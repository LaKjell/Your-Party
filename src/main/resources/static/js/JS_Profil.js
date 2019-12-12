/**
 * 
 */
function My_Profil() {
	
	$.get("username", function(data){
		var user = data;
		
		var boxes = document.getElementById('flex');
		
		var col4l = document.createElement('div');
		var col12l = document.createElement('div');
		var col8 = document.createElement('div');
		var col12m = document.createElement('div');
		var col3r = document.createElement('div');
		var col12r = document.createElement('div');
		
		col4l.setAttribute('class','col-md-4 bord');
		col12l.setAttribute('class','col-md-12 jumbotron');
		col8.setAttribute('class','col-md-8 bord');
		col12m.setAttribute('class','col-md-12 jumbotron');
//		col3r.setAttribute('class','col-md-3 bord');
//		col12r.setAttribute('class','col-md-12 jumbotron');
		
		col12l.innerHTML = '<img class="d-block w-100" alt="picture" src="/downloadFile/' + user.username + '.jpg">';
		
		var h2m1 = document.createElement('h2');
		var pm1 = document.createElement('p');
		
		h2m1.innerHTML= "Über mich";
		/**
		pm1.innerHTML= "Vorname: <br> &nbsp;&nbsp;&nbsp;&nbsp;	" + user.firstname + "<br> <br> Nachname: <br> &nbsp;&nbsp;&nbsp;&nbsp;" + user.lastname + "<br> <br> Geschlecht:<br> &nbsp;&nbsp;&nbsp;&nbsp; " + user.gender + "<br><br>  Geburtsdatum:<br> &nbsp;&nbsp;&nbsp;&nbsp; " + user.gg ;
		*/
		if(user.gender == "m"){pm1.innerHTML= "Vorname:  &nbsp;&nbsp;&nbsp;&nbsp;	" + user.firstname + "<br> <br> Nachname:  &nbsp;&nbsp;&nbsp;&nbsp;" + user.lastname + "<br> <br> Geschlecht:&nbsp;&nbsp;&nbsp;&nbsp; " + "Männlich" + "<br><br>  Geburtsdatum: &nbsp;&nbsp;&nbsp;&nbsp; " + user.birthdate ;}
		else{pm1.innerHTML="Vorname:  &nbsp;&nbsp;&nbsp;&nbsp;	" + user.firstname + "<br> <br> Nachname:  &nbsp;&nbsp;&nbsp;&nbsp;" + user.lastname + "<br> <br> Geschlecht:&nbsp;&nbsp;&nbsp;&nbsp; " + "Weiblich" + "<br><br>  Geburtsdatum: &nbsp;&nbsp;&nbsp;&nbsp; " + birthdate;;};
		col12m.appendChild(h2m1);
		col12m.appendChild(pm1);
		
		var h2m2 = document.createElement('h2');
		var pm2 = document.createElement('p');
		
		h2m2.innerHTML= "Woher du kommst";
		pm2.innerHTML= user.street + "&nbsp;" + user.housenumber + "<br>" + user.postcode + "&nbsp;" + user.city + "<br>" + user.country;
			
		col12m.appendChild(h2m2);
		col12m.appendChild(pm2);
		
		var h2m3 = document.createElement('h2');
		var pm3 = document.createElement('p');
		
		h2m3.innerHTML= "Kontakt zu dir";
		pm3.innerHTML= user.email + "&nbsp;&nbsp;&nbsp;&nbsp; <br>" + user.phonenumber;
		
		col12m.appendChild(h2m3);
		col12m.appendChild(pm3);
		
		var h2m4 = document.createElement('h2');
		var pm4 = document.createElement('p');
		
		h2m4.innerHTML= "Du bist";
		if(user.type == "v"){pm4.innerHTML= "Vermieter";}else{pm4.innerHTML="Mieter";};
		
		col12m.appendChild(h2m4);
		col12m.appendChild(pm4);
		
		col4l.appendChild(col12l);
		col8.appendChild(col12m);
//		col3r.appendChild(col12r);
		
		boxes.appendChild(col4l);
		boxes.appendChild(col8);
//		boxes.appendChild(col3r);
	});
}