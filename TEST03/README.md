# Spring boot 요청을 처리하는 방법 

먼저 컨트롤러에서 

@RequestMapping("/") // 루트 요청  // 핸들러 맴핑 역할을 해줄 
	public @ResponseBody String root() {
		return "루트요청 ! "; 
		
		// VR 관여 안시킬거고 
		// 문자열 "값" 을 보낼 거라 비동기 요청 이다. 그래서 @ResponseBody 붙임 
	}
viewResolver 동작 안하게 하면서 , 값을 보낼 것으로 비동기 요청을 추측 할 수 있다. 

비동기 처리 시에는 클라이언트 요청에 대한 서버의 응답이므로 본문 응답 @ResposeBody 를 붙인다. 

​

​

​

1. 기본적인 요청 처리 

@RequestMapping("/test") // 루트 요청  // 핸들러 맴핑 역할을 해줄  // value 라는건 하나있을땐 value 생략 가능 
	public String test(VO vo, Model model ) { // 커맨드 객체
		
		System.out.println("vo : " + vo); // 이거 toString 누가 만들어 준거냐 롬복이 만들어줬다. 롬복의 결과
		vo.setId("GILDONG");
		vo.setName("홍길동");
		vo.setPw(1234);
	
		model.addAttribute("apple", vo.getId());
		model.addAttribute("banana", vo.getName());
		model.addAttribute("vo", vo);
		
        return "test"; 
	
		// /WEB-INF/views/test.jsp 가달라는 뜻 
	}
Model 객체를 써서 model.addAttribute 로 데이터를 전달 해준다. 

​

​

​

2. 인자에 Request 가 있는 방식

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
request 자체가 not POJO 인 Servlet 객체 이기 때문에 활용도가 낮다. 

Servlet 객체는 메모리가 많이 들기 때문에 

​

​

​

3. @RequestParam 사용 

@RequestMapping("/test02") // 루트 요청  // 핸들러 맴핑 역할을 해줄  // value 라는건 하나있을땐 value 생략 가능 
	public String test02(@RequestParam("id")String id,@RequestParam("name")String name, Model model ) { // 커맨드 객체
		// 가독성이 커맨드 객체를 사용 할 때 보다 별로임 ...!!!! 
        // view 랑 모델이 아무 생각  없이 사용 할 수는 있음  
		model.addAttribute("apple", id);
		model.addAttribute("banana", name);
		// 얘는 폼태그에 실어서 보내야 에러가 안난다. !!
		return "test"; 
		
		// /WEB-INF/views/test.jsp 가달라는 뜻 
	}
작동은 하지만 가독성이 커맨드 객체를 사용 할 때 보다 별로이다. 

form 태그를 이용해야 에러가 안난다. parameter 로 받기 때문에 

의외로 많이 보이는 코드 이다. 

​

​

​

4. URL 에 실어서 보내기 

@RequestMapping("/test03/{id}/{name}") //URL 에 실어서 보내는 것임 // 아이디랑 이름을 가져올거다 
          // .do 없이 웹을 모바일 환경 에서도 돌릴 수 있게  rest api 라고 불린다.  
	public String test03(@PathVariable String id, @PathVariable String name, Model model  ) { // 커맨드 객체
		
		
		model.addAttribute("apple", id);
		
		return "test"; 
		
		// /WEB-INF/views/test.jsp 가달라는 뜻 
	}
URL 에 실어서 보낸다 . 요즘은 .do 요청 없이 웹을 모바일 환경에서도 돌릴 수 있도록 url 에 입력하는 방법이 사용되는데 Rest Api호출시 주로 많이 사용하게 된다.

@PathVariable  ==> URI를 이용해 파라미터 처리를 할수있다는 뜻
