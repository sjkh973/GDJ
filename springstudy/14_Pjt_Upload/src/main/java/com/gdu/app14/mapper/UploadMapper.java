package com.gdu.app14.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app14.domain.AttachDTO;
import com.gdu.app14.domain.UploadDTO;

@Mapper
public interface UploadMapper {

	public List<UploadDTO> selectUploadList();

	public int insertUpload(UploadDTO upload);

	public int insertAttach(AttachDTO attach);
	
	public UploadDTO selectUploadByNo(int uploadNo);
	
	public List<AttachDTO> selectAttachList(int uploadNo); // 여러개의 파일을 업로드 해놨기 떄문에 list로 불러온다.
	public int updateDownloadCnt(int attachNo);
	public AttachDTO selectAttachByNo(int attachNo);
	public int deleteAttachByAttachNo(int attachNo);
}
