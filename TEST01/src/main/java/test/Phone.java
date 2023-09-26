package test;

public interface Phone {
	void call(String name);
	// 인터페이스에 달리는 속성 두가지 
	// public : 부모의 공개범위가 >= 자식의 공개범위 보다 무조건 넓어야 하기 때문에 
	// abstract :  추상이라서 메서드 바디를 가질 수 가 없다 
}
