<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">


<title>General Invoice</title>
<style>
body {
    background-color: #FFFFFF;
    color: #333366;
    font-family: 'Times New Roman';
}
.form-horizontal{
  margin-right: -15px;
  margin-left: -15px;
}
.padding-20p{
    padding: 20px;
}
.padding-top-10{
	padding-top: 10px;
}
.padding-top-30{
	padding-top: 30px;
}
.padding-left-5{
	padding-left: 5px;
}
.padding-5p{
	padding: 5px;
}
.line-height-23p{
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
.footer{
   
    width: 100%;
    position: relative;
    bottom: 0px;
}
.footer-text{
    font-family: Arial, Helvetica, sans-serif;
    font-size: 8pt;
    font-style: normal;
    font-weight: normal;
    color: #000000;
    text-decoration: none;
}
.header-bg{
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
.bold{
font-weight:bold;}

.company-for-seal{
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
      html, body { margin: 0; padding: 0; }
      /* body { height: 11in;  width: 8.5in; } */
        a[href]:after {
	    	content: " (" attr(href) ")";
	 	}
	   /* #footer { position: absolute; bottom: 0; width:100%; margin:0 auto;} */ 
	   @page:last {
  		  @bottom-center {
        content: element(footer, last);
   		 }
    	#content{
     		display: table;
    	}
    	#footer { display: table-footer-group;
    	width:100%;        
    	position:absolute;
    	bottom:0; }
    	#pageFooter:after {
		    counter-increment: page;
		    content: counter(page);
		} 
		}
		@page {
		   @bottom-right {
		    content: counter(page) " of " counter(pages);
		   }
		}
