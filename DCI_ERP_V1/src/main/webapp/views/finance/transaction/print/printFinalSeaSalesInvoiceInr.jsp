<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">


<style>
body {
	background-color: #FFFFFF;
	color: #000000;
	font-family: 'Arial';
	border :1px solid;
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
}
</style>
<style type="text/css" media="print">
html, body {
	margin: 0;
	padding: 0;
}
/* body { height: 11in;  width: 8.5in; } */
a[href]:after {
	content: " (" attr(href) ")";
}

#footer {
	display: table-footer-group;
	width: 100%;
	position: absolute;

	/* bottom:3px; */
}

#content {
	margin-bottom: 6px;
}


@page{
size: A4;
margin: 6mm;

}


</style>
</head>
<body >

	<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="object1" value="${purchaseInvoiceList}" />
	<c:set var="object2" value="${shipperDetails}" />
	<c:set var="con" value="${containerDetails}" />
	
	<div id="content" style="margin-bottom: 10px;">
				<table class="padding-top-2 class_border" width=100% align="center" border="0" cellPadding="0" style="padding-top: 20px;border-left:none;border-right:none;margin-left: 0px;border-left: none; border-right: none;" cellSpacing="0" >
						<tr>
							<td width="100%" style="text-align: center;">
								<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="" align="center">
									<tr>
										<td width="40%"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 0px 0 0 40px; height: 65px;"></td>                                   
										<td width="60%" style="word-wrap: break-word;padding-left: 2%;padding-right: 2%;">
											<span style="text-align: left;font-size: 17px;"><b>${object1.branchName}</b></span> <br> <br> 
										<p style="text-align: right">	<span style="font-size: 13px;">${object1.branchAddress1}</span> <br> 
											<span style="font-size: 13px;">
												<c:if test="${object1.branchGstno != null && object1.branchGstno != ''}">GSTNO : ${object1.branchGstno} <br></c:if> 
												<c:if test="${object1.stateNameNew != null && object1.stateNameNew != ''}">State Name : ${object1.stateNameNew} 
													<c:if test="${object1.stateCode != null && object1.stateCode != ''}">, Code : ${object1.stateCode}</c:if><br> 
												</c:if> 
												<c:if test="${object1.cin != null && object1.cin != ''}">CIN : ${object1.cin} <br></c:if> 
												<c:if test="${object1.mailId != null && object1.mailId != ''}">E-mail : ${object1.mailId}</c:if>
											</span></p>
										</td>
										<!-- <td width="10%">
										</td> -->									
									</tr>
								</table>
							</td>

						</tr>
						<tr>
						</tr>
					</table>
					<%-- <table border="0" class="padding-top-2" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF"
						align="center" style="border-left:none;border-right:none">
						<tr>
							<td width="50%" style="text-align: center;">

								<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF"  align="center" style="border-left:none;border-right:none;margin-left: 0px;">
									<tr>
										<td width="25%"><img
											src="/img//${user.tenantId}HelpVideos/logo.jpg"
											style="padding: 10 0 0 10; height: 50px;"></td>
                                   
										<td width="75%" style="font-size: 14px;"><span style="text-align: center;"><b>ATHENA
													GLOBAL LOGISTICS PVT LTD</b></span> <br> <span
											style="text-align: right;" style="font-size: 12px;">${object1.branchAddress1},${object1.branchAddress2},${object1.branchZip} </span> <br> <span
											style="text-align: right;" style="font-size: 12px;">${object1.branchAddress3}</span> <br> </td>
									
									</tr>
								</table>
							</td>

						</tr>
						<tr>
						</tr>
					</table> --%> <br>
					<table width=100% align="center" border="1" cellPadding="0"style="border-left: none;
    border-right: none;"
						cellSpacing="0"  style="border-left:none;border-right:none;margin-left: 0px;">
						<tr>
							<td><center>
									<font size="2" face="arial"><b>TAX INVOICE</b></font>
								</center></td>
						</tr>
					</table> 
					<table width="50%" style="float:left; padding-top:10px; padding-bottom:15px;">
					<tr>
					<td class="width_30" align="left" style="font-size: 10px;"><b>To</b></td></tr><tr><td style="font-size: 10px;"><b>Customer Id:${object1.customerName}</b></td></tr>
					<tr><td style="font-size: 10px;"><b>${object1.cutName}</b></td></tr><tr><td style="font-size: 10px;">${object1.custAddress1}${object1.custAddress2}${object1.custAddress3}
							</td></tr><tr><td align="left" style="font-size: 10px;">GST IN :${object1.gstNo}</td></tr>
							<tr><td align="left" style="font-size: 10px;">State Name :${object1.stateNam}</td></tr>
							<tr><td align="left" style="font-size: 10px;">State Code :${object1.pinCode}</td></tr>
							<tr><td align="left" style="font-size: 10px;">Place of Supply :${object1.plaSupply}</td></tr>
							
							<c:if test="${object2.shipperName !=null }"><tr><td class="width_30" align="left" style="font-size: 10px;"><b>Shipper Name</b></td></tr><tr><td style="font-size: 10px;"><b>${object2.shipperName}<b></td></tr><tr><td style="font-size: 10px;">${object2.shipperAddress1}${object2.shipperAddress2}${object2.shipperAddress3}
							</td></tr></c:if>
							<tr><c:if test="${object2.consigneeName !=null }"><td class="width_30" align="left" style="font-size: 10px;"><b>Consignee Name</b></td></c:if></tr><tr><td style="font-size: 10px;"><b>${object2.consigneeName}<b></td></tr><tr><td style="font-size: 10px;">${object2.consigneeAddress1}${object2.consigneeAddress2}${object2.consigneeAddress3}
							</td></tr>
								
								</table>
					<table width="50%" style="float:left; padding-top:10px; padding-bottom:15px;"><tr>
							<td class="width_40"  style="font-size: 10px;"><b>DATE</b></td><td style="font-size: 10px;">: ${object1.purchaseInvoiceDate}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>SALES INVOICE NO</b></td><td style="font-size: 10px;">: ${object1.purchaseInvoiceNo}</td></tr>
							<c:if test="${object1.mode1 !=5 }"> <tr ><td class="width_40"  style="font-size: 10px;"><b>JOB NO</b></td><td style="font-size: 10px;">: ${object1.jobNo}</td></tr></c:if>
							<c:if test="${object1.mode1 ==5 }"> <tr ><td class="width_40"  style="font-size: 10px;"><b>MBL NO</b></td><td style="font-size: 10px;">: ${object1.mblNumber}</td></tr></c:if>
							<tr><td class="width_40" style="font-size: 10px;"><b>Booking NO</b></td><c:if test="${object1.bookNo != null}"><td style="font-size: 10px;">: ${object1.bookNo}</td></c:if><c:if test="${object1.bookNo == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr>
