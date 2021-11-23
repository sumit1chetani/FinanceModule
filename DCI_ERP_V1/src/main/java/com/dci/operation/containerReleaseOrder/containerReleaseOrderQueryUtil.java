package com.dci.operation.containerReleaseOrder;



import java.math.BigInteger;

public class containerReleaseOrderQueryUtil {
	
	
	public static final String GET_print= "SELECT crh.container_release_hdr_code as croNo, cm.cust_name as customerName, crh.booking_no as bookingNo,crh.cro_date closeDate,ve.vesselname as vessel,concat(ve.vesselname,'-',b.voyage) as vesselVoy,pm.portname as pol,pm1.portname as pod,de.portname as destinationName,cm.tel_num as tel, to_char(current_date,'dd/mm/yyyy') as confirmDate,com.address as address1 "
			+ "FROM container_release_hdr crh left join booking b on crh.booking_no=b.booking_no "
			+ "left join customer_master cm on cm.cust_code= crh.customer "
			+ "left join tb_vessels ve on b.vessel=ve.vesselcode "
			+ "left join tb_voyage vo on vo.voyageno=b.voyage "
			+ "left join port_master pm on pm.portcode=b.pol "
			+ "left join port_master pm1 on pm1.portcode=b.pod "
			+ "left join company_master com on com.company_code=(select company_code from company_user where user_id=?)"
			+ "left join port_master de on de.portcode=b.destination where crh.container_release_hdr_code =?";
	
	
	
	/*public static final String GET_print_CRO="SELECT crh.container_release_hdr_code as refNo, cm.cust_name as shipperName, crh.booking_no as bookingNo,crh.cro_date closeDate,ve.vesselname as vesselName,concat(ve.vesselname,'-',b.voyage) as voyageNo,pm.prt_icd_nam as pol,pm1.prt_icd_nam as pod,de.prt_icd_nam as destinationName,cm.tel_num as tel, to_char(current_date,'dd/mm/yyyy') as presentDate,com.address as address1 	FROM container_release_hdr crh \r\n" + 
			"left join sales_booking b on crh.booking_no=b.booking_no \r\n" + 
			"left join customer_master cm on cm.cust_code= crh.customer \r\n" + 
			"left join tb_vessels ve on b.vessel=ve.vesselcode \r\n" + 
			"left join tb_voyage vo on vo.voyageno=b.voyage \r\n" + 
			"left join port_icd pm on pm.prt_icd_id::text=b.pol \r\n" + Cde from company_user where user_id=? limit 1) \r\n" + 
			"left join port_icd de on de.prt_icd_id::text=b.destination where crh.booking_no =?";*/
	public static final String GET_print_CRO="select distinct TO_char(return_date,'dd/mm/yyyy') gateInDate,to_char((select sailed from tb_sof_1 where voyageid=voyage and b.pol=port limit 1),'DD/MM/YYYY') etasailDate,depot.prt_icd_nam depot,des.prt_icd_nam destination,C.commodity commodity,b.booking_no as bookingNo,to_char(booking_date + INTERVAL '2 day' ,'dd/mm/yyyy') as crodate,to_char(booking_date,'DD/MM/YYYY') as bookingDate,sq.qttn_no_tcd as quotation,agent as agent,b.customer as customer,customer_type as customerType, pi.prt_icd_nam polName,pd.prt_icd_nam podName,to_char((select eta from tb_sof_1 where voyageid=voyage and b.pod=port limit 1),'DD/MM/YYYY') as voyagePortETA, vessel as vessel,voyage as voyage,pol as pol,pod as pod,CU.SRVC_PRTNR_CD as custShrtName, b.shipper as shipperName,b.consignee as consigneeName,b.pol_seq  as polseq,CU.SRVC_PRTNR_NAM as customerName,v.vesselname as vesselName from SALES_booking  b left join SERVICE_PARTNER cu on  cu.SRVC_PRTNR_BIN::VARCHAR=b.customer left join tb_vessels v on  v.vesselcode=b.vessel left join container_release_hdr cro on cro.booking_no=b.booking_no left join port_icd pi on pi.prt_icd_id::VARCHAR=pol left join gate_in_hdr gih on gih.booking_no=b.booking_no left join port_icd pd on pd.prt_icd_id::VARCHAR=pod left join port_icd des on des.prt_icd_id::VARCHAR=destination left join sea_quotation sq on qttn_bin::VARCHAR=quotation left join port_icd depot on depot.prt_icd_id::VARCHAR=cro.depot	left join commodity C on commodity_CODE=B.commodity where cro.container_release_hdr_code=? ";
	
	/*--,to_char(b.eta_date ,'dd/mm/yyyy') as etasailDate,to_char(b.etd_date ,'dd/mm/yyyy') as etdsailDate,to_char(b.cutoff_date,'dd/mm/yyyy') as cutoffDate,b.haulier_code as haulierCode,b.haulier_name as haulierName,\n" + 
	"			--case when not null_or_empty(cro.depot) then cro.depot else b.cro_depot  end as depot"*/
	
	public static final String GET_print_CRO_dtl="select sb.booking_no as bookingNo,cont_type as  conType, case when cont_type in( 'R20','R40' ,'R40H') then true else false end as conflag, commodity as commodityName,quantity as quantity from sales_booking_dtl sb inner join container_release_hdr c on c.booking_no=sb.booking_no where c.container_release_hdr_code=? ";
	
	//+ "--,temp as temp,vent as vent,humidity as humidity "

