package com.dci.tenant.marketing.quotation;

public class QuotationQueryUtil {
	

	public static final String INSERT ="insert into quotation (quotation_no,quotation_date,servicetype,validtill,executive,agent,agreeparty,pack_type,business,freight,oog,odo,hazardous,line,lcid,pol,pod,dicd,pot1,pot2,pot3,pot4 ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static String list="select quotation_no as quotation_no,quotation_date as quotation_date,servicetype as servicetype,validtill as validtill,line as line,"
			+ "agent as agent,agreeparty as agreeparty, executive as executive ,lcid as lcid, pol as pol,pod as pod,dicd as dicd,pack_type as pack_type,business as business,pot1 as pot1,pot2 as pot2,pot3 as pot3,pot4 as pot4 from quotation";

	public static final String delete="delete from quotation where quotation_no=? ";
	
	public static final String GET_Quotation="select quotation_no as quotation_no,quotation_date as quotation_date,servicetype as servicetype,validtill as validtill,line as line,"
			+ " agent as agent,agreeparty as agreeparty,executive as executive,lcid as lcid,freight as freight,oog as oog,odo as odo,hazardous as hazardous,pol as pol,pod as pod,dicd as dicd,pack_type as pack_type,business as business,pot1 as pot1,pot2 as pot2,pot3 as pot3,pot4 as pot4 from quotation where quotation_no=?";


	public static final String Update = "update quotation set quotation_date=?,servicetype=?,validtill=?,executive=?,agent=?,agreeparty=?,pack_type=?,business=?,freight=?,"
			+ "oog=?,odo=?,hazardous=?,line=?,lcid=?,pol=?,pod=?,dicd=?,pot1=?,pot2=?,"
			+ "pot3=?,pot4=? where quotation_no=?";

	public static final String  Last_seq_no=" select 'QO' || lpad( (coalesce(max( substring(quotation_no,4)::int),0)+1)::text,4,'0') from quotation";

	public static final String getPortList = "select distinct portcode as id, CONCAT(portcode, '-' ,portname) as text  from port_master order by portcode asc  ";
	 
	public static final String GET_portValue = "select portname as text  from port_master where portcode=?";
	
	public static final String getlineList = "select distinct linecode as id, CONCAT(linecode, '-' ,linename) as text  from line_master ";
	 
	public static final String GET_lineValue = "select linename as text  from line where linecode=?";
	
	public static final String getAgentList = "select distinct vendor_code as id, CONCAT(vendor_code, '-' ,vendor_name) as text  from vendor_master";

	public static final String getPartyList = "select distinct cust_code as id, CONCAT(cust_code, '-' ,cust_name) as text  from customer_master order by cust_code asc";

	public static final String getExeList = "select distinct emp_id as id, CONCAT(emp_id, '-' ,emp_name) as text  from employee_master order by emp_id asc";


	public static final String Check_Quot_Exists = " select count(*) from quotation_hdr  where pol_id =? and pod_id=? and agre_party_id=? and  status='Approved'  ";

}



