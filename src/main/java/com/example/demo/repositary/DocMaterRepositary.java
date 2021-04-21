package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DocMaster;

public interface DocMaterRepositary extends JpaRepository<DocMaster, String> {

}
