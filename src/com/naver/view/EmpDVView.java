package com.naver.view;

import java.util.List;

import com.naver.emp_details_view.EmpDetailsViewDTO;

public class EmpDVView {
	public void view(EmpDetailsViewDTO empDetailsViewDTO){
		System.out.println("==========================");
		System.out.println(empDetailsViewDTO.getEmployee_id());
		System.out.println(empDetailsViewDTO.getJob_id());
		System.out.println(empDetailsViewDTO.getManager_id());
		System.out.println(empDetailsViewDTO.getDepartment_id());
		System.out.println(empDetailsViewDTO.getLocation_id());
		System.out.println(empDetailsViewDTO.getCountry_id());
		System.out.println(empDetailsViewDTO.getFirst_name());
		System.out.println(empDetailsViewDTO.getSalary());
		System.out.println(empDetailsViewDTO.getCommission_pct());
		System.out.println(empDetailsViewDTO.getDepartment_name());
		System.out.println(empDetailsViewDTO.getJob_title());
		System.out.println(empDetailsViewDTO.getCity());
		System.out.println(empDetailsViewDTO.getState_province());
		System.out.println(empDetailsViewDTO.getCountry_name());
		System.out.println(empDetailsViewDTO.getRegion_name());
	}

	public void view(List<EmpDetailsViewDTO> ar) {
		for(EmpDetailsViewDTO e : ar) {
			this.view(e);
		}
	}

	public void view(String str) {
		System.out.println(str);
	}

}
