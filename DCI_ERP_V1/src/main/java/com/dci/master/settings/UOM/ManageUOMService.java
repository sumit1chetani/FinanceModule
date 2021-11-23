package com.dci.master.settings.UOM;

import java.util.List;

public interface ManageUOMService {

	public boolean insertManageUOM(ManageUOM manageUOM) throws Exception;

	public ManageUOM getManageUOMById(Integer manageUOMId) throws Exception;

	public boolean updateManageUOM(ManageUOM manageUOM) throws Exception;

	public void deleteManageUOM(Integer manageUOMId) throws Exception;

	public List<ManageUOM> getManageUOMList() throws Exception;

	public ManageUOMResultBean getUOMCategoryList() throws Exception;

	public int checkBaseUOM(ManageUOM manageUOM) throws Exception;

	public ManageUOMResultBean getUOMCategList() throws Exception;

	public int checkUOMName(String uomName) throws Exception;

}
