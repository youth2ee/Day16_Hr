package com.naver.input;

import java.util.Scanner;

import com.naver.jobs.JobsDTO;

public class JobInput {
	private Scanner sc;
	
	public JobInput() {
		sc = new Scanner(System.in);
	}
	
	public String oneInput() {
		System.out.println("job_id 입력");
		String job_id = sc.next().toUpperCase();
		
		return job_id;
	}//oneinput
	
	public JobsDTO allInput() {
		JobsDTO jobsDTO = new JobsDTO();
		System.out.println("job_id 입력");
		jobsDTO.setJob_id(sc.next().toUpperCase());
		System.out.println("job_title 입력");
		jobsDTO.setJob_title(sc.next());
		System.out.println("min_salary 입력");
		jobsDTO.setMin_salary(sc.nextInt());
		System.out.println("max_salary 입력");
		jobsDTO.setMax_salary(sc.nextInt());
		
		return jobsDTO;
	}//allinput

}
