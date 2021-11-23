package com.dci.payroll.payroll.payslip;

import java.util.ArrayList;
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
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.hrms.report.employeeEarlyStart.EmployeeEarlyStartBean;



@Repository
public class PaySlipDAOImpl implements PaySlipDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(PaySlipDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Override
	public PaySlipBean getemail(String employeeId) throws Exception {
		PaySlipBean PaySlipBean = new PaySlipBean();

		String mail;
		try {
			mail = jdbcTemplate.queryForObject(PaySlipQueryUtil.mail1, String.class, employeeId);
			PaySlipBean.setEmail(mail);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return PaySlipBean;
	}

	@Override
	public List<PaySlipBean> getPaySlipList(String companyId, String branchId, String dept, String employeeId, String monthYear) throws CustomException {
		List<PaySlipBean> paySlipList = new ArrayList<>();
		/*try {
			String qry = "SELECT coalesce(el.days,0) lopDays, e.employee_id,case when e.pay_component_id = 'AD' then concat(e.pay_component_id, '-', e.ad_code)" + " else e.pay_component_id end as payComponentId , e.month_year,coalesce(round(e.amount),0) amount," + " bd.department_id, bd.branch_id, e.employee_name,e.pay_component_type FROM pay_slip('" + companyId + "','" + branchId + "'," + dept + ",'" + employeeId + "','" + monthYear + "') as e left join employee_lop as el on el.employee_id=e.employee_id and e.month_year=el.month_year inner join employee ee on ee.employee_id = e.employee_id inner join branch_department bd on bd.branch_department_id = ee.branch_department_id";

			System.out.println(qry);
			
			paySlipList = jdbcTemplate.query(qry, new BeanPropertyRowMapper<>(PaySlipBean.class));

			
			
			return paySlipList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPaySlipList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
*/
		
try {
			
			if(dept != null){
				if(dept.equalsIgnoreCase("null") || dept.equalsIgnoreCase("")){
					dept = null;
				}
			}
				if(employeeId != null){
				if(employeeId.equalsIgnoreCase("null") || employeeId.equalsIgnoreCase("")){
					employeeId = null;
				}
				}

			paySlipList = jdbcTemplate.query(PaySlipQueryUtil.SELECT_PAYSLIP, new BeanPropertyRowMapper<>(PaySlipBean.class), companyId, branchId, dept, employeeId, monthYear);

		} catch (DataAccessException e) {
//			LOGGER.error("Error in getPaySlipList", e);
//			throw new CustomException(ErrorMessage.ERROR_LIST);
			e.printStackTrace();
		}
return paySlipList;

	}

	

	@Override
	public List<PaySlipBean> getPaySlipListChkDept(String monthYear, String dept) throws CustomException {
		List<PaySlipBean> paySlipList = new ArrayList<>();
		try {

			paySlipList = jdbcTemplate.query(PaySlipQueryUtil.SELECT_PAYSLIP_Check_Dept, new BeanPropertyRowMapper<>(PaySlipBean.class), monthYear, dept);

			return paySlipList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPaySlipList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public List<PaySlipBean> getPaySlipListChk(String monthYear, Integer departmentId) throws CustomException {
		List<PaySlipBean> paySlipList = new ArrayList<>();
		try {

			paySlipList = jdbcTemplate.query(PaySlipQueryUtil.SELECT_PAYSLIP_Check, new BeanPropertyRowMapper<>(PaySlipBean.class), monthYear);

			return paySlipList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPaySlipList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public List<PaySlipBean> getPaySlipList1(String monthYear, Integer departmentId) throws CustomException {
		List<PaySlipBean> paySlipList = new ArrayList<>();
		try {

			paySlipList = jdbcTemplate.query(PaySlipQueryUtil.SELECT_PAYSLIP_NEW, new BeanPropertyRowMapper<>(PaySlipBean.class), monthYear, departmentId);

			return paySlipList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPaySlipList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public List<PaySlipBean> getPaySlipListmont(String monthYear) throws CustomException {
		List<PaySlipBean> paySlipList = new ArrayList<>();
		try {

			paySlipList = jdbcTemplate.query(PaySlipQueryUtil.SELECT_PAYSLIP_NEW_MONTH, new BeanPropertyRowMapper<>(PaySlipBean.class), monthYear);

			return paySlipList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getPaySlipList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

	}

	@Override
	public List<Map<String, Object>> getPaySlipList1(String companyId, String branchId, String departmentId, String employeeId, String monthYear) throws CustomException {
		// List<Map<String, Object>> paySlipList = new ArrayList<Map<String,
		// Object>>();
		// try {
		//
		// paySlipList =
		// jdbcTemplate.queryForList(PaySlipQueryUtil.SELECT_PAYSLIP, companyId,
		// branchId, departmentId, employeeId, monthYear);
		//
		// return paySlipList;
		// } catch (DataAccessException e) {
		// LOGGER.error("Error in getPaySlipList", e);
		// throw new CustomException(ErrorMessage.ERROR_LIST);
		// }
		List<PaySlipBean> payRollReportList = new ArrayList<>();
		try {
			// Define Arraylist
			List<Map<String, Object>> payRollList = new ArrayList<>();
			// Define Map
			Map<String, Object> payRollMap = new HashMap<>();
			String tmpemployeeId = null;
			payRollReportList = jdbcTemplate.query(PaySlipQueryUtil.SELECT_PAYSLIP1, new BeanPropertyRowMapper(PaySlipBean.class), companyId, branchId, departmentId, employeeId, monthYear);

			int i = 1;
			for (PaySlipBean payRollReport : payRollReportList) {

				if (tmpemployeeId == null) {
					tmpemployeeId = payRollReport.getEmployeeId();
					payRollMap = new HashMap<>();
				}
				if ((tmpemployeeId).equals(payRollReport.getEmployeeId())) {

					if (payRollMap.containsKey("salDays")) {

					} else {
						payRollMap.put("salDays", payRollReport.getSalDays());
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

							("PFCOM").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("WF").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId())
							|| ("Tele").equals(payRollReport.getPayComponentId()) || ("US").equals(payRollReport.getPayComponentId()) || ("AD").equals(payRollReport.getPayComponentId()) || ("TR1").equals(payRollReport.getPayComponentId()) || ("OTD").equals(payRollReport.getPayComponentId()) || ("TOTDE").equals(payRollReport.getPayComponentId()) || ("PI").equals(payRollReport.getPayComponentId()) || ("HR").equals(payRollReport.getPayComponentId()) || ("ARR").equals(payRollReport.getPayComponentId())) {

						payRollMap.put(payRollReport.getPayComponentId(), payRollReport.getAmount());
					}

					if (payRollReportList.size() == i) {
						payRollList.add(payRollMap);
					}
					tmpemployeeId = payRollReport.getEmployeeId();
				} else {
					payRollList.add(payRollMap);
					payRollMap = new HashMap<>();

					if (payRollMap.containsKey("salDays")) {

					} else {
						payRollMap.put("salDays", payRollReport.getSalDays());
					}
					if (payRollMap.containsKey("epfno")) {

					} else {
						payRollMap.put("epfno", payRollReport.getEpfno());
					}
					if (payRollMap.containsKey("uanno")) {

					} else {
						payRollMap.put("epfno", payRollReport.getUanno());
					}

					if (payRollMap.containsKey("lopDays")) {

					} else {
						payRollMap.put("lopDays", payRollReport.getLopDays());
					}
					if (payRollMap.containsKey("lopAmount")) {

					} else {
						payRollMap.put("lopAmount", payRollReport.getLopAmount());
					}
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

							("PFCOM").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("WF").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId())
							|| ("Tele").equals(payRollReport.getPayComponentId()) || ("US").equals(payRollReport.getPayComponentId()) || ("AD").equals(payRollReport.getPayComponentId()) || ("TR1").equals(payRollReport.getPayComponentId()) || ("OTD").equals(payRollReport.getPayComponentId()) || ("TOTDE").equals(payRollReport.getPayComponentId()) || ("PI").equals(payRollReport.getPayComponentId()) || ("HR").equals(payRollReport.getPayComponentId()) || ("ARR").equals(payRollReport.getPayComponentId())) {

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
	public PaySlipResultBean getEmpDetailList(String employeeId) throws Exception {
		List<EmployeeEarlyStartBean> empdetailList = new ArrayList<>();
		List<EmployeeEarlyStartBean> sample = new ArrayList<>();
		PaySlipResultBean empty = new PaySlipResultBean();
		try {

			empdetailList = jdbcTemplate.query(PaySlipQueryUtil.get_EmployeeDetail_List, new BeanPropertyRowMapper<>(EmployeeEarlyStartBean.class), employeeId, employeeId);

			for (EmployeeEarlyStartBean okk : empdetailList) {
				sample = jdbcTemplate.query(PaySlipQueryUtil.mail, new BeanPropertyRowMapper<>(EmployeeEarlyStartBean.class), okk.getEmployeeId());
			}

			empty.setEmpdetailList(empdetailList);
			empty.setSample(sample);

			return empty;
		} catch (Exception e) {
			LOGGER.error("Error in get_HabitualLate_List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public PaySlipResultBean getemailid(List<PaySlipBean> employeeIdlist) throws Exception {

		List<PaySlipBean> mailList = new ArrayList<>();

		PaySlipResultBean bean = new PaySlipResultBean();

		for (PaySlipBean obj : employeeIdlist) {

			PaySlipBean payslipBean = new PaySlipBean();

			List<PaySlipBean> list = new ArrayList<>();

			list = jdbcTemplate.query(PaySlipQueryUtil.mail, new BeanPropertyRowMapper<>(PaySlipBean.class), obj.getEmpId());

			String mail = list.get(0).getEmail();
			Integer department = list.get(0).getDepartmentId();

			payslipBean.setEmail(mail);
			payslipBean.setDepartmentId(department);
			payslipBean.setEmpId(obj.getEmpId());

			mailList.add(payslipBean);

		}

		bean.setEmailList(mailList);

		return bean;
	}

}