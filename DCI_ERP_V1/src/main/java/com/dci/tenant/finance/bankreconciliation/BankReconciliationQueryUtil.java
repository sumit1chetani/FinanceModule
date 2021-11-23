package com.dci.tenant.finance.bankreconciliation;

public class BankReconciliationQueryUtil {

	public static String GET_DRAFT_COUNT = "select count(*) from bank_reconcile_stmt_draft_new where transaction_no  = ?";
	public static String GET_RECONCILE_COUNT = "select count(*) from bank_reconcile_stmt where transaction_no  = ?";

	// public static String GETBANKLIST =
	// "select bank_id as id,bank_name as text from cash_bank_hdr";

	public static String GETBANKLIST = "select ahm.Acct_Head_Code id,ahm.Acct_Head_Name as text,ahm.Acct_Head_Code acctHeadCode, " + "ahm.Acct_Head_Name accountName, ahm.acct_currency currencyCode,COALESCE(curr.currency_default,'0') as  exchangeRate, " + "COALESCE(curr.CURRENCY_CONVER_FROM,'0') fromCurrency,COALESCE(curr.CURRENCY_CONVER_TO,'0') toCurrency,COALESCE(curr.Currency_fraction,'0') currencyFraction " + "from ACCOUNT_HEAD_MASTER ahm  left join currency  curr on  curr.crrncy_cd = ahm.acct_currency " + "where SUBGROUP_ACCT_CODE = '1003'";

	public static String INSERTBANKSTATEMENT = " Insert into bank_stmt (TRANSACTION_DATE,CHEQUE_NO,VALUE_DATE,DEBIT_AMT,CREDIT_AMT," + "CLOSING_BAL,NARRATION,STATEMENT,BANK_ACCOUNT_CODE)" + "values (TO_DATE (?, 'DD/MM/YYYY'),?,TO_DATE (?, 'DD/MM/YYYY'),?,?,?,?,?,?)";

	public static String GET_STATEMENT_AVAILABLITY = "select * from bank_stmt where (value_date  between TO_DATE (?, 'DD-MM-YYYY') and TO_DATE (?, 'DD-MM-YYYY')) and bank_account_code =?";
	public static String GET_STATEMENT_AVAILABLITY1 = "select * from BANK_RECONCILE_STMT where (value_date  between TO_DATE (?, 'DD-MM-YYYY') and TO_DATE (?, 'DD-MM-YYYY')) and bank_account_code =?";

	public static String GET_DIFFERENCE_LIST = "select bank_stmt_id as bank_stmt_id,transaction_no as transaction_no,bank_account_code as bank_account_code, to_char(book_date,'dd/mm/yyyy') as book_date,book_cheque_no as book_cheque_no,to_char(book_cheque_date,'dd/mm/yyyy') as book_cheque_date,  book_debit_amt,book_credit_amt,book_narration as book_narration,bank_cheque_no as bank_cheque_no,to_char(bank_date,'dd/mm/yyyy') as bank_date,  bank_debit_amt as bank_debit_amt,bank_credit_amt as bank_credit_amt from BANK_RECONCILE  where"
			+ " BANK_STMT_ID NOT IN(select BOOK_STATEMENT_ID from BANK_RECONCILE_STMT) and BANK_DATE between TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (?, 'DD/MM/YYYY')";

	// public static String GET_DIFFERENCE_LIST_WITH_BANK = "select bank_stmt_id
	// as
	// bank_stmt_id,transaction_no as transaction_no,bank_account_code as
	// bank_account_code, to_char(book_date,'dd/mm/yyyy') as
	// book_date,book_cheque_no as
	// book_cheque_no,to_char(book_cheque_date,'dd/mm/yyyy') as
	// book_cheque_date,
	// book_debit_amt,book_credit_amt,book_narration as
	// book_narration,bank_cheque_no as
	// bank_cheque_no,to_char(bank_date,'dd/mm/yyyy') as bank_date,
	// bank_debit_amt
	// as bank_debit_amt,bank_credit_amt as bank_credit_amt from BANK_RECONCILE
	// where BANK_STMT_ID NOT IN(select BOOK_STATEMENT_ID from
	// BANK_RECONCILE_STMT)
	// "
	// + "AND BANK_DATE between TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (?,
	// 'DD/MM/YYYY') " + "AND BOOK_DATE between TO_DATE (?, 'DD/MM/YYYY') and
	// TO_DATE (?, 'DD/MM/YYYY') " + "and BANK_ACCOUNT_CODE=?";

	public static String GET_DIFFERENCE_LIST_WITH_BANK = "select BANK_STMT_ID as bank_stmt_id,BANK_ACCOUNT_CODE as bank_account_code,TO_CHAR(TRANSACTION_DATE,'DD-MM-YYYY') as bank_date,CHEQUE_NO as bank_cheque_no,TO_CHAR(VALUE_DATE,'DD-MM-YYYY') as bank_approved_date, DEBIT_AMT as bank_debit_amt,CREDIT_AMT as bank_credit_amt from BANK_STMT where BANK_STMT_ID  not in (select BOOK_STATEMENT_ID from BANK_RECONCILE_STMT) AND TRANSACTION_DATE between TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY') AND BANK_ACCOUNT_CODE =?";

