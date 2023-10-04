<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title> 예제 </title>
   </head>
<script type="text/javascript">
	function deleteMember(mid){
	var ans=confirm('탈퇴 하시겠습니까? 😢');
	if(ans){
	location.href="deleteMember?mid="+mid;
	}
   }
</script>

   <body>

	<h1>🌟 마이페이지 🌟</h1>
       <form action="updateMember" method="POST">
	<input type="hidden" name="mid" value="${mid}">
	비밀번호 변경 <input type="password" name="mpw" required> <br>
	<input type="submit" value="변경하기"> <input type="button" onclick="deleteMember('${mid}')" value="회원탈퇴">
<br>

	</form>


<br>

<a href="main">메인으로 돌아가기</a>
	


   </body>
</html>