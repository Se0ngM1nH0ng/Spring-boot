package com.hong.app;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class VOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 유효성 검사할 객체의 클래스 정보를 반환 
		return VO.class.isAssignableFrom(clazz); // 어떤 클래스 객체의 데이터를 볼수 있구나 정도만 잘 안씀 // 뭐에 대해서 할것인지 알려주면 됨 
	}

	@Override       		// 참조 변수라서 
	public void validate(Object target, Errors errors) { // 에러라는 친구도 커맨드 객체라 "참조 변수" 이다. 변화를 기억할 수 있는 객체 // 내부 메서드에서 add 되는결과값들을 기억해준다는 뜻  
		// target : 유효성 검사 할 객체를 의미 // 타겟에 vo 가 넘어옴
		// errors : 검증이 통과되지 못한 경우 , 왜 통과가 안되었는지를 반환  이유를 반환 해주는 객체 
		
		// errors 라는 인자는 진짜 외부에서 들어오는 값이 아님 , 반환을 위해 만들어짐 에러가 한두개 나는게 아니기 때문에 많은 에러를 한번에 반환할 방법으로 보내주는 방법
				// new 를 코드에다 때려박는게 유지보수에 불리하기 때문에 검사 클래스 에서는 유효성을 한 값을 보내진 않는 다. 반환을 위해 거기서 new를 하는게 아니라 
				// 커맨드 객체 == 참조변수 == 바인딩 result 라는 객체 라는걸 참조해서 쓴다는게 중요 저런 단어를 외우는게 아님 
		
		VO vo = (VO)target;
		String id= vo.getId();
		
		if(id.length()<=5) {
			System.out.println("아이디가 5글자 이하 일수 없습니다. ");
			errors.rejectValue("id", "5글자 이하로는 할 수 없습니다. "); // 에러라고 보내줘야 된다. 
			
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id", "id값 없음"); // 공백이거나 null 이거나 하면 구분해준다는 메서드 // empty 까지만 쓰면 null 만 구분 
		
		//if(id == null || id.isEmpty() || id.isBlank() || id.trim().isEmpty() || id.trim().isBlank()) { // 남은 부분을 잘라서 trim  비었니도 검사 
	     //    System.out.println("로그 : id값이 올바르지 않습니다. ");
	     //    errors.rejectValue("id", "id값 없음");
	     // }
		String password = vo.getPassword(); // 단일 변수화 시키는경우도 많이 있다. 
		if(password == null || password.isEmpty() || password.isBlank() || password.trim().isEmpty() || password.trim().isBlank()) { // 남은 부분을 잘라서 trim  비었니도 검사 
	         System.out.println("로그 : password값이 올바르지 않습니다. ");
	         errors.rejectValue("password", "password값 없음");
	      }
		
	} // 부트에서 유효성 검사를 모듈화 한 클래스가 있는데 걔 이름이 VOValiidator 이다. 
// 이렇게 해야해 라고 강제 해야해 
}
