package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ItemGroup;
import com.example.demo.entity.Locations;
import com.example.demo.service.LocationService;

@RestController
@CrossOrigin(origins = "*")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	
	
	@PostMapping("/location/createnewlocation")
	public int createNewLocation(@RequestBody Locations location) {
		return locationService.createNewLocation(location);
	}
	
	@GetMapping("/location/getlocation/{id}")
	public Locations  getLocation(@PathVariable Integer id) {
		
		return locationService.getLocation(id);
	}
	
	@PostMapping("/location/updatelocation")
	public String updateLocation(@RequestBody Locations location) {
		return locationService.updateLocation(location);
	}
	
	@GetMapping("/location/get_all_locations")
	public  List<Locations>  getAllLocations() {
		return locationService.getAllLocations();
	}
	
	
	@GetMapping("/location/get_all_locations/{location}")
	public  List<Locations>  getNotInLocations(@PathVariable Integer location) {
		return locationService.getNotInLocations(location);
	}
	
	
}
