package com.hong.app;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VO {
	@NotNull(message="id값 Null")//클래스가 하는 역할을 VO 로 가져온다. 
	@NotEmpty(message="id값 Empty")
	@Size(min=5 , max=100, message="id값 6이상 100이하 가능")
	
	private String id;
	
	@NotNull(message="password값 Null")//클래스가 하는 역할을 VO 로 가져온다. 
	@NotEmpty(message="password값 Empty")
	
	private String password;
}


