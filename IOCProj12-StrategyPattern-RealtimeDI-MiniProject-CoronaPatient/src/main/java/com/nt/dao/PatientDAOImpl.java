package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.PatientBO;

public final class PatientDAOImpl implements IPatientDAO{
	private static final String PATIENT_INSERT_QUERY="INSERT INTO CORONA_PATIENT_DI VALUES(PATIENT_NO_SEQ.NEXTVAL,?,?,?,?)";
		//has -a property
	private DataSource ds;
		public PatientDAOImpl(DataSource ds) {
			System.out.println("PatientDAOImpl:: 1-param constructor");
			this.ds = ds;
		}
		
		public int insert(PatientBO patBO)throws Exception{
			System.out.println("PatientDAOImpl.insert()");
			int count=0;
			//get pooled jdbc connection
			try (Connection con=ds.getConnection();
					PreparedStatement ps=con.prepareStatement(PATIENT_INSERT_QUERY);){
				if(ps!=null) {
					//set values to query param by collecting the data from BO
					ps.setString(1, patBO.getPname());
					ps.setString(2, patBO.getPadd());
					ps.setDouble(3, patBO.getPdaycharge());
					ps.setDouble(4, patBO.getBill());
					//execte the query 
					count=ps.executeUpdate();
				}//if
				
			}//try
			catch(SQLException se) {
				se.printStackTrace();
				throw se;
			}
			catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
			return count;
		}//method
	 
}//class
