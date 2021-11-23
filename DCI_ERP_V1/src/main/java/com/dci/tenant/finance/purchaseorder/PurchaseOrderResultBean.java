package com.dci.tenant.finance.purchaseorder;

import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.tenant.common.CommonUtilityBean;

public class PurchaseOrderResultBean extends BasicResultBean {

	private List<PurchaseOrder> purchaseOrders;
	private List<PurchaseSelect> purchaseFrom;
	private List<PurchaseSelect> purchaseTo;
	private List<PurchaseSelect> purchaseStatus;
	private List<PurchaseSelect> locationList;
	private List<PurchaseSelect> companyList;
	private List<PurchaseSelect> vendorList;
	private List<PurchaseSelect> purchaseReqDropDownList;
	private List<PurchaseSelect> itemList;
	private List<PurchaseSelect> conTransferNoList;
	private List<CommonUtilityBean> commonUtilityBeans;
	public PurchaseOrder purchaseOrder;
	public PurchaseOrderDetail purchaseOrderDetail;
	private List<PurchaseSelect> purchaseOrderDropDownList;
	private List<PurchaseSelect> purchaseInvoiceDropDownList;
	private List<PurchaseSelect> materialIssueDropDownList;

	private List<PurchaseSelect> purchaseOrderStatusDropDownList;
	private List<PurchaseSelect> grnStatusDropDownList;

	public String termsAndConditions;

	public List<PurchaseSelect> getPurchaseOrderStatusDropDownList() {
		return purchaseOrderStatusDropDownList;
	}

	public void setPurchaseOrderStatusDropDownList(List<PurchaseSelect> purchaseOrderStatusDropDownList) {
		this.purchaseOrderStatusDropDownList = purchaseOrderStatusDropDownList;
	}

	public List<PurchaseSelect> getGrnStatusDropDownList() {
		return grnStatusDropDownList;
	}

	public void setGrnStatusDropDownList(List<PurchaseSelect> grnStatusDropDownList) {
		this.grnStatusDropDownList = grnStatusDropDownList;
	}

	public List<PurchaseSelect> getMaterialIssueDropDownList() {
		return materialIssueDropDownList;
	}

	public void setMaterialIssueDropDownList(List<PurchaseSelect> materialIssueDropDownList) {
		this.materialIssueDropDownList = materialIssueDropDownList;
	}

	public List<PurchaseSelect> getPurchaseOrderDropDownList() {
		return purchaseOrderDropDownList;
	}

	public void setPurchaseInvoiceDropDownList(List<PurchaseSelect> purchaseInvoiceDropDownList) {
		this.purchaseInvoiceDropDownList = purchaseInvoiceDropDownList;
	}

	public List<PurchaseSelect> getPurchaseInvoiceDropDownList() {
		return purchaseInvoiceDropDownList;
	}

	public void setPurchaseOrderDropDownList(List<PurchaseSelect> purchaseOrderDropDownList) {
		this.purchaseOrderDropDownList = purchaseOrderDropDownList;
	}

	public List<PurchaseSelect> getPurchaseReqDropDownList() {
		return purchaseReqDropDownList;
	}

	public void setPurchaseReqDropDownList(List<PurchaseSelect> purchaseReqDropDownList) {
		this.purchaseReqDropDownList = purchaseReqDropDownList;
	}

	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public List<PurchaseSelect> getPurchaseFrom() {
		return purchaseFrom;
	}

	public void setPurchaseFrom(List<PurchaseSelect> purchaseFrom) {
		this.purchaseFrom = purchaseFrom;
	}

	public List<PurchaseSelect> getPurchaseTo() {
		return purchaseTo;
	}

	public void setPurchaseTo(List<PurchaseSelect> purchaseTo) {
		this.purchaseTo = purchaseTo;
	}

	public List<PurchaseSelect> getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(List<PurchaseSelect> purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}

	public List<PurchaseSelect> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<PurchaseSelect> locationList) {
		this.locationList = locationList;
	}

	public List<PurchaseSelect> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<PurchaseSelect> companyList) {
		this.companyList = companyList;
	}

	public List<PurchaseSelect> getVendorList() {
		return vendorList;
	}

	public void setVendorList(List<PurchaseSelect> vendorList) {
		this.vendorList = vendorList;
	}

	public List<CommonUtilityBean> getCommonUtilityBeans() {
		return commonUtilityBeans;
	}

	public void setCommonUtilityBeans(List<CommonUtilityBean> commonUtilityBeans) {
		this.commonUtilityBeans = commonUtilityBeans;
	}

	public List<PurchaseSelect> getConTransferNoList() {
		return conTransferNoList;
	}

	public void setConTransferNoList(List<PurchaseSelect> conTransferNoList) {
		this.conTransferNoList = conTransferNoList;
	}

	public List<PurchaseSelect> getItemList() {
		return itemList;
	}

	public void setItemList(List<PurchaseSelect> itemList) {
		this.itemList = itemList;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

}
