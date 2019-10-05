package com.naver.view;

import java.util.List;

import com.naver.locations.LocationsDTO;

public class LocView {
	public void view(LocationsDTO locationsDTO){
		System.out.println("==========================");
		System.out.println(locationsDTO.getLocation_id());
		System.out.println(locationsDTO.getStreet_address());
		System.out.println(locationsDTO.getPostal_code());
		System.out.println(locationsDTO.getCity());
		System.out.println(locationsDTO.getState_province());
		System.out.println(locationsDTO.getCountry_id());
	}
	
	public void view(List<LocationsDTO> ar) {
		for(LocationsDTO l : ar){
			this.view(l);
		}
	}
	
	public void view(String str) {
		System.out.println(str);
	}

}
