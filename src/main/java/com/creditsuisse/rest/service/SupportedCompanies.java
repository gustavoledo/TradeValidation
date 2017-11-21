package com.creditsuisse.rest.service;

import java.util.ArrayList;
import java.util.List;

public class SupportedCompanies {
	
	private static List<String> companies = new ArrayList<String>();
	
	
	//TODO: put companies in properties file or data base, static in code is only temporaly.
	static {
		
		companies.add("PLUTO1");
		companies.add("PLUTO2");
	}

	
	public static boolean validateSuportedCompanies(String companie) {
		if(companie.isEmpty() || companie == null) {
			return false;
		}
		
		return companies.contains(companie.toUpperCase());
		
	}
	
}
