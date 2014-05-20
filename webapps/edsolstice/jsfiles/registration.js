$("#btnRegister").button().bind ("click", function() {

$.ajax( {
	
    type: 'POST',
    url: '/edsolstice/rest/registrationservice/users',
    contentType:'application/json',
    async: false,
     
    
    data: JSON.stringify ({ 
	"userName": $("#fname").val(), 
    "surName": $("#lname").val(),
	"password": $("#password").val(), 
    "cPpassword": $("#cPpassword").val(),
    "department": $("#department").val(),
    "college": $("#college").val(),
    "mobile": $("#mobile").val(),
    "emailId": $("#emailId").val(),
    "role": $("#type").val()
		
			
		}),
		
	dataType: 'json',
    
   error: function(jqXHR, textStatus, ex) {
        alert(textStatus + "," + ex + "," + jqXHR.status);	
    },
    
    success : function(xhr){
      alert("success");	
    }
}
);
});
