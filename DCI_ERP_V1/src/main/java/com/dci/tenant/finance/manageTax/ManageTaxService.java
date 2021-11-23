package com.dci.tenant.finance.manageTax;

import java.util.List;

public interface ManageTaxService {

	List<ManageTax> getTaxList() throws Exception;

	ManageTaxResultBean getValueList() throws Exception;

	ManageTaxResultBean getTypeList() throws Exception;

	ManageTaxResultBean getSubTaxList() throws Exception;

	public ManageTaxResultBean insertManageTax(ManageTax manageTax) throws Exception;

	public boolean deleteTax(Integer taxId) throws Exception;

	public ManageTax editManageTax(Integer taxId) throws Exception;

	public boolean updateManageTax(ManageTax manageTax) throws Exception;

	ManageTaxResultBean getAcctList(String subGrp);

	String checkAccount(int taxTypeId, String formCode);

	ManageTax getChildTaxDetails(int subTaxId);

}