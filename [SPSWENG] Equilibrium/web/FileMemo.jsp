<html>
    <head>
        <link rel="shortcut icon" href="eq logo.ico"/>
        <script src="js/jquery-1.11.2.js"></script>
        <title> Memo Form - Equilibrium </title>
        <style>
            DIV.nav{
                padding-top:0px;
                background: #D63333;
                opacity: 0.55;
                width: 100%;
                height: 10%;
                position: absolute;
                top: 0%;
                left: 0%;
                z-score: 2;
            }
            .nav ul{
                padding: 0;
                margin: 0;
            }
            .nav ul li{
                list-style: none;
            }
            .nav ul li a{
                float: right;
                padding: 20px 30px;
                color: black;
                text-decoration: none;
                display: block;
                font-size: 125%;
            }
            .nav ul li a:hover{
                color: white;
            }
            .logo{
                float: left;
                width: 175;
                height: 65;
            }
            .memoForm{
                background-color: white;
                border-radius: 16px;
                width:750;
                opacity: 0.55;
                position: absolute;
                top: 10%;
                left: 23%;
                margin-top: 3%;
                /*
                margin-left: auto;
                margin-right: auto;*/
            }
            .memoText{
                margin-left: 125px;
                margin-top: 20px;
                font-color: black;
                border: 1px solid black;
                font-family: Arial;
                position: relative;
                top: 5%;
                left: 0%;
                /*padding-left: 4px;*/
            }
            .submitButton{
                width: 75;
                height: 25;
                /*margin-top: 8px;
                margin-left: 560px;*/
                cursor: hand;
                color: black;
                position: relative;
                top:15%;
                left: 16.5%;
                margin-bottom: 10%;
            }
            .submitButton:hover{
                border: 1.5px solid white;
            }
            .titleText{
                font-size: 35;
                font-family: Arial;
                font-weight: bold;
                color: red;
                /*margin-left: 125px;*/
                position: relative;
                left: 16.5%;
                opacity: .85;
            }
            .contentText{
                font-size: 17;
                font-family: Arial;
                color: red;
                /*margin-left: 125px;
                margin-top: 8px;*/
                position: relative;
                left: 16.5%;
                opacity: .85;
            }
            DIV.pageBottom{
                width: 100%;
                position: fixed;
                top: 90%;
                left: 0%;
                height: 500px;
                text-align:center;
                color: #808080;
                font-size: 11;
                font-family: "Arial";
                background-color: #E8E8E8;
                z-score: 1;
            }
            textarea{
                resize:none;
            }
            table[name=softmemo]{
                position: relative;
                left: 16.5%;
            }

        </style>
        <script>
            $(document).ready(function() {
                var softmemowrapper = $('table[name=softmemo]');

                $(document).on("click", ".addsoftmemo", function(e) {
                    e.preventDefault();
                    $(softmemowrapper).append(
                            '<tr><td><input type="file" name="filename" placeholder="File Name here" /></td>'
                            + '<td><button class="removesoftmemo" align="center">-</button></td></tr>'
                            );
                });

                $(document).on("click", ".removesoftmemo", function(e) {
                    e.preventDefault();
                    var c = confirm("Do you want to remove this row of data?");
                    if (c) {
                        $(this).parent().parent().remove();
                    }
                });
            });
        </script>
    </head>
    <body bgcolor=#E8E8E8>
        <DIV class= "nav">
            <!-- When going back to any page here, please do not forget to add prompt if the user wants to discard any changes made to any form element.-->
            <ul>
                <li><a href= "#">Log Out</a></li>
                <li><a href= "#">Announcements</a></li>
                <li><a href= "#">Home</a></li>
                <li><img class= "logo" src= "eqboyz.png"/></li>
            </ul>
        </DIV>
        <div class = "memoForm">
            <br/><br/><br/><br/><br/>
            <span class= "titleText"> File a Memo </span>
            <br/>
            <div class = "contentText">

                <form action="SaveMemo" method="POST" enctype="multipart/form-data">
                    Select type of memorandum : 

                    <select required name="listTypeMemo">
                        <option value="Verbal Reprimand">Verbal Reprimand</option>
                        <option value="Written Reprimand">Written Reprimand</option>
                        <option value="Suspension">Suspension</option>

                    </select></div>
            <table name="softmemo">
                <tr>
                    <td><input type="file" name="filename" placeholder="File Name here" /></td>
                    <td><button class="addsoftmemo" align="center">+</button></td>
                </tr>
            </table>
            <textarea rows="7" cols = "70" name="memoNote" class="memoText" placeholder="Enter text here..." required ></textarea>
            <br/><input type="submit" class="submitButton"/> 
        </form>


    </div>


    <DIV class = "pageBottom"><hr width ="75%"/></br> EQUILIBRIUM INTERTRADE CORP.</div>
</body>

</html>
