package com.dci.common.quicklink;

import java.util.List;



public interface QuickLinkService {
	public List<QuickLinkBean> getqlList();
	
	public QuickLinkBean getqlDtl(Integer id);
	
	public QuickLinkBean getBookingNo(String id);
	
	public QuickLinkBean getCRONo(String id);
	
	public QuickLinkBean getGout(String id);
	
	public QuickLinkBean getGin(String id);
	
	public QuickLinkBean getShipmentOrder(String id);
	
	public QuickLinkBean getBl(String id);
}
