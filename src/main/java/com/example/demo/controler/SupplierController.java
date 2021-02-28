package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;

@RestController
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping("/supplier/createnewsupplier")
	public Supplier createNewSupplier(@RequestBody Supplier supplier) {
		return supplierService.CreateSupplier(supplier);
	}
	
	@GetMapping("/supplier/getsupplier/{id}")
	public Supplier  getSupplier(@PathVariable String id) {
		
		return supplierService.getSupplierById(id);
	}
	
	@PostMapping("/supplier/updateSUpplier")
	public String updateSupplier(@RequestBody Supplier supplier) {
		return supplierService.updateSupplier(supplier);
	}

}