	// public static String GET_DIFFERENCE_LIST_WITH_BANK_NEW = "with t as(\r\n"
	// + "select BANK_STMT_ID as bank_stmt_id,BANK_ACCOUNT_CODE as
	// bank_account_code,TO_CHAR(TRANSACTION_DATE,'DD-MM-YYYY') as
	// bank_date,CHEQUE_NO as bank_cheque_no,TO_CHAR(VALUE_DATE,'DD-MM-YYYY') as
	// bank_approved_date, coalesce(DEBIT_AMT,0) as
	// bank_debit_amt,coalesce(CREDIT_AMT,0) as bank_credit_amt from BANK_STMT
	// where
	// BANK_STMT_ID not in (select BOOK_STATEMENT_ID from BANK_RECONCILE_STMT)
	// AND
	// TRANSACTION_DATE between TO_DATE (? , 'DD-MM-YYYY') AND TO_DATE (? ,
	// 'DD-MM-YYYY') AND BANK_ACCOUNT_CODE =? ) , \r\n" + "t1 as (\r\n"
	// + "select * from vw_unreconciled_transactiont() WHERE voucher_date
	// between
	// TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY') AND BANK_CODE=? )
	// select
	// bank_stmt_id,bank_account_code,bank_date,bank_cheque_no,bank_approved_date,coalesce(bank_debit_amt,0)
	// as bank_debit_amt,coalesce(bank_credit_amt,0) as bank_credit_amt
	// ,BANK_STMT_ID,transaction_no, book_date, voucher_date,book_cheque_no,
	// book_cheque_date,coalesce(book_credit_amt,0) as book_credit_amt ,
	// coalesce(book_debit_amt,0) as book_debit_amt ,book_narration from t full
	// outer join t1 on bank_cheque_no = book_cheque_no";
	public static String GET_DIFFERENCE_LIST_WITH_BANK_NEW1 = "select * from unreconciled_records(?,?,?)";
	public static String GET_DIFFERENCE_LIST_WITH_BANK_NEW = "select * from unreconciled_records(?,?,?)";

	/// public static String GET_DIFFERENCE_LIST_WITH_BANK_NEW1 = "with t
	/// as(select
	/// BANK_STMT_ID as bank_stmt_id,BANK_ACCOUNT_CODE as
	/// bank_account_code,TO_CHAR(TRANSACTION_DATE,'DD-MM-YYYY') as
	/// bank_date,CHEQUE_NO as bank_cheque_no,TO_CHAR(VALUE_DATE,'DD-MM-YYYY')
	/// as
	/// bank_approved_date, coalesce(DEBIT_AMT,0) as
	/// bank_debit_amt,coalesce(CREDIT_AMT,0) as bank_credit_amt from BANK_STMT
	/// where BANK_STMT_ID not in (select BOOK_STATEMENT_ID from
	/// BANK_RECONCILE_STMT) AND TRANSACTION_DATE between TO_DATE (?,
	/// 'DD-MM-YYYY')
	/// AND TO_DATE (?, 'DD-MM-YYYY') ) ,t1 as (select * from
	/// vw_unreconciled_transactiont() WHERE voucher_date between TO_DATE (?,
	/// 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY') ) select
	/// bank_stmt_id,bank_account_code,bank_date,bank_cheque_no,bank_approved_date,coalesce(bank_debit_amt,0)
	/// as bank_debit_amt,coalesce(bank_credit_amt,0) as bank_credit_amt
	/// ,BANK_STMT_ID,transaction_no, book_date, voucher_date,book_cheque_no,
	/// book_cheque_date,coalesce(book_credit_amt,0) as book_credit_amt ,
	/// coalesce(book_debit_amt,0) as book_debit_amt ,book_narration from t full
	/// outer join t1 on bank_cheque_no = book_cheque_no ";

	public static String GET_DIFFERENCE_LIST_WITH_BANK1 = "select BANK_STMT_ID as bank_stmt_id,BANK_ACCOUNT_CODE as bank_account_code,TO_CHAR(TRANSACTION_DATE,'DD-MM-YYYY') as bank_date,CHEQUE_NO as bank_cheque_no,TO_CHAR(VALUE_DATE,'DD-MM-YYYY') as bank_approved_date, coalesce(DEBIT_AMT,0) as bank_debit_amt,coalesce(CREDIT_AMT,0) as bank_credit_amt from BANK_STMT where BANK_STMT_ID  not in (select BOOK_STATEMENT_ID from BANK_RECONCILE_STMT) AND TRANSACTION_DATE between TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY') ";
	public static String GET_DIFFERENCE_LIST_WITH_BOOK1 = "select * from vw_unreconciled_transactiont() WHERE voucher_date between TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY')";

	public static String GET_DIFFERENCE_LIST_WITH_BOOK = "select * from vw_unreconciled_transactiont() WHERE voucher_date between TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY') AND BANK_CODE=?";
	public static String Reconcile_mail = " select bank_stmt_id as bank_stmt_id,transaction_no as transaction_no,bank_account_code as bank_account_code,to_char(book_date,'dd/mm/yyyy') as book_date,book_cheque_no as book_cheque_no,to_char(book_cheque_date,'dd/mm/yyyy') as book_cheque_date,book_debit_amt,book_credit_amt,book_narration as book_narration,bank_cheque_no as bank_cheque_no,to_char(bank_date,'dd/mm/yyyy') as bank_date,bank_debit_amt as bank_debit_amt,bank_credit_amt as bank_credit_amt from BANK_RECONCILE where  BANK_STMT_ID NOT IN(select distinct BOOK_STATEMENT_ID from BANK_RECONCILE_STMT where status is null) order by bank_stmt_id asc";

	// public static String INSERT_RECONCILE_STMT = "INSERT INTO
	// bank_reconcile_stmt_new(transaction_no, cheque_dt, cheque_no, debit, " +
	// "credit, customer, transaction_type, narration, document_type,
	// document_date,
	// bank_date,remarks,bank_balance_as_per_bank,bank_balance_as_per_bank_usd,bank_balance_as_per_book,difference,bank_code,to_date,from_date,receipt_difference,payment_difference,tcdebit,tccredit)
	// "
	// + "
	// VALUES(?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?)";
	public static String INSERT_RECONCILE_STMT = "INSERT INTO BANK_RECONCILE_STMT(transaction_no, book_cheque_date, book_cheque_no, book_debit_amt, " + "book_credit_amt, bank_cheque_no, bank_date, bank_debit_amt, bank_credit_amt, remarks, book_statement_id,bank_account_code,customer) " + " VALUES(?,to_date(?,'dd/mm/yyyy'),?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?)";
	public static String INSERT_EXCLUDED_STMT = "INSERT INTO bank_excluded_stmt(transaction_no, cheque_dt, cheque_no, debit, " + "credit, customer, transaction_type, narration, document_type, document_date, bank_date,remarks,bank_balance_as_per_bank,bank_balance_as_per_book,difference,bank_code,to_date,from_date,receipt_difference,payment_difference) " + " VALUES(?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),now(),?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?)";

