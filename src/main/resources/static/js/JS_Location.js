/**
 * 
 */

function Location() {
	
	let ArrayOne = ['Douala', 'img/douala.jpg', 'Douala in Ravensburg:', 'Der renommierte Club mit Baustellen-Charme, Graffiti und Tropen-Flair ist bekannt für Raves und berühmte DJs. Das Douala in Ravensburg bietet Ihnen die Möglichkeit eine ordentliche Sause mit all ihren Besten zu veranstalten. Sie fühlen den Beat und sind von modernen Drogen nicht abgeneigt? Dann sind Sie hier genau richtig!'];

	var boxes = document.getElementById('flex');

	console.log(boxes);

	var col12 = document.createElement('div');
	var row = document.createElement('div');
	var col6i = document.createElement('div'); 
	var col6t = document.createElement('div');
	
	var head = document.createElement('h2');
	var text = document.createElement('p');
	var img = document.createElement('img');
	

	text.innerHTML = ArrayOne[3];
	text.setAttribute('style', 'align-self: right');
	//.setAttribute('style', 'align: right');

	head.innerHTML = ArrayOne[2];

	img.setAttribute('src', ArrayOne[1]);
	img.setAttribute('alt', ArrayOne[0]);
	img.setAttribute('align', 'left');

	row.setAttribute('id', 'loc');
	
	col6t.setAttribute('class', 'col-md-6');
	col6i.setAttribute('class', 'col-md-6');
	
	row.setAttribute('class', 'row' );
	row.setAttribute('id', 'loc');
	
	col12.setAttribute('class', 'col-md-12');
	
	col6i.appendChild(img);
	
	col6t.appendChild(head);
	col6t.appendChild(text);
	

	row.appendChild(col6i);	
	row.appendChild(col6t);
	
	
	col12.appendChild(row);
	

	boxes.appendChild(col12);
	console.log(box);
	}
