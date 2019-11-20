/**
 * 
 */
function validateForm() {
	var x1 = document.forms["register"]["vorname"].value;
	if (x1 == "") {
		alert("Vorname muss ausgefüllt sein");
		return false;
	}

	var x2 = document.forms["register"]["nachname"].value;
	if (x2 == "") {
		alert("Nachname muss ausgefüllt sein");
		return false;
	}

	var x3 = document.forms["register"]["username"].value;
	if (x3 == "") {
		alert("Username muss ausgefüllt sein");
		return false;
	}

	var x4 = document.forms["register"]["e-mail"].value;
	if (x4 == "") {
		alert("E-Mail muss ausgefüllt sein");
		return false;
	}

	var x5 = document.forms["register"]["straße"].value;
	if (x5 == "") {
		alert("Straße muss ausgefüllt sein");
		return false;
	}

	var x6 = document.forms["register"]["hausnummer"].value;
	if (x6 == "") {
		alert("Hausnummer muss ausgefüllt sein");
		return false;
	}

	var x7 = document.forms["register"]["plz"].value;
	if (x7 == "") {
		alert("Postleitzahl muss ausgefüllt sein");
		return false;
	}

	var x8 = document.forms["register"]["ort"].value;
	if (x8 == "") {
		alert("Wohnort muss ausgefüllt sein");
		return false;
	}
}