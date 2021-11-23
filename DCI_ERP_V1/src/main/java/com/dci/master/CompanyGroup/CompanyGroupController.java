package com.dci.master.CompanyGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping(value = "app/companygroup")
public class CompanyGroupController {
	private final static Logger LOGGER = LoggerFactory.getLogger(CompanyGroupController.class);

	@Autowired
	private CompanyGroupService companyGroupService;

	// Company Add
	@RequestMapping("/addCompanyGroup")
	public @ResponseBody boolean addCompanyDetails(@RequestBody CompanyGroupBean objCompanyDetailsBean) throws CustomException, JsonParseException,
			JsonMappingException, IOException { // objVesselMasterResultBean.setSuccess(true);
		boolean isAdded = false; // false;
		try {
			isAdded = companyGroupService.addCompanyDetails(objCompanyDetailsBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();

		}
		return isAdded;
	}

	// Populate main table list
	@RequestMapping("/companyGroubTableList")
	public @ResponseBody CompanyGroupResultBean CompanyGroupTableList() throws CustomException {
		CompanyGroupResultBean objCompanyDetailsResultBean = new CompanyGroupResultBean();

		try {
			objCompanyDetailsResultBean.setlCompanyGroupBean(companyGroupService.getCompanyGroupTableList());
			objCompanyDetailsResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCompanyDetailsResultBean;
	}

	// Populate company checkbox list
	@RequestMapping("/companyCheckboxList")
	public @ResponseBody CompanyGroupResultBean CompanyGroupList() throws CustomException {
		CompanyGroupResultBean objCompanyDetailsResultBean = new CompanyGroupResultBean();

		try {
			objCompanyDetailsResultBean.setlCompanyGroupBean(companyGroupService.getCompanyDetailsList());
			objCompanyDetailsResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCompanyDetailsResultBean;
	}

	// get company group Edit detail list
	@RequestMapping("/editDetList")
	public @ResponseBody CompanyGroupResultBean CompanyGroupEditDetList(@RequestParam("groupId") Integer groupId) throws CustomException {
		CompanyGroupResultBean objCompanyDetailsResultBean = new CompanyGroupResultBean();

		try {
			objCompanyDetailsResultBean.setlCompanyGroupBean(companyGroupService.CompanyGroupEditDetList(groupId));
			objCompanyDetailsResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objCompanyDetailsResultBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteCompanyDetail(@RequestBody int companycode) throws Exception {
		boolean isDeleted = false;
		isDeleted = companyGroupService.deleteCompanyDetail(companycode);
		return isDeleted;
	}

	// Company multidelete
	@RequestMapping("/multidelete")
	public @ResponseBody boolean multideleteCompanyDetail(@RequestBody String companycode) throws Exception {
		boolean isDeleted = false;
		isDeleted = companyGroupService.multideleteCompanyDetail(companycode);
		return isDeleted;
	}

	@RequestMapping("/duplicate")
	public @ResponseBody boolean CompanyGroupNameCheck(@RequestParam("companyGroupName") String companyGroupName) throws CustomException {
		boolean isDuplicate = false;
		try {
			isDuplicate = companyGroupService.companyGroupNameCheck(companyGroupName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDuplicate;
	}
	
	@RequestMapping("/getCompanyList")
	public @ResponseBody List<CompanyGroupBean> getCompanyList() throws CustomException {
		List<CompanyGroupBean> purchaseNoList = new ArrayList<>();
		try {
			purchaseNoList = companyGroupService.getCompanyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return purchaseNoList;
	}
}
