<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title> 예제 </title>
   </head>
   <body>

	<h1> 🌟 회원가입 🌟 </h1>
        <form action="signup" method="POST">
		ID <input type="text" name="mid" required> <br>
		PW <input type="password" name ="mpw" required> <br>
		<input type="submit" value="회원가입">
	</form>
<br>
<a href = "main">메인으로 돌아가기</a>

   </body>
</html>