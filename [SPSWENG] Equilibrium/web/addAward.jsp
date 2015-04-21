<html>
   <head>
     <title>Add Awards</title>
        <link rel="shortcut icon" href="img/eq logo.ico">
	 <link rel="stylesheet" type="text/css" media="all" href="addMiscFilesStyle.css"/>
	 <script src="js/jquery-1.11.2.js"></script>
         
           <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
            <script src="//code.jquery.com/jquery-1.10.2.js"></script>
            <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
            <link rel="stylesheet" href="/resources/demos/style.css">   
 	 <script src="addMiscFilesFunc.js"></script>
         
         <script>
              $(document).ready(function () {
                  
                   $( "#datepicker" ).datepicker();
                   
                
             });
         </script>    
             
         
   </head>
   <body>
<DIV class= "nav">
	        <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
			<ul>
				<li><a href= "#">Log Out</a></li>
				<li><a href= "#">Announcements</a></li>
				<li><a href= "#">Home</a></li>
				<li><img class= "logo" src= "eqboyz.png"/></li>
			</ul>
		</DIV>
		<DIV class="content">
		<form action="SaveAward" method="POST" enctype="multipart/form-data">
                <span>Attach soft copies of awards that is pertinent to this employee record</span><br/>
		<br/>
						          
                Award Name  <input type="text" name="awardname" placeholder="Award Name" required /> <br>
                Date Received <input id="datepicker" type="date" name="awardreceive" placeholder="Date Received" readonly="true"> <br/>
                <input type="file" name="filename" placeholder="File Name here"/>                                             
                <textarea rows="7" cols = "70" name="memoNote" class="memoText" placeholder="Enter text here..."></textarea>
                <input class="back" input type="submit" value="Submit" name="bSubmit" align="center">
                   ${message} 
		</form>
		</DIV>
		
		<DIV class= "footer">
			<hr width="75%"/>
			EQUILIBRIUM INTERTRADE CORP.
		</DIV>                   