package com.dci.tenant.designation;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	DesignationDAO objDesignationDAO;

	@Override
	public List<DesignationBean> getDesignationList(int limit, int offset) throws Exception {
		return objDesignationDAO.getDesignationList(limit, offset);
	}

	@Override
	public boolean addDesignation(DesignationBean objDesignationBean) throws Exception {
		return objDesignationDAO.addDesignation(objDesignationBean);
	}

	@Override
	public boolean updateDesignation(DesignationBean objDesignationBean) throws Exception {
		return objDesignationDAO.updateDesignation(objDesignationBean);
	}

	@Override
	public boolean deleteDesignation(String dCode) throws Exception {
		return objDesignationDAO.deleteDesignation(dCode);
	}

	@Override
	public DesignationBean getdesignationValues(String desgnCode) throws Exception {
		return objDesignationDAO.getdesignationValues(desgnCode);
	}

	@Override
	public List getDesignation() {
		return objDesignationDAO.getDesignation();
	}

}

