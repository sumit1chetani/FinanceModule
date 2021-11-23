<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="BankReconcilRequestData" value="${BankReconciliationbeanList}" />
<html>
<head>

<style media="print">
.header_label {
	font-family: Old English;
	color: #000000;
	font-size: 18px;
	line-height: 2.1499023;
	font-weight: bold;
}

.certificate_content_label {
	font-family: Old English;
	color: #000000;
	font-size: 18px;
	line-height: 2.1499023;
	font-weight: normal;
}

.college_header {
	font-family: Old English;
	color: #000000;
	font-size: 32px;
	line-height: 1.1499023;
	font-weight: bold;
	font-style: normal;
}

.header {
	font-family: Old English;
	color: #000000;
	font-size: 30px;
	line-height: 1.1499023;
	font-weight: bold;
	font-style: italic;
}

.conatainer_detail {
	font-family: Helvetica;
	color: #000000;
	font-size: 20px;
	line-height: 1.1640625;
	font-style: italic;
}

.table_detail {
	font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif;
	color: #000000;
	font-size: 10px;
	line-height: 1.1640625;
	padding-left: 5px;
}

tr.border_bot td {
	border-bottom: 1px solid black;
}

@page {
	size: A4 landscape;
	margin: 0mm;
}

@media print {
	table.page-break {
		page-break-after: always;
	}
}
</style>
</head>

<center>
<h1>Bank Reconciliation Details for your Approval</h1>
</center>
<br><br><br><br><br><br>
	<table border="0" align="center">
	<thead style="border: 1px solid #000;background:#19a9d5; color: #fff;font-size: 12px;"><tr>
						<th style="padding: 10px; background-color: #42A5;">Bank Statement ID</th>
					<th style="padding: 10px; background-color: #42A5F5;">Transation No.</th>
					<th style="padding: 10px; background-color: #42A5F5;">Bank Account code</th>
					<th style="padding: 10px; background-color: #42A5F5;">Book Date</th>
					<th style="padding: 10px; background-color: #42A5F5;">Book Cheque No</th>
					<th style="padding: 10px; background-color: #42A5F5;">Book Cheque  Date</th>
					<th style="padding: 10px; background-color: #42A5F5;">Book Debit Amt</th>
										<th style="padding: 10px; background-color: #42A5F5;">Book Credit amt</th>
										<th style="padding: 10px; background-color: #42A5F5;">Bank Cheque no</th>
										<th style="padding: 10px; background-color: #42A5F5;">Bank Date</th>
										<th style="padding: 10px; background-color: #42A5F5;">bank Debit amt</th>
															<th style="padding: 10px; background-color: #42A5F5;">bank Credit amt</th>
					
					<th style="padding: 10px; background-color: #42A5F5;">Status</th>
																			
                    </thead>

<tbody style="background: #efeded">	
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.bank_stmt_id}</td>		
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.transaction_no}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.bank_account_code}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.book_date}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.book_cheque_no}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.book_cheque_date}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.book_debit_amt}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.book_credit_amt}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.bank_cheque_no}</td>
						<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.bank_date}</td>
						<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.bank_debit_amt}</td>
			
						<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.bank_credit_amt}</td>
			

			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${BankReconcilRequestData.status}</td>



			</tbody>
		
	</table>

</html>

