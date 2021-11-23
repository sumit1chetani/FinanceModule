package com.dci.tenant.finance.tax.taxpayment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class TaxPaymentServiceImpl implements TaxPaymentService {
	@Autowired
	TaxPaymentDAO taxPaymentDAO;

	@Override
	public List<TaxPaymentBean> getTaxPaymentList() throws CustomException {
		return taxPaymentDAO.getTaxPaymentList();
	}

	@Override
	public boolean save(TaxPaymentBean tdsNatureBeanObj) throws CustomException {
		return taxPaymentDAO.save(tdsNatureBeanObj);
	}

	@Override
	public TaxPaymentBean edit(String tdsNatureCode) throws CustomException {
		return taxPaymentDAO.edit(tdsNatureCode);
	}

	@Override
	public boolean updateTds(TaxPaymentBean tdsNatureBeanObj) throws CustomException {
		return taxPaymentDAO.updateTds(tdsNatureBeanObj);
	}

	@Override
	public boolean deleteTdsNature(String tdsNatureCode) throws CustomException {
		return taxPaymentDAO.deleteTdsNature(tdsNatureCode);
	}

	@Override
	public List<TaxPaymentBean> getAcctHeadList(String userId) throws CustomException {
		return taxPaymentDAO.getAcctHeadList(userId);
	}

}
