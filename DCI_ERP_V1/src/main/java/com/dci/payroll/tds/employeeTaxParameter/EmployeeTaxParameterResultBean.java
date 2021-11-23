package com.dci.payroll.tds.employeeTaxParameter;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class EmployeeTaxParameterResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<EmployeeTaxParameterBean> employeeTaxParameterList;

	private EmployeeTaxParameterBean employeeTaxParameter;

	public List<EmployeeTaxParameterBean> getEmployeeTaxParameterList() {
		return employeeTaxParameterList;
	}

	public void setEmployeeTaxParameterList(List<EmployeeTaxParameterBean> employeeTaxParameterList) {
		this.employeeTaxParameterList = employeeTaxParameterList;
	}

	public EmployeeTaxParameterBean getEmployeeTaxParameter() {
		return employeeTaxParameter;
	}

	public void setEmployeeTaxParameter(EmployeeTaxParameterBean employeeTaxParameter) {
		this.employeeTaxParameter = employeeTaxParameter;
	}

}