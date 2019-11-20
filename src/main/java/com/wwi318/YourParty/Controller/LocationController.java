package com.wwi318.YourParty.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;
import com.wwi318.YourParty.Controller.LocationController;
import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Repository.LocationRepository;
import com.wwi318.YourParty.Service.LocationService;

@RestController
public class LocationController {

	private LocationService locationService;

	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	// Alle Datensätze finden
	@RequestMapping(method = RequestMethod.GET, path = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getAllLocations() {
		return locationService.findAll();
	}

//	// Filterfunktion
//	@RequestMapping(method = RequestMethod.GET, value = "/location/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Location getSpecificLocation(@PathVariable String name) {
//		return null;
//
//	}
//
//	// Einzelnen Datensatz
//	@RequestMapping(method = RequestMethod.GET, value = "/location/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Location getSpecificLocationId(@PathVariable Integer id) {
//		if (locationService.findById(id).isPresent())
//			return locationService.findById(id).get();
//		else
//			return null;
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/location/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Location getSpecificLocationName(@PathVariable String name) {
//		if (locationService.findByName(name).isPresent())
//			return locationService.findByName(name).get();
//		else
//			return null;
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/location/{owner}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Location getSpecificLocationOwner(@PathVariable String owner) {
//		if (locationService.findByOwner(owner).isPresent())
//			return locationService.findByOwner(owner).get();
//		else
//			return null;
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/location/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Location getSpecificLocationCity(@PathVariable String city) {
//		if (locationService.findByCity(city).isPresent())
//			return locationService.findByCity(city).get();
//		else
//			return null;
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/location/{postcode}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Location getSpecificLocationPosctcode(@PathVariable String postcode) {
//		if (locationService.findByPostcode(postcode).isPresent())
//			return locationService.findByPostcode(postcode).get();
//		else
//			return null;
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/location/{size}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Location getSpecificLocationSize(@PathVariable Integer size) {
//		if (locationService.findBySize(size).isPresent())
//			return locationService.findBySize(size).get();
//		else
//			return null;
//	}
//
//	@RequestMapping(method = RequestMethod.GET, value = "/location/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Location getSpecificLocationPrice(@PathVariable Double price) {
//		if (locationService.findByPrice(price).isPresent())
//			return locationService.findByPrice(price).get();
//		else
//			return null;
//	}
//
//	// Funktionen anlegen, ändern, löschen
//	@RequestMapping(method = RequestMethod.POST, value = "location", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Location> createLocation(@RequestBody Location location) {
//		try {
//			Location results = locationService.save(location);
//			return ResponseEntity.created(new URI("/api/location/" + results.getid())).body(results);
//		} catch (Exception e) {
//			return new ResponseEntity<Location>(HttpStatus.CONFLICT);
//		}
//	}
//
//	@RequestMapping(method = RequestMethod.PUT, value = "location", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
//		if (location.getid() == null)
//			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
//
//		try {
//			Location results = locationService.update(location);
//			return ResponseEntity.created(new URI("/api/location/" + results.getid())).body(results);
//		} catch (Exception e) {
//			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@RequestMapping(method = RequestMethod.DELETE, value = "/location/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> deleteLocation(@PathVariable Integer id) {
//		locationService.delete(id);
//		return ResponseEntity.ok().build();
//	}

	/*
	 * 
	 * @GetMapping("/name/{name}") public List findByTitle(@PathVariable String
	 * bookTitle) { return locationRepository.findByTitle(bookTitle); }
	 * 
	 * @GetMapping("/{id}") public Location findOne(@PathVariable Long id) { return
	 * locationRepository.findById(id) .orElseThrow(LocationNotFoundException::new);
	 * }
	 * 
	 */
}
