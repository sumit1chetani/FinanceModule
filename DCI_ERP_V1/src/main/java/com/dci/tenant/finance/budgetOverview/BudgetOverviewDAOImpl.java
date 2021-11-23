package com.dci.tenant.finance.budgetOverview;

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
public class BudgetOverviewDAOImpl implements BudgetOverviewDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetOverviewDAOImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BudgetOverviewBean> getList(BudgetOverviewBean overviewBean) {
		List<BudgetOverviewBean> manageCostCenterList = new ArrayList<>();
		try {
			manageCostCenterList = jdbcTemplate.query(BudgetOverviewQueryUtil.GET_BUDGET_DETAIL, new BeanPropertyRowMapper<>(BudgetOverviewBean.class), overviewBean.getCompanyId(), overviewBean.getFinancialyear());
		} catch (DataAccessException e) {
			LOGGER.error("Error in taxSubSectionList", e);

		}
		return manageCostCenterList;

	}

	@Override
	public List<BudgetOverviewBean> getDetailList(BudgetOverviewBean overviewBean) {
		List<BudgetOverviewBean> manageCostCenterList = new ArrayList<>();
		try {
			manageCostCenterList = jdbcTemplate.query(BudgetOverviewQueryUtil.GET_DETAIL_LIST, new BeanPropertyRowMapper<>(BudgetOverviewBean.class), overviewBean.getStartdate(), overviewBean.getEnddate(), overviewBean.getCompanyId(), overviewBean.getSubGroupAcctCode());
		} catch (DataAccessException e) {
			LOGGER.error("Error in taxSubSectionList", e);

		}
		return manageCostCenterList;

	}

	@Override
	public List<BudgetOverviewBean> getFinancialYearList(String companyId) throws Exception {
		List<BudgetOverviewBean> finaceyrList = new ArrayList<>();
		try {
			finaceyrList = jdbcTemplate.query(BudgetOverviewQueryUtil.GET_YEAR_LIST, new BeanPropertyRowMapper<>(BudgetOverviewBean.class), companyId);
		} catch (DataAccessException e) {
			LOGGER.error("Error in taxSubSectionList", e);

		}
		return finaceyrList;

	}

}
