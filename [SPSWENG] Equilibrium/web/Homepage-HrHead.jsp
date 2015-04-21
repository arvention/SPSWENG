<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home - Equilibrium</title>
         <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="shortcut icon" href="img/eqboyz.png">
        <link rel="stylesheet" type="text/css" media="all" href= "css/HomepageStyles.css"/>

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
    <body>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href="#">Employees</a></li>
                <li><a href= "#">File a Leave</a></li>
                <li><a href= "#"><input class="report" type="button" value="Generate Report"/></a></li>
                <form method="GET" action="SearchEmployee" style="display: inline;">
                <li><input id="search" name="searchbox" type="search" class="searchBox" placeholder="Search Employee"></li>
                </form>
                <li><img class= "logo" src= "img/eqboyz.png" height="55px"/></li>
            </ul>
        </DIV>	
        <DIV class="notifications">
            <p>This is a sample paragraph inside Notifications.</p>
        </DIV>
        <DIV class="trail">
            <p>This is a sample content in Audit Trail</p>
        </DIV>
       
        <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>

    </body>
</html>
