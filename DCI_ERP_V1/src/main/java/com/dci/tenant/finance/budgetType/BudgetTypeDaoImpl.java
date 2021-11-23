package com.dci.tenant.finance.budgetType;

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
public class BudgetTypeDaoImpl implements BudgetTypeDao {
	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetTypeDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BudgetTypeBean> getExpenseAccountsList(String userId) {
		List<BudgetTypeBean> lCompanyList = new ArrayList<>();
		try {
			lCompanyList = jdbcTemplate.query(BudgetTypeQueryUtil.GET_ACCT_LIST, new BeanPropertyRowMapper<>(BudgetTypeBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Account List", e);
		}
		return lCompanyList;
	}

	@Override
	public boolean save(BudgetTypeBean BudgetTypeBean) {
		boolean isSaved = false;
		try {
			int i = jdbcTemplate.update(BudgetTypeQueryUtil.INSERT_BUDGET_TYPE, BudgetTypeBean.getBudget_type(), BudgetTypeBean.getExpenses(), BudgetTypeBean.getAmount());
			if (i > 0) {
				isSaved = true;
			}
		} catch (Exception ex) {
			LOGGER.error("Error in Save Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return isSaved;
	}

	@Override
	public List<BudgetTypeBean> budgetTypeList() {
		List<BudgetTypeBean> budgetTypeList = new ArrayList<>(), finalList = new ArrayList<>();
		try {
			budgetTypeList = jdbcTemplate.query(BudgetTypeQueryUtil.GET_BUDGET_TYPE_LIST, new BeanPropertyRowMapper<>(BudgetTypeBean.class));
			for (BudgetTypeBean bean : budgetTypeList) {
				String accounts = "";
				if (bean.getExpenses() != null) {
					String[] expCode = bean.getExpenses().split(",");
					for (String str : expCode) {
						accounts += jdbcTemplate.queryForObject(BudgetTypeQueryUtil.GET_ACCT_NAME, new Object[] { str }, String.class).concat(",");
					}
				}
				bean.setExpenses(accounts.replaceAll(",$", ""));
				finalList.add(bean);
			}

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Allocation List", e);
		}
		return budgetTypeList;
	}

	@Override
	public BudgetTypeBean budgetTypeEdit(String allocationId) {
		BudgetTypeBean allocationBean = new BudgetTypeBean();
		try {
			allocationBean = jdbcTemplate.queryForObject(BudgetTypeQueryUtil.GET_BUDGET_TYPE_EDIT, new Object[] { Integer.valueOf(allocationId) }, new BeanPropertyRowMapper<>(BudgetTypeBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Budget Edit", e);
		}
		return allocationBean;
	}

	@Override
	public boolean update(BudgetTypeBean budgetTypeBean) {
		boolean isSaved = false;
		try {

			String listString = "";
			for (String s : budgetTypeBean.getExpCodes()) {
				listString += s + ",";
			}
			budgetTypeBean.setExpenses(listString.replaceAll(",$", ""));

			int dtlId = jdbcTemplate.update(BudgetTypeQueryUtil.UPDATE_BUDGET_TYPE, new Object[] { budgetTypeBean.getBudget_type(), budgetTypeBean.getExpenses(), budgetTypeBean.getAmount(), budgetTypeBean.getBudget_type_id() });
			if (dtlId > 0)
				isSaved = true;

		} catch (Exception ex) {
			LOGGER.error("Error in update Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return isSaved;
	}

	@Override
	public boolean delete(String budgetId) {
		boolean isdelete = false;
		try {
			int dtlId = jdbcTemplate.update(BudgetTypeQueryUtil.DELETE_ALLOCATION, new Object[] { Integer.valueOf(budgetId) });
			if (dtlId > 0)
				isdelete = true;
		} catch (Exception ex) {
			LOGGER.error("Error in Delete Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return isdelete;
	}

}
