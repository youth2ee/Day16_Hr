package com.naver.view;

import java.util.List;

import com.naver.jobs.JobsDTO;

public class JobView {
	public void view(JobsDTO jobsDTO){
		System.out.println("==========================");
		System.out.println(jobsDTO.getJob_id());
		System.out.println(jobsDTO.getJob_title());
		System.out.println(jobsDTO.getMin_salary());
		System.out.println(jobsDTO.getMax_salary());
	}
	
	public void view(List<JobsDTO> ar) {
		for(JobsDTO j : ar) {
			this.view(j);
		}
	}
	
	public void view(String str) {
		System.out.println(str);
	}

}
