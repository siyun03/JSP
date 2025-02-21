<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>회원수정</h3>
	<form action="/updateMember.do" method="post">
	<input type="hidden" name="mid" value="${member.mid}">
		아이디 :${member.mid}<br>
		성명 : <input type="text" name="mname" value="${member.mname}"><br>
		별칭 : <input type="text" name="malias" value="${member.malias}"><br>
		이메일 : <input type="text" name="memail" value="${member.memail}"><br>
		전화번호 : <input type="text" name="mcp" value="${member.mcp}"><br>
		<input type="button" value="목록" onclick="location.href='/selectMember.do';" class="btn btn-success">&nbsp;
		<input type="submit" value="등록" class="btn btn-success">
	</form>
<%@ include file="/jsp/include/footer.jsp" %>