$(document).ready(function(){
	$.ajax( {

		type: 'GET',
		url: '/webapps/edsolstice/dummy/student.json',

		dataType: 'json',
		error: function(jqXHR, textStatus, ex) {
			alert(textStatus + "," + ex + "," + jqXHR.status);	
		},
		success : function(result){
			//alert(JSON.stringify(sessionStorage));
			$('#edsolstice-menu ul li p').text(sessionStorage.username);
		}
	}
);	
}
);