package com.wwi318.YourParty.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wwi318.YourParty.Entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	
//	 <S extends Location> S save(S entity);      

	  Optional<Location> findById(Integer id);
	  
	  Optional<Location> findByName(String name);
	  
	  Optional<Location> findByOwner(String owner);
	  
	  Optional<Location> findByCity(String city);
	  
	  Optional<Location> findByPostcode(String postcode);
	  
	  Optional<Location> findBySize(Integer size);
	  
	  Optional<Location> findByPrice(Double price);

	  List<Location> findAll();    
	  
//	  @Query(value = "SELECT * FROM location as loc"
//	  		+ "WHERE loc.city = city", 
////	  		 AND loc.price between priceu AND priceo "
////	  		  		+ "AND loc.size BETWEEN sizeu AND sizeo
//				nativeQuery = true)
//	  Location findByFilter(@Param("city") String city, @Param("priceu")int priceu, int priceo, int sizeu, int sizeo);

//	  long count();                        
//
//	  void delete(Location entity);               

//	  boolean existsById(ID primaryKey);
	  
}
