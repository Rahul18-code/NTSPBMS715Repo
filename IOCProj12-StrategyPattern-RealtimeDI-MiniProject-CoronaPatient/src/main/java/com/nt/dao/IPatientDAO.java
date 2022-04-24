package com.nt.dao;

import com.nt.bo.PatientBO;

public interface IPatientDAO {
	public int insert(PatientBO patBO)throws Exception;
}
