package com.dci.tenant.finance.journalVoucherType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "app/JournalVoucherType")
public class JournalVoucherTypeController {

	private final static Logger LOGGER = LoggerFactory.getLogger(JournalVoucherTypeController.class);
	@Autowired
	JournalVoucherTypeService journalVoucherTypeService;

	@RequestMapping(value = "/list")
	public @ResponseBody JournalVoucherTypeResultBean getList() {
		JournalVoucherTypeResultBean journalVoucherTypeResultBean = new JournalVoucherTypeResultBean();
		try {
			journalVoucherTypeResultBean.setJournalVoucherTypeBeans(journalVoucherTypeService.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return journalVoucherTypeResultBean;
	}

	@RequestMapping(value = "/getJvTypeList")
	public @ResponseBody JournalVoucherTypeResultBean getJvTypeList() {
		JournalVoucherTypeResultBean journalVoucherTypeResultBean = new JournalVoucherTypeResultBean();
		try {
			journalVoucherTypeResultBean.setJournalVoucherTypeBeans(journalVoucherTypeService.getJvTypeList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return journalVoucherTypeResultBean;
	}

	@RequestMapping(value = "/edit")
	public @ResponseBody JournalVoucherTypeResultBean getJvTypeId(@RequestBody int jvTypeId) {
		JournalVoucherTypeResultBean parameterTypeResultBean = new JournalVoucherTypeResultBean();
		try {
			parameterTypeResultBean.setJournalVoucherTypeBean(journalVoucherTypeService.getJvTypeId(jvTypeId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parameterTypeResultBean;
	}

	@RequestMapping(value = "/save")
	public @ResponseBody boolean save(@RequestBody JournalVoucherTypeBean journalVoucherTypeBean) {

		boolean isSuccess = false;
		try {

			isSuccess = journalVoucherTypeService.save(journalVoucherTypeBean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	@RequestMapping(value = "/update")
	public @ResponseBody boolean update(@RequestBody JournalVoucherTypeBean journalVoucherTypeBean) {
		JournalVoucherTypeResultBean journalVoucherTypeResultBean = new JournalVoucherTypeResultBean();
		boolean isSuccess = false;
		try {
			isSuccess = journalVoucherTypeService.update(journalVoucherTypeBean);
		} catch (CustomException e) {
			journalVoucherTypeResultBean.setSuccess(false);
			journalVoucherTypeResultBean.setMessage(e.getCustomMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@RequestMapping(value = "/delete")
	public @ResponseBody boolean delete(@RequestBody Integer jvTypeId) {
		boolean isDeleted = false;
		try {
			isDeleted = journalVoucherTypeService.delete(jvTypeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;

	}
}
