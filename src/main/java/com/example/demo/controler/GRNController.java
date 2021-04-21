package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.GRN;
import com.example.demo.service.GRNService;

@CrossOrigin(origins = "*")
@RestController
public class GRNController {

	@Autowired
	private GRNService grnService;

	@PostMapping("/inventory/savesuppliergrn")
	public int saveGRN(@RequestBody List<GRN> grn) {
		return grnService.saveGRN(grn);
	}

}
