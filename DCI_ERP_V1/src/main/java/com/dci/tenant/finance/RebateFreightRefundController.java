package com.dci.tenant.finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;

@Controller
@RequestMapping(value = "{tenantid}/app/rebatefreightrefund")
public class RebateFreightRefundController {
	private final static Logger LOGGER = LoggerFactory.getLogger(RebateFreightRefundController.class);

	@Autowired
	private RebateFreightRefundService rebateFreightRefundService;

	@RequestMapping("/list")
	public @ResponseBody RebateFreightRefundResultBean getRebateFreightRefundList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		RebateFreightRefundResultBean rebateFreightRefundResultBean = new RebateFreightRefundResultBean();

		try {
			rebateFreightRefundResultBean.setRebateFreightRefundBeanList(rebateFreightRefundService.getRebateFreightRefundList());
			rebateFreightRefundResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return rebateFreightRefundResultBean;
	}

	@RequestMapping("/getDropDownList")
	public @ResponseBody RebateFreightRefundResultBean getDropDownList() throws CustomException {
		RebateFreightRefundResultBean rebateFreightRefundResultBean = null;
		RebateFreightRefundBean rebateFreightRefundBean = new RebateFreightRefundBean();
		try {
			rebateFreightRefundResultBean = rebateFreightRefundService.getDropDownList(rebateFreightRefundBean);
			rebateFreightRefundResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return rebateFreightRefundResultBean;
	}

	@RequestMapping("/getInvoiceList")
	public @ResponseBody RebateFreightRefundResultBean getVoyageList(@RequestBody String customerCode) throws CustomException {
		RebateFreightRefundResultBean rebateFreightRefundResultBean = new RebateFreightRefundResultBean();

		try {
			rebateFreightRefundResultBean.setInvoiceList(rebateFreightRefundService.getInvoiceList(customerCode));
			rebateFreightRefundResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return rebateFreightRefundResultBean;
	}

	@RequestMapping("/save")
	public @ResponseBody RebateFreightRefundResultBean saveVesselInformaiton(@RequestBody RebateFreightRefundBean rebateFreightRefundBean) throws CustomException {
		RebateFreightRefundResultBean rebateFreightRefundResultBean = new RebateFreightRefundResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {

			rebateFreightRefundResultBean.setSuccess(rebateFreightRefundService.saveRebateRefund(rebateFreightRefundBean, userId));

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return rebateFreightRefundResultBean;
	}

	/*@RequestMapping("/update")
	public @ResponseBody VesselInformationResultBean updateVesselInformaiton(@RequestBody VesselInformationBean vesselInformationBean) throws CustomException {
		VesselInformationResultBean vesselInformationResultBean = new VesselInformationResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			vesselInformationResultBean.setVesselInformationDtlBean(rebateFreightRefundService.updateVesselInformaiton(vesselInformationBean, userId));
			vesselInformationResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return vesselInformationResultBean;
	}

	@RequestMapping("/edit")
	public @ResponseBody VesselInformationBean editVesselInformaiton(@RequestBody int vesselI	nfoId) throws CustomException {
		VesselInformationBean vesselInformationBean = new VesselInformationBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			vesselInformationBean = rebateFreightRefundService.editVesselInformaiton(vesselInfoId, userId);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return vesselInformationBean;
	}*/
}
