package com.dci.master.branch;


public class BranchQueryUtil {

	//public static final String GET_BRANCH_LIST = "select brnch_cd as branchCode,brnch_nam as branchName,br.cmpny_id as companyId,cmpny_nam as company,crrncy_nam as currency,br.crrncy_id as currencyId,addrss1 as address,addrss2 as address1,addrss3 as address2,zp_pstl_cd as pinCode,phn_no as phoneNumber,fx_no as faxNo,pan_no as panNo,srvc_tx_no as serviceTaxNo,lcns_no as licenceNo,dcmnt_lg_id as logoPath,uom_id as uom,gstn_stt_cd as gstnCode,gstn_no as gstnNo,case when br.actv_bt is null then false when br.actv_bt= '1' then true when br.actv_bt= '0' then  false end as isActive,brnch_id as branchId,br.crtd_by as createdBy,to_char(br.crtd_dt,'dd/mm/yyyy') as createdDate,br.mdfd_by as modifiedBy ,to_char(br.mdfd_dt,'dd/mm/yyyy') as modifiedDate from branch br left join currency cr on  br.crrncy_id=cr.crrncy_id left join company cm on cm.cmpny_id=br.cmpny_id order by br.brnch_id desc";

	public static final String GET_BRANCH_LIST="select brnch_cd as branchCode,brnch_nam as branchName,br.cmpny_id as companyId,company_name as company,crrncy_nam as currency,br.crrncy_id as currencyId,addrss1 as address,addrss2 as address1,addrss3 as address2,zp_pstl_cd as pinCode,phn_no as phoneNumber,fx_no as faxNo,pan_no as panNo,srvc_tx_no as serviceTaxNo,lcns_no as licenceNo,dcmnt_lg_id as logoPath,uom_id as uom,gstn_stt_cd as gstnCode,gstn_no as gstnNo,case when br.actv_bt is null then false when br.actv_bt= '1' then true when br.actv_bt= '0' then  false end as isActive,brnch_id as branchId,(select em.emp_name from employee_master em where br.crtd_by =em.emp_id) as createdBy,to_char(br.crtd_dt,'dd/mm/yyyy') as createdDate,(select em.emp_name from employee_master em where br.mdfd_by =em.emp_id) as modifiedBy ,to_char(br.mdfd_dt,'dd/mm/yyyy') as modifiedDate from branch br left join currency cr on  br.crrncy_id=cr.crrncy_id  left join company_master cm on cm.company_code=br.cmpny_id order by br.brnch_id desc";
	
	public static final String INSERT_Branch(String active)
	{
	String str	= "insert into branch(brnch_cd,brnch_nam,cmpny_id,crrncy_id,addrss1,addrss2,addrss3,zp_pstl_cd,phn_no,fx_no,pan_no,srvc_tx_no,lcns_no,dcmnt_lg_id,uom_id,gstn_stt_cd,gstn_no,actv_bt,brnch_id,crtd_by,crtd_dt,mdfd_by,mdfd_dt,company_code,country_id,city_id,eml_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,(B'"+active+"')::bit(1),(select coalesce(max(brnch_id),0)+1 from branch),?,now(),?,now(),?,?,?,?)";
     return str;
	}
	public static String sAddCompanydetails = "INSERT INTO COMPANY_MASTER (COMPANY_NAME,SHORT_NAME,LOCATION,COMPANY_CODE,ADDRESS,PH_NO,FAX_NO,INTER_COMP_GROUP,CREATED_BY,CREATED_DATE,CURRENCY,IS_OPERATION )VALUES(?,?,?,?,?,?,?,?,?,now(),?,?)";

	public static final String SELECT_BRANCH_BY_ID = "select eml_id email,brnch_cd as branchCode,brnch_nam as branchName,cmpny_id as companyId,crrncy_id as currencyId,addrss1 as address,addrss2 as address1,addrss3 as address2,zp_pstl_cd as pinCode,phn_no as phoneNumber,fx_no as faxNo,pan_no as panNo,srvc_tx_no as serviceTaxNo,lcns_no as licenceNo,coalesce(dcmnt_lg_id,0) as logoPath,uom_id as uom,gstn_stt_cd as gstnCode,gstn_no as gstnNo,case when actv_bt is null then false when actv_bt= '1' then true when actv_bt= '0' then  false end as isActive,brnch_id as branchId,company_code as companyCode,country_id as countryId,city_id as cityId from branch where brnch_id =? ";
	
