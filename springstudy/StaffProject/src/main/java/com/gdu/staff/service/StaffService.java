package com.gdu.staff.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gdu.staff.domain.StaffDTO;

public interface StaffService {

	public List<StaffDTO> getStaffList();
	public ResponseEntity<String> addStaff(StaffDTO staff);
	public StaffDTO findStaff(String sno);
}
