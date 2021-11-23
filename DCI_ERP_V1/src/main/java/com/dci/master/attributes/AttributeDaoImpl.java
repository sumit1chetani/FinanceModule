package com.dci.master.attributes;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AttributeDaoImpl implements AttributeDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(AttributeDaoImpl.class);
	@Autowired
	DataSource dataSource;

	@Override
	public List<AttributeBean> getAttributesList() {
		List<AttributeBean> lAttributeList = new ArrayList<AttributeBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lAttributeList = jdbcTemplate.query(AttributeQueryUtil.GET_ATTRIBUTE_LIST, new BeanPropertyRowMapper<AttributeBean>(AttributeBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in getAttributesList", e);
		}
		return lAttributeList;
	}

	@Override
	public boolean saveAttribute(AttributeBean objAttributeBean) {
		boolean isSucess = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int i = jdbcTemplate.update(AttributeQueryUtil.SAVE_ATTRIBUTE, new Object[] { objAttributeBean.getAttributeName(), objAttributeBean.getAttributeValue() });
			if (i > 0)
				isSucess = true;
			else
				isSucess = false;
		} catch (DataAccessException e) {
			LOGGER.error("Error in ", e);
		}
		return isSucess;
	}

}
