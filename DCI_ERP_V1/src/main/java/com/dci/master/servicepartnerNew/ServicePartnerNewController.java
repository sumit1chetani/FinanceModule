package com.dci.master.servicepartnerNew;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;


@RestController
@RequestMapping("{tenantid}/app/master/servicepartnerNew")
public class ServicePartnerNewController {
	@Autowired
	ServicePartnerNewService servicePartnerService;
@RequestMapping("/list")
ServicePartnerNewResultBean getServicePatrnerList(@RequestParam("name") String name)
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.getServicePartnerList(name);
		servicePartnerResultBean.setSuccess(true);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}


@RequestMapping("/generateExcel")
 void  generateExcel()
{
String filePath = "";
	try
	{
		
		filePath=servicePartnerService.generateExcel();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}



@RequestMapping("/countryList")
public ServicePartnerNewResultBean getDropDownList(@RequestBody int cityId)
{
	ServicePartnerNewResultBean branchResultBean = new ServicePartnerNewResultBean();
try
	{
		
	branchResultBean=servicePartnerService.getCountryList(cityId);
		branchResultBean.setSuccess(true);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return branchResultBean;
	
}
@RequestMapping("/dropDownList")
ServicePartnerNewResultBean getDropDownList()
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.getDropDownList();
		servicePartnerResultBean.setSuccess(true);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}
@RequestMapping("/save")
ServicePartnerNewResultBean saveServicePatrnerList(@RequestBody ServicePartnerNewResultBean servicePartnerBean)
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.saveServicePartner(servicePartnerBean);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}
@RequestMapping("/update")
ServicePartnerNewResultBean updateServicePatrnerList(@RequestBody ServicePartnerNewResultBean servicePartnerBean)
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.updateServicePartner(servicePartnerBean);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}
@RequestMapping("/edit")
ServicePartnerNewResultBean editServicePatrnerList(@RequestParam("servicePartnerId") int servicePartnerId )
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.editServicePartner(servicePartnerId);
		servicePartnerResultBean.setSuccess(true);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}

@RequestMapping("/view")
ServicePartnerNewResultBean viewServicePatrnerList(@RequestParam("servicePartnerId") int servicePartnerId )
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.viewServicePatrnerList(servicePartnerId);
		servicePartnerResultBean.setSuccess(true);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}

@RequestMapping("/delete")
ServicePartnerNewResultBean deleteServicePatrnerList(@RequestParam("servicePartnerId") int servicePartnerId )
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.deleteServicePartner(servicePartnerId);
		servicePartnerResultBean.setSuccess(true);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}

@RequestMapping("/createLogin")
ServicePartnerNewResultBean createLogin(@RequestParam("rowid") int rowid )
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.createLogin(rowid);
		servicePartnerResultBean.setSuccess(true);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}

@RequestMapping("/deleteKeyDetail")
ServicePartnerNewResultBean deleteKeyDetail(@RequestBody List<ServicePartnerNewKeyBean> lServicePartnerKeyBean)
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.deleteKeyDetail(lServicePartnerKeyBean);
		servicePartnerResultBean.setSuccess(true);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}


