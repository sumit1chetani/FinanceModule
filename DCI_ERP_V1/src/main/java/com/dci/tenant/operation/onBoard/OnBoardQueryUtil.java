package com.dci.tenant.operation.onBoard;

public class OnBoardQueryUtil {

	public static final String GET_Vessel_list=" select vesselcode as id,vesselcode||'-'||vesselname as text  from tb_vessels  where nullif(vesselcode,'') is not null order by vesselname ";

	public static final String GET_Voyage_list=" select voyageno as id,voyageno as text from tb_voyage where vesselid=? order by voyageno asc " ;

	
	public static final String Get_slot_list= "select vendor_code as id,vendor_name as text from vendor_master";
	public static String GetContainerData="select sj.jb_no_tcd jobNo,sj.vssl_vyg_tcd,prt_icd_nam pod,shcd.no_of_pckg_int noOfPkgs,hbl_no_tcd blNo,sj.booking_No bookingNo,container_number containerNo,srvc_prtnr_nam customerName,cntnr_sl_no_nam sealNo "
			+ ",ct.cntnr_sz_typ_cd containerType,to_char(gate_in_date,'dd/mm/yyyy') as gateInDate "
			+ " from sea_hbl sh  left  join "
			+ " sea_hbl_container_detail shcd on shcd.hbl_bin=sh.hbl_bin "
			+ " left join   sea_job sj    on sj.jb_bin=sh.jb_bin "
			+ " left join  (select * from gate_in_dtl  inner join  gate_in_hdr using (gate_in_no) where  type_list='Export') gate_in "
			+ " on  gate_in.booking_no=sj.booking_no  and gate_in.container_no::text=shcd.cntnr_no_cno::text "
			+ " left  join sea_hbl_cargo_detail shcd1 on shcd1.hbl_bin=sh.hbl_bin "
			+ " left join container_size_type ct on ct.cntnr_sz_typ_cd=shcd.cntnr_sz_typ_id "
			+ " left join service_partner sp on  sp.srvc_prtnr_bin=sh.cstmr_bin "
			+ "  left join port_icd pi on pi.prt_icd_id=sh.pod_id "
			+ "  left join container c on c.container_id::varchar=shcd.cntnr_no_cno "
			+ "  where  sj.vssl_vyg_tcd=? and sh.pol_id=? and (shcd1.vssl_vyg_tcd,container_number,hbl_no_tcd) not in (select  voyage_id, container_no,bl_no from tb_onboard_details right join tb_onboard on "
			+ "    tb_onboard.onboard_id = tb_onboard_details.onboard_id where container_no  is not null  ) order by hbl_no_tcd asc";
			public static String GetContainerData(OnBoardBean onBoardBean) {
		String vessel = "", voyage = "", port = "";
		if (onBoardBean.getVessel() == null || onBoardBean.getVessel().equals("null")) {
			vessel = "";
		} else {
			vessel = onBoardBean.getVessel();
		}
		if (onBoardBean.getVoyage() == null || onBoardBean.getVoyage().equals("null")) {
			voyage = "";
		} else {
			voyage = onBoardBean.getVoyage();
		}
		if (onBoardBean.getPort() == null || onBoardBean.getPort().equals("null")) {
			port = "";
		} else {
			port = onBoardBean.getPort();
		}
		String query = "  select * from vw_get_on_board_details1('" + vessel + "','" + voyage + "','" + port + "') where (voyage_id,containerno,blno) not in (select   voyage_id,container_no,bl_no from tb_onboard_details right join tb_onboard on    tb_onboard.onboard_id = tb_onboard_details.onboard_id where container_no  is not null  )";

			 
		 
		System.out.println(query);
		return query;
	}
	
	
	public static String GetContainerCount(OnBoardBean onBoardBean) {
		String vessel = "", voyage = "", port = "";
		if (onBoardBean.getVessel() == null || onBoardBean.getVessel().equals("null")) {
			vessel = "";
		} else {
			vessel = onBoardBean.getVessel();
		}
		if (onBoardBean.getVoyage() == null || onBoardBean.getVoyage().equals("null")) {
			voyage = "";
		} else {
			voyage = onBoardBean.getVoyage();
		}
		if (onBoardBean.getPort() == null || onBoardBean.getPort().equals("null")) {
			port = "";
		} else {
			port = onBoardBean.getPort();
		}
		String query1 = "  select * from vw_get_on_board_container_withCount('" + vessel + "','" + voyage + "','" + port + "')";
		
		System.out.println(query1);
		return query1;
	}
	
