package com.example.demo.controler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MRO;
import com.example.demo.service.MROService;

@CrossOrigin(origins = "*")
@RestController
public class MroController {

	@Autowired
	MROService mroService;
	
	
	@GetMapping("/inventory/mro_supplies/balQty/{itmcod}")
	public Integer getAvItmQty(@PathVariable String itmcod) {
		return mroService.getAvailabelInvBal(itmcod);
	}
	
	
	@PostMapping("/inventory/mro_supplies/save/mroIN")
	public ArrayList<String> saveMroIn(@RequestBody ArrayList<MRO>  mro) {
		return mroService.saveMRO(mro);
	}
	
	
	@PostMapping("/inventory/mro_supplies/save/mroOUT")
	public ArrayList<String> saveMroOUT(@RequestBody ArrayList<MRO>  mro) {
		return mroService.saveMroOUT(mro);
	}
	
	
	
	
}
