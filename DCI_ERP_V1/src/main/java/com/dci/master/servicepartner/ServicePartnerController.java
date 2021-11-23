package com.dci.master.servicepartner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;


@RestController
@RequestMapping("{tenantid}/app/master/servicepartner")
public class ServicePartnerController {
	@Autowired
	ServicePartnerService servicePartnerService;
@RequestMapping("/list")
ServicePartnerResultBean getServicePatrnerList(@RequestParam("name") String name)
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
public ServicePartnerResultBean getDropDownList(@RequestBody int cityId)
{
	ServicePartnerResultBean branchResultBean = new ServicePartnerResultBean();
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
ServicePartnerResultBean getDropDownList()
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
ServicePartnerResultBean saveServicePatrnerList(@RequestBody ServicePartnerResultBean servicePartnerBean)
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
ServicePartnerResultBean updateServicePatrnerList(@RequestBody ServicePartnerResultBean servicePartnerBean)
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
ServicePartnerResultBean editServicePatrnerList(@RequestParam("servicePartnerId") int servicePartnerId )
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
ServicePartnerResultBean viewServicePatrnerList(@RequestParam("servicePartnerId") int servicePartnerId )
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
ServicePartnerResultBean deleteServicePatrnerList(@RequestParam("servicePartnerId") int servicePartnerId )
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
ServicePartnerResultBean createLogin(@RequestParam("rowid") int rowid )
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
ServicePartnerResultBean deleteKeyDetail(@RequestBody List<ServicePartnerKeyBean> lServicePartnerKeyBean)
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
ServicePartnerResultBean getMapDetail()
{
	ServicePartnerResultBean servicePartnerResultBean = new ServicePartnerResultBean();

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
public @ResponseBody ServicePartnerResultBean saveLeadDetail(@RequestBody CustomerMasterCommDetail2 customerMasterCommDetail) throws Exception {
	UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	ServicePartnerResultBean customMaster = new ServicePartnerResultBean();
	boolean isSaved = servicePartnerService.saveCustomCommDetail(customerMasterCommDetail,userDetails.getUserId());
	if (isSaved) {
		List<CustomerMasterCommDetail2> customerMasterCommDetails = servicePartnerService.getCustomCommDetail(
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
public @ResponseBody ServicePartnerResultBean updateLeadDetail(@RequestBody CustomerMasterCommDetail2 customerMasterCommDetail) throws Exception {
	ServicePartnerResultBean customMaster = new ServicePartnerResultBean();
	UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	boolean isSaved = servicePartnerService.updateCustomerCommDetail2(customerMasterCommDetail,userDetails.getUserId());
	if (isSaved) {
		List<CustomerMasterCommDetail2> customerMasterCommDetails = servicePartnerService.getCustomCommDetail(
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
public @ResponseBody ServicePartnerResultBean deleteLeadComm(@RequestParam("customCommId") String customCommId,
		@RequestParam("customId") String srvcprtnrcd) throws Exception {
	ServicePartnerResultBean customMaster = new ServicePartnerResultBean();
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




@RequestMapping("/uploadfile")
public  ServicePartnerResultBean uploadFile1(MultipartFile file) throws CustomException {
	ServicePartnerResultBean resultBean = new ServicePartnerResultBean();
	try {
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {

				resultBean = servicePartnerService.uploadFile1(file);

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


