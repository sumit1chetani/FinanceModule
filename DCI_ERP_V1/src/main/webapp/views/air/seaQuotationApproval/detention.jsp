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
	margin-bottom: 4px;
}


@page{
size: A4;
margin: 6mm;

}


</style>
</head>
<body>

	<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="object1" value="${masterList}" />
	<div id="content" style="margin-bottom: 10px;">
				<table border="0" class="padding-top-2" class="class_border" width="100%"
						cellpadding="0" cellspacing="0"  style="padding-top: 20px; border: none;" align="center">
						<tr>
							<td width="100%" style="text-align: center;">
								<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="" align="center">
									<tr>
										<td width="40%"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 0px 0 0 40px; height: 65px;"></td>                                   
										<td width="60%" style="word-wrap: break-word;padding-left: 2%;padding-right: 15%;">
											<span style="text-align: left;font-size: 17px;"><b>${object1.branchName}</b></span> <br> <br> 
											<span style="text-align: left;font-size: 15px;">${object1.branchAddress}</span> 
																						
																						 <c:if test="${object1.stateNam != null && object1.stateNam != ''}"> ${object1.stateNam} 
													<c:if test="${object1.stateCode != null && object1.stateCode != ''}"> - ${object1.stateCode}</c:if><br> 
												</c:if> <span style="text-align: left;font-size: 15px;"><c:if test="${object1.telNo != null && object1.telNo != ''}">Tel. No. : ${object1.telNo}</c:if> <c:if test="${object1.telNo != null && object1.telNo != '' && object1.faxNo != null && object1.faxNo != ''}"> / </c:if><c:if test="${object1.faxNo != null && object1.faxNo != ''}">Fax. No. : ${object1.faxNo}</c:if></span> <br>
												<span style="text-align: left;font-size: 15px;">
												<c:if test="${object1.branchGstno != null && object1.branchGstno != ''}">GSTNO : ${object1.branchGstno} <br></c:if> 
												<%-- <c:if test="${object1.stateNameNew != null && object1.stateNameNew != ''}">State Name : ${object1.stateNameNew} 
													<c:if test="${object1.stateCode != null && object1.stateCode != ''}">, Code : ${object1.stateCode}</c:if><br> 
												</c:if> 
												<c:if test="${object1.cin != null && object1.cin != ''}">CIN : ${object1.cin} <br></c:if> 
												<c:if test="${object1.mailId != null && object1.mailId != ''}">E-mail : ${object1.mailId}</c:if>
										 --%>	</span>
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
					
					 <br>
				<table width=100% align="center" border="1" cellPadding="0"style="border-left: none;
    border-right: none;"
						cellSpacing="0"  style="border-left:none;border-right:none;margin-left: 0px;">
						<tr>
							<td><center>
									<font size="2" face="arial"><b>STORAGE AND WAREHOUSING SERVICES INVOICE - SWS</b></font>
								</center></td>
						</tr>
					</table> 
					<table width="50%" style="float:left; padding-top:10px; padding-bottom:15px;">
					<tr><td class="width_30" align="left" style="font-size: 10px;"><b>Detais Of Receiver(Billed To)</b></td></tr>
					<tr><td class="width_30" align="left" style="font-size: 10px;">Name</td><td style="font-size: 10px;"> :   ${object1.customerName}</td></tr><tr><td style="font-size: 10px;">Address</td><td style="font-size: 10px;"> : ${object1.address}</td></tr><tr><td style="font-size: 10px;">State </td><td style="font-size: 10px;">: ${object1.state}</td></tr>
							<tr><td style="font-size: 10px;">GSTIN / Unique ID </td><td style="font-size: 10px;">:${object1.gstNo}</td></tr>
							<%-- <tr><td align="left" style="font-size: 10px;">State Code :${object1.pinCode}</td></tr>
							<tr><td align="left" style="font-size: 10px;">Place of Supply :${object1.plaSupply}</td></tr> --%>
								
									
								</table>
								
					<table width="50%" style="float:left; padding-top:10px; padding-bottom:15px;"><tr>
							<td class="width_40"  style="font-size: 10px;">Invoice No</td><td style="font-size: 10px;">: ${object1.invoiceNo}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;">Invoice Date</td><td style="font-size: 10px;">: ${object1.invoiceDate}</td></tr>
							 <tr><td class="width_40"  style="font-size: 10px;">Container Type</td><td style="font-size: 10px;">: ${object1.invoiceNo}</td></tr>
							<tr><td class="width_40" style="font-size: 10px;">Vessel / Voyage No</td><c:if test="${object1.voyageCode != null}"><td style="font-size: 10px;">: ${object1.voyageCode}</td></c:if><c:if test="${object1.voyageCode == null}"><td style="font-size: 10px;">: &nbsp;&nbsp; -</td></c:if></tr>
							<tr><td class="width_40" style="font-size: 10px;">POL</td><td style="font-size: 10px;">: ${object1.pol}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;">POD</td><td style="font-size: 10px;">: ${object1.pod}</td></tr>
								
							</table>
				<br>



