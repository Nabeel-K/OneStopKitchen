/**
 * 
 */

function validateLogin(e) {
    e.preventDefault();

    //Get values from event
    const userEmail = e.target[0].value;
    const userPassword = e.target[1].value;

    //Regex to check basic email and password syntax
    const emailCheck = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
//    const passwordCheck = /[\w#!@$%^&*)(}{:">?;'.\/\\]+/;
//    || !passwordCheck.test(userPassword)
    if (!emailCheck.test(userEmail)) {
        document.getElementById("errorMessage").innerHTML = "Invalid Email Address";
    } else {
        window.location.replace("./index.jsp");
    }

}