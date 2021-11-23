package com.dci.master.service;

public class ServiceMasterQueryUtil {
	



	public static String sCompanyLocationDropDown = "select company_code as id,location as text , location as serviceLoc  from company_master where upper(is_operation) = 'Y'";
	
	
	
	public static String sViewServiceMasterDetails =  "select s.sector_code sectorCode,s.sector_name sectorName,s.sec_company_code, "
			+ "s.operation_since operationSince,emc.user_name as createdBy ,emm.user_name  AS modifiedBy, to_char(s.CREATED_DT,'dd/MM/yyyy')  as createdDate,to_char(s.MODIFIED_DT,'dd/MM/yyyy') "
			+ "AS modifiedDate,vessel_operator,vm.srvc_prtnr_nam as vendorName, coalesce(sailing_freq,0.0) as sailingfreq,coalesce(avg_trans,0.0) as avgtrans "
			+ "from sector_master s left join user_master emc on emc.user_id = s.created_by "
			+ "left join user_master emm on emm.user_id = s.MODIFIED_BY "
			+ "left join vendor_master_new vm on vm.vendor_id =vessel_operator";

	
	public static String sBranchDropDown="select branch_code as id,branch_name as text from branch order by branch_name asc";

	public static String sPortDropDown = "select portcode as id,portcode as text,portcode portCode from port_master where isactive='Y' ";

	public static String sPortDropDownforEdit = "select port_id as id,port_id as text,port_id portCode from SECTOR_PORT  where sector_id =? union select portcode as id,portcode as text,portcode portCode from port_master where isactive='Y'";

	public static String sAddServiceMaster = "INSERT INTO SECTOR_MASTER "
			+ "(SECTOR_CODE, SECTOR_NAME, SECTOR_SLNO, OPERATION_SINCE, EQPT_CNTRL, CREATED_BY, CREATED_DT,  SECTOR_ACTIVE,"
			+ " COMMENCE_DATE, COMPLETION_DATE, SEC_COMPANY_CODE,vessel_operator,avg_trans,sailing_freq) VALUES "
			+ "(:sectorCode, :sectorName, :sectorSlnoNumber, :operationSince, :eqmtCntrlEnable,"
			+ " :createdBy, now(), :isActive, :timeStampcommenceDate, :timeStampcompletionDate, :companyCode,:vesselOperator,:avgtrans,:sailingfreq)";

	public static String sGetSerialNo = "SELECT CASE WHEN MAX(sector_slno) IS NULL THEN 1 ELSE MAX(sector_slno)+1 END As sectorSlnoNumber FROM SECTOR_MASTER";

	public static String sAddServiceMasterDeatil = "INSERT " + "INTO SECTOR_PORT (SECTOR_ID, PORT_ID, TRANS_HUB, LEG_DEC, SL_NO, TO_PORT,"
			+ " berth_hour,berth_min,port_stay_hour,port_stay_min,steaming_hour,steaming_min,distance,speed,out_value,zone_value) "
			+ "VALUES (:sectorCode, :portCode, :transhipmentHub, :legDescription, :sno, :toPort,:berthHour,:berthMin,:stayHour,:stayMin,"
			+ ":steamingHour,:steamingMin,:distance,:speed,:out,:zone)";

	public static String sCheckServiceCodeAdd = "select count(*)  from sector_master where upper(trim(sector_code)) =? or upper(trim(sector_name))=?";
	public static String sCheckServiceCodeUpdate = "SELECT count(*) FROM SECTOR_MASTER WHERE upper(trim(sector_code)) <>? and upper(trim(sector_name))=?";

	public static String sEditServiceMaster ="select SECTOR_CODE sectorCode, SECTOR_NAME sectorName,SECTOR_SLNO sectorSlnoNumber,OPERATION_SINCE operationSince,EQPT_CNTRL eqmtCntrlEnable,SECTOR_ACTIVE isActive,to_char(COMMENCE_DATE,'dd/mm/yyyy') commenceDate,to_char(COMPLETION_DATE,'dd/mm/yyyy') completionDate,SEC_COMPANY_CODE companyCode,emc.user_name as createdBy ,emm.user_name  AS modifiedBy, to_char(SECTOR_MASTER.CREATED_DT,'dd/MM/yyyy')  as createdDate,to_char(SECTOR_MASTER.MODIFIED_DT,'dd/MM/yyyy') AS modifiedDate,vessel_operator as vesselOperator, COALESCE(avg_trans,0.0)  :: double precision as avgtrans, COALESCE(sailing_freq,0.0)  :: double precision as sailingfreq,v.srvc_prtnr_nam as vendorName  from SECTOR_MASTER left join user_master emc on emc.user_id = SECTOR_MASTER.created_by left join user_master emm on emm.user_id = SECTOR_MASTER.MODIFIED_BY   "
	+ " left join vendor_master_new v on v.vendor_id=vessel_operator "
                + "  where sector_code=? ";

			
			
	public static String sEditServiceMasterDetail = "select  SECTOR_ID sectorCode, PORT_ID portCode,TRANS_HUB transhipmentHub,"
			+ "LEG_DEC legDescription,SL_NO slNo,"
			+ "berth_hour berthHour,berth_min berthMin,port_stay_hour stayHour,"
			+ "port_stay_min stayMin,steaming_hour steamingHour,steaming_min steamingMin,"
			+ "distance,speed,out_value outValue,zone_value zoneValue "
			+ "from SECTOR_PORT where SECTOR_ID = ? Order by SLNO";

	public static String sUpdateServiceMaster = "UPDATE SECTOR_MASTER SET SECTOR_NAME = :sectorName, SECTOR_SLNO = :sectorSlnoNumber, OPERATION_SINCE = :operationSince, EQPT_CNTRL = :eqmtCntrlEnable, MODIFIED_BY = :modifiedBy, MODIFIED_DT = now(), SECTOR_ACTIVE = :isActive, COMMENCE_DATE = :timeStampcommenceDate, COMPLETION_DATE = :timeStampcompletionDate, SEC_COMPANY_CODE = :companyCode,vessel_operator = :vesselOperator,avg_trans =:avgtrans,sailing_freq =:sailingfreq WHERE SECTOR_CODE = :sectorCode";

	public static String sUpdateServiceMasterDeatil = "UPDATE SECTOR_PORT SET SL_NO = :sno, TO_PORT = :toPort WHERE SECTOR_ID = :sectorCode AND PORT_ID = :portCode AND TRANS_HUB = :transhipmentHub AND LEG_DEC = :legDescription";

	public static String sCheckServiceMasterDetail = "SELECT count(*) FROM SECTOR_PORT WHERE SECTOR_ID =? AND PORT_ID =? AND TRANS_HUB=? AND LEG_DEC=?";

	public static String sDeleteServiceMasterDetail = "delete from sector_port where Sector_ID=?";

	public static String sDeleteServiceMaster = "delete  from  SECTOR_MASTER where  SECTOR_CODE = ?";
	public static String sCheckServiceDetail = "SELECT count(*) FROM SECTOR_PORT WHERE SECTOR_ID =?";

	public static String sServiceDropDown = "select sector_code sectorCode,sector_name sectorName from SECTOR_MASTER ";
	

	public static String CHECK_FOREIGN_KEY = " select max(count)  from (select count(*) count from vessel_service_master where sector_code =? union select count(*) from voyage where sector_id =?) a ";

}
