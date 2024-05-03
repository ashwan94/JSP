<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="회원 목록" name="title"/>
</jsp:include>
<h1>회원 목록</h1>
<%-- <c:if test="${not empty sessionScope.member}"> --%>
<a href="/member/add">신규 회원</a>
<%-- </c:if> --%>
<form action="/board/list" method="get"> <!-- 검색어가 노출돼도 상관없고, history에 남으므로 get 이 적절 -->
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
	<c:forEach var="member" items="${members}">
	<tr>
		<td><a href="/member/view?id=${member.id}">${member.id}</a></td>
		<td><a href="/member/view?id=${member.id}">${member.name}</a></td>
		<td>${member.email}</td>
		<td>${member.createDate}</td>
	</tr>
	</c:forEach>
</table>
<!-- 페이지 링크 -->
<a href="/member/list?currentPageNo=1">맨 처음</a>
<c:if test="${pagination.currentPageNo > 1 }">
	<a href="/member/list?currentPageNo=${pagination.currentPageNo - 1 }">이전</a>
</c:if>
<!-- 디자이너가 작업할 수 있도록 조치함 -->
<!-- 표시할 게시물이 없으면 '이전' button 을 표시는 하지만, 작동하지 않도록 조치 -->
<c:if test="${pagination.currentPageNo <= 1 }">
	<a href="#">이전</a>
</c:if>

<c:forEach begin="${pagination.firstPageNoOnPageList }" end="${pagination.lastPageNoOnPageList }" var="pageNo">
	<a href="/member/list?currentPageNo=${pageNo }">${pageNo }</a>	
</c:forEach>

<c:if test="${pagination.currentPageNo < pagination.totalPageCount}">
	<a href="/member/list?currentPageNo=${pagination.currentPageNo + 1 }">다음</a>
</c:if>

<!-- 디자이너가 작업할 수 있도록 조치함 -->
<!-- 표시할 게시물이 없으면 '다음' button 을 표시는 하지만, 작동하지 않도록 조치 -->
<c:if test="${pagination.currentPageNo >= pagination.totalPageCount }">
	<a href="#">다음</a>
</c:if>

<a href="/member/list?currentPageNo=${pagination.totalPageCount }">맨 마지막</a>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>



