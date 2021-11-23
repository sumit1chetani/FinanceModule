package com.dci.tenant.finance.manageSubTax;

import java.util.List;

public interface ManageSubTaxService {

	public boolean insertManageSubTax(ManageSubTax manageSubTax) throws Exception;

	ManageSubTaxResultBean getValueList() throws Exception;

	ManageSubTaxResultBean getTypeList() throws Exception;

	List<ManageSubTax> getSubTaxList() throws Exception;

	void deleteSubTax(Integer subTaxId) throws Exception;

	public ManageSubTax editManageSubTax(Integer subTaxId) throws Exception;

	public boolean updateManageSubTax(ManageSubTax manageSubTax) throws Exception;

}