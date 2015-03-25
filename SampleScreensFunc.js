$(document).ready(function(){
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
			  var otherinfowrapper = $('table[name=awards]');
                                 
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

					  $(siblingwrapper).append(
					           '<tr><td><input type="text" name="siblingname" placeholder="ex. Virma Lopez"  /></td>'
					          + '<td><input type="number" name="siblingage" placeholder="ex. 14"  /></td>'
					          + '<td><input type="text" name="siblingoccupation" placeholder="ex. Student"  /></td>'
					          + '<td><input type="text" name="siblinglocation" placeholder="ex. Binan, Laguna"  /></td>'
					          + '<td><button class="removesibling">-</button></td></tr>'
					   );
			 });
				 
			 $(document).on("click", ".removesibling", function(e){
				       e.preventDefault();

					   $(this).parent().parent().remove();
			 });
				 
			 $(document).on("click", ".addchild", function(e){
				       e.preventDefault();

					   $(childwrapper).append(
					             '<tr><td><input type="text" name="childrenname" placeholder="Name of Child" /></td>'
					           + '<td><input type="number" name="childrenage" placeholder="Age" /></td>'
					           + '<td><input type="text" name="childyear" placeholder="Grade/Year" /></td>'
					           + '<td><input type="text" name="childschool" placeholder="School/Location" /></td>'
					           + '<td><button class="removechild">-</button></td></tr>'
					   );
			 });
				 
			 $(document).on("click", ".removechild", function(e){
				      e.preventDefault();

					  $(this).parent().parent().remove();
			});
				 
			$(document).on("click", ".addelem", function(e){
				      e.preventDefault();

					  $(elemwrapper).append(
					            '<tr><td><input type="text" name="elemschool" placeholder="ex. Don Bosco School" required /></td>'
					           + '<td><input type="date" name="elemfrom" placeholder="ex. 2000" required /></td>'
					           + '<td><input type="date" name="elemto" placeholder="ex. 2012" required /></td>'
					           + '<td><input type="text" name="elemawards" placeholder="ex. Perfect Attendance" /></td>'
					           + '<td><button class="removeelem">-</button></td></tr>'
					  );
			});
				 
			$(document).on("click", ".removeelem", function(e){
				     e.preventDefault();

					 $(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addhighschool", function(e){
				     e.preventDefault();

					 $(highschoolwrapper).append(
					             '<tr><td><input type="text" name="highschool" placeholder="ex. Don Bosco School" required /></td>'
					           + '<td><input type="date" name="highschoolfrom" placeholder="ex. 2000" required /></td>'
					           + '<td><input type="date" name="highschooltoelemto" placeholder="ex. 2012" required /></td>'
					           + '<td><input type="text" name="highschoolawards" placeholder="ex. Perfect Attendance" /></td>'
					           + '<td><button class="removehighschool">-</button></td></tr>'
					);
			});
				 
			$(document).on("click", ".removehighschool", function(e){
				    e.preventDefault();

					$(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addcollege", function(e){
				    e.preventDefault();

					$(collegewrapper).append(
					             '<tr><td><input type="text" name="college" placeholder="ex. Don Bosco School" required /></td>'
					           + '<td><input type="date" name="collegefrom" placeholder="ex. 2000" required /></td>'
					           + '<td><input type="date" name="collegeto" placeholder="ex. 2012" required /></td>'
					           + '<td><input type="text" name="collegewards" placeholder="ex. Perfect Attendance" /></td>'
					           + '<td><button class="removecollege">-</button></td></tr>'
					);
			});
				 
			$(document).on("click", ".removecollege", function(e){
				    e.preventDefault();

					$(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addvocational", function(e){
				    e.preventDefault();

					$(vocationalwrapper).append(
					            '<tr><td><input type="text" name="vocationalschool" placeholder="ex. Don Bosco School" /></td>'
					          + '<td><input type="text" name="vocataionalschoolfrom" placeholder="ex. 2000"  /></td>'
					          + '<td><input type="text" name="vocationalschoolto" placeholder="ex. 2012"  /></td>'
					          + '<td><input type="text" name="vocationalschoolawards" placeholder="ex. Perfect Attendance"  /></td>'
					          + '<td><button class="removevocational">-</button></td></tr>'
					);
			});
				 
			$(document).on("click", ".removevocational", function(e){
				    e.preventDefault();

					$(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addmasteral", function(e){
				   e.preventDefault();

					$(masteralwrapper).append(
                                             '<tr><td><input type="text" name="masteralschool" placeholder="ex. Don Bosco School" /></td>'
					   + '<td><input type="text" name="masteralschoolfrom" placeholder="ex. 2000"  /></td>'
					   + '<td><input type="text" name="masteralschoolto" placeholder="ex. 2012"  /></td>'
					   + '<td><input type="text" name="masteralschoolawards" placeholder="ex. Perfect Attendance"  /></td>'
					   + '<td><button class="removemasteral">-</button></td></tr>'
					   );
			});
				 
			$(document).on("click", ".removemasteral", function(e){
				    e.preventDefault();
					
					$(this).parent().parent().remove();
			});
						
			$(document).on("click", ".addother", function(e){
			    e.preventDefault();

				$(otherswrapper).append(
                                             '<tr><td><input type="text" name="otherschool" placeholder="ex. Don Bosco School" /></td>'
					   + '<td><input type="text" name="otherfrom" placeholder="ex. 2000"  /></td>'
					   + '<td><input type="text" name="otherto" placeholder="ex. 2012"  /></td>'
					   + '<td><input type="text" name="otherawards" placeholder="ex. Perfect Attendance" /></td>'
					   + '<td><button class="removeother">-</button></td></tr>');
			});
			
			$(document).on("click", ".removeother", function(e){
			       e.preventDefault();

				   $(this).parent().parent().remove();
			});
			
			$(document).on("click", ".addlicense", function(e){
				   e.preventDefault();

					$(licensewrapper).append(
                                             '<tr><td><input type="text" name="license" placeholder="License/Exam Name" /></td>'
					   + '<td><input type="text" name="licensepercentage" placeholder="Percentage Result" /></td>'
					   + '<td><button class="removelicense">-</button></td></tr>'
					   );
			});
				 
			$(document).on("click", ".removelicense", function(e){
				    e.preventDefault();
					
					$(this).parent().parent().remove();
			});
				 
				 			  $(document).on("click", ".addemployment", function(e){
			      e.preventDefault();

				  $(employmentwrapper).append(
				     '<tr>'
					 + '	<td width="300px" class="here">Job Title</td>'
					 + '	<td>Date of Employment</td>'
					 + '	<td width="300px">Starting Salary</td>'
					 + '	<td width="300px">Ending Salary</td>'

					 + '</tr>'
					 + '<tr>'
					 + '	<td><input type="text" name="jobtitle" placeholder="Job Title" /></td>'
					 + '	<td><input type="text" name="jobemploydate" placeholder="Date of Employment" /></td>'
					 + '	<td><input type="text" name="jobbegsal" placeholder="Starting Salary" /></td>'
					 + '	<td><input type="text" name="jobendsal" placeholder="Ending Salary" /></td>'
					 + '</tr>'
					 + '<tr>'
					 + '	<td></td>'
					 + '	<td width="400px">Employer\'s Name</td>'
					 + '	<td width="400px">Employer\'s Address</td>'
					 + '	<td width="400px">Employer\'s Contact Number</td>'
					 + '</tr>'
					 + '<tr>'
					 + '	<td></td>'
					 + '	<td><input type="text" name="jobemployer" placeholder="Employer\'s Name" /></td>'
					 + '	<td><input type="text" name="jobaddress" placeholder="Employer\'s Address" /></td>'
					 + '	<td><input type="text" name="jobtelno" placeholder="Employer\'s Contact Number" /></td>'
					 + '</tr>'
					 + '<tr>'
					 + '	<td></td>'
					 + '	<td width="400px">Supervisor\'s Name</td>'
					 + '	<td width="400px">Supervisor\'s Contact Number</td>'
					 + '	<td width="400px">Reason For Leaving</td>'
					 + '	<td></td>'
					 + '</tr>'
					 + '<tr>'
					 + '	<td></td>'
					 + '	<td><input type="text" name="jobsupname" placeholder="Supervisor Name" /></td>'
					 + '	<td><input type="text" name="jobsupno" placeholder="Supervisor Contact Number" /></td>'
					 + '	<td><input type="text" name="jobreason" placeholder="Reason for Leaving" /></td>'
					 + '	<td><button class="removeemployment">-</button></td>'
					 + '</tr>'
				  );
			  });
			  
			  $(document).on("click", ".removeemployment", function(e){
			           var toremove = $(this).parent().parent();
			           e.preventDefault();

				   //$(toremove).nextUntil("input[name=jobreason]").remove();
                                    $(toremove).prev().prev().prev().prev().prev().remove();
                                    $(toremove).prev().prev().prev().prev().remove();
                                    $(toremove).prev().prev().prev().remove();
                                    $(toremove).prev().prev().remove();
                                    $(toremove).prev().remove();
                                    $(toremove).remove();
                                   
			  });
			  
			 $(document).on("click", ".addcriminaloffense", function(e){
			      e.preventDefault();

				  $(criminaloffensewrapper).append(
                                           '<tr><td><input type="text" name="offensename" placeholder="Criminal Offense" /></td>'
					 + '<td><input type="text" name="offensedate" placeholder="Date of Offence" /></td>'
					 + '<td><input type="text" name="offenceplace" placeholder="Place of Offence" /></td>'
					 + '<td><button class="removecriminaloffense">-</button></td></tr>'
				  );
			 });
			 $(document).on("click", ".removecriminaloffense", function(e){
			    e.preventDefault();

				$(this).parent().parent().remove();
			 });
			 
			 $(document).on("click", ".addotherinfo", function(e){
			    e.preventDefault();
				$(otherinfowrapper).append(
				   '<tr><td><input type="text" name="infoname" placeholder="Award/Certification Title" /></td>'
				   + '<td><input type="date" name="infodate" placeholder="Date recieved by employee" /></td>'
				   + '<td><input type="text" name="infodescription" placeholder="Descrbe the award/certification" /></td>'
				   + '<td><button class="deleteotherinfo">-</button></td></tr>'
				);
			 });
			 
			 $(document).on("click", ".deleteotherinfo", function(e){
			     e.preventDefault();
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
