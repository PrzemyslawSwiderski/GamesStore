<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
  <style>
    body {
      background-color: lightgray
    }
    b {
      color: green
    }
    input[type=submit] {
      font-size: 120%;
      background: #656565;
      background: -webkit-gradient(linear, 0 0, 0 bottom, from(#656565), to(#444));
      background: -moz-linear-gradient(#656565, #444);
      background: linear-gradient(#656565, #444);
      border: solid 1px #535353;
      border-bottom: solid 3px #414141;
      box-shadow: inset 0 0 0 1px #939393;
      color: #fff;
      text-shadow: 0 1px 0 #2f2f2f;
    }
    input:hover[type=submit] {
      background: #4c4c4c;
      background: -webkit-gradient(linear, 0 0, 0 bottom, from(#4c4c4c), to(#565656));
      background: -moz-linear-gradient(#4c4c4c, #565656);
      background: linear-gradient(#4c4c4c, #565656);
      border: solid 1px #464646;
      border-bottom: solid 3px #414141;
      box-shadow: inset 0 0 0 1px #818181;
    }
    input:active [type=submit] {
      background: #474747;
      background: -webkit-gradient(linear, 0 0, 0 bottom, from(#474747), to(#444));
      background: -moz-linear-gradient(#474747, #444);
      background: linear-gradient(#474747, #444);
      border: solid 1px #2f2f2f;
      box-shadow: inset 0 10px 15px 0 #3e3e3e;
    }
    input[type=text] {
      padding: 5px;
      border: 2px solid #ccc;
      -webkit-border-radius: 5px;
      border-radius: 5px;
    }
    input[type=text]:focus {
      border-color: #333;
    }
    a{
      text-decoration: none;
    }
    a.button.dark_grey {
      font-size: 150%;
      background: #d1d1d1;
      background: -webkit-gradient(linear, 0 0, 0 bottom, from(#d1d1d1), to(#afafaf));
      background: -moz-linear-gradient(#d1d1d1, #afafaf);
      background: linear-gradient(#d1d1d1, #afafaf);
      border: solid 1px #b4b4b4;
      border-bottom: solid 3px #878787;
      box-shadow: inset 0 0 0 1px #e3e3e3;
      color: #555;
      text-shadow: 0 1px 0 #d6d6d6; }

    a.button.dark_grey:hover {
      background: #b7b7b7;
      background: -webkit-gradient(linear, 0 0, 0 bottom, from(#b7b7b7), to(#c2c2c2));
      background: -moz-linear-gradient(#b7b7b7, #c2c2c2);
      background: linear-gradient(#b7b7b7, #c2c2c2);
      border: solid 1px #a2a2a2;
      border-bottom: solid 3px #878787;
      box-shadow: inset 0 0 0 1px #d4d4d4; }

    a.button.dark_grey:active {
      background: #afafaf;
      background: -webkit-gradient(linear, 0 0, 0 bottom, from(#afafaf), to(#a9a9a9));
      background: -moz-linear-gradient(#afafaf, #a9a9a9);
      background: linear-gradient(#afafaf, #a9a9a9);
      border: solid 1px #757575;
      box-shadow: inset 0 10px 15px 0 #9a9a9a; }

  </style>
</head>

<body>
<hr>
<form:form action="gamelist/new" method="get">
  <input align="middle" type="submit" value="Add New Game">
</form:form>
<hr>
<table style="width:100%" class="pure-table">
  <c:forEach var="game" items="${gameList}" varStatus="status">
    <tr>
      <td>
        <b>${status.index + 1}.</b>
        </b>
      </td>
      <td>
        Name: <b>${game.title}</b>
        </b>
      </td>
      <td>
        Last Name: <b>${game.studio}</b>
        </b>
      </td>
      <td>
        Release Date: <b>${game.releaseDate}</b>
        </b>
      </td>
      <td>
        In Store: <b>${game.inStore}</b>
        </b>
      </td>
      <td>
        <a href="gamelist/edit?id=${game.idGame}" class="button dark_grey">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="gamelist/delete?id=${game.idGame}" class="button dark_grey">Delete</a>
      </td>
    </tr>
  </c:forEach>

</table>
<hr>
<form method="get" action="gamelist/deleteAll">
  <input type="submit" value="Clear list">
</form>
<br>
<br>
<br>
<form method="get" action="/">
  <input type="submit" value="Go back to menu">
</form>
</body>
</html>

