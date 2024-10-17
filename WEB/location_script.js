document.getElementById("getLocation").addEventListener("click", 
    function() {
        document.getElementById("loader").style.display = "flex";
        document.getElementById("latitud").disabled = true;
        document.getElementById("longitud").disabled = true;
        document.getElementById("getLocation").style.display = "none";
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition, showError);
        } else {
            alert("Geolocation is not supported by this browser.");
        }
});

function showPosition(position) {
    document.getElementById("latitud").disabled = false;
    document.getElementById("longitud").disabled = false;

    document.getElementById("latitud").value = position.coords.latitude;
    document.getElementById("longitud").value = position.coords.longitude;
    
    document.getElementById("loader").style.display = "none";
    document.getElementById("getLocation").style.display = "inline-block";
}

function showError(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            alert("User denied the request for Geolocation.");
            break;
        case error.POSITION_UNAVAILABLE:
            alert("Location information is unavailable.");
            break;
        case error.TIMEOUT:
            alert("The request to get user location timed out.");
            break;
        case error.UNKNOWN_ERROR:
            alert("An unknown error occurred.");
            break;
    }
}
