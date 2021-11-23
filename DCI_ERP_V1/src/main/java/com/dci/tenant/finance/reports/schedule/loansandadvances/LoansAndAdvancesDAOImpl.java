package com.dci.tenant.finance.reports.schedule.loansandadvances;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;


@Repository
@Transactional("tenantTransactionManager")
public class LoansAndAdvancesDAOImpl implements LoansAndAdvancesDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoansAndAdvancesDAOImpl.class);

	@Resource
	 private DataSource dataSource;

	@Override
	public List<SelectivityBean> getDepartmentList() {
		List<SelectivityBean> lDepartmentList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lDepartmentList = jdbcTemplate.query(LoansAndAdvancesQueryUtil.GET_DEPARTMENT_LIST, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
		} catch (DataAccessException e) {

		}
		return lDepartmentList;
	}

	@Override
	public List<SelectivityBean> getCustomerList() {
		List<SelectivityBean> lCustomerList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lCustomerList = jdbcTemplate.query(LoansAndAdvancesQueryUtil.GET_CUSTOMER_LIST, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
		} catch (DataAccessException e) {

		}
		return lCustomerList;
	}

	@Override
	public List<SelectivityBean> getSupplierList() {
		List<SelectivityBean> lSupplierList = new ArrayList<SelectivityBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lSupplierList = jdbcTemplate.query(LoansAndAdvancesQueryUtil.GET_SUPPLIER_LIST, new BeanPropertyRowMapper<SelectivityBean>(
					SelectivityBean.class));
		} catch (DataAccessException e) {

		}
		return lSupplierList;
	}

	@Override
	public LoansAndAdvancesResultBean getEmployeeList(String department) throws CustomException {
		LoansAndAdvancesResultBean loansAndAdvancesResultBean = new LoansAndAdvancesResultBean();
		List<LoansAndAdvancesBean> employeeList = new ArrayList<LoansAndAdvancesBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			employeeList = jdbcTemplate.query(LoansAndAdvancesQueryUtil.GET_EMPLOYEE_LIST, new BeanPropertyRowMapper<LoansAndAdvancesBean>(
					LoansAndAdvancesBean.class), department);
			loansAndAdvancesResultBean.setEmployeeList(employeeList);
		} catch (DataAccessException e) {
			System.out.println(e);
			LOGGER.error("Error in employee list ", e);
			throw new CustomException("Error in loansAdvances list");
		}
		return loansAndAdvancesResultBean;
	}

	@Override
	public List<LoansAndAdvancesBean> generateLAReport(LoansAndAdvancesBean objLoansAndAdvancesBean) {
		List<LoansAndAdvancesBean> lLAList = new ArrayList<LoansAndAdvancesBean>();
		int advance = 2001;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			if (objLoansAndAdvancesBean.getCategory().equals("loan")) {
				lLAList = jdbcTemplate.query(LoansAndAdvancesQueryUtil.GET_LA_REPORT, new Object[] { (objLoansAndAdvancesBean.getEmployee()) },
						new BeanPropertyRowMapper<LoansAndAdvancesBean>(LoansAndAdvancesBean.class));
			} else if (objLoansAndAdvancesBean.getCategory().equals("advance")) {
				lLAList = jdbcTemplate.query(LoansAndAdvancesQueryUtil.GET_LA_ADVANCE_REPORT, new BeanPropertyRowMapper<LoansAndAdvancesBean>(
						LoansAndAdvancesBean.class));
			} else if (objLoansAndAdvancesBean.getCategory().equals("customer")) {
				lLAList = jdbcTemplate.query(LoansAndAdvancesQueryUtil.GET_LA_CUSTOMER_REPORT,
						new Object[] { (objLoansAndAdvancesBean.getCustomer()) }, new BeanPropertyRowMapper<LoansAndAdvancesBean>(
								LoansAndAdvancesBean.class));
			} else if (objLoansAndAdvancesBean.getCategory().equals("supplier")) {
				lLAList = jdbcTemplate.query(LoansAndAdvancesQueryUtil.GET_LA_SUPPLIER_REPORT, new Object[] {
						(objLoansAndAdvancesBean.getSupplier()), advance }, new BeanPropertyRowMapper<LoansAndAdvancesBean>(
						LoansAndAdvancesBean.class));
			}

		} catch (DataAccessException e) {

		}
		return lLAList;
	}

}
