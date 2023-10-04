<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title> 예제 </title>
   </head>
   <body>


	<h1>🌟글 작성 페이지🌟</h1>
	<form action="insertBoard" method="POST">
	글 제목 <input type="text" name="title" required> <br> 	
	글 내용 <input type="text" name="content" required> <br>
        작성자 <input type="text" name="mid" value='${mid}' readonly> <br>
	<input type="submit" value="글 작성"> 
	</form>
<hr>
<a href="main">메인으로 돌아가기</a>

   </body>
</html>