package com.dci.tenant.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.common.util.InvoiceMoveToDraft;

@Controller
@RequestMapping(value = "{tenantid}/app/usermaster")
public class UserMasterController {

	@Autowired
	private UserMasterService userMasterService;

	@RequestMapping(value = "/getuserpermissions/{userId}/{companyCode}/{moduleCode}")
	public @ResponseBody UserMasterResultBean getUserPermissions(@PathVariable("userId") String userId,
			@PathVariable("companyCode") String companyCode, @PathVariable("moduleCode") String moduleCode) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		objUserMasterResultBean.setlFormMasterBean(userMasterService.getFormMasterListByCompanyUser(userId, companyCode, moduleCode));
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}
	
	@RequestMapping(value = "/getFormNames")
	public @ResponseBody UserMasterResultBean getFormNames() {
		System.out.println("inside");
		UserMasterResultBean lUserMasterResultBean = new UserMasterResultBean();	
		List<FormPropertyBean> beans = userMasterService.getFormNames();
		System.out.println("inside"+beans.get(0).getFormName());
		lUserMasterResultBean.setlFormPropertyBean(beans);
		lUserMasterResultBean.setSuccess(true);
		System.out.println("formPropertyBean"+lUserMasterResultBean);
		//excelFormexport("");
		return lUserMasterResultBean;
	}	
	
	

	@RequestMapping(value = "/saveuserpermissions/{userId}/{companyCode}/{moduleCode}/{mode}", method = RequestMethod.POST)
	public @ResponseBody UserMasterResultBean setUserPermissions(@RequestBody List<FormMasterBean> lFormMasterBean,
			@PathVariable("userId") String userId, @PathVariable("companyCode") String companyCode, @PathVariable("moduleCode") String moduleCode,@PathVariable("mode") String mode)
			throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		objUserMasterResultBean.setlFormMasterBean(userMasterService.saveFormMasterListByCompanyUser(lFormMasterBean, userId, companyCode, moduleCode,mode));
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}
	
	@RequestMapping(value = "/invoicemovetodraft", method = RequestMethod.POST)
	public @ResponseBody UserMasterResultBean invoicemovetodraft(@RequestBody InvoiceMoveToDraft invoiceDraft)
			throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		boolean isSuccess=userMasterService.invoicemovetodraft(invoiceDraft) ;
		objUserMasterResultBean.setSuccess(isSuccess);
		return objUserMasterResultBean;
	}
	

	@RequestMapping(value = "/getdesgnpermissions/{desgnCode}/{moduleCode}", method = RequestMethod.GET)
	public @ResponseBody UserMasterResultBean getDesgnPermissions(@PathVariable("desgnCode") String desgnCode,
			@PathVariable("moduleCode") String moduleCode) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		objUserMasterResultBean.setlFormMasterBean(userMasterService.getFormMasterListByDesgn(desgnCode, moduleCode));
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}

	@RequestMapping(value = "/savedesgnpermissions/{desgnCode}/{moduleCode}", method = RequestMethod.POST)
	public @ResponseBody UserMasterResultBean saveDesgnPermissions(@RequestBody List<FormMasterBean> lFormMasterBean,
			@PathVariable("desgnCode") String desgnCode, @PathVariable("moduleCode") String moduleCode) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		objUserMasterResultBean.setlFormMasterBean(userMasterService.saveFormMasterListByDesgn(lFormMasterBean, desgnCode, moduleCode));
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}

	@RequestMapping("/insertusertouser")
	public @ResponseBody UserMasterResultBean insertUserToUser(@RequestParam("fromUserId") String fromUserId,
			@RequestParam("toUserId") String toUserId, @RequestParam("compMapped") String compMapped) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		objUserMasterResultBean.setSuccess(userMasterService.insertUserToUser(fromUserId, toUserId, compMapped));
		return objUserMasterResultBean;
	}

	@RequestMapping("/insertcompanytocompany")
	public @ResponseBody UserMasterResultBean insertCompanyToCompany(@RequestParam("fromCompId") String fromCompId,
			@RequestParam("toCompId") String toCompId, @RequestParam("userId") String userId) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		objUserMasterResultBean.setUserMasterBean(userMasterService.insertCompanyToCompany(fromCompId, toCompId, userId));
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}

	@RequestMapping("/usercompanymodulelist")
	public @ResponseBody UserMasterResultBean userCompModList(HttpServletRequest request) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		objUserMasterResultBean.setlUserMasterBean(userMasterService.getUserList());
		objUserMasterResultBean.setlCompanyDetailsBean(userMasterService.getCompanyList());
		objUserMasterResultBean.setlModuleMasterBean(userMasterService.getModuleMasterList());
		objUserMasterResultBean.setlPropertyMasterBean(userMasterService.getPropertyMasterBeanList());
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}

	@RequestMapping("/userlist")
	public @ResponseBody UserMasterResultBean getUserList(@RequestParam("companyCode") String companyCode) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		objUserMasterResultBean.setlUserMasterBean(userMasterService.getUserList(companyCode));
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}

	@RequestMapping("/desgnmodulelist")
	public @ResponseBody UserMasterResultBean getDesignationList(HttpServletRequest request) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		objUserMasterResultBean.setlDesignationMasterBean(userMasterService.getDesignationList());
		objUserMasterResultBean.setlModuleMasterBean(userMasterService.getModuleMasterList());
		objUserMasterResultBean.setlPropertyMasterBean(userMasterService.getPropertyMasterBeanList());
		objUserMasterResultBean.setSuccess(true);
		return objUserMasterResultBean;
	}

	@RequestMapping("/getCompanyList")
	public @ResponseBody List<UserMasterBean> getCompanyList(@RequestParam("formCode") String formCode) throws CustomException {
		List<UserMasterBean> lCompanyList = new ArrayList<UserMasterBean>();

		try {
			lCompanyList = userMasterService.getCompanyList(formCode);
			System.out.println(lCompanyList);
		} catch (Exception e) {
			throw new CustomException();
		}

		return lCompanyList;
	}
	
	@RequestMapping("/getCompanyList1")
	public @ResponseBody List<UserMasterBean> getCompanyList1(@RequestParam("formCode") String formCode) throws CustomException {
		List<UserMasterBean> lCompanyList = new ArrayList<UserMasterBean>();

		try {
			lCompanyList = userMasterService.getCompanyList1(formCode);
			System.out.println(lCompanyList);
		} catch (Exception e) {
			throw new CustomException();
		}

		return lCompanyList;
	}

	@RequestMapping(value = "/generateExcel", method = RequestMethod.POST)
	public @ResponseBody UserMasterResultBean excelexport(@RequestBody UserMasterResultBean objWholeData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		try {
			userMasterService.excellexport(objWholeData, ConfigurationProps.exportFilesPath, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * objUserMasterResultBean.setlFormMasterBean(userMasterService
		 * .saveFormMasterListByCompanyUser(lFormMasterBean, userId,
		 * companyCode, moduleCode)); objUserMasterResultBean.setSuccess(true);
		 */
		return objUserMasterResultBean;
	}

	@RequestMapping(value = "/generateFormExcel", method = RequestMethod.POST)
	public @ResponseBody UserMasterResultBean excelFormexport(@RequestBody UserMasterBean objWholeData) {

		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		try {

			userMasterService.excelFormexport(objWholeData.getFormCode(),ConfigurationProps.exportFilesPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * objUserMasterResultBean.setlFormMasterBean(userMasterService
		 * .saveFormMasterListByCompanyUser(lFormMasterBean, userId,
		 * companyCode, moduleCode)); objUserMasterResultBean.setSuccess(true);
		 */
		return objUserMasterResultBean;
	}
	

	@RequestMapping(value = "/generateEmployeeCompany", method = RequestMethod.POST)
	public @ResponseBody UserMasterResultBean generateEmployeeCompany(@RequestBody UserMasterBean objWholeData, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
		try {
			
			userMasterService.generateEmployeeCompany(objWholeData, ConfigurationProps.exportFilesPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * objUserMasterResultBean.setlFormMasterBean(userMasterService
		 * .saveFormMasterListByCompanyUser(lFormMasterBean, userId,
		 * companyCode, moduleCode)); objUserMasterResultBean.setSuccess(true);
		 */
		return objUserMasterResultBean;
	}
	
	@RequestMapping("/forgetPassword")
	public @ResponseBody UserMasterResultBean forgetPassword(@RequestParam("emailId") String emailId) throws Exception {
		UserMasterResultBean manageUserResultBean = new UserMasterResultBean();
		try {
			Boolean flag = false;
			flag = userMasterService.forgetPassword(emailId);
			manageUserResultBean.setSuccess(flag);
			
		} catch (Exception e) {
			manageUserResultBean.setSuccess(false);
			
		}
		return manageUserResultBean;
	}
	
	@RequestMapping(value = "/listpassword")
	public @ResponseBody UserMasterResultBean getpasswordList() throws Exception {
		UserMasterResultBean resultBean = new UserMasterResultBean();
		try {

			resultBean.setGetPassword(userMasterService.getBranchList());
			resultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return resultBean;

	}
	

	@RequestMapping(value = "/getInvoiceList")
	public @ResponseBody List<SelectivityBean> getInvoiceList(@RequestParam("invoiceType") String invoiceType,@RequestParam("mode") String mode) throws CustomException {
		List<SelectivityBean> List = new ArrayList<SelectivityBean>();
		try {
			List = userMasterService.getInvoiceList(invoiceType,mode);

		} catch (Exception e) {
			
			throw new CustomException();
		}

		return List;
	}
	



}
