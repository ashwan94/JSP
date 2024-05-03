<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 수정" name="title"/>
</jsp:include>
<h1>게시글 내용 수정</h1>
<div>글 번호 : ${board.no }</div>
<div>작성일 : ${board.createDate }</div>
	<form action="/board/update" method="post">
		<label>제목 :
			<input type="text" name="title" value="${board.title }">
		</label>
		<label>내용 : 
			<textarea rows="10" cols="40" name="content">${board.content }</textarea>
		</label>
		<button type="submit">등록</button>
		<button type="button">취소</button>
		<input type="hidden" name="no" value="${board.no }">
		<div style="color:red;">${msg }</div>
	</form>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>