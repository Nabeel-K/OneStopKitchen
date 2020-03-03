/**
 * Filename: createAccount.js 
 * Author: Nabeel Khan 
 * Creation Date: 3-02-20
 * Original Creation
 */

function validateAccountCreation(e) {
	const email = e.target[2].value;
	const pass = e.target[3].value;

	
	const emailCheck = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
	const passCheck = /[\w#!@$%^&*)(}{:">?;'.\/\\]{8,}/;

	if (!emailCheck.test(email)){
		alert("Invalid email address, please try again");
		e.preventDefault();

	} else if(!passCheck.test(pass)) {
		alert("Password must be 8 or more characters, please try again");
		e.preventDefault();
	} 

}
