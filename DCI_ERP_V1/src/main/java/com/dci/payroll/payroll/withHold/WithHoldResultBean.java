package com.dci.payroll.payroll.withHold;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class WithHoldResultBean extends BasicResultBean implements Serializable {

	private List<WithHoldBean> employeeList;
	private List<WithHoldBean> yearList;
	private List<WithHoldBean> withholdList;
	private List<WithHoldBean> withholdAddList;
	private String alert;

	public List<WithHoldBean> getYearList() {
		return yearList;
	}

	public void setYearList(List<WithHoldBean> yearList) {
		this.yearList = yearList;
	}

	public List<WithHoldBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<WithHoldBean> employeeList) {
		this.employeeList = employeeList;
	}

	public List<WithHoldBean> getWithholdList() {
		return withholdList;
	}

	public void setWithholdList(List<WithHoldBean> withholdList) {
		this.withholdList = withholdList;
	}

	public List<WithHoldBean> getWithholdAddList() {
		return withholdAddList;
	}

	public void setWithholdAddList(List<WithHoldBean> withholdAddList) {
		this.withholdAddList = withholdAddList;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

}
