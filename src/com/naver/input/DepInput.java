package com.naver.input;

import java.util.Scanner;

import com.naver.departments.DepartmentsDTO;

public class DepInput {
	private Scanner sc;
	
	public DepInput() {
		sc =  new Scanner(System.in);
	}

	public int oneInput() {
		System.out.println("department_id 입력");
		int department_id = sc.nextInt();
		
		return department_id;
	}//oneinput
	
	public DepartmentsDTO allInput() {
		DepartmentsDTO departmentsDTO = new DepartmentsDTO();
		System.out.println("department_id 입력");
		departmentsDTO.setDepartment_id(sc.nextInt());
		System.out.println("department_name 입력");
		departmentsDTO.setDepartment_name(sc.next());
		System.out.println("manager_id 입력");
		departmentsDTO.setManager_id(sc.nextInt());
		System.out.println("loaction_id 입력");
		departmentsDTO.setLocation_id(sc.nextInt());
		
		return departmentsDTO;
	}//allinput
	
}