	public static final String check_vsl_arrival ="select case when count(*) =0 then true else false end as value from vesssel_arrival_hdr a inner join  vesssel_arrival_dtl b on b.vessel_arrival_id=a.vessel_arrival_id   and voyage_code =? and port_code= ?";

	public static final String get_dtl_id ="select onboard_details_id as onBoardId from tb_onboard_details where   onboard_id =?  ";

	public static final String delete_status ="delete from t_container_status where job_no= ?";
	
	public static final String SAVE_DETAIL_CONTAINER_STATUS="INSERT INTO t_container_status( container_id, container_type_id,cms_codes_id, status_date,vessel_id,voyage_id,pol_id, job_no, created_by, created_date, company_id,depot_id,pod_id,form_code,bl_no,booking_no) VALUES ( ?, ?, ?, to_timestamp(?,'dd/mm/yyyy hh24:mi'), ?,?,?,?, ?, now(), ?, ?,?,'F0108',?,?)";
	
	public static final String GET_CON_ID= "select container_id from container where container_number =?";
	public static final String GET_CON_ID_count= "select count(*) from container where container_number =?";

	public static final String GET_onboard_No  = " select ? || lpad( (coalesce(max( substring(onboard_id, 5)::int),0)+1)::text,5,'0') onboard_id from tb_onboard  where onboard_id like ? ";

	public static final String GET_onboard_Dtl_No  = " select ? || lpad( (coalesce(max( substring(onboard_details_id, 6)::int),0)+1)::text,6,'0') onboard_details_id from tb_onboard_details  where onboard_details_id like ? ";

	public static final String INSERT = "INSERT INTO tb_onboard( onboard_id, vessel_id, voyage_id, pol, pol_sequence, onboard_date,  created_by, created_date,mode,carrier) VALUES (?, ?, ?, ?, ?,to_timestamp(?,'dd/mm/yyyy hh24:mi'), ?, now(),?,?)";
	
	public static final String INSERT_Dtl = " INSERT INTO tb_onboard_details( onboard_details_id, onboard_id, bl_no, booking_no,container_type,container_no,pod,seal_no,package_type,no_of_boxes,slot_operator,cont_id,trans_leg,onboard_status_date,booking_type)   VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,to_timestamp(?,'dd/mm/yyyy hh24:mi'),?)";

	public static final String Get_List= " select a.created_by created_by,onboard_id onBoardId,vesselname vessel,voyage_id voyage,pol port,to_char(onboard_date,'dd/MM/yyyy  hh24:mi') as  onBoardDate  ,(select distinct booking_no from  tb_onboard_details b where  b.onboard_id= a.onboard_id limit 1) as bookingNo " +
			"	from tb_onboard a inner join tb_vessels on vesselcode=vessel_id  " ; 
	
	public static final String delete_hdr = " delete from tb_onboard where onboard_id = ? ";

