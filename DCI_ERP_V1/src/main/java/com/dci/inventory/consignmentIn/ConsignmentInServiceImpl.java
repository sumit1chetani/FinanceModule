package com.dci.inventory.consignmentIn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.util.CommonUtil;
import com.dci.common.util.CommonUtilityStockBean;
import com.dci.common.util.CommonUtilityStockDetailBean;
import com.dci.tenant.common.CommonUtilityDAO;

@Service
@Transactional
public class ConsignmentInServiceImpl implements ConsignmentInService {

	@Autowired
	private ConsignmentInDAO objConsignmentInDAO;

	@Autowired
	private CommonUtilityDAO objCommonUtilityDAO;

	@Override
	public List<Object> getDropdownValues() {
		return objConsignmentInDAO.getDropdownValues();
	}

	@Override
	public List<Object> getDropdownValues1() {
		return objConsignmentInDAO.getDropdownValues1();
	}

	@Override
	public boolean saveConsignmentInData(ConsignmentInBean objConsignmentInBean) {
		String consignmentInNo = objConsignmentInDAO.generateConsignmentInNumber();
		CommonUtilityStockBean objCommonUtilityStockBean = new CommonUtilityStockBean();
		objCommonUtilityStockBean.setStockNo(consignmentInNo);
		objCommonUtilityStockBean.setStockDate(objConsignmentInBean.getConsignmentInDate());
		// objCommonUtilityStockBean.setRequisitionId(CommonUtil.convertNullToInteger(String.valueOf(objConsignmentInBean.getRequisition())));
		objCommonUtilityStockBean.setTransportType(objConsignmentInBean.getTransportType());
		objCommonUtilityStockBean.setServiceName(objConsignmentInBean.getServiceName());
		objCommonUtilityStockBean.setPersonName(objConsignmentInBean.getPersonName());
		objCommonUtilityStockBean.setDeliveryMethod(objConsignmentInBean.getDeliveryMet());
		objCommonUtilityStockBean.setStatus(objConsignmentInBean.getStatus());
		objCommonUtilityStockBean.setReason(objConsignmentInBean.getStockReason());
		objCommonUtilityStockBean.setSourceLocation(objConsignmentInBean.getSourceLocName());
		objCommonUtilityStockBean.setDestLocation(objConsignmentInBean.getDestinationLocName());
		objCommonUtilityStockBean.setCompanyId(objConsignmentInBean.getCompanyId());
		objCommonUtilityStockBean.setStockType(121);
		objCommonUtilityStockBean.setReceivedBy(objConsignmentInBean.getReceivedBy());
		objCommonUtilityStockBean.setEntityId(objConsignmentInBean.getVendor());
		objCommonUtilityStockBean.setQuotationId(CommonUtil.convertNullToInteger(String.valueOf(objConsignmentInBean.getQuotation())));

		ArrayList<CommonUtilityStockDetailBean> alCommDetailBean = new ArrayList<CommonUtilityStockDetailBean>();

		for (ConsignmentInDetailBean objBean : objConsignmentInBean.getRowCollection()) {

			CommonUtilityStockDetailBean objCommonUtilityStockDetailBean = new CommonUtilityStockDetailBean();

			objCommonUtilityStockDetailBean.setBatchNumber(objBean.getBatchNumber());
			objCommonUtilityStockDetailBean.setItemId(objBean.getItemId());
			objCommonUtilityStockDetailBean.setQuantity(objBean.getConvertedQuantity());
			objCommonUtilityStockDetailBean.setVendorQty(objBean.getItemQuantity());
			objCommonUtilityStockDetailBean.setBatchDetails(objBean.getBatchDetails());
			objCommonUtilityStockDetailBean.setAttributeBeans(objBean.getAttributeBeans());

			alCommDetailBean.add(objCommonUtilityStockDetailBean);
		}
		objCommonUtilityStockBean.setStockDetTables(alCommDetailBean);

		return objCommonUtilityDAO.saveCommonUtilityStockData(objCommonUtilityStockBean);
	}

	@Override
	public ConsignmentInResultBean getConsignmentInList() {
		return objConsignmentInDAO.getConsignmentInList();
	}

	@Override
	public ConsignmentInBean getConsignmentInDataOnEdit(Integer consignmentInId) {
		return objConsignmentInDAO.getConsignmentInDataOnEdit(consignmentInId);
	}

