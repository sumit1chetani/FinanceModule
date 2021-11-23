package com.dci.payroll.payroll.gradepaycomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dci.common.util.CustomException;


public interface GradePayComponentDAO {
	public List<Map<String, Object>> getGradePayComponentList(Integer gradeId) throws CustomException;

	public List<GradePayComponentBean> getListByIdDate(Integer gradeId, String fromDate) throws CustomException;

	public boolean insertGradePayComponent(ArrayList<GradePayComponentBean> gradePayComBean) throws CustomException;

	public GradePayComponentBean getGradeMaxDate(Integer gradeId) throws CustomException;

	public boolean updateGradePayComponent(ArrayList<GradePayComponentBean> gradePayComBean) throws CustomException;

	public boolean deleteGradePayComponenet(Integer gradeId, String fromDate) throws CustomException;

	List<GradePayComponentBean> getGradeList(String companyId) throws CustomException;

	List<GradePayComponentBean> checkEmployeeExists(String fromdate, Integer gradeId) throws CustomException;

	boolean insertGrdePayComponent(String fromdate, Integer gradeId) throws CustomException;

}