package com.dci.tenant.finance.manageitem;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author paragon
 *
 */
public interface ManageItemDAO {

	public List getItemCtaegoryList();

	public List getUOmList();

	public List getEntityList();

	public boolean insertManageItemDetails(ManageItemBean objManageItem);

	public ManageItemResultBean getManageItemList();

	public boolean deleteItemDetails(String itemId);

	public ManageItemResultBean getEditManageItem(String itemCode);

	public boolean updateManageItemDetails(ManageItemBean objManageItem);

	public ManageItemResultBean getAttributeDetails(int itemCategoryId) throws Exception;

	public ArrayList<ManageItemBean> getGrnAttributeDetails(int itemCategoryId);

	public int checkItemName(String checkItemName);

	public ManageItemResultBean getItemConsumptionMasterList(String itm, int rdoDays);

	public ManageItemResultBean getUOMCategoryBasedList(int uomId) throws Exception;

	public int checkItemCode(String checkItemCode) throws Exception;

	boolean exportManageItemReport(String exportFilesPath, ManageItemBean ManageItemBean);

	List<ManageItemBean> getExcelReport(ManageItemBean ManageItemBean);

	List<ManageItemBean> getChqDepoCollReport(ManageItemBean ManageItemBean);

}
