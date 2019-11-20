package com.wwi318.YourParty.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.wwi318.YourParty.Entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
//	
//	 <S extends Location> S save(S entity);      

	  Optional<Location> findById(ID primaryKey); 
	  
	  Optional<Location> findByName(String name);
	  
	  Optional<Location> findByOwner(String owner);
	  
	  Optional<Location> findByCity(String city);
	  
	  Optional<Location> findByPostcode(String postcode);
	  
	  Optional<Location> findBySize(Integer size);
	  
	  Optional<Location> findByPrice(Double price);

	  List<Location> findAll();               

//	  long count();                        
//
//	  void delete(Location entity);               
//
//	  boolean existsById(ID primaryKey);
	  
}
