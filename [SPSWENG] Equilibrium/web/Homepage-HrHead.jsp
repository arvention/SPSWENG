<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - EQuilibrium</title>
        
        <link rel = "shortcut icon" href="eq logo.ico"/>
        <link href = "css/Homepage-HrHead.css" rel = "stylesheet" />
    </head>
    <body bgcolor ="#E8E8E8">
        <div class = "pageTop">
            <IMG class="compLogo" src="img/eqnavlogo.png">
            <hr width = "75%" SIZE = "1"/>
            <p> Welcome, ${employee.getFirstName()} ${employee.getLastName()} </p>
        </div>
        <div class = "pageMid">
            <a href="viewemp.html"><button id="login" class="selectButton"> Manage Employee Records</button></a>
            <a href="CreateAccount/searchEmployeeAccount.html"><button id="login" class="selectButton"> Create Account</button></a>
            <button id="login" class="selectButton"> View Request for Edit</button>
            <button id="login" class="selectButton"> Manage Leaves</button>
        </div>
        <div class ="pageBot">
            <hr width = "75%" SIZE = "1"/>EQUILIBRIUM INTERTRADE CORP.</div>
    </body>
</html>
