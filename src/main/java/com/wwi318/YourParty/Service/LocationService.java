package com.wwi318.YourParty.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Repository.LocationRepository;

@Service
public class LocationService {

	private LocationRepository locationRepository;
	
	@Autowired
    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }
	
	public List<Location> findAll(){
        return locationRepository.findAll();
    }
}
