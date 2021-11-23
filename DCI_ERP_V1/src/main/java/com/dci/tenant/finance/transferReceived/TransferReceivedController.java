package com.dci.tenant.finance.transferReceived;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
import com.dci.tenant.common.CommonUtilityService;

@Controller
@RequestMapping(value = "hospital/inventory/transferReceive")
public class TransferReceivedController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TransferReceivedController.class);

	@Autowired
	private CommonUtilityService utilityService;

	@RequestMapping("/getList")
	public @ResponseBody TransferReceivedResultBean getReceivedList(@RequestParam("limit") int limit, @RequestParam("offset") int offset, @RequestParam("transferType") String transferType) throws CustomException, InterruptedException {
		TransferReceivedResultBean objReceivedResultBean = new TransferReceivedResultBean();
		try {
			objReceivedResultBean.setTransferBeanList(utilityService.getReceivedList(limit, offset, transferType));
			objReceivedResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objReceivedResultBean;
	}

	@RequestMapping(value = "/saveTransferRecive", method = RequestMethod.POST)
	public @ResponseBody boolean saveTransferRecive(@RequestBody TransferReceivedBean bean) throws Exception {
		boolean isSuccess = false;
		TransferReceivedResultBean objReceivedResultBean = new TransferReceivedResultBean();
		try {
			isSuccess = utilityService.saveTransferRecive(bean);
			objReceivedResultBean.setSuccess(isSuccess);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping("/view")
	public @ResponseBody TransferReceivedBean getTransferReceiveView(@RequestParam("receivedId") Integer receivedId) throws Exception {
		TransferReceivedBean objTransferReceivedBean = new TransferReceivedBean();
		try {
			objTransferReceivedBean = utilityService.getTransferReceiveView(receivedId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objTransferReceivedBean;
	}

	@RequestMapping(value = "/transferNolist")
	public @ResponseBody List<TransferReceivedBean> getTransferNoList(@RequestParam("transType") String transferType) {

		List<TransferReceivedBean> transferNoList = Arrays.asList();
		try {
			transferNoList = utilityService.getTransferNoList(transferType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transferNoList;

	}

	@RequestMapping(value = "/receiveItem")
	public @ResponseBody TransferReceivedResultBean getReceiveItemList(@RequestBody int id) {

		TransferReceivedResultBean transferReceivedResultBean = new TransferReceivedResultBean();
		try {
			transferReceivedResultBean.setTransferDetailBeanList(utilityService.getReceiveItemList(id));
			transferReceivedResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transferReceivedResultBean;
	}

	@RequestMapping(value = "/getBatchDetail")
	public @ResponseBody TransferReceivedResultBean getBatchDeatil(@RequestBody TransferReceivedBean receivedBean) {

		TransferReceivedResultBean transferReceivedResultBean = new TransferReceivedResultBean();
		try {
			transferReceivedResultBean.setBatchAttributeBeans(utilityService.getBatchDeatil(receivedBean));
			transferReceivedResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transferReceivedResultBean;
	}
}
