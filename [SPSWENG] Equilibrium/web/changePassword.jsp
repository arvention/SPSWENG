<html>
<head>
	<link rel="stylesheet" type="text/css" href="navbar.css">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel = "shortcut icon" href="eq logo.ico"/>
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


	<div class="header">
	</div>
	<div class= "content" align= "center">
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
