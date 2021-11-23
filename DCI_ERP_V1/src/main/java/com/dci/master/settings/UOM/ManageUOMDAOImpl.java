package com.dci.master.settings.UOM;

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
public class ManageUOMDAOImpl implements ManageUOMDAO {
	private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ManageUOMDAOImpl.class);

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
	public boolean insertManageUOM(ManageUOM manageUOM) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {
			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			HashMap<String, Object> unitMap = new HashMap<String, Object>();

			unitMap.put("uomName", manageUOM.getUomName());
			unitMap.put("uomDescription", manageUOM.getUomDescription());
			unitMap.put("uomCategoryId", manageUOM.getUomCategoryId());
			unitMap.put("createdBy", user.getUserId());
			unitMap.put("createdDate", getCurrentTimeStamp());
			unitMap.put("companyId", user.getCompanyCode());

			i = jdbcTemplate.queryForObject(ManageUOMQueryUtil.CHECK_COUNT_INSERT,Integer.class, manageUOM.getUomName(), user.getCompanyCode());
			if (i == 0) {
				namedParameterJdbcTemplate.update(ManageUOMQueryUtil.INSERT_UOM, unitMap);
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Insert UOM", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return isSuccess;
	}

	@Override
	public ManageUOM getManageUOMById(Integer manageUOMId) throws CustomException {
		ManageUOM manageUOM = null;
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		try {
			manageUOM = jdbcTemplate.queryForObject(ManageUOMQueryUtil.SELECT_UOM_BY_ID, new BeanPropertyRowMapper<ManageUOM>(ManageUOM.class), manageUOMId);

		} catch (DataAccessException e) {
			LOGGER.error("Error in getManageUOMEdit", e);
			throw new CustomException(ErrorMessage.ERROR_EDIT);
		}
		return manageUOM;
	}

	@Override
	public boolean updateManageUOM(ManageUOM manageUOM) throws CustomException {

		boolean isSuccess = false;
		int i = 1;
		try {
			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			HashMap<String, Object> unitMap = new HashMap<String, Object>();

			unitMap.put("uomName", manageUOM.getUomName());
			unitMap.put("uomDescription", manageUOM.getUomDescription());
			unitMap.put("uomCategoryId", manageUOM.getUomCategoryId());
			unitMap.put("modifiedBy", user.getUserId());
			unitMap.put("modifiedDate", getCurrentTimeStamp());
			unitMap.put("uomId", manageUOM.getUomId());

			i = jdbcTemplate.queryForObject(ManageUOMQueryUtil.CHECK_COUNT_UPDATE,Integer.class, manageUOM.getUomId(), manageUOM.getUomName());
			if (i == 0) {
				namedParameterJdbcTemplate.update(ManageUOMQueryUtil.UPDATE_UOM, unitMap);
				isSuccess = true;
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Update UOM", e);
			throw new CustomException(ErrorMessage.ERROR_UPDATE);
		}

		return isSuccess;
	}

	@Override
	public void deleteManageUOM(Integer manageUOMId) throws CustomException {
		try {
			jdbcTemplate.update(ManageUOMQueryUtil.DELETE_UOM, manageUOMId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in delete UOM", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}

	}

	@Override
	public List<ManageUOM> getManageUOMList() throws CustomException {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ManageUOM> manageUOMList = new ArrayList<ManageUOM>();
		try {
			manageUOMList = jdbcTemplate.query(ManageUOMQueryUtil.SELECT_UOM_LIST, new BeanPropertyRowMapper<ManageUOM>(ManageUOM.class), user.getCompanyCode());
			return manageUOMList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Manage UOM List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ManageUOMResultBean getUOMCategoryList() throws CustomException {
		ManageUOMResultBean objManageUOMResultBean = new ManageUOMResultBean();
		List<ManageUOM> uomCategoryList = new ArrayList<ManageUOM>();
		try {
			uomCategoryList = jdbcTemplate.query(ManageUOMQueryUtil.sGetUOMCategoryList, new BeanPropertyRowMapper<ManageUOM>(ManageUOM.class));
			objManageUOMResultBean.setUomCategoryList(uomCategoryList);
			objManageUOMResultBean.setSuccess(true);
			return objManageUOMResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in UOM Category List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public int checkBaseUOM(ManageUOM manageUOM) throws CustomException {
		int uomId = 0;
		try {

			uomId = jdbcTemplate.queryForObject(ManageUOMQueryUtil.sCheckBaseUOM, Integer.class  ,manageUOM.getUomCategoryId() );

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check Base UOM", e);
		}

		return uomId;

	}

	@Override
	public ManageUOMResultBean getUOMCategList() throws CustomException {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		ManageUOMResultBean objManageUOMResultBean = new ManageUOMResultBean();
		List<ManageUOM> uomCategoryList = new ArrayList<ManageUOM>();
		try {
			uomCategoryList = jdbcTemplate.query(ManageUOMQueryUtil.sGetUOMCategList, new BeanPropertyRowMapper<ManageUOM>(ManageUOM.class), user.getCompanyCode());
			objManageUOMResultBean.setUomCategoryList(uomCategoryList);
			objManageUOMResultBean.setSuccess(true);
			return objManageUOMResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in UOM Category List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public int checkUOMName(String uomName) throws CustomException {
		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		int uomNameExist = 0;
		try {

			uomNameExist = jdbcTemplate.queryForObject(ManageUOMQueryUtil.sCheckUOMName, Integer.class , uomName, user.getCompanyCode() );

		} catch (DataAccessException e) {
			LOGGER.error("Error in Check UOM Name", e);
		}

		return uomNameExist;

	}

}
