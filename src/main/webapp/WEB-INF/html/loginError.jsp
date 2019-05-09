<!DOCTYPE html>
<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta name="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)">
			<meta name="dcterms.created" content="Tue, 11 Oct 2016 15:07:22 GMT">
			<meta name="description" content="">
			<meta name="keywords" content="">
		
			<title>Error</title>
		
			<link rel="stylesheet" type="text/css" href="${initParam.siteURL}/styles.css">
			<link rel="stylesheet" type="text/css" href="styles.css">
		
			<style type="text/css">
			</style>

	<body>
			<h1>Error
			</h1>
			<hr style="margin:auto; height:1px"/>
	
			<section>
				<p class="errorText">
					You have entered an incorrect username or password. Please try again.
				</p>
	 
				<%--<form method="post" action="${initParam.siteURL}" class="login">
					<p>Username: <input type="text" name="username" value="" style="width:150px"></p>
					<p>Password: <input type="password" name="password" value="" style="width:150px"></p>
					<p><input type="submit" name="loginSubmit" value="Submit"></p>
				</form>--%>

				<form method="post" action="${initParam.siteURL}/login" class="login">
                    <p>Username: <input type="text" name="username" value="" style="width:150px"></p>
                	<p>Password: <input type="password" name="password" value="" style="width:150px"></p>
                	<p><input type="submit" name="loginSubmit" value="Submit"></p>
                </form>
			</section>
	
			<footer >
		   	<p></p>
	   	</footer>
	
	</body>

</html>