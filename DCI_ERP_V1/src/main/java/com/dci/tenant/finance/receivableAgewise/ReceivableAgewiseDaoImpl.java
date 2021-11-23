package com.dci.tenant.finance.receivableAgewise;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CommonUtil;
import com.dci.tenant.finance.payableAgewise.PayableAgewiseDAOImpl;

@Repository
public class ReceivableAgewiseDaoImpl implements ReceivableAgewiseDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static Logger LOGGER = LoggerFactory.getLogger(PayableAgewiseDAOImpl.class);

	@Override
	public List<ReceivableAgewiseBean> getReceivableAgewiseReport(String sDate) {
		List<ReceivableAgewiseBean> lPayableAgewiseList = new ArrayList<ReceivableAgewiseBean>();
		try {
			lPayableAgewiseList = jdbcTemplate.query(ReceivableAgewiseQueryUtil.GET_RECEIVABLE_AGEWISE_LIST, new Object[] { CommonUtil.convertSqlDateFormat(sDate) }, new BeanPropertyRowMapper<ReceivableAgewiseBean>(ReceivableAgewiseBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Getting Payable agewise List", e);
		}
		return lPayableAgewiseList;
	}

	@Override
	public List<ReceivableAgewiseBean> getReceivableAgewiseReportDtl(ReceivableAgewiseBean objReceivableAgewiseBean) {
		List<ReceivableAgewiseBean> lreceivableAgewiseDtlList = new ArrayList<ReceivableAgewiseBean>();
		try {
			lreceivableAgewiseDtlList = jdbcTemplate.query(ReceivableAgewiseQueryUtil.GET_RECEIVABLE_AGEWISE_DTL_LIST, new Object[] { CommonUtil.convertSqlDateFormat(objReceivableAgewiseBean.getArDate()), objReceivableAgewiseBean.getCustomerCode(), CommonUtil.convertSqlDateFormat(objReceivableAgewiseBean.getArDate()), objReceivableAgewiseBean.getCustomerCode(), CommonUtil.convertSqlDateFormat(objReceivableAgewiseBean.getArDate()), objReceivableAgewiseBean.getCustomerCode(), objReceivableAgewiseBean.getCustomerCode() },
					new BeanPropertyRowMapper<ReceivableAgewiseBean>(ReceivableAgewiseBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Getting Payable agewise List", e);
		}
		return lreceivableAgewiseDtlList;
	}

	@Override
	public List<ReceivableAgewiseBean> getReceivableAgewiseListForExcel(String sDate) {
		List<ReceivableAgewiseBean> lReceivableAgewiseList = new ArrayList<ReceivableAgewiseBean>();

		try {
			List<ReceivableAgewiseBean> lReceivableAgewiseTempList = new ArrayList<ReceivableAgewiseBean>();
			lReceivableAgewiseTempList = getReceivableAgewiseReport(sDate);
			for (ReceivableAgewiseBean objReceivableAgewiseBean : lReceivableAgewiseTempList) {
				List<ReceivableAgewiseBean> lPayableAgewiseDtlList = new ArrayList<ReceivableAgewiseBean>();
				objReceivableAgewiseBean.setArDate(sDate);
				lPayableAgewiseDtlList = getReceivableAgewiseReportDtl(objReceivableAgewiseBean);
				objReceivableAgewiseBean.setlReceivableAgewiseDtlList(lPayableAgewiseDtlList);
				lReceivableAgewiseList.add(objReceivableAgewiseBean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Getting Receivable agewise List", e);
		}

		return lReceivableAgewiseList;

	}
}
