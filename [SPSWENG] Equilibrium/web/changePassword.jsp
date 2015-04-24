<%@page import="Models.modelEmployee"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="navbar.css">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel = "shortcut icon" href="img/eq logo.ico"/>
    <link rel = "stylesheet" type="text/css" href= "css/changePassword.css"/>
    
     <script src="js/jquery-1.11.2.min.js"></script>
      <script src="js/jquery-ui.min.js"></script>
    <title>Change Password - EQuilibrium</title>
    
    <script>
	$(document).ready(function(){
            
            $("#savebutton").click(function() {
                   if($("#newpass").val().length ===0 ){
                       alert("Invalid Password");
                   }

                   else if($("#newpass").val() !== $("#oldpass").val()){
                       alert("Password Does not match");
                   }
                   else if($("#newpass").val() === $("#oldpass").val()){
                       $("#passwordform").submit();
                   }
                   
                });
            
        });
    </script>
</head>
<body>

       <%
	   modelEmployee m = (modelEmployee)session.getAttribute("employee");
            
           if (m.getEmployeeType().equals("Hr Head")){
       %>
                <DIV class= "nav">
            <form method="GET" action="SearchEmployee">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li> 
                <li><a href= "#">Generate Report</a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
            </form>
        </DIV>
        <%
           }
           else if (m.getEmployeeType().equals("Hr Employee")){
               
        %>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li>
                <li><a href= "#">Generate Report</a></li>
                <li><a href= "EmployeeData.jsp">Add Employee Record</a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>
        <% 
           }
           
           else if (m.getEmployeeType().equals("Senior Manager")){
               
        %>
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
        <%       
           }
           
           else if(m.getEmployeeType().equals("Manager")){
        %>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>
        <%
           }
           
           else if (m.getEmployeeType().equals("Employee")){
        %>
        <div class= "nav">
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </div>
        <%
           }
        %>
	<div class= "content" align= "center">
		<span class = "titleText">Change Password</span>
		<hr width= "75%"/>
		<br/><br/>
                <form action="ChangePasswordServlet" method="POST" id="passwordform">
		Current password: <input class= "textLine" input type="password" size="25" name="oldpassword" /> </br></br>
		New password: <input class="textLine" input type="password" size="25" name="newpassword" id="newpass"/></br></br>
		Confirm new password: <input class= "textLine" input type="password" size="25" id="oldpass"/></br></br>
                <div id = "status">${error}</div>
                </form>
                <input class="submitButton" input type= "submit" name="okButton" value="Save Changes" id="savebutton"/>	
                <input class="back" input type= "submit" name="bButton" value="Back"/>
	</div>
	<div class= "footer"><hr width="75%"/>EQUILIBRIUM INTERTRADE CORPORATION</div>
</body>
</html>
