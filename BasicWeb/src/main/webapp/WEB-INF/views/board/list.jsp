<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 조회" name="title"/>
</jsp:include>
	<table>
	<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일자</th>
	<th>조회수</th>
	</tr>
	<c:forEach var="board" items="${boards }">
	<tr>
		<td><a href="/board/view?no=${board.no}">${board.no }</td>
		<td>${board.title }</td>
		<td>${board.writer }</td>
		<td>${board.createDate }</td>
		<td>${board.hits }</td>
	</tr>
	</c:forEach>
	</table>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>