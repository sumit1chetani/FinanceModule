package com.dci.tenant.finance.manageitem;

import java.util.ArrayList;
import java.util.List;

public class ManageItemBean {

	public int itemId;
	public int itemTypeId;
	public String itemType;
	public String itemCode;
	public String itemName;
	public String itemDescription;
	public String defaultrate;
	public boolean isAutoIssue;
	public boolean isServiceType;
	public boolean autoissue;
	private Integer id;

	public int tax;
	public double cgst;
	public double sgst;
	public double igst;
	public double openingQty;
	public double currentQty;
	private int altuom;
	private double altqty;
	private String altuomName;

	public int getAltuom() {
		return altuom;
	}

	public void setAltuom(int altuom) {
		this.altuom = altuom;
	}

	public double getAltqty() {
		return altqty;
	}

	public void setAltqty(double altqty) {
		this.altqty = altqty;
	}

	public String getAltuomName() {
		return altuomName;
	}

	public void setAltuomName(String altuomName) {
		this.altuomName = altuomName;
	}

	public double getCurrentQty() {
		return currentQty;
	}

	public void setCurrentQty(double currentQty) {
		this.currentQty = currentQty;
	}

	public double getOpeningQty() {
		return openingQty;
	}

	public void setOpeningQty(double openingQty) {
		this.openingQty = openingQty;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public boolean isAutoissue() {
		return autoissue;
	}

	public void setAutoissue(boolean autoissue) {
		this.autoissue = autoissue;
	}

	public String getDefaultrate() {
		return defaultrate;
	}

	public void setDefaultrate(String defaultrate) {
		this.defaultrate = defaultrate;
	}

	public int itemCategoryId;

	public boolean isAutoIssue() {
		return isAutoIssue;
	}

	public void setAutoIssue(boolean isAutoIssue) {
		this.isAutoIssue = isAutoIssue;
	}

	public boolean isServiceType() {
		return isServiceType;
	}

	public void setServiceType(boolean isServiceType) {
		this.isServiceType = isServiceType;
	}

	public String itemCategory;
	private String itemCategorytype;
	private boolean select = false;
	public boolean isSaleable;
	public boolean isPurchaseable;
	public boolean isRequestable;
	public int purchaseId;
	public String purchase;
	public int uomId;
	public String uom;
	public String reorderLevel;
	public double minQuantity;
	public double maxQuantity;
	public int costingId;
	public String costing;
	public int warranty;
	public double costPrice;
	public String leadTime;
	public int inventoryValuationId;
	public String inventoryValuation;
	public int issueId;
	public String issue;

	public boolean isMrp;
	public boolean isBatch;
	public boolean isExpiry;
	public boolean isManfactureDetails;

	private List tables[];
	private ArrayList<String> ldeleteIds;
	private List<ManageItemVendorBean> lmanageitemvendor;

	private String text;
	private String typeinput;
	private String labelName;
	private String defaultvalue;

	private String attributeId;
	private String attributevalue;
	private String itemSpecificationId;

	// Line Chart
	private String docDate;
	// private Integer qty;
	private Double qty;
	private Integer maxQty;
	private Integer minQty;
	private Integer avgQty;
	private Integer totalQty;

	private boolean isEditCate = false;

	// public Integer getQty() {
	// return qty;
	// }
	//
	// public void setQty(Integer qty) {
	// this.qty = qty;
	// }

	public Integer getMaxQty() {
		return maxQty;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public void setMaxQty(Integer maxQty) {
		this.maxQty = maxQty;
	}

	public Integer getMinQty() {
		return minQty;
	}

	public void setMinQty(Integer minQty) {
		this.minQty = minQty;
	}

	public Integer getAvgQty() {
		return avgQty;
	}

	public void setAvgQty(Integer avgQty) {
		this.avgQty = avgQty;
	}

	public Integer getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(Integer totalQty) {
		this.totalQty = totalQty;
	}

	private List<ManageItemBean> specificationList;

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributevalue() {
		return attributevalue;
	}

	public void setAttributevalue(String attributevalue) {
		this.attributevalue = attributevalue;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeinput() {
		return typeinput;
	}

	public void setTypeinput(String typeinput) {
		this.typeinput = typeinput;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	/**
	 * @return the lmanageitemvendor
	 */
	public List<ManageItemVendorBean> getLmanageitemvendor() {
		return lmanageitemvendor;
	}

	/**
	 * @param lmanageitemvendor
	 *            the lmanageitemvendor to set
	 */
	public void setLmanageitemvendor(List<ManageItemVendorBean> lmanageitemvendor) {
		this.lmanageitemvendor = lmanageitemvendor;
	}

	/**
	 * @return the itemTypeId
	 */
	public int getItemTypeId() {
		return itemTypeId;
	}

	/**
	 * @param itemTypeId
	 *            the itemTypeId to set
	 */
	public void setItemTypeId(int itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType
	 *            the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return the itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * @param itemCode
	 *            the itemCode to set
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * @param itemDescription
	 *            the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * @return the itemCategoryId
	 */
	public int getItemCategoryId() {
		return itemCategoryId;
	}

	/**
	 * @param itemCategoryId
	 *            the itemCategoryId to set
	 */
	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	/**
	 * @return the itemCategory
	 */
	public String getItemCategory() {
		return itemCategory;
	}

	/**
	 * @param itemCategory
	 *            the itemCategory to set
	 */
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	/**
	 * @return the isSaleable
	 */
	public boolean isSaleable() {
		return isSaleable;
	}

	/**
	 * @param isSaleable
	 *            the isSaleable to set
	 */
	public void setSaleable(boolean isSaleable) {
		this.isSaleable = isSaleable;
	}

	/**
	 * @return the isPurchaseable
	 */
	public boolean isPurchaseable() {
		return isPurchaseable;
	}

	/**
	 * @param isPurchaseable
	 *            the isPurchaseable to set
	 */
	public void setPurchaseable(boolean isPurchaseable) {
		this.isPurchaseable = isPurchaseable;
	}

	/**
	 * @return the isRequestable
	 */
	public boolean isRequestable() {
		return isRequestable;
	}

	/**
	 * @param isRequestable
	 *            the isRequestable to set
	 */
	public void setRequestable(boolean isRequestable) {
		this.isRequestable = isRequestable;
	}

	/**
	 * @return the purchaseId
	 */
	public int getPurchaseId() {
		return purchaseId;
	}

	/**
	 * @param purchaseId
	 *            the purchaseId to set
	 */
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * @return the purchase
	 */
	public String getPurchase() {
		return purchase;
	}

	/**
	 * @param purchase
	 *            the purchase to set
	 */
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}

	/**
	 * @return the uomId
	 */
	public int getUomId() {
		return uomId;
	}

	/**
	 * @param uomId
	 *            the uomId to set
	 */
	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	/**
	 * @return the uom
	 */
	public String getUom() {
		return uom;
	}

	/**
	 * @param uom
	 *            the uom to set
	 */
	public void setUom(String uom) {
		this.uom = uom;
	}

	/**
	 * @return the reorderLevel
	 */
	public String getReorderLevel() {
		return reorderLevel;
	}

	/**
	 * @param reorderLevel
	 *            the reorderLevel to set
	 */
	public void setReorderLevel(String reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	/**
	 * @return the minQuantity
	 */
	public double getMinQuantity() {
		return minQuantity;
	}

	/**
	 * @param minQuantity
	 *            the minQuantity to set
	 */
	public void setMinQuantity(double minQuantity) {
		this.minQuantity = minQuantity;
	}

	/**
	 * @return the maxQuantity
	 */
	public double getMaxQuantity() {
		return maxQuantity;
	}

	/**
	 * @param maxQuantity
	 *            the maxQuantity to set
	 */
	public void setMaxQuantity(double maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	/**
	 * @return the costingId
	 */
	public int getCostingId() {
		return costingId;
	}

	/**
	 * @param costingId
	 *            the costingId to set
	 */
	public void setCostingId(int costingId) {
		this.costingId = costingId;
	}

	/**
	 * @return the costing
	 */
	public String getCosting() {
		return costing;
	}

	/**
	 * @param costing
	 *            the costing to set
	 */
	public void setCosting(String costing) {
		this.costing = costing;
	}

	/**
	 * @return the warranty
	 */
	public int getWarranty() {
		return warranty;
	}

	/**
	 * @param warranty
	 *            the warranty to set
	 */
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	/**
	 * @return the costPrice
	 */
	public double getCostPrice() {
		return costPrice;
	}

	/**
	 * @param costPrice
	 *            the costPrice to set
	 */
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	/**
	 * @return the leadTime
	 */
	public String getLeadTime() {
		return leadTime;
	}

	/**
	 * @param leadTime
	 *            the leadTime to set
	 */
	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}

	/**
	 * @return the inventoryValuationId
	 */
	public int getInventoryValuationId() {
		return inventoryValuationId;
	}

	/**
	 * @param inventoryValuationId
	 *            the inventoryValuationId to set
	 */
	public void setInventoryValuationId(int inventoryValuationId) {
		this.inventoryValuationId = inventoryValuationId;
	}

	/**
	 * @return the inventoryValuation
	 */
	public String getInventoryValuation() {
		return inventoryValuation;
	}

	/**
	 * @param inventoryValuation
	 *            the inventoryValuation to set
	 */
	public void setInventoryValuation(String inventoryValuation) {
		this.inventoryValuation = inventoryValuation;
	}

	/**
	 * @return the issueId
	 */
	public int getIssueId() {
		return issueId;
	}

	/**
	 * @param issueId
	 *            the issueId to set
	 */
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	/**
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * @param issue
	 *            the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @return the tables
	 */
	public List[] getTables() {
		return tables;
	}

	/**
	 * @param tables
	 *            the tables to set
	 */
	public void setTables(List[] tables) {
		this.tables = tables;
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the ldeleteIds
	 */
	public ArrayList<String> getLdeleteIds() {
		return ldeleteIds;
	}

	/**
	 * @param ldeleteIds
	 *            the ldeleteIds to set
	 */
	public void setLdeleteIds(ArrayList<String> ldeleteIds) {
		this.ldeleteIds = ldeleteIds;
	}

	public List<ManageItemBean> getSpecificationList() {
		return specificationList;
	}

	public void setSpecificationList(List<ManageItemBean> specificationList) {
		this.specificationList = specificationList;
	}

	public String getItemSpecificationId() {
		return itemSpecificationId;
	}

	public void setItemSpecificationId(String itemSpecificationId) {
		this.itemSpecificationId = itemSpecificationId;
	}

	/**
	 * @return the isMrp
	 */
	public boolean isMrp() {
		return isMrp;
	}

	/**
	 * @param isMrp
	 *            the isMrp to set
	 */
	public void setMrp(boolean isMrp) {
		this.isMrp = isMrp;
	}

	/**
	 * @return the isBatch
	 */
	public boolean isBatch() {
		return isBatch;
	}

	/**
	 * @param isBatch
	 *            the isBatch to set
	 */
	public void setBatch(boolean isBatch) {
		this.isBatch = isBatch;
	}

	/**
	 * @return the isExpiry
	 */
	public boolean isExpiry() {
		return isExpiry;
	}

	/**
	 * @param isExpiry
	 *            the isExpiry to set
	 */
	public void setExpiry(boolean isExpiry) {
		this.isExpiry = isExpiry;
	}

	/**
	 * @return the isManfactureDetails
	 */
	public boolean isManfactureDetails() {
		return isManfactureDetails;
	}

	/**
	 * @param isManfactureDetails
	 *            the isManfactureDetails to set
	 */
	public void setManfactureDetails(boolean isManfactureDetails) {
		this.isManfactureDetails = isManfactureDetails;
	}

	/**
	 * @return the itemCategorytype
	 */
	public String getItemCategorytype() {
		return itemCategorytype;
	}

	/**
	 * @param itemCategorytype
	 *            the itemCategorytype to set
	 */
	public void setItemCategorytype(String itemCategorytype) {
		this.itemCategorytype = itemCategorytype;
	}

	public String getDocDate() {
		return docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isEditCate() {
		return isEditCate;
	}

	public void setEditCate(boolean isEditCate) {
		this.isEditCate = isEditCate;
	}

}
