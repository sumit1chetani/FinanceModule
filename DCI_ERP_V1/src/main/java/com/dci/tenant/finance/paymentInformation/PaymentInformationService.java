package com.dci.tenant.finance.paymentInformation;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CustomException;

public interface PaymentInformationService {

	List<PaymentInformationDetailBean> getPaymentInforDtlist(PaymentInformationBean informationBean) throws CustomException;

	List<PaymentInformationBean> getlist() throws CustomException;

	List<PaymentInformationBean> getlistDraft() throws CustomException;

	boolean saveData(PaymentInformationBean informationBean) throws CustomException;

	List<PaymentInformationBean> showPendingReceiptInformationList(PaymentInformationBean objPaymentInformationBean);

	boolean updateData(PaymentInformationBean informationBean) throws CustomException;

	PaymentInformationBean editData(PaymentInformationBean informationBean) throws CustomException;

	boolean approvedata(ArrayList<PaymentInformationBean> informationBean) throws CustomException;

	boolean deleteData(String paymentInformationNo) throws CustomException;

	void excellExport(PaymentInformationResultBean ObjPendingapprovalResultBean, PaymentInformationBean objPendingapprovalBean, String pdfFile);

	List<PaymentInformationBean> showPendingPaymentInformationList(PaymentInformationBean objPaymentInformationBean);
}
