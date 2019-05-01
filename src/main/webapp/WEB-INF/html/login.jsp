<!DOCTYPE html>
<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta name="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)">
			<meta name="dcterms.created" content="Tue, 11 Oct 2016 15:07:22 GMT">
			<meta name="description" content="">
			<meta name="keywords" content="">
			
			<title>eApp Login</title>
		
			<link rel="stylesheet" type="text/css" href="${initParam.siteURL}/styles.css">
			<link rel="stylesheet" type="text/css" href="styles.css">
		
			<style type="text/css">
			</style>
	</head>
	<body>
	   <h1>eApp
			<img src="${initParam.siteURL}/NBIB-logo.png" width="79" height="79" style="vertical-align:middle; margin-right:10px; float:right;">
			</h1>
			<hr style="margin:auto; height:1px"/>
	
			<section>
				<p class="explanation">
					Welcome to eApp, the NBIS portal for clearance form submission. Please login using the
					username and password that were provided to you. If you do not have a username and 
					password, contact your sponsoring agency.
		   	</p>
		   	
		   	<%--
		   	<p>${initParam['siteURL']}</p>
		   	<p>${1+1}</p>
            --%>
            
		   	<form method="post" action="${initParam.siteURL}/servlets" class="login">
					<p>Username: <input type="text" name="username" value="" style="width:150px"></p>
					<p>Password: <input type="password" name="password" value="" style="width:150px"></p>
					<p><input type="submit" name="loginSubmit" value="Submit"></p>
				</form>
		   </section>
	
			<footer>
				<p></p>
			</footer>
	
	</body>

</html>