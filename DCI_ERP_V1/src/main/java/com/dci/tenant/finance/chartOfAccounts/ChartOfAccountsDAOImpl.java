package com.dci.tenant.finance.chartOfAccounts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChartOfAccountsDAOImpl implements ChartOfAccountsDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(ChartOfAccountsDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Resource
	private DataSource dataSource;
	@Override
	public List<ChartOfAccountsBean> getGroupHeadList() {
		List<ChartOfAccountsBean> lGroupHeadList = new ArrayList<ChartOfAccountsBean>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lGroupHeadList = jdbcTemplate.query(ChartOfAccountsQueryUtil.GET_GROUP_HEAD_LIST, new BeanPropertyRowMapper<ChartOfAccountsBean>(ChartOfAccountsBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Group Head List", e);
		}
		return lGroupHeadList;
	}

	@Override
	public List<ChartOfAccountsBean> getSubGroupHeadList(String groupHeadCode) {
		List<ChartOfAccountsBean> lSubGroupHeadList = new ArrayList<ChartOfAccountsBean>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lSubGroupHeadList = jdbcTemplate.query(ChartOfAccountsQueryUtil.GET_SUB_GROUP_HEAD_LIST, new Object[] { groupHeadCode }, new BeanPropertyRowMapper<ChartOfAccountsBean>(ChartOfAccountsBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Sub Group Head List", e);
		}
		return lSubGroupHeadList;
	}

	@Override
	public List<ChartOfAccountsBean> getAccountHeadList(String subGroupAcctCode) {
		List<ChartOfAccountsBean> lAccountHeadList = new ArrayList<ChartOfAccountsBean>();

		try {
			jdbcTemplate = new JdbcTemplate(dataSource);

			lAccountHeadList = jdbcTemplate.query(ChartOfAccountsQueryUtil.GET_ACCOUNT_HEAD_LIST, new Object[] { subGroupAcctCode }, new BeanPropertyRowMapper<ChartOfAccountsBean>(ChartOfAccountsBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Sub Group Head List", e);
		}
		return lAccountHeadList;
	}

	@Override
	public List<ChartOfAccountsBean> getChartOfAccountsList() {

		List<ChartOfAccountsBean> lChartofAccountList = new ArrayList<ChartOfAccountsBean>();
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);
			List<ChartOfAccountsBean> lGroupHeadList = new ArrayList<ChartOfAccountsBean>();
			lGroupHeadList = jdbcTemplate.query(ChartOfAccountsQueryUtil.GET_GROUP_HEAD_LIST, new BeanPropertyRowMapper<ChartOfAccountsBean>(ChartOfAccountsBean.class));

			for (ChartOfAccountsBean objChartOfAccountsBean : lGroupHeadList) {
				List<ChartOfAccountsBean> lSubGrpList = new ArrayList<ChartOfAccountsBean>();
				List<ChartOfAccountsBean> lTempSubGrpList = new ArrayList<ChartOfAccountsBean>();
				lTempSubGrpList = jdbcTemplate.query(ChartOfAccountsQueryUtil.GET_SUB_GROUP_HEAD_LIST, new Object[] { objChartOfAccountsBean.getGroupHeadCode() }, new BeanPropertyRowMapper<ChartOfAccountsBean>(ChartOfAccountsBean.class));

				for (ChartOfAccountsBean objChartOfAccountsBeandtl : lTempSubGrpList) {
					List<ChartOfAccountsBean> lAccountHeadList = new ArrayList<ChartOfAccountsBean>();
					lAccountHeadList = jdbcTemplate.query(ChartOfAccountsQueryUtil.GET_ACCOUNT_HEAD_LIST, new Object[] { objChartOfAccountsBeandtl.getSubGroupAcctCode() }, new BeanPropertyRowMapper<ChartOfAccountsBean>(ChartOfAccountsBean.class));
					objChartOfAccountsBeandtl.setlAccountHeadList(lAccountHeadList);
					lSubGrpList.add(objChartOfAccountsBeandtl);
				}
				objChartOfAccountsBean.setlSubGrpList(lSubGrpList);
				lChartofAccountList.add(objChartOfAccountsBean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Sub Group Head List", e);
		}
		return lChartofAccountList;
	}

}
