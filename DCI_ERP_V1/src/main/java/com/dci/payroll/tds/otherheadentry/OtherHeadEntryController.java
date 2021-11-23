package com.dci.payroll.tds.otherheadentry;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;


@RestController
@RequestMapping(value = "payroll/tds/otherheadentry")
public class OtherHeadEntryController {
	private final static Logger LOGGER = LoggerFactory.getLogger(OtherHeadEntryController.class);
	@Autowired
	OtherHeadEntryService otherHeadEntryService;

	@RequestMapping(value = "/list")
	public OtherHeadEntryResultBean getOtherHeadEntryList(@RequestBody OtherHeadEntryBean otherHeadEntryBean) {
		OtherHeadEntryResultBean otherHeadEntryResultBean = new OtherHeadEntryResultBean();
		try {
			otherHeadEntryResultBean.setOtherHeadEntryList(otherHeadEntryService.getOtherHeadEntryList(otherHeadEntryBean.getEmployeeId(), otherHeadEntryBean.getFinancialYearId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otherHeadEntryResultBean;
	}

	@RequestMapping(value = "/save")
	public boolean save(@RequestBody ArrayList<OtherHeadEntryBean> otherHeadEntryBean) {
		OtherHeadEntryResultBean otherHeadEntryResultBean = new OtherHeadEntryResultBean();
		boolean isSuccess = false;
		try {

			isSuccess = otherHeadEntryService.insertOtherHead(otherHeadEntryBean);

		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/edit")
	public OtherHeadEntryBean getOtherHeadById(@RequestBody Integer otherHeadId) {
		try {
			return otherHeadEntryService.getOtherHeadById(otherHeadId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/update")
	public boolean update(@RequestBody OtherHeadEntryBean otherHeadEntryBean) {
		OtherHeadEntryResultBean otherHeadEntryResultBean = new OtherHeadEntryResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = otherHeadEntryService.updateHeadEntry(otherHeadEntryBean);
		} catch (CustomException e) {
			otherHeadEntryResultBean.setSuccess(false);
			otherHeadEntryResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public boolean delete(@RequestBody Integer otherHeadId) {
		boolean isDeleted = false;
		try {
			isDeleted = otherHeadEntryService.deleteOtherHeadEntry(otherHeadId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}

}