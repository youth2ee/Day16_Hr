package com.naver.emp_details_view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.util.DBConnector;

public class EmpDetailsViewDAO {
	
	public List<EmpDetailsViewDTO> getSelectAll() {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		EmpDetailsViewDTO empDetailsViewDTO = new EmpDetailsViewDTO();
		ArrayList<EmpDetailsViewDTO> ar = new ArrayList<EmpDetailsViewDTO>();
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from emp_details_view";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				empDetailsViewDTO = new EmpDetailsViewDTO();
				empDetailsViewDTO.setEmployee_id(rs.getInt(1));
				empDetailsViewDTO.setJob_id(rs.getString(2));
				empDetailsViewDTO.setManager_id(rs.getInt(3));
				empDetailsViewDTO.setDepartment_id(rs.getInt(4));
				empDetailsViewDTO.setLocation_id(rs.getInt(5));
				empDetailsViewDTO.setCountry_id(rs.getString(6));
				empDetailsViewDTO.setFirst_name(rs.getString(7));
				empDetailsViewDTO.setSalary(rs.getInt(8));
				empDetailsViewDTO.setCommission_pct(rs.getDouble(9));
				empDetailsViewDTO.setDepartment_name(rs.getString(10));
				empDetailsViewDTO.setJob_title(rs.getString(11));
				empDetailsViewDTO.setCity(rs.getString(12));
				empDetailsViewDTO.setState_province(rs.getString(13));
				empDetailsViewDTO.setCountry_name(rs.getString(14));
				empDetailsViewDTO.setRegion_name(rs.getString(15));
			
				ar.add(empDetailsViewDTO);
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

	public EmpDetailsViewDTO getSelectOne(int employee_id) {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		EmpDetailsViewDTO empDetailsViewDTO =null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from emp_details_view where employee_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, employee_id);
			rs=st.executeQuery();
			
			if(rs.next()) {
				empDetailsViewDTO = new EmpDetailsViewDTO();
				empDetailsViewDTO.setEmployee_id(rs.getInt(1));
				empDetailsViewDTO.setJob_id(rs.getString(2));
				empDetailsViewDTO.setManager_id(rs.getInt(3));
				empDetailsViewDTO.setDepartment_id(rs.getInt(4));
				empDetailsViewDTO.setLocation_id(rs.getInt(5));
				empDetailsViewDTO.setCountry_id(rs.getString(6));
				empDetailsViewDTO.setFirst_name(rs.getString(7));
				empDetailsViewDTO.setSalary(rs.getInt(8));
				empDetailsViewDTO.setCommission_pct(rs.getDouble(9));
				empDetailsViewDTO.setDepartment_name(rs.getString(10));
				empDetailsViewDTO.setJob_title(rs.getString(11));
				empDetailsViewDTO.setCity(rs.getString(12));
				empDetailsViewDTO.setState_province(rs.getString(13));
				empDetailsViewDTO.setCountry_name(rs.getString(14));
				empDetailsViewDTO.setRegion_name(rs.getString(15));
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
		
		return empDetailsViewDTO;
	}//getselectone

	public int insert(EmpDetailsViewDTO empDetailsViewDTO) {
		Connection con =null;
		PreparedStatement st=null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql="insert into emp_details_view values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1, empDetailsViewDTO.getEmployee_id());
			st.setString(2, empDetailsViewDTO.getJob_id());
			st.setInt(3, empDetailsViewDTO.getManager_id());
			st.setInt(4, empDetailsViewDTO.getDepartment_id());
			st.setInt(5, empDetailsViewDTO.getLocation_id());
			st.setString(6, empDetailsViewDTO.getCountry_id());
			st.setString(7, empDetailsViewDTO.getFirst_name());
			st.setInt(8, empDetailsViewDTO.getSalary());
			st.setDouble(9, empDetailsViewDTO.getCommission_pct());
			st.setString(10, empDetailsViewDTO.getDepartment_name());
			st.setString(11, empDetailsViewDTO.getJob_title());
			st.setString(12, empDetailsViewDTO.getCity());
			st.setString(13, empDetailsViewDTO.getState_province());
			st.setString(14, empDetailsViewDTO.getCountry_name());
			st.setString(15, empDetailsViewDTO.getRegion_name());

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

	public int delete(int employee_id) {
		Connection con =null;
		PreparedStatement st =null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql = "delete emp_details_view where employee_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, employee_id);
			
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
