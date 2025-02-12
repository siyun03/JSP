<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>get</title>
</head>
<body>
번호 : ${dto.sid}, 제목 : ${dto.title}, 내용 : ${dto.content}<br>
<a href="/select.do">목록</a>
</body>
</html>