package com.dci.master.service;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;



public class ServiceMasterResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ServiceMasterBean> lServiceMasterBean;
	private List<ServiceMasterBean> objCompanyInfo;

	private List<ServiceMasterTableDetail> objPortTransmitInfo; // Detail
																// Information
	private ServiceMasterBean companyInfoHeader;// Header Information
	
	
	private List<ServiceMasterBean> objBranchInfo;
	
	

	public List<ServiceMasterBean> getObjBranchInfo() {
		return objBranchInfo;
	}

	public void setObjBranchInfo(List<ServiceMasterBean> objBranchInfo) {
		this.objBranchInfo = objBranchInfo;
	}

	public List<ServiceMasterBean> getlServiceMasterBean() {
		return lServiceMasterBean;
	}

	public void setlServiceMasterBean(List<ServiceMasterBean> lServiceMasterBean) {
		this.lServiceMasterBean = lServiceMasterBean;
	}

	public List<ServiceMasterBean> getObjCompanyInfo() {
		return objCompanyInfo;
	}

	public void setObjCompanyInfo(List<ServiceMasterBean> objCompanyInfo) {
		this.objCompanyInfo = objCompanyInfo;
	}

	public List<ServiceMasterTableDetail> getObjPortTransmitInfo() {
		return objPortTransmitInfo;
	}

	public void setObjPortTransmitInfo(List<ServiceMasterTableDetail> objPortTransmitInfo) {
		this.objPortTransmitInfo = objPortTransmitInfo;
	}

	public ServiceMasterBean getCompanyInfoHeader() {
		return companyInfoHeader;
	}

	public void setCompanyInfoHeader(ServiceMasterBean companyInfoHeader) {
		this.companyInfoHeader = companyInfoHeader;
	}

}