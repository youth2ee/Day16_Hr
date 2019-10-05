package com.naver.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.util.DBConnector;

public class CountriesDAO {
	
	public List<CountriesDTO> getSelectAll() {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		CountriesDTO countriesDTO =null;
		ArrayList<CountriesDTO> ar = new ArrayList<CountriesDTO>();
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from countries";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				countriesDTO = new CountriesDTO();
				countriesDTO.setCountry_id(rs.getString(1));
				countriesDTO.setCountry_name(rs.getString(2));
				countriesDTO.setRegion_id(rs.getInt(3));
				
				ar.add(countriesDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ar;
	}//getSelectAll
	
	
	public CountriesDTO getSelectOne(String country_id) {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		CountriesDTO countriesDTO =null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from countries where country_id=?";
			st=con.prepareStatement(sql);
			st.setString(1, country_id);
			rs=st.executeQuery();
			
			if(rs.next()) {
				countriesDTO = new CountriesDTO();
				countriesDTO.setCountry_id(rs.getString(1));
				countriesDTO.setCountry_name(rs.getString(2));
				countriesDTO.setRegion_id(rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return countriesDTO;
	} //getSelectOne
	
	public int insert(CountriesDTO countriesDTO) {
		Connection con =null;
		PreparedStatement st=null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql="insert into countries values(?,?,?)";
			st=con.prepareStatement(sql);
			st.setString(1, countriesDTO.getCountry_id());
			st.setString(2, countriesDTO.getCountry_name());
			st.setInt(3, countriesDTO.getRegion_id());
			
			result = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}//insert
	
	public int delete(String country_id) {
		Connection con =null;
		PreparedStatement st =null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql = "delete countries where country_id=?";
			st=con.prepareStatement(sql);
			st.setString(1, country_id);
			
			result = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}///delete

}
