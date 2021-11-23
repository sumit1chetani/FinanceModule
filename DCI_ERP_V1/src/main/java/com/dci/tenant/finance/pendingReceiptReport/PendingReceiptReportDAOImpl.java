package com.dci.tenant.finance.pendingReceiptReport;

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

@Repository
public class PendingReceiptReportDAOImpl implements PendingReceiptReportDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final static Logger LOGGER = LoggerFactory.getLogger(PendingReceiptReportDAOImpl.class);

	@Override
	public PendingReceiptReportResultBean getList() throws Exception {
		PendingReceiptReportResultBean pendingReceiptReportResultBean = new PendingReceiptReportResultBean();
		List<PendingReceiptReportBean> receiptReportlist = new ArrayList<PendingReceiptReportBean>();
		try {
			receiptReportlist = jdbcTemplate.query(PendingReceiptReportQueryUtil.SELECT_LIST, new BeanPropertyRowMapper<PendingReceiptReportBean>(PendingReceiptReportBean.class));
			pendingReceiptReportResultBean.setReportBeanList(receiptReportlist);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getTaxPayerTypeList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return pendingReceiptReportResultBean;
	}

	@Override
	public PendingReceiptReportBean getCustomerDetails(String customerCode) throws Exception {
		PendingReceiptReportBean pendingReceiptReportBean = new PendingReceiptReportBean();
		// TODO Auto-generated method stub
		pendingReceiptReportBean = jdbcTemplate.queryForObject(PendingReceiptReportQueryUtil.CUSTOMER_LIST, new Object[] { customerCode }, new BeanPropertyRowMapper<PendingReceiptReportBean>(PendingReceiptReportBean.class));

		return pendingReceiptReportBean;
	}

}
