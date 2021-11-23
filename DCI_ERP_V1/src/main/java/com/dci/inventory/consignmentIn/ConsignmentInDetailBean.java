package com.dci.inventory.consignmentIn;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.BatchAttributeBean;
import com.dci.tenant.finance.grn.GRNPurchaseOrderBean;

public class ConsignmentInDetailBean {

	private boolean select = false;
	private int itemId;
	private int consignmentInDetId;
	private int purchaseQuotDetId;
	private String batchNumber;
	private Integer batchNoId;
	private int purchaseQuantity;
	private int convertedQuantity;
	private Boolean batchNoExist;

	private ArrayList<ConsignmentInDetailBean> rowCollection;
	private List<BatchAttributeBean> attributeBeans;
	private ArrayList<GRNPurchaseOrderBean> batchDetails;
	private List<GRNPurchaseOrderBean> stockTransferBatchList;

	public ArrayList<ConsignmentInDetailBean> getRowCollection() {
		return rowCollection;
	}

	public void setRowCollection(ArrayList<ConsignmentInDetailBean> rowCollection) {
		this.rowCollection = rowCollection;
	}

	public List<BatchAttributeBean> getAttributeBeans() {
		return attributeBeans;
	}

	public void setAttributeBeans(List<BatchAttributeBean> attributeBeans) {
		this.attributeBeans = attributeBeans;
	}

	public ArrayList<GRNPurchaseOrderBean> getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(ArrayList<GRNPurchaseOrderBean> batchDetails) {
		this.batchDetails = batchDetails;
	}

	public List<GRNPurchaseOrderBean> getStockTransferBatchList() {
		return stockTransferBatchList;
	}

	public void setStockTransferBatchList(List<GRNPurchaseOrderBean> stockTransferBatchList) {
		this.stockTransferBatchList = stockTransferBatchList;
	}

	public int getPurchaseQuotDetId() {
		return purchaseQuotDetId;
	}

	public void setPurchaseQuotDetId(int purchaseQuotDetId) {
		this.purchaseQuotDetId = purchaseQuotDetId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private String itemCode;
	private String itemName;
	private int uom;
	private int itemQuantity;

	private Integer id;
	private String text;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
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

	public int getUom() {
		return uom;
	}

	public void setUom(int uom) {
		this.uom = uom;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getConsignmentInDetId() {
		return consignmentInDetId;
	}

	public void setConsignmentInDetId(int consignmentInDetId) {
		this.consignmentInDetId = consignmentInDetId;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Integer getBatchNoId() {
		return batchNoId;
	}

	public void setBatchNoId(Integer batchNoId) {
		this.batchNoId = batchNoId;
	}

	/**
	 * @return the purchaseQuantity
	 */
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}

	/**
	 * @param purchaseQuantity
	 *            the purchaseQuantity to set
	 */
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

	/**
	 * @return the convertedQuantity
	 */
	public int getConvertedQuantity() {
		return convertedQuantity;
	}

	/**
	 * @param convertedQuantity
	 *            the convertedQuantity to set
	 */
	public void setConvertedQuantity(int convertedQuantity) {
		this.convertedQuantity = convertedQuantity;
	}

	public Boolean getBatchNoExist() {
		return batchNoExist;
	}

	public void setBatchNoExist(Boolean batchNoExist) {
		this.batchNoExist = batchNoExist;
	}

}
