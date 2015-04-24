<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Database.Database"%>
<html>
<head>
    <link rel="shortcut icon" href="img/eq logo.ico">
    <link rel="stylesheet" href="css/generateReport.css">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    
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
</head>
<body onload="makeTableScroll();">
	
    <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "Logout">Log Out</a></li>
                <li><a href= "changePassword.jsp">Change Password</a></li>
                <li><a href= "LeaveForm.jsp">File a Leave</a></li>
                <li><a href= "GenerateReport.jsp">Generate Report</a></li>
                <li><img class= "logo" src= "img/eqlogoclear.png" height="53px"/></li>
            </ul>
        </DIV>	


    <div id = "box" align="center">
	<span class="titleText">Monthly Leave Report</span><hr/>
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
		</select>
    </div>
	   <DIV class="footer">
            <br/><hr width="75%"/>
            EQUILIBRIUM INTERTRADE CORP.
        </DIV>
</body>
</html>
