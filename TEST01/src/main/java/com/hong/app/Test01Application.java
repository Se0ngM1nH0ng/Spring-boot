package com.hong.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import test.Config;
import test.Member;


/////@SpringBootApplication
public class Test01Application {

	public static void main(String[] args) {
		/////SpringApplication.run(Test01Application.class, args);
		
		// 1. pojo를 다루는 스프링 IoC 컨테이너 구동시키기
		// 1-2. 컨테이너를 구동시킬때에 설정 파일이 필요함
		//      (스프링에서는 .xml / 부트에서는 .java)
		ApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
		// 컨테이너는 팩토리 패턴을 기반으로 동작하고있음!!!!!
	
		
		Member member1 = (Member)ac.getBean("teemo1"); // 다운 캐스팅 (형변환)
		member1.print();
		
		Member member2 = (Member)ac.getBean("apple", Member.class); // 다운 캐스팅 (형변환)
		member2.print();
		
		// 2. 싱글톤 유지되는지 확인 해보자 !
		if(member1 == member2) {
			System.out.println("둘은 동일한 객체 입니다");
		}else {
			System.out.println("둘은 다른 객체 입니다.");
		}
		
		// 부트방식을 전부 활용 xxx 
		// 개발자(직접 new를 작성한 상황)member 객체를 2개 등록 -> 싱글톤 유지 xxx
		
		
		
	}

}
