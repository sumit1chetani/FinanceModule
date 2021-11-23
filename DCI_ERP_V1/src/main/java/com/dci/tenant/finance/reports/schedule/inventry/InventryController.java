package com.dci.tenant.finance.reports.schedule.inventry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "{tenantid}/app/inventory")
public class InventryController {

	private final static Logger LOGGER = LoggerFactory.getLogger(InventryController.class);
	@Autowired
	private InventryService inventryService;

	// Getting List

	@RequestMapping("/list")
	public @ResponseBody InventryResultBean getInventryList(@RequestBody InventryBean inventryBean ) throws CustomException,
			InterruptedException {
		InventryResultBean objInventryResultBean = new InventryResultBean();
		try {
			objInventryResultBean.setInventoryList(inventryService.getInventryList(inventryBean));
			objInventryResultBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventryResultBean;
	}

}
