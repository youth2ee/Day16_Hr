package com.naver.control;

import java.util.List;
import java.util.Scanner;

import com.naver.input.JobHInput;
import com.naver.job_history.Job_historyDAO;
import com.naver.job_history.Job_historyDTO;
import com.naver.view.JobHView;

public class JobHController {
	private Scanner sc;
	private Job_historyDAO job_historyDAO;
	private JobHInput jobHInput;
	private JobHView jobHView;

	public JobHController() {
		sc = new Scanner(System.in);
		job_historyDAO = new Job_historyDAO();
		jobHInput = new JobHInput();
		jobHView = new JobHView();
	}

	public void start() {
		boolean check = true;

		while(check) {
			System.out.println("-------------");
			System.out.println("Job_history");
			System.out.println("1. 전체출력");
			System.out.println("2. 검색");
			System.out.println("3. 추가");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();

			switch(num) {
			case 1:
				List<Job_historyDTO> ar = job_historyDAO.getSelectAll();
				if(ar.size()!=0) {
					jobHView.view(ar);
				} else {
					jobHView.view("데이터가 없습니다.");
				}
				break;

			case 2:
				int employee_id = jobHInput.oneInput();
				Job_historyDTO job_historyDTO = job_historyDAO.getSelectOne(employee_id);
				if(job_historyDTO!=null) {
					jobHView.view(job_historyDTO);
				} else {
					jobHView.view("검색할 수 없습니다.");
				}
				break;

			case 3:
				Job_historyDTO job_historyDTO2 = jobHInput.allInput();
				int result = job_historyDAO.insert(job_historyDTO2);
				if(result>0) {
					jobHView.view("추가 성공");
					jobHView.view(job_historyDTO2);
				} else {
					jobHView.view("추가 실패");
				}
				break;

			case 4:
				employee_id = jobHInput.oneInput();
				result = job_historyDAO.delete(employee_id);
				if(result>0) {
					jobHView.view("삭제 성공");
				} else {
					jobHView.view("삭제 실패");
				}
				break;

			default:
				check=!check;
			}//switch
		}//while
	}//start
}
