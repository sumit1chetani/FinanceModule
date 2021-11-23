package com.dci.tenant.finance.paymentOrder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.util.CustomException;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {
	@Autowired
	public PaymentOrderDAO paymentOrderDAO;

	@Override
	public List<PaymentOrderBean> getPaymentOrderList() throws CustomException {
		// TODO Auto-generated method stub
		return paymentOrderDAO.getPaymentOrderList();
	}

	@Override
	public List<PaymentOrderBankBean> getCashBankList() throws CustomException {
		// TODO Auto-generated method stub
		return paymentOrderDAO.getCashBankList();
	}

	@Override
	public List<PaymentOrderBankBean> getChequeList(String AccountCode) throws CustomException {
		// TODO Auto-generated method stub
		return paymentOrderDAO.getChequeList(AccountCode);
	}

	@Override
	public List<PaymentOrderBankBean> generatePayment(ArrayList<PaymentOrderBean> listPaymentOrder) throws CustomException {
		// TODO Auto-generated method stub
		return paymentOrderDAO.generatePayment(listPaymentOrder);
	}

	@Override
	public List<PaymentOrderBean> searchList(String companyCode) throws CustomException {
		// TODO Auto-generated method stub
		return paymentOrderDAO.searchList(companyCode);
	}

}
