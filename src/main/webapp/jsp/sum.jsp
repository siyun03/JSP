<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- 
	서블릿 실습
	1. SumServlet 클래스 실습
	2. sum.jsp 생성
	3. 두 수를 입력하면 결과를 출력
 --%>
<form action="/sum" method="POST">
 	<input type="text" name="num1"><br>
 	<input type="text" name="num2"><br>
 	<input type="submit" value="전송">
 </form>