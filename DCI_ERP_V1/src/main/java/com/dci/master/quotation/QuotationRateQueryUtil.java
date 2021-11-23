package com.dci.master.quotation;

import java.math.BigInteger;

public class QuotationRateQueryUtil {

	public static final String GENERATE_QUOTATION_NO = "SELECT CASE WHEN MAX(quotation_no) IS NULL THEN 'QO00001' ELSE rpad(MAX(quotation_no),2,'QO')|| lpad(cast(cast((SUBSTRING(MAX(quotation_no),3)) as int) + 1 as text),5,'0') END quotationNo FROM quotation_hdr where quotation_no not like '%RR%' ";

	public static final String COUNT_OF_INVOICE = "select count(*) from invoice_hdr where quotation=?";

	public static final String SAVE_QUOTATION_HDR = "INSERT INTO quotation_hdr(quotation_no, agre_party_id, pol_id, pod_id, quotation_date, valid_till, status,created_by, created_date,company_id, origin_id, customer_type,remarks,currency_code,type,cust_category,free_days,address,other_charges,soc) VALUES (?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ?, ?, now(), ?, ?, ?, ?,?,?,?,?,?,?,?)";

	public static final String SAVE_QUOTATION_HDR_FROM_RRR = "INSERT INTO quotation_hdr(quotation_no, agre_party_id, pol_id, pod_id, quotation_date, valid_till, status,created_by, created_date,company_id, origin_id, customer_type,remarks,currency_code,type,cust_category,free_days,address,other_charges,soc,rr_no,approved_by,approved_dt,approve_remarks,cargo_type) VALUES (?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ?, ?, now(), ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,now(),?,?)";

	public static final String SAVE_QUOTATION_DTL = "INSERT INTO quotation_dtl(quotation_no, container_type_code,charge_type_code, quoted_rate,no_of_box,tariff, sl_no,is_hazardous,is_empty,is_oog,freedays,local_currency,charge_flag, commodity) VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?)";

	public static final String SAVE_QUOTATION_DTL_FROM_RRR = "INSERT INTO quotation_dtl(quotation_no, container_type_code,charge_type_code, quoted_rate,no_of_box,tariff, sl_no,is_hazardous,is_empty,is_oog,freedays,local_currency,charge_flag,uom , commodity,tax,all_in_rate) VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,? , ?,?,?)";

	public static String GET_Quotation_List1 = "SELECT qh.quotation_no as quotationNo,agre_party_id, pol_id, pm.portname as pol,pod_id, pm1.portname as pod,  to_char(quotation_date,'dd/mm/yyyy') as quotationDate,to_char(valid_till,'dd/mm/yyyy') as validTill , origin_id as origin, dropoff_mode as dropoff,case when valid_till < current_date then 'Expired' else 'Valid' end as Status, (select * from get_customer_name_by_custid(qh.agre_party_id ))  as customer,qh.status as status1,user_name as user,(select branch_short_name from user_master um left join branch b on um.branch_department_id=b.branch_code where user_id=qh.created_by) as location, case when count(b.quotation) > 0 then 'ALLOTTED' else 'NOT ALLOTTED' end as bookingStatus ,approved_by as approvedBy ,(select count(*) from invoice_hdr where quotation=qh.quotation_no) as quotationcount  ,qh.created_by as quotationcreated,approved_dt FROM quotation_hdr qh left join port_master pm on qh.pol_id=pm.portcode left join port_master pm1 on qh.pod_id=pm1.portcode   left join booking b on b.quotation =  qh.quotation_no   \r\n"
			+ "left join customer_master cm on cm.cust_code=qh.agre_party_id left join user_master um on um.user_id = qh.created_by    where 1=1 ";

