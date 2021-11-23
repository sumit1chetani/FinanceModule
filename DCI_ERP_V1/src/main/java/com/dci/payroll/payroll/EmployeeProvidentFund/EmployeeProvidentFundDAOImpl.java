package com.dci.payroll.payroll.EmployeeProvidentFund;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.payroll.tds.professionaltaxslab.ProfessionalTaxSlabDAOImpl;



@Repository
public class EmployeeProvidentFundDAOImpl implements EmployeeProvidentFundDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ProfessionalTaxSlabDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public EmployeeProvidentFundResultBean getEPFList(EmployeeProvidentFundBean employeeProvidentFundBean) throws CustomException {

		List<EmployeeProvidentFundBean> employeeid = new ArrayList<>();

		List<EmployeeProvidentFundBean> employeeProvidentFundList = new ArrayList<>();
		EmployeeProvidentFundResultBean jjd = new EmployeeProvidentFundResultBean();

		try {
			employeeProvidentFundList = jdbcTemplate.query(EmployeeProvidentFundQueryUtil.SELECT_EPF_LIST, new BeanPropertyRowMapper<>(EmployeeProvidentFundBean.class), employeeProvidentFundBean.getCompanyId(), employeeProvidentFundBean.getBranchId(), employeeProvidentFundBean.getDept(), employeeProvidentFundBean.getMonthYear());

			jjd.setEmployeeProvidentFundList(employeeProvidentFundList);

			return jjd;
		} catch (DataAccessException e) {
			LOGGER.error("Error in ProfessionalTaxSlabDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public List<EmployeeProvidentFundBean> getEPFXLList(EmployeeProvidentFundBean employeeProvidentFundBean) throws CustomException {
		List<EmployeeProvidentFundBean> employeeProvidentFundList = new ArrayList<>();
		try {
			// employeeProvidentFundList =
			// jdbcTemplate.query(EmployeeProvidentFundQueryUtil.SELECT_EPF_DETAIL_LIST, new
			// BeanPropertyRowMapper<EmployeeProvidentFundBean>(EmployeeProvidentFundBean.class),
			// employeeProvidentFundBean.getCompanyId(),
			// employeeProvidentFundBean.getBranchId(),
			// employeeProvidentFundBean.getDepartmentId(),
			// employeeProvidentFundBean.getMonthYear());
			employeeProvidentFundList = jdbcTemplate.query(EmployeeProvidentFundQueryUtil.SELECT_EPF_LIST, new BeanPropertyRowMapper<>(EmployeeProvidentFundBean.class), employeeProvidentFundBean.getCompanyId(), employeeProvidentFundBean.getBranchId(), employeeProvidentFundBean.getDept(), employeeProvidentFundBean.getMonthYear());

			return employeeProvidentFundList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in ProfessionalTaxSlabDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}
}
