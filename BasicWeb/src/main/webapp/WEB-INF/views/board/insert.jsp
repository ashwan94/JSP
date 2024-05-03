<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 작성" name="title"/>
</jsp:include>
	<form action="/board/insert" method="post">
		<label>제목 : 
			<input type="text" name="title">
		</label>
		<label>내용 : 
			<textarea rows="10" cols="40" name="content"></textarea>
		</label>
		<button type="submit">등록</button>
		<button type="button">취소</button>
		<input type="hidden" name="writer" value="${board.no }">
		<div style="color:red;">${msg }</div>
	</form>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>