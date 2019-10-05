package com.naver.view;

import java.util.List;

import com.naver.departments.DepartmentsDTO;

public class DepView {
	public void view(DepartmentsDTO departmentsDTO) {
		System.out.println("==========================");
		System.out.println(departmentsDTO.getDepartment_id());
		System.out.println(departmentsDTO.getDepartment_name());
		System.out.println(departmentsDTO.getManager_id());
		System.out.println(departmentsDTO.getLocation_id());
	}
	
	public void view(List<DepartmentsDTO> ar) {
		for(DepartmentsDTO d : ar) {
			this.view(d);
		}
	}
	
	public void view(String str) {
		System.out.println(str);
	}

}
