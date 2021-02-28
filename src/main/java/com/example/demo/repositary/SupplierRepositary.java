package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Supplier;

public interface SupplierRepositary extends JpaRepository<Supplier,String> {

	Supplier findBysupplierid(String supplierid);

}
