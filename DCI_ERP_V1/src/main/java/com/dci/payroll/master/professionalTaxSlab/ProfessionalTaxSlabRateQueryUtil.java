package com.dci.payroll.master.professionalTaxSlab;

public class ProfessionalTaxSlabRateQueryUtil {

	public static final String SAVE_SLAB_RATE_HDR = " insert into professional_slab_rate_tax_hdr (from_date,to_date,created_by,created_date) values (to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,now())  RETURNING slab_hdr_id";

	public static final String SAVE_SLAB_RATE_DTL = " insert into professional_slab_rate_tax_dtl (slab_name,range_from,range_to,professional_tax,created_by,created_date,slab_hdr_id) values (?,?::numeric,?::numeric,?::numeric,?,now(),?)";

	public static final String SLAB_LIST = "select slab_hdr_id as slabHdrId, to_char(from_date,'dd/mm/yyyy') as fromDate, to_char(to_date,'dd/mm/yyyy') as toDate from professional_slab_rate_tax_hdr order by fromDate asc ";

	public static final String SLAB_LIST_EDIT = "select to_char(from_date,'dd/mm/yyyy') as fromDate, to_char(to_date,'dd/mm/yyyy') as toDate,slab_hdr_id as slabHdrId from professional_slab_rate_tax_hdr where slab_hdr_id=?";

	public static final String getValidate = "select count(*) from professional_slab_rate_tax_hdr where created_by=? and (from_date, to_date) overlaps (to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'))";

	public static final String getEditValidate = "select count(*) from professional_slab_rate_tax_hdr where created_by=? and slab_hdr_id<>? and (from_date, to_date) overlaps (to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'))";

	/*
	 * public static final String SLAB_LIST_EDIT_DTL =
	 * "select slab_name as slabName, range_from as rangeFromAmount,range_to as rangeToAmount,professional_tax as professionaltax,hdr.slab_hdr_id as slabHdrId, to_char(from_date,'dd/mm/yyyy') as fromDate,to_char(to_date,'dd/mm/yyyy') as toDate from professional_slab_rate_tax_dtl dtl inner join professional_slab_rate_tax_hdr hdr on hdr.slab_hdr_id=dtl.slab_hdr_id where hdr.slab_hdr_id=?"
	 * ;
	 */
	public static final String SLAB_LIST_EDIT_DTL = "select slab_name as slabName, range_from as rangeFromAmount,range_to as rangeToAmount,professional_tax as professionaltax from professional_slab_rate_tax_dtl  where slab_hdr_id=?";

	public static final String UPDATE_SLAB_RATE_HDR = " update professional_slab_rate_tax_hdr set from_date=to_date(?,'dd/mm/yyyy'), to_date=to_date(?,'dd/mm/yyyy'),modified_by=?,modified_date=now() where slab_hdr_id =?";

	public static final String UPDATE_SLAB_RATE_DTL = " update professional_slab_rate_tax_dtl set slab_name=?,range_from=?::numeric,range_to=?::numeric,professional_tax=?::numeric,modified_by=?,modified_date=now() where slab_hdr_id =?";

	public static final String DELETE_DETAIL = "delete from professional_slab_rate_tax_dtl where slab_hdr_id=? ";

	public static final String DELETE_HEADER = "delete from professional_slab_rate_tax_hdr where slab_hdr_id=? ";

	public static String DUPLICATE_COUNT = "select  count(*) from professional_slab_rate_tax_hdr where to_date(?,'dd/mm/yyyy') between from_date and to_date or to_date(?,'dd/mm/yyyy') between from_date and to_date ";
}
