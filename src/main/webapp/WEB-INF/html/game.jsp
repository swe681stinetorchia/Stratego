<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jonathan.Torchia
  Date: 5/2/2019
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="keywords" content="">

    <title>Game</title>

    <link rel="stylesheet" type="text/css" href="${initParam.siteURL}/styles.css">
    <link rel="stylesheet" type="text/css" href="styles.css">

    <style type="text/css">
    </style>
</head>
</head>
<body>

<a href="${initParam.siteURL}/logout"> Logout </a>

<table width="100%">
<thead></thead>

<tbody>
<tr><th></th><th>${sessionScope.board.col1}</th><th>${sessionScope.board.col2}</th><th>${sessionScope.board.col3}</th><th>${sessionScope.board.col4}</th><th>${sessionScope.board.col5}</th><th>${sessionScope.board.col6}</th><th>${sessionScope.board.col7}</th><th>${sessionScope.board.col8}</th><th>${sessionScope.board.col9}</th><th>${sessionScope.board.col10}</th></tr>
<tr> <th>${sessionScope.board.row1}</th><th><img src =  "${sessionScope.board.sq11}" title="position 1x1" > </th><th><img src = "${sessionScope.board.sq12}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq13}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq14}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq15}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq16}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq17}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq18}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq19}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq110}" title="position 1x10" ></th></tr>
<tr> <th>${sessionScope.board.row2}</th><th><img src = "${sessionScope.board.sq21}" title="position 2x1" > </th><th><img src = "${sessionScope.board.sq22}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq23}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq24}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq25}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq26}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq27}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq28}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq29}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq210}" title="position 1x10" ></th></tr>
<tr> <th>${sessionScope.board.row3}</th><th><img src = "${sessionScope.board.sq31}" title="position 3x1" > </th><th><img src = "${sessionScope.board.sq32}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq33}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq34}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq35}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq36}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq37}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq38}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq39}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq310}" title="position 1x10" ></th></tr>
<tr> <th>${sessionScope.board.row4}</th><th><img src = "${sessionScope.board.sq41}" title="position 4x1" > </th><th><img src = "${sessionScope.board.sq42}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq43}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq44}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq45}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq46}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq47}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq48}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq49}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq410}" title="position 1x10" ></th></tr>
<tr> <th>${sessionScope.board.row5}</th><th><img src = "${sessionScope.board.sq51}" title="position 5x1" > </th><th><img src = "${sessionScope.board.sq52}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq53}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq54}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq55}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq56}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq57}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq58}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq59}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq510}" title="position 1x10" ></th></tr>
<tr> <th>${sessionScope.board.row6}</th><th><img src = "${sessionScope.board.sq61}" title="position 6x1" > </th><th><img src = "${sessionScope.board.sq62}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq63}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq64}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq65}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq66}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq67}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq68}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq69}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq610}" title="position 1x10" ></th></tr>
<tr> <th>${sessionScope.board.row7}</th><th><img src = "${sessionScope.board.sq71}" title="position 7x1" > </th><th><img src = "${sessionScope.board.sq72}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq73}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq74}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq75}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq76}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq77}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq78}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq79}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq710}" title="position 1x10" ></th></tr>
<tr> <th>${sessionScope.board.row8}</th><th><img src = "${sessionScope.board.sq81}" title="position 8x1" > </th><th><img src = "${sessionScope.board.sq82}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq83}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq84}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq85}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq86}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq87}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq88}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq89}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq810}" title="position 1x10" ></th></tr>
<tr> <th>${sessionScope.board.row9}</th><th><img src = "${sessionScope.board.sq91}" title="position 9x1" > </th><th><img src = "${sessionScope.board.sq92}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq93}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq94}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq95}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq96}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq97}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq98}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq99}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq910}" title="position 1x10" ></th></tr>
<tr> <th>${sessionScope.board.row10}</th><th><img src = "${sessionScope.board.sq101}" title="position 10x1" > </th><th><img src = "${sessionScope.board.sq102}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq103}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq104}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq105}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq106}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq107}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq108}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq109}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq1010}" title="position 1x10" ></th></tr>
</tbody>
</table>
<form method="post">
<%--    <input id="token" type="hidden" value="${sessionScope.csrfToken}" />--%>
    <input id="move" type="text"/>
    <input type = "submit" value = "Submit" />
</form>

        <form method="get" action="${initParam.siteURL}/game" class="game">
	        <label>Add Piece</label>
            <input type="hidden" name="action" value="add" />
			<p>Piece Type: <input type="text" name="pieceType" value="" style="width:150px"></p>
			<p>Row: <input type="text" name="row" value="" style="width:150px"></p>
			<p>Column: <input type="text" name="column" value="" style="width:150px"></p>
			<p><input type="submit" name="modGame" value="Submit"></p>
		</form>
        <p>Available Pieces: ${sessionScope.board.availablePieces}</p>

        <form method="get" action="${initParam.siteURL}/game" class="game">
	        <label>Move Piece</label>
            <input type="hidden" name="action" value="move" />
			<p>From Row: <input type="text" name="fromRow" value="" style="width:150px"></p>
			<p>From Column: <input type="text" name="fromColumn" value="" style="width:150px"></p>
			<p>To Row: <input type="text" name="toRow" value="" style="width:150px"></p>
			<p>To Column: <input type="text" name="toColumn" value="" style="width:150px"></p>
			<p><input type="submit" name="modGame" value="Submit"></p>
		</form>

        <c:forEach var="i" begin="1" end="10" step="1">
            <c:out value="${i}" />
            <br />
        </c:forEach>



        <%-- <p>This ${sessionScope.board.availablePieces}</p>
        <p>This ${sessionScope.board.piecesLength}</p>
		<c:forEach var="availablePiece" items="${sessionScope.board.availablePieces}">
            ${availablePiece}<br>
        </c:forEach>--%>
</body>
</html>
