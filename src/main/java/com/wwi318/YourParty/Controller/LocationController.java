package com.wwi318.YourParty.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wwi318.YourParty.Controller.LocationController;
import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Service.FileStorageService;
import com.wwi318.YourParty.Service.LocationService;

@RestController
public class LocationController {

	private LocationService locationService;

	@Autowired
	private FileStorageService fileStorageService;
	
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	// Alle Datens�tze finden
	@RequestMapping(method = RequestMethod.GET, path = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getAllLocations() {
		return locationService.findAll();
	}

	// Filterfunktion
//	@RequestMapping(method = RequestMethod.GET, value = "/location/filter{city}{price}{size}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Location getSpecificLocation(@PathVariable String city, int price, int size) {
//		int priceu = 0;
//		int priceo = 0;
//		if (price == 1) {
//			priceu = 0;
//			priceo = 100;
//		} else if (price == 2) {
//			priceu = 100;
//			priceo = 300;
//		} else if (price == 3) {
//			priceu = 300;
//			priceo = 50000;
//		}
//		int sizeu = 0;
//		int sizeo = 0;
//		if (size == 1) {
//			sizeu = 0;
//			sizeo = 50;
//		} else if (size == 2) {
//			sizeu = 50;
//			sizeo = 150;
//		} else if (size == 3) {
//			sizeu = 150;
//			sizeo = 2000;
//		}
//		if (city != null && price > 0 && size > 0) {
//			return locationService.findByFilter(city, priceu, priceo, sizeu, sizeo);
//		}
//		return null;
//		
//	}

	// Einzelnen Datensatz
	@RequestMapping(method = RequestMethod.GET, value = "/location/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Location getSpecificLocationId(@PathVariable Integer id) {
		if (locationService.findById(id).isPresent())
			return locationService.findById(id).get();
		else
			return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/location/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Location getSpecificLocationName(@PathVariable String name) {
		if (locationService.findByName(name).isPresent())
			return locationService.findByName(name).get();
		else
			return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/location/owner/{owner}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Location getSpecificLocationOwner(@PathVariable String owner) {
		if (locationService.findByOwner(owner).isPresent())
			return locationService.findByOwner(owner).get();
		else
			return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/location/city/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Location getSpecificLocationCity(@PathVariable String city) {
		if (locationService.findByCity(city).isPresent())
			return locationService.findByCity(city).get();
		else
			return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/location/postcode/{postcode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Location getSpecificLocationPosctcode(@PathVariable String postcode) {
		if (locationService.findByPostcode(postcode).isPresent())
			return locationService.findByPostcode(postcode).get();
		else
			return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/location/size/{size}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Location getSpecificLocationSize(@PathVariable Integer size) {
		if (locationService.findBySize(size).isPresent())
			return locationService.findBySize(size).get();
		else
			return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/location/price/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Location getSpecificLocationPrice(@PathVariable Double price) {
		if (locationService.findByPrice(price).isPresent())
			return locationService.findByPrice(price).get();
		else
			return null;
	}

	// Funktionen anlegen, �ndern, l�schen
	@RequestMapping(method = RequestMethod.POST, value = "Location", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Location> createLocation(Location location, @RequestParam("file") MultipartFile file) {
		try {
			uploadLocationPicture(file, location.getName().replace(" ", ""));
			Location results = locationService.save(location);
			return ResponseEntity.created(new URI("/api/location/" + results.getId())).body(results);
		} catch (Exception e) {
			return new ResponseEntity<Location>(HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/uploadLocationPicture")
	private void uploadLocationPicture(@RequestParam("file") MultipartFile file, String replace) {
		String fileName = fileStorageService.storePicture(file, replace);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		
	}

	@RequestMapping(method = RequestMethod.PUT, value = "location/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
		if (location.getId() == null)
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);

		try {
			Location results = locationService.update(location);
			return ResponseEntity.created(new URI("/api/location/" + results.getId())).body(results);
		} catch (Exception e) {
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/location/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteLocation(@PathVariable Integer id) {
		locationService.delete(id);
		return ResponseEntity.ok().build();
	}

//		// Return the image from the database using HttpServletResponse
//		@GetMapping(value = "database1/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
//		public void fromDatabaseAsHttpServResp(@PathVariable("id") Integer id, HttpServletResponse response)
//				throws SQLException, IOException {
//
//			Optional<Location> location = locationService.findById(id);
//
//			if (location.isPresent()) {
//
//				Blob image = location.get().getPicture();
//
//				StreamUtils.copy(image.getBinaryStream(), response.getOutputStream());
//			}
//		}
//
//		// Return the image from the classpath location using ResponseEntity
//		@GetMapping(value = "classpath")
//		public ResponseEntity<byte[]> fromClasspathAsResEntity() throws IOException {
//
//			ClassPathResource imageFile = new ClassPathResource("pm-india/modi.jpg");
//
//			byte[] imageBytes = StreamUtils.copyToByteArray(imageFile.getInputStream());
//
//			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
//		}
//
//		// Return the image from the classpath location using HttpServletResponse
//		@GetMapping(value = "classpath1", produces = MediaType.IMAGE_JPEG_VALUE)
//		public void fromClasspathAsHttpServResp(HttpServletResponse response) throws IOException {
//
//			ClassPathResource imageFile = new ClassPathResource("pm-india/vajpayee.jpg");
//
//			StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
//		}

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
