package test;

public class PhoneA implements Phone{

	@Override
	public void call(String name) { // 오버 라이딩
		System.out.println("PhoneA : " + name + "이(가) 전화거는중...");
		
	}

	
}
