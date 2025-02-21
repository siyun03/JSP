<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>회원목록</h3>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>별칭</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>삭제여부</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<c:if test="${!empty memberList}">
		<tbody>
			<c:forEach var="member" items="${memberList}">
			<tr>
				<td><a href='/getMember.do?mid=${member.mid}'>${member.mid}</a></td>
				<td >${member.mname}</td>
				<td>${member.malias}</td>
				<td>${member.mpass}</td>
				<td>${member.memail}</td>
				<td>${member.mcp}</td>
				<td>${member.mdelyn}</td>
				<td>
					<input type="button" value="수정" onclick="location.href='/updateMemberForm.do?mid=${member.mid}';" class="btn btn-outline-success">
					<input type="button" value="삭제" onclick="location.href='/deleteMember.do?mid=${member.mid}';"  class="btn btn-secondary">
				</td>
			</tr>
			</c:forEach>
		</tbody>
		</c:if>
	</table>
		<input id="insertBtn" type="button" value="등록" 
		data-mid="${sessionScope.ss_mid}" data-location="/insertMemberForm.do"  class="btn btn-success">
<%@ include file="/jsp/include/footer.jsp" %>


