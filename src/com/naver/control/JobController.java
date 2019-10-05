package com.naver.control;

import java.util.List;
import java.util.Scanner;

import com.naver.input.JobInput;
import com.naver.jobs.JobsDAO;
import com.naver.jobs.JobsDTO;
import com.naver.view.JobView;

public class JobController {
	private Scanner sc;
	private JobsDAO jobsDAO;
	private JobInput jobInput;
	private JobView jobView;

	public JobController() {
		sc = new Scanner(System.in);
		jobsDAO = new JobsDAO();
		jobInput = new JobInput();
		jobView = new JobView();
	}

	public void start() {
		boolean check = true;

		while(check) {
			System.out.println("-------------");
			System.out.println("Jobs");
			System.out.println("1. 전체출력");
			System.out.println("2. 검색");
			System.out.println("3. 추가");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();

			switch(num) {
			case 1:
				List<JobsDTO> ar = jobsDAO.getSelectAll();
				if(ar.size()!=0) {					
					jobView.view(ar);
				} else {
					jobView.view("데이터가 없습니다.");
				}
				break;

			case 2:
				String job_id = jobInput.oneInput();
				JobsDTO jobsDTO = jobsDAO.getSelectOne(job_id);
				if(jobsDTO!=null) {
					jobView.view(jobsDTO);					
				} else {
					jobView.view("검색할 수 없습니다.");
				}
				break;

			case 3:
				JobsDTO jobsDTO2 = jobInput.allInput();
				int result = jobsDAO.insert(jobsDTO2);
				if(result>0) {
					jobView.view("추가 성공");
					jobView.view(jobsDTO2);
				} else {
					jobView.view("추가 실패");
				}
				break;

			case 4:
				job_id = jobInput.oneInput();
				result = jobsDAO.delete(job_id);
				if(result>0) {
					jobView.view("삭제 성공");
				} else {
					jobView.view("삭제 실패");
				}
				break;

			default:
				check=!check;
			}//switch
		}//while
	}//start

}
