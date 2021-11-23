package com.dci.tenant.container.containerstatussequence;

public class ContainerStatusSequenceQueryUtil {
	

    
    public static final String containersequencestatus_list ="select sequence,sequencem as sequenceS from containerstatussequence order by sequence";
	
	public static final String containerstatussequence_hdr_insert= "INSERT INTO containerstatussequence (sequence, created_by, created_dt) values (?,?,now())";
	
	public static final String containerstatussequence_hdr_edit="select concat(css.sequence, ' - ', cds.containerstatus_description) as sequence,sequencem as sequenceS,emc.user_name as createdBy ,to_char(css.CREATED_DT,'dd/MM/yyyy')  as createdDate, " +
" emm.user_name  AS modifiedBy,to_char(css.MODIFIED_DT,'dd/MM/yyyy') AS modifiedDate from containerstatussequence css " +
" left join container_status cds on cds.containerstatus_code = css.sequence left join user_master emc on emc.user_id = css.CREATED_BY " +
" left join user_master emm on emm.user_id = css.MODIFIED_BY where sequence=?";
	
	public static final String containerstatussequence_hdr_update="update containerstatussequence set sequence=? where sequence=?";

	public static final String containerstatussequence_hdr_delete="delete from containerstatussequence where sequence =?";
	
	public static final String containerstatussequence_dtl_delete="delete from containerstatussequence_dtl where sequence =?";

	public static final String containerstatussequence_dtl_insert= "INSERT INTO containerstatussequence_dtl (sequence, direction, status) values (?,?,?)";

	public static final String containerstatussequence_dtl_edit="select sequence, id, text from containerstatussequence_dtl  where sequence =?";

	public static final String containerstatussequence_dtl_update="update containerstatussequence_dtl set status=? where sequence=?";

	public static final String generateSequence ="select 'CSS' || lpad( (coalesce(max( substring(sequence,4)::int),0)+1)::text,4,'0') from containerstatussequence";
		
	public static final String getStatusList="select distinct containerstatus_code as id ,concat(containerstatus_code,' - ',containerstatus_description) as text from container_status order by containerstatus_code asc";
	
	public static final String get_container_status= "select containerstatus_code as id,concat(containerstatus_code,'-',containerstatus_description) as text from container_status where containerstatus_code !='OFH' order by containerstatus_code  asc";
	
	public static final String save= "INSERT INTO containerstatussequence (sequence,sequenceM, created_by, created_dt) values (?,?,?,now())";
	
	public static final String save_dtl= "INSERT INTO containerstatussequence_dtl (sequence,id, text) values (?,?,?)";

}
