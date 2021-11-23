<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html><head>

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
.padding-left-5{
	padding-left: 5px;
}
.padding-5p{
	padding: 5px;
}
.line-height-23p{
line-height: 23px;
}
.padding-top-30{
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
.footer{
    width: 100%;
    position: fixed;
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
.bold {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
	font-weight: bold;
	color: #000000;
	text-decoration: none;
	padding-left: 6px;
}

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
.description, .description td {
	border-bottom: 1pt solid #fff;
	border-top: 1pt solid #fff;
}

.description1, .description1 td {
	border-bottom: 0px solid #fff;
}
@page{
size: A4;
margin: 2mm;

}
</style>
<link rel="stylesheet" href="../../css/jquery.signaturepad.css" >

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
</head>
<body>
 <c:set var="object1" value="${creditNodeList}" />
  <c:set var="object2" value="${companyList}" /> 
   <c:set var="object3" value="${invoiceDeail}" /> 
    <c:set var="object4" value="${digitalSignList}" />
    <c:set var="object5" value="${credittablesDetail}" /> 
   <c:set var="locationName" scope="session" value="DUBAI"/>
  <c:set var="locationName1" scope="session" value="SINGAPORE"/>
  <c:set var="locationName2" scope="session" value="AMERICA"/>
  <c:set var="locationName3" scope="session" value="MUMBAI"/> 
  <table border="0" class="padding-top-2" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center" margin-left:-1px" >
						<tr>
							<td width="50%" style="text-align: center;">

								<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="" align="center">
									<tr>
										<td width="25%"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 10 0 0 30; height: 50px;"></td>
                                  
										<td width="75%" style="font-size: 14px;">
										<span style="text-align: center;"><font face="arial" size="4"><b>${object1.branchName}</b></font></span> <br> 
										
													<span
											style="text-align: right;" style="font-size: 12px;">${object1.branchAddress1}${object1.branchAddress2}</span> <br> <span
											style="text-align: right;" style="font-size: 12px;">${object1.branchAddress3}</span> <br> 
											<span
											style="text-align: right;" style="font-size: 12px;"><c:if test="${object1.branchGstno != ''}">GSTNO:${object1.branchGstno}</c:if></span></td>
									
									</tr>
								</table>
							</td>

						</tr>
						<tr>
						</tr>
					</table>
	<table align=center border=0 cellPadding=0 cellSpacing=0 width="95%">
		<tr>
			<td>
			<%--  <table border="0" width="100%" cellpadding="0" cellspacing="0"
				bgcolor="FFFFFF" bordercolor="#cccccc" align=center >
				<tr>
				<td width="25%"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 10 0 0 10; height: 50px;"></td>
					<td><c:if test="${locationName == object2.locationName}">
						<img src="/img/sfpl_logo_202x48.jpg"></c:if>
					<c:if test="${locationName1 == object2.locationName}">
						<img src="/img/sfpl_logo_232x55.jpg"></c:if> 	
					<c:if test="${locationName2 == object2.locationName}">
						<img src="/img/America_logo.jpg"></c:if> 	
					<c:if test="${locationName3 == object2.locationName}">
						<img src="/img/sfpl_logo_226x50.jpg"></c:if> 	
					</td>
				</tr>
			</table>
			<br> --%>
		
			<TABLE align=center border=0 cellPadding=0 cellSpacing=0 width="100%">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<td><font face="arial" size="4" align="center"><b>PURCHASE CREDIT NOTE</b></font></td>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<TD width=24%>

					<TABLE align=left border=1 cellPadding=2 cellSpacing=0 width=100%>
						<TR>

							<TD align=left><span class="normal"><b>${object1.mloName}<br>
							
							<c:if test="${object1.custAddrss != ''}">${object1.custAddrss}</c:if><c:if test="${object1.custAddrss == ''}">&nbsp;&nbsp;-</c:if><br>
													
							<br>
							</b></span></td>

						</tr>
					</table>
					</td>
				<TD width=2%>&nbsp;</td>
				<td width=24% height=100%>
							<table width=100% align="left" border="1" height=100%  bordercolor="" cellPadding="0" cellSpacing="0">
								<tr>
									
									<td valign="top" class="padding-left-5"><span class="normal">
										<b>Credit Note Number :${object1.creditNoteNo}<br>
										Date : ${object1.creditNoteDate}<br>
										Reference. No : ${object1.invoiceNo}<br>
														    
										<%-- Voyage : ${object3.voyage}<br> 
									    Vessel : ${object3.vesselName}<br><br> --%>
									   <!--  &nbsp;BL No. :  BL No
									    	&nbsp;Sailing Date :&nbsp; Fetch slDate - sailing date<br>
									    	&nbsp;Exchange Rate :&nbsp; fetch exchange Rate  -->
										</b></span>
									</td>							
								</tr>
							</table>
						</td>
			
				</TR>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="3">
						<table align=left border=1 cellPadding=2 cellSpacing=0 width="100%"
						 style="border-left-width: 1px; border-right-width: 1px; border-top-width: 1px; border-bottom-width: 1px; 
						 border: black;">
						 	<thead>
						 	<tr >
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>Charge Head</b></span></td>
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>Sac No</b></span></td>
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>Exchange Rate</b></span></td>
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>Currency</b></span></td>
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>CGST%</b></span></td>
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>CGST AMOUNT</b></span></td>
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>SGST %</b></span></td>
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>SGST AMOUNT</b></span></td>
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>IGST %</b></span></td>
								<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>IGST AMOUNT</b></span></td>
								<!-- <TD align=center width=15% height=10 align="center" valign=top  style="border-right: 0pt;"><span class=normal><b>AMOUNT (INR)</b></span></td> -->
								<TD align=center width=15% height=10 align="center" valign=top ><span class=normal><b>AMOUNT </b></span></td>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="ob"  items="${creditNodeList.credittables}" varStatus="i"> 
								
				   					<tr >					 					
					 					<td width="15%" align="left" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.crdtlAccountHead}"/></font></td> 
					 					<td width="15%" align="left" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.sacNo}"/></font></td>
					 					<td width="15%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.exchangeRate}"/></font></td>
					 					<td width="15%" align="left" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.currency}"/></font></td>
					 					<td width="15%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.cgstPrct}"/></font></td>
					 					<td width="15%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.cgstamt}" /></font>
					 					</td>
					 					<td width="15%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.sgstPrct}"/></font></td>
					 					<td width="15%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.sgstamt}" /></font>
					 					</td>
					 					<td width="15%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.igstPrct}"/></font></td>
					 					<td width="15%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.igstamt}" /></font>
					 					</td> 
					 					<%-- <td width="15%" align="right" valign=top  style="border-right: 0pt;"><c:out value="${ob.tcamount}"/></td>  --%>
					 					<td width="15%" align="right" valign=top  ><font face="arial" size="1" color="black"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.bcamount}" /></font></td> 					       				
				               		</tr>
				               
			               		</c:forEach>			               		
			               		<tbody>
			               			
		        				<tr>	
		        					<td style="border-right: 0pt;"><font face="arial" size="1" color="black"><B>Total</B></font></td>
									<td style="border-right: 0pt;"></td> 
									<td style="border-right: 0pt;"></td>        				
		        				<td style="border-right: 0pt;"></td>
		        				<td style="border-right: 0pt;"></td>
		        				<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;">
		        				<font face="arial" size="1" color="black"><B><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${creditNodeList.credittables[0].totalcgstAmt}" /></B></font>
		        				
		        				<td style="border-right: 0pt;"></td>
		        				<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;">
		        				<font face="arial" size="1" color="black"><B><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${creditNodeList.credittables[0].totalgstAmt}" /></B></font>
		        				
										 </td>
		        				<td style="border-right: 0pt;"></td>
		        				<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;">
		        				<font face="arial" size="1" color="black"><B><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${creditNodeList.credittables[0].totaligstAmt}" /></B></font>
		        				
										 </td>							
									
								<td width="15%" height="10" align="right" valign="top" >
										<font face="arial" size="1" color="black"><B><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.totalBCAmount+creditNodeList.credittables[0].totalcgstAmt+creditNodeList.credittables[0].totalgstAmt+creditNodeList.credittables[0].totaligstAmt}" /></B></font>
										</td>										
								</tr>
						</table>
					</td>
				</tr>
			</table>
			</td>		
		</tr>
		<tr>
			<td align=left><span class=normal> 				
				<c:out value="Amount In Words:${object1.totalBCAmountInWords}"/><br>
				
				</span></td>
		</tr>
		<br>
		<br>
	<%-- 	<tr>
			<td align="left" class="tablespace">
				<span class="normal"><br>
					<font style="font-style: arial;"><b>MBK<br><br>
					${object1.createdUser}</b></font>
				</span></td>
														
		</tr> --%>
		
		
		
		<!-- <tr>
			<td><span class="normal"><br>		
			<b><u>BANK DETAILS</u></b></span></td>
		</tr> -->
		<%-- <tr>
			<td><br>
			<table border=0 cellPadding=0 cellSpacing=0 class="width_100"
							style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
							<tr>
								<td>
									<table align=left border=1 cellPadding=0 cellSpacing=0
										class="width_100" height=100%
										style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">

										<c:choose>
											<c:when test="${object2.locationName ==  'INDIA'}">
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
											<c:when test="${object2.locationName ==  'SRILANKA'}">
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
											<c:when test="${object2.locationName== 'DUBAI'}">
												<TR>
													<td width="100%"><span class=normal>
															Bene Name: MBK <BR>
															Bene Bank: <c:if test="${object1.branchBankname != ''}">${object1.branchBankname}</c:if><c:if test="${object1.branchBankname == ''}">&nbsp;&nbsp;-</c:if><br><BR>
															Swift Code: <BR><BR><BR>
															<span style="text-decoration: underline;"><b>For USD Remittance:</b></span><BR>
															USD Acct.Num:  <BR> 
															IBAN (USD Acct): <BR>
															Intermediary Bank:  <BR>
															Swift Code: <BR><BR><BR> 
															<span style="text-decoration: underline;"><b>For AED Remittance:</b></span><BR>
															AED Acct. Num.: <BR> 
															IBAN (AED Acct): .<BR>   
													</span></td>
												</tr>

											</c:when>
											
											<c:when
												test="${object2.locationName =='SINGAPORE'}">
												<TR>
													<td><span class=normal> &nbsp;&nbsp;<br>
															&nbsp;&nbsp;SWIFT CODE <BR>
															&nbsp;&nbsp;USD Current A/C :<BR>
															&nbsp;&nbsp;SGD CURRENT A/C :
													</span></td>

												</tr>
											</c:when>
											
											<c:otherwise>
												<TR>
													<td width="100%"><span class=normal>
															Bene Name:MBK <BR>
															Bene Bank: <c:if test="${object1.branchBankname != ''}">${object1.branchBankname}</c:if><c:if test="${object1.branchBankname == ''}">&nbsp;&nbsp;-</c:if><br><BR>
															Swift Code: <BR><BR><BR>
															<span style="text-decoration: underline;"><b>For USD Remittance:</b></span><BR>
															USD Acct.Num: <BR> 
															IBAN (USD Acct): <BR>
															Intermediary Bank:  <BR>
															Swift Code: <BR><BR><BR> 
															<span style="text-decoration: underline;"><b>For AED Remittance:</b></span><BR>
															AED Acct. Num.: <BR> 
															IBAN (AED Acct): .<BR>   
													</span></td>
												</tr>

											</c:otherwise>
										</c:choose>



									</table>
								</td>
								<td>
									<table border=0 cellPadding=2 cellSpacing=0 class="width_100">
									<c:choose>
									<c:when	test="${object2.locationName =='SINGAPORE'}">
											<tr>
											<td>
												<table class="width_100" border=0 cellspacing=0
													cellpadding=0>
													<tr>
														<td class="bold text_right">MBK</td>
													</tr>
													<tr>
														<td class="bold text_right padding-top-30">${object1.createdUser}</td>
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
														<td class="bold text_right">MBK </td>
													</tr>
													<tr>
														<td class="bold text_right"></td>
													</tr>
													<tr>
														<td class="bold text_right padding-top-30">${object1.createdUser}</td>
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
			</td>
		</tr> --%>
		
	</table>
			</td>
		</tr>
		
		
 	<TR>
	<TABLE width="100%">
	<tr>
	<td>&nbsp;</td>
	<td>
		<TABLE align=left   width=100%>
		<tr>
		
 			<td></td>
		<td> 
			<div class="sigPad signed">
			<div class="sigWrapper">
	      		<div class="signed"></div>
	      		<canvas class="pad" width="400" height="55"></canvas>
	    	</div>
	   		</div>
   		</td>
		</tr>
		</TABLE>
		</td>
		</tr>
		
	</TABLE>
	</TR> 
	
</TABLE>



 <script src="../../js/vendor/signaturepad/jquery.signaturepad.js"></script>
<script src="../../js/vendor/signaturepad/json2.min.js"></script>

<script>
    $(document).ready(function() {
	 	var approvedSign=[];
        var status=${digitalSignList.status};
        var approvedSign=[];
     	approvedSign=${digitalSignList.approvedSign};
      	if(approvedSign.length>0){
            $('.sigPad').signaturePad({displayOnly:true}).regenerate(approvedSign);
        
        }
       
   
    });
  </script>
 
</body>
</html>