package com.example.demo.utils;

import java.time.LocalDate;

public class Date {

	static LocalDate   date = LocalDate.now();
	
	public static String getLocalDate() {
		return date.toString();
	}
	
	
}
