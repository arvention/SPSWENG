<html>
   <head>
     <title>Add Awards</title>
        <link rel="shortcut icon" href="img/eq logo.ico">
	 <link rel="stylesheet" type="text/css" media="all" href="addAwards.css"/>
	 <script src="js/jquery-1.11.2.js"></script>
         
           <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
            <script src="//code.jquery.com/jquery-1.10.2.js"></script>
            <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
            <link rel="stylesheet" href="/resources/demos/style.css">   
 	 <script src="addMiscFilesFunc.js"></script>
         
         <script>
               $(document).ready(function () {
                  
                   $( "#datepicker" ).datepicker();
                   
                   
                    $("#datepicker").keydown(function(e){
                    e.preventDefault();
                    });
                   
                   
                   $( "#datepicker" ).change(function(){
                    
                    var date = $( "#datepicker" ).val();
                    date = date.split('/');
                    
                    console.log(date);
                     
                    
                     var pick = new Date(date[2], date[0]-1, date[1], 0, 0, 0, 0); 
                     var today = new Date();
                     var dd = today.getDate();
                     var mm = today.getMonth()+1; //January is 0!
                     var yyyy = today.getFullYear();
                    
                    if(pick > today){
                        $( "#datepicker" ).val("");
                        alert("Pick only dates before or equal to today");
                    }    

if(dd<10) {
    dd='0'+dd;
} 

if(mm<10) {
    mm='0'+mm;
} 
today = mm+'/'+dd+'/'+yyyy;
console.log(today);
                    
                    console.log(today.getDay());
                    
                    });
                   
                
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
               	<span class="boxText"> Add Award to Employee Record</span>
		<hr width="75%"/>
		<br/>

						                  
                <span class="nameText">Award Name</span>  <input type="text" name="awardname" placeholder="Award Name" class="awardName" required /> <br/><br/>
                <span class="nameText">Date Received</span> <input id="datepicker" class="dateReceived" type="date" name="awardreceive"  required="true" /><br/><br/>                                 
                <textarea rows="7" cols = "70" name="memoNote" class="memoText" placeholder="Enter text here..."></textarea><br/><br/>
                <input type="file" name="filename" class="chooseFile"/>   
		<input class="submitBtn" input type="submit" value="Submit" name="bSubmit" align="center">
                   ${message} 

		</form>
		</DIV>
		
		<DIV class= "footer">
			<hr width="75%"/>
			EQUILIBRIUM INTERTRADE CORP.
		</DIV>              
</body>
</html>>