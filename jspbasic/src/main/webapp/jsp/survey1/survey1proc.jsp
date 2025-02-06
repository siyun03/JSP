<%@ page contentType="text/html; charset=UTF-8"%>

<%
    //String name = request.getParameter("name");
    //session.setAttribute("name", name);
    
    request.setAttribute("name", request.getParameter("name"));
    request.getRequestDispatcher("survey2.jsp").forward(request, response);
%>
