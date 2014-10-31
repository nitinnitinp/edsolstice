function singleEntry(Name , CollegeName , fieldName){

var listentry = "<li> <img src='./images/profile.jpg' align='middle'> <div class='name'>" +Name  +"</div> <div class='college'> "+CollegeName + "</div> <div class='Field'>"+fieldName+"</div> <input type='button' value = '+' /> </li>";

return listentry ;

}

$(document).ready(function(){
//	$.ajax( {
//
//		type: 'GET',
//		url: '/webapps/edsolstice/dummy/student.json',
//
//		dataType: 'json',
//		error: function(jqXHR, textStatus, ex) {
//			alert(textStatus + "," + ex + "," + jqXHR.status);	
//		},
//		success : function(result){
//			//alert(JSON.stringify(sessionStorage));
//			$('#edsolstice-menu ul li p').text(sessionStorage.username);
//		}
//	}
//);	


	$.ajax( {

		type: 'GET',
		url: '/webapps/edsolstice/dummy/teachers.json',

		dataType: 'json',
		error: function(jqXHR, textStatus, ex) {
			alert(textStatus + "," + ex + "," + jqXHR.status);	
		},
		success : function(result){
			//alert(JSON.stringify(sessionStorage));
			var finalList = "<ul id='StudentList'>" ;
			var loadteachers = result.teachers;
			$.each(loadteachers,function(){
				finalList  = finalList  + singleEntry(this.name , this.college , this.field);
			});
			
			finalList  = finalList  + "</ul>";

			$('#searchBox').after(finalList);

		}
	}
);

});

$('#searchBox').bind('keyup' ,function() {
    var value = $(this).val();

    $("#StudentList > li").each(function() {
        if ($(this).children('.name').text().search(value) > -1 || $(this).children('.college').text().search(value) > -1 || $(this).children('.Field').text().search(value) > -1)  {
            $(this).show()
        }
        else {
            $(this).hide();
        }
    });
});