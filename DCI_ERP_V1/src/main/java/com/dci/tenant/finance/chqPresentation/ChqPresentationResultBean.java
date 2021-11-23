package com.dci.tenant.finance.chqPresentation;

import java.util.ArrayList;
import java.util.List;

public class ChqPresentationResultBean {

	private List<ChqPresentationBean> swapMasterList = new ArrayList<>();
	private boolean success;

	public List<ChqPresentationBean> getSwapMasterList() {
		return swapMasterList;
	}

	public void setSwapMasterList(List<ChqPresentationBean> swapMasterList) {
		this.swapMasterList = swapMasterList;
	}

	public boolean isSuccess() {
		return success;
	}

	public List<ChqPresentationBean> getlCommonUtilityBean() {
		return lCommonUtilityBean;
	}

	public void setlCommonUtilityBean(List<ChqPresentationBean> lCommonUtilityBean) {
		this.lCommonUtilityBean = lCommonUtilityBean;
	}

	private List<ChqPresentationBean> lCommonUtilityBean;

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private List<ChqPresentationBean> chqStatusRprtList;

	public List<ChqPresentationBean> getChqStatusRprtList() {
		return chqStatusRprtList;
	}

	public void setChqStatusRprtList(List<ChqPresentationBean> chqStatusRprtList) {
		this.chqStatusRprtList = chqStatusRprtList;
	}

	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
