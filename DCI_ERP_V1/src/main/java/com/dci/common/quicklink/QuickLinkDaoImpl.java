package com.dci.common.quicklink;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("tenantTransactionManager")
public class QuickLinkDaoImpl implements QuickLinkDao {

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<QuickLinkBean> getqlList() {
		List<QuickLinkBean> list = new ArrayList<QuickLinkBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(QuickLinkQueryUtil.getqlList,new BeanPropertyRowMapper<QuickLinkBean>(QuickLinkBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public QuickLinkBean getqlDtl(Integer id) {
		QuickLinkBean list = null;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(QuickLinkQueryUtil.getqlDtl,new Object[] { id },new BeanPropertyRowMapper<QuickLinkBean>(QuickLinkBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public QuickLinkBean getBookingNo(String id) {
		QuickLinkBean list = null;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(QuickLinkQueryUtil.getBookingNo,new Object[] { id },new BeanPropertyRowMapper<QuickLinkBean>(QuickLinkBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public QuickLinkBean getCRONo(String id) {
		QuickLinkBean list = null;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(QuickLinkQueryUtil.getCRONo,new Object[] { id },new BeanPropertyRowMapper<QuickLinkBean>(QuickLinkBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public QuickLinkBean getGout(String id) {
		QuickLinkBean list = null;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(QuickLinkQueryUtil.getGout,new Object[] { id },new BeanPropertyRowMapper<QuickLinkBean>(QuickLinkBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public QuickLinkBean getGin(String id) {
		QuickLinkBean list = null;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(QuickLinkQueryUtil.getGin,new Object[] { id },new BeanPropertyRowMapper<QuickLinkBean>(QuickLinkBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	@Override
	public QuickLinkBean getShipmentOrder(String id) {
		QuickLinkBean list = null;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(QuickLinkQueryUtil.getShipmentOrder,new Object[] { id },new BeanPropertyRowMapper<QuickLinkBean>(QuickLinkBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	@Override
	public QuickLinkBean getBl(String id) {
		QuickLinkBean list = null;

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.queryForObject(QuickLinkQueryUtil.getBl,new Object[] { id },new BeanPropertyRowMapper<QuickLinkBean>(QuickLinkBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
