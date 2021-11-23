package com.dci.tenant.finance.payableAgewise;

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

@Repository
public class PayableAgewiseDAOImpl implements PayableAgewiseDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static Logger LOGGER = LoggerFactory.getLogger(PayableAgewiseDAOImpl.class);

	@Override
	public List<PayableAgewiseBean> getPayableAgewiseReport(String sDate) {
		List<PayableAgewiseBean> lPayableAgewiseList = new ArrayList<PayableAgewiseBean>();
		try {
			lPayableAgewiseList = jdbcTemplate.query(PayableAgewiseQueryUtil.GET_PAYABLE_AGEWISE_LIST, new Object[] { CommonUtil.convertSqlDateFormat(sDate) }, new BeanPropertyRowMapper<PayableAgewiseBean>(PayableAgewiseBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Getting Payable agewise List", e);
		}
		return lPayableAgewiseList;
	}

	@Override
	public List<PayableAgewiseBean> getPayableAgewiseReportDtl(PayableAgewiseBean objPayableAgewiseBean) {
		List<PayableAgewiseBean> lPayableAgewiseDtlList = new ArrayList<PayableAgewiseBean>();
		try {

			lPayableAgewiseDtlList = jdbcTemplate.query(PayableAgewiseQueryUtil.GET_PAYABLE_AGEWISE_DTL_LIST, new Object[] { CommonUtil.convertSqlDateFormat(objPayableAgewiseBean.getApDate()), objPayableAgewiseBean.getSupplierCode(), CommonUtil.convertSqlDateFormat(objPayableAgewiseBean.getApDate()), objPayableAgewiseBean.getSupplierCode(), CommonUtil.convertSqlDateFormat(objPayableAgewiseBean.getApDate()) }, new BeanPropertyRowMapper<PayableAgewiseBean>(PayableAgewiseBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Getting Payable agewise List", e);
		}
		return lPayableAgewiseDtlList;
	}

	@Override
	public List<PayableAgewiseBean> getPayableAgewiseListForExcel(String sDate) {
		List<PayableAgewiseBean> lPayableAgewiseList = new ArrayList<PayableAgewiseBean>();

		try {
			List<PayableAgewiseBean> lPayableAgewiseTempList = new ArrayList<PayableAgewiseBean>();
			lPayableAgewiseTempList = getPayableAgewiseReport(sDate);
			for (PayableAgewiseBean objPayableAgewiseTempBean : lPayableAgewiseTempList) {
				List<PayableAgewiseBean> lPayableAgewiseDtlList = new ArrayList<PayableAgewiseBean>();
				objPayableAgewiseTempBean.setApDate(sDate);
				lPayableAgewiseDtlList = getPayableAgewiseReportDtl(objPayableAgewiseTempBean);
				objPayableAgewiseTempBean.setlPayableAgewiseDtlList(lPayableAgewiseDtlList);
				lPayableAgewiseList.add(objPayableAgewiseTempBean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Getting Payable agewise List", e);
		}

		return lPayableAgewiseList;

	}
}
