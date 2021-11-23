package com.dci.tenant.finance.manageCustomer;

import java.util.List;

public class ManagecustomerDTO {

	private ManageCustomerBean manageCustomer;
	private List<ManageCustomerAddressBean> manageCustomerAddress;
	private List<ManageCustomerBankBean> manageCustomerBank;

	public ManageCustomerBean getManageCustomer() {
		return manageCustomer;
	}

	public void setManageCustomer(ManageCustomerBean manageCustomer) {
		this.manageCustomer = manageCustomer;
	}

	public List<ManageCustomerAddressBean> getManageCustomerAddress() {
		return manageCustomerAddress;
	}

	public void setManageCustomerAddress(List<ManageCustomerAddressBean> manageCustomerAddress) {
		this.manageCustomerAddress = manageCustomerAddress;
	}

	public List<ManageCustomerBankBean> getManageCustomerBank() {
		return manageCustomerBank;
	}

	public void setManageCustomerBank(List<ManageCustomerBankBean> manageCustomerBank) {
		this.manageCustomerBank = manageCustomerBank;
	}

}
