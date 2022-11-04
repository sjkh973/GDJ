package com.gdu.app07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
	
	private int board_no;
	private String title, content, writer, create_date, modify_date;
	
}
