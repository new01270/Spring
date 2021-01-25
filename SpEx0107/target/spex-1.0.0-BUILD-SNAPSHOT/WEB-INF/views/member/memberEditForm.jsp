<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/memberEditForm.jsp</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회 원 수 정</h1>
		</div>
		<div>
			<form id="frm" name="frm"
				action="memberEdit.do?memberid=${member.memberid }" method="post">
				<input type="hidden" name="member" value="${member }">
				<table border="1">
					<tr>
						<th width="200" height="40">회원아이디</th>
						<td width="400" height="40">${member.memberid }</td>
					</tr>
					<tr>
						<th width="200" height="40">비밀번호</th>
						<td width="400" height="40"><input type="password"
							id="password" name="password" style="border: none;"></td>
					</tr>
					<tr>
						<th width="200" height="40">회원명</th>
						<td width="400" height="40">${member.membername }</td>
					</tr>
					<tr>
						<th width="200" height="40">회원권한</th>
						<td width="400" height="40"><input type="text"
							id="memberauth" name="memberauth" style="border: none;">
						</td>
					</tr>
					<tr>
						<th width="200" height="40">포인트</th>
						<td width="400" height="40"><input type="text"
							id="memberpoint" name="memberpoint" style="border: none;">
						</td>
					</tr>
				</table>
				<br> <input type="submit" value="수 정 하 기">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="입 력 취 소"><br>
			</form>
		</div>
	</div>
</body>
</html>