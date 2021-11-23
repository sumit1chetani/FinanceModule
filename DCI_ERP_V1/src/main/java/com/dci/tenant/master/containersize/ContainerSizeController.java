package com.dci.tenant.master.containersize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;
@Controller
@RequestMapping(value = "{tenantid}/containersize")
public class ContainerSizeController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ContainerSizeDaoImpl.class);

	@Autowired
	ContainerSizeService portSerivce;
	@RequestMapping(value = "/statelist")
	public @ResponseBody ContainerSizeResultBean getstate() throws Exception {
		ContainerSizeResultBean ResultBean = null;

		try {
			
			ResultBean = new ContainerSizeResultBean();
			
			
			ResultBean = portSerivce.selectivity();
			
		} catch (CustomException e) {

			e.printStackTrace();
		}
		return ResultBean;

	}
	
	
	@RequestMapping("/list")
	public @ResponseBody ContainerSizeResultBean list() throws CustomException {
		System.out.println(12);

		ContainerSizeResultBean ResultBean;
		 
		try {

			ResultBean = new ContainerSizeResultBean();

			ResultBean.setList(portSerivce.getList());

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/save")
	public @ResponseBody Object save(@RequestBody ContainerSizeBean  bean) throws CustomException {

		ContainerSizeResultBean ResultBean;
		Object isSuccess;
		try {

			ResultBean = new ContainerSizeResultBean();

			isSuccess = portSerivce.save(bean);

		} catch (Exception e) {
			LOGGER.error("error on closing account" + e);
			throw new CustomException();
		}

		return isSuccess;

	}
	
	@RequestMapping("/edit")
	public @ResponseBody ContainerSizeBean  editvalue(@RequestBody int rowid) throws CustomException {
		ContainerSizeBean bean = new ContainerSizeBean();
		try {
			bean = portSerivce.edit(rowid);
			
		} catch (Exception e) {
			
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return bean;
	}
	
	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody ContainerSizeBean update) throws CustomException {
		boolean isSuccess = false;
		
		try {
			isSuccess = portSerivce.update(update);
			
		} catch (Exception e) {
			e.printStackTrace();
			//LOGGER.error("Error", e);
			//throw new CustomException();
		}
		return isSuccess;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(@RequestBody int rowid) throws Exception {
		boolean isDeleted = false;
		isDeleted = portSerivce.delete(rowid);
		return isDeleted;
	}
	}