	public static String BANK_RECONCILE_STMTprint = "INSERT INTO BANK_RECONCILE_STMT(transaction_no, book_cheque_date, book_cheque_no, book_debit_amt, " + "book_credit_amt, bank_cheque_no, bank_date, bank_debit_amt, bank_credit_amt, book_statement_id,bank_account_code,status) " + " VALUES(?,to_date(?,'dd/mm/yyyy'),?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?)";
	public static String INSERT_RECONCILE_STMT_DRAFTS = "INSERT INTO bank_reconcile_stmt_draft_new(transaction_no, cheque_dt, cheque_no, debit, " + "credit, customer, transaction_type, narration, document_type, document_date, bank_date,remarks,bank_balance_as_per_bank,bank_balance_as_per_book,difference,bank_code,to_date,from_date,receipt_difference,payment_difference) " + " VALUES(?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?)";

	public static String GET_RECONCILE_LIST = "with a as " + " (    select distinct c.voucher_no as transactionNo,to_char(c.cheque_dt,'dd/mm/yyyy') as chqDt,c.cheque_no as chqNo,'Payment' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as docdate,c.bc_amount as creditamount,   " + "  				0 as debitamount,string_agg(case when not null_or_empty(dtl.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,narration,c.cheque_no as transactionType,c.BANK_ACCT as bank     "
			+ "  				from cashbank_pay_hdr c        " + "  					left outer join cashbank_pay_dtl dtl on dtl.voucher_no=c.voucher_no        " + "  							left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=c.BANK_ACCT     " + "  								inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=dtl.acct_head       " + "  									left outer join service_partner sp on sp.acct_head_code=dtl.sub_account_code      "
			+ "  						where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')     " + "  		group by transactionNo, chqDt,doctype,creditamount,debitamount   " + "  			union        "

			+ "  				select crh.voucher_no as transactionNo,to_char(crh.cheque_dt,'dd/mm/yyyy') as chqDt,crh.cheque_no as chqNo,'Receipt' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as docdate,0 as creditamount,   " + "  				crh.bc_amount as debitamount,string_agg(case when not null_or_empty(crd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end,',')  as supplier,narration,crh.cheque_no as transactionType,crh.BANK_ACCT as bank   " + "  				from cashbank_receipt_hdr crh        "
			+ "  				left outer join cashbank_receipt_dtl crd on crd.voucher_no=crh.voucher_no     " + "  						left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=crh.BANK_ACCT    " + "  				                         inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=crd.acct_head      " + "   		            		 		left outer join service_partner sp on sp.acct_head_code=crd.sub_account_code      "
			+ "  				where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')   " + "  		group by transactionNo, chqDt,doctype,creditamount,debitamount  "

			+ "  			union       " + " 					select cheque_no as transactionNo,to_char(cheque_date,'dd/mm/yyyy') as chqDt,cheque_no as chqNo,voucher_type doctype,to_char(unreconcile_date,'dd/mm/yyyy') as docdate,credit as creditamount,  " + "  					debit as debitamount,particulars as supplier,'' as narration,transaction_type as transactionType,bank_code as bank  from unreconcile_bank  "

			+ "  				               union      "

			+ "  			               	             select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,journal_creditusd as creditamount,0 as debitamount,  " + " 			             	 string_agg(case when not null_or_empty( jd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank    "
			+ "  				  from journalvoucher_hdr jh       " + "  				  inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no    " + "  						  left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head   " + "  						 	inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head    " + " 				left outer join service_partner sp on sp.acct_head_code=jd.sub_account_code       "
			+ "  								where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')  and journal_creditusd !=0  " + "  		group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank   "

			+ " 				union     "

			+ "			                select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype ,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,0 as creditamount,journal_debitusd as debitamount,  " + " 			                	string_agg(case when not null_or_empty( jd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank   "
			+ "			  from journalvoucher_hdr jh       " + " 			  inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no    " + "					left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head     " + " 								inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head    " + "											left outer join service_partner sp on sp.acct_head_code=jd.sub_account_code     "
			+ "				where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014') and journal_debitusd !=0 group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank ) "
			+ " select * from a where TO_DATE (docdate, 'DD/MM/YYYY') >= TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (docdate, 'DD/MM/YYYY') <=TO_DATE (?, 'DD/MM/YYYY') and a.transactionNo not in (select transaction_no from bank_reconcile_stmt_draft_new ) and a.transactionNo not in (select transaction_no from bank_reconcile_stmt_new ) order by docdate desc";