	public static String GET_Quotation_List = "SELECT qh.quotation_no as quotationNo,agre_party_id, pol_id, pm.portname as pol,pod_id, pm1.portname as pod,  to_char(quotation_date,'dd/mm/yyyy') as quotationDate,   "
			+ " to_char(valid_till,'dd/mm/yyyy') as validTill , origin_id as origin, dropoff_mode as dropoff,case when valid_till < current_date then 'Expired' else 'valid' end as Status,   "
			+ " cm.cust_name as customer,qh.status as status1,user_name as user,(select branch_short_name from user_master em left join branch b on em.branch_department_id=b.branch_code   "
			+ " where user_id=qh.created_by) as location, case when count(b.quotation) > 0 then 'ALLOTTED' else 'NOT ALLOTTED' end as bookingStatus ,qh.created_by as quotationcreated,approved_dt  "
			+ " 			 FROM quotation_hdr qh left join port_master pm on qh.pol_id=pm.portcode left join port_master pm1 on qh.pod_id=pm1.portcode    "
			+ "                       left join booking b on b.quotation =  qh.quotation_no   "
			+ " 			left join customer_master cm on cm.cust_code=qh.agre_party_id left join user_master um on um.user_id = qh.created_by   where qh.status = 'Approved' group by qh.quotation_no,pm.portname ,pm1.portname,cm.cust_name ,emp_name  order by approved_dt desc  NULLS LAST";

	public static String GET_Quotation_List_Approval = "SELECT qh.quotation_no as quotationNo,agre_party_id, pol_id, pm.portname as pol,pod_id, pm1.portname as pod,  to_char(quotation_date,'dd/mm/yyyy') as quotationDate, to_char(valid_till,'dd/mm/yyyy') as validTill , origin_id as origin, dropoff_mode as dropoff,case when valid_till < current_date then 'Expired' else 'valid' end as Status, cm.cust_name as customer,qh.status as status1,user_name as user,(select branch_short_name from user_master um left join branch b on um.branch_department_id=b.branch_code where user_id=qh.created_by) as location, case when count(b.quotation) > 0 then 'ALLOTTED' else 'NOT ALLOTTED' end as bookingStatus  ,qh.created_by as quotationcreated  FROM quotation_hdr qh left join port_master pm on qh.pol_id=pm.portcode left join port_master pm1 on qh.pod_id=pm1.portcode    \r\n"
			+ "left join booking b on b.quotation =  qh.quotation_no   \r\n"
			+ "left join customer_master cm on cm.cust_code=qh.agre_party_id left join user_master um on um.user_id = qh.created_by   where   qh.status !='Draft' and qh.status='Pending' group by qh.quotation_no,pm.portname ,pm1.portname,cm.cust_name ,user_name  order by approved_dt desc  NULLS LAST  ";

	public static String GET_Quotation_List_Approval_filter = "SELECT qh.quotation_no as quotationNo,agre_party_id, pol_id, pm.portname as pol,pod_id, pm1.portname as pod,  to_char(quotation_date,'dd/mm/yyyy') as quotationDate,to_char(valid_till,'dd/mm/yyyy') as validTill , origin_id as origin, dropoff_mode as dropoff,case when valid_till < current_date then 'Expired' else 'valid' end as Status, cm.cust_name as customer,qh.status as status1,user_name as user,(select branch_short_name from user_master em left join branch b on em.branch_department_id=b.branch_code   \r\n"
			+ "where user_id=qh.created_by) as location, case when count(b.quotation) > 0 then 'ALLOTTED' else 'NOT ALLOTTED' end as bookingStatus  FROM quotation_hdr qh left join port_master pm on qh.pol_id=pm.portcode left join port_master pm1 on qh.pod_id=pm1.portcode left join booking b on b.quotation =  qh.quotation_no left join customer_master cm on cm.cust_code=qh.agre_party_id left join user_master um on um.user_id = qh.created_by   where qh.status = ? group by qh.quotation_no,pm.portname ,pm1.portname,cm.cust_name ,user_name  order by approved_dt desc  NULLS LAST";

