<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ include file="/jsp/include/header.jsp" %>

	<h3>게시물 조회</h3>
	<table class="table table-striped table-bordered">
		<tr>
			<td>아이디</td>
			<td>${article.aid}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${article.asubject}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${article.acontent}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${article.arcnt}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${article.mid}</td>
		</tr>
		<tr>
			<td>등록일시</td>
			<td><fmt:formatDate value="${article.aregdate}" pattern="yyyy/M/dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td>첨부파일수</td>
			<td>${article.adelyn}</td>
		</tr>
	</table>
	<c:if test="${!empty sessionScope.ss_mid}">
		<p>
			<input type="text" name="rcontent">&nbsp;
			<input id="insertReplyBtn" type="button" value="등록"
				data-mid="${sessionScope.ss_mid}" data-aid="${article.aid}" class="btn btn-success">
		</p>
		</c:if>
		<ul id="replyList"></ul>
		<p>
		<c:if test="${sessionScope.ss_mid == article.mid}">
			<input type="button" value="수정" onclick="location.href='/updateArticleForm.do?aid=${article.aid}';"  class="btn btn-outline-success">
			<input type="button" value="삭제" onclick="location.href='/deleteArticle.do?aid=${article.aid}';"  class="btn btn-outline-success">&nbsp;
		</c:if>	
			<input type="button" value="목록" onclick="location.href='/selectArticle.do';" class="btn btn-success">
		</p>
		<script>
			$(function() {
			board.getReplyList('${article.aid}','${sessionScope.ss_mid}');
			});
		</script>
<%@ include file="/jsp/include/footer.jsp" %>


