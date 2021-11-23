package com.dci.payroll.payroll.gratuity;

import java.util.List;

import com.dci.common.util.CustomException;


public interface GratuityDAO {
	public List<GratuityBean> getGratuityList() throws CustomException;

	public GratuityBean getGratuityById(String employeeId) throws CustomException;

	public boolean insertGratuity(GratuityBean gratuity) throws CustomException;

	public boolean updateGratuity(GratuityBean gratuity) throws CustomException;

}
