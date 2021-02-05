<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <h1>사원등록</h1>
   <form action="insertEmp">  
    employeeId <input name="employeeId"/>
    			<form:errors path="empVO.employeeId"/><br>
    firstName <input name="firstName">
    			<form:errors path="empVO.firstName"/><br>
    lastName <input name="lastName">
    			<form:errors path="empVO.lastName"/><br>
    email <input name="email">
    			<form:errors path="empVO.email"/><br>
    hireDate <input name="hireDate"><br>
    jobId <input name="jobId"><br>
    <button>등록</button>
    </form>
