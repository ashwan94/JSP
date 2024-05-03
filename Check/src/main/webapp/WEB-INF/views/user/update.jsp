<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="회원정보 수정" name="title"/>
</jsp:include>
<h1>회원정보 수정</h1>
<form action="/user/update" method="post">
	<label>ID:
		<input type="text" name="id" readonly value="${user.id }">
	</label>
	<label>이름:
		<input type="text" name="name" readonly value="${user.writer }">
	</label>
	<label>PW:
		<input type="text" name="password" readonly value="${user.password }">
	</label>
	<label>EMAIL:
		<input type="email" name="email" readonly value="${user.email }">
	</label>
	<button type="submit">저장</button>
	<button type="button">취소</button>
</form>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>