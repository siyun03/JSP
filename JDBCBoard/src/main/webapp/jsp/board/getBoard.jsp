<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시판정보</h3>
	<table class="table table-striped table-bordered">
		<tr>
			<td>아이디</td>
			<td>${board.bid}</td>
		</tr>
		<tr>
			<td>게시판명</td>
			<td>${board.bname}</td>
		</tr>
		<tr>
			<td>게시물수</td>
			<td>${board.bacnt}</td>
		</tr>
	</table>
	<p><input type="button" value="목록" onclick="location.href='/selectBoard.do';" class="btn btn-success"></p>
<%@ include file="/jsp/include/footer.jsp" %>

