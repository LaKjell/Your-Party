
var password = document.getElementById('password');
var passwordConfirm = document.getElementById('passwordConfirm');

var checkPasswordValidity = function() {
	if (password.value != passwordConfirm.value) {
		passwordConfirm
				.setCustomValidity('Passwörter müssen miteinander übereinstimmen!');
	} else {
		passwordConfirm.setCustomValidity('');
	}
}
password.addEventListener('change', checkPasswordValidity);
passwordConfirm.addEventListener('change', checkPasswordValidity);


<<<<<<< HEAD
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

=======
>>>>>>> branch 'master' of https://github.com/schla-ma/Your-Party.git
