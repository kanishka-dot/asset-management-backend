package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Repair;

public interface RepairRepositary extends JpaRepository<Repair, Integer> {

	
}
