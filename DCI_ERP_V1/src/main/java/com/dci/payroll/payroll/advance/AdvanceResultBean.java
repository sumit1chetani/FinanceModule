package com.dci.payroll.payroll.advance;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class AdvanceResultBean extends BasicResultBean implements Serializable {

	private List<Advance> employeeList;
	private List<Advance> designationList;
	private List<Advance> advanceList;
	private List<Advance> advanceAddList;
	private List<Advance> advanceCountList;
	private String alert;

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public List<Advance> getAdvanceCountList() {
		return advanceCountList;
	}

	public void setAdvanceCountList(List<Advance> advanceCountList) {
		this.advanceCountList = advanceCountList;
	}

	public List<Advance> getAdvanceAddList() {
		return advanceAddList;
	}

	public void setAdvanceAddList(List<Advance> advanceAddList) {
		this.advanceAddList = advanceAddList;
	}

	public List<Advance> getAdvanceList() {
		return advanceList;
	}

	public void setAdvanceList(List<Advance> advanceList) {
		this.advanceList = advanceList;
	}

	public List<Advance> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Advance> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Advance> getDesignationList() {
		return designationList;
	}

	public void setDesignationList(List<Advance> designationList) {
		this.designationList = designationList;
	}

}
