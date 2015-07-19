<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Przemek_Swiderski
  Date: 2015-07-15
  Time: 01:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Gamers List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/cssFile.css" />">
</head>

<body>
<hr>
<form:form action="new" method="get">
    <input align="middle" type="submit" value="Add New Gamer">
</form:form>
<hr>
<table style="width:100%" class="pure-table">
    <tr>
        <th>Nr.</th>
        <th>Name</th>
        <th>Last Name</th>
        <th>Sign Date</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="gamer" items="${gamerList}" varStatus="status">
        <tr>
            <td>
                <b>${status.index + 1}.</b>
            </td>
            <td>
                <b>${gamer.name}</b>
            </td>
            <td>
                <b>${gamer.lastName}</b>
            </td>
            <td>
                <b>
                    <fmt:formatDate value="${gamer.signDate}" pattern="yyyy-MM-dd"/>
                </b>
            </td>
            <td>
                <a href="edit?id=${gamer.idGamer}" class="button dark_grey">Edit</a>
            </td>
            <td>
                <a href="delete?id=${gamer.idGamer}" class="button dark_grey">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>
<hr>
<form method="get" action="deleteAll">
    <input type="submit" value="Clear list">
</form>
<br>
<br>
<br>

<form method="get" action="..">
    <input type="submit" value="Go back to menu">
</form>
</body>
</html>
