package com.dci.tenant.finance.tax.taxpayment;

import java.util.List;

import com.dci.common.util.CustomException;

public interface TaxPaymentService {
	List<TaxPaymentBean> getTaxPaymentList() throws CustomException;

	boolean save(TaxPaymentBean tdsNatureBeanObj) throws CustomException;

	TaxPaymentBean edit(String tdsNatureCode) throws CustomException;

	boolean updateTds(TaxPaymentBean tdsNatureBeanObj) throws CustomException;

	boolean deleteTdsNature(String tdsNatureCode) throws CustomException;

	List<TaxPaymentBean> getAcctHeadList(String userId) throws CustomException;
}
