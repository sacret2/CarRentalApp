
function hideLoginButton() {
    document.getElementById("loginButton").style.display = "none";
    print("i was here");
    $('loginButton').click( function(e) {e.preventDefault(); e.style.display="none"; return false; } );

}