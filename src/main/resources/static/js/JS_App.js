
function Register(vorname, nachname, username, email, password, beschreibung,
		gender, land) {
	let vn = document.querySelector("#vorname").value;
	let nn = document.querySelector("#nachname").value;
	let un = document.querySelector("#username").value;
	let em = document.querySelector("#email").value;
	let pw = document.querySelector("#password").value;
	let beschr = document.querySelector("#beschreibung").value;
	let gn = document.querySelector('input[name="gender"]:checked').value;
	let la = document.querySelector("#land").value;

	let UserSignUp = {
		Vorname : vn,
		Nachname : nn,
		Username : un,
		Email : em,
		Passwort : pw,
		Beschreibung : beschr,
		Geschlecht : gn,
		Land : la
	}
	alert('Vorname: ' + vn + ' ' + 'Nachname: ' + nn + ' ' + 'Username: ' + un + ' '
			+ 'Email: ' + em + ' ' + 'Passwort: ' + pw + ' ' + 'Beschreibung: '
			+ beschr + ' ' + 'Geschlecht: ' + gn + ' ' + 'Land: ' + la);
};
	
function Login(username, password) {
	var username = document.querySelector("#username").value;
	var password = document.querySelector("#password").value;
	const UserSignIn = {
		Username : username,
		Passwort : password
	};
	console.log(UserSignIn);
	alert('Username: ' + username + '   ' + 'Passwort: ' + password);
	
};
	
function Profil() {
	
}