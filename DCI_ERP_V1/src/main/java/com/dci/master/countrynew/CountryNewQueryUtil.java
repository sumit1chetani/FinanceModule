package com.dci.master.countrynew;

public class CountryNewQueryUtil {

	public static final String COUNTRY_LIST = "select co.country_code as countryCode,co.country_name as countryName,cu.currency_code as currencyCode,cu.currency_name as currencyName from country co left join currency cu on cu.currency_code = co.currency_code order by co.country_code";

	public static final String getCheckCountryCodeCount = "select count(*) from country where LOWER(country_code)=LOWER(?)";

	public static final String getCheckCountryNameCount = "select count(*) from country where LOWER(country_name)=LOWER(?)";

	public static final String INSERT_COUNTRY = "insert into country(country_code,country_name,currency_code) values(?,?,?)";

	public static final String getCurrencyList = "select crrncy_cd as id,crrncy_nam as text from currency where actv_bt = '1' order by crrncy_cd asc";

	public static final String SELECT_COUNTRY_BY_CODE = "select co.country_code as countryCode,co.country_name as countryName,cu.currency_code as currencyCode,cu.currency_name as currencyName from country co left join currency cu on cu.currency_code = co.currency_code where country_code=?";

	public static final String DELETE_COUNTRY = "delete from country where country_code=?";

	public static final String GET_COUNTRY_CODE = "SELECT country_code FROM country where UPPER(country_code)=UPPER(?)";

	public static final String GET_COUNTRY_NAME = "SELECT country_name FROM country where UPPER(country_code)=UPPER(?)";

	public static final String UPDATE_COUNTRY = "update country set country_name=?,currency_code=? where country_code=?";

}
