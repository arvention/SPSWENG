<%@page import="AddAccountBeans.searchEmployeeBean"%>
<%@page import="Bean.EmployeeBean"%>
<%@page import="Bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>


<html>
<head>
	<link rel="shortcut icon" href="eq logo.ico"/>
	<link rel="stylesheet" type="text/css" media="all" href="../css/SearchEmployee.css"/>
        
</head>
<body>
<DIV class ="pageTop">
	<div id="box">
	<div id="results">
	
            
    <%
        searchEmployeeBean bean  =(searchEmployeeBean) session.getAttribute("search");
        ArrayList< EmployeeBean > collection = bean.getSearchResult();
        
        if(collection.size() ==0){
           %> 
           <h1> NO SEARCH RESULTS </h1>
       <% }
       
        else
        for(EmployeeBean result : collection ){
        %>
        <div class="result">
            
            
            <form action ="../SaveAccount" method="POST" >
		<span class="name"> <%=result.getlastname()%> ,  <%=result.getfirstname()%> </span><br>
		<span class="idnum"><%=result.getempid() %></span><br>
		<span class="accStatus">No Account</span>
		<select required name="type">
			<option value="seniormanager"> Senior Manager </option>
			<option value="manager"> Manager </option>
                        <option value="hrhead"> HR Head </option>
			<option value ="hremployee"> HR Employee </option>
			<option selected value="employee"> Employee </option>
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
