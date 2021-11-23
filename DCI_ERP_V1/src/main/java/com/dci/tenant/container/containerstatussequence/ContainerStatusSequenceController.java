package com.dci.tenant.container.containerstatussequence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CustomException;
import com.dci.tenant.user.UserDetail;


	
@RestController
@RequestMapping(value = "{tenantid}/api/containerstatussequence")
public class ContainerStatusSequenceController {


	@Autowired
	private ContainerStatusSequenceService containerstatussequenceService;

	@RequestMapping("/list")
	public @ResponseBody List<ContainerStatusSequenceBean> getList() {
		
		List<ContainerStatusSequenceBean> containerlist = new ArrayList<>();
		try {
			containerlist = containerstatussequenceService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return containerlist;
	}

	@RequestMapping("/save")
	public @ResponseBody ContainerStatusSequenceBean save(@RequestBody ContainerStatusSequenceBean bean) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();

		ContainerStatusSequenceBean Bean = new ContainerStatusSequenceBean();
		try {
			Bean = containerstatussequenceService.save(bean, userId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Bean;

	}
	
	
	@RequestMapping("/dropDownList")
	public @ResponseBody ContainerStatusSequenceResultbean getDropDownList() throws CustomException {
		/*List agreementPartyList = new ArrayList();
		List agreementTypeList = new ArrayList();
		List locationList = new ArrayList();
		List containerstatussequenceCodeList = new ArrayList();
		List containerTypeList = new ArrayList();
		List sequenceList = new ArrayList();
		//List containerstatussequenceStatusList = new ArrayList();
		List repairProcess = new ArrayList();*/
		List statusList = new ArrayList();


		ContainerStatusSequenceResultbean dropdownbean = new ContainerStatusSequenceResultbean();
		try {
			/*agreementPartyList = containerstatussequenceService.getAgreementPartyList();
			agreementTypeList = containerstatussequenceService.getAgreementTypeList();
			locationList = containerstatussequenceService.getLocationList();
			containerstatussequenceCodeList = containerstatussequenceService.getcontainerstatussequenceCodeList();
			containerTypeList = containerstatussequenceService.getContainerTypeList();
			sequenceList = containerstatussequenceService.getContainerNoList();*/
			statusList = containerstatussequenceService.getStatusList();
			/*repairProcess = containerstatussequenceService.getRepairProcessList();
			dropdownbean.setListAgreementPartyList(agreementPartyList);
			dropdownbean.setListAgreementTypeList(agreementTypeList);
			dropdownbean.setListLocationList(locationList);
			dropdownbean.setListcontainerstatussequenceCodeList(containerstatussequenceCodeList);
			dropdownbean.setListContainerTypeList(containerTypeList);
			dropdownbean.setListContainerNoList(sequenceList);
			//dropdownbean.setListcontainerstatussequenceStatusList(containerstatussequenceStatusList);
			dropdownbean.setListRepairProcessList(repairProcess);*/
			dropdownbean.setListStatusList(statusList);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return dropdownbean;
	}
	
	@RequestMapping("/getSequence")
	public @ResponseBody ContainerStatusSequenceBean getSequence() throws CustomException {
		ContainerStatusSequenceBean bean = new ContainerStatusSequenceBean();

		String sequence = "";
 
		try {
			sequence = containerstatussequenceService.getSequence();
			bean.setSequence(sequence);
		} catch (Exception e) {
			throw new CustomException();

		}
		return bean; 
		}


	@RequestMapping(value = "/delete")
	public ContainerStatusSequenceBean delete(@RequestParam("sequence") String sequence) {
		ContainerStatusSequenceBean bean = new ContainerStatusSequenceBean();
		try {
			bean = containerstatussequenceService.delete(sequence);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

	@RequestMapping(value = "/edit")
	public ContainerStatusSequenceBean getEdit(@RequestParam("sequence") String sequence) {

		ContainerStatusSequenceBean bean = new ContainerStatusSequenceBean();
		try {
			bean = containerstatussequenceService.edit(sequence);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ContainerStatusSequenceBean Update(@RequestBody ContainerStatusSequenceBean bean) {
		ContainerStatusSequenceBean bean1 = new ContainerStatusSequenceBean();
		try {

			bean1 = containerstatussequenceService.update(bean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean1;

	}
	
	@RequestMapping("/getcontainerStatus")
	public List<SelectivityBean> getcontainerStatus() {			

		List<SelectivityBean> selectivityBean = new ArrayList<>();

		selectivityBean = containerstatussequenceService.getcontainerStatus();

		return selectivityBean;
	}
	
	
	
	@RequestMapping("/saveContainer")
	public @ResponseBody ContainerStatusSequenceBean saveContainer(@RequestBody ContainerStatusSequenceBean bean) {
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDetails.getUserId();

		ContainerStatusSequenceBean Bean = new ContainerStatusSequenceBean();
		try {
			Bean = containerstatussequenceService.saveContainer(bean, userId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Bean;

	}


}
