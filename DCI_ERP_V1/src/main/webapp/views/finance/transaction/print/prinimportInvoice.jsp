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
<body >

	<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="payerForIndia" value="${payerIndia}" />
		<c:set var="object1" value="${generalInvoiceList}" />
			<c:set var="billofladingobject" value="${setEditData}" />
	
	<div id="content" style="margin-bottom: 10px;">
				<table border="0" class="padding-top-2" class="class_border" width="100%"
						cellpadding="0" cellspacing="0"  style="padding-top: 20px; border: none;" align="center">
						<tr>
							<td width="100%" style="text-align: center;">
								<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="" align="center">
									<!-- <table border="0" width="100%" cellpadding="0" cellspacing="0"
					bgcolor="FFFFFF" bordercolor="#cccccc" align=center
					style="padding-top: 0px">
					<tr width=25%>
						<td><img src="/img/MBKHelpVideos/mbk_image.png"
							style="height: 55%;"></td>
						<td><br> <br> <br> <font face="arial" size="5"><b>
									</b></font></td>
					</tr>
				</table> -->
									 <tr>
										<td width="40%"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 0px 0 0 40px; height: 65px;"></td>                                   
										<td width="60%" style="word-wrap: break-word;padding-left: 2%;padding-right: 2%;">
											<span style="text-align: left;font-size: 17px;"><b>${object1.branchName}</b></span> <br> <br> 
										<p style="text-align: right">	<span style="text-align: left;font-size: 15px;">${object1.branchAddress1}</span> <br> 
											<span style="text-align: left;font-size: 14px;">
												<c:if test="${object1.branchGstno != null && object1.branchGstno != ''}">GSTNO : ${object1.branchGstno} <br></c:if> 
												<c:if test="${object1.stateNameNew != null && object1.stateNameNew != ''}">State Name : ${object1.stateNameNew} 
													<c:if test="${object1.stateCode != null && object1.stateCode != ''}">, Code : ${object1.stateCode}</c:if><br> 
												</c:if> 
												<c:if test="${object1.cin != null && object1.cin != ''}">CIN : ${object1.cin} <br></c:if> 
												<c:if test="${object1.mailId != null && object1.mailId != ''}">E-mail : ${object1.mailId}</c:if>
											</span></p>
										</td>
																			
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
					<table width="50%" style="float:left; padding-top:10px; padding-bottom:15px;"><tr>
										<td valign="top" class="tablespace padding-5p">
											<span class="">
												Customer:	 ${object1.mloName} ,<br>
													Address: ${object1.customerAddress} <br><br>	
													<%-- Address1: ${object1.customerAddress1} <br><br>	 --%>							
													Tel No.: ${object1.customerPhoneNo} | Fax No.: ${object1.customerFaxNo}<br>
													Email: ${object1.customerEmail}<br>
																
													<%-- <c:if test="${object1.checkVATDate =='Y'}"><br>
													VAT Reg. No. : 100516541800003 <br>
													</c:if> --%>
												<!-- companyName, company address, phoneno, fax -->
											</span>
										</td>
									</tr>	</table>
					<table width="50%" style="float:left; padding-top:10px; padding-bottom:15px;"><tr>
										<c:if test="${object1.invoicesub !='GSU'}">	
										<td valign="top" class="padding-left-5" align =left >
										
										<b>Customer   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp     : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${object1.customerName}</b><br>
											<b>Inv. No &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp      :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${object1.invoiceNo}<br>
											Inv. Date   &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${object1.invoiceDate}<br>	
											<c:if test="${object1.voyage !=''}">	
											Voyage &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp       : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${object1.voyage}<br>	
											</c:if>										 
											 
											
																							    
											<c:if test="${object1.vesselName !=''}">	
											 Vessel   &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp     :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${object1.vesselName}		<br>
											</c:if>	
										   	
										   		<c:if test="${object1.pol !=''}">	
											 Pol   &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp      : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${object1.pol}	
											</c:if>	
													<c:if test="${object1.pol ==''}">	
											 Pol    &nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp     : -	
											</c:if>	
											<br>
												<c:if test="${object1.pod !=''}">	
											 Pod    &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp     : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${object1.pod}	
											</c:if>	
											<c:if test="${object1.pod ==''}">	
											 Pod   &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp     v : -
											</c:if>	
												<br>
										   	  <c:if test="${object1.fpod != ''}">	
											 Fpod   &nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp      :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ${object1.fpod}	
											</c:if>
											<c:if test="${object1.fpod == ''}">	
											 Fpod   &nbsp &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp      : -
											</c:if>
											<br>
												<c:if test="${object1.sailingDate != null}">	
											 Sailing Date&nbsp&nbsp&nbsp   : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${object1.sailingDate}	
											</c:if>
											<c:if test="${object1.sailingDate == null}">	
											 Sailing Date &nbsp&nbsp&nbsp        : -
											</c:if>	
											<br>
										   	  <c:if test="${object1.bl != ''}">	
											 BL No     &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp    : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${object1.bl}	
											</c:if>
											<c:if test="${object1.bl == ''}">	
											  BL No   &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp      : -
											</c:if>	
											
															
											</b></span>
										</td>		
										
										</c:if>	
											<c:if test="${object1.invoicesub =='GSU'}">	
										<td valign="top" class="padding-left-5"><span class="">
										
										<b>Customer        :  ${object1.customerName}</b><br>
											<b>Inv. No        :  ${object1.invoiceNo}<br> 
											Inv. Date        : ${object1.invoiceDate}<br> 
											 <c:if test="${object1.bl != ''}">	
											 BL No        : ${object1.bl}	
											</c:if>
											<c:if test="${object1.bl == ''}">	
											  BL No        : -
											</c:if>	<br> 
													
											
										 
											EX Voyage        : ${object1.exvoyage}<br>	
											
											<c:if test="${object1.vesselName !=''}">	
											Loading Vessel        : ${object1.vesselName}		<br>
											</c:if>	
											<c:if test="${object1.voyage !=''}">	
											Loading  Voyage : ${object1.voyage}<br>	
											</c:if>
												<c:if test="${object1.sailingDate != null}">	
											 Sailing Date : ${object1.sailingDate}	
											</c:if>
											<c:if test="${object1.sailingDate == null}">	
											 Sailing Date : -
											</c:if>	
											<br>
										 
															
											</b></span>
										</td>		
										
										</c:if>			
									</tr>	
							</table>
					<table width=100% align="center" border="1" cellPadding="0" style="border-left: none;
    border-right: none;"
						cellSpacing="0" style="border-left:none;border-right:none;margin-left: 0px;">
						<%-- <tr>
							<td><center>
									<font size="2" face="arial">YOUR ACCOUNT HAS BEEN
										DEBITED TOWARDS THE FOLLOWING CHARGES.</font>
								</center></td>
						</tr> --%>
					</table> <br>
					<table class="" align="left" border="1"  bordercolor="" cellPadding="0" cellSpacing="0" width=100%>
									<thead>
										<tr class="">
											
												<c:if test="${object1.checkVATDate =='Y'}">
												<th class="width_50" height="10" align="center" style="border-right: 0pt;"><span class="">Description of Charges</span></th>
												<th class="width_10" height="10" align="center" style="border-right: 0pt;"><span class="">	VAT ( % )</span></th>
												
													   <th class="width_10" height="10" align="center" style="border-right: 0pt;"><span class="">	VAT AMT ((${object1.currencyName})</span></th>
												   <th class="width_10" height="10" align="center" style="border-right: 0pt;"><span class="">	VAT AMT(${object1.companyCurrency})</span></th>
												   	<th class="width_10" height="10" align="center" style="border-right: 0pt;"><span class="">TC Amount (${object1.currencyName})</span></th>
											<th class="width_10" height="10" align="center" style="border-right: 0pt;"><span class="">BC Amount (${object1.companyCurrency})</span></th>
									
													</c:if>					
											
										<c:if test="${object1.checkVATDate =='N'}">
										<th class="width_60" height="10" align="center" style="border-right: 0pt;"><span class="">Description of Charges</span></th>
										<th class="width_20" height="10" align="center" style="border-right: 0pt;"><span class="">TC Amount (${object1.currencyName})</span></th>
											<th class="width_20" height="10" align="center" style="border-right: 0pt;"><span class="">BC Amount (${object1.companyCurrency})</span></th>
										</c:if>
													
											
										</tr>
									</thead>
									<tbody>
										<%-- <tr  border="0">
											<td colspan="4" class="width_60" align="left" valign="top" class="tablespace">
													<span class=""> ${object1.subject}</span>
											</td>												
										</tr>	 --%>
										
										<c:forEach var="ob" items="${generalInvoiceList.giDtl}"  varStatus="theCount"> 
											<tr class="description">
											<c:if test="${object1.checkVATDate =='Y'}">
												<td class="subcolor width_50" height="10" align="left" valign="top" style="border-right: 0pt;">
													
													<span class=""> 
													<c:if test="${theCount.count == 1}">
																<b>Subject:<c:out value="${object1.subject}" /></b>
															</c:if><br>
													<font class="" face="arial" size="2">${ob.accountHeadName}</font>
															
													<br><font class="" face="arial" size="2">${ob.narration}</font>
													</span><br>
													
<%-- 													<font class="" face="arial" size="2">${ob.accountHeadName}</font> --%>
														
<%-- 													<br><font class="" face="arial" size="2">${ob.narration}</font> --%>
<!-- 													</span><br> -->
																<c:choose>
													    <c:when test="${empty ob.vesselCode}">
															<font class="" face="arial" size="2"></font>												        
													    </c:when>
													    <c:otherwise>
													        <font class="" face="arial" size="2"> <b>Vessel:</b> ${ob.vesselName} </font>
													    </c:otherwise>
													</c:choose>	
<%-- 													</c:if> --%>


<%-- 													<c:if test="${object1.voyage ==''}">														 --%>
													<c:choose>
													    <c:when test="${empty ob.voyageCode}">
															<font class="" face="arial" size="2"></font>												        
													    </c:when>
													    <c:otherwise>
													        <font class="" face="arial" size="2"> <b>Voyage:</b> ${ob.voyageCode} </font><br>
													    </c:otherwise>
													</c:choose>	
<%-- 													</c:if> --%>
													
											 	
											 	<td class="subcolor width_10" height="10" align="left" valign="top" style="border-right: 0pt;">
													 
													<span class=""> 
													<font class="" face="arial" size="2">${ob.vattype}</font>
														 
													</span> 
													</td>
											 	 
											 		<td class="subcolor width_10" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;">
												<span class=""> 
												${ob.vattcamount} 
												</span></td>
												<td class="subcolor width_10" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;"><span class=""> 
												${ob.vatbcamount} 
												</span></td>
										
												<td class="subcolor width_10" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;">
												<span class=""> 
												${ob.tcAmount} 
												</span></td>
												<td class="subcolor width_10" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;"><span class=""> 
												${ob.bcAmount} 
												</span></td>
												</c:if>
												
												<c:if test="${object1.checkVATDate =='N'}">
												<td class="subcolor width_60" height="10" align="left" valign="top" style="border-right: 0pt;">
												 
													<span class=""> 
													<font class="" face="arial" size="2">${ob.accountHeadName}</font>
															<c:if test="${theCount.count == 1}">
																<b><c:out value="${object1.subject}" /></b>
															</c:if>
													<br><font class="" face="arial" size="2">${ob.narration}</font>
													</span><br>
													
<%-- 													<c:if test="${object1.vesselName ==''}"> --%>
													<c:choose>
													    <c:when test="${empty ob.vesselCode}">
															<font class="" face="arial" size="2"></font>												        
													    </c:when>
													    <c:otherwise>
													        <font class="" face="arial" size="2"> <b>Vessel:</b> ${ob.vesselName} </font>
													    </c:otherwise>
													</c:choose>	
<%-- 													</c:if> --%>
													
<%-- 													<c:if test="${object1.voyage ==''}">														 --%>
													<c:choose>
													    <c:when test="${empty ob.voyageCode}">
															<font class="" face="arial" size="2"></font>												        
													    </c:when>
													    <c:otherwise>
													        <font class="" face="arial" size="2"> <b>Voyage:</b> ${ob.voyageCode} </font><br>
													    </c:otherwise>
													</c:choose>	
<%-- 													</c:if> --%>
													
													<c:if test="${object1.exvoyage ==''}">														
													<c:choose>
													    <c:when test="${empty object1.exvoyage}">
															<font class="" face="arial" size="2"></font>												        
													    </c:when>
													    <c:otherwise>
													        <font class="" face="arial" size="2"> <b>Ex Voyage:</b> ${object1.exvoyage} </font><br>
													    </c:otherwise>
													</c:choose>	
													
											 	 
												
											 	</c:if>
												
 </td>
					
												<td class="subcolor width_20" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;">
												<span class=""> 
												${ob.tcAmount} 
												</span></td>
												<td class="subcolor width_20" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;"><span class=""> 
												${ob.bcAmount} 
												</span></td>
												</c:if>
											</tr>	
											<tr class="description blank_row">
									            <td bgcolor="#FFFFFF" colspan="" height="10"  style="border-right: 0pt;">&nbsp;</td>
									            <c:if test="${object1.checkVATDate =='Y'}">
									             <td bgcolor="#FFFFFF" colspan="" height="10"  style="border-right: 0pt;">&nbsp;</td>
									               <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td>
									            <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td>
									            </c:if>
									            <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td>
									            <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td>
									    	</tr>									
										</c:forEach>									
											<tr class="description">
											 <c:if test="${object1.checkVATDate =='Y'}">
												<td class="width_50 normal" height="50" align="left" valign="top" style="border-right: 0pt;"><span class="">&nbsp;</span> </td>
												
												  
												   	 <td class="width_10 normal" height="50" align="left" valign="top" style="border-right: 0pt;"><span class="">&nbsp;</span> </td>
												   
												   <td class="width_10 normal" height="50" align="left" valign="top" style="border-right: 0pt;"><span class="">&nbsp;</span> </td>
												<td class="width_10 normal" height="50" align="left" valign="top" style="border-right: 0pt;"><span class="">&nbsp;</span> </td>	
											
									          
									            <td class="width_10 normal" height="50" align="left" valign="top" style="border-right: 0pt;"><span class="">&nbsp;</span> </td>
												<td class="width_10 normal" height="50" align="left" valign="top" style="border-right: 0pt;"><span class="">&nbsp;</span> </td>	
											  </c:if>
											  <c:if test="${object1.checkVATDate =='N'}">
												<td class="width_60 normal" height="50" align="left" valign="top" style="border-right: 0pt;"><span class="">&nbsp;</span> </td>
												 
									            <td class="width_20 normal" height="50" align="left" valign="top" style="border-right: 0pt;"><span class="">&nbsp;</span> </td>
												<td class="width_20 normal" height="50" align="left" valign="top" style="border-right: 0pt;"><span class="">&nbsp;</span> </td>	
											  </c:if>
												</tr>

										<c:if
											test="${object1.invoiceNo.contains('SIGI')}">
<%-- 											<c:if test="${'Y' != object1.sector}"> --%>
												<tr height=10>
													<td class="width_60" align=left class="width_70" valign=top><span
														class=normal><b>Zero Rated GST@ 0%%</b></span></td>

													<td class="width_20" class="width_15" align=right
														valign=top
														style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
														class=normal><b> 0 <%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
												 ${totalBC} --%>
														</b></span></td>
													<td class="width_60" align=right valign=top><span
														class=normal><b> 0 <%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
												 ${totalTC} --%>
														</b></span></td>
												</tr>

										</c:if>
										
										 <c:if test="${object1.checkVATDate =='Y'}">
										 <tr>
												<td class="width_50" align="left" valign="top">
													<span class=""><b>Exchange Rate: ${object1.exchangeRate}</b></span>
													<span class="" style="float:right; padding-right:10px;"><b>Total</b></span>												
												</td>
												
												 <td class="width_10" align="left" valign="top">													 												
												</td>
												<td class="width_10" align="right">
													<span class=""><b><!-- total TC Amount -->
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totvattcamount}" />
													</b></span>
												</td>
												<td class="width_10" align="right">
													<span class=""> <b> <!-- total BC Amount (USD) -->  
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totvatbcamount}" />
													</b></span></td>
												
												<td class="width_10" align="right">
													<span class=""><b><!-- total TC Amount -->
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totalTCamount}" />
													</b></span>
												</td>
												<td class="width_10" align="right">
													<span class=""> <b> <!-- total BC Amount (USD) -->  
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totalBCamount}" />
													</b></span></td>
													</tr>
													
													<tr>
												<td class="width_50" align="left" valign="top">
													<span class=""><b>  Total VAT</b></span>
												 											
												</td>
												
												 <td class="width_10" align="left" valign="top">													 												
												</td>
												<td class="width_10" align="right">
													<span class=""><b><!-- total TC Amount -->
												 </b></span>
												</td>
												<td class="width_10" align="right">
													<span class=""> <b> <!-- total BC Amount (USD) -->  
													 </b></span></td>
												
												<td class="width_10" align="right">
													<span class=""><b><!-- total TC Amount -->
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totvattcamount}" />
													</b></span>
												</td>
												<td class="width_10" align="right">
													<span class=""> <b> <!-- total BC Amount (USD) -->  
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totvatbcamount}" />
													</b></span></td>
													</tr>
													<tr>
												<td class="width_50" align="left" valign="top">
													<span class=""><b>  Total Amount</b></span>
												 											
												</td>
												
												 <td class="width_10" align="left" valign="top">													 												
												</td>
												<td class="width_10" align="right">
													<span class=""><b><!-- total TC Amount -->
												 </b></span>
												</td>
												<td class="width_10" align="right">
													<span class=""> <b> <!-- total BC Amount (USD) -->  
													 </b></span></td>
												
												<td class="width_10" align="right">
													<span class=""><b><!-- total TC Amount -->
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totalTCamount+object1.totvattcamount}" />
													</b></span>
												</td>
												<td class="width_10" align="right">
													<span class=""> <b> <!-- total BC Amount (USD) -->  
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totalBCamount+object1.totvatbcamount}" />
													</b></span></td>
													</tr>
													 </c:if>
													 
													  <c:if test="${object1.checkVATDate =='N'}">
													  <tr>
												<td class="width_60" align="left" valign="top">
													<span class=""><b>Exchange Rate: ${object1.exchangeRate}</b></span>
													<span class="" style="float:right; padding-right:10px;"><b>Total</b></span>												
												</td>
											 
												<td class="width_20" align="right">
													<span class=""><b><!-- total TC Amount -->
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totalTCamount}" />
													</b></span>
												</td>
												<td class="width_20" align="right">
													<span class=""> <b> <!-- total BC Amount (USD) -->  
													<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.totalBCamount}" />
													</b></span></td>
													</tr>
													 </c:if>
											
									</tbody>		
								</table>	</td>
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
		<br>
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
