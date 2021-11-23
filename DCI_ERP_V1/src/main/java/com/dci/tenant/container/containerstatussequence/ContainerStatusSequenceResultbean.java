package com.dci.tenant.container.containerstatussequence;

import java.io.Serializable;
import java.util.List;

public class ContainerStatusSequenceResultbean  implements Serializable{
	
	private List<ContainerStatusSequenceBean> damage_recordDtl;

	private ContainerStatusSequenceBean damage_recordBean = new ContainerStatusSequenceBean();

	private List<String> errorList;

	private List listAgreementPartyList;
	private List listAgreementTypeList;
	private List listLocationList;
	private List listDamageCodeList;
	private List listContainerTypeList;
	private List listContainerNoList;
	private List listDamageStatusList;
	private List listRepairProcessList;
	private List listStatusList;
	public List<ContainerStatusSequenceBean> getDamage_recordDtl() {
		return damage_recordDtl;
	}
	public void setDamage_recordDtl(List<ContainerStatusSequenceBean> damage_recordDtl) {
		this.damage_recordDtl = damage_recordDtl;
	}
	public ContainerStatusSequenceBean getDamage_recordBean() {
		return damage_recordBean;
	}
	public void setDamage_recordBean(ContainerStatusSequenceBean damage_recordBean) {
		this.damage_recordBean = damage_recordBean;
	}
	public List<String> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	public List getListAgreementPartyList() {
		return listAgreementPartyList;
	}
	public void setListAgreementPartyList(List listAgreementPartyList) {
		this.listAgreementPartyList = listAgreementPartyList;
	}
	public List getListAgreementTypeList() {
		return listAgreementTypeList;
	}
	public void setListAgreementTypeList(List listAgreementTypeList) {
		this.listAgreementTypeList = listAgreementTypeList;
	}
	public List getListLocationList() {
		return listLocationList;
	}
	public void setListLocationList(List listLocationList) {
		this.listLocationList = listLocationList;
	}
	public List getListDamageCodeList() {
		return listDamageCodeList;
	}
	public void setListDamageCodeList(List listDamageCodeList) {
		this.listDamageCodeList = listDamageCodeList;
	}
	public List getListContainerTypeList() {
		return listContainerTypeList;
	}
	public void setListContainerTypeList(List listContainerTypeList) {
		this.listContainerTypeList = listContainerTypeList;
	}
	public List getListDamageStatusList() {
		return listDamageStatusList;
	}
	public void setListDamageStatusList(List listDamageStatusList) {
		this.listDamageStatusList = listDamageStatusList;
	}
	public List getListRepairProcessList() {
		return listRepairProcessList;
	}
	public void setListRepairProcessList(List listRepairProcessList) {
		this.listRepairProcessList = listRepairProcessList;
	}
	public List getListContainerNoList() {
		return listContainerNoList;
	}
	public void setListContainerNoList(List listContainerNoList) {
		this.listContainerNoList = listContainerNoList;
	}
	public List getListStatusList() {
		return listStatusList;
	}
	public void setListStatusList(List listStatusList) {
		this.listStatusList = listStatusList;
	}
	
	
}
