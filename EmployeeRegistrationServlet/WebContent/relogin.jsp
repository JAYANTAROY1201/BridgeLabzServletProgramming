<%@page import="java.io.PrintWriter"%>
<%
PrintWriter o=response.getWriter();
response.setContentType("text/html");
o.println("<h3 style=\"color:white; background-color:red\">Invalid password!! Please login again...</h3>");
request.getRequestDispatcher("Login.jsp").include(request, response);
%>

