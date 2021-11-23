package com.dci.operation.containerReleaseOrder;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.model.SelectivityBean;


public interface containerReleaseOrderService {

	containerReleaseOrderResultBean save(containerReleaseOrderBean bean);

	containerReleaseOrderResultBean list();

	containerReleaseOrderResultBean edit(String quotHdId);
	
	containerReleaseOrderResultBean view(Integer quotHdId);

	containerReleaseOrderResultBean getCustomerDetail(String quotHdId);
	
	containerReleaseOrderResultBean getcustomerpolpod(String quotHdId);
	
	public containerReleaseOrderResultBean uploadEmployeeExcel(MultipartFile file) throws Exception;
	

     public containerReleaseOrderPrintBean printBL(String blNo);
     
     public containerReleaseOrderPrintBean printreleaseOrder(String blNo);

     
     public printcontainerReleaseOrderBean printCRO(String blNo);
     

	
	containerReleaseOrderResultBean update(containerReleaseOrderBean bean);

	containerReleaseOrderResultBean delete(String QuotHdId);

	containerReleaseOrderResultBean approve(String quotation);

	List<CommonUtilityBean> getiataList();

	List<CommonUtilityBean> getCurrencyList();

	List<CommonUtilityBean> getServicePartner();

	List<CommonUtilityBean> getBranch();

	public void insertFiles(String quotationNumber, String filename, String path);

	List<CommonUtilityBean> getServicePartnerType();

	List<CommonUtilityBean> getEmployeeList();

	List<CommonUtilityBean> getChargeHeads();

	List<CommonUtilityBean> getTerms();

	List<CommonUtilityBean> getUnitList();

	containerReleaseOrderBean print(Integer quotationHdId);

	containerReleaseOrderResultBean saveasDraft(containerReleaseOrderBean bean);

	List<CommonUtilityBean> getuomList();

	List<String> getFileNameList(Integer quotationHdId);
	
	public containerReleaseOrderResultBean DownloadFile(String quotationNo);

	void updateFiles(String quotationNo, List<String> check, String filepath,
			List<String> filepaths);
	
	public containerReleaseOrderResultBean getServicePartnerDropdownList();
	
	public containerReleaseOrderResultBean getServicePartnerDropdownListid(String id);
	
	List<CommonUtilityBean> getcommodity();

	boolean uploaddelete(String quotationNo);
	
	boolean deletefiles(String fileName);
	public containerReleaseOrderResultBean getCustomerList();
	
	public containerReleaseOrderResultBean getCustomerListCompany(String company);
	
	public containerReleaseOrderResultBean getShipment();
	
	public List<containerReleaseOrderBean> getContainerTypeDropDown();
	

	//List<containerReleaseOrderBean> getEmptyList(containerReleaseOrderBean containerReleaseOrderBean);


	//List<containerReleaseOrderBean> getEmptyList(String containerreleaseCode);
	

    public containerReleaseOrderBean export(String containerreleaseCode);

    public void generateExcel(containerReleaseOrderResultBean resultBean,String containerreleaseCode,String exportFilesPath);

	public void sendCROMail(String croNo);

	List<SelectivityBean> getContainerTypeByBooking(String bookingNo,boolean isEdit,String conHdrCode);

}

