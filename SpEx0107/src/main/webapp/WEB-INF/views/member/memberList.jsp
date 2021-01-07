<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/memberList.jsp</title>
</head>
<body>
	<div align="center">
		<h1>회원목록</h1>
		<c:forEach var="member" items="${members }">
			${member.memberid } &nbsp;&nbsp;&nbsp; 
			${member.membername } &nbsp;&nbsp;&nbsp;
			${member.password } &nbsp;&nbsp;&nbsp;
			${member.memberauth } &nbsp;&nbsp;&nbsp;
			${member.memberpoint } &nbsp;&nbsp;&nbsp;
			<a href="memberSelect.do?memberid=${member.memberid }">회원상세</a>&nbsp;&nbsp;
			<a href="memberDelete.do?memberid=${member.memberid }">회원삭제</a>&nbsp;&nbsp;
			<a href="memberEditForm.do?memberid=${member.memberid }">회원수정</a>
			<br><hr> 
		</c:forEach><br>
		<h3>
			<a href="memberInsertForm.do">회원가입하기</a>
		</h3>
		
	</div>
</body>
</html>