package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public final class EmployeeDAOImpl implements IEmployeeDAO{
	private static final String EMPLOYEE_INSERT_QUERY="INSERT INTO EMPLOYEE_DI VALUES(EMPLOYEE_ENO_SEQ.NEXTVAL,?,?,?,?,?)";
	//HAS -A property
	private DataSource ds;
	public EmployeeDAOImpl(DataSource ds) {
		System.out.println("EmployeeDAOImpl:: 1-param constructor");
		this.ds = ds;
	}
	public int insert(EmployeeBO empBO)throws Exception{
		System.out.println("EmployeeDAOImpl.insert()");
		int count=0;
		//get pooled jdbc connection
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(EMPLOYEE_INSERT_QUERY);){
			if(ps!=null) {
				//set values to query by collecting the data from BO
				ps.setString(1, empBO.getEname());
				ps.setString(2, empBO.getEadd()); 
				ps.setDouble(3, empBO.getBasicsalary());
				ps.setDouble(4, empBO.getGrosssalary());
				ps.setDouble(5, empBO.getNetsalary());
				//execute the query
				count=ps.executeUpdate();
			}//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}//catch
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}//catch
		return count;
	}//method
}//class
