<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="gamesStore.*"%>
<jsp:useBean id="gamerDao" type="gamesStore.GamerDao" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Games Store</title>
</head>

<body>
	<form method="POST" action="gamer.html">
		Name: <input type="text" name="name" /> Last Name: <input type="text"
			name="lastname" /> <input type="submit" value="Add" />
	</form>
	<hr>
	<ol>
		<%
			for (Gamer gamer : gamerDao.loadList()) {
		%>
		<li><%=gamer.getLastName()+" "+gamer.getName()%></li>
		<%
			}
		%>
	</ol>
	<hr>

</body>
</html>
