<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>

<div style="margin-left: 30px; margin-top: 30px;">
    <a class="btn btn-primary" style="background-color: darkviolet"
       href="http://localhost:8081/LAB_10_war_exploded/DBConnect?task=1" role="button">SELECT ALL</a>
    <a class="btn btn-primary" style="background-color: coral"
       href="http://localhost:8081/LAB_10_war_exploded/DBConnect?task=2&minPrice=2100" role="button">SELECT WITH
        CLAUSE</a>
    <a class="btn btn-primary" style="background-color: cornflowerblue"
       href="http://localhost:8081/LAB_10_war_exploded/DBConnect?task=3&id=1" role="button">CALL STORE PROCEDURE</a>
</div>

</body>
</html>
