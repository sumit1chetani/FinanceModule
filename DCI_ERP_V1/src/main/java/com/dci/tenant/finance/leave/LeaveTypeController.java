package com.dci.tenant.finance.leave;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.CustomException;



@RestController
@RequestMapping(value = "{tenantid}/finance/leavetype")
public class LeaveTypeController {

	@Autowired
	private LeaveTypeService leaveTypeService;

	@RequestMapping(value = "/list")
	public @ResponseBody LeaveTypeResultBean getLeaveTypeList() {
		LeaveTypeResultBean leaveTypeResultBean = new LeaveTypeResultBean();
		try {

			leaveTypeResultBean.setLeaveTypeList(leaveTypeService.getLeaveTypeList());
			leaveTypeResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return leaveTypeResultBean;
	}

	@RequestMapping(value = "/save")
	public @ResponseBody  boolean save(@RequestBody LeaveType leaveType) {
		boolean sucess = false;

		LeaveTypeResultBean leaveTypeResultBean = new LeaveTypeResultBean();
		try {
			sucess=leaveTypeService.insertLeaveType(leaveType);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucess;
	}

	@RequestMapping(value = "/update")
	public @ResponseBody LeaveTypeResultBean update(@RequestBody LeaveType leaveType) {
		LeaveTypeResultBean leaveTypeResultBean = new LeaveTypeResultBean();
		try {
			leaveTypeService.updateLeaveType(leaveType);
			leaveTypeResultBean.setSuccess(true);
		} catch (CustomException e) {
			leaveTypeResultBean.setSuccess(false);
			leaveTypeResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaveTypeResultBean;
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody LeaveTypeResultBean delete(@RequestBody String shortName) {
		LeaveTypeResultBean leaveTypeResultBean = new LeaveTypeResultBean();
		try {
			leaveTypeService.deleteLeaveType(shortName);
			leaveTypeResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaveTypeResultBean;
	}

	@RequestMapping(value = "/edit")
	public @ResponseBody LeaveTypeResultBean getleaveTypeById(@RequestBody String shortName) {
		LeaveTypeResultBean leaveTypeResultBean = new LeaveTypeResultBean();
		try {
			LeaveType leaveType = leaveTypeService.getLeaveTypeByShortName(shortName);
			leaveTypeResultBean.setLeaveType(leaveType);
			leaveTypeResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaveTypeResultBean;
	}

	@RequestMapping(value = "/bulkdelete")
	public @ResponseBody LeaveTypeResultBean bulkDelete(@RequestBody List<String> shortNameList) {
		LeaveTypeResultBean leaveTypeResultBean = new LeaveTypeResultBean();
		try {
			leaveTypeService.bulkDeleteLeaveType(shortNameList);
			leaveTypeResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaveTypeResultBean;
	}

	// UPLOAD FILE
	@RequestMapping("/uploadfile")
	public @ResponseBody LeaveTypeResultBean uploadFile(MultipartFile file) throws CustomException {
		LeaveTypeResultBean leaveTypeResultBean = new LeaveTypeResultBean();
		try {
			if (!file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {
					leaveTypeResultBean.setSuccess(leaveTypeService.uploadFile(file));

				} else {
					leaveTypeResultBean.setSuccess(false);
					System.out.println("Not a valid file format");
				}

			} else {
				leaveTypeResultBean.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaveTypeResultBean;
	}
}
