<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<b>URL1:</b> <%= request.getServletContext().getInitParameter("URL1") %>
<br>
<b>URL2:</b> <%= request.getServletContext().getInitParameter("URL2") %>


</body>
</html>