<table class="table table-striped b-t b-light " style="border-left: none;
    border-right: none;"
						align="left" border="1" bordercolor="" cellPadding="0"
						cellSpacing="0" width=100% style="border-left:none;border-right:none;margin-left: 0px;">

<thead><tr>
							<td class="width_10" align="center" style="font-size: 10px;" colspan="6"><b>GROUND RENT</b>
								</td>
								<td class="width_10" align="center" style="font-size: 10px;" colspan="5"><b>LINE DETENTION</b>
								</td>
						</tr>
							<tr>
								<th class="width_3" align="center" style="font-size: 10px;">sr.</th>
							    <th class="width_10" align="center" style="font-size: 10px;">Container No</th>
								<th class="width_6" align="center" style="font-size: 10px;">Size</th>
								<th class="width_8" align="center" style="font-size: 10px;">ARR Dt</th>
								<th class="width_5" align="center" style="font-size: 10px;">RLS</th>
								<th class="width_8" align="center" style="font-size: 10px;">Gr Amount</th>
								<th class="width_8" align="center" style="font-size: 10px;">ARR Dt</th>
								<th class="width_5" align="center" style="font-size: 10px;">RTN</th>
								<th class="width_8" align="center" style="font-size: 10px;">LD Amount</th>																
								<th class="width_15" align="center" style="font-size: 10px;">TOTAL</th>
							</tr>
							<!-- <tr><th></th><th></th><th></th><th></th><th></th><th></th>
							<th class="width_5" align="center" style="font-size: 10px;">S1</th>
																<th class="width_5" align="center" style="font-size: 10px;">S2</th>
																<th class="width_5" align="center" style="font-size: 10px;">S3</th>
																<th></th><th></th><th></th>
																<th class="width_5" align="center" style="font-size: 10px;">S1</th>
																<th class="width_5" align="center" style="font-size: 10px;">S2</th>
																<th class="width_5" align="center" style="font-size: 10px;">S3</th><th></th>
																<th class="width_15" align="center" style="font-size: 10px;"></th>
																
						</tr> -->
						</thead><tbody>
							<c:forEach var="ob"
								items="${masterList.grldInvoiceDetail}"
								varStatus="theCount">
								<tr>
									<td  align="center" valign="middle" style="font-size: 10px;">${ob.invoiceNo}</td>
                                     <td  align="left" style="font-size: 10px;">${ob.containerNo}</td>
                                       
									<td align="center" valign="middle" style="font-size: 10px;"><center>${ob.containerType}</center></td>
									<td align="right" style="font-size: 10px;">
										${ob.dischargeDate}
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.releaseDate} 
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.grAmount}
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.dischargeDate}
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.returnDate} 
									</td>
									
									<td align="right" style="font-size: 10px;">
										${ob.ldAmount}
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.grAmount+ob.ldAmount}
									</td>

								</tr>
															</c:forEach>
								
								<tr>
                                    <td align="right" style="font-size: 10px;" colspan="6">
										Total Cargo Handling Services - CHS 
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${object1.total}
									</td>
									</tr>
									<tr>
                                    <td align="right" style="font-size: 10px;" colspan="6">
										Add : CGST @ 
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${object1.cgstpercentage}.0%
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${object1.cgst}
									</td>
									</tr>
									<tr>
                                    <td align="right" style="font-size: 10px;" colspan="6">
										Add : SGST @ 
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${object1.sgstpercentage}.0%
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${object1.sgst}
									</td>
									</tr>
									<tr>
                                    <td align="right" style="font-size: 10px;" colspan="6">
										Add : IGST @ 
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${object1.igstpercentage}.0%
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${object1.igst}
									</td>
									</tr>
									<tr>
                                    <td align="right" style="font-size: 10px;" colspan="6">
										<b>Ground Total Amount</b>
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										<b>${object1.grandtotal}</b>
									</td>
									</tr>
                                  <tr>
                                    <td align="left" style="font-size: 15px;" colspan="10">
										<b> &nbsp;&nbsp; Amout in Words (Rupees Only) :  &nbsp;&nbsp; &nbsp;${object1.id}</b><br>
										<b> &nbsp;&nbsp; Amout of Tax Subject To Reverse &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;${object1.grandtotal}</b>
									</td>
									</tr>
									<tr>
                                    <td align="left" style="font-size: 10px;" colspan="10">
										<b> &nbsp;&nbsp; For MBK Logistix Private Limited</b><br><br>
										<b> &nbsp;&nbsp; Authorized Signatory</b>
									</td>
									</tr><!-- <tr>
										<th class="width_15" align="center" style="font-size: 10px;" colspan="3">Charges</th>
									
                                    <th class="width_5" align="center" style="font-size: 10px;" colspan="2">S1</th>
																<th class="width_5" align="center" style="font-size: 10px;" colspan="2">S2</th>
																<th class="width_5" align="center" style="font-size: 10px;" colspan="2">S3</th>
																	<th class="width_15" align="center" style="font-size: 10px;"colspan="2">Charges</th>

																<th class="width_5" align="center" style="font-size: 10px;" colspan="2">S1</th>
																<th class="width_5" align="center" style="font-size: 10px;" colspan="2">S2</th>
																<th class="width_5" align="center" style="font-size: 10px;" colspan="2">S3</th>
									</tr> -->
									<%-- <c:forEach var="ob"
								items="${masterList.grldInvoiceDetail}"
								varStatus="theCount">
								<tr>
									