	public static String getOnBoardDetails(String onBoardNo) {
		String query=" select ROW_NUMBER () OVER (ORDER BY b.onboard_details_id) as slno,a.onboard_id,vesselname vessel,a.voyage_id voyage,a.pol port,to_char(a.onboard_date,'dd/mm/yyyy') onBoardDate, 	 string_agg(b.bl_no,',') as blNo,	 b.booking_no bookingNo,b.container_type containerType,coalesce(c.is_soc,false) as soc,b.container_no containerNo,b.pod,b.seal_no sealNo,b.package_type packgeType,b.no_of_boxes noOfPkgs,cstmr_bin,srvc_prtnr_nam as customerName,	 b.slot_operator slotOperator,b.onboard_status_date as onboardStatusDate,trans_leg as leg ,emc.user_name as created_by ,to_char(a.CREATED_DATE,'dd/MM/yyyy')  as created_date from tb_onboard a left join tb_onboard_details b using(onboard_id) 	 left join tb_vessels on vesselcode=vessel_id 	 left join sea_job  sh on sh.jb_no_tcd=bl_no	  left join service_partner sp on srvc_prtnr_id=cstmr_bin ::varchar 	 left join user_master emc on emc.user_id = a.CREATED_BY 	 left join container c on c.container_id= b.cont_id  where a.onboard_id ='"+onBoardNo+"' 	 group by a.onboard_id,a.voyage_id,a.pol,vesselname,a.onboard_date,b.booking_no,b.container_type,b.container_no,b.pod,b.seal_no,b.package_type,b.no_of_boxes,srvc_prtnr_nam,b.slot_operator,b.onboard_status_date,c.is_soc,trans_leg,b.onboard_details_id,emc.user_name,a.CREATED_DATE,cstmr_bin order by trans_leg asc" ;
	 return query;
	}

	public static final String delete_dtl = " delete from tb_onboard_details where onboard_id = ? ";
/*
	public static String getOnBoardDetails(String onBoardNo) {
		String query="  select ROW_NUMBER () OVER (ORDER BY b.onboard_details_id) as slno,a.onboard_id,vesselname vessel,a.voyage_id voyage,a.pol port,to_char(a.onboard_date,'dd/mm/yyyy') onBoardDate,string_agg(b.bl_no,',') as blNo,b.booking_no bookingNo,b.container_type containerType,c.is_soc as soc,b.container_no containerNo,b.pod,b.seal_no sealNo,b.package_type packgeType,b.no_of_boxes noOfPkgs,client_id,(select cust_name from customer_master where cust_code= client_id union select agent_name from agent_master where agent_code = client_id) as customerName,cust_type customerType,b.slot_operator slotOperator,b.onboard_status_date as onboardStatusDate,trans_leg as leg ,emc.user_name as created_by ,to_char(a.CREATED_DATE,'dd/MM/yyyy')  as created_date from tb_onboard a inner join tb_onboard_details b using(onboard_id) \r\n" + 
				" left join tb_vessels on vesselcode=vessel_id \r\n" + 
				" left join outward_bls   using(bl_no)  \r\n" + 
				" left join customer_master on cust_code=client_id \r\n" + 
				" left join user_master emc on emc.user_id = a.CREATED_BY \r\n" + 
				" inner join container c on c.container_id= b.cont_id  where a.onboard_id ='"+onBoardNo+"' \r\n" + 
				" group by a.onboard_id,a.voyage_id,a.pol,vesselname,a.onboard_date,b.booking_no,b.container_type,b.container_no,b.pod,b.seal_no,b.package_type,b.no_of_boxes,cust_name,cust_type,b.slot_operator,b.onboard_status_date,c.is_soc,trans_leg,b.onboard_details_id,emc.user_name,a.CREATED_DATE,client_id order by trans_leg asc ";
		return query;
	}
	*/
	
	public static String getOnBoardDetailsMail="select a.onboard_id as onBoardId,vesselname vessel,a.voyage_id voyage,a.pol port,to_char(a.onboard_date,'dd/mm/yyyy HH24:MI') onBoardDate,string_agg(distinct b.bl_no,',') as blNo,string_agg(distinct b.booking_no,',') bookingNo,string_agg(distinct b.container_type,',') containerType,string_agg(concat(b.container_type,' - ',b.container_no),',') containerNo,string_agg(distinct b.pod,',') pod,(select cust_name from customer_master where cust_code= client_id union select agent_name from agent_master where agent_code = client_id) as customerName,(select email from customer_master where cust_code= client_id union select agent_email from agent_master where agent_code = client_id) as customerMail  from tb_onboard a inner join tb_onboard_details b using(onboard_id) left join tb_vessels on vesselcode=vessel_id  left join outward_bls   using(bl_no) left join customer_master on cust_code=client_id left join user_master emc on emc.user_id = a.CREATED_BY inner join container c on c.container_id= b.cont_id  where a.onboard_id=? group by a.onboard_id,a.voyage_id,a.pol,vesselname,a.onboard_date,client_id order by client_id asc";

