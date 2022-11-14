package com.gdu.app13.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetireUserDTO {
	private Long userNo;
	private String id;
	private Date joinDate;
	private Date retireDate;
}
