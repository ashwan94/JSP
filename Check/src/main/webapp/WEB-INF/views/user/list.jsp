<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="회원 목록" name="title"/>
</jsp:include>
<h1>회원 목록</h1>
<a href="/user/add">신규 회원</a>
<form action="/board/list" method="get">
	<label>
		<select type="text" name="searchType">
			<option>선택</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
		</select>
	</label>
	<label>
		<input type="text" name="searchWord" placeholder="검색어">
	</label>
	<button>검색</button>
</form>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일자</th>
	</tr>
	<c:forEach var="user" items="${users }">
		<tr>
			<td><a href="/user/view?id=${user.id }">${user.id }</a></td>
			<td><a href="/user/view?id=${user.id }">${user.name }</a></td>
			<td>${user.email }</td>
			<td>${user.createDate }</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>