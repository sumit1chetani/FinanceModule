package com.dci.master.settings.UOM;

import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;

@AuditLoggableType(tableName = "uom", formCode = "F5192")
public class ManageUOM {

	private Integer uomId;
	private String uomName;
	private String uomDescription;
	private double roundPrecision;
	private int uomCategoryId;
	private String uomCategoryName;
	private double ratio;
	private boolean baseUOM = false;
	private String tableName;
	private String formCode;
	
	

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	private int id;
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@AuditLoggable(fieldName = "uom_category_id", displayName = "uomCategoryId")
	public int getUomCategoryId() {
		return uomCategoryId;
	}

	public void setUomCategoryId(int uomCategoryId) {
		this.uomCategoryId = uomCategoryId;
	}

	public String getUomCategoryName() {
		return uomCategoryName;
	}

	public void setUomCategoryName(String uomCategoryName) {
		this.uomCategoryName = uomCategoryName;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public double getRoundPrecision() {
		return roundPrecision;
	}

	public void setRoundPrecision(double roundPrecision) {
		this.roundPrecision = roundPrecision;
	}

	@AuditLoggable(fieldName = "uom_description", displayName = "uomDescription")
	public String getUomDescription() {
		return uomDescription;
	}

	public void setUomDescription(String uomDescription) {
		this.uomDescription = uomDescription;
	}	

	@AuditLoggable(fieldName = "uom", displayName = "uomName")
	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public boolean isBaseUOM() {
		return baseUOM;
	}

	public void setBaseUOM(boolean baseUOM) {
		this.baseUOM = baseUOM;
	}

}
