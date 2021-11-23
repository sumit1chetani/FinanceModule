package com.dci.tenant.employeemaster;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class EmpmasterResultBean extends BasicResultBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private EmpmasterBean empmasterBean;

	private List<EmpmasterBean> lEmpmasterBean;
	private List<EmpmasterBean> lEmpmasterBeanExcel;
	private List<EmpmasterBean> objCompanyInfo;

	private List<EmpmasterBean> objPortTransmitInfo;
	public List<EmpmasterBean> getlEmpmasterBean() {
		return lEmpmasterBean;
	}

	public List getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List companyList) {
		this.companyList = companyList;
	}

	public List getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List departmentList) {
		this.departmentList = departmentList;
	}

	public void setlEmpmasterBean(List<EmpmasterBean> lEmpmasterBean) {
		this.lEmpmasterBean = lEmpmasterBean;
	}

	public List getDesignationList() {
		return designationList;
	}

	public void setDesignationList(List designationList) {
		this.designationList = designationList;
	}

	/**
	 * @return the empmasterBean
	 */
	public EmpmasterBean getEmpmasterBean() {
		return empmasterBean;
	}

	/**
	 * @param empmasterBean
	 *            the empmasterBean to set
	 */
	public void setEmpmasterBean(EmpmasterBean empmasterBean) {
		this.empmasterBean = empmasterBean;
	}

	public List<EmpmasterBean> getlEmpmasterBeanExcel() {
		return lEmpmasterBeanExcel;
	}

	public void setlEmpmasterBeanExcel(List<EmpmasterBean> lEmpmasterBeanExcel) {
		this.lEmpmasterBeanExcel = lEmpmasterBeanExcel;
	}

	public List<EmpmasterBean> getObjCompanyInfo() {
		return objCompanyInfo;
	}

	public void setObjCompanyInfo(List<EmpmasterBean> objCompanyInfo) {
		this.objCompanyInfo = objCompanyInfo;
	}

	public List<EmpmasterBean> getObjPortTransmitInfo() {
		return objPortTransmitInfo;
	}

	public void setObjPortTransmitInfo(List<EmpmasterBean> objPortTransmitInfo) {
		this.objPortTransmitInfo = objPortTransmitInfo;
	}

	private List companyList;
	private List departmentList;
	private List designationList;

}
