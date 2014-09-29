
$( document ).ready(function() {
	$("#head2").hide();
	$("#subtitle2").hide();
	$("#subpara2").hide();
//	$("#head1").fadeOut("2000");
//	$("#subtitle1").fadeOut("2000");
//	$("#subpara1").fadeOut("2000");
//	$("#head2").fadeIn("3000");
//	$("#subtitle2").fadeIn("3000");
//	$("#subpara2").fadeIn("3000");
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