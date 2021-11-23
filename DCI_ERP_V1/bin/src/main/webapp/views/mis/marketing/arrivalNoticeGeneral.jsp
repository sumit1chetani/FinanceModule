
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Ubuntu" />

<html>
<head>

<style>
body {
	background-color: #FFFFFF;
	color: #333366;
	/* 	font-family: 'Times New Roman'; */
	font-family: Ubuntu !important;
	font-size: 10px;
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

.padding-top-30 {
	padding-top: 30px;
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
	position: fixed;
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

.blprint {
	vertical-align: top;
	font-family: verdana;
	font-size: 11px;
	font-weight: bold;
}

.bold {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
	font-weight: bold;
	color: #000000;
	text-decoration: none;
	padding-left: 6px;
}

.company-for-seal {
	font-size: 14px;
	font-weight: bold;
	padding-top: 25px;
	text-align: center;
}

.normal {
	/* 	font-family: Arial, Helvetica, sans-serif;
 */
	font-family: Ubuntu;
	font-size: 11px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	text-decoration: none
}

.description, .description td {
	border-bottom: 1pt solid #fff;
	border-top: 1pt solid #fff;
}

.description1, .description1 td {
	border-bottom: 0px solid #fff;
}

@page {
	size: A4 portrait; /* auto is the initial value */
	margin: 2mm; /* this affects the margin in the printer settings */
}
</style>
<link rel="stylesheet" href="../../css/jquery.signaturepad.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
</head>

<body>
<!-- 	<div>
		<img src="/img/cordelia.png"
			style="float: left !important; padding: 0px 0px 0px 15px !important; float: left !important; height: 60px; width: 270px;"><img
			src="/img/csl.png"
			style="float: right !important; padding: 0px 15px 0px 0px !important;">
	</div> -->

	<c:set var="hdr" value="${arrival}" />
	<div id="content" style="margin-bottom: 10px;">
		<table align="right" class="padding-30p" border="0" cellpadding="0"
			width="100%" cellspacing="0">
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
							<td>
								<img class="width_50" src="/img/MBKHelpVideos/mbk_image.png"/>
									<!-- <img src="/GFS/img/gfs_logo.jpg" alt="simatech-logo" /> -->
								</td>	
								
								<!--  <td   class="no_border"><img src="/img/csl.png" style="float: right !important;padding: 10 0 0 10; height: 40px;"> --></td>

                   

						</tr>
					
					</table>
					</td>
						 <td colspan=4 align="right">
								<font face="arial" size="4"><b>MBK LOGISTIX PVT LTD</b>
								</font><br>		
								<font face="arial" size="2"> </font></td>
					
						</tr>
						
					
					<center>

						<tr>
							<td width=10% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;"></td>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-bottom: .4em; font-size: 20px; font-family: Ubuntu;">&nbsp;<b>CARGO
									ARRIVAL NOTICE</b>
							</td>
						</tr>
					</center> <!-- <font size="5" face="arial" width=20%><b>CARGO ARRIVAL NOTICE</b></font> -->
					<table width=100% align="center" style="border: 1px solid #42a5f5;"
						border-color: green; cellPadding="0" cellSpacing="0"
						style="border-color: #42a5f5;">

						<tr>
							<td class="normal" height="100" rowspan="3"
								style="border-right: 1px solid #42a5f5; vertical-align: baseline; padding-top: 5px;">
								<p style="padding-left: 5px;">Shipper: ${hdr.shipper}</p>
							</td>
							<td class="normal" height="100" rowspan="3"
								style="border-right: 1px solid #42a5f5; vertical-align: baseline; padding-top: 5px;"><p
									style="padding-left: 5px;">Consignee: ${hdr.cnee}</td>
							<td class="normal" style="border-bottom: 1px solid #42a5f5;">Date
								of Issue: ${hdr.issueDate}</td>
						</tr>
						<tr>
							<td class="normal" style="border-bottom: 1px solid #42a5f5;">BL
								No: ${hdr.blno}</td>

						</tr>
						<tr>
							<td class="normal">Type of BL: ${hdr.bltype}</td>

						</tr>

					</table>
					<table width=100% align="center" style="border: 1px solid #42a5f5;"
						cellPadding="0" cellSpacing="0" style="border-color: #42a5f5;">


						<tr>
							<td class="normal" height="100" rowspan="3"
								style="border-right: 1px solid #42a5f5; vertical-align: baseline; padding-top: 5px;width: 34%;">Notify
								Party: ${hdr.notify1}</td>
							<td class="normal" height="100" rowspan="3"
								style="border-right: 1px solid #42a5f5; vertical-align: baseline; padding-top: 5px;width: 37%;">Also
								Notify Party: ${hdr.notify2}</td>
							<td class="normal" height="50"
								style="border-bottom: 1px solid #42a5f5;    width: 21%;">ETA at:
								${hdr.etaPort} On <b>${hdr.eta}</b>
							</td>
							
						</tr>
						<tr>
							<td class="normal" height="50"
								style="vertical-align: baseline; padding-top: 5px;">Place
								of Final Delivery: ${hdr.disFpod}</td>

						</tr>

					</table>



					<table width=100% align="center" style="border: 1px solid #42a5f5;"
						cellPadding="0" cellSpacing="0" style="border-color: #42a5f5;">


						<tr>
							<td class="normal" height="50"
								style="border-right: 1px solid #42a5f5; vertical-align: baseline; padding-top: 5px;">Port
								of Loading: ${hdr.disPol}</td>
							<td class="normal" height="50"
								style="border-right: 1px solid #42a5f5; vertical-align: baseline; padding-top: 5px;">Place
								of Receipt: ${hdr.disPor}</td>
							<td class="normal" height="50"
								style="border-right: 1px solid #42a5f5; vertical-align: baseline; padding-top: 5px;">Vessel
								& Voyage No.: ${hdr.vslVoyage}</td>
							<td class="normal" height="50"
								style="border-right: 1px solid #42a5f5; vertical-align: baseline; padding-top: 5px;">Port
								of Discharge: ${hdr.disFpod}</td>
						</tr>
					</table>



					<table width=100% align="center" border="1" cellPadding="0"
						cellSpacing="0" style="border-color: #42a5f5;">

						<tr>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">Marks &
								No.Container & Seal No.s</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">No. of
								packages/Containers</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">Description of
								Goods & Packages</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">Gross Weight (MT)/
								Measurement (CBM)</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">Type of Cargo
								Reefer/HAZ</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">Mode FCL/LCL</td>
						</tr>
						<!-- <tr>
    <td class="normal" height="100"></td>
    <td class="normal" height="100"></td>
    <td class="normal" height="100"></td>
    <td class="normal" height="100"></td> 
    <td class="normal" height="100"></td>
    <td class="normal" height="100"></td>
  </tr>	 -->

						<c:set var="index" value="0"></c:set>
						<c:forEach var="dtl" items="${conList}" varStatus="theCount">
							<tr style="    vertical-align: baseline;">

								<td class="tablespace" height="30"
									style="border-right: 1px solid #42a5f5;"><span
									class=normal>${dtl.marks} ${dtl.sealno}</span></td>
								<td class="tablespace" height="30"
									style="border-right: 1px solid #42a5f5;"><span
									class=normal>${dtl.pkgs} ${dtl.containerType} </span></td>
								<td class="tablespace" height="30"
									style="border-right: 1px solid #42a5f5;"><span
									class=normal>${dtl.goods}</span></td>
								<td class="tablespace" height="30"
									style="border-right: 1px solid #42a5f5;"><span
									class=normal>${dtl.g_wgt} ${dtl.cbm}</span></td>

								<td class="tablespace" height="30"
									style="border-right: 1px solid #42a5f5;"><span
									class=normal>${dtl.commodity}</span></td>

								<td class="tablespace" height="30"
									style="border-right: 1px solid #42a5f5;"><span
									class=normal>${dtl.commodity}</span></td>
							</tr>
						</c:forEach>
					</table>


				 <table width=100% align="center" style="border: 1px solid #42a5f5;"
						cellPadding="0" cellSpacing="0" style="border-color: #42a5f5;">

						<tr>
							<td class="normal" height="30">Remarks</td>

						</tr>

					</table> 
					
					<br><br><br><br><br><br>

				<%-- 	 <table width=100% align="center" border="1" cellPadding="0"
						cellSpacing="0" style="border-color: #42a5f5;">

						<tr>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;">Contact Office:</td>

							<!-- 	<td class="gridheadercell">&nbsp;&nbsp;5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">Freight & Charges</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">P/C</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">Amount</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">Exchange Rate</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: center;">Amount (${hdr.currency})</td>

						</tr>
						<!-- <tr>
    <td class="normal" height="100"></td>
    <td class="normal" height="100"></td>
    <td class="normal" height="100"></td>
    <td class="normal" height="100"></td> 
    <td class="normal" height="100"></td>
    <td class="normal" height="100"></td>
  </tr>	 -->

						<c:set var="index" value="0"></c:set>

						<tr  style="    vertical-align: baseline;    width: 20%;">
							<td class="tablespace" height="50"
								style="border-right: 1px solid #42a5f5;    width: 27% !important;
    word-break: break-all;"><span
								class=normal>${hdr.address}</span></td>
								
							<td class="tablespace" height="30"
								style="border-right: 1px solid #42a5f5;     width: 33%;"><c:forEach
									var="chargesList" items="${hdr.chargesList}"
									varStatus="theCount">
									<span class=normal>${chargesList.chargeName} </span>
									<br>
										<c:set var="podfreeday"
											value="${chargesList.podFdays}" />
								</c:forEach></td>
								
							<td class="tablespace" height="30"
								style="border-right: 1px solid #42a5f5;     width: 20%;"><c:forEach
									var="chargesList" items="${hdr.chargesList}"
									varStatus="theCount">
									 <c:if test="${chargesList.uom != 'PER CTR'}">
									<span class=normal>1 x ${chargesList.rate} ${chargesList.uom}</span><br>
									</c:if> 
									<c:if test="${chargesList.uom == 'PER CTR'}">
									<span class=normal>${chargesList.containerType}/${chargesList.quantity} x ${chargesList.rate} ${chargesList.uom}</span><br>
									</c:if>
									
								
								</c:forEach></td>
								<c:out value="${empty detailObj1.nwgt ? '' :  string3}" />
							<td class="tablespace" height="30"
								style="border-right: 1px solid #42a5f5;     width: 7%; text-align: right;"><c:forEach
									var="chargesList" items="${hdr.chargesList}"
									varStatus="theCount">
									
										<c:set var="amt" value="${chargesList.rate * chargesList.quantity}" />
									
										<span class=normal>${chargesList.rate * chargesList.quantity}</span>
									
									
									
									<br>
								</c:forEach></td>
								<td class="tablespace" height="30"
								style="border-right: 1px solid #42a5f5;     width: 7%; text-align: right;"><c:forEach
									var="chargesList" items="${hdr.chargesList}"
									varStatus="theCount">
									<c:if test="${chargesList.uom == 'PER CTR'}">
									<c:set var="amt" value="${chargesList.rate * chargesList.quantity}" />
									</c:if>
									<c:if test="${chargesList.uom != 'PER CTR'}">
									<c:set var="amt" value="${chargesList.rate * 1}" />
									</c:if>
									<span class=normal>
									<fmt:formatNumber type="number" groupingUsed="true"
											maxFractionDigits="0"
											value="${fn:substringBefore(amt, '.')}" />
									</span><br>
									
								</c:forEach></td>

							<td class="tablespace" height="30"
								style="border-right: 1px solid #42a5f5;     width: 5%; text-align: right;"><c:forEach
									var="chargesList" items="${hdr.chargesList}"
									varStatus="theCount">
									
									<span class=normal>${chargesList.exchangeRate}</span><br>
									
								</c:forEach></td>

							<td class="tablespace" height="30"
								style="border-right: 1px solid #42a5f5;     width: 9%; text-align: right;"><c:forEach
									var="chargesList" items="${hdr.chargesList}"
									varStatus="theCount">
									<c:if test="${chargesList.exchangeRate > 0}">
										<c:if test="${chargesList.uom == 'PER CTR'}">
										<c:set var="exAmount" value="${chargesList.rate * chargesList.exchangeRate * chargesList.quantity}" />
										</c:if>
										<c:if test="${chargesList.uom != 'PER CTR'}">
										<c:set var="exAmount" value="${chargesList.rate * chargesList.exchangeRate * 1}" />
										</c:if>
										<span class=normal><fmt:formatNumber type="number" groupingUsed="true"
											maxFractionDigits="0"
											value="${exAmount}" /></span><br>
										<c:set var="subTotal"
											value="${subTotal + exAmount}" />
									</c:if>
									<c:if
										test="${chargesList.exchangeRate == 0 || chargesList.exchangeRate == null}">
										<c:if test="${chargesList.uom == 'PER CTR'}">
										<c:set var="exAmount" value="${chargesList.rate  * chargesList.quantity}" />
										</c:if>
										<c:if test="${chargesList.uom != 'PER CTR'}">
										<c:set var="exAmount" value="${chargesList.rate  * 1}" />
										</c:if>
										<span class=normal><fmt:formatNumber type="number" groupingUsed="true"
											maxFractionDigits="0"
											value="${fn:substringBefore(exAmount, '.')}" /></span><br>
										<c:set var="subTotal" value="${subTotal + exAmount}" />
									</c:if>
									
								</c:forEach></td>




						</tr>

	<tr>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;"></td>

							<!-- 	<td class="gridheadercell">&nbsp;&nbsp;5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;"></td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;"></td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;"></td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;">Total</td>
							<td class="normal" height="40"
								style="border-right: 1px solid #42a5f5;text-align: right;" > <fmt:formatNumber type="number" groupingUsed="true"
											maxFractionDigits="0"
											value="${subTotal}" /></td>

						</tr>
					</table>  --%> 
					
					
					<%-- <table width=100% align="center" style= "border: 1px solid #42a5f5;" cellPadding="0" cellSpacing="0">

						 	<tr>
								<td class="normal"  height="40" style= "border-right: 1px solid #42a5f5;">Contact Office: </td>
								
							<!-- 	<td class="gridheadercell">&nbsp;&nbsp;5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
								<td class="normal" height="40" style= "border-right: 1px solid #42a5f5;">Freight & Charges</td>
								<td class="normal" height="40" style= "border-right: 1px solid #42a5f5;">P/C</td>
								<c:if test="${hdr.pol=='RFR' || object1.pol=='RF40'}">
							   <td class="normal" height="40" style= "border-right: 1px solid #42a5f5;">Amount</td>
								<td class="normal" height="40" style= "border-right: 1px solid #42a5f5;">Exchange Rate</td>
							    <td class="normal" height="40" style= "border-right: 1px solid #42a5f5;">Amount & Currency</td>
																																																																																																<!--  -->					
								
							</tr>
						  <c:set var="index" value="0"></c:set>  
						  <c:forEach var="slotmessageList" items="${arrival.detailList}" varStatus="theCount">
							  <tr>
								
								<td class="tablespace" height="50" style= "border-right: 1px solid #42a5f5;"><span class=normal></span></td>
								<td class="tablespace" height="30" style= "border-right: 1px solid #42a5f5;"><span class=normal>${slotmessageList.numpacks} /${slotmessageList.containerNumber}</span></td>
								<td class="tablespace" height="30" style= "border-right: 1px solid #42a5f5;"><span class=normal>${slotmessageList.grossweight}</span></td>
								<td class="tablespace" height="30" style= "border-right: 1px solid #42a5f5;"><span class=normal>${slotmessageList.grossweight}</span></td>
								
								<td class="tablespace" height="30" style= "border-right: 1px solid #42a5f5;"><span class=normal>${slotmessageList.commodity}</span></td>
								
								<td class="tablespace" height="30" style= "border-right: 1px solid #42a5f5;"><span class=normal>${slotmessageList.commodity}</span></td>
							
							</tr>
						  </c:forEach>
						 </table> --%>

					 <!-- 
  			<table width=100% align="center" border="1" cellPadding="0" cellSpacing="0">
  
  
  
  <tr>
 <td></td>
  <td>P/C</td>
  <td>Freight & Charges</td>
  <td>Freight & Charges</td>
  <td>Bob</td>
  <td>Alice</td>
 </tr>
 <tr>
  <th rowspan="2" >Favorite</th>
  <th></th>
  <td></td>
  <td></td>
    <td></td>
  <td></td>
 </tr>
 <tr>
  <th></th>
  <td></td>
  <td></td>
    <td></td>
  <td></td>
 </tr>
 </table> -->




					<table border="0" width="100%" cellpadding="0" cellspacing="0"
						bgcolor="FFFFFF" bordercolor="" align="center">


						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
							</td>
						</tr>
						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">1)
								THIS SERVES AS A NOTICE to inform you of the arrival of your consignment. It cannot be regarded as Delivery Order and presented for Cargo Release / Delivery.
						</tr>
						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">2)
								The vessel's ETA date is only an estimation (i.e. expected to arrive). This notice is solely FOR INFORMATION only. Failure to give such notification shall not involve Carrier's Liability nor relieve Merchant of any obligation for taking delivery of the Cargo.</td>

						</tr>

						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">3)
								Please login to our website to access the following services:
<br>a. Container Tracking<br>b. Vessel ETA 
							</td>

						</tr>

						<tr>
						
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">4)
								Demurrage and Detention Charges starts accruing from the date the container(s) is (are) discharged until the container(s) are returned empty to our assigned depot / area based on "CALENDAR DAYS" which include Public Holidays / Weekly Holidays, less the approved free days provided.
<br>a) Demurrage and Detention Charges Excludes the Port Storage which will be billed separately or the Consignee will be required to pay directly to Port / Terminal as per the local standard procedure.
<br>b) All Demurrage / Detention Charges (Present and Outstanding Charges) as per the Statement of Accounts (SOA) should be settled by the Consignee before the release of current shipment.
					</td>	</tr>
						<!-- 
						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
								5) For Cash Customers, Late Charges for delayed Delivery Order Pick-up of US$ [amount] per Delivery Order is applicable effective from [date]</td>

						</tr> -->

						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
								5) All Charges should be settled by the Consignee before the release of the Delivery Order
							</td>

						</tr>

						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">6)
								The Consignee, whether acting by himself or through a clearing agent on his behalf, is solely and fully responsible for the return of the Empty Container(s) in a clean, sound, cargo worthy condition, failing which, the Consignee will be liable for the costs and consequences.</td>

						</tr>

						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
								7) In case the payment is not made by the Consignee on demand, we have the right to take legal action to recover the same. Kindly note that as the Consignee, you are liable for the costs and consequences, irrespective of whether it is you or your agent/forwarder who has caused the loss/damage.</td>

						</tr>


						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
								8) In case the container(s) is (are) returned in a damaged or dirty condition, all repair/restitution or cleaning expenses as applicable will be to your account. Kindly note that if the Containers not cleared within days, they will be moved for auctioning as per local Customs & Port Authorities' regulations, and we as the Line shall have right to claim all charges in this connection from the Consignee for the unclaimed cargo consignment. We shall be, in no way, responsible if the Authorities decide to sequester/auction your containers and you shall continue to be liable for the detention/demurrage charges arising from non-clearance/release of our equipment.</td>

						</tr>


						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
								9) In case you require any further information, please do not hesitate to contact us.</td>

						</tr>


						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
								10) All the payments should be made in Cash or Bank transfer. Cheque payments are not acceptable.</td>

						</tr>


						<!-- <tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
								11) In case you require any further information, please do not
								hesitate to contact us</td>

						</tr>

						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
								12) All the payments should be made in Cash or Bank transfer.
								Cheque payments are not acceptable.</td>

						</tr>


						<tr>
							<td width=20% class="no_border"
								style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">
								Thank you for your continued patronage and we assure you of our
								best attention at all times.</td>

						</tr> -->
					</table>
		</table>
	</div>
	<div id="footer">
		<table border="0" width="100%" cellpadding="0" cellspacing="0"
			bgcolor="FFFFFF" bordercolor="" align="center">



			<tr>
				<td width=20% class="no_border"
					style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">For
					& on behalf of
			</tr>



			<tr>
				<td width=20% class="no_border"
					style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px;">MBK</td>

			</tr>


		</table>

		<table border=0 bordercolor="" cellspacing="0" cellpadding="2"
			align="center" valign="bottom">
			<tr>
				<td class="padding-top-10" colspan="10" align="center"><span
					class=footer-text> </span></td>
			</tr>
			<tr>

				<td colspan="10" class="no_border"><span class=footer-text><b>Digitally
							signed by MBK on ${hdr.curDate}</b></span></td>
			</tr>
		</table>
	</div>

</body>
</html>