	public static final String SELECT_BRANCH_BY_ID_view = "select brnch_cd as branchCode,brnch_nam as branchName,cmpny_id as companyId,case when cmpny_id= '1' then 'ATHENA GLOBAL LOGISTICS PTE. LTD.'   end     as companyName,cr.crrncy_id as currencyId,cr.crrncy_id as id,concat(crrncy_cd,'-',crrncy_nam) as currencyName,addrss1 as address,addrss2 as address1,addrss3 as address2,zp_pstl_cd as pinCode,phn_no as phoneNumber,fx_no as faxNo,pan_no as panNo,srvc_tx_no as serviceTaxNo,lcns_no as licenceNo,dcmnt_lg_id as logoPath,case when dcmnt_lg_id= 43 then 'COMPANY'    when  dcmnt_lg_id= 44 then 'BRANCH'  when  uom_id= 3 then 'LBS-POUNDS'    end     as logopath1,uom_id as uom,case when uom_id= 1 then 'KGS-KGS'    when  uom_id= 2 then 'MT-METRIC TON'  when  uom_id= 3 then 'LBS-POUNDS'    end     as uom1 ,br.gstn_stt_cd as gstnCode,concat(s.gstn_stt_cd,'-',s.stt_nam) as stateName,gstn_no as gstnNo,case when br.actv_bt is null then false when br.actv_bt= '1' then true when br.actv_bt= '0' then  false end as isActive,brnch_id as branchId,company_code as companyCode,country_id as countryId,cr1.cntry_nam as countryName,city_id as cityId,c.cty_id as city,c.cty_nam as cityName from branch br   left join currency cr on cr.crrncy_id = br.crrncy_id  left join state s on s.stt_id::int = br.gstn_stt_cd::int left join city c on c.cty_id=br.city_id left join country cr1 on cr1.cntry_id=br.country_id where brnch_id =?";

	
	public static final String DELETE_Branch = "delete from branch where brnch_id =?";

	public static final String Update_BranchMaster = "UPDATE branch_master SET tenant_id =? , branch_code=?, branch_name=?, address=?, pin_code=?, phone_number=?, short_name=?, country=?, state=?, city=?, email=?, is_active=?, is_head=?,template_id = ? WHERE branch_id=?";

	public static String sUpdateCompanyDetail = "UPDATE COMPANY_MASTER SET  COMPANY_NAME=?,SHORT_NAME=?,LOCATION=?,ADDRESS=?,PH_NO=?,FAX_NO=?,INTER_COMP_GROUP=?,MODIFIED_BY=?,MODIFIED_DATE=now(), CURRENCY=?,IS_OPERATION =?  WHERE COMPANY_CODE=?";

	public static final String sCheckBranchCode = "select count(*) from branch_master where branch_code = ? and tenant_id=?";

	public static final String sCheckBranchCodeUpdate = "select count(*) from branch_master where branch_id <> ? and branch_code = ?";

	public static final String GET_BRANCH_LIST_ADMIN = "SELECT branch_id as branchId, branch_code as branchCode, branch_name as branchName, address as address, pin_code as pinCode, phone_number as phoneNumber, short_name as shortName, country as country, state as state, city as city, email as email, is_active as isActive, is_head as isHead, template_id as templateId, (select retailer_name from retailer where retailer_id=bm.tenant_id) as text FROM branch_master  bm order by branch_id desc";

	public static final String sCheckBranchCode1 = "select count(*) from branch_master where branch_name = ? and tenant_id=?";

	public static final String getdiv = "select branch_code from branch_master where branch_id=?";

	public static final String getdiv1 = "select branch_name  from branch_master where branch_id=?";

	public static final String sCheckBranchCode3 = "select count(*) from branch_master where branch_code = ? and tenant_id=? and branch_id <> ?";

	public static final String sCheckBranchCode4 = "select count(*) from branch_master where branch_name = ? and tenant_id=? and branch_id <> ?";

