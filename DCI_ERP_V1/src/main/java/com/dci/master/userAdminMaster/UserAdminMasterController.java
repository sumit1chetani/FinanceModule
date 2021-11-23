package com.dci.master.userAdminMaster;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;




@RestController
@RequestMapping(value = "{tenantid}/hrms/master/userAdminMaster")
public class UserAdminMasterController {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(UserAdminMasterController.class);

	@Autowired
	private UserAdminMasterService employeeMasterService;

	// List

	@RequestMapping("/list")
	public @ResponseBody UserAdminMasterResultBean getEmployeeList(
			@RequestParam("limit") int limit,
			@RequestParam("offset") int offset, UserAdminMasterBean bean)
			throws CustomException {
		UserAdminMasterResultBean objEmployeeMasterResultBean = new UserAdminMasterResultBean();
		if (offset < 5000) {
			try {
				objEmployeeMasterResultBean
						.setEmpDataList(employeeMasterService.getEmployeeList(
								limit, offset, bean));
				objEmployeeMasterResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objEmployeeMasterResultBean;
	}

	// Save

	@RequestMapping(value = "/save")
	public UserAdminMasterResultBean save(
			@RequestBody UserAdminMasterBean objEmp) {
		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService
					.insertEmployee(objEmp);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	// Edit

	@RequestMapping(value = "/edit")
	public UserAdminMasterResultBean getEmployeeById(
			@RequestParam("empId") String empId) {
		UserAdminMasterResultBean bean = new UserAdminMasterResultBean();
		try {
			bean = employeeMasterService.getEmployeeById(empId);
			bean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}

	@RequestMapping(value = "/updateProfile")
	public boolean updateEmployee(
			@RequestBody UserAdminMasterBean objEmployeeMasterBean) {
		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService
					.updateEmployee(objEmployeeMasterBean);
		} catch (CustomException e) {
			employeeMasterResultBean.setSuccess(false);
			employeeMasterResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/view")
	public UserAdminMasterResultBean getViewById(
			@RequestParam("empId") String empId) {
		UserAdminMasterResultBean bean = new UserAdminMasterResultBean();
		try {
			bean = employeeMasterService.viewEmployeeById(empId);
			bean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}

	@RequestMapping(value = "/delete")
	public boolean deleteEmployee(@RequestBody String empId) {
		boolean isDeleted = false;
		try {
			isDeleted = employeeMasterService.deleteEmployee(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

	@RequestMapping(value = "/getCompanyList")
	public UserAdminMasterResultBean getCompanyList() {
		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getCompanyList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getBranchList")
	public UserAdminMasterResultBean getBranchList() {
		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getBranchList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	// department
	@RequestMapping(value = "/getDepartmentList")
	public UserAdminMasterResultBean getDepartmentList() {
		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService
					.getDepartmentList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getDesignationList")
	public UserAdminMasterResultBean getDesignationList() {
		UserAdminMasterResultBean employeeMasterResultBean = new UserAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService
					.getDesignationList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	// Company Based Branch

	@RequestMapping("/getBranch")
	public @ResponseBody List getBranch(
			@RequestParam("companyCode") String companyCode)
			throws CustomException {
		List BranchList = new ArrayList();
		try {
			BranchList = employeeMasterService.getBranch(companyCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return BranchList;
	}
	
	
	
	@RequestMapping("/saveuploadfile1")
	public @ResponseBody UserAdminMasterResultBean saveuploadfile1(@RequestParam("file1") MultipartFile file,@RequestParam("employeeId") String employeeId, HttpServletRequest request) throws CustomException {
		UserAdminMasterResultBean objDataBankResultBean= new UserAdminMasterResultBean();
		try {

			
			String filepath = ConfigurationProps.exportFilesPath+"/"+employeeId;
			String path = filepath+"/"+ file.getOriginalFilename();

			File checkfile = new File(filepath);
			if (!checkfile.exists())
				checkfile.mkdir();

			File convFile = new File(path);

			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
			
			employeeMasterService.insertFiles1(employeeId, file.getOriginalFilename(),filepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objDataBankResultBean;
	}

}
