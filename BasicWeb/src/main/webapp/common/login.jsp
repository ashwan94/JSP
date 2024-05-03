<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
<style>
	label{
		display:block;
	}
	#log{
		color:red;
	}
</style>
</head>
<body>
	<h2>로그인</h2>
	<form action="/login" method="post">
		<label>아이디: 
			<input type="text" name="id" placeholder="ID를 입력하세요.">
		</label>
		<label>PW:
			<input type="password" name="password" placeholder="PW를 입력하세요.">
		</label>
		<div id="log">${msg}</div>
		<button type="submit">로그인</button>
		<button type="button">취소</button>
	</form>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>