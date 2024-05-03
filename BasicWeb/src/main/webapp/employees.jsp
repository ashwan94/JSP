<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
</head>
<body>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>고용일</th>
		<th>테스트</th>
	</tr>
	<!-- EL(expression Language) 표현 언어 p.250 참고 -->
	<c:forEach var="vo" items="${employees}">
	<!-- java 파일의 request.setAttribute() 로 작성된 data 를 가져옴 -->
	<tr>
		<td>${vo.employeeId}</td>
		<td>${vo.empName }</td>
		<td>${vo.email }</td>
		<td>${vo.phoneNumber }</td>
		<td>${vo.hireDate }</td>
		<td>테스트</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>