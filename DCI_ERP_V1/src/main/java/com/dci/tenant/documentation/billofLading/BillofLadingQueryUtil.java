package com.dci.tenant.documentation.billofLading;

public class BillofLadingQueryUtil {
	public static final String INSERT = "insert into inward_bls (bl_no,booking_no,issue_place,issue_date,onboard_date,por,pol,pod,pot,fpod,"
			+ "terms_of_payment,no_of_bls,reference,voyage_code,pre_voyage_code,fcl_type,service,mail_release,client_id,job_no,"
			+ "agent_id,remarks,bl_status,status )  values"
			+ "(?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,"
			+ "?,?,?::int,?,?,?,?,?,?,?,"
			+ "?,?,?,?)";
	
	public static final String DROPDOWN ="select tvo.voyageno as id,concat(tv.vesselcode,'-',tvo.voyageno) as text from tb_vessels tv inner join tb_voyage tvo on tvo.vesselid=tv.vesselcode";

		
	public static final String LIST="select bl_no as blNo,booking_no as bookingNo,no_of_bls as noBls,concat(b.branch_short_name,'-',cm.short_name,'-',cm.country) as issuePlace,pm.portname as pol,pd.portname as pod FROM inward_bls ib left join branch b on b.branch_code=ib.issue_place  "
			+ " left join company_master cm on cm.company_code=b.company_code  "
+ " left join port_master pm on pm.portcode=ib.pol "
+ " left join port_master pd on pd.portcode=ib.pod "
+ "ORDER BY BlNo ASC";

	public static final String GET_BL =" select distinct ib.bl_no as blNo,ib.booking_no as bookingNo,ib.issue_place as issuePlace,to_char(ib.issue_date,'dd/mm/yyyy') as issueDate,to_char(ib.onboard_date,'dd/mm/yyyy')  as onBoard,   "
		+" ib.por as receiptAt,ib.pol as pol,ib.pod as pod,ib.pot as pot,ib.fpod as fpod,ib.terms_of_payment as terms,ib.no_of_bls as noBls,ib.reference as ref,ib.voyage_code as vslVoyage,   "
		+" pre_voyage_code as mVoyage,fcl_type as loadType,service as service,mail_release as released,     "
		+" ib.client_id as client,ib.job_no as jobNo,ib.agent_id as agent,ib.remarks as remarks,ib.bl_status as shipment,ib.status as status,ibn.shipper as shipper,   "
		+" ibn.cnee as cnee,ibn.notify1 as notify1,ibn.notify2 as notify2,ibn.messers as messers,ibn.forwarder as forwarder,ibg.goods,ibg.marks,ibg.maincom as maincom,ibg.ttw as t_wgt,ibg.tgw as g_wgt,   "
		+" ibg.ttlpkgs as pkgs,ibg.ttlcbm as cbm,ibg.ttlnet as n_wgt    "
 	+" 	FROM inward_bls ib inner join inward_bls_names ibn on ibn.bl_no=ib.bl_no     "
        +"   left join inward_bls_goods ibg on ibg.bl_no=ib.bl_no    "
+" where ib.bl_no=? ";
	
	public static final String GET_BL_CONT_DTL="select inward_cntrs_id as inwardCntrId,bl_no as blNo,cntr_no as cntrNo ,cn_type as type,seal_no as sealNo,tw as tw,gw as gw,cbm as cb,net as net,fle as fle,soc as so,package_type as packageType,  "
+" no_of_pkgs as noOfPckgs,goods as goods,isoog as iso,polterm as polTer,podterm as podTer,marks as marks from inward_cntrs where bl_no=?";
	
	public static final String GET_CON_CHARGE_DTL="select  inward_cntrs_charges_id as inwardContChargesId,charges_code as chargeCode,currency as currency,unit_rate as unitRate,mea_rate as meaRate,wgt_rate as wgRate,from_place as fromPlace,to_place as toPlace,min_rate as minRate,terms as terms,real_amount as realAmount from inward_cntrs_charges   where inward_cntrs_id=?";
	
	public static final String GET_CON_PACKAGE_DTL="select inward_cns_pkgs_id as inwardPackageChargeId ,package_type as packageType,no_of_packages  as noofPcks,gw as gw_,hs_code  as hsCode,goods  as goods from inward_cns_pkgs  where inward_cns_id=?";

