<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home - Equilibrium</title>
        <link rel="shortcut icon" href="img/eq logo.ico">
        <link rel="stylesheet" type="text/css" media="all" href="css/HomepageStyles.css"/>

        <script src="js/HomepageFunc.js"></script>
    </head>
    <body>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href="changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>	
        <DIV class="notifications">
            <p>This is a sample paragraph inside Notifications.</p>
            <DIV class="searchMan">
                Search for an Employee: <input type="search"/>
            </DIV>
        </DIV>
        <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>

    </body>
</html>