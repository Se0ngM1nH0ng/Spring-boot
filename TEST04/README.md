# 유효성 검사
서버(== 백, 개발자)

- URL 을 막을수 없다. 클라이언트에선 

- 잘못된 URL 호출에 대해 유효성 검사가 필요하다 . 

   반드시 필요한 부분 !

먼저 gradle에서 설정 파일을 추가 하자 
implementation 'org.springframework.boot:spring-boot-starter-validation' // validator 자동화 시키기

그리고 컨트롤러로 이동해서
메서드를 하나 만들어준다. 

@InitBinder 
: Spring Validator를 사용 시 @Valid 어노테이션으로 검증이 필요한 객체를 가져오기 전에 수행할 method를 지정해주는 어노테이션이다.
그리고 
@Valid 
: 객체 안에서 들어오는 값에 대해 검증이 가능해진다.


@InitBinder 와 @Valid  같이 쓰인다. 
@InitBinder 는 컨트롤러가 동작했을때 이미 validator 가 동작 될 수 있도록 할때 사용하고 
@Valid 는 검증 할려는 객체가 무엇인지 정해준다. 지금은 VO 객체 이기 때문에 VO 앞에 붙인다.

​요즘은 VO 에서 간편하게 유효성 검사를 처리한다.

@NotNull  - null 일때 나올 message /
@NotEmpty - Empty 일때 나올 message /
@Size - min 부터 max 까지  , message /

# 요즘 VO 에서 유효성 검사를 처리 하는게 보편적이다.




