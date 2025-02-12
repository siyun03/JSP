<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	String JDBC_USER = "mvc";
	String JDBC_PASS = "mvc";
	
	Class.forName(JDBC_DRIVER);
	Connection conn = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
	if(conn!=null){
		out.print("Oracle 연결 성공 !");
	}
%>