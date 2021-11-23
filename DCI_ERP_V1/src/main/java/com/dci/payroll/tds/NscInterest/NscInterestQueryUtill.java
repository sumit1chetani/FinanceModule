package com.dci.payroll.tds.NscInterest;

public class NscInterestQueryUtill {

	public static final String SELECT_ALL = "SELECT  * from nsc_interest";

	public static final String SELECT_BY_ID = "select * from  nsc_interest where financial_year=?";

	public static final String INSERT = "INSERT INTO nsc_interest(financial_year, rate_of_interest) VALUES (:financialYear, :rateOfInterest) ";

	public static final String UPDATE = "UPDATE nsc_interest SET rate_of_interest = :rateOfInterest where financial_year=:financialYear";
}
