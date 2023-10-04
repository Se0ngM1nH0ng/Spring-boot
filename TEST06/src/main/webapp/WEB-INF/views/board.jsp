<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title> 글 상세 내용  </title>
   </head>
<script type="text/javascript">
	function deleteBoard(bid){
	var ans=confirm('삭제 하시겠습니까? 😢');
	if(ans){
	location.href="deleteBoard?bid="+bid;
	}
   }
</script>

   <body>
	<h1>🌟 글 상세 내용 🌟</h1>
        <form action="board" method="POST">
	<input type="hidden" name="bid" value="${bdata.bid}">
	글 제목 <input type="text" name="title" value="${bdata.title}" required> <br> 	
	글 내용 <input type="text" name="content" value="${bdata.content}" required> <br>
        작성자 <input type="text" name="mid" value='${bdata.mid == null?'탈퇴한 회원입니다' : bdata.mid}' readonly> <br> <br> <!-- 삼항연산자 -->
	                                        
	<c:if test ="${mid eq bdata.mid}"> <!-- 회원이 글 작성자가 맞을 때 -->
	<input type="submit" value="글 변경"> 
	<input type="button" onclick ="deleteBoard(${bdata.bid})" value="글삭제">
	</c:if>
	
	<c:if test ="${bdata.mid == null}"> <!-- 글 작성자가 탈퇴한 회원일때 -->
	<input type="button" onclick ="deleteBoard(${bdata.bid})" value="글삭제">
	</c:if>
	</form>
<br>
<a href="main">메인으로 돌아가기</a>
	

   </body>
</html>