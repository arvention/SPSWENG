<%@page import="Bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="AddAccountBeans.searchEmployeeBean"%>
<html>
<head>
	<link rel="shortcut icon" href="eq logo.ico"/>
	<title> Memo Form - Equilibrium </title>
        <link href = "../css/FileMemo.css" rel = "stylesheet" />
        
        
</head>
<body bgcolor=#E8E8E8>
	<div class = "memoForm">
		<br/><br/><br/><br/><br/>
		<text class= "titleText"> File a Memo </text>
		<br/>
		<div class = "contentText">
		<form action="../SaveMemo" method="POST">
		Memo addressed to:
		<select required name="listEmployees">
                    
                 <% 
                     searchEmployeeBean bean  =(searchEmployeeBean) session.getAttribute("ManagerEmployee");
                     ArrayList<EmployeeBean> list = bean.getSearchResult();
                     
                     for(EmployeeBean emp : list ){
                            
                 %>
                 <option value="<%=emp.getempid()%>" > <%=emp.getlastname()%>, <%=emp.getfirstname()%>  </option>
                <%
                     }
                 %>
                
	
		</select></div>
		<textarea rows="7" cols = "70" name="memoNote" class="memoText" placeholder="Enter text here..."required ></textarea>
		<input type="submit" class="submitButton"/> </form>
                <h6>${errors}</h6>
	</div>
	
	
	<DIV class = "pageBottom" style="margin-bottom: 3px"><hr width ="75%"/></br> EQUILIBRIUM INTERTRADE CORP.</div>
</body>

</html>