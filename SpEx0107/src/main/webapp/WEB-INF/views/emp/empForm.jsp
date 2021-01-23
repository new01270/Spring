<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/empForm.jsp</title>
</head>
<body>
	<h3>사원등록, 사원수정 한 페이지에서 가능</h3>
	<!-- commandName에 첫글자만 소문자로해서 넘어옴, items는 controller에서 메소드명, path에 속성만 정의-->
	<form:form modelAttribute="empVO">
		employee_id <form:input path="employee_id" /><br>
		first_name <form:input path="first_name" /><br>
		last_name <form:input path="last_name" /><br>
		hire_date <form:input path="hire_date" /><br>
		email <form:input path="email" /><br>
		job_id <form:radiobuttons path="job_id" 
		items="${ jobList}" itemLabel="job_title" itemValue="job_id"/><br>
		department_id <form:select path="department_id" 
		items="${ deptList}" itemLabel="department_name" itemValue="department_id"></form:select>
		<br><br><!-- itemLabel을 선택하면 itemValue값이 넘어간다. -->
		<form:button>등록</form:button>
	</form:form>
</body>
</html>