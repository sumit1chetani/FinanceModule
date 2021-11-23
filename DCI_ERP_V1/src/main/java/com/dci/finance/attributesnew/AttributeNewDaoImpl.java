package com.dci.finance.attributesnew;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AttributeNewDaoImpl implements AttributeNewDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(AttributeNewDaoImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<AttributeNewBean> getAttributesList() {
		List<AttributeNewBean> lAttributeList = new ArrayList<AttributeNewBean>();
		try {
			lAttributeList = jdbcTemplate.query(AttributeNewQueryUtil.GET_ATTRIBUTE_LIST, new BeanPropertyRowMapper<AttributeNewBean>(AttributeNewBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAttributesList", e);
		}
		return lAttributeList;
	}

	@Override
	public boolean saveAttribute(AttributeNewBean objAttributeBean) {
		boolean isSucess = false;
		try {
			int avail = jdbcTemplate.queryForObject(AttributeNewQueryUtil.CHECK_ATTRIBUTE, new Object[] { objAttributeBean.getAttributeName().toLowerCase() }, Integer.class);
			if (avail == 0) {
				int i = jdbcTemplate.update(AttributeNewQueryUtil.SAVE_ATTRIBUTE, new Object[] { objAttributeBean.getAttributeName(), objAttributeBean.getAttributeValue() });
				if (i > 0)
					isSucess = true;
				else
					isSucess = false;
			} else
				isSucess = false;

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return isSucess;
	}

	@Override
	public boolean deleteAttr(String attr) {
		boolean success = false;
		try {
			int i = jdbcTemplate.update(AttributeNewQueryUtil.DELETE_ATTR, attr);
			if (i > 0)
				success = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in delete", e);
		}
		return success;
	}

	@Override
	public AttributeNewBean editAttribute(String attr) {
		AttributeNewBean editAttribute = new AttributeNewBean();

		try {
			editAttribute = jdbcTemplate.queryForObject(AttributeNewQueryUtil.GET_EDIT_DATA, new Object[] { attr }, new BeanPropertyRowMapper<AttributeNewBean>(AttributeNewBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return editAttribute;

	}

	@Override
	public boolean updateAttribute(AttributeNewBean objAttribute) {

		boolean isSucess = false;
		try {
			if (objAttribute.getAttributeName() != null && !objAttribute.getAttributeName().equalsIgnoreCase("")) {
				int i = jdbcTemplate.update(AttributeNewQueryUtil.UPDATE_ATTRIBUTE, new Object[] { objAttribute.getAttributeValue(), objAttribute.getAttributeName() });
				if (i > 0)
					isSucess = true;
				else
					isSucess = false;
			} else
				isSucess = false;

		} catch (DataAccessException e) {
			LOGGER.error("Error in Update", e);
		}
		return isSucess;

	}

}
