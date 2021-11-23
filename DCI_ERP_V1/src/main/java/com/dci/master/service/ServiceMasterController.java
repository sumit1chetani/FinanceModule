package com.dci.master.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping(value = "{tenantid}/app/serviceMaster")
public class ServiceMasterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ServiceMasterController.class);

	@Autowired
	private ServiceMasterService ServiceMasterService;

	@RequestMapping("/list")
	public @ResponseBody ServiceMasterResultBean getServiceMasterList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		ServiceMasterResultBean objServiceMasterResultBean = new ServiceMasterResultBean();
		//Thread.sleep(5000);
		if (offset < 5000) {
			try {
				objServiceMasterResultBean.setlServiceMasterBean(ServiceMasterService.getServiceMasterList(limit, offset));
				objServiceMasterResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objServiceMasterResultBean;
	}

	@RequestMapping("/getService")
	public @ResponseBody List getService() throws CustomException {
		List sPort = new ArrayList();

		try {
			sPort = ServiceMasterService.getService();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return sPort;
	}

	@RequestMapping("/getCompanyLocation")
	public @ResponseBody ServiceMasterResultBean getCompanyLocation() throws CustomException {
		ServiceMasterResultBean objRsltBean = new ServiceMasterResultBean();

		try {
			objRsltBean = ServiceMasterService.getCompanyLocation();

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objRsltBean;
	}

	@RequestMapping("/getPortforEdit")
	public @ResponseBody ServiceMasterResultBean getportforEdit(@RequestBody String sectorCode) throws CustomException {
		ServiceMasterResultBean objRsltBean = new ServiceMasterResultBean();

		try {
			objRsltBean = ServiceMasterService.getportforEdit(sectorCode);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objRsltBean;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody ServiceMasterBean addServiceMaster(@RequestBody ServiceMasterResultBean objServiceMasterResultBean) throws CustomException, JsonParseException, JsonMappingException, IOException {
		boolean isSuccess = false;
		ServiceMasterBean objServiceMasterBean = new ServiceMasterBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			

			objServiceMasterBean = ServiceMasterService.addServiceMaster(objServiceMasterResultBean,userDetails.getUserId());

			if (objServiceMasterBean.isSuccess()) {
				try {
					int offset = 0;
					int limit = 0;
					objServiceMasterResultBean.setlServiceMasterBean(ServiceMasterService.getServiceMasterList(limit, offset));
					objServiceMasterResultBean.setSuccess(true);
				} catch (Exception e) {
					LOGGER.error("Error", e);
					throw new CustomException();
				}
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objServiceMasterBean;
	}

	@RequestMapping("/edit")
	public @ResponseBody ServiceMasterResultBean editServiceMaster(@RequestBody String sectorCode) throws Exception {
		ServiceMasterResultBean objServiceMasterResultBean = new ServiceMasterResultBean();
		objServiceMasterResultBean = ServiceMasterService.editServiceMaster(sectorCode);
		objServiceMasterResultBean.setSuccess(true);
		return objServiceMasterResultBean;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ServiceMasterBean updateServiceMaster(@RequestBody ServiceMasterResultBean objServiceMasterResultBean) throws CustomException, JsonParseException, JsonMappingException, IOException {
		boolean isSuccess = false;
		ServiceMasterBean objServiceMasterBean = new ServiceMasterBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			System.out.println("divya");

			objServiceMasterBean = ServiceMasterService.updateServiceMaster(objServiceMasterResultBean,userDetails.getUserId());

			if (objServiceMasterBean.isSuccess()) {
				try {
					int offset = 0;
					int limit = 0;
					objServiceMasterResultBean.setlServiceMasterBean(ServiceMasterService.getServiceMasterList(limit, offset));
					objServiceMasterResultBean.setSuccess(true);
				} catch (Exception e) {
					LOGGER.error("Error", e);
					throw new CustomException();
				}
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objServiceMasterBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteServiceMaster(@RequestBody String SectorCode) throws Exception {
		boolean isDeleted = false;
		isDeleted = ServiceMasterService.deleteServiceMaster(SectorCode);
		return isDeleted;
	}

}