package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Supplier;
import com.example.demo.repositary.SupplierRepositary;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepositary supplierRepositary;

	public Supplier CreateSupplier(Supplier supplier) {

		return supplierRepositary.save(supplier);

	}

	public Supplier getSupplierById(String id) {

		return supplierRepositary.findById(id).orElse(null);
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
