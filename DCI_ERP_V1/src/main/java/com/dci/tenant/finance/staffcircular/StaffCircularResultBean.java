package com.dci.tenant.finance.staffcircular;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class StaffCircularResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<SelectivityBean> ldepartmentlist;
	private List<SelectivityBean> ldesignationlist;
	private List<SelectivityBean> lgradelist;
	private List<SelectivityBean> lreportingTolist;
	private List<SelectivityBean> ldivisionlist;
	private StaffCircularBean staffNotificationBeanDetail;
	private List<StaffCircularBean> lstaffNotificationBeanDetail;

	public List<SelectivityBean> getLdepartmentlist() {
		return ldepartmentlist;
	}

	public void setLdepartmentlist(List<SelectivityBean> ldepartmentlist) {
		this.ldepartmentlist = ldepartmentlist;
	}

	public List<SelectivityBean> getLdesignationlist() {
		return ldesignationlist;
	}

	public void setLdesignationlist(List<SelectivityBean> ldesignationlist) {
		this.ldesignationlist = ldesignationlist;
	}

	public List<SelectivityBean> getLgradelist() {
		return lgradelist;
	}

	public void setLgradelist(List<SelectivityBean> lgradelist) {
		this.lgradelist = lgradelist;
	}

	public List<SelectivityBean> getLreportingTolist() {
		return lreportingTolist;
	}

	public void setLreportingTolist(List<SelectivityBean> lreportingTolist) {
		this.lreportingTolist = lreportingTolist;
	}

	public List<SelectivityBean> getLdivisionlist() {
		return ldivisionlist;
	}

	public void setLdivisionlist(List<SelectivityBean> ldivisionlist) {
		this.ldivisionlist = ldivisionlist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StaffCircularBean getStaffNotificationBeanDetail() {
		return staffNotificationBeanDetail;
	}

	public void setStaffNotificationBeanDetail(StaffCircularBean staffNotificationBeanDetail) {
		this.staffNotificationBeanDetail = staffNotificationBeanDetail;
	}

	public List<StaffCircularBean> getLstaffNotificationBeanDetail() {
		return lstaffNotificationBeanDetail;
	}

	public void setLstaffNotificationBeanDetail(List<StaffCircularBean> lstaffNotificationBeanDetail) {
		this.lstaffNotificationBeanDetail = lstaffNotificationBeanDetail;
	}

}
