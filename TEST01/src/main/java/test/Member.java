package test;

public class Member {

	private String name;
	private Phone phone;
	
	public Member() {
		System.out.println("Member 기본 생성자 호출됨 ");
	}
	// 생성자 오버로딩 
	public Member(String name , Phone phone) {
		this.name = name;
		this.phone = phone; // this == 자기 자신 객체 
		
		System.out.println("Member 생성자 호출됨");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", phone=" + phone + "]";
	}
	
	public void print() { // this 키워드는 생략이 가능하다 !
		phone.call(name);
	}
	
}
