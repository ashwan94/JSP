<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.title}</title>
<style>
	label {
		display: block;
	}
	header form {
		text-align: right;
		margin: 20px 30px 0px 0px;
	}
</style>
</head>
<body>
<header>
	<c:choose>
		<c:when test="${not empty sessionScope.member}">
			<!-- member != null 또는 member ne null 로 표기 가능(not empty) -->
			<form action="/logout" method="get">
				<span id="loginName"> ${sessionScope.member.name} 님 환영합니다</span>
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