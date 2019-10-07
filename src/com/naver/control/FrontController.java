package com.naver.control;

import java.util.Scanner;

import com.naver.control.ConController;
import com.naver.control.DepController;
import com.naver.control.EmpController;
import com.naver.control.EmpDVController;
import com.naver.control.JobController;
import com.naver.control.JobHController;
import com.naver.control.LocController;
import com.naver.control.RegController;

public class FrontController {
	private Scanner sc;
	private ConController conController;
	private DepController depController;
	private EmpController empController;
	private EmpDVController empDVController;
	private JobController jobController;
	private JobHController jobHController;
	private LocController locController;
	private RegController regController;
	
	public FrontController() {
		sc = new Scanner(System.in);
		conController = new ConController();
		depController = new DepController();
		empController = new EmpController();
		empDVController = new EmpDVController();
		jobController = new JobController();
		jobHController = new JobHController();
		locController = new LocController();
		regController = new RegController();
	}
	
	public void start() {
		boolean check = true;
		int select = 0;
		
		while(check) {
			System.out.println("***전체메뉴***");
			System.out.println("1. Countries");
			System.out.println("2. Departments");
			System.out.println("3. Employees");
			System.out.println("4. Emp_details_view");
			System.out.println("5. Jobs");
			System.out.println("6. Job_history");
			System.out.println("7. Locations");
			System.out.println("8. Regions");
			System.out.println("9. 종료");
			select = sc.nextInt();
			
			switch (select) {
			case 1:
				conController.start();
				break;

			case 2:
				depController.start();
				break;
				
			case 3:
				empController.start();
				break;
				
			case 4:
				empDVController.start();
				break;
				
			case 5:
				jobController.start();
				break;
				
			case 6:
				jobHController.start();
				break;
				
			case 7:
				locController.start();
				break;
				
			case 8:
				regController.start();
				break;
				
			default:
				check=!check;
			}//switch
		}//while
	}//start

}
