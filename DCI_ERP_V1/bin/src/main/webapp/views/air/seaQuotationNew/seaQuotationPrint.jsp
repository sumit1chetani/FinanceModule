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


<title></title>
<style>
body {
	background-color: #FFFFFF;
	color:#000000;
	font-family: 'Times New Roman';
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

.padding-top-30 {
	padding-top: 30px;
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

.footer {
	width: 100%;
	position: relative;
	bottom: 0px;
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
	white-space: -moz-pre-wrap; /* Firefox */
	white-space: -o-pre-wrap; /* Opera */
	white-space: pre-wrap; /* Chrome */
	word-wrap: break-word; /* IE */
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

.normal {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	text-decoration: none
}

.description, .description th {
	border-bottom: 1pt solid #fff;
	border-top: -1pt solid #fff;
}

.description1, .description1 th {
	border-bottom: 0px solid #fff;
}

.description, .description td {
	border-bottom: 1pt solid #fff;
	border-top: -1pt solid #fff;
}

.description1, .description1 td {
	border-bottom: 0px solid #fff;
}

.description2, .description2 td {
	border-bottom: 0px;
}

.tablespace {
	padding-left: 5px;
}

.tablespace1 {
	padding-top: 5px;
	padding-bottom: 5px;
}

.tablespace2 {
	padding-top: 5px;
	padding-bottom: 5px;
	padding-left: 10px;
}

.gridheadercell {
	/* color: #000000;
 background: #ffe6a2; */
	color: #fff;
	background: #F37F52;
	text-align: center;
	FONT-FAMILY: Arial;
	FONT-SIZE: 8pt;
	padding: 2px;
	font-weight: bold;
}
</style>
<style type="text/css" media="print">
html, body {
	size: auto;
	margin: 0;
	padding: 0;
	border:1px solid;
}
/* body { height: 11in;  width: 8.5in; } */
a[href]:after {
	content: " (" attr(href) ")";
}
/* #footer { position: absolute; bottom: 0; width:100%; margin:0 auto;} */
@page :last { @bottom-center { content:element(footer, last);
	
}

#content {
	display: table;
}

#footer {
	display: table-footer-group;
	width: 100%;
	position: absolute;
	bottom: 0;
}

#pageFooter:after {
	counter-increment: page;
	content: counter(page);
}

}
.detail-table-font {
	font-size: 11px;
	font-family: arial;
}

@page {
	size: A4;
	margin: 2mm;
}
</style>

</head>
<body style="border:1px solid black" >
	<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="hdr" value="${masterList}" />


	<div id="content">

		<table class="width_100" align="center" border="0" cellPadding="0"
			cellSpacing="0">
			<tr>
				<td>
					<table border="0" class="padding-top-2" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td width="50%" style="text-align: center;    padding-right: 200px;">

								<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="" align="center">
									<tr>
										<td width="25%"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 10 0 0 10; height: 60px;"></td>
										<td width="75%" style="font-size:12px;"><span
											style="text-align: center;     text-transform: uppercase;"><center><b>${user.tenantId}
													</b></center></span> <%-- 								<span style="text-align: right;" ng-if="${user.tenantId} == unicon"><b>UNICON GLOBAL LOGISTICS PVT LTD</b></span> --%>
											<br>
										<span class="" style="font-size: 12px;" ><center><b>
												${hdr.address1} ${hdr.address2}</b></center></span> <br>
										<!-- <span  style="    margin-left: 116px;font-size: 12px;"> </span> <br> -->
										<span style="font-size: 12px;" ><center><b>${hdr.address3}</b></center></span><br>
										<span style="font-size: 12px;"><center><c:if test="${hdr.gstnNo != ''}">GSTNO:${hdr.gstnNo}</c:if></span></center>
										
									</tr>
								</table>
							</td>

						</tr>
						<tr>
						</tr>
					</table>
					<p>
					<h2 align="center" style="font-size: 12px;padding-right: 138px;">Quotation</h2>
					<table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						<tr>
							<td align="left"
								style="padding-left: 28px; font-size: 12px; font-family: arial;"><span
								style="font-size: 12px; font-family: arial;"><b>Quotation
										No</b> : ${hdr.quotationNo}<br> </span></td>
							<td align="right"
								style="padding-left: 3px; font-size: 14px; font-family: arial;"><span
								style="font-size: 12px; font-family: arial;padding-right: 145px;" ><b>Quotation
										Date</b> : ${hdr.quotationDate}<br> </span></td>
						</tr>
					</table> <br> 

					<table class="table" width=100% border=0 bordercolor=""
						cellspacing="0" cellpadding="2" align="center">
						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 12px; font-family: arial;"><b style="padding-left: 27px;">To</b></td>
							<td colspan=1 style="border-top: none !important"></td>
						</tr>

						<c:if test="${hdr.attention != ''}">

						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%;  width: 25%;  padding-left: 63px; font-size: 12px; font-family: arial;"><b>Kind
									Attention</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.attention}</td>
						</tr>
						</c:if>

						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 12px;  width: 25%;   padding-left: 63px; font-family: arial;"><b>Customer
									Name</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.custName}</td>
						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%; width: 25%;   padding-left: 63px; font-size: 12px; font-family: arial; width: 241px;"><b>Address</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.custAddress1} ${hdr.custAddress2} ${hdr.custAddress3}
								${hdr.custAddress4}</td>

						</tr>
						<tr>

						</tr>
					</table>





					<table class="table" width=100% border=0 bordercolor=""
						cellspacing="0" cellpadding="2" align="center">
						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%;  font-family: arial; font-size: 12px;"><b style="padding-left: 22px;">Consignment
									Details</b></td>
							<td colspan=1 style="border-top: none !important"></td>
						</tr>

						<tr ng-if="${hdr.mode}=='4'">
							<td colspan=1 style="border-top: none !important; line-height: 145%;    width: 25%;    padding-left: 65px; font-size: 12px; font-family: arial;"><b>POL</b></td>
							<td colspan=1 style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.aolName}</td>
							<td colspan=1 style="border-top: none !important; line-height: 145%;    width: 16%; font-size: 12px; font-family: arial;"><b>POD</b></td>
							<td colspan=1 style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.aodName}</td>
						</tr>
