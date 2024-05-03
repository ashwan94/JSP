<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
label{
	dislpay:block;
}
</style>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form action="/user/update" method="post">
		<label>
		ID : <input type="text" name="id" readonly="readonly" value="${user.id }">
		</label>
		<label>
		이름 : <input type="text" name="id" readonly="readonly" value="${user.name }">
		</label>
		<label>
		PW : <input type="text" name="id" readonly="readonly" value="${user.password }">
		</label>
		<label>
		EMAIL : <input type="text" name="id" readonly="readonly" value="${user.email }">
		</label>
		<button type="submit">저장</button>
		<button type="button">취소</button>
	</form>
</body>
</html>