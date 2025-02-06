<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
	<h3>회원 로그인</h3>
	<form action="loginProc.jsp" method="post">
		ID : <input type="text" name="mid"><br>
		PW : <input type="password" name="mpass"><br>
		NAME : <input type="text" name="mname"><br>
		AGE : <input type="text" name="mage"><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>