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
	public ArrayList<String> saveGRN(@RequestBody ArrayList<GRN> grn) {
		return grnService.saveGRN(grn);
	}
	
	
	@PostMapping("/inventory/grn/approvegrn/{docno}/{user}")
	public ArrayList<String> approveGRN(@PathVariable Integer docno, @PathVariable String user) {
		return grnService.approveGRN(docno, user);
	}
	
	
	
	@GetMapping("/inventory/getgrnserial/{serial}")
	public boolean getserialNo(@PathVariable String serial) {
		return grnService.isSerialUnique(serial);
	}
	
	
	@GetMapping("/inventory/grn/getstatusnap")
	public List<GRN> getserialNo() {
		return grnService.getAvailableGRN();
	}
	
	@GetMapping("/inventory/grn/{docno}")
	public List<GRN> getGRN(@PathVariable Integer docno) {
		return grnService.getGRN(docno);
	}
	
	

}
