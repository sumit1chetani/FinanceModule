package com.dci.payroll.payroll.earningdeductionmaster;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EarningDeductionMasterBean {
	private String payComponentId;
	private String payComponentName;
	private boolean permanant;
	private boolean isSelect;
	private boolean allowance;
	private int valueType;
	private BigDecimal value;
	private String percentageAppliedOn;
	private String description;
	private boolean status;
	private int payComponentType;
	private double percentageValue;
	private String payComponentTypeName;
	private double amountValue;
	private String formula;
	private int displayOrder;
	private boolean success;
	private String errormessage;
	private boolean isEdit; // Button Change While Adding and Updating
	private String id;
	private String text;
	private boolean jvMapping;
	private String accountHead;
	private String debitaccountHead;
	private boolean nonStandardDeduction;
	private String type;

	public boolean getNonStandardDeduction() {
		return nonStandardDeduction;
	}

	public void setNonStandardDeduction(boolean nonStandardDeduction) {
		this.nonStandardDeduction = nonStandardDeduction;
	}

	public String getDebitaccountHead() {
		return debitaccountHead;
	}

	public void setDebitaccountHead(String debitaccountHead) {
		this.debitaccountHead = debitaccountHead;
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public boolean isJvMapping() {
		return jvMapping;
	}

	public void setJvMapping(boolean jvMapping) {
		this.jvMapping = jvMapping;
	}

	private List<String> earningList = new ArrayList<>();

	public boolean getisEdit() {
		return isEdit;
	}

	public void setisEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public String getPayComponentId() {
		return payComponentId;
	}

	public void setPayComponentId(String payComponentId) {
		this.payComponentId = payComponentId;
	}

	public String getPayComponentName() {
		return payComponentName;
	}

	public void setPayComponentName(String payComponentName) {
		this.payComponentName = payComponentName;
	}

	public int getValueType() {
		return valueType;
	}

	public void setValueType(int valueType) {
		this.valueType = valueType;
	}

	public String getPercentageAppliedOn() {
		return percentageAppliedOn;
	}

	public void setPercentageAppliedOn(String percentageAppliedOn) {
		this.percentageAppliedOn = percentageAppliedOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getPayComponentType() {
		return payComponentType;
	}

	public void setPayComponentType(int payComponentType) {
		this.payComponentType = payComponentType;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public boolean isPermanant() {
		return permanant;
	}

	public void setPermanant(boolean permanant) {
		this.permanant = permanant;
	}

	public boolean isAllowance() {
		return allowance;
	}

	public void setAllowance(boolean allowance) {
		this.allowance = allowance;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public double getPercentageValue() {
		return percentageValue;
	}

	public void setPercentageValue(double percentageValue) {
		this.percentageValue = percentageValue;
	}

	public double getAmountValue() {
		return amountValue;
	}

	public void setAmountValue(double amountValue) {
		this.amountValue = amountValue;
	}

	public String getPayComponentTypeName() {
		return payComponentTypeName;
	}

	public void setPayComponentTypeName(String payComponentTypeName) {
		this.payComponentTypeName = payComponentTypeName;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}

	public List<String> getEarningList() {
		return earningList;
	}

	public void setEarningList(List<String> earningList) {
		this.earningList = earningList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}