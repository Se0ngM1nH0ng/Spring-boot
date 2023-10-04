<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title> 예제 </title>
   </head>

   <body>

	<h1>🌟 비밀번호 확인 🌟</h1>
       <form action="mypageCheck" method="POST">
	<input type="hidden" name="mid" value="${mid}">
	비밀번호 <input type="password" name="mpw" placeholder="비밀 번호를 입력해주세요" required>
	<input type="submit" value="확인">
	</form>
<br>

	</form>
<br>
<a href="main">메인으로 돌아가기</a>
	


   </body>
</html>