package com.dci.master.branch;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "{tenantid}/app/master/branch")
public class BranchController {

	/*
	 * private final static Logger LOGGER =
	 * LoggerFactory.getLogger(branchController.class);
	 */

	@Autowired
	private BranchService branchService;

	@RequestMapping(value = "/list")
	public BranchResultBean getbranchList() throws Exception {
		
		BranchResultBean branchResultBean = new BranchResultBean();
		try {

			branchResultBean.setBranchList(branchService.getBranchList());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return branchResultBean;

	}

	@RequestMapping(value = "/tenantList")
	public BranchResultBean getTemplateById(@RequestBody int tenantId) {
		BranchResultBean branchResultBean = new BranchResultBean();
		try {
			branchResultBean.setTemplateList(branchService.getTemplateById(tenantId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branchResultBean;
	}

	@RequestMapping("/dropDownList")
	public BranchResultBean getDropDownList(@RequestBody int cityId)
	{
		BranchResultBean branchResultBean = new BranchResultBean();
    try
		{
			
    	branchResultBean=branchService.getDropDownList(cityId);
			branchResultBean.setSuccess(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return branchResultBean;
		
	}
	
	// Save Method

	@RequestMapping(value = "/save")
	public BranchResultBean save(@RequestBody BranchResultBean branch) {
		BranchResultBean objbranchResultBean = new BranchResultBean();
		try {
			objbranchResultBean = branchService.insertBranch(branch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return objbranchResultBean;

	}

	@RequestMapping("/delete")
	public boolean deletebranch(@RequestBody int branchId) throws Exception {
		boolean isDeleted = false;
		isDeleted = branchService.deleteBranch(branchId);
		return isDeleted;
	}
	@RequestMapping("/deleteDetail")
	public boolean deletebranchBank(@RequestBody List<BranchBank> lBranchBank) throws Exception {
		boolean isDeleted = false;
		isDeleted = branchService.deletebranchBank(lBranchBank);
		return isDeleted;
	}

	@RequestMapping(value = "/edit")
	public BranchResultBean getOpnThrById(@RequestBody int branchId) {
		BranchResultBean branchResultBean = new BranchResultBean();
		try {
			branchResultBean= branchService.getBranchById(branchId);
			branchResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branchResultBean;
	}
	
	@RequestMapping(value = "/view")
	public BranchResultBean getview(@RequestBody int branchId) {
		BranchResultBean branchResultBean = new BranchResultBean();
		try {
			branchResultBean= branchService.getview(branchId);
			branchResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branchResultBean;
	}

	@RequestMapping(value = "/update")
	public BranchResultBean update(@RequestBody BranchResultBean branch) {
		BranchResultBean operationTheatreResultBean = new BranchResultBean();
		boolean isSuccess = false;
		try {
			operationTheatreResultBean = branchService.updateBranch(branch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operationTheatreResultBean;
	}
	
	
	
	@SuppressWarnings("resource")
	@RequestMapping("/getError")
	public Branch tail2() throws IOException {

	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	System.out.println(date);
	
	int n_lines = 600;
	int counter = 0; 
	String st;
	Branch objBranchBean = new Branch();
	List<String> str = new ArrayList();
	try {
		File file = new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\logs\\catalina."+date+".log");
	ReversedLinesFileReader object = new ReversedLinesFileReader(file);
	while(counter < n_lines) {

	st = object.readLine();
	str.add(st);
	/*System.out.println(object.readLine());*/
	counter++;

	objBranchBean.setGetTextList(str);

	}
	
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return objBranchBean;

	}
	
	@RequestMapping("/deleteKeyDetail")
	BranchResultBean deleteKeyDetail(@RequestBody List<BranchNewKeyBean> lServicePartnerKeyBean)
	{
		BranchResultBean servicePartnerResultBean = new BranchResultBean();

		try
		{
			
			servicePartnerResultBean=branchService.deleteKeyDetail(lServicePartnerKeyBean);
			servicePartnerResultBean.setSuccess(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return servicePartnerResultBean;
		
	}
	
	
	
}