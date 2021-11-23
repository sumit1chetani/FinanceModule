package com.dci.payroll.payroll.gradepaycomponent;

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

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/payroll/gradepay")
public class GradePayComponentController {
	private final static Logger LOGGER = LoggerFactory.getLogger(GradePayComponentController.class);

	@Autowired
	private GradePayComponentService gradepayService;

	@RequestMapping(value = "/list")
	public @ResponseBody GradePayComponentResultBean getGradePayComList(@RequestParam("gradeId") Integer gradeId) {

		GradePayComponentResultBean resultBean = new GradePayComponentResultBean();
		try {

			resultBean.setGradeComponentList(gradepayService.getGradePayComponentList(gradeId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@RequestMapping(value = "/getGradeMaxDate")
	public @ResponseBody GradePayComponentBean getGradeMaxDate(@RequestParam("gradeId") Integer gradeId) {
		GradePayComponentBean payComponentBean = new GradePayComponentBean();
		try {

			payComponentBean = gradepayService.getGradeMaxDate(gradeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payComponentBean;
	}

	@RequestMapping(value = "/edit")
	public GradePayComponentResultBean getListByIdDate(@RequestBody GradePayComponentBean gradePayBean) {

		GradePayComponentResultBean resultBean = new GradePayComponentResultBean();
		try {
			// private static String fromDate = null;
			resultBean.setGradePayComList(gradepayService.getListByIdDate(gradePayBean.getGradeId(), gradePayBean.getFromdate()));
			return resultBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody ArrayList<GradePayComponentBean> gradePayComBean) {

		GradePayComponentResultBean gradePayComResultBean = new GradePayComponentResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = gradepayService.insertGradePayComponent(gradePayComBean);
		} catch (CustomException e) {
			gradePayComResultBean.setSuccess(false);
			gradePayComResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody ArrayList<GradePayComponentBean> gradePayComBean) {
		GradePayComponentResultBean gradePayComResultBean = new GradePayComponentResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = gradepayService.updateGradePayComponent(gradePayComBean);
		} catch (CustomException e) {
			gradePayComResultBean.setSuccess(false);
			gradePayComResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody GradePayComponentBean gradePayComBean) {
		boolean isDeleted = false;
		try {
			isDeleted = gradepayService.deleteGradePayComponenet(gradePayComBean.getGradeId(), gradePayComBean.getFromdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

	@RequestMapping(value = "/getGradeList")
	public GradePayComponentResultBean getGradeList(@RequestBody String companyId) {
		GradePayComponentResultBean objGradePayComponentResultBean = new GradePayComponentResultBean();
		try {
			objGradePayComponentResultBean.setGradeList(gradepayService.getGradeList(companyId));
			objGradePayComponentResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objGradePayComponentResultBean;
	}

	// Check the employeeList

	@RequestMapping(value = "/generateGradeSalary")
	public GradePayComponentResultBean getGradeList(@RequestBody GradePayComponentBean gradePayComponentBean) {
		GradePayComponentResultBean objGradePayComponentResultBean = new GradePayComponentResultBean();
		boolean isSuccess = false;
		try {
			objGradePayComponentResultBean.setSalaryCreated(false);
			objGradePayComponentResultBean.setSalaryExists(false);

			List<GradePayComponentBean> checksalaryCreatedList = gradepayService.checkEmployeeExists(gradePayComponentBean.getFromdate(), gradePayComponentBean.getGradeId());

			if (checksalaryCreatedList.size() == 0) {
				isSuccess = gradepayService.insertGrdePayComponent(gradePayComponentBean.getFromdate(), gradePayComponentBean.getGradeId());
				objGradePayComponentResultBean.setSalaryExists(false);
				objGradePayComponentResultBean.setSalaryCreated(true);

			} else {
				objGradePayComponentResultBean.setSalaryExists(true);
				objGradePayComponentResultBean.setSalaryCreated(false);
			}

			objGradePayComponentResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objGradePayComponentResultBean;
	}
}