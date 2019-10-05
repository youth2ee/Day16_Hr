package com.naver.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.naver.util.DBConnector;

public class DepartmentsDAO {
	public List<DepartmentsDTO> getSelectAll() {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		DepartmentsDTO departmentsDTO =null;
		ArrayList<DepartmentsDTO> ar = new ArrayList<DepartmentsDTO>();
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from departments";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				departmentsDTO = new DepartmentsDTO();
				departmentsDTO.setDepartment_id(rs.getInt(1));
				departmentsDTO.setDepartment_name(rs.getString(2));
				departmentsDTO.setManager_id(rs.getInt(3));
				departmentsDTO.setLocation_id(rs.getInt(4));
				
				ar.add(departmentsDTO);
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
	
	public DepartmentsDTO getSelectOne(int department_id) {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		DepartmentsDTO departmentsDTO =null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from departments where department_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, department_id);
			rs=st.executeQuery();
			
			if(rs.next()) {
				departmentsDTO = new DepartmentsDTO();
				departmentsDTO.setDepartment_id(rs.getInt(1));
				departmentsDTO.setDepartment_name(rs.getString(2));
				departmentsDTO.setManager_id(rs.getInt(3));
				departmentsDTO.setLocation_id(rs.getInt(4));
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
		
		return departmentsDTO;
	}//getselectone
	
	public int insert(DepartmentsDTO departmentsDTO) {
		Connection con =null;
		PreparedStatement st=null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql="insert into departments values(?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1, departmentsDTO.getDepartment_id());
			st.setString(2, departmentsDTO.getDepartment_name());
			st.setInt(3, departmentsDTO.getManager_id());
			st.setInt(4, departmentsDTO.getLocation_id());
			
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
	
	public int delete(int department_id) {
		Connection con =null;
		PreparedStatement st =null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql = "delete departments where department_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, department_id);
			
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
