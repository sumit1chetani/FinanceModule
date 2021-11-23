package com.dci.tenant.documentation.billofLading;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dci.common.model.SelectivityBean;


public interface BillofLadingService {

	public BillofLadingBean insert(BillofLadingBean billofLading) throws Exception;

	public List<SelectivityBean> getDropDown();

	List<BillofLadingBean> getList() throws Exception;
	
	List<BillofLadingBean> getBlList() throws Exception;
	
	XSSFWorkbook excellExport(List<BillofLadingBean> blreport, BillofLadingBean billofLading, String pdfFile);

	public BillofLadingBean print(String blNo);
	
	public BillofLadingBean getBlEdit(String blNo);
	
	public BillofLadingBean delete(String blNo);
	
	public BillofLadingBean update(BillofLadingBean billofLading) throws Exception;

	public  List<SelectivityBean> getIssuePlace();

	public List<SelectivityBean> getAgentList();

	public List<SelectivityBean> getBookingList();

	public List<SelectivityBean> shipmentList();

	public List<SelectivityBean> getConatinerTypeList();

	public List<SelectivityBean> getPackageTypeList();

	public List<SelectivityBean> getSurChargeList();

	//Print
	public BillofLadingResultBean printBL(String blNo);
	
	public List<BillofLadingBean> printDetailList(String blNo);
	
	public Integer seqPrint(String blNo, String printStatus) throws Exception;
	
	public BillofLadingResultBean getcountPrint(String blNo, String printStatus) throws Exception;

	public List<SelectivityBean> getContainerList();
}
