/**
 * function validateForm() { var x1 =
 * document.forms["register"]["firstname"].value; if (x1 == "") { alert("Vorname
 * eingeben"); return false; }
 * 
 * var x2 = document.forms["register"]["lastname"].value; if (x2 == "") {
 * alert("Nachname eingeben"); return false; }
 * 
 * var x3 = document.forms["register"]["gender"].value; if (x3 == "") {
 * alert("Geschlecht auswählen"); return false; }
 * 
 * var x4 = document.forms["register"]["birthday"].value; if (x4 == "") {
 * alert("Geburtsdatum muss angegeben werden"); return false; }
 * 
 * var x5 = document.forms["register"]["postcode"].value; if (x5 == "") {
 * alert("Postleitzahl muss angegeben werden"); return false; }
 * 
 * var x6 = document.forms["register"]["city"].value; if (x6 == "") {
 * alert("Wohnort muss angegeben werden"); return false; }
 * 
 * var x7 = document.forms["register"]["country"].value; if (x7 == "") {
 * alert("Land auswählen"); return false; }
 * 
 * var x8 = document.forms["register"]["street"].value; if (x8 == "") {
 * alert("Straße muss angegeben werden"); return false; }
 * 
 * var x9 = document.forms["register"]["housenumber"].value; if (x9 == "") {
 * alert("Hausnummer muss angegeben werden"); return false; }
 * 
 * var x10 = document.forms["register"]["username"].value; if (x10 == "") {
 * alert("Username angeben"); return false; }
 * 
 * var x11 = document.forms["register"]["email"].value; if (x11 == "") {
 * alert("E-Mail muss angegeben werden"); return false; }
 * 
 * var x12 = document.forms["register"]["phonenumber"].value; if (x12 == "") {
 * alert("Telefonnummer muss angegeben werden"); return false; }
 * 
 * var x13 = document.forms["register"]["type"].value; if (x13 == "") {
 * alert("Typ auswählen"); return false; }
 */
var password = document.getElementById('password');
var passwordConfirm = document.getElementById('passwordConfirm');

var checkPasswordValidity = function() {
	if (password.value != passwordConfirm.value) {
		passwordConfirm
				.setCustomValidity('Passwörter müssen miteinander übereinstimmen!');
	} else {
		passwordConfirm.setCustomValidity('');
	}
};
password.addEventListener('change', checkPasswordValidity);
passwordConfirm.addEventListener('change', checkPasswordValidity);
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
	
	var singleUploadForm = document.querySelector('#register');
	var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
	var singleFileUploadError = document.querySelector('#singleFileUploadError');
	var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');
	
	function uploadSingleFile(file) {
	    var formData = new FormData();
	    formData.append("file", file);

	    var xhr = new XMLHttpRequest();
	    xhr.open("POST", "/uploadProfilePicture");

	    xhr.onload = function() {
	        console.log(xhr.responseText);
	        var response = JSON.parse(xhr.responseText);
	        if(xhr.status == 200) {
	            singleFileUploadError.style.display = "none";
	            singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='" + response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a></p>";
	            singleFileUploadSuccess.style.display = "block";
	        } else {
	            singleFileUploadSuccess.style.display = "none";
	            singleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
	        }
	    }

	    xhr.send(formData);
	}
}
