package com.dci.payroll.payroll.earningdeductionmaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/earningdeductionmaster")
public class EarningDeductionMasterController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EarningDeductionMasterController.class);
	@Autowired
	EarningDeductionMasterService earningDeductionMasterService;

	@RequestMapping(value = "/list")
	public EarningDeductionMasterResultBean getEarningDeductionList() {
		EarningDeductionMasterResultBean earningDeductionMasterResultBean = new EarningDeductionMasterResultBean();
		try {
			earningDeductionMasterResultBean.setEarningDeductionMasterList(earningDeductionMasterService.getEarningDeductionMasterList());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return earningDeductionMasterResultBean;
	}

	@RequestMapping(value = "/paycomponentlist")
	public EarningDeductionMasterResultBean getPayComponentList() {
		EarningDeductionMasterResultBean earningDeductionMasterResultBean = new EarningDeductionMasterResultBean();
		try {
			earningDeductionMasterResultBean.setEarningDeductionMasterList(earningDeductionMasterService.getPayComponentList());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return earningDeductionMasterResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody EarningDeductionMasterBean earningDeductionMasterBean) {
		EarningDeductionMasterResultBean earningDeductionMasterResultBean = new EarningDeductionMasterResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = earningDeductionMasterService.insertEarningDeduction(earningDeductionMasterBean);

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
	public EarningDeductionMasterBean getTaxSectionById(@RequestBody String payComponentId) {
		try {
			return earningDeductionMasterService.getEarningDeductionbyId(payComponentId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody EarningDeductionMasterBean earningDeductionMasterBean) {
		EarningDeductionMasterResultBean earningDeductionMasterResultBean = new EarningDeductionMasterResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = earningDeductionMasterService.updateEarningDeduction(earningDeductionMasterBean);
		} catch (CustomException e) {
			earningDeductionMasterResultBean.setSuccess(false);
			earningDeductionMasterResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public EarningDeductionMasterBean delete(@RequestBody String payComponentId) {

		EarningDeductionMasterBean deductionMasterBean = new EarningDeductionMasterBean();
		boolean isDeleted = false;
		try {
			deductionMasterBean = earningDeductionMasterService.deleteEarningDeduction(payComponentId);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return deductionMasterBean;

	}

}