	public static final String CONTAINER_COUNT= "with test as (select * from t_container_status cs inner join container c on c.container_id = cs.container_id where container_number=?) "
			+ "select count(*) from test where cms_codes_id='MTD' and container_status_id=(select max(container_status_id) from test)";
	
	public static final String CHK_DUP_CON="select count(*) from container_release_order_detail_container where container_id=?";
	
	public static final String RTS_COUNT= "with test as (select * from t_container_status cs inner join container c on c.container_id = cs.container_id where container_number=?) "
			+ "select count(*) from test where cms_codes_id='RTS' and container_status_id=(select max(container_status_id) from test)";
	
	public static final String RNS_COUNT= "with test as (select * from t_container_status cs inner join container c on c.container_id = cs.container_id where container_number=?) "
			+ "select count(*) from test where cms_codes_id='RNS' and container_status_id=(select max(container_status_id) from test)";
	
	public static final String GET_CUST_BOOKING = "select booking_no as id , booking_no as text from sales_booking where customer = ?  and nullif(cancel_by,'') is null  ";
	
	public static final String GET_CUST_POL_POD = "select pol,pod from booking  where booking_no =?";
	
	public static final String GENERATE_CONTAINER_CODE = "SELECT CASE WHEN MAX(container_release_hdr_code) IS NULL THEN 'CR00001' ELSE rpad(MAX(container_release_hdr_code),2,'CR')|| lpad(cast(cast((SUBSTRING(MAX(container_release_hdr_code),3)) as int) + 1 as text),5,'0') END quotationNo FROM container_release_hdr;";
	
	public static final String GENERATE_CONTAINER_CODE_DET ="SELECT CASE WHEN MAX(container_release_dtl_code) IS NULL THEN 'CD00001' ELSE rpad(MAX(container_release_dtl_code),2,'CD')|| lpad(cast(cast((SUBSTRING(MAX(container_release_dtl_code),3)) as int) + 1 as text),5,'0') END quotationNo FROM container_release_dtl";
	
	public static final String SAVE_CONTAINER_HDR = "INSERT INTO container_release_hdr(container_release_hdr_code, customer, booking_no,depot,cro_date,created_by, created_date)  VALUES (?,?, ?, ?,to_date(?,'dd/mm/yyyy'),?,now())";
	
	public static final String SAVE_CONTAINER_DTL = "INSERT INTO container_release_dtl(container_release_hdr_code, container_type,container_no, quantity, slno,container_release_dtl_code)VALUES (?, ?,?, ?,?,?)";
	
	public static final String UPDATE_CONTAINER_HDR ="UPDATE container_release_hdr SET  customer=?, booking_no=?, depot=?,cro_date=to_date(?,'dd/mm/yyyy'), modified_by=?, modified_date=now() WHERE container_release_hdr_code=?";


	public static final String DELETE_CONTAINER_HDR ="delete from container_release_hdr where container_release_hdr_code=?";
	
	public static String GET_CONTAINER_List =  "with temp as (SELECT crh.container_release_hdr_code as containerreleaseCode, cm.srvc_prtnr_nam as customer,count(cd.container_release_hdr_code) as c1, " 
			+" count(gd.go_no_dtl) as c2,count(gdtl.gate_in_no) as c3, crh.booking_no as bookingCode,pm.prt_icd_nam depot,gh.go_no as gateOutNo,gi.gate_in_no as  gateInNo, crh.depot as depo " 
			+" FROM container_release_hdr crh   " 
			+" left join container_release_dtl cd on cd.container_release_hdr_code =crh.container_release_hdr_code " 
			+"  left join gate_out_hdr gh on gh.cro_no=crh.container_release_hdr_code " 
			+" left join gate_out_dtl gd on gd.go_no_dtl=gh.go_no " 
			+" left join gate_in_hdr gi on  gi.gate_out_no=gh.go_no " 
			+" left join gate_in_dtl gdtl on  gdtl.gate_in_no=gi.gate_in_no " 
			+" left join service_partner cm on cm.srvc_prtnr_bin::text=crh.customer  " 
			+" left join port_icd pm on pm.prt_icd_id::text=crh.depot  " 
			+" group by containerreleaseCode,cm.srvc_prtnr_nam,bookingCode,pm.prt_icd_nam,gh.go_no,gi.gate_in_no " 
			+" order by crh.container_release_hdr_code desc) " 
			  
			+" select *,case when c1=c2 then 'COMPLETED' else 'PENDING' END as gateOutStatus,case when c1=c3 then 'COMPLETED' else 'PENDING' END as gateInStatus from temp ";
	
	public static final String DELETE_CONTAINER_DTL="delete from container_release_dtl where container_release_hdr_code=?";
	
	public static final String DELETE_SEAL_DTL="delete from container_release_seal_dtl where container_release_hdr_code =?";
	
	
	public static final String DELETE_INNER_DTL="DELETE FROM container_release_order_detail_container WHERE container_release_hdr_code=?";
	
	public static final String Edit_dtl="SELECT  container_type as conType,container_no as conNumber, quantity FROM container_release_dtl where container_release_hdr_code=?";
	
	public static final String Edit_Seal="SELECT seal_no_from as sealFrom, seal_no_to as sealTo, no_of_container as count  FROM container_release_seal_dtl where container_release_hdr_code =?";
			
			public static final String edit_hdr="SELECT container_release_hdr_code as containerreleaseCode, customer, booking_no as bookingNo,depot as depot,to_char(cro_date,'dd/mm/yyyy') as croDate FROM container_release_hdr where container_release_hdr_code=?";
			
