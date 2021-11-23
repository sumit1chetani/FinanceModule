package com.dci.truck.staffMaster;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

//import com.mbk.tenant.finance.transaction.cashflowledger.CashflowBean;


public class StaffResultBean extends BasicResultBean implements Serializable {
	
	List<SelectivityBean> resultList;

	private List<StaffBean> list;


	public List<StaffBean> getList() {
		return list;
	}

	public void setList(List<StaffBean> list) {
		this.list = list;
	}

	public List<SelectivityBean> getResultList() {
		return resultList;
	}

	public void setResultList(List<SelectivityBean> resultList) {
		this.resultList = resultList;
	}
	

  


	
	
	
	
}
