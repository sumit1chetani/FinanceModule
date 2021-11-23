package com.dci.tenant.finance.manageTax;

import java.util.List;

import com.dci.common.util.CustomException;

public interface ManageTaxDAO {

	public List<ManageTax> getTaxList() throws CustomException;

	public ManageTaxResultBean getValueList() throws CustomException;

	public ManageTaxResultBean getTypeList() throws CustomException;

	public ManageTaxResultBean getSubTaxList() throws CustomException;

	public ManageTaxResultBean insertManageTax(ManageTax objManage) throws CustomException;

	public boolean deleteTax(Integer taxId) throws CustomException;

	public ManageTax editManageTax(Integer taxId) throws CustomException;

	public boolean updateManageTax(ManageTax objManage) throws CustomException;

	public ManageTaxResultBean getAcctList(String subGrp);

	public String checkAccount(int taxTypeId, String formCode);

	public ManageTax getChildTaxDetails(int subTaxId);

}