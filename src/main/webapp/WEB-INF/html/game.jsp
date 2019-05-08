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

    <title>eApp Login</title>

    <link rel="stylesheet" type="text/css" href="${initParam.siteURL}/styles.css">
    <link rel="stylesheet" type="text/css" href="styles.css">

    <style type="text/css">
    </style>
</head>
<%--<script>
    function addPieceImageToLocation(locationId, imagePath)
    {
        document.getElementById(locationId).src=imagePath;
    }
    function removePieceImageFromLocation(locationId)
    {
        document.getElementById(locationId).src="images/blank.PNG";
    }
</script>--%>
</head>
<body>

<table width="100%">
<thead></thead>
<%--<tbody>
<tr><th></th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th>10</th></tr>
<tr> <th>1</th><img src = "${sq11}" title="position 1x1" > <img src = "${sq12}" title="position 1x2" ><img src = "${sq13}" title="position 1x3" ><img src = "${sq14}" title="position 1x4" ><img src = "${sq15}" title="position 1x5" ><img src = "${sq16}" title="position 1x6" ><img src = "${sq17}" title="position 1x7" ><img src = "${sq18}" title="position 1x8" ><img src = "${sq19}" title="position 1x9" ><img src = "${sq110}" title="position 1x10" ></tr>
<tr> <th>2</th><img src = "${sq21}" title="position 2x1" > <img src = "${sq22}" title="position 1x2" ><img src = "${sq23}" title="position 1x3" ><img src = "${sq24}" title="position 1x4" ><img src = "${sq25}" title="position 1x5" ><img src = "${sq26}" title="position 1x6" ><img src = "${sq27}" title="position 1x7" ><img src = "${sq28}" title="position 1x8" ><img src = "${sq29}" title="position 1x9" ><img src = "${sq210}" title="position 1x10" ></tr>
<tr> <th>3</th><img src = "${sq31}" title="position 3x1" > <img src = "${sq32}" title="position 1x2" ><img src = "${sq33}" title="position 1x3" ><img src = "${sq34}" title="position 1x4" ><img src = "${sq35}" title="position 1x5" ><img src = "${sq36}" title="position 1x6" ><img src = "${sq37}" title="position 1x7" ><img src = "${sq38}" title="position 1x8" ><img src = "${sq39}" title="position 1x9" ><img src = "${sq310}" title="position 1x10" ></tr>
<tr> <th>4</th><img src = "${sq41}" title="position 4x1" > <img src = "${sq42}" title="position 1x2" ><img src = "${sq43}" title="position 1x3" ><img src = "${sq44}" title="position 1x4" ><img src = "${sq45}" title="position 1x5" ><img src = "${sq46}" title="position 1x6" ><img src = "${sq47}" title="position 1x7" ><img src = "${sq48}" title="position 1x8" ><img src = "${sq49}" title="position 1x9" ><img src = "${sq410}" title="position 1x10" ></tr>
<tr> <th>5</th><img src = "${sq51}" title="position 5x1" > <img src = "${sq52}" title="position 1x2" ><img src = "${sq53}" title="position 1x3" ><img src = "${sq54}" title="position 1x4" ><img src = "${sq55}" title="position 1x5" ><img src = "${sq56}" title="position 1x6" ><img src = "${sq57}" title="position 1x7" ><img src = "${sq58}" title="position 1x8" ><img src = "${sq59}" title="position 1x9" ><img src = "${sq510}" title="position 1x10" ></tr>
<tr> <th>6</th><img src = "${sq61}" title="position 6x1" > <img src = "${sq62}" title="position 1x2" ><img src = "${sq63}" title="position 1x3" ><img src = "${sq64}" title="position 1x4" ><img src = "${sq65}" title="position 1x5" ><img src = "${sq66}" title="position 1x6" ><img src = "${sq67}" title="position 1x7" ><img src = "${sq68}" title="position 1x8" ><img src = "${sq69}" title="position 1x9" ><img src = "${sq610}" title="position 1x10" ></tr>
<tr> <th>7</th><img src = "${sq71}" title="position 7x1" > <img src = "${sq72}" title="position 1x2" ><img src = "${sq73}" title="position 1x3" ><img src = "${sq74}" title="position 1x4" ><img src = "${sq75}" title="position 1x5" ><img src = "${sq76}" title="position 1x6" ><img src = "${sq77}" title="position 1x7" ><img src = "${sq78}" title="position 1x8" ><img src = "${sq79}" title="position 1x9" ><img src = "${sq710}" title="position 1x10" ></tr>
<tr> <th>8</th><img src = "${sq81}" title="position 8x1" > <img src = "${sq82}" title="position 1x2" ><img src = "${sq83}" title="position 1x3" ><img src = "${sq84}" title="position 1x4" ><img src = "${sq85}" title="position 1x5" ><img src = "${sq86}" title="position 1x6" ><img src = "${sq87}" title="position 1x7" ><img src = "${sq88}" title="position 1x8" ><img src = "${sq89}" title="position 1x9" ><img src = "${sq810}" title="position 1x10" ></tr>
<tr> <th>9</th><img src = "${sq91}" title="position 9x1" > <img src = "${sq92}" title="position 1x2" ><img src = "${sq93}" title="position 1x3" ><img src = "${sq94}" title="position 1x4" ><img src = "${sq95}" title="position 1x5" ><img src = "${sq96}" title="position 1x6" ><img src = "${sq97}" title="position 1x7" ><img src = "${sq98}" title="position 1x8" ><img src = "${sq99}" title="position 1x9" ><img src = "${sq910}" title="position 1x10" ></tr>
<tr> <th>10</th><img src = "${sq101}" title="position 10x1" > <img src = "${sq102}" title="position 1x2" ><img src = "${sq103}" title="position 1x3" ><img src = "${sq104}" title="position 1x4" ><img src = "${sq105}" title="position 1x5" ><img src = "${sq106}" title="position 1x6" ><img src = "${sq107}" title="position 1x7" ><img src = "${sq108}" title="position 1x8" ><img src = "${sq109}" title="position 1x9" ><img src = "${sq1010}" title="position 1x10" ></tr>
</tbody>--%>

