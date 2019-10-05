package com.naver.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.naver.util.DBConnector;

public class EmployeesDAO {
	
	public List<EmployeesDTO> getSelectAll() {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		EmployeesDTO employeesDTO =null;
		ArrayList<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();

		try {
			con=DBConnector.getConnect();
			String sql = "select * from employees";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				employeesDTO = new EmployeesDTO();
				employeesDTO.setEmployee_id(rs.getInt(1));
				employeesDTO.setFirst_name(rs.getString(2));
				employeesDTO.setLast_name(rs.getString(3));
				employeesDTO.setEmail(rs.getString(4));
				employeesDTO.setPhone_number(rs.getString(5));
				employeesDTO.setHire_date(rs.getString(6));
				employeesDTO.setJob_id(rs.getString(7));
				employeesDTO.setSalary(rs.getInt(8));
				employeesDTO.setCommission_pct(rs.getDouble(9));
				employeesDTO.setManager_id(rs.getInt(10));
				employeesDTO.setDepartment_id(rs.getInt(11));
				
				
				ar.add(employeesDTO);
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

	public EmployeesDTO getSelectOne(int employee_id) {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		EmployeesDTO employeesDTO =null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from employees where employee_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, employee_id);
			rs=st.executeQuery();
			
			if(rs.next()) {
				employeesDTO = new EmployeesDTO();
				employeesDTO.setEmployee_id(rs.getInt(1));
				employeesDTO.setFirst_name(rs.getString(2));
				employeesDTO.setLast_name(rs.getString(3));
				employeesDTO.setEmail(rs.getString(4));
				employeesDTO.setPhone_number(rs.getString(5));
				employeesDTO.setHire_date(rs.getString(6));
				employeesDTO.setJob_id(rs.getString(7));
				employeesDTO.setSalary(rs.getInt(8));
				employeesDTO.setCommission_pct(rs.getDouble(9));
				employeesDTO.setManager_id(rs.getInt(10));
				employeesDTO.setDepartment_id(rs.getInt(11));
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
		
		return employeesDTO;
	}//getselectone

	public int insert(EmployeesDTO employeesDTO) {
		Connection con =null;
		PreparedStatement st =null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql="insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1, employeesDTO.getEmployee_id());
			st.setString(2, employeesDTO.getFirst_name());
			st.setString(3, employeesDTO.getLast_name());
			st.setString(4, employeesDTO.getEmail());
			st.setString(5, employeesDTO.getPhone_number());
			st.setString(6, employeesDTO.getHire_date());
			st.setString(7, employeesDTO.getJob_id());
			st.setInt(8, employeesDTO.getSalary());
			st.setDouble(9, employeesDTO.getCommission_pct());
			st.setInt(10, employeesDTO.getManager_id());
			st.setInt(11, employeesDTO.getDepartment_id());
			
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
			String sql = "delete employees where employee_id=?";
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
