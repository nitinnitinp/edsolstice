 $("#save").click(function() {
	 
	 alert("mnbvcnvnmnvmnmcnv");
	 
	var form_data = new FormData($('#upload-file')[0]);
    $.ajax({
        type : "POST",
        url : "/edsolstice/rest/uploadservice/upload",
        data: form_data,
        contentType: false,
        cache: false,
        processData: false,
        async: false,
        success : function (data) {
        	alert("mnbvcnvnmnvmnmcnv");

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {

        }
    });
     });
