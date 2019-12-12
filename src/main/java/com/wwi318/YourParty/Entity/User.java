package com.wwi318.YourParty.Entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Der Vorname darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[-a-zA-Z\\s]+", message = "Der Vorname darf nur Buchstaben und - enthalten.")
	private String firstname;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Der Nachname darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[-a-zA-Z\\s]+", message = "Der Nachname darf nur Buchstaben und - enthalten.")
	private String lastname;

	@NotNull(message = "Pflichtfeld")
	@Column(unique = true)
	@Size(min = 6, max = 50, message = "Der Username muss zwischen 6 und 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Der Username darf nur Aplhanumerisch sein.")
	private String username;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Die E-Mail darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z0-9.@-]+", message = "Die E-Mail darf nur Alphanumerisch sein.")
	private String email;

	@NotNull(message = "Pflichtfeld")
//	@Size(min = 8, max = 25, message = "Das Passwort muss zwischen 8 und 25 Zeichen sein.")
//	@Pattern(regexp = "[a-zA-Z0-9!.?]+", message = "Das Passwort darf nur Aplhanumerisch und !,.,? sein.")
	private String password;

	@Transient
	@NotNull(message = "Pflichtfeld")
//	@Size(min = 8, max = 25, message = "Das Passwort muss zwischen 8 und 25 Zeichen sein.")
//	@Pattern(regexp = "[a-zA-Z0-9!.?]+", message = "Das Passwort darf nur Aplhanumerisch und !,.,? sein.")
	private String passwordConfirm;

	@NotNull(message = "Pflichtfeld")
	private char gender;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Die Straße darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z\\s.-]+", message = "Die Straße darf nur Buchstaben und .,- enthalten.")
	private String street;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 10, message = "Die Hausnummer darf nicht länger als 10 Zeichen sein.")
	@Pattern(regexp = "[0-9/-]+", message = "Die Hausnummer darf nur Zahlen und /,- enthalten.")
	private String housenumber;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 5, message = "Die Postleitzahl darf nicht länger als 5 Zeichen sein.")
	@Pattern(regexp = "[0-9]+", message = "Die Postleitzahl darf nur Zahlen enthalten.")
	private String postcode;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Die Stadt darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z\\s-.]+", message = "Die Stadt darf nur Buchstaben und -,. enthalten.")
	private String city;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Das Land darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[a-zA-Z\\s-.]+", message = "Das Land darf nur Buchstaben und -,. enthalten.")
	private String country;

	@NotNull(message = "Pflichtfeld")
	@Size(min = 1, max = 50, message = "Die Telefonnummer darf nicht länger als 50 Zeichen sein.")
	@Pattern(regexp = "[0-9+-/\\s]+", message = "Die Telefonnummer darf nur Zahlen und +,-,/ enthalten.")
	private String phonenumber;
	
	@NotNull(message = "Pflichtfeld")
	private Date birthdate;

	@NotNull(message = "Pflichtfeld")
	private char type;

	private boolean active;

	@ManyToMany
	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setSurname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousnumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
