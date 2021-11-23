package com.dci.tenant.finance.reports.analytical.operatingExpenses;

public class OperatingExpensesQueryUtil {

	public static final String GET_TRUCK_LIST = "select distinct tm.truck_id as id,tm.license_plate as text from truck_master tm, VIEW_USER_RIGHTS_FOR_LIST ur where ur.form_code = ? and ur.user_id = ? and tm.created_dt is not null "; 
			

public static final String GET_trip_LIST = "select  distinct v.trip_no as id,v.trip_no as text   from "
			+" plan_trip v,VIEW_USER_RIGHTS_FOR_LIST ur where  ur.form_code = ? "
			+" and ur.user_id = ? and v.created_dt is not null ";

/*	public static final String GET_SERVICE_LIST = "select   distinct vs.SECTOR_CODE AS id,vs.SECTOR_CODE AS text " 
			 +" from vessel_service_master vs,sector_master s,VIEW_USER_RIGHTS_FOR_LIST ur "
		  +" where vs.sector_code=s.sector_code and s.sec_company_code = ur.company_code and ur.form_code = ? "
		+" and ur.user_id = ? "
					 +" order by vs.sector_code ";*/
	
	public static final String SELECT_LOCATION_LIST = "SELECT iata_id as id, concat(iata_cd, '-',iata_nam) as text FROM IATA where actv_bt='1'  order by iata_cd";
	
	public static final String SELECT_LOCATION_LIST1 = "SELECT prt_icd_id as id, concat(prt_icd_cd, '-',prt_icd_nam) as text FROM port_icd where actv_bt='1'  order by prt_icd_cd";
	
	public static final String GET_COMPANY_LIST = " select company_code as id, company_name as text from company_master";

	public static final String SELECT_ACCOUNT_HEAD_LIST = "select ACCT_HEAD_CODE as id,ACCT_HEAD_NAME as text from ACCOUNT_HEAD_MASTER order by ACCT_HEAD_NAME";

	public static final String SELECT_GRP_LIST = "select GROUP_HEAD_ID ||'0' as id,GROUP_HEAD_NAME as text from GROUP_HEAD_MASTER where group_head_id not in(1,2,3,9) ";

	public static final String SELECT_GRP_LIST_FOR_DUBAI = "select GROUP_HEAD_ID ||'0' as id,GROUP_HEAD_NAME as text from GROUP_HEAD_MASTER where group_head_id not in(3,9) ";

	public static final String GET_MAIN_REPORT(OperatingExpensesBean bean) {
		String sql = "";
		String groupBy = "";
		String whereCond = "";
		String identity = "";String identity1 = "";
		if (bean.getVesselCode() != null && !bean.getVesselCode().isEmpty()) {
			groupBy = " ,vessel_id ";
			whereCond += " where  vessel_id='" + bean.getVesselCode() + "' ";
		} else if (bean.getVoyageId() != null && !bean.getVoyageId().isEmpty()) {
			groupBy = " ,voyage_no ";
			whereCond += " where voyage_no='" + bean.getVoyageId() + "' ";
		} /*else if (bean.getServiceCode() != null && !bean.getServiceCode().isEmpty()) {
			groupBy = " ,SECTOR_ID";
			whereCond += " where SECTOR_ID='" + bean.getServiceCode() + "' ";
		} */
	
		if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
			identity1=(whereCond.isEmpty() == true) ? " where " : " and ";
			whereCond += identity1+" VOUCHER_DT >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
		}
		if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
			identity1=(whereCond.isEmpty() == true) ? " where " : " and ";
			whereCond += identity1+" VOUCHER_DT <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
		}
		if (bean.getCompanyCode() != null && !bean.getCompanyCode().isEmpty()) {
			identity1=(whereCond.isEmpty() == true) ? " where " : " and ";
			groupBy+= " ,COMPANY_ID ";
			whereCond += identity1+" COMPANY_ID='" + bean.getCompanyCode() + "' ";
		}

		if (bean.getGroupCode() != null && !bean.getGroupCode().isEmpty()) {
			identity1=(whereCond.isEmpty() == true) ? " where " : " and ";
			groupBy+= " ,sg ";
			whereCond += identity1 + " sg  LIKE ANY(ARRAY[" + bean.getGroupCode() + "])";
		}
		if (bean.getPol()!= null && !bean.getPol().isEmpty()) {
			identity1=(whereCond.isEmpty() == true) ? " where " : " and ";
			whereCond += identity1+" pol in(" + bean.getPol() + ")";
		}
		if (bean.getPod() != null && !bean.getPod().isEmpty()) {
			identity1=(whereCond.isEmpty() == true) ? " where " : " and ";
			whereCond += identity1+" pod in(" + bean.getPod() + ")";
		}
		
		sql = "select AH accountNo, A.ACCT_HEAD_NAME accountName, COALESCE(CR,0) usdCredit, COALESCE(DR,0) usdDebit,COALESCE((DR - CR),0) balance ," + "AH accoundHead " + groupBy
				+ " from ( select AH,sum(cr) cr, sum(dr) dr " + groupBy + " from vw_operation_expenses() VW ";
		sql += whereCond + " group by ah " + groupBy + ") T1 " + " left outer join  Account_head_master A on AH = ACCT_HEAD_CODE ";
		if (bean.getAccountCode() != null && !bean.getAccountCode().isEmpty()) {
			identity = " where ";
			sql += identity + " AH='" + bean.getAccountCode() + "'";
		}
		
		System.out.println(sql);
		return sql;
	}

	public static final String GET_SUB_REPORT(OperatingExpensesBean bean) {
		String accountCode = "";
		if (bean.getAccountNo().indexOf(",") == -1) {
			accountCode = "'" + bean.getAccountNo() + "'";
		} else {
			accountCode = bean.getAccountNo();
		}
		String sql = "select distinct AH accountNo, to_char(voucher_dt,'dd/mm/yyyy') voucherDate,voucher_no voucherNo,desciption description,payername payerName,COALESCE(cr,0) usdCredit,COALESCE(dr,0) usdDebit,voyage_no voyageId,vessel_id as vesselCode,pol,pod from vw_operation_expenses() IE "
				+ "left outer join  Account_head_master A on AH = ACCT_HEAD_CODE " +  "where AH in (" + accountCode + ")";
	if (bean.getVesselCode() != null && !bean.getVesselCode().isEmpty()) {
			sql += " and  vessel_id='" + bean.getVesselCode() + "' ";
		} else if (bean.getVoyageId() != null && !bean.getVoyageId().isEmpty()) {
			sql += " and voyage_no='" + bean.getVoyageId() + "' ";
		} 
		if (bean.getFromDate() != null && !bean.getFromDate().isEmpty()) {
			sql += " and VOUCHER_DT >= to_date('" + bean.getFromDate() + "','dd/mm/yyyy') ";
		}
		if (bean.getToDate() != null && !bean.getToDate().isEmpty()) {
			sql += " and VOUCHER_DT <= to_date('" + bean.getToDate() + "','dd/mm/yyyy') ";
		}if (bean.getPol()!= null && !bean.getPol().isEmpty()) {
			sql += " and pol in(" + bean.getPol() + ") ";
		}
		if (bean.getPod() != null && !bean.getPod().isEmpty()) {
			sql += " and pod in(" + bean.getPod() + ") ";
		}
		if (bean.getCompanyCode() != null && !bean.getCompanyCode().isEmpty()) {
			sql += " and COMPANY_ID='" + bean.getCompanyCode() + "' ";
		}
		return sql;
	}
}
