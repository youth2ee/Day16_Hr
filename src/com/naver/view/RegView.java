package com.naver.view;

import java.util.List;

import com.naver.regions.RegionsDTO;

public class RegView {
	public void view(RegionsDTO regionsDTO){
		System.out.println("==========================");
		System.out.println(regionsDTO.getRegion_id());
		System.out.println(regionsDTO.getRegion_name());
	}

	public void view(List<RegionsDTO> ar) {
		for(RegionsDTO r : ar) {
			this.view(r);
		}
	}

	public void view(String str) {
		System.out.println(str);
	}

}
