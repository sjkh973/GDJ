package com.gdu.app10.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
	
	private int boardNo;
	private String title, content, writer, createDate, modifyDate;
	
}
