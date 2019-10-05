package com.naver.control;

import java.util.List;
import java.util.Scanner;

import com.naver.countries.CountriesDAO;
import com.naver.countries.CountriesDTO;
import com.naver.input.ConInput;
import com.naver.view.ConView;

public class ConController {
	private Scanner sc;
	private CountriesDAO countriesDAO;
	private ConInput conInput;
	private ConView conView;

	public ConController() {
		sc = new Scanner(System.in);
		countriesDAO = new CountriesDAO();
		conInput = new ConInput();
		conView = new ConView();
	}

	public void start() {
		boolean check = true;

		while(check) {
			System.out.println("-------------");
			System.out.println("Countries");
			System.out.println("1. 전체출력");
			System.out.println("2. 검색");
			System.out.println("3. 추가");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			int num = sc.nextInt();

			switch (num) {
			case 1:
				List<CountriesDTO> ar = countriesDAO.getSelectAll();
				if(ar.size()!=0) {
					conView.view(ar);
				} else {
					conView.view("데이터가 없습니다.");
				}
				break;

			case 2:
				String country_id = conInput.oneInput();
				CountriesDTO countriesDTO = countriesDAO.getSelectOne(country_id);
				if(countriesDTO!=null) {
					conView.view(countriesDTO);
				} else {
					conView.view("검색할 수 없습니다.");
				}
				break;

			case 3:
				CountriesDTO countriesDTO2 = conInput.allInput();
				int result = countriesDAO.insert(countriesDTO2);
				if(result>0) {
					conView.view("추가 성공");
					conView.view(countriesDTO2);
				} else {
					conView.view("추가 실패");
				}
				break;

			case 4:
				country_id = conInput.oneInput();
				result = countriesDAO.delete(country_id);
				if(result>0) {
					conView.view("삭제 성공");
				} else {
					conView.view("삭제 실패");
				}
				break;

			default:
				check=!check;
			}//switch
		}//while
	}//start
}
