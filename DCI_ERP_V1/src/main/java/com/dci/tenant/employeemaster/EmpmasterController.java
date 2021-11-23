package com.dci.tenant.employeemaster;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;

@Controller
@RequestMapping(value = "{tenantid}/app/empmaster")
public class EmpmasterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmpmasterController.class);

	@Value("${profileimg.upload.serverPath}")
	private String profileImgSrvPath;

	@Value("${profileimg.upload.absolutePath}")
	private String profileImgAbsPath;

	@Autowired
	private EmpmasterService empmasterService;

	// Save Method

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody boolean addEmpmaster(@RequestBody EmpmasterBean objEmpmasterBean) throws CustomException {
		boolean isSuccess = false;
		EmpmasterResultBean objEmpmasterResultBean = new EmpmasterResultBean();
		try {

			isSuccess = empmasterService.addEmpmaster(objEmpmasterBean);
			System.out.println("Result" + isSuccess);
			objEmpmasterResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}
	

		return isSuccess;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateEmpmaster(@RequestBody EmpmasterBean objEmpmasterBean) throws CustomException {
		boolean isSuccess = false;
		EmpmasterResultBean objEmpmasterResultBean = new EmpmasterResultBean();
		try {

			isSuccess = empmasterService.updateEmpmaster(objEmpmasterBean);
			objEmpmasterResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/getEmployee")
	public @ResponseBody List getEmployee() throws CustomException {
		List sEmployee = new ArrayList();
		try {
			sEmployee = empmasterService.getEmployee();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sEmployee;
	}

	@RequestMapping("/edit")
	public @ResponseBody EmpmasterBean editempmasterValues(@RequestBody String empId) throws CustomException {
		EmpmasterBean empBean = new EmpmasterBean();
		try {
			empBean = empmasterService.getempmasterValues(empId);
			empBean.setIsEdit(true);
		} catch (Exception e) {
			empBean.setIsEdit(false);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return empBean;
	}

	@RequestMapping("/userdetails")
	public @ResponseBody EmpmasterBean userDetail() throws CustomException {
		EmpmasterBean empList = new EmpmasterBean();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			empList = empmasterService.getempmasterValues(userDetails.getUserId());
			empList.setProfileImg(profileImgSrvPath + "/" + empList.getProfileImg());
			empList.setIsEdit(true);
		} catch (Exception e) {
			empList.setIsEdit(false);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return empList;
	}

	@RequestMapping(value = "/userdetail", method = RequestMethod.POST)
	public @ResponseBody EmpmasterResultBean saveUserDetail(MultipartFile file) throws CustomException {
		EmpmasterResultBean resultBean = new EmpmasterResultBean();
		try {
			if (!file.isEmpty()) {
			//	String uplFileName = FileUploadUtillity.uploadProfileImage(file, profileImgAbsPath);
				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				EmpmasterBean objEmpmasterBean = new EmpmasterBean();
			//	objEmpmasterBean.setProfileImg(uplFileName);
				objEmpmasterBean.setEmpId(userDetails.getUserId());
				if (empmasterService.updateUserProfile(objEmpmasterBean)) {
					EmpmasterBean empmasterBean = empmasterService.getempmasterValues(userDetails.getUserId());
					empmasterBean.setProfileImg(profileImgSrvPath + "/" + empmasterBean.getProfileImg());
					resultBean.setEmpmasterBean(empmasterBean);
					resultBean.setSuccess(true);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}
	

	@RequestMapping("/getCompany")
	public @ResponseBody EmpmasterResultBean getCompany() throws CustomException {
		EmpmasterResultBean objBean = null;
		try {
			objBean = empmasterService.getCompany();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objBean;
	}

	@RequestMapping("/getDepartment")
	public @ResponseBody EmpmasterResultBean getDepartment() throws CustomException {
		EmpmasterResultBean sDepartment = null;
		try {
			sDepartment = empmasterService.getDepartment();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sDepartment;
	}

	@RequestMapping("/getDesignation")
	public @ResponseBody EmpmasterResultBean getDesignation() throws CustomException {
		EmpmasterResultBean sDesignation = null;
		try {
			sDesignation = empmasterService.getDesignation();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sDesignation;
	}

	// Getting List

	@RequestMapping("/list")
	public @ResponseBody EmpmasterResultBean getEmpmasterList(@RequestParam("limit") int limit, @RequestParam("offset") int offset)
			throws CustomException, InterruptedException {
		EmpmasterResultBean objEmpmasterResultBean = new EmpmasterResultBean();

		if (offset < 5000) {
			try {
				objEmpmasterResultBean.setlEmpmasterBean(empmasterService.getEmpmasterList(limit, offset));
				objEmpmasterResultBean.setlEmpmasterBeanExcel(empmasterService.getEmpmasterList(limit, offset));
				objEmpmasterResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objEmpmasterResultBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteEmpmaster(@RequestBody String empId) throws Exception {
		boolean isDeleted = false;
		isDeleted = empmasterService.deleteEmpmaster(empId);
		return isDeleted;
	}

	@RequestMapping("/pswdUpdate")
	public @ResponseBody EmpmasterResultBean changepasswordUpdate(@RequestBody EmpmasterBean objEmpmasterBean, HttpServletRequest request)
			throws CustomException {
		boolean isUpdate = false;
		EmpmasterResultBean objBean = new EmpmasterResultBean();
		try {
			if (objEmpmasterBean.getNewpswd().equals(objEmpmasterBean.getConfrmPwd())) {
				objBean = empmasterService.updateUserPassword(objEmpmasterBean);
				//objBean.setSuccess(true);

 				  

			} else {
				objBean.setSuccess(false);
				objBean.setErrors("Passwords do not match!");
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objBean;
	}

	// excel
	@RequestMapping(value = "/generateExcel", method = RequestMethod.POST)
	public @ResponseBody EmpmasterResultBean exportExcel(@RequestBody EmpmasterResultBean objWholeData, HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
		EmpmasterResultBean reportBuilderResultBean = new EmpmasterResultBean();
		try {
			empmasterService.excellexport(objWholeData, ConfigurationProps.exportFilesPath, null);
			reportBuilderResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportBuilderResultBean;
	}

	@RequestMapping("/getCompanyLocation")
	public @ResponseBody EmpmasterResultBean getCompanyLocation() throws CustomException {
		EmpmasterResultBean objRsltBean = new EmpmasterResultBean();

		try {
			objRsltBean = empmasterService.getCompanyLocation();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objRsltBean;
	}
}

