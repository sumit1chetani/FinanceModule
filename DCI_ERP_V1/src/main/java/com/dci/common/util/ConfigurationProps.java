package com.dci.common.util;

import org.springframework.beans.factory.annotation.Value;


import org.springframework.stereotype.Component;

@Component
public class ConfigurationProps {

	public static String exportFilesPath;
	public static String invoiceFilesPath;
	public static String slotMessageFilesPath;
	public static String quotationFilesPath;
	public static String athenaHelpVideosPath;
	
	public static String uniconHelpVideosPath;
	
	
	public static String DBConnection;
	public static String DBuserName;
	public static String DBpassword;
	
	@Value("${DB.Connection}")
	public void setDBConnection(String DBConnection) {
		ConfigurationProps.DBConnection = DBConnection;
	}
	
	@Value("${DB.UserName}")
	public void setDBuserName(String DBuserName) {
		ConfigurationProps.DBuserName = DBuserName;
	}
	
	@Value("${DB.Password}")
	public void setDBpassword(String DBpassword) {
		ConfigurationProps.DBpassword = DBpassword;
	}
	

/*	public static String creditnoteAcctData;
	public static String debitnoteMasterData;
	public static String cashbankpaymentModelData;
	public static String objCBReceipt;
	*/
		/*@Value("${export.creditnoteAcctData.serverPath}")
	public static void setCreditnoteAcctData(String creditnoteAcctData) {
		ConfigurationProps.creditnoteAcctData = creditnoteAcctData;
	}
		
		@Value("${export.files.serverPath}")
	public static void setDebitnoteMasterData(String debitnoteMasterData) {
		ConfigurationProps.debitnoteMasterData = debitnoteMasterData;
	}
		
			
		@Value("${file.upload.cashbankpaymentModelData.serverPath}")
	public static void setCashbankpaymentModelData(String cashbankpaymentModelData) {
		ConfigurationProps.cashbankpaymentModelData = cashbankpaymentModelData;
	}


		@Value("${file.upload.objCBReceipt.serverPath}")
	public static void setObjCBReceipt(String objCBReceipt) {
		ConfigurationProps.objCBReceipt = objCBReceipt;
	}	*/

	@Value("${export.files.absolutePath}")
	public void setExportFilesPath(String exportFilesPath) {
		ConfigurationProps.exportFilesPath = exportFilesPath;
	}

	@Value("${invoice.files.absolutePath}")
	public void setInvoiceFilesPath(String invoiceFilesPath) {
		ConfigurationProps.invoiceFilesPath = invoiceFilesPath;
	}

	@Value("${file.upload.slotmessage}")
	public void setSlotMessageFilesPath(String slotMessageFilesPath) {
		ConfigurationProps.slotMessageFilesPath = slotMessageFilesPath;
	}
	@Value("${export.quotationfiles.serverPath}")
	public void setQuotationFilesPath(String quotationFilesPath) {
		ConfigurationProps.quotationFilesPath = quotationFilesPath;
	}


	
	
/*	public static String getIforwardHelpVideosPath() {
		return iforwardHelpVideosPath;
	}

	public static void setIforwardHelpVideosPath(String iforwardHelpVideosPath) {
		ConfigurationProps.iforwardHelpVideosPath = iforwardHelpVideosPath;
	}

	public static String getUniconHelpVideosPath() {
		return uniconHelpVideosPath;
	}

	public static void setUniconHelpVideosPath(String uniconHelpVideosPath) {
		ConfigurationProps.uniconHelpVideosPath = uniconHelpVideosPath;*/
	

	@Value("${export.files.athenahelpvideos}")
	public void setAthenaHelpVideosPath(String athenaHelpVideosPath) {
		ConfigurationProps.athenaHelpVideosPath = athenaHelpVideosPath;
	}
	@Value("${export.files.uniconhelpvideos}")
	public void setUniconHelpVideosPath(String uniconHelpVideosPath) {
		ConfigurationProps.uniconHelpVideosPath = uniconHelpVideosPath;
	}
}
