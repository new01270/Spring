<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/memberInsertForm.jsp</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회 원 등 록</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberInsert.do" method="post">
				<table border="1">
					<tr>
						<th width="200" height="40">회원아이디</th>
						<td width="400" height="40">
							<input type="text" id="memberid" name="memberid" style="border:none;">
						</td>
					</tr>
					<tr>
						<th width="200" height="40">비밀번호</th>
						<td width="400" height="40">
							<input type="password" id="password" name="password" style="border:none;">
						</td>
					</tr>
					<tr>
						<th width="200" height="40">회원명</th>
						<td width="400" height="40">
							<input type="text" id="membername" name="membername" style="border:none;">
						</td>
					</tr>
					<tr>
						<th width="200" height="40">회원권한</th>
						<td width="400" height="40">
							<input type="text" id="memberauth" name="memberauth" style="border:none;">
						</td>
					</tr>
				</table><br>
				<input type="submit" value="가 입 하 기">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="입 력 취 소">
			</form><br>
			<button onclick="location.href='main.do'">메 인 으 로</button>
		</div>
	</div>
</body>
</html>