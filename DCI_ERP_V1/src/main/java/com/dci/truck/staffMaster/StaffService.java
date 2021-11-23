package com.dci.truck.staffMaster;

import java.util.List;

import com.dci.common.util.CustomException;

//import com.mbk.tenant.finance.transaction.cashflowledger.CashflowBean;


public interface StaffService {


	public StaffResultBean getemployeelist() throws CustomException;
	
	public StaffBean  save(StaffBean  bean) throws Exception;

	public List<StaffBean> getList();

	public boolean deleteStaff(String staffId);


	
	
}
