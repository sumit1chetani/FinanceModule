package com.dci.tenant.finance.paymentInformation;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CustomException;

public interface PaymentInformationDAO {

	List<PaymentInformationDetailBean> getPaymentInforDtlist(PaymentInformationBean informationBean) throws CustomException;

	boolean saveData(PaymentInformationBean informationBean) throws CustomException;

	List<PaymentInformationBean> getlist() throws CustomException;

	List<PaymentInformationBean> getlistDraft() throws CustomException;

	boolean updateData(PaymentInformationBean informationBean) throws CustomException;

	PaymentInformationBean editData(PaymentInformationBean informationBean) throws CustomException;

	boolean deleteData(String paymentInformationNo) throws CustomException;

	boolean approvedata(ArrayList<PaymentInformationBean> informationBean) throws CustomException;

	List<PaymentInformationBean> showPendingReceiptInformationList(PaymentInformationBean objPaymentInformationBean);

	List<PaymentInformationBean> showPendingPaymentInformationList(PaymentInformationBean objPaymentInformationBean);

}