	public static String GET_CONTAINERCOUNT="select container_type as ContainerCount,count(*) as ContainerTypeCount from tb_onboard_details where onboard_id =? group by container_type";


	public static String Check_GATE_IN_LADEN="select case when count(*)=0 then false else true end as check from sea_hbl_container_detail  oc "
			+ "inner join sea_hbl ob on ob.hbl_bin=oc.hbl_bin "
			+ "inner join sea_job sh on sh.jb_bin=ob.jb_bin inner join sea_job_tracking_detail sc on oc.cntnr_no_cno=sc.cntnr_no_cno  \n" + 
			"						inner join gate_out_dtl god on god.gate_out_dtl_id=sc.gate_out_dtl_id \n" + 
			"						inner join gate_out_hdr goh on goh.go_no=god.go_no_dtl   \n" + 
			"						inner join gate_in_hdr gih on gih.gate_out_no=goh.go_no   \n" + 
			"						inner join gate_in_dtl gid on gid.gate_in_no=gih.gate_in_no		where gid.container_no::int =? and  gid.empty_or_load='t' and sh.booking_no = ?";
	

	public static String Check_GATE_IN_EMPTY="select case when count(*)=0 then false else true end as check from sea_hbl_container_detail  oc inner join sea_hbl ob on ob.hbl_bin=oc.hbl_bin inner join sea_job sh on sh.jb_bin=ob.jb_bin inner join sea_job_tracking_detail sc on oc.cntnr_no_cno=sc.cntnr_no_cno  \n" + 
			"						inner join gate_out_dtl god on god.gate_out_dtl_id=sc.gate_out_dtl_id \n" + 
			"						inner join gate_out_hdr goh on goh.go_no=god.go_no_dtl   \n" + 
			"						inner join gate_in_hdr gih on gih.gate_out_no=goh.go_no   \n" + 
			"						inner join gate_in_dtl gid on gid.gate_in_no=gih.gate_in_no		where gid.container_no::int =?  and sh.booking_no = ?";
	
	
	public static String check_Onboard_status="select case when count(*) >0 then false else true end as value from tb_onboard where voyage_id = ? and pol =? ";
	
	public static String Check_Unallocated_Containers ="with bookno as ( \n" + 
			"			select distinct  booking_no,pol,pod,destination from booking where voyage =? and pol= ? order by booking_no \n" + 
			"			) \n" + 
			"			,gateoutcon as (  \n" + 
			"			select b.booking_no as bookingNo,crh.booking_no as croBookingNo,crh.depot as pol,gd.container_no as containerId,c.container_number as containerNo,gd.gate_out_dtl_id as gateoutDtlId from container_release_hdr crh  \n" + 
			"			inner join booking b on b.booking_no=crh.booking_no \n" + 
			"			inner join gate_out_hdr gh on gh.booking_no=crh.booking_no  \n" + 
			"			inner join gate_out_dtl gd on gd.go_no_dtl=gh.go_no  \n" + 
			"			inner join container c on c.container_id=gd.container_no::int \n" + 
			"			where crh.booking_no=b.booking_no \n" + 
			"			and gd.container_no::int in (select distinct container_id from t_container_status where container_status_id in (select max(container_status_id) from t_container_status group by container_id) and cms_codes_id in ('STS'))\n" + 
			"			) \n" + 
			"			,alloca as ( \n" + 
			"			select b.booking_no,b.pol,oc.cntr_no,c.container_number from outward_cntrs oc inner join outward_bls ob on oc.bl_no=ob.bl_no \n" + 
			"			inner join shipment_hdr sh on sh.job_no=ob.job_no \n" + 
			"			inner join bookno b on sh.booking_no=b.booking_no \n" + 
			"			inner join container c on c.container_id=oc.cntr_no::int \n" + 
			"			 order by b.booking_no \n" + 
			"			) \n" + 
			"			,unalloc as ( \n" + 
			"			select bookingNo,pol,containerId,containerNo,gateoutDtlId from gateoutcon where (containerId) not in (select container_number from alloca)   \n" + 
			"			) \n" + 
			"			,shipUnassign as ( \n" + 
			"			select b.booking_no,b.pol,oc.cntr_no,c.container_number,sc.gate_out_dtl_id as gateOutDtlId from outward_cntrs oc  \n" + 
			"			inner join outward_bls ob on oc.bl_no=ob.bl_no \n" + 
			"			inner join shipment_hdr sh on sh.job_no=ob.job_no \n" + 
			"			inner join shipment_cntrs sc on sh.job_no=sc.job_no \n" + 
			"			inner join bookno b on sh.booking_no=b.booking_no \n" + 
			"			inner join container c on c.container_id=sc.cntr_no::int \n" + 
			"			) \n" + 
			"			select concat('<br>',bookingNo ,'-',pol,'-',containerNo,'<br>') as bookingNo  from unalloc where gateoutDtlId not in (select gateOutDtlId from shipUnassign) group by bookingNo,pol,containerNo  order by bookingNo";

