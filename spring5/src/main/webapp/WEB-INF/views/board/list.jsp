<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 목록" name="title"/>
</jsp:include>
<h2>게시판</h2>
<c:if test="${not empty sessionScope.member}">
<a href="/board/add">게시글 등록</a>
</c:if>
<table>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="board" items="${boards}">
	<tr>
		<td>${board.no }</td>
		<td><a href="/board/view?no=${board.no}">${board.title }</a></td>
		<td>${board.writer }</td>
		<td>${board.createDate }</td>
		<td>${board.hits }</td>
	</tr>
	</c:forEach>
</table>
<!-- 페이지 링크 -->
<a href="/board/list?currentPageNo=1">맨 처음</a>
<c:if test="${pagination.currentPageNo > 1 }">
	<a href="/board/list?currentPageNo=${pagination.currentPageNo - 1 }">이전</a>
</c:if>
<!-- 디자이너가 작업할 수 있도록 조치함 -->
<!-- 표시할 게시물이 없으면 '이전' button 을 표시는 하지만, 작동하지 않도록 조치 -->
<c:if test="${pagination.currentPageNo <= 1 }">
	<a href="#">이전</a>
</c:if>

<c:forEach begin="${pagination.firstPageNoOnPageList }" end="${pagination.lastPageNoOnPageList }" var="pageNo">
	<a href="/board/list?currentPageNo=${pageNo }">${pageNo }</a>	
</c:forEach>

<c:if test="${pagination.currentPageNo < pagination.totalPageCount}">
	<a href="/board/list?currentPageNo=${pagination.currentPageNo + 1 }">다음</a>
</c:if>

<!-- 디자이너가 작업할 수 있도록 조치함 -->
<!-- 표시할 게시물이 없으면 '다음' button 을 표시는 하지만, 작동하지 않도록 조치 -->
<c:if test="${pagination.currentPageNo >= pagination.totalPageCount }">
	<a href="#">다음</a>
</c:if>

<a href="/board/list?currentPageNo=${pagination.totalPageCount }">맨 마지막</a>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
