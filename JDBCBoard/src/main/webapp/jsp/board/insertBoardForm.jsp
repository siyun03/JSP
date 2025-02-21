<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시판</h3>
	<form action="/insertBoard.do" method="post">
		게시판명 : <input type="text" name="bname"><br><br>
		<input type="button" value="목록" onclick="location.href='/selectBoard.do';" class="btn btn-success">&nbsp;
		<input type="submit" value="등록" class="btn btn-success">
	</form>
<%@ include file="/jsp/include/footer.jsp" %>