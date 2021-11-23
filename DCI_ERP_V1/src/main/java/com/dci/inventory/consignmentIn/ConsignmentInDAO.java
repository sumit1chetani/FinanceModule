package com.dci.inventory.consignmentIn;

import java.util.List;

import com.dci.common.model.CommonUtilityBean;

public interface ConsignmentInDAO {

	List<Object> getDropdownValues();

	List<Object> getDropdownValues1();

	List<ConsignmentInBean> saveConsignmentInData(ConsignmentInBean objConsignmentInBean, String stockInNo);

	ConsignmentInResultBean getConsignmentInList();

	ConsignmentInBean getConsignmentInDataOnEdit(Integer stockInId);

	String generateConsignmentInNumber();

	List<ConsignmentInDetailBean> getItemrequisition(String id);

	public int checkBatchNumber(String manageName) throws Exception;



}
