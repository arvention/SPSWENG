<%@page import="AddAccountBeans.searchEmployeeBean"%>
<%@page import="Bean.employeeSearchResult"%>
<%@page import="java.util.ArrayList"%>


<html>
<head>
	<link rel="shortcut icon" href="eq logo.ico"/>
	<link rel="stylesheet" type="text/css" media="all" href="SearchStyle.css"/>
</head>
<body>
<DIV class ="pageTop">
	<div id="box">
	<div id="results">
	
            
    <%
        searchEmployeeBean bean  =(searchEmployeeBean) session.getAttribute("search");
        ArrayList<employeeSearchResult> collection = bean.getSearchResult();
        
        if(collection.size() ==0){
           %> 
           <h1> NO SEARCH RESULTS </h1>
       <% }
       
        else
        for(employeeSearchResult result : collection ){
        %>
        <div class="result">
            
            
            <form action ="../SaveAccount" method="POST" >
		<span class="name"> <%=result.getlastname()%> ,  <%=result.getfirstname()%> </span><br>
		<span class="idnum"><%=result.getempid() %></span><br>
		<span class="accStatus">No Account</span>
		<select required name="type">
			<option value="sm"> Senior Manager </option>
			<option value="m"> Manager </option>
			<option value ="hr"> HR Employee </option>
			<option selected value="e"> Employee </option>
                        <input type="hidden"  name="entry" value="<%=result.getentrynum()%>">
                      <input type ="submit" value="Add Account">  
                      
		</select>
               
            <form>    
	</div>
	
        <%
        }
       %>
    
           
       
         
            
            
         
	</div>
	</div>
</div>

</body>
</html>
