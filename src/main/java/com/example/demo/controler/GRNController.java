package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GRN;
import com.example.demo.service.GRNService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@EnableTransactionManagement
public class GRNController {

	@Autowired
	private GRNService grnService;

	

	
	
	@PostMapping("/inventory/savesuppliergrn")
	public String saveGRN(@RequestBody ArrayList<GRN> grn) {
		return grnService.saveGRN(grn);
	}
	
	
	@GetMapping("/inventory/getgrnserial/{serial}")
	public boolean getserialNo(@PathVariable String serial) {
		return grnService.isSerialUnique(serial);
	}

}
