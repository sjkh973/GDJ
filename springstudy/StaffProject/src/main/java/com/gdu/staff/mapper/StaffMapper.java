package com.gdu.staff.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.staff.domain.StaffDTO;

@Mapper
public interface StaffMapper {

	public List<StaffDTO> selectStaffList();
	public int insertStaff(StaffDTO staff);
	public StaffDTO selectStaffByNo(String sno);
}