<td  align="left" style="font-size: 10px;" colspan="3">GR(${ob.containerType})</td>
                                       <td  align="left" style="font-size: 10px;" colspan="2">${ob.invoiceNo}</td>
									<td align="left" valign="middle" style="font-size: 10px;" colspan="2"><center>${ob.containerType}</center></td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${ob.invoiceNo}
									</td>
									
									<td align="left" style="font-size: 10px;" colspan="2">
										LD(${ob.containerType})
									</td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${ob.invoiceNo} 
									</td>
									<td align="left" valign="middle" style="font-size: 10px;" colspan="2"><center>${ob.containerType}</center></td>
									<td align="right" style="font-size: 10px;" colspan="2">
										${ob.invoiceNo}
									</td>
									

								</tr>
															</c:forEach> --%>
															<tr>
                                    <td align="left" style="font-size: 10px;" colspan="10">
										<b> &nbsp;&nbsp; Bank Details for NEFT/RTGS&nbsp;&nbsp; : </b><br><br><br>
									<br>&nbsp;&nbsp; All Cheques/Demand Drafts should be in favour of "MBK Logistix Private Limited"
									<br><br>
									&nbsp;&nbsp; Bank&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${object1.bankName}<br>
									<!-- <br>&nbsp;&nbsp; Accout Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<br>
									 --><br>&nbsp;&nbsp; Current A/C. No &nbsp;&nbsp;&nbsp;&nbsp;: ${object1.acctNo} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%-- MICR Code&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : ${ob.invoiceNo} --%>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IFSC Code &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${object1.ifsc}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<br><br>
									<b>&nbsp;&nbsp;&nbsp;PAN NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>: <b>${object1.pan}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CIN NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>: <b>${object1.cin}</b>
									<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
									 <span class=footer-text><center>*This is a Computer generated invoice and requires no signature*</center></span>
									</td>
									</tr>
						
		</table>
		
	</div>

</body>
</html>
