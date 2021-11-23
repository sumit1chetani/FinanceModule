package com.dci.payroll.tds.NscInterest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/tds/nscinterest")
public class NscInterestController {

	private final static Logger LOGGER = LoggerFactory.getLogger(NscInterestController.class);

	@Autowired
	private NscInterestService nscInterestService;

	@RequestMapping(value = "/list")
	public NscInterestResultBean getNscInterestList() {
		NscInterestResultBean nscInterestResultBean = new NscInterestResultBean();
		try {

			nscInterestResultBean.setNscInterestList(nscInterestService.getNscInterestList());
			nscInterestResultBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nscInterestResultBean;

	}

	// Save Method

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody NscInterestBean nscInterest) {
		boolean isSuccess = false;
		try {
			isSuccess = nscInterestService.insertNscInterest(nscInterest);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/edit")
	public NscInterestResultBean getNscInterestById(@RequestBody String financialYear) {
		NscInterestResultBean nscInterestResultBean = new NscInterestResultBean();
		try {
			NscInterestBean nscInterest = nscInterestService.getNscInterestById(financialYear);
			nscInterestResultBean.setNscInterestBean(nscInterest);
			nscInterestResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nscInterestResultBean;
	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody NscInterestBean nscInterest) {
		NscInterestResultBean nscInterestResultBean = new NscInterestResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = nscInterestService.updateNscInterest(nscInterest);
		} catch (CustomException e) {
			nscInterestResultBean.setSuccess(false);
			nscInterestResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