	/*
	 * public static String GET_RECONCILE_LIST_WITH_BANK = "with a as  " +
	 * "  (   select distinct c.voucher_no as transactionNo,to_char(c.cheque_dt,'dd/mm/yyyy') as chqDt,c.cheque_no as chqNo,'Payment' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as docdate,c.bc_amount as creditamount,c.tc_amount as tcCreditAmount,0 as tcDebitAmount,  "
	 * +
	 * " 				0 as debitamount,string_agg(case when not null_or_empty(dtl.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,narration,c.cheque_no as transactionType,c.BANK_ACCT as bank     "
	 * + "  				from cashbank_pay_hdr c        " +
	 * "   					left outer join cashbank_pay_dtl dtl on dtl.voucher_no=c.voucher_no        "
	 * +
	 * "   							left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=c.BANK_ACCT     "
	 * +
	 * "  								inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=dtl.acct_head       "
	 * +
	 * "  									left outer join service_partner sp on sp.acct_head_code=dtl.sub_account_code    "
	 * +
	 * "  			where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')  "
	 * + "   		group by transactionNo, chqDt,doctype,creditamount,debitamount "
	 * + "   			union      "
	 * 
	 * +
	 * "   				select crh.voucher_no as transactionNo,to_char(crh.cheque_dt,'dd/mm/yyyy') as chqDt,crh.cheque_no as chqNo,'Receipt' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as docdate,0 as creditamount,0 as tcCreditAmount,  crh.tc_amount as tcDebitAmount,  "
	 * +
	 * "   				crh.bc_amount as debitamount,string_agg(case when not null_or_empty(crd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end,',')  as supplier,narration,crh.cheque_no as transactionType,crh.BANK_ACCT as bank    "
	 * + " 				from cashbank_receipt_hdr crh        " +
	 * "  				left outer join cashbank_receipt_dtl crd on crd.voucher_no=crh.voucher_no     "
	 * +
	 * "  						left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=crh.BANK_ACCT    "
	 * +
	 * "   				                         inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=crd.acct_head     "
	 * +
	 * "   		            		 		left outer join service_partner sp on sp.acct_head_code=crd.sub_account_code   "
	 * +
	 * "  				where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')   "
	 * +
	 * "  		group by transactionNo, chqDt,doctype,creditamount,debitamount   "
	 * 
	 * + " 			union     " +
	 * " 					select cheque_no as transactionNo,to_char(cheque_date,'dd/mm/yyyy') as chqDt,cheque_no as chqNo,voucher_type doctype,to_char(unreconcile_date,'dd/mm/yyyy') as docdate,credit as creditamount,credit as tcCreditAmount,debit as tcDebitAmount,  "
	 * +
	 * " 					debit as debitamount,particulars as supplier,'' as narration,transaction_type as transactionType,bank_code as bank  from unreconcile_bank    "
	 * 
	 * + " 			               union       "
	 * 
	 * +
	 * " 		               	             select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,journal_creditusd as creditamount,journal_credit as tcCreditAmount,0 as tcDebitAmount,0 as debitamount,  "
	 * +
	 * " 		             	 string_agg(case when not null_or_empty( jd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank     "
	 * + " 			  from journalvoucher_hdr jh        " +
	 * " 			  inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no      "
	 * +
	 * " 					  left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head     "
	 * +
	 * " 					 	inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head     "
	 * +
	 * " 			left outer join service_partner sp on sp.acct_head_code=jd.sub_account_code    "
	 * +
	 * " 							where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')  and journal_creditusd !=0   "
	 * +
	 * " 	group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank,tcCreditAmount,tcDebitAmount  "
	 * 
	 * + " 		union       "
	 * 
	 * +
	 * " 	                select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype ,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,0 as creditamount,0 as tcCreditAmount,journal_debit as tcDebitAmount,journal_debitusd as debitamount,  "
	 * +
	 * " 	                	string_agg(case when not null_or_empty( jd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank   "
	 * + " 	  from journalvoucher_hdr jh        " +
	 * " 	  inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no    " +
	 * " 			left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head     "
	 * +
	 * " 						inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head      "
	 * +
	 * " 									left outer join service_partner sp on sp.acct_head_code=jd.sub_account_code     "
	 * +
	 * " 		where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014') and journal_debitusd !=0 group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank,tcCreditAmount,tcDebitAmount  )  "
	 * 
	 * +
	 * " 	select * from a  where TO_DATE(docdate, 'DD/MM/YYYY') >= TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (docdate, 'DD/MM/YYYY') <=TO_DATE (?, 'DD/MM/YYYY') and bank =? and a.transactionNo not in (select transaction_no from bank_reconcile_stmt_draft_new ) and a.transactionNo not in (select transaction_no from bank_reconcile_stmt_new where bank_code=? ) and   a.transactionNo not in (select transaction_no from bank_excluded_stmt where bank_code=? )order by docdate desc"
	 * ;
	 */

	/*
	 * public static String GET_RECONCILE_LIST_WITH_BANK =
	 * "with a as(select crh.voucher_no as transactionNo,to_char(crh.cheque_dt,'dd/mm/yyyy') as chqDt,crh.cheque_no as chqNo,'Receipt' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as docdate,0 as creditamount,0 as tcCreditAmount, "
	 * +
	 * "0 as tcDebitAmount,0 as debitamount,narration,crh.cheque_no as transactionType, "
	 * + "crh.BANK_ACCT as bank " + "from cashbank_receipt_hdr crh " +
	 * "left outer join cashbank_receipt_dtl crd on crd.voucher_no=crh.voucher_no "
	 * +
	 * "left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=crh.BANK_ACCT "
	 * + "inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=crd.acct_head " +
	 * "where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014') "
	 * + "group by transactionNo, chqDt,doctype,creditamount " + " " + " " +
	 * "union " + " " +
	 * "select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,journal_creditusd as creditamount,journal_credit as tcCreditAmount,0 as tcDebitAmount,0 as debitamount, "
	 * +
	 * "jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank "
	 * + "from journalvoucher_hdr jh " +
	 * "inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no " +
	 * "left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head "
	 * +
	 * "inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head "
	 * +
	 * "where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')  and journal_creditusd !=0 "
	 * +
	 * "group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank,tcCreditAmount,tcDebitAmount "
	 * + " " + "union " + " " +
	 * "select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype ,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,0 as creditamount,0 as tcCreditAmount,journal_debit as tcDebitAmount,journal_debitusd as debitamount, "
	 * +
	 * "jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank "
	 * + "from journalvoucher_hdr jh " +
	 * "inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no " +
	 * "left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head "
	 * +
	 * "inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head "
	 * +
	 * "where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014') and journal_debitusd !=0 "
	 * +
	 * "group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank,tcCreditAmount,tcDebitAmount ) "
	 * + " " +
	 * "select * from a  where TO_DATE(docdate, 'DD/MM/YYYY') >= TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (docdate, 'DD/MM/YYYY') <=TO_DATE (?, 'DD/MM/YYYY') and bank =? "
	 * // + "and a.transactionNo not in (select transaction_no from //
	 * bank_reconcile_stmt_draft_new ) and a.transactionNo not in // (select
	 * transaction_no from bank_reconcile_stmt_new where // bank_code=? ) and
	 * a.transactionNo not in (select transaction_no // from bank_excluded_stmt
	 * where bank_code=? ) " + "order by docdate desc";
	 */

