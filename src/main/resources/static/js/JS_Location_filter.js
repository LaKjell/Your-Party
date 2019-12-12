/**
 * 
 */
function Locationfilter() {
	var boxes = document.getElementById('flex');
	boxes.innerHTML = "";
		
		$.get("location#text", function(data){
			var dbloc = data; 
			for (let i=0; i<dbloc.length; i++) {
			    var locations = dbloc[i];
			    if(locations.city == document.getElementById("inlineFormCustomSelectCity").value || document.getElementById("inlineFormCustomSelectCity").value == 0 ){
			    	if(		document.getElementById("inlineFormCustomSelectPrice").value == 1 && locations.price < 100 || 
			    			document.getElementById("inlineFormCustomSelectPrice").value == 2 && locations.price >= 100 && locations.price <= 300  || 
			    			document.getElementById("inlineFormCustomSelectPrice").value == 3 && locations.price > 300 ||
			    			document.getElementById("inlineFormCustomSelectPrice").value == 0){
			    		
			    	
			    		if(		document.getElementById("inlineFormCustomSelectSize").value == 1 && locations.size < 50 || 
				    			document.getElementById("inlineFormCustomSelectSize").value == 2 && locations.size >= 50 && locations.size <= 150  || 
				    			document.getElementById("inlineFormCustomSelectSize").value == 3 && locations.size > 150 ||
				    			document.getElementById("inlineFormCustomSelectSize").value == 0){
			    			
			    var boxes = document.getElementById('flex');
			    
				

				var col12 = document.createElement('div');
				var row = document.createElement('div');
				var col6i = document.createElement('div'); 
				var col6t = document.createElement('div');
				var col12d = document.createElement('div');
				var collaps = document.createElement('div');
				
				var head = document.createElement('h2');
				var text = document.createElement('p');
				var img = document.createElement('img');
				var tab = document.createElement('table')
				var but = document.createElement('button');
				var butb = document.createElement('a');

				head.innerHTML = locations.name;

				text.innerHTML = locations.description;
				text.setAttribute('style', 'align-self: right');

				img.setAttribute('src', 'img/douala.jpg');
				img.setAttribute('alt', '...');
				img.setAttribute('align', 'left');
				img.setAttribute('class', 'img-fluid');

				
				tab.innerHTML = "<tbody><tr><th scope='row'>Preis</th><td>" + locations.price + " EUR </td></tr><tr><th scope='row'>Größe</th><td>"+locations.size+" m² </td></tr><tr><th scope='row'>Straße</th><td>"+ locations.street +"</td></tr><tr><th scope='row'>Ort</th><td>"+ locations.city +"</td></tr><tr><th scope='row'>Besitzer</th><td>"+ locations.owner +"</td></tr></tbody>";
				tab.setAttribute('class', 'table table-borderless table-sm')

				
				but.setAttribute('class', 'btn btn btn-primary float-right');
				but.setAttribute('data-toggle', 'collapse');
				but.setAttribute('data-target', '#a' + locations.id);
				but.innerHTML = "Mehr";
				
				butb.setAttribute('class', 'btn btn btn-primary float-left');
				butb.setAttribute('href', 'Locations/buchen');
				butb.innerHTML = "Jetzt buchen";
				butb.setAttribute('onclick', 'function sichern () {storage.set("id", ' + location.id + ') }')
				
				col6t.setAttribute('class', 'col-md-6');
				col6i.setAttribute('class', 'col-md-6');
				collaps.setAttribute('id', 'a' + locations.id);
				collaps.setAttribute('class', 'collapsing');
				col12d.setAttribute('class', 'col-md-12');
				
				row.setAttribute('class', 'row' );
				//row.setAttribute('id', 'loc');
				
				
				col12.setAttribute('class', 'col-md-12 jumbotron');
				
				collaps.appendChild(tab);
				
				col6i.appendChild(img);
				
				col6t.appendChild(head);
				col6t.appendChild(text);
				
				col12d.appendChild(butb);
				col12d.appendChild(but);
				col12d.appendChild(collaps);

				row.appendChild(col6i);	
				row.appendChild(col6t);
				row.appendChild(col12d);
				
				col12.appendChild(row);
				

				boxes.appendChild(col12);
			    }
			}
			    }
			}
			});
	
}