			public static final String edit_inner_dtl="select release_order_detail_id as containerRelID, container_type_id as containertype, container_id as containerNo,seal_no as sealNo, to_char(release_date,'dd/mm/yyy') as releaseDate, to_char(return_date,'dd/mm/yyy') as returnDate, return_depot as returnDepot, is_empty_return as isempty,in_bound_mode as inBoundMode ,out_bound_mode as outBoundMode from container_release_order_detail_container where release_order_detail_id=?";;
			
			
			public static final String SAVE_DETAIL_CONTAINER="INSERT INTO container_release_order_detail_container(slno, release_order_detail_id, container_type_id, container_id,seal_no,created_by, created_date, company_id, release_date, return_date, return_depot, is_empty_return,container_release_hdr_code,in_bound_mode,out_bound_mode) VALUES (?, ?, ?, ?, ?, ?, now(), ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ?, ?,?,?,?)";
			
			
			public static final String SAVE_DETAIL_CONTAINER_STATUS="INSERT INTO t_container_status( container_id, container_type_id,cms_codes_id, status_date, pol_id, pod_id, job_no, created_by, created_date, company_id,depot_id, form_code) VALUES ( ?, ?, ?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, now(), ?, ?, ?)";
			
			
			public static final String GET_CONTAINER_ID="select container_id from container where container_number=?";
			
			public static final String SAVE_DETAIL_SEAL="INSERT INTO container_release_seal_dtl(seal_no_from, seal_no_to, no_of_container, slno, container_release_hdr_code) VALUES (?, ?, ?, ?, ?)";


	
	
	///////////////////////

	public static final String GENERATE_QUOTATION_NO = "SELECT CASE WHEN MAX(quotation_no) IS NULL THEN 'QC00001' ELSE rpad(MAX(quotation_no),2,'QC')|| lpad(cast(cast((SUBSTRING(MAX(quotation_no),3)) as int) + 1 as text),5,'0') END quotationNo FROM quotation_hdr";
	
	
	public static final String SAVE_QUOTATION_HDR = "INSERT INTO container_release_hdr(container_release_hdr_code, customer, booking_no, pol, pod)  VALUES (?, ?, ?, ?, ?);";
	
	
	
	public static String GET_Quotation_List = "SELECT container_release_hdr_code as containerreleaseCode, customer, booking_no as bookingCode, pol, pod FROM container_release_hdr";
	
	public static String EDIT_HDR =  "SELECT quotation_no as quotationNo, agre_party_id as customer, pol_id as pol, pod_id as pod,to_char(quotation_date,'dd/mm/yyyy') as quotationDate, to_char(valid_till,'dd/mm/yyyy') as validTill,origin_id as origin,dropoff_mode as dropoff,remarks as shipmentTerm,currency_code as currencyName  FROM quotation_hdr where quotation_no=?";
	
	public static String EDIT_DTL="SELECT container_type_code as conType,charge_type_code as chargeType, quoted_rate as quotedRate FROM quotation_dtl where quotation_no=?";

	
	
	public static final String UPDATE_QUOTATION_HDR = "UPDATE quotation_hdr SET  agre_party_id=?, pol_id=?, pod_id=?,quotation_date=to_date(?,'dd/mm/yyyy'),valid_till=to_date(?,'dd/mm/yyyy'), modified_by=?, modified_date=now(), company_id=?,origin_id=?,dropoff_mode=?, "
	+ "remarks=?,currency_code=? WHERE quotation_no=?";

	
	public static final String Delete_Quotation_Dtl = "delete from quotation_dtl WHERE quotation_no=?";
	
	public static final String Delete_Quotation_Hdr = "delete from quotation_hdr WHERE quotation_no=?";
	
	
	public static final String GET_CUSTOMER_ADD ="select address from customer_master where cust_code=?";
	
	////////////////////////////////////////////

	
	
	
	
	
	public static final String Update_Booking_status = "update booking set quotation_no  = ?,status = ? where booking_id=? ";
	public static final String Get_Employee_list = "select emp_id as id,concat(emp_id,'-',emp_name) as text from employee_master where emp_id like '%E%' order by id";
	public static final String Get_Charge_Head_list = "select chrg_hd_id as id,concat(chrg_hd_cd,'-',chrg_hd_nam) as text from charge_head where actv_bt='1'  and chrg_hd_grp_id = 1";
	public static final String Get_Terms = "select trm_id as id,trm_cd as text from terms";
	public static final String INSERT_QUOTATION_DTL = "insert into sea_quotation_detail(qttn_bin,chrg_hd_id,unt_id,qty_int_qty,rt_nc,crrncy_id,pymnt_md_id,trnsctn_typ_id,prty_bin,nts_vcr,qttn_chrg_dtl_bin)  values(?,?,?,?,?,?,?,?,?,?,?) returning  qttn_chrg_dtl_bin";
	public static final String QUOTATION_HD_ID = "SELECT CASE WHEN MAX(qttn_bin) IS NULL THEN '1'  ELSE  MAX(qttn_bin)+1 END As QHdId FROM sea_quotation ";
	public static final String QUOTATION_DTL_ID = "SELECT CASE WHEN MAX(qttn_chrg_dtl_bin) IS NULL THEN '1'  ELSE  MAX(qttn_chrg_dtl_bin)+1 END As QDtlId FROM sea_quotation_detail ";
	
