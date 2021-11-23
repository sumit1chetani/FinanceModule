package com.dci.tenant.finance.grouphead;

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

import com.dci.common.util.CustomException;

@Repository
public class GroupHeadMasterDAOImpl implements GroupHeadMasterDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(GroupHeadMasterDAOImpl.class);

	@Autowired
	DataSource dataSource;

	@Override
	public List<GroupHeadMasterListBean> getGroupHeadMasterList(int limit, int offset) throws Exception {
		// TODO Auto-generated method stub

		List<GroupHeadMasterListBean> grpHeadMasterBean = new ArrayList<GroupHeadMasterListBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			grpHeadMasterBean = jdbcTemplate.query(GroupHeadMasterQueryUtil.sGetGroupHeadList, new BeanPropertyRowMapper<GroupHeadMasterListBean>(GroupHeadMasterListBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Group Head Master", e);
			throw new CustomException("Error in Get Group Head Master");
		}
		return grpHeadMasterBean;

	}

}
