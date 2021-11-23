package com.dci.payroll.payroll.gratuity;

import java.util.List;

public interface GratuityService {

	List<GratuityBean> getGratuityList() throws Exception;

	GratuityBean getGratuityById(String employeeId) throws Exception;

	boolean insertGratuity(GratuityBean gratuity) throws Exception;

	boolean updateGratuity(GratuityBean Gratuity) throws Exception;

}
