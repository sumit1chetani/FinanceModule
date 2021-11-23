package com.dci.tenant.finance.inventoryRprt;

public class InventoryRprtBean {

	private int locationId;
	private int itemId;
	private String itemName;
	private String itemCode;
	private String itemDesc;
	private String locationName;
	private double qty;
	private int invId;
	private String invDate;
	private String docDate;
	private String docRef;
	private String docType;
	private String sourcelocation;

	private String itemType;
	private Integer reorderLevel;
	private Integer reorderQty;
	private String stockon;

	private String unit;
	private Double received;
	private Double issued;
	private Double current;
	private String opening;
	private String reject;
	private Double curBal;
	private String fomdate;
	private String todate;
	private String item;
	private String location;
	private String categoryname;
	private String categoryid;
	private String fromdate;

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getReceived() {
		return received;
	}

	public void setReceived(Double received) {
		this.received = received;
	}

	public Double getIssued() {
		return issued;
	}

	public void setIssued(Double issued) {
		this.issued = issued;
	}

	public Double getCurrent() {
		return current;
	}

	public void setCurrent(Double current) {
		this.current = current;
	}

	public String getOpening() {
		return opening;
	}

	public void setOpening(String opening) {
		this.opening = opening;
	}

	public String getReject() {
		return reject;
	}

	public void setReject(String reject) {
		this.reject = reject;
	}

	public Double getCurBal() {
		return curBal;
	}

	public void setCurBal(Double curBal) {
		this.curBal = curBal;
	}

	public String getFomdate() {
		return fomdate;
	}

	public void setFomdate(String fomdate) {
		this.fomdate = fomdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getSourcelocation() {
		return sourcelocation;
	}

	public void setSourcelocation(String sourcelocation) {
		this.sourcelocation = sourcelocation;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	// public int getQty() {
	// return qty;
	// }
	//
	// public void setQty(int qty) {
	// this.qty = qty;
	// }

	public String getDocDate() {
		return docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	public String getDocRef() {
		return docRef;
	}

	public void setDocRef(String docRef) {
		this.docRef = docRef;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Integer getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(Integer reorderQty) {
		this.reorderQty = reorderQty;
	}

	public String getStockon() {
		return stockon;
	}

	public void setStockon(String stockon) {
		this.stockon = stockon;
	}

}
