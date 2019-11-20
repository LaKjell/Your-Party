package com.wwi318.YourParty.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Repository.LocationRepository;

@Service
public class LocationService {

	private LocationRepository locationRepository;

	@Autowired
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	// alle Datensätze
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	// einzelnen Datensatz finden
	public Optional<Location> findById(Integer id) {
		return locationRepository.findById(id);
	}
	
	public Optional<Location> findByName(String name)  {
			return locationRepository.findByName(name);
	}
	
	public Optional<Location> findByOwner(String owner) {
		return locationRepository.findByOwner(owner);
	}
	
	public Optional<Location> findByCity(String city) {
		return locationRepository.findByCity(city);
	}
	
	public Optional<Location> findByPostcode(String postcode) {
		return locationRepository.findByPostcode(postcode);
	}
	
	public Optional<Location> findBySize(Integer size) {
		return locationRepository.findBySize(size);
	}
	
	public Optional<Location> findByPrice(Double price) {
		return locationRepository.findByPrice(price);
	}
//	public Optional<Location> findOneId(Integer id){
//  return locationRepository.findOne( <> id);
//}

//	public Optional<Location> findOneName(String name){
//        return locationRepository.findOne( <> name);
//    }

	// Funktionen (speichern, ändern, löschen
	public Location save(Location location) {
		if (location.getid() != null && locationRepository.existsById(location.getid())) {
			throw new EntityExistsException("There is an entity with such an ID");
		}
		return locationRepository.save(location);
	}

	public Location update(Location location) {
		if (location.getid() != null && locationRepository.existsById(location.getid())) {
			throw new EntityExistsException("There is an entity with such an ID");
		}
		return locationRepository.save(location);
	}

	public void delete(Integer id) {
		locationRepository.deleteById(id);
	}

}
