
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EQuilibrium</title>
        
        <link href = "css/LoginPage.css" rel = "stylesheet" />

        <script src = "js/LoginPage.js"></script>
    </head>
    <body bgcolor= "#E8E8E8">
        <DIV class = "pageTop"></div>
        <DIV class = "pageMid" align="center"><IMG class ="compLogo" src = "img/eqlogobig.png"></div>
        <form action ="Homepage" method = "post">
            <DIV class = "loginForm" align = "center">
                <p></p>
                <input type="text" name = "username" style="margin-top: 30px" class= "inputBox" placeholder="Username" id="username" required/>
                <input type="password" name = "password" class= "inputBox" placeholder="Password" id="password" required/>
               <div id = "status">${error}</div>
            </div> 
            <div id="button-buttons" align="center">
                <input type="submit" id="login" class="loginButton" value="Login"/></div>
        </form>
        <DIV class = "pageBottom" style="margin-bottom: 3px"><hr width ="50%"/></br> EQUILIBRIUM INTERTRADE CORP.</div>
    </body>
</html>