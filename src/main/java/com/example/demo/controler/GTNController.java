package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GTN;
import com.example.demo.service.GTNService;

@CrossOrigin(origins = "*")
@RestController
public class GTNController {

	@Autowired
	GTNService gtnService;
	
	
	@GetMapping("/inventory/receive/{location}")
	public List<GTN> getAvailbleGTN(@PathVariable Integer location){
		return gtnService.getAvailableGTN(location);
	}
	
	@GetMapping("/inventory/receive/getgtn/{docno}")
	public List<GTN> getGTN(@PathVariable Integer docno){
		return gtnService.getSelectGTN(docno);
	}
	
	
	
	@PostMapping("/inventory/receive/approve/{docNo}/{user}")
	public ArrayList<String> approveGTN(@PathVariable Integer docNo, @PathVariable String user) {
		return gtnService.approveGTN(docNo, user);
	}
	
	
	@PostMapping("/inventory/tranfer/data")
	public ArrayList<String> saveGTN(@RequestBody ArrayList<GTN> gtn) {
		return gtnService.saveGTN(gtn);
	}

	
}
