package com.hong.app;

import lombok.Data;

@Data
public class MemberDTO {

	private String mid;
	private String mpw;
	private String sk; // 서치 키워드

	//===== 임시 변수 =====
	private String sweetAlert; // 성공, 실패
	private String message; // 메세지
	private String location; // 경로
}
