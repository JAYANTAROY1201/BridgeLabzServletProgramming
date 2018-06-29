<%@page import="java.io.PrintWriter"%>
<%
PrintWriter o=response.getWriter();
response.setContentType("text/html");
o.println("<h3 >SignUp successful!! You can login now...</h3>");
request.getRequestDispatcher("Login.html").include(request, response);
%>

