package com.hong.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // 컴포넌트를 해도 되지만 메모리 적재 편의성 상 , 개발자 가독성 상 
public class CTRL {

	@RequestMapping("/") // 루트 요청  // 핸들러 맴핑 역할을 해줄 
	public @ResponseBody String root() {
		return "롬복 예제 입니다. ! "; 
		
		// VR 관여 안시킬거고 
		// 문자열 "값" 을 보낼 거라 비동기 요청 이다. 그래서 @ResponseBody 붙임 
	}
	
	@RequestMapping("/test") // 루트 요청  // 핸들러 맴핑 역할을 해줄  // value 라는건 하나있을땐 value 생략 가능 
	public String test(@ModelAttribute("apple")VO vo ) { // 커맨드 객체
		
		System.out.println("vo : " + vo); // 이거 toString 누가 만들어 준거냐 롬복이 만들어줬다. 롬복의 결과
		
		
		return "test"; 
	
		// /WEB-INF/views/test.jsp 가달라는 뜻 
	}
	
}
