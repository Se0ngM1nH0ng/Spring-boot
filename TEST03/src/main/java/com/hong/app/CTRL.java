package com.hong.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller // 컴포넌트를 해도 되지만 메모리 적재 편의성 상 , 개발자 가독성 상 
public class CTRL {

	@RequestMapping("/") // 루트 요청  // 핸들러 맴핑 역할을 해줄 
	public @ResponseBody String root() {
		return "루트요청 ! "; 
		
		// VR 관여 안시킬거고 
		// 문자열 "값" 을 보낼 거라 비동기 요청 이다. 그래서 @ResponseBody 붙임 
	}
	

	@RequestMapping("/test") // 루트 요청  // 핸들러 맴핑 역할을 해줄  // value 라는건 하나있을땐 value 생략 가능 
	public String test(VO vo, Model model ) { // 커맨드 객체
		
		System.out.println("vo : " + vo); // 이거 toString 누가 만들어 준거냐 롬복이 만들어줬다. 롬복의 결과
		vo.setId("tjdals9219");
		vo.setName("성민");
		vo.setPw(1234);
		
		
		
		model.addAttribute("apple", vo.getId());
		model.addAttribute("banana", vo.getName());
		model.addAttribute("vo", vo);
		
		
		return "test"; 
	
		// /WEB-INF/views/test.jsp 가달라는 뜻 
	}
	@RequestMapping("/test01") // 루트 요청  // 핸들러 맴핑 역할을 해줄  // value 라는건 하나있을땐 value 생략 가능 
	public String test01( Model model, HttpServletRequest request ) { // 커맨드 객체
		// request 자체가 not POJO 인 Servlet 객체이기 때문에 활용도가 낮다 ! 
		VO vo = new VO();
		vo.setId(request.getParameter("id"));
		
		System.out.println("vo : " + vo); // 이거 toString 누가 만들어 준거냐 롬복이 만들어줬다. 롬복의 결과
	
		model.addAttribute("apple", vo.getId());
		
		return "test"; 
		
		// /WEB-INF/views/test.jsp 가달라는 뜻 
	}
	
	@RequestMapping("/test02") // 루트 요청  // 핸들러 맴핑 역할을 해줄  // value 라는건 하나있을땐 value 생략 가능 
	public String test02(@RequestParam("id")String id,@RequestParam("name")String name, Model model ) { // 커맨드 객체
		// 가독성이 커맨드 객체를 사용 할 때 보다 별로임 ...!!!! view 랑 모델이 아무 생각  없이 사용 할 수는 있음  //얘가 의외로 많이 보임 
		model.addAttribute("apple", id);
		model.addAttribute("banana", name);
		// 얘는 폼태그에 실어서 보내야 에러가 안난다. !!
		return "test"; 
		
		// /WEB-INF/views/test.jsp 가달라는 뜻 
	}
	@RequestMapping("/test03/{id}/{name}") //URL 에 실어서 보내는 것임 // 아이디랑 이름을 가져올거다 // .do 없이 웹을 모바일 환경 에서도 돌릴 수 있게  rest api 라고 불린다.  
	public String test03(@PathVariable String id, @PathVariable String name, Model model  ) { // 커맨드 객체
		
		
		model.addAttribute("apple", id);
		
		return "test"; 
		
		// /WEB-INF/views/test.jsp 가달라는 뜻 
	}
	
}
