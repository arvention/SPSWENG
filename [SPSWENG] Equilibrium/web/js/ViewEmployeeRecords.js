$(document).ready(function () {
    var currPage = "#personal", currRecord = "#memo";
    var nextPage, nextRecord;
    var toBeDeleted;
    $(".pages").hide();
    $("#personal").show();
    $("#alert").hide();
    $(".add-delete-button").hide();
    $("#overlay").hide();
    $("#awards").hide();
    $("#evaluation").hide();

    $(document).on("change", "#options", function () {
        nextPage = "#" + $("#options").find(":selected").val();
        if(nextPage !== "#docs")
            $("#info-form").show();
        else
            $("#info-form").hide();
        $(currPage).hide();
        $(nextPage).show();
        currPage = nextPage;
    });
    
    $(document).on("change", "#docs-select", function () {
        nextRecord = "#" + $("#docs-select").find(":selected").val();
        $(currRecord).hide();
        $(nextRecord).show();
        currRecord = nextRecord;
    });
    
    $(document).on("click", "#editButton", function () {
        if($(this).val() === "Edit") {
            $(this).val("Cancel");
            $("#saveButton").show();
            $("input[name='managerid']").attr("type", "number");
            $(".data").attr("readonly", false);
            //$(".data").css("border-bottom", "1px solid lightgray");
            $(".editMessage").show();
            $(".add-delete-button").show();
            $(".editNote").show();
        }
        else if($(this).val() === "Cancel") {
            $(this).val("Edit");
            $("#editButton").attr("type", "button");
            $("#saveButton").hide();
            $(".data").attr("readonly", true);
            $(".data").css("border-bottom", "0");
            $(".editMessage").hide();
            $(".add-delete-button").hide();
            $("input[name='managerid']").attr("type", "text");
            $(".editNote").hide();
        }
    });
    
    $(document).on("click", ".add-delete-button", function () {
        if($(this).val() === "+") {
            var type = $(this).closest(".pages").attr("id");
            var element;
            
            if($(this).parent().attr("class") === "label-rel")
                element = $(this).parent(".label-rel");
            else
                element = $(this).closest(".subContent");
            
            console.log("+ BUTTON CLICKED");
            console.log("   type: " + type);
            console.log("   element: " + element);
            
            switch(type) {
                case "relations": appendRelations(element); break;
                case "edu": appendEducation(element); break;
                case "history": appendHistory(element); 
            }
            reloadCss();
            $(this).remove();
        } 
        else if($(this).val() === "-") {
            toBeDeleted = $(this).closest(".subContent");
            $("#overlay").fadeIn("fast");
            $("#alert").fadeIn("fast");
            $("#main :input").attr("disabled", true);
        }
    });
    
    $(document).on("click", ".alertButton", function () {
        if($(this).val() === "Yes") {
            console.log("SIBLING LEN " + toBeDeleted.siblings().length);
            if(toBeDeleted.siblings().length <= 1)
                $(toBeDeleted).siblings(".label-rel").append("<input type=\"button\" value=\"+\" class=\"add-delete-button\">");
            toBeDeleted.remove();
        } 
        $("#alert").fadeOut("fast");
        $("#overlay").fadeOut("fast");
        $("#main :input").attr("disabled", false);
    });
    
    function appendRelations(element) {
        var content =
            "<div class=\"subContent\">" +
            "<div class=\"line\"><span class=\"label\"><b>Name</b></span>\n" +
            "   <span class=\"data\"></span>\n" +
            "   <input type=\"button\" value=\"+\" class=\"add-delete-button\">\n" +
            "   <input type=\"button\" value=\"-\" class=\"add-delete-button\"></div>\n" +
            "<div class=\"line\"><span class=\"label\">Contact Number</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Occupation</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Employer</span>\n" +
            "   <span class=\"data\"></span></div><br/>" +
            "</div>";
        $(element).after(content);
    }
    
    function appendEducation(element) {
        var content =
            "<div class=\"subContent\">" +
            "<div class=\"line\"><span class=\"label\"><b>Name</b></span>\n" +
            "   <span class=\"data\"></span>\n" +
            "   <input type=\"button\" value=\"+\" class=\"add-delete-button\">\n" +
            "   <input type=\"button\" value=\"-\" class=\"add-delete-button\"></div>\n" +
            "<div class=\"line\"><span class=\"label\">Age</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Occupation</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Company</span>\n" +
            "   <span class=\"data\"></span></div>" +
            "</div>";
        $(element).after(content);
    }
    
    function appendHistory(element) {
        var content =
            "<div class=\"subContent\">" +
            "<div class=\"label-rel\">Year</div>" +
            "<div class=\"line\"><span class=\"label\"><b>Occupation</b></span>\n" +
            "   <span class=\"data\"></span>\n" +
            "   <input type=\"button\" value=\"+\" class=\"add-delete-button\">\n" +
            "   <input type=\"button\" value=\"-\" class=\"add-delete-button\"></div>\n" +
            "<div class=\"line\"><span class=\"label\">Date of Employment</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Beginning Salary</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Ending Salary</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Name of Employer</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Address of Employer</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Contact Number of Employer</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Name of Supervisor</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Contact Number of Supervisor</span>\n" +
            "   <span class=\"data\"></span></div>\n" +
            "<div class=\"line\"><span class=\"label\">Reason for leaving</span>\n" +
            "   <span class=\"data\"></span></div>" + 
            "</div>";
        $(element).after(content);
    }
    
    function reloadCss() {
        $(".add-delete-button").css(button);
        $(".data").css(data);
        $(".data").attr("contentEditable", true);
        $(".data").css("border-bottom", "1px solid lightgray");
    }
    
    var button = {
        'width': '20px',
        'float': 'right',
        'background-color': 'lightgray',
        'border': '0',
        'color': 'white',
        'margin-left': '2px'
    };
    
    var data = {
        'padding-left': '2px',
        'padding-right': '2px'
    };
    
});