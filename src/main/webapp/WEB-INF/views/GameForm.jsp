<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  <title>Game Form</title>
  <style>
    body {
      background-color: lightgray
    }

    b {
      color: green
    }

    h1 {
      color: darkred;
      font-size: 150%;
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

  </style>
</head>
<body>
<div align="center">
  <h1>Game Form</h1>
  <table>
    <form:form action="save" method="post" modelAttribute="game">
      <form:hidden path="idGame"/>
      <tr>
        <td>Title:</td>
        <td><form:input path="title"/></td>
      </tr>
      <tr>
        <td>Studio:</td>
        <td><form:input path="studio"/></td>
      </tr>
      <tr>
        <td>Release Date:</td>
        <td><input id="releaseDate" name="releaseDate" type="date" ></td>
      </tr>
      <tr>
        <td>Left in Store:</td>
        <td><input id="inStore" name="inStore" type="number"></td>
      </tr>

      <tr>
        <td colspan="3" align="center">
          <input type="submit" value="Save">
        </td>
      </tr>

    </form:form>
  </table>
</div>

</body>
</html>

