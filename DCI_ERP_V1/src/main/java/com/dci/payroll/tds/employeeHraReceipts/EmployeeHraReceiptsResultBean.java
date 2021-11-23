package com.dci.payroll.tds.employeeHraReceipts;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class EmployeeHraReceiptsResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fileName;
	private String docFileName;

	private String docPath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	private List<EmployeeHraReceiptsBean> employeeHraReceiptsList;

	private EmployeeHraReceiptsBean employeeHraReceipts;

	public List<EmployeeHraReceiptsBean> getEmployeeHraReceiptsList() {
		return employeeHraReceiptsList;
	}

	public void setEmployeeHraReceiptsList(List<EmployeeHraReceiptsBean> employeeHraReceiptsList) {
		this.employeeHraReceiptsList = employeeHraReceiptsList;
	}

	public EmployeeHraReceiptsBean getEmployeeHraReceipts() {
		return employeeHraReceipts;
	}

	public void setEmployeeHraReceipts(EmployeeHraReceiptsBean employeeHraReceipts) {
		this.employeeHraReceipts = employeeHraReceipts;
	}

}