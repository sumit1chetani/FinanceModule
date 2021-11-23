package com.dci.tenant.finance.exchangerate;

public class ExchangeRateQueryUtil {
	public static final String GET_EXCHANGE_RATE_CODE = "SELECT CASE WHEN MAX(ER_ID) IS NULL THEN ? ELSE rpad(MAX(ER_ID),2,?)|| " + "lpad(cast(cast((SUBSTRING(MAX(ER_ID),3)) as int)+1 as text),5,'0') END AS ER_ID FROM EXCHANGE_RATE_TABLE ";

	public static final String GET_BOOK_CURRENCY_LIST = "select Crrncy_cd as currencyCode,crrncy_nam as id,CURRENCY_NAME as text from CURRENCY where isbookcurrency=? ORDER BY CURRENCY_NAME ASC";

	public static final String GET_EXCHANGE_RATE_LIST_ON_EDIT = "select to_char(ex_date,'DD/MM/YYYY') as exchangeRateDate, currency as currencyCode, book_currency bookCurrency, " + "value as exchangeRateValue,er_id as exchangeRateCode FROM exchange_rate_table where er_id=?";

	public static final String UPDATE_EXCHANGE_RATE_DATA = "update exchange_rate_table set ex_date=to_date(?,'DD/MM/YYYY'),currency=?,book_currency=?,value=?,modified_by=?,modified_dt=current_date where er_id=?";

	public static final String GET_EXCHANGE_RATE_WITH_SOURCE = "select currency as currencyCode, book_currency as bookCurrency, " + "value as exchangeRateValue,er_id as exchangeRateCode from exchange_rate_table where ex_date= to_date(?,'DD/MM/YYYY')";

	public static String GET_EXCHANGE_RATE_LIST = "select to_char(ex_date,'DD/MM/YYYY') as exchangeRateDate, currency as currencyCode, book_currency as bookCurrency, value as exchangeRateValue,er_id as exchangeRateCode " + "FROM exchange_rate_table order by er_id desc";

	public static String GET_CURRENCY_LIST = "select Crrncy_cd as currencyCode,crrncy_cd as id,crrncy_nam as text from CURRENCY where actv_bt = '1' ORDER BY crrncy_nam ASC";

	public static String SAVE_EXCHANGE_RATE = "insert into exchange_rate_table (ex_date,currency,book_currency,value,er_id,created_by,created_dt) values(to_date(?,'DD/MM/YYYY'),?,?,?,?,?,current_date)";

	public static String sDeleteExchangeRate = "delete from EXCHANGE_RATE_TABLE where ER_ID = ?";
}
