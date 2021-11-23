package com.dci.tenant.truck.commodityclassification;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.auditlog.AuditLogDAO;
import com.dci.tenant.auditlog.UserLog;
import com.dci.tenant.auditlog.UserLogDAO;
import com.dci.tenant.user.UserDetail;


@Repository
@Transactional("tenantTransactionManager")

public class CommodityClassificationDaoImpl implements CommodityClassificationDao {
	
	private final static Logger LOGGER = Logger.getLogger(CommodityClassificationDaoImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	AuditLogDAO auditLogDao;


	@Override
	public List<CommodityClassificationBean> getCommodityList() {
		List<CommodityClassificationBean> list = new ArrayList<CommodityClassificationBean>();

		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CommodityClassificationQueryUtil.list,
					new BeanPropertyRowMapper<CommodityClassificationBean>(CommodityClassificationBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getCommodityClassificationFormList", e);
		}

		return list;
	}

	@Override
	public CommodityClassificationBean insert(CommodityClassificationBean commodityclassification) throws Exception {
		Boolean isSuccess = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			int i = jdbcTemplate.update(CommodityClassificationQueryUtil.INSERT,
					new Object[] {commodityclassification.getClassificationCode(), commodityclassification.getDescription(),userDetails.getUserId() });

			if (i > 0) {
				isSuccess = true;
				commodityclassification.setIsSuccess(isSuccess);

				UserLog userLog = userlogDao.userLogForInsert(commodityclassification, commodityclassification.getClassificationCode(), userDetails.getUserId());
				auditLogDao.auditLogForInsert(commodityclassification, userLog, null);

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			commodityclassification.setIsSuccess(isSuccess);
			LOGGER.error("Error in save", e);
			commodityclassification.setMessage("Error in save :" + e.getMessage());
		}
		return commodityclassification;
	}

	@Override
	public boolean delete(String classificationCode) {
		boolean isDeleted = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CommodityClassificationBean commo = new CommodityClassificationBean();

		try {
			jdbcTemplate.update(CommodityClassificationQueryUtil.delete, classificationCode);
			UserLog userLog = userlogDao.userLogForDelete(commo, classificationCode, userDetails.getUserId());

			isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in delete", e);
		}

		return isDeleted;
	}

	@Override
	public CommodityClassificationBean getCommodityEdit(String classificationCode) {
		CommodityClassificationBean commodityclassificationbean = new CommodityClassificationBean();
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			commodityclassificationbean = jdbcTemplate.queryForObject(CommodityClassificationQueryUtil.GET_COMMODITY,
					new Object[] { classificationCode }, new BeanPropertyRowMapper<CommodityClassificationBean>(CommodityClassificationBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in edit", e);

		}
		return commodityclassificationbean;
	}

	@Override
	public CommodityClassificationBean update(CommodityClassificationBean commodityclassification) throws Exception {
		Boolean isSuccess = false;
		CommodityClassificationBean commodityResBean = new CommodityClassificationBean();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			int i = jdbcTemplate.update(CommodityClassificationQueryUtil.UPDATE,commodityclassification.getDescription(),userDetails.getUserId(),commodityclassification.getClassificationCode());

			if (i > 0) {
				isSuccess = true;
				commodityclassification.setIsSuccess(isSuccess);

				UserLog userLog = userlogDao.userLogForUpdate(commodityclassification, commodityResBean, commodityclassification.getClassificationCode(),
						userDetails.getUserId());
		
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			commodityclassification.setIsSuccess(isSuccess);
			commodityclassification.setMessage("Error in Update :" + e.getMessage());
			LOGGER.error("Error in update", e);
		}
		return commodityclassification;
	}


}
