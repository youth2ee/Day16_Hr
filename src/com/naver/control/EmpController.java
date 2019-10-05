package com.naver.control;

import java.util.List;
import java.util.Scanner;

import com.naver.employees.EmployeesDAO;
import com.naver.employees.EmployeesDTO;
import com.naver.input.EmpInput;
import com.naver.view.EmpView;

public class EmpController {
	private Scanner sc;
	private EmployeesDAO employeesDAO;
	private EmpInput empInput;
	private EmpView empView;
	
	public EmpController() {
		sc = new Scanner(System.in);
		employeesDAO = new EmployeesDAO();
		empInput = new EmpInput();
		empView = new EmpView();
	}

	public void start() {
		boolean check = true;
		
		while(check) {
			System.out.println("-------------");
			System.out.println("Employees");
			System.out.println("1. 전체출력");
			System.out.println("2. 검색");
			System.out.println("3. 추가");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				List<EmployeesDTO> ar = employeesDAO.getSelectAll();
				if(ar.size()!=0) {
					empView.view(ar);					
				} else {
					empView.view("데이터가 없습니다.");
				}
				break;
				
			case 2:
				int employee_id = empInput.oneInput();
				EmployeesDTO employeesDTO = employeesDAO.getSelectOne(employee_id);
				if(employeesDTO!=null) {
					empView.view(employeesDTO);					
				} else {
					empView.view("검색할 수 없습니다.");
				}
				break;
				
			case 3:
				EmployeesDTO employeesDTO2 = empInput.allInput();
				int result = employeesDAO.insert(employeesDTO2);
				if(result>0) {
					empView.view("추가 성공");
					empView.view(employeesDTO2);
				} else {
					empView.view("추가 실패");
				}
				break;
				
			case 4:
				employee_id = empInput.oneInput();
				result = employeesDAO.delete(employee_id);
				if(result>0) {
					empView.view("삭제 성공");
				} else {
					empView.view("삭제 실패");
				}
				break;
				
			default:
				check=!check;
			}//switch
		}//while
	}//start
	
}
