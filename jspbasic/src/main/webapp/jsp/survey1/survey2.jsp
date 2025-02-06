<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>survey2.jsp</title>
</head>
<body>
	<form action="survey2proc.jsp" method="post">
	<input type="hidden" name="name" value='<%=request.getAttribute("name") %>'>
		<p>취미를 선택하세요!</p>
		<p>
			<input type="checkbox" name="hobby" value="game">게임 &nbsp;
			<input type="checkbox" name="hobby" value="youtube">유튜브 &nbsp;
			<input type="checkbox" name="hobby" value="sleeping"> 잠자기
		</p>
		<p><input type="submit" name="name"></p>
	</form>
</body>
</html>