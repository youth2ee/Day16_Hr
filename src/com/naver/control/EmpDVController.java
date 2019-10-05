package com.naver.control;

import java.util.List;
import java.util.Scanner;

import com.naver.emp_details_view.EmpDetailsViewDAO;
import com.naver.emp_details_view.EmpDetailsViewDTO;
import com.naver.input.EmpDVInput;
import com.naver.view.EmpDVView;

public class EmpDVController {
	private Scanner sc;
	private EmpDetailsViewDAO empDetailsViewDAO;
	private EmpDVInput empDVInput;
	private EmpDVView empDVView;
	
	public EmpDVController() {
		sc = new Scanner(System.in);
		empDetailsViewDAO = new EmpDetailsViewDAO();
		empDVInput = new EmpDVInput();
		empDVView = new EmpDVView();
	}

	public void start() {
		boolean check = true;
		
		while(check) {
			System.out.println("-------------");
			System.out.println("Emp_details_view");
			System.out.println("1. 전체출력");
			System.out.println("2. 검색");
			System.out.println("3. 추가");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				List<EmpDetailsViewDTO> ar = empDetailsViewDAO.getSelectAll();
				if(ar.size()!=0) {
					empDVView.view(ar);
				} else {
					empDVView.view("데이터가 없습니다.");
				}
				break;
				
			case 2:
				int employee_id = empDVInput.oneInput();
				EmpDetailsViewDTO empDetailsViewDTO = empDetailsViewDAO.getSelectOne(employee_id);
				if(empDetailsViewDTO!=null) {
					empDVView.view(empDetailsViewDTO);
				} else {
					empDVView.view("검색할 수 없습니다.");
				}
				break;
				
			case 3:
				EmpDetailsViewDTO empDetailsViewDTO2 = empDVInput.allInput();
				int result = empDetailsViewDAO.insert(empDetailsViewDTO2);
				if(result>0) {
					empDVView.view("추가 성공");
					empDVView.view(empDetailsViewDTO2);
				} else {
					empDVView.view("추가 실패");
				}
				break;
				
			case 4:
				employee_id = empDVInput.oneInput();
				result = empDetailsViewDAO.delete(employee_id);
				if(result>0) {
					empDVView.view("삭제 성공");
				} else {
					empDVView.view("삭제 실패");
				}
				break;
				
			default:
				check=!check;
			}//switch
		}//while
	}//start
}
