$("#btnRegister").button().bind ("click", function() {

$.ajax( {
	
    type: "POST",
    url: "edsolstice/rest/registrationservice/users",
    data: { 
	userName: "John", 
	password: "Boston" 
		} ,
    
    error : function(){
      alert("error");	
    },
    
    success : function(){
      alert("success");	
    }
}
);
});
