package com.dci.tenant.finance.consignmentRequest;

public class ConsignmentRequestSubBean {

	private int purchaseRequisitionId;
	private int purchaseRequisitionSubId;
	private String itemCode;
	private String itemName;
	private String itemDesc;
	private Integer itemCategoryId;
	private String itemCategoryName;
	private String itemdescription;
	private double availQuantity;
	private Integer altuom;
	private double altqty;
	private boolean miexist;

	private String altuomName;

	public boolean isMiexist() {
		return miexist;
	}

	public void setMiexist(boolean miexist) {
		this.miexist = miexist;
	}

	public Integer getAltuom() {
		return altuom;
	}

	public void setAltuom(Integer altuom) {
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

	public double getAvailQuantity() {
		return availQuantity;
	}

	public void setAvailQuantity(double availQuantity) {
		this.availQuantity = availQuantity;
	}

	public String getItemdescription() {
		return itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	private Integer uomId;
	private Object section;
	private String uomName;
	private String eddDate;
	private double quantity;
	private String itemId;
	private int slNo;
	private boolean disableDate = false;

	private String id;
	private String text;

	private Integer item;

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPurchaseRequisitionId() {
		return purchaseRequisitionId;
	}

	public void setPurchaseRequisitionId(int purchaseRequisitionId) {
		this.purchaseRequisitionId = purchaseRequisitionId;
	}

	public int getPurchaseRequisitionSubId() {
		return purchaseRequisitionSubId;
	}

	public void setPurchaseRequisitionSubId(int purchaseRequisitionSubId) {
		this.purchaseRequisitionSubId = purchaseRequisitionSubId;
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

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Integer getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(Integer itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getEddDate() {
		return eddDate;
	}

	public void setEddDate(String eddDate) {
		this.eddDate = eddDate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public Object getSection() {
		return section;
	}

	public void setSection(Object section) {
		this.section = section;
	}

	public boolean isDisableDate() {
		return disableDate;
	}

	public void setDisableDate(boolean disableDate) {
		this.disableDate = disableDate;
	}

}
