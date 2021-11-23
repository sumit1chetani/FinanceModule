package com.dci.operation.voyage.thirdPartyVoyage;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
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
import org.springframework.web.multipart.MultipartFile;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;
 

@RestController
@RequestMapping(value = "{tenantid}/voyage/thirdPartyVoyage")
public class ThirdPartyVoyageController {

	@Autowired
	public ThirtyPartyVoyageService thirtyPartyVoyageService;

	/*@Autowired
	public ScheduleVoyageService scheduleVoyageService;
*/
	private final static Logger LOGGER = LoggerFactory.getLogger(ThirdPartyVoyageController.class);

	@RequestMapping(value = "/getThirdPartyVoyageList", method = RequestMethod.POST)
	public ThirdPartyVoyageResultBean getThirdPartyVoyageList(@RequestBody ThirdPartyVoyageBean thirdPartyVoyageBean) throws Exception {
		ThirdPartyVoyageResultBean thirdPartyVoyageResultBean = new ThirdPartyVoyageResultBean();
		List<ThirdPartyVoyageBean> thirdPartyVoyageList = new ArrayList<ThirdPartyVoyageBean>();
		List<ThirdPartyVoyageBean> vesselList = new ArrayList<ThirdPartyVoyageBean>();
		String formCode = thirdPartyVoyageBean.getFormCode();
		System.out.println(formCode);
		try {
			thirdPartyVoyageList = thirtyPartyVoyageService.getThirdPartyVoyageList(thirdPartyVoyageBean, thirdPartyVoyageBean.getFormCode());
			vesselList = thirtyPartyVoyageService.getVesselList(formCode);
			thirdPartyVoyageResultBean.setThirdPartyVoyageList(thirdPartyVoyageList);
			thirdPartyVoyageResultBean.setVesselList(vesselList);
			thirdPartyVoyageResultBean.setActivityTypes(thirtyPartyVoyageService.getActivityTypes());
			thirdPartyVoyageResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return thirdPartyVoyageResultBean;
	}

	@RequestMapping(value = "/addThirdPartyHeaderList", method = RequestMethod.POST)
	public ThirdPartyVoyageResultBean getPlanVoyageHeaderList(@RequestParam("formCode") String formCode,@RequestParam("voyageId") String voyageId) throws Exception {
		ThirdPartyVoyageResultBean thirdPartyVoyageResultBean = new ThirdPartyVoyageResultBean();
		List<ThirdPartyVoyageBean> vesselList = new ArrayList<ThirdPartyVoyageBean>();
		List<ThirdPartyVoyageBean> vesselList1 = new ArrayList<ThirdPartyVoyageBean>();
		List<ThirdPartyVoyageBean> activityTypes = new ArrayList<ThirdPartyVoyageBean>();
		try {
			vesselList = thirtyPartyVoyageService.getVesselListWithOutOwnParty(formCode);
			vesselList1 = thirtyPartyVoyageService.getVesselListWithOutOwnParty1(formCode);
			/*activityTypes = thirtyPartyVoyageService.getActivityTypes();*/
			thirdPartyVoyageResultBean.setVesselList(vesselList);
			thirdPartyVoyageResultBean.setVesselList1(vesselList1);
			/*thirdPartyVoyageResultBean.setActivityTypes(activityTypes);*/
			thirdPartyVoyageResultBean.setMloShortNameList(thirtyPartyVoyageService.getMloList(voyageId));
			thirdPartyVoyageResultBean.setSuccess(true);
		} catch (Exception e) {

		}
		return thirdPartyVoyageResultBean;
	}

	@RequestMapping(value = "/getServiceList", method = RequestMethod.POST)
	public ThirdPartyVoyageResultBean getServiceList(@RequestBody ThirdPartyVoyageBean voyageBean) throws Exception {
		ThirdPartyVoyageResultBean thirdPartyVoyageResultBean = new ThirdPartyVoyageResultBean();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<ThirdPartyVoyageBean> serviceList = new ArrayList<ThirdPartyVoyageBean>();
		try {
			serviceList = thirtyPartyVoyageService.getServiceList(voyageBean, userDetails.getCompanyCode());
			thirdPartyVoyageResultBean.setServiceList(serviceList);
			thirdPartyVoyageResultBean.setSuccess(true);
		} catch (Exception e) {

		}
		return thirdPartyVoyageResultBean;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getVoyageDtlList", method = RequestMethod.POST)
	public ThirdPartyVoyageResultBean getVoyageDtlList(@RequestBody ThirdPartyVoyageBean voyageBean) throws Exception {
		ThirdPartyVoyageResultBean thirdPartyVoyageResultBean = new ThirdPartyVoyageResultBean();
		List<ThirdPartyVoyagePortBean> portList = new ArrayList<ThirdPartyVoyagePortBean>();
		List<ThirdPartyVoyagePortBean> voyageDtlList = new ArrayList<ThirdPartyVoyagePortBean>();
		try {
			portList = thirtyPartyVoyageService.getPortList(voyageBean);
			//if (!voyageBean.getSectorId().equalsIgnoreCase("ADHOC-SIN")) {
			if (!voyageBean.getSectorId().matches("ADHOC-SIN|ADHOC AGI|ADHOCFME|ADHOCCISC")) {
				voyageDtlList = thirtyPartyVoyageService.getVoyageDtlList(voyageBean, portList);
			} else {
				ThirdPartyVoyagePortBean portBean = new ThirdPartyVoyagePortBean();
				portBean.setVesselCode(voyageBean.getVesselCode());
				portBean.setBerthingHour("2");
				portBean.setBerthingMin("0");
				portBean.setPortStayHour("2");
				portBean.setPortStayMin("0");
				portBean.setPortStayContHour("2");
				portBean.setSteamingContHour("0");
				portBean.setSpeed(14);
				voyageDtlList.add(portBean);
			}
			thirdPartyVoyageResultBean.setPortList(portList);
			thirdPartyVoyageResultBean.setVoyageDtlList(voyageDtlList);
			thirdPartyVoyageResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thirdPartyVoyageResultBean;
	}

	@RequestMapping(value = "/getDistance", method = RequestMethod.POST)
	public String getDistance(@RequestParam(value = "fromPort") String fromPort, @RequestParam(value = "toPort") String toPort) throws Exception {
		String distance = "";
		try {
			distance = thirtyPartyVoyageService.getDistance(fromPort, toPort);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return distance;
	}

	@RequestMapping(value = "/saveThirdPartyVoyage", method = RequestMethod.POST)
	public String saveThirdPartyVoyage(@RequestBody ThirdPartyVoyageResultBean thirdPartyVoyageResultBean) throws Exception {
		String Status = "false";
		String purchaseQutMsg = "";
		JSONObject result = new JSONObject();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ThirdPartyVoyageResultBean resultBean = new ThirdPartyVoyageResultBean();
		try {
			boolean isServiceExist = thirtyPartyVoyageService.checkServiceExist(thirdPartyVoyageResultBean.getThirtyPartyVoyageHeader(), userDetails.getCompanyCode());
			//String companyOfService=thirtyPartyVoyageService.getCompanyOfService(thirdPartyVoyageResultBean.getThirtyPartyVoyageHeader());
			if (thirdPartyVoyageResultBean.getVoyageFlag().equals("S")) {
				if (isServiceExist) {
					Status = thirtyPartyVoyageService.saveThirdPartyVoyage(thirdPartyVoyageResultBean);
					/*if (!companyOfService.equalsIgnoreCase("C0001")) {
						Status = thirtyPartyVoyageService.saveThirdPartyVoyage(thirdPartyVoyageResultBean);
					}else{
						thirdPartyVoyageResultBean = thirtyPartyVoyageService.checkPurchaseQuotValid(thirdPartyVoyageResultBean);
						purchaseQutMsg = thirdPartyVoyageResultBean.getMessage();
						if (thirdPartyVoyageResultBean.isSuccess()) {
							Status = thirtyPartyVoyageService.saveThirdPartyVoyage(thirdPartyVoyageResultBean);
						}
					}*/
				} else {
					String serviceLocation = thirtyPartyVoyageService.getLocationOfService(thirdPartyVoyageResultBean.getThirtyPartyVoyageHeader().getSectorId());
					Status = serviceLocation;
				}
			} else {
				resultBean = thirtyPartyVoyageService.updateThirdPartyVoyage(thirdPartyVoyageResultBean);
				/*boolean isValidDate = thirtyPartyVoyageService.checkValidationDate(thirdPartyVoyageResultBean.getThirtyPartyVoyageHeader().getOldVoyageId());
					if (!companyOfService.equalsIgnoreCase("C0001") || !isValidDate) {
						resultBean = thirtyPartyVoyageService.updateThirdPartyVoyage(thirdPartyVoyageResultBean);
					}else{
						thirdPartyVoyageResultBean = thirtyPartyVoyageService.checkPurchaseQuotValid(thirdPartyVoyageResultBean);
						purchaseQutMsg = thirdPartyVoyageResultBean.getMessage();
						if (thirdPartyVoyageResultBean.isSuccess()) {
							resultBean = thirtyPartyVoyageService.updateThirdPartyVoyage(thirdPartyVoyageResultBean);
						}
					}*/
				
				Status=resultBean.isSuccess()?"true":"false";
			}


			result.put("status", Status);
			result.put("message", resultBean.getMessage());
			/*result.put("purchaseQutMsg", purchaseQutMsg);
			result.put("removedIndex", thirdPartyVoyageResultBean.getRemovedIndex());
			result.put("purchaseQuotMailMsg", thirdPartyVoyageResultBean.getPurchaseQuotMailMsg());*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	@RequestMapping(value = "/getEditThirdPartyHeaderList", method = RequestMethod.POST)
	public ThirdPartyVoyageResultBean getEditThirdPartyHeaderList(@RequestBody ThirdPartyVoyageBean voyageBean) throws Exception {
		ThirdPartyVoyageResultBean thirdPartyVoyageResultBean = new ThirdPartyVoyageResultBean();
		List<ThirdPartyVoyageBean> editVoyageHeaderData = new ArrayList<ThirdPartyVoyageBean>();
		try {
			editVoyageHeaderData = thirtyPartyVoyageService.getEditVoyageHeader(voyageBean);
			thirdPartyVoyageResultBean.setEditThirdPartyVoyageHeaderList(editVoyageHeaderData);
			thirdPartyVoyageResultBean.setSuccess(true);
		} catch (Exception e) {

		}
		return thirdPartyVoyageResultBean;
	}

	@RequestMapping(value = "/getEditVoyageDtlList", method = RequestMethod.POST)
	public ThirdPartyVoyageResultBean getEditVoyageDtlList(@RequestBody ThirdPartyVoyageBean voyageBean) throws Exception {
		ThirdPartyVoyageResultBean thirdPartyVoyageResultBean = new ThirdPartyVoyageResultBean();
		List<ThirdPartyVoyagePortBean> portList = new ArrayList<ThirdPartyVoyagePortBean>();
		List<ThirdPartyVoyagePortBean> editVoyageDtlList = new ArrayList<ThirdPartyVoyagePortBean>();
		ThirdPartyVoyagePortBean totalTime = new ThirdPartyVoyagePortBean();
		List<Object> voyageList = new ArrayList<Object>();
		try {
			portList = thirtyPartyVoyageService.getPortList(voyageBean);
			editVoyageDtlList = thirtyPartyVoyageService.getEditVoyageDtlList(voyageBean);
			thirdPartyVoyageResultBean.setPortList(portList);
			thirdPartyVoyageResultBean.setVoyageDtlList(editVoyageDtlList);
			thirdPartyVoyageResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thirdPartyVoyageResultBean;
	}

	@RequestMapping(value = "/deleteThirdPartyVoyage", method = RequestMethod.POST)
	public boolean deletePlanVoyage(@RequestBody String voyageId) {
		boolean result = false;
		try {
			result = thirtyPartyVoyageService.deleteThirdPartyVoyage(voyageId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/getVoyageList")
	public ThirdPartyVoyageResultBean getVoyageList(@RequestBody ThirdPartyVoyageBean thirdPartyVoyageBean) {
		ThirdPartyVoyageResultBean thirdPartyVoyageResultBean = new ThirdPartyVoyageResultBean();
		try {
			thirdPartyVoyageResultBean.setVoyageList(thirtyPartyVoyageService.getVoyageList(thirdPartyVoyageBean));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thirdPartyVoyageResultBean;
	}

	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public ThirdPartyVoyageResultBean sendMail(@RequestBody ThirdPartyVoyageResultBean thirdPartyVoyageResultBean) {
		ThirdPartyVoyageResultBean resultBean = new ThirdPartyVoyageResultBean();
		boolean result = false;
		try {
		/*	thirdPartyVoyageResultBean.getThirtyPartyVoyageHeader().setVesselName(
					scheduleVoyageService.getVesselName(thirdPartyVoyageResultBean.getThirtyPartyVoyageHeader().getVesselCode()));
	*/		result = thirtyPartyVoyageService.sendMail(thirdPartyVoyageResultBean);
			resultBean.setSuccess(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}
	
	@RequestMapping(value = "/sendMailForPurchaseQuote", method = RequestMethod.POST)
	public ThirdPartyVoyageResultBean sendMailForPurchaseQuote(@RequestBody ThirdPartyVoyageResultBean thirdPartyVoyageResultBean) {
		ThirdPartyVoyageResultBean resultBean = new ThirdPartyVoyageResultBean();
		boolean result = false;
		try {
			/*thirdPartyVoyageResultBean.getThirtyPartyVoyageHeader().setVesselName(
					scheduleVoyageService.getVesselName(thirdPartyVoyageResultBean.getThirtyPartyVoyageHeader().getVesselCode()));
		*/	result = thirtyPartyVoyageService.sendMailForPurchaseQuote(thirdPartyVoyageResultBean);
			resultBean.setSuccess(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultBean;
	}

@RequestMapping(value = "/ExportExcel", method = RequestMethod.POST)
public @ResponseBody ThirdPartyVoyageResultBean getExcelReportExportList(
		@RequestBody ThirdPartyVoyageBean objBLissuedReportBean, HttpServletRequest request,
		HttpServletResponse response) throws CustomException {
	ThirdPartyVoyageResultBean objBLissuedReportResultBean = new ThirdPartyVoyageResultBean();
 	try {
 		objBLissuedReportResultBean.setSearchList(thirtyPartyVoyageService.geList(objBLissuedReportBean));
 		thirtyPartyVoyageService.excellExport(objBLissuedReportResultBean,ConfigurationProps.exportFilesPath) ;

		objBLissuedReportResultBean.setSuccess(true);
	} catch (Exception e) {
		System.out.println(e);

	}
	return objBLissuedReportResultBean;
}


@RequestMapping(value = "/search" ,method = RequestMethod.POST)
public @ResponseBody List<ThirdPartyVoyageBean>  search(@RequestBody ThirdPartyVoyageBean searchBean) {
	List<ThirdPartyVoyageBean> ObjThirdPartyVoyageBean = new ArrayList<>();
	try {
		ObjThirdPartyVoyageBean = thirtyPartyVoyageService.searchfindshed(searchBean);
	} catch (Exception e) {

		e.printStackTrace();
	} 
	return ObjThirdPartyVoyageBean;

}

@RequestMapping("/uploadfile")
public @ResponseBody ThirdPartyVoyageResultBean uploadFile(MultipartFile file) throws CustomException {
	ThirdPartyVoyageResultBean resultBean = new ThirdPartyVoyageResultBean();
	try {
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			if (fileName.endsWith("xls") || fileName.endsWith("xlsx")) {

				resultBean = thirtyPartyVoyageService.uploadFile(file);

			} else {
				resultBean.setSuccess(false);
				resultBean.setMessage("Not a valid file format");
				System.out.println("Not a valid file format");
			}

		} else {
			resultBean.setSuccess(false);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return resultBean;
}


}

