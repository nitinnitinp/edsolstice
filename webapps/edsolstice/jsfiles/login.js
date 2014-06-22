

// Call the button widget method on the login button to format it. 
$("#save").button().bind ("click", function(){
    // Test our form for a valid login.  
    // Our form only works with:
    //     username: script
    //     password: junkie
   
            // If the login credentials are correct, go to the todo page.
            
            $.ajax( {

        		type: 'POST',
        		url: '/edsolstice/rest/loginsessionservice/login',
        		contentType:'application/json',
        		async: false,


        		data: JSON.stringify ({ 
        			
        			"password": $("#password").val(), 
        			"email": $("#email").val()
//        			"role": $("#type").val()


        		}),

        		dataType: 'json',

        		error: function(jqXHR, textStatus, ex) {
        			$("#rightcolumn").effect("shake", {times: 3}, 80);
        		},

        		success : function(xhr){
        			document.location = 'students.htm';	
        		}
        	}
        	);
            
            return false;
            
    // return false to cancel normal form submit event methods.
   
});


