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
			    var boxes = document.getElementById('flex');
			    
				console.log(boxes);

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
			
//				var tbody = document.createElement('tbody');
//				var trf = document.createElement('tr');
//				var thf = document.createElement('th');
//				var tdf = document.createElement('td');
				head.innerHTML = locations.name;

				text.innerHTML = locations.description;
				text.setAttribute('style', 'align-self: right');

				img.setAttribute('src', 'img/douala.jpg');
				img.setAttribute('alt', '...');
				img.setAttribute('align', 'left');
				img.setAttribute('class', 'img-fluid');

				
				tab.innerHTML = "<tbody><tr><th scope='row'>Preis</th><td>" + locations.price + " EUR </td></tr><tr><th scope='row'>Größe</th><td>"+locations.size+" m² </td></tr><tr><th scope='row'>Straße</th><td>"+ locations.street +"</td></tr><tr><th scope='row'>Ort</th><td>"+ locations.city +"</td></tr><tr><th scope='row'>Besitzer</th><td>"+ locations.owner +"</td></tr></tbody>";
				tab.setAttribute('class', 'table table-borderless')
//				th.setAttribute('scope', 'row');
				
				but.setAttribute('class', 'btn btn btn-primary float-right');
				but.setAttribute('data-toggle', 'collapse');
				but.setAttribute('data-target', '#details');
				but.innerHTML = "Mehr";
				
				col6t.setAttribute('class', 'col-md-6');
				col6i.setAttribute('class', 'col-md-6');
				collaps.setAttribute('id', 'details');
				collaps.setAttribute('class', 'collapsing');
				col12d.setAttribute('class', 'col-md-12');
				
				row.setAttribute('class', 'row' );
				//row.setAttribute('id', 'loc');
				
				
				col12.setAttribute('class', 'col-md-12 jumbotron');
				
				collaps.appendChild(tab);
				
				col6i.appendChild(img);
				
				col6t.appendChild(head);
				col6t.appendChild(text);
				
				col12d.appendChild(but);
				col12d.appendChild(collaps);

				row.appendChild(col6i);	
				row.appendChild(col6t);
				row.appendChild(col12d);
				
				col12.appendChild(row);
				

				boxes.appendChild(col12);
			}
			
			});
	
}