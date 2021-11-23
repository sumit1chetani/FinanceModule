package com.dci.tenant.finance;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface RebateFreightRefundDAO {
	public List<RebateFreightRefundBean> getRebateFreightRefundList();

	/*public List<VesselInformationDtlBean> saveVesselInformaiton(VesselInformationBean vesselInformationBean, String userId);

	public VesselInformationBean editVesselInformaiton(int vesselInfoId, String userId);

	public List<VesselInformationDtlBean> updateVesselInformaiton(VesselInformationBean vesselInformationBean, String userId);
*/
	public RebateFreightRefundResultBean getDropDownList(RebateFreightRefundBean rebateFreightRefundBean);

	public boolean saveRebateRefund(RebateFreightRefundBean rebateFreightRefundBean, String userId);

	public List<SelectivityBean> getInvoiceList(String customerCode);

}
