<%@page import="Bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="AddAccountBeans.searchEmployeeBean"%>
<html>
<head>
	<link rel="shortcut icon" href="eq logo.ico"/>
	<title> Memo Form - Equilibrium </title>
	<style>
	.memoForm{
		background-color: red;
		border-radius: 16px;
		width:750;
		height: 450;
		opacity: 0.65;
		margin-left: auto;
		margin-right: auto;
	}
	.memoText{
		margin-left: 125px;
		margin-top: 20px;
		font-color: black;
		border: 1px solid black;
		font-family: Arial;
		padding-left: 4px;
	}
	.submitButton{
		width: 75;
		height: 25;
		margin-top: 8px;
		margin-left: 560px;
		cursor: hand;
		color: black;
	}
	.submitButton:hover{
		border: 1.5px solid white;
	}
	.titleText{
		font-size: 35;
		font-family: Arial;
		font-weight: bold;
		color: white;
		margin-left: 125px;
	}
	.contentText{
		font-size: 17;
		font-family: Arial;
		color: white;
		margin-left: 125px;
		margin-top: 8px;
	}
	DIV.pageBottom{
		padding-top: 130px;
		text-align:center;
		color: #808080;
		font-size: 11;
		font-family: "Arial";
	}
	textarea{
		resize:none;
	}
	
	</style>
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
	</div>
	
	
	<DIV class = "pageBottom" style="margin-bottom: 3px"><hr width ="75%"/></br> EQUILIBRIUM INTERTRADE CORP.</div>
</body>

</html>