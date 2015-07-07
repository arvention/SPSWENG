<%@page import="Models.modelEmployee"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Database.Database"%>
<%@page import="java.io.*"%>
<html>
<head>
    <link rel="shortcut icon" href="img/eq logo.ico"/>
    <link rel="stylesheet" href="css/generateReport.css">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <title>Generate Report - EQuilibrium </title>

      <link rel="stylesheet" href="css/jquery-ui.css"/>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script>
            $(document).ready(function () {
                var sugg = [];
                var search;


                $("#search").keyup(function () {
                    search = $("#search").val();
                    search = search.trim();
                    console.log("HEREE");
                    $.get('AutoCompleteServlet', {keyword: search}, function (responseText) {

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
    
    <%
        Database db = Database.getInstance();
        int[] years = db.getYearSpan();
        int min = years[0], max = years[1];
    %>
    
    <script>
        function makeTableScroll() {
            // Constant retrieved from server-side via JSP
            var maxRows = 15;

            var table = document.getElementById('reportTable');
            var wrapper = table.parentNode;
            var rowsInTable = table.rows.length;
            var height = 0;
            if (rowsInTable > maxRows) {
                for (var i = 0; i < maxRows; i++) {
                    height += table.rows[i].clientHeight;
                }
                wrapper.style.height = height + "px";
            }
        }
    </script>
    <script>
        $(document).ready(function(){
            var currDate = new Date();
            var month = currDate.getMonth()+1;
            $("#month").find("option[value="+month+"]").attr("selected", true);
            reloadEntries();
            
            $(document).on("change", "#month", function() {
                reloadEntries();
            });
            
            $(document).on("change", "#year", function() {
                reloadEntries();
            });
            
            function reloadEntries() {
                $(".entry").remove();
                var month = $("#month").val();
                var year = $("#year").text();
                $.post("GenerateReport", {m: month, y: year}, function(x){
                    $("#reportTable").append(x);
                });
            }
        });
    </script>
    <script>
        function getFile(){
            <%
                String str = "print me";
                //always give the path from root. This way it almost always works.
                String textFile = "C:/Users/User/Desktop/koya.csv";
                try {
                    FileWriter fw = new FileWriter(textFile);
                    fw.append(str);
                    fw.append(",");
                    fw.append("Ye");
                    //clean up
                    fw.flush();
                    fw.close();
                    } catch(IOException e) {
                        out.println(e.getMessage());
                    }
            %>
        }
    </script>
</head>
<body onload="makeTableScroll();">
	
   <%
	   modelEmployee m = (modelEmployee)session.getAttribute("employee");
            
           if (m.getEmployeeType().equals("Hr Head")){
       %>
                <DIV class= "nav">
            <form method="GET" action="SearchEmployee">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li> 
                <li><a href= "GenerateReport.jsp"><span class="selectText">Generate Report</span></a></li>
                <li><a href= "EmployeeData.jsp"><span class="selectText">Add Employee Record</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                <li><a href="Homepage-HrHead.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
            </form>
        </DIV>
        <%
           }
           else if (m.getEmployeeType().equals("Hr Employee")){
               
        %>
        <DIV class= "nav">
         <form method="GET" action="SearchEmployee">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href= "changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li> 
                <li><a href= "GenerateReport.jsp"><span class="selectText">Generate Report</span></a></li>
                <li><a href= "EmployeeData.jsp"><span class="selectText">Add Employee Record</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                <li><a href="Homepage-HrEmployee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
            </form>
        </DIV>
        <% 
           }
           
           else if (m.getEmployeeType().equals("Senior Manager")){
               
        %>
        <DIV class= "nav">
         <form method="GET" action="SearchEmployee">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href="changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li>
                <li><input name="searchbox" class="searchBox" id="search" type="search" placeholder="Search Employee Records"/></li>
                <li><a href="Homepage-SManager.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
            </form>
        </DIV>
        <%       
           }
           
           else if(m.getEmployeeType().equals("Manager")){
        %>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href="changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                <li><a href= "LeaveForm.jsp"><span class="selectText">File a Leave</span></a></li>
                <li><a href="Homepage-Manager.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </DIV>
        <%
           }
           
           else if (m.getEmployeeType().equals("Employee")){
        %>
        <div class= "nav">
            <ul>
                <li><a href= "Logout"><span class="selectText">Log Out</span></a></li>
                <li><a href="changePassword.jsp"><span class="selectText">Change Password</span></a></li>
                
                <li><a href="Homepage-Employee.jsp"><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></a></li>
            </ul>
        </div>
        <%
           }
        %>        

    <span class="titleText">Monthly Leave Report</span>
        
    <div id = "box" align="center">
    <div class="scrollingTable">
        <table id="reportTable">
    <tr>
        <th> Employee Name </th>
        <th> Leaves Taken </th>
        <th> Leaves Left </th>
    </tr>
        </table>	
    </div>
    		<br/>
		Month
		<select id="month" name="month">
                    <option value="1">January</option>
                    <option value="2">February</option>
                    <option value="3">March</option>
                    <option value="4">April</option>
                    <option value="5">May</option>
                    <option value="6">June</option>
                    <option value="7">July</option>
                    <option value="8">August</option>
                    <option value="9">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
		</select>
		<span style="margin-left: 10px"></span>
                Year
		<select id="year" name="year">
                    <% for(int i = min; i <= max; i++) { %>
                        <option><%=i%></option>
                    <% } %>
		</select><br/>
                <input type="button" value="Download" onclick="getFile()"/>
    </div>
	   <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>
</body>
</html>
