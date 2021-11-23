package com.dci.tenant.master.packageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
@Controller
@RequestMapping(value = "{tenantid}/packageType")
public class PackageTypeController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PackageTypeDaoImpl.class);

	@Autowired
	PackageTypeService packageTypeSerivce;
	
@RequestMapping("/list")
	public @ResponseBody PackageTypeResultBean list() throws CustomException {

		PackageTypeResultBean ResultBean;
		 
		try {

			ResultBean = new PackageTypeResultBean();

			ResultBean.setList(packageTypeSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody PackageTypeBean  bean) throws CustomException {


		PackageTypeResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new PackageTypeResultBean();

			isSuccess = packageTypeSerivce.save(bean);

		} catch (Exception e) {
			e.printStackTrace();
			//LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody PackageTypeBean  editvalue(@RequestBody int rowid) throws CustomException {
		PackageTypeBean bean = new PackageTypeBean();
		try {
			bean = packageTypeSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody PackageTypeBean update) throws CustomException {
		boolean isSuccess = false;
		
		try {
			isSuccess = packageTypeSerivce.update(update);
			
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return isSuccess;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {
		boolean isDeleted = false;
		isDeleted = packageTypeSerivce.delete(rowid);
		return isDeleted;
	}
	}