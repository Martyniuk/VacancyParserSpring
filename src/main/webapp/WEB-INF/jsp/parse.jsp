<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 19.02.16
  Time: 7:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="/parse">
    <table>
        <%--<tr>--%>
            <%--<td><form:label path="Provider">Provider</form:label></td>--%>
            <%--<td><form:input path="provider" /></td>--%>
        <%--</tr>--%>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
