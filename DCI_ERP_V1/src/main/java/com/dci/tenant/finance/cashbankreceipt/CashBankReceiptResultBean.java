package com.dci.tenant.finance.cashbankreceipt;

import java.io.Serializable;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;

public class CashBankReceiptResultBean extends BasicResultBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6843004761595202951L;

	private List<SelectivityBean> objCashBankReceiptSelectivityBean;
	private List<CashBankReceiptListBean> objCashBankReceiptListListBean;
	private List<CashBankReceiptListBean> lCashbankReceiptListBean;
	private String sReceiptCode;
	private String sErrorMessage;
	private String voucherNo;

	public List<SelectivityBean> getObjCashBankReceiptListBean() {
		return objCashBankReceiptSelectivityBean;
	}

	public void setObjCashBankReceiptListBean(List<SelectivityBean> objCashBankReceiptSelectivityBean) {
		this.objCashBankReceiptSelectivityBean = objCashBankReceiptSelectivityBean;
	}

	public List<CashBankReceiptListBean> getObjCashBankReceiptListListBean() {
		return objCashBankReceiptListListBean;
	}

	public void setObjCashBankReceiptListListBean(List<CashBankReceiptListBean> objCashBankReceiptListListBean) {
		this.objCashBankReceiptListListBean = objCashBankReceiptListListBean;
	}

	public List<CashBankReceiptListBean> getlCashbankReceiptListBean() {
		return lCashbankReceiptListBean;
	}

	public void setlCashbankReceiptListBean(List<CashBankReceiptListBean> lCashbankReceiptListBean) {
		this.lCashbankReceiptListBean = lCashbankReceiptListBean;
	}

	public String getsReceiptCode() {
		return sReceiptCode;
	}

	public void setsReceiptCode(String sReceiptCode) {
		this.sReceiptCode = sReceiptCode;
	}

	public String getsErrorMessage() {
		return sErrorMessage;
	}

	public void setsErrorMessage(String sErrorMessage) {
		this.sErrorMessage = sErrorMessage;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

}
