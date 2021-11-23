package com.dci.tenant.common;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;
import com.dci.common.util.CommonUtilityStockoutBean;

public class CommonUtilityResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<SelectivityBean> lCommonUtilityBean1;
	private List<SelectivityBean> lCommonUtilityBean2;
	private List<SelectivityBean> containerTypeList;
	private List<SelectivityBean> leaseAggTypeList;
	private List<SelectivityBean> customercategory;
	private List<SelectivityBean> lClassBasedOnSpecificRigths;

	public List<SelectivityBean> getlCommonUtilityBean1() {
		return lCommonUtilityBean1;
	}

	public void setlCommonUtilityBean1(List<SelectivityBean> lCommonUtilityBean1) {
		this.lCommonUtilityBean1 = lCommonUtilityBean1;
	}

	private List<CommonUtilityBean> lCommonUtilityBean;
	
	private List<CommonUtilityBean> lCommonUtilityBeanList;

	

	private CommonUtilityBean commonUtilityBean;
	
	private CommonUtilityStockoutBean commonUtilityStockoutBean;
	
	
	
	public List<CommonUtilityBean> getlCommonUtilityBeanList() {
		return lCommonUtilityBeanList;
	}

	public void setlCommonUtilityBeanList(
			List<CommonUtilityBean> lCommonUtilityBeanList) {
		this.lCommonUtilityBeanList = lCommonUtilityBeanList;
	}

	public List<CommonUtilityBean> getlCommonUtilityBean() {
		return lCommonUtilityBean;
	}

	public void setlCommonUtilityBean(List<CommonUtilityBean> lCommonUtilityBean) {
		this.lCommonUtilityBean = lCommonUtilityBean;
	}

	public CommonUtilityStockoutBean getCommonUtilityStockoutBean() {
		return commonUtilityStockoutBean;
	}

	public void setCommonUtilityStockoutBean(
			CommonUtilityStockoutBean commonUtilityStockoutBean) {
		this.commonUtilityStockoutBean = commonUtilityStockoutBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<CommonUtilityBean> getCommonUtilityBean() {
		return lCommonUtilityBean;
	}

	public void setCommonUtilityBean(List<CommonUtilityBean> lCommonUtilityBean) {
		this.lCommonUtilityBean = lCommonUtilityBean;
	}

	public void setCommonUtilityBean(CommonUtilityBean commonUtilityBean) {
		this.commonUtilityBean = commonUtilityBean;
	}

	public List<SelectivityBean> getlCommonUtilityBean2() {
		return lCommonUtilityBean2;
	}

	public void setlCommonUtilityBean2(List<SelectivityBean> lCommonUtilityBean2) {
		this.lCommonUtilityBean2 = lCommonUtilityBean2;
	}

	public List<SelectivityBean> getContainerTypeList() {
		return containerTypeList;
	}

	public void setContainerTypeList(List<SelectivityBean> containerTypeList) {
		this.containerTypeList = containerTypeList;
	}
	
	public List<SelectivityBean> getLeaseAggTypeList() {
		return leaseAggTypeList;
	}

	public void setLeaseAggTypeList(List<SelectivityBean> leaseAggTypeList) {
		this.leaseAggTypeList = leaseAggTypeList;
	}

	public List<SelectivityBean> getCustomercategory() {
		return customercategory;
	}

	public void setCustomercategory(List<SelectivityBean> customercategory) {
		this.customercategory = customercategory;
	}

	public List<SelectivityBean> getlClassBasedOnSpecificRigths() {
		return lClassBasedOnSpecificRigths;
	}

	public void setlClassBasedOnSpecificRigths(List<SelectivityBean> lClassBasedOnSpecificRigths) {
		this.lClassBasedOnSpecificRigths = lClassBasedOnSpecificRigths;
	}
	
	
	

	
}
