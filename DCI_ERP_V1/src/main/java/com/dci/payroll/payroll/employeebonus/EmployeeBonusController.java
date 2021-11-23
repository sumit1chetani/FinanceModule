package com.dci.payroll.payroll.employeebonus;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/employeebonus")
public class EmployeeBonusController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeBonusController.class);
	@Autowired
	EmployeeBonusService employeeBonusService;

	@RequestMapping(value = "/list")
	public EmployeeBonusResultBean getEmployeeBonusList(@RequestBody EmployeeBonusBean employeeBonusBean) {
		EmployeeBonusResultBean employeeBonusResultBean = new EmployeeBonusResultBean();
		try {
			employeeBonusResultBean.setEmployeeBonusList(employeeBonusService.getEmployeeBonusList(employeeBonusBean.getCompanyId(), employeeBonusBean.getBranchId(), employeeBonusBean.getDept(), employeeBonusBean.getFinancialYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeBonusResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody ArrayList<EmployeeBonusBean> employeeBonusBean) {
		EmployeeBonusResultBean employeeBonusResultBean = new EmployeeBonusResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = employeeBonusService.insertEmployeeBonusBean(employeeBonusBean);

		} catch (CustomException e) {
			employeeBonusResultBean.setSuccess(false);
			employeeBonusResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping(value = "/bonussummary")
	public EmployeeBonusResultBean getBonusSummary(@RequestBody Integer bonusId) {
		EmployeeBonusResultBean employeeBonusResultBean = new EmployeeBonusResultBean();
		try {
			employeeBonusResultBean.setEmployeeBonusSummaryList(employeeBonusService.getEmployeeBonusSummary(bonusId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeBonusResultBean;
	}

	@RequestMapping(value = "/edit")
	public EmployeeBonusBean getPaidDetailById(@RequestBody Integer bonusId) {
		try {
			return employeeBonusService.getPaidDetailById(bonusId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/checkEmployeeBonusByDate")
	public EmployeeBonusBean getPaidDetailByDate(@RequestBody EmployeeBonusBean employeeBonusBean) {
		try {
			return employeeBonusService.getPaidDetailByDate(employeeBonusBean.getBonusId(), employeeBonusBean.getPaidOn());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody EmployeeBonusBean employeeBonusBean) {
		EmployeeBonusResultBean employeeBonusResultBean = new EmployeeBonusResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = employeeBonusService.updteEmployeeBonusPaid(employeeBonusBean);
		} catch (CustomException e) {
			employeeBonusResultBean.setSuccess(false);
			employeeBonusResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

}