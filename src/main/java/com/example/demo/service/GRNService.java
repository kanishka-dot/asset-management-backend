package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GRN;
import com.example.demo.repositary.GRNRepositary;

@Service
public class GRNService {

	@Autowired
	private GRNRepositary grnRepositary;

	public int saveGRN(GRN grn) {

		try {
			grnRepositary.save(grn);
			return 1;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
