$("#btnRegister").button().bind ("click", function() {

$.ajax( {
	
    type: 'POST',
    url: '/edsolstice/rest/registrationservice/users',
    contentType:'application/json',
    async: false,
     
    
    data: JSON.stringify ({ 
	"userName": "John", 
	"password": "Boston" 
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
