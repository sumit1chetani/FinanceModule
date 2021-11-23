package com.dci.tenant.finance.tax.taxpayment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CustomException;

@Repository
@Transactional("tenantTransactionManager")

public class TaxPaymentDAOImpl implements TaxPaymentDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(TaxPaymentDAOImpl.class);


	@Resource
	 private DataSource dataSource;

	@Override
	public List<TaxPaymentBean> getTaxPaymentList() throws CustomException {
		List<TaxPaymentBean> taxPaymentBeanList = new ArrayList<TaxPaymentBean>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {

			taxPaymentBeanList = jdbcTemplate.query(TaxPaymentQueryUtil.GET_TAX_PAYMENT_LIST, new BeanPropertyRowMapper<TaxPaymentBean>(TaxPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in disbursement account list page", e);
			throw new CustomException("Error in TaxPaymentDAOImpl in list");
		}
		return taxPaymentBeanList;
	}

	@Override
	public List<TaxPaymentBean> getAcctHeadList(String userId) throws CustomException {
		List<TaxPaymentBean> taxPaymentBeanList = new ArrayList<TaxPaymentBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String empAccessStatus = "";
			String companyCode = "", query = "";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(TaxPaymentQueryUtil.GET_EMP_ACCESS_STATUS, new Object[] { userId });
			for (Map row : rows) {
				empAccessStatus = "Y";
				companyCode = String.valueOf(row.get("COMPANY_CODE"));
			}
			// and ACCT_HEAD_CODE ='A020603'
			if (empAccessStatus.equals("Y")) {
				query = TaxPaymentQueryUtil.accountCategoryList;
			} else if (companyCode.equals("C0001")) {
				query = TaxPaymentQueryUtil.accountCategoryListDXB + " union all " + TaxPaymentQueryUtil.getBankForCompany;
			} else if (companyCode.equals("C0003")) {
				query = TaxPaymentQueryUtil.accountCategoryListSIN;
			} else if (companyCode.equals("C0004")) {
				query = TaxPaymentQueryUtil.accountCategoryListMA + " union all " + TaxPaymentQueryUtil.getBankForCompany;
			} else if (companyCode.equals("C0002")) {
				query = TaxPaymentQueryUtil.accountCategoryListIND + " union all " + TaxPaymentQueryUtil.getBankForCompany;
			} else {
				query = TaxPaymentQueryUtil.accountCategoryList;
			}

			taxPaymentBeanList = jdbcTemplate.query(query, new BeanPropertyRowMapper<TaxPaymentBean>(TaxPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in disbursement account list page", e);
			throw new CustomException("Error in TaxPaymentDAOImpl in list");
		}
		return taxPaymentBeanList;
	}

	@Override
	public boolean save(TaxPaymentBean vendorNatureObj) throws CustomException {
		boolean isSuccess = false;
		try {
			// String vendorNatureCode =
			// jdbcTemplate.queryForObject(TaxPaymentQueryUtil.GENERATE_TDSTAX_ID,
			// String.class);
			// System.out.println("tds Code-" + vendorNatureCode);
			// vendorNatureObj.setVendorNatureCode(vendorNatureCode);
			// jdbcTemplate.update(TaxPaymentQueryUtil.SAVE_TDSTAX,
			// vendorNatureCode, vendorNatureObj.getVendorCode(),
			// vendorNatureObj.getTdsNatureCode(),
			// vendorNatureObj.getTdsNatureType(), vendorNatureObj.getDate(),
			// vendorNatureObj.getCurrencyCode(),
			// vendorNatureObj.getExchangeRate(),
			// vendorNatureObj.getTdsTaxRate(),
			// vendorNatureObj.getSurchargeExRate(),
			// vendorNatureObj.getEduCessExRate(),
			// vendorNatureObj.getTdsNetAmtLocal(),
			// vendorNatureObj.getTdsNetAmtUsd(),
			// vendorNatureObj.getPurchaseAmountLocal(),
			// vendorNatureObj.getCreditAmountLocal(),
			// vendorNatureObj.getUserId(),
			// vendorNatureObj.getAccountHeadCode(),
			// vendorNatureObj.getAccountHeadCode(), "C0001");
			isSuccess = true;

		} catch (DataAccessException e) {
			System.out.println(e);
			LOGGER.error("Error in disbursement account list page", e);
			throw new CustomException("Error in TaxPaymentDAOImpl save");
		}
		return isSuccess;
	}

	@Override
	public TaxPaymentBean edit(String vendorNatureCode) throws CustomException {
		boolean isSuccess = false;
		TaxPaymentBean tdsNatureBean = null;
		try {
			// tdsNatureBean =
			// jdbcTemplate.queryForObject(TaxPaymentQueryUtil.EDIT_VENDORNATURE,
			// new Object[] { vendorNatureCode }, new
			// BeanPropertyRowMapper<TaxPaymentBean>(TaxPaymentBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in disbursement account list page", e);
			throw new CustomException("Error in TaxPaymentDAOImpl edit");
		}
		return tdsNatureBean;
	}

	@Override
	public boolean updateTds(TaxPaymentBean vendorNatureObj) throws CustomException {
		boolean isSuccess = false;
		try {
			// jdbcTemplate.update(TaxPaymentQueryUtil.UPDATE_TDSTAX,
			// vendorNatureObj.getVendorCode(),
			// vendorNatureObj.getTdsNatureCode(),
			// vendorNatureObj.getTdsNatureType(),
			// vendorNatureObj.getDescription(), vendorNatureObj.getUserId(),
			// vendorNatureObj.getVendorNatureCode());
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in disbursement account list page", e);
			throw new CustomException("Error in TaxPaymentDAOImpl update");
		}
		return isSuccess;
	}

	@Override
	public boolean deleteTdsNature(String vendorNatureCode) throws CustomException {
		boolean isSuccess = false;
		try {
			// jdbcTemplate.update(TaxPaymentQueryUtil.DELETE_VENDORNATURE,
			// vendorNatureCode);
			isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in disbursement account list page", e);
			throw new CustomException("Error in TaxPaymentDAOImpl delete");
		}
		return isSuccess;
	}

}
