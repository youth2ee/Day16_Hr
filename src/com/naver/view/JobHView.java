package com.naver.view;

import java.util.List;

import com.naver.job_history.Job_historyDTO;

public class JobHView {
	public void view(Job_historyDTO job_historyDTO){
		System.out.println("==========================");
		System.out.println(job_historyDTO.getEmployee_id());
		System.out.println(job_historyDTO.getStart_date());
		System.out.println(job_historyDTO.getEnd_date());
		System.out.println(job_historyDTO.getJob_id());
		System.out.println(job_historyDTO.getDepartment_id());
	}
	
	public void view(List<Job_historyDTO> ar) {
		for(Job_historyDTO j : ar) {
			this.view(j);
		}		
	}
	
	public void view(String str) {
		System.out.println(str);
	}

}
