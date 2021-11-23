package com.dci.operation.containerReleaseOrder;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.model.SelectivityBean;



public interface containerReleaseOrderDao {
	

	public containerReleaseOrderResultBean getShipment();
	
	containerReleaseOrderResultBean save(containerReleaseOrderBean bean);

	containerReleaseOrderResultBean list();

	containerReleaseOrderResultBean edit(String quotHdId);
	
	containerReleaseOrderResultBean view(Integer quotHdId);

	containerReleaseOrderResultBean getCustomerDetail(String quotHdId);
	
	containerReleaseOrderResultBean getcustomerpolpod(String quotHdId);

	containerReleaseOrderResultBean update(containerReleaseOrderBean bean);

	containerReleaseOrderResultBean delete(String QuotHdId);

	containerReleaseOrderResultBean approve(String quotation);

	List<CommonUtilityBean> getCurrencyList();

	List<CommonUtilityBean> getServicePartner();

	List<CommonUtilityBean> getBranch();

	public void insertFiles(String quotationNumber, String filename, String path);

	List<CommonUtilityBean> getiataList();
	
	List<CommonUtilityBean> getcommodity();

	List<CommonUtilityBean> getServicePartnerType();

	List<CommonUtilityBean> getEmployeeList();

	List<CommonUtilityBean> getChargeHeads();

	List<CommonUtilityBean> getTerms();

	List<CommonUtilityBean> getUnitList();

	containerReleaseOrderBean print(Integer quotationHdId);

	containerReleaseOrderResultBean saveasDraft(containerReleaseOrderBean bean);

	containerReleaseOrderResultBean approve(containerReleaseOrderBean bean);

	List<CommonUtilityBean> getuomList();

	List<String> getFileNameList(Integer quotationHdId);

	void updateFiles(String quotationNo, List<String> check, String filepath,
			List<String> filepaths);
	
	public containerReleaseOrderResultBean getServicePartnerDropdownList();
	
	public containerReleaseOrderResultBean getServicePartnerDropdownListid(String id);
	
	public containerReleaseOrderResultBean downloadfile(String quotationNo);

	boolean uploaddelete(String quotationNo);
	
	boolean deletefiles(String fileName);
	
	public containerReleaseOrderResultBean getCustomerList();
	
	public containerReleaseOrderResultBean uploadEmployeeExcel(MultipartFile file) throws Exception;
	
	public containerReleaseOrderResultBean getCustomerListCompany(String company);

	//public List<containerReleaseOrderBean> getemptyList(String containerreleaseCode);
	
	public List<containerReleaseOrderBean> getContainerTypeDropDown();
	
	public containerReleaseOrderPrintBean printBL(String blNo);
	
	public containerReleaseOrderPrintBean printreleaseOrder(String blNo);

	
	public printcontainerReleaseOrderBean printCRO(String blNo);

	public containerReleaseOrderBean getExport(String containerreleaseCode);

	List<containerReleaseOrderBean> getemptyList(containerReleaseOrderBean containerReleaseOrderBean);

	public List<SelectivityBean> getContainerTypeByBooking(String bookingNo,boolean isEdit,String conHdrCode);

}

