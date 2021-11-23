package com.dci.tenant.finance.closingaccounts;

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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;

@Repository
public class ClosingAccountsDAOImpl implements ClosingAccountsDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClosingAccountsDAOImpl.class);

	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AuditLogDAO auditLogDao;

	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<ClosingAccounts> getList() throws Exception {

		List<ClosingAccounts> list = new ArrayList<>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			list = jdbcTemplate.query(AccountingYearCloseQueryUtil.list, new BeanPropertyRowMapper<>(ClosingAccounts.class));
			System.out.println("List" + list);
			/*
			 * for (Map row : rows) { ClosingAccountsBean bean = new
			 * ClosingAccountsBean();
			 * bean.setFromdate(String.valueOf(row.get("fromdate")));
			 * bean.setTodate(String.valueOf(row.get("todate"))); //
			 * bean.setLocation(String.valueOf(row.get("company_name"))); //
			 * bean.setCompanyCode(String.valueOf(row.get("company_code")));
			 * 
			 * list.add(bean); }
			 */

		} catch (DataAccessException e) {
			LOGGER.error("Error in taxSubSectionList", e);
		}
		return list;
	}

	@Override
	public boolean insertManageCostCenter(ClosingAccounts objClosingAccountsBean) throws Exception {
		boolean isSuccess = false;
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {

			// Map<String, Object> manageCostCenterMap = new HashMap<>();
			// manageCostCenterMap.put("company_id",
			// objClosingAccountsBean.getCompanyId());
			// manageCostCenterMap.put("fromdate",
			// objClosingAccountsBean.getFromdate());
			// manageCostCenterMap.put("todate",
			// objClosingAccountsBean.getTodate());
			int value = jdbcTemplate.update(AccountingYearCloseQueryUtil.save, objClosingAccountsBean.getFromdate(), objClosingAccountsBean.getTodate(), objClosingAccountsBean.getCompanyId());
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertTaxSubSection", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		return isSuccess;
	}

	@Override
	public boolean update(ClosingAccounts objClosingAccountsBean) throws Exception {
		boolean isSuccess = false;
		try {
			/*
			 * Map<String, Object> manageCostCenterMap = new HashMap<>();
			 * manageCostCenterMap.put("company_code",
			 * objClosingAccountsBean.getCompanyId());
			 * manageCostCenterMap.put("fromdate",
			 * objClosingAccountsBean.getFromdate());
			 * manageCostCenterMap.put("todate",
			 * objClosingAccountsBean.getTodate());
			 * manageCostCenterMap.put("closing_account_id",
			 * objClosingAccountsBean.getClosingAccountId());
			 */
			jdbcTemplate.update(AccountingYearCloseQueryUtil.UPDATE, objClosingAccountsBean.getCompanyId(), objClosingAccountsBean.getFromdate(), objClosingAccountsBean.getTodate(), objClosingAccountsBean.getClosingAccountId());
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in taxSubSectionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return isSuccess;
	}

	@Override
	public ClosingAccounts edit(Integer closingAccountId) throws Exception {
		ClosingAccounts closingaccounts = new ClosingAccounts();
		try {
			closingaccounts = jdbcTemplate.queryForObject(AccountingYearCloseQueryUtil.EDIT, new Object[] { closingAccountId }, new BeanPropertyRowMapper<>(ClosingAccounts.class));
			closingaccounts.setisEdit(true);
			System.out.println("values" + closingaccounts);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getclosingAccountId", e);
			closingaccounts.setisEdit(false);
			return closingaccounts;
		}
		// TODO Auto-generated method stub
		return closingaccounts;
	}

	@Override
	public boolean delete(Integer closingAccountId) throws Exception {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(AccountingYearCloseQueryUtil.DELETE, closingAccountId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteTaxSubSection", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public ClosingAccountsResultBean save(ClosingAccounts objClosingAccountsBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
