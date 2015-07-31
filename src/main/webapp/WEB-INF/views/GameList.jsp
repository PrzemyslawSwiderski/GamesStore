<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Przemek_Swiderski
  Date: 2015-07-16
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Games List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/cssFile.css" />">
</head>

<body>

<div align="left">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        Welcome : ${pageContext.request.userPrincipal.name}
        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if>
</div>
<hr>
<form:form action="new" method="get">
    <input align="middle" type="submit" value="Add New Game">
</form:form>
<hr>
<table style="width:100%" class="pure-table">
    <tr>
        <th>Nr.</th>
        <th>Title</th>
        <th>Studio</th>
        <th>Release Date</th>
        <th>In Store</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="game" items="${gameList}" varStatus="status">
        <tr>
            <td>
                <b>${status.index + 1}.</b>
            </td>
            <td>
                <b>${game.title}</b>
            </td>
            <td>
                <b>${game.studio}</b>
            </td>
            <td>
                <b><fmt:formatDate value="${game.releaseDate}" pattern="yyyy-MM-dd"/>
                </b>
            </td>
            <td>
                <b>${game.inStore}</b>
            </td>
            <td>
                <a href="edit?id=${game.idGame}" class="button dark_grey">Edit</a>
            </td>
            <td>
                <a href="delete?id=${game.idGame}" class="button dark_grey">Delete</a>
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

