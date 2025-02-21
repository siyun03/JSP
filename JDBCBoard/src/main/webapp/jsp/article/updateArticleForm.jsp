<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시물 수정</h3>
	<form action="/updateArticle.do" method="post">
		<input type="hidden" name="aid" value="${article.aid}"/>
		제목 : <input type="text" value="${article.asubject}" name="asubject"><br>
		내용 : <textarea rows="10" cols="40" name="acontent">${article.acontent}</textarea>
		<input type="submit" value="수정">&nbsp;
		<input type="submit" value="목록" onclick="location.href='/selectArticle.do'">
	</form>
<%@ include file="/jsp/include/footer.jsp" %>