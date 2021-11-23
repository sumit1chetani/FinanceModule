package com.dci.master.currency;

public class CurrencyQueryUtill {

	//public static String sGetCurrencyValue = "SELECT CURRENCY_CODE as currencyCode, CURRENCY_NAME as currencyName, CURRENCY_DEFAULT as currencyDefault, CURRENCY_FRACTION as currencyFraction,currency_conver_from as fromc, currency_conver_to as toc, currency_status as isActive, book_currency as bookCurrency from CURRENCY_MASTER where CURRENCY_CODE = ?";

	public static String sGetCurrencyValue = "select crrncy_id as currencyId,crrncy_cd as currencyCode,crrncy_nam as currencyName,COALESCE(CURRENCY_DEFAULT,'0') as currencyDefault,COALESCE(CURRENCY_FRACTION,'0')   as currencyFraction,COALESCE(currency_conver_from,'0') as fromc, COALESCE(currency_conver_to,'0') as toc,dscrptn_vc as description,crrncy_symbl_nam as symbol,crrncy_ctgry as category,actv_bt as isActive,rnd_off_invc_fnl_amnt as isRound from currency where crrncy_cd=?";
	
	public static String sGetCurrencyValue1 = "select crrncy_id as currencyId,crrncy_cd as currencyCode,crrncy_nam as currencyName,COALESCE(CURRENCY_DEFAULT,'0') as currencyDefault,COALESCE(CURRENCY_FRACTION,'0')   as currencyFraction,COALESCE(currency_conver_from,'0') as fromc, COALESCE(currency_conver_to,'0') as toc,dscrptn_vc as description,crrncy_symbl_nam as symbol,crrncy_ctgry as category,actv_bt as isActive,rnd_off_invc_fnl_amnt as isRound from currency where crrncy_id=?";
	//public static String sGetCurrencyValues = "SELECT CURRENCY_CODE as currencyCode, CURRENCY_NAME as currencyName, CURRENCY_DEFAULT as currencyDefault, CURRENCY_FRACTION as currencyFraction,currency_conver_from as fromc, currency_conver_to as toc, currency_status as isActive, book_currency as bookCurrency from CURRENCY_MASTER";
	

	public static String sGetCurrencyValues = "select crrncy_id as currencyId,crrncy_cd as currencyCode,crrncy_nam as currencyName,COALESCE(CURRENCY_DEFAULT,'0') as defaultCurrency,COALESCE(CURRENCY_FRACTION,'0')   as currencyFraction,COALESCE(currency_conver_from,'0') as fromCurrency, COALESCE(currency_conver_to,'0') as toCurrency,dscrptn_vc as description,crrncy_symbl_nam as symbol,crrncy_ctgry as category,actv_bt as isActive,rnd_off_invc_fnl_amnt as isRound from currency order by crrncy_id desc";
	
	//public static String sAddCurrency = "insert into CURRENCY_MASTER (CURRENCY_CODE, CURRENCY_NAME , CURRENCY_CONVER_FROM, CURRENCY_CONVER_TO, CURRENCY_DEFAULT, CURRENCY_FRACTION, CURRENCY_STATUS, BOOK_CURRENCY, CREATED_BY, CREATED_DT) values (?,?,?,?,?,?,?,?,?, current_date )";


	public static String sAddCurrency = "insert into currency (crrncy_id,crrncy_cd,crrncy_nam,crrncy_symbl_nam,dscrptn_vc,crtd_by,crtd_dt,mdfd_by,mdfd_dt,actv_bt,crrncy_ctgry,rnd_off_invc_fnl_amnt,currency_conver_from,currency_conver_to,currency_fraction,currency_default) values (?,?,?,?,?,?,now(),?,now(),pg_catalog.bit(?),?,pg_catalog.bit(?),?,?,?,?)";

	public static String sDeleteCurrencyDetail = "delete from currency where crrncy_id = ?";

	//public static String sUpdatecurrency = "update currency_master set CURRENCY_NAME =? ,CURRENCY_DEFAULT =?,CURRENCY_FRACTION =?, currency_conver_from = ?, currency_conver_to = ?, CURRENCY_STATUS = ?,  BOOK_CURRENCY = ? where CURRENCY_CODE = ?";
	
	public static String sUpdatecurrency = "update currency set crrncy_nam=?,crrncy_symbl_nam=?,dscrptn_vc=?,mdfd_by=?,mdfd_dt=now(),actv_bt=pg_catalog.bit(?),crrncy_ctgry=?,rnd_off_invc_fnl_amnt=pg_catalog.bit(?),currency_conver_from = ?, currency_conver_to = ?,currency_fraction =?,currency_default =? where crrncy_id =?";
	
	public static String currencyExists = "SELECT count(*) FROM currency WHERE  crrncy_nam=?";
	
	public static String count1 ="select case when max(crrncy_id) is null then '1' else max(crrncy_id)+1 end  as currencyid from currency";
	
	public static String currencyCodeExists = "SELECT count(*) FROM currency WHERE  crrncy_cd=?";
	
	public static String currencyExistsOnEDit = "SELECT count(*) FROM currency_master WHERE CURRENCY_CODE<>? and CURRENCY_NAME=?";

	public static String sGetCurrencyRates="select currency_conver_from as fromCurrency,currency_conver_to as toCurrency,currency_default as defaultCurrency from currency where crrncy_id=?";

}
