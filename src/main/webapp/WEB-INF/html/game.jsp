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

<table width="50%">
<thead></thead>
<tbody>
<tr><th>1</th></tr>
<tr> <img src = "${sq11}" title="position 1x1" > <img src = "${sq12}" title="position 1x2" ><img src = "${sq13}" title="position 1x3" ><img src = "${sq14}" title="position 1x4" ><img src = "${sq15}" title="position 1x5" ><img src = "${sq16}" title="position 1x6" ><img src = "${sq17}" title="position 1x7" ><img src = "${sq18}" title="position 1x8" ><img src = "${sq19}" title="position 1x9" ><img src = "${sq110}" title="position 1x10" ></tr>
    <tr> <th><label id = "sq21"/></th> <th><label id = "sq22"/></th> <th><label id = "sq23"/></th> <th><label id = "sq24"/></th> <th><label id = "sq25"/></th> <th><label id = "sq26"/></th> <th><label id = "sq27"/></th> <th><label id = "sq28"/></th> <th><label id = "sq29"/></th> <th><label id = "sq210"/></th> </tr>
    <tr> <th><label id = "sq31"/></th> <th><label id = "sq32"/></th> <th><label id = "sq33"/></th> <th><label id = "sq34"/></th> <th><label id = "sq35"/></th> <th><label id = "sq36"/></th> <th><label id = "sq37"/></th> <th><label id = "sq38"/></th> <th><label id = "sq39"/></th> <th><label id = "sq310"/></th> </tr>
    <tr> <th><label id = "sq41"/></th> <th><label id = "sq42"/></th> <th><label id = "sq43"/></th> <th><label id = "sq44"/></th> <th><label id = "sq45"/></th> <th><label id = "sq46"/></th> <th><label id = "sq47"/></th> <th><label id = "sq48"/></th> <th><label id = "sq49"/></th> <th><label id = "sq410"/></th> </tr>
    <tr> <th><label id = "sq51"/></th> <th><label id = "sq52"/></th> <th><label id = "sq53"/></th> <th><label id = "sq54"/></th> <th><label id = "sq55"/></th> <th><label id = "sq56"/></th> <th><label id = "sq57"/></th> <th><label id = "sq58"/></th> <th><label id = "sq59"/></th> <th><label id = "sq510"/></th> </tr>
    <tr> <th><label id = "sq61"/></th> <th><label id = "sq62"/></th> <th><label id = "sq63"/></th> <th><label id = "sq64"/></th> <th><label id = "sq65"/></th> <th><label id = "sq66"/></th> <th><label id = "sq67"/></th> <th><label id = "sq68"/></th> <th><label id = "sq69"/></th> <th><label id = "sq610"/></th> </tr>
    <tr> <th><label id = "sq71"/></th> <th><label id = "sq72"/></th> <th><label id = "sq73"/></th> <th><label id = "sq74"/></th> <th><label id = "sq75"/></th> <th><label id = "sq76"/></th> <th><label id = "sq77"/></th> <th><label id = "sq78"/></th> <th><label id = "sq79"/></th> <th><label id = "sq710"/></th> </tr>
    <tr> <th><label id = "sq81"/></th> <th><label id = "sq82"/></th> <th><label id = "sq83"/></th> <th><label id = "sq84"/></th> <th><label id = "sq85"/></th> <th><label id = "sq86"/></th> <th><label id = "sq87"/></th> <th><label id = "sq88"/></th> <th><label id = "sq89"/></th> <th><label id = "sq810"/></th> </tr>
    <tr> <th><label id = "sq91"/></th> <th><label id = "sq92"/></th> <th><label id = "sq93"/></th> <th><label id = "sq94"/></th> <th><label id = "sq95"/></th> <th><label id = "sq96"/></th> <th><label id = "sq97"/></th> <th><label id = "sq98"/></th> <th><label id = "sq99"/></th> <th><label id = "sq910"/></th> </tr>
    <tr> <th><label id = "sq101"/></th> <th><label id = "sq102"/></th> <th><label id = "sq103"/></th> <th><label id = "sq104"/></th> <th><label id = "sq105"/></th> <th><label id = "sq106"/></th> <th><label id = "sq107"/></th> <th><label id = "sq108"/></th> <th><label id = "sq109"/></th> <th><label id = "sq1010"/></th> </tr>
</tbody>
</table>
<form method="post">
<%--    <input id="token" type="hidden" value="${sessionScope.csrfToken}" />--%>
    <input id="move" type="text"/>
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>
