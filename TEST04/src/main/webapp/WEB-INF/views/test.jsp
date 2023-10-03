<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title> 예제 </title>
   </head>
   <body>
        <form action="test" method="POST">
		ID <input type="text" name="id" value="${apple}">
		PW <input type="password" name ="password">
		<input type="submit" value="전송">
	</form>
	

   </body>
</html>