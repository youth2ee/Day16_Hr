package com.naver.jobs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.departments.DepartmentsDTO;
import com.naver.util.DBConnector;

public class JobsDAO {

	public List<JobsDTO> getSelectAll() {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		JobsDTO jobsDTO =null;
		ArrayList<JobsDTO> ar = new ArrayList<JobsDTO>();

		try {
			con=DBConnector.getConnect();
			String sql = "select * from jobs";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();

			while(rs.next()) {
				jobsDTO = new JobsDTO();
				jobsDTO.setJob_id(rs.getString(1));
				jobsDTO.setJob_title(rs.getString(2));
				jobsDTO.setMin_salary(rs.getInt(3));
				jobsDTO.setMax_salary(rs.getInt(4));

				ar.add(jobsDTO);
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

	public JobsDTO getSelectOne(String job_id) {
		Connection con =null;
		PreparedStatement st =null;
		ResultSet rs =null;
		JobsDTO jobsDTO = null;
		
		try {
			con=DBConnector.getConnect();
			String sql = "select * from jobs where job_id=?";
			st=con.prepareStatement(sql);
			st.setString(1, job_id);
			rs=st.executeQuery();
			
			if(rs.next()) {
				jobsDTO = new JobsDTO();
				jobsDTO.setJob_id(rs.getString(1));
				jobsDTO.setJob_title(rs.getString(2));
				jobsDTO.setMin_salary(rs.getInt(3));
				jobsDTO.setMax_salary(rs.getInt(4));
				
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
		
		return jobsDTO;
	}//getselectone

	public int insert(JobsDTO jobsDTO) {
		Connection con =null;
		PreparedStatement st=null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql="insert into jobs values(?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setString(1, jobsDTO.getJob_id());
			st.setString(2, jobsDTO.getJob_title());
			st.setInt(3, jobsDTO.getMin_salary());
			st.setInt(4, jobsDTO.getMax_salary());
			
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

	public int delete(String job_id) {
		Connection con =null;
		PreparedStatement st =null;
		int result =0;
		
		try {
			con=DBConnector.getConnect();
			String sql = "delete jobs where job_id=?";
			st=con.prepareStatement(sql);
			st.setString(1, job_id);
			
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
