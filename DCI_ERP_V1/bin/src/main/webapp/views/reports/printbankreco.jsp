<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />

<html>
<head>
<style>
@page {
	size: auto;
	margin: 5mm;
}

#table2, td, th {
	border: 1px solid #ddd;
	text-align: left;
}

#table2 {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 5px;
}

.width_auto {
	width: auto;
}

.width_10px {
	width: 10px;
}

.width_05 {
	width: 0.50%;
}

.width_1 {
	width: 1%;
}

.width_2 {
	width: 2%;
}

.width_3 {
	width: 3%;
}

.width_4 {
	width: 4%;
}

.width_5 {
	width: 5%;
}

.width_6 {
	width: 6%;
}

.width_7 {
	width: 7%;
}

.width_8 {
	width: 8%;
}

.width_9 {
	width: 9%;
}

.width_10 {
	width: 10%;
}

.width_11 {
	width: 11%;
}

.width_12 {
	width: 12%;
}

.width_13 {
	width: 13%;
}

.width_14 {
	width: 14%;
}

.width_15 {
	width: 15%;
}

.width_16 {
	width: 16%;
}

.width_17 {
	width: 17%;
}

.width_18 {
	width: 18%;
}

.width_19 {
	width: 19%;
}

.width_20 {
	width: 5%;
	-webkit-column-width-adjust: exact;
}

.width_21 {
	width: 21%;
}

.width_22 {
	width: 22%;
}

.width_23 {
	width: 23%;
}

.width_24 {
	width: 24%;
}

.width_25 {
	width: 25%;
}

.width_26 {
	width: 26%;
}

.width_27 {
	width: 27%;
}

.width_28 {
	width: 28%;
}

.width_29 {
	width: 29%;
}

.width_30 {
	width: 30%;
}

.width_31 {
	width: 31%;
}

.width_32 {
	width: 32%;
}

.width_33 {
	width: 33%;
}

.width_34 {
	width: 34%;
}

.width_35 {
	width: 35%;
}

.width_36 {
	width: 36%;
}

.width_37 {
	width: 37%;
}

.width_38 {
	width: 38%;
}

.width_39 {
	width: 39%;
}

.width_40 {
	width: 40%;
}

.width_41 {
	width: 41%;
}

.width_42 {
	width: 42%;
}

.width_43 {
	width: 43%;
}

.width_44 {
	width: 44%;
}

.width_45 {
	width: 45%;
}

.width_46 {
	width: 46%;
}

.width_47 {
	width: 47%;
}

.width_48 {
	width: 48%;
}

.width_49 {
	width: 49%;
}

.width_50 {
	width: 50%;
}

.width_51 {
	width: 51%;
}

.width_52 {
	width: 52%;
}

.width_53 {
	width: 53%;
}

.width_54 {
	width: 54%;
}

.width_55 {
	width: 55%;
}

.width_56 {
	width: 56%;
}

.width_57 {
	width: 57%;
}

.width_58 {
	width: 58%;
}

.width_59 {
	width: 59%;
}

.width_60 {
	width: 60%;
}

.width_61 {
	width: 61%;
}

.width_62 {
	width: 62%;
}

.width_63 {
	width: 63%;
}

.width_64 {
	width: 64%;
}

.width_65 {
	width: 65%;
}

.width_66 {
	width: 66%;
}

.width_67 {
	width: 67%;
}

.width_68 {
	width: 68%;
}

.width_69 {
	width: 69%;
}

.width_70 {
	width: 70%;
}

.width_71 {
	width: 71%;
}

.width_72 {
	width: 72%;
}

.width_73 {
	width: 73%;
}

.width_74 {
	width: 74%;
}

.width_75 {
	width: 75%;
}

.width_76 {
	width: 76%;
}

.width_77 {
	width: 77%;
}

.width_78 {
	width: 78%;
}

.width_79 {
	width: 79%;
}

.width_80 {
	width: 80%;
}

.width_81 {
	width: 81%;
}

.width_82 {
	width: 82%;
}

.width_83 {
	width: 83%;
}

.width_84 {
	width: 84%;
}

.width_85 {
	width: 85%;
}

.width_100 {
	width: 100%;
}

.no_border {
	border: 0px;
}

tr.odd {
	-webkit-print-color-adjust: exact;
	background: #CCC
}

tr.even {
	-webkit-print-color-adjust: exact;
	background: #FFF
}
</style>
</head>

