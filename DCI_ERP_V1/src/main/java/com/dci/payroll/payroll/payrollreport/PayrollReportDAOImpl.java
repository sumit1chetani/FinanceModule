package com.dci.payroll.payroll.payrollreport;

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



@Repository
public class PayrollReportDAOImpl implements PayrollReportDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(PayrollReportDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Override
	public List<Map<String, Object>> getPayrollList(String companyId, String branchId, String dept, String monthYear) throws CustomException {
		List<PayrollReportBean> payRollReportList = new ArrayList<>();
		List<String> header = new ArrayList<>();
		try {
			// Define Arraylist
			List<Map<String, Object>> payRollList = new ArrayList<>();
			// Define Map
			Map<String, Object> payRollMap = new HashMap<>();
			String tmpemployeeId = null;

			payRollReportList = jdbcTemplate.query(PayrollReportQueryUtil.PAYROLL_LIST, new BeanPropertyRowMapper<>(PayrollReportBean.class), monthYear, companyId, branchId, dept, monthYear);

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

					if (("BASIC").equals(payRollReport.getPayComponentId()) || ("DA").equals(payRollReport.getPayComponentId()) || ("HRA").equals(payRollReport.getPayComponentId()) || ("SPL").equals(payRollReport.getPayComponentId()) || ("CONVE").equals(payRollReport.getPayComponentId()) || ("CONS").equals(payRollReport.getPayComponentId()) || ("TA").equals(payRollReport.getPayComponentId()) || ("PI").equals(payRollReport.getPayComponentId()) || ("OT").equals(payRollReport.getPayComponentId()) || ("ARR").equals(payRollReport.getPayComponentId())
							|| ("TS_05").equals(payRollReport.getPayComponentId()) || ("MEDIC").equals(payRollReport.getPayComponentId()) || ("WF").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("EPF").equals(payRollReport.getPayComponentId()) || ("ESI").equals(payRollReport.getPayComponentId()) || ("ADMC").equals(payRollReport.getPayComponentId()) || ("EDLI").equals(payRollReport.getPayComponentId()) || ("EPS").equals(payRollReport.getPayComponentId())
							|| ("Trans").equals(payRollReport.getPayComponentId()) || ("PTS").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId()) || ("Tele").equals(payRollReport.getPayComponentId())
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

					if (("BASIC").equals(payRollReport.getPayComponentId()) || ("DA").equals(payRollReport.getPayComponentId()) || ("HRA").equals(payRollReport.getPayComponentId()) || ("SPL").equals(payRollReport.getPayComponentId()) || ("CONVE").equals(payRollReport.getPayComponentId()) || ("CONS").equals(payRollReport.getPayComponentId()) || ("TA").equals(payRollReport.getPayComponentId()) || ("PI").equals(payRollReport.getPayComponentId()) || ("OT").equals(payRollReport.getPayComponentId()) || ("ARR").equals(payRollReport.getPayComponentId())
							|| ("TS_05").equals(payRollReport.getPayComponentId()) || ("MEDIC").equals(payRollReport.getPayComponentId()) || ("WF").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("EPF").equals(payRollReport.getPayComponentId()) || ("ESI").equals(payRollReport.getPayComponentId()) || ("ADMC").equals(payRollReport.getPayComponentId()) || ("EDLI").equals(payRollReport.getPayComponentId()) || ("EPS").equals(payRollReport.getPayComponentId())
							|| ("Trans").equals(payRollReport.getPayComponentId()) || ("PTS").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId()) || ("Tele").equals(payRollReport.getPayComponentId())
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
	public List<Map<String, Object>> getMonthlyPayrollList(String employeeId) throws CustomException {
		List<PayrollReportBean> payRollReportList = new ArrayList<>();
		try {
			// Define Arraylist
			List<Map<String, Object>> payRollList = new ArrayList<>();
			// Define Map
			Map<String, Object> payRollMap = new HashMap<>();
			String tmpMonthYear = null;
			payRollReportList = jdbcTemplate.query(PayrollReportQueryUtil.MONTHLY_PAYROLL_LIST, new BeanPropertyRowMapper<>(PayrollReportBean.class), employeeId, employeeId);
			int i = 1;
			for (PayrollReportBean payRollReport : payRollReportList) {

				if (tmpMonthYear == null) {
					tmpMonthYear = payRollReport.getMonthYear();
					payRollMap = new HashMap<>();
				}
				if ((tmpMonthYear).equals(payRollReport.getMonthYear())) {

					if (payRollMap.containsKey("monthYear")) {

					} else {
						payRollMap.put("monthYear", payRollReport.getMonthYear());
					}
					if (payRollMap.containsKey("employeeId")) {

					} else {
						payRollMap.put("employeeId", payRollReport.getEmployeeId());
					}
					if (payRollMap.containsKey("employeeName")) {

					} else {
						payRollMap.put("employeeName", payRollReport.getEmployeeName());
					}

					if (("BASIC").equals(payRollReport.getPayComponentId()) || ("DA").equals(payRollReport.getPayComponentId()) || ("HRA").equals(payRollReport.getPayComponentId()) || ("MEDIC").equals(payRollReport.getPayComponentId()) || ("CONVE").equals(payRollReport.getPayComponentId()) || ("SPL").equals(payRollReport.getPayComponentId()) || ("CONS").equals(payRollReport.getPayComponentId()) ||

							("WF").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId()) || ("Tele").equals(payRollReport.getPayComponentId())
							|| ("US").equals(payRollReport.getPayComponentId()) || ("AD").equals(payRollReport.getPayComponentId()) || ("TR1").equals(payRollReport.getPayComponentId()) || ("OTD").equals(payRollReport.getPayComponentId())) {

						payRollMap.put(payRollReport.getPayComponentId(), payRollReport.getAmount());
					}

					if (payRollReportList.size() == i) {
						payRollList.add(payRollMap);
					}
					tmpMonthYear = payRollReport.getMonthYear();
				} else {

					payRollList.add(payRollMap);
					payRollMap = new HashMap<>();

					if (("BASIC").equals(payRollReport.getPayComponentId()) || ("DA").equals(payRollReport.getPayComponentId()) || ("HRA").equals(payRollReport.getPayComponentId()) || ("MEDIC").equals(payRollReport.getPayComponentId()) || ("CONVE").equals(payRollReport.getPayComponentId()) || ("SPL").equals(payRollReport.getPayComponentId()) || ("CONS").equals(payRollReport.getPayComponentId()) ||

							("WF").equals(payRollReport.getPayComponentId()) || ("PFSEL").equals(payRollReport.getPayComponentId()) || ("OTDED").equals(payRollReport.getPayComponentId()) || ("OTEAR").equals(payRollReport.getPayComponentId()) || ("GROSS").equals(payRollReport.getPayComponentId()) || ("NET").equals(payRollReport.getPayComponentId()) || ("PT").equals(payRollReport.getPayComponentId()) || ("TDS").equals(payRollReport.getPayComponentId()) || ("Tele").equals(payRollReport.getPayComponentId())
							|| ("US").equals(payRollReport.getPayComponentId()) || ("AD").equals(payRollReport.getPayComponentId()) || ("TR1").equals(payRollReport.getPayComponentId()) || ("OTD").equals(payRollReport.getPayComponentId())) {

						payRollMap.put(payRollReport.getPayComponentId(), payRollReport.getAmount());
					}

					tmpMonthYear = payRollReport.getMonthYear();

				}
				i++;
			}
			return payRollList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in getMonthlyPayrollList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

}