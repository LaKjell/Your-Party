/**
 * 
 */
function Booking(){
	
var liste = storage.getAll();

document.getElementById('locationId').setAttribute('value','liste.id');
$.get("username", function(data){
	var user = data;

document.getElementById('userId').setAttribute('value','user.id');
});
}