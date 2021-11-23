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


<title>INVOICE</title>
<style>
body {
	background-color: #FFFFFF;
	color: #333366;
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
	border-top: 1pt solid #fff;
}

.description1, .description1 th {
	border-bottom: 0px solid #fff;
}

.description, .description td {
	border-bottom: 1pt solid #fff;
	border-top: 1pt solid #fff;
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
@page { @bottom-right { content:counter(page)" of "counter(pages);
	
}
}
</style>

</head>
<body>
<input type="hidden" value="${user.tenantId}" id="tenantId" >
	<c:set var="hdr" value="${masterList}" />
	<c:set var="detailObj" value="${detailList}" />

	<div id="content">
		<h2 align="center"> Invoice </h2>
		<table class="width_100" align="center" border="0"
			cellPadding="0" cellSpacing="0">
			<tr>
				<td>
					<table border="1" class="padding-top-2" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td width="50%" style="text-align: center;">
							
							<table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">
							<tr>
								<td width="25%"><img src="/img/${user.tenantId}HelpVideos/logo.jpg" style=" padding:10 0 0 10; height: 60px;">
								</td>
						<c:if test="${user.tenantId.contains('mbk')}">
								<td width="75%"> <span style="text-align: right;"><b>MBK</b></span>
								 <br><span style="text-align: right;">1009, THE AVENUE,INTERNATIONAL AIRPORT ROAD,OPP. THE LEELA,</span>
								 <br><span style="text-align: right;">ANDHERI (EAST),MUMBAI-400 059. INDIA </span>
								 <br><span style="text-align: right;">CIN NO. U62200MH2014PTC252664</span></td></c:if>
						 <c:if test="${user.tenantId.contains('MBK')}">
								<td width="75%"> <span style="text-align: right;"><b>MBK</b></span>
								 <br><span style="text-align: right;">1009, THE AVENUE,INTERNATIONAL AIRPORT ROAD,OPP. THE LEELA,</span>
								 <br><span style="text-align: right;"> ANDHERI(EAST),MUMBAI-400 059. INDIA </span>
								 <br><span style="text-align: right;">CIN NO. U62200MH2014PTC252664 </span></td></c:if>
							 </tr>
							 </table>
							</td>
							<td width="50%" style="font-size: 10px;">
								<table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">
									<tr >
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px; width: 49%"> Invoice No :  <b>${hdr.invoiceNo}</b></td>
											
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;"> Dated :  <b>${hdr.invDate}</b></td>
									 </tr>
								 	<tr>
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;"> Delivery Note :  <b>2491</b></td>
											
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;"> Mode/Terms of Payment :  <b>Cheque</b></td>
									 </tr>
									 <tr>
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;"> Supplier Ref :  <b>IAHS/006/2017</b></td>
											
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;"> Other Reference(s) : <b> ${hdr.remarks}</b></td>
									 </tr>
									 
									 <tr>
										<td style="height : 50px; border-right: 1px solid #cdd0d4; padding-left: 3px;"> Work/Transport Order No : <b> ${hdr.workNo}</b> </td>
											
										<td style="height : 50px; border-right: 1px solid #cdd0d4;padding-left: 3px;"> Dated :  </td>
									 </tr>
							 	</table>
							</td>
						</tr>
						<tr>
							<td width="50%" style="text-align: center;">
								<table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">
									<tr>
										<td style="height: 40px;padding-left: 3px;"> Customer : </td>
									 </tr>
									 <tr>
										<td style="height: 20px; padding-left: 5px; text-align: left;"> <B>  ${hdr.customerName} </B> </td>
									 </tr>
									 <tr>
										<td style="height: 20px; padding-left: 5px; text-align: left;"> ${hdr.address1} </td>
									 </tr>
									  <tr>
										<td style="height: 20px; padding-left: 5px; text-align: left;"> ${hdr.address2} </td>
									 </tr>
									  <tr>
										<td style="height: 20px; padding-left: 5px; text-align: left;">  ${hdr.mloCountry} </td>
									 </tr>
								</table>
							</td>
							<td width="50%" style="font-size: 10px;">
								<table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">
								 	<tr>
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;"> Despatch Document No : <b>1539 </b> </td>
											
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;"> Delivery Note Date : <b> ${hdr.invDate} </b></td>
									 </tr>
									 <tr>
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;"> Despatched Through : <b> ${hdr.truckNo} </b></td>
											
										<td style="height : 50px; border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;"> Destination :  <b>${hdr.pod} </b> </td>
									 </tr>
									 
									 <tr>
									 	<td style=" border-bottom: 1px solid #cdd0d4;border-right: 1px solid #cdd0d4;padding-left: 3px;" colspan="2"> Terms of Delivery  : <b>Transporter</b> </td>
									 </tr>
							 	</table>
							</td>
						</tr>
					</table> 
					<p>
					<table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						<tr>
						</tr>
						<tr>
							<td class="padding-top-10">
								<table class="" align="left" border="1" bordercolor=""
									cellPadding="0" cellSpacing="0" width=100%>
									<thead>
										<tr class="">
											<th class="width_8" height="10" align="center"
												><span class="bold">Sl No.</span></th>
											<th class="width_22" height="10" align="center"
												><span class="bold">Description of Goods</span></th>
											<th class="width_10" height="10" align="center"
												><span class="bold">Quantity</span></th>
											<th class="width_10" height="10" align="center"
												><span class="bold">Rate</span></th>
											<th class="width_10" height="10" align="center"
												><span class="bold">Per</span></th>
											<th class="width_20" height="10" align="center"
												><span class="bold">Amount (KSH)</span></th>
											<th class="width_20" height="10" align="center"
												><span class="bold">Amount (USD)</span></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="det" items="${detailObj}" varStatus="theCount">
												<tr class="description">
													<td class="width_8 "  align="left"
														valign="top" ><span>&nbsp;${det.slNo}</span></td>
													<td class="width_32 "   align="left"
														valign="top" ><span>&nbsp; <B>Transport Charge </B></span>
														<br/><span class="">&nbsp;&nbsp;${det.quantity} * ${det.contSize}' - ${det.contType} Container(s) <br/><br/></span></td>
													<td class="width_10"   align="right"
														valign="top" style="padding-right: 2px; "><span
														>&nbsp;${det.quantity}</span></td>
													<td class="width_10 "   align="right" style="padding-right: 2px; "
														valign="top" ><span
														>&nbsp;${det.quotAmount}</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;Container</span></td>
													<td class="width_15 "  align="right" style="padding-right: 2px; "
														valign="top" ><span
														>&nbsp;${det.amount}</span></td>
													<td class="width_15 "  align="right" style="padding-right: 2px; "
														valign="top" ><span
														>&nbsp;${det.amountUSD}</span></td>
												</tr>
												<tr class="description">
													<td class="width_8 "  align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_32 "   align="left"
														valign="top" style="padding-right: 2px; "><span
														>&nbsp; <B>VAT @ ${det.vatPerc}%</B></span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_15 "  align="right"
														valign="top" style="padding-right: 2px; " ><span
														>&nbsp;${det.vatAmount}</span></td>
													<td class="width_15 "  align="right"
														valign="top" style="padding-right: 2px; " ><span
														>&nbsp;${det.vatAmountUSD}</span></td>
												</tr>
											</c:forEach>
											
												<tr class="description" >
													<td class="width_8 "  align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_32 "   align="left"
														valign="top" style="padding-right: 2px; "></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_15 "  align="right"
														valign="top" style="padding-right: 2px; " ></td>
													<td class="width_15 "  align="right"
														valign="top" style="padding-right: 2px; " ></td>
												</tr>
												
												<tr class="description" >
													<td class="width_8 "  align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_32 "   align="left"
														valign="top" style="padding-right: 2px; "></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_15 "  align="right"
														valign="top" style="padding-right: 2px; " ></td>
													<td class="width_15 "  align="right"
														valign="top" style="padding-right: 2px; " ></td>
												</tr>
												<tr class="description" >
													<td class="width_8 "  align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_32 "   align="left"
														valign="top" style="padding-right: 2px; "></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>&nbsp;</span></td>
													<td class="width_15 "  align="right"
														valign="top" style="padding-right: 2px; " ></td>
													<td class="width_15 "  align="right"
														valign="top" style="padding-right: 2px; " ></td>
												</tr>
												
									
									</tbody>
									<tfoot>
										<tr>
											<td class="width_8" height="10" align="center"
												><span class=" bold"></span></td>
											<td class="width_32" height="10" align="center"
												style="border-right: 0pt; text-align: center;"><span class="bold">Total</span></td>
											<td class="width_10" height="10" align="center"
												style="border-right: 0pt;text-align: right;"><span class=" bold"></span></td>
											<td class="width_10" height="10" align="center"
												><span class=" bold"></span></td>
											<td class="width_10" height="10" align="center"
												><span class=" bold"></span></td>
											<td class="width_15 " height="10" align="center"
												style="padding-right: 2px; text-align: right;"><span class="bold">&nbsp;${hdr.totalBCamount}</span></td>
											<td class="width_15 " height="10" align="center"
												style="padding-right: 2px; text-align: right;"><span class="bold">&nbsp;${hdr.totalTCamount}</span></td>
										</tr>
									</tfoot>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
			<div style= "border: 2px solid #2F4F4F;">
			<table border="0" class="padding-top-10" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
			<tr>
				<td align="left" style="padding-left: 3px;"><span>Amount chargeable (in words)<br/>
				</span></td>
				<td align="right" style="padding-right: 5px;"><span>E. & O.E.<br/>
				</span></td>
			</tr>
			<tr>
				<!-- Fetch TC Amount and BC Amount in words -->
				<td align="left" colspan="2"><span><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${hdr.totalBCAmountInWords}</b><br>
				</span></td>
			</tr>
			<tr>
				<td align="left" colspan="2"><span><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${hdr.totalTCAmountInWords}</b><br>
				</span></td>
			</tr>
			<tr>
				<td align="left"  style="padding-left: 3px;"><span>Remarks : <br>
				</span></td>
			</tr>
			<tr>
				<td align="left" colspan="2"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${hdr.remarks}<br> <br>
				</span></td>
			</tr>
			<tr>
				<td>

					<table border="0" class="padding-top-10" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td  style="padding-left: 3px;">Device No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <span>&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>KRA/ESD/18072011/00448H</b><br/><br/></span></td>
							<!-- <td style="text-align: left;"><b>KRA/ESD/18072011/00448H</b><br></td> -->
						</tr>
						<tr>
							<td  style="padding-left: 3px;">Company's VAT No &nbsp;&nbsp;&nbsp;&nbsp;: <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>P051592894V</b><br/><br/></span></td>
							<!-- <td style="text-align: left;"><b>P051592894V</b><br></td> -->
						</tr>
						<tr>
							<td  style="padding-left: 3px;">Company's PIN &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<b>P051592894V</b><br/><br/></span></td>
							<!-- <td style="text-align: left;"><b>P051592894V</b><br><br></td> -->
						</tr>
					</table> 

				</td>
			</tr>
			<tr>
				<table border="0" class="padding-top-10" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td class="padding-top-10,padding-bottom-10,padding-left-5" width="50%"  style="font-size: 14px;"><b><u><span>Declaration</span></u></b> <br/>
							We declare that this invoice shows the actual price of the goods 
							described and that all particualrs are true and correct.</td>
							<td class="padding-top-10,padding-bottom-10, padding-right-5" width="50%" style="font-size: 14px; text-align: right;"><b><span>for Interafrica Haulage Services Ltd&nbsp;&nbsp;&nbsp;</span></b><br/><br/><br/>
							Authorised Signatory&nbsp;&nbsp;&nbsp;</span><br><br></td>
						</tr>
				</table>
			</tr>
		</table>
</div>
		<table id="footer" border=0 bordercolor="" cellspacing="0"
			cellpadding="2" align="center">
			<tr>
				<td colspan="10" align="center"><span class=footer-text> This is a Computer Generated Invoice.
				</span> </td>
			</tr>
		</table>
	</div>

</body>
</html>