	public static final String QUOTATION_DRAFT_DTL_ID = "SELECT CASE WHEN MAX(qttn_chrg_dtl_bin) IS NULL THEN '1'  ELSE  MAX(qttn_chrg_dtl_bin)+1 END As QDtlId FROM sea_quotation_detail_tmp ";

	
	public static final String QUOTATION_DRAFT_HD_ID = "SELECT CASE WHEN MAX(qttn_bin) IS NULL THEN '1'  ELSE  MAX(qttn_bin)+1 END As QHdId FROM sea_quotation_tmp  ";

	public static final String Get_Unit = "select unt_id as id,concat(unt_cd,'-',unt_nam) as text  from unit ";
	public static final String Get_Hdr_Sea_Quotation = "select aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,sp.srvc_prtnr_nam as custName,(select concat(prt_icd_cd,'-',prt_icd_nam)  from port_icd ia where ia.prt_icd_id =aq.pol_id) as aolName,   (select concat(prt_icd_cd,'-',prt_icd_nam)  from port_icd ia where ia.prt_icd_id =aq.pod_id) as aodName,(select concat(prt_icd_cd,'-',prt_icd_nam)  from port_icd ia where ia.prt_icd_id =aq.orgn_id) as originName,   to_char(aq.crtd_dt,'dd/mm/yyyy') as createdOn,to_char(aq.mdfd_dt,'dd/mm/yyyy')as modifiedOn,aq.crtd_by as createdBy,aq.mdfd_by as modifiedBy,  (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.dstntn_id) as destinationName,knd_attntn_vcr as attention,    to_char(aq.vldty_dt,'dd/mm/yyyy') as validityDate,cmmdty_nam as commodityName,rmrks_vcr as remarks,tm.trm_nam as termName,br.addrss1 as address1,br.addrss2 as address2, br.addrss3 as address3,br.gstn_no as gstnNo,sp.addrs1_add as custAddress1,sp.addrs2_add as custAddress2,sp.addrs3_add as custAddress3 ,sp.addrs4_add as custAddress4,(select enm_nam from enum e where e.enm_cd::int=aq.qttn_srvc_id and enm_typ_nam='SERVICE TYPE')  as serviceType   from sea_quotation aq    inner join service_partner sp on sp.srvc_prtnr_bin=aq.cstmr_bin  inner join terms tm on tm.trm_id=aq.trm_id   inner join branch br on br.brnch_id=aq.brnch_id where aq.qttn_bin=? order by quotationId desc";
	public static final String Get_Dtl_Sea_Quotation = "select ch.chrg_hd_nam as chargeHead,sqd.qty_int_qty as quantityCount,un.unt_nam as unitName,sqd.rt_nc as rate,crrncy_cd as currencyName,nts_vcr as note from sea_quotation_detail sqd "
			+ " inner join charge_head ch on ch.chrg_hd_id=sqd.chrg_hd_id "
			+ " inner join unit un on un.unt_id=sqd.unt_id "
			+ " inner join currency cu on cu.crrncy_id=sqd.crrncy_id "
			+ " where sqd.qttn_bin=? and sqd.trnsctn_typ_id =2";
	public static final String Update_SEA_QUOTATION = "update sea_quotation set qttn_no_tcd=?,knd_attntn_vcr=?,crrr_nam=?,rmrks_vcr=?,qttn_dt=to_date(?,'dd/mm/yyyy'),sls_prsn_nam=?,trms_cndtns=?,vldty_dt=to_date(?,'dd/mm/yyyy'),pod_id=?,pol_id=?,brnch_id=?,cnsgn_bin=?,brnch_crrncy_id=?, cstmr_bin=?,dstntn_id=?,assgnd_by=?,orgn_id=?,sls_typ_id=?,qttn_srvc_id=?,shppr_bin=?,trm_id=?,vndr_bin=?,cmmdty_nam=?,vssl_vyg_tcd=?,qttn_md_id=?,mdfd_by= ?,mdfd_dt=now(),jb_stts_bt='0',dimension_name=? where qttn_bin= ?";



	public static final String GET_SEA_QUOTATION_Edit = "select dimension_name as dimensionName,aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,aq.qttn_md_id as mode,aq.qttn_srvc_id as service,   "
			+ " aq.brnch_id as branch,aq.cstmr_bin as customer,aq.assgnd_by as nominatedBy,aq.shppr_bin as shipper,aq.cnsgn_bin as consignee,aq.pol_id as aol,aq.pod_id aod,aq.orgn_id as origin,aq.dstntn_id as destination,   "
			+ " aq.sls_prsn_nam as salesPerson,  "
			+ " aq.sls_typ_id as salesType,aq.trms_cndtns as termConditions,   "
			+ " aq.knd_attntn_vcr as attention,aq.crrr_nam as carrier,aq.vndr_bin as vendor,aq.trm_id as term,aq.brnch_crrncy_id as currency,aq.jb_stts_bt,   "
			+ " 			   to_char(aq.vldty_dt,'dd/mm/yyyy') as validityDate,vssl_vyg_tcd as vessel,cmmdty_nam as commodity,rmrks_vcr as remarks  "
			+ " 			             from sea_quotation aq  where aq.qttn_bin=?";

	
	public static final String GET_SEA_QUOTATION_Dtl_Edit = "select qttn_chrg_dtl_bin as quotationDtlId,qttn_bin as quotationId,chrg_hd_id as chargeHeads,unt_id as unit,rt_nc as rate,qty_int_qty as qty,crrncy_id as currency,pymnt_md_id as paymentMethod,trnsctn_typ_id as transactionType,prty_bin as buySell ,nts_vcr as note from sea_quotation_detail  where  qttn_bin=?";

	
	

