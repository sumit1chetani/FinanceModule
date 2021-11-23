package com.dci.tenant.finance.trialBalance;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;

public class TrialBalanceResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<TrialBalanceBean> lTrialBalanceSGLevelList;
	private List<TrialBalanceBean> lTrialBalanceAHLevelList;
	private List<TrialBalanceBean> lTrialBalanceTransactionLevelList;
	private List<TrialBalanceBean> lTrialBalanceTransactionLevelListnew;
	private List<TrialBalanceBean> lTrialBalanceSGLevelListnew;

	private List<TrialBalanceBean> lTrialBalanceBean;
	private List<TrialBalanceBean> lTrialTreeList;
	private TrialBalanceBean trialBalanceBean;

	public List<TrialBalanceBean> getlTrialBalanceSGLevelList() {
		return lTrialBalanceSGLevelList;
	}

	public void setlTrialBalanceSGLevelList(List<TrialBalanceBean> lTrialBalanceSGLevelList) {
		this.lTrialBalanceSGLevelList = lTrialBalanceSGLevelList;
	}

	public List<TrialBalanceBean> getlTrialBalanceBean() {
		return lTrialBalanceBean;
	}

	public void setlTrialBalanceBean(List<TrialBalanceBean> lTrialBalanceBean) {
		this.lTrialBalanceBean = lTrialBalanceBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<TrialBalanceBean> getlTrialTreeList() {
		return lTrialTreeList;
	}

	public void setlTrialTreeList(List<TrialBalanceBean> lTrialTreeList) {
		this.lTrialTreeList = lTrialTreeList;
	}

	public TrialBalanceBean getTrialBalanceBean() {
		return trialBalanceBean;
	}

	public void setTrialBalanceBean(TrialBalanceBean trialBalanceBean) {
		this.trialBalanceBean = trialBalanceBean;
	}

	public List<TrialBalanceBean> getlTrialBalanceAHLevelList() {
		return lTrialBalanceAHLevelList;
	}

	public void setlTrialBalanceAHLevelList(List<TrialBalanceBean> lTrialBalanceAHLevelList) {
		this.lTrialBalanceAHLevelList = lTrialBalanceAHLevelList;
	}

	public List<TrialBalanceBean> getlTrialBalanceTransactionLevelList() {
		return lTrialBalanceTransactionLevelList;
	}

	public void setlTrialBalanceTransactionLevelList(List<TrialBalanceBean> lTrialBalanceTransactionLevelList) {
		this.lTrialBalanceTransactionLevelList = lTrialBalanceTransactionLevelList;
	}

	public List<TrialBalanceBean> getlTrialBalanceTransactionLevelListnew() {
		return lTrialBalanceTransactionLevelListnew;
	}

	public void setlTrialBalanceTransactionLevelListnew(List<TrialBalanceBean> lTrialBalanceTransactionLevelListnew) {
		this.lTrialBalanceTransactionLevelListnew = lTrialBalanceTransactionLevelListnew;
	}

	public List<TrialBalanceBean> getlTrialBalanceSGLevelListnew() {
		return lTrialBalanceSGLevelListnew;
	}

	public void setlTrialBalanceSGLevelListnew(List<TrialBalanceBean> lTrialBalanceSGLevelListnew) {
		this.lTrialBalanceSGLevelListnew = lTrialBalanceSGLevelListnew;
	}

	
	


}