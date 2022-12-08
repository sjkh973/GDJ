package com.gdu.app02.batch;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.app02.domain.SummernoteImageDTO;
import com.gdu.app02.mapper.BlogMapper;

@EnableScheduling
@Component
public class DeleteWrongSummernoteImages {

	// 주기적으로 잘못 올라간 써머노트 이미지를 지워주는 스케쥴러
	
	@Autowired
	private BlogMapper blogMapper;
	
	@Scheduled(cron="0 0 4 * * *")  // 새벽 4시마다 동작
	//@Scheduled(cron="0 0/1 * * * *")
	public void execute() {

		// 써머노트 이미지 경로
		String path = "C:" + File.separator + "summernoteImage";
		
		// DB에 업로드 된 전체 써머노트 이미지 목록
		List<SummernoteImageDTO> summernoteImageList = blogMapper.selectAllSummernoteImageList();
		
		// DB에 업로드 된 파일(경로 + 파일명) 목록을 List<Path>로 생성
		List<Path> pathList = new ArrayList<Path>();
		if(summernoteImageList != null && summernoteImageList.isEmpty() == false) {
			for(SummernoteImageDTO summernoteImage : summernoteImageList) {
				pathList.add(Paths.get(path, summernoteImage.getFilesystem()));
			}
		}
		
		// System.out.println("1   " + pathList.toString());
		
		// HDD에 업로드 된 파일 목록 중 DB에 기록되어 있지 않은 써머노트 이미지 목록
		File dir = new File(path);
		File[] wrongSummernoteImages = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return !pathList.contains(new File(dir, name).toPath());
			}
		});
		/*
		Lambda Expression
		File[] wrongSummernoteImages = dir.listFiles((directory, name) -> pathList.contains(new File(directory, name).toPath()));
		*/
		// System.out.println("2   " + Arrays.toString(wrongSummernoteImages));
		
		// 삭제
		if(wrongSummernoteImages != null) {
			for(File wrongSummernoteImage : wrongSummernoteImages) {
				wrongSummernoteImage.delete();
			}
		}
		
	}
	
}