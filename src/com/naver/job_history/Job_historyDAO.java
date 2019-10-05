package com.naver.job_history;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.util.DBConnector;

public class Job_historyDAO {
	public List<Job_historyDTO> getSelectAll() {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		Job_historyDTO job_historyDTO = null;
		ArrayList<Job_historyDTO> ar = new ArrayList<Job_historyDTO>();
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from job_history";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			
			while(rs.next()) {
				job_historyDTO = new Job_historyDTO();
				job_historyDTO.setEmployee_id(rs.getInt(1));
				job_historyDTO.setStart_date(rs.getString(2));
				job_historyDTO.setEnd_date(rs.getString(3));
				job_historyDTO.setJob_id(rs.getString(4));
				job_historyDTO.setDepartment_id(rs.getInt(5));
				
				ar.add(job_historyDTO);
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

	public Job_historyDTO getSelectOne(int employee_id) {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		Job_historyDTO job_historyDTO =null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from job_history where employee_id=?";
			st=con.prepareStatement(sql);
			st.setInt(1, employee_id);
			rs=st.executeQuery();
			
			if(rs.next()) {
				job_historyDTO = new Job_historyDTO();
				job_historyDTO.setEmployee_id(rs.getInt(1));
				job_historyDTO.setStart_date(rs.getString(2));
				job_historyDTO.setEnd_date(rs.getString(3));
				job_historyDTO.setJob_id(rs.getString(4));
				job_historyDTO.setDepartment_id(rs.getInt(5));
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
		
		return job_historyDTO;
	}//getselectone

	public int insert(Job_historyDTO job_historyDTO) {
		Connection con =null;
		PreparedStatement st=null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql="insert into job_history values(?,?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1, job_historyDTO.getEmployee_id());
			st.setString(2, job_historyDTO.getStart_date());
			st.setString(3, job_historyDTO.getEnd_date());
			st.setString(4, job_historyDTO.getJob_id());
			st.setInt(5, job_historyDTO.getDepartment_id());
			
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
			String sql = "delete job_history where employee_id=?";
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
