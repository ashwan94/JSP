<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="상세 게시글 조회" name="title"/>
</jsp:include>
<a href="/board/update?no=${board.no}">수정</a>
<a href="javascript:deleteBoard();">삭제</a>
<div>
	게시글 번호: ${board.no }
</div>
<div>
	작성자: ${board.writer }
</div>
<div>
	제목: ${board.title }
</div>
<div>
	작성일: ${board.createDate }
</div>
<input type="hidden" name="${board.no}">
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>