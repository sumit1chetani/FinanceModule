package com.dci.tenant.finance.paymentOrder;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CustomException;

public interface PaymentOrderDAO {
	List<PaymentOrderBean> getPaymentOrderList() throws CustomException;

	List<PaymentOrderBankBean> getCashBankList() throws CustomException;

	List<PaymentOrderBankBean> getChequeList(String AccountCode) throws CustomException;

	List<PaymentOrderBankBean> generatePayment(ArrayList<PaymentOrderBean> listPaymentOrder) throws CustomException;

	List<PaymentOrderBean> searchList(String companyCode) throws CustomException;
}
