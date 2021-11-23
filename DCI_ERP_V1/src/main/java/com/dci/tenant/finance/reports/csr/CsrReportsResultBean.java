package com.dci.tenant.finance.reports.csr;

import java.io.Serializable;

import com.dci.common.util.BasicResultBean;

public class CsrReportsResultBean extends BasicResultBean implements Serializable {
private String filePath;

public String getFilePath() {
	return filePath;
}

public void setFilePath(String filePath) {
	this.filePath = filePath;
}
}
