package com.dci.tenant.finance.budgetAllocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.dci.tenant.finance.budgetType.BudgetTypeQueryUtil;
import com.dci.tenant.user.UserDetail;

@Repository
public class BudgetAllocationDaoImpl implements BudgetAllocationDao {
	private final static Logger LOGGER = LoggerFactory.getLogger(BudgetAllocationDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BudgetAllocationBean> getCompanyList(String userId) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<BudgetAllocationBean> lCompanyList = new ArrayList<>();
		try {
			lCompanyList = jdbcTemplate.query(BudgetAllocationQueryUtil.GET_COMPANY_LIST, new BeanPropertyRowMapper<>(BudgetAllocationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Company List", e);
		}
		return lCompanyList;
	}

	@Override
	public List<BudgetAllocationBean> getFinancialYearList(String company) {
		List<BudgetAllocationBean> lFinYearList = new ArrayList<>();
		try {
			lFinYearList = jdbcTemplate.query(BudgetAllocationQueryUtil.GET_FIN_YEAR_LIST, new Object[] { company }, new BeanPropertyRowMapper<>(BudgetAllocationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Financial Year List", e);
		}
		return lFinYearList;
	}

	@Override
	public List<BudgetAllocationBean> getFinYearbudget() {
		List<BudgetAllocationBean> lFinYearList = new ArrayList<>();
		try {
			lFinYearList = jdbcTemplate.query(BudgetAllocationQueryUtil.GET_FIN_YEAR_LIST_BUDGET, new Object[] {}, new BeanPropertyRowMapper<>(BudgetAllocationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Financial Year List", e);
		}
		return lFinYearList;
	}

	@Override
	public List<BudgetAllocationBean> getTdsType() {
		List<BudgetAllocationBean> lTdsList = new ArrayList<>();
		try {
			lTdsList = jdbcTemplate.query(BudgetAllocationQueryUtil.GET_TDS_LIST, new Object[] {}, new BeanPropertyRowMapper<>(BudgetAllocationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Financial Year List", e);
		}
		return lTdsList;
	}

	@Override
	public List<BudgetAllocationBean> getVendorList() {
		List<BudgetAllocationBean> lTdsList = new ArrayList<>();
		try {
			lTdsList = jdbcTemplate.query(BudgetAllocationQueryUtil.GET_Vendor_list, new Object[] {}, new BeanPropertyRowMapper<>(BudgetAllocationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Financial Year List", e);
		}
		return lTdsList;
	}

	@Override
	public List<BudgetAllocationBean> getaccontnameTds() {
		List<BudgetAllocationBean> lTdsList = new ArrayList<>();
		try {
			lTdsList = jdbcTemplate.query(BudgetAllocationQueryUtil.GET_getaccontnameTds_list, new Object[] {}, new BeanPropertyRowMapper<>(BudgetAllocationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Financial Year List", e);
		}
		return lTdsList;
	}

	@Override
	public boolean save(BudgetAllocationBean allocationBean) {
		boolean isSaved = false;
		try {
			int allocationId = jdbcTemplate.queryForObject(BudgetAllocationQueryUtil.SAVE_ALLOCATION, new Object[] { allocationBean.getCompany(), allocationBean.getFinancial_year(), allocationBean.getExpense_type(), allocationBean.getStatus(), allocationBean.getAmount() }, Integer.class);

			if (allocationId > 0) {
				for (Object object : allocationBean.getExpenseColumns()) {
					HashMap accountmap = (HashMap) object;
					String acctCode = jdbcTemplate.queryForObject(BudgetTypeQueryUtil.GET_ACCT_CODE, new Object[] { accountmap.get("keyColumn").toString() }, String.class);
					int dtlId = jdbcTemplate.update(BudgetAllocationQueryUtil.SAVE_ALLOCATION_ACCOUNTS, new Object[] { allocationId, acctCode, Double.valueOf(accountmap.get("keyValue").toString()) });
				}
				isSaved = true;
			}

		} catch (Exception ex) {
			LOGGER.error("Error in Save Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return isSaved;
	}

	@Override
	public List<BudgetAllocationBean> allocationList() {
		List<BudgetAllocationBean> lFinYearList = new ArrayList<>();
		try {
			lFinYearList = jdbcTemplate.query(BudgetAllocationQueryUtil.GET_ALLOCATION_LIST, new BeanPropertyRowMapper<>(BudgetAllocationBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Allocation List", e);
		}
		return lFinYearList;
	}

	@Override
	public BudgetAllocationBean allocationEdit(String allocationId) {
		BudgetAllocationBean allocationBean = new BudgetAllocationBean();
		List lAccounts = new ArrayList();
		Object object = null;
		try {
			allocationBean = jdbcTemplate.queryForObject(BudgetAllocationQueryUtil.GET_ALLOCATION_EDIT, new Object[] { Integer.valueOf(allocationId) }, new BeanPropertyRowMapper<>(BudgetAllocationBean.class));
			List<Map<String, Object>> RowData = jdbcTemplate.queryForList(BudgetAllocationQueryUtil.GET_ALLOCATION_ACCOUNT, new Object[] { Integer.valueOf(allocationId) });

			for (Map<String, Object> row : RowData) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("keyColumn", row.get("subGrpName").toString());
				map.put("keyValue", Double.valueOf(row.get("amount").toString()));
				lAccounts.add(map);
			}
			allocationBean.setExpenseColumns(lAccounts);

		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Allocation Edit", e);
		}
		return allocationBean;
	}

	@Override
	public boolean update(BudgetAllocationBean allocationBean) {
		boolean isSaved = false;
		try {
			int dtlId = jdbcTemplate.update(BudgetAllocationQueryUtil.UPDATE_ALLOCATION, new Object[] { allocationBean.getCompany(), allocationBean.getFinancial_year(), allocationBean.getExpense_type(), allocationBean.getStatus(), allocationBean.getAmount(), allocationBean.getBudget_allocation_id() });
			if (dtlId > 0) {

				for (Object object : allocationBean.getExpenseColumns()) {
					HashMap accountmap = (HashMap) object;
					String acctCode = jdbcTemplate.queryForObject(BudgetTypeQueryUtil.GET_ACCT_CODE, new Object[] { accountmap.get("keyColumn").toString() }, String.class);
					jdbcTemplate.update(BudgetAllocationQueryUtil.UPDATE_ALLOCATION_AMOUNT, new Object[] { Double.valueOf(accountmap.get("keyValue").toString()), allocationBean.getBudget_allocation_id(), acctCode });
				}
				isSaved = true;
			}

		} catch (Exception ex) {
			LOGGER.error("Error in update Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return isSaved;
	}

	@Override
	public boolean approve(BudgetAllocationBean allocationBean) {
		boolean isSaved = false;
		try {
			int dtlId = jdbcTemplate.update(BudgetAllocationQueryUtil.APPROVE_ALLOCATION, new Object[] { allocationBean.getStatus(), allocationBean.getBudget_allocation_id() });
			if (dtlId > 0)
				isSaved = true;
		} catch (Exception ex) {
			LOGGER.error("Error in approve Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return isSaved;
	}

	@Override
	public boolean getAvailablity(BudgetAllocationBean allocationBean) {
		boolean notAvail = false;
		try {
			int dtlId = jdbcTemplate.queryForObject(BudgetAllocationQueryUtil.CHECK_ALLOCATION, new Object[] { allocationBean.getCompany(), allocationBean.getFinancial_year(), allocationBean.getExpense_type() }, Integer.class);
			if (dtlId == 0)
				notAvail = true;
		} catch (Exception ex) {
			LOGGER.error("Error in getAvailablity Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return notAvail;
	}

	@Override
	public boolean delete(String budgetId) {
		boolean isdelete = false;
		try {
			int dtlId = jdbcTemplate.update(BudgetAllocationQueryUtil.DELETE_ALLOCATION, new Object[] { Integer.valueOf(budgetId) });
			if (dtlId > 0)
				isdelete = true;
		} catch (Exception ex) {
			LOGGER.error("Error in Delete Budget Allocation", ex);
		}
		// TODO Auto-generated method stub
		return isdelete;
	}

	@Override
	public List<String> getDynamicColumns(String type) {
		List<String> lCompanyList = new ArrayList<>();
		String strColumns = "", columnName = "";
		try {
			strColumns = jdbcTemplate.queryForObject(BudgetAllocationQueryUtil.GET_BUDGET_TYPE_COLUMNS, new Object[] { type }, String.class);

			if (strColumns != null) {
				String[] expCode = strColumns.split(",");
				for (String str : expCode) {
					columnName = jdbcTemplate.queryForObject(BudgetTypeQueryUtil.GET_ACCT_NAME, new Object[] { str }, String.class);
					lCompanyList.add(columnName);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in Get Column List", e);
		}
		return lCompanyList;
	}

}
