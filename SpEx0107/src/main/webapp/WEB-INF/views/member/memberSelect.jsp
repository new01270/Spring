<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/memberSelect.jsp</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회 원 정 보</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberList.do" method="post">
				<input type="hidden" name="member" value="${member }">
				<table border="1">
					<tr>
						<th width="200" height="40">회원아이디</th>
						<td width="400" height="40">${member.memberid }</td>
					</tr>
					<tr>
						<th width="200" height="40">비밀번호</th>
						<td width="400" height="40">${member.password }</td>
					</tr>
					<tr>
						<th width="200" height="40">회원명</th>
						<td width="400" height="40">${member.membername }</td>
					</tr>
					<tr>
						<th width="200" height="40">회원권한</th>
						<td width="400" height="40">${member.memberauth } </td>
					</tr>
					<tr>
						<th width="200" height="40">포인트</th>
						<td width="400" height="40">${member.memberpoint }</td>
					</tr>
				</table>
				<br> <input type="submit" value="목 록 가 기">&nbsp;&nbsp;&nbsp;
			</form>
		</div>
	</div>
</body>
</html>