<c:if test="${object1.mode1 !=5 }"><tr><td class="width_40"  style="font-size: 10px;"><b>BCG NO</b></td><c:if test="${object1.bcgNo != null}"><td style="font-size: 10px;">: ${object1.bcgNo}</td></c:if><c:if test="${object1.bcgNo == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr></c:if>
							<c:if test="${object1.mode1 ==5 }"><tr><td class="width_40"  style="font-size: 10px;"><b>CARRIER</b></td><c:if test="${object1.carrier != null}"><td style="font-size: 10px;">: ${object1.carrier}</td></c:if><c:if test="${object1.carrier == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr></c:if>
							


							<%-- <tr><td class="width_40" style="font-size: 10px;"><b>HBL NO</b></td><c:if test="${object1.hbl != null}"><td style="font-size: 10px;">: ${object1.hbl}</td></c:if><c:if test="${object1.hbl == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>MBL NO</b></td><c:if test="${object1.mbl != null}"><td style="font-size: 10px;">: ${object1.mbl}</td></c:if><c:if test="${object1.mbl == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr>
							 --%><tr><td class="width_40" style="font-size: 10px;"><b>POL</b></td><td style="font-size: 10px;">: ${object1.polName}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>POD</b></td><td style="font-size: 10px;">: ${object1.podName}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>FPOD</b></td><td style="font-size: 10px;">: ${object1.podName}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>SAILED DATE</b></td><c:if test="${object1.sailedDate != null}"><td style="font-size: 10px;">: ${object1.sailedDate}</td></c:if><c:if test="${object1.sailedDate == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>ARRIVAL DATE</b></td><c:if test="${object1.arrivalDate != null}"><td style="font-size: 10px;">: ${object1.arrivalDate}</td></c:if><c:if test="${object1.arrivalDate == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr>	
							<tr><td class="width_40" style="font-size: 10px;"><b>VESSEL/VOYAGE</b></td><c:if test="${object1.vessel != ''}"><td style="font-size: 10px;">: ${object1.vessel}</td></c:if><c:if test="${object1.vessel == ''}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr>
							 <tr><td class="width_40"  style="font-size: 10px;"><b>VOLUME</b></td><c:if test="${object1.volume != null}"><td style="font-size: 10px;">: ${object1.volume}</td></c:if><c:if test="${object1.volume == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr> 
							<tr><td class="width_40"  style="font-size: 10px;"><b>NARRATION</b></td><c:if test="${object1.narration != null}"><td style="font-size: 10px;">: ${object1.narration}</td></c:if><c:if test="${object1.narration == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr> 
							
							</table>
					<table width=100% align="center" border="1" cellPadding="0" style="border-left: none;
    border-right: none;"
						cellSpacing="0" style="border-left:none;border-right:none;margin-left: 0px;">
						<tr>
							<td><center>
									<font size="2" face="arial">YOUR ACCOUNT HAS BEEN
										DEBITED TOWARDS THE FOLLOWING CHARGES.</font>
								</center></td>
						</tr>
					</table> <br>
					<table class="table table-striped b-t b-light " style="border-left: none;
    border-right: none;"
						align="left" border="1" bordercolor="" cellPadding="0"
						cellSpacing="0" width=100% style="border-left:none;border-right:none;margin-left: 0px;">
						<thead>
							<tr>
								<th class="width_10" align="center" style="font-size: 10px;">CHARGE HEADS</th>
																<th class="width_6" align="center" style="font-size: 10px;">Container Type</th>
								
								<th class="width_6" align="center" style="font-size: 10px;">SAC NO</th>
								<th class="width_8" align="center" style="font-size: 10px;">QTY</th>
								<th class="width_5" align="center" style="font-size: 10px;">RATE</th>
								<th class="width_5" align="center" style="font-size: 10px;">CURRENCY</th>
								<th class="width_8" align="center" style="font-size: 10px;">EX-RATE</th>
								<th class="width_10" align="center" style="font-size: 10px;">NON-TAXABLE</th>
								<th class="width_10" align="center" style="font-size: 10px;">TAXABLE</th>
								<th class="width_5" align="center" style="font-size: 10px;">CGST%</th>
								<th class="width_7" align="center" style="font-size: 10px;">CGST AMOUNT</th>
								<th class="width_5" align="center" style="font-size: 10px;">SGST %</th>
								<th class="width_7" align="center" style="font-size: 10px;">SGST AMOUNT</th>
								<th class="width_5" align="center" style="font-size: 10px;">IGST %</th>
								<th class="width_7" align="center" style="font-size: 10px;">IGST AMOUNT</th>
								<th class="width_12" align="center" style="font-size: 10px;">TOTAL</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ob"
								items="${purchaseInvoiceList.purchaseInvoiceDetail}"
								varStatus="theCount">
								<tr>
									<td  align="left" style="font-size: 10px;">${ob.accountHeadCode}</td>
<td  align="left" style="font-size: 10px;">${ob.conType}</td>

                                        <c:if test="${ob.sacNo == 0}">
									<td align="left" valign="middle" style="font-size: 10px;"><center></center></td></c:if>
									<c:if test="${ob.sacNo != 0}">
									<td align="left" valign="middle" style="font-size: 10px;"><center>${ob.sacNo}</center></td></c:if>
									<td align="right" style="font-size: 10px;">
										${ob.qty}
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.rate} 
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.currency}
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.exchangeRate} 
									</td>
									
									<td align="right" style="font-size: 10px;"><c:if
													test="${ob.taxAmount == 0}"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.amount}" /></c:if></td>
										
										
										<td align="right" style="font-size: 10px;"><c:if
													test="${ob.taxAmount != 0}"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.amount}" /></c:if></td>
										
									<td align="right"
										valign="right" style="font-size: 10px;">${ob.cgstPrct}
									</td>
									<td align="right"
										valign="right" style="font-size: 10px;"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.cgstAmt}" />
									</td>
									<td align="right"
										valign="right" style="font-size: 10px;">${ob.sgstPrct}
									</td>
									<td align="right"
										valign="right" style="font-size: 10px;"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.sgstAmt}" />
									</td>
									<td align="right"
										valign="right" style="font-size: 10px;">${ob.igstPrct}
									</td>
									<td align="right"
										valign="right" style="font-size: 10px;"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.igstAmt}" />
									</td>
										
									<td align="right"
										valign="right" style="font-size: 10px;"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.subTotal}" />
									</td>

								</tr>
							</c:forEach>
                              <tr>
                              <td colspan="7" class="width_10" align="right" style="font-size: 12px;" >TOTAL</td>                      
                             <!--  <td align="right" valign="right" style="font-size: 10px;"></td> -->
                               <td align="right" valign="right" style="font-size: 10px;" ><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.subAmtTotal}" /></td>
                              <td align="right" valign="right" style="font-size: 10px;" ><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.subAmtTaxTotal}" /></td>
                              
                              <td align="right" valign="right" style="font-size: 10px; " colspan="2"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.subCgstTaxTotal}" /></td>
                             
                              <td align="right" valign="right" style="font-size: 10px;" colspan="2"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.subSgstTaxTotal}" /></td>
                              
                                <td align="right" valign="right" style="font-size: 10px;" colspan="2"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.subIgstTaxTotal}" /></td>
                                
                              <td align="right" valign="right" style="font-size: 10px;"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.totalAmount}" /></td>
                              </tr> 
                              <tr>
                              
                              <td colspan="8" class="width_10" align="right" style="font-size: 12px;" >ROUND OFF</td>                      
                            
                              
                              <td align="right" valign="right" style="font-size: 10px;"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.roundOff}" /></td>
												<td colspan="6" class="width_10" align="right" style="font-size: 12px;" >GRAND TOTAL</td>  
                              <td align="right" valign="right" style="font-size: 10px;"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.grandTotal}" /></td>
												</tr>      
						</tbody>
						<table style="font-size: 12px;">
				
						<tbody>
						<c:if test="${containerDetails.containerNo !=''}"><td>Containers:</td></c:if>
							
								<td style="font-family:'Courier New'">${containerDetails.containerNo}&nbsp;</td>
						 </tbody>   
						</table>
						
						<table style="font-size: 12px;">
							
							<tr>
								<td><b>Amount in Words: ${object1.totalAmountInWords}</b></td><br>
						    </tr>
						    <tr>
						     <c:if test="${object1.bankId != 3}"><td>Please issue all payment in favour of &nbsp;"MBK Logistix Private Limited"</td></c:if>
						    <c:if test="${object1.bankId == 3}"><td>Please issue all payment in favour of &nbsp;"MBK Logistix Private Limited"</td></c:if>
						    </tr>
						</table>
					</table></td>
			</tr>
		</table>
	</div>
	<div >
		<%-- <table style="font-size: 10px;" >
						    <tr><td>BANK DETAILS&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankName}</td> </tr>
							<tr><td>ADDRESS&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankAddress}</td></tr>
							<tr><td>ACCOUNT NO &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankAcct}</td></tr>
							<tr><td>SWIFT CODE&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankSwift} </td></tr>
							<tr> <td>IFSC CODE&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankifsc}</td></tr>
                            <tr><td>PAN NO&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.branchPan}</td></tr>
                            <!-- <tr><td>SERVICE TAX NO&nbsp:&nbsp&nbsp${object1.branchSrvctax}</td></tr> -->
                            <tr><td> GSTN IN&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.branchGstno}</td></tr>	
						<tr><td></td></tr>	<tr><td></td></tr>	
				<tr><td>This invoice is due for payment on ${object1.dueDate1}.</td></tr>
					</table> --%>
					<table style="font-size: 10px;" >
						    <tr><td>BANK DETAILS&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbspICICI Bank</td> </tr>
							<tr><td>ADDRESS&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbspRavipuram  branch, ernakulam, Kochi 682020</td></tr>
							<tr><td>ACCOUNT NO &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp116205000660</td></tr>
							<tr><td>SWIFT CODE&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp </td></tr>
							<tr> <td>IFSC CODE&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbspICIC0001162</td></tr>
                            <tr><td>PAN NO&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbspAAHCM8479K</td></tr>
                            <!-- <tr><td>SERVICE TAX NO&nbsp:&nbsp&nbsp${object1.branchSrvctax}</td></tr> -->
                            <tr><td> GSTN IN&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp32AAHCM8479K1ZW</td></tr>	
				<tr><td></td></tr>	<tr><td></td></tr>	
				<%-- <tr><td>This invoice is due for payment on ${object1.dueDate1}.</td></tr> --%>	
					</table>
		<br> <c:if test="${object1.bankId != 3}"><font size="1" face="arial"><b>FOR MBK (${object1.branchName})</b></font></c:if>
		<c:if test="${object1.bankId == 3}"><font size="1" face="arial"><b>FOR MBK (${object1.branchName})</b></font></c:if>
		<br><font size="1" face="arial"> Remarks :${object1.remarks}</font>
		<br><br><br><div style="font-size: 10px;font-weight: bold;"><!-- NOTE: KINDLY CONFIRM THE PROFORMA  INVOICE  WITHIN 5 DAYS FROM DATE OF INVOICE. IF NO REPLY IS RECEIVED, IT WILL BE ASSUMED THAT THE <br> <span style="margin-left: 34px; line-height: 2;">INVOICE HAS BEEN CONFIRMED BY YOU. --></span></div>
		<table  border=0 bordercolor="" cellspacing="0"
			cellpadding="2" align="center">
			<tr>
				<td align="center"><span class=footer-text><center>
							This is a Computer Generated Invoice and does not require
							physical signature.</center> </span></td>
			</tr>
		</table>
	</div>

</body>
</html>
