$(document).ready(function(){
var miscfilewrapper = $('table[name=miscellaneous]');
$(document).on("click", ".addmiscfile", function(e){
		e.preventDefault();
		$(miscfilewrapper).append(
		    '<tr><td><input type="text" name="filename" placeholder="File Name here" /></td>'
		        + '<td><input type="date" name="birthday" placeholder="Birthday" /></td>'
                        + '<td><input type="file" name="filename" placeholder="File Name here" /></td>'
			+ '<td><button class="removemiscfile">-</button></td></tr>'
		);
	});
	
	$(document).on("click", ".removemiscfile", function(e){
		e.preventDefault();
		var c = confirm("Do you want to remove this row of data?");
		if (c){
			$(this).parent().parent().remove();
		}
	});
});