
<%@page import="java.util.ArrayList"%>
<%@page import="Models.modelEmployee"%>

<html>
    <head>
	<link rel="shortcut icon" href="img/eq logo.ico"/>
	<link rel="stylesheet" type="text/css" media="all" href="css/SearchEmployee.css"/>    
    
    <%
      
      
        
       
     %>   
    
    
    </head>
    <body>
        <DIV class ="pageTop">
            <div id="box">
                <div id="results">
                    <%
                        ArrayList<modelEmployee> modelEmployees  = (ArrayList<modelEmployee>)session.getAttribute("searchResult");
                        
                        if(modelEmployees.size() ==0){
                    %> 
                    <h1> NO SEARCH RESULTS </h1>
                    <% }else
                        for(modelEmployee result : modelEmployees ){
                    %>
                    <div class="result">
                        <form action ="SaveAccount" method="POST" >
                            <span class="name"> <%=result.getLastName()%>, <%=result.getFirstName()%> </span><br>
                            <span class="idnum"><%=result.getEmployeeID() %></span><br>
                            <span class="accStatus">No Account</span>
                            <select required name="type">
                                <option value="Senior Manager"> Senior Manager </option>
                                <option value="Manager"> Manager </option>
                                <option value="HR Head"> HR Head </option>
                                <option value ="HR Employee"> HR Employee </option>
                                <option selected value="Employee"> Employee </option>
                                <input type="hidden"  name="entry" value="<%=result.getEntryNum()%>">
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
