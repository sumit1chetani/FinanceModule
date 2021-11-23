package com.dci.common.util;

public class CustomerQueryUtil {

	public static final String ERROR_ADD = null;

	public static String GETCODESTANDARDALL = "select * from (SELECT MLO_CODE as mlocode,MLO_NAME as mloname,MLO_ADDRESS as mloaddress FROM MLO_MASTER) where rownum < 10 ";
	public static String GETCODESTANDALL = "select * from (SELECT TARIFF_CODE as tariffcode,PORT_CODE as portcode ,AMT_LOCAL as amount  FROM PORT_TARIFF_HDR) where rownum < 10";
	public static String GETCALL = "select LOADING_DT as loadingdate ,TOTAL_WEIGHT as totalweight from LOADING_TILL2008 where rownum < = 10";
	public static String GETPAYMENT = "select INVOICE_NO as invoiceno ,RATE as paymentamount,USD_AMT as credit from PHC_INV_CON_DTL  where rownum < = 10";

	public static String INSERT_USERMASTER = " ";

}
