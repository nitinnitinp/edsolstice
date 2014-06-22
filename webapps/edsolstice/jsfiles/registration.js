$("#save").button().bind ("click", function() {
 //  var registration = new Registration();
  //  registration.init();
    //registration.validate();

	$.ajax( {

		type: 'POST',
		url: '/edsolstice/rest/registrationservice/users',
		contentType:'application/json',
		async: false,


		data: JSON.stringify ({ 
			"userName": $("#fname").val(), 
			"surName": $("#lname").val(),
			"password": $("#password").val(), 
			"cPassword": $("#cpassword").val(),
			"department": $("#stream").val(),
			"college": $("#college").val(),
			"mobile": $("#mobilenumber").val(),
			"email": $("#email").val(),
			"gender": $("#gender").val(),
			"fieldOfInterest": $("#fieldOfInterest").val(),
//			"role": $("#type").val()


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


//$(document).ready(function() {
//$("#registration").validate({
//	
//rules: {
//	
//// no quoting necessary
//mobile: "required"
//},
//messages: {
//	mobile: "Please enter your first name"
//}
//});
//});

$(document).ready(function(){
	  $("p").click(function(){
	    $(this).hide();
	  });
	});x

//function Registration () {
//	
//	this.userName = $("#fname").val();
//	this.surName = $("#lname").val();
//	this.password = $("#password").val(); 
//	this.cPpassword = $("#cPpassword").val();
//	this.department = $("#department").val();
//	this.college = $("#college").val();
//	this.mobile = $("#mobile").val();
//	this.emailId = $("#emailId").val()
//	this.role = $("#type").val();
//
//	} 
//
//
//Registration.prototype.validate = function () {
//    	
//	var nameReg = /^[A-Za-z]+$/;
//	var numberReg =  /^[0-9]+$/;
//	var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
//
//	//$('.error').hide();
//
//	if(this.userName == ""){
//		$('#fname').after('<span class="error"> Please enter your first name</span>');
//	} 
//	else if(!nameReg.test(this.userName)){
//		$('#fname').after('<span class="error"> Letters only</span>');
//	}
//
//	if(this.surName == ""){
//		$('#lname').after('<span class="error"> Please enter your last name</span>');
//	} 
//	else if(!nameReg.test(this.surName)){
//		$('#lname').after('<span class="error"> Letters only</span>');
//	}
//
//	if(this.emailId == ""){
//		$('#emailId').after('<span class="error"> Please enter your email </span>');
//	} 
//	else if(!emailReg.test(this.emailId)){
//		$('#emailId').after('<span class="error"> Please enter a valid email address</span>');
//	}
//
//	if(this.mobile == ""){
//		$('#mobile').after('<span class="error"> Please enter your mobile</span>');
//	} 
//	else if(!numberReg.test(this.mobile)){
//		$('#mobile').after('<span class="error"> Numbers only</span>');
//	}
//return false ;
//
//}   

