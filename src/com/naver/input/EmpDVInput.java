package com.naver.input;

import java.util.Scanner;

import com.naver.emp_details_view.EmpDetailsViewDTO;

public class EmpDVInput {
	private Scanner sc;
	
	public EmpDVInput() {
		sc = new Scanner(System.in);
	}
	
	public int oneInput() {
		System.out.println("employee_id 입력");
		int employee_id = sc.nextInt();
		
		return employee_id;
	}//oneinput
	
	public EmpDetailsViewDTO allInput() {
		EmpDetailsViewDTO empDetailsViewDTO = new EmpDetailsViewDTO();
		System.out.println("employee_id 입력");
		empDetailsViewDTO.setEmployee_id(sc.nextInt());
		System.out.println("job_id 입력");
		empDetailsViewDTO.setJob_id(sc.next());
		System.out.println("manager_id 입력");
		empDetailsViewDTO.setManager_id(sc.nextInt());
		System.out.println("department_id 입력");
		empDetailsViewDTO.setDepartment_id(sc.nextInt());
		System.out.println("location_id 입력");
		empDetailsViewDTO.setLocation_id(sc.nextInt());
		System.out.println("country_id 입력");
		empDetailsViewDTO.setCountry_id(sc.next());
		System.out.println("first_name 입력");
		empDetailsViewDTO.setFirst_name(sc.next());
		System.out.println("salary 입력");
		empDetailsViewDTO.setSalary(sc.nextInt());
		System.out.println("commission_pct 입력");
		empDetailsViewDTO.setCommission_pct(sc.nextDouble());
		System.out.println("department_name 입력");
		empDetailsViewDTO.setDepartment_name(sc.next());
		System.out.println("job_title 입력");
		empDetailsViewDTO.setJob_title(sc.next());
		System.out.println("city 입력");
		empDetailsViewDTO.setCity(sc.next());
		System.out.println("state_province 입력");
		empDetailsViewDTO.setState_province(sc.next());
		System.out.println("country_name 입력");
		empDetailsViewDTO.setCountry_name(sc.next());
		System.out.println("region_name 입력");
		empDetailsViewDTO.setRegion_name(sc.next());
		
		return empDetailsViewDTO;
	}//allinput

}