	//public static final String GET_SEA_QUOTATION_Dtl_View = "select qttn_chrg_dtl_bin as quotationDtlId,qttn_bin as quotationId,chrg_hd_id as chargeHeads,unt_id as unit,rt_nc as rate,qty_int_qty as qty,crrncy_id as currency,pymnt_md_id as paymentMethod,trnsctn_typ_id as transactionType,prty_bin as buySell ,nts_vcr as note from sea_quotation_detail  where  qttn_bin=?";

	public static final String GET_SEA_QUOTATION_Dtl_View = "select qttn_chrg_dtl_bin as quotationDtlId,qttn_bin as quotationId,ch.chrg_hd_id as chargeHeads,ch.chrg_hd_nam as chargeHeads1 ,u.unt_id as unit,u.unt_nam as unitName,rt_nc as rate,qty_int_qty as qty,c.crrncy_id as currency,c.crrncy_nam as currencyName,(select enm_nam from enum e where e.enm_cd::varchar=sqd.pymnt_md_id::varchar and enm_typ_id=6)as paymentMethod1,(select enm_nam from enum e where e.enm_cd::varchar=sqd.trnsctn_typ_id::varchar and enm_typ_id=7)as transactionType1,prty_bin as buySell ,sp.srvc_prtnr_nam as partyBin,nts_vcr as note from sea_quotation_detail sqd left join charge_head ch on ch.chrg_hd_id = sqd.chrg_hd_id left join unit u on u.unt_id = sqd.unt_id left join currency c on c.crrncy_id=sqd.crrncy_id left join service_partner sp on sp.srvc_prtnr_bin= sqd.prty_bin where qttn_bin=?";

	
	
	/*
	public static final String GET_SEA_QUOTATION_View = "select dimension_name as dimensionName,aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,aq.qttn_md_id as mode,aq.qttn_srvc_id as service,   "
			+ " aq.brnch_id as branch,aq.cstmr_bin as customer,aq.assgnd_by as nominatedBy,aq.shppr_bin as shipper,aq.cnsgn_bin as consignee,aq.pol_id as aol,aq.pod_id aod,aq.orgn_id as origin,aq.dstntn_id as destination,   "
			+ " aq.sls_prsn_nam as salesPerson,  "
			+ " aq.sls_typ_id as salesType,aq.trms_cndtns as termConditions,   "
			+ " aq.knd_attntn_vcr as attention,aq.crrr_nam as carrier,aq.vndr_bin as vendor,aq.trm_id as term,aq.brnch_crrncy_id as currency,aq.jb_stts_bt,   "
			+ " 			   to_char(aq.vldty_dt,'dd/mm/yyyy') as validityDate,vssl_vyg_tcd as vessel,cmmdty_nam as commodity,rmrks_vcr as remarks  "
			+ " 			             from sea_quotation aq  where aq.qttn_bin=?";	
	*/
	
