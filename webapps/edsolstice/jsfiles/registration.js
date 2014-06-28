$("#save").bind ("click", function() {

	$.ajax( {

		type: 'POST',
		url: '/edsolstice/rest/registrationservice/users',
		contentType:'application/json',
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
			document.location = 'useractivation.html';		
		}
	}
	);
	return false;
});


function validateTextFields(fieldId, errormessage , msgid ,targetId , type){
	var pattern = /^[A-Za-z]+$/;
	if(type == 'number'){
		pattern =  /^[0-9]+$/;
	}else if(type == 'email'){
		pattern =  /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	}
	else{
		pattern = /^[A-Za-z]+$/;
	}
	var inputvalue = $("#"+fieldId).val();
	if(inputvalue == '' || !(pattern.test(inputvalue))){
		if($('#'+msgid).length == 0){
			$('#'+targetId).after('<div id="'+msgid+'" style="padding-bottom:10px;color:#522675">' +errormessage+'</div>');
		}		
	}else{
		$('#'+msgid).remove();
	}
}



$("#fname").bind("blur",function(){
	validateTextFields('fname' , 'Please enter valid Firstname' , 'fnameerror' , 'lname');
	
});

$("#lname").bind("blur",function(){
	validateTextFields('lname' , 'Please enter valid Lastname' , 'fnameerror' , 'lname');
});

$("#mobilenumber").bind("blur",function(){
	validateTextFields('mobilenumber' , 'Please enter valid Mobile Number' , 'mnumerr' , 'mobilenumber' , 'number');
});

$("#email").bind("blur",function(){
	validateTextFields('email' , 'Please enter valid Email Id' , 'emailerr' , 'email' , 'email');
});

$("#cpassword").bind("blur",function(){
	if($("#cpassword").val() != $("#password").val()){
		if($('#pwderr').length == 0){
			$('#cpassword').after('<div id="pwderr" style="padding-bottom:10px;color:#522675"> Password and Confirm Password should be same</div>');
		}
	}else{
		$('#pwderr').remove();
	}
});