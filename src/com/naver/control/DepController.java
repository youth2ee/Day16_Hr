package com.naver.control;

import java.util.List;
import java.util.Scanner;

import com.naver.departments.DepartmentsDAO;
import com.naver.departments.DepartmentsDTO;
import com.naver.input.DepInput;
import com.naver.view.DepView;

public class DepController {
	private Scanner sc;
	private DepartmentsDAO departmentsDAO;
	private DepInput depInput;
	private DepView depView;
	
	public DepController() {
		sc = new Scanner(System.in);
		departmentsDAO = new DepartmentsDAO();
		depInput = new DepInput();
		depView = new DepView();
	}
	
	public void start() {
		boolean check = true;
		
		while(check) {
			System.out.println("-------------");
			System.out.println("Departments");
			System.out.println("1. 전체출력");
			System.out.println("2. 검색");
			System.out.println("3. 추가");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				List<DepartmentsDTO> ar = departmentsDAO.getSelectAll();
				if(ar.size()!=0) {
					depView.view(ar);
				} else {
					depView.view("데이터가 없습니다.");
				}
				break;
				
			case 2:
				int department_id = depInput.oneInput();
				DepartmentsDTO departmentsDTO = departmentsDAO.getSelectOne(department_id);
				if(departmentsDTO!=null) {
					depView.view(departmentsDTO);
				} else {
					depView.view("검색할 수 없습니다.");
				}
				break;
				
			case 3:
				DepartmentsDTO departmentsDTO2 = depInput.allInput();
				int result = departmentsDAO.insert(departmentsDTO2);
				if(result>0) {
					depView.view("추가 성공");
					depView.view(departmentsDTO2);
				} else {
					depView.view("추가 실패");
				}
				break;
				
			case 4:
				department_id = depInput.oneInput();
				result = departmentsDAO.delete(department_id);
				if(result>0) {
					depView.view("삭제 성공");
				} else {
					depView.view("삭제 실패");
				}
				break;
				
			default:
				check=!check;
			}//switch
		}//while
	}//start

}