	public static final String GET_SEA_QUOTATION_View = "select dimension_name as dimensionName,aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,aq.qttn_md_id as mode,aq.qttn_srvc_id as service,aq.brnch_id as branch,br.brnch_id as id,concat(brnch_cd,'-',brnch_nam) as branchName,aq.cstmr_bin as customer,sp2.acct_head_code as id, concat(sp2.srvc_prtnr_cd,'-',sp2.srvc_prtnr_nam) as customer1,aq.assgnd_by as nominatedBy,sp1.srvc_prtnr_bin as id,concat(sp1.srvc_prtnr_cd,'-',sp.srvc_prtnr_nam) as nominatedBy1,aq.shppr_bin as shipper, sp1.srvc_prtnr_bin as id,concat(sp1.srvc_prtnr_cd,'-',sp.srvc_prtnr_nam) as shipper1,  aq.cnsgn_bin as consignee,aq.pol_id as aol,pic.prt_icd_id as id,concat(pic.prt_icd_cd,'-',pic.prt_icd_nam) as policdName,aq.pod_id aod,concat(pic1.prt_icd_cd,'-',pic1.prt_icd_nam) as aod1,aq.orgn_id as origin,concat(pic.prt_icd_cd,'-',pic.prt_icd_nam) as orginName,dstntn_id as destination,concat(por.prt_icd_cd,'-',por.prt_icd_nam) as destination1, aq.sls_prsn_nam as salesPerson,emp_id as id,concat(emp_id,'-',emp_name) as salesPerson1,  tr.trm_cd as termName,  aq.sls_typ_id as salesType,(select enm_nam from enum e where e.enm_cd::varchar=aq.sls_typ_id::varchar and enm_typ_nam='SALES TYPE')as salesType1,  aq.trms_cndtns as termConditions,aq.knd_attntn_vcr as attention,aq.crrr_nam as carrier,aq.vndr_bin as vendor,aq.trm_id as term,tr.trm_cd as term1,aq.brnch_crrncy_id as currency,cr.crrncy_id as id,concat(crrncy_cd,'-',crrncy_nam) as currencyName,aq.jb_stts_bt,			  			   to_char(aq.vldty_dt,'dd/mm/yyyy') as validityDate,vssl_vyg_tcd as vessel,cmmdty_nam as commodity,rmrks_vcr as remarks 			  			             from sea_quotation aq  left join branch br on br.brnch_id=aq.brnch_id  left join currency cr on cr.crrncy_id = aq.brnch_crrncy_id left join port_icd pic on pic.prt_icd_id=aq.pol_id left join  port_icd pic1 on pic1.prt_icd_id=aq.pod_id left join terms tr on tr.trm_id=aq.trm_id  left join service_partner sp on sp.srvc_prtnr_bin= aq.cstmr_bin left join service_partner sp1 on sp1.srvc_prtnr_bin =aq.shppr_bin left join  service_partner sp2 on sp2.srvc_prtnr_bin = aq.cstmr_bin left join employee_master em on em.emp_id= aq.sls_prsn_nam  left join port_icd por on por.prt_icd_id=aq.dstntn_id where aq.qttn_bin=?";	
 
   
       
			
			 
			
			
			
	
	
	
	
	public static final String PORT_LIST = "select prt_icd_id as id,concat(prt_icd_cd,'-',prt_icd_nam) as text from port_icd where actv_bt ='1'";
	public static final String Delete_Sea_Quotation = "delete from sea_quotation where qttn_bin=?";
	public static final String INSERT_QUOTATION_DTL_DRAFT = "insert into sea_quotation_detail_tmp(qttn_bin,chrg_hd_id,unt_id,qty_int_qty,rt_nc,crrncy_id,pymnt_md_id,trnsctn_typ_id,prty_bin,nts_vcr,qttn_chrg_dtl_bin)  values(?,?,?,?,?,?,?,?,?,?,?) returning  qttn_chrg_dtl_bin";
	public static String GET_LIST = "select quotation_no quotation,to_char(quotation_dt,'dd/mm/YYYY') dataOfIssues,mlo_short_name customer,quotation_type quotationType,trip_no tripNo from quotation inner join mlo_master on customer_id=mlo_code  where active='Y' order by created_dt desc";
	public static String QUOTATION_NO = "SELECT CASE WHEN MAX(qttn_no_tcd) IS NULL THEN 'QO1000'  ELSE  'QO' ||    (max(to_number(substr(qttn_no_tcd,3),'999999999999'))+1) END As Quotation FROM sea_quotation   where qttn_no_tcd like 'QO%'";
	public static String CHECK_QUOTATION_EXISTS = "select count(*) from sea_quotation where qttn_no_tcd=?";
	public static String INSERT_QUOTATION = "insert into sea_quotation(qttn_no_tcd,knd_attntn_vcr,crrr_nam,rmrks_vcr,qttn_dt,sls_prsn_nam,trms_cndtns,vldty_dt,pod_id,pol_id,brnch_id,cnsgn_bin,brnch_crrncy_id, cstmr_bin,dstntn_id,assgnd_by,orgn_id,sls_typ_id,qttn_srvc_id,shppr_bin,trm_id,vndr_bin,cmmdty_nam,qttn_bin,qttn_md_id,crtd_by,mdfd_by,crtd_dt,mdfd_dt,jb_stts_bt,vssl_vyg_tcd,dimension_name)values (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,?,?,now(),now(),'0',?,?) returning qttn_bin";
	
	public static String INSERT_QUOTATION_DRAFT = "insert into sea_quotation_tmp(qttn_no_tcd,knd_attntn_vcr,crrr_nam,rmrks_vcr,qttn_dt,sls_prsn_nam,trms_cndtns,vldty_dt,pod_id,pol_id,brnch_id,cnsgn_bin,brnch_crrncy_id, cstmr_bin,dstntn_id,assgnd_by,orgn_id,sls_typ_id,qttn_srvc_id,shppr_bin,trm_id,vndr_bin,commodity_id,qttn_bin,qttn_md_id,crtd_by,mdfd_by,crtd_dt,mdfd_dt,jb_stts_bt,vssl_vyg_tcd )values (?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,2,?,?,now(),now(),'0',?) returning qttn_bin";

	public static String INSERT_QUOTATION_PORT_PAIR = "insert into quotation_port_pair (quotation_no,qpp_id,pol,pod,currency,valid_from,valid_till,created_by,created_dt,active) values (?,?,?,?,?,to_date(?,'dd/mm/YYYY'),to_date(?,'dd/mm/YYYY'),?,now(),'Y')";
	public static String INSERT_QUOTATION_PORT_PAIR_WEIGHT = "insert into quotation_port_pair_weight (quotation_no,qpp_id,weight_qpp_id,from_weight,to_weight) values (?,?,?,?,?)";

	public static String INSERT_QUOTATION_PP_WEIGHT_CHARGES = "  insert into quotation_weight_charges (quotation_no,qpp_id,weight_qpp_id,charge_id,m20,m40,d20,d40) values (?,?,?,?,?,?,?,?)";

	public static String GET_QUOTATION = "select quotation_no quotation,to_char(quotation_dt,'dd/mm/YYYY') dataOfIssues,customer_id customer,quotation_type quotationType,trip_no tripNo,quotation_img as quotationDocUrl from quotation   where quotation_no=?";

	public static String GET_QUOTATION_PP = "select quotation_no as quotation,qpp_id as id,pol,pod,currency,to_char(valid_from,'dd/mm/YYYY') validFrom,to_char(valid_till,'dd/mm/YYYY') validTill from quotation_port_pair where quotation_no=?";

	public static String GET_QUOTATION_PP_WEIGHT = "select quotation_no  as quotation,qpp_id as id,weight_qpp_id as wid,from_weight fromweight,to_weight  toweight from quotation_port_pair_weight where quotation_no=? and qpp_id=?";

	public static String GET_QUOTATION_PP_WEIGHT_CHARGES = "select quotation_no  as quotation,qpp_id as id,weight_qpp_id as wid,chargetypecode||'-'||chargetypename as type,m20,m40,d20,d40  from quotation_weight_charges,chargetype where chargetype_id::text=charge_id::text and quotation_no=? and qpp_id=? and weight_qpp_id=?";