	public static String EDIT_HDR = "SELECT q.quotation_no as quotationNo, q.agre_party_id as customer,c.cust_name as customername, q.pol_id as pol, q.pod_id as pod,to_char(q.quotation_date,'dd/mm/yyyy') as quotationDate, "
			+ " to_char(q.valid_till,'dd/mm/yyyy') as validTill,q.origin_id as origin,q.dropoff_mode as dropoff,q.remarks as freight,q.currency_code as currencyName,q.type as doType, "
			+ " q.cust_category as custCategory,q.free_days as freeDays,q.status,q.address,q.other_charges as otCharge,u.user_name as approvedBy,to_char(q.approved_dt,'dd/mm/yyyy') as approvedDate, "
			+ " case when q.other_charges='1' then 'Collect' when q.other_charges='3' then 'Third Party Collect' when q.other_charges='2' then 'Prepaid'else '' end as viewotCharge, "
			+ " case when q.remarks='1' then 'Collect' when q.remarks='3' then 'Third Party Collect' when q.remarks='2' then 'Prepaid' else '' end as viewfreight,q.approve_remarks as approveRemarks, "
			+ " q.soc as soc ,(select string_agg(commodity,',') from commodity  where commodity_id = any (string_to_array(cargo_type, ',')::int[]) limit 1) as cargoType, "
			+ " emc.user_name as created_by ,to_char(q.CREATED_DATE,'dd/MM/yyyy')  as created_date,emm.user_name  AS modified_by, to_char(q.MODIFIED_DATE,'dd/MM/yyyy') AS modified_date,pm.portname as polName,pm1.portname as podName"
			+ " FROM quotation_hdr q left join user_master u on u.user_id = q.approved_by left join customer_master as c on  c.cust_code=q.agre_party_id "
			+ " left join user_master emc on emc.user_id = q.CREATED_BY left join user_master emm on emm.user_id = q.MODIFIED_BY  left join port_master pm on pm.portcode =q.pol_id "
			+ " left join port_master pm1 on pm1.portcode =q.pod_id where quotation_no=?";

	public static String EDIT_DTL = "SELECT quotation_dtl_id as quotationDtlId,tariff as tariff,container_type_code as conType,charge_type_code as chargeType,s.sur_name as chargeHeads1, quoted_rate as quotedRate,quoted_rate as quotedRate1,case when is_hazardous is false then 'No' when is_hazardous is true then 'Yes' end as name,no_of_box as noOfBox, is_hazardous as hazardous,is_empty as empty,is_oog as oog, freedays,local_currency,local_currency  as currencyName,charge_flag as chargeFlagType, uom as uom ,commodity::character varying as commodity ,coalesce(tax,0) as tax FROM quotation_dtl q inner join surcharge_master s on s.sur_code=q.charge_type_code where quotation_no=?";

	public static final String UPDATE_QUOTATION_HDR = "UPDATE quotation_hdr SET  agre_party_id=?, pol_id=?, pod_id=?,quotation_date=to_date(?,'dd/mm/yyyy'),valid_till=to_date(?,'dd/mm/yyyy'), modified_by=?, modified_date=now(), company_id=?,origin_id=?, "
			+ "remarks=?,currency_code=?,type=?,cust_category=?,free_days=?,status=?,address =?,other_charges=?,soc=? WHERE quotation_no=?";

	public static final String check_booking = "select count(*) from booking where quotation =?";

	public static final String Delete_Quotation_Dtl = "delete from quotation_dtl WHERE quotation_no=?";

	public static final String Delete_Quotation_Hdr = "delete from quotation_hdr WHERE quotation_no=?";

	public static final String GET_CUSTOMER_ADD = "select address,cust_category as custcategory from customer_master where cust_code=?";

	////////////////////////////////////////////

	public static final String Update_Booking_status = "update booking set quotation_no  = ?,status = ? where booking_id=? ";
	public static final String Get_Employee_list = "select emp_id as id,concat(user_id,'-',user_name) as text from user_master where user_id like '%COR%' order by id";
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
			+ " inner join unit un on un.unt_id=sqd.unt_id " + " inner join currency cu on cu.crrncy_id=sqd.crrncy_id "
			+ " where sqd.qttn_bin=? and sqd.trnsctn_typ_id =2";
	public static final String Update_SEA_QUOTATION = "update sea_quotation set qttn_no_tcd=?,knd_attntn_vcr=?,crrr_nam=?,rmrks_vcr=?,qttn_dt=to_date(?,'dd/mm/yyyy'),sls_prsn_nam=?,trms_cndtns=?,vldty_dt=to_date(?,'dd/mm/yyyy'),pod_id=?,pol_id=?,brnch_id=?,cnsgn_bin=?,brnch_crrncy_id=?, cstmr_bin=?,dstntn_id=?,assgnd_by=?,orgn_id=?,sls_typ_id=?,qttn_srvc_id=?,shppr_bin=?,trm_id=?,vndr_bin=?,cmmdty_nam=?,vssl_vyg_tcd=?,qttn_md_id=?,mdfd_by= ?,mdfd_dt=now(),jb_stts_bt='0',dimension_name=? where qttn_bin= ?";

