<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 화면</title>
<style>
</style>
</head>
<body>
	<a href="/user/update?id=${user.id }">수정</a>
	<a href="javascript:deleteMember();">삭제</a>
	<a href="/user/password?id=${user.id }">비밀번호 변경</a>
	<div>
	ID : ${user.id }
	</div>
	<div>
	이름 : ${user.name }
	</div>
	<div>
	EMAIL : ${user.email }
	</div>
</body>
<script>
	function deleteMember() {
		if(confirm("삭제하시겠습니까?")) {
			location.href = "/user/delete?id=${user.id}"
		}else{
			alert("삭제를 취소하셨습니다.");
		}
	}
</script>
</html>