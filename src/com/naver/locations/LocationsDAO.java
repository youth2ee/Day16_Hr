package com.naver.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.util.DBConnector;

public class LocationsDAO {
	public List<LocationsDTO> getSelectAll() {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		LocationsDTO locationsDTO =null;
		ArrayList<LocationsDTO> ar = new ArrayList<LocationsDTO>();
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from locations";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				locationsDTO = new LocationsDTO();
				locationsDTO.setLocation_id(rs.getInt(1));
				locationsDTO.setStreet_address(rs.getString(2));
				locationsDTO.setPostal_code(rs.getString(3));
				locationsDTO.setCity(rs.getString(4));
				locationsDTO.setState_province(rs.getString(5));
				locationsDTO.setCountry_id(rs.getString(6));
				
				ar.add(locationsDTO);
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
	}//getselectall

	public LocationsDTO getSelectOne(int location_id) {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		LocationsDTO locationsDTO =null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from locations where location_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, location_id);
			rs=st.executeQuery();
			
			if(rs.next()) {
				locationsDTO = new LocationsDTO();
				locationsDTO.setLocation_id(rs.getInt(1));
				locationsDTO.setStreet_address(rs.getString(2));
				locationsDTO.setPostal_code(rs.getString(3));
				locationsDTO.setCity(rs.getString(4));
				locationsDTO.setState_province(rs.getString(5));
				locationsDTO.setCountry_id(rs.getString(6));
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
		
		return locationsDTO;
	}//getselectone

	public int insert(LocationsDTO locationsDTO) {
		Connection con =null;
		PreparedStatement st=null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql="insert into locations values(?,?,?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1, locationsDTO.getLocation_id());
			st.setString(2, locationsDTO.getStreet_address());
			st.setString(3, locationsDTO.getPostal_code());
			st.setString(4, locationsDTO.getCity());
			st.setString(5, locationsDTO.getState_province());
			st.setString(6, locationsDTO.getCountry_id());
			
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

	public int delete(int location_id) {
		Connection con =null;
		PreparedStatement st =null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql = "delete locations where location_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, location_id);
			
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
	}//delete

}