	public static final String DELETEBRANCHBANK = "delete from branch_bank_detail where brnch_id=?";

	public static final String DELETEBRANCHBANKDETAIL = "delete from branch_bank_detail where brnch_bnk_dtl_bin=?";

	public static final  String SELECT_BRANCH_BANK_BY_ID = "select bnk_nam as bankName,bnk_addrss as bankAddress,accnt_no as accountNo,ifsc_cd as ifscCode,iban_no as ibanNo, case when bnk_actv_bt is null then false when bnk_actv_bt= '1' then true when bnk_actv_bt= '0' then  false end as bankActive,swft_cd as shiftCard,brnch_bnk_dtl_bin as branchBankDetailId,brnch_id as branchId from branch_bank_detail where brnch_id=?";

	public static final  String SELECT_BRANCH_BANK_BY_ID_view = "select bnk_nam as bankName,bnk_addrss as bankAddress,accnt_no as accountNo,ifsc_cd as ifscCode,iban_no as ibanNo, case when bnk_actv_bt is null then false when bnk_actv_bt= '1' then true when bnk_actv_bt= '0' then  false end as bankActive,swft_cd as shiftCard,brnch_bnk_dtl_bin as branchBankDetailId,brnch_id as branchId from branch_bank_detail where brnch_id=?";

	public static final String GET_COMPANY = "select company_code from branch where brnch_id =?";

	public static final String DELETE_COMPANY = "delete from company_master where company_code=?";

	public static final String INSERT_Branch_BANK(String bankActive)
	{
		String str= "insert into branch_bank_detail(bnk_nam,bnk_addrss,accnt_no,ifsc_cd,iban_no,bnk_actv_bt,swft_cd,brnch_bnk_dtl_bin,brnch_id)values(?,?,?,?,?,(B'"+bankActive+"')::bit(1),?,(select coalesce(max(brnch_bnk_dtl_bin),0)+1 from branch_bank_detail),(select max(brnch_id) from branch))";
	    return str;
	}

	public static final String INSERT_Branch_BANK1(String bankActive)
	{
		String str= "insert into branch_bank_detail(bnk_nam,bnk_addrss,accnt_no,ifsc_cd,iban_no,bnk_actv_bt,swft_cd,brnch_bnk_dtl_bin,brnch_id)values(?,?,?,?,?,(B'"+bankActive+"')::bit(1),?,(select coalesce(max(brnch_bnk_dtl_bin),0)+1 from branch_bank_detail),?)";
	    return str;
	}
	public static String select_previous_id="select max(brnch_id) as branchId from branch";

	public static String UPDATE_Branch(String active) {
		// TODO Auto-generated method stub
		String str	= "update branch set brnch_cd=?,brnch_nam=?,cmpny_id=?,crrncy_id=?,addrss1=?,addrss2=?,addrss3=?,zp_pstl_cd=?,phn_no=?,fx_no=?,pan_no=?,srvc_tx_no=?,lcns_no=?,dcmnt_lg_id=?,uom_id=?,gstn_stt_cd=?,gstn_no=?,actv_bt=(B'"+active+"')::bit(1),mdfd_by=?,mdfd_dt=now(),country_id=?,city_id=?,eml_id=? where brnch_id=?";
	     return str;	}

	public static String GET_STATE_ID="select stt_id as stateId from city where cty_id=?";
	
	public static String GETCOUNTRYLIST="select cntry_id as id,(select cntry_nam from country c where c.cntry_id=s.cntry_id) as text from state s where stt_id=?";
	
	public static String AUTOGENERATE_OF_ACCT_HEAD_CODE="select max(acct_head_code) as acct_code from account_head_master where SUBGROUP_ACCT_CODE =?";
	public static String INSERT_ACC_HEAD="insert into account_head_master(acct_head_code,subgroup_acct_code,acct_head_name,acct_currency,acct_head_for,acct_head_status,created_by,created_dt)values(?,?,?,?,?,?,?,now())";
	public static String CURRENCY_VALUE="select crrncy_cd  from currency where crrncy_id=?";
	public static String DELETE_ACC="delete from account_head_master where brnch_id=?";
	public static final String DELETE_BRANCHBANK_DETAIL = "delete from branch_bank_detail where brnch_id=?";

}
