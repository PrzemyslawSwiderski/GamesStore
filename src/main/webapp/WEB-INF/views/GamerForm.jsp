<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Przemek_Swiderski
  Date: 2015-07-15
  Time: 01:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gamer Form</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/cssFile.css" />">
</head>
<body>
<div align="center">
    <h1>Gamer Form</h1>
    <form:form action="save" method="post" modelAttribute="gamer">
        <form:hidden path="idGamer"/>
        <table>

            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
        <form:errors path="*" cssClass="error"/>
    </form:form>
</div>

</body>
</html>
