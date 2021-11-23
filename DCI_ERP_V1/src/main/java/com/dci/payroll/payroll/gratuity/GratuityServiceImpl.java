package com.dci.payroll.payroll.gratuity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GratuityServiceImpl implements GratuityService {
	@Autowired
	GratuityDAO gratuityDAO;

	@Override
	public List<GratuityBean> getGratuityList() throws Exception {
		return gratuityDAO.getGratuityList();
	}

	@Override
	public GratuityBean getGratuityById(String employeeId) throws Exception {
		return gratuityDAO.getGratuityById(employeeId);
	}

	@Override
	public boolean insertGratuity(GratuityBean gratuity) throws Exception {
		return gratuityDAO.insertGratuity(gratuity);
	}

	@Override
	public boolean updateGratuity(GratuityBean gratuity) throws Exception {
		return gratuityDAO.updateGratuity(gratuity);
	}

}
