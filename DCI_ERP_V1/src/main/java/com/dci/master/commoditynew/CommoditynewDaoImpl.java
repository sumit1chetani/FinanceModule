package com.dci.master.commoditynew;

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

public class CommoditynewDaoImpl implements CommoditynewDao {
	private final static Logger LOGGER = Logger.getLogger(CommoditynewDaoImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	AuditLogDAO auditLogDao;

	@Override
	public List<CommoditynewBean> getCommodityList() {
		List<CommoditynewBean> list = new ArrayList<CommoditynewBean>();

		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CommoditynewQueryUtil.list,
					new BeanPropertyRowMapper<CommoditynewBean>(CommoditynewBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getCommodityFormList", e);
		}

		return list;
	}

	@Override
	public CommoditynewBean insert(CommoditynewBean commodity) throws Exception {
		Boolean isSuccess = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String commodityCode = "";

			commodityCode = jdbcTemplate.queryForObject(CommoditynewQueryUtil.GENERATE_CODE, new Object[] { "CMD", "CMD" },
					String.class);
			commodityCode = "CMD" + commodityCode;

			int i = jdbcTemplate.update(CommoditynewQueryUtil.INSERT,
					new Object[] { commodityCode, commodity.getCommodity(), 
							commodity.getHazardous(), commodity.getUnno(),
							commodity.getFlashPoint(), commodity.getImdgCode(), commodity.getImdgPage(),
							commodity.getHsCode(), commodity.getBlClause(),userDetails.getUserId(),commodity.getActive() });

			if (i > 0) {
				isSuccess = true;
				commodity.setIsSuccess(isSuccess);

				UserLog userLog = userlogDao.userLogForInsert(commodity, commodityCode, userDetails.getUserId());
				auditLogDao.auditLogForInsert(commodity, userLog, null);

			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			commodity.setIsSuccess(isSuccess);
			LOGGER.error("Error in save", e);
			commodity.setMessage("Error in save :" + e.getMessage());
		}
		return commodity;
	}

	@Override
	public boolean delete(String commodityCode) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CommoditynewBean commo = new CommoditynewBean();

		try {
			jdbcTemplate.update(CommoditynewQueryUtil.delete, commodityCode);
			UserLog userLog = userlogDao.userLogForDelete(commo, commodityCode, userDetails.getUserId());

			isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in delete", e);
		}

		return isDeleted;
	}

	@Override
	public CommoditynewBean getCommodityEdit(String commodityCode) {
		CommoditynewBean commoditybean = new CommoditynewBean();
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			commoditybean = jdbcTemplate.queryForObject(CommoditynewQueryUtil.GET_COMMODITY,
					new Object[] { commodityCode }, new BeanPropertyRowMapper<CommoditynewBean>(CommoditynewBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in edit", e);

		}
		return commoditybean;
	}

	@Override
	public CommoditynewBean update(CommoditynewBean commodity) throws Exception {
		CommoditynewBean commodityResBean = new CommoditynewBean();
		Boolean isSuccess = false;
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			int i = jdbcTemplate.update(CommoditynewQueryUtil.UPDATE, commodity.getCommodity(),
					 commodity.getHazardous(),
					commodity.getUnno(), commodity.getFlashPoint(), commodity.getImdgCode(), commodity.getImdgPage(),
					commodity.getHsCode(), commodity.getBlClause(), userDetails.getUserId(),commodity.getActive() ,commodity.getCommodityCode());

			if (i > 0) {
				isSuccess = true;
				commodity.setIsSuccess(isSuccess);

				UserLog userLog = userlogDao.userLogForUpdate(commodity, commodityResBean, commodity.getCommodityCode(),
						userDetails.getUserId());
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			isSuccess = false;
			commodity.setIsSuccess(isSuccess);
			commodity.setMessage("Error in Update :" + e.getMessage());
			LOGGER.error("Error in update", e);
		}
		return commodity;
	}

	@Override
	public List<CommoditynewBean> getDropDown() {
		List<CommoditynewBean> list = new ArrayList<CommoditynewBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CommoditynewQueryUtil.DROPDOWN,new BeanPropertyRowMapper<CommoditynewBean>(CommoditynewBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
