package com.dci.tenant.finance.journalVoucherType;

public class JournalVoucherTypeQueryUtil {

	public static final String SELECT_LIST = "select  journalvoucher_type_id as journalVoucherTypeId,name,description,active from  journalvoucher_type ";

	public static final String SELECT__JV_LIST = "select  journalvoucher_type_id as id,name as text, journalvoucher_type_id as journalVoucherTypeId,name from  journalvoucher_type where active=true";

	public static String JVTypeIdAutoGen = "SELECT CASE WHEN MAX(journalvoucher_type_id) IS NULL THEN '1' ELSE MAX(journalvoucher_type_id)+1 END FROM journalvoucher_type";

	public static final String SELECT_JVTYPE_BY_ID = "select journalvoucher_type_id ,name,description,active from journalvoucher_type where journalvoucher_type_id=?";

	public static final String INSERT_JVTYPE = "INSERT INTO journalvoucher_type(name,description,active) VALUES (:name,:description,:active)";

	public static final String UPDATE_JVTYPE = "UPDATE journalvoucher_type SET name=:name,description=:description,active=:active WHERE journalvoucher_type_id=:journalvoucher_type_id";

	public static final String DELETE_JVTYPE = "DELETE FROM journalvoucher_type WHERE journalvoucher_type_id=?";
}
