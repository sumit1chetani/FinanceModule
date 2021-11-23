package com.dci.tenant.finance.manageSubTax;

import java.util.List;

import com.dci.common.util.CustomException;

public interface ManageSubTaxDAO {

	public List<ManageSubTax> getSubTaxList() throws CustomException;

	public boolean insertManageSubTax(ManageSubTax objManage) throws CustomException;

	public ManageSubTaxResultBean getValueList() throws CustomException;

	public ManageSubTaxResultBean getTypeList() throws CustomException;

	public void deleteSubTax(Integer subTaxId) throws CustomException;

	public ManageSubTax editManageSubTax(Integer subTaxId) throws CustomException;

	public boolean updateManageSubTax(ManageSubTax objManage) throws CustomException;

}