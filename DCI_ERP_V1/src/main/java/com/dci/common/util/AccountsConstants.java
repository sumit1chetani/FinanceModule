package com.dci.common.util;

import java.util.ArrayList;
import java.util.HashMap;

/*
 These Constants are used for Accounts Related 
 */
public class AccountsConstants {

	public static final String INTER_COMPANY_MANAGING_ACCOUNTS_AH = "20000001";

	public static final String INTER_COMPANY_MANAGING_ACCOUNTS_SG = "2000";

	public static final String MANAGING_COMPANY_OTHERS = "10100003";

	public static final String BANK_SG = "1000";
	public static final String CASH_SG = "1005";

	public static final String TEMPDOC_PATH = "/tempdoc";
	public static final String IMAGE_PATH = "/img";

	public static final String PURCHASE_INVOICE_JASPER_REPORT = "reportHeader/PurchaseInvoice.jrxml";
	public static final String PURCHASE_INVOICE_PDF = "/PurchaseInvoice.pdf";

	public static final String GENERAL_INVOICE_JASPER_REPORT = "reportHeader/GeneralInvoiceReport.jrxml";
	public static final String GENERAL_INVOICE_PDF = "/Invoice.pdf";

	public static final String PURCHASE_ACCRUAL_SG = "2000";
	public static final String PURCHASE_ACCRUAL_AH = "20000026";
	public static final String STOCK_VALUE_SG = "2000";
	public static final String STOCK_VALUE_AH = "20000019";

	public static final String CLOSING_ACCTS_RETAINED_EARNINGS_AH = "20130001";
	public static final String CLOSING_ACCTS_CURRENT_PERIOD_EARNINGS_AH = "20130002";
	public static final String PROFIT_AND_LOSS_ACCT_SG = "2013";

	/* Constant For Budget Allocation */

	public static final String MISC_SG = "4012";
	public static final String SALARY_SG = "4003";
	public static final String COMMUNICATION_SG = "4013";
	public static final String TRAVEL_EXP_SG = "4014";

	public static final String PROF_FEE_SG = "4005";
	public static final String MAINTANACE_SG = "4015";
	public static final String ASST_PUR_SG = "4016";
	public static final String SUP_PYMT_SG = "2000";
	// Mapped with Payables
	// SubGroup
	public static final String TRADE_CREDITORS_SG = "2001";

	public static final String TRADE_CREDITORS_AH = "20010001";
	public static ArrayList<String> BUDGET_SG_LIST = new ArrayList<>();

	public static HashMap<String, String> BUDGET_SG_MAP = new HashMap<>();

	public static ArrayList<String> getBUDGET_SG_LIST() {
		return BUDGET_SG_LIST;
	}

	public static void setBUDGET_SG_LIST(ArrayList<String> bUDGET_SG_LIST) {
		BUDGET_SG_LIST = bUDGET_SG_LIST;
	}

	public static ArrayList<String> createBudgetList() {
		BUDGET_SG_LIST.add(MISC_SG);
		BUDGET_SG_LIST.add(SALARY_SG);
		BUDGET_SG_LIST.add(COMMUNICATION_SG);
		BUDGET_SG_LIST.add(TRAVEL_EXP_SG);
		BUDGET_SG_LIST.add(PROF_FEE_SG);
		BUDGET_SG_LIST.add(MAINTANACE_SG);
		BUDGET_SG_LIST.add(ASST_PUR_SG);
		BUDGET_SG_LIST.add(SUP_PYMT_SG);
		return BUDGET_SG_LIST;

	}

	public static HashMap<String, String> createBudgetMap() {
		BUDGET_SG_MAP.put("misc_expenses", MISC_SG);
		BUDGET_SG_MAP.put("salaries", SALARY_SG);
		BUDGET_SG_MAP.put("communication", COMMUNICATION_SG);
		BUDGET_SG_MAP.put("travel_entertainment", TRAVEL_EXP_SG);
		BUDGET_SG_MAP.put("prof_fees", PROF_FEE_SG);
		BUDGET_SG_MAP.put("maintanance", MAINTANACE_SG);
		BUDGET_SG_MAP.put("asset_purchase", ASST_PUR_SG);
		BUDGET_SG_MAP.put("supplier_payment", SUP_PYMT_SG);
		return BUDGET_SG_MAP;

	}

}