	public static final String GET_SEA_QUOTATION_Edit = "select dimension_name as dimensionName,aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,aq.qttn_md_id as mode,aq.qttn_srvc_id as service,   "
			+ " aq.brnch_id as branch,aq.cstmr_bin as customer,aq.assgnd_by as nominatedBy,aq.shppr_bin as shipper,aq.cnsgn_bin as consignee,aq.pol_id as aol,aq.pod_id aod,aq.orgn_id as origin,aq.dstntn_id as destination,   "
			+ " aq.sls_prsn_nam as salesPerson,  " + " aq.sls_typ_id as salesType,aq.trms_cndtns as termConditions,   "
			+ " aq.knd_attntn_vcr as attention,aq.crrr_nam as carrier,aq.vndr_bin as vendor,aq.trm_id as term,aq.brnch_crrncy_id as currency,aq.jb_stts_bt,   "
			+ " 			   to_char(aq.vldty_dt,'dd/mm/yyyy') as validityDate,vssl_vyg_tcd as vessel,cmmdty_nam as commodity,rmrks_vcr as remarks  "
			+ " 			             from sea_quotation aq  where aq.qttn_bin=?";

	public static final String GET_SEA_QUOTATION_Dtl_Edit = "select qttn_chrg_dtl_bin as quotationDtlId,qttn_bin as quotationId,chrg_hd_id as chargeHeads,unt_id as unit,rt_nc as rate,qty_int_qty as qty,crrncy_id as currency,pymnt_md_id as paymentMethod,trnsctn_typ_id as transactionType,prty_bin as buySell ,nts_vcr as note from sea_quotation_detail  where  qttn_bin=?";

	// public static final String GET_SEA_QUOTATION_Dtl_View = "select
	// qttn_chrg_dtl_bin as quotationDtlId,qttn_bin as quotationId,chrg_hd_id as
	// chargeHeads,unt_id as unit,rt_nc as rate,qty_int_qty as qty,crrncy_id as
	// currency,pymnt_md_id as paymentMethod,trnsctn_typ_id as
	// transactionType,prty_bin as buySell ,nts_vcr as note from
	// sea_quotation_detail where qttn_bin=?";

	public static final String GET_SEA_QUOTATION_Dtl_View = "select qttn_chrg_dtl_bin as quotationDtlId,qttn_bin as quotationId,ch.chrg_hd_id as chargeHeads,ch.chrg_hd_nam as chargeHeads1 ,u.unt_id as unit,u.unt_nam as unitName,rt_nc as rate,qty_int_qty as qty,c.crrncy_id as currency,c.crrncy_nam as currencyName,(select enm_nam from enum e where e.enm_cd::varchar=sqd.pymnt_md_id::varchar and enm_typ_id=6)as paymentMethod1,(select enm_nam from enum e where e.enm_cd::varchar=sqd.trnsctn_typ_id::varchar and enm_typ_id=7)as transactionType1,prty_bin as buySell ,sp.srvc_prtnr_nam as partyBin,nts_vcr as note from sea_quotation_detail sqd left join charge_head ch on ch.chrg_hd_id = sqd.chrg_hd_id left join unit u on u.unt_id = sqd.unt_id left join currency c on c.crrncy_id=sqd.crrncy_id left join service_partner sp on sp.srvc_prtnr_bin= sqd.prty_bin where qttn_bin=?";

