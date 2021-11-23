package com.dci.payroll.tds.TdsDeclaration;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class TdsDeclarationResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<TdsDeclarationBean> tdsDeclarationList;

	private TdsDeclarationBean tdsDeclarationBean = null;
	private String fileName;
	private String docFileName;

	private String docPath;

	public List<TdsDeclarationBean> getTdsDeclarationList() {
		return tdsDeclarationList;
	}

	public void setTdsDeclarationList(List<TdsDeclarationBean> tdsDeclarationList) {
		this.tdsDeclarationList = tdsDeclarationList;
	}

	public TdsDeclarationBean getTdsDeclarationBean() {
		return tdsDeclarationBean;
	}

	public void setTdsDeclarationBean(TdsDeclarationBean tdsDeclarationBean) {
		this.tdsDeclarationBean = tdsDeclarationBean;
	}

	public String getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

}
