/**
 * 
 */
function My_Profil() {
	
	$.get("username#text", function(data){
		var data = data;
	
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
		
		
		col3l.appendChild(col12l);
		col6.appendChild(col12m);
		col3r.appendChild(col12r);
		
		boxes.appendChild(col3l);
		boxes.appendChild(col6);
		boxes.appendChild(col3r);
	});
}