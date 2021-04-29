package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Roles;

public interface RoleRepositary extends JpaRepository<Roles, Integer>{

}
