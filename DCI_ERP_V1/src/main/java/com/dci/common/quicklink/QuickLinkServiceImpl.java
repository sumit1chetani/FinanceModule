package com.dci.common.quicklink;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuickLinkServiceImpl implements QuickLinkService {

	@Autowired
	QuickLinkDao quickLinkDao;
	
	public List<QuickLinkBean> getqlList() {
		// TODO Auto-generated method stub
		return quickLinkDao.getqlList();
	}
	
	public QuickLinkBean getqlDtl(Integer id) {
		// TODO Auto-generated method stub
		return quickLinkDao.getqlDtl(id);
	}
	
	public QuickLinkBean getBookingNo(String id) {
		// TODO Auto-generated method stub
		return quickLinkDao.getBookingNo(id);
	}
	
	
	public QuickLinkBean getCRONo(String id) {
		// TODO Auto-generated method stub
		return quickLinkDao.getCRONo(id);
	}
	
	public QuickLinkBean getGout(String id) {
		// TODO Auto-generated method stub
		return quickLinkDao.getGout(id);
	}
	
	public QuickLinkBean getGin(String id) {
		// TODO Auto-generated method stub
		return quickLinkDao.getGin(id);
	}
	
	public QuickLinkBean getShipmentOrder(String id) {
		// TODO Auto-generated method stub
		return quickLinkDao.getShipmentOrder(id);
	}
	
	public QuickLinkBean getBl(String id) {
		// TODO Auto-generated method stub
		return quickLinkDao.getBl(id);
	}
	
	
}
