package com.dci.payroll.tds.otherincomemaster;

import java.util.List;

import com.dci.common.util.CustomException;


public interface OtherIncomeMasterDAO {
	public List<OtherIncomeMasterBean> getOtherIncomeMasterList() throws CustomException;
}