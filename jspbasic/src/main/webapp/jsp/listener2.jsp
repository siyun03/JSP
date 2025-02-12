<%@ page contentType="text/html; charset=UTF-8"%>

<%
	// application 속성변수 생성
	application.setAttribute("name" , "홍길동");
	
	// application 속성변수 대체
	application.setAttribute("name" , "강감찬");
	
	// application 속성변수 삭제
	application.removeAttribute("name");
	
	// application 속성변수 생성
	application.setAttribute("adress" , "서울");
	
	// application 속성변수 대체
	application.setAttribute("adress" , "부산");
	
	// application 속성변수 삭제
	application.removeAttribute("adress");
	
	
%>