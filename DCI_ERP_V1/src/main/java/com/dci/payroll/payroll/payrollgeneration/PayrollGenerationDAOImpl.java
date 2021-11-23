package com.dci.payroll.payroll.payrollgeneration;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.hrms.report.employeeEarlyStart.EmployeeEarlyStartBean;
import com.dci.payroll.payroll.payrollreport.PayrollReportBean;
import com.dci.payroll.payroll.payrollreport.PayrollReportQueryUtil;
import com.dci.payroll.payroll.payslip.PaySlipBean;
import com.dci.payroll.payroll.payslip.PaySlipDAO;
import com.dci.payroll.payroll.payslip.PaySlipDTO;
import com.dci.payroll.payroll.payslip.PaySlipListDTO;
import com.dci.payroll.payroll.payslip.PaySlipResultBean;
import com.dci.tenant.user.UserDetail;


@Repository
public class PayrollGenerationDAOImpl implements PayrollGenerationDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(PayrollGenerationDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	PaySlipDAO paySlipDAO;

	/*
	 * public PayrollGenerationResultBean getPayrollFlag(Integer departmentId)
	 * throws CustomException { PayrollGenerationResultBean resultbean = new
	 * PayrollGenerationResultBean(); List<PayrollGenerationBean> flagList = new
	 * ArrayList<>(); try { flagList =
	 * jdbcTemplate.query(PayrollGenerationQueryUtil.FLAG_EMPLOYEE_ISSUE, new
	 * BeanPropertyRowMapper<>(PayrollGenerationBean.class), departmentId);
	 * resultbean.setFlagList(flagList); } catch (Exception e) {
	 * e.printStackTrace(); } return resultbean;
	 * 
	 * }
	 */

	@Override
	public PayrollGenerationBean generatePayroll(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException {
		PayrollGenerationBean payrollBean = null;
		// boolean success = false;
		try {
			String sql = "select count(*) from employee_master where department_id = '" + dept + "'  and emp_id = '" + employeeId + "' and payroll_flag='t' and status='Y'";

			String sql2 = "select count(*) from employee_master where department_id = '" + dept + "' and payroll_flag!='t' and status='Y'";

			int count = jdbcTemplate.queryForObject(sql, Integer.class);
			int count2 = jdbcTemplate.queryForObject(sql2, Integer.class);

			// if (count2 > 0) {
			payrollBean = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.CREATE_SALARY, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), monthYear, companyId, branchId, dept, employeeId);

			int iJvHdr = jdbcTemplate.update(PayrollGenerationQueryUtil.UPDATE_DEPARTMENT, new Object[] { dept, employeeId });

			arrearTax(companyId, branchId, dept, employeeId, monthYear);
			payrollBean.setSuccess(true);
			// }

			/*
			 * else { payrollBean = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.
			 * CREATE_SALARY, new BeanPropertyRowMapper<>(PayrollGenerationBean.class),
			 * monthYear,companyId, branchId, departmentId, employeeId);
			 * payrollBean.setSuccess(true);
			 * 
			 * }
			 */

			if (count > 0) {
				// getPayrollFlag(departmentId);
				/*
				 * PayrollGenerationResultBean employeeMasterResultBean = new
				 * PayrollGenerationResultBean(); List<PayrollGenerationBean> flagList = new
				 * ArrayList<>();
				 * 
				 * flagList = jdbcTemplate.query(PayrollGenerationQueryUtil.
				 * FLAG_EMPLOYEE_ISSUE, new
				 * BeanPropertyRowMapper<>(PayrollGenerationBean.class), departmentId);
				 * employeeMasterResultBean.setFlagList(flagList);
				 */

				// payrollBean.setPayrollFlag(true);

				payrollBean.setFlagMessage(true);

			}

		} catch (DataAccessException e) {
			payrollBean.setSalaryError(true);
			LOGGER.error("Error in generatePayroll", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}
		return payrollBean;
	}

	private void arrearTax(String companyId, String branchId, String dept, String employeeId, String monthYear) {
		List<PayrollGenerationBean> arrearEarnings = new ArrayList<>();
		List<PayrollGenerationBean> earningsAmount = new ArrayList<>();
		String whereCode = "";
		// all

		if (dept != "" && monthYear != "" && employeeId != "") {
		//	whereCode = "  department_id = '" + dept + "' and e.emp_id='" + employeeId + "' and ";
			whereCode = "  dept = '" + dept + "' and e.emp_id='" + employeeId + "' and ";
		}

		// dept and month
		if (dept != "" && monthYear != "" && employeeId == null) {
			whereCode = "  department_id = '" + dept + "' and ";
		}
		// month
		if (dept == "" && monthYear != "" && employeeId == null) {
			// whereCode = " where department_id = " + departmentId + " ";
			whereCode = " ";
		}

		String sqlQuery = "select e.emp_id, e.first_name from employee_master e  left join payroll_withHold ph on ph.emp_id=e.emp_id where " + whereCode + "  e.status='t' and e.emp_id not in ( select e.emp_id from employee_master e left join payroll_withHold ph on ph.emp_id=e.emp_id  where  to_date('" + monthYear + "','MMyyyy')  between to_date(concat(ph.from_month,pH.from_year)::text,'MMyyyy') and to_date(concat(ph.till_month,pH.till_year)::text,'MMyyyy'))";		/*
		 * String sqlQuery = "select employee_id, first_name from employee where " +
		 * whereCode + " payroll_flag='f' and status='t'";
		 */
		arrearEarnings = jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));

		// TODO Auto-generated method stub

		for (PayrollGenerationBean objPayrollGenerationBean : arrearEarnings) {

			String sql = "select count(arrears_from_date) from employee_pay_component where employee_id ='" + objPayrollGenerationBean.getEmployeeId() + "' and fromdate=to_date('" + monthYear + "','MMyyyy')";

			int count = jdbcTemplate.queryForObject(sql, Integer.class);

			if (count >= 1) {

				String arrearDateQuery = "select distinct arrears_from_date from employee_pay_component where employee_id = '" + objPayrollGenerationBean.getEmployeeId() + "' and fromdate=to_date('" + monthYear + "','MMyyyy') and arrears_from_date IS NOT NULL";

				String arrearDate = jdbcTemplate.queryForObject(arrearDateQuery, String.class);

				System.out.println("*******************ARREAR DATE**********************");
				System.out.println(arrearDate);

				String currentGross = "select sum(amount) as currentGross from employee_pay_component_paid epc inner join pay_component pac on pac.pay_component_id= epc.pay_component_id where pay_component_type='1' and pac.status='t' and epc.employee_id = '" + objPayrollGenerationBean.getEmployeeId() + "'  and month_year=('" + monthYear + "')";
				String currentGrossAmount = jdbcTemplate.queryForObject(currentGross, String.class);
				System.out.println("*******************CURRENT GROSS**********************");
				System.out.println(currentGrossAmount);

				/*
				 * String execute = "select epc.month_year , ABS('" + currentGrossAmount +
				 * "'- sum(amount)) as taxSlabAmount from employee_pay_component_paid epc inner join pay_component pac on pac.pay_component_id= epc.pay_component_id where pay_component_type='1' and pac.status='t' and  employee_id = '"
				 * + objPayrollGenerationBean.getEmployeeId() +
				 * "'   and to_date(month_year,'mm/yyyy') between to_date('" + arrearDate +
				 * "','MM/yyyy') and to_date('" + monthYear +
				 * "','MM/yyyy') group by epc.month_year";
				 */

				String yearSubStr = arrearDate.substring(0, 4);
				String monthSubStr = arrearDate.substring(5, 7);
				String daata = monthSubStr + yearSubStr;

				String execute = "with t as (select epc.employee_id, epc.month_year , ABS( '" + currentGrossAmount + "' - sum(amount)) as earningArrear from employee_pay_component_paid epc inner join pay_component pac on pac.pay_component_id= epc.pay_component_id where pay_component_type='1' and pac.status='t' and  employee_id = '" + objPayrollGenerationBean.getEmployeeId() + "' and to_date(month_year,'mm/yyyy') between to_date('" + daata + "','MM/yyyy') and to_date('" + monthYear
						+ "','MM/yyyy') group by epc.month_year,epc.employee_id) select sum(earningArrear) from t";

				String earningsAmountStr = jdbcTemplate.queryForObject(execute, String.class);

				// earningsAmount = jdbcTemplate.query(execute, new
				// BeanPropertyRowMapper<>(PayrollGenerationBean.class));

				double d = Double.parseDouble(earningsAmountStr);

				System.out.println(d);
				/*
				 * String yearSubStr = arrearDate.substring(0, 4); String monthSubStr =
				 * arrearDate.substring(5, 7); String daata = monthSubStr + yearSubStr;
				 */
				jdbcTemplate.update(PayrollGenerationQueryUtil.INSERT_ARREAR, objPayrollGenerationBean.getEmployeeId(), daata, monthYear, d);

				jdbcTemplate.update(PayrollGenerationQueryUtil.INSERT_ARREAR_PAY_COMPONENT, objPayrollGenerationBean.getEmployeeId(), monthYear, d, dept);

			}

		}

	}

	/*
	 * @Override public PayrollGenerationBean generatePayroll(String companyId,
	 * String branchId, Integer departmentId, String employeeId, String monthYear)
	 * throws CustomException { PayrollGenerationBean payrollBean = null; try {
	 * 
	 * payrollBean =
	 * jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.CREATE_SALARY, new
	 * BeanPropertyRowMapper<>(PayrollGenerationBean.class), monthYear,companyId,
	 * branchId, departmentId, employeeId);
	 * 
	 * } catch (DataAccessException e) { LOGGER.error("Error in generatePayroll",
	 * e); throw new CustomException(ErrorMessage.ERROR_EDIT); } return payrollBean;
	 * }
	 */
	@Override
	public List<PayrollGenerationBean> checkSalaryFixed(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException {
		List<PayrollGenerationBean> salNotFixedList = new ArrayList<>();
		PayrollGenerationBean objPayrollGenerationBean = new PayrollGenerationBean();
		objPayrollGenerationBean.setSuccess(true);
		try {

			salNotFixedList = jdbcTemplate.query(PayrollGenerationQueryUtil.CHECK_SALARY_FIXED, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), companyId, branchId, dept, employeeId, monthYear);

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}

		return salNotFixedList;

	}

	@Override
	public List<PayrollGenerationBean> getDepartmentList(String branchId) throws CustomException {
		List<PayrollGenerationBean> departmentList = new ArrayList<>();
		try {

			departmentList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_DEPARTMENT_LIST, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), branchId);

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return departmentList;

	}

	@Override
	public List<PayrollGenerationBean> getEmployeeList(String branchId) throws CustomException {
		List<PayrollGenerationBean> employeeList = new ArrayList<>();

		try {

			employeeList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_EMPLOYEE, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), branchId);

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return employeeList;
	}

	@Override
	public List<PayrollGenerationBean> getTypeList() throws CustomException {
		List<PayrollGenerationBean> departmentList = new ArrayList<>();
		try {

			departmentList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_Type_LIST, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return departmentList;

	}

	@Override
	public PayrollGenerationResultBean getDepartmentList1() throws CustomException {
		PayrollGenerationResultBean employeeMasterResultBean = new PayrollGenerationResultBean();
		List<PayrollGenerationBean> departmentList = new ArrayList<>();
		try {

			departmentList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_DEPARTMENT_LIST1, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));
			employeeMasterResultBean.setDepartmentList(departmentList);

			return employeeMasterResultBean;
		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public List<PayrollGenerationBean> getEmployeeList(String dept, String branchId) throws CustomException {
		List<PayrollGenerationBean> employeeList = new ArrayList<>();
		try {

			employeeList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_EMPLOYEE_LIST, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), dept, Integer.parseInt(branchId));

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return employeeList;

	}

	@Override
	public List<PayrollGenerationBean> getEmployees() throws CustomException {
		List<PayrollGenerationBean> employeeList = new ArrayList<>();
		try {

			employeeList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_EMPLOYEES, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return employeeList;
	}

	@Override
	public List<PayrollGenerationBean> getMonthYearList() throws CustomException {
		List<PayrollGenerationBean> monthyearList = new ArrayList<>();
		try {

			monthyearList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_MONTHLIST, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));

			for (PayrollGenerationBean d : monthyearList) {
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in SELECT_MONTHLIST", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return monthyearList;

	}

	@Override
	public List<PayrollGenerationBean> getPaySlipYearList() throws CustomException {
		List<PayrollGenerationBean> monthyearList = new ArrayList<>();
		try {

			monthyearList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_PAYSLIPYEARLIST, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));

			for (PayrollGenerationBean d : monthyearList) {
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in SELECT_PAYSLIPYEARLIST", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return monthyearList;

	}

	@Override
	public List<PayrollGenerationBean> getCompanyList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<PayrollGenerationBean> monthyearList = new ArrayList<>();
		try {

			monthyearList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_COMPANY_LIST, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), userDetails.getCompanyCode());

			System.out.println("code"+userDetails.getCompanyCode());
			for (PayrollGenerationBean d : monthyearList) {
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in SELECT_PAYSLIPYEARLIST", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return monthyearList;

	}

	@Override
	public List<PayrollGenerationBean> getBranchList(String companyId) throws CustomException {
		List<PayrollGenerationBean> employeeList = new ArrayList<>();
		try {

			employeeList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_BRANCH_LIST, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), companyId);

			for (PayrollGenerationBean d : employeeList) {
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in checkSalaryFixed", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return employeeList;

	}

	@Override
	public List<PayrollGenerationBean> checkSalaryCreated(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException {
		List<PayrollGenerationBean> checkSalCreatedList = new ArrayList<>();
		//String deparmentid = dept;
		try {

			
			checkSalCreatedList = jdbcTemplate.query(PayrollGenerationQueryUtil.CHECK_SALARY_CREATED, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), companyId, branchId, dept, employeeId, monthYear);

		} catch (DataAccessException e) {
//			LOGGER.error("Error in checkSalaryCreated", e);
//			throw new CustomException(ErrorMessage.ERROR_LIST);
			e.printStackTrace();
		}

		return checkSalCreatedList;
	}

	@Override
	public List<PayrollGenerationBean> getEmployeeSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException {
		List<PayrollGenerationBean> salaryList = new ArrayList<>();
		try {
			salaryList = jdbcTemplate.query(PayrollGenerationQueryUtil.SAL_LIST, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), companyId, branchId, dept, employeeId, monthYear);
			return salaryList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getEmployeeSalaryList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public boolean deleteSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(PayrollGenerationQueryUtil.DELETE_SAL_LIST, companyId, branchId, dept, employeeId, monthYear, monthYear);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteSalaryList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public PayrollGenerationResultBean getcheckFlag(String employeeId) {
		PayrollGenerationResultBean resultBean = new PayrollGenerationResultBean();
		try {
			if (employeeId != "") {
				String sqlQuery = "select count(*) from employee_master where emp_id= '" + employeeId + "' and payroll_flag='t'";
				int count = jdbcTemplate.queryForObject(sqlQuery,Integer.class);
				// resultBean.setObjPaySlipBean(count);

				if (count > 0) {
					// String Data = "No Salary";
					resultBean.setFlagListStopped(true);
					// resultBean.setNoSalary(Data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return resultBean;
	}

	@Override
	public List<Map<String, Object>> getPayrollList(String companyId, String branchId, Integer departmentId, String employeeId, String monthYear) throws CustomException {
		List<PayrollGenerationBean> payRollReportList = new ArrayList<>();
		try {
			// Define Arraylist
			List<Map<String, Object>> payRollList = new ArrayList<>();
			// Define Map
			Map<String, Object> payRollMap = new HashMap<>();
			String tmpemployeeId = null;
			payRollReportList = jdbcTemplate.query(PayrollGenerationQueryUtil.SELECT_PAYROLL_LIST_BY_EMPID, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), companyId, branchId, departmentId, monthYear, employeeId);

			int i = 1;
			for (PayrollGenerationBean payRollReport : payRollReportList) {

				if (tmpemployeeId == null) {
					tmpemployeeId = payRollReport.getEmployeeId();
					payRollMap = new HashMap<>();
				}
				if ((tmpemployeeId).equals(payRollReport.getEmployeeId())) {

					if (payRollMap.containsKey("employeeId")) {

					} else {
						payRollMap.put("employeeId", payRollReport.getEmployeeId());
					}
					if (payRollMap.containsKey("employeeName")) {

					} else {
						payRollMap.put("employeeName", payRollReport.getEmployeeName());
					}
					if (payRollMap.containsKey("monthYear")) {

					} else {
						payRollMap.put("monthYear", payRollReport.getMonthYear());
					}

					if (("BASIC").equals(payRollReport.getPayComponentId()) || ("DA").equals(payRollReport.getPayComponentId()) || ("HRA").equals(payRollReport.getPayComponentId()) || ("MEDIC").equals(payRollReport.getPayComponentId()) || ("CONVE").equals(payRollReport.getPayComponentId()) || ("SPL").equals(payRollReport.getPayComponentId()) || ("CONS").equals(payRollReport.getPayComponentId()) ||

							("PFCOM").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId()) || ("Tele").equals(payRollReport.getPayComponentId())
							|| ("US").equals(payRollReport.getPayComponentId()) || ("AD").equals(payRollReport.getPayComponentId()) || ("TR1").equals(payRollReport.getPayComponentId()) || ("OTD").equals(payRollReport.getPayComponentId())) {

						payRollMap.put(payRollReport.getPayComponentId(), payRollReport.getAmount());
					}

					if (payRollReportList.size() == i) {
						payRollList.add(payRollMap);
					}
					tmpemployeeId = payRollReport.getEmployeeId();
				} else {

					payRollList.add(payRollMap);
					payRollMap = new HashMap<>();

					if (("BASIC").equals(payRollReport.getPayComponentId()) || ("DA").equals(payRollReport.getPayComponentId()) || ("HRA").equals(payRollReport.getPayComponentId()) || ("MEDIC").equals(payRollReport.getPayComponentId()) || ("CONVE").equals(payRollReport.getPayComponentId()) || ("SPL").equals(payRollReport.getPayComponentId()) || ("CONS").equals(payRollReport.getPayComponentId()) ||

							("PFCOM").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId()) || ("Tele").equals(payRollReport.getPayComponentId())
							|| ("US").equals(payRollReport.getPayComponentId()) || ("AD").equals(payRollReport.getPayComponentId()) || ("TR1").equals(payRollReport.getPayComponentId()) || ("OTD").equals(payRollReport.getPayComponentId())) {

						payRollMap.put(payRollReport.getPayComponentId(), payRollReport.getAmount());
					}

					tmpemployeeId = payRollReport.getEmployeeId();

				}
				i++;
			}
			return payRollList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPayrollList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<PayrollGenerationBean> checkPayrollFlag() {
		List<PayrollGenerationBean> payRollReportList = new ArrayList<>();
		try {

			payRollReportList = jdbcTemplate.query(PayrollGenerationQueryUtil.CHECK_PAYROLL_FLAG, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));

			// String empList = "select employee_id from employee where
			// payroll_flag='t'";
			// payRollReportList = jdbcTemplate.queryForList(empList);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return payRollReportList;
	}

	@Override
	public PayrollGenerationResultBean checkFlag(Integer departmentId, String employeeId) {

		PayrollGenerationResultBean resultBean = new PayrollGenerationResultBean();

		try {
			String sql = "select count(*) from employee_master where department_id = '" + departmentId + "'  and employee_id = '" + employeeId + "' and payroll_flag='t'";
			int abcd = jdbcTemplate.queryForObject(sql,Integer.class);

			// resultBean.setObjPayrollGenerationBean(abcd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return resultBean;
	}

	@Override
	public PayrollGenerationResultBean getFlagList(int departmentId, String monthYear, String employeeId) {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		List<PayrollGenerationResultBean> objList = new ArrayList<>();
		try {

			String whereCode = "";
			// all

			if (departmentId != 0 && monthYear != "" && employeeId != "") {
				whereCode = "  department_id = " + departmentId + " and employee_id='" + employeeId + "' and ";
			}
			if (departmentId != 0 && monthYear == "" && employeeId == "") {
				objPayrollGenerationResultBean.setSuccess(false);
			}
			// dept and month
			if (departmentId != 0 && monthYear != "" && employeeId == "") {
				whereCode = "  department_id = " + departmentId + " and ";
			}
			// month
			if (departmentId == 0 && monthYear != "" && employeeId == "") {
				// whereCode = " where department_id = " + departmentId + " ";
				whereCode = " ";
			}

			String sqlQuery = "select emp_id, first_name from employee_master where " + whereCode + " payroll_flag='t' and status='Y'";

			// List<Map<String, Object>> finalData =
			// jdbcTemplate.queryForList(sqlQuery);

			List<PayrollGenerationBean> lscManageAdmissionBean = new ArrayList<>();

			lscManageAdmissionBean = jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));
			objPayrollGenerationResultBean.setLscManageAdmissionBean(lscManageAdmissionBean);
			objPayrollGenerationResultBean.setSuccess(true);

			// objPayrollGenerationResultBean.setFlagList(finalData);
			// objPayrollGenerationResultBean.setFlagList(sqlQuery);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objPayrollGenerationResultBean;
	}

	@Override
	public PayrollGenerationResultBean withHoldList(String employeeId, String monthYear) {
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		// TODO Auto-generated method stub
		if (employeeId != "" && monthYear != "") {

			int checkCount = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.CHECK_WITH_HOLD_EMPLOYEE,new Object[] { employeeId, monthYear},Integer.class);

			if (checkCount > 0) {

				// String message = "With Hold Salary";
				objPayrollGenerationResultBean.setMessage("With Hold Salary");
				// objPayrollGenerationResultBean.setWithHoldList(true);

				// objPayrollGenerationResultBean.setWithHoldList(false);
			}

		}
		if (employeeId != "") {
			String sqlQuery = "select count(*) from employee_master where emp_id= '" + employeeId + "' and payroll_flag='t'";
			int count = jdbcTemplate.queryForObject(sqlQuery,Integer.class);
			// resultBean.setObjPaySlipBean(count);

			if (count > 0) {
				// String Data = "No Salary";
				objPayrollGenerationResultBean.setFlagListStopped(true);
				// resultBean.setNoSalary(Data);
			}

		}

		return objPayrollGenerationResultBean;
	}

	@Override
	public PayrollGenerationResultBean getAlreadyGenerated(String employeeId, String startDate) {
		// TODO Auto-generated method stub
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		try {
			if (employeeId != "" && startDate != "") {
				String sql = "select count(*) from employee_pay_component_paid where employee_id = '" + employeeId + "'  and  month_year= '" + startDate + "'";
				int count = jdbcTemplate.queryForObject(sql,Integer.class);
				if (count == 0) {
					objPayrollGenerationResultBean.setCheckALreadyCreated(true);

				} else {
					objPayrollGenerationResultBean.setCheckALreadyCreated(false);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return objPayrollGenerationResultBean;
	}

	@Override
	public PayrollGenerationResultBean taxDeduction(String companyId, String branchId, String dept, String employeeId, String monthYear) {
		// TODO Auto-generated method stub
		PayrollGenerationResultBean objPayrollGenerationResultBean = new PayrollGenerationResultBean();
		List<PayrollGenerationBean> taxDeductionBean = new ArrayList<>();
		List<PayrollGenerationBean> taxDeductionBean2 = new ArrayList<>();
		List<PayrollGenerationBean> rangeFind = new ArrayList<>();

		String whereCode = "";
		// all

		if (dept != "" && monthYear != "" && employeeId != "") {
			whereCode = "  department_id = '" + dept + "' and e.emp_id='" + employeeId + "' and ";
		}

		// dept and month
		if (dept != "" && monthYear != "" && employeeId == null) {
			whereCode = "  department_id = '" + dept + "' and ";
		}
		// month
		if (dept == "" && monthYear != "" && employeeId == null) {
			// whereCode = " where department_id = " + departmentId + " ";
			whereCode = " ";
		}

		String sqlQuery = "select e.emp_id, e.first_name from employee_master e  left join payroll_withHold ph on ph.emp_id=e.emp_id where " + whereCode + " e.payroll_flag='f' and e.status='Y' and e.emp_id not in ( select e.emp_id from employee_master e left join payroll_withHold ph on ph.emp_id=e.emp_id  where  to_date('" + monthYear + "','MMyyyy')  between to_date(concat(ph.from_month,pH.from_year)::text,'MMyyyy') and to_date(concat(ph.till_month,pH.till_year)::text,'MMyyyy'))";

		taxDeductionBean = jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));

		for (PayrollGenerationBean iterate : taxDeductionBean) {
			iterate.getEmployeeId();

			// epc.employee_id as employeeId
			// int returnAmount = jdbcTemplate.queryForObject(grossPay,
			// Integer.class);
			int value = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.grossPay, new Object[] { iterate.getEmployeeId(), monthYear, iterate.getEmployeeId() }, Integer.class);

			/*
			 * String monthYearTest = monthYear; String monthSubStr =
			 * monthYearTest.substring(0, 2); String yearSubStr = monthYearTest.substring(2,
			 * 6); int intYear = Integer.parseInt(yearSubStr); if (monthSubStr == "03") {
			 * int a[] = { 02, 01, 12, 11, 10 };
			 * 
			 * for (int i = 0; i < 5; i++) {
			 * 
			 * int x = (int) Array.get(a, i); if (x == 01) {
			 * 
			 * int Beforeyear = intYear - 1;
			 * 
			 * } }
			 * 
			 * }
			 */
			/*
			 * if (demo == "03") {
			 * 
			 * int[] monthsData = { 02, 01, 12, 11, 10 };
			 * 
			 * findIndex(monthsData, 02); findIndex(monthsData, 01); findIndex(monthsData,
			 * 12); findIndex(monthsData, 11); findIndex(monthsData, 10);
			 * 
			 * 
			 * int counter = months.length; while (counter > 0) { counter--;
			 * System.out.println(months[counter]); }
			 * 
			 * }
			 */
			// taxDeductionBean2 = jdbcTemplate.query(grossPay, new
			// BeanPropertyRowMapper<>(PayrollGenerationBean.class));
			// get tax range date
			// objPayrollGenerationResultBean.setTaxDeduction(taxDeductionBean2);

			String rangeFinderHeader = "select slab_hdr_id as hdrId ,concat(extract(month from to_date ) , extract(year from to_date )) as rangeDate from professional_slab_rate_tax_hdr";
			rangeFind = jdbcTemplate.query(rangeFinderHeader, new BeanPropertyRowMapper<>(PayrollGenerationBean.class));

			for (PayrollGenerationBean iterate2 : rangeFind) {
				String extractDate = 0 + iterate2.getRangeDate();

				if (extractDate.equalsIgnoreCase(monthYear) == true)

				{
					String hdrId = iterate2.getHdrId();
					int result = Integer.parseInt(hdrId);
					System.out.println("*******************PROFESSIONAL TAX**********************");
					String query = "select professional_tax as professionaltax from professional_slab_rate_tax_dtl where slab_hdr_id='" + result + "'  and  '" + value + "'  between range_from and range_to";
					int remark = jdbcTemplate.queryForObject(query, (Integer.class));

					System.out.println(remark);
					jdbcTemplate.update(PayrollGenerationQueryUtil.INSERT_TAX, iterate.getEmployeeId(), remark, extractDate);

					// int Finalvalue =
					// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.finalQuery,
					// new Object[] { iterate2.getHdrId(), value },
					// Integer.class);

				}

			}
		}

		return objPayrollGenerationResultBean;
	}

	public void autoJvEntryGeneration(PayrollReportBean bean, double dGrnAmount) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			String journalNumber = generateJournalVoucherNumber();

			// int count =
			// jdbcTemplate.queryForInt(PayrollGenerationQueryUtil.CHECK_EXIST_EMPLOYEE,
			// bean.getEmployeeId());

			// String checkalreadyExist =
			// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.CHECK_EXIST_EMPLOYEE,
			// String.class, bean.getEmployeeId());
			// if (count == 0) {

			// java.util.Date date = new java.util.Date();
			Date date = new Date();
			//int jvHdr = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_HEADER, new Object[] { journalNumber, date, "AUTO JV FOR PAYROLL  - " + 1, userDetails.getUserId(), userDetails.getCompanyCode() });

			// debit entry
		//	int jvDebit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL, new Object[] { journalNumber, AccountsConstants.STOCK_VALUE_AH, "INR", 1.0, 0.0, dGrnAmount, "AUTO JV FOR PAYROLL - " + 1, AccountsConstants.STOCK_VALUE_SG, 0.0, dGrnAmount, 1, bean.getEmployeeId(), null, null, null, null, null, userDetails.getCompanyCode(), null, null, null });

			// credit entry
			//int jvCredit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL, new Object[] { journalNumber, AccountsConstants.PURCHASE_ACCRUAL_AH, "INR", 1.0, dGrnAmount, 0.0, "AUTO JV FOR PAYROLL - " + 1, AccountsConstants.PURCHASE_ACCRUAL_SG, dGrnAmount, 0.0, 1, bean.getEmployeeId(), null, null, null, null, null, userDetails.getCompanyCode(), null, null, null });

			//if (jvHdr > 0 && jvDebit > 0 && jvCredit > 0)
				//jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_GENERAL_LEDGER_FOR_JV, new Object[] { journalNumber });
			// }
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}

	public String generateJournalVoucherNumber() throws CustomException {
		String journalNumber = null;
		String appendWithYear = "", appendWithJVNo = "";

		try {
			String sCurrentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			sCurrentYear = sCurrentYear.substring(2);

			appendWithJVNo = "JV" + sCurrentYear + "00001";
			appendWithYear = "JV" + sCurrentYear + "%";

			/*List<Map<String, Object>> rowJVNo = jdbcTemplate.queryForList(JournalVoucherQueryUtil.GET_JOURNAL_NO_AUTOGENERATE, new Object[] { appendWithJVNo, appendWithYear });
			for (Map row : rowJVNo) {
				journalNumber = (String) row.get("JOURNAL_NO");
			}
*/
		} catch (DataAccessException e) {
		}

		return journalNumber;
	}

	@Override
	public boolean payrolltojv(PaySlipBean PaySlipBean) throws Exception {
		// public PayrollGenerationResultBean payrolltojv(PaySlipBean PaySlipBean) {
		PayrollGenerationResultBean PayrollGenerationResultBean = new PayrollGenerationResultBean();
		List<PayrollReportBean> payRollReportList = new ArrayList<>();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean sucess = false;
		double amount = 0;
		// try {

		// payRollReportList =
		// jdbcTemplate.query(PayrollGenerationQueryUtil.PAYROLL_LIST_FOR_JV, new
		// BeanPropertyRowMapper<>(PayrollReportBean.class), PaySlipBean.getMonthYear(),
		// PaySlipBean.getCompanyId(), PaySlipBean.getBranchId(),
		// PaySlipBean.getDepartmentId(), PaySlipBean.getEmployeeId(),
		// PaySlipBean.getMonthYear());

		List<EmployeeEarlyStartBean> empdetailList = new ArrayList<>();
		PaySlipResultBean ojjs = new PaySlipResultBean();
		List<PaySlipBean> paySlipList = null;
		List<PaySlipBean> paySlipListStreamchk = null;

		double employeeLeaveAvailable = 0.00;
		double employeeLeaveTaken = 0.00;

		NumberFormat formatter = new DecimalFormat("#0.00");

		PaySlipListDTO payLsPaySlipListDTO = new PaySlipListDTO();

		PaySlipDTO paySlipdto = new PaySlipDTO();

		String tempEmpid = null;

		int countnum = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.check_number, Integer.class, PaySlipBean.getMonthYear());

		if (countnum == 0) {
			if (PaySlipBean.getMonthYear() != null && PaySlipBean.getDept() != null) {
				paySlipList = paySlipDAO.getPaySlipList1(PaySlipBean.getMonthYear(), PaySlipBean.getDepartmentId());

				if (paySlipList.size() > 0) {

					paySlipListStreamchk = paySlipDAO.getPaySlipListChkDept(PaySlipBean.getMonthYear(), PaySlipBean.getDept());

					for (PaySlipBean bean : paySlipListStreamchk) {
						String journalNumber = generateJournalVoucherNumber();

						String month = PaySlipBean.getMonthYear();
						month = month.substring(0, 2);

						String year = PaySlipBean.getMonthYear();
						year = year.substring(2, 6);

						Integer department = PaySlipBean.getDepartmentId();

						int jvHdr = jdbcTemplate.update(PayrollGenerationQueryUtil.INSERT_JOURNAL_VOUCHER_HEADER, new Object[] { journalNumber, "BEING SALARY FOR THE MONTH OF " + " -" + month + "/ " + year + "", PaySlipBean.getMonthYear(), PaySlipBean.getDept(), userDetails.getUserId(), bean.getCompany() });

						for (PaySlipBean objJournalVoucherBean : paySlipList) {

							if (("BASIC").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.BASIC, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);

								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("20000029");

									}

									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("20000029");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("HRA").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.HRA, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("20000026");

									}

									String debitacct = objJournalVoucherBean.getAccountdebitCode();
									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("20000019");

									}

									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("PFSEL").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.PFSEL, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40040011");

									}

									String debitacct = objJournalVoucherBean.getAccountdebitCode();
									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40040008");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("MEDIC").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.MEDIC, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("30020001");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();
									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40040009");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("TOTDE").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.TOTDE, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("30010025");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();
									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050014");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("ADMC").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.ADMC, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("30010025");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();
									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050014");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("EDLI").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.EDLI, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050002");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050006");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("EPF").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.EPF, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050003");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();
									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050009");

									}

									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("ESI").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.ESI, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050003");

									}
									// objJournalVoucherBean.setAccountdebitCode("40050003");
									// objJournalVoucherBean.setAccountdebitCode("10030011");
									String debitacct = objJournalVoucherBean.getAccountdebitCode();
									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("GROSS").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GROSS, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("10000026");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}

									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("CONS").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.CONS, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("10000026");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("WF").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.WF, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050010");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("DA").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.DA, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("10000054");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("PTS").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.PTS, Double.class, PaySlipBean.getMonthYear(), PaySlipBean.getDept(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050017");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050007");

									}

									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else {

								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("10030001");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050014");

									}

									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							}
							if (objJournalVoucherBean.getAmount() != 0 && objJournalVoucherBean.getAccountCode() != null && objJournalVoucherBean.getAccountdebitCode() != null) {

								/*int jvDebit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL,
										new Object[] { journalNumber, objJournalVoucherBean.getAccountCode(), "INR", 1.0, 0.0, objJournalVoucherBean.getAmount(), "BEING SALARY FOR THE MONTH OF  -" + objJournalVoucherBean.getMonthYear() + " -  PAY COMP -" + objJournalVoucherBean.getPayComponentId() + "", AccountsConstants.STOCK_VALUE_SG, 0.0, objJournalVoucherBean.getAmount(), 1, PaySlipBean.getEmployeeId(), null, null, null, null, null, bean.getCompany(), null, null, null });

								int jvDebitLedger = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_GL_DEBIT_DTL, new Object[] { journalNumber, objJournalVoucherBean.getAccountCode(), "INR", 1.0, objJournalVoucherBean.getAmount(), objJournalVoucherBean.getAmount(), "BEING SALARY FOR THE MONTH OF  -" + objJournalVoucherBean.getMonthYear() + " -  PAY COMP -" + objJournalVoucherBean.getPayComponentId() + "", 1, PaySlipBean.getEmployeeId(), bean.getCompany() });
*/
								// Credit Entry

							//	int jvCredit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL,
										//new Object[] { journalNumber, objJournalVoucherBean.getAccountdebitCode(), "INR", 1.0, objJournalVoucherBean.getAmount(), 0.0, "BEING SALARY FOR THE MONTH OF  -" + objJournalVoucherBean.getMonthYear() + " - PAY COMP -" + objJournalVoucherBean.getPayComponentId() + "", AccountsConstants.PURCHASE_ACCRUAL_SG, objJournalVoucherBean.getAmount(), 0.0, 1, PaySlipBean.getEmployeeId(), null, null, null, null, null, bean.getCompany(), null, null, null });

							//	int jvCreditLedger = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_GL_CREDIT_DTL, new Object[] { journalNumber, objJournalVoucherBean.getAccountCode(), "INR", 1.0, objJournalVoucherBean.getAmount(), objJournalVoucherBean.getAmount(), "BEING SALARY FOR THE MONTH OF  -" + objJournalVoucherBean.getMonthYear() + " -  PAY COMP -" + objJournalVoucherBean.getPayComponentId() + "", 1, PaySlipBean.getEmployeeId(), bean.getCompany() });

								// int isSuccess = createGeneralLedgerForJournalVoucher(objJournalVoucherBean);

							/*	if (jvDebit > 0 && jvCredit > 0)

								{

									sucess = true;
								}*/
							}
						}
					}

				} else {
					throw new Exception("Records Not Found");

				}
			}
			if (PaySlipBean.getMonthYear() != null && PaySlipBean.getDept()!= null) {
				paySlipList = paySlipDAO.getPaySlipListmont(PaySlipBean.getMonthYear());

				if (paySlipList.size() > 0) {

					paySlipListStreamchk = paySlipDAO.getPaySlipListChk(PaySlipBean.getMonthYear(), PaySlipBean.getDepartmentId());

					for (PaySlipBean bean : paySlipListStreamchk) {
						String journalNumber = generateJournalVoucherNumber();

						String month = PaySlipBean.getMonthYear();
						month = month.substring(0, 2);

						String year = PaySlipBean.getMonthYear();
						year = year.substring(2, 6);

						Integer department = PaySlipBean.getDepartmentId();

						int jvHdr = jdbcTemplate.update(PayrollGenerationQueryUtil.INSERT_JOURNAL_VOUCHER_HEADER, new Object[] { journalNumber, "BEING SALARY FOR THE MONTH OF  -" + month + "/ " + year + "", PaySlipBean.getMonthYear(), PaySlipBean.getDept(), userDetails.getUserId(), userDetails.getCompanyCode() });

						for (PaySlipBean objJournalVoucherBean : paySlipList) {

							if (("BASIC").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.BASICMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);

								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("10000052");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("20000029");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("HRA").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.HRAMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("10000053");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("20000029");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("PFSEL").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.PFSELMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40040011");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40040008");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("MEDIC").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.MEDICMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("30020001");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40040009");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("TOTDE").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.TOTDEMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("30010025");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050014");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("ADMC").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.ADMCMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("30010025");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050014");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("EDLI").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.EDLIMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050002");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050006");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("EPF").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.EPFMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050003");

									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050009");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("ESI").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.ESIMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050003");
									}
									// objJournalVoucherBean.setAccountdebitCode("40050003");
									// objJournalVoucherBean.setAccountdebitCode("10030011");
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("GROSS").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GROSSMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("10000026");
									}

									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("CONS").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.CONSMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("10000026");
									}

									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("WF").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.WFMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050010");
									}

									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("DA").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.DAMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050016");
									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("10030020");

									}
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else if (("PTS").equals(objJournalVoucherBean.getPayComponentId())) {
								Double ADMC = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.PTSMON, Double.class, PaySlipBean.getMonthYear(), bean.getCompany());
								objJournalVoucherBean.setAmount(ADMC);
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("40050017");
									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									// String AccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (AccoutHeadCode != null && AccoutHeadCode != "") {
										objJournalVoucherBean.setAccountCode(AccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountCode("40050007");

									}

									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							} else {
								String debitAccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								String AccoutHeadCode = jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_ACCOUNT_HEAD_FROM_ED, String.class, objJournalVoucherBean.getPayComponentId());
								if (objJournalVoucherBean.getAmount() != 0 && debitAccoutHeadCode != null && debitAccoutHeadCode != null) {

									// String debitAccoutHeadCode =
									// jdbcTemplate.queryForObject(PayrollGenerationQueryUtil.GET_DEBIT_ACCOUNT_HEAD_FROM_ED,
									// String.class, objJournalVoucherBean.getPayComponentId());
									if (debitAccoutHeadCode != null && debitAccoutHeadCode != "") {
										objJournalVoucherBean.setAccountdebitCode(debitAccoutHeadCode);

									} else {
										objJournalVoucherBean.setAccountdebitCode("10030001");
									}
									String debitacct = objJournalVoucherBean.getAccountdebitCode();

									objJournalVoucherBean.setAccountCode("40050014");
									String creditacct = objJournalVoucherBean.getAccountCode();
								}
							}
							if (objJournalVoucherBean.getAmount() != 0 && objJournalVoucherBean.getAccountCode() != null && objJournalVoucherBean.getAccountdebitCode() != null) {

								//int jvDebit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL, new Object[] { journalNumber, objJournalVoucherBean.getAccountCode(), "INR", 1.0, 0.0, objJournalVoucherBean.getAmount(), "BEING SALARY FOR THE MONTH OF  -" + objJournalVoucherBean.getMonthYear() + " -  PAY COMP -" + objJournalVoucherBean.getPayComponentId() + "", AccountsConstants.STOCK_VALUE_SG, 0.0, objJournalVoucherBean.getAmount(), 1, PaySlipBean.getEmployeeId(), null, null, null, null, null, "C0001", null, null, null });

								// Credit Entry

								/*int jvCredit = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_JOURNAL_VOUCHER_DTL,
										new Object[] { journalNumber, objJournalVoucherBean.getAccountdebitCode(), "INR", 1.0, objJournalVoucherBean.getAmount(), 0.0, "BEING SALARY FOR THE MONTH OF  -" + objJournalVoucherBean.getMonthYear() + " - PAY COMP -" + objJournalVoucherBean.getPayComponentId() + "", AccountsConstants.PURCHASE_ACCRUAL_SG, objJournalVoucherBean.getAmount(), 0.0, 1, PaySlipBean.getEmployeeId(), null, null, null, null, null, "C0001", null, null, null });
*/
								// int isSuccess = createGeneralLedgerForJournalVoucher(objJournalVoucherBean);

								/*if (jvDebit > 0 && jvCredit > 0)

								{
									sucess = true;
								}*/
							}
						}
					}

				} else {
					throw new Exception("No records  for this data");
				}
			}

		} else

		{
			throw new Exception("Already generated for this Month and Year");

		}

		// }

		/*
		 * catch (
		 * 
		 * Exception e) { e.printStackTrace();
		 * 
		 * }
		 */
		return sucess;

	}
