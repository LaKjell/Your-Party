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
