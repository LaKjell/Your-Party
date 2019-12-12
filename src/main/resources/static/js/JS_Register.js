<<<<<<< HEAD
var password = document.getElementById('password');
var passwordConfirm = document.getElementById('passwordConfirm');
=======

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

>>>>>>> branch 'master' of https://github.com/schla-ma/Your-Party.git

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