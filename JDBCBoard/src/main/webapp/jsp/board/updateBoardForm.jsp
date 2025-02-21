<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시판수정</h3>
	<form action="/updateBoard.do" method="post">
	<input type="hidden" name="bid" value="${board.bid}"><br>
		아이디 :<a href='/getBoard.do?bid=${board.bid}'>${board.bid}</a><br>
		게시판명 : <input type="text" name="bname" value="${board.bname}"><br>
		게시물수 :${board.bacnt}<br><br><br>
		<input type="button" value="목록" onclick="location.href='/selectBoard.do';">&nbsp;
		<input type="submit" value="등록">
	</form>
<%@ include file="/jsp/include/footer.jsp" %>