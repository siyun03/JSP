<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>insertForm</title>
</head>
<body>
<form name="insertForm" action="/insert.do" method="post">
제목 : <input type="text" name="title"><br>
내용 : <textarea cols="40" rows="5" name="content"></textarea><br>
<input type="submit" value="입력">
</form>
</body>
</html>