</style> 
</head>
	<body>
		
		<c:set var="object1" value="${invoiceList}" />
		<%-- <c:set var="object2" value="${vesselVoyageWithInvoiceNo}" /> --%>
		<div id="content">
			<table class="width_100" height="95%" align="center" border="0" cellPadding="0" cellSpacing="0">
				<tr>
					<td>				
					<table border="0" class="padding-top-10" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">		
						<tr>
							<td><c:if test="${object1.location == 'DUBAI'}">
							<img src="/shipping/img/sfpl_logo_202x48.jpg"></c:if>
							<c:if test="${object1.location == 'SINGAPORE'}">
							<img src="/shipping/img/sfpl_logo_232x55.jpg"></c:if> 	
							<c:if test="${object1.location == 'AMERICA'}">
							<img src="/shipping/img/America_logo.jpg"></c:if> 	
							<c:if test="${object1.location == 'INDIA'}">
							<img src="/shipping/img/sfpl_logo_226x50.jpg"></c:if> 	
							</td>
						</tr>
					</table>				
					<font size="4" class="padding-top-10" face="arial"><b>INVOICE</b></font>
					<p>
					<table width=100% align="center" border="0" cellPadding="0" cellSpacing="0">
						<tr>
							<td width=24% height=100%>
								<table width=100% align="left" border="1" height=100%  bordercolor="" cellPadding="0" cellSpacing="0">
									<tr>
										<td valign="top" class="tablespace padding-5p">
											<span class="normal bold">
													 ${object1.customerName} ,<br>
													${object1.customerAddress} <br><br>									
													Tel No.: ${object1.customerPhoneNo} | Fax No.: ${object1.customerFaxNo}<br>
													Email: ${object1.customerEmail}
												<!-- companyName, company address, phoneno, fax -->
											</span>
										</td>
									</tr>
								</table>
							</td>
							<td width=2% height=100%>
							</td>
							<td width=24% height=100%>
								<table width=100% align="left" border="1" height=100%  bordercolor="" cellPadding="0" cellSpacing="0">
									<tr>
										<td valign="top" class="padding-left-5"><span class="normal">
											<b>Inv. No :  ${object1.invoiceNo}<br>
											Inv. Date : ${object1.invoiceDate}<br>	
											<c:if test="${object1.voyage !=''}">	
											Voyage : ${object1.voyage}
											</c:if>	
											<c:if test="${object1.voyage ==''}">	
											<br>
											</c:if>		
											<br>													    
											<c:if test="${object1.vesselName !=''}">	
											 Vessel : ${object1.vesselName}	
											</c:if>	
										   		<br><br>				
											</b></span>
										</td>							
									</tr>
								</table>
							</td>
						</tr>					
						<tr>
							<td colspan="4" class="padding-top-10">
								<table class="" align="left" border="1"  bordercolor="" cellPadding="0" cellSpacing="0" width=100%>
									<thead>
										<tr class="">
											<th class="width_70" height="10" align="center" style="border-right: 0pt;"><span class="normal bold">Description of Charges</span></th>
											<!-- <th class="width_20" align="center"><span class="bold">Sub Account</span></th> -->							
											<th class="width_15" height="10" align="center" style="border-right: 0pt;"><span class="normal bold">TC Amount (${object1.currencyName})</span></th>
											<th class="width_15" height="10" align="center" style="border-right: 0pt;"><span class="normal bold">BC Amount (${object1.companyCurrency})</span></th>
										</tr>
									</thead>
									<tbody>
										<%-- <tr  border="0">
											<td colspan="4" class="width_60" align="left" valign="top" class="tablespace">
													<span class="normal"> ${object1.subject}</span>
											</td>												
										</tr>	 --%>
										<c:forEach var="ob" items="${invoiceList.detailList}"  varStatus="theCount"> 
											<tr class="description">
												<td class="subcolor width_70" height="10" align="left" valign="top" style="border-right: 0pt;">
													<%-- <font face="arial" size="2"> Sub Group Code:- ${ob.subGroupCode}  </font><br>
													<font class="bold" face="arial" size="2">${ob.subGroupName}</font><br>									
													<font face="arial" size="2"> Account Code:- ${ob.accountHead}</font><br> --%>
													<span class="normal"> 
													<font class="" face="arial" size="2">${ob.accountHeadName}</font>
															<c:if test="${theCount.count == 1}">
																<b><c:out value="${object1.subject}" /></b>
															</c:if>
													<br><font class="" face="arial" size="2">${ob.narration}</font>
													
													</span><br>
													
													<c:if test="${object1.vesselName ==''}">
													<c:choose>
													    <c:when test="${empty ob.vesselCode}">
															<font class="" face="arial" size="2"></font>												        
													    </c:when>
													    <c:otherwise>
													        <font class="" face="arial" size="2"> <b>Vessel:</b> ${ob.vesselName} </font>
													    </c:otherwise>
													</c:choose>	
													</c:if>
													
													<c:if test="${object1.voyage ==''}">														
													<c:choose>
													    <c:when test="${empty ob.voyageCode}">
															<font class="" face="arial" size="2"></font>												        
													    </c:when>
													    <c:otherwise>
													        <font class="" face="arial" size="2"> <b>Voyage:</b> ${ob.voyageCode} </font><br>
													    </c:otherwise>
													</c:choose>	
													</c:if>
													<%-- <c:choose>
													    <c:when test="${empty ob.sectorCode}">
															<font face="arial" size="2"></font>												        
													    </c:when>
													    <c:otherwise>
													        <font face="arial" size="2"> <b>Service:</b> ${ob.sectorCode} - ${ob.sectorName}</font>
													    </c:otherwise>
													</c:choose>  --%>
												</td>
												
												<%-- <td class="subcolor width_20 text-wrap" align="left"  valign="top" nowrap="nowrap">
													<font class="bold" face="arial" size="2">${ob.subAccountName}</font>
												</td> --%>
												
					
												<td class="subcolor width_15" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;">
												<span class="normal"> 
												${ob.tcAmount} 
												</span></td>
												<td class="subcolor width_15" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;"><span class="normal"> 
												${ob.bcAmount} 
												</span></td>
											</tr>	
											<tr class="description blank_row">
									            <td bgcolor="#FFFFFF" colspan="" height="10"  style="border-right: 0pt;">&nbsp;</td>
									            <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td>
									            <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td>
									    	</tr>									
										</c:forEach>									
											<tr class="description">
												<td class="width_70 normal" height="150" align="left" valign="top" style="border-right: 0pt;"><span class="normal">&nbsp;</span> </td>
												<td class="width_15 normal" height="150" align="left" valign="top" style="border-right: 0pt;"><span class="normal">&nbsp;</span> </td>
												<td class="width_15 normal" height="150" align="left" valign="top" style="border-right: 0pt;"><span class="normal">&nbsp;</span> </td>	
											</tr>
											<tr>
												<td class="width_70" align="left" valign="top">
													<span class="normal"><b>Exchange Rate: ${object1.exchangeRate}</b></span>
													<span class="normal" style="float:right; padding-right:10px;"><b>Total</b></span>												
												</td>
												<!-- <td class="width_20" align="right" valign="top">
												</td> -->
												<td class="width_15" align="right">
													<span class="normal"><b><!-- total TC Amount -->
													${object1.totalTCamount}</b></span>
												</td>
												<td class="width_15" align="right">
													<span class="normal"> <b> <!-- total BC Amount (USD) -->  
													${object1.totalBCamount}</b></span></td>
											</tr>
									</tbody>		
								</table>					
							</td>
						</tr>
					</table>
					</td>
				</tr>
				<tr><!-- Fetch TC Amount and BC Amount (USD) in words --> 
					<td align="left" class="tablespace">
						<span class="normal"><b>E and O.E.</b><br>
						${object1.totalTCAmountInWords} <br>
						${object1.totalBCAmountInWords} </span>
					</td>
				</tr> 
				<!-- <tr>
					<td align="left" class="tablespace">
						<span class="normal"><br>
							<font style="font-style: italic;"><b>Note:<br>
							IN CASE OF ANY DISCREPANCIES ,
							PLEASE NOTIFY WITHIN 10 DAYS FROM THE DATE OF RECEIPT</b></font>
						</span></td>
				</tr> -->
				<tr>
					<td class="padding-top-10"><span class="normal">	
					<b><u>BANK DETAILS</u></b></span></td>
				</tr>
				<tr>
					<td class="padding-top-10" valign="top">
					
					<table border=0 cellPadding=0 cellSpacing=0 class="width_100"
									style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
									<tr>
										<td>
											<table align=left border=1 cellPadding=0 cellSpacing=0
												class="width_100" height=100%
												style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
	
												<c:choose>
													<c:when test="${object1.location ==  'INDIA'}">
														<TR>
															<td width="100%"><span class=normal>XXXXXXXXXXXXX
																	LTD<BR> &nbsp;&nbsp;BRANCH : XXXXXXXX<BR>
																	&nbsp;&nbsp;BRANCH ADDRESS :XXXXXXXXXXXXX
																	XXXXXXXXXXXXX<BR> &nbsp;&nbsp;A/C No : XXXXXXXXXXXXX <BR>
																	&nbsp;&nbsp;NEFT / RTGS / IFSC CODE : XXXXXXXXXXXXX<BR>
																	&nbsp;&nbsp;MICR CODE : XXXXXXXXXXXXX<BR>
																	&nbsp;&nbsp;BENEFICIARY : XXXXXXXXXXXXXXX<BR>
															</span></td>
														</tr>
													</c:when>
													<c:when test="${object1.location ==  'SRILANKA'}">
													<TR>
													<td width="100%"><span class=normal>PLEASE DRAW ALL CHEQUES IN FAVOR OF PARAGON DYNAMICS INFO SYSTEMS (P) LTD.<BR><BR></span>
													
													</td>
													
													</TR>
														<TR>
															<td width="100%"><span class=normal>XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;BRANCH : XXXXXXX<BR>
																&nbsp;&nbsp;BRANCH ADDRESS :XXXXXXXXXXXXX<BR> 
																&nbsp;&nbsp;EAST BLOCK, XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;SWIFT CODE : XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;LKR ACCOUNT : XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;USD ACCOUNT : XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;BENEFICIARY : Saurashtra Freight (Pvt) Ltd.<BR>
																&nbsp;&nbsp;BENEFICIARY ADDRESS : XXXXXXXXXXXXXX<BR>
																</span></td>
	
														</tr>
													</c:when>
													<c:when test="${object1.location== 'DUBAI'}">
														<TR>
															<td width="100%"><span class=normal>
																	Bene Name:  Saurashtra Freight (Pvt) Ltd. <BR>
																	Bene Bank: XXXXXXXX<BR>
																	Swift Code: XXXXXXXX<BR><BR><BR>
																	<span style="text-decoration: underline;"><b>For USD Remittance:</b></span><BR>
																	USD Acct.Num:  XXXXXX<BR> 
																	IBAN (USD Acct): XXXXXXXXXX<BR>
																	Intermediary Bank:  XXXXXXXXXXXXX<BR>
																	Swift Code: XXXXXXXXX<BR><BR><BR> 
																	<span style="text-decoration: underline;"><b>For AED Remittance:</b></span><BR>
																	AED Acct. Num.: XXXXXXXXXXX<BR> 
																	IBAN (AED Acct): XXXXXXXX<BR>   
															</span></td>
														</tr>
	
													</c:when>
													
													<c:when
														test="${object1.location =='SINGAPORE'}">
														<TR>
															<td><span class=normal> &nbsp;&nbsp;XXXXXXXXXXXXX<br>
																	&nbsp;&nbsp;SWIFT CODE XXXXXXXXXXXXX<BR>
																	&nbsp;&nbsp;USD Current A/C :XXXXXXXXXXXXX<BR>
																	&nbsp;&nbsp;SGD CURRENT A/C :XXXXXXXXXXXXX
															</span></td>
	
														</tr>
													</c:when>
													
													<c:otherwise>
														<TR>
															<td width="100%"><span class=normal>
																	Bene Name: PARAGON DYNAMICS INFO SYSTEMS (P) LTD<BR>
																	Bene Bank: National Bank of Fujairah PSC, Dubai<BR>
																	Swift Code: NBFUAEAFDXB<BR><BR><BR>
																	<span style="text-decoration: underline;"><b>For USD Remittance:</b></span><BR>
																	USD Acct.Num:  01 20 00 694 396<BR> 
																	IBAN (USD Acct): AE 78 0380 0000 1200 0694 396<BR>
																	Intermediary Bank:  JP Morgan Chase, New York<BR>
																	Swift Code: XXXXXXXXXXXXX<BR><BR><BR> 
																	<span style="text-decoration: underline;"><b>For AED Remittance:</b></span><BR>
																	AED Acct. Num.: 01 20 00 694 388<BR> 
																	IBAN (AED Acct): AE 03 0380 0000 1200 0694 388.<BR>   
															</span></td>
														</tr>
	
													</c:otherwise>
												</c:choose>
	
	
	
											</table>
										</td>
										<td>
											<table border=0 cellPadding=2 cellSpacing=0 class="width_100">
												<c:choose>
													<c:when	test="${object1.location =='SINGAPORE'}">
														<tr>
															<td>
																<table class="width_100" border=0 cellspacing=0
																	cellpadding=0>
																	<tr>
																		<td class="bold text_right">PARAGON DYNAMICS INFO SYSTEMS (P) LTD</td>
																	</tr>
																	<tr>
																		<td class="bold text_right padding-top-30">${object1.invoiceCreatedUser}</td>
																	</tr>
																</table>
															</td>
														</tr>
													</c:when>
													<c:otherwise>
														<tr>
															<td>
																<table class="width_100" border=0 cellspacing=0
																	cellpadding=0>
																	<tr>
																		<td class="bold text_right">PARAGON DYNAMICS INFO SYSTEMS (P) LTD</td>
																	</tr>
																	<tr>
																		<td class="bold text_right"></td>
																	</tr>
																	<tr>
																		<td class="bold text_right padding-top-30">${object1.invoiceCreatedUser}</td>
																	</tr>
																</table>
															</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</table>
										</td>
									</tr>
								</table>
					<!-- Detail table - ends -->
						
					</td>
				</tr>
				<tr>
				   <!-- <td class="normal">***This is a Computer Generated BL and does
				    not requires signature and seal*****</td> -->
				   		<!-- <TD class="normal" style="text-align: right">Page 1 of 2</TD> -->
				   	   <!-- Add Page Numbering in HTML using &p; and &P -->
	            	<td style="width: 90%;text-align: right">Page 
	            	<span style="font-weight: bold">1</span> of <span style="font-size: 16px; font-weight: bold">2</span> 	            	</td>
				</tr>
				
				
			</table>
			
			 <br><br> <br><br>
			 
			 <table width="100%">
			 	<tr>
					<td class="" colspan="10" align="center">
						<c:if test="${object1.blRelated == 'Y'}">
						 <table border="1" width="90%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="#cccccc" align="center">
						  <tr>
						   <td class="gridheadercell" colspan="12">CONTAINERS DETAILS</td>
						  </tr>
						 	<tr>
								<td class="gridheadercell">S.No</td>
								<td class="gridheadercell">Voyage</td>
								<td class="gridheadercell">CUST.</td>
								<td class="gridheadercell">POL</td>
								<td class="gridheadercell">POD</td>
								<td class="gridheadercell">TYPE</td>
								<td class="gridheadercell">CONTAINER_NO</td>
								<td class="gridheadercell">SLOT_SIZE</td>
					
								<td class="gridheadercell">WEIGHT</td>
								<td class="gridheadercell">IMCO</td>
					
								<td class="gridheadercell">REFER</td>
								<td class="gridheadercell">Remarks</td>
							</tr>
						  <c:set var="index" value="0"></c:set>  
						  <c:forEach var="slotmessageList" items="${invoiceList.slotMsgContainerList}" varStatus="theCount">
							  <tr>
								<td class="tablespace"><span class=normal>${theCount.count}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.voyage}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.mloname}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.pol}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.pod}</span></td>
				
								<td class="tablespace"><span class=normal>${slotmessageList.containerType}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.containerNO}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.slotsize}</span></td>
				
								<td class="tablespace"><span class=normal>${slotmessageList.weight}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.imco}</span></td>
				
								<td class="tablespace"><span class=normal>${slotmessageList.refer}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.remarks}</span></td>
							</tr>
						  </c:forEach>
						 </table><!-- <br><br><br><br><br><br> <br><br><br><br><br><br> -->
					 </c:if> 
					 <c:if test="${object1.subject == 'Stack Usage'}">
					 	 <table border="1" width="90%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="#cccccc" align="center">
						  <tr>
						   <td class="gridheadercell" colspan="12">CONTAINERS DETAILS</td>
						  </tr>
						 	<tr>
								<td class="gridheadercell">S.No</td>
								<td class="gridheadercell">Voyage</td>
								<td class="gridheadercell">CUST.</td>
								<td class="gridheadercell">POL</td>
								<td class="gridheadercell">POD</td>
								<td class="gridheadercell">TYPE</td>
								<td class="gridheadercell">CONTAINER_NO</td>
								<td class="gridheadercell">SLOT_SIZE</td>
					
								<td class="gridheadercell">WEIGHT</td>
								<td class="gridheadercell">IMCO</td>
					
								<td class="gridheadercell">REFER</td>
								<td class="gridheadercell">Remarks</td>
							</tr>
						  <c:set var="index" value="0"></c:set>  
						  <c:forEach var="slotmessageList" items="${invoiceList.stackUsageContList}" varStatus="theCount">
							  <tr>
								<td class="tablespace"><span class=normal>${theCount.count}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.voyage}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.mloname}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.pol}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.pod}</span></td>
				
								<td class="tablespace"><span class=normal>${slotmessageList.containerType}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.containerNO}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.slotsize}</span></td>
				
								<td class="tablespace"><span class=normal>${slotmessageList.weight}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.imco}</span></td>
				
								<td class="tablespace"><span class=normal>${slotmessageList.refer}</span></td>
								<td class="tablespace"><span class=normal>${slotmessageList.remarks}</span></td>
							</tr>
						  </c:forEach>
						 </table><!-- <br><br><br><br><br><br> <br><br><br><br><br><br> -->
					 </c:if>
					 <!-- stackUsageContList -->
					</td>
				</tr>
				
			  <tr>
			   <!-- <TD class="normal" style="text-align: right">Page 2 of 2</TD> -->
			   <td style="width: 90%;text-align: right">Page <span style="font-weight: bold">2</span> of 
			   <span style="font-size: 16px; font-weight: bold">2</span></td>
			  </tr>
			 </table>
			 <br><br><br><br><br><br> <br><br><br><br><br><br>
			 <table id="footer" border=0 bordercolor="" cellspacing="0" cellpadding="2" align="center">										
					<tr>
				
				<td class="" colspan="10" align="center"><span class=footer-text> ${object1.companyAddress}</span></td>
				</tr>
				<tr>
					<td colspan="10" align="center">
						<span class=footer-text><b>Tel.:</b> ${object1.companyPhoneNo}</span>
						<span class=footer-text><b>Telex:</b> ${object1.companyFaxNo}</span>
						<span class=footer-text><b> e-mail:</b> ${object1.companyEmail}</span>
					</td>
				</tr>
			</table>
		</div>
		
	</body>
</html>
