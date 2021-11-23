package com.dci.tenant.finance.reports.charterhirestatement;

public class CharterHireStatementQueryUtil {

	public static final String GET_CHARTER_HIRE_STMT_REPORT =/* "select chdr.CHARTER_HIRE_CODE charterHireNo, chdr.VESSEL_CODE, ves.VESSEL_NAME vesselName, "
			+ "TO_CHAR(cdtl.FROM_DATE,'DD/MM/YYYY hh:mm') chFromDate, TO_CHAR(cdtl.TO_DATE,'DD/MM/YYYY hh:mm') chToDate, chdr.CURRENCY currencyCode, chdr.EXCHANGE_RATE exchangeRate,  "
			+ "cdtl.TOTAL_CHARGES totalCharges, (to_date (cdtl.TO_DATE,'DD/MM/YYYY') - to_date(cdtl.FROM_DATE,'DD/MM/YYYY'))  as noOfDays from CHARTER_HIRE_HDR chdr "
			+ "LEFT JOIN CHARTER_HIRE_DTL cdtl on cdtl.CHARTER_HIRE_CODE = chdr.CHARTER_HIRE_CODE "
			+ "LEFT JOIN VESSEL_MASTER ves on ves.VESSEL_CODE = chdr.VESSEL_CODE "
			+ "WHERE chdr.VESSEL_CODE=? and from_date BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')";*/
	
	 " select chdr.CHARTER_HIRE_CODE charterHireNo, chdr.VESSEL_CODE, ves.VESSEL_NAME vesselName, TO_CHAR(cdtl.FROM_DATE,'DD/MM/YYYY hh:mm') chFromDate, "+
	 " TO_CHAR(cdtl.TO_DATE,'DD/MM/YYYY hh:mm') chToDate, chdr.CURRENCY_code currencyCode, chdr.EXCHANGE_RATE exchangeRate,  cdtl.charter_hire_amount totalCharges, "+
	 " ( cdtl.TO_DATE - cdtl.FROM_DATE )  as noOfDays from vessel_approval_chrtrhire_hdr chdr LEFT JOIN vessel_approval_chrtrhire_dtl cdtl  "+
	 " on cdtl.CHARTER_HIRE_CODE = chdr.CHARTER_HIRE_CODE LEFT JOIN VESSEL_MASTER ves on ves.VESSEL_CODE = chdr.VESSEL_CODE "+
	 " WHERE chdr.VESSEL_CODE=? and cdtl.from_date BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " ;

	public static final String GET_CHARTER_HIRE_HDR_STMT_REPORT = /*"select DISTINCT chdr.CHARTER_HIRE_CODE charterHireNo, chdr.VESSEL_CODE vesselCode, ves.VESSEL_NAME vesselName, "
			+ "chdr.CURRENCY currencyCode, chdr.EXCHANGE_RATE exchangeRate from CHARTER_HIRE_HDR chdr "
			+ "LEFT JOIN CHARTER_HIRE_DTL cdtl on cdtl.CHARTER_HIRE_CODE = chdr.CHARTER_HIRE_CODE LEFT JOIN VESSEL_MASTER ves on ves.VESSEL_CODE = chdr.VESSEL_CODE "
			+ "WHERE chdr.VESSEL_CODE=? and from_date BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') ";
*/
			
			" select DISTINCT chdr.CHARTER_HIRE_CODE charterHireNo, chdr.VESSEL_CODE vesselCode, ves.VESSEL_NAME vesselName, "+
			" chdr.CURRENCY_code currencyCode, chdr.EXCHANGE_RATE exchangeRate from vessel_approval_chrtrhire_hdr chdr   "+
			" LEFT JOIN vessel_approval_chrtrhire_dtl cdtl on cdtl.CHARTER_HIRE_CODE = chdr.CHARTER_HIRE_CODE LEFT JOIN VESSEL_MASTER ves on ves.VESSEL_CODE = chdr.VESSEL_CODE   "+
			" WHERE chdr.VESSEL_CODE=? and cdtl.from_date BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')  ";
}
