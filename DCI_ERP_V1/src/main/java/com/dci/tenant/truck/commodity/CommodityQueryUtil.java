package com.dci.tenant.truck.commodity;

public class CommodityQueryUtil {

	public static final String INSERT ="insert into commodity (commodity_code,commodity,hazardous,unno,flash_point,"
			
			+ "imdg_class_code,imdg_code_page,hs_code,bl_clause,created_by,created_dt,active,tax_exemption) "
		
			+ "values(?,?,?,?,?,?,?,?,?,?,now(),?,?)";
	
	
	public static final String GET_COMMODITY ="select tax_exemption taxExem,commodity_code as commodityCode,commodity as commodity,"
			
			
			+ "hazardous as hazardous ,unno as unno,flash_point as flashPoint,"
			
			
			+ "imdg_code_page as imdgPage,hs_code as hsCode,bl_clause as blClause,imdg_class_code as imdgCode ,active as active  from commodity where commodity_code=?";

	
	
	public static final String UPDATE = "update commodity set commodity=?,hazardous=?,unno=?,flash_point=?,"
					
			+ "imdg_class_code=?,imdg_code_page=?,hs_code=?,bl_clause=?,modified_at=?,modified_dt=now(),active = ?,tax_exemption=? where commodity_code=?";
	
	
	public static final String GENERATE_CODE = "SELECT  case when (select max(commodity_code )from commodity where commodity_code~*?)"
			
			+ " is null then '0001' ELSE   lpad(cast(cast((SUBSTRING((select max(commodity_code) from commodity where commodity_code~*?),3))" 
			
			+ " as int)+1  as text),4,'0')  END";


	public static final String DROPDOWN = "select classification_code as id,CONCAT(classification_code, '-' ,description) as text from commodity_classification ORDER BY classification_code ASC";
	
	public static String list="select commodity_code as commodityCode,commodity as commodity,hazardous as hazardous,unno as unno,flash_point as flashPoint,"  
 
			+ "imdg_class_code as imdgCode,imdg_code_page as imdgPage,hs_code as hsCode,bl_clause as blClause from commodity order by created_dt desc";
	
	
	public static String delete="delete from commodity where commodity_code=?";

}
