$(document).ready( function() {
	var announcementswrapper = $('.announcements');
	$(announcementswrapper).hide();
	
	$(document).on("click", "#showall", function(e){
		$(announcementswrapper).toggle();
	});
});