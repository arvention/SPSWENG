<html>
    <head>
        <title>Home - Equilibrium</title>
         <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel ="shortcut icon" href="img/eq logo.ico">
        <!--<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">-->
        <link rel="stylesheet" href="css/jquery-ui.css"/>
        <!--<script src="//code.jquery.com/jquery-1.10.2.js"></script>-->
        <script src="js/jquery-1.10.2.js"></script>
        <!--<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>-->
        <script src="js/jquery-ui.js"></script>
     
        <link rel="stylesheet" type="text/css" media="all" href="css/Homepage-HrEmployee.css"/>

        <script src="js/HomepageFunc.js"></script>
        
               <script>        
        $(document).ready(function(){
        var sugg = [];
        var search;
       
        
         $("#search").keyup(function() {
           search = $("#search").val();
           search= search.trim();
           console.log("HEREE");
           $.get('AutoCompleteServlet', {keyword: search}, function(responseText) {
                        
                        console.log(responseText);
                        sugg = responseText.split("\n");
                        console.log(sugg);
                       $("#search").autocomplete({
                        source: sugg
                    });
                });
         });
        
        
        });
        </script>
        
        
        
    </head>
    <body color="#e8e8e8">
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li>
                <li><a href= "#">Generate Report</a></li>
                <li><a href= "EmployeeData.jsp">Add Employee Record</a></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>	
        
        <DIV class="search" >
         <form method ="GET" align="center" action="SearchEmployee">
		<IMG class ="compLogo" src = "img/eqboyz.png"/>
		<input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search EQuilibrium"/>
          </form>   
        </DIV>    
        <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>

    </body>
</html>