	public static final String GET_BL_CHARGE="select inward_charges_id as packageChargeId,seq as seq,charge_code as chargeCode, currency as currency,qty as qty,rate as rate,amount as amount,pay_at as payAt,real_amount as realAmount,from_place as fromPlace,invoice_amount as invAmount,to_place as toPlace,terms as terms from inward_charges where bl_no=?";
	
	public static final String GET_Bl ="select bl_no as blNo,booking_no as bookingNo,issue_place as issuePlace,issue_date as issueDate,onboard as onboard,"  
			+ "receipt_at as receiptAt,pol as pol,pod as pod,pot as pot,fpod as fpod,terms as terms,no_bls as noBls,_ref as ref,vsl_voyage as vslVoyage,"
			+ "m_voyage as mvoyage,load_type as loadType,service as service,case when released=true then 'TRUE' else 'FALSE' end as releasedstr,"  
			+ "client as client,job_no as jobNo,agent as agent,remarks as remarks,shipment as shipment,status as status,"
			+ "messers as messers,shipper as shipper,cnee as cnee,notify1 as notify1,notify2 as notify2,"
				+ "forwarder as forwarder,maincom as maincom,t_wgt as t_wgt,g_wgt as g_wgt,n_wgt as n_wgt,cbm as cbm,pkgs as pkgs,goods as goods,marks as marks FROM export_bl where bl_no=?";


	public static final String UPDATE = "update export_bl set booking_no=?,issue_place=?,issue_date=?,onboard=?,receipt_at=?,pol=?,pod=?,pot=?,fpod=?,terms=?,no_bls=?,"
			
			+ "_ref=?,vsl_voyage=?,m_voyage=?,load_type=?,service=?,released=?,client=?,job_no=?,agent=?,remarks=?,shipment=?,status=?,"
			+ "messers=?,shipper=?,cnee=?,notify1=?,notify2=?,"
			+ "forwarder=?,maincom=?,t_wgt=?,g_wgt=?,n_wgt=?,cbm=?,pkgs=?,goods=?,marks=? where bl_no=?";

	public static final String INSERT_BL_NAMES = "insert into inward_bls_names(bl_no,messers,shipper,cnee,notify1,notify2,forwarder) values (?,?,?,?,?,?,?)";

	public static final String INSERT_BL_GOODS = "	insert into inward_bls_goods (bl_no,goods,marks,maincom,ttw,tgw,ttlpkgs,ttlcbm,ttlnet) values (?,?,?,?,?,?,?,?,?)";

	public static final String INSERT_CONT_DTLS = "insert into inward_cntrs(bl_no,cntr_no,cn_size,cn_type,seal_no,tw,gw,cbm,net,fle,soc,package_type,no_of_pkgs,goods,isoog,polterm,podterm,marks) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning inward_cntrs_id ";

	public static final String INSERT_CONT_CHARGE_DTLS = "insert into inward_cntrs_charges(inward_cntrs_id,cntr_no,charges_code,currency,unit_rate,mea_rate,wgt_rate,from_place,to_place,min_rate,terms,real_amount) values (?,?,?,?,?,?,?,?,?,?,?,?) ";

	public static final String INSERT_CONT_PACKAGE_DTL = "insert into inward_cns_pkgs(inward_cns_id,hs_code,package_type,no_of_packages,gw,goods,cntr_no) values (?,?,?,?,?,?,?)";

	public static final String Update_Hdr = "update inward_bls set booking_no=?,issue_place=?,issue_date=to_date(?,'dd/mm/yyyy'),onboard_date=to_date(?,'dd/mm/yyyy'),por=?,pol=?,pod=?,pot=?,fpod=?,"
			+ "terms_of_payment=?,no_of_bls=?,reference=?::int,voyage_code=?,pre_voyage_code=?,fcl_type=?,service=?,mail_release=?,client_id=?,job_no=?,"
			+ "agent_id=?,remarks=?,bl_status=?,status=? where bl_no=?";

	public static final String Get_count_names = "select count(*) from inward_bls_names where bl_no=?";

	public static final String UPDATE_BL_NAMES = "update inward_bls_names set messers= ? ,shipper= ? ,cnee= ? ,notify1= ? ,notify2 = ? ,forwarder = ? where bl_no = ? ";

