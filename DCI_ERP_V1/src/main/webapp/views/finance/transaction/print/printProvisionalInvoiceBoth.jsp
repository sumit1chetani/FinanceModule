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
</style>
<style type="text/css" media="print">
      html, body { margin: 0; padding: 0; }
      /* body { height: 11in;  width: 8.5in; } */
       a[href]:after {
	    content: " (" attr(href) ")";
	 }
	  #footer { position: absolute; bottom: 0; width:100%; margin:0 auto;} 
</style> 
</head>
	<body>
		
		<c:set var="object1" value="${provisionalInvoiceList}" />
		<%-- <c:set var="object2" value="${vesselVoyageWithInvoiceNo}" /> --%>
		
		<table class="width_100" align="center" border="0" cellPadding="0" cellSpacing="0">
			<tr>
				<td>				
				<table border="0" class="padding-top-10" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">		
					
					<tr>
						<td><c:if test="${object1.location == 'DUBAI'}">
						<img src="/img/sfpl_logo_202x48.jpg"></c:if>
						<c:if test="${object1.location == 'SINGAPORE'}">
						<img src="/img/sfpl_logo_232x55.jpg"></c:if> 	
						<c:if test="${object1.location == 'AMERICA'}">
						<img src="/img/America_logo.jpg"></c:if> 	
						<c:if test="${object1.location == 'INDIA'}">
						<img src="/img/sfpl_logo_226x50.jpg"></c:if> 	
						</td>
					</tr>
				</table>
				
				<font size="5" class="padding-top-10" face="arial"><b>INVOICE</b></font>
				<p>
				<table width=100% align="center" border="0" cellPadding="0" cellSpacing="0">
					<tr>
						<td width=24% height=100%>
							<table width=100% align="left" border="1" height=100%  bordercolor="" cellPadding="0" cellSpacing="0">
								<tr>
									<td valign="top" class="tablespace padding-5p">
										<span class=bold>
												 <font class="bold" face="arial" size="2"> ${object1.mloName} ,</font><br>
												<font  face="arial" size="2">${object1.customerAddress} ,</font><br><br>									
												<font face="arial" size="2"> Tel No.: ${object1.customerPhoneNo} | Fax No.: ${object1.customerFaxNo} </font><br>
												<font class="" face="arial" size="2"> Email: ${object1.customerEmail}</font>
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
									<td valign="top" class="line-height-23p padding-left-5"><span class="normal">
										<b>Inv. No :  ${object1.invoiceNo}<br>
										Inv. Date : ${object1.invoiceDate}<br>																		    
										Trip : ${object1.voyage}<br> 
									    Truck : ${object1.vesselName}<br>									
										</b></span>
									</td>							
								</tr>
							</table>
						</td>
					</tr>
					
					<tr>
						<td colspan="4" class="padding-top-10">
							<table class="table table-striped b-t b-light" align="left" border="1"  bordercolor="" cellPadding="0" cellSpacing="0" width=100%>
								<thead>					
									<tr>
										<th class="width_50" align="center"><span class="bold">Description of Charges</span></th>
										<th class="width_20" align="center"><span class="bold">Sub Account</span></th>							
										<th class="width_15" align="center"><span class="bold">TC Amount (${object1.currencyName})</span></th>
										<th class="width_15" align="center"><span class="bold">BC Amount (${object1.companyCurrency})</span></th>
										
									</tr>
								</thead>
								<tbody>
									<tr  border="0">
										<td colspan="4" class="width_60" align="left" valign="top" class="tablespace">
												<span class="normal"><b>Subject :   ${object1.subject}</b></span>
										</td>												
									</tr>	
									<c:forEach var="ob" items="${provisionalInvoiceList.priDtl}"> 
										<tr>
											<td class="subcolor width_50" align="left" valign="top">
												<font face="arial" size="2"> Sub Group Code:- ${ob.subGroupCode}  </font><br>
												<font class="bold" face="arial" size="2">${ob.subGroupName}</font><br>									
												<font face="arial" size="2"> Account Code:- ${ob.accountHead}</font><br>
												<font class="bold" face="arial" size="2">${ob.accountHeadName}</font><br>
												<font class="bold" face="arial" size="2"> Narration:- ${ob.narration}</font><br>
												
												<c:choose>
												    <c:when test="${empty ob.vesselCode}">
														<font face="arial" size="2"></font>												        
												    </c:when>
												    <c:otherwise>
												        <font face="arial" size="2"> <b>Truck:</b> ${ob.vesselCode} -  ${ob.vesselName} </font><br>
												    </c:otherwise>
												</c:choose>														
												<c:choose>
												    <c:when test="${empty ob.voyageCode}">
														<font face="arial" size="2"></font>												        
												    </c:when>
												    <c:otherwise>
												        <font face="arial" size="2"> <b>Trip:</b> ${ob.voyageCode} </font><br>
												    </c:otherwise>
												</c:choose>	
												<c:choose>
												    <c:when test="${empty ob.sectorCode}">
														<font face="arial" size="2"></font>												        
												    </c:when>
												    <c:otherwise>
												        <font face="arial" size="2"> <b>Service:</b> ${ob.sectorCode} - ${ob.sectorName}</font>
												    </c:otherwise>
												</c:choose>
											</td>
											
											<td class="subcolor width_20 text-wrap" align="left"  valign="top" nowrap="nowrap">
												<font class="bold" face="arial" size="2">${ob.subAccountName}</font>
											</td>
											
				
											<td class="subcolor width_15" align="right" nowrap="nowrap">
											<span class="normal"> 
											${ob.tcAmount} 
											</span></td>
											<td class="subcolor width_15" align="right" nowrap="nowrap"><span class="normal"> 
											${ob.bcAmount} 
											</span></td>
										</tr>										
									</c:forEach>									
										
										<tr>
											<td class="width_50" align="left" valign="top">
												<span class="normal"><b>Exchange Rate: ${object1.exchangeRate}</b></span>												
											</td>
											<td class="width_20" align="right" valign="top">
											</td>
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
				<td align="left" class="tablespace"><span class="normal"><b>E and O.E.</b><br>
				${object1.totalTCAmountInWords} <br>
				${object1.totalBCAmountInWords} </span></td>
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
															&nbsp;&nbsp;BENEFICIARY : PARAGON DYNAMICS INFO SYSTEMS (P) LTD<BR>
															&nbsp;&nbsp;BENEFICIARY ADDRESS : NO.99 ST MICHAELA��S ROAD, COLOMBO 03<BR>
															</span></td>

													</tr>
												</c:when>
												<c:when test="${object1.location== 'DUBAI'}">
													<TR>
														<td width="100%"><span class=normal>
																Bene Name: PARAGON DYNAMICS INFO SYSTEMS (P) LTD<BR>
																Bene Bank: XXXXXXXXXXXXXXXXXXXXXXX<BR>
																Swift Code: XXXXXXXXXXXX<BR><BR><BR>
																<span style="text-decoration: underline;"><b>For USD Remittance:</b></span><BR>
																USD Acct.Num:  XXXXXXXXXXXXXXXXXX<BR> 
																IBAN (USD Acct): XXXXXXXXXXXXXXXX<BR>
																Intermediary Bank:  XXXXXXXXXXXXXXX<BR>
																Swift Code: XXXXXXXXXXXXX<BR><BR><BR> 
																<span style="text-decoration: underline;"><b>For AED Remittance:</b></span><BR>
																AED Acct. Num.: XXXXXXXXXXXXXXXX<BR> 
																IBAN (AED Acct): XXXXXXXXXXXXXXXXXXXXX.<BR>   
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
																Bene Bank: XXXXXXXXXXXXXXXXXXX<BR>
																Swift Code: XXXXXXXXXXXXXX<BR><BR><BR>
																<span style="text-decoration: underline;"><b>For USD Remittance:</b></span><BR>
																USD Acct.Num:  XXXXXXXXXXXXXXXXXXX<BR> 
																IBAN (USD Acct): XXXXXXXXXXXXXXXXXX<BR>
																Intermediary Bank:  XXXXXXXXXXXXXXXXX<BR>
																Swift Code: XXXXXXXXXXXXX<BR><BR><BR> 
																<span style="text-decoration: underline;"><b>For AED Remittance:</b></span><BR>
																AED Acct. Num.: XXXXXXXXXXXXXXX<BR> 
																IBAN (AED Acct): XXXXXXXXXXXXXXXXXXXXXXXX.<BR>   
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
		</table>
		<table id="footer" class="width_100 footer" border="0" bordercolor="" cellspacing="0" cellpadding="0" align="center" valign="top">								
			<tr>
				<td class="padding-top-10" colspan="10" align="center"><span class=footer-text> ${object1.companyAddress}</span></td>
			</tr>
			<tr>
				<td colspan="10" align="center">
					<span class=footer-text><b>Tel.:</b> ${object1.companyPhoneNo}</span>
					<span class=footer-text><b>Telex:</b> ${object1.companyFaxNo}</span>
					<span class=footer-text><b>e-mail:</b> ${object1.companyEmail}</span>
				</td>
			</tr>	
		</table>	
	</body>
</html>
