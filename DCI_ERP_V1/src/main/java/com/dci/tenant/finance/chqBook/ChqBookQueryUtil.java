package com.dci.tenant.finance.chqBook;

public class ChqBookQueryUtil {

	public static final String GET_STATUS_LIST = "select def_table_id as id,value as text from def_table " + "where form_field_id = 73";

	public static final String GET_CHQ_BOOK_LIST = "select cd.chq_book_id as chqBookId,ahm.acct_head_code as bankAccountId,ahm.acct_head_name as bankAccountName,TO_CHAR(cd.valid_from,'dd/mm/yyyy') as validFrom,TO_CHAR(cd.valid_to,'dd/mm/yyyy') as validTo, cd.cheque_number as chqNo,TO_CHAR(cd.cheque_date,'dd/mm/yyyy') as chequeDate,df.value as statusName from cheque_details cd left join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code = cd.bank_account inner join def_table df on df.def_table_id = cd.cheque_status order by cd.chq_book_id desc";

	public static final String INSERT_CHQ_BOOK = "insert into cheque_details(bank_account,valid_from,valid_to,cheque_status,cheque_number,cheque_date) values(:bankAccountId,to_date(:validFrom,'dd/mm/yyyy'),to_date(:validTo,'dd/mm/yyyy'),:statusId,:chequeNumber,to_date(:chequeDate,'dd/mm/yyyy'))";

	public static final String getEditList = "select cd.chq_book_id as chqBookId,ahm.acct_head_code as bankAccountId,ahm.acct_head_name as bankAccountName,TO_CHAR(cd.valid_from,'dd/mm/yyyy') as validFrom,TO_CHAR(cd.valid_to,'dd/mm/yyyy') as validTo, cd.cheque_number as chqNo,TO_CHAR(cd.cheque_date,'dd/mm/yyyy') as chequeDate,df.value as statusName,df.def_table_id as statusId from cheque_details cd left join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code = cd.bank_account inner join def_table df on df.def_table_id = cd.cheque_status where cd.chq_book_id = ?";

	public static final String UPDATE_CHQ_BOOK = "update cheque_details set bank_account=:bankAccountId,valid_from = to_date(:validFrom,'dd/mm/yyyy'),valid_to = to_date(:validTo,'dd/mm/yyyy'),cheque_status = :statusId,cheque_number = :chqNo,cheque_date = to_date(:chequeDate,'dd/mm/yyyy') where chq_book_id = :chqBookId";

	public static final String DELETE_CHQ_BOOK = "delete from cheque_details where chq_book_id = ?";

	public static final String GET_CHQ_BOOK = "select cd.chq_book_id as chqBookId,ahm.acct_head_code as bankAccountId,ahm.acct_head_name as bankAccountName,TO_CHAR(cd.valid_from,'dd/mm/yyyy') as validFrom,TO_CHAR(cd.valid_to,'dd/mm/yyyy') as validTo, cd.cheque_number as chqNo,TO_CHAR(cd.cheque_date,'dd/mm/yyyy') as chequeDate,df.value as statusName from cheque_details cd left join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code = cd.bank_account inner join def_table df on df.def_table_id = cd.cheque_status order by cd.chq_book_id desc";

	public static final String GENERATE_CODE = "SELECT  case when (select max(cheque_number )from cheque_details where cheque_number~*?)" + " is null then '0001' ELSE   lpad(cast(cast((SUBSTRING((select max(cheque_number) from cheque_details where cheque_number~*?),2))" + " as int)+1  as text),4,'0')  END";

}