<body style="font-family: monospace;">
	<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="hdr" value="${headerDetails}" />
	<c:set var="hdr" value="${category}" />


	<!-- width="100%" class="no_border"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center" -->
	<!-- border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="" -->


	<%-- <tr>
							
							<td width="25%"><img src="/img/${user.tenantId}HelpVideos/logo.jpg" style=" padding:10 0 0 10; height: 60px;"></td><tr>
							<td>
							
						 <span style="vertical-align:80px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${category}</span>
						 <tr><span style="vertical-align:60px">${datetime}</span></tr>
						
						</td>
						 
						
						 </tr>
								
							 
							
							
						</tr> --%>

	<div style="width: 82%; float: left;">
		<div style="width: 27%; float: left;">
			<img src="/img/${user.tenantId}HelpVideos/logo.jpg"
				style="padding: 10 0 0 10; height: 60px;">
		</div>
		<%-- <div style="width: 25%;float: left;">
						<span>${category}</span>
						<br/>
						<span>${datetime}</span>
						</div> --%>

	</div>





	<c:set var="bean" value="${getReconcileRecords}" />

	<c:set var="footbean" value="${getReconcileRecords}" />





	<br>
	<table class="table table-striped b-t b-light padding-top-10"
		align="left" border="1" bordercolor="black" cellPadding="0"
		cellSpacing="0" width=100%>
		<thead>
			<tr
				style="-webkit-print-color-adjust: exact; background-color: #ffff00;">
				<th class="sorting width_10">Customer/Supplier</th>
				<!-- <th class="sorting width_10">Cheque No.</th> -->
				<th class="sorting width_10">Cheque Dt</th>
				<th class="sorting width_10">Voucher No</th>
				<th class="sorting width_10">Voucher Type</th>
				<th class="sorting width_10">Narration</th>
				<th class="sorting width_5">Doc Type</th>
				<th class="sorting width_5">Doc Date</th>
				<th class="sorting width_5">Credit</th>
				<th class="sorting width_5">Debit</th>
				<th class="sorting width_10">Bank Date</th>
				<th class="sorting width_10">Remarks</th>
			</tr>
		</thead>
		<tbody>


			<c:forEach var="ob" items="${getReconcileRecords}"
				varStatus="theCount">
				<%--  <c:forEach items="${bean.list}" var="item" varStatus="loop"> --%>
				<%-- 	<c:set var="count" value="${count + 1}" scope="page"/> --%>
				<tr class="${theCount.index % 2 == 0 ? 'even' : 'odd'}">

					<td class="subcolor width_20 text-wrap detail-table-cell"
						align="center" value="${count + 1}" valign="middle"><span
						class="detail-table-font w-s-no">${ob.supplier} </span></td>

					<!-- <td class="subcolor width_20 detail-table-cell" align="center">
										<span class="detail-table-font"><c:if test="${ob.chqNo != ''}"></c:if></span>
									</td>-->
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.chqDt} </span>
					</td>
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.transactionNo} </span>
					</td>
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.transactionType} </span>
					</td>
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.narration} </span>
					</td>
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.doctype} </span>
					</td>
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.docdate} </span>
					</td>
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.creditamount1} </span>
					</td>
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.debitamount1} </span>
					</td>
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.bank_date} </span>
					</td>
					<td class="subcolor width_20 detail-table-cell" align="center">
						<span class="detail-table-font">${ob.remarks} </span>
					</td>
				</tr>
			</c:forEach>
			<%--                             <tr><td></td><td></td><td><b>Total Profit</b></td><td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bean.totprofit}" /></td><td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bean.totprofitusd}" /></td></tr>
 --%>
		</tbody>
	</table>


	<table>
		<tbody>
			<tr style="text-align: center;">
				<td>Bank Balance As Per Bank</td>
				<td>${bankBalanceAsPerBank}</td>
			</tr>
			<tr style="text-align: center;">
				<td>Bank Balance As Per Book</td>
				<td>${bankBalanceAsPerBook}</td>
			</tr>
			<tr style="text-align: center;">
				<td>Difference</td>
				<td>${difference}</td>
			</tr>
			
			<tr style="text-align: center;">
				<c:if test="${rec=false}"><td>Reconciled Receipts</td></c:if>
				<c:if test="${rec=true}">	<td>Unreconciled Receipts</td></c:if>
				<td>${differenceReceipt}</td>
			</tr>
			
			<tr style="text-align: center;">
			<c:if test="${rec=false}">	<td>Reconciled Payments</td></c:if>
			<c:if test="${rec=true}">	<td>Unreconciled Payments</td></c:if>
				<td>${differencePayment}</td>
			</tr>
		</tbody>
	</table>






	<table>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
	</table>


</body>
</html>



