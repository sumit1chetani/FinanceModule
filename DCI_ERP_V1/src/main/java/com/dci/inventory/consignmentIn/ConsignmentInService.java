package com.dci.inventory.consignmentIn;

import java.util.List;

import com.dci.common.model.CommonUtilityBean;

public interface ConsignmentInService {

	List<Object> getDropdownValues();

	List<Object> getDropdownValues1();

	boolean saveConsignmentInData(ConsignmentInBean objConsignmentInBean);

	ConsignmentInResultBean getConsignmentInList();

	ConsignmentInBean getConsignmentInDataOnEdit(Integer consignmentInId);

	boolean updateConsignmentInData(ConsignmentInBean objConsignmentInBean);

	boolean deleteConsignmentInData(Integer consignmentInId);

	List<ConsignmentInDetailBean> getItemrequisition(String id);

	public int checkBatchNumber(String manageName) throws Exception;


}
