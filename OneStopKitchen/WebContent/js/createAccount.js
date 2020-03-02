/**
 * Filename: createAccount.js 
 * Author: Nabeel Khan 
 * Creation Date: 3-02-20
 * Original Creation
 */

function validateAccountCreation(e) {
	e.preventDefault();
    console.log("im in boss");	
	const email = e.target[2].value;
	const pass = e.target[3].value;

	const emailCheck = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
	const passCheck = /[\w#!@$%^&*)(}{:">?;'.\/\\]{8,}/;

	if (!emailCheck.test(email)) {
		document.getElementById("loginEmail").setCustomValidity("Invalid Email Address, please try again");
	} else if(!passCheck.test(pass)){
		document.getElementById("createPassword").setCustomValidity("Password must be at least 8 characters long");
		return;
	} else{
		document.getElementById("loginEmail").setCustomValidity("");
		document.getElementById("createPassword").setCustomValidity("");
	}

}