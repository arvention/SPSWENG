
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel = "shortcut icon" href= "img/eq logo.ico" />
	<title> EQuilibrium </title>
        <link href = "css/LoginPage.css" rel = "stylesheet" />
	
</head>

<body bgcolor= "#E8E8E8">
	<DIV class = "pageTop"></div>
	<div class = "loginForm" align="center">
	<DIV class = "pageMid" align="center">EQ</div>
	<form action ="Home" method="POST" align="center">
		<p></p>
		<input name ="username" type="text" style="margin-top: 7px" placeholder="Username" id="username" class="inputBox1" required/></br>
		<input name= "password" type="password" placeholder="Password" id="password" class = "inputBox2" required/>
	<div id="button-buttons" align="center">
	<input type="submit" id="login" class="loginButton" value="Log in"/></div>
	</form>
	<a href="#forgotpwd">Forgot your password?</a>
        <div id = "status">${error}</div>
        </div>
       
	<DIV class = "pageBottom" style="margin-bottom: 3px"><hr width ="50%"/></br> EQUILIBRIUM INTERTRADE CORP.</div>
</body>
</html>