<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	// 실습2 : 이미지 다운로드 구현
	InputStream is = application.getResourceAsStream("/img/cat.jpg");

	// 다운로드시 응답헤더 설정
	response.setHeader("Content-Disposition", "attachment; filename\"cat.jpg\"");

	OutputStream os = response.getOutputStream();
	
	byte[] buffer = new byte[1024];
	int readByte = 0;
	while((is.read(buffer)) > -1){
		os.write(buffer,0,readByte); // 1024개 단위이므로 마지막 읽은 바이트 계산해야 함
	}

%>