	public static String GET_RECONCILE_LIST_WITH_BANK = "with a as(select crh.voucher_no as transactionNo,to_char(crh.cheque_dt,'dd/mm/yyyy') " + "as chqDt,crh.cheque_no as chqNo,'Receipt' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as " + "docdate,0 as creditamount,0 as tcCreditAmount, 0 as tcDebitAmount,0 as debitamount,narration,crh.cheque_no " + " as transactionType, crh.BANK_ACCT as bank,r.retailer_name as supplier from cashbank_receipt_hdr crh left outer join cashbank_receipt_dtl crd "
			+ "on crd.voucher_no=crh.voucher_no left join retailer r on r.retailer_code= crd.sub_account_code  left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=crh.BANK_ACCT " + "inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=crd.acct_head where am.acct_head_code " + " not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014') " + " group by r.retailer_name,transactionNo, chqDt,doctype,creditamount   union  select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as "
			+ "chqDt,jh.journal_no as chqNo,'Contra' as doctype,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,journal_creditusd as creditamount,journal_credit as " + "tcCreditAmount,0 as tcDebitAmount,0 as debitamount, jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank, " + "'' as supplier " + "from journalvoucher_hdr jh inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code "
			+ "=jd.journal_account_head  inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head where am.acct_head_code " + "not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')  and journal_creditusd !=0 group by  supplier, " + " transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank,tcCreditAmount,tcDebitAmount  union " + " " + "  select jh.journal_no as "
			+ "transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype ,to_char(jh.journal_date,'dd/mm/yyyy') " + "as docdate,0 as creditamount,0 as tcCreditAmount,journal_debit as tcDebitAmount,journal_debitusd as debitamount, jd.journal_narration as narration, " + "jh.journal_no as transactionType,jd.journal_account_head as bank, '' as supplier from journalvoucher_hdr jh inner join journalvoucher_dtl jd on "
			+ " jd.journal_no=jh.journal_no left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head  inner " + "join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head where am.acct_head_code not " + "in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014') and journal_debitusd !=0 group by transactionNo, " + " chqDt,doctype,creditamount,debitamount,narration,bank,tcCreditAmount,tcDebitAmount )  select * from a  where TO_DATE(docdate, 'DD/MM/YYYY') >= "
			+ " TO_DATE (?, 'DD/MM/YYYY') " + "and TO_DATE (docdate, 'DD/MM/YYYY') <=TO_DATE (?, 'DD/MM/YYYY') and bank=? order by docdate desc";

	public static String GET_SHOW_RECONCILE_LIST = "select transaction_no,book_cheque_no,book_cheque_date,book_credit_amt,book_debit_amt ,bank_cheque_no, bank_date,bank_debit_amt,bank_credit_amt,remarks,book_statement_id, bank_account_code    from bank_reconcile_stmt where bank_date between TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY') and BANK_ACCOUNT_CODE = ?";

	public static String GET_RECONCILE_LIST_Draft = "select transaction_no as transactionNo ,to_char(cheque_dt,'dd/mm/yyyy') as chqDt , cheque_no as chqNo, debit as debitamount, credit as creditamount, customer as supplier,transaction_type as transactionType,narration as narration,document_type as doctype,to_char(document_date,'dd/mm/yyyy') as docdate,to_char(bank_date,'dd/mm/yyyy') as bank_date,remarks as remarks,bank_balance_as_per_bank as balanceAsPerBank,bank_balance_as_per_book as balanceAsPerBook,difference  as difference,bank_code as bank_account_code  from bank_reconcile_stmt_draft_new"
			+ " where document_date between TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (?, 'DD/MM/YYYY')";

	public static String GET_RECONCILE_LIST_New = "select transaction_no as transactionNo ,tccredit as tcCreditAmount,tcdebit as tcDebitAmount,to_char(cheque_dt,'dd/mm/yyyy') as chqDt , cheque_no as chqNo, debit as debitamount, credit as creditamount, customer as supplier,transaction_type as transactionType,narration as narration,document_type as doctype,to_char(document_date,'dd/mm/yyyy') as docdate,to_char(bank_date,'dd/mm/yyyy') as bank_date,remarks as remarks,bank_balance_as_per_bank as balanceAsPerBank,bank_balance_as_per_book as balanceAsPerBook,difference  as difference from bank_reconcile_stmt_new"
			+ " where document_date between TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (?, 'DD/MM/YYYY')";
	public static final String APPROVE_STATEMENT1 = "update  bank_reconcile_stmt set status=? where book_statement_id=?";
	public static final String APPROVE_STATEMENT = "update  bank_stmt set status=? where bank_stmt_id=?";

	public static final String REJECT_STATEMENT1 = "update  bank_reconcile_stmt set status=? where book_statement_id=?";
	public static final String REJECT_STATEMENT = "update  bank_stmt set status=? where bank_stmt_id=?";

	/*
	 * public static String GET_RECONCILE_LIST_WITH_BANK =
	 * "select transaction_no as transaction_no, to_char(book_cheque_date,'dd/mm/yyyy') as book_cheque_date, book_cheque_no as book_cheque_no, book_debit_amt as book_debit_amt, book_credit_amt as book_credit_amt, bank_cheque_no,to_char(bank_date,'dd/mm/yyyy') as bank_date,bank_debit_amt as bank_debit_amt, bank_credit_amt as bank_credit_amt, remarks as remarks, book_statement_id from BANK_RECONCILE_STMT"
	 * +
	 * " where bank_date between TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (?, 'DD/MM/YYYY')  and bank_account_code=?"
	 * ;
	 */

	public static String GET_UNRECONCILED_BANK_LIST = "select BANK_STMT_ID as bank_stmt_id,BANK_ACCOUNT_CODE as bank_account_code,TO_CHAR(TRANSACTION_DATE,'DD-MM-YYYY') as bank_date,CHEQUE_NO as bank_cheque_no,TO_CHAR(VALUE_DATE,'DD-MM-YYYY') as bank_approved_date, " + "DEBIT_AMT as bank_debit_amt,CREDIT_AMT as bank_credit_amt from BANK_STMT " + "where BANK_STMT_ID  not in (select BOOK_STATEMENT_ID from BANK_RECONCILE_STMT) AND TRANSACTION_DATE between TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY')";

