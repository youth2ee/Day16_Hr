package com.naver.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.util.DBConnector;

public class RegionsDAO {
	public List<RegionsDTO> getSelectAll() {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		RegionsDTO regionsDTO =null;
		ArrayList<RegionsDTO> ar = new ArrayList<RegionsDTO>();
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from regions";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				regionsDTO = new RegionsDTO();
				regionsDTO.setRegion_id(rs.getInt(1));
				regionsDTO.setRegion_name(rs.getString(2));
				
				ar.add(regionsDTO);
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

	public RegionsDTO getSelectOne(int region_id) {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		RegionsDTO regionsDTO =null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from regions where region_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, region_id);
			rs=st.executeQuery();
			
			if(rs.next()) {
				regionsDTO = new RegionsDTO();
				regionsDTO.setRegion_id(rs.getInt(1));
				regionsDTO.setRegion_name(rs.getString(2));
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
		
		return regionsDTO;
	}//getselectone

	public int insert(RegionsDTO regionsDTO) {
		Connection con =null;
		PreparedStatement st=null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql="insert into regions values(?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1, regionsDTO.getRegion_id());
			st.setString(2, regionsDTO.getRegion_name());
			
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

	public int delete(int region_id) {
		Connection con =null;
		PreparedStatement st =null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql = "delete regions where region_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, region_id);
			
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
