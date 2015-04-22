<html>
    <head>
        <title>Home - Equilibrium</title>
         <script src="http://code.jquery.com/jquery-latest.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="shortcut icon" href="img/eq logo.png">
        <link rel="stylesheet" type="text/css" media="all" href="/cssHomepage-HrHead.css"/>

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
                <li><a href= "#">File a Leave</a></li>
                <li><a href= "#">Generate Report</a></li>
		<li><a href= "#">Search</a></li>
                <li><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></li>
            </ul>
        </DIV>	
        <div id="box">
		<span class = "titleText">Leaves for Approval </span>
	<div id="results">
		<div class="result">
			<span class="name">Last Name, First Name</span><br>
			<span class="typeLeave">Type of Leave</span><br>
			<span class="duration">Duration of Leave</span></br></br>
			<button class="approveLeave">Approve</button>
			<button class="declineLeave">Decline</button>
		</div>
		<div class="result">
			<span class="name">Last Name, First Name</span><br>
			<span class="typeLeave">Type of Leave</span><br>
			<span class="duration">Duration of Leave</span></br></br>
			<button class="approveLeave">Approve</button>
			<button class="declineLeave">Decline</button>
		</div>
		<div class="result">
			<span class="name">Last Name, First Name</span><br>
			<span class="typeLeave">Type of Leave</span><br>
			<span class="duration">Duration of Leave</span></br></br>
			<button class="approveLeave">Approve</button>
			<button class="declineLeave">Decline</button>
		</div>
		<div class="result">
			<span class="name">Last Name, First Name</span><br>
			<span class="typeLeave">Type of Leave</span><br>
			<span class="duration">Duration of Leave</span></br></br>
			<button class="approveLeave">Approve</button>
			<button class="declineLeave">Decline</button>
		</div>
		
	</div></div>
	
	<div id="box2">
		<span class = "titleText2">Edits for Approval </span>
	<div id="results">
		<div class="result">
			<span class="name">Last Name, First Name of record edited</span><br>
			<span class="editor">Name of Editor</span><br>
			<span class="edited">Edited data</span><br>
			<span class="timestamp">Timestamp</span></br></br>
			<button class="approveLeave">Approve</button>
			<button class="declineLeave">Decline</button>
		</div>	
		<div class="result">
			<span class="name">Last Name, First Name of record edited</span><br>
			<span class="editor">Name of Editor</span><br>
			<span class="edited">Edited data</span><br>
			<span class="timestamp">Timestamp</span></br></br>
			<button class="approveLeave">Approve</button>
			<button class="declineLeave">Decline</button>
		</div>
		<div class="result">
			<span class="name">Last Name, First Name of record edited</span><br>
			<span class="editor">Name of Editor</span><br>
			<span class="edited">Edited data</span><br>
			<span class="timestamp">Timestamp</span></br></br>
			<button class="approveLeave">Approve</button>
			<button class="declineLeave">Decline</button>
		</div>	
		<div class="result">
			<span class="name">Last Name, First Name of record edited</span><br>
			<span class="editor">Name of Editor</span><br>
			<span class="edited">Edited data</span><br>
			<span class="timestamp">Timestamp</span></br></br>
			<button class="approveLeave">Approve</button>
			<button class="declineLeave">Decline</button>
		</div>	
	</div></div>

       
        <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>

    </body>
</html>
