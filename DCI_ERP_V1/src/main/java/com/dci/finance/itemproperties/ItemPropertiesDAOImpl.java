package com.dci.finance.itemproperties;

import java.sql.Types;
import java.util.ArrayList;
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

import com.dci.common.util.CommonUtil;
import com.dci.common.util.CustomException;
import com.dci.common.util.ErrorMessage;
import com.dci.tenant.user.UserDetail;

@Repository
public class ItemPropertiesDAOImpl implements ItemPropertiesDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ItemPropertiesDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public boolean deleteItemProperties(String itemPropertiesId) throws Exception {

		boolean issucces = false;
		int value = 0;
		try {

			value = jdbcTemplate.update(ItemPropertiesQueryUtil.deleteItemProperties, Integer.valueOf(itemPropertiesId));

			if (value != 0) {
				issucces = true;
			}

		} catch (Exception e) {
			LOGGER.error("Error in Delete", e);
			throw new CustomException(ErrorMessage.ERROR_DELETE);
		}
		return issucces;
	}

	@Override
	public List<ItemPropertiesBean> getItemPropertiesList() throws Exception {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<ItemPropertiesBean> manageItemPropertiesList = new ArrayList<ItemPropertiesBean>();
		try {
			manageItemPropertiesList = jdbcTemplate.query(ItemPropertiesQueryUtil.GetManageItemPropertiesList, new BeanPropertyRowMapper<ItemPropertiesBean>(ItemPropertiesBean.class), userDetails.getCompanyCode());
			return manageItemPropertiesList;

		} catch (DataAccessException e) {
			LOGGER.error("Error in List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public boolean addItemProperties(ItemPropertiesBean objItemPropertiesBean) throws Exception {

		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		boolean issucces = false;
		int value = 0, propValue = 0, propLength = 0;
		boolean mandatory = false;
		String defaultValue = "";

		try {

			java.sql.Timestamp date = CommonUtil.getCurrentTimeStamp();

			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if (objItemPropertiesBean.getManditory().equals("Y")) {
				mandatory = true;
			} else {
				mandatory = false;
			}

			if (objItemPropertiesBean.getPropValue() == "") {
				propValue = 0;
			} else {
				propValue = Integer.valueOf(objItemPropertiesBean.getPropValue());
			}

			if (objItemPropertiesBean.getPropLength() == "") {
				propLength = 0;
			} else {
				propLength = Integer.valueOf(objItemPropertiesBean.getPropLength());
			}

			if (objItemPropertiesBean.getDefaultsValue() == "") {
				defaultValue = "";
			} else {
				defaultValue = objItemPropertiesBean.getDefaultsValue();
			}

			int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.BOOLEAN, Types.VARCHAR, Types.DATE, Types.VARCHAR };
			Object[] params = new Object[] { objItemPropertiesBean.getTypeId(), objItemPropertiesBean.getPropertyTypeId(), objItemPropertiesBean.getPropName(), propLength, propValue, defaultValue, mandatory, user.getUserId(), date, user.getCompanyCode() };

			value = jdbcTemplate.update(ItemPropertiesQueryUtil.sAddItemProperties, params, types);

			if (value != 0) {
				issucces = true;
			}

		} catch (Exception e) {
			LOGGER.error("Error in Add Item Properties", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return issucces;

	}

	@Override
	public ItemPropertiesResultBean getDefaultValueList() throws Exception {
		ItemPropertiesResultBean objItemPropertiesResultBean = new ItemPropertiesResultBean();
		List<ItemPropertiesBean> typeList = new ArrayList<ItemPropertiesBean>();
		try {
			typeList = jdbcTemplate.query(ItemPropertiesQueryUtil.sDefaultValueList, new BeanPropertyRowMapper<ItemPropertiesBean>(ItemPropertiesBean.class));
			objItemPropertiesResultBean.setTypeList(typeList);
			objItemPropertiesResultBean.setSuccess(true);
			return objItemPropertiesResultBean;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Expense Account List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}

	@Override
	public ItemPropertiesBean getEditList(int itemPropertiesId) throws Exception {

		ItemPropertiesBean objItemPropertiesBean = new ItemPropertiesBean();
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(ItemPropertiesQueryUtil.SELECT_ITEM_PROPERTIES_BY_ID, new Object[] { itemPropertiesId });

			for (Map row : rows) {

				objItemPropertiesBean.setItemPropertiesId(String.valueOf((int) row.get("itemPropertiesId")));
				objItemPropertiesBean.setTypeId(String.valueOf((int) row.get("typeId")));
				objItemPropertiesBean.setPropertyTypeId(String.valueOf((int) row.get("propertyTypeId")));
				objItemPropertiesBean.setPropName((String) row.get("propName"));

				if ((int) row.get("propValue") != 0) {
					objItemPropertiesBean.setPropValue(String.valueOf((int) row.get("propValue")));
				} else {
					objItemPropertiesBean.setPropValue("");
				}

				if ((int) row.get("propLength") != 0) {
					objItemPropertiesBean.setPropLength(String.valueOf((int) row.get("propLength")));
				} else {
					objItemPropertiesBean.setPropLength("");
				}

				objItemPropertiesBean.setDefaultsValue((String) row.get("defaultsValue"));
				objItemPropertiesBean.setManditory((String) row.get("manditory"));

			}

		} catch (Exception e) {
			LOGGER.error("Error in Get Item Properties Edit List", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}

		return objItemPropertiesBean;
	}

	@Override
	public boolean updateItemProperties(ItemPropertiesBean objItemPropertiesBean) throws Exception {

		boolean issucces = false;
		int value = 0, propValue = 0, propLength = 0;
		boolean mandatory = false;
		String defaultValue = "";

		try {

			java.sql.Timestamp date = CommonUtil.getCurrentTimeStamp();

			UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			if (objItemPropertiesBean.getManditory().equals("Y")) {
				mandatory = true;
			} else {
				mandatory = false;
			}

			if (objItemPropertiesBean.getPropValue() == "") {
				propValue = 0;
			} else {
				propValue = Integer.valueOf(objItemPropertiesBean.getPropValue());
			}

			if (String.valueOf(objItemPropertiesBean.getPropLength()) == null || objItemPropertiesBean.getPropLength() == " " || objItemPropertiesBean.getPropLength() == "") {
				propLength = 0;
			} else {
				propLength = Integer.valueOf(objItemPropertiesBean.getPropLength());
			}

			if (String.valueOf(objItemPropertiesBean.getDefaultsValue()) == null || objItemPropertiesBean.getDefaultsValue() == "") {
				defaultValue = "";
			} else {
				defaultValue = objItemPropertiesBean.getDefaultsValue();
			}

			int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.BOOLEAN, Types.VARCHAR, Types.DATE, Types.INTEGER };
			Object[] params = new Object[] { objItemPropertiesBean.getTypeId(), objItemPropertiesBean.getPropertyTypeId(), objItemPropertiesBean.getPropName(), propLength, propValue, defaultValue, mandatory, user.getUserId(), date, objItemPropertiesBean.getItemPropertiesId() };

			value = jdbcTemplate.update(ItemPropertiesQueryUtil.sUpdateItemProperties, params, types);

			if (value != 0) {
				issucces = true;
			}

		} catch (Exception e) {
			LOGGER.error("Error in Update Item Properties", e);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}

		return issucces;

	}

}
