package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;

@RestController
@CrossOrigin(origins = "*")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping("/supplier/createnewsupplier")
	public Supplier createNewSupplier(@RequestBody Supplier supplier) {
		return supplierService.CreateSupplier(supplier);
	}
	
	@GetMapping("/supplier/getsupplier/{name}")
	public Supplier  getSupplier(@PathVariable String name) {
		
		return supplierService.getSupplierByName(name);
	}
	
	@PostMapping("/supplier/updateSUpplier")
	public String updateSupplier(@RequestBody Supplier supplier) {
		return supplierService.updateSupplier(supplier);
	}
	
	@GetMapping("/supplier/getall")
	public List<Supplier> getAllSuppliers(){
		return supplierService.getAllSupplier();
	}
	
	
	

}
