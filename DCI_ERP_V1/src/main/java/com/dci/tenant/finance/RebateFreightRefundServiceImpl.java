package com.dci.tenant.finance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;

@Service
public class RebateFreightRefundServiceImpl implements RebateFreightRefundService {

	@Autowired
	RebateFreightRefundDAO rebateFreightRefundDAO;

	@Override
	public List<RebateFreightRefundBean> getRebateFreightRefundList() {
		return rebateFreightRefundDAO.getRebateFreightRefundList();
	}

	/*@Override
	public List<VesselInformationDtlBean> saveVesselInformaiton(VesselInformationBean vesselInformationBean, String userId) {
		return rebateFreightRefundDAO.saveVesselInformaiton(vesselInformationBean, userId);
	}

	@Override
	public VesselInformationBean editVesselInformaiton(int vesselInfoId, String userId) {
		return rebateFreightRefundDAO.editVesselInformaiton(vesselInfoId, userId);
	}

	@Override
	public List<VesselInformationDtlBean> updateVesselInformaiton(VesselInformationBean vesselInformationBean, String userId) {
		return rebateFreightRefundDAO.updateVesselInformaiton(vesselInformationBean, userId);
	}*/

	@Override
	public RebateFreightRefundResultBean getDropDownList(RebateFreightRefundBean rebateFreightRefundBean) {
		return rebateFreightRefundDAO.getDropDownList(rebateFreightRefundBean);
	}

	@Override
	public boolean saveRebateRefund(RebateFreightRefundBean rebateFreightRefundBean, String userId) {
		return rebateFreightRefundDAO.saveRebateRefund(rebateFreightRefundBean, userId);
	}

	@Override
	public List<SelectivityBean> getInvoiceList(String customerCode) {
		return rebateFreightRefundDAO.getInvoiceList(customerCode);
	}

}
