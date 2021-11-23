package com.dci.common.quicklink;

public class QuickLinkQueryUtil {

	public static final String getqlList="select ql_id as id,sub_form_name as text from quick_links";
	
	public static final String getqlDtl="select ql_link as qlLink from quick_links where ql_id=?";
	
	public static final String getBookingNo="select booking_no as id from booking where quotation=?";
	
	public static final String getCRONo="select container_release_hdr_code as id from container_release_hdr where booking_no=?";
	
	public static final String getGout="select go_no as id from gate_out_hdr where cro_no=?";
			
	public static final String getGin="select gate_in_no as id from gate_in_hdr where gate_out_no=?";
	
	public static final String getShipmentOrder="";
	
	public static final String getBl="";
}
