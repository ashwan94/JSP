<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 회원 등록</title>
<style>
lable {
	display:block;
}
</style>
</head>
<body>
<h1>회원정보</h1>
<form action="/user/add" method="post">
	<label>
		ID : <input type="text" name="id">
	</label>
	<label>
		PW : <input type="password" name="password">
	</label>
	<label>
		EMAIL : <input type="email" name="email">
	</label>
	<button type="submit">저장</button>
	<button type="button">취소</button>
</form>
</body>
</html>