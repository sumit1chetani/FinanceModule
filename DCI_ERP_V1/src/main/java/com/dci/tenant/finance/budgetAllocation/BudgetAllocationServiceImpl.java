package com.dci.tenant.finance.budgetAllocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetAllocationServiceImpl implements BudgetAllocationService {

	@Autowired
	BudgetAllocationDao budgetAllocationDao;

	@Override
	public List<BudgetAllocationBean> getCompanyList(String userId) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.getCompanyList(userId);
	}

	@Override
	public List<BudgetAllocationBean> getFinancialYearList(String company) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.getFinancialYearList(company);
	}

	@Override
	public List<BudgetAllocationBean> getFinYearbudget() {
		// TODO Auto-generated method stub
		return budgetAllocationDao.getFinYearbudget();
	}

	@Override
	public List<BudgetAllocationBean> getTdsType() {
		// TODO Auto-generated method stub
		return budgetAllocationDao.getTdsType();
	}

	@Override
	public List<BudgetAllocationBean> getVendorList() {
		// TODO Auto-generated method stub
		return budgetAllocationDao.getVendorList();
	}

	@Override
	public List<BudgetAllocationBean> getaccontnameTds() {
		// TODO Auto-generated method stub
		return budgetAllocationDao.getaccontnameTds();
	}

	@Override
	public boolean save(BudgetAllocationBean allocationBean) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.save(allocationBean);
	}

	@Override
	public List<BudgetAllocationBean> allocationList() {
		// TODO Auto-generated method stub
		return budgetAllocationDao.allocationList();
	}

	@Override
	public BudgetAllocationBean allocationEdit(String allocationId) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.allocationEdit(allocationId);
	}

	@Override
	public boolean update(BudgetAllocationBean allocationBean) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.update(allocationBean);
	}

	@Override
	public boolean approve(BudgetAllocationBean allocationBean) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.approve(allocationBean);
	}

	@Override
	public boolean getAvailablity(BudgetAllocationBean allocationBean) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.getAvailablity(allocationBean);
	}

	@Override
	public boolean delete(String budgetId) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.delete(budgetId);
	}

	@Override
	public List<String> getDynamicColumns(String type) {
		// TODO Auto-generated method stub
		return budgetAllocationDao.getDynamicColumns(type);
	}

}
