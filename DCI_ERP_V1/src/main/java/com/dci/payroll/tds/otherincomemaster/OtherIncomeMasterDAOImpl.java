package com.dci.payroll.tds.otherincomemaster;

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
public class OtherIncomeMasterDAOImpl implements OtherIncomeMasterDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(OtherIncomeMasterDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource datasource;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<OtherIncomeMasterBean> getOtherIncomeMasterList() throws CustomException {
		List<OtherIncomeMasterBean> getOtherIncomeMasterList = new ArrayList<OtherIncomeMasterBean>();
		try {
			getOtherIncomeMasterList = jdbcTemplate.query(OtherIncomeMasterQueryUtil.SELECT_OtherIncomeMaster, new BeanPropertyRowMapper<OtherIncomeMasterBean>(OtherIncomeMasterBean.class));
			return getOtherIncomeMasterList;
		} catch (DataAccessException e) {
			LOGGER.error("Error in OtherIncomeMasterDAOImpl", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
	}
}