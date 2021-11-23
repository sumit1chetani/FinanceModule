package com.dci.tenant.department;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDAO objDepartmentDAO;

	@Override
	public List<DepartmentBean> getDepartmentList(int limit, int offset) throws Exception {
		return objDepartmentDAO.getDepartmentList(limit, offset);
	}

	@Override
	public DepartmentResultBean getEmployee() {
		return objDepartmentDAO.getEmployee();
	}

	@Override
	public boolean addDepartment(DepartmentBean objDepartmentBean) throws Exception {
		return objDepartmentDAO.addDepartment(objDepartmentBean);
	}

	@Override
	public boolean updateDepartment(DepartmentBean objDepartmentBean) throws Exception {
		return objDepartmentDAO.updateDepartment(objDepartmentBean);
	}

	@Override
	public boolean deleteDepartment(String dCode) throws Exception {
		return objDepartmentDAO.deleteDepartment(dCode);
	}

	@Override
	public DepartmentBean getdepartmentValues(String deptCode) throws Exception {
		return objDepartmentDAO.getdepartmentValues(deptCode);
	}

	@Override
	public List getDepartment() {
		return objDepartmentDAO.getDepartment();
	}

}

