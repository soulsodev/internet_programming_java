<%@ page import="JSP.CBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"
         import= "java.util.*" %>
<%@ page import="java.io.PrintWriter" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    String sessionID = httpSession.getId();
    CBean obj =(CBean)request.getSession().getAttribute(sessionID);
%>

<br>
<br> request_atr1=<%=obj.getValue1()%>
<br> request_atr2=<%=obj.getValue2()%>
<br> request_atr3=<%=obj.getValue3()%>
<br> request_ref=<%=obj%>

</body>
</html>
