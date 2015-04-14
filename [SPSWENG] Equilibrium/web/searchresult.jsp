<%@page import="java.util.ArrayList"%>
<%@page import="Models.modelEmployee"%>
<%@page import="ClassHelpers.SearchResult"%>
<html>
<head>
	<link rel="shortcut icon" href="eq logo.ico"/>
	<link rel="stylesheet" type="text/css" media="all" href= "css/SearchStyle.css"/>
        <script src= "js/jquery-1.11.2.js"></script>
        
        <%
            SearchResult sr =(SearchResult) session.getAttribute("searchresult");
            ArrayList<modelEmployee> me = sr.getResult();
        %>
        
        <script>
        $(document).ready(function(){
          $(".filememo").click(function() {
           
            var id = $(this).closest("div").attr("val");   
              $("#numberofid").val(id);
              $("#go").submit();
          });   
        });
        </script>
        
        
        
</head>
<body>
<DIV class ="pageTop">
	<div id="box">
	<div id="results">
        
        <form id="go" method="POST" action="SelectEmployeeServlet">
        <input id ="numberofid" name="idnumber" type="hidden" value="">
        <input name="type"type="hidden" value="file">
        </form>   
            
        <%for(modelEmployee e: me ){  
            
        %>    
	<div class="result" val="<%=e.getEmployeeID()%>">
		<span class="name"><%=e.getLastName()%>, <%=e.getFirstName()%></span><br>
		<span class="idnum"><%=e.getEmployeeID()%></span><br>
		
                <%if( e.getPassword()== null){%>
                <span class="accStatus">No Account</span>
                <select required name="type">
		<option> Senior Manager </option>
		<option> Manager </option>
		<option> HR Employee </option>
		<option selected> Employee </option>
		</select>
                
                <button class="addAccount">Add Account</button>
                
                <%}else{%>
                <span class="accStatus">Has Account</span>
                <%}%>
		<button class="addAccount">Add Award</button>
                <button class="filememo">File Memo</button>
                
	</div>
         <%}%>   
            
            <!--
	<div class="result">
		<span class="name">Last Name, First Name</span><br>
		<span class="idnum">11223300</span><br>
		<span class="accStatus">Has Account</span>
		<button class="addAccount">Add Award</button>
		<button class="addAccount">File Memo</button>
	</div>
	<div class="result">
		<span class="name">Last Name, First Name</span><br>
		<span class="idnum">11223300</span><br>
		<span class="accStatus">No Account</span>
		<select required name="type">
			<option> Senior Manager </option>
			<option> Manager </option>
			<option> HR Employee </option>
			<option selected> Employee </option>
		</select>
		<button class="addAccount">Add Account</button>
		<button class="addAccount">Add Award</button>
		<button class="addAccount">File Memo</button>
	</div>
	<div class="result">
		<span class="name">Last Name, First Name</span><br>
		<span class="idnum">11223300</span><br>
		<span class="accStatus">No Account</span>
		<select required name="type">
			<option> Senior Manager </option>
			<option> Manager </option>
			<option> HR Employee </option>
			<option selected> Employee </option>
		</select>
		<button class="addAccount">Add Account</button>
		<button class="addAccount">Add Award</button>
		<button class="addAccount">File Memo</button>
	</div>
	<div class="result">
		<span class="name">Last Name, First Name</span><br>
		<span class="idnum">11223300</span><br>
		<span class="accStatus">Has Account</span>
		<button class="addAccount">Add Award</button>
		<button class="addAccount">File Memo</button>
	</div>
	<div class="result">
		<span class="name">Last Name, First Name</span><br>
		<span class="idnum">11223300</span><br>
		<span class="accStatus">No Account</span>
		<select required name="type">
			<option> Senior Manager </option>
			<option> Manager </option>
			<option> HR Employee </option>
			<option selected> Employee </option>
		</select>
		<button class="addAccount">Add Account</button>
		<button class="addAccount">Add Award</button>
		<button class="addAccount">File Memo</button>
	</div>
	<div class="result">
		<span class="name">Last Name, First Name</span><br>
		<span class="idnum">11223300</span><br>
		<span class="accStatus">No Account</span>
		<button class="addAccount">Add Account</button>
		<button class="addAccount">Add Award</button>
		<button class="addAccount">File Memo</button>
	</div>
	<div class="result">
		<span class="name">Last Name, First Name</span><br>
		<span class="idnum">11223300</span><br>
		<span class="accStatus">Has Account</span>
		<button class="addAccount">Add Award</button>
		<button class="addAccount">File Memo</button>
	</div>
	<div class="result">
		<span class="name">Last Name, First Name</span><br>
		<span class="idnum">11223300</span><br>
		<span class="accStatus">No Account</span>
		<select required name="type">
			<option> Senior Manager </option>
			<option> Manager </option>
			<option> HR Employee </option>
			<option selected> Employee </option>
		</select>
		<button class="addAccount">Add Account</button>
		<button class="addAccount">Add Award</button>
		<button class="addAccount">File Memo</button>
	</div>
	</div>
	</div>
            -->
            
</div>
 
</body>
</html>
