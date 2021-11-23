package com.dci.truck.staffMaster;

import java.util.List;

//import com.mbk.tenant.finance.transaction.cashflowledger.CashflowBean;

public interface StaffDao {

	

	StaffResultBean getemployeelist();

	StaffBean save(StaffBean bean);
	
	public List<StaffBean> getList();

	boolean deleteStaff(String staffId);

	

	
	 
}
