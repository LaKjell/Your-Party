package com.wwi318.YourParty.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
	
	public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

	@RequestMapping(method = RequestMethod.GET, path = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getAllLocations() {
		return locationService.findAll();
	}

	/*
	 * //@Autowired LocationRepository locationRepository;
	 * 
	 * @GetMapping public Iterable findAll() { return locationRepository.findAll();
	 * }
	 * 
	 * @GetMapping("/name/{name}") public List findByTitle(@PathVariable String
	 * bookTitle) { return locationRepository.findByTitle(bookTitle); }
	 * 
	 * @GetMapping("/{id}") public Location findOne(@PathVariable Long id) { return
	 * locationRepository.findById(id) .orElseThrow(LocationNotFoundException::new);
	 * }
	 * 
	 * @PostMapping
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public Location create(@RequestBody
	 * Location location) { return locationRepository.save(location); }
	 * 
	 * @DeleteMapping("/{id}") public void delete(@PathVariable Long id) {
	 * locationRepository.findById(id).orElseThrow(LocationNotFoundException::new);
	 * locationRepository.deleteById(id); }
	 * 
	 * @PutMapping("/{id}") public Location updateLocation(@RequestBody Location
	 * location, @PathVariable Long id) { if (location.getId() != id) { throw new
	 * LocationIdMismatchException(); } locationRepository.findById(id)
	 * .orElseThrow(LocationNotFoundException::new); return
	 * locationRepository.save(location); }
	 */
}
