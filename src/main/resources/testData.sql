drop table if exists locations;

create table locations (
	id int auto_increment primary key,
	owner varchar(100) not null,
	city varchar(50) not null,
	postcode varchar(5) not null,
	street varchar(50) not null,
	size int,
	price float,
	description varchar(1000) not null
);

insert into locations () Values
	('Max Müller', 'Musterstadt', '12345', 'Musterstraße 35', '150', '349,99');