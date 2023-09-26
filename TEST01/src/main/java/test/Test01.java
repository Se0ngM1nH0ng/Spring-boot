package test;

class A {
		//private 
		public A() { // 생성자는 클래스와 이름이 똑같 , 아웃풋이 없고 , 
			System.out.println("기본 생성자 호출됨 ");
		}
}


public class Test01 {
	
	public static void useA() {
		A apple = new A();
		// 개발자가 직접 new 
		// 결합이 강함 // 결합도가 높으면 외부 코드 변화에 반응을 하게 되어있다.  
	}
	public static void useA(A a) { // 오버 로딩  : 메서드 시그니처가 달라서 가능 !
		A apple = a ;
		// 외부에서 객체를 받아옴 == 객체를 주입받는다 !!
		// 결합이 약함 
	}
	

	public static void main(String[] args) {
		
		// 결론)
		// 코드의 결합도가 높을 수록 
		// 안정성이 떨어짐 
		// 유연성이 떨어짐 
		// 외부코드 변화에 에러가 발생할 확률이 높아짐 == 유지보수가 불리 
		
	}

}
