package com.dci.master.settings.UOM;

import java.util.List;

import com.dci.common.util.CustomException;

public interface ManageUOMDAO {

	public boolean insertManageUOM(ManageUOM manageUOM) throws CustomException;

	public ManageUOM getManageUOMById(Integer manageUOMId) throws CustomException;

	public boolean updateManageUOM(ManageUOM manageUOM) throws CustomException;

	public void deleteManageUOM(Integer manageUOMId) throws CustomException;

	public List<ManageUOM> getManageUOMList() throws CustomException;

	public ManageUOMResultBean getUOMCategoryList() throws CustomException;

	public int checkBaseUOM(ManageUOM manageUOM) throws CustomException;

	public ManageUOMResultBean getUOMCategList() throws CustomException;

	public int checkUOMName(String uomName) throws CustomException;

}
