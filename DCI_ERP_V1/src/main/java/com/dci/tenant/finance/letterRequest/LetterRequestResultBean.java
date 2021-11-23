package com.dci.tenant.finance.letterRequest;

import java.io.Serializable;
import java.util.List;

import com.dci.common.util.BasicResultBean;


public class LetterRequestResultBean extends BasicResultBean implements
		Serializable {
	private static final long serialVersionUID = 1L;

	private List<LetterRequestBean> letterReqList;

	public List<LetterRequestBean> getLetterReqList() {
		return letterReqList;
	}

	public void setLetterReqList(List<LetterRequestBean> letterReqList) {
		this.letterReqList = letterReqList;
	}
	
}