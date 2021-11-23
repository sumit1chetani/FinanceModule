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
		<c:set var="print" value="${printdata}" />
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
								<h1 style="font-size: 1.2em; margin-left: 15px;">
									${print.editBeanData.organisationName}<br>No:79,Omega
									School Road,<br>Kolappakkam,Chennai-600122,<br>State
									- Tamil Nadu, Code - 33
								</h1>
						</span></td>
					</table>
					<table width="25%" style="float: left;=">
						<td width="25%" style="font-size: 5px;"><span
							style="text-align: left;"> <br> <span
								style="text-align: right;" style="font-size: 12px;"></span></td>
					</table>

					<table width=100% align="center" border="1" cellPadding="0"
						cellSpacing="0" style="border-left: none; border-right: none;">
						<tr>
							<td><center>
									<font size="2" face="arial"><b>Goods Received Note</b></font>
								</center></td>
						</tr>
					</table> <br>
					<table width="50%"
						style="float: left; padding-top: 10px; padding-bottom: 15px;">
						<%-- <tr>

							<td class="width_40" style="font-size: 11px;">Entity</td>

							<td style="font-size: 11px;">: <b>${print.editBeanData.entity}</b></td>
						</tr> --%>

						<tr>
							<td class="width_40" style="font-size: 11px;">Vendor Name</td>
							<td style="font-size: 11px;">: <b>${print.editBeanData.vendorName}</b></td>
						</tr>

						<tr>
							<td class="width_40" style="font-size: 11px;">Address of
								Vendor</td>
							<td style="font-size: 11px;">: <b>${print.editBeanData.vendorAddress}</b></td>
						</tr>

						<tr>
							<td class="width_40" style="font-size: 11px;">Phone</td>
							<td style="font-size: 11px;">: <b>${print.editBeanData.vendorPhone}</b></td>
						</tr>
						<tr>
							<td class="width_40" style="font-size: 11px;">E-Mail</td>
							<td style="font-size: 11px;">: <b>${print.editBeanData.vendorEmail}</b></td>
						</tr>
					</table>
					<table width="50%"
						style="float: left; padding-top: 10px; padding-bottom: 15px;">


						<tr>
							<td class="width_40" style="font-size: 11px;">Requisition No</td>
							<td style="font-size: 11px;">:<b>
									${print.editBeanData.poRequisition} </b>
							</td>
						</tr>
						<tr>
							<td class="width_40" style="font-size: 11px;">Mode of Transport</td>
							<td style="font-size: 11px;">:<b>
									${print.editBeanData.transMod} </b>
							</td>
						</tr>
						
<%-- <c:when test="${print.editBeanData.poAmendNo !=''}">
 --%>						
 <c:if
									test="${print.editBeanData.poAmendNo != ''}">  <tr>
							<td class="width_40" style="font-size: 11px;" >P.O.No
							(Amended POs)</td>
							<td style="font-size: 11px;">:<b>
									${print.editBeanData.poNo} </b>
							</td>
						</tr>
						</c:if>
						
<%-- 						</c:when>
 --%>						
<%-- <c:when test="${print.editBeanData.poAmendNo ==''}">
 --%>						 <c:if
									test="${print.editBeanData.poAmendNo == ''}">  <tr>

							<td class="width_40" style="font-size: 11px;">P.O.No</td>
							<td style="font-size: 11px;">:<b>
									${print.editBeanData.poNo} </b>
							</td>
						</tr>
												</c:if>
						
