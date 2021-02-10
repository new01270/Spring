<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main/main.jsp</title>
</head>
<body>
	<h1><spring:message code="main.title" /></h1>
	<br>
	<h3>
		<a href="memberList.do">멤버목록보기</a>
	</h3>
	<br>
	<h3>
		<a href="memberInsertForm.do">회원가입하기</a>
	</h3>
	<br>
	<h3>
		<a href="insEmpForm">멤버 등록</a>
	</h3>
	<br>
	<h3>
		<a href="updEmpForm">멤버 수정</a>
	</h3>
	<br>
	<h3>
		<a href="insUpdEmp">멤버 업데이트 파일확인</a>
	</h3>
	<br>
	<c:if test="${memberid eq null }">
		<h3>
			<a href="memberLoginForm.do">로그인하기</a>
		</h3>
	</c:if>
	<c:if test="${memberid ne null }">
		<h2>${memberid }님로그인~~~</h2>
		<h3>
			<a href="memberLogout.do">로그아웃하기</a>
		</h3>
	</c:if>
</body>
</html>