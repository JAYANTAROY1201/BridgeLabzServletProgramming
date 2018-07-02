<%@page import="java.io.PrintWriter"%>
<%
PrintWriter o=response.getWriter();
response.setContentType("text/html");
o.println("<h3><marquee>SignUp successful!! You can login now...</marquee></h3>");
request.getRequestDispatcher("Login.jsp").include(request, response);
%>

