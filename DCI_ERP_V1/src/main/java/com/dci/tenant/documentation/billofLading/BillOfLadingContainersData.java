package com.dci.tenant.documentation.billofLading;

import java.util.List;

public class BillOfLadingContainersData {
 
	private List<BillOfLadingChargesList> chargeList;
    private Integer inwardCntrId;
	private Boolean select;
	private String blNo;
	private String cntrNo;
	private String  sealNo;
	private String size;
	private String type;
	private Double tw;
	private Double gw;
	private Double cb;
	private Double net;
	private String fle;
	private String so;
	private String packageType;
	private Double noOfPckgs;
	private String goods;
	private Boolean iso;
	private String marks;
	private String polTer;
	private String podTer;

	public Integer getInwardCntrId() {
		return inwardCntrId;
	}

	public void setInwardCntrId(Integer inwardCntrId) {
		this.inwardCntrId = inwardCntrId;
	}

	public String getSealNo() {
		return sealNo;
	}

	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public Boolean getSelect() {
		return select;
	}

	public void setSelect(Boolean select) {
		this.select = select;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	 

	public Double getGw() {
		return gw;
	}

	public void setGw(Double gw) {
		this.gw = gw;
	}

	public Double getCb() {
		return cb;
	}

	public void setCb(Double cb) {
		this.cb = cb;
	}

	public Double getNet() {
		return net;
	}

	public void setNet(Double net) {
		this.net = net;
	}

	public String getFle() {
		return fle;
	}

	public void setFle(String fle) {
		this.fle = fle;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public Double getTw() {
		return tw;
	}

	public void setTw(Double tw) {
		this.tw = tw;
	}

	public Double getNoOfPckgs() {
		return noOfPckgs;
	}

	public void setNoOfPckgs(Double noOfPckgs) {
		this.noOfPckgs = noOfPckgs;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public Boolean getIso() {
		return iso;
	}

	public void setIso(Boolean iso) {
		this.iso = iso;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getPolTer() {
		return polTer;
	}

	public void setPolTer(String polTer) {
		this.polTer = polTer;
	}

	public String getPodTer() {
		return podTer;
	}

	public void setPodTer(String podTer) {
		this.podTer = podTer;
	}

	public List<BillOfLadingChargesList> getChargeList() {
		return chargeList;
	}

	public void setChargeList(List<BillOfLadingChargesList> chargeList) {
		this.chargeList = chargeList;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	 

}