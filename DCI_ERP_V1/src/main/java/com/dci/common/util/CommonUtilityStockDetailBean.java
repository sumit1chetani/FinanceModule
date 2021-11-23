package com.dci.common.util;

import java.util.ArrayList;
import java.util.List;

import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;

public class CommonUtilityStockDetailBean {

	private Integer stockDetId;
	private Integer consignmentInDetId;
	private Integer consignmentOutDetId;
	private Integer requisitionDetId;
	private Integer itemId;
	private String itemCode;
	private String itemName;
	private Integer batchNoId;
	private String batchNumber;
	private Integer uom;
	private Integer quantity;
	private String status;
	private Integer amount;
	private String assetDetailId;
	private List<BatchAttributeBean> attributeBeans;
	private Integer pendingQty;
	private int vendorQty;
	private int oldQuantity = 0;

	private ArrayList<GRNPurchaseOrderBean> batchDetails;

	
	

	public int getOldQuantity() {
		return oldQuantity;
	}

	public void setOldQuantity(int oldQuantity) {
		this.oldQuantity = oldQuantity;
	}

 

	public Integer getBatchNoId() {
		return batchNoId;
	}

	public void setBatchNoId(Integer batchNoId) {
		this.batchNoId = batchNoId;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getAssetDetailId() {
		return assetDetailId;
	}

	public void setAssetDetailId(String assetDetailId) {
		this.assetDetailId = assetDetailId;
	}

	public List<BatchAttributeBean> getAttributeBeans() {
		return attributeBeans;
	}

	public void setAttributeBeans(List<BatchAttributeBean> attributeBeans) {
		this.attributeBeans = attributeBeans;
	}

 
	public Integer getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(Integer pendingQty) {
		this.pendingQty = pendingQty;
	}

	public int getVendorQty() {
		return vendorQty;
	}

	public void setVendorQty(int vendorQty) {
		this.vendorQty = vendorQty;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	private boolean select = false;

	public Integer getRequisitionDetId() {
		return requisitionDetId;
	}

	public void setRequisitionDetId(Integer requisitionDetId) {
		this.requisitionDetId = requisitionDetId;
	}

	public Integer getStockDetId() {
		return stockDetId;
	}

	public void setStockDetId(Integer stockDetId) {
		this.stockDetId = stockDetId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getUom() {
		return uom;
	}

	public void setUom(Integer uom) {
		this.uom = uom;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getConsignmentInDetId() {
		return consignmentInDetId;
	}

	public void setConsignmentInDetId(Integer consignmentInDetId) {
		this.consignmentInDetId = consignmentInDetId;
	}

	public Integer getConsignmentOutDetId() {
		return consignmentOutDetId;
	}

	public void setConsignmentOutDetId(Integer consignmentOutDetId) {
		this.consignmentOutDetId = consignmentOutDetId;
	}

	public ArrayList<GRNPurchaseOrderBean> getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(ArrayList<GRNPurchaseOrderBean> batchDetails) {
		this.batchDetails = batchDetails;
	}

	
}
