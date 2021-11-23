package com.dci.tenant.master.chargeHead;
import com.dci.tenant.auditlog.AuditLoggable;
import com.dci.tenant.auditlog.AuditLoggableType;
@AuditLoggableType(tableName = "charge_head", formCode = "F5090")
public class ChargeHeadBean {
	private Integer id;
	private Integer sacNo;
	private Integer group;
	private String plName;
	private String slName;

	private String groupName1;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@AuditLoggable(fieldName = "sac_no", displayName = "SAC NO")
	public Integer getSacNo() {
		return sacNo;
	}
	public void setSacNo(Integer sacNo) {
		this.sacNo = sacNo;
	}
	
	@AuditLoggable(fieldName = "prchs_ldgr_nam", displayName = "Purchase Ledger Name")
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	@AuditLoggable(fieldName = "sls_ldgr_nam", displayName = "Sales Ledger Name")
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	private String code;
	private String name;
	private String pName;
	private String sName;
	private String groupName;
    private String accountHead;
    private String accountHeadName;
    private Double cgst;
    private Double sgst;
    private Double igst;
    private Double gst;

 
	public Double getGst() {
		return gst;
	}
	public void setGst(Double gst) {
		this.gst = gst;
	}
	public Double getCgst() {
		return cgst;
	}
	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}
	public Double getSgst() {
		return sgst;
	}
	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}
	public Double getIgst() {
		return igst;
	}
	public void setIgst(Double igst) {
		this.igst = igst;
	}
	public String getAccountHeadName() {
		return accountHeadName;
	}
	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}
	public String getAccountHead() {
		return accountHead;
	}
	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@AuditLoggable(fieldName = "chrg_hd_cd", displayName = "Charge Head Code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@AuditLoggable(fieldName = "chrg_hd_nam", displayName = "Charge Head Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	
	@AuditLoggable(fieldName = "chrg_hd_grp_id", displayName = "Charge Head Group")
	public Integer getGroup() {
		return group;
	}
	public void setGroup(Integer group) {
		this.group = group;
	}
	
	@AuditLoggable(fieldName = "dscrptn_vc", displayName = "Description")
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getMdyDate() {
		return mdyDate;
	}
	public void setMdyDate(String mdyDate) {
		this.mdyDate = mdyDate;
	}
	public String getIsStstus() {
		return isStstus;
	}
	public void setIsStstus(String isStstus) {
		this.isStstus = isStstus;
	}
	public String getMdyBy() {
		return mdyBy;
	}
	public void setMdyBy(String mdyBy) {
		this.mdyBy = mdyBy;
	}
	public String getCrtdDate() {
		return crtdDate;
	}
	public void setCrtdDate(String crtdDate) {
		this.crtdDate = crtdDate;
	}
	public String getCrtdBy() {
		return crtdBy;
	}
	public void setCrtdBy(String crtdBy) {
		this.crtdBy = crtdBy;
	}
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
	
	
	public String getPlName() {
		return plName;
	}
	public void setPlName(String plName) {
		this.plName = plName;
	}
	public String getSlName() {
		return slName;
	}
	public void setSlName(String slName) {
		this.slName = slName;
	}
	
	
	public String getGroupName1() {
		return groupName1;
	}
	public void setGroupName1(String groupName1) {
		this.groupName1 = groupName1;
	}
	private String description;
	public boolean isActive;
	
	private String mdyDate;
	private String isStstus;

	private String mdyBy;
	private String crtdDate;
	private String crtdBy;

	
	private String tableName;
	private String formCode;
}
