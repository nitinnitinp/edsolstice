$("#save").bind ("click", function() {

	$.ajax( {

		type: 'POST',
		url: '/edsolstice/rest/accountactivatedservice/activate',
		contentType:'application/json',
		data: JSON.stringify ({ 
			"activationCode": $("#activationCode").val() 
			
		}),

		dataType: 'json',
		error: function(jqXHR, textStatus, ex) {
			alert(textStatus + "," + ex + "," + jqXHR.status);	
		},
		success : function(xhr){
			document.location = 'index.html';		
		}
	}
	);
	return false;
});