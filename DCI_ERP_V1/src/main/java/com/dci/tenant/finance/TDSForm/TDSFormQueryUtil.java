package com.dci.tenant.finance.TDSForm;

public class TDSFormQueryUtil {

	public static final String GENERATE_CODE = "SELECT  case when (select max(tds_code )from tds_master where tds_code~*?)" + " is null then '0001' ELSE   lpad(cast(cast((SUBSTRING((select max(tds_code) from tds_master where tds_code~*?),2))" + " as int)+1  as text),4,'0')  END";

	public static final String LIST = "select tds_code as tdsauto,code as tdscode,name as tdsname,tds_type as tdsType,tds_desc as tdsDesc from tds_master";

	public static final String Editbankcompanyvalues = "select tds_code as tdsauto, code as tdscode,name as tdsname,tds_type as tdsType," + "tds_desc as tdsDesc  " + " from tds_master b where tds_code=?";

	public static String sInsertSubGroup = "insert into tds_master (tds_code,name,code,tds_desc,tds_type)values(?,?,?,?,?)";

	public static String delete = "delete from tds_master where tds_code=?";

	public static String sUpdateSubGroup = "update tds_master set code =? ,name =? ,tds_type=? ,tds_desc=? where tds_code=? ";

}
