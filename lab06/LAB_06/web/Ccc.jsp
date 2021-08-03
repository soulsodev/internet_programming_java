<%@ page import="JSP.CBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    CBean cBean = null;
    ServletContext servletContext = request.getServletContext();
    Enumeration enumerator = servletContext.getAttributeNames();
    String paramName;
    PrintWriter printWriter = response.getWriter();

    while (enumerator.hasMoreElements()) {
        paramName = (String) enumerator.nextElement();

        if (paramName.equals("value1") || paramName.equals("value2") || paramName.equals("value3") || paramName.equals("atrCBean")) {
            printWriter.println("<br />" + paramName + "= " + servletContext.getAttribute(paramName));
        }

        if (paramName.equals("atrCBean")) {
            cBean = (CBean) servletContext.getAttribute(paramName);
        }
    }
%>

</body>
</html>
