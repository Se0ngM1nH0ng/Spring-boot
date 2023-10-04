<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title> 예제 </title>
   </head>
   <body>
	<c:if test="${empty mid}"> <!-- 로그인 안했을 때 -->
	<h1>🌟 로그인 🌟</h1>
        <form action="login" method="POST">
		ID <input type="text" name="mid" required> <br>
		PW <input type="password" name ="mpw" required> <br>
		<input type="submit" value="로그인">
	</form>
	<br> <br>
	<a href="signup">회원가입</a> 
	</c:if>

	<c:if test="${not empty mid}"> <!-- 로그인 했을때 -->
	<h1>🌟 ${mid} 님 🌟 환영합니다 🎉 </h1> 
	<a href ="mypageCheck">마이페이지</a> <a href="logout">로그아웃</a> <br>
	<a href ="insertBoard">글 작성하기</a> 
	<hr>
	
	<c:if test ="${not empty bdatas}"> <!-- 게시글이 있을때 -->
	<table border="1">
	<tr>
		<th>글 번호</th><th>글 제목</th><th>작성자</th>
	</tr>
		<c:forEach var="v" items="${bdatas}">
			<tr>
		<td><a href = "board?bid=${v.bid}">${v.bid}</a></td><td>${v.title}</td>
         <td>${v.mid == null ? '탈퇴한 회원입니다' : v.mid}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<c:if test="${empty bdatas}"> <!-- 게시글이 없을 때 -->
	 <h3> 찾고자 하는 내용이 없습니다. </h3>
	</c:if>
	
	
	</c:if>


	

   </body>
</html>