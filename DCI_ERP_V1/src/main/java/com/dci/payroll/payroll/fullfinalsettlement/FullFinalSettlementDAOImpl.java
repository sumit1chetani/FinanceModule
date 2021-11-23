package com.dci.payroll.payroll.fullfinalsettlement;

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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;



@Repository
public class FullFinalSettlementDAOImpl implements FullFinalSettlementDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(FullFinalSettlementDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<FullFinalSettlementBean> getFullFinalSettlementList(FullFinalSettlementBean finalSettlementBean) throws CustomException {
		List<FullFinalSettlementBean> fullFinalSettlementList = new ArrayList<FullFinalSettlementBean>();
		List<FullFinalSettlementDetailBean> fullFinalSettlementdtList = new ArrayList<FullFinalSettlementDetailBean>();
		try {

			fullFinalSettlementList = jdbcTemplate.query(FullFinalSettlementQueryUtil.FINAL_SETTLEMENT_LIST, new BeanPropertyRowMapper<FullFinalSettlementBean>(FullFinalSettlementBean.class), finalSettlementBean.getEmployeeId());

			for (FullFinalSettlementBean obj : fullFinalSettlementList) {

				fullFinalSettlementdtList = jdbcTemplate.query(FullFinalSettlementQueryUtil.FINAL_SETTLEMENT_DETAIL_LIST, new BeanPropertyRowMapper<FullFinalSettlementDetailBean>(FullFinalSettlementDetailBean.class), obj.getEmployeeFinalSettlementId());
				obj.setDetailList(fullFinalSettlementdtList);
			}

			return fullFinalSettlementList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in FullFinalSettlementDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean save(FullFinalSettlementBean finalSettlementBean) {
		// TODO Auto-generated method stub

		boolean isSuccess = false;
		FullFinalSettlementBean fullFinalSettlementBean = new FullFinalSettlementBean();

		List<FullFinalSettlementBean> fullFinalSettlementList = new ArrayList<FullFinalSettlementBean>();

		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Map<String, Object> finalsettlementMap = new HashMap<String, Object>();
		finalsettlementMap.put("emp_id", finalSettlementBean.getEmployeeId());
		finalsettlementMap.put("created_date", finalSettlementBean.getCreatedDate());
		finalsettlementMap.put("created_by", teampUser.getUserId());
		finalsettlementMap.put("status", "Pending");

		fullFinalSettlementList = jdbcTemplate.query(FullFinalSettlementQueryUtil.GET_FINAL_SETTLEMENT_HDR_ID, new BeanPropertyRowMapper<FullFinalSettlementBean>(FullFinalSettlementBean.class), finalSettlementBean.getEmployeeId());

		if (fullFinalSettlementList.size() == 0) {

			namedParameterJdbcTemplate.update(FullFinalSettlementQueryUtil.INSERT_FINAL_SETTLEMENT, finalsettlementMap);

			fullFinalSettlementBean = jdbcTemplate.queryForObject(FullFinalSettlementQueryUtil.GET_FINAL_SETTLEMENT_HDR_ID, new Object[] { finalSettlementBean.getEmployeeId() }, new BeanPropertyRowMapper<FullFinalSettlementBean>(FullFinalSettlementBean.class));

			if (fullFinalSettlementBean.getEmployeeFinalSettlementId() > 0) {
				isSuccess = true;
				Map<String, Object> finalsettlementDtlMap;
				for (FullFinalSettlementDetailBean objdetailbean : finalSettlementBean.getDetailList()) {
					finalsettlementDtlMap = new HashMap<String, Object>();
					finalsettlementDtlMap.put("credit", objdetailbean.getCredit());
					finalsettlementDtlMap.put("debit", objdetailbean.getDebit());
					finalsettlementDtlMap.put("description", objdetailbean.getDescription());
					finalsettlementDtlMap.put("employee_final_settlement_id", fullFinalSettlementBean.getEmployeeFinalSettlementId());

					namedParameterJdbcTemplate.update(FullFinalSettlementQueryUtil.INSERT_FINAL_DETAIL_SETTLEMENT, finalsettlementDtlMap);
				}
			}
		} else {
			if (fullFinalSettlementList.size() > 0) {

				fullFinalSettlementBean = jdbcTemplate.queryForObject(FullFinalSettlementQueryUtil.GET_FINAL_SETTLEMENT_HDR_ID, new Object[] { finalSettlementBean.getEmployeeId() }, new BeanPropertyRowMapper<FullFinalSettlementBean>(FullFinalSettlementBean.class));

				if (fullFinalSettlementBean.getEmployeeFinalSettlementId() > 0) {

					jdbcTemplate.update(FullFinalSettlementQueryUtil.DELETE_SETTLEMENT_DETAIL_ID, fullFinalSettlementBean.getEmployeeFinalSettlementId());

					isSuccess = true;
					Map<String, Object> finalsettlementDtlMap;
					for (FullFinalSettlementDetailBean objdetailbean : finalSettlementBean.getDetailList()) {
						finalsettlementDtlMap = new HashMap<String, Object>();
						finalsettlementDtlMap.put("credit", objdetailbean.getCredit());
						finalsettlementDtlMap.put("debit", objdetailbean.getDebit());
						finalsettlementDtlMap.put("description", objdetailbean.getDescription());
						finalsettlementDtlMap.put("employee_final_settlement_id", fullFinalSettlementBean.getEmployeeFinalSettlementId());

						namedParameterJdbcTemplate.update(FullFinalSettlementQueryUtil.INSERT_FINAL_DETAIL_SETTLEMENT, finalsettlementDtlMap);
					}
				}
			}
		}

		return isSuccess;
	}

	@Override
	public boolean approve(FullFinalSettlementBean finalSettlementBean) {

		boolean isSuccess = false;

		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Map<String, Object> finalsettlementMap = new HashMap<String, Object>();
		finalsettlementMap.put("emp_id", finalSettlementBean.getEmployeeId());
		finalsettlementMap.put("approved_date", finalSettlementBean.getCreatedDate());
		finalsettlementMap.put("approved_by", teampUser.getUserId());
		finalsettlementMap.put("status", "Approved");

		namedParameterJdbcTemplate.update(FullFinalSettlementQueryUtil.UPDATE_FINAL_SETTLEMENT, finalsettlementMap);
		isSuccess = true;

		return isSuccess;

	}
}