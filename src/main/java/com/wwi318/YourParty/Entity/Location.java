package com.wwi318.YourParty.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Der Name darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z\\s]+", message = "Der Name darf nur Buchstaben enthalten.")
	private String name;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Der Besitzer darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z\\s-]+", message = "Der Besitzer darf nur Buchstaben enthalten.")
	private String owner;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Die Stadt darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z\\s-.]+", message = "Die Stadt darf nur Buchstaben und -,. enthalten.")
	private String city;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 5, message = "Die Postleitzahl darf nicht länger als 5 Zeichen sein.")
	@Pattern(regexp = "[0-9]+", message = "Die Postleitzahl darf nur Zahlen enthalten.")
	private String postcode;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Die Straße darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z\\s.-]+", message = "Die Straße darf nur Buchstaben und .,- enthalten.")
	private String street;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 10, message = "Die Hausnummer darf nicht länger als 10 Zeichen sein.")
	@Pattern(regexp = "[0-9/-]+", message = "Die Hausnummer darf nur Zahlen und /,- enthalten.")
	private String housenumber;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Das Land darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z\\s-.]+", message = "Das Land darf nur Buchstaben und -,. enthalten.")
	private String country;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 10, message = "Die Fläche darf nicht länger als 10 Zeichen sein.")
	@Pattern(regexp = "[0-9]+", message = "Die Fläche darf nur Zahlen enthalten.")
	private Integer size;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 10, message = "Der Preis darf nicht länger als 10 Zeichen sein.")
	@Pattern(regexp = "[0-9,.]+", message = "Der Preis darf nur Zahlen und ,,. enthalten.")
	private double price;

	@NotNull(message = "Pflichtfeld")
	@Column(name = "description", length = 100000)
	private String description;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

}
