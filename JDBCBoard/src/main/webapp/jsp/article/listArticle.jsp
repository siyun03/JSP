<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/jsp/include/header.jsp" %>

<h3>게시물 목록</h3>

<body>
	<p>
	   <form action="/selectArticle.do" method="post" class="form-inline">
	      <div class="form-group mb-2">
	         <select name="bid" class="form-control">
	            <option value="">전체</option>
	         </select>
	      </div>&nbsp;

	      <div class="form-group mb-2">
	         <select name="searchClass" class="form-control">
	            <option value="" <c:if test="${empty searchClass}">selected</c:if>>전체</option>
	            <option value="asubject" <c:if test="${searchClass=='asubject'}">selected</c:if>>제목</option>
	            <option value="acontent" <c:if test="${searchClass=='acontent'}">selected</c:if>>내용</option>
	            <option value="mid" <c:if test="${searchClass=='mid'}">selected</c:if>>작성자 아이디</option>
	         </select>
	      </div>&nbsp;

	      <div class="form-group mb-2">
	         <input type="text" name="searchVal" value="${searchVal}" class="form-control" placeholder="검색어 입력">
	      </div>&nbsp;

	      <div class="form-group mb-2">
	         <input type="submit" value="검색" class="btn btn-success">
	      </div>
	   </form>
	</p>

	<!-- 게시물 목록 테이블 -->
	<table class="table table-striped table-bordered">
		<thead class="thead-dark">
			<tr>
				<th>아이디</th>
				<th>게시판</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성자</th>
				<th>등록일시</th>
				<th>첨부파일수</th>
			</tr>
		</thead>
		<c:if test="${!empty articleList}">
			<tbody>
				<c:forEach var="article" items="${articleList}">
					<tr>
						<td>${article.aid}</td>
						<td>${article.bname}</td> 
						<td><a href="/getArticle.do?aid=${article.aid}">${article.asubject}</a></td>
						<td>${article.avcnt}</td>
						<td>${article.mid}</td>
						<td><fmt:formatDate value="${article.aregdate}" pattern="MM/dd HH:mm"/></td>
						<td>${article.acount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
	</table>

	<!-- 등록 버튼 -->
	<p>
		<input id="insertBtn" type="button" value="등록" 
		data-mid="${sessionScope.ss_mid}" data-location="/insertArticleForm.do" class="btn btn-success">
	</p>

	<script>
		$(function(){
			board.getBoardList("${searchBoard}");
		});
	</script>

<%@ include file="/jsp/include/footer.jsp" %>
