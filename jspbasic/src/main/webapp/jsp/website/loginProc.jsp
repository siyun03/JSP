<%@ page import="jspbasic.model.Member" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:useBean id="member" class="jspbasic.model.Member" />
<jsp:setProperty name="member" property="*" />

<%
	Member mem = (Member)pageContext.getAttribute("member");

	if (mem.getMid().equals("kim") && mem.getMpass().equals("1234")){
		session.setAttribute("sid", mem.getMid());
		session.setAttribute("sname", "김슌");
	}
		response.sendRedirect("main.jsp");
%>

