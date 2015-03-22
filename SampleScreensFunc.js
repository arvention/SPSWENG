$(document).ready(function(){
 var siblingcount =1;
			  var childcount = 1;
              var elemcount =1;
			  var highschoolcount =1;
			  var collegecount =1;
			  var vocationalcount =1;
			  var masteralcount =1;
			  var otherscount = 1;
			  var licensecount = 1;
			  var employmentcount = 1;
			  var criminaloffensecount = 1;
			  var siblingwrapper = $('table[name=siblings]');
			  var childwrapper = $('table[name=children]');
              var tohide = $('.tohide');
			  var elemwrapper = $('table[name=elementary]');
			  var highschoolwrapper = $('table[name=highschool]');
			  var collegewrapper = $('table[name=college]');
			  var vocationalwrapper = $('table[name=vocational]');
			  var masteralwrapper = $('table[name=masteral]');
			  var otherswrapper = $('table[name=others]');
			  var licensewrapper = $('table[name=license]');
			  var employmentwrapper = $('table[name=employment]');
			  var criminaloffensewrapper = $('table[name=criminaloffense]');			
                                 
              $(tohide).hide();
			  $('select[name=civilstatus]').change(function(){
			       if( $('select[name=civilstatus]').find(':selected').val()==="s" )
				             $(tohide).hide();
			       else
				             $(tohide).show();
			  });
			  
			  $('select[name=convicted]').change(function(){
			      if( $('select[name=convicted]').find(':selected').val()==="y" )
				      $(tohide).show();
			     else
				      $(tohide).hide();
			  });
				 
			  $(document).on("click", ".addsibling", function(e){
				      e.preventDefault();
				      siblingcount++;
					  $(siblingwrapper).append(
					          '<tr><td> ' + siblingcount.toString() + ' </td>' 
					          + '<td><input type="text" name="siblingname" placeholder="ex. Virma Lopez"  /></td>'
					          + '<td><input type="number" name="siblingage" placeholder="ex. 14"  /></td>'
					          + '<td><input type="text" name="siblingoccupation" placeholder="ex. Student"  /></td>'
					          + '<td><input type="text" name="siblinglocation" placeholder="ex. Binan, Laguna"  /></td>'
					          + '<td><button class="removesibling">Remove sibling info</button></td></tr>'
					   );
			 });
				 
			 $(document).on("click", ".removesibling", function(e){
				       e.preventDefault();
					   siblingcount--;
					   $(this).parent().parent().remove();
			 });
				 
			 $(document).on("click", ".addchild", function(e){
				       e.preventDefault();
				       childcount++;
					   $(childwrapper).append(
					            '<tr><td> ' + childcount.toString() + ' </td>' 
					           + '<td><input type="text" name="childrenname" placeholder="Name of Child" /></td>'
					           + '<td><input type="number" name="childrenage" placeholder="Age" /></td>'
					           + '<td><input type="text" name="childyear" placeholder="Grade/Year" /></td>'
					           + '<td><input type="text" name="childschool" placeholder="School/Location" /></td>'
					           + '<td><button class="removechild">Remove child info</button></td></tr>'
					   );
			 });
				 
			 $(document).on("click", ".removechild", function(e){
				      e.preventDefault();
					  childcount--;
					  $(this).parent().parent().remove();
			});
				 
			$(document).on("click", ".addelem", function(e){
				      e.preventDefault();
				      elemcount++;
					  $(elemwrapper).append(
					            '<tr><td> ' + elemcount.toString() + ' </td>' 
					           + '<td><input type="text" name="elemschool" placeholder="ex. Don Bosco School" required /></td>'
					           + '<td><input type="date" name="elemfrom" placeholder="ex. 2000" required /></td>'
					           + '<td><input type="date" name="elemto" placeholder="ex. 2012" required /></td>'
					           + '<td><input type="text" name="elemawards" placeholder="ex. Perfect Attendance" /></td>'
					           + '<td><button class="removeelem">Remove elementary school info</button></td></tr>'
					  );
			});
				 
			$(document).on("click", ".removeelem", function(e){
				     e.preventDefault();
					 elemcount--;
					 $(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addhighschool", function(e){
				     e.preventDefault();
				     highschoolcount++;
					 $(highschoolwrapper).append(
					            '<tr><td> ' + highschoolcount.toString() + ' </td>' 
					           + '<td><input type="text" name="highschool" placeholder="ex. Don Bosco School" required /></td>'
					           + '<td><input type="date" name="highschoolfrom" placeholder="ex. 2000" required /></td>'
					           + '<td><input type="date" name="highschooltoelemto" placeholder="ex. 2012" required /></td>'
					           + '<td><input type="text" name="highschoolawards" placeholder="ex. Perfect Attendance" /></td>'
					           + '<td><button class="removehighschool">Remove high school info</button></td></tr>'
					);
			});
				 
			$(document).on("click", ".removehighschool", function(e){
				    e.preventDefault();
					highschoolcount--;
					$(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addcollege", function(e){
				    e.preventDefault();
				    collegecount++;
					$(collegewrapper).append(
					            '<tr><td> ' + collegecount.toString() + ' </td>' 
					           + '<td><input type="text" name="college" placeholder="ex. Don Bosco School" required /></td>'
					           + '<td><input type="date" name="collegefrom" placeholder="ex. 2000" required /></td>'
					           + '<td><input type="date" name="collegeto" placeholder="ex. 2012" required /></td>'
					           + '<td><input type="text" name="collegewards" placeholder="ex. Perfect Attendance" /></td>'
					           + '<td><button class="removecollege">Remove college info</button></td></tr>'
					);
			});
				 
			$(document).on("click", ".removecollege", function(e){
				    e.preventDefault();
					collegecount--;
					$(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addvocational", function(e){
				    e.preventDefault();
				    vocationalcount++;
					$(vocationalwrapper).append(
					           '<tr><td> ' + vocationalcount.toString() + ' </td>' 
					          + '<td><input type="text" name="vocationalschool" placeholder="ex. Don Bosco School" /></td>'
					          + '<td><input type="text" name="vocataionalschoolfrom" placeholder="ex. 2000"  /></td>'
					          + '<td><input type="text" name="vocationalschoolto" placeholder="ex. 2012"  /></td>'
					          + '<td><input type="text" name="vocationalschoolawards" placeholder="ex. Perfect Attendance"  /></td>'
					          + '<td><button class="removevocational">Remove vocational school info</button></td></tr>'
					);
			});
				 
			$(document).on("click", ".removevocational", function(e){
				    e.preventDefault();
					vocationalcount--;
					$(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addmasteral", function(e){
				   e.preventDefault();
				    masteralcount++;
					$(masteralwrapper).append('<tr><td> ' + masteralcount.toString()
					   + ' </td>' 
					   + '<td><input type="text" name="masteralschool" placeholder="ex. Don Bosco School" /></td>'
					   + '<td><input type="text" name="masteralschoolfrom" placeholder="ex. 2000"  /></td>'
					   + '<td><input type="text" name="masteralschoolto" placeholder="ex. 2012"  /></td>'
					   + '<td><input type="text" name="masteralschoolawards" placeholder="ex. Perfect Attendance"  /></td>'
					   + '<td><button class="removemasteral">Remove masteral school info</button></td></tr>'
					   );
			});
				 
			$(document).on("click", ".removemasteral", function(e){
				    e.preventDefault();
					masteralcount--;
					//alert("Removing.");
					$(this).parent().parent().remove();
			});
						
			$(document).on("click", ".addother", function(e){
			    e.preventDefault();
				otherscount++;
				$(otherswrapper).append('<tr><td> ' + otherscount.toString()
					   + ' </td>' 
					   + '<td><input type="text" name="otherschool" placeholder="ex. Don Bosco School" /></td>'
					   + '<td><input type="text" name="otherfrom" placeholder="ex. 2000"  /></td>'
					   + '<td><input type="text" name="otherto" placeholder="ex. 2012"  /></td>'
					   + '<td><input type="text" name="otherawards" placeholder="ex. Perfect Attendance" /></td>'
					   + '<td><button class="removeother">Remove other school info</button></td></tr>');
			});
			
			$(document).on("click", ".removeother", function(e){
			       e.preventDefault();
				   otherscount--;
				   $(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addlicense", function(e){
				   e.preventDefault();
				    licensecount++;
					$(licensewrapper).append('<tr><td> ' + licensecount.toString()
					   + ' </td>' 
					   + '<td><input type="text" name="license" placeholder="License/Exam Name" /></td>'
					   + '<td><input type="text" name="licensepercentage" placeholder="Percentage Result" /></td>'
					   + '<td><button class="removelicense">Remove license/exam info</button></td></tr>'
					   );
			});
				 
			$(document).on("click", ".removelicense", function(e){
				    e.preventDefault();
					licensecount--;
					//alert("Removing.");
					$(this).parent().parent().remove();
			});
				 
				 			  $(document).on("click", ".addemployment", function(e){
			      e.preventDefault();
				  employmentcount++;
				  $(employmentwrapper).append(
				     '<tr>'
					 +'	<td>#</td>'
					 + '	<td>Job Title</td>'
					 + '	<td>Date of Employment</td>'
					 + '	<td>Starting Salary</td>'
					 + '	<td>Ending Salary</td>'
					 + '	<td><button class="removeemployment">Remove job history</button></td>'
					 + '</tr>'
					 + '<tr>'
					 + '	<td>' + employmentcount.toString() + '</td>'
					 + '	<td><input type="text" name="jobtitle" placeholder="Job Title" /></td>'
					 + '	<td><input type="text" name="jobemploydate" placeholder="Date of Employment" /></td>'
					 + '	<td><input type="text" name="jobbegsal" placeholder="Starting Salary" /></td>'
					 + '	<td><input type="text" name="jobendsal" placeholder="Ending Salary" /></td>'
					 + '</tr>'
					 + '<tr>'
					 + '	<td></td>'
					 + '	<td>Employer\'s Name</td>'
					 + '	<td>Employer\'s Address</td>'
					 + '	<td>Employer\'s Contact Number</td>'
					 + '</tr>'
					 + '<tr>'
					 + '	<td></td>'
					 + '	<td><input type="text" name="jobemployer" placeholder="Employer\'s Name" /></td>'
					 + '	<td><input type="text" name="jobaddress" placeholder="Employer\'s Address" /></td>'
					 + '	<td><input type="text" name="jobtelno" placeholder="Employer\'s Contact Number" /></td>'
					 + '</tr>'
					 + '<tr>'
					 + '	<td></td>'
					 + '	<td>Supervisor\'s Name</td>'
					 + '	<td>Supervisor\'s Contact Number</td>'
					 + '	<td>Reason For Leaving</td>'
					 + '	<td></td>'
					 + '</tr>'
					 + '<tr>'
					 + '	<td></td>'
					 + '	<td><input type="text" name="jobsupname" placeholder="Supervisor Name" /></td>'
					 + '	<td><input type="text" name="jobsupno" placeholder="Supervisor Contact Number" /></td>'
					 + '	<td><input type="text" name="jobreason" placeholder="Reason for Leaving" /></td>'
					 + '	<td></td>'
					 + '</tr>'
				  );
			  });
			  
			  $(document).on("click", ".removeemployment", function(e){
			       e.preventDefault();
				   employmentcount--;
				   //alert("Will implement this later. :(");
				   var toremove = $(this).parent().parent();
				   $(toremove).nextUntil("input[name=jobreason]").remove();
				   $(toremove).remove();
			  });
			  
			 $(document).on("click", ".addcriminaloffense", function(e){
			      e.preventDefault();
				  criminaloffensecount++;
				  $(criminaloffensewrapper).append('<tr><td>' + criminaloffensecount.toString() + '</td>'
				     + '<td><input type="text" name="offensename" placeholder="Criminal Offense" /></td>'
					 + '<td><input type="text" name="offensedate" placeholder="Date of Offence" /></td>'
					 + '<td><input type="text" name="offenceplace" placeholder="Place of Offence" /></td>'
					 + '<td><button class="removecriminaloffense">Remove criminal offense history</button></td></tr>'
				  );
			 });
			 $(document).on("click", ".removecriminaloffense", function(e){
			    e.preventDefault();
				criminaloffensecount--;
				$(this).parent().parent().remove();
			 });
			 
			$('.tab-section').hide();
	        $('.tabs a').bind('click', function(e){
		             $('.tabs a.current').removeClass('current');
		             $('.tab-section:visible').hide();
		             $(this.hash).show();
		             $(this).addClass('current');
		             e.preventDefault();
	        }).filter(':first').click();
			
		 });
