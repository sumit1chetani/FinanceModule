package com.dci.tenant.finance.purchasequotation;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.common.util.DefTableBean;
import com.dci.master.settings.UOM.EntityBean;
import com.dci.tenant.finance.storeToStore.StoreToStore;
import com.dci.tenant.finance.storeToStore.StoreToStoreSubBean;

public class PurchaseQuotationResultBean extends BasicResultBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<DefTableBean> purchaseForList;
	private List<DefTableBean> purchaseTypeList;

	public List<PurchaseQuotationDetail> getQuotationDetailList() {
		return quotationDetailList;
	}

	public void setQuotationDetailList(List<PurchaseQuotationDetail> quotationDetailList) {
		this.quotationDetailList = quotationDetailList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private List<EntityBean> vendorList;
	private List<StoreToStore> requisitionList;
	private List<StoreToStoreSubBean> itemList;
	private List<DefTableBean> taxList;
	private List<DefTableBean> discountTypeList;
	private List<DefTableBean> statusList;
	private List<PurchaseQuotationDetail> quotationDetailList = new ArrayList<PurchaseQuotationDetail>();

	private List<PurchaseQuotation> quotationList;
	private PurchaseQuotation purchaseQuotation = new PurchaseQuotation();
	private PurchaseQuotationDetail purchaseQuotationDetail = new PurchaseQuotationDetail();

	public List<DefTableBean> getPurchaseForList() {
		return purchaseForList;
	}

	public void setPurchaseForList(List<DefTableBean> purchaseForList) {
		this.purchaseForList = purchaseForList;
	}

	public List<DefTableBean> getPurchaseTypeList() {
		return purchaseTypeList;
	}

	public void setPurchaseTypeList(List<DefTableBean> purchaseTypeList) {
		this.purchaseTypeList = purchaseTypeList;
	}

	public List<EntityBean> getVendorList() {
		return vendorList;
	}

	public void setVendorList(List<EntityBean> vendorList) {
		this.vendorList = vendorList;
	}

	public List<StoreToStoreSubBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<StoreToStoreSubBean> itemList) {
		this.itemList = itemList;
	}

	public List<DefTableBean> getTaxList() {
		return taxList;
	}

	public void setTaxList(List<DefTableBean> taxList) {
		this.taxList = taxList;
	}

	public List<DefTableBean> getDiscountTypeList() {
		return discountTypeList;
	}

	public void setDiscountTypeList(List<DefTableBean> discountTypeList) {
		this.discountTypeList = discountTypeList;
	}

	public List<DefTableBean> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<DefTableBean> statusList) {
		this.statusList = statusList;
	}

	public PurchaseQuotation getPurchaseQuotation() {
		return purchaseQuotation;
	}

	public void setPurchaseQuotation(PurchaseQuotation purchaseQuotation) {
		this.purchaseQuotation = purchaseQuotation;
	}

	public List<StoreToStore> getRequisitionList() {
		return requisitionList;
	}

	public void setRequisitionList(List<StoreToStore> requisitionList) {
		this.requisitionList = requisitionList;
	}

	public List<PurchaseQuotation> getQuotationList() {
		return quotationList;
	}

	public void setQuotationList(List<PurchaseQuotation> quotationList) {
		this.quotationList = quotationList;
	}

	public PurchaseQuotationDetail getPurchaseQuotationDetail() {
		return purchaseQuotationDetail;
	}

	public void setPurchaseQuotationDetail(PurchaseQuotationDetail purchaseQuotationDetail) {
		this.purchaseQuotationDetail = purchaseQuotationDetail;
	}

}
