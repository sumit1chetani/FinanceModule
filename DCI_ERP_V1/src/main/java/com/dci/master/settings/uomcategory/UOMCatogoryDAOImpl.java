package com.dci.master.settings.uomcategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

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
public class UOMCatogoryDAOImpl implements UOMCatogoryDAO {

	private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UOMCatogoryDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	@Override
	public List<UOMCatogoryBean> getUOMCategoryList() throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<UOMCatogoryBean> UOMCategoryList = new ArrayList<UOMCatogoryBean>();
		try {
			UOMCategoryList = jdbcTemplate.query(UOMCatogoryQueryUtil.UOMCategory_LIST, new BeanPropertyRowMapper<UOMCatogoryBean>(UOMCatogoryBean.class), userDetails.getCompanyCode());
			return UOMCategoryList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in getManageUOMList", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean insertUOMCategory(UOMCatogoryBean manageUOM) throws CustomException {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean isSuccess = false;
		int i = 1;
		try {
			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UOMCatogoryBean objBean = manageUOM.getUomcategoryData();
			HashMap<String, Object> unitMap = new HashMap<String, Object>();

			unitMap.put("uomCategoryId", objBean.getUomcategoryId());
			unitMap.put("uomCategoryName", objBean.getUomcategoryName());
			unitMap.put("uomCategoryDesc", objBean.getUomcategoryDesc());
			unitMap.put("status", objBean.isStatus());
			unitMap.put("companyId", user.getCompanyCode());
			i = jdbcTemplate.queryForObject(UOMCatogoryQueryUtil.CHECK_COUNT_INSERT,Integer.class, objBean.getUomcategoryName(), userDetails.getCompanyCode());
			if (i == 0) {
				namedParameterJdbcTemplate.update(UOMCatogoryQueryUtil.INSERT_UOMCATEGORY, unitMap);
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteDesignation", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public void deleteUOMCategory(Integer UOMCategoryId) throws CustomException {
		try {
			jdbcTemplate.update(UOMCatogoryQueryUtil.DELETE_UOMCATEGORY, UOMCategoryId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteDesignation", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}

	}

	@Override
	public UOMCatogoryBean getAutoGenarateValues() {
		UOMCatogoryBean objBean = new UOMCatogoryBean();
		try {
			objBean.setUomcategoryId(getAutoGenerateNumber());
		} catch (Exception ae) {
			ae.printStackTrace();
		}
		return objBean;
	}

	private String getAutoGenerateNumber() {
		String autogenerateNumber = "";
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			autogenerateNumber = jdbcTemplate.queryForObject(UOMCatogoryQueryUtil.sGenerateAutoNumber, String.class);
		} catch (DataAccessException ae) {
			ae.printStackTrace();
		}
		return autogenerateNumber;
	}

	@Override
	public UOMCatogoryBean uomCategoryEditList(int uomId) throws Exception {
		UOMCatogoryBean objUomCatogoryBean = new UOMCatogoryBean();
		try {
			objUomCatogoryBean = jdbcTemplate.queryForObject(UOMCatogoryQueryUtil.UOMCategory_EDIT_LIST, new BeanPropertyRowMapper<UOMCatogoryBean>(UOMCatogoryBean.class), new Object[] { uomId });

		} catch (DataAccessException e) {
			LOGGER.error("Error in Edit", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return objUomCatogoryBean;
	}

	@Override
	public boolean updateUOMCategory(UOMCatogoryBean objUomCatogoryBean) throws Exception {

		boolean isSuccess = false;
		int i = 0;
		try {
			UOMCatogoryBean objBean = objUomCatogoryBean.getUomcategoryData();
			HashMap<String, Object> unitMap = new HashMap<String, Object>();

			unitMap.put("uomCategoryId", objBean.getUomcategoryId());
			unitMap.put("uomCategoryName", objBean.getUomcategoryName());
			unitMap.put("uomCategoryDesc", objBean.getUomcategoryDesc());
			unitMap.put("status", objBean.isStatus());
			unitMap.put("uomId", objBean.getUomId());

			i = namedParameterJdbcTemplate.update(UOMCatogoryQueryUtil.UPDATE_UOMCATEGORY, unitMap);
			if (i != 0) {
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in deleteDesignation", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public int checkCatgeoryName(String categoryName) throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		int categoryId = 0;
		try {
			categoryId = jdbcTemplate.queryForObject(UOMCatogoryQueryUtil.sCheckCategoryName, Integer.class , categoryName );
		} catch (DataAccessException e) {
			LOGGER.error("Error in Check Category Name", e);
		}

		return categoryId;

	}

}