	public static String GET_UNRECONCILED_BOOK_LIST = "select * from vw_unreconciled_transactiont() WHERE voucher_date between TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY')";
	public static String sCheck = "select count(*) from bank_stmt where value_date=TO_DATE (?, 'DD/MM/YYYY') and bank_account_code=?";
	public static String GET_UNRECONCILED_BANK_LIST_WITH_BANK = "select BANK_STMT_ID as bank_stmt_id,BANK_ACCOUNT_CODE as bank_account_code,TO_CHAR(TRANSACTION_DATE,'DD-MM-YYYY') as bank_date,CHEQUE_NO as bank_cheque_no,TO_CHAR(VALUE_DATE,'DD-MM-YYYY') as bank_approved_date, " + "DEBIT_AMT as bank_debit_amt,CREDIT_AMT as bank_credit_amt from BANK_STMT " + "where BANK_STMT_ID  not in (select BOOK_STATEMENT_ID from BANK_RECONCILE_STMT) AND TRANSACTION_DATE between TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY') AND BANK_ACCOUNT_CODE =?";

	public static String GET_UNRECONCILED_BOOK_LIST_WITH_BANK = "select * from vw_unreconciled_transactiont() WHERE voucher_date between TO_DATE (?, 'DD-MM-YYYY') AND TO_DATE (?, 'DD-MM-YYYY') AND BANK_CODE=?";
	public static final String PRINT_HEADER = "select bank_stmt_id as bank_stmt_id,transaction_no as transaction_no,bank_account_code as bank_account_code,to_char(book_date,'dd/mm/yyyy') as book_date,book_cheque_no as book_cheque_no,to_char(book_cheque_date,'dd/mm/yyyy') as book_cheque_date,book_debit_amt,book_credit_amt,bank_cheque_no as bank_cheque_no,to_char(bank_date,'dd/mm/yyyy') as bank_date,bank_debit_amt as bank_debit_amt,bank_credit_amt as bank_credit_amt from bank_reconcile where bank_stmt_id=?";

	public static final String PRINT_HEADER1 = "select bank_reconcile.bank_stmt_id as bank_stmt_id,transaction_no as transaction_no,bank_reconcile.bank_account_code as bank_account_code,to_char(book_date,'dd/mm/yyyy') as book_date,book_cheque_no as book_cheque_no,to_char(book_cheque_date,'dd/mm/yyyy') as book_cheque_date,book_debit_amt,book_credit_amt,bank_cheque_no as bank_cheque_no,to_char(bank_date,'dd/mm/yyyy') as bank_date,bank_debit_amt as bank_debit_amt,bank_credit_amt as bank_credit_amt,bank_stmt.status as isActive from bank_reconcile inner join bank_stmt on bank_stmt.bank_stmt_id=bank_reconcile.bank_stmt_id where  bank_reconcile.bank_stmt_id=? limit 1";
	public static final String delete_Draft = "delete from bank_reconcile_stmt_draft_new where transaction_no=?";
	public static final String Get_Sum_Reconcile = "with a as " + " (  select distinct c.voucher_no as transactionNo,to_char(c.cheque_dt,'dd/mm/yyyy') as chqDt,c.cheque_no as chqNo,'Payment' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as docdate,c.bc_amount as creditamount,   " + " 				0 as debitamount,string_agg(case when not null_or_empty(dtl.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,narration,c.cheque_no as transactionType,c.BANK_ACCT as bank    "
			+ "  				from cashbank_pay_hdr c       " + "  					left outer join cashbank_pay_dtl dtl on dtl.voucher_no=c.voucher_no       " + "  							left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=c.BANK_ACCT    " + "  								inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=dtl.acct_head      " + "  									left outer join service_partner sp on sp.acct_head_code=dtl.sub_account_code     "
			+ "  						where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')    " + "  		group by transactionNo, chqDt,doctype,creditamount,debitamount  " + "  			union       "

			+ " 				select crh.voucher_no as transactionNo,to_char(crh.cheque_dt,'dd/mm/yyyy') as chqDt,crh.cheque_no as chqNo,'Receipt' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as docdate,0 as creditamount,  " + "  				crh.bc_amount as debitamount,string_agg(case when not null_or_empty(crd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end,',')  as supplier,narration,crh.cheque_no as transactionType,crh.BANK_ACCT as bank  " + "  				from cashbank_receipt_hdr crh       "
			+ "  				left outer join cashbank_receipt_dtl crd on crd.voucher_no=crh.voucher_no       " + "  						left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=crh.BANK_ACCT      " + "  				                         inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=crd.acct_head     " + "  		            		 		left outer join service_partner sp on sp.acct_head_code=crd.sub_account_code   "
			+ "  				where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')   " + "  		group by transactionNo, chqDt,doctype,creditamount,debitamount  "

			+ "  			union       " + "  					select cheque_no as transactionNo,to_char(cheque_date,'dd/mm/yyyy') as chqDt,cheque_no as chqNo,voucher_type doctype,to_char(unreconcile_date,'dd/mm/yyyy') as docdate,credit as creditamount,  " + "  					debit as debitamount,particulars as supplier,'' as narration,transaction_type as transactionType,bank_code as bank  from unreconcile_bank   "

			+ "				               union      "

			+ "			               	             select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,journal_creditusd as creditamount,0 as debitamount,  " + " 			             	 string_agg(case when not null_or_empty( jd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank   "
			+ "				  from journalvoucher_hdr jh     " + "				  inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no   " + "						  left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head  " + " 						 	inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head    " + " 				left outer join service_partner sp on sp.acct_head_code=jd.sub_account_code       "
			+ " 								where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')  and journal_creditusd !=0  " + " 		group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank   "

			+ "				union      "

