<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Przemek_Swiderski
  Date: 2015-07-16
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/cssFile.css" />">
</head>
<body>
<h1 align="center">MENU</h1>

<br>


<table style="width:100%" class="pure-table">
    <td>
        <table style="width:100%" class="pure-table">
            <caption style="font-size: 150%">
                <form method="get" action="gamelist/">
                    <input type="submit" value="Games">
                </form>
            </caption>
            <tr>
                <th>Nr.</th>
                <th>Title</th>
                <th>Studio</th>
                <th>Release Date</th>
                <th>In Store</th>
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
                        <b>${game.releaseDate}</b>
                    </td>
                    <td>
                        <b>${game.inStore}</b>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </td>
    <td>
        <table style="width:100%" class="pure-table">
            <caption style="font-size: 150%">
                <form method="get" action="gamerlist/">
                    <input type="submit" value="Gamers">
                </form>
            </caption>
            <tr>
                <th>Nr.</th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Sign Date</th>
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
                        <b>${gamer.signDate}</b>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </td>
</table>

</body>
</html>
