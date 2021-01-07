<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberLoginForm.jsp</title>
</head>
<body>
	<div align="center">
		<form id="frm" name="frm" action="memberLoginResult.do" method="post">
			<div align="center">
				<h1>로그인</h1>
				아이디 <input type="text" size="50" id="memberid" name="memberid"><br>
				<br> 비밀번호 <input type="password" size="50" id="password"
					name="password">
			</div>
			<br> <input type="submit" value="로그인하기">
		</form>
		<br>
		<button onclick="location.href='main.do'">메 인 으 로</button>
	</div>
</body>
</html>