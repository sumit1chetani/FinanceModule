package com.dci.payroll.tds.TdsDeclaration;

import java.io.IOException;
import java.util.ArrayList;

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
@RequestMapping(value = "payroll/tds/tdsDeclaration")
public class TdsDeclarationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(TdsDeclarationController.class);

	@Autowired
	private TdsDeclarationService tdsDeclarationService;

	@RequestMapping(value = "/list")
	public TdsDeclarationResultBean getTdsDeclarationList(@RequestBody TdsDeclarationBean declarationBean) {
		TdsDeclarationResultBean tdsDeclarationResultBean = new TdsDeclarationResultBean();
		try {

			tdsDeclarationResultBean.setTdsDeclarationList(tdsDeclarationService.getTdsDeclarationList(declarationBean.getEmployeeId(), declarationBean.getFinancialYearId(), declarationBean.getTaxSectionCode()));
			tdsDeclarationResultBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tdsDeclarationResultBean;

	}

	@RequestMapping(value = "/generationlist")
	public TdsDeclarationResultBean getTdsGenerationList(@RequestBody TdsDeclarationBean declarationBean) {
		TdsDeclarationResultBean tdsDeclarationResultBean = new TdsDeclarationResultBean();
		try {

			tdsDeclarationResultBean.setTdsDeclarationList(tdsDeclarationService.getTdsGenerationList(declarationBean.getCompanyId(), declarationBean.getBranchId(), declarationBean.getDepartmentId(), declarationBean.getEmployeeId(), declarationBean.getMonthYear()));
			tdsDeclarationResultBean.setSuccess(true);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tdsDeclarationResultBean;

	}

	// Save Method

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody ArrayList<TdsDeclarationBean> tdsDeclaration) {
		boolean isSuccess = false;
		try {
			isSuccess = tdsDeclarationService.insertTdsDeclaration(tdsDeclaration);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/generationsave")
	public boolean insertTdsGeneration(@RequestBody ArrayList<TdsDeclarationBean> tdsDeclaration) {
		boolean isSuccess = false;
		try {
			isSuccess = tdsDeclarationService.insertTdsGeneration(tdsDeclaration);
		} catch (CustomException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/edit")
	public TdsDeclarationResultBean getTdsDeclarationById(@RequestBody int sk) {
		TdsDeclarationResultBean tdsDeclarationResultBean = new TdsDeclarationResultBean();
		try {
			TdsDeclarationBean tdsDeclaration = tdsDeclarationService.getTdsDeclarationBySk(sk);
			tdsDeclarationResultBean.setTdsDeclarationBean(tdsDeclaration);
			tdsDeclarationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tdsDeclarationResultBean;
	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody TdsDeclarationBean tdsDeclaration) {
		TdsDeclarationResultBean tdsDeclarationResultBean = new TdsDeclarationResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = tdsDeclarationService.updateTdsDeclaration(tdsDeclaration);
		} catch (CustomException e) {
			tdsDeclarationResultBean.setSuccess(false);
			tdsDeclarationResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/updateActualList")
	public boolean updateActualAmount(@RequestBody ArrayList<TdsDeclarationBean> tdsDeclaration) {
		TdsDeclarationResultBean tdsDeclarationResultBean = new TdsDeclarationResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = tdsDeclarationService.updateActualAmount(tdsDeclaration);
		} catch (CustomException e) {
			tdsDeclarationResultBean.setSuccess(false);
			tdsDeclarationResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean update(@RequestBody int sk) {
		TdsDeclarationResultBean tdsDeclarationResultBean = new TdsDeclarationResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = tdsDeclarationService.deleteTdsDeclarationBySk(sk);
		} catch (CustomException e) {
			tdsDeclarationResultBean.setSuccess(false);
			tdsDeclarationResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/uploadDocfile")
	public @ResponseBody TdsDeclarationResultBean uploadDocFile(MultipartFile file, @RequestParam("fileName") String fileName) throws IOException {

		TdsDeclarationResultBean tdsDeclarationResultBean = new TdsDeclarationResultBean();
		try {
			tdsDeclarationResultBean = tdsDeclarationService.uploadDocFile(file, fileName);
			tdsDeclarationResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tdsDeclarationResultBean;

	}

}
