package com.naver.input;

import java.util.Scanner;

import com.naver.locations.LocationsDTO;

public class LocInput {
	private Scanner sc;
	
	public LocInput() {
		sc = new Scanner(System.in);
	}
	
	public int oneInput() {
		System.out.println("location_id 입력");
		int location_id = sc.nextInt();
		
		return location_id;
	}//oneinput
	
	public LocationsDTO allInput() {
		LocationsDTO locationsDTO = new LocationsDTO();
		System.out.println("location_id 입력");
		locationsDTO.setLocation_id(sc.nextInt());
		System.out.println("street_address 입력");
		locationsDTO.setStreet_address(sc.next());
		System.out.println("postal_code 입력");
		locationsDTO.setPostal_code(sc.next());
		System.out.println("city 입력");
		locationsDTO.setCity(sc.next());
		System.out.println("state_province 입력");
		locationsDTO.setState_province(sc.next());
		System.out.println("country_id 입력");
		locationsDTO.setCountry_id(sc.next().toUpperCase());
		
		return locationsDTO;
	}//allinput

}
