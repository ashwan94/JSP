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
.error{
	color:red;
}
</style>
</head>
<body>
	<form action="/user/password" method="post" id="passwordForm">
		<label>
		현재 비번 : <input type="password" name="currentPassword" id="currentPassword">
		</label>
		<label>
		변경할 비번 : <input type="password" name="password" id="password">
		</label>
		<label>
		비번 체크 : <input type="password" id="confirmPassword">
		</label>
		<input type="hidden" name="id" value="${deleteId }">
		<button type="submit">변경</button>
		<button type="button">취소</button>
	</form>
</body>
<script>
const passwordForm = document.querySelector("#passwordForm");
passwordForm.addEventListenter("submit", function(e)){
	e.preventDefalut;
	const password = document.querySelector("#password");
	const confirmPassword = document.querySelector("#confirmPassord");
	if(password.value == confirmPassword) {
		this.submit;
	}else{
		const span = document.createElement("span");
		span.classList.add("error");
		span.textContent = "비밀번호가 일치하지 않습니다.";
		confirmPassword.parentNode.appendChild(span);
		confirmPassword.select();
	}
})
</script>
</html>