package com.dci.tenant.finance.budgetDefinition;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dci.common.model.SelectivityBean;

@Repository
public class BudgetDefinitionDaoImpl implements BudgetDefinitionDao {
	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetDefinitionDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean saveBudgetDefinition(BudgetDefinition BudgetDefinition) {

		boolean isSaved = false;
		try {
			int i = jdbcTemplate.update(BudgetDefinitionQueryUtil.INSERT_BUDGET_DEFINITIONS, BudgetDefinition.getCompany(), BudgetDefinition.getFinancial_year(), BudgetDefinition.getBudgetType(), BudgetDefinition.getCapexno(), BudgetDefinition.getProjectName(), BudgetDefinition.getFlag(), BudgetDefinition.getAmount(), BudgetDefinition.getCostCenter());
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
	public List<BudgetDefinition> getBudgetDefinition() {
		List<BudgetDefinition> allList = new ArrayList<>();
		try {
			allList = jdbcTemplate.query(BudgetDefinitionQueryUtil.GET_ALL_BUDGET_DEFINITIONS, new BeanPropertyRowMapper<>(BudgetDefinition.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allList;

	}

	@Override
	public boolean updateBudgetDefinition(BudgetDefinition BudgetDefinition) {

		boolean isSaved = false;
		try {
			int i = jdbcTemplate.update(BudgetDefinitionQueryUtil.UPDATE_BUDGET_DEFINITIONS, BudgetDefinition.getCompany(), BudgetDefinition.getFinancial_year(), BudgetDefinition.getBudgetType(), BudgetDefinition.getCapexno(), BudgetDefinition.getProjectName(), BudgetDefinition.getFlag(), BudgetDefinition.getAmount(), BudgetDefinition.getCostCenter(), BudgetDefinition.getBudgetDefinitionId());
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
	public BudgetDefinition editBudgetDefinition(Integer budgetDefinitionId) {
		BudgetDefinition BudgetDefinition = new BudgetDefinition();
		try {
			BudgetDefinition = jdbcTemplate.queryForObject(BudgetDefinitionQueryUtil.EDIT_BUDGET_DEFINITIONS, new Object[] { budgetDefinitionId }, new BeanPropertyRowMapper<>(BudgetDefinition.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return BudgetDefinition;
	}

	@Override
	public boolean delete(Integer budgetDefinitionId) {
		boolean isdelete = false;
		try {
			int dtlId = jdbcTemplate.update(BudgetDefinitionQueryUtil.DELETE_BUDGET_DEFINITIONS, new Object[] { budgetDefinitionId });
			if (dtlId > 0)
				isdelete = true;
		} catch (Exception ex) {
			LOGGER.error("Error in Delete Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return isdelete;
	}

	@Override
	public List<SelectivityBean> getBudgetTypeList() {
		List<SelectivityBean> budgetTypeList = new ArrayList<>();
		try {
			budgetTypeList = jdbcTemplate.query(BudgetDefinitionQueryUtil.GET_BUDGET_TYPE_LIST, new BeanPropertyRowMapper<>(SelectivityBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return budgetTypeList;
	}

	@Override
	public boolean approveBudgetDefinition(BudgetDefinition BudgetDefinition) {

		boolean isSaved = false;
		try {
			int i = jdbcTemplate.update(BudgetDefinitionQueryUtil.Approve, BudgetDefinition.getBudgetDefinitionId());
			if (i > 0) {
				isSaved = true;
			}
		} catch (Exception ex) {
			LOGGER.error("Error in Approve Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return isSaved;

	}
}
