package com.dci.tenant.finance.reports.analytical.adminandbudgetprojection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.util.CommonUtilityQueryUtil;
@Repository
@Transactional("tenantTransactionManager")
public class AdminBudgetAndProjectionDAOImpl implements AdminBudgetAndProjectionDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(AdminBudgetAndProjectionDAOImpl.class);

	@Resource
	 private DataSource dataSource;
	
	@Override
	public AdminBudgetAndProjectionResultBean getPrevYearLoadingContainerTuesList() {
		AdminBudgetAndProjectionBean bean = new AdminBudgetAndProjectionBean();

		AdminBudgetAndProjectionResultBean resultBean = new AdminBudgetAndProjectionResultBean();
		double emptytues = 0, ladentues = 0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int sCurrentYear = Calendar.getInstance().get(Calendar.YEAR);
			int prevYear = sCurrentYear - 1;
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(AdminBudgetAndProjectionQueryUtil.GET_PREV_YEAR_VOLUME_EXPECTATION,
					new Object[] { prevYear });

			for (Map row : rows) {
				bean.setEmptyTues(Double.parseDouble(String.valueOf(row.get("M20")))  + Double.parseDouble(String.valueOf(row.get("M40"))));
				bean.setLadenTues(Double.parseDouble(String.valueOf(row.get("L20")))  + Double.parseDouble(String.valueOf(row.get("L40"))));
				bean.setTotalTues(Double.parseDouble(String.valueOf(row.get("totalTues"))) );
				
				resultBean.setAdminBudgetProjectionBean(bean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in get Prev Year Loading Container Tues Records!", e);
		}

		return resultBean;
	}

	@Override
	public AdminBudgetAndProjectionResultBean getAccountHeadPreviousBalance(String accountCode) {
		List<AdminBudgetAndProjectionBean> alList = new ArrayList<AdminBudgetAndProjectionBean>();
		AdminBudgetAndProjectionResultBean resultBean = new AdminBudgetAndProjectionResultBean();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			alList = jdbcTemplate.query(CommonUtilityQueryUtil.GET_ACCOUNTHEAD_PREV_BALANCE, new Object[] { accountCode },
					new BeanPropertyRowMapper<AdminBudgetAndProjectionBean>(AdminBudgetAndProjectionBean.class));

			resultBean.setlAdminBudgetAndProjectionBean(alList);

		} catch (DataAccessException e) {
			LOGGER.error("Error in GetlAttributeList", e);
		}
		return resultBean;
	}

	@Override
	public boolean generateAdminBudgetData(AdminBudgetAndProjectionBean objAdminBudgetBean) {
		boolean isSuccess = false;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate = new JdbcTemplate(dataSource);

			String adminBudgetNo = generateAdminBudgetNo();
			System.out.println("adminBudgetNo:::::::::::" + adminBudgetNo);
			int iSave = jdbcTemplate.update(
					AdminBudgetAndProjectionQueryUtil.SAVE_ADMIN_BUDGET_DATA,
					new Object[] { adminBudgetNo, objAdminBudgetBean.getFromDate(), objAdminBudgetBean.getToDate(),
							objAdminBudgetBean.getCostCentre(), objAdminBudgetBean.getAccountHead(), objAdminBudgetBean.getCurrentVolume(),
							objAdminBudgetBean.getEmptyTues(), objAdminBudgetBean.getLadenTues(), objAdminBudgetBean.getTotalTues(),
							objAdminBudgetBean.getCurrentvariance(), objAdminBudgetBean.getPreviousVariance(),
							objAdminBudgetBean.getCurrentPerTeuCost(), objAdminBudgetBean.getPreviousPerTeuCost(),
							objAdminBudgetBean.getCurrentTotalAccount(), objAdminBudgetBean.getPreviousTotalAccount(),
							objAdminBudgetBean.getCurrentTotalCostCentre(), objAdminBudgetBean.getPreviousTotalCostCentre(),
							objAdminBudgetBean.getCurrentTotalPeriod(), objAdminBudgetBean.getPreviousTotalPeriod(),
							objAdminBudgetBean.getIncreaseDecrease() });

			if (iSave > 0)
				isSuccess = true;

		} catch (DataAccessException e) {
			LOGGER.error("Error in save the Admin Budget Records!", e);
		}

		return isSuccess;
	}

	private String generateAdminBudgetNo() {

		String budgetNo = "";
		try {
			String initialBudgetNo = "BD00001";
			String budgetPrefix = "BD";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(AdminBudgetAndProjectionQueryUtil.AUTO_GEN_ADMIN_BUDGET_NO, new Object[] {
					initialBudgetNo, budgetPrefix });
			for (Map row : rows) {
				budgetNo = (String) row.get("BUDJET_ID");
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Generate Admin budget Number", e);
		}
		return budgetNo;
	}

	@Override
	public List<AdminBudgetAndProjectionBean> getAdminBudgetHdrList(int limit, int offset) {
		List<AdminBudgetAndProjectionBean> lBudgetHdrList = new ArrayList<AdminBudgetAndProjectionBean>();

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			lBudgetHdrList = jdbcTemplate.query(AdminBudgetAndProjectionQueryUtil.GET_ADMIN_BUDGET_HDR_LIST,
					new BeanPropertyRowMapper<AdminBudgetAndProjectionBean>(AdminBudgetAndProjectionBean.class));

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Admin Budget List", e);
		}
		return lBudgetHdrList;
	}
}
