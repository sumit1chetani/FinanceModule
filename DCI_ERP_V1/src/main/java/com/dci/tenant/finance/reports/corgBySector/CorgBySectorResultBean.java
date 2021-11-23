package com.dci.tenant.finance.reports.corgBySector;

import java.util.List;

import com.dci.common.util.BasicResultBean;


public class CorgBySectorResultBean extends BasicResultBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CorgBySector> coreBySectorList;
	

	public List<String> getlEmpmasterBeanHeader() {
		return lEmpmasterBeanHeader;
	}

	public void setlEmpmasterBeanHeader(List<String> lEmpmasterBeanHeader) {
		this.lEmpmasterBeanHeader = lEmpmasterBeanHeader;
	}

	private List<String> lEmpmasterBeanHeader;
	
	private List<CorgBySector> lEmpmasterBeanDetail;

	public List getHeader() {
		return header;
	}

	public void setHeader(List header) {
		this.header = header;
	}

	public List getDetail() {
		return detail;
	}

	public void setDetail(List detail) {
		this.detail = detail;
	}

	private List header;
	private List detail;
	public List<CorgBySector> getCoreBySectorList() {
		return coreBySectorList;
	}

	public void setCoreBySectorList(List<CorgBySector> coreBySectorList) {
		this.coreBySectorList = coreBySectorList;
	}

	public List<CorgBySector> getlEmpmasterBeanDetail() {
		return lEmpmasterBeanDetail;
	}

	public void setlEmpmasterBeanDetail(List<CorgBySector> lEmpmasterBeanDetail) {
		this.lEmpmasterBeanDetail = lEmpmasterBeanDetail;
	}

	
	
	
	
}