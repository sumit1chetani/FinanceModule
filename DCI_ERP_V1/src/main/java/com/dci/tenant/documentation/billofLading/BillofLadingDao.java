package com.dci.tenant.documentation.billofLading;

import java.util.List;

import com.dci.common.model.SelectivityBean;

public interface BillofLadingDao {
	
public BillofLadingBean insert(BillofLadingBean billofLading) throws Exception;
	
	public List<SelectivityBean> getDropDown();
	
	List<BillofLadingBean> getList() throws Exception;
	
	List<BillofLadingBean> getBlList() throws Exception;
	
	public BillofLadingBean print(String blNo);

	public BillofLadingBean getBlEdit(String blNo);
	
	public BillofLadingBean delete(String blNo);
	
	public BillofLadingBean update(BillofLadingBean billofLading) throws Exception;

	public List<SelectivityBean> getIssuePlace();

	public List<SelectivityBean> getAgentList();

	public List<SelectivityBean> getBookingList();

	public List<SelectivityBean> shipmentList();

	public List<SelectivityBean> getConatinerTypeList();

	public List<SelectivityBean> getPackageTypeList();

	public List<SelectivityBean> getSurChargeList();

	//Print
	public BillofLadingResultBean printBL(String blNo);
	
	public BillofLadingResultBean getcountPrint(String blNo, String printStatus) throws Exception;
	
	public Integer seqPrint(String blNo, String printStatus);
	
	public List<BillofLadingBean> printDetailList(String blNo);

	public List<SelectivityBean> getContainerList();
}
