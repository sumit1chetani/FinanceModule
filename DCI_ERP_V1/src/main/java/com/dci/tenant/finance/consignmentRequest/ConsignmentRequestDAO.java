package com.dci.tenant.finance.consignmentRequest;

import java.util.List;

import com.dci.common.util.BasicResultBean;
import com.dci.common.util.CustomException;

public interface ConsignmentRequestDAO {

	public ConsignmentRequestResultBean getEmployeeList() throws CustomException;

	public ConsignmentRequestSubBean getItemList(int itemId) throws CustomException;

	public boolean insertConsignmentRequest(ConsignmentRequestResultBean consignmentRequestResultBean) throws CustomException;

	public ConsignmentRequestResultBean getConsignmentRequestById(int purchaseRequisitionId) throws CustomException;

	public List<ConsignmentRequest> getConsignmentRequestList() throws CustomException;

	public boolean updateConsignmentRequest(ConsignmentRequestResultBean consignmentRequestResultBean) throws CustomException;

	public boolean deleteConsignmentRequest(int purchaseRequisitionId) throws CustomException;

	public ConsignmentRequestSubBean issueStatus(Integer reqId, Integer issueStatus) throws Exception;

	public ConsignmentRequestResultBean printMaterialRequest(Integer materialReqID);

	public BasicResultBean getPRnumberduplicate(String prnumber);

	public BasicResultBean getPRnumberduplicate(String prnumber, String PRId);

	public boolean insertConReq(List<ConsignmentRequest> headerDataList);

	public boolean updateApproveMR(ConsignmentRequestResultBean consignmentRequetResultBean);
}
