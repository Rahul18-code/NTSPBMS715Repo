package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.GuestBO;

public final class GuestDAOImpl implements IGuestDAO{
	private static final String GUEST_INSERT_QUERY="INSERT INTO GUEST_DI VALUES(GUEST_NO_SEQ.NEXTVAL,?,?,?,?,?)";
	//HAS -A property
	private DataSource ds;
	public GuestDAOImpl(DataSource ds) {
		System.out.println("GuestDAOImpl:: 1-param constructor");
		this.ds=ds;
	}
	public int insert(GuestBO guestBO)throws Exception{
		System.out.println("GuestDAOImpl.insert()");
		int count=0;
		//get pooled jdbc connection
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GUEST_INSERT_QUERY);){
			if(ps!=null) {
				//set values to query by collecting the data from BO
				ps.setString(1, guestBO.getGname());
				ps.setString(2, guestBO.getGadd());
				ps.setDouble(3, guestBO.getPdaycharge());
				ps.setInt(4, guestBO.getDaysstayed());
				ps.setDouble(5, guestBO.getBill());
				//execute the query
				count=ps.executeUpdate();
			}	//if
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
