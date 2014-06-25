$("#save").bind ("click", function(){
            $.ajax( {
        		type: 'POST',
        		url: '/edsolstice/rest/loginsessionservice/login',
        		contentType:'application/json',
        		data: JSON.stringify ({ 
        			"password": $("#password").val(), 
        			"email": $("#email").val()
        		}),
        		dataType: 'json',
        		error: function(jqXHR, textStatus, ex) {
        			$("#serverErr").show();
        		},
        		success : function(loginData){
        			//alert(JSON.stringify(loginData));
        			sessionStorage.setItem('sessionToken' , loginData.sessionToken);
        			sessionStorage.setItem('username' , loginData.email);
        			document.location = 'students.htm';	
         		}
        	}
        	);
            return false;   
});

$("#email").bind ("blur	", function(){
	if($("#email").val() == ''){
		$("#emailerrormessage").show();
		return false;
	}else{
		$("#emailerrormessage").hide();
		return true;
	}
});

$("#password").bind ("blur	", function(){
	if($("#email").val() == ''){
		$("#passworderrormessage").show();
		return false;
	}else{
		$("#passworderrormessage").hide();
		return true;
	}
});