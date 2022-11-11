package com.gdu.app11.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDTO {

	private int employeeId, managerId;
	private String firstName, lastName, email, phoneNumber,jobId;
	private double salary, commissionPct;
	private Date hireDate;
	private DeptDTO deptDTO;
}
