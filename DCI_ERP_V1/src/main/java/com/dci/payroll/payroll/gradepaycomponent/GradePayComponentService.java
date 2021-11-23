package com.dci.payroll.payroll.gradepaycomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface GradePayComponentService {
	List<Map<String, Object>> getGradePayComponentList(Integer gradeId) throws Exception;

	List<GradePayComponentBean> getListByIdDate(Integer gradeId, String fromDate) throws Exception;

	boolean insertGradePayComponent(ArrayList<GradePayComponentBean> gradePayComBean) throws Exception;

	GradePayComponentBean getGradeMaxDate(int gradeId) throws Exception;

	boolean updateGradePayComponent(ArrayList<GradePayComponentBean> gradePayComBean) throws Exception;

	boolean deleteGradePayComponenet(Integer gradeId, String fromDate) throws Exception;

	public List<GradePayComponentBean> getGradeList(String companyId) throws Exception;

	public List<GradePayComponentBean> checkEmployeeExists(String fromdate, Integer gradeId) throws Exception;

	boolean insertGrdePayComponent(String fromdate, Integer gradeId) throws Exception;

}