package com.dci.operation.voyage.thirdPartyVoyage;



import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

 
public class ThirdPartyVoyageResultBean extends BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ThirdPartyVoyageBean> thirdPartyVoyageList;

	private List<ThirdPartyVoyageBean> voyageList;

	private List<ThirdPartyVoyageBean> vesselList;
	private List<ThirdPartyVoyageBean> vesselList1;

	private List<ThirdPartyVoyageBean> serviceList;

	private List<ThirdPartyVoyageBean> activityTypes;

	private List<ThirdPartyVoyagePortBean> portList;

	private ThirdPartyVoyageBean thirtyPartyVoyageHeader;

	private List<ThirdPartyVoyagePortBean> voyageDtlList;

	private List<ThirdPartyVoyageBean> editThirdPartyVoyageHeaderList;

	private List<ThirdPartyVoyageBean> mloShortNameList;
	
	private List<Integer> removedIndex;

	private String voyageFlag;
	
	private String purchaseQuotMailMsg;
	
	private List<ThirdPartyVoyageBean> searchList;
	

	public List<ThirdPartyVoyageBean> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<ThirdPartyVoyageBean> searchList) {
		this.searchList = searchList;
	}

	public List<ThirdPartyVoyageBean> getVoyageList() {
		return voyageList;
	}

	public void setVoyageList(List<ThirdPartyVoyageBean> voyageList) {
		this.voyageList = voyageList;
	}

	public List<ThirdPartyVoyageBean> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<ThirdPartyVoyageBean> vesselList) {
		this.vesselList = vesselList;
	}

	public List<ThirdPartyVoyageBean> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<ThirdPartyVoyageBean> serviceList) {
		this.serviceList = serviceList;
	}

	public List<ThirdPartyVoyageBean> getActivityTypes() {
		return activityTypes;
	}

	public void setActivityTypes(List<ThirdPartyVoyageBean> activityTypes) {
		this.activityTypes = activityTypes;
	}

	public List<ThirdPartyVoyagePortBean> getPortList() {
		return portList;
	}

	public void setPortList(List<ThirdPartyVoyagePortBean> portList) {
		this.portList = portList;
	}

	public ThirdPartyVoyageBean getThirtyPartyVoyageHeader() {
		return thirtyPartyVoyageHeader;
	}

	public void setThirtyPartyVoyageHeader(ThirdPartyVoyageBean thirtyPartyVoyageHeader) {
		this.thirtyPartyVoyageHeader = thirtyPartyVoyageHeader;
	}

	public List<ThirdPartyVoyagePortBean> getVoyageDtlList() {
		return voyageDtlList;
	}

	public void setVoyageDtlList(List<ThirdPartyVoyagePortBean> voyageDtlList) {
		this.voyageDtlList = voyageDtlList;
	}

	public List<ThirdPartyVoyageBean> getEditThirdPartyVoyageHeaderList() {
		return editThirdPartyVoyageHeaderList;
	}

	public void setEditThirdPartyVoyageHeaderList(List<ThirdPartyVoyageBean> editThirdPartyVoyageHeaderList) {
		this.editThirdPartyVoyageHeaderList = editThirdPartyVoyageHeaderList;
	}

	public String getVoyageFlag() {
		return voyageFlag;
	}

	public void setVoyageFlag(String voyageFlag) {
		this.voyageFlag = voyageFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ThirdPartyVoyageBean> getThirdPartyVoyageList() {
		return thirdPartyVoyageList;
	}

	public void setThirdPartyVoyageList(List<ThirdPartyVoyageBean> thirdPartyVoyageList) {
		this.thirdPartyVoyageList = thirdPartyVoyageList;
	}

	public List<ThirdPartyVoyageBean> getMloShortNameList() {
		return mloShortNameList;
	}

	public void setMloShortNameList(List<ThirdPartyVoyageBean> mloShortNameList) {
		this.mloShortNameList = mloShortNameList;
	}

	public List<Integer> getRemovedIndex() {
		return removedIndex;
	}

	public void setRemovedIndex(List<Integer> removedIndex) {
		this.removedIndex = removedIndex;
	}

	public String getPurchaseQuotMailMsg() {
		return purchaseQuotMailMsg;
	}

	public void setPurchaseQuotMailMsg(String purchaseQuotMailMsg) {
		this.purchaseQuotMailMsg = purchaseQuotMailMsg;
	}

	public List<ThirdPartyVoyageBean> getVesselList1() {
		return vesselList1;
	}

	public void setVesselList1(List<ThirdPartyVoyageBean> vesselList1) {
		this.vesselList1 = vesselList1;
	}


}

