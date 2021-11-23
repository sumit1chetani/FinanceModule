package com.dci.tenant.finance.chqBook;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dci.common.util.CustomException;

@RestController
@RequestMapping(value = "app/chqBook")

public class ChqBookController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ChqBookController.class);

	@Autowired
	ChqBookService chqBookService;

	@RequestMapping(value = "/list")
	public ChqBookResultBean getChqBookList() {
		ChqBookResultBean objChqBookResultBean = new ChqBookResultBean();

		try {
			objChqBookResultBean.setChqBookList(chqBookService.getChqBookList());
			objChqBookResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objChqBookResultBean;
	}

	@RequestMapping(value = "/listdumy")
	public ChqBookResultBean getChqBookListdummy() {
		ChqBookResultBean objChqBookResultBean = new ChqBookResultBean();

		try {
			objChqBookResultBean.setChqBookList(chqBookService.getChqBookListdummy());
			objChqBookResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objChqBookResultBean;
	}

	@RequestMapping(value = "/getStatusList")
	public ChqBookResultBean getStatusList() {
		ChqBookResultBean objChqBookResultBean = new ChqBookResultBean();
		try {

			objChqBookResultBean.setStatusList(chqBookService.getStatusList());
			objChqBookResultBean.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objChqBookResultBean;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ChqBookResultBean saveChqBook(@RequestBody ChqBookBean objChqBookBean) throws CustomException {
		boolean isSuccess = false;
		ChqBookResultBean objChqBookResultBean = new ChqBookResultBean();
		try {

			isSuccess = chqBookService.saveChqBook(objChqBookBean);
			objChqBookResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objChqBookResultBean;
	}

	@RequestMapping(value = "/edit")
	public ChqBookResultBean editChqBook(@RequestParam("chqBookId") int chqBookId) {

		try {
			return chqBookService.editChqBook(chqBookId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ChqBookResultBean updateChqBook(@RequestBody ChqBookBean objChqBookBean) throws CustomException {
		boolean isSuccess = false;
		ChqBookResultBean objChqBookResultBean = new ChqBookResultBean();
		try {

			isSuccess = chqBookService.updateChqBook(objChqBookBean);
			objChqBookResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}

		return objChqBookResultBean;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteChqBook(@RequestBody int chqBookId) throws Exception {

		boolean isDeleted = false;
		isDeleted = chqBookService.deleteChqBook(chqBookId);
		return isDeleted;
	}

	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
	public @ResponseBody ChqBookResultBean searchList(@RequestBody ChqBookBean objChqBookBean) {
		List<ChqBookBean> lChqBookLevelList = new ArrayList<ChqBookBean>();
		ChqBookResultBean objChqBookResultBean = new ChqBookResultBean();
		try {
			try {
				lChqBookLevelList = chqBookService.searchList(objChqBookBean);
				objChqBookResultBean.setChqBookList(lChqBookLevelList);
				objChqBookResultBean.setSuccess(true);
			} catch (Exception e) {
				objChqBookResultBean.setSuccess(false);
				LOGGER.error("Error", e);
				throw new CustomException();
			}

		} catch (Exception e) {
			LOGGER.error("Error", e);
		}

		return objChqBookResultBean;
	}

}
