package com.dci.tenant.finance.purchaseorder;

/*
 These Constants are used in purchase Order Query util for various status and def table list for form
 */
public class PurchaseConstants {

	public static final int PURCHASEFROM_FORMID = 15;
	public static final int PURCHASETO_FORMID = 16;
	public static final int PURCHASESTATUS_FORMID = 17;
	public static final int DETAIL_PURCHASESTATUS_FORMID = 40;
	public static final int PURCHASE_TYPE_REGULAR_ID = 43;
	public static final int STOCK_TRANSFER_TYPE = 123;
	public static final int STATUS_TYPE_PARTIALLY_RECIEVED = 138;
	public static final int STATUS_TYPE_RECIEVED = 139;
	public static final int STATUS_TYPE_CANCELLED = 48;

	public static final String TRADE_CREDITORS_AH = "20000001";

	public static final String TRADE_CREDITORS_SG = "2000";
	/*
	 * public static final String RETAIN_STATUS_LIST = "{" +
	 * STATUS_TYPE_PARTIALLY_RECIEVED + "," + STATUS_TYPE_CANCELLED + "}";
	 */
	public static final String RETAIN_STATUS_LIST = "{" + STATUS_TYPE_CANCELLED + "}";
	public static final String CANCEL_PURCHASE_ORDER_RETAIN_STATUS_LIST = "{" + STATUS_TYPE_PARTIALLY_RECIEVED + "," + STATUS_TYPE_RECIEVED + "}";
	public static final String ORDER_BY_PURCHASE_ORDER = " order by purchaseorderid desc";
	/*
	 * public static final String SPLIT_PURCHASE_STATUS_LIST = "{" +
	 * STATUS_TYPE_RECIEVED + "," + STATUS_TYPE_CANCELLED + ", 49 }";
	 */

	public static final String SPLIT_PURCHASE_STATUS_LIST = "{" + STATUS_TYPE_RECIEVED + "," + STATUS_TYPE_CANCELLED + "," + STATUS_TYPE_PARTIALLY_RECIEVED + ", 49 }";

	public static final String AMENDMENT_PURCHASE_STATUS_LIST = "{" + STATUS_TYPE_RECIEVED + "," + STATUS_TYPE_CANCELLED + "," + STATUS_TYPE_PARTIALLY_RECIEVED + ", 49 ,46}";

	public static final String PURCHASE_ORDER_AMENDMENT_STATUS_LIST = "{" + STATUS_TYPE_RECIEVED + "," + STATUS_TYPE_CANCELLED + ", 46, 48, 49 }";
	public static final StringBuilder TERMS_CONDITIONS = new StringBuilder().append("01. All the supplies should be accompanied by proper documents.").append("\n").append("02. The bills for supplies must be submitted in duplicate copy bearing the Supplier's GST registration number and showing the description of material, quantity, Purchase Order no., delivery challan no. and date etc. with proper Gate Entry.").append("\n").append("03.  One invoice for one purchase order.").append("\n")
			.append("04. Payment will be made after (25) days on receipt of material.").append("\n").append("05. No deviation is accepted from PO.").append("\n").append("06. Invoice to be raised in the name of");
	public static final String PURCHASE_ORDER_JASPER_REPORT = "reportHeader/Purchase_OrderDetails.jrxml";
	public static final String PURCHASE_ORDER_PDF = "/Purchase_Order.pdf";
	public static final String TEMPDOC_PATH = "/tempdoc";
	public static final String IMAGE_PATH = "/img";

	public static final String MERGE_PURCHASE_STATUS_LIST = "{" + STATUS_TYPE_RECIEVED + "," + STATUS_TYPE_CANCELLED + ", 49,138,165,166 }";

	public static final StringBuilder MERGE_REMARKS = new StringBuilder().append("This Purchase Order is merged with the following Purchase Order");
	public static final StringBuilder MERGE_REMARKS_STATEMENT = new StringBuilder().append("\n").append("Hence it is force Closed.");

	public static final String LOGO_IMAGE_HIS_PATH = "/img/his.png";

}