<tr>
							<td colspan=1 style="border-top: none !important; line-height: 145%;    width: 25%;    padding-left: 65px; font-size: 12px; font-family: arial;"><b>POT</b></td>
							<td colspan=1 style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.pot}</td>
							<td colspan=1 style="border-top: none !important; line-height: 145%;    width: 16%; font-size: 12px; font-family: arial;"><b>FPOD</b></td>
							<td colspan=1 style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.fpod}</td>
						</tr>
						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%;     padding-left: 65px;    width: 25%;font-size: 12px; font-family: arial;"><b>ORIGIN</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.originName}</td>
							<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 12px;    width: 16%; font-family: arial;"><b>DESTINATION</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.destinationName}</td>
						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 12px;     padding-left: 65px;   width: 25%; font-family: arial;"><b>SERVICE
									TYPE</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.serviceType}</td>
								<c:if test="${hdr.termName != ''}">
							<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 12px;    width: 16%; font-family: arial;"><b>TERM</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.termName}</td>
									</c:if>
										<c:if test="${hdr.termName == ''}">
										<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 12px;    width: 16%; font-family: arial;"><b></b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								</td>
											</c:if>

						</tr>
						<tr>
						<c:if test="${hdr.commodityName != ''}">
							<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 12px;     padding-left: 65px;   width: 25%; font-family: arial;"><b>COMMODITY</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.commodityName}</td>
								</c:if>
								<c:if test="${hdr.commodityName == ''}">
								<td style="border-top: none !important; line-height: 145%; font-size: 12px;     padding-left: 65px;   width: 25%; font-family: arial;"> <b></b></td><td style="border-top: none !important; font-size: 12px; font-family: arial;"></td>
									</c:if>
								
							<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 12px;    width: 16%; font-family: arial;"><b>VALIDITY
									DATE</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.validityDate}</td>


						</tr>
						<c:if test="${hdr.remarks != ''}">
												
						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 12px;     padding-left: 65px;   width: 25%; font-family: arial;"><b>REMARKS</b></td>
							<td colspan=1
								style="border-top: none !important; font-size: 12px; font-family: arial;">:
								${hdr.remarks}</td>

						</tr>
						</c:if>
					</table> 

	<br>
	<table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
	<tr>
							<td colspan=1
								style="border-top: none !important;    padding-left: 22px; line-height: 145%; font-size: 12px; font-family: arial;"><b>Charge
									Details</b></td>
							<td colspan=1 style="border-top: none !important"></td>
						</tr>
	</table>
	

					<table width=96% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						
						<tr>
							<td class="padding-top-10">
								<table class="" align="left" border="1" bordercolor=""
									cellPadding="0" cellSpacing="0" width=100%>
									<thead>
										<tr class="">
											<th class="width_30" height="10" text-align="center"
												style="font-size: 11px;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;"><span
												class="bold">Charge Heads </span></th>
											<th class="width_18" height="10" align="center"
												style="font-size: 11px;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;"><span
												class="bold"> Unit </span></th>
											<th class="width_8" height="10" align="center"
												style="font-size: 11px;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;"><span
												class="bold">Qty </span></th>
											<th class="width_4" height="10" align="center"
												style="font-size: 11px;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;"><span
												class="bold">Rate </span></th>
											<th class="width_8" height="10" align="center"
												style="font-size: 11px;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;"><span
												class="bold">Currency </span></th>
											<c:if test="${hdr.note != ''}">
											<th class="width_20" height="10" align="center"
												style="font-size: 11px;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;"><span
												class="bold">Notes</span></th>
												</c:if>
												  
												
										</tr>
									</thead>
									<c:forEach var="detailObj1" items="${detailList}">
										<tbody>


											<tr class="description">
												<td class="width_30 " align="left" 
													style="font-size: 11px;     padding: 9px;   padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;" valign="top"><span >${detailObj1.chargeHead}</span></td>
												<td class="width_6" align="left"
													style="font-size: 11px;    padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;" valign="top"><span style="    padding: 9px;">${detailObj1.unitName}</span></td>
												<td class="width_1 " align="right"
													style="font-size: 11px;    padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;" valign="top"><span style="    padding: 9px;">${detailObj1.quantityCount}</span></td>
												<td class="width_2 " align="right"
													style="font-size: 11px;    padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;" valign="top"><span style="    padding: 6px;">${detailObj1.rate}</span></td>
												<td class="width_5" align="left"
													style="font-size: 11px;    padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;" valign="top"><span style="    padding: 6px;">${detailObj1.currencyName}</span></td>
											<c:if test="${detailObj1.note != ''}">
												<td class="width_30 " 
													style="font-size: 11px;padding: 9px; padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;" valign="top" >${detailObj1.note}</td>
    </c:if>
											</tr>



										</tbody>
									</c:forEach>
								</table>
							</td>
						</tr>
					</table>
					<br>&nbsp;&nbsp;&nbsp;&nbsp;
					
					Please issue all payment in favour of "MBK Logistix Private Limited"
					<table class="table" width=100% border=0 bordercolor=""
						cellspacing="0" cellpadding="2" align="center">
						<tr>
							<td colspan=6
								style="border-top: none !important;padding-top: 17px;
 padding-left: 22px;line-height: 145%; font-size: 12px; font-family: arial;"><b>Terms
									& Conditions : </b></td>
							<td colspan=1 style="border-top: none !important"></td>
						</tr>
						<br>


						<tr>
							<td colspan=20
								style="border-top: none !important;padding-left: 22px; padding-top: 13px; font-size: 12px; font-family: arial;"><b>1. Rates applicable on Freight prepaid basis.
 </b></td>
							<td colspan=1 style="border-top: none !important"></td>
						</tr>

						<tr>
							<td colspan=20
								style="border-top: none !important;padding-left: 22px;padding-top: 5px; font-size: 12px; font-family: arial;"><b>2. Subject to space & equipment availability.</b></td>
							<td colspan=1 style="border-top: none !important"></td>
						<tr>
							<td colspan=20 style="border-top: none !important; font-size: 12px; padding-top: 5px;padding-left: 22px; font-family: arial;"><b>3. Subject to approval from POL & POD.</b></td>
							<td colspan=1 style="border-top: none !important"></td>

						</tr>
						<tr>
							<td colspan=20
								style="border-top: none !important; font-size: 12px;padding-left: 22px;padding-top: 5px; font-family: arial;"><b>4. Subject to PSL Standard Trading Conditions.</b></td>
							<td colspan=1 style="border-top: none !important"></td>

						</tr>
						<tr>
						<tr>
							<td colspan=20
								style="border-top: none !important; font-size: 12px;padding-left: 22px;padding-top: 5px; font-family: arial;"><b>5. Service taxes extra as applicable on ODC / THC / DOC. 
 </b></td>
 <td colspan=1 style="border-top: none !important"></td>
 </tr>
 <tr>
 
 	<td colspan=20
								style="border-top: none !important; font-size: 12px;padding-left: 22px;padding-top: 5px; font-family: arial;"><b>6. All other destination charges will be on account of consignee.
 
 </b></td>
 <td colspan=1 style="border-top: none !important"></td>
 </tr>
 <tr>
 	<td colspan=20
								style="border-top: none !important; font-size: 12px;padding-left: 22px;padding-top: 5px; font-family: arial;"><b>7. Any changes in the dimensions/weight will automatically nullify this quote.

 </b></td>
 <td colspan=1 style="border-top: none !important"></td>
 </tr>
 <tr>
 <td colspan=20
								style="border-top: none !important; font-size: 12px;padding-left: 22px;padding-top: 5px; font-family: arial;"><b> 8. Please note cargo may be transshipped and transit times and routings are given as indications without warranty.


 </b></td>
 <td colspan=1 style="border-top: none !important"></td>
 </tr>

					</table>
					<br>
					<br>
					<br>
					
		
					<table class="table" width=100% border=0 bordercolor=""
						cellspacing="0" cellpadding="2" align="center">
						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%; text-decoration: underline; text-transform: uppercase;padding-left: 22px; font-size: 12px; font-family: arial;"><b>FOR
									${user.tenantId}  </b></td>
							<td colspan=1 style="border-top: none !important"></td>
						</tr>


						<tr>
							<td colspan=1
								style="border-top: none !important; line-height: 145%; font-size: 14px; font-family: arial;"><b style="padding-left: 20px">(${hdr.name})</b></td>
							<td colspan=1 style="border-top: none !important"></td>
						</tr>
						<table class="table" width=100% border=0 bordercolor=""
						cellspacing="0" cellpadding="2" align="center">
			
		
						<tr>
							<td colspan=1
								style="border-top: none !important; font-size: 11px; font-family: arial;"><b style="padding-left:20px">(This is a System Generated Quotation. No Signature Required)</b></td>
							<td colspan=1 style="border-top: none !important"></td>
						</tr>
						</table>
						
						

						<tr>
					</table>

				</td>
			</tr>
		</table>
		
		
	</div>

</body>
</html>