	@Override
	public boolean updateConsignmentInData(ConsignmentInBean objConsignmentInBean) {
		CommonUtilityStockBean objCommonUtilityStockBean = new CommonUtilityStockBean();
		objCommonUtilityStockBean.setStockId(objConsignmentInBean.getConsignmentInId());
		objCommonUtilityStockBean.setStockNo(objConsignmentInBean.getConsignmentInNo());
		objCommonUtilityStockBean.setStockDate(objConsignmentInBean.getConsignmentInDate());

		objCommonUtilityStockBean.setTransportType(objConsignmentInBean.getTransportType());
		objCommonUtilityStockBean.setServiceName(objConsignmentInBean.getServiceName());
		objCommonUtilityStockBean.setPersonName(objConsignmentInBean.getPersonName());
		objCommonUtilityStockBean.setDeliveryMethod(objConsignmentInBean.getDeliveryMet());
		objCommonUtilityStockBean.setStatus(objConsignmentInBean.getStatus());
		objCommonUtilityStockBean.setReason(objConsignmentInBean.getStockReason());
		objCommonUtilityStockBean.setSourceLocation(objConsignmentInBean.getSourceLocName());
		objCommonUtilityStockBean.setDestLocation(objConsignmentInBean.getDestinationLocName());
		objCommonUtilityStockBean.setCompanyId(objConsignmentInBean.getCompanyId());

		objCommonUtilityStockBean.setStockType(121);
		objCommonUtilityStockBean.setReceivedBy(objConsignmentInBean.getReceivedBy());
		objCommonUtilityStockBean.setEntityId(objConsignmentInBean.getVendor());
		objCommonUtilityStockBean.setQuotationId(CommonUtil.convertNullToInteger(String.valueOf(objConsignmentInBean.getQuotation())));

		ArrayList<CommonUtilityStockDetailBean> alCommDetailBean = new ArrayList<CommonUtilityStockDetailBean>();

		ArrayList<CommonUtilityStockDetailBean> aldeletedIds = new ArrayList<CommonUtilityStockDetailBean>();

		for (ConsignmentInDetailBean objBean : objConsignmentInBean.getRowCollection()) {

			CommonUtilityStockDetailBean objCommonUtilityStockDetailBean = new CommonUtilityStockDetailBean();

			objCommonUtilityStockDetailBean.setBatchNumber(objBean.getBatchNumber());
			objCommonUtilityStockDetailBean.setStockDetId(objBean.getConsignmentInDetId());
			objCommonUtilityStockDetailBean.setItemId(objBean.getItemId());
			objCommonUtilityStockDetailBean.setQuantity(objBean.getPurchaseQuantity());
			objCommonUtilityStockDetailBean.setVendorQty(objBean.getItemQuantity());

			objCommonUtilityStockDetailBean.setBatchDetails(objBean.getBatchDetails());
			objCommonUtilityStockDetailBean.setAttributeBeans(objBean.getAttributeBeans());

			alCommDetailBean.add(objCommonUtilityStockDetailBean);
		}
		for (ConsignmentInDetailBean objBean : objConsignmentInBean.getDeletedIds()) {
			CommonUtilityStockDetailBean objCommonUtilityStockDetailBean = new CommonUtilityStockDetailBean();

			objCommonUtilityStockDetailBean.setStockDetId(objBean.getConsignmentInDetId());
			objCommonUtilityStockDetailBean.setItemId(objBean.getItemId());

			aldeletedIds.add(objCommonUtilityStockDetailBean);
		}

		objCommonUtilityStockBean.setLdetedIds(aldeletedIds);

		objCommonUtilityStockBean.setStockDetTables(alCommDetailBean);

		return objCommonUtilityDAO.updateCommonUtilityStockData(objCommonUtilityStockBean);
	}

	@Override
	public boolean deleteConsignmentInData(Integer consignmentInId) {
		CommonUtilityStockBean objCommonUtilityStockBean = new CommonUtilityStockBean();
		objCommonUtilityStockBean.setStockType(121);
		return objCommonUtilityDAO.deleteStockData(consignmentInId, objCommonUtilityStockBean.getStockType());
	}

	@Override
	public List<ConsignmentInDetailBean> getItemrequisition(String id) {
		// TODO Auto-generated method stub
		return objConsignmentInDAO.getItemrequisition(id);
	}

	@Override
	public int checkBatchNumber(String manageName) throws Exception {
		return objConsignmentInDAO.checkBatchNumber(manageName);
	}

	

}
