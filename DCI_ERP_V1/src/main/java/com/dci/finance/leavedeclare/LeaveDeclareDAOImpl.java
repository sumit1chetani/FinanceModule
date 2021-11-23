package com.dci.finance.leavedeclare;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;


@Repository
@Transactional("tenantTransactionManager")

public class LeaveDeclareDAOImpl implements LeaveDeclareDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LeaveDeclareDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public List<LeaveDeclareBean> getLeaveList() throws Exception {
		// TODO Auto-generated method stub
		List<LeaveDeclareBean> reusltLeave = new ArrayList<LeaveDeclareBean>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveDeclareQueryUtil.listLeaveQuery);
		for (Map row : rows) {
			LeaveDeclareBean leaveBean = new LeaveDeclareBean();
			String branch_code=String.valueOf((int) row.get("branchCode"));
			leaveBean.setCompanyName((String) row.get("companyName"));
			leaveBean.setBranch((String) row.get("branch"));
			leaveBean.setBranchCode(branch_code);
			//leaveBean.setGradeName((String) row.get("gradeName"));
			leaveBean.setYearValue((int) row.get("year"));
			//String grade = String.valueOf((int) row.get("gradeId"));
			//leaveBean.setGradeId(grade);
			reusltLeave.add(leaveBean);
		}

		return reusltLeave;
	}

	@Override
	public LeaveDeclareResultBean getGradeList(String companyId) throws Exception {
		// TODO Auto-generated method stub
		LeaveDeclareResultBean resultBean = new LeaveDeclareResultBean();
		List<LeaveDeclareBean> gradeResult = new ArrayList<LeaveDeclareBean>();
		try {
			gradeResult = jdbcTemplate.query(LeaveDeclareQueryUtil.getGradeQuery, new BeanPropertyRowMapper<LeaveDeclareBean>(LeaveDeclareBean.class), companyId);
			resultBean.setGradeList(gradeResult);
			resultBean.setSuccess(true);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getgradeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;
	}

	@Override
	public LeaveDeclareResultBean getYearList() throws Exception {
		LeaveDeclareResultBean resultBean = new LeaveDeclareResultBean();
		List<LeaveDeclareBean> yearResult = new ArrayList<LeaveDeclareBean>();
		try {
			yearResult = jdbcTemplate.query(LeaveDeclareQueryUtil.getYearQuery, new BeanPropertyRowMapper<LeaveDeclareBean>(LeaveDeclareBean.class));
			resultBean.setYearList(yearResult);
		} catch (DataAccessException a) {
			LOGGER.error("error in YearList", a);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return resultBean;
	}

	@Override
	public LeaveDeclareResultBean getLeaveType(String branchId,int yearId) throws Exception {
		// TODO Auto-generated method stub
		LeaveDeclareResultBean resultBean = new LeaveDeclareResultBean();
		List<leavedeclareListBean> leaveType = new ArrayList<leavedeclareListBean>();
		try {
			leaveType = jdbcTemplate.query(LeaveDeclareQueryUtil.leaveType, new BeanPropertyRowMapper<leavedeclareListBean>(leavedeclareListBean.class), new Object[] {  branchId,  yearId , branchId,  yearId });
			resultBean.setGradeTypeList(leaveType);
		} catch (DataAccessException a) {
			LOGGER.error("error in YearList", a);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return resultBean;
	}

	@Override
	public void saveLeaveDetails(LeaveDeclareResultBean leaveBean) throws Exception {
		// TODO Auto-generated method stub
		List<LeaveDeclareBean> gradeResult = new ArrayList<LeaveDeclareBean>();
		LeaveDeclareResultBean resultBean = new LeaveDeclareResultBean();

		try {

			List<leavedeclareListBean> temp = leaveBean.getGradeTypeList();
			LeaveDeclareBean leaveDeclareBean = leaveBean.getLeaveDeclareObj();

			java.util.Iterator<leavedeclareListBean> ite = temp.iterator();
			while (ite.hasNext()) {
				leavedeclareListBean result = ite.next();
				String leave_month = result.getLeavemonth();
				String leave_year = result.getLeaveyear();
				String leave_type = result.getLeaveType();
                String branch =leaveDeclareBean.getBranch();
                String companyName =leaveDeclareBean.getCompanyName();
                   
				double leave_Year = Double.parseDouble(leave_year);
				double leave_Month = Double.parseDouble(leave_month);
				int year = Integer.parseInt(leaveDeclareBean.getYear());
                int branch_id=Integer.parseInt(branch);
				//int count = jdbcTemplate.queryForObject(LeaveDeclareQueryUtil.checkLeaveDeclare, Integer.class, leave_type,  year ,branch );
				int count = jdbcTemplate.queryForObject(LeaveDeclareQueryUtil.checkLeaveDeclare, Integer.class, leave_type,  year  );

				List<LeaveDeclareBean> resultLeave = new ArrayList<LeaveDeclareBean>();
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveDeclareQueryUtil.employeeIdByGrade,branch_id);

				
				//String employee = jdbcTemplate.queryForObject(LeaveDeclareQueryUtil.CHECK_EMPLOYEE_BRANCH, String.class,branch );

				
				if (count > 0) {

					int i = jdbcTemplate.update(LeaveDeclareQueryUtil.updateLeaveDeclare, leave_Month, leave_Year,companyName,  leave_type, year ,branch);
					for (Map row : rows) {
						String empId = (String) row.get("empId");
						jdbcTemplate.update(LeaveDeclareQueryUtil.updateData, leave_Month, leave_Year, leave_type, year,branch);
					}

				} else {
					for (Map row1 : rows) {
					gradeResult = jdbcTemplate.query(LeaveDeclareQueryUtil.CHECK_EMPLOYEE_BRANCH, new BeanPropertyRowMapper<LeaveDeclareBean>(LeaveDeclareBean.class), new Object[] {  branch_id});

					resultBean.setEmployeeTypeList(gradeResult);
					
					for (LeaveDeclareBean dtl :gradeResult) {
						
						jdbcTemplate.update(LeaveDeclareQueryUtil.insertleaveDeclare,  leave_type, branch,leave_Month, leave_Year, year,companyName,dtl.getEmpId());
					

					//String empId = (String) row1.get("empId");
					//jdbcTemplate.update(LeaveDeclareQueryUtil.insertleaveDeclare,  leave_type, branch,leave_Month, leave_Year, year,companyName,empId);
					for (Map row : rows) {
						//String empId = (String) row.get("empId");
						jdbcTemplate.update(LeaveDeclareQueryUtil.insertData,branch, dtl.getEmpId(), leave_type, leave_Month, leave_Year, year ,companyName ,dtl.getDept());
					}
				}
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public LeaveDeclareResultBean getEditList(String branch, int year) throws Exception {
		LeaveDeclareResultBean resultBean = new LeaveDeclareResultBean();
		LeaveDeclareBean bb = new LeaveDeclareBean();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveDeclareQueryUtil.leaveEditQuery, new Object[] { branch, year });
		ArrayList list = new ArrayList();

		for (Map row : rows) {

			leavedeclareListBean listBean = new leavedeclareListBean();
			//int grade = ((int) (row.get("gradeId")));
			int yearValue = ((int) (row.get("year")));
			String leave_type = ((String) row.get("leaveType"));
			double month_max = ((double) row.get("leavemonth"));
			double year_max = ((double) row.get("leaveyear"));
			String mon_leave = Double.toString(month_max);
			String year_leave = Double.toString(year_max);
			String companyName = String.valueOf("companyName");
			String companyId = String.valueOf(row.get("companyId"));
			//String gradeName = String.valueOf("gradeName");
			//String gradeID = String.valueOf(grade);
			String branch1 = String.valueOf(row.get("branch"));
			String branchCode = String.valueOf(row.get("branchCode"));
			String year1 = String.valueOf(yearValue);
			listBean.setLeaveType(leave_type);
			listBean.setLeavemonth(mon_leave);
			listBean.setLeaveyear(year_leave);
			bb.setYear(year1);
			//bb.setGradeId(gradeID);
			bb.setCompanyName(companyName);		
			//bb.setGradeName(gradeName);
			bb.setCompanyId(companyId);
			bb.setBranchCode(branchCode);
			bb.setBranch(branch);

			list.add(listBean);

		}
		bb.setisEdit(true);
		resultBean.setGradeTypeList(list);

		resultBean.setLeaveDeclareObj(bb);

		return resultBean;
	}

	@Override
	public boolean deleteLeave(int gradeId, int year) throws Exception {
		boolean isSucess = false;

		int i = jdbcTemplate.update(LeaveDeclareQueryUtil.deleteQuery, gradeId, year);
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(LeaveDeclareQueryUtil.employeeIdByGrade, gradeId);
		for (Map row : rows) {
			String empId = (String) row.get("empId");
			jdbcTemplate.update(LeaveDeclareQueryUtil.deleteEmployeeLeaveType, empId, year);
		}

		System.out.println("iiii" + i);
		if (i > 0) {
			isSucess = true;
		}

		return isSucess;

	}
}
