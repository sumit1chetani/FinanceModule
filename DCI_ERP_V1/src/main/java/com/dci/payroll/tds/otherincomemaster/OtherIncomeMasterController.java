package com.dci.payroll.tds.otherincomemaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payroll/tds/otherincomemaster")
public class OtherIncomeMasterController {
	private final static Logger LOGGER = LoggerFactory.getLogger(OtherIncomeMasterController.class);
	@Autowired
	OtherIncomeMasterService otherIncomeMasterService;

	@RequestMapping(value = "/list")
	public OtherIncomeMasterResultBean getOtherIncomeMasterList() {
		OtherIncomeMasterResultBean otherIncomeMasterResultBean = new OtherIncomeMasterResultBean();
		try {
			otherIncomeMasterResultBean.setOtherIncomeMasterList(otherIncomeMasterService.getOtherIncomeMasterList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otherIncomeMasterResultBean;
	}

}