<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="gamesStore.*" %>
<jsp:useBean id="gamerDao" type="gamesStore.GamerDao" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Games Store</title>
    <style>
        body {
            background-color: lightgray
        }
        hr {
            color: blue
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

    </style>
    <link rel="stylesheet" href="buttonsStyle.css">
</head>

<body>
<form method="post" action="gamer.html">
    Name: <input type="text" placeholder="First name" name="name" value=""/> Last Name: <input type="text" placeholder="Last name"
                                                                      name="lastname" value=""/> <input type="submit"
                                                                                                        name="add"
                                                                                                        value="Add"/>
</form>
<hr>
<table style="width:100%">

    <%
        for (Gamer gamer : gamerDao.loadList()) {
    %>
    <tr>
        <td>
            Id:<b><%=gamer.getIdGamer()%>
        </b>
        </td>
        <td>
            Name:<b><%=gamer.getName()%>
        </b>
        </td>
        <td>
            Last Name: <b><%=gamer.getLastName()%>
        </b>
        </td>
        <td>
            <input type="submit" name="delete<%=gamer.getIdGamer()%>"
                   value="delete"/>
        </td>
    </tr>
    <%
        }
    %>

</table>
<hr>
<form method="POST" action="clear.html">
    <input type="submit" value="Clear list">
</form>
</body>
</html>
