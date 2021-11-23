package com.dci.payroll.payroll.gradepaycomponent;

public class GradePayComponentBean {
	private Integer gradeId;
	private String fromdate;
	private String payComponentId;
	private String payComponentName;
	private String percentageAppliedOn;
	private double amount;
	private double value;
	private String status;
	private String gradeName;
	private int payComponentType;
	private String id;
	private String text;
	private String select;

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
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

	public String getPercentageAppliedOn() {
		return percentageAppliedOn;
	}

	public void setPercentageAppliedOn(String percentageAppliedOn) {
		this.percentageAppliedOn = percentageAppliedOn;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getPayComponentType() {
		return payComponentType;
	}

	public void setPayComponentType(int payComponentType) {
		this.payComponentType = payComponentType;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

}