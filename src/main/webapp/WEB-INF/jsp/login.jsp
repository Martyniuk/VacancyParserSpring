<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 11.02.16
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JavaForFun</title>
    <link href='../../css/bootstrap-theme.min.css' rel='stylesheet'>
</head>
<body>
<h2>Ola Spring Vacancy</h2>
<div class="table table-hover">
    <table>
        <thead>
            <th>Title</th>
            <th>City</th>
            <th>Description</th>
            <th>Date of publication</th>
            <th>Company</th>
        </thead>
        <c:if test="${not empty login}">
        <c:forEach items="${login}" var="vacancy">
            <tr>
                <td><a href="${vacancy.link}">${vacancy.title}</a></td>
                <td>${vacancy.city}</td>
                <td>${vacancy.description}</td>
                <td>${vacancy.dateOfPublication}</td>
                <td>${vacancy.companyName}</td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
</div>
</body>
</html>
