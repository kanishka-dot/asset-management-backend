package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ItemGroup;


public interface ItemGroupRepository extends JpaRepository<ItemGroup, String>{


//	ItemGroup findbyid(String id);

}
