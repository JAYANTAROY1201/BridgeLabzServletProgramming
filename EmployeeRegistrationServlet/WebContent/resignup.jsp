<%@page import="java.io.PrintWriter"%>
<%
PrintWriter o=response.getWriter();
response.setContentType("text/html");
o.println("<h3 >Signup unsuccessful!! email or user name already in use</h3>");
request.getRequestDispatcher("SignUp.jsp").include(request, response);
%>
