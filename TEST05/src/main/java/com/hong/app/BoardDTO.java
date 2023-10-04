package com.hong.app;

import lombok.Data;

@Data
public class BoardDTO {

	private int bid;
	private String mid;
	private String title;
	private String content;

	//======= 임시변수 ======
	private String sweetAlert;
	private String message;
	private String location;
}
