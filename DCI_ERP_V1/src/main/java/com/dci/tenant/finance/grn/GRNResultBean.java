package com.dci.tenant.finance.grn;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.tenant.common.CommonUtilityBean;


public class GRNResultBean extends BasicResultBean implements Serializable {

	private List<GRNBean> lGRNBean;

	private List<GRNResultBean> grnresultbean;

	private double grnFreight;
	private double grnOtherCharges;

	public double getGrnFreight() {
		return grnFreight;
	}

	public void setGrnFreight(double grnFreight) {
		this.grnFreight = grnFreight;
	}

	public double getGrnOtherCharges() {
		return grnOtherCharges;
	}

	public void setGrnOtherCharges(double grnOtherCharges) {
		this.grnOtherCharges = grnOtherCharges;
	}

	public List<GRNBean> getlGRNBean() {
		return lGRNBean;
	}

	public void setlGRNBean(List<GRNBean> lGRNBean) {
		this.lGRNBean = lGRNBean;
	}

	private List<GRNBean> lLocation;

	private List<GRNBean> lVendor;

	private List<GRNBean> lPurchaseOrder;

	public List<GRNBean> getlLocation() {
		return lLocation;
	}

	public void setlLocation(List<GRNBean> lLocation) {
		this.lLocation = lLocation;
	}

	public List<GRNBean> getlVendor() {
		return lVendor;
	}

	public void setlVendor(List<GRNBean> lVendor) {
		this.lVendor = lVendor;
	}

	public List<GRNBean> getlPurchaseOrder() {
		return lPurchaseOrder;
	}

	public void setlPurchaseOrder(List<GRNBean> lPurchaseOrder) {
		this.lPurchaseOrder = lPurchaseOrder;
	}

	private List<GRNPurchaseOrderBean> lPurchaseOrderDtl;

	public List<GRNPurchaseOrderBean> getlPurchaseOrderDtl() {
		return lPurchaseOrderDtl;
	}

	public void setlPurchaseOrderDtl(List<GRNPurchaseOrderBean> lPurchaseOrderDtl) {
		this.lPurchaseOrderDtl = lPurchaseOrderDtl;
	}

	private List<GRNBean> lRequisitionList;

	public List<GRNBean> getlRequisitionList() {
		return lRequisitionList;
	}

	public void setlRequisitionList(List<GRNBean> lRequisitionList) {
		this.lRequisitionList = lRequisitionList;
	}

	private List<GRNPurchaseOrderBean> lVendorAddressDtl;

	public List<GRNPurchaseOrderBean> getlVendorAddressDtl() {
		return lVendorAddressDtl;
	}

	public void setlVendorAddressDtl(List<GRNPurchaseOrderBean> lVendorAddressDtl) {
		this.lVendorAddressDtl = lVendorAddressDtl;
	}

	private List<GRNPurchaseOrderBean> lRequisitionDtl;

	public List<GRNPurchaseOrderBean> getlRequisitionDtl() {
		return lRequisitionDtl;
	}

	public void setlRequisitionDtl(List<GRNPurchaseOrderBean> lRequisitionDtl) {
		this.lRequisitionDtl = lRequisitionDtl;
	}

	public GRNBean editBeanData;

	public GRNBean getEditBeanData() {
		return editBeanData;
	}

	public void setEditBeanData(GRNBean editBeanData) {
		this.editBeanData = editBeanData;
	}

	private List<GRNPurchaseOrderBean> lScheduleDtl;

	public List<GRNPurchaseOrderBean> getlScheduleDtl() {
		return lScheduleDtl;
	}

	public void setlScheduleDtl(List<GRNPurchaseOrderBean> lScheduleDtl) {
		this.lScheduleDtl = lScheduleDtl;
	}

	private List<CommonUtilityBean> lLocationLst;

	public List<CommonUtilityBean> getlLocationLst() {
		return lLocationLst;
	}

	public void setlLocationLst(List<CommonUtilityBean> lLocationLst) {
		this.lLocationLst = lLocationLst;
	}

	private GRNPurchaseOrderBean itemAttributes;

	public GRNPurchaseOrderBean getItemAttributes() {
		return itemAttributes;
	}

	public void setItemAttributes(GRNPurchaseOrderBean itemAttributes) {
		this.itemAttributes = itemAttributes;
	}

	public List<GRNResultBean> getGrnresultbean() {
		return grnresultbean;
	}

	public void setGrnresultbean(List<GRNResultBean> grnresultbean) {
		this.grnresultbean = grnresultbean;
	}

	public Object getVendorId() {
		// TODO Auto-generated method stub
		return null;
	}

}
