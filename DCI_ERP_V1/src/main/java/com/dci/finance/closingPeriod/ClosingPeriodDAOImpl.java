package com.dci.finance.closingPeriod;

import java.util.ArrayList;
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

import com.dci.common.util.CodeStandardMsgUtil;
import com.dci.common.util.CustomException;
import com.dci.tenant.finance.closingaccounts.ClosingAccountsDAOImpl;
import com.dci.tenant.user.UserDetail;

@Repository
public class ClosingPeriodDAOImpl implements ClosingPeriodDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ClosingAccountsDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public List<ClosingPeriodBean> getClosingList() throws CustomException {

		List<ClosingPeriodBean> closingAccountList = new ArrayList<>();

		try {
			JdbcTemplate jdbctemplate = new JdbcTemplate(dataSource);

			closingAccountList = jdbctemplate.query(ClosingPeriodQueryUtil.GETCLOSINGACCOUNTLIST, new BeanPropertyRowMapper<>(ClosingPeriodBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return closingAccountList;
	}

	@Override
	public boolean delete(String closingAccountCode) throws CustomException {

		int value;
		boolean isSuccess = false;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			value = jdbcTemplate.update(ClosingPeriodQueryUtil.DELETECLOSINGACCOUNT, closingAccountCode);
			if (value != 0) {
				isSuccess = true;
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in addCodeStandard", e);
			throw new CustomException(CodeStandardMsgUtil.ERROR_ADD);
		}
		return isSuccess;
	}

	@Override
	public boolean save(ClosingPeriodBean objClosingPeriodBean) throws CustomException {

		try {

			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String userId = userDetails.getUserId();
			String companyCode = userDetails.getCompanyCode();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String comp = objClosingPeriodBean.getCompanyCode().replaceAll("'", "");
			String[] code = comp.split(",");
			for (String obj : code) {
				jdbcTemplate.update(ClosingPeriodQueryUtil.SAVE_CLOSING_ACCOUNT_HEAD, new Object[] { objClosingPeriodBean.getFromDate(), objClosingPeriodBean.getToDate(), userId, obj, objClosingPeriodBean.getStatus() });
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			LOGGER.error("Error in Customer LIST", e);
		}
		return true;
	}

	@Override
	public boolean chkDate(String cbReceiptDate) throws CustomException {
		boolean isValid = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			System.out.println("cbReceiptDate" + cbReceiptDate);
			int count = jdbcTemplate.queryForObject(ClosingPeriodQueryUtil.CHK, new Object[] { cbReceiptDate, cbReceiptDate }, Integer.class);
			if (count > 0) {
				isValid = true;
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			LOGGER.error("Error in Customer LIST", e);
		}
		return isValid;
	}

}