<tbody>
<tr><th></th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th>10</th></tr>
<tr> <th>1</th><th><img src =  "${sessionScope.board.sq12}" title="position 1x1" > </th><th><img src = "${sessionScope.board.sq12}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq13}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq14}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq15}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq16}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq17}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq18}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq19}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq110}" title="position 1x10" ></th></tr>
<tr> <th>2</th><th><img src = "${sessionScope.board.sq21}" title="position 2x1" > </th><th><img src = "${sessionScope.board.sq22}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq23}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq24}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq25}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq26}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq27}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq28}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq29}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq210}" title="position 1x10" ></th></tr>
<tr> <th>3</th><th><img src = "${sessionScope.board.sq31}" title="position 3x1" > </th><th><img src = "${sessionScope.board.sq32}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq33}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq34}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq35}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq36}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq37}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq38}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq39}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq310}" title="position 1x10" ></th></tr>
<tr> <th>4</th><th><img src = "${sessionScope.board.sq41}" title="position 4x1" > </th><th><img src = "${sessionScope.board.sq42}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq43}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq44}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq45}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq46}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq47}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq48}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq49}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq410}" title="position 1x10" ></th></tr>
<tr> <th>5</th><th><img src = "${sessionScope.board.sq51}" title="position 5x1" > </th><th><img src = "${sessionScope.board.sq52}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq53}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq54}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq55}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq56}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq57}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq58}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq59}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq510}" title="position 1x10" ></th></tr>
<tr> <th>6</th><th><img src = "${sessionScope.board.sq61}" title="position 6x1" > </th><th><img src = "${sessionScope.board.sq62}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq63}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq64}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq65}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq66}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq67}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq68}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq69}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq610}" title="position 1x10" ></th></tr>
<tr> <th>7</th><th><img src = "${sessionScope.board.sq71}" title="position 7x1" > </th><th><img src = "${sessionScope.board.sq72}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq73}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq74}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq75}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq76}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq77}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq78}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq79}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq710}" title="position 1x10" ></th></tr>
<tr> <th>8</th><th><img src = "${sessionScope.board.sq81}" title="position 8x1" > </th><th><img src = "${sessionScope.board.sq82}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq83}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq84}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq85}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq86}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq87}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq88}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq89}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq810}" title="position 1x10" ></th></tr>
<tr> <th>9</th><th><img src = "${sessionScope.board.sq91}" title="position 9x1" > </th><th><img src = "${sessionScope.board.sq92}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq93}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq94}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq95}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq96}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq97}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq98}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq99}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq910}" title="position 1x10" ></th></tr>
<tr> <th>10</th><th><img src = "${sessionScope.board.sq101}" title="position 10x1" > </th><th><img src = "${sessionScope.board.sq102}" title="position 1x2" ></th><th><img src = "${sessionScope.board.sq103}" title="position 1x3" ></th><th><img src = "${sessionScope.board.sq104}" title="position 1x4" ></th><th><img src = "${sessionScope.board.sq105}" title="position 1x5" ></th><th><img src = "${sessionScope.board.sq106}" title="position 1x6" ></th><th><img src = "${sessionScope.board.sq107}" title="position 1x7" ></th><th><img src = "${sessionScope.board.sq108}" title="position 1x8" ></th><th><img src = "${sessionScope.board.sq109}" title="position 1x9" ></th><th><img src = "${sessionScope.board.sq1010}" title="position 1x10" ></th></tr>
</tbody>
</table>
<form method="post">
<%--    <input id="token" type="hidden" value="${sessionScope.csrfToken}" />--%>
    <input id="move" type="text"/>
    <input type = "submit" value = "Submit" />
</form>

        <form method="put" action="${initParam.siteURL}/game" class="game">
	        <label>Add Piece</label>
			<p>Piece Type: <input type="text" name="pieceType" value="" style="width:150px"></p>
			<p>Row: <input type="text" name="row" value="" style="width:150px"></p>
			<p>Column: <input type="text" name="column" value="" style="width:150px"></p>
			<p><input type="submit" name="modGame" value="Submit"></p>
		</form>

        <form method="put" action="${initParam.siteURL}/game" class="game">
	        <label>Move Piece</label>
			<p>From Row: <input type="text" name="fromRow" value="" style="width:150px"></p>
			<p>From Column: <input type="text" name="fromXolumn" value="" style="width:150px"></p>
			<p>To Row: <input type="text" name="toRow" value="" style="width:150px"></p>
			<p>To Column: <input type="text" name="toColumn" value="" style="width:150px"></p>
			<p><input type="submit" name="modGame" value="Submit"></p>
		</form>
</body>
</html>
