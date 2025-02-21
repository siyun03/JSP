<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시판목록</h3>
	<table class="table table-striped table-bordered">
		<thead class="thead-dark">
			<tr>
				<th>아이디</th>
				<th>게시판명</th>
				<th>게시물수</th>
			</tr>
		</thead>
		<c:if test="${!empty boardList}">
		<tbody>
			<c:forEach var="board" items="${boardList}">
			<tr>
				<td><a href='/getBoard.do?bid=${board.bid}' >${board.bid}</a></td>
				<td>${board.bname}</td>
				<td>${board.bacnt}</td>
				<td>
					<input type="button" value="수정" onclick="location.href='/updateBoardForm.do?bid=${board.bid}';"  class="btn btn-outline-success">
					<input type="button" value="삭제" onclick="location.href='/deleteBoard.do?bid=${board.bid}';" class="btn btn-secondary">
				</td>
			</tr>
			</c:forEach>
		</tbody>
		</c:if>
	</table>
		<input id="insertBtn" type="button" value="등록" 
		data-mid="${sessionScope.ss_mid}"	data-location="/insertBoardForm.do" class="btn btn-success">
<%@ include file="/jsp/include/footer.jsp" %>


