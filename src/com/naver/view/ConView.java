package com.naver.view;

import java.util.List;

import com.naver.countries.CountriesDTO;

public class ConView {
	public void view(CountriesDTO countriesDTO) {
		System.out.println("==========================");
		System.out.println(countriesDTO.getCountry_id());
		System.out.println(countriesDTO.getCountry_name());
		System.out.println(countriesDTO.getRegion_id());
	}
	
	public void view(List<CountriesDTO> ar) {
		for(CountriesDTO c : ar) {
			this.view(c);
		}
	}

	public void view(String str) {
		System.out.println(str);
	}
}