	/*
	 * public static final String GET_SEA_QUOTATION_View =
	 * "select dimension_name as dimensionName,aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,aq.qttn_md_id as mode,aq.qttn_srvc_id as service,   "
	 * +
	 * " aq.brnch_id as branch,aq.cstmr_bin as customer,aq.assgnd_by as nominatedBy,aq.shppr_bin as shipper,aq.cnsgn_bin as consignee,aq.pol_id as aol,aq.pod_id aod,aq.orgn_id as origin,aq.dstntn_id as destination,   "
	 * + " aq.sls_prsn_nam as salesPerson,  " +
	 * " aq.sls_typ_id as salesType,aq.trms_cndtns as termConditions,   " +
	 * " aq.knd_attntn_vcr as attention,aq.crrr_nam as carrier,aq.vndr_bin as vendor,aq.trm_id as term,aq.brnch_crrncy_id as currency,aq.jb_stts_bt,   "
	 * +
	 * " 			   to_char(aq.vldty_dt,'dd/mm/yyyy') as validityDate,vssl_vyg_tcd as vessel,cmmdty_nam as commodity,rmrks_vcr as remarks  "
	 * + " 			             from sea_quotation aq  where aq.qttn_bin=?";
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

	public static String APPROVE_QUOTATION = "update quotation_hdr set approved_by=?, approved_dt=now(),Status=?,approve_remarks=? where quotation_no=? ";

	public static String EXPIRE_QUOTATION = " update quotation_hdr  set expired_by=? ,expired_on=now(),Status=?,expired_remarks= ?\n"
			+ "  where upper(status) ='APPROVED' and quotation_no!=? and ( \n"
			+ "  (agre_party_id, pol_id,pod_id,(select string_agg(DISTINCT container_type_code,',') as container_type_code from quotation_dtl qd where qd.quotation_no  =quotation_hdr.quotation_no order by container_type_code asc)) \n"
			+ "  in(select agre_party_id, pol_id,pod_id,(select string_agg(DISTINCT container_type_code,',') as container_type_code from quotation_dtl qd  where qd.quotation_no  =qh.quotation_no order by container_type_code asc)\n"
			+ "   from quotation_hdr qh where  qh.quotation_no  =?) )";

	public static String INACTIVE_QUOTATION = " update quotation_hdr  set   Status='INACTIVE'  where upper(status) ='APPROVED' and quotation_no =? ";

	public static String IATA_LIST = "select iata_id as id,iata_cd as text from iata ";

	public static String GET_CURRENCY = "select crrncy_id as id,concat(crrncy_cd,'-',crrncy_nam) as text from currency";

	public static String Get_Service_Partner = "select srvc_prtnr_bin as id,concat(srvc_prtnr_cd,'-',srvc_prtnr_nam) as text from service_partner";

	public static String Get_Service_Partner_Type = "select dflt_typ_id as id,dflt_typ_nam as text from service_partner_type";

	public static String Get_Employee = "select user_id as id,concat(user_id,'-',user_name) as text from user_name order by id";

	public static String INSERT_FILES = "insert into sea_quotation_files(quotation_no,file_name,file_path) values(?,?,?)";

	// public static String GET_Quotation_List = "select aq.qttn_no_tcd as
	// quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy')
	// as quotationDate,sp.srvc_prtnr_nam as custName,(select
	// concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id
	// =aq.pol_id) as aolName,(select concat(prt_icd_cd,'-',prt_icd_nam) from
	// port_icd ia where ia.prt_icd_id =aq.pod_id) as aodName,(select
	// concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id
	// =aq.orgn_id) as originName,to_char(aq.crtd_dt,'dd/mm/yyyy') as
	// createdOn,to_char(aq.mdfd_dt,'dd/mm/yyyy')as modifiedOn,(select emp_name
	// from employee_master em where em.emp_id=aq.crtd_by) as createdBy,(select
	// emp_name from employee_master em where em.emp_id=aq.mdfd_by) as
	// modifiedBy,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia
	// where ia.prt_icd_id =aq.dstntn_id) as destinationName from sea_quotation
	// aq inner join service_partner sp on sp.srvc_prtnr_bin=aq.cstmr_bin order
	// by quotationId desc";

	public static String getQuotBranch = "select concat((select brnch_cd  from branch where brnch_id=?),'/S',?) as quotBranch";

	public static String getQuotCount(String quotationBranch) {
		String data = "";
		data = "select coalesce ((select SPLIT_PART(qttn_no_tcd,'/','4') :: int as  count from sea_quotation pt  "
				+ " where qttn_no_tcd like '%" + quotationBranch + "%' order by count desc limit 1),'0') as count";
		return data;
	}

	public static String getQuotCountUpdate(String quotationBranch, BigInteger QId) {
		String data = "";

		data = "select coalesce ((select SPLIT_PART(qttn_no_tcd,'/','4') :: int as  count from sea_quotation pt  "
				+ " where  qttn_bin !=" + QId + " and qttn_no_tcd like '%" + quotationBranch
				+ "%' order by count desc limit 1),'0') as count ";

		// + "select count(*) as count from sea_quotation where qttn_no_tcd like
		// '%"+quotationBranch+"%' and qttn_bin="+QId;
		return data;
	}

	public static final String Delete_Sea_Quotation_tmp_Dtl = "delete from sea_quotation_detail_tmp where qttn_bin=?";

	public static final String Delete_Sea_Quotation_tmp = "delete from sea_quotation_tmp where qttn_bin=?";
	public static final String Get_Uom_List = "select enm_cd as id,enm_nam as text from enum where enm_typ_id=16";

	public static String DateandYear = "select concat((select to_char(now(),'mm')),(select to_char(now(),'yy'))) as dateYear";

	public static String Get_File_Name_List = "SELECT file_name  FROM  sea_quotation_files qf inner join sea_quotation aq on aq.qttn_no_tcd=qf.quotation_no where qttn_bin=?";

	public static String delete_FILES = "delete from sea_quotation_files where quotation_no=?";

	public static String delete_FILENAME = "delete from sea_quotation_files ";

	public static String getcommodity = "select commodity_id as id,commodity_name as text from commodity_master order by commodity_name asc";

	public static String SET_IMAGE_LIST = "select commodity_id as id,commodity_name as text from commodity_master order by commodity_name asc";

	public static final String FILE_LIST = "select  file_name as fileName,file_path as filePath from sea_quotation_files where quotation_no= ?";

	public static String GET_FILES = "select file_path as filePath from sea_quotation_files where quotation_no = ?";

	public static String get_booking_dtls_by_quot = "select booking_no as bookingNo,quotation as quotation,booking_date as bookingDate from booking where quotation =? order by booking_no asc";

	public static final String dummy = "select qttn_no_tcd from sea_quotation where qttn_bin  = ?";

	public static final String GET_Dept_NO = "select dept as deptNo from employee_master where emp_id=?";

	public static final String GET_Quotation_List_Admin = "select aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,sp.srvc_prtnr_nam as custName,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pol_id) as aolName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pod_id) as aodName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.orgn_id) as originName, to_char(aq.crtd_dt,'dd/mm/yyyy') as createdOn,to_char(aq.mdfd_dt,'dd/mm/yyyy')as modifiedOn,(select emp_name from employee_master em where em.emp_id=aq.crtd_by) as createdBy,(select emp_name from employee_master em where em.emp_id=aq.mdfd_by) as modifiedBy,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.dstntn_id) as destinationName from sea_quotation aq inner join service_partner sp on sp.srvc_prtnr_bin=aq.cstmr_bin left join employee_master em on aq.crtd_by=em.emp_id left join employee_master em1 on aq.mdfd_by=em1.emp_id inner join branch b on b.brnch_id=aq.brnch_id inner join company_user cu on cu.company_code=b.company_code where cu.user_id=? order by quotationId desc";

	public static final String GET_Quotation_List_Sales = "select aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,sp.srvc_prtnr_nam as custName,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pol_id) as aolName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pod_id) as aodName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.orgn_id) as originName, to_char(aq.crtd_dt,'dd/mm/yyyy') as createdOn,to_char(aq.mdfd_dt,'dd/mm/yyyy')as modifiedOn,(select emp_name from employee_master em where em.emp_id=aq.crtd_by) as createdBy,(select emp_name from employee_master em where em.emp_id=aq.mdfd_by) as modifiedBy,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.dstntn_id) as destinationName from sea_quotation aq inner join service_partner sp on sp.srvc_prtnr_bin=aq.cstmr_bin left join employee_master em on aq.crtd_by=em.emp_id left join employee_master em1 on aq.mdfd_by=em1.emp_id inner join branch b on b.brnch_id=aq.brnch_id inner join company_user cu on cu.company_code=b.company_code where cu.user_id=? and aq.crtd_by=? order by quotationId desc";
	public static final String GET_Quotation_List_SALES_Manager = "select distinct aq.qttn_no_tcd as quotationNo, aq.qttn_bin as quotationId,to_char(aq.qttn_dt,'dd/mm/yyyy') as quotationDate,sp.srvc_prtnr_nam as custName,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pol_id) as aolName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.pod_id) as aodName, (select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.orgn_id) as originName, to_char(aq.crtd_dt,'dd/mm/yyyy') as createdOn,to_char(aq.mdfd_dt,'dd/mm/yyyy')as modifiedOn,(select emp_name from employee_master em where em.emp_id=aq.crtd_by) as createdBy,(select emp_name from employee_master em where em.emp_id=aq.mdfd_by) as modifiedBy,(select concat(prt_icd_cd,'-',prt_icd_nam) from port_icd ia where ia.prt_icd_id =aq.dstntn_id) as destinationName from sea_quotation aq inner join service_partner sp on sp.srvc_prtnr_bin=aq.cstmr_bin left join employee_master em on aq.crtd_by=em.emp_id left join employee_master em1 on aq.mdfd_by=em1.emp_id inner join branch b on b.brnch_id=aq.brnch_id inner join company_user cu on cu.company_code=b.company_code where cu.user_id=? and (aq.crtd_by =? or aq.sls_prsn_nam in (select emp_id from employee_master where (emp_id=? or reporting_to=?)) ) and aq.brnch_id in (select brnch_id from branch where company_code in (select company_code from employee_master where (emp_id=? or reporting_to=?)))  order by quotationId desc";

	public static String getQuotUserDtl(String quotationNo) {
		String query = " select user_name,user_id from quotation_hdr a join user_master on a.created_by=user_id where quotation_no='"
				+ quotationNo + "' ";
		return query;
	}

	public static final String GET_OF_CHARGE_TO_MAIL = "select quotation_no,container_type_code as conType,charge_type_code,s.sur_name as chargeName,local_currency as localCurrency,quoted_rate as quotedRate,freedays as freeDays from quotation_dtl q\n"
			+ "inner join  surcharge_master s on q.charge_type_code=s.sur_code where charge_type_code ='SC0001' and quotation_no= ?";

	public static final String GET_CUSTOMER_EDIT = "select cust_code as id,concat(cust_code,' - ',cust_name) as text  from customer_master where active ='T' \n"
			+ "union \n"
			+ "select agre_party_id as id ,concat(cust_code,' - ',cust_name) as text from quotation_hdr s join customer_master c on s.agre_party_id=c.cust_code\n"
			+ " where quotation_no = ?";

	public static final String GET_PREV_QUOT_NO = " select quotation_no as quotationNo from quotation_hdr  where pol_id =? and pod_id=? and status='Approved' and agre_party_id=?  order by quotation_no desc limit 1";

	public static final String UPDATE_STATUS_AS_UNAPPROVE = "UPDATE quotation_hdr set status='Pending',approve_remarks='Unapproved because of new container type creation' where quotation_no=? ";

	public static final String SAVE_QUOTATION_FREE_DAYS_DTL = "insert into quotation_free_days_dtl (quotation_no,con_type,pol_free_days,pod_free_days , pol_free_days_demaurrage , pod_free_days_demaurrage) values (?,?,?,?,?,?)";

	public static final String EDIT_FREEDAYS_DTL = "select quotation_free_days_dtl_id as quotationFreeDaysId,quotation_no as quotationNo,pol_free_days as polFreeDays,pod_free_days as podFreeDays,con_type as conType,pol_free_days as polFreeDays1,pod_free_days as podFreeDays1 , pol_free_days_demaurrage as polFreeDaysdemurrage, pod_free_days_demaurrage as podFreeDaysdemurrage  from  quotation_free_days_dtl where quotation_no=?";

	public static final String Delete_Quotation_Free_days_Dtl = "delete from quotation_free_days_dtl where quotation_no=?";

	public static final String Insert_mail_log = "insert into   mail_error_log (module_id,send_date,send_by,error_log) values (?,now(),?,?)";

	public static final String Update_mail_log = "update mail_error_log set send_date =now(),send_by=?,error_log=? where module_id=?";

	public static String GET_Tariff_RateList = "SELECT qh.quotation_no as quotationNo,agre_party_id, pol_id, pm.portname as pol,pod_id, pm1.portname as pod,  to_char(quotation_date,'dd/mm/yyyy') as quotationDate, to_char(valid_till,'dd/mm/yyyy') as validTill , origin_id as origin, dropoff_mode as dropoff,case when valid_till < current_date then 'Expired' else 'valid' end as Status, cm.cust_name as customer,qh.status as status1,user_name as user,(select branch_short_name from user_master um left join branch b on um.branch_department_id=b.branch_code  where user_id =qh.created_by) as location, case when count(b.quotation) > 0 then 'ALLOTTED' else 'NOT ALLOTTED' end as bookingStatus  ,qh.created_by as quotationcreated  FROM quotation_hdr qh  \r\n"
			+ "			left join port_master pm on qh.pol_id=pm.portcode left join port_master pm1 on qh.pod_id=pm1.portcode  \r\n"
			+ "			 left join booking b on b.quotation =  qh.quotation_no   \r\n"
			+ "			left join customer_master cm on cm.cust_code=qh.agre_party_id  \r\n"
			+ "			left join user_master um on um.user_id = qh.created_by   \r\n"
			+ "			where   qh.status !='Draft' and (qh.status='Pending' or qh.status='Rejected' ) and qh.status !='Expired' group by qh.quotation_no,pm.portname ,pm1.portname,cm.cust_name ,user_name order by approved_dt desc  NULLS LAST ";

	public static final String SAVE_QUOTATION_DTL_log = "INSERT INTO quotation_dtl_log(quotation_no, container_type_code,charge_type_code, quoted_rate,no_of_box,tariff, sl_no,is_hazardous,is_empty,is_oog,freedays,local_currency, created_by, created_date) VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,now())";

	public static final String UPDATE_QUOTATION_FREE_DAYS_DTL = "update quotation_dtl set quoted_rate = ?  where quotation_no = ? and container_type_code = ?";

	public static final String GET_MRG_DTL_RATE = "select coalesce(rate,0) from mrg_hdr inner join mrg_dtl on mrg_dtl.mrg_hdr_no = mrg_hdr.mrg_hdr_no where mlo_mrg = ? and pod = ? and pol = ? and cntr_type = ? ";

	public static final String GET_MRG_DTL_COUNT = "select count(*) from mrg_hdr inner join mrg_dtl on mrg_dtl.mrg_hdr_no = mrg_hdr.mrg_hdr_no where mlo_mrg = ? and pod = ? and pol = ? and cntr_type = ? ";

	public static final String GET_TARIFF_DTL_COUNT = "select count(*) from tariff_hdr inner join tariff_dtl on tariff_dtl.tariff_no = tariff_hdr.tariff_no where agre_party_id = ? and pod_id = ? and pol_id = ? and container_type_code = ? ";

	public static final String GET_TARIFF_DTL_RATE = "select coalesce(quoted_rate,0) from tariff_hdr inner join tariff_dtl on tariff_dtl.tariff_no = tariff_hdr.tariff_no where agre_party_id = ? and pod_id = ? and pol_id = ? and container_type_code = ? ";

	public static final String EDIT_AMOUNT_DTL = "select local_currency  as currencyName, sum(quoted_rate) as quotedRate  \n"
			+ "FROM quotation_dtl where quotation_no=? group by local_currency";

	public static final String GET_CUSTOMER_COUNTRY = "select  (select country_name from country_master where country_code = customer_master.country_name)  from customer_master  where  cust_code  = ? ";

	public static final String GET_POL_COUNTRY = "select (select country_name from country_master where country_code = port_master.country_code)  from port_master  where portcode  = ? ";

	public static final String SAVE_QUOTATION_HDR_FROM_RRR_NEW = "INSERT INTO quotation_hdr(quotation_no, agre_party_id, pol_id, pod_id, quotation_date, valid_till, status,created_by, created_date,company_id, origin_id, customer_type,remarks,currency_code,type,cust_category,free_days,address,other_charges,soc,rr_no,approved_by,approved_dt,approve_remarks,cargo_type) VALUES (?, ?, ?, ?, now(), to_date(?,'dd/mm/yyyy'), ?, ?, now(), ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,now(),?,?)";

	public static final String Check_Quot_Exists = null;

}
