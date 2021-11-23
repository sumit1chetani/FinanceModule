package com.dci.master.vesselMaster;

public class VesselMasterQueryUtil {

	public static final String list ="SELECT id as vesselID, vesselcode, vesselname, coalesce(gw,0.00) as grossTonnage,coalesce(net,0.00) callletter, vessel_flag, main_line_service, vessel_owner, created_by, created_date, modified_by, modified_date FROM tb_vessels order by id desc ;";
	
//	public static final String list ="select id as vesselID, VesselCode as vesselCode,VesselName as vesselName,DeadWeight as deadWeight,Capacity  as capacity,GW as grossWeight,NET as netWeight,Speed as speed,OfficalNo  as officeCallNo,CallLetter as callLetter, BuiltDate as buildDate,Nationality as nationalitYList,VesselAccount as vesselAccount from TB_Vessels order by VesselCode asc";
	
	public static final String INSERT="INSERT INTO tb_vessels(vesselcode, vesselname, gw, net, callletter, main_line_service, vessel_owner, vessel_flag, created_by, created_date)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,now());";

//	public static final String INSERT= "INSERT INTO tb_vessels(vesselcode, vesselname, deadweight, capacity, gw, net, speed, officalno, callletter, builtdate, vesselaccount,created_by,created_date,modified_by,modified_date) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?,to_date(?,'dd/mm/yyyy'), ?,?,now(),?,now());";

	public static final String delete="delete from TB_Vessels where id=?";
	
	public static final String GET_VESSEL ="SELECT id as vesselID, vesselcode as vesselCode, vesselname as vesselName, gw as grossTonnage, net as netTonnage, callletter as callSign, vessel_flag as vesselFlag, main_line_service as mainLineService, vessel_owner as vesselOwner, created_by, created_date, modified_by, modified_date FROM tb_vessels where id=?;";

//	public static final String GET_VESSEL="select id as vesselID, VesselCode as vesselCode,VesselName as vesselName,DeadWeight as deadWeight,Capacity  as capacity,GW as grossWeight,NET as netWeight,Speed as speed,OfficalNo  as officeCallNo,CallLetter as callLetter,to_char(BuiltDate,'dd/mm/yyyy') as buildDate,VesselAccount as vesselAccount from TB_Vessels where id=?";
	
//	public static final String UPDATE = "update TB_Vessels set VesselCode=?, VesselName=?,DeadWeight=?,Capacity=?,GW=?,NET=?,Speed=?,OfficalNo=?,CallLetter=?,BuiltDate=to_date(?,'dd/mm/yyyy'),Nationality=?,VesselAccount=?,modified_by=?,modified_date=now() where id=?";

	public static final String UPDATE = "UPDATE tb_vessels SET vesselcode=?, vesselname=?, gw=?, net=?, vessel_flag=?, main_line_service=?, vessel_owner=?, callletter=?, modified_by=?, modified_date=now() WHERE id=?;";
	
	public static final String  getLineList ="select distinct line_code as id, line_name as text  from line order by line_name asc";

}