	public static String GET_Branch = "select brnch_id as id,concat(brnch_cd,'-',brnch_nam) as text from branch b inner join company_user cu on cu.company_code=b.company_code where cu.user_id=?";

	public static String DELETE_QUOT_PP = "delete from quotation_port_pair where quotation_no=? ";

	public static String DELETE_QUOT_PP_WT = "delete from quotation_port_pair_weight where quotation_no=? ";

	public static String DELETE_QUOT_PP_WT_CHARGE = "delete from quotation_weight_charges where quotation_no=? ";

	public static String UPDATE_QUOTATION = "update quotation set quotation_dt=to_date(?,'dd/mm/YYYY'),customer_id=?,quotation_type=?,trip_no=?,remarks=?,modified_by=?,modified_dt=now(),active='Y',quotation_img=? where quotation_no=? ";

	public static String ACTIVE_QUOTATION = "update quotation set modified_by=?, modified_dt=now(),active='N' where quotation_no=? ";

	public static String CHARGES_ID = "select chargetype_id   from chargetype where chargetypecode||'-'||chargetypename=?";

	public static String APPROVE_QUOTATION = "update quotation set approved_by=?, approved_dt=now() where quotation_no=? ";

	public static String IATA_LIST = "select iata_id as id,iata_cd as text from iata ";

	public static String GET_CURRENCY = "select crrncy_id as id,concat(crrncy_cd,'-',crrncy_nam) as text from currency";

	public static String Get_Service_Partner = "select srvc_prtnr_bin as id,concat(srvc_prtnr_cd,'-',srvc_prtnr_nam) as text from service_partner";

	public static String Get_Service_Partner_Type = "select dflt_typ_id as id,dflt_typ_nam as text from service_partner_type";

	public static String Get_Employee = "select emp_id as id,concat(emp_id,'-',emp_name) as text from employee_master order by id";

	public static String INSERT_FILES = "insert into sea_quotation_files(quotation_no,file_name,file_path) values(?,?,?)";

	//public static String GET_Quotation_List = "select aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,sp.srvc_prtnr_nam as custName,(select concat(prt_icd_cd,'-',prt_icd_nam)  from port_icd ia where ia.prt_icd_id =aq.pol_id) as aolName,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pod_id) as aodName,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.orgn_id) as originName,to_char(aq.crtd_dt,'dd/mm/yyyy') as createdOn,to_char(aq.mdfd_dt,'dd/mm/yyyy')as modifiedOn,(select emp_name from employee_master em where em.emp_id=aq.crtd_by) as createdBy,(select emp_name from employee_master em where em.emp_id=aq.mdfd_by) as modifiedBy,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.dstntn_id) as destinationName from sea_quotation aq inner join service_partner sp on sp.srvc_prtnr_bin=aq.cstmr_bin order by quotationId desc";
	

	
	public static String getQuotBranch="select concat((select brnch_cd  from branch where brnch_id=?),'/S',?) as quotBranch";
	
	public static String getQuotCount(String quotationBranch){
		String data="";
		data="select coalesce ((select SPLIT_PART(qttn_no_tcd,'/','4') :: int as  count from sea_quotation pt  "
 +" where qttn_no_tcd like '%"+quotationBranch+"%' order by count desc limit 1),'0') as count";
		return data;
	}
	
	public static String getQuotCountUpdate(String quotationBranch,BigInteger QId){
		String data="";
		
		
		data="select coalesce ((select SPLIT_PART(qttn_no_tcd,'/','4') :: int as  count from sea_quotation pt  "
 +" where  qttn_bin !="+QId+" and qttn_no_tcd like '%"+quotationBranch+"%' order by count desc limit 1),'0') as count ";
				
			//	+ "select count(*) as count from sea_quotation where qttn_no_tcd like '%"+quotationBranch+"%' and qttn_bin="+QId;
		return data;
	}
	
	public static final String Delete_Sea_Quotation_tmp_Dtl = "delete from sea_quotation_detail_tmp where qttn_bin=?";

	public static final String Delete_Sea_Quotation_tmp = "delete from sea_quotation_tmp where qttn_bin=?";
	public static final String Get_Uom_List = "select enm_cd as id,enm_nam as text from enum where enm_typ_id=16";

	public static String DateandYear="select concat((select to_char(now(),'mm')),(select to_char(now(),'yy'))) as dateYear";
	
	public static String Get_File_Name_List="SELECT file_name  FROM  sea_quotation_files qf inner join sea_quotation aq on aq.qttn_no_tcd=qf.quotation_no where qttn_bin=?";

	public static String delete_FILES="delete from sea_quotation_files where quotation_no=?";
	
	public static String delete_FILENAME="delete from sea_quotation_files ";
	
	public static String getcommodity="select commodity_id as id,commodity_name as text from commodity_master order by commodity_name asc";
	
	public static String SET_IMAGE_LIST="select commodity_id as id,commodity_name as text from commodity_master order by commodity_name asc";
	
	public static final String FILE_LIST="select  file_name as fileName,file_path as filePath from sea_quotation_files where quotation_no= ?";
	
	public static String GET_FILES="select file_path as filePath from sea_quotation_files where quotation_no = ?";

	public static final String dummy = "select qttn_no_tcd from sea_quotation where qttn_bin  = ?";
	
	public static final String GET_Dept_NO="select dept as deptNo from employee_master where emp_id=?";
	
