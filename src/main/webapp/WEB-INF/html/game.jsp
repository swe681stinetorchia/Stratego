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
<script>
    Game game = (Game) session.getAttribute("game");

    String token = (String) session.

    var sq11 = "images/"


    function getValAtLoc(row, col)
    {
        String piece = game.
    }
</script>
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
<%
String token = session.getAttribute("csrfToken");
Game game = session.getAttribute("game");
var sq11 = "images/" + game.getPieceAt(1,1,token) + ".PNG";
var sq12 = "images/" + game.getPieceAt(1,2,token) + ".PNG";
var sq13 = "images/" + game.getPieceAt(1,3,token) + ".PNG";
var sq14 = "images/" + game.getPieceAt(1,4,token) + ".PNG";
var sq15 = "images/" + game.getPieceAt(1,5,token) + ".PNG";
var sq16 = "images/" + game.getPieceAt(1,6,token) + ".PNG";
var sq17 = "images/" + game.getPieceAt(1,7,token) + ".PNG";
var sq18 = "images/" + game.getPieceAt(1,8,token) + ".PNG";
var sq19 = "images/" + game.getPieceAt(1,9,token) + ".PNG";
var sq110 = "images/" + game.getPieceAt(1,10,token) + ".PNG";
var sq21 = "images/" + game.getPieceAt(1,1,token) + ".PNG";
var sq22 = "images/" + game.getPieceAt(1,2,token) + ".PNG";
var sq23 = "images/" + game.getPieceAt(1,3,token) + ".PNG";
var sq24 = "images/" + game.getPieceAt(1,4,token) + ".PNG";
var sq25 = "images/" + game.getPieceAt(1,5,token) + ".PNG";
var sq26 = "images/" + game.getPieceAt(1,6,token) + ".PNG";
var sq27 = "images/" + game.getPieceAt(1,7,token) + ".PNG";
var sq28 = "images/" + game.getPieceAt(1,8,token) + ".PNG";
var sq29 = "images/" + game.getPieceAt(1,9,token) + ".PNG";
var sq210 = "images/" + game.getPieceAt(1,10,token) + ".PNG";
var sq31 = "images/" + game.getPieceAt(1,1,token) + ".PNG";
var sq32 = "images/" + game.getPieceAt(1,2,token) + ".PNG";
var sq33 = "images/" + game.getPieceAt(1,3,token) + ".PNG";
var sq34 = "images/" + game.getPieceAt(1,4,token) + ".PNG";
var sq35 = "images/" + game.getPieceAt(1,5,token) + ".PNG";
var sq36 = "images/" + game.getPieceAt(1,6,token) + ".PNG";
var sq37 = "images/" + game.getPieceAt(1,7,token) + ".PNG";
var sq38 = "images/" + game.getPieceAt(1,8,token) + ".PNG";
var sq39 = "images/" + game.getPieceAt(1,9,token) + ".PNG";
var sq310 = "images/" + game.getPieceAt(1,10,token) + ".PNG";
var sq41 = "images/" + game.getPieceAt(1,1,token) + ".PNG";
var sq42 = "images/" + game.getPieceAt(1,2,token) + ".PNG";
var sq43 = "images/" + game.getPieceAt(1,3,token) + ".PNG";
var sq44 = "images/" + game.getPieceAt(1,4,token) + ".PNG";
var sq45 = "images/" + game.getPieceAt(1,5,token) + ".PNG";
var sq46 = "images/" + game.getPieceAt(1,6,token) + ".PNG";
var sq47 = "images/" + game.getPieceAt(1,7,token) + ".PNG";
var sq48 = "images/" + game.getPieceAt(1,8,token) + ".PNG";
var sq49 = "images/" + game.getPieceAt(1,9,token) + ".PNG";
var sq410 = "images/" + game.getPieceAt(1,10,token) + ".PNG";
var sq51 = "images/" + game.getPieceAt(1,1,token) + ".PNG";
var sq52 = "images/" + game.getPieceAt(1,2,token) + ".PNG";
var sq53 = "images/" + game.getPieceAt(1,3,token) + ".PNG";
var sq54 = "images/" + game.getPieceAt(1,4,token) + ".PNG";
var sq55 = "images/" + game.getPieceAt(1,5,token) + ".PNG";
var sq56 = "images/" + game.getPieceAt(1,6,token) + ".PNG";
var sq57 = "images/" + game.getPieceAt(1,7,token) + ".PNG";
var sq58 = "images/" + game.getPieceAt(1,8,token) + ".PNG";
var sq59 = "images/" + game.getPieceAt(1,9,token) + ".PNG";
var sq510 = "images/" + game.getPieceAt(1,10,token) + ".PNG";
var sq61 = "images/" + game.getPieceAt(1,1,token) + ".PNG";
var sq62 = "images/" + game.getPieceAt(1,2,token) + ".PNG";
var sq63 = "images/" + game.getPieceAt(1,3,token) + ".PNG";
var sq64 = "images/" + game.getPieceAt(1,4,token) + ".PNG";
var sq65 = "images/" + game.getPieceAt(1,5,token) + ".PNG";
var sq66 = "images/" + game.getPieceAt(1,6,token) + ".PNG";
var sq67 = "images/" + game.getPieceAt(1,7,token) + ".PNG";
var sq68 = "images/" + game.getPieceAt(1,8,token) + ".PNG";
var sq69 = "images/" + game.getPieceAt(1,9,token) + ".PNG";
var sq610 = "images/" + game.getPieceAt(1,10,token) + ".PNG";
var sq71 = "images/" + game.getPieceAt(1,1,token) + ".PNG";
var sq72 = "images/" + game.getPieceAt(1,2,token) + ".PNG";
var sq73 = "images/" + game.getPieceAt(1,3,token) + ".PNG";
var sq74 = "images/" + game.getPieceAt(1,4,token) + ".PNG";
var sq75 = "images/" + game.getPieceAt(1,5,token) + ".PNG";
var sq76 = "images/" + game.getPieceAt(1,6,token) + ".PNG";
var sq77 = "images/" + game.getPieceAt(1,7,token) + ".PNG";
var sq78 = "images/" + game.getPieceAt(1,8,token) + ".PNG";
var sq79 = "images/" + game.getPieceAt(1,9,token) + ".PNG";
var sq710 = "images/" + game.getPieceAt(1,10,token) + ".PNG";
var sq81 = "images/" + game.getPieceAt(1,1,token) + ".PNG";
var sq82 = "images/" + game.getPieceAt(1,2,token) + ".PNG";
var sq83 = "images/" + game.getPieceAt(1,3,token) + ".PNG";
var sq84 = "images/" + game.getPieceAt(1,4,token) + ".PNG";
var sq85 = "images/" + game.getPieceAt(1,5,token) + ".PNG";
var sq86 = "images/" + game.getPieceAt(1,6,token) + ".PNG";
var sq87 = "images/" + game.getPieceAt(1,7,token) + ".PNG";
var sq88 = "images/" + game.getPieceAt(1,8,token) + ".PNG";
var sq89 = "images/" + game.getPieceAt(1,9,token) + ".PNG";
var sq810 = "images/" + game.getPieceAt(1,10,token) + ".PNG";
var sq91 = "images/" + game.getPieceAt(1,1,token) + ".PNG";
var sq92 = "images/" + game.getPieceAt(1,2,token) + ".PNG";
var sq93 = "images/" + game.getPieceAt(1,3,token) + ".PNG";
var sq94 = "images/" + game.getPieceAt(1,4,token) + ".PNG";
var sq95 = "images/" + game.getPieceAt(1,5,token) + ".PNG";
var sq96 = "images/" + game.getPieceAt(1,6,token) + ".PNG";
var sq97 = "images/" + game.getPieceAt(1,7,token) + ".PNG";
var sq98 = "images/" + game.getPieceAt(1,8,token) + ".PNG";
var sq99 = "images/" + game.getPieceAt(1,9,token) + ".PNG";
var sq910 = "images/" + game.getPieceAt(1,10,token) + ".PNG";
var sq101 = "images/" + game.getPieceAt(10,1,token) + ".PNG";
var sq102 = "images/" + game.getPieceAt(10,2,token) + ".PNG";
var sq103 = "images/" + game.getPieceAt(10,3,token) + ".PNG";
var sq104 = "images/" + game.getPieceAt(10,4,token) + ".PNG";
var sq105 = "images/" + game.getPieceAt(10,5,token) + ".PNG";
var sq106 = "images/" + game.getPieceAt(10,6,token) + ".PNG";
var sq107 = "images/" + game.getPieceAt(10,7,token) + ".PNG";
var sq108 = "images/" + game.getPieceAt(10,8,token) + ".PNG";
var sq109 = "images/" + game.getPieceAt(10,9,token) + ".PNG";
var sq1010 = "images/" + game.getPieceAt(10,10,token) + ".PNG";
%>

<table width="100%">
<thead></thead>
<tbody>
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
</tbody>
</table>
<form method="post">
<%--    <input id="token" type="hidden" value="${sessionScope.csrfToken}" />--%>
    <input id="move" type="text"/>
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
