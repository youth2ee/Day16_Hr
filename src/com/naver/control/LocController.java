package com.naver.control;

import java.util.List;
import java.util.Scanner;

import com.naver.input.LocInput;
import com.naver.locations.LocationsDAO;
import com.naver.locations.LocationsDTO;
import com.naver.view.LocView;

public class LocController {
	private Scanner sc;
	private LocationsDAO locationsDAO;
	private LocInput locInput;
	private LocView locView;
	
	public LocController() {
		sc = new Scanner(System.in);
		locationsDAO = new LocationsDAO();
		locInput = new LocInput();
		locView = new LocView();
	}

	public void start() {
		boolean check = true;
		
		while(check) {
			System.out.println("-------------");
			System.out.println("Locations");
			System.out.println("1. 전체출력");
			System.out.println("2. 검색");
			System.out.println("3. 추가");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				List<LocationsDTO> ar = locationsDAO.getSelectAll();
				if(ar.size()!=0) {
					locView.view(ar);
				} else {
					locView.view("데이터가 없습니다.");
				}
				break;
				
			case 2:
				int location_id = locInput.oneInput();
				LocationsDTO locationsDTO = locationsDAO.getSelectOne(location_id);
				if(locationsDTO!=null) {
					locView.view(locationsDTO);					
				} else {
					locView.view("검색할 수 없습니다.");
				}
				break;
				
			case 3:
				LocationsDTO locationsDTO2 = locInput.allInput();
				int result = locationsDAO.insert(locationsDTO2);
				if(result>0) {
					locView.view("추가 성공");
					locView.view(locationsDTO2);
				} else {
					locView.view("추가 실패");
				}
				break;
				
			case 4:
				location_id = locInput.oneInput();
				result = locationsDAO.delete(location_id);
				if(result>0) {
					locView.view("삭제 성공");
				} else {
					locView.view("삭제 실패");
				}
				break;
				
			default:
				check=!check;
			}//switch
		}//while
		
	}//start
	
}
