package com.dci.tenant.finance.manageitem;

import java.util.ArrayList;
import java.util.List;

public interface ManageItemService {

	public List getItemCtaegoryList();

	public List getUOmList();

	public List getEntityList();

	public boolean insertManageItemDetails(ManageItemBean objManageItem);

	public ManageItemResultBean getManageItemList();

	public boolean deleteItemDetails(String itemId);

	public ManageItemResultBean getEditManageItem(String itemCode);

	public boolean updateManageItemDetails(ManageItemBean objManageItem);

	public ManageItemResultBean getAttributeDetails(int itemCategoryId) throws Exception;

	public ArrayList getGrnAttributeDetails(int itemCategoryId);

	public ManageItemResultBean getItemConsumptionMasterList(String itm, int rdoDays);

	public int checkItemName(String checkItemName);

	public ManageItemResultBean getUOMCategoryBasedList(int uomId) throws Exception;

	public int checkItemCode(String checkItemCode) throws Exception;

	boolean exportManageItemReport(String filePath, ManageItemBean objChqDepCollecBean);

}
