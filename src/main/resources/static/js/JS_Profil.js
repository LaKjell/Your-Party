/**
 * 
 */
function My_Profil() {
	
	$.get("username", function(data){
		var users = data;
		alert(users);
		var boxes = document.getElementById('flex');
		
		var col3l = document.createElement('div');
		var col12l = document.createElement('div');
		var col6 = document.createElement('div');
		var col12m = document.createElement('div');
		var col3r = document.createElement('div');
		var col12r = document.createElement('div');
		
		col3l.setAttribute('class','col-md-3 bord');
		col12l.setAttribute('class','col-md-12 jumbotron');
		col6.setAttribute('class','col-md-6 bord');
		col12m.setAttribute('class','col-md-12 jumbotron');
		col3r.setAttribute('class','col-md-3 bord');
		col12r.setAttribute('class','col-md-12 jumbotron');
		
		col12l.innerHTML = '<img class="d-block w-100" alt="picture" src="/img/Saal.jpg">';
		
		var h2m1 = document.createElement('h2');
		var pm1 = document.createElement('p');
		
		h2m1.innerHTML= "Über mich";
		pm1.innerHTML= "Vorname: <br> &nbsp;&nbsp;&nbsp;&nbsp;	" + user.vorname + "<br> <br> Nachname: <br> &nbsp;&nbsp;&nbsp;&nbsp;" + user.nachname + "<br> <br> Geschlecht:<br> &nbsp;&nbsp;&nbsp;&nbsp; " + user.geschlecht + "<br><br>  Geburtsdatum:<br> &nbsp;&nbsp;&nbsp;&nbsp; " + user.geburtsdatum ;
	
		col12m.appendChild(h2m1);
		col12m.appendChild(pm1);
		
		var h2m2 = document.createElement('h2');
		var pm2 = document.createElement('p');
		
		h2m2.innerHTML= "Woher du kommst";
		pm2.innerHTML= user.street + "&nbsp;" + user.housenumber + "<br>" + user.postalcode + "&nbsp;" + user.ort + "<br>" + user.country;
			
		col12m.appendChild(h2m2);
		col12m.appendChild(pm2);
		
		var h2m3 = document.createElement('h2');
		var pm3 = document.createElement('p');
		
		h2m3.innerHTML= "Kontakt zu dir";
		pm3.innerHTML= user.email + "&nbsp;&nbsp;&nbsp;&nbsp;" + user.phonenumber;
		
		col12m.appendChild(h2m3);
		col12m.appendChild(pm3);
		
		var h2m4 = document.createElement('h2');
		var pm4 = document.createElement('p');
		
		h2m4.innerHTML= "Du bist";
		pm4.innerHTML= user.type;
		
		col12m.appendChild(h2m4);
		col12m.appendChild(pm4);
		
		col3l.appendChild(col12l);
		col6.appendChild(col12m);
		col3r.appendChild(col12r);
		
		boxes.appendChild(col3l);
		boxes.appendChild(col6);
		boxes.appendChild(col3r);
	});
}