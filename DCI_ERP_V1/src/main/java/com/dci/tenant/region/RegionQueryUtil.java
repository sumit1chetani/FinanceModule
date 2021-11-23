package com.dci.tenant.region;

public class RegionQueryUtil {

	public static String list= " select  region_code as region_Code,name_db as name,area as area,address as address,city as city,country as country,pincode as  pincode,email as email,phone_no as phone_No,local_currency as local_Currency from region";
	public static String INSERT = "insert into region (region_code,name_db,area,address,city,country,pincode,email,phone_no,local_currency) values(?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE = " update region set name_db=?,area=?,address=?,city=?,country=?,pincode=?,email=?,phone_no=?,local_currency=? where region_code=?";

	public static String delete="delete from region where region_code=?";
	public static String GET_REGION="select region_code as region_Code, name_db as name,area as area,address as address,city as city,country as country,pincode as  pincode,email as email,phone_no as phone_No,local_currency as local_Currency from region where region_code=?";

	




	
}