	public static final String UPDATE_BL_GOODS = "update inward_bls_goods set goods= ?,marks= ?,maincom= ?,ttw= ?,tgw= ?,ttlpkgs= ?,ttlcbm= ?,ttlnet= ? where bl_no = ? ";

	public static final String UPDATE_CONT_DTLS = "update inward_cntrs set cntr_no= ?,cn_size= ?,cn_type= ?,seal_no= ?,tw= ?,gw= ?,cbm= ?,net= ?,fle= ?,soc= ?,package_type= ?,no_of_pkgs= ?,goods= ?,isoog= ?,polterm= ?,podterm= ?,marks= ? where inward_cntrs_id = ?";

	public static final String UPDATE_CONT_CHARGE_DTLS = "update inward_cntrs_charges set cntr_no= ?,charges_code= ?,currency= ?,unit_rate= ?,mea_rate= ?,wgt_rate= ?,from_place= ?,to_place= ?,min_rate= ?,terms= ?,real_amount= ? where inward_cntrs_charges_id=?";

	public static final String UPDATE_CONT_PACKAGE_DTL = "update inward_cns_pkgs set hs_code= ?,package_type= ?,no_of_packages= ?,gw= ?,goods= ?,cntr_no= ? where inward_cns_pkgs_id =?";

	public static String delete="delete from export_bl where bl_no=?";
	
	public static String getIssuePlace="select b.branch_code as id, concat(b.branch_short_name,'-',cm.short_name,'-',cm.country) as text from company_master cm inner join branch b on b.company_code=cm.company_code order by text asc";
	
	public static String getContainerType="select const_code as id,const_desc as text from sys_const where const_grp ='CT'";
	
	public static String getAgentList="select vendor_code as id,concat(vendor_code,'-',vendor_name) as text from vendor_master order by id";
	
	public static String getBookingList="select booking_no as id,booking_no as text from booking order by booking_no asc";
	
	public static String shipmentList="select const_code as id,const_desc as text from sys_const where const_grp ='ST' and isactive=true";

	public static String packageTypeList="select pack_type as id,description as text from pack_types  order by text asc";
	
	public static String surChargeList="select sur_code as id,sur_name as text from surcharge_master order by text asc";

	public static String delete_conatiner="delete from inward_cntrs where inward_cntrs_id=?";

	public static String delete_package_charge="delete from inward_cns_pkgs where inward_cns_pkgs_id=?";

	public static String delete_conatiner_charge="delete from inward_cntrs_charges where inward_cntrs_charges_id=?";

	public static String getContainers="select container_number as id,container_number as text from container order by container_number asc";

	public static String delete_charge="delete from inward_charges where inward_charges_id=?";
	
	public static final String INSERT_CHARGE_DT_BL = "insert into inward_charges (bl_no,seq,charge_code,currency,qty,rate,amount,pay_at,terms,from_place,to_place,invoice_amount,real_amount) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String Get_count_charge = "select count(*) from inward_charges where bl_no=?";

	public static final String UPDATE_CHARGE_DT_BL = "update inward_charges set bl_no=?,seq=?,charge_code=?,currency=?,qty=?,rate=?,amount=?,pay_at=?,terms=?,from_place=?,to_place=?,invoice_amount=?,real_amount=? where inward_charges_id=?";

	public static final String GET_print_bl ="select distinct ib.inwardbls_id as blId,ib.client_id as customerId, ib.bl_no as blNo,ib.booking_no as bookingNo,ib.issue_place as issuePlace,to_char(ib.issue_date,'dd/mm/yyyy') as issueDate,to_char(ib.onboard_date,'dd/mm/yyyy')  as onBoard,      ib.por as receiptAt,ib.pol as pol,ib.pod as pod,ib.pot as pot,ib.fpod as fpod,CASE WHEN ib.terms_of_payment='1' THEN 'Prepaid' ELSE 'Collect' END as terms,ib.no_of_bls as noBls,ib.reference as ref,ib.voyage_code as vslVoyage,      pre_voyage_code as mVoyage,fcl_type as loadType,service as service,mail_release as released,        ib.client_id as client,ib.job_no as jobNo,ib.agent_id as agent,ib.remarks as remarks,ib.bl_status as shipment,ib.status as status,ibn.shipper as shipper,      ibn.cnee as cnee,ibn.notify1 as notify1,ibn.notify2 as notify2,ibn.messers as messers,ibn.forwarder as forwarder,ibg.goods,ibg.marks,ibg.maincom as maincom,ibg.ttw as t_wgt,ibg.tgw as g_wgt, ibg.ttlpkgs as pkgs,ibg.ttlcbm as cbm,ibg.ttlnet as n_wgt FROM inward_bls ib inner join inward_bls_names ibn on ibn.bl_no=ib.bl_no left join inward_bls_goods ibg on ibg.bl_no=ib.bl_no where ib.bl_no=?;";
	
