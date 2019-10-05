package com.naver.input;

import java.util.Scanner;
import com.naver.employees.EmployeesDTO;

public class EmpInput {
	private Scanner sc;
	
	public EmpInput() {
		sc = new Scanner(System.in);
	}
	
	public int oneInput() {
		System.out.println("employee_id 입력");
		int employee_id = sc.nextInt();
		
		return employee_id;
	}//oneinput
	
	public EmployeesDTO allInput() {
		EmployeesDTO employeesDTO = new EmployeesDTO();
		System.out.println("employee_id 입력");
		employeesDTO.setEmployee_id(sc.nextInt());
		System.out.println("first_name 입력");
		employeesDTO.setFirst_name(sc.next());
		System.out.println("last_name 입력");
		employeesDTO.setLast_name(sc.next());
		System.out.println("email 입력");
		employeesDTO.setEmail(sc.next());
		System.out.println("phone_number 입력");
		employeesDTO.setPhone_number(sc.next());
		System.out.println("hire_date 입력");
		employeesDTO.setHire_date(sc.next());
		System.out.println("job_id 입력");
		employeesDTO.setJob_id(sc.next());
		System.out.println("salary 입력");
		employeesDTO.setSalary(sc.nextInt());
		System.out.println("commission_pct 입력");
		employeesDTO.setCommission_pct(sc.nextDouble());
		System.out.println("manager_id 입력");
		employeesDTO.setManager_id(sc.nextInt());
		System.out.println("departments_id 입력");
		employeesDTO.setDepartment_id(sc.nextInt());
		
		return employeesDTO;
	}//allinput

}
