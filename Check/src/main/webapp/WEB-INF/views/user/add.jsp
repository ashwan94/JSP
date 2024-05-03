<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="회원 등록" name="title"/>
</jsp:include>
<h1>회원정보</h1>
<form action="/user/add" method="post">
	<label> ID :
		<input type="text" name="id">
	</label>
	<label> 이름 :
		<input type="text" name="name">
	</label>
	<label> PW :
		<input type="password" name="password">
	</label>
	<label> EMAIL :
		<input type="email" name="eamil">
	</label>
	<button type="submit">저장</button>
	<button type="button">취소</button>
</form>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>