			+ "			                select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype ,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,0 as creditamount,journal_debitusd as debitamount,  " + "			                	string_agg(case when not null_or_empty( jd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank   "
			+ "			  from journalvoucher_hdr jh     " + "			  inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no      " + "					left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head     " + "								inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head   " + "											left outer join service_partner sp on sp.acct_head_code=jd.sub_account_code     "
			+ "			where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014') and journal_debitusd !=0 group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank  ) "
			+ "select coalesce(sum(debitamount)-sum(creditamount),0) from a where TO_DATE (docdate, 'DD/MM/YYYY') >= TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (docdate, 'DD/MM/YYYY') <=TO_DATE (?, 'DD/MM/YYYY') and a.transactionNo not in (select transaction_no from bank_reconcile_stmt_draft_new ) and a.transactionNo not in (select transaction_no from bank_reconcile_stmt_new ) order by docdate desc";
	public static final String Get_Sum_Reconcile_With_Bank = "with a as " + " (   select distinct c.voucher_no as transactionNo,to_char(c.cheque_dt,'dd/mm/yyyy') as chqDt,c.cheque_no as chqNo,'Payment' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as docdate,c.bc_amount as creditamount,   " + "  				0 as debitamount,string_agg(case when not null_or_empty(dtl.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,narration,c.cheque_no as transactionType,c.BANK_ACCT as bank    "
			+ "  				from cashbank_pay_hdr c       " + " 					left outer join cashbank_pay_dtl dtl on dtl.voucher_no=c.voucher_no       " + "  							left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=c.BANK_ACCT  " + "  								inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=dtl.acct_head   " + "  									left outer join service_partner sp on sp.acct_head_code=dtl.sub_account_code      "
			+ "  						where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')    " + "  		group by transactionNo, chqDt,doctype,creditamount,debitamount  " + "  			union       "

			+ " 				select crh.voucher_no as transactionNo,to_char(crh.cheque_dt,'dd/mm/yyyy') as chqDt,crh.cheque_no as chqNo,'Receipt' as doctype,to_char(voucher_dt,'dd/mm/yyyy') as docdate,0 as creditamount,   " + " 				crh.bc_amount as debitamount,string_agg(case when not null_or_empty(crd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end,',')  as supplier,narration,crh.cheque_no as transactionType,crh.BANK_ACCT as bank   " + " 				from cashbank_receipt_hdr crh       "
			+ "  				left outer join cashbank_receipt_dtl crd on crd.voucher_no=crh.voucher_no     " + "  						left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=crh.BANK_ACCT      " + "  				                         inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=crd.acct_head     " + "  		            		 		left outer join service_partner sp on sp.acct_head_code=crd.sub_account_code   "
			+ "  				where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')   " + "  		group by transactionNo, chqDt,doctype,creditamount,debitamount  "

			+ "  			union       " + " 					select cheque_no as transactionNo,to_char(cheque_date,'dd/mm/yyyy') as chqDt,cheque_no as chqNo,voucher_type doctype,to_char(unreconcile_date,'dd/mm/yyyy') as docdate,credit as creditamount,   " + "					debit as debitamount,particulars as supplier,'' as narration,transaction_type as transactionType,bank_code as bank  from unreconcile_bank   "

			+ " 				               union      "

			+ "			               	             select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,journal_creditusd as creditamount,0 as debitamount,   " + "			             	 string_agg(case when not null_or_empty( jd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank    "
			+ "				  from journalvoucher_hdr jh       " + "				  inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no      " + " 						  left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head   " + " 						 	inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head    " + " 				left outer join service_partner sp on sp.acct_head_code=jd.sub_account_code       "
			+ " 								where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014')  and journal_creditusd !=0   " + " 		group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank   "

			+ "				union      "

			+ "			                select jh.journal_no as transactionNo,to_char(jh.journal_date,'dd/mm/yyyy') as chqDt,jh.journal_no as chqNo,'Contra' as doctype ,to_char(jh.journal_date,'dd/mm/yyyy') as docdate,0 as creditamount,journal_debitusd as debitamount,      " + "		                	string_agg(case when not null_or_empty( jd.sub_account_code) then  sp.srvc_prtnr_nam else am.acct_head_name end ,',')  as supplier,jd.journal_narration as narration,jh.journal_no as transactionType,jd.journal_account_head as bank   "
			+ "		  from journalvoucher_hdr jh       " + "			  inner join journalvoucher_dtl jd on jd.journal_no=jh.journal_no  " + "				left outer join ACCOUNT_HEAD_MASTER ahm on ahm.acct_head_code=jd.journal_account_head  " + "								inner join ACCOUNT_HEAD_MASTER am on am.acct_head_code=jd.journal_account_head    " + "										left outer join service_partner sp on sp.acct_head_code=jd.sub_account_code     "
			+ "			where am.acct_head_code not in('20070001','20070002','20070003','20070004','20070005','10070008','50040003','50060014') and journal_debitusd !=0 group by transactionNo, chqDt,doctype,creditamount,debitamount,narration,bank  ) " + " "
			+ "select coalesce(sum(debitamount)-sum(creditamount),0) from a where TO_DATE(docdate, 'DD/MM/YYYY') >= TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (docdate, 'DD/MM/YYYY') <=TO_DATE (?, 'DD/MM/YYYY') and bank =? and a.transactionNo not in (select transaction_no from bank_reconcile_stmt_draft_new ) and a.transactionNo not in (select transaction_no from bank_reconcile_stmt_new )order by docdate desc";
	public static final String Get_balance_as_per_book_With_Bank = "select coalesce((select bank_balance_as_per_book from bank_reconcile_stmt_new where  bank_code=? and bank_balance_as_per_book is not null and bank_balance_as_per_book != 0),0)";

	public static final String Get_balance_as_per_book = "select coalesce((select bank_balance_as_per_book from bank_reconcile_stmt_new where bank_code= ? and  bank_balance_as_per_book is not null and bank_balance_as_per_book != 0),0)";
	public static final String Get_balance_as_per_bank = "select coalesce ((select bank_balance_as_per_bank from bank_reconcile_stmt_new where bank_code=? and    bank_balance_as_per_bank is not null  and bank_balance_as_per_bank !=0 order by to_date desc limit 1 ),0)";

	public static final String Get_balance_as_per_bank_With_Bank = "select coalesce ((select bank_balance_as_per_bank from bank_reconcile_stmt_new where  bank_code=? and bank_balance_as_per_bank is not null and bank_balance_as_per_bank !=0  order by to_date desc limit 1 ),0)";

	public static final String Get_balance_as_per_book_With_Bank_New = "select coalesce((select bank_balance_as_per_book from bank_reconcile_stmt_new where  bank_code=? and bank_balance_as_per_book is not null and bank_balance_as_per_book != 0),0)";
	public static final String Get_balance_as_per_bank_With_Bank_New = "select coalesce ((select bank_balance_as_per_bank from bank_reconcile_stmt_new where   bank_code=? and    bank_balance_as_per_bank is not null  and bank_balance_as_per_bank !=0 order by to_date desc limit 1 ),0)";