<%-- 						</c:when>
 --%>						<tr>
							<td class="width_40" style="font-size: 11px;">D.C No</td>
							<td style="font-size: 11px;">:<b>
									${print.editBeanData.delOrderNo}</b>
							</td>
						</tr>
						<tr>
							<td class="width_40" style="font-size: 11px;">Invoice No</td>
							<td style="font-size: 11px;">:<b>
									${print.editBeanData.invoiceNo} </b>
							</td>
						</tr>
						<tr>
							<td class="width_40" style="font-size: 11px;">Invoice Date</td>
							<td style="font-size: 11px;">:<b>
									${print.editBeanData.invoiceDate} </b></td>
						</tr>
						<tr>
							<td class="width_40" style="font-size: 11px;">GRN No</td>
							<td style="font-size: 11px;">:<b>
									${print.editBeanData.grnCode} </b>
							</td>
						</tr>
						<tr>
							<td class="width_40" style="font-size: 11px;">GRN Date</td>
							<td style="font-size: 11px;">:<b>
									${print.editBeanData.grnDate} </b>
							</td>
						</tr>
						<tr>
							<td class="width_40" style="font-size: 11px;">Budget Type</td>
							<td style="font-size: 11px;">:<b>
									${printdata.editBeanData.budgetTypeName} </b>
							</td>
						</tr>
					</table> <br> <br>


					<table width=100% align="center" border="1" cellPadding="0"
						cellSpacing="0" style="border-left: none; border-right: none;">
						<tr>
							<td><center>
									<font size="2" face="arial"><b>ORDER DETAILS</b></font>
								</center></td>
						</tr>
					</table> <br>
					<table class="table table-striped b-t b-light " align="left"
						border="1" bordercolor="" cellPadding="0" cellSpacing="0"
						width=100%>
						<thead>
							<tr>
								<th class="width_2" align="center" style="font-size: 11px;">S.No</th>
								<th class="width_10" align="center" style="font-size: 11px;">Item
									Name</th>
								<th class="width_10" align="center" style="font-size: 11px;">Item
									Description</th>
								<!-- 	<th class="width_10" align="center" style="font-size: 11px;">Budget
									Type</th> -->
								<th class="width_2" align="center" style="font-size: 11px;">Qty</th>
								<th class="width_2" align="center" style="font-size: 11px;">UOM</th>
								<th class="width_5" align="center" style="font-size: 11px;">unit
									Rate</th>
								<!-- <th class="width_4" align="center" style="font-size: 11px;">Price
								</th> -->
								<th class="width_4" align="center" style="font-size: 11px;">Disc
								</th>
								<!-- <th class="width_4" align="center" style="font-size: 11px;">Disc
									(%)</th> -->

								<!-- <th class="width_6" align="center" style="font-size: 11px;">Net
									Price</th> -->
								<th class="width_4" align="center" style="font-size: 11px;">CGST
									(%)</th>
								<th class="width_4" align="center" style="font-size: 11px;">SGST
									(%)</th>
								<th class="width_4" align="center" style="font-size: 11px;">IGST
									(%)</th>
								<th class="width_4" align="center" style="font-size: 11px;">Total
								</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="ob" items="${printdata.editBeanData.grnTables}"
								varStatus="theCount">
								<tr>
									<td align="center" style="font-size: 11px;">${ob.serialNumber}</td>
									<td align="center" style="font-size: 11px; text-align: left;">
										${ob.dtlItemName}</td>
									<td align="center" style="font-size: 11px; text-align: left;">
										${ob.dtlItemDesc}</td>
									<%-- <td align="center" style="font-size: 10px; text-align: left;">
										${print.editBeanData.budgetTypeName}</td> --%>
									<td align="center" style="font-size: 11px;">${ob.dtlQty}</td>
									<td align="center" style="font-size: 11px;">
										${ob.dtlUomName}</td>
									<td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2">
											 ${ob. dtlPrice}</fmt:formatNumber></td>
									<%-- <td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2">
										${ob.price}</fmt:formatNumber></td> --%>
									<td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2">
										${ob.discountAmount}</fmt:formatNumber></td>
									<%-- <td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2">
										${ob.discountPercentage}</fmt:formatNumber></td>
 --%>
									<%-- <td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2">
										${ob.total}</fmt:formatNumber></td> --%>

									<td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="1" maxFractionDigits="1">
											 ${ob.taxCGSTinPercent}</fmt:formatNumber></td>
									<td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="1" maxFractionDigits="1">
											 ${ob.taxSGSTinPercent}</fmt:formatNumber></td>
									<td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="1" maxFractionDigits="1"> 
											${ob.taxIGSTinPercent}</fmt:formatNumber></td>
									<%-- <td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2"> ${ob.rowTotal}</fmt:formatNumber>
									</td> --%>
									<td align="center" style="font-size: 11px;"><fmt:formatNumber
											type="number" minFractionDigits="2" maxFractionDigits="2">
										${ob.price}</fmt:formatNumber></td>

								</tr>
								<tr class="no-border">
								</tr>
							</c:forEach>
						</tbody>
					</table> <br> <br> <br>
					<table class="width_50"
						style="float: left; border-left: none; border-right: none;">
						<tr>
						</tr>
					</table>
					<table class="width_50"
						style="float: right; border-left: none; border-right: none; padding-left: 10%;">
						<tr>
							<td class="width_40" style="font-size: 11px;" align="right"><c:if
									test="${print.editBeanData.subTotal != 0.0}">SubTotal :</c:if></td>
							<td style="font-size: 11px;" align="right"><c:if
									test="${print.editBeanData.subTotal != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2">${print.editBeanData.subTotal}</fmt:formatNumber>
								</c:if></td>

						</tr>
						<tr>
							<td class="width_60" style="font-size: 11px;" align="right"><c:if
									test="${print.editBeanData.totalDiscount != 0.0}">Discount :</c:if></td>
							<td style="font-size: 11px;" align="right"><c:if
									test="${print.editBeanData.totalDiscount != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2">${print.editBeanData.totalDiscount}</fmt:formatNumber>
								</c:if></td>

						</tr>
						<%-- <tr>
						<td class="width_40" style="font-size: 11px;"><c:if
								test="${print.editBeanData.totalTaxCGST != 0.0}">CGST  (${print.editBeanData.taxCGSTinPercent})%</c:if></td>
						<td style="font-size: 11px;"><c:if
								test="${print.editBeanData.totalTaxCGST != 0.0}">: <b>${print.editBeanData.totalTaxCGST}</b>
							</c:if></td>

					</tr>
					<tr>
						<td class="width_40" style="font-size: 11px;"><c:if
								test="${print.editBeanData.totalTaxSGST != 0.0}">SGST  (${print.editBeanData.taxSGSTinPercent})%</c:if></td>
						<td style="font-size: 11px;"><c:if
								test="${print.editBeanData.totalTaxSGST != 0.0}">: <b>${print.editBeanData.totalTaxSGST}</b>
							</c:if></td>

					</tr>
					<tr>
					
						<td class="width_40" style="font-size: 11px;"><c:if
								test="${print.editBeanData.totalTaxIGST != 0.0}">IGST  (${print.editBeanData.taxIGSTinPercent})%</c:if></td>
						<td style="font-size: 11px;"><c:if
								test="${print.editBeanData.totalTaxIGST != 0.0}">: <b>${print.editBeanData.totalTaxIGST}</b>
							</c:if></td>

					</tr> --%>
						<c:forEach var="GST" items="${printdata.editBeanData.groupList}"
							varStatus="theCount">
							<tr>

								<td class="width_40" style="font-size: 11px;" align="right"><c:if
										test="${GST.gstAmtgroupbyPercent != 0.0}">${GST.gstgroupbyPercent} :</c:if></td>
								<td style="font-size: 11px;" align="right"><c:if
										test="${GST.gstAmtgroupbyPercent != 0.0}">
										<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2">${GST.gstAmtgroupbyPercent}</fmt:formatNumber>
									</c:if></td>

							</tr>
						</c:forEach>
						<%-- 	<tr>

						<td class="width_40" style="font-size: 11px;"><c:if
								test="${print.editBeanData.freightAmount != 0.0}">Freight </c:if></td>
						<td style="font-size: 11px;"><c:if
								test="${print.editBeanData.freightAmount != 0.0}">: <b>${print.editBeanData.freightAmount}</b>
							</c:if></td>

					</tr> --%>
						<%-- 		<tr>

						<td class="width_40" style="font-size: 11px;"><c:if
								test="${print.editBeanData.freightTax != 0.0}">FreightTax (%) </c:if></td>
						<td style="font-size: 11px;"><c:if
								test="${print.editBeanData.freightTax != 0.0}">: <b>${print.editBeanData.freightTax}</b>
							</c:if></td>

					</tr>
					<tr> --%>

						<td class="width_40" style="font-size: 11px;" align="right"><c:if
								test="${print.editBeanData.freight != 0.0}">Freight Total :</c:if></td>
						<td style="font-size: 11px;" align="right"><c:if
								test="${print.editBeanData.freight!= 0.0}">
								<fmt:formatNumber type="number" minFractionDigits="2"
									maxFractionDigits="2">${print.editBeanData.freight}</fmt:formatNumber>
							</c:if></td>

						</tr>
						<tr>
							<td class="width_40" style="font-size: 11px;" align="right"><c:if
									test="${print.editBeanData.otherCharges != 0.0}">other Charges :</c:if></td>
							<td style="font-size: 11px;" align="right"><c:if
									test="${print.editBeanData.otherCharges != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2">${print.editBeanData.otherCharges}</fmt:formatNumber>
								</c:if></td>

						</tr>
						<tr>
							<td class="width_40" style="font-size: 14px;" align="right"><c:if
									test="${print.editBeanData.fTotal != 0.0}">
									Final Total :
								</c:if></td>
							<td style="font-size: 14px;" align="right"><c:if
									test="${print.editBeanData.fTotal != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2">${print.editBeanData.fTotal}</fmt:formatNumber>
								</c:if></td>

						</tr>
						<tr>
							<td class="width_40" style="font-size: 14px;" align="right"><c:if
									test="${print.editBeanData.roundOf != 0.0}">
									Round of :
								</c:if></td>
							<td style="font-size: 14px;" align="right"><c:if
									test="${print.editBeanData.roundOf != 0.0}">
									<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2">${print.editBeanData.roundOf}</fmt:formatNumber>
								</c:if></td>

						</tr>
						<tr>
							<td class="width_40" style="font-size: 14px;" align="right"><c:if
									test="${print.editBeanData.finalTotal != 0.0}">
									<b>Total :</b>
								</c:if></td>
							<td style="font-size: 14px;" align="right"><c:if
									test="${print.editBeanData.finalTotal != 0.0}">
									<b><fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2">${print.editBeanData.finalTotal}</fmt:formatNumber></b>
								</c:if></td>

						</tr>
						<%-- <td style="font-size: 11px;" colspan="1"><b>CGST :</b>${print.editBeanData.totalTaxCGST}</td>
						<td style="font-size: 11px;" colspan="1"><b>IGST :</b>${print.editBeanData.totalTaxCGST}</td>
						<td style="font-size: 11px;" colspan="1"></td> --%>

					</table>
		</table>
		<table class="width_100"
			style="float: left; border-left: none; border-right: none;">
			<tr>
				<td class="no-border" align="left"><br> <font face="arial"
					size="2">Total Order Value :
						${print.editBeanData.amountinWords} </font></td>
			</tr>
			<tr>
				<td class="no-border" align="left"><br> <font face="arial"
					size="2">Remarks : ${print.editBeanData.remarks} </font></td>
			</tr>
			<tr>
				<td class="no-border" align="left"><br> <font face="arial"
					size="2">Other Charges Remarks :
						${print.editBeanData.remarksforother} </font></td>
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
				<td class="no-border" align="center" style="font-size: 11px;">${print.editBeanData.preparedBy}</td>
				<td class="no-border" align="center" style="font-size: 11px;"></td>
				<td class="no-border" align="center" style="font-size: 11px;"></td>
			</tr>

		</table>
		<br> <br> <br>
		</table>
	</div>
</body>
</html>