package com.dci.payroll.payroll.reimbursement;

import java.io.IOException;

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

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/reimbursementreq")
public class ReimbursementController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ReimbursementController.class);

	@Autowired
	private ReimbursementService reimbursementService;

	@RequestMapping(value = "/list")
	public ReimbursementResultBean getReimbursementList(@RequestBody int status) {
		ReimbursementResultBean reimbursementResultBean = new ReimbursementResultBean();
		try {

			reimbursementResultBean.setReimbursementList(reimbursementService.getReimbursementList(status));
			reimbursementResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimbursementResultBean;

	}

	@RequestMapping(value = "/approvallist")
	public ReimbursementResultBean getReimbursementListByStatus(@RequestBody Reimbursement reimbursement) {
		ReimbursementResultBean reimbursementResultBean = new ReimbursementResultBean();
		try {

			reimbursementResultBean.setReimbursementList(reimbursementService.getReimbursementListByStatus(reimbursement.getStatus(), reimbursement.getApprovalempId()));
			reimbursementResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimbursementResultBean;

	}

	// Save Method

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody Reimbursement reimbursement) {

		ReimbursementResultBean reimbursementResultBean = new ReimbursementResultBean();
		boolean isSuccess = false;

		try {

			isSuccess = reimbursementService.insertReimbursementreq(reimbursement);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/edit")
	public Reimbursement getReimbursementById(@RequestBody int reimbursementId) {
		try {
			return reimbursementService.getReimbursementById(reimbursementId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody Reimbursement reimbursement) {
		ReimbursementResultBean reimbursementResultBean = new ReimbursementResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = reimbursementService.updateReimbursement(reimbursement);
		} catch (CustomException e) {
			reimbursementResultBean.setSuccess(false);
			reimbursementResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/approvalupdate")
	public boolean approvalupdate(@RequestBody Reimbursement reimbursement) {
		ReimbursementResultBean reimbursementResultBean = new ReimbursementResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = reimbursementService.approvalupdate(reimbursement);
		} catch (CustomException e) {
			reimbursementResultBean.setSuccess(false);
			reimbursementResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody int reimbursementId) {
		boolean isDeleted = false;
		try {
			isDeleted = reimbursementService.deleteReimbursement(reimbursementId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

	@RequestMapping(value = "/getCurrencyList")
	public ReimbursementResultBean getCurrencyList() {
		ReimbursementResultBean reimbursementResultBean = new ReimbursementResultBean();
		try {
			reimbursementResultBean.setCurrencyList(reimbursementService.getCurrencyList());
			reimbursementResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementResultBean;
	}

	@RequestMapping(value = "/getReimburseMentTypeList")
	public ReimbursementResultBean getReimburseMentTypeList() {
		ReimbursementResultBean reimbursementResultBean = new ReimbursementResultBean();
		try {
			reimbursementResultBean.setReimbursementTypeList(reimbursementService.getReimburseMentTypeList());
			reimbursementResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementResultBean;
	}

	@RequestMapping(value = "/uploadDocfile")
	public @ResponseBody ReimbursementResultBean uploadDocFile(MultipartFile file, @RequestParam("fileName") String fileName) throws IOException {

		ReimbursementResultBean reimbursementResultBean = new ReimbursementResultBean();
		try {
			reimbursementResultBean = reimbursementService.uploadDocFile(file, fileName);
			reimbursementResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return reimbursementResultBean;

	}

	@RequestMapping(value = "/exportExcel")
	public @ResponseBody ReimbursementResultBean exportExcelAverage(@RequestBody Reimbursement reimbursement, HttpServletRequest request, HttpServletRequest response) throws CustomException {
		ReimbursementResultBean reimbursementResultBean = new ReimbursementResultBean();

		try {
			String filePath = request.getServletContext().getRealPath("/tempdoc/Reimbursement.xls");
			reimbursementService.exportExcel(reimbursement, filePath);
			reimbursementResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return reimbursementResultBean;

	}

}
