<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>회원가입</h3>
	<form action="/insertMember.do" method="post">
		아이디 : <input type="text" name="mid"><br>
		비밀번호 : <input type="password" name="mpass"><br>
		성명 : <input type="text" name="mname"><br>
		별칭 : <input type="text" name="malias"><br>
		이메일 : <input type="text" name="memail"><br>
		전화번호 : <input type="text" name="mcp"><br>
		<input type="button" value="목록" onclick="location.href='/selectMember.do';">&nbsp;
		<input type="submit" value="등록" class="btn btn-success">
	</form>
<%@ include file="/jsp/include/footer.jsp" %>