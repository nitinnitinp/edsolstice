$("#logout").bind ("click", function(){
	
            $.ajax( {
        		type: 'POST',
        		url: '/edsolstice/rest/sessionservice/logout',
        		contentType:'application/json',
        		headers: {'sessionToken': sessionStorage.getItem('sessionToken')},
        		dataType: 'json',
        		error: function(jqXHR, textStatus, ex) {
        			alert(textStatus);
        		},
        		success : function(textStatus){
        			document.location = 'index.html';	
         		}
        	}
        	);
            return false;   
});
