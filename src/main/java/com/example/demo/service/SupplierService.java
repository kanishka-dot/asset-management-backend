package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Supplier;
import com.example.demo.repositary.SupplierRepositary;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepositary supplierRepositary;

	public Supplier CreateSupplier(Supplier supplier) {	
		System.out.println("Supplier ID--->"+supplier.getSupplierid());
		return supplierRepositary.save(supplier);

	}
	
	public List<Supplier> getAllSupplier() {
		return supplierRepositary.findAll();
	}
	
	//get all active supplier list 
	public List<Supplier> getAllActSupplier(String status) {
		return supplierRepositary.findBystatus(status);
	}

	public Supplier getSupplierByName(String name) {

		return supplierRepositary.findByname(name);
		 
	}

	public String updateSupplier(Supplier supplier) {
		Supplier updaingSupplier = supplierRepositary.findBysupplierid(supplier.getSupplierid());

		if (updaingSupplier == null) {

			return "Unable to Find Supplier";
			
		} else {

			updaingSupplier.setName(supplier.getName());
			updaingSupplier.setAddress(supplier.getAddress());
			updaingSupplier.setNic(supplier.getNic());
			updaingSupplier.setStatus(supplier.getStatus());
			updaingSupplier.setRemark(supplier.getRemark());
			updaingSupplier.setMod_by(supplier.getMod_by());
			updaingSupplier.setMod_date(supplier.getMod_date());
			updaingSupplier.setCre_by(supplier.getCre_by());
			updaingSupplier.setCre_date(supplier.getCre_date());
			supplierRepositary.save(updaingSupplier);
			return "Supplier Successfully Updated";

		}

	}

}
