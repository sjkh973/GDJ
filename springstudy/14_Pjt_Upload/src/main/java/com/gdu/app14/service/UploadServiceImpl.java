package com.gdu.app14.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app14.domain.AttachDTO;
import com.gdu.app14.domain.UploadDTO;
import com.gdu.app14.mapper.UploadMapper;
import com.gdu.app14.util.MyFileUtil;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadMapper uploadMapper;
	
	@Autowired
	private MyFileUtil myFileUtil;
	
	@Override
	public List<UploadDTO> getUploadList() {
		return uploadMapper.selectUploadList();
	}
	
	@Transactional
	@Override
	public void save(MultipartHttpServletRequest multipartReuqest, HttpServletResponse response) {
		
		/* Upload 테이블에 저장하기 */
		
		// 파라미터
		String title = multipartReuqest.getParameter("title");
		String content = multipartReuqest.getParameter("content");
		
		// DB로 보낼 
		UploadDTO upload = UploadDTO.builder()
				.title(title)
				.content(content)
				.build();
		System.out.println(upload); // upload 없음
		// DB에 UploadDTO 저장
		int uploadResult = uploadMapper.insertUpload(upload); // <selectKey>에 의해서 인수 upload에 uploadNo값이 저장된다.
		
		System.out.println(upload); // upload 있음		
		
		/* ATTACH 테이블에 저장하기 */
		
		// 첨부된 파일목록
		List<MultipartFile> files = multipartReuqest.getFiles("files");	// <input type="file" name="files">
		System.out.println(files);
		// 첨부 결과
		int attachResult;
		if(files.get(0).getSize() == 0) { // 0번째 파일의 사이즈  
		// 첨부가 없는경우 (files 리스트에 [MultipartFile[field="files", filename=, contentType=application/octet-stream, size=0]]  이렇게 저장되어 있어서 files.size()가 1이다.))
			attachResult = 1;
		} else {
			attachResult = 0;
		}  
		
		//files.get(0).getOriginalFilename().isEmpty();
		
		// 첨부된 파일 목록 순회(하나씩 저장)
		for(MultipartFile multipartFile : files) {
			
			try {
				
				// 첨부가 있는지 점검
				if(multipartFile != null && multipartFile.isEmpty() == false) { // 둘 다 필요함
					
					// 원래 이름
					String origin = multipartFile.getOriginalFilename();
					origin = origin.substring(origin.lastIndexOf("\\") + 1);	// IE는 origin에 전체 경로가 붙어서 파일명만 사용하기 위해 lastindexof를 씀
					
					// 저장할 이름
					String filesystem = myFileUtil.getFilename(origin);
					
					// 저장할 경로
					String path = myFileUtil.getTodayPath();
					
					// 저장할 경로 만들기
					File dir = new File(path);
					if(dir.exists() == false) {
						dir.mkdirs();
					}
					
					// 첨부할 File 객체
					File file = new File(dir, filesystem); // 경로, 저장할 이름
					
					// 첨부파일 서버에 저장(업로드 진행)
					multipartFile.transferTo(file);
					
					// AttachDTO 생성
					AttachDTO attach = AttachDTO.builder()
							.path(path)
							.origin(origin)
							.filesystem(filesystem)
							.uploadNo(upload.getUploadNo())
							.build();
					
					// DB에 AttachDto 저장
					attachResult += uploadMapper.insertAttach(attach);
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		} // for
		
		// 응답
		
		try {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(uploadResult > 0 && attachResult == files.size()) {
				out.println("<script>");
				out.println("alert('업로드 되었습니다.');");
				out.println("location.href='" + multipartReuqest.getContextPath() + "/upload/list';");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('업로드 실패습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
			out.close();
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	@Override
	public void getUploadByNo(int uploadNo, Model model) {
		
		model.addAttribute("upload", uploadMapper.selectUploadByNo(uploadNo));
		model.addAttribute("attachList", uploadMapper.selectAttachList(uploadNo));
	}
	
@Override
	public ResponseEntity<Resource> download(String userAgent, int attachNo) {
		
		// responseentity 반환 = 페이지 변환 x, 값 반환
	
		// 다운로드 할 첨부 파일의 정보(경로,이름)
		AttachDTO attach = uploadMapper.selectAttachByNo(attachNo);
		File file = new File(attach.getPath(), attach.getFilesystem());   // 파일의 경로, 파일의 이름 - > db에는 원본 이름이 아닌 uuid값(파일의 저장된 이름)으로 저장되어있음 
		
		// 반환할 Resource
		Resource resource = new FileSystemResource(file);
		
		// Resource가 없으면 종료 (다운로드할 파일이 없음)
		if(resource.exists() == false) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		// 다운로드 횟수 증가
		uploadMapper.updateDownloadCnt(attachNo);
		
		// 다운로드 되는 파일명(브라우저 마다 다르게 세팅)
		String origin = attach.getOrigin();
		try {
			
			// IE (userAgent)에 "Trident"가 포함되어 있음
			if(userAgent.contains("Trident")) {
				origin = URLEncoder.encode(origin, "UTF-8").replaceAll("\\+", "");  // replaceAll는 정규식을 사용하는데 + 는 정규식에서 역할이 있으므로 역슬래시를 2개붙여줌
			} 
			// Edge (userAgent에 "Edg"가 포함되어 있음)
			else if(userAgent.contains("Edg")) {
				origin = URLEncoder.encode(origin, "UTF-8");
			} 
			// 나머지
			else {
				origin = new String(origin.getBytes("UTF-8"), "ISO-8859-1");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// 다운로드 헤더 만들기
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Disposition", "attachment; filename=" + origin);
		header.add("Content-Length", file.length() + "");
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}


@Override
public ResponseEntity<Resource> downloadAll(String userAgent, int uploadNo) {
	
	// storage/temp 디렉터리에 임시 zip 파일을 만든 뒤 이를 다운로드 받을 수 있음
	// com.gdu.app14.batch.DeleteTmpFiles에 의해서 storage/temp 디렉터리의 임시 zip 파일은 주기적으로 삭제됨
	
	// 다운로드 할 첨부 파일들의 정보(경로, 이름)
	List<AttachDTO> attachList = uploadMapper.selectAttachList(uploadNo);
	
	// zip 파일을 만들기 위한 스트림
	FileOutputStream fout = null;
	ZipOutputStream zout = null;   // zip 파일 생성 스트림
	FileInputStream fin = null;
	
	// storage/temp 디렉터리에 zip 파일 생성
	String tmpPath = "storage" + File.separator + "temp";
	
	File tmpDir = new File(tmpPath);
	if(tmpDir.exists() == false) {
		tmpDir.mkdirs();
	}
	
	// zip 파일명은 타임스탬프 값으로 생성
	String tmpName =  System.currentTimeMillis() + ".zip";
	
	try {
		
		fout = new FileOutputStream(new File(tmpPath, tmpName));
		zout = new ZipOutputStream(fout);
		
		// 첨부가 있는지 확인
		if(attachList != null && attachList.isEmpty() == false) {

			// 첨부 파일 하나씩 순회
			for(AttachDTO attach : attachList) {
				
				// zip 파일에 첨부 파일 추가
				ZipEntry zipEntry = new ZipEntry(attach.getOrigin());
				zout.putNextEntry(zipEntry);
				
				fin = new FileInputStream(new File(attach.getPath(), attach.getFilesystem()));
				byte[] buffer = new byte[1024];
				int length;
				while((length = fin.read(buffer)) != -1){
					zout.write(buffer, 0, length);
				}
				zout.closeEntry();
				fin.close();

				// 각 첨부 파일 모두 다운로드 횟수 증가
				uploadMapper.updateDownloadCnt(attach.getAttachNo());
				
			}
			
			zout.close();

		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	
	// 반환할 Resource
	File file = new File(tmpPath, tmpName);
	Resource resource = new FileSystemResource(file);
	
	// Resource가 없으면 종료 (다운로드할 파일이 없음)
	if(resource.exists() == false) {
		return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
	}
	
	// 다운로드 헤더 만들기
	HttpHeaders header = new HttpHeaders();
	header.add("Content-Disposition", "attachment; filename=" + tmpName);  // 다운로드할 zip파일명은 타임스탬프로 만든 이름을 그대로 사용
	header.add("Content-Length", file.length() + "");
	
	return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	
}

	@Override
	public void removeAttachByAttachNo(int attachNo) {
		
		// 삭제할 Attach 정보 가져오기
		AttachDTO attach = uploadMapper.selectAttachByNo(attachNo);
		
		// DB에서 삭제
		int result = uploadMapper.deleteAttach(attachNo);
		
		// 첨부 파일 삭제
		if(result > 0) {
			
			// 첨부 파일을 File 객체로 만듬
			File file = new File(attach.getPath(), attach.getFilesystem());
			
			// 삭제
			if(file.exists()) { // 파일이 존재하면 삭제
				file.delete();
			}
			
		}
		
	}
	

	@Override
	public void removeUpload(HttpServletRequest multipartRequest, HttpServletResponse response) {
		
		// 파라미터
		int uploadNo = Integer.parseInt(multipartRequest.getParameter("uploadNo"));
		
		// 삭제할 Upload에 첨부된 첨부파일 목록 가져오기
		List<AttachDTO> attachList = uploadMapper.selectAttachList(uploadNo);
		
		// DB에서 Upload 정보 삭제
		int result = uploadMapper.deleteUpload(uploadNo);
		
		// 첨부 파일 삭제
		if(result > 0) {
			if(attachList != null && attachList.isEmpty() == false) {
				// 순회하면서 하나씩 삭제
				for(AttachDTO attach : attachList) {
					// 삭제할 첨부 파일의 File 객체 생성
					File file = new File(attach.getPath(), attach.getFilesystem());
					// 삭제
					if(file.exists()) {
						file.delete();
					}
				}
			}
		}
		
		// 응답
		try {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			if(result > 0) {
				out.println("<script>");
				out.println("alert('삭제 되었습니다.');");
				out.println("location.href='" + multipartRequest.getContextPath() + "/upload/list'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('삭제 실패했습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
