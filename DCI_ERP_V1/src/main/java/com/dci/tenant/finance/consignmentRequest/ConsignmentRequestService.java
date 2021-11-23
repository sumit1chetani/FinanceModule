package com.dci.tenant.finance.consignmentRequest;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.BasicResultBean;

public interface ConsignmentRequestService {

	public ConsignmentRequestResultBean getEmployeeList() throws Exception;

	public ConsignmentRequestSubBean getItemList(int itemId) throws Exception;

	public boolean insertConsignmentRequest(ConsignmentRequestResultBean consignmentRequestResultBean) throws Exception;

	public ConsignmentRequestResultBean getConsignmentRequestById(int purchaseRequisitionId) throws Exception;

	public List<ConsignmentRequest> getConsignmentRequestList() throws Exception;

	public boolean updateConsignmentRequest(ConsignmentRequestResultBean consignmentRequestResultBean) throws Exception;

	public boolean deleteConsignmentRequest(int purchaseRequisitionId) throws Exception;

	public ConsignmentRequestSubBean issueStatus(Integer reqId, Integer issueStatus) throws Exception;

	public ConsignmentRequestResultBean printMaterialRequest(Integer materialReqID);

	public BasicResultBean getPRnumberduplicate(String prnumber);

	public BasicResultBean getPRnumberduplicate(String prnumber, String PRId);

	public ConsignmentRequestResultBean uploadExeFile(MultipartFile file);

	public boolean updateApproveMR(ConsignmentRequestResultBean consignmentRequetResultBean);
}
