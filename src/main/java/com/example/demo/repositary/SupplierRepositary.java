package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Supplier;

public interface SupplierRepositary extends JpaRepository<Supplier,Integer> {

	Supplier findBysupplierid(Integer supplierid);
	Supplier findByname(String supplierName);

}
