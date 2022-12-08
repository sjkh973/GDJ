package com.gdu.rest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.rest.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	
	public int insertMember(MemberDTO member);
	public int selectMemberCount();
	public List<MemberDTO> selectMemberListByMap(Map<String, Object> map);
	public MemberDTO selectMemberByNo(int memberNo);
	public int updateMember(Map<String, Object> map);
	public int deleteMemberList(List<String> memberNoList);
}
