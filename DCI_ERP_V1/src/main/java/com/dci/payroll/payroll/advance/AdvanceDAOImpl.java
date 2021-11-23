package com.dci.payroll.payroll.advance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.dci.payroll.payroll.loanEntry.LoanEntryDAOImpl;
import com.dci.tenant.user.UserDetail;



@Repository
public class AdvanceDAOImpl implements AdvanceDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoanEntryDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Override
	public List<Advance> getEmployeeList() throws Exception {
		List<Advance> employeeList = new ArrayList<>();
		try {

			employeeList = jdbcTemplate.query(AdvanceQueryUtil.SELECT_EMPLOYEE, new BeanPropertyRowMapper<>(Advance.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in employeeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return employeeList;
	}

	@Override
	public Advance getEmployeeDetail(String emp) throws Exception {
		Advance bean = new Advance();
		try {

			bean = jdbcTemplate.queryForObject(AdvanceQueryUtil.SELECT_EMPLOYEE_DETAIL, new BeanPropertyRowMapper<>(Advance.class), emp);

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String format = dateFormat.format(date);
			Double workingYear = jdbcTemplate.queryForObject(AdvanceQueryUtil.no_of_years, Double.class, format, bean.getJoinDate());
			bean.setWorkingYear(workingYear);
		} catch (DataAccessException e) {
			LOGGER.error("Error in employeeDetail", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return bean;
	}

	@Override
	public List<Advance> getDesignationList() throws Exception {
		List<Advance> designationList = new ArrayList<>();
		try {

			designationList = jdbcTemplate.query(AdvanceQueryUtil.SELECT_DESIGNATION, new BeanPropertyRowMapper<>(Advance.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in designationList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return designationList;
	}

	@Override
	public List<Advance> getEmployeeListbasondes(String des) throws Exception {
		List<Advance> employeeList1 = new ArrayList<>();
		try {

			employeeList1 = jdbcTemplate.query(AdvanceQueryUtil.SELECT_EMPLOYEE_basonDES, new BeanPropertyRowMapper<>(Advance.class), Integer.parseInt(des));

		} catch (DataAccessException e) {
			LOGGER.error("Error in employeeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return employeeList1;
	}

	@Override
	public List<Advance> getInsList(Advance Advance) throws Exception {
		List<Advance> List = new ArrayList<>();
		try {
			int number = Integer.parseInt(Advance.getNumberOfInstallments()) - Integer.parseInt(Advance.getInstallmentPaid());

			List = jdbcTemplate.query(AdvanceQueryUtil.insList, new BeanPropertyRowMapper<>(Advance.class), number);

		} catch (DataAccessException e) {
			LOGGER.error("Error in employeeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return List;
	}

	@Override
	public boolean addAdvance(Advance Advance) throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean isSuccess = false;

		try {
			String code = "";

			String maxId = jdbcTemplate.queryForObject(AdvanceQueryUtil.check_max, String.class);
			int max = Integer.parseInt(maxId);
			int nextId = max + 1;

			code = nextId + "";
			String prefix = "";
			if (code.length() == 1) {
				prefix = "AD000";
			} else if (code.length() == 2) {
				prefix = "AD00";
			} else if (code.length() == 3) {
				prefix = "AD0";
			} else {
				prefix = "AD";
			}
			code = prefix + code;

			if (Advance.getInstallmentPaid() == "" || Advance.getInstallmentPaid() == null) {

				Advance.setInstallmentPaid("0");

			}

			jdbcTemplate.update(AdvanceQueryUtil.insert_advance, code, Advance.getEmployee(), Advance.getDescription(), Advance.getAmount(), Advance.getDisbursementDate(), Advance.getOpeningBalance(), Integer.parseInt(Advance.getInstallmentPaid()), Integer.parseInt(Advance.getRecoverytype()), Advance.getInstallmentAmount(), Advance.getDeductFrom(), Integer.parseInt(Advance.getNumberOfInstallments()), userDetail.getUserId());
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in insert Advance", e);
		}

		return isSuccess;

	}

	@Override
	public List<Advance> getAdvanceListList() throws Exception {
		List<Advance> AdvanceList = new ArrayList<>();
		try {
			AdvanceList = jdbcTemplate.query(AdvanceQueryUtil.Advance_List, new BeanPropertyRowMapper<>(Advance.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAdvanceList", e);
		}
		return AdvanceList;
	}

	@Override
	public List<Advance> getAdvanceListbyCode(String advanceCode) throws Exception {
		List<Advance> AdvanceList = new ArrayList<>();
		// Advance objAdvance = new Advance();
		try {

			// String userId = "select emp_id from emp_advance where adv_code='"
			// + advanceCode + "'";
			// objAdvance.setEmployeeId(userId);

			String emp_id = jdbcTemplate.queryForObject(AdvanceQueryUtil.GET_EMP_ID, String.class, advanceCode);
			AdvanceList = jdbcTemplate.query(AdvanceQueryUtil.Advance_List_byCode_blnceamount, new BeanPropertyRowMapper<>(Advance.class), advanceCode, emp_id);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAdvanceList", e);
		}
		return AdvanceList;
	}

	@Override
	public boolean updateAdvance(Advance Advance) throws Exception {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean isSuccess = false;

		try {
			if (Advance.getInstallmentPaid() == "" || Advance.getInstallmentPaid() == null) {

				Advance.setInstallmentPaid("0");

			}

			jdbcTemplate.update(AdvanceQueryUtil.Advance_Update, Advance.getEmployee(), Advance.getDescription(), Advance.getAmount(), Advance.getDisbursementDate(), Advance.getOpeningBalance(), Integer.parseInt(Advance.getRecoverytype()), Advance.getInstallmentAmount(), Advance.getDeductFrom(), Integer.parseInt(Advance.getNumberOfInstallments()), userDetail.getUserId(), Integer.parseInt(Advance.getInstallmentPaid()), Advance.getAdvanceCode());
			isSuccess = true;

		} catch (DataAccessException e) {
			isSuccess = false;
			LOGGER.error("Error in insert Advance", e);
		}

		return isSuccess;
	}

	@Override
	public boolean deleteAdvance(String advanceCode) throws Exception {
		boolean isSuccess = false;

		try {

			jdbcTemplate.update(AdvanceQueryUtil.Advance_Delete, advanceCode);
			isSuccess = true;

		} catch (DataAccessException e) {
			isSuccess = false;
			LOGGER.error("Error in insert Advance", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}

		return isSuccess;
	}

	@Override
	public List<Advance> getAdvanceAddList(Advance Advance) throws Exception {

		List<Advance> AdvanceList = new ArrayList<>();
		List<Advance> AdvanceListFinal = new ArrayList<>();
		try {
			if (Advance.getDepartmentId() != null && Advance.getEmployeeId() != null && !Advance.getEmployeeId().isEmpty()) {

				AdvanceList = jdbcTemplate.query(AdvanceQueryUtil.Advance_AddList_DeptEmp, new BeanPropertyRowMapper<>(Advance.class), Advance.getMonthYear(), Advance.getDepartmentId(), Advance.getEmployeeId());

				for (Advance adv : AdvanceList) {

					Integer ins = Integer.parseInt(adv.getNumberOfInstallments());
					Integer insnew = ins - 1;

					if (adv.getRecoverytype().equals("1")) {

						String query = "select count(*) from emp_advance where to_date('" + Advance.getMonthYear() + "','mmyyyy') between deduct_from_mnth and deduct_from_mnth + INTERVAL '" + insnew + "' month";

						int count = jdbcTemplate.queryForObject (query,Integer.class);						
						if (count > 0) {
							AdvanceListFinal.add(adv);
						}

					} else if (adv.getRecoverytype().equals("2")) {

						String query = " select count(*) from emp_advance where case when(select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1) is not null then  (select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1)+ INTERVAL '3' month else deduct_from_mnth end  = to_date('" + Advance.getMonthYear() + "','mmyyyy')";
						int count = jdbcTemplate.queryForObject(query,Integer.class);
						if (count > 0) {
							AdvanceListFinal.add(adv);
						}

					} else if (adv.getRecoverytype().equals("3")) {
						String query = " select count(*) from emp_advance where case when(select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1) is not null then  (select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1)+ INTERVAL '6' month else deduct_from_mnth end  = to_date('" + Advance.getMonthYear() + "','mmyyyy')";
						int count = jdbcTemplate.queryForObject(query,Integer.class);

						if (count > 0) {
							AdvanceListFinal.add(adv);
						}
					} else {
						String query = " select count(*) from emp_advance where case when(select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1) is not null then  (select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1)+ INTERVAL '12' month else deduct_from_mnth end  = to_date('" + Advance.getMonthYear() + "','mmyyyy')";
						int count = jdbcTemplate.queryForObject(query,Integer.class);
						if (count > 0) {
							AdvanceListFinal.add(adv);
						}
					}
				}

			} else if (Advance.getDepartmentId() != null && (Advance.getEmployeeId() == null || Advance.getEmployeeId().isEmpty())) {

				AdvanceList = jdbcTemplate.query(AdvanceQueryUtil.Advance_AddList_Dept, new BeanPropertyRowMapper<>(Advance.class), Advance.getMonthYear(), Advance.getDepartmentId());

				for (Advance adv : AdvanceList) {

					Integer ins = Integer.parseInt(adv.getNumberOfInstallments());
					Integer insnew = ins - 1;

					if (adv.getRecoverytype().equals("1")) {

						String query = "select count(*) from emp_advance where to_date('" + Advance.getMonthYear() + "','mmyyyy') between deduct_from_mnth and deduct_from_mnth + INTERVAL '" + insnew + "' month";

						int count = jdbcTemplate.queryForObject(query,Integer.class);
						if (count > 0) {
							AdvanceListFinal.add(adv);
						}

					} else if (adv.getRecoverytype().equals("2")) {

						String query = " select count(*) from emp_advance where case when(select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1) is not null then  (select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1)+ INTERVAL '3' month else deduct_from_mnth end  = to_date('" + Advance.getMonthYear() + "','mmyyyy')";
						int count = jdbcTemplate.queryForObject(query,Integer.class);
						if (count > 0) {
							AdvanceListFinal.add(adv);
						}

					} else if (adv.getRecoverytype().equals("3")) {
						String query = " select count(*) from emp_advance where case when(select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1) is not null then  (select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1)+ INTERVAL '6' month else deduct_from_mnth end  = to_date('" + Advance.getMonthYear() + "','mmyyyy')";
						int count = jdbcTemplate.queryForObject(query,Integer.class);

						if (count > 0) {
							AdvanceListFinal.add(adv);
						}
					} else {
						String query = " select count(*) from emp_advance where case when(select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1) is not null then  (select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1)+ INTERVAL '12' month else deduct_from_mnth end  = to_date('" + Advance.getMonthYear() + "','mmyyyy')";
						int count = jdbcTemplate.queryForObject(query,Integer.class);
						if (count > 0) {
							AdvanceListFinal.add(adv);
						}
					}
				}

			} else {

				AdvanceList = jdbcTemplate.query(AdvanceQueryUtil.Advance_AddList, new BeanPropertyRowMapper<>(Advance.class), Advance.getMonthYear());

				for (Advance adv : AdvanceList) {

					Integer ins = Integer.parseInt(adv.getNumberOfInstallments());
					Integer insnew = ins - 1;

					if (adv.getRecoverytype().equals("1")) {

						String query = "select count(*) from emp_advance where to_date('" + Advance.getMonthYear() + "','mmyyyy') between deduct_from_mnth and deduct_from_mnth + INTERVAL '" + insnew + "' month";

						int count = jdbcTemplate.queryForObject(query,Integer.class);
						if (count > 0) {
							AdvanceListFinal.add(adv);
						}

					} else if (adv.getRecoverytype().equals("2")) {

						String query = " select count(*) from emp_advance where case when(select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1) is not null then  (select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1)+ INTERVAL '3' month else deduct_from_mnth end  = to_date('" + Advance.getMonthYear() + "','mmyyyy')";
						int count = jdbcTemplate.queryForObject(query,Integer.class);
						if (count > 0) {
							AdvanceListFinal.add(adv);
						}

					} else if (adv.getRecoverytype().equals("3")) {
						String query = " select count(*) from emp_advance where case when(select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1) is not null then  (select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1)+ INTERVAL '6' month else deduct_from_mnth end  = to_date('" + Advance.getMonthYear() + "','mmyyyy')";
						int count = jdbcTemplate.queryForObject(query,Integer.class);

						if (count > 0) {
							AdvanceListFinal.add(adv);
						}
					} else {
						String query = " select count(*) from emp_advance where case when(select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1) is not null then  (select month_year from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' order by month_year desc limit 1)+ INTERVAL '12' month else deduct_from_mnth end  = to_date('" + Advance.getMonthYear() + "','mmyyyy')";
						int count = jdbcTemplate.queryForObject(query,Integer.class);
						if (count > 0) {
							AdvanceListFinal.add(adv);
						}
					}
				}

			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAdvanceAddList", e);
		}
		return AdvanceListFinal;

	}

	@Override
	public AdvanceResultBean addAdvanceAmount(ArrayList<Advance> Advance) throws Exception {

		AdvanceResultBean bean = new AdvanceResultBean();
		// boolean isScucess = false;
		bean.setAlert("Deduction calculated towards advance exceeds net salary for (");

		try {
			for (Advance adv : Advance) {

				int count1 = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_amount_deduct_check,new Object[] { adv.getEmployeeCode(), adv.getMonthYear() }, Integer.class);
				if (count1 == 0) {

					Double ttlAmt = jdbcTemplate.queryForObject(AdvanceQueryUtil.NET_AMOUNT, Double.class, adv.getDepartmentId(), adv.getEmployeeCode(), adv.getMonthYear());
					if (ttlAmt >= adv.getInstallmentAmount()) {

						Double ttlADVAmt = jdbcTemplate.queryForObject(AdvanceQueryUtil.existADV_AMOUNT, Double.class, adv.getEmployeeCode(), adv.getMonthYear());
						if (ttlADVAmt == null) {
							ttlADVAmt = 0.00;
						}
						Double tmpAdvAmt = ttlADVAmt + adv.getInstallmentAmount();
						Double AdvAmnt = adv.getAmount();
						if (AdvAmnt > tmpAdvAmt) {

							// if(adv.get)

							int countEx = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_deduct_exist,new Object[] { adv.getAdvanceCode(), adv.getMonthYear() },Integer.class);
							if (countEx != 0) {
								jdbcTemplate.update(AdvanceQueryUtil.delete_Advance_deduct_exist, adv.getAdvanceCode(), adv.getMonthYear());
								jdbcTemplate.update(AdvanceQueryUtil.Advance_amount_deduct, adv.getAdvanceCode(), adv.getEmployeeCode(), adv.getMonthYear(), adv.getInstallmentAmount(), adv.getNarration());
							} else {
								jdbcTemplate.update(AdvanceQueryUtil.Advance_amount_deduct, adv.getAdvanceCode(), adv.getEmployeeCode(), adv.getMonthYear(), adv.getInstallmentAmount(), adv.getNarration());
							}

							int ins = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_ins_count,new Object[] { adv.getAdvanceCode()},Integer.class);
							int insttl = ins + Integer.parseInt(adv.getToModify());
							jdbcTemplate.update(AdvanceQueryUtil.Advance_add_installment, insttl, adv.getAdvanceCode(),Integer.class);

							String component = "AD";

							int count = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_add_emp_component_count, new Object[] {adv.getEmployeeCode(), adv.getMonthYear(), component},Integer.class);
							if (count != 0) {
								Double adamt = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_add_emp_component_AD, Double.class, adv.getEmployeeCode(), adv.getMonthYear(), component,Integer.class);
								Double totaladamt = adamt + adv.getInstallmentAmount();
								jdbcTemplate.update(AdvanceQueryUtil.Advance_add_emp_component_update, totaladamt, adv.getEmployeeCode(), adv.getMonthYear(), component);
							} else {
								jdbcTemplate.update(AdvanceQueryUtil.Advance_add_emp_component, adv.getEmployeeCode(), component, adv.getMonthYear(), adv.getInstallmentAmount(), adv.getDepartmentId());
							}
							bean.setSuccess(true);
						} else {

							bean.setSuccess(false);
							bean.setAlert("Deducted Amount Excedds the Advance Amount (");
						}
					} else {
						bean.setSuccess(false);
						int countEx1 = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_deduct_exist_emp,new Object[] { adv.getEmployeeCode(), adv.getMonthYear()},Integer.class);
						if (countEx1 != 0) {

							List<Advance> AdvanceListFinal1 = new ArrayList<>();

							AdvanceListFinal1 = jdbcTemplate.query(AdvanceQueryUtil.Advance_tempList, new BeanPropertyRowMapper<>(Advance.class), adv.getEmployeeCode(), adv.getMonthYear());

							for (Advance ad : AdvanceListFinal1) {

								int ins = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_ins_count, new Object[] {ad.getAdvanceCode()},Integer.class);
								int insttl = ins - 1;
								jdbcTemplate.update(AdvanceQueryUtil.Advance_add_installment, insttl, ad.getAdvanceCode());
							}
							jdbcTemplate.update(AdvanceQueryUtil.delete_Advance_amount_deduct, adv.getEmployeeCode(), adv.getMonthYear());

							String component1 = "AD";
							int count2 = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_add_emp_component_count,new Object[] { adv.getEmployeeCode(), adv.getMonthYear(), component1},Integer.class);
							if (count2 != 0) {
								jdbcTemplate.update(AdvanceQueryUtil.deleteAdvance_pay, adv.getEmployeeCode(), adv.getMonthYear(), component1);

							}
						}
						String alertMsg = bean.getAlert() + " " + adv.getEmployeeName() + ",";
						bean.setAlert(alertMsg);
					}

				} else {
					Double ttlADVAmt = jdbcTemplate.queryForObject(AdvanceQueryUtil.existADV_AMOUNT, Double.class, adv.getEmployeeCode(), adv.getMonthYear());
					Double tmpAdvAmt = ttlADVAmt + adv.getInstallmentAmount();

					Double ttlAmt = jdbcTemplate.queryForObject(AdvanceQueryUtil.NET_AMOUNT, Double.class, adv.getDepartmentId(), adv.getEmployeeCode(), adv.getMonthYear());
					Double tmpttlAmt = ttlAmt + ttlADVAmt;
					if (tmpttlAmt >= tmpAdvAmt) {

						int countEx = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_deduct_exist,new Object[] { adv.getAdvanceCode(), adv.getMonthYear()},Integer.class);
						if (countEx != 0) {
							jdbcTemplate.update(AdvanceQueryUtil.delete_Advance_deduct_exist, adv.getAdvanceCode(), adv.getMonthYear());
							jdbcTemplate.update(AdvanceQueryUtil.Advance_amount_deduct, adv.getAdvanceCode(), adv.getEmployeeCode(), adv.getMonthYear(), adv.getInstallmentAmount(), adv.getNarration());
						} else {
							jdbcTemplate.update(AdvanceQueryUtil.Advance_amount_deduct, adv.getAdvanceCode(), adv.getEmployeeCode(), adv.getMonthYear(), adv.getInstallmentAmount(), adv.getNarration());
						}

						int ins = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_ins_count,new Object[] { adv.getAdvanceCode()},Integer.class);
						int insttl = ins + 1;

						jdbcTemplate.update(AdvanceQueryUtil.Advance_add_installment, insttl, adv.getAdvanceCode(),Integer.class);

						String component = "AD";

						int count = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_add_emp_component_count,new Object[] { adv.getEmployeeCode(), adv.getMonthYear(), component },Integer.class);
						if (count != 0) {
							Double adamt = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_add_emp_component_AD, Double.class, adv.getEmployeeCode(), adv.getMonthYear(), component,Integer.class);
							Double totaladamt = adamt + adv.getInstallmentAmount();
							jdbcTemplate.update(AdvanceQueryUtil.Advance_add_emp_component_update, totaladamt, adv.getEmployeeCode(), adv.getMonthYear(), component);
						} else {
							jdbcTemplate.update(AdvanceQueryUtil.Advance_add_emp_component, adv.getEmployeeCode(), component, adv.getMonthYear(), adv.getInstallmentAmount());
						}
						bean.setSuccess(true);

					} else {

						List<Advance> AdvanceListFinal = new ArrayList<>();

						AdvanceListFinal = jdbcTemplate.query(AdvanceQueryUtil.Advance_tempList, new BeanPropertyRowMapper<>(Advance.class), adv.getEmployeeCode(), adv.getMonthYear());

						for (Advance ad : AdvanceListFinal) {

							int ins = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_ins_count, new Object[] {ad.getAdvanceCode() },Integer.class);
							int insttl = ins - 1;
							jdbcTemplate.update(AdvanceQueryUtil.Advance_add_installment, insttl, ad.getAdvanceCode(),Integer.class);
						}
						jdbcTemplate.update(AdvanceQueryUtil.delete_Advance_amount_deduct, adv.getEmployeeCode(), adv.getMonthYear(),Integer.class);

						String component = "AD";
						int count = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_add_emp_component_count,new Object[] { adv.getEmployeeCode(), adv.getMonthYear(), component},Integer.class);
						if (count != 0) {
							jdbcTemplate.update(AdvanceQueryUtil.deleteAdvance_pay, adv.getEmployeeCode(), adv.getMonthYear(), component);

						}
						bean.setSuccess(false);
						int countEx1 = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_deduct_exist_emp,new Object[] { adv.getEmployeeCode(), adv.getMonthYear() },Integer.class);
						if (countEx1 != 0) {

							List<Advance> AdvanceListFinal1 = new ArrayList<>();

							AdvanceListFinal1 = jdbcTemplate.query(AdvanceQueryUtil.Advance_tempList, new BeanPropertyRowMapper<>(Advance.class), adv.getEmployeeCode(), adv.getMonthYear());

							for (Advance ad : AdvanceListFinal1) {

								int ins = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_ins_count,new Object[] { ad.getAdvanceCode() },Integer.class);
								int insttl = ins - 1;
								jdbcTemplate.update(AdvanceQueryUtil.Advance_add_installment, insttl, ad.getAdvanceCode());
							}
							jdbcTemplate.update(AdvanceQueryUtil.delete_Advance_amount_deduct, adv.getEmployeeCode(), adv.getMonthYear());

							String component1 = "AD";
							int count2 = jdbcTemplate.queryForObject(AdvanceQueryUtil.Advance_add_emp_component_count,new Object[] { adv.getEmployeeCode(), adv.getMonthYear(), component1 },Integer.class);
							if (count2 != 0) {
								jdbcTemplate.update(AdvanceQueryUtil.deleteAdvance_pay, adv.getEmployeeCode(), adv.getMonthYear(), component1);

							}
						}

						String alertMsg = bean.getAlert() + " " + adv.getEmployeeName() + ",";
						bean.setAlert(alertMsg);
					}

				}

			}
			String alertMsg = bean.getAlert() + " ). Please recheck and proceed.";
			bean.setAlert(alertMsg);
			// isScucess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in inserting Advance Amount", e);
		}
		return bean;
	}

	@Override
	public boolean deleteAdvanceAdd(String monthYear, Integer departmentId, String employeeId) throws Exception {
		boolean isSuccess = false;
		List<Advance> AdvanceList = new ArrayList<>();
		String component = "AD";
		try {
			if (departmentId != null && employeeId != null && !employeeId.isEmpty()) {
				AdvanceList = jdbcTemplate.query(AdvanceQueryUtil.Advance_AddList_DeptEmp_del, new BeanPropertyRowMapper<>(Advance.class), monthYear, departmentId, employeeId);
				for (Advance adv : AdvanceList) {
					String query = "delete from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' and month_year = to_date('" + monthYear + "','mmyyyy')";
					jdbcTemplate.update(query);

					int inspaid = Integer.parseInt(adv.getInstallmentPaid());
					if (inspaid != 0) {
						int inspaidnew = inspaid - 1;
						String query1 = "update emp_advance set installmts_paid =" + inspaidnew + " where adv_code = '" + adv.getAdvanceCode() + "'";
						jdbcTemplate.update(query1);
					}
					String query2 = "delete from employee_pay_component_paid where month_year = '" + monthYear + "' and pay_component_id ='" + component + "' and employee_id = '" + adv.getEmployeeCode() + "'";
					jdbcTemplate.update(query2);
				}
			} else if (departmentId != null && (employeeId == null || employeeId.isEmpty())) {
				AdvanceList = jdbcTemplate.query(AdvanceQueryUtil.Advance_AddList_Dept_del, new BeanPropertyRowMapper<>(Advance.class), monthYear, departmentId);
				for (Advance adv : AdvanceList) {
					String query = "delete from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' and month_year = to_date('" + monthYear + "','mmyyyy')";
					jdbcTemplate.update(query);

					int inspaid = Integer.parseInt(adv.getInstallmentPaid());
					if (inspaid != 0) {
						int inspaidnew = inspaid - 1;
						String query1 = "update emp_advance set installmts_paid =" + inspaidnew + " where adv_code = '" + adv.getAdvanceCode() + "'";
						jdbcTemplate.update(query1);
					}
					String query2 = "delete from employee_pay_component_paid where month_year = '" + monthYear + "' and pay_component_id = '" + component + "' and employee_id = '" + adv.getEmployeeCode() + "'";
					jdbcTemplate.update(query2);
				}
			} else {
				AdvanceList = jdbcTemplate.query(AdvanceQueryUtil.Advance_AddList_del, new BeanPropertyRowMapper<>(Advance.class), monthYear);
				for (Advance adv : AdvanceList) {
					String query = "delete from emp_advance_deduct where adv_code = '" + adv.getAdvanceCode() + "' and month_year = to_date('" + monthYear + "','mmyyyy')";
					jdbcTemplate.update(query);

					int inspaid = Integer.parseInt(adv.getInstallmentPaid());
					if (inspaid != 0) {
						int inspaidnew = inspaid - 1;
						String query1 = "update emp_advance set installmts_paid =" + inspaidnew + " where adv_code = '" + adv.getAdvanceCode() + "'";
						jdbcTemplate.update(query1);
					}
					String query2 = "delete from employee_pay_component_paid where month_year = '" + monthYear + "' and pay_component_id = '" + component + "' and employee_id = '" + adv.getEmployeeCode() + "'";
					jdbcTemplate.update(query2);
				}
			}
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteAdvanceList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public List<Advance> getAdvanceReport(Advance Advance) throws Exception {
		List<Advance> AdvanceList = new ArrayList<>();
		try {

			AdvanceList = jdbcTemplate.query(AdvanceQueryUtil.Advance_ReportList, new BeanPropertyRowMapper<>(Advance.class), Advance.getMonthYear());

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAdvanceAddList", e);
		}
		return AdvanceList;
	}

}
