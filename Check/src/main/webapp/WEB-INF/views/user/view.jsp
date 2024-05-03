<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="회원정보" name="title"/>
</jsp:include>
<a href="/user/update?id=${user.id }">수정</a>
<a href="javascript:deleteItem('/user/delete?id=${user.id }');">삭제</a>
<a href="/user/password?id=${user.id }">비번 변경</a>
<div>
	ID : ${user.id }
</div>
<div>
	이름 : ${user.name }
</div>
<div>
	EMAIL : ${user.email }
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>