package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Locations;

public interface LocationRepository extends JpaRepository<Locations, Integer>{

	Locations findBylocationid(Integer locationid);
	
	List<Locations> findByLocationidNot(Integer locationid);

}
