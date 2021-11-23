package com.dci.tenant.company;

import java.io.IOException;
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
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping(value = "{tenantid}/app/companydetails")
public class CompanyDetailsController {
	private final static Logger LOGGER = LoggerFactory.getLogger(CompanyDetailsController.class);

	@Autowired
	private CompanyDetailsService companyDetailsService;

	// Company Add	
	@RequestMapping(value = "/add")
	public @ResponseBody boolean addCompanyDetails(@RequestBody CompanyDetailsBean objCompanyDetailsBean1) throws CustomException, JsonParseException, JsonMappingException, IOException {
		boolean isAdded = false; // false;
		List<CompanyDetailsBean> objCompanyDetailsBean = new ArrayList<CompanyDetailsBean>();
		CompanyDetailsResultBean objCompanyDetailsResultBean = new CompanyDetailsResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		objCompanyDetailsBean.add(objCompanyDetailsBean1);
		try {
			isAdded = companyDetailsService.addCompanyDetails(objCompanyDetailsBean, userId);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isAdded;
	}

	// Populate Grid
	@RequestMapping("/list")
	public @ResponseBody CompanyDetailsResultBean CompanyDetailsList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		CompanyDetailsResultBean objCompanyDetailsResultBean = new CompanyDetailsResultBean();
		if (offset < 5000) {
			try {
				objCompanyDetailsResultBean.setlCompanyDetailsBean(companyDetailsService.getCompanyDetailsList(limit, offset));
				objCompanyDetailsResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objCompanyDetailsResultBean;
	}

	// Company Edit
	@RequestMapping(value = "/edit")
	public @ResponseBody CompanyDetailsBean editCompanyDetails(@RequestBody String companycode) throws Exception {
		try {
			return companyDetailsService.editCompanyDetails(companycode);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
	}

	// Company Delete
	@RequestMapping("/delete")
	public @ResponseBody boolean deleteCompanyDetail(@RequestBody String companycode) throws Exception {
		boolean isDeleted = false;
		isDeleted = companyDetailsService.deleteCompanyDetail(companycode);
		return isDeleted;
	}

	// Company Update
	@RequestMapping(value = "/update")
	public @ResponseBody boolean updateCompanyDetail(@RequestBody CompanyDetailsBean objCompanyDetailsBean) throws CustomException {
		boolean isSuccess = false;
		CompanyDetailsResultBean objCompanyDetailsResultBean = new CompanyDetailsResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();
		try {
			isSuccess = companyDetailsService.updateCompanyDetail(objCompanyDetailsBean, userId);
			if (isSuccess) {
				int offset = 0;
				int limit = 0;
				objCompanyDetailsResultBean.setlCompanyDetailsBean(companyDetailsService.getCompanyDetailsList(limit, offset));
				objCompanyDetailsResultBean.setSuccess(true);
			}
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}

	// CompanyName Check
	@RequestMapping("/duplicate")
	public @ResponseBody boolean CompanyNameCheck(@RequestBody String companyname) throws CustomException {
		boolean isDuplicate = false;
		try {
			isDuplicate = companyDetailsService.CompanyNameCheck(companyname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDuplicate;
	}

	// Supplier DropDown.
	@RequestMapping("/getcompanyname")
	public @ResponseBody List getSupplier() throws CustomException {
		List sVessel = new ArrayList();
		try {
			sVessel = companyDetailsService.getCompany();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return sVessel;
	}

	@RequestMapping("/getCurrencyList")
	public @ResponseBody List getCurrencyList() throws CustomException {
		List lCurrencyList = new ArrayList();
		try {
			lCurrencyList = companyDetailsService.getCurrencyList();
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return lCurrencyList;
	}
}
