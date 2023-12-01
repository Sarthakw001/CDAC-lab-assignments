<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Process Form</title>
</head>
<jsp:setProperty property="*" name="player"/>
<body>
<%--Invoke PlayerBean's method and display mesg--%>
<h2> Status mesg : ${sessionScope.player.validateAndAddPlayer()}</h2>
</body>
</html>