	public static String UPDATE_Onboard_DATE_IN_BL ="update outward_bls  set   onboard_date =to_timestamp(?,'dd/mm/yyyy hh24:mi') where voyage_code=? and pol=? and bl_no=?";


	public final static String gettingYear = "select (to_char(now(),'YY')) as year";
	
	public static final String GET_CSLTS_BL_details ="select distinct ob.bl_no as blNo,v.vesselname as vessel,b.voyage as voyage,b.pol as pol,b.pod as pod,b.fpod as fpod,(select to_char(etd,'dd/mm/yyyy hh:mm') as etd from voyage_port vp where vp.voyage_id=b.voyage and vp.from_port_id=b.pod and vp.port_sequence::text=(case when b.pod_seq='' then '0' else b.pod_seq end))  etd, v1.vesselname as connectVessel ,connect_voyagee as connectVoyage,bookingtype from outward_bls ob \r\n" + 
			"left join shipment_hdr sh on sh.job_no=ob.job_no\r\n" + 
			"left join booking b on b.booking_no=sh.booking_no \r\n" + 
			"inner join tb_vessels v on v.vesselcode=b.vessel\r\n" + 
			"left join tb_vessels v1 on v1.vesselcode=b.connect_vessel\r\n" + 
			" where  bookingtype in ('3','2') and ob.pod like '%AEJEA%'  and b.voyage = ?  and b.pol= ? order by blNo ";
	
	public static final String GET_CSLTS_container_dtls ="select distinct ob.bl_no as blNo,c.container_number as containerNo,c.container_type as containerType, Coalesce(gw,0) as gw from outward_bls ob \r\n" + 
			"left join shipment_hdr sh on sh.job_no=ob.job_no\r\n" + 
			"left join booking b on b.booking_no=sh.booking_no \r\n" + 
			"inner join outward_cntrs oc on oc.bl_no=ob.bl_no\r\n" + 
			"inner join container c on c.container_id=oc.cntr_no\r\n" + 
			" where bookingtype in ('3','2') and ob.pod like '%AEJEA%' and b.voyage = ?  and b.pol= ? order by blNo ";
	public static final String Get_port = "select string_agg(port,',') from tb_sof_1 where voyageid=?";
	public static final String Get_port_lisr= " select prt_icd_id as id,concat(prt_icd_cd,'-',prt_icd_nam) as text from port_icd where prt_icd_id in (?) order by prt_icd_nam  ";
	public static String vessel="select vesselname from tb_vessels where vesselcode=?";
	public static final String ports= " select prt_icd_cd from port_icd where prt_icd_id =?  ";

