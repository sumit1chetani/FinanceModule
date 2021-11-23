package com.dci.finance.closingPeriod;

import java.util.List;

import com.dci.common.util.CustomException;

public interface ClosingPeriodService {

	List<ClosingPeriodBean> getClosingList() throws CustomException;

	boolean delete(String closingAccountCode) throws CustomException;

	boolean save(ClosingPeriodBean objClosingPeriodBean) throws CustomException;

	boolean chkDate(String cbReceiptDate) throws CustomException;
}
