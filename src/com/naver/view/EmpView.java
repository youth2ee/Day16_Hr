package com.naver.view;

import java.util.List;

import com.naver.employees.EmployeesDTO;

public class EmpView {
	public void view(EmployeesDTO employeesDTO){
		System.out.println("==========================");
		System.out.println(employeesDTO.getEmployee_id());
		System.out.println(employeesDTO.getFirst_name());
		System.out.println(employeesDTO.getLast_name());
		System.out.println(employeesDTO.getEmail());
		System.out.println(employeesDTO.getPhone_number());
		System.out.println(employeesDTO.getHire_date());
		System.out.println(employeesDTO.getJob_id());
		System.out.println(employeesDTO.getSalary());
		System.out.println(employeesDTO.getCommission_pct());
		System.out.println(employeesDTO.getManager_id());
		System.out.println(employeesDTO.getDepartment_id());
	}
	
	public void view(List<EmployeesDTO> ar) {
		for(EmployeesDTO e : ar) {
			this.view(e);
		}	
	}
	
	public void view(String str) {
		System.out.println(str);
	}
}
