package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemGroup;
import com.example.demo.entity.Locations;
import com.example.demo.repositary.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public int createNewLocation(Locations location) {
		
		Optional<Locations> LocationIsExsist =  locationRepository.findById(location.getLocationid());
		if(LocationIsExsist.isPresent()) {	

			return 0;
		}else {
			locationRepository.save(location);
			return 1;
		}
		

	
	}

	public Locations getLocation(Integer id) {
		return locationRepository.findById(id).orElse(null);
	}
	
	public List<Locations> getAllLocations() {
		return locationRepository.findAll();
		
	}

	public String updateLocation(Locations location) {
		Locations updateLocation = locationRepository.findBylocationid(location.getLocationid());
		if (updateLocation == null) {

			return "Unable to update location";
		} else {

			updateLocation.setLocationname(location.getLocationname());
			updateLocation.setMod_by(location.getMod_by());
			updateLocation.setMod_date(location.getCre_date());
			updateLocation.setCre_by(location.getCre_by());
			updateLocation.setCre_date(location.getCre_date());

			locationRepository.save(updateLocation);

			return "Location Sucessfully Updated";
		}

	}

}