	public static final String GET_Quotation_List_Admin="select aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,sp.srvc_prtnr_nam as custName,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pol_id) as aolName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pod_id) as aodName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.orgn_id) as originName, to_char(aq.crtd_dt,'dd/mm/yyyy') as createdOn,to_char(aq.mdfd_dt,'dd/mm/yyyy')as modifiedOn,(select emp_name from employee_master em where em.emp_id=aq.crtd_by) as createdBy,(select emp_name from employee_master em where em.emp_id=aq.mdfd_by) as modifiedBy,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.dstntn_id) as destinationName from sea_quotation aq inner join service_partner sp on sp.srvc_prtnr_bin=aq.cstmr_bin left join employee_master em on aq.crtd_by=em.emp_id left join employee_master em1 on aq.mdfd_by=em1.emp_id inner join branch b on b.brnch_id=aq.brnch_id inner join company_user cu on cu.company_code=b.company_code where cu.user_id=? order by quotationId desc";

	public static final String GET_Quotation_List_Sales="select aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,sp.srvc_prtnr_nam as custName,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pol_id) as aolName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pod_id) as aodName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.orgn_id) as originName, to_char(aq.crtd_dt,'dd/mm/yyyy') as createdOn,to_char(aq.mdfd_dt,'dd/mm/yyyy')as modifiedOn,(select emp_name from employee_master em where em.emp_id=aq.crtd_by) as createdBy,(select emp_name from employee_master em where em.emp_id=aq.mdfd_by) as modifiedBy,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.dstntn_id) as destinationName from sea_quotation aq inner join service_partner sp on sp.srvc_prtnr_bin=aq.cstmr_bin left join employee_master em on aq.crtd_by=em.emp_id left join employee_master em1 on aq.mdfd_by=em1.emp_id inner join branch b on b.brnch_id=aq.brnch_id inner join company_user cu on cu.company_code=b.company_code where cu.user_id=? and aq.crtd_by=? order by quotationId desc";
	public static final String GET_Quotation_List_SALES_Manager = "select distinct aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,sp.srvc_prtnr_nam as custName,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pol_id) as aolName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pod_id) as aodName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.orgn_id) as originName, to_char(aq.crtd_dt,'dd/mm/yyyy') as createdOn,to_char(aq.mdfd_dt,'dd/mm/yyyy')as modifiedOn,(select emp_name from employee_master em where em.emp_id=aq.crtd_by) as createdBy,(select emp_name from employee_master em where em.emp_id=aq.mdfd_by) as modifiedBy,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.dstntn_id) as destinationName from sea_quotation aq inner join service_partner sp on sp.srvc_prtnr_bin=aq.cstmr_bin left join employee_master em on aq.crtd_by=em.emp_id left join employee_master em1 on aq.mdfd_by=em1.emp_id inner join branch b on b.brnch_id=aq.brnch_id inner join company_user cu on cu.company_code=b.company_code where cu.user_id=? and (aq.crtd_by =? or aq.sls_prsn_nam in (select emp_id from employee_master where (emp_id=? or reporting_to=?)) ) and aq.brnch_id in (select brnch_id from branch where company_code in (select company_code from employee_master where (emp_id=? or reporting_to=?)))  order by quotationId desc";

	public static final String ContainerTypeList="select distinct cont_type as id,cont_type as text from booking_dtl  order by cont_type asc";


	public static final String Get_Empty="select container_release_hdr_code as containerreleaseCode,customer as customer,booking_no as bookingNo,depot as depot from container_release_hdr where container_release_hdr_code=?";

	public static final String GET_CONTAINER_QTY_TYPE_BY_BOOKING = "with t as (select quantity as qty,cont_type as conType from(select * from (select cont_type,sum(quantity::integer)  as quantity from sales_booking_dtl bd  where bd.booking_No=? and quantity::integer <> 0    group by cont_type)bkd  EXCEPT  select * from ( select container_type,sum(quantity::integer) as quantity from container_release_dtl crd inner join container_release_hdr crh on crh.container_release_hdr_code=crd.container_release_hdr_code where crh.booking_no=? group by container_type)crtd  )g  group by cont_type ,quantity )  select * from  t";

	
	public static final String GET_CONTAINER_TYPE_BY_BOOKING = "with t as (select  cont_type as id,cont_type as text from(select * from (select cont_type,sum(quantity::integer) from sales_booking_dtl bd where bd.booking_No=? and quantity::integer <> 0    group by cont_type)bkd  "  
			 +" EXCEPT  select * from (select container_type,sum(quantity::integer) from container_release_dtl crd inner join container_release_hdr crh on crh.container_release_hdr_code=crd.container_release_hdr_code where crh.booking_no=? group by container_type)crtd  )g group by cont_type  "
			 +" ) "


			 +"  select * from  t";



	public static final String GET_CONTAINER_TYPE_BY_BOOKING_Edit = "with t as (select  cont_type as id,cont_type as text from(select * from (select cont_type,sum(quantity::integer) from sales_booking_dtl bd where bd.booking_No=? and quantity::integer <> 0    group by cont_type)bkd  "  
			 +" EXCEPT  select * from (select container_type,sum(quantity::integer) from container_release_dtl crd inner join container_release_hdr crh on crh.container_release_hdr_code=crd.container_release_hdr_code where crh.booking_no=? and crh.container_release_hdr_code <> ? group by container_type)crtd  )g group by cont_type  "
			 +" ) "


			 +"  select * from  t";



	public static final String GET_print1 = "select * from vw_get_cro_print(?)";
}


