
$( document ).ready(function() {
	$(".spinner-2").hide();
	$("#registrationpanel").hide();
	$("#linkspanel").hide();
	$("#contactuspanel").hide();
	$("#feedbackpanel").hide();
	$("#aboutuspanel").hide();
	
	
});

$("#signupicon").bind ("click", function(){
	$("#textPanel").hide();
	$("#loginPanel").hide();
	$("#registrationpanel").show();
	
});

$("#aboutusicon").bind ("click", function(){
	$("#textPanel").hide();
	$("#loginPanel").hide();
	$("#aboutuspanel").show();
	
});

$(".round-button").bind ("click", function(){
	$(".spinner-2").show();
	
});


//$("#save").bind ("click", function(){
//            $.ajax( {
//        		type: 'POST',
//        		url: '/edsolstice/rest/sessionservice/login',
//        		contentType:'application/json',
//        		data: JSON.stringify ({ 
//        			"password": $("#password").val(), 
//        			"email": $("#email").val()
//        		}),
//        		dataType: 'json',
//        		error: function(jqXHR, textStatus, ex) {
//        			$("#serverErr").show();
//        		},
//        		success : function(loginData){
//        			//alert(JSON.stringify(loginData));
//        			sessionStorage.setItem('sessionToken' , loginData.sessionToken);
//        			sessionStorage.setItem('email' , loginData.email);
//        			document.location = 'students.htm';	
//         		}
//        	}
//        	);
//            return false;   
//});

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