package com.dci.tenant.finance.ManageCostCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ManageCostCenterDAOImpl implements ManageCostCenterDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(ManageCostCenterDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public boolean insertManageCostCenter(ManageCostCenterBean manageCostCenterBean) throws Exception {
		boolean isSuccess = false;

		try {

			Map<String, Object> manageCostCenterMap = new HashMap<>();
			manageCostCenterMap.put("company_id", manageCostCenterBean.getCompanyId());
			manageCostCenterMap.put("cost_center_name", manageCostCenterBean.getCostCenterName());
			manageCostCenterMap.put("cost_center_code", manageCostCenterBean.getCostCenterCode());
			manageCostCenterMap.put("cost_center_description", manageCostCenterBean.getCostCenterDescription());
			manageCostCenterMap.put("status", manageCostCenterBean.isStatus());
			namedParameterJdbcTemplate.update(ManageCostCenterQueryUtil.INSERT_COST_CENTER, manageCostCenterMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in insertTaxSubSection", e.getMessage());
			throw new CustomException(ErrorMessage.ERROR_LIST);

		}
		return isSuccess;
	}

	@Override
	public List<ManageCostCenterBean> getList() throws Exception {
		List<ManageCostCenterBean> manageCostCenterList = new ArrayList<>();
		try {
			manageCostCenterList = jdbcTemplate.query(ManageCostCenterQueryUtil.COST_CENTER_LIST, new BeanPropertyRowMapper<>(ManageCostCenterBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in taxSubSectionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return manageCostCenterList;
	}

	@Override
	public boolean deleteManageCostCenter(Integer costCenterId) throws Exception {
		boolean isSuccess = false;
		try {
			jdbcTemplate.update(ManageCostCenterQueryUtil.DELETE_COST_CENTER, costCenterId);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteTaxSubSection", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		// TODO Auto-generated method stub
		return isSuccess;
	}

	@Override
	public ManageCostCenterBean editManageCostCenter(Integer costCenterId) throws Exception {
		ManageCostCenterBean manageCostCenterBean = new ManageCostCenterBean();
		try {
			manageCostCenterBean = jdbcTemplate.queryForObject(ManageCostCenterQueryUtil.COST_CENTER_BY_ID, new Object[] { costCenterId }, new BeanPropertyRowMapper<>(ManageCostCenterBean.class));
			manageCostCenterBean.setisEdit(true);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getcostCenterId", e);
			manageCostCenterBean.setisEdit(false);
			return manageCostCenterBean;
		}
		// TODO Auto-generated method stub
		return manageCostCenterBean;
	}

	@Override
	public boolean updateManageCostCenter(ManageCostCenterBean manageCostCenterBean) throws Exception {
		boolean isSuccess = false;
		try {
			Map<String, Object> manageCostCenterMap = new HashMap<>();
			manageCostCenterMap.put("company_id", manageCostCenterBean.getCompanyId());
			manageCostCenterMap.put("cost_center_name", manageCostCenterBean.getCostCenterName());
			manageCostCenterMap.put("cost_center_id", manageCostCenterBean.getCostCenterId());
			manageCostCenterMap.put("cost_center_code", manageCostCenterBean.getCostCenterCode());
			manageCostCenterMap.put("cost_center_description", manageCostCenterBean.getCostCenterDescription());
			manageCostCenterMap.put("status", manageCostCenterBean.isStatus());
			namedParameterJdbcTemplate.update(ManageCostCenterQueryUtil.UPDATE_COST_CENTER, manageCostCenterMap);
			isSuccess = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in taxSubSectionList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return isSuccess;
	}

}
