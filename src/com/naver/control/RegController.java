package com.naver.control;

import java.util.List;
import java.util.Scanner;

import com.naver.input.RegInput;
import com.naver.regions.RegionsDAO;
import com.naver.regions.RegionsDTO;
import com.naver.view.RegView;

public class RegController {
	private Scanner sc;
	private RegionsDAO regionsDAO;
	private RegInput regInput;
	private RegView regView;
	
	public RegController() {
		sc =  new Scanner(System.in);
		regionsDAO = new RegionsDAO();
		regInput = new RegInput();
		regView = new RegView();
	}
	
	public void start() {
		boolean check = true;
		
		while(check) {
			System.out.println("-------------");
			System.out.println("Regions");
			System.out.println("1. 전체출력");
			System.out.println("2. 검색");
			System.out.println("3. 추가");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				List<RegionsDTO> ar = regionsDAO.getSelectAll();
				if(ar.size()!=0) {
					regView.view(ar);
				} else {
					regView.view("데이터가 없습니다.");
				}
				break;
				
			case 2:
				int region_id = regInput.oneInput();
				RegionsDTO regionsDTO = regionsDAO.getSelectOne(region_id);
				if(regionsDTO!=null) {
					regView.view(regionsDTO);
				} else {
					regView.view("검색할 수 없습니다.");
				}
				break;
				
			case 3:
				RegionsDTO regionsDTO2 = regInput.allInput();
				int result = regionsDAO.insert(regionsDTO2);
				if(result>0) {
					regView.view("추가 성공");
					regView.view(regionsDTO2);
				} else {
					regView.view("추가 실패");
				}
				break;
				
			case 4:
				region_id = regInput.oneInput();
				result = regionsDAO.delete(region_id);
				if(result>0) {
					regView.view("삭제 성공");
				} else {
					regView.view("삭제 실패");
				}
				break;
				
			default:
				check=!check;
			}//switch
		}//while
		
	}//start

}