	public static final String GET_RECONCILE_LIST_New_With_Bank = "select transaction_no as transactionNo ,tccredit as tcCreditAmount,tcdebit as tcDebitAmount,to_char(cheque_dt,'dd/mm/yyyy') as chqDt , cheque_no as chqNo, debit as debitamount, credit as creditamount, customer as supplier,transaction_type as transactionType,narration as narration,document_type as doctype,to_char(document_date,'dd/mm/yyyy') as docdate,to_char(bank_date,'dd/mm/yyyy') as bank_date,remarks as remarks,bank_balance_as_per_bank as balanceAsPerBank,bank_balance_as_per_book as balanceAsPerBook,difference  as difference from bank_reconcile_stmt_new"
			+ " where document_date between TO_DATE (?, 'DD/MM/YYYY') and TO_DATE (?, 'DD/MM/YYYY') and bank_code=?";
	public static final String Get_balance_as_per_book_New = "select coalesce((select bank_balance_as_per_book from bank_reconcile_stmt_new where from_date >= TO_DATE (?, 'DD/MM/YYYY')  and to_date <=TO_DATE (?, 'DD/MM/YYYY') and bank_balance_as_per_book is not null and bank_balance_as_per_book != 0),0)";
	public static final String Get_balance_as_per_bank_New = "select coalesce ((select bank_balance_as_per_bank from bank_reconcile_stmt_new where from_date >= TO_DATE (?, 'DD/MM/YYYY')  and to_date <=TO_DATE (?, 'DD/MM/YYYY') and    bank_balance_as_per_bank is not null  and bank_balance_as_per_bank !=0 order by to_date desc limit 1 ),0)";
	public static final String get_Bank_balance_book_balance = "select bank_balance_as_per_bank_usd as balanceAsPerBankUsd,bank_balance_as_per_book as bankBalanceAsPerBook,bank_balance_as_per_bank as bankBalanceAsPerBank,to_date   from bank_reconcile_stmt_new where   to_date::date < to_date(?, 'DD/MM/YYYY')   and  bank_code=? and bank_balance_as_per_bank <> 0 order  by to_date desc limit 1";

	public static final String get_Bank_balance_book_balance_new = "select  bank_balance_as_per_bank_usd as balanceAsPerBankUsd,bank_balance_as_per_bank as bankBalanceAsPerBook,bank_balance_as_per_bank as bankBalanceAsPerBank,to_date   from bank_reconcile_stmt_new where   to_date::date = to_date(?, 'DD/MM/YYYY')   and  bank_code=? and bank_balance_as_per_bank <> 0  ";

	// + "select * from vw_bank_reco(?, ?)";
	public static final String GET_COUNT = "select count(*)::int  from bank_reconcile_stmt_new where   to_date::date = to_date(?, 'DD/MM/YYYY')   and  bank_code=? and bank_balance_as_per_bank <> 0";
	public static final String CHECK_CHEQUE_NO = "select count(*) from cashbank_pay_hdr  where cheque_no  = ?";

	public static String GET_BANK_DETAIL = "SELECT BANK_ACCT_NO as bankAccountNo,BANK_CURRENCY as bankCurrency FROM CASH_BANK_HDR WHERE BANK_ID=?";

	public static String update_BalanceAsPerBank = "update bank_reconcile_stmt_new set bank_balance_as_per_bank=0 where   bank_code=? and to_date  =TO_DATE (?, 'DD/MM/YYYY')";
	public static String update_BalanceAsPerBank_Draft = "update bank_reconcile_stmt_draft_new set bank_balance_as_per_bank=0 where     bank_code=? and and to_date  =TO_DATE (?, 'DD/MM/YYYY') ";
	public static String update_BalanceAsPerBook = "update bank_reconcile_stmt_new set bank_balance_as_per_book=0 where  bank_code=?   and to_date <=TO_DATE (?, 'DD/MM/YYYY')";
	public static String update_BalanceAsPerBook_Draft = "update bank_reconcile_stmt_draft_new set bank_balance_as_per_book=0 where  bank_code=? and and to_date <=TO_DATE (?, 'DD/MM/YYYY')";
	public static String update_differ_rec = "update bank_reconcile_stmt_new set receipt_difference=0 where  bank_code=? and to_date  =TO_DATE (?, 'DD/MM/YYYY')";
	public static String update_differ_pay = "update bank_reconcile_stmt_new set payment_difference=0 where  bank_code=? and to_date  =TO_DATE (?, 'DD/MM/YYYY')";
	public static String update_differ_rec_draft = "update bank_reconcile_stmt_draft_new set receipt_difference=0 where  bank_code=? and and to_date  =TO_DATE (?, 'DD/MM/YYYY')";
	public static String update_differ_pay_draft = "update bank_reconcile_stmt_draft_new set payment_difference=0 where  bank_code=? and and to_date  =TO_DATE (?, 'DD/MM/YYYY')";
	public static String get_count_reconcile = "select count(*) from bank_reconcile_stmt_new where from_date >= TO_DATE (?, 'DD/MM/YYYY') and to_date  =TO_DATE (?, 'DD/MM/YYYY') ";
	public static String get_count_reconcile_with_Bank = "select count(*) from bank_reconcile_stmt_new where    to_date =TO_DATE (?, 'DD/MM/YYYY')-1  and bank_code=?";
	public static String book_reco_old = "\n" + "select coalesce(sum(coalesce(book_debit_amt,0)),0)-coalesce(sum(coalesce(book_credit_amt,0)),0) as balanceAsPerBook\n" + "from bank_reconcile_stmt where bank_account_code='10060034' and bank_date::date between to_date(?,'dd/mm/yyyy')\n" + "and to_date(?,'dd/mm/yyyy')";
	public static String get_bank = "select * from bank_reco(?,?,?)";
	public static String get_reconciled_payment = "select * from reconciled_payment(?,?,?)";
	public static String get_reconciled_receipt = "select * from reconciled_receipt(?,?,?)";

}
