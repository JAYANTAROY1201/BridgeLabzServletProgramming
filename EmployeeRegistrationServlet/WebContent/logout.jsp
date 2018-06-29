<%@page import="java.io.PrintWriter"%>
<%
PrintWriter o=response.getWriter();
response.setContentType("text/html");
o.println("<h3 style=\"color:white; background-color:red\">Logout Successfull!! Hope we see you again...</h3>");
request.getRequestDispatcher("HomePage.html").include(request, response);
%>

