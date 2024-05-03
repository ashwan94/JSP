<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<style>
form {
	text-align : right;
	margin:20px 30px 0px 0px;
}
</style>
</head>
<body>
	<header>
		<c:choose>
			<c:when test="${not empty user}">
				<form action="/logout" method="get">
					<span id="loginName">${user.name }님 환영합니다</span>
					<button type="submit">로그아웃</button>
				</form>
			</c:when>
			<c:otherwise>
				<form action="/login" method="get">
					<span id="loginName"></span>
					<button type="submit">로그인</button>
				</form>
			</c:otherwise>
		</c:choose>
	</header>
	<h1>회원목록</h1>
	<a href="/user/add">신규회원</a>
	<table>
		<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일자</th>
		</tr>
		<c:forEach var="user" items="${users }">
			<tr>
			<td><a href="/user/view?=id=${user.id }">${user.id }</a></td>
			<td><a href="/user/view?=id=${user.id }">${user.name }</a></td>
			<td>${user.email }</td>
			<td>${user.createDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>