	public static final String GetContainerData_count = "with t as(select shcd1.vssl_vyg_tcd,prt_icd_nam pod,no_of_pckg_int noOfPkgs,hbl_no_tcd blNo,booking_No bookingNo,container_number containerNo,srvc_prtnr_nam customerName,cntnr_sl_no_nam sealNo,ct.cntnr_sz_typ_cd containerType   from sea_hbl sh left  join  sea_hbl_container_detail shcd on shcd.hbl_bin=sh.hbl_bin left join   sea_job sj    on sj.jb_bin=sh.jb_bin  left  join  sea_hbl_cargo_detail shcd1 on shcd1.hbl_bin=sh.hbl_bin  left join container_size_type ct on ct.cntnr_sz_typ_cd=shcd.cntnr_sz_typ_id left join service_partner sp on sp.srvc_prtnr_bin=sh.cstmr_bin left join port_icd pi on pi.prt_icd_id=sh.pod_id left join container c on c.container_id::varchar=shcd.cntnr_no_cno where  sj.vssl_vyg_tcd=? and sh.pol_id =? and (shcd1.vssl_vyg_tcd,container_number,hbl_no_tcd) not in        (select  voyage_id, container_no,bl_no from tb_onboard_details right join tb_onboard on tb_onboard.onboard_id = tb_onboard_details.onboard_id where container_no  is not null  ) order by hbl_no_tcd asc)select  containertype as containerCount, count(containerType) as containerTypeCount from t group by containertype";
	public static final String GetContainerData_count_liner = "with t as (select sh.voyage_code,prt_icd_nam pod,no_of_pkgs noOfPkgs,sh.bl_no blNo,booking_No bookingNo,container_number containerNo,srvc_prtnr_nam customerName,seal_no sealNo,c.container_type containerType  from outward_bls sh left join outward_cntrs shcd on shcd.bl_no=sh.bl_no left join shipment_hdr sj  on sj.job_no=sh.job_no  left join service_partner sp on sp.srvc_prtnr_bin::varchar=sh.client_id left join port_icd pi on pi.prt_icd_id::varchar =  sh.pod left join container c on  c.container_id=  shcd.cntr_no where sh.voyage_code=(select id::varchar from tb_voyage where voyageno=?)  and sh.pol ::int=? and ((select id::varchar from tb_voyage where voyageno=sh.voyage_code),container_number, sh.bl_no) not in (select voyage_id, container_no,bl_no from  tb_onboard_details right join tb_onboard on tb_onboard.onboard_id = tb_onboard_details.onboard_id  where container_no is not null ) order by sh.bl_no  asc)select containertype as containerCount, count (containerType) as containerTypeCount from t group by containertype";

	public static final String Get_bl = "select case when ( select null_or_empty(sh.hbl_bin::varchar) from sea_hbl sh where sh.hbl_no_tcd=dd.bl_no) is false then ( select sh.hbl_bin::varchar from sea_hbl sh where sh.hbl_no_tcd=dd.bl_no) else dd.bl_no end  blNo\r\n"
			+ " from discharge_dtl dd  where discharge_id  =? ";

	//public static String get_booking_no = "with a as ( select a.booking_no ,sum(coalesce(quantity,'0')::int) cntqty from sales_booking a join sales_booking_dtl using(booking_no ) group by a.booking_no ) select booking_no as id, booking_no as text from a where (a.booking_no,cntqty) in (select distinct(booking_no),count(booking_no) from gate_out_hdr where go_no = ?  and nullif(booking_no,'') is not null  group by booking_no )";
	
	public static String get_gatein_no = "select go_no as id,go_no as text from gate_out_hdr where booking_no = ?";

