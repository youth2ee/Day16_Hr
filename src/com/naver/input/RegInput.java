package com.naver.input;

import java.util.Scanner;

import com.naver.regions.RegionsDTO;

public class RegInput {
	private Scanner sc;
	
	public RegInput() {
		sc = new Scanner(System.in);
	}
	
	public int oneInput() {
		System.out.println("region_id 입력");
		int region_id = sc.nextInt();
		
		return region_id;
	}//oneinput
	
	public RegionsDTO allInput() {
		RegionsDTO regionsDTO = new RegionsDTO();
		System.out.println("region_id 입력");
		regionsDTO.setRegion_id(sc.nextInt());
		System.out.println("region_name 입력");
		regionsDTO.setRegion_name(sc.next());
		
		return regionsDTO;
	}//allinput

}
