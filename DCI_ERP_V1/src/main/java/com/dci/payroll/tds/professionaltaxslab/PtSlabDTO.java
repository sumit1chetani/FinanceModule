package com.dci.payroll.tds.professionaltaxslab;

import java.util.ArrayList;
import java.util.List;

public class PtSlabDTO {
	private String employeeId;
	private String employeeName;
	List<ProfessionalTaxSlabBean> dateList = new ArrayList<ProfessionalTaxSlabBean>();

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public List<ProfessionalTaxSlabBean> getDateList() {
		return dateList;
	}

	public void setDateList(List<ProfessionalTaxSlabBean> dateList) {
		this.dateList = dateList;
	}

}