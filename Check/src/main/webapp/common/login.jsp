<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<label>
			ID :
			<input type="text" name="id" placeholder="ID를 입력하세요">
		</label>
		<label>
			PW :
			<input type="password" name="password" placeholder="PW를 입력하세요">
		</label>
		<div id="log">${msg }</div>
		<button type="submit">로그인</button>
		<button type="button">취소</button>
	</form>
</body>
</html>