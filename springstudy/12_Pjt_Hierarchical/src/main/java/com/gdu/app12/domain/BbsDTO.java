package com.gdu.app12.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BbsDTO {

	private int bbsNo;
	private String writer;
	private String title;
	private String ip;
	private Date createDate;
	private int state, depth, groupNo,groupOrder;
}
