package com.dci.tenant.finance.letterRequest;

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

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "{tenantid}/finance/letterRequest")
public class LetterRequestController {

	private final static Logger LOGGER = LoggerFactory.getLogger(LetterRequestController.class);

	@Autowired
	private LetterRequestService LetterRequestService;

	
	@RequestMapping(value = "/getLetterReqTypeList")
	public @ResponseBody List<SelectivityBean> getLetterReqTypeList() {
		List<SelectivityBean> SelectivityBean = new ArrayList<SelectivityBean>();
		try {
			SelectivityBean = LetterRequestService.getLetterReqTypeList();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SelectivityBean;

	}
	@RequestMapping(value = "/list")
	public @ResponseBody LetterRequestResultBean getLeaveTypeLimitList() {
		LetterRequestResultBean leaveTypeLimitResultBean = new LetterRequestResultBean();
		try {
			leaveTypeLimitResultBean.setLetterReqList(LetterRequestService.getLetterTypeList());
			leaveTypeLimitResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return leaveTypeLimitResultBean;

	}
	

	@RequestMapping(value = "/letterReqList")
	public @ResponseBody LetterRequestResultBean letterReqList() {
		LetterRequestResultBean leaveTypeLimitResultBean = new LetterRequestResultBean();
		try {
			leaveTypeLimitResultBean.setLetterReqList(LetterRequestService.letterReqList());
			leaveTypeLimitResultBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return leaveTypeLimitResultBean;

	}
	
	
	
	@RequestMapping(value = "/save")
	public @ResponseBody boolean save(@RequestBody LetterRequestBean LetterRequestBean1) {
		boolean isSuccess = false;
		try {
			isSuccess = LetterRequestService.insertLetterRequestType(LetterRequestBean1);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}
	
	@RequestMapping(value = "/saveLR")
	public @ResponseBody boolean saveLR(@RequestBody LetterRequestBean LetterRequestBean1) {
		boolean isSuccess = false;
		try {
			isSuccess = LetterRequestService.save(LetterRequestBean1);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}
	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateLetterRequestType(@RequestBody LetterRequestBean LetterRequestBean) {
		boolean success = false;
		try {
			success = LetterRequestService.updateLetterRequestType(LetterRequestBean);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return success;

	}
	@RequestMapping(value = "/updateLR")
	public @ResponseBody boolean updateLR(@RequestBody LetterRequestBean LetterRequestBean) {
		boolean success = false;
		try {
			success = LetterRequestService.update(LetterRequestBean);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return success;

	}
	
	@RequestMapping(value = "/approve")
	public @ResponseBody boolean approve(@RequestBody LetterRequestBean LetterRequestBean) {
		boolean success = false;
		try {
			success = LetterRequestService.approve(LetterRequestBean);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return success;

	}
//	issueVal
	
	
	@RequestMapping(value = "/issueVal")
	public @ResponseBody boolean issueVal(@RequestBody LetterRequestBean LetterRequestBean) {
		boolean success = false;
		try {
			success = LetterRequestService.issueVal(LetterRequestBean);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return success;

	}
	
	@RequestMapping(value = "/edit")
	public  @ResponseBody LetterRequestBean editLetterRequestType(@RequestParam("letterReqId")Integer id) throws Exception {
		LetterRequestBean LetterRequestBean = new LetterRequestBean();
		try {
			LetterRequestBean = LetterRequestService.editLetterRequestType(id);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return LetterRequestBean;

	}
	@RequestMapping(value = "/editLR")
	public  @ResponseBody LetterRequestBean editLR(@RequestParam("letterReqId")Integer id) throws Exception {
		LetterRequestBean LetterRequestBean = new LetterRequestBean();
		try {
			LetterRequestBean = LetterRequestService.edit(id);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return LetterRequestBean;

	}
	@RequestMapping(value = "/delete")
	public boolean deleteLeaveTypeLimit(@RequestBody LetterRequestBean LetterRequestBean1) {
		boolean isSuccess = false;
		try {
			isSuccess = LetterRequestService.delete(LetterRequestBean1);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	@RequestMapping(value = "/deleteLR")
	public boolean deleteLR(@RequestBody LetterRequestBean LetterRequestBean1) {
		boolean isSuccess = false;
		try {
			isSuccess = LetterRequestService.deleteLR(LetterRequestBean1);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
}