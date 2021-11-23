package com.dci.tenant.truck.commodityclassification;

public class CommodityClassificationQueryUtil {

	public static final String INSERT  ="insert into commodity_classification (classification_code,description,created_by,created_dt) "
		
			+ "values(?,?,?,now())";
	
	
	public static final String GET_COMMODITY ="select classification_code as classificationCode,description as description from commodity_classification where classification_code=?";

	
	public static final String UPDATE = "update commodity_classification set description=?,modified_at=?,modified_dt=now() where classification_code=?";
	
	public static String list="select classification_code as classificationCode,description as description from commodity_classification order by created_dt desc";
	
	public static String delete="delete from commodity_classification where classification_code=?";

}