	public static String get_onBoard_excel = " select jb_no_tcd jobNo, coalesce(tbd.container_no,'') as container_no,coalesce(to_char(gid.gate_in_date,'DD-MM-YYYY'),'') gateInDate,coalesce(tbd.container_type,'') as container_type,'' as iso_code, coalesce((select srvc_prtnr_cd from service_partner  where srvc_prtnr_bin::text=qot.crrr_nam limit 1),'') as lineCode,coalesce((select prt_icd_cd from port_icd  where prt_icd_id=bcg.pol_id limit 1),'') as pol,coalesce((select prt_icd_cd from port_icd  where prt_icd_id=bcg.pod_id limit 1),'') as pod,bcg_con.grss_wght_nc as weight,coalesce(bcg_con.cntnr_sl_no_nam,'') as sealNo,'' as exVoyage,'' as forwarder,coalesce((select srvc_prtnr_nam from service_partner  where srvc_prtnr_bin=bcg.shppr_bin limit 1),'') as shipper,coalesce((select addrs1_add from service_partner  where srvc_prtnr_bin=bcg.shppr_bin limit 1),'') as shipperAddress,coalesce((select srvc_prtnr_nam from service_partner  where srvc_prtnr_bin=bcg.cnsgn_bin limit 1),'') as consignee,coalesce((select addrs1_add from service_partner  where srvc_prtnr_bin=bcg.cnsgn_bin limit 1),'') as consigneeAddress,'' as product,coalesce((select commodity from commodity  where commodity_code::text=bk.commodity limit 1),'') as commodity,coalesce((select prt_icd_cd from port_icd  where prt_icd_id=bcg.orgn_id limit 1),'') as origin,coalesce((select prt_icd_cd from port_icd  where prt_icd_id=bcg.dstntn_id limit 1),'') as destination,coalesce(sale_inv.sls_invc_no_tcd,'') as invoiceNo,coalesce(to_char(sale_inv.sls_invc_dt,'DD-MM-YYYY'),'') as invoiceDate,coalesce(sale_inv.ttl_amnt_nc,0) as invoiceAmount,'' as transporter,coalesce(truck.license_plate,'') as vehicleNo,'' as modeEntry, '' as LRNo,bcg_con.no_of_pckg_int as package,'' as packageType,coalesce((select uom_nam from uom where uom_id=bcg_con.uom_id),'') as uomName,coalesce(concat(bcg.hbl_no_tcd,' / ',to_char(bcg.hbl_dt,'DD-MM-YYYY')),'') as bcgNo,case when bcg_con.no_of_pckg_int is null then '' else coalesce(fx_numtowords(bcg_con.no_of_pckg_int),'') end as packagesInWords   \n" + 
			"from tb_onboard_details tbd  \n" + 
			"inner join tb_onboard tb on tb.onboard_id=tbd.onboard_id  \n" + 
			"left join gate_in_hdr gi on gi.booking_no=tbd.booking_no  \n" + 
			"left join gate_in_dtl gid on gid.gate_in_no=gi.gate_in_no and gid.container_no= (\n" + 
			"select case when (select true from container where container_id ::varchar=tbd.container_no and null_or_empty(container_bank_id::varchar) is false) then cb.container_id when (select true from container where container_id ::varchar=tbd.container_no  and null_or_empty(container_bank_id::varchar) is true)  then c.container_id end\n" + 
			"from container c\n" + 
			"left join container_bank cb on cb.container_id=c.container_bank_id \n" + 
			"left join container_onhiredtl cod on cod.container_id=c.container_id  where c.container_id ::varchar=tbd.container_no\n" + 
			")::varchar  \n" + 
			"left join sales_booking bk on bk.booking_no=tbd.booking_no  \n" + 
			"left join sea_job job on job.booking_no=tbd.booking_no  \n" + 
			"left join sea_hbl bcg on bcg.jb_bin=job.jb_bin  \n" + 
			"left join sea_hbl_container_detail bcg_con on bcg_con.hbl_bin=bcg.hbl_bin and bcg_con.cntnr_no_cno=(select case when  null_or_empty((select container_bank_id from container where container_bank_id in (select container_id from container  where container_number=tbd.container_no))::varchar) is false then (select container_bank_id from container where container_bank_id in (select container_id from container  where container_number=tbd.container_no)) else (select container_id from container  where container_number=tbd.container_no) end from container limit 1)::varchar  \n" + 
			"left join sea_quotation qot on qot.qttn_bin::text=bk.quotation  \n" + 
			"left join sea_sales_invoice sale_inv on sale_inv.jb_bin=job.jb_bin  \n" + 
			"left join plan_trip trip on trip.plan_trip_id::text=gi.trip_no  \n" + 
			"left join truck_master truck on truck.truck_id=trip.truck_trailer_mapping_id   where tb.onboard_id=? ";

	public static String checkDO="select count(*) from deliverorder where bl_no=?  ";

}
