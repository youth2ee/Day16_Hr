package com.naver.input;

import java.util.Scanner;

import com.naver.job_history.Job_historyDTO;

public class JobHInput {
	private Scanner sc;
	
	public JobHInput() {
		sc = new Scanner(System.in);
	}
	
	public int oneInput() {
		System.out.println("employee_id 입력");
		int employee_id = sc.nextInt();
		
		return employee_id;
	}//oneinput
	
	public Job_historyDTO allInput() {
		Job_historyDTO job_historyDTO = new Job_historyDTO();
		System.out.println("employee_id 입력");
		job_historyDTO.setEmployee_id(sc.nextInt());
		System.out.println("start_date 입력");
		job_historyDTO.setStart_date(sc.next());
		System.out.println("end_date 입력");
		job_historyDTO.setEnd_date(sc.next());
		System.out.println("job_id 입력");
		job_historyDTO.setJob_id(sc.next().toUpperCase());
		System.out.println("departments_id 입력");
		job_historyDTO.setDepartment_id(sc.nextInt());
		
		return job_historyDTO;
	}//allinput

}
