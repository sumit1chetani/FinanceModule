package com.dci.finance.leaverequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;


@Controller
@RequestMapping(value = "{tenantid}/finance/leaverequest")
public class LeaveRequestController {
	private final static Logger LOGGER = LoggerFactory.getLogger(LeaveRequestController.class);

	@Autowired
	LeaveRequestService leaveRequestService;

	@RequestMapping(value = "/list")
	public @ResponseBody LeaveRequestResultBean getLeaveRequestList() {

		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		List<LeaveRequestBean> result = new ArrayList<LeaveRequestBean>();
		try {
			result = leaveRequestService.getLeaveRequestList();
			resultBean.setLeaveRequestList(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/leavelist")
	public @ResponseBody LeaveRequestResultBean getLeaveList(@RequestBody LeaveRequestBean leaveRequestBean) throws Exception {
		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();

		resultBean = leaveRequestService.getLeaveList(leaveRequestBean);

		return resultBean;
	}

	@RequestMapping(value = "/add")
	public @ResponseBody LeaveRequestResultBean saveLeaveData(@RequestBody LeaveRequestResultBean saveBean) throws Exception {
		LeaveRequestBean leaveRequestBean = new LeaveRequestBean();
		LeaveRequestResultBean leaveResultBean = new LeaveRequestResultBean();
		UserDetail teampUser = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			leaveRequestBean.setLoginEmpId(teampUser.getUserId());
			boolean sucess = false;
			sucess = leaveRequestService.saveLeaveData(saveBean);
			leaveResultBean.setSuccess(sucess);
		} catch (Exception e) {
			e.printStackTrace();
			leaveResultBean.setSuccess(false);
			leaveResultBean.setMessage(e.getMessage());
		}
		return leaveResultBean;

	}

	@RequestMapping(value = "/holidaylist")
	public @ResponseBody LeaveRequestResultBean getHolidayList(@RequestBody LeaveRequestBean leaveRequestBean) throws Exception {

		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		resultBean = leaveRequestService.getHolidayList(leaveRequestBean);

		return resultBean;
	}

	@RequestMapping(value = "/getEditList")
	public @ResponseBody LeaveRequestBean getEditList(@RequestParam("requestId") int requestId) throws Exception {

		LeaveRequestBean resultBean = new LeaveRequestBean();
		resultBean = leaveRequestService.getEditList(requestId);

		return resultBean;

	}

	// @RequestMapping(value = "/getEmployeeList")
	// public LeaveRequestResultBean getEmployeeList() {
	// LeaveRequestResultBean empList = new LeaveRequestResultBean();
	// LeaveRequestBean leaveRequestBean = new LeaveRequestBean();
	// UserDetail teampUser = (UserDetail)
	// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	//
	// leaveRequestBean.setLoginEmpId(teampUser.getUserId());
	// try {
	// empList = leaveRequestService.getEmployeeList();
	// empList.setSuccess(true);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return empList;
	// }

	@RequestMapping(value = "/getEmployeeDetails")
	public @ResponseBody LeaveRequestResultBean getEmployeeDetails() {
		LeaveRequestResultBean leaveRequestResultBean = new LeaveRequestResultBean();

		try {

			LeaveRequestBean leaveRequestBean = leaveRequestService.getEmployeeDetails();

			leaveRequestResultBean.setEmployeeDetailsList(leaveRequestBean);
			leaveRequestResultBean.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return leaveRequestResultBean;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateLeaveData(@RequestBody LeaveRequestResultBean updateBean) throws Exception {
		boolean sucess = false;
		sucess = leaveRequestService.updateLeaveData(updateBean);

		return sucess;
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody boolean deleteLeave(@RequestBody int leaveRequestId) {

		System.out.println("deleteeeee");
		boolean isSucess = true;
		try {
			isSucess = leaveRequestService.deleteLeave(leaveRequestId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSucess;
	}

	@RequestMapping(value = "/getLeaveNotification")
	public @ResponseBody LeaveRequestResultBean getLeaveNotification() throws Exception {
		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		// List<LeaveRequestBean> result = new ArrayList<LeaveRequestBean>();
		try {
			resultBean = leaveRequestService.getLeaveNotification();
			// resultBean.setLeaveRequestList(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/cancelRequest")
	public @ResponseBody LeaveRequestResultBean cancelRequest(@RequestBody LeaveRequestBean leaveRequestBean) throws Exception {
		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		// List<LeaveRequestBean> result = new ArrayList<LeaveRequestBean>();
		try {
			leaveRequestService.cancelRequest(leaveRequestBean);
			resultBean.setSuccess(true);
		} catch (Exception e) {
			resultBean.setSuccess(false);
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/leaveExclude")
	public @ResponseBody LeaveRequestResultBean leaveExclude(@RequestBody LeaveRequestBean leaveRequestBean) throws Exception {

		// double leaveDays = 0;
		LeaveRequestResultBean excludeResultBean = new LeaveRequestResultBean();
		LeaveRequestBean leaveReqBean = new LeaveRequestBean();
		try {
			leaveReqBean = leaveRequestService.leaveExclude(leaveRequestBean);
			// leaveDays = leaveRequestService.leaveExclude(leaveRequestBean);
			// excludeResultBean.setLeaveDays(leaveDays);
			excludeResultBean.setLeaveObj(leaveReqBean);
			excludeResultBean.setSuccess(true);
		} catch (CustomException e) {
			excludeResultBean.setSuccess(false);
			excludeResultBean.setMessage(e.getCustomMessage());
		}
		return excludeResultBean;
	}

	@RequestMapping(value = "/checkHoliday")
	public @ResponseBody LeaveRequestResultBean checkHoliday(@RequestBody LeaveRequestBean leaveRequestBean) throws Exception {

		LeaveRequestResultBean leaveResultBean = new LeaveRequestResultBean();
		boolean checkStatus = false;
		try {

			checkStatus = leaveRequestService.checkHoliday(leaveRequestBean);
			leaveResultBean.setSuccess(checkStatus);
		} catch (CustomException e) {
			leaveResultBean.setSuccess(false);
			leaveResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
		}
		return leaveResultBean;
	}

	@RequestMapping(value = "/leaveDeductionList")
	public @ResponseBody LeaveRequestResultBean getLeaveDeductionList() {

		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		List<LeaveRequestBean> result = new ArrayList<LeaveRequestBean>();
		try {
			result = leaveRequestService.leaveDeductionList();
			resultBean.setLeaveRequestList(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/saveLeaveDeduction")
	public @ResponseBody LeaveRequestResultBean saveLeaveDeduction(@RequestBody LeaveRequestBean leaveRequestBean) {
		LeaveRequestResultBean leaveDeductionSave = new LeaveRequestResultBean();
		try {
			leaveRequestService.saveLeaveDeduction(leaveRequestBean);
			leaveDeductionSave.setSuccess(true);
		} catch (CustomException e) {
			leaveDeductionSave.setSuccess(false);
			leaveDeductionSave.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveDeductionSave;
	}

	@RequestMapping(value = "/editLeaveDeduction")
	public @ResponseBody LeaveRequestResultBean editLeaveDeduction(@RequestBody int leaveRequestId) {
		LeaveRequestResultBean leaveDeductionEdit = new LeaveRequestResultBean();
		try {
			LeaveRequestBean leaveRequestBean = leaveRequestService.editLeaveDeduction(leaveRequestId);
			leaveDeductionEdit.setLeaveObj(leaveRequestBean);
			leaveDeductionEdit.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveDeductionEdit;
	}

	@RequestMapping(value = "/updateLeaveDeduction")
	public @ResponseBody LeaveRequestResultBean updateLeaveDeduction(@RequestBody LeaveRequestBean leaveRequestBean) {
		LeaveRequestResultBean leaveDeductionUpdate = new LeaveRequestResultBean();
		try {
			leaveRequestService.updateLeaveDeduction(leaveRequestBean);
			leaveDeductionUpdate.setSuccess(true);
		} catch (CustomException e) {
			leaveDeductionUpdate.setSuccess(false);
			leaveDeductionUpdate.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveDeductionUpdate;
	}

	@RequestMapping(value = "/deleteLeaveDeduction")
	public @ResponseBody LeaveRequestResultBean deleteLeaveDeduction(@RequestBody int leaveRequestId) {
		LeaveRequestResultBean leaveDeductionDelete = new LeaveRequestResultBean();
		try {
			leaveRequestService.deleteLeaveDeduction(leaveRequestId);
			leaveDeductionDelete.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveDeductionDelete;
	}

	@RequestMapping(value = "/uploadfile")
	public @ResponseBody LeaveRequestResultBean uploadFile(@RequestParam("file") MultipartFile[] files) throws IOException {
		LeaveRequestResultBean LeaveRequestResultBean = new LeaveRequestResultBean();
		try {
			LeaveRequestResultBean = leaveRequestService.uploadMLFile(files);
			LeaveRequestResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LeaveRequestResultBean;

	}
	
	/*@RequestMapping(value = "/uploadMLFile")
	public LeaveRequestResultBean uploadMLFile(MultipartFile file, @RequestParam("fileName") String fileName) throws CustomException {
		LeaveRequestResultBean LeaveRequestResultBean = new LeaveRequestResultBean();
		try {
			if (!file.isEmpty()) {
				LeaveRequestResultBean = leaveRequestService.uploadMLFile(file, fileName);
				LeaveRequestResultBean.setSuccess(true);
			} else {
				LeaveRequestResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LeaveRequestResultBean;
	}*/

	@RequestMapping(value = "/updateViewMLDoc")
	public @ResponseBody LeaveRequestResultBean updateViewMLDoc(@RequestBody LeaveRequestBean leaveRequestBean) {
		LeaveRequestResultBean leaveDeductionDelete = new LeaveRequestResultBean();
		try {
			leaveDeductionDelete = leaveRequestService.updateViewMLDoc(leaveRequestBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveDeductionDelete;
	}

	@RequestMapping(value = "/viewLeaveHistory")
	public LeaveRequestResultBean viewLeaveHistory(@RequestBody String empId) {

		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();
		List<LeaveRequestBean> result = new ArrayList<LeaveRequestBean>();
		try {
			result = leaveRequestService.viewLeaveHistory(empId);
			resultBean.setLeaveRequestList(result);
			resultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@RequestMapping(value = "/viewHistoryOfLeave")
	public @ResponseBody LeaveRequestResultBean viewHistoryOfLeave(@RequestBody String empId) throws Exception {
		LeaveRequestResultBean resultBean = new LeaveRequestResultBean();

		resultBean = leaveRequestService.getLeaveListHistory(empId);

		return resultBean;
	}
	
	
	
	
	@RequestMapping("/saveuploadfile")
	public @ResponseBody LeaveRequestBean saveuploadfile(@RequestParam("file") MultipartFile file,@RequestParam("leaveRequestObj") String requestId, HttpServletRequest request) throws CustomException {
		LeaveRequestBean resultBean= new LeaveRequestBean();                                                                    
		try {
			 
//			String filepath = ConfigurationProps.cashbankpaymentModelData+"/"+cashbankpaymentModelData;
			//String filepath = "/home/iwsfeedertech/GeneratedFiles/supportingfiles/"+cashbankpaymentModelData;
			
			//String filepath = "/home/paragon/uploads/"+invoiceNo;
			String filepath = ConfigurationProps.quotationFilesPath+"/"+requestId;

			String path = filepath+"/"+ file.getOriginalFilename();

			File checkfile = new File(filepath);
			if (!checkfile.exists())
				checkfile.mkdir();

			File convFile = new File(path);

			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
			
			leaveRequestService.insertFiles(requestId, file.getOriginalFilename(),filepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	
	
	@RequestMapping(value = "/uploadfileleave")
	public @ResponseBody LeaveRequestResultBean uploadFile(MultipartFile file) throws IOException {
		LeaveRequestResultBean ResultBean = new LeaveRequestResultBean();
		try {
			ResultBean = leaveRequestService.uploadFile(file);
			ResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResultBean;

	}

}
