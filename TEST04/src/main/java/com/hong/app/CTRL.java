package com.hong.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class CTRL {

	@RequestMapping("/")
	public String root() {
		return "test";
	}
	
	@RequestMapping("/test") // method요청 써도됨  // @Valid 너 만들라고 시킨거 얘 검사할때 시키는거야 
	public String root(@Valid VO vo, BindingResult br, Model model) { // 커맨드 객체 , Model model , 에러친구 커맨드 객체로 받아올 수 있게 
		
		// 검사 코드가 컨트롤러에 그대로 오픈 되어 있지 않다 . 따로 검사 객체에 들어가있다. 
		// 서버 통신과 관련된 컨트롤러가 있고 검사만 진행하는 컨트롤러가 따로 있다 . 
		
		VOValidator voV = new VOValidator();  // 얘를 직접 쓰고 있는데 이걸 없애보자 // 이걸 커맨드 객체화 IoC 시키고 있다.  
		
		voV.validate(vo, br); // 검사를 했을때 검사 할게 여러가지 일 수 있는데 자바에서 그게 안되기 때문에 따로 객체를 사용할 수 있다. br 는 커맨드 객체(참조변수)를 참조하고 있다. 
		// validate 메서드 강제에 의해 만들어진 메서드 
		
		if(br.hasErrors()) {
			System.out.println("로그 : 에러 발생함!");
			System.out.println("발생한 에러목록");
			System.out.println(br.getAllErrors()); // for문과도 잘 어울림 

			if(br.getFieldError("id") != null) {
				System.out.println(br.getFieldError("id").getCode());
			}
			if(br.getFieldError("password") != null) {
				System.out.println(br.getFieldError("password").getCode());
				// 어노테이션으로 설정한거 볼게 
			}
		}
		
		model.addAttribute("apple", vo.getId());
		return "test";
	}
	
	// 컨트롤러가 동작했을때 이미 validator 가  동작 될 수 있도록 
	@InitBinder // 이런 어노테이션을 사용하기 위해 gradle 에 추가 한거다. 
	   protected void initBinder(WebDataBinder wdb) {
	      wdb.setValidator(new VOValidator());  
	   } 
	
	
}
