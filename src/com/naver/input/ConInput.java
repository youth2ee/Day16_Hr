package com.naver.input;

import java.util.Scanner;

import com.naver.countries.CountriesDTO;

public class ConInput {
	private Scanner sc;
	
	public ConInput() {
		sc = new Scanner(System.in);
	}
	
	public String oneInput() {
		System.out.println("country_id 입력");
		String country_id = sc.next().toUpperCase();
		
		return country_id;
	}//oneinput
	
	public CountriesDTO allInput() {
		CountriesDTO countriesDTO = new CountriesDTO();
		System.out.println("country_id 입력");
		countriesDTO.setCountry_id(sc.next().toUpperCase());
		System.out.println("country_name 입력");
		countriesDTO.setCountry_name(sc.next());
		System.out.println("region_id 입력");
		countriesDTO.setRegion_id(sc.nextInt());
		
		return countriesDTO;
	}//allinput

}
