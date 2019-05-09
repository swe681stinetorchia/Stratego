<%--
  Created by IntelliJ IDEA.
  User: Jonathan.Torchia
  Date: 5/2/2019
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Home</title>
</head>
<body>
<%
    String message = "";
    Object mesObj = session.getAttribute("message");
    if (mesObj != null)
    {
        message = (String) mesObj;
    }
%>

	<a href="${initParam.siteURL}/logout"> Logout </a>

	<p>
	<br>
	<br>
	    ${message}
	<br>
	<br>
	<p>
	
	<%--<form method="get" action="${initParam.siteURL}/game" class="openGame">
	    <label>Open existing game.</label>
        <input type="hidden" name="action" value="open" />
		<p>Game Id: <input type="text" name="gameId" value="" style="width:150px"></p>
		<p><input type="submit" name="openGame" value="Submit"></p>
	</form>--%>


	<p>Ongoing Games</p>

	<c:forEach var="entry" items="${requestScope.view.ongoingGames}">
      Key: <c:out value="${entry.key}"/>
      Value: <c:out value="${entry.value}"/>
    </c:forEach>


    <p>Ongoing Games 2</p>

	<c:forEach var="entry" items="${requestScope.view.ongoingGames}">
      <form method="get" action="${initParam.siteURL}/game" class="openGame">
        <input type="hidden" name="action" value="open" />
        <input type="hidden" name="gameId" value="${entry.value}">
        <p><input type="submit" name="openGame" value="${entry.key}"></p>
      </form>
    </c:forEach>

	<form method="post" action="${initParam.siteURL}/game" class="newGame">
	    <label>Start new game.</label>
		<p>Opponent: <input type="text" name="opponent" value="" style="width:150px"></p>
		<p><input type="submit" name="newGame" value="Submit"></p>
	</form>

<p>Moves History for Completed Games:</p>
<c:forEach var="moveHistory" items="${moveHistory}">
    <td>
        <c:out value="${moveHistory}" />
    </td>
</c:forEach>
</body>
</html>
