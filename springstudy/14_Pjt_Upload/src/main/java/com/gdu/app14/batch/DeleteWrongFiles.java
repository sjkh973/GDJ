package com.gdu.app14.batch;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.app14.domain.AttachDTO;
import com.gdu.app14.mapper.UploadMapper;
import com.gdu.app14.util.MyFileUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@EnableScheduling
@Component
public class DeleteWrongFiles {

	// 필드 2개는 @Autowired 대신 @AllArgsConstructor로 처리
	private MyFileUtil myFileUtil;
	private UploadMapper uploadMapper;
	
	// 삭제되는지 테스트는 아래 크론식으로 확인
	// cron="0 0/1 * * * *"(1분마다 잘못 업로드 된 파일을 지움)
	
	@Scheduled(cron="0 0 4 * * *")  // 새벽 4시마다 동작
	public void execute() {
		
		// 어제 업로드 된 파일의 경로
		String path = myFileUtil.getYesterdayPath();
		
		// 어제 업로드 된 파일 목록(DB에 기록된 파일 목록)
		List<AttachDTO> dbList = uploadMapper.selectAttachListInYesterday();
		
		// 어제 업로드 된 파일(경로 + 파일명) 목록을 List<Path>로 생성
		List<Path> pathList = new ArrayList<Path>();
		if(dbList != null && dbList.isEmpty() == false) {
			for(AttachDTO attach : dbList) {
				pathList.add(Paths.get(path, attach.getFilesystem()));
			}
		}
		
		System.out.println("1   " + pathList.toString());     // 어제 저장되었다고 DB에 기록된 파일들
		
		// 어제 업로드 된 파일 목록 중 DB에 기록된 파일이 아닌 목록
		File dir = new File(path);
		File[] wrongFiles = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return !pathList.contains(new File(dir, name).toPath());
			}
		});
		
		System.out.println("2   " + Arrays.toString(wrongFiles));  // 어제 저장된 파일 중 DB에 기록되어 있지 않은 파일들
		
		// 삭제
		if(wrongFiles != null) {
			for(File wrong : wrongFiles) {
				wrong.delete();
			}
		}
		
	}
	
}