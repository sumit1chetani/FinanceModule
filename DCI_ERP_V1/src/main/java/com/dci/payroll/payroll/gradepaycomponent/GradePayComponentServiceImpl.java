package com.dci.payroll.payroll.gradepaycomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradePayComponentServiceImpl implements GradePayComponentService {
	@Autowired
	GradePayComponentDAO gradePayComDAO;

	@Override
	public List<Map<String, Object>> getGradePayComponentList(Integer gradeId) throws Exception {
		// TODO Auto-generated method stub
		return gradePayComDAO.getGradePayComponentList(gradeId);
	}

	@Override
	public List<GradePayComponentBean> getListByIdDate(Integer gradeId, String fromDate) throws Exception {
		// TODO Auto-generated method stub
		return gradePayComDAO.getListByIdDate(gradeId, fromDate);
	}

	@Override
	public boolean insertGradePayComponent(ArrayList<GradePayComponentBean> gradePayComBean) throws Exception {
		// TODO Auto-generated method stub
		return gradePayComDAO.insertGradePayComponent(gradePayComBean);
	}

	@Override
	public GradePayComponentBean getGradeMaxDate(int gradeId) throws Exception {
		// TODO Auto-generated method stub
		return gradePayComDAO.getGradeMaxDate(gradeId);
	}

	@Override
	public boolean updateGradePayComponent(ArrayList<GradePayComponentBean> gradePayComBean) throws Exception {
		// TODO Auto-generated method stub
		return gradePayComDAO.updateGradePayComponent(gradePayComBean);
	}

	@Override
	public boolean deleteGradePayComponenet(Integer gradeId, String fromDate) throws Exception {
		// TODO Auto-generated method stub
		return gradePayComDAO.deleteGradePayComponenet(gradeId, fromDate);
	}

	@Override
	public List<GradePayComponentBean> getGradeList(String companyId) throws Exception {
		// TODO Auto-generated method stub
		return gradePayComDAO.getGradeList(companyId);
	}

	@Override
	public List<GradePayComponentBean> checkEmployeeExists(String fromdate, Integer gradeId) throws Exception {
		// TODO Auto-generated method stub
		return gradePayComDAO.checkEmployeeExists(fromdate, gradeId);
	}

	@Override
	public boolean insertGrdePayComponent(String fromdate, Integer gradeId) throws Exception {
		// TODO Auto-generated method stub
		return gradePayComDAO.insertGrdePayComponent(fromdate, gradeId);
	}
}