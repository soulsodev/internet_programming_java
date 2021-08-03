<%@ page import="classes.ChoiseXXX" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pi 13</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h1>Add new file</h1>
    <form method="post" action="Sss" enctype="multipart/form-data" class="form">
        <div class="row">
            <h3>Select file:</h3><input type="file" name="file" size="60" class="btn_link"/>
            <input type="submit" value="Upload" class="btn_link"/>
        </div>
    </form>
</div>

<%
    String d = (String) config.getServletContext().getInitParameter("doc-dir");
    ChoiseXXX ch = new ChoiseXXX(d, "docx");
    String ll = null;
    for (int i = 0; i < ch.listxxx.length; i++) {
        ll = ch.listxxx[i];
%>
<br/>
<div class="links">
    <a href="Sss?file=<%=ll%>"><%=ll%>
</div>
<%}%>

</body>
</html>
