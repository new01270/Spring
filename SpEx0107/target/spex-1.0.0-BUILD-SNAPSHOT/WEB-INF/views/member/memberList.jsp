<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/memberList.jsp</title>
</head>
<body>
	<div align="center">
		<h1>회원목록</h1>
		<div>
			${memberVO }
			<!-- model객체 첫글자만 소문자로 해서 확인하기 -->
			<form action="memberList.do">
				id<input name="memberid" value="${vo.memberid }"> name<input
					name="membername" value="${vo.membername }"> auth<input
					name="memberauth" value="${vo.memberauth }">
				<button>검색</button>
			</form>
		</div>
		<c:forEach var="member" items="${members }">
			${member.memberid } &nbsp;&nbsp;&nbsp; 
			${member.membername } &nbsp;&nbsp;&nbsp;
			${member.password } &nbsp;&nbsp;&nbsp;
			${member.memberauth } &nbsp;&nbsp;&nbsp;
			${member.memberpoint } &nbsp;&nbsp;&nbsp;
			<a href="memberSelect.do?memberid=${member.memberid }">회원상세</a>&nbsp;&nbsp;
			<a href="memberDelete.do?memberid=${member.memberid }">회원삭제</a>&nbsp;&nbsp;
			<a href="memberEditForm.do?memberid=${member.memberid }">회원수정</a>
			<br>
			<hr>
		</c:forEach>

		<my:paging paging="${paging }" jsFunc="goList" />
		<script type="text/javascript">
			function goList(p) {
				location.href = "memberList.do?page=" + p;
			}
		</script>


		<br>
		<h3>
			<a href="memberInsertForm.do">회원가입하기</a><br> <br> <a
				href="main.do">메인으로~~</a>
		</h3>

	</div>
</body>
</html>