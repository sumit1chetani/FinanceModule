package com.dci.tenant.truck.commodity;

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

public class CommodityDaoImpl implements CommodityDao {
	private final static Logger LOGGER = Logger.getLogger(CommodityDaoImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	UserLogDAO userlogDao;

	@Autowired
	AuditLogDAO auditLogDao;

	@Override
	public List<CommodityBean> getCommodityList() {
		List<CommodityBean> list = new ArrayList<CommodityBean>();

		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CommodityQueryUtil.list,
					new BeanPropertyRowMapper<CommodityBean>(CommodityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getCommodityFormList", e);
		}

		return list;
	}

	@Override
	public CommodityBean insert(CommodityBean commodity) throws Exception {
		Boolean isSuccess = false;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String commodityCode = "";
			if(commodity.getActive().equalsIgnoreCase("true")){
				//active ="Y";
				commodity.setActive("Y");
			}else{
				commodity.setActive("N");
			}		

			commodityCode = jdbcTemplate.queryForObject(CommodityQueryUtil.GENERATE_CODE, new Object[] { "CM", "CM" },
					String.class);
			commodityCode = "CM" + commodityCode;

			int i = jdbcTemplate.update(CommodityQueryUtil.INSERT,
					new Object[] { commodityCode, commodity.getCommodity(),
							commodity.getHazardous(), commodity.getUnno(),
							commodity.getFlashPoint(), commodity.getImdgCode(), commodity.getImdgPage(),
							commodity.getHsCode(), commodity.getBlClause(),userDetails.getUserId(),commodity.getActive(),commodity.getTaxExem() });

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
		CommodityBean commo = new CommodityBean();

		try {
			jdbcTemplate.update(CommodityQueryUtil.delete, commodityCode);
			UserLog userLog = userlogDao.userLogForDelete(commo, commodityCode, userDetails.getUserId());

			isDeleted = true;
		} catch (DataAccessException e) {
			LOGGER.error("Error in delete", e);
		}

		return isDeleted;
	}

	@Override
	public CommodityBean getCommodityEdit(String commodityCode) {
		CommodityBean commoditybean = new CommodityBean();
		try {

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			commoditybean = jdbcTemplate.queryForObject(CommodityQueryUtil.GET_COMMODITY,
					new Object[] { commodityCode }, new BeanPropertyRowMapper<CommodityBean>(CommodityBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in edit", e);

		}
		return commoditybean;
	}

	@Override
	public CommodityBean update(CommodityBean commodity) throws Exception {
		CommodityBean commodityResBean = new CommodityBean();
		Boolean isSuccess = false;
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			if(commodity.getActive().equalsIgnoreCase("true")){
				//active ="Y";
				commodity.setActive("Y");
			}else{
				commodity.setActive("N");
			}	

			int i = jdbcTemplate.update(CommodityQueryUtil.UPDATE, commodity.getCommodity(),
					 commodity.getHazardous(),
					commodity.getUnno(), commodity.getFlashPoint(), commodity.getImdgCode(), commodity.getImdgPage(),
					commodity.getHsCode(), commodity.getBlClause(), userDetails.getUserId(),commodity.getActive() ,commodity.getTaxExem(),commodity.getCommodityCode());

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
	public List<CommodityBean> getDropDown() {
		List<CommodityBean> list = new ArrayList<CommodityBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			list = jdbcTemplate.query(CommodityQueryUtil.DROPDOWN,new BeanPropertyRowMapper<CommodityBean>(CommodityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
