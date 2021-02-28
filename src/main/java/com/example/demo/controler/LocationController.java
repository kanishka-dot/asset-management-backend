package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Locations;
import com.example.demo.service.LocationService;

@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	
	
	@PostMapping("/location/createnewlocation")
	public Locations createNewSupplier(@RequestBody Locations location) {
		return locationService.createNewLocation(location);
	}
	
	@GetMapping("/location/getlocation/{id}")
	public Locations  getSupplier(@PathVariable Integer id) {
		
		return locationService.getLocation(id);
	}
	
	@PostMapping("/location/updatelocation")
	public String updateSupplier(@RequestBody Locations location) {
		return locationService.updateLocation(location);
	}
	
	
	
}
