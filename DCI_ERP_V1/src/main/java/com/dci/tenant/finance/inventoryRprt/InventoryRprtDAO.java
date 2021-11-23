package com.dci.tenant.finance.inventoryRprt;

import java.util.List;

public interface InventoryRprtDAO {

	List<InventoryRprtBean> getInventoryMasterList(int limit, int offset);

	List<InventoryRprtDtlBean> getInventroySubList(int item, int location, String invDate);

	InventroyRprtListBean getDropDowns();

	List<InventoryRprtBean> getInventroyListWithParam(int item, int location, String stockon);

	List<InventoryRprtBean> getinvlistBelowROL();

	List<InventoryRprtDtlBean> getSubGridBatchDetails(int ledgerId);

	List<InventoryRprtDtlBean> getInventroyNewSubList(int item, String invDate);

	List<InventoryRprtBean> getInventoryNewMasterList(int limit, int offset);

	List<InventoryRprtBean> getInventroyNewListWithParam(String item, String location, String fromdate, String todate, String category);

	List<InventoryRprtBean> getInventroyNewListExport(String item, String location, String fomdate, String todate, String categoryid);

}
