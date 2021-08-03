<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 14.04.2021
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

URL1: <%= request.getServletContext().getInitParameter("URL1") %>
<br>
URL1: <%= request.getServletContext().getInitParameter("URL2") %>

</body>
</html>
