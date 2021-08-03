<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>

<div class="row h-100">
    <div class="col-8 my-auto col-8 my-auto mx-auto">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">PHONE NAME</th>
                <th scope="col">PRICE</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${tableModelList}" var="element">
                <tr>
                    <td>${element.id}</td>
                    <td>${element.name}</td>
                    <td>${element.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>