@RequestMapping("/getMapDetail")
ServicePartnerNewResultBean getMapDetail()
{
	ServicePartnerNewResultBean servicePartnerResultBean = new ServicePartnerNewResultBean();

	try
	{
		
		servicePartnerResultBean=servicePartnerService.getServicePartnerDetailList();
		servicePartnerResultBean.setSuccess(true);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return servicePartnerResultBean;
	
}
//kyc


@RequestMapping("/saveCustomerDetail")
public @ResponseBody ServicePartnerNewResultBean saveLeadDetail(@RequestBody CustomerMasterNewCommDetail2 customerMasterCommDetail) throws Exception {
	UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	ServicePartnerNewResultBean customMaster = new ServicePartnerNewResultBean();
	boolean isSaved = servicePartnerService.saveCustomCommDetail(customerMasterCommDetail,userDetails.getUserId());
	if (isSaved) {
		List<CustomerMasterNewCommDetail2> customerMasterCommDetails = servicePartnerService.getCustomCommDetail(
				customerMasterCommDetail.getCustomId()).getCustomerMasterCommDetails();
	/*	customerMasterCommDetails.addAll(leadMasterService.getCustomerCommDetail(customerMasterCommDetail.getCustomId())
				.getCustomerMasterCommDetails());*/
		customMaster.setCustomerMasterCommDetails(customerMasterCommDetails);
		customMaster.setMessage("Inseretd Sucessfully");
		customMaster.setSuccess(true);
		customMaster.setType("sucess");
	}
	return customMaster;
}
@RequestMapping("/updateCustomerDetail")
public @ResponseBody ServicePartnerNewResultBean updateLeadDetail(@RequestBody CustomerMasterNewCommDetail2 customerMasterCommDetail) throws Exception {
	ServicePartnerNewResultBean customMaster = new ServicePartnerNewResultBean();
	UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	boolean isSaved = servicePartnerService.updateCustomerCommDetail2(customerMasterCommDetail,userDetails.getUserId());
	if (isSaved) {
		List<CustomerMasterNewCommDetail2> customerMasterCommDetails = servicePartnerService.getCustomCommDetail(
			customerMasterCommDetail.getCustomId()).getCustomerMasterCommDetails();
	//	customerMasterCommDetails.addAll(leadMasterService.getCustomerCommDetail(customerMasterCommDetail.getCustomId())
		//		.getCustomerMasterCommDetails());
customMaster.setCustomerMasterCommDetails(customerMasterCommDetails);
		customMaster.setMessage("Updated Sucessfully");
		customMaster.setSuccess(true);
		customMaster.setType("sucess");
	}
	return customMaster;
}
@RequestMapping("/deleteCustomerComm")
public @ResponseBody ServicePartnerNewResultBean deleteLeadComm(@RequestParam("customCommId") String customCommId,
		@RequestParam("customId") String srvcprtnrcd) throws Exception {
	ServicePartnerNewResultBean customMaster = new ServicePartnerNewResultBean();
	boolean isDelete = servicePartnerService.deleteCustomerComm(customCommId, srvcprtnrcd);
	if (isDelete) {
		System.out.println("test");
		customMaster.setCustomerMasterCommDetails(servicePartnerService.getCustomCommDetail(srvcprtnrcd).getCustomerMasterCommDetails());
		customMaster.setMessage("Deleted Sucessfully");
		customMaster.setSuccess(true);
		customMaster.setType("sucess");
	}
	return customMaster;
}



@RequestMapping(value = "/ExportExcel", method = RequestMethod.POST)
public ServicePartnerNewResultBean getExcelReportExportList( ServiceNewMapBean objBookingReportBean ) throws CustomException {
	ServicePartnerNewResultBean objBookingReportResultBean = new ServicePartnerNewResultBean();
	List<ServiceNewMapBean> bean = new ArrayList<ServiceNewMapBean>();
	try {
		//objBookingReportResultBean.setSearchList(objBookingReportService.searchportDtl(objBookingReportBean));
		//bean = commodityService.getCommodityList();
		servicePartnerService.excellExport(objBookingReportResultBean, objBookingReportBean,ConfigurationProps.exportFilesPath) ;
		System.out.println("List Of  fee excel");

		objBookingReportResultBean.setSuccess(true);
	} catch (Exception e) {
		System.out.println(e);

	}
	return objBookingReportResultBean;
}

@RequestMapping(value = "/uploadfileleave")
public @ResponseBody ServicePartnerNewResultBean uploadFile(MultipartFile file) throws IOException {
	ServicePartnerNewResultBean ResultBean = new ServicePartnerNewResultBean();
	try {
		ResultBean = servicePartnerService.uploadFile(file);
		ResultBean.setSuccess(true);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return ResultBean;

}



@RequestMapping("/uploadfile")
public @ResponseBody ServicePartnerNewResultBean uploadFile1(@RequestBody MultipartFile file) throws CustomException {
	ServicePartnerNewResultBean resultBean = new ServicePartnerNewResultBean();
	try {
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
				

				resultBean = servicePartnerService.uploadFile1(file);
				//resultBean.setSuccess1(true);
				//System.out.println("test");


			} else {
				resultBean.setSuccess1(false);
				resultBean.setMessage("Not a valid file format");
				System.out.println("Not a valid file format");
			}

		} else {
			resultBean.setSuccess1(false);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return resultBean;
}

}


