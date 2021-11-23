package com.dci.master.employeeAdminMaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;




@RestController
@RequestMapping(value = "{tenantid}/hrms/master/employeeAdminMaster")
public class EmployeeAdminMasterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeAdminMasterController.class);

	@Autowired
	private EmployeeAdminMasterService employeeMasterService;

	/*
	 * @RequestMapping(value = "/list") public EmployeeMasterResultBean
	 * getEmpDataList() throws Exception { EmployeeMasterResultBean
	 * employeeMasterResultBean = new EmployeeMasterResultBean();
	 * 
	 * employeeMasterResultBean.setEmpDataList(employeeMasterService.getEmpDataList
	 * ()); employeeMasterResultBean.setSuccess(true);
	 * 
	 * return employeeMasterResultBean; }
	 */
	//
	@RequestMapping("/list")
	public @ResponseBody EmployeeAdminMasterResultBean getEmployeeList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, EmployeeAdminMasterBean bean) throws CustomException {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		if (offset < 5000) {
			try {
				objEmployeeMasterResultBean.setEmpDataList(employeeMasterService.getEmployeeList(limit, offset, bean));
				objEmployeeMasterResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objEmployeeMasterResultBean;
	}

	@RequestMapping("/showEmployeeReport")
	public @ResponseBody EmployeeAdminMasterResultBean getEmployeeReportList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("cmp") String cmp, @RequestParam("dept") int dept, @RequestParam("branch") String branch) throws CustomException {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		if (offset < 5000) {
			try {
				objEmployeeMasterResultBean.setEmployeeReportShow(employeeMasterService.getEmployeeReportList(limit, offset, cmp, dept, branch));
				objEmployeeMasterResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objEmployeeMasterResultBean;
	}

	@RequestMapping(value = "/edit")
	public EmployeeAdminMasterResultBean getEmployeeById(@RequestParam("empId") String empId) {
		EmployeeAdminMasterResultBean bean = new EmployeeAdminMasterResultBean();
		try {
			bean = employeeMasterService.getEmployeeById(empId);
			bean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}
	@RequestMapping(value = "/view")
	public EmployeeAdminMasterResultBean getViewById(@RequestParam("empId") String empId) {
		EmployeeAdminMasterResultBean bean = new EmployeeAdminMasterResultBean();
		try {
			bean = employeeMasterService.viewEmployeeById(empId);
			bean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}
	@RequestMapping(value = "/getDesignationStatus")
	public EmployeeAdminMasterResultBean getDesignationStatus(@RequestParam("designationId") String designationId) {
		EmployeeAdminMasterResultBean employeeAdminMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeAdminMasterResultBean = employeeMasterService.getDesigantion(designationId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeAdminMasterResultBean;

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
	public EmployeeAdminMasterResultBean getCompanyList() {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getCompanyList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getEmpEduList")
	public EmployeeAdminMasterResultBean getEmpEduList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getEmpEduList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getEmpDocumentList")
	public EmployeeAdminMasterResultBean getEmpDocumentList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getEmpDocumentList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getEmpFamList")
	public EmployeeAdminMasterResultBean getEmpFamList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getEmpFamList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getEmergencyList")
	public EmployeeAdminMasterResultBean getEmergencyList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getEmergencyList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getProbationList")
	public EmployeeAdminMasterResultBean getProbationList(@RequestBody String employeeId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getProbationList(employeeId);
			employeeMasterResultBean.setEmpId(employeeId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editPhysical")
	public EmployeeAdminMasterResultBean editPhysical(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeePhysical(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editPerDet")
	public EmployeeAdminMasterResultBean editPerDet(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeDetail(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editRule")
	public EmployeeAdminMasterResultBean editRule(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeRule(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editPersonal")
	public EmployeeAdminMasterResultBean editPersonal(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeePersonal(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editAddress")
	public EmployeeAdminMasterResultBean editAddress(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeAddress(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/editPayRoll")
	public EmployeeAdminMasterResultBean editPayRoll(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editPayRoll(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	
	@RequestMapping(value = "/editFormReview")
	public EmployeeAdminMasterResultBean editFormReview(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editFormReview(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	

	@RequestMapping(value = "/editAssets")
	public EmployeeAdminMasterResultBean editAssets(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editAssets(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	@RequestMapping(value = "/editPassportReqeuest")
	public EmployeeAdminMasterResultBean editPassportReqeuest(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editPassportReqeuest(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	@RequestMapping(value = "/editAirClaim")
	public EmployeeAdminMasterResultBean editAirClaim(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editAirClaim(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/editSettlement")
	public EmployeeAdminMasterResultBean editSettlement(@RequestParam("empId") String editEmployeeID) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editSettlement(editEmployeeID);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	@RequestMapping(value = "/editEmployeeProbation")
	public EmployeeAdminMasterResultBean editEmployeeProbation(@RequestBody EmployeeAdminProbationBean objEmployeeProbationBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeProbation(objEmployeeProbationBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editEmployeeMerits")
	public EmployeeAdminMasterResultBean editEmployeeMerits(@RequestBody EmployeeAdminMeritsBean objEmployeeMeritsBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeMerits(objEmployeeMeritsBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editEmployeeFamily")
	public EmployeeAdminMasterResultBean editEmployeeFamily(@RequestBody EmployeeAdminFamilyBean objEmployeeFamilyBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeFamily(objEmployeeFamilyBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editEmployeeExperiance")
	public EmployeeAdminMasterResultBean editEmployeeExperiance(@RequestBody EmployeeAdminExperianceBean objEmployeeExperianceBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeExperiance(objEmployeeExperianceBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editEmployeeDoc")
	public EmployeeAdminMasterResultBean editEmployeeDoc(@RequestBody EmployeeAdminDocumentBean objEmployeeDocumentBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeDoc(objEmployeeDocumentBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editEmployeeEducation")
	public EmployeeAdminMasterResultBean editEmployeeEducation(@RequestBody EmployeeAdminEducationBean objEmployeeEducationBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeEducation(objEmployeeEducationBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editEmployeeReference")
	public EmployeeAdminMasterResultBean editEmployeeReference(@RequestBody EmployeeAdminReferanceBean objBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeReference(objBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editEmployeeEmergency")
	public EmployeeAdminMasterResultBean editEmployeeEmergency(@RequestBody EmployeeAdminEmergencyBean objBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeEmergency(objBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/editEmployeeNomination")
	public EmployeeAdminMasterResultBean editEmployeeNomination(@RequestBody EmployeeAdminNominationBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.editEmployeeNomination(objEmp);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/deleteProbation")
	public EmployeeAdminMasterResultBean deleteProbation(@RequestBody EmployeeAdminProbationBean objProbationBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.deleteEmployeeProbation(objProbationBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/deleteExperiance")
	public EmployeeAdminMasterResultBean deleteExperiance(@RequestBody EmployeeAdminExperianceBean objExperianceBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.deleteEmployeeExperiance(objExperianceBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/deleteEducation")
	public EmployeeAdminMasterResultBean deleteEducation(@RequestBody EmployeeAdminEducationBean objEducationBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.deleteEmployeeEducation(objEducationBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/deleteDoc")
	public EmployeeAdminMasterResultBean deleteDoc(@RequestBody EmployeeAdminDocumentBean objDocumentBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.deleteEmployeeDoc(objDocumentBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/deleteFamily")
	public EmployeeAdminMasterResultBean deleteFamily(@RequestBody EmployeeAdminFamilyBean objFamilyBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.deleteEmployeeFamily(objFamilyBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/deleteMerits")
	public EmployeeAdminMasterResultBean deleteMerits(@RequestBody EmployeeAdminMeritsBean objMeritsBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.deleteEmployeeMerit(objMeritsBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/deleteNomination")
	public EmployeeAdminMasterResultBean deleteNomination(@RequestBody EmployeeAdminNominationBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.deleteEmployeeNomination(objEmp);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/deleteEmergency")
	public EmployeeAdminMasterResultBean deleteEmergency(@RequestBody EmployeeAdminEmergencyBean objemp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.deleteEmployeeEmergency(objemp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/deleteReference")
	public EmployeeAdminMasterResultBean deleteReference(@RequestBody EmployeeAdminReferanceBean objBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.deleteEmployeeReference(objBean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "updateEmployeeReference")
	public EmployeeAdminMasterResultBean updateEmployeeReference(@RequestBody EmployeeAdminReferanceBean objEmployeeReferanceBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.updateEmployeeReference(objEmployeeReferanceBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/updateEmployeeNomination")
	public EmployeeAdminMasterResultBean updateEmployeeNomination(@RequestBody EmployeeAdminNominationBean objEmployeeNominationBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.updateEmployeeNomination(objEmployeeNominationBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/updateEmployeeProbation")
	public EmployeeAdminMasterResultBean updateEmployeeProbation(@RequestBody EmployeeAdminProbationBean objEmployeeProbationBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.updateEmployeeProbation(objEmployeeProbationBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/updateEmployeeEmergency")
	public EmployeeAdminMasterResultBean updateEmployeeEmergency(@RequestBody EmployeeAdminEmergencyBean objEmployeeEmergencyBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.updateEmployeeEmergency(objEmployeeEmergencyBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/updateEmployeeDoc")
	public EmployeeAdminMasterResultBean updateEmployeeDoc(@RequestBody EmployeeAdminDocumentBean objEmployeeDocumentBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.updateEmployeeDoc(objEmployeeDocumentBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/updateEmployeeEducation")
	public EmployeeAdminMasterResultBean updateEmployeeEducation(@RequestBody EmployeeAdminEducationBean objEmployeeEducationBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.updateEmployeeEducation(objEmployeeEducationBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/updateEmployeeFamily")
	public EmployeeAdminMasterResultBean updateEmployeeFamily(@RequestBody EmployeeAdminFamilyBean objEmployeeFamilyBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.updateEmployeeFamily(objEmployeeFamilyBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/UpdateExperianceDetail")
	public EmployeeAdminMasterResultBean UpdateExperianceDetail(@RequestBody EmployeeAdminExperianceBean objEmployeeExperianceBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.UpdateExperianceDetail(objEmployeeExperianceBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/updateEmployeeMerit")
	public EmployeeAdminMasterResultBean updateEmployeeMerit(@RequestBody EmployeeAdminMeritsBean objEmployeeMeritsBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.updateEmployeeMerit(objEmployeeMeritsBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getReferenceList")
	public EmployeeAdminMasterResultBean getReferenceList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getReferenceList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/getLeaveList")
	public EmployeeAdminMasterResultBean getLeaveList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getLeaveList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/getContractList")
	public EmployeeAdminMasterResultBean getContractList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getContractList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	
	@RequestMapping(value = "/getPayslipList")
	public EmployeeAdminMasterResultBean getPayslipList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getPayslipList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/getAssetsList")
	public EmployeeAdminMasterResultBean getAssetsList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getAssetsList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
//	/getLeaveList
	@RequestMapping(value = "/getLeaveListSeach")
	public EmployeeAdminMasterResultBean getLeaveListSeach(@RequestBody EmployeeAdminMasterBean bean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getLeaveListSeach(bean);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	@RequestMapping(value = "/getAirClaimList")
	public EmployeeAdminMasterResultBean getAirClaimList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getAirClaimList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	

	@RequestMapping(value = "/getLetterRequestList")
	public EmployeeAdminMasterResultBean getLetterRequestList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getLetterRequestList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	

	@RequestMapping(value = "/getAddressBookList")
	public EmployeeAdminMasterResultBean getAddressBookList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getAddressBookList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	@RequestMapping(value = "/getSettlementList")
	public EmployeeAdminMasterResultBean getSettlementList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getSettlementList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	

	
	@RequestMapping(value = "/getLoanList")
	public EmployeeAdminMasterResultBean getLoanList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getLoanList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/getPassportRelease")
	public EmployeeAdminMasterResultBean getPassportRelease(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getPassportRelease(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	
	
	@RequestMapping(value = "/getpayrolldeductionList")
	public EmployeeAdminMasterResultBean getpayrolldeductionList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getpayrolldeductionList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	

	@RequestMapping(value = "/getformList")
	public EmployeeAdminMasterResultBean getformList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getformList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	@RequestMapping(value = "/getEndofserviceList")
	public EmployeeAdminMasterResultBean getEndofserviceList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getEndofserviceList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/getPayrollBankList")
	public EmployeeAdminMasterResultBean getPayrollBankList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getPayrollBankList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/gettravelHistorysList")
	public EmployeeAdminMasterResultBean gettravelHistorysList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.gettravelHistorysList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getEmpMeritList")
	public EmployeeAdminMasterResultBean getEmpMeritList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getEmpMeritList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getNominationList")
	public EmployeeAdminMasterResultBean getNominationList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getNominationList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getEmpExList")
	public EmployeeAdminMasterResultBean getEmpExList(@RequestBody String empId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getEmpExList(empId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getBranchList")
	public EmployeeAdminMasterResultBean getBranchList() {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getBranchList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	@RequestMapping(value = "/getBranchList1")
	public EmployeeAdminMasterResultBean getBranchList1(@RequestBody String comp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getBranchList1(comp);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}
	// department
	@RequestMapping(value = "/getDepartmentList")
	public EmployeeAdminMasterResultBean getDepartmentList() {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getDepartmentList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getDesignationList")
	public EmployeeAdminMasterResultBean getDesignationList() {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getDesignationList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getDivisionList")
	public EmployeeAdminMasterResultBean getDivisionList() {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getDivisionList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getGradeList")
	public EmployeeAdminMasterResultBean getGradeList() {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getGradeList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getReportBranchList")
	public EmployeeAdminMasterResultBean getReportToBranchList() {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getReportToBranchList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getReportToDeptList")
	public EmployeeAdminMasterResultBean getReportToDeptList(@RequestBody String branchId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getReportToDeptList(branchId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getReportToDesigList")
	public EmployeeAdminMasterResultBean getReportToDesigList(@RequestBody String repManagerId) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getReportToDesigList(repManagerId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getEmpType")
	public EmployeeAdminMasterResultBean getEmpTypeList() {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getEmpTypeList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	/*
	 * @RequestMapping(value = "/getReportManaget") public
	 * EmployeeMasterResultBean getReportToManagerList() {
	 * EmployeeMasterResultBean employeeMasterResultBean = new
	 * EmployeeMasterResultBean(); try { employeeMasterResultBean =
	 * employeeMasterService.getReportToManagerList();
	 * employeeMasterResultBean.setSuccess(true); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } return
	 * employeeMasterResultBean; }
	 */

	@RequestMapping("/getReportManager")
	public @ResponseBody List getReportingManager(@RequestParam("depId") int depId, @RequestParam("branchId") String branchId) throws CustomException {
		List reportingList = new ArrayList();
		try {
			reportingList = employeeMasterService.getReporingManager(depId, branchId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return reportingList;
	}

	@RequestMapping(value = "/save")
	public EmployeeAdminMasterResultBean save(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.insertEmployee(objEmp);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	@RequestMapping(value = "/savePersonal")
	public EmployeeAdminMasterResultBean savePersonal(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {

			employeeMasterResultBean = employeeMasterService.insertEmployeePersonal(objEmp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	@RequestMapping(value = "/saveProbation")
	public EmployeeAdminMasterResultBean saveProbation(@RequestBody EmployeeAdminProbationBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {

			employeeMasterResultBean = employeeMasterService.insertEmployeeProbation(objEmp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	@RequestMapping(value = "/saveRules")
	public EmployeeAdminMasterResultBean saveRules(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {

			employeeMasterResultBean = employeeMasterService.insertEmployeeRule(objEmp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	@RequestMapping(value = "/saveDocument")
	public EmployeeAdminMasterResultBean saveDocument(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {

			employeeMasterResultBean = employeeMasterService.insertEmployeeDocument(objEmp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	@RequestMapping(value = "/savePhysical")
	public EmployeeAdminMasterResultBean savePhysical(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {

			employeeMasterResultBean = employeeMasterService.insertEmployeePhysical(objEmp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	@RequestMapping(value = "/saveAddress")
	public EmployeeAdminMasterResultBean saveAddress(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.insertEmployeeAddress(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/savePayBank")
	public EmployeeAdminMasterResultBean savePayBank(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.savePayBank(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;
	}

	
	
	
	@RequestMapping(value = "/savefrmAssets")
	public EmployeeAdminMasterResultBean savefrmAssets(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.savefrmAssets(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;
	}

	
	
	
	@RequestMapping(value = "/saveAirClaim")
	public EmployeeAdminMasterResultBean saveAirClaim(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.saveAirClaim(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/saveSettle")
	public EmployeeAdminMasterResultBean saveSettle(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.saveSettle(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/savePassport")
	public EmployeeAdminMasterResultBean savePassport(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.savePassport(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;
	}
	
	
	@RequestMapping(value = "/saveFormReview")
	public EmployeeAdminMasterResultBean saveFormReview(@RequestBody EmployeeAdminMasterBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.saveFormReview(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;
	}
	@RequestMapping(value = "/saveEducationDetail")
	public EmployeeAdminMasterResultBean saveEducation(@RequestBody EmployeeAdminEducationBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.insertEmployeeEducation(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/saveExperianceDetail")
	public EmployeeAdminMasterResultBean save(@RequestBody EmployeeAdminExperianceBean objEmp) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.insertEmployeeExperiance(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	@RequestMapping(value = "/saveFamily")
	public EmployeeAdminMasterResultBean saveFamily(@RequestBody EmployeeAdminFamilyBean objEmp) {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			objEmployeeMasterResultBean = employeeMasterService.insertEmployeeFamily(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objEmployeeMasterResultBean;
	}

	@RequestMapping(value = "/saveDoc")
	public EmployeeAdminMasterResultBean saveDocuments(@RequestBody EmployeeAdminDocumentBean objEmp) {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			objEmployeeMasterResultBean = employeeMasterService.insertEmployeeDoc(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objEmployeeMasterResultBean;
	}

	@RequestMapping(value = "/saveMerits")
	public EmployeeAdminMasterResultBean saveMerits(@RequestBody EmployeeAdminMeritsBean objEmp) {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			objEmployeeMasterResultBean = employeeMasterService.insertEmployeeMerits(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objEmployeeMasterResultBean;
	}

	@RequestMapping(value = "/saveEmergency")
	public EmployeeAdminMasterResultBean saveEmergency(@RequestBody EmployeeAdminEmergencyBean objEmp) {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			objEmployeeMasterResultBean = employeeMasterService.insertEmployeeEmergency(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objEmployeeMasterResultBean;
	}

	@RequestMapping(value = "/saveReference")
	public EmployeeAdminMasterResultBean saveReference(@RequestBody EmployeeAdminReferanceBean objEmp) {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			objEmployeeMasterResultBean = employeeMasterService.insertEmployeeReference(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objEmployeeMasterResultBean;
	}

	@RequestMapping(value = "/saveNomination")
	public EmployeeAdminMasterResultBean saveNomination(@RequestBody EmployeeAdminNominationBean objEmp) {
		EmployeeAdminMasterResultBean objEmployeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			objEmployeeMasterResultBean = employeeMasterService.insertEmployeeNomination(objEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objEmployeeMasterResultBean;
	}

	@RequestMapping(value = "/updateProfile")
	public boolean updateEmployee(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updateEmployee(objEmployeeMasterBean);
		} catch (CustomException e) {
			employeeMasterResultBean.setSuccess(false);
			employeeMasterResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/updatePersonalInfo")
	public boolean updatePersonalInfo(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updatePersonalInfo(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/updateAddress")
	public boolean updateAddress(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updateAddress(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	
	@RequestMapping(value = "/updatePayBank")
	public boolean updatePayBank(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updatePayBank(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	@RequestMapping(value = "/updateformReview")
	public boolean updateformReview(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updateformReview(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	

	@RequestMapping(value = "/updatefrmAssets")
	public boolean updatefrmAssets(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updatefrmAssets(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	
	@RequestMapping(value = "/updateAirClaim")
	public boolean updateAirClaim(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updateAirClaim(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	@RequestMapping(value = "/updateSettle")
	public boolean updateSettle(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updateSettle(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	@RequestMapping(value = "/updatePassport")
	public boolean updatePassport(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updatePassport(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	@RequestMapping(value = "/updateRules")
	public boolean updateRules(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updateRules(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/updateDocument")
	public boolean updateDocument(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updateDocument(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/updatePhysical")
	public boolean updatePhysical(@RequestBody EmployeeAdminMasterBean objEmployeeMasterBean) {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeMasterService.updatePhysical(objEmployeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/uploadfile")
	public EmployeeAdminMasterResultBean uploadFile(MultipartFile file, @RequestParam("fileName") String employeeId) throws IOException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.uploadFile(file, employeeId);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}
	@RequestMapping(value = "/getYearList")
	public EmployeeAdminMasterResultBean getYearList() throws IOException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		EmployeeAdminMasterResultBean beans = new EmployeeAdminMasterResultBean();
		try {
			beans = employeeMasterService.getYearList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return beans;

	}

	@RequestMapping(value = "/uploadDocfile")
	public EmployeeAdminMasterResultBean uploadDocFile(MultipartFile file) throws IOException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.uploadDocFile(file);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	@RequestMapping(value = "/bloodgrouplist")
	private EmployeeAdminMasterResultBean getbloodgroupList() {
		EmployeeAdminMasterResultBean resultbean = new EmployeeAdminMasterResultBean();

		try {
			resultbean = employeeMasterService.getBloodGroupList();
			resultbean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultbean;
	}
	// UPLOAD FILE
	@RequestMapping("/uploadExefile")
	public @ResponseBody EmployeeAdminMasterResultBean uploadExeFile(MultipartFile file) throws CustomException {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					employeeMasterResultBean.setSuccess(employeeMasterService.uploadExeFile(file));

				} else {
					employeeMasterResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				employeeMasterResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/getEmployeeNameList")
	public EmployeeAdminMasterResultBean getEmployeeNameList() {
		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.getEmployeeNameList();
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;
	}

	@RequestMapping(value = "/uploadEmpDependnentPhoto")
	public EmployeeAdminMasterResultBean uploadEmpDependnentPhoto(MultipartFile file, @RequestParam("fileName") String fileName) throws IOException {

		EmployeeAdminMasterResultBean employeeMasterResultBean = new EmployeeAdminMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.uploadDependentFile(file, fileName);
			employeeMasterResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}

	@RequestMapping(value = "/getprofile")
	public EmployeeAdminMasterBean getProfileInfo() {
		EmployeeAdminMasterBean empMasterBean = new EmployeeAdminMasterBean();
		try {
			empMasterBean = employeeMasterService.getProfileInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empMasterBean;
	}

	@RequestMapping("/checkESICNo")
	public @ResponseBody int checkESICNo(@RequestParam("esic") String esic) throws CustomException {
		int esicNo = 0;
		try {
			esicNo = employeeMasterService.checkESICNo(esic);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return esicNo;
	}

	@RequestMapping("/checkEPFNo")
	public @ResponseBody int checkEPFNo(@RequestParam("epfNo") String epfNo) throws CustomException {
		int epfNumber = 0;
		try {
			epfNumber = employeeMasterService.checkEPFNo(epfNo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return epfNumber;
	}

	@RequestMapping("/checkPersonalInfoPANNo")
	public @ResponseBody int checkPersonalInfoPANNo(@RequestParam("panNo") String panNo) throws CustomException {
		int pANNo = 0;
		try {
			pANNo = employeeMasterService.checkPersonalInfoPANNo(panNo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pANNo;
	}
	@RequestMapping(value = "/uploadfileNew")
	public @ResponseBody EmployeeAdminMasterResultBean uploadFile(MultipartFile file) throws IOException {
		EmployeeAdminMasterResultBean ResultBean = new EmployeeAdminMasterResultBean();
		try {
			ResultBean = employeeMasterService.uploadFileNew(file);
			ResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResultBean;

	}

}
