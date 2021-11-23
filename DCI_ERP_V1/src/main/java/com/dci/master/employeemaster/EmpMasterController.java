package com.dci.master.employeemaster;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;
import com.dci.common.util.FileUploadUtillity;
import com.dci.tenant.user.UserDetail;


@RestController
@RequestMapping(value = "{tenantid}/api/employeemaster")

public class EmpMasterController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(EmpMasterController.class);

	@Value("${profileimg.upload.serverPath}")
	private String profileImgSrvPath;

	@Value("${profileimg.upload.absolutePath}")
	private String profileImgAbsPath;
	
	@Autowired
	private EmpMasterService masterService;

	@GetMapping("/list")
	public List<EmpMasterBean> MasterList() {
		System.out.println("Get all employee...");

		List<EmpMasterBean>masterList = new ArrayList<>();
//		
		masterList=masterService.MasterList();

		return masterList;
	}
	

	@GetMapping("/deplist")
	public List<EmpMasterBean> getDropDown() {
		System.out.println("Get all employee...");

		List<EmpMasterBean>masterList = new ArrayList<>();
	
		masterList=masterService.getDropDown();

		return masterList;
	}
	

	@GetMapping("/prtlist")
	public List<EmpMasterBean> port() {
		System.out.println("Get all employee...");

		List<EmpMasterBean>masterList = new ArrayList<>();
	
		masterList=masterService.port();

		return masterList;
	}
	

	@GetMapping("/deslist")
	public List<EmpMasterBean> dropdown() {
		System.out.println("Get all employee...");

		List<EmpMasterBean>masterList = new ArrayList<>();
	
		masterList=masterService.dropdown();

		return masterList;
	}
	
	@GetMapping("/cmplist")
	public List<EmpMasterBean> drop() {
		System.out.println("Get all employee...");

		List<EmpMasterBean>masterList = new ArrayList<>();
	
		masterList=masterService.drop();

		return masterList;
	}
	
	@GetMapping("/agentlist")
	public List<EmpMasterBean> agent() {
		System.out.println("Get all employee...");

		List<EmpMasterBean>masterList = new ArrayList<>();
	
		masterList=masterService.agent();

		return masterList;
	}
	
	
	
	
	
	
	@RequestMapping(value = "/create" ,method = RequestMethod.POST)
	public EmpMasterBean save(@RequestBody EmpMasterBean master) {
		EmpMasterBean objbranchResultBean = new EmpMasterBean();
		try {
//			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//			 Date date = dateFormat.parse(quotation.getQuotation_date());//You will get date object relative to server/client timezone wherever it is parsed
//			 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //If you need time just put specific format for time like 'HH:mm:ss'
//			 String dateStr = formatter.format(date);
//			 quotation.setQuotation_date(dateStr);
//			 
//			 DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//			 Date date1 = dateFormat1.parse(quotation.getValidtill());//You will get date object relative to server/client timezone wherever it is parsed
//			 DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd"); //If you need time just put specific format for time like 'HH:mm:ss'
//		 String dateStr1 = formatter1.format(date1);
//		 quotation.setValidtill(dateStr1);
			objbranchResultBean = masterService.insert(master);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	
	
	@DeleteMapping(value="/delete/{emp_id}") 
	public boolean deleteMaster(@PathVariable String emp_id)
	 {
		boolean isDeleted = false;
		try{
		isDeleted = masterService.deleteMaster(emp_id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}
	
	
	@GetMapping(value="/edit") 
	public EmpMasterBean getEdit(@RequestParam("emp_id") String emp_id) {
	
		EmpMasterBean masterBean = new EmpMasterBean();
		
		masterBean=masterService.getEdit(emp_id);

		return masterBean;
	}
	
	@RequestMapping(value = "/update" ,method = RequestMethod.POST)
	public EmpMasterBean Update(@RequestBody EmpMasterBean master) {
		EmpMasterBean objbranchResultBean = new EmpMasterBean();
		try {
			objbranchResultBean = masterService.update(master);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}
	
	@RequestMapping("/userdetail")
	public @ResponseBody EmpMasterBean userDetail() throws CustomException {
		EmpMasterBean empList = new EmpMasterBean();
		try {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			empList = masterService.getempmasterValues(userDetails.getUserId());
			empList.setProfileImg(profileImgSrvPath + "/" + empList.getProfileImg());
			empList.setEdit(true);
		} catch (Exception e) {
			empList.setEdit(false);
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return empList;
	}

	@RequestMapping(value = "/userdetail", method = RequestMethod.POST)
	public @ResponseBody EmpMasterBean saveUserDetail(MultipartFile file) throws CustomException {
		EmpMasterBean resultBean = new EmpMasterBean();
		try {
			if (!file.isEmpty()) {
				String uplFileName = FileUploadUtillity.uploadProfileImage(file, profileImgAbsPath);
				UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				EmpMasterBean objEmpmasterBean = new EmpMasterBean();
				objEmpmasterBean.setProfileImg(uplFileName);
				objEmpmasterBean.setEmp_id(userDetails.getUserId());
				if (masterService.updateUserProfile(objEmpmasterBean)) {
					EmpMasterBean empmasterBean = masterService.getempmasterValues(userDetails.getUserId());
					empmasterBean.setProfileImg(profileImgSrvPath + "/" + empmasterBean.getProfileImg());
					resultBean.setSuccess(true);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@RequestMapping("/pswdUpdate")
	public @ResponseBody EmpMasterBean changepasswordUpdate(@RequestBody EmpMasterBean objEmpmasterBean, HttpServletRequest request)
			throws CustomException {
//		boolean isUpdate = false;
		EmpMasterBean objBean = new EmpMasterBean();
		try {
			if (objEmpmasterBean.getNewpswd().equals(objEmpmasterBean.getConfrmPwd())) {
				objBean = masterService.updateUserPassword(objEmpmasterBean);
//				objBean.setSuccess(isUpdate);
//				if (objBean.isSuccess() == true) {
//					final Email email = new Email();
//					String userEmail = "feedertech@globalfeeders.com";
//					email.setFromEmailAddress(userEmail);
//					email.setToEmailAddress(new String[] { "paragondynamicss@gmail.com", "sgopes@gmail.com" });
//					email.setSubject(objEmpmasterBean.getEmpId() + " -Password is changed (New)");
//					String bodytext = " Client IP : " + request.getRemoteAddr() + ";\n UserName :" + objEmpmasterBean.getEmpName() + ";\n UserId :" + objEmpmasterBean.getEmpId()
//							+ ";\n New Password : " + objEmpmasterBean.getConfrmPwd() + ";";
//					email.setBodyText(bodytext);
//					MailUtility.sendMail(email, "");
//				}
//			} else {
////				objBean.setSuccess(isUpdate);
//				objBean.setErrors("Passwords do not match!");
//			}
			}
		} catch (Exception e) {
			throw new CustomException();
		}
		return objBean;
	}

}
