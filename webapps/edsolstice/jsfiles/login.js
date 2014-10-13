	var caption = ['Videos','Knowledge Sharing','Forums','All @ One'];
	var description = ['Desc About the Video Functionality ',
						'Desc about knowledge sharing',
						'Desc about Forums',
						'Desc about all professsionals at one place'];
	var animInterval;

$( document ).ready(function() {
	$(".spinner-2").hide();
	resetAll();
	$("#slidePanel").show();
	$("#loginPanel").show();	
	
	slider();	
});

function resetAll(){
	$("#content1").children().hide();
}


function slider(){
		var images=$("#slides").children();	
		i=0;
		function run(){			
			$("#description").fadeOut(1000,function(){
				$("#slides p").fadeOut(1000,function(){
					$(images[i]).fadeOut(2000);
					i++;
					if(i==4){i=0;}
					$(images[i]).fadeIn(2000,function(){
						$("#slides p").text(caption[i]).fadeIn(1000,function(){
							$("#description").text(description[i]).fadeIn(1000);
						});
					});	
				});
			});
			animInterval=setTimeout(run,8500);	
		}
		setTimeout(run,3000);
	}

$("#signupicon").bind ("click", function(){
	resetAll();
	$("#registrationpanel").show();
	
});

$("#aboutusicon").bind ("click", function(){
	resetAll();
	$("#aboutuspanel").show();
	
});

$("#homeicon").bind ("click", function(){
	resetAll();
	$("#slidePanel").show();
	$("#loginPanel").show();	
	
});

$("#notificationicon").bind ("click", function(){
	resetAll();	
});

$("#feedbackicon").bind ("click", function(){
	resetAll();	
	$("#feedbackpanel").show();
});
$("#contactusicon").bind ("click", function(){
	resetAll();	
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

//$("#email").bind ("blur	", function(){
//	if($("#email").val() == ''){
//		$("#emailerrormessage").show();
//		return false;
//	}else{
//		$("#emailerrormessage").hide();
//		return true;
//	}
//});
//
//$("#password").bind ("blur	", function(){
//	if($("#email").val() == ''){
//		$("#passworderrormessage").show();
//		return false;
//	}else{
//		$("#passworderrormessage").hide();
//		return true;
//	}
//});