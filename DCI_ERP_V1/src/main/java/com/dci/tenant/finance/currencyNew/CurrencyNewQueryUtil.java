package com.dci.tenant.finance.currencyNew;

public class CurrencyNewQueryUtil {

	public static final String SELECT_CURRENCY_LIST = "SELECT currency_code currencyCode, currency_name currencyName, symbol symbol, default_rate currencyDefault, fraction_part currencyFraction FROM currency order by currency_code asc";

	public static final String GET_CURRENCY_LIST_ON_EDIT = "SELECT currency_code currencyCode, currency_name currencyName, symbol symbol, conversion_rate_from fromCurrency, conversion_rate_to toCurrency, " + "default_rate currencyDefault, fraction_part currencyFraction, isactive isActive, isbookcurrency bookCurrency FROM currency where currency_code=?";

	public static final String CHECK_COUNT_CURRENCY = "select count(*) from currency where currency_name=?";

	public static final String CHECK_COUNT_CURRENCY_UPDATE = "select count(*) from currency where currency_code<>? and currency_name=?";

	public static final String UPDATE_CURRENCY_DATA = "UPDATE currency SET currency_name=?, symbol=?, conversion_rate_from=?, conversion_rate_to=?, default_rate=?, fraction_part=?, isactive=?, " + "isbookcurrency=?  WHERE currency_code=?";

	public static final String DELETE_CURRENCY = "delete from currency where currency_code=?";

	public static final String saveCurrencyData = "INSERT INTO currency(currency_code, currency_name, symbol, conversion_rate_from, conversion_rate_to, " + "default_rate, fraction_part, isactive, isbookcurrency) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

}
