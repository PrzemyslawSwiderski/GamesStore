<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<div align="left" >
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        Welcome : <b> ${pageContext.request.userPrincipal.name}</b>
        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if>
</div>
<h1 align="center">MENU</h1>

<br>

<form action="purchase?gamerID=${game.idGame}&gameID=${gamer.idGamer}" method="get">
    <table style="width:100%" class="pure-table">
        <td>
            <table style="width:100%" class="pure-table">
                <caption style="font-size: 150%">
                    <a href="gamelist/" class="button dark_grey">Games</a>
                </caption>
                <tr>
                    <th>Nr.</th>
                    <th>Title</th>
                    <th>Studio</th>
                    <th>Release Date</th>
                    <th>In Store</th>
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
                            <b>
                                <fmt:formatDate value="${game.releaseDate}" pattern="yyyy-MM-dd"/>
                            </b>
                        </td>
                        <td>
                            <b>${game.inStore}</b>
                        </td>
                        <td>
                            <input type="radio" name="gameID" value="${game.idGame}"/>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </td>
        <td>
            <table style="width:100%" class="pure-table">
                <caption style="font-size: 150%">
                    <a href="gamerlist/" class="button dark_grey">Gamers</a>
                </caption>
                <tr>
                    <th>Nr.</th>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Sign Date</th>
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
                            <b><fmt:formatDate value="${gamer.signDate}" pattern="yyyy-MM-dd"/>
                            </b>
                        </td>
                        <td>
                            <input type="radio" name="gamerID" value="${gamer.idGamer}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </table>
    <br>
    <input type="submit" value="Add Purchase" align="center">
</form>

<table style="width:100%" class="pure-table">
    <caption style="font-size: 150%">
        <b>Purchases</b>
    </caption>
    <tr>
        <th>Nr.</th>
        <th>Last Name</th>
        <th>Name</th>
        <th>Title</th>
        <th>Purchase Date</th>
    </tr>
    <c:forEach var="purchase" items="${purchaseList}" varStatus="status">
        <tr>
            <td>
                <b>${status.index + 1}.</b>
            </td>
            <td>
                <b>${purchase.lastName}</b>
            </td>
            <td>
                <b>${purchase.name}</b>
            </td>
            <td>
                <b>${purchase.title}</b>
            </td>
            <td>
                <b><fmt:formatDate value="${purchase.purchaseDate}" pattern="yyyy-MM-dd"/>
                </b>
            </td>
        </tr>
    </c:forEach>
</table>
<form method="get" action="deleteAll">
    <input type="submit" value="Clear Purchases">
</form>
</body>
</html>
