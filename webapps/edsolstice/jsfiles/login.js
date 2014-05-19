// Make sure that the error state element is hidden.
$(".ui-state-error").hide();

// Call the button widget method on the login button to format it. 
$("#btnLogin").button().bind ("click", function(){
    // Test our form for a valid login.  
    // Our form only works with:
    //     username: script
    //     password: junkie
    if ( $("#username").val() != "admin" 
        && $("#password").val() != "admin") {
        
            // If the login credentials are not correct,
            // show our error state element.
            $(".ui-state-error").show();
            // Add an jQuery UI effect that shakes the whole login form
            // like as if it's shaking its head no.
            $("#login section").effect("shake", 150 );
    } else {
            // If the login credentials are correct, go to the todo page.
            document.location = 'todo.html';
    }
            
    // return false to cancel normal form submit event methods.
    return false;
});

$("#btnsignUp").button().bind ("click", function(){
            document.location = 'html/registration.html';
            

    return false;
});
