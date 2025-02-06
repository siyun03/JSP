<%--
out : javax.servlet.jsp.JspWriter 
-출력
-print() : 줄바꿈 없이 출력
-println() : 줄바꿈 문자와 함께 출력
-newLine() : 줄바꿈 문자 출력
--%>
<%@ page contentType="text/html; charset=UTF-8"%>

<% 
   out.print("Hello");
   out.println("hello");
   out.newLine();
   out.print("jsp");
 %>









