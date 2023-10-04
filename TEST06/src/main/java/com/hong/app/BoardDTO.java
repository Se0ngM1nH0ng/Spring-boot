package com.hong.app;

import lombok.Data;

@Data
public class BoardDTO {

	private int bid; // PK // 글 번호
	private String mid; // FK  // 회원 아이디 
	private String title; // 글 제목
	private String content; // 글 내용

	//======= 임시변수 ======
	private String sweetAlert; // 스윗 알럿 
	private String message; // 안내 메세지 
	private String location; // 경로
}
