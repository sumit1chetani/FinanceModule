package com.dci.tenant.operation.onBoard;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.ConfigurationProps;
import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "{tenantid}/app/onBoard")
public class OnBoardController {

	@Autowired
	private OnBoardService onBoardService;

	@RequestMapping("/dropDownList")
	public @ResponseBody OnBoardResultBean getDropDownList() throws CustomException {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		try {
			onBoardResultBean.setVesselList(onBoardService.getVesselList());
			onBoardResultBean.setSlotList(onBoardService.getSlotList());
			onBoardResultBean.setPortList(onBoardService.getPort());
			onBoardResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return onBoardResultBean;
	}

	@RequestMapping("/list")
	public @ResponseBody OnBoardResultBean getList() throws CustomException {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		try {
			onBoardResultBean.setOnBoardBeanList(onBoardService.getList());
			onBoardResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onBoardResultBean;
	}

	@RequestMapping(value = "/getVoyage")
	public OnBoardResultBean getVoyageList(@RequestParam("vesselCode") String vesselCode) {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		try {
			onBoardResultBean.setVoyageList(onBoardService.getVoyageList(vesselCode));
			onBoardResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onBoardResultBean;
	}
	
	
	//bookin
	
	
	@RequestMapping(value = "/getgatoutNo")
	public OnBoardResultBean getbookList(@RequestParam("vesselCode") String vesselCode) {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		try {
			onBoardResultBean.setVoyageList(onBoardService.getbookList(vesselCode));
			onBoardResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onBoardResultBean;
	}


	@RequestMapping(value = "/getPortList")
	public OnBoardResultBean getPortList(@RequestBody String voyage) {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		try {
			onBoardResultBean.setPortList(onBoardService.getPortList(voyage));
			onBoardResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onBoardResultBean;
	}

	@RequestMapping(value = "/getContainerData", method = RequestMethod.POST)
	public OnBoardResultBean getContainerData(@RequestBody OnBoardBean onBoardBean) {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		try {
			onBoardResultBean = onBoardService.getContainerData(onBoardBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onBoardResultBean;

	}
	@RequestMapping(value = "/getSearchList", method = RequestMethod.POST)
	public OnBoardResultBean getSearchList(@RequestBody OnBoardBean onBoardBean) {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		try {
			onBoardResultBean.setOnBoardBeanList(onBoardService.getSearchList(onBoardBean));
			onBoardResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onBoardResultBean;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public OnBoardResultBean save(@RequestBody OnBoardBean onBoardBean) {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		try {
			onBoardResultBean = onBoardService.save(onBoardBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onBoardResultBean;

	}
	
	
	@RequestMapping(value = "/delete")
	public OnBoardResultBean delete(@RequestParam("onBoardNo") String onBoardNo) {
		OnBoardResultBean onBoardResultBean = new OnBoardResultBean();
		try {
			onBoardResultBean= onBoardService.delete(onBoardNo) ;
			onBoardResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onBoardResultBean;
	}
	
	@RequestMapping("/getOnBoardDetails")
	public @ResponseBody OnBoardBean getOnBoardDetails(@RequestBody String onBoardNo) throws CustomException {
		OnBoardBean onBoardBean = new OnBoardBean();
		try {
			onBoardBean = onBoardService.getOnBoardDetails(onBoardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onBoardBean;

	}

	@RequestMapping("/generateExcelReport")
	public @ResponseBody OnBoardResultBean generateExcelReport(@RequestParam("onBoardID") String onBoardID, HttpServletRequest request,
			HttpServletResponse response) throws CustomException {
		OnBoardResultBean objresultBean = new OnBoardResultBean();
		try {
			Random r = new Random();
			String number = onBoardID;
			onBoardService.generateExcelReport(onBoardID, ConfigurationProps.exportFilesPath, number);
			objresultBean.setFileName("OnBoardReport_" + number + ".xlsx");
			objresultBean.setFilePath(ConfigurationProps.exportFilesPath);
			objresultBean.setSuccess(true);
		} catch (Exception e) {
			throw new CustomException();
		}
		return objresultBean;

	}
}
