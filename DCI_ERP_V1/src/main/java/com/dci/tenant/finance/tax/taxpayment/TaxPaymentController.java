package com.dci.tenant.finance.tax.taxpayment;

import java.util.ArrayList;
import java.util.List;

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
@RequestMapping(value = "{tenantid}/app/taxpayment")
public class TaxPaymentController {
	private final static Logger LOGGER = LoggerFactory.getLogger(TaxPaymentController.class);

	@Autowired
	TaxPaymentService taxPaymentService;

	@RequestMapping("/list")
	public @ResponseBody List<TaxPaymentBean> getTaxPaymentList() throws CustomException {
		List<TaxPaymentBean> taxPaymentList = new ArrayList<TaxPaymentBean>();
		try {
			taxPaymentList = taxPaymentService.getTaxPaymentList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return taxPaymentList;

	}

	@RequestMapping("/getAcctList")
	public @ResponseBody TaxPaymentResultBean getAcctHeadList() throws CustomException {
		TaxPaymentResultBean tdsNatureResultBean = new TaxPaymentResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		List<TaxPaymentBean> taxPaymentList = null;
		try {
			taxPaymentList = taxPaymentService.getAcctHeadList(userId);
			tdsNatureResultBean.setTaxPaymentBeanList(taxPaymentList);
			tdsNatureResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return tdsNatureResultBean;
	}

	@RequestMapping("/save")
	public @ResponseBody TaxPaymentResultBean save(@RequestBody TaxPaymentBean tdsNatureBeanObj) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		TaxPaymentResultBean tdsNatureResultBean = new TaxPaymentResultBean();
		try {
			tdsNatureBeanObj.setUserId(userId);
			tdsNatureResultBean.setSuccess(taxPaymentService.save(tdsNatureBeanObj));
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return tdsNatureResultBean;
	}

	@RequestMapping("/edit")
	public @ResponseBody TaxPaymentBean edit(@RequestParam("natureCode") String tdsNatureCode) throws CustomException {
		TaxPaymentBean tdsNatureBean = new TaxPaymentBean();
		try {
			tdsNatureBean = taxPaymentService.edit(tdsNatureCode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return tdsNatureBean;

	}

	@RequestMapping("/update")
	public @ResponseBody TaxPaymentResultBean edit(@RequestBody TaxPaymentBean tdsNatureBeanObj) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		TaxPaymentResultBean tdsNatureResultBean = new TaxPaymentResultBean();
		try {
			tdsNatureBeanObj.setUserId(userId);
			tdsNatureResultBean.setSuccess(taxPaymentService.updateTds(tdsNatureBeanObj));
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return tdsNatureResultBean;
	}

	@RequestMapping("/deleteTdsNature")
	public @ResponseBody TaxPaymentResultBean deleteTdsNature(@RequestParam("natureCode") String tdsNatureCode) throws CustomException {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		TaxPaymentResultBean tdsNatureResultBean = new TaxPaymentResultBean();
		try {
			tdsNatureResultBean.setSuccess(taxPaymentService.deleteTdsNature(tdsNatureCode));
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return tdsNatureResultBean;
	}
}
