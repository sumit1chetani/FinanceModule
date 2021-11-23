package com.dci.common.util;

public class ContainerInvoiceReportQueryUtil {

	public static String getvoyageforInvoice = " select mlo,voyage,pol,pod,TO_CHAR(INVOICE_DT,'DD/MM/YYYY') invoicedt,bill_of_lading_hdr.bl_no from bill_of_lading_hdr,VSI_GI_AMOUNT where VSI_GI_AMOUNT.BL_NO=bill_of_lading_hdr.BL_NO and VSI_GI_AMOUNT.INVOICE_NO=?";

	public static String getvoyageforBL = " select mlo,voyage,pol,pod,TO_CHAR(INVOICE_DT,'DD/MM/YYYY') invoicedt,bill_of_lading_hdr.bl_no,VSI_GI_AMOUNT.INVOICE_NO from bill_of_lading_hdr,VSI_GI_AMOUNT where VSI_GI_AMOUNT.BL_NO=bill_of_lading_hdr.BL_NO and bill_of_lading_hdr.BL_NO=?";

	public static String getvoyageforContainer = " select mlo_code,mlo_name,VOYAGE_NO,pol,pod,SLOT_SIZE,CONTR_TYPE from INV_Container_dtls  where CONTAINER_NO =?";

	public static String getVoyageforInvoicedtl = "Select voyage,vessel_name from singleinvoice_bl_dtl,vessel_master " + "where vessel = vessel_code and invoice_no = ?";

	public static String getPort = "Select TO_CHAR(a.invoice_dt,'DD-MM-YYYY'), " + "a.agent, b.mlo_name, a.currency, a.si_company_code " + "from singleinvoice_hdr a, " + "mlo_master b where a.customer = b.mlo_code " + "and a.invoice_no = ?";

	public static String slotmsg_hdr = "SELECT 	slot_msg_dtl_id,vessel_name,VOYAGE_NO,mlo_name,POL,POD,SAILING_DT," + " CONTAINER_NO,SLOT_SIZE,STOWAGE,WEIGHT,CONTR_TYPE,IMCO,REFER,remarks FROM INV_Container_dtls where";

	public static String getInvoice = "select INVOICE_NO from SINGLEINVOICE_HDR where INVOICE_NO like '%?%'";
	
	
	public static final String GET_MLO_SHORT = "select MLO_SHORT_NAME from MLO_MASTER where MLO_NAME = ? ";
	
	public static String slotmessage_hdr = "SELECT VOYAGE_NO as voyage,mlo_name as mlo ,POL,POD,CONTR_TYPE as contr_type,"
			+ "CONTAINER_NO as container_NO,SLOT_SIZE as size,round(WEIGHT::numeric, 2) as weight,IMCO as clas,"
			+ "REFER as setting,remarks FROM INV_Container_dtls where";
}