	public static final String GET_print ="select distinct ib.bl_no as blNo,to_char(ib.onboard_date,'dd/mm/yyyy')  as onBoard,ib.issue_place as issuePlace,to_char(ib.issue_date,'dd/mm/yyyy') as issueDate,ib.por as receiptAt,ib.pol as pol,ib.pod as pod,ib.pot as pot,ib.fpod as fpod,ib.no_of_bls as noBls,ib.reference as ref,ib.voyage_code as vslVoyage, pre_voyage_code as mvoyage,ib.agent_id as agent,ibn.shipper as shipper,ibn.cnee as cnee,ibn.notify1 as notify1,ibn.notify2 as notify2,ibg.goods,ibg.marks,ibg.tgw as g_wgt,ibg.ttlpkgs,ibg.ttlcbm as cbm FROM inward_bls ib inner join inward_bls_names ibn on ibn.bl_no=ib.bl_no left join inward_bls_goods ibg on ibg.bl_no=ib.bl_no where ib.bl_no=?;";
	
	public static final String GET_issueplaceforprint ="select concat(b.branch_short_name,'-',cm.short_name,'-',cm.country) as text from company_master cm inner join branch b on b.company_code=cm.company_code where b.branch_code=? order by text asc;";

	public static final String GET_branchforprint ="SELECT branch_name FROM branch where branch_code=?;";
	
	public static final String GET_portforprint ="SELECT portname FROM port_master where portcode=?;";
	
	public static final String GET_vessel ="select  tv.vesselname  from tb_voyage  tb inner join inward_bls vc  on vc.voyage_code=  tb.voyageno\n" + 
											"inner join tb_vessels tv on tv.vesselcode=tb.vesselid where bl_no=?;";
	
	public static final String GET_seqforprint ="SELECT count(*) as seqprint FROM print_view_seq where bl_no=? and print_status=? and unlock_status='Y'";
	
	public static final String insert_seqprint ="INSERT INTO print_view_seq (bl_no,customer,print_date, print_status) VALUES (?,?,now(),?);";
	
	public static final String GET_charges ="select bl_no,currency,sum(qty),sum(rate) as rate,sum(amount),sum(real_amount),sum(invoice_amount) from inward_charges where bl_no=? group by bl_no,currency;";
	
	public static final String GET_cntrchargesID ="select inward_cntrs_id as chargesId from inward_cntrs where bl_no=?;";

	public static final String GET_cntrcharges ="select inward_cntrs_charges_id as inwardContChargesId,charges_code as chargeCode,currency as currency,sum(unit_rate) as unit,sum(mea_rate) as meaRate,sum(wgt_rate) as wgRate,from_place as fromPlace,to_place as toPlace,sum(min_rate) as minRate,terms as terms,sum(real_amount) as realAmount from inward_cntrs_charges   where bl_no=? group by inward_cntrs_charges_id,charges_code,currency,from_place,to_place,terms";

	public static final String GET_ALL_CHARGES = "select string_agg(sur_name,',') as freight_charges,string_agg(currency,',') as currency,sum(qty) as unit,sum(rate) as rate,sum(amount) as amount from inward_charges  ic inner join surcharge_master sm on sm.sur_code=ic.charge_code where bl_no= ?";

	public static final String GET_CUST_NAME = "select cust_name from customer_master  where cust_code=? ";

	public static final String GET_Quot_Count = " select count(*) from outward_bls ob inner join shipment_hdr sh on sh.job_no=ob.job_no  "
  + " inner join sales_booking b on b.booking_no=sh.booking_no "
  + " where bl_no=? and quotation is not null";

}