package com.dci.tenant.finance.pendingReceiptReport;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dci.common.util.MailConstants;
import com.dci.tenant.common.MailUtility;
import com.dci.tenant.user.UserDetail;

@Service
public class PendingReceiptReportServiceImpl implements PendingReceiptReportService {
	@Autowired
	PendingReceiptReportDAO pendingReceiptReportDAO;

	@Override
	public PendingReceiptReportResultBean getList() throws Exception {
		// TODO Auto-generated method stub
		return pendingReceiptReportDAO.getList();
	}

	@Override
	public boolean sendMail(List<PendingReceiptReportBean> beanslist) throws Exception {
		boolean isSent = false;
		boolean isSaved = false;
		boolean isSuccess = false;

		UserDetail user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String invoiceDt = "";
		String invoiceNo = "";
		String stateName = "";
		double invBcAmt;
		double paidBcAmount;
		double balanceAmount;
		String duedate;

		for (PendingReceiptReportBean pendingReceiptReportBean : beanslist) {

			if (pendingReceiptReportBean.isSelect() == true) {

				PendingReceiptReportBean objCustomerDetails = new PendingReceiptReportBean();
				String tHead = MailConstants.pendingRecepitHead;
				String tBody = MailConstants.pendingRecepitBody;
				String tFoot = MailConstants.pendingRecepitFoot;
				String sBodyTop = MailConstants.pendingRecepitBodyTop;
				String sBodyBtm = MailConstants.pendingRecepitBodyBtm;
				String sBody;
				String sCategories = MailConstants.sCategories;
				String sSubject = MailConstants.pendingRecepitSubject;

				String sToMail = null;
				String customerName = "";
				String customerloc = "";
				String customerAddress = "";
				String customerzip = "";
				String customerState = "";
				String customerCity = "";
				String customerCountry = "";

				objCustomerDetails = pendingReceiptReportDAO.getCustomerDetails(pendingReceiptReportBean.getCustomer());

				customerName = pendingReceiptReportBean.getEntityName();

				if (objCustomerDetails.getCustomerLocName() != null && objCustomerDetails.getCustomerLocName() != "") {
					customerloc = objCustomerDetails.getCustomerLocName();
				}
				if (objCustomerDetails.getCustomerAddress() != null && objCustomerDetails.getCustomerAddress() != "") {
					customerAddress = objCustomerDetails.getCustomerAddress();
				}
				if (objCustomerDetails.getState() != null && objCustomerDetails.getState() != "") {
					customerState = objCustomerDetails.getState();
				}
				if (objCustomerDetails.getCountry() != null && objCustomerDetails.getCountry() != "") {
					customerCountry = objCustomerDetails.getCountry();
				}
				if (objCustomerDetails.getZipcode() != null && objCustomerDetails.getZipcode() != "") {
					customerzip = objCustomerDetails.getZipcode();
				}
				if (objCustomerDetails.getCityName() != null && objCustomerDetails.getCityName() != "") {
					customerCity = objCustomerDetails.getCityName();
				}

				sToMail = objCustomerDetails.getEmail();

				Date dt = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
				ft.format(dt);

				sBodyTop = MessageFormat.format(sBodyTop, new Object[] { ft.format(dt), customerName, customerloc, customerAddress, customerCity, customerState, customerCountry, customerzip, pendingReceiptReportBean.getCurrencyCode(), pendingReceiptReportBean.getBalanceAmount(), pendingReceiptReportBean.getDueDate() });
				sBodyBtm = MessageFormat.format(sBodyBtm, new Object[] { user.getCompanyName() });

				invoiceDt = pendingReceiptReportBean.getInvoiceDt();
				invoiceNo = pendingReceiptReportBean.getInvoiceNo();
				invBcAmt = pendingReceiptReportBean.getInvBcAmt();
				paidBcAmount = pendingReceiptReportBean.getPaidBcAmount();
				balanceAmount = pendingReceiptReportBean.getBalanceAmount();
				duedate = pendingReceiptReportBean.getDueDate();
				tHead = tHead + MessageFormat.format(tBody, new Object[] { invoiceDt, invoiceNo, duedate, invBcAmt, paidBcAmount, balanceAmount });
				tHead = tHead + tFoot;

				sBody = sBodyTop + tHead + sBodyBtm;
				sBody = MessageFormat.format(sBody, new Object[] {});

				Map<String, String> filesList = new HashMap<>();

				if (sToMail != null && !"".equalsIgnoreCase(sToMail) && !" ".equalsIgnoreCase(sToMail)) {
				//	MailUtility.sendMail(email, path);(sToMail, sSubject, sBody, sCategories.split(","), filesList);
					isSuccess = true;
				}

			}

		}
		isSent = true;

		return isSuccess;
	}

}
