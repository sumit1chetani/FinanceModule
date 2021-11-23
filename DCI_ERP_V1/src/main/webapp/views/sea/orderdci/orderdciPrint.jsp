<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title></title>
</head>
<style>
@page {
	size: A4 portrait; /* auto is the initial value */
	margin: 2mm; /* this affects the margin in the printer settings */
}

@media print {
	.page-break {
		display: block;
		page-break-after: always;
	}
}

@page {
	size: legal;
	margin: 0mm;
}

body {
	background-color: #FFFFFF;
	color: #000000;
	font-family: 'Arial';
}

.form-horizontal {
	margin-right: -15px;
	margin-left: -15px;
}

.padding-20p {
	padding: 20px;
}

.padding-top-10 {
	padding-top: 10px;
}

.padding-left-5 {
	padding-left: 5px;
}

.padding-5p {
	padding: 5px;
}

.line-height-23p {
	line-height: 23px;
}

.custom-color-1 .table-striped>thead>tr>th {
	color: #fff;
	border-bottom: 1px solid rgba(255, 255, 225, .15);
	border-left: 1px solid rgba(255, 255, 225, .15);
	border-top: 1px solid rgba(255, 255, 225, .15);
	background: #42a5f5 !important;
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
	width: 20%;
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
/* .footer{
    width: 100%;
    position: relative;
    bottom: 0px;
} */
.footer {
	position: absolute;
	bottom: 0px;
	left: 0px;
	width: 100%;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	text-decoration: none;
}

.footer-text {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 8pt;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	text-decoration: none;
}

.header-bg {
	background-color: #42a5f5;
	color: #fff;
	font-weight: bold;
	font-family: sans-serif;
}

.text-wrap {
	/* white-space: -moz-pre-wrap; */ /* Firefox */
	white-space: -o-pre-wrap; /* Opera */
	/* white-space: pre-wrap; */ /* Chrome */
	word-wrap: break-word; /* IE */
}

.border-right-none {
	border-right: none;
}

.border-top-none {
	border-top: none;
}

.border-bottom-none {
	border-bottom: none;
}

.border-left-none {
	border-left: none;
}

.border-bottom-1p {
	border-bottom: 1px solid #000;
}

.border-bottom-2p {
	border-bottom: 2px solid #000;
}

.b-none {
	border: none;
}



.bold {
	font-weight: bold;
}

.company-for-seal {
	font-size: 14px;
	font-weight: bold;
	padding-top: 25px;
	text-align: center;
}

.table-striped tbody td {
	height: 30px;
	padding: 3px;
}
/* .normal{
	font-size:14px;
} */
.normal {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 4pt;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	text-decoration: none;
}

.padding-top-20 {
	padding-top: 20px;
}

.detail-table-cell {
	font-family: Arial;
	FONT-SIZE: 4pt;
	color: black;
	background-color: #FFFFFF;
	padding: 1px;
	bordercolor: #000000;
	text-transform: uppercase;
}

.thead-bold {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 4pt;
	font-style: normal;
	font-weight: bold;
	color: #000000;
	text-decoration: none;
	padding-left: 6px;
}

.detail-table-font {
	font-size: 5px;
	font-family: arial;
}

@page :last { @bottom-center { content:"…";
	
}

#footer {
	display: table-footer-group;
	width: 100%;
	position: absolute;
	bottom: 0;
}

.new {
	margin-top: 5%;
	margin-left: 5%;
	margin-right: 5%;
}
</style>
<body>
	<div
		style="border: 1px solid black; margin-top: 5%; margin-left: 5%; margin-right: 5%;">
		<c:set var="print" value="${generalInvoiceList}" />
		<table class="width_100" align="center" border="0" cellPadding="0"
			cellSpacing="0">
			<tr>
				<td>
					<table width="25%" style="float: left; padding-top: 10px;">
						<td width="25%"
							style="float: left; padding-left: 45px; padding-right: 30px; padding-bottom: 5px;">
							<img src="/sampark/images/logo1.png">
						</td>
					</table>
					<table width="50%" style="float: left; padding-top: 5px;">
						<td width="75%" style="font-size: 11px;"><span
							style="text-align: center;">
							 <c:if
									test="${print.poAmendNo!= ''}">
								<h1 style="font-size: 1.5em; margin-left: 22px;">${print.purchaseOrderType}(Amended)</h1>
								</c:if>
									 <c:if
									test="${print.poAmendNo == ''}">
								<h1 style="font-size: 1.5em; margin-left: 22px;">${print.purchaseOrderType}</h1>
								</c:if>
								
								<h1 style="font-size: 1.2em; margin-left: 15px;">
									Dental Council of India<br>Aiwan-E-Galib Marg,Kotla Road,<br>New Delhi.


									
								</h1>
						</span></td>
					</table>
					<table width="25%" style="float: left;">
						<td width="25%" style="font-size: 5px;"><span
							style="text-align: left;"> <br> <span
								style="text-align: right;" style="font-size: 12px;"></span></td>
					</table>
					<table width="100%" style="border-bottom: 1px solid #000;">
						<td width="100%"></td>
					</table>
					<table width="60%" style="float: left; padding-top: 10px;">
						<tr>
							<td class="width_30" style="font-size: 12px;">PO No :</td>
							<td style="font-size: 12px;"><b>${print.purchaseOrderNo}</b></td>
						</tr>
						<%-- <tr>
							<td class="width_30" style="font-size: 12px;">Entity :</td>
							<td style="font-size: 12px;"><b>${print.entity}</b></td>
						</tr> --%>
						<tr>
							<td class="width_30" style="font-size: 12px;">Vendor Name :</td>
							<td style="font-size: 12px;"><b>${print.vendorName}</b></td>
						</tr>
						<tr>
							<td class="width_30" style="font-size: 12px;">Address of
								Vendor :</td>
							<td style="font-size: 12px;"><b>${print.vendorAddress}</b></td>
						</tr>
						<%-- <tr>
						<td class="width_30" style="font-size: 12px;">Ref :</td>
						<td style="font-size: 12px;"><b> ${print.purchaseOrderType}

						</b></td>
						</tr> --%>
						<%-- <tr>
							<td class="width_30" style="font-size: 12px;">Budget Head :</td>
							<td style="font-size: 12px;"><b>${print.purchaseOrderType}</b></td>
						</tr> --%>
						<tr>
							<td class="width_30" style="font-size: 12px;">Delivery
								Schedule :</td>
							<td style="font-size: 12px;"><b> <%-- ${print.purchaseOrderType} --%>
									Immediate
							</b></td>
						</tr>

						<tr>
							<td class="width_30" style="font-size: 12px;">Payment Terms
								:</td>
							<td style="font-size: 12px;"><b> <c:if
										test="${print.paymentTerms != 0}">${print.paymentTerms} Days
								</c:if></b></td>
						</tr>
					</table>
					<table width="40%" style="float: right; padding-top: 10px;">
						<tr>
							<td class="width_30" style="font-size: 12px;">Date :</td>
							<td style="font-size: 12px;"><b>${print.purchaseOrderDate}</b>
							</td>
						</tr>
						<%-- <tr>
							<td class="width_30" style="font-size: 12px;">Department :</td>
							<td style="font-size: 12px;"><b>${print.locationName}</b></td>
						</tr> --%>
						<tr>
							<td class="width_30" style="font-size: 12px;"></td>
							<td style="font-size: 12px;"></td>
						</tr>
						<tr>
							<td class="width_30" style="font-size: 12px;"></td>
							<td style="font-size: 12px;"></td>
						</tr>
						<%-- <tr>
							<td class="width_30" style="font-size: 12px;">E-Mail :</td>
							<td style="font-size: 12px;"><b>${print.vendorEmail}</b></td>
						</tr> --%>

						<tr>
							<td class="width_30" style="font-size: 12px;">Phone:</td>
							<td style="font-size: 12px;"><b>${print.vendorPhone}</b></td>
						</tr>
						<tr>
							<td class="width_30" style="font-size: 12px;">PO Value :</td>
							<td style="font-size: 12px;"><b> <fmt:formatNumber
										type="number" minFractionDigits="0" maxFractionDigits="0"
										value="${print.amount}" />.00
							</b></td>
						</tr>
						<tr>
							<td class="width_30" style="font-size: 12px;">Currency :</td>
							<td style="font-size: 12px;"><b>${print.currencyType}</b></td>
						</tr>
						<tr>
							<td class="width_30" style="font-size: 12px;">Advance :</td>
							<td style="font-size: 12px;"><b>${print.advanceAmount}<c:if
										test="${print.advanceAmount != 0}">%</c:if></b></td>
						</tr>

						<%-- <tr>
							<td class="width_30" style="font-size: 12px;">Cost Center :</td>
							<td style="font-size: 12px;"><b>${print.costcenter}</b>
							</td>
						</tr> --%>
					</table> <br> <%-- <table width=100% align="center" border="1" cellPadding="0"
					cellSpacing="0" style="border-left: none; border-right: none;border-bottom: none;">
					<tr>
						<td><center>
								<font size="3" face="arial"><b>Your Invoice Should be raised for ' '</b></font>
							</center></td>
					</tr>
				</table> --%>
					<table class="table table-striped b-t b-light " align="left"
						border="1" bordercolor="" cellPadding="0" cellSpacing="0"
						width=100%>
						<thead>
							<tr>
								<th class="width_5" align="center" style="font-size: 11px;">S.
									NO</th>
								 <th class="width_12" align="center" style="font-size: 11px;">PR NO</th> 
								<th class="width_20" align="center" style="font-size: 11px;">ITEM
									NAME / DESCRIPTION</th>
								<th class="width_6" align="center" style="font-size: 11px;">QUANTITY</th>
								<!-- <th class="width_5" align="center" style="font-size: 12px;">UOM</th> -->
								<th class="width_5" align="center" style="font-size: 11px;">UOM</th>
								<th class="width_6" align="center" style="font-size: 11px;">RATE</th>
								<!-- <th class="width_8" align="center" style="font-size: 11px;">TOTAL</th> -->
								<!-- <th class="width_5" align="center" style="font-size: 11px;">VAT%</th> -->
								<!-- <th class="width_5" align="center" style="font-size: 11px;">SGST</th> -->
								<th class="width_5" align="center" style="font-size: 11px;">SGST%</th>
								<!-- <th class="width_5" align="center" style="font-size: 11px;">CGST</th> -->
								<th class="width_5" align="center" style="font-size: 11px;">CGST%</th>
								<!-- <th class="width_5" align="center" style="font-size: 11px;">IGST</th> -->
								<th class="width_5" align="center" style="font-size: 11px;">IGST%</th>
								<th class="width_5" align="center" style="font-size: 11px;">DISCOUNT</th>
								<th class="width_8" align="center" style="font-size: 11px;">TOTAL</th>
								<!-- <th class="width_8" align="center" style="font-size: 11px;">AMOUNT</th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ob" items="${generalInvoiceList.detailList}"
								varStatus="theCount">
								<tr>
									<td align="center" style="font-size: 11px;">${ob.serialnumber}</td>
									 <td align="center" style="font-size: 11px;">
										${ob.purchaseReqNo}</td> 
									<td align="left" style="font-size: 11px;">${ob.itemName}<i>
											- ${ob.itemDescription}</i></td>
									<td align="center" style="font-size: 11px;">
										${ob.quantity}</td>
									<td align="center" style="font-size: 11px;">${ob.uomName}</td>
									<%-- <td align="center" style="font-size: 12px;">
										${ob.quantity}</td> --%>
									<td align="right" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2"
											value="${ob.rate}" /></td>
									<%-- <td align="right" style="font-size: 11px;">
									<fmt:formatNumber type="number" minFractionDigits="2"
															maxFractionDigits="2"
															value="${ob.total}" /></td> --%>
									<%-- <td align="center" style="font-size: 11px;">${ob.vat}</td> --%>
									<%-- <td align="right" style="font-size: 11px;">
									<fmt:formatNumber type="number" minFractionDigits="2"
															maxFractionDigits="2"
															value="${ob.taxSGST}" /></td> --%>
									<td align="right" style="font-size: 11px;">${ob.taxSGSTinPercent}</td>
									<%-- <td align="right" style="font-size: 11px;">
									<fmt:formatNumber type="number" minFractionDigits="2"
															maxFractionDigits="2"
															value="${ob.taxCGST}" /></td> --%>
									<td align="right" style="font-size: 11px;">${ob.taxCGSTinPercent}</td>
									<%-- <td align="right" style="font-size: 11px;">
									<fmt:formatNumber type="number" minFractionDigits="2"
															maxFractionDigits="2"
															value="${ob.taxIGST}" /></td> --%>
									<td align="right" style="font-size: 11px;">${ob.taxIGSTinPercent}</td>
									<td align="right" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2"
											value="${ob.discountAmount}" /></td>
									<%-- <td align="right" style="font-size: 11px;">
									<fmt:formatNumber type="number" minFractionDigits="2"
															maxFractionDigits="2"
															value="${ob.amount}" /></td> --%>
									<td align="right" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2"
											value="${ob.total}" /></td>
								</tr>
								<tr class="no-border">
								</tr>
							</c:forEach>
						</tbody>
					</table> <br> <br> <br>
					<table class="width_50"
						style="float: left; border-left: none; border-right: none;">
						<tr>
							<%-- <td style="font-size: 12px;width: 75px;"><c:if
									test="${print.taxCGST != 0.0}">CGST : <fmt:formatNumber type="number" minFractionDigits="2"
									maxFractionDigits="2" value="${print.taxCGST}"/>
								</c:if>
							</td>
							<td style="font-size: 12px;width: 75px;"><c:if
									test="${print.taxSGST != 0.0}">SGST : <fmt:formatNumber type="number" minFractionDigits="2"
									maxFractionDigits="2" value="${print.taxSGST}"/>
								</c:if>
							</td>
							<td style="font-size: 12px;width: 75px;"><c:if
									test="${print.taxIGST != 0.0}">IGST : <fmt:formatNumber type="number" minFractionDigits="2"
									maxFractionDigits="2" value="${print.taxIGST}"/>
								</c:if>
							</td> --%>
						</tr>
					</table>
					<table class="width_50"
						style="float: right; border-left: none; border-right: none; padding-left: 10%;">
						<tr>
							<td class="width_30" style="font-size: 12px;" align="right">Sub
								Total :</td>
							<td style="font-size: 12px;" align="right"><fmt:formatNumber
									type="number" minFractionDigits="2" maxFractionDigits="2"
									value="${print.total}" /></td>
						</tr>
						<tr>

							<td class="width_40" style="font-size: 12px;" align="right"><c:if
									test="${print.discount != 0.0}">Discount :</c:if></td>
							<td style="font-size: 12px;" align="right"><c:if
									test="${print.discount != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2" value="${print.discount}" />
								</c:if></td>
						</tr>
						<tr>

							<td class="width_40" style="font-size: 12px;" align="right">Net Amount
								:
							</td>
							<td style="font-size: 12px;" align="right">
									
									<fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2" value="${print.totalNetPrice}" />
								</td>
						</tr>
						<tbody>
							<c:forEach var="ob" items="${generalInvoiceList.gstgropuList}"
								varStatus="theCount">
								<%-- <tr>
								
									<td style="font-size: 13px;" colspan="1">
											
											<b>${ob.gstgroupbyPercent} : ${ob.gstAmtgroupbyPercent}</b>
										</b></td>


								</tr> --%>
								<tr>
									<td class="width_55" style="font-size: 12px;" align="right">${ob.gstgroupbyPercent}
										:</td>
									<td style="font-size: 12px;" align="right"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2"
											value="${ob.gstAmtgroupbyPercent}" /></td>
								</tr>
								<tr class="no-border">
								</tr>
							</c:forEach>
						</tbody>
						<tr>
							<td class="width_40" style="font-size: 12px;" align="right"><c:if
									test="${print.freightAmount != 0.0}">Freight :</c:if></td>
							<td style="font-size: 12px;" align="right"><c:if
									test="${print.freightAmount != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2" value="${print.freightAmount}" />
								</c:if></td>
						</tr>
						<tr>

							<td class="width_40" style="font-size: 12px;" align="right"><c:if
									test="${print.freightTax != 0}">Freight Tax :
									</c:if></td>
							<td style="font-size: 12px;" align="right"><c:if
									test="${print.freightTax != 0}">${print.freightTax}%</c:if></td>

						</tr>
						<tr>

							<td class="width_40" style="font-size: 12px;" align="right"><c:if
									test="${print.freightCharges != 0.0}">Total Freight :
									</c:if></td>
							<td style="font-size: 12px;" align="right"><c:if
									test="${print.freightCharges != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2" value="${print.freightCharges}" />
								</c:if></td>

						</tr>
						<tr>
							<td class="width_45" style="font-size: 12px;" align="right"><c:if
									test="${print.otherCharges != 0.0}">Other Charges :</c:if></td>
							<td style="font-size: 12px;" align="right"><c:if
									test="${print.otherCharges != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2" value="${print.otherCharges}" />
								</c:if></td>
						</tr>
						<tr>
							<td class="width_30" style="font-size: 13px;" align="right">Total
								Amount :</td>
							<td style="font-size: 13px;" align="right"><fmt:formatNumber
									type="number" minFractionDigits="2" maxFractionDigits="2"
									value="${print.fTotal}" /></td>
						</tr>
						<tr>
							<td class="width_30" style="font-size: 13px;" align="right">
								<c:if test="${print.roundOf != 0.0}">Round of  :</c:if>
							</td>
							<td style="font-size: 13px;" align="right"><c:if
									test="${print.roundOf != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2" value="${print.roundOf}" />
								</c:if></td>
						</tr>
						<tr>
							<td class="width_30" style="font-size: 13px; font-weight: bold;"
								align="right">Grand Total :</td>
							<td style="font-size: 13px;" align="right"><b> <fmt:formatNumber
										type="number" minFractionDigits="0" maxFractionDigits="0"
										value="${print.amount}" />.00
							</b></td>
						</tr>
					</table>
		</table>
		<table class="width_100"
			style="float: left; border-left: none; border-right: none;">
			<tr>
				<td class="no-border" align="left"><font face="arial" size="2">Total
						Order Value : ${print.amountinWords} </font></td>
			</tr>
			<tr>
				<td class="no-border" align="left"><font face="arial" size="2">Remarks
						: ${print.remarks} </font></td>
			</tr>
			<tr>
				<td class="no-border" align="left"><font face="arial" size="2">Other
						Charges Remarks : ${print.otherChargesRemarks} </font></td>
			</tr>
		</table>

		<table class="width_100"
			style="float: left; border-left: none; border-right: none; padding-top: 5px; padding-bottom: 30px;">
			<tr>
				<td class="no-border" align="left"><font face="arial" size="2">Terms
						& Condition :<br>${print.terms_Condition}
				</font></td>
			</tr>
		</table>
		<table class="width_100">
			<tr class="no-border">
				<td class="no-border" align="center"></td>
			</tr>
			<tr class="no-border">
				<td class="no-border" align="center">________________________</td>
				<td class="no-border" align="center">________________________</td>
				<td class="no-border" align="center">________________________</td>
			</tr>
			<tr class="no-border">
				<td class="no-border" align="center" style="font-size: 11px;">Prepared
					By</td>
				<td class="no-border" align="center" style="font-size: 11px;">Approved
					By</td>
				<td class="no-border" align="center" style="font-size: 11px;">Received
					By</td>
			</tr>
			<tr class="no-border">
				<td class="no-border" align="center" style="font-size: 11px;">${print.preparedBy}</td>
				<td class="no-border" align="center" style="font-size: 11px;">${print.approvedName}</td>
				<td class="no-border" align="center" style="font-size: 11px;"><font
					face="arial" size="2"></font></td>
			</tr>

		</table>
		<br> <br> <br>
		</table>
	</div>
</body>
</html>