/*
	private boolean createGeneralLedgerForJournalVoucher(JournalVoucherDTO objJournalVoucherBean) {
		boolean flag = false;
		try {

		//int iTemp = jdbcTemplate.update(JournalVoucherQueryUtil.INSERT_GENERAL_LEDGER_FOR_JV, new Object[] { objJournalVoucherBean.getJvNumber(), objJournalVoucherBean.getJvNumber() });
		//	if (iTemp > 0)
				flag = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Journal Voucher Detail Records!", e);
		}
		return flag;
	}*/

	@Override
	public List<Map<String, Object>> getPayrollList(String companyId, String branchId, Integer departmentId, String monthYear) throws Exception {
		List<PayrollReportBean> payRollReportList = new ArrayList<>();

		try {
			// Define Arraylist
			List<Map<String, Object>> payRollList = new ArrayList<>();
			// Define Map
			Map<String, Object> payRollMap = new HashMap<>();
			String tmpemployeeId = null;
			payRollReportList = jdbcTemplate.query(PayrollReportQueryUtil.PAYROLL_LIST, new BeanPropertyRowMapper<>(PayrollReportBean.class), monthYear, companyId, branchId, departmentId, monthYear);

			int i = 1;
			for (PayrollReportBean payRollReport : payRollReportList) {

				if (tmpemployeeId == null) {
					tmpemployeeId = payRollReport.getEmployeeId();
					payRollMap = new HashMap<>();
				}
				if ((tmpemployeeId).equals(payRollReport.getEmployeeId())) {

					if (payRollMap.containsKey("employeeId")) {

					} else {
						payRollMap.put("employeeId", payRollReport.getEmployeeId());
					}
					if (payRollMap.containsKey("employeeName")) {

					} else {
						payRollMap.put("employeeName", payRollReport.getEmployeeName());
					}
					if (payRollMap.containsKey("epfno")) {

					} else {
						payRollMap.put("epfno", payRollReport.getEpfno());
					}

					if (payRollMap.containsKey("uanno")) {

					} else {
						payRollMap.put("uanno", payRollReport.getUanno());
					}
					if (payRollMap.containsKey("lopDays")) {

					} else {
						payRollMap.put("lopDays", payRollReport.getLopDays());
					}
					if (payRollMap.containsKey("lopAmount")) {

					} else {
						payRollMap.put("lopAmount", payRollReport.getLopAmount());
					}
					if (payRollMap.containsKey("monthYear")) {

					} else {
						payRollMap.put("monthYear", payRollReport.getMonthYear());
					}

					if (("BASIC").equals(payRollReport.getPayComponentId()) || ("DA").equals(payRollReport.getPayComponentId()) || ("HRA").equals(payRollReport.getPayComponentId()) || ("MEDIC").equals(payRollReport.getPayComponentId()) || ("CONVE").equals(payRollReport.getPayComponentId()) || ("SPL").equals(payRollReport.getPayComponentId()) || ("CONS").equals(payRollReport.getPayComponentId()) ||

							("WF").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId()) || ("Tele").equals(payRollReport.getPayComponentId())
							|| ("US").equals(payRollReport.getPayComponentId()) || ("AD").equals(payRollReport.getPayComponentId()) || ("TR1").equals(payRollReport.getPayComponentId()) || ("OTD").equals(payRollReport.getPayComponentId()) || ("TOTDE").equals(payRollReport.getPayComponentId())) {

						payRollMap.put(payRollReport.getPayComponentId(), payRollReport.getAmount());
					}

					if (payRollReportList.size() == i) {
						payRollList.add(payRollMap);

					}
					tmpemployeeId = payRollReport.getEmployeeId();
				} else {
					payRollList.add(payRollMap);
					payRollMap = new HashMap<>();

					if (payRollMap.containsKey("employeeId")) {

					} else {
						payRollMap.put("employeeId", payRollReport.getEmployeeId());
					}
					if (payRollMap.containsKey("employeeName")) {

					} else {
						payRollMap.put("employeeName", payRollReport.getEmployeeName());
					}
					if (payRollMap.containsKey("epfno")) {

					} else {
						payRollMap.put("epfno", payRollReport.getEpfno());
					}

					if (payRollMap.containsKey("uanno")) {

					} else {
						payRollMap.put("uanno", payRollReport.getUanno());
					}
					if (payRollMap.containsKey("lopDays")) {

					} else {
						payRollMap.put("lopDays", payRollReport.getLopDays());
					}
					if (payRollMap.containsKey("lopAmount")) {

					} else {
						payRollMap.put("lopAmount", payRollReport.getLopAmount());
					}
					if (payRollMap.containsKey("monthYear")) {

					} else {
						payRollMap.put("monthYear", payRollReport.getMonthYear());
					}

					if (("BASIC").equals(payRollReport.getPayComponentId()) || ("DA").equals(payRollReport.getPayComponentId()) || ("HRA").equals(payRollReport.getPayComponentId()) || ("MEDIC").equals(payRollReport.getPayComponentId()) || ("CONVE").equals(payRollReport.getPayComponentId()) || ("SPL").equals(payRollReport.getPayComponentId()) || ("CONS").equals(payRollReport.getPayComponentId()) ||

							("WF").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId()) || ("Tele").equals(payRollReport.getPayComponentId())
							|| ("US").equals(payRollReport.getPayComponentId()) || ("AD").equals(payRollReport.getPayComponentId()) || ("TR1").equals(payRollReport.getPayComponentId()) || ("OTD").equals(payRollReport.getPayComponentId()) || ("TOTDE").equals(payRollReport.getPayComponentId())) {

						payRollMap.put(payRollReport.getPayComponentId(), payRollReport.getAmount());
					}

					tmpemployeeId = payRollReport.getEmployeeId();

				}
				i++;
			}

			return payRollList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPayrollList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<PayrollGenerationBean> pendingSalaryList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException {
		boolean isSuccess = false;
		List<PayrollGenerationBean> list = new ArrayList<>();
		try {
			list = jdbcTemplate.query(PayrollGenerationQueryUtil.pending_SAL_LIST, new BeanPropertyRowMapper<>(PayrollGenerationBean.class), companyId, branchId, dept, employeeId, monthYear, monthYear);
		} catch (DataAccessException e) {
			LOGGER.error("Error in pendingSalaryList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		// TODO Auto-generated method stub
		return list;
	}
}