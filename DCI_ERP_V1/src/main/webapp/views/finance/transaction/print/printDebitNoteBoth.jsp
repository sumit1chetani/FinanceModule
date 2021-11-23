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


<title>Debit Note</title>
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
.padding-top-30{
	padding-top: 30px;
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
.description, .description td {
	border-bottom: 1pt solid #fff;
	border-top: 1pt solid #fff;
}

.description1, .description1 td {
	border-bottom: 0px solid #fff;
}

.gridheadercell {
	color: #000000;
	background: #ffe6a2;
	text-align: center;
	FONT-FAMILY: Arial;
	FONT-SIZE: 8pt;
	padding: 2px;
	font-weight: bold;
}
@page{
size: A4;
margin: 2mm;

}

</style>
</head>
	<body>
		<c:set var="object1" value="${debitNodeList}" />
		<c:set var="object2" value="${vesselVoyageWithInvoiceNo}" />
		<c:set var="payercountry" value="${payerIndia}" />
		  <c:set var="object5" value="${credittablesDetail}" /> 
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
											style="padding: 10 0 0 20; height: 50px;"></td>
                                  
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
		<!-- <table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">		
				<tr>
					<td>
					<img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 10 0 0 10; height: 50px;">
					
					</td>
				</tr>
			</table> -->
		<table class="width_100" height="100%" align="center" border="0" cellPadding="0" cellSpacing="0">
			<tr>
				<td>
				
			
			<br>
			<br>
				<font size="4" face="arial"><b>DEBIT NOTE</b></font>
				<p>
				<table width=100% align="center" border="0" cellPadding="0" cellSpacing="0">
					<tr>
						<td width=24% height=100%>
							<table width=100% align="left" border="1" height=100%  bordercolor="" cellPadding="0" cellSpacing="0">
								<tr>
									<td valign="top" class="tablespace padding-5p">
										<span class="normal bold">
											<font class="bold" face="arial" size="2"> ${object1.accountHeadCode} ,</font><br>
											<font  face="arial" size="2">${object1.payerAddress}</font><br><br>									
											
											<%-- <font class="" face="arial" size="2"> Email: ${object1.companyEmail}</font> --%>
											<!-- companyName, company address, phoneno, fax -->
										</span>
									</td>
								</tr>
							</table>
						</td>
						<td width=2% height=100%><br>
						</td>
						<td width=24% height=100%>
							<table width=100% align="left" border="1" height=100%  bordercolor="" cellPadding="0" cellSpacing="0">
								<tr>
									
									<td valign="top" class="padding-left-5"><span class="normal">
										<b>Debit Note No :  ${object1.debitNoteNo}<br>
										Date : ${object1.debitNoteDate}<br>
										Reference. No : ${object1.invoiceNo}<br>
										Job Order No : ${object1.jobOrder}<br>	
										  <c:if test="${vesselVoyageWithInvoiceNo.vesselvoyagelist.size() < 2 }" >										
									 <c:forEach	var="obkk" items="${vesselVoyageWithInvoiceNo.vesselvoyagelist}">						    
										Job Order No. : ${obkk.vesselName}<br> 
									    Mode : ${obkk.voyage}<br><br>
									    </c:forEach>
									    </c:if>
									    <c:if test="${vesselVoyageWithInvoiceNo.vesselvoyagelist.size() >1 }" >
								    	Job Order No. :  <br> 
									    Mode : <br> 
									    </c:if>
									   <!--  &nbsp;BL No. :  BL No
									    	&nbsp;Sailing Date :&nbsp; Fetch slDate - sailing date<br>
									    	&nbsp;Exchange Rate :&nbsp; fetch exchange Rate  -->
										</b></span>
									</td>							
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="3"><br>
						</td>                  
					</tr>
					<tr>
						<td colspan="4">
							<table class="table table-striped b-t b-light" align="left" border="1"  bordercolor="" cellPadding="0" cellSpacing="0" width=100%>
								<thead>					
									<tr  border="1">
										<th width=20% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>Charge Head</b></span></th>
										<TD width=15% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>Sac No</b></span></td>
								<th width=8% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>Exchange Rate</b></span></th>
								<th width=10% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>Currency</b></span></th>
								<th width=10% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>CGST%</b></span></th>
								<th width=12% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>CGST AMOUNT</b></span></th>
								<th width=10% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>SGST %</b></span></th>
								<th width=12% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>SGST AMOUNT</b></span></th>
								<th width=10% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>IGST %</b></span></th>
								<th width=12% height=10 valign=top  align="center" style="border-right: 0pt;"><span class=normal><b>IGST AMOUNT</b></span></th>
								<!-- <th align=center width=15% height=10 align="center" valign=top  style="border-right: 0pt;"><span class=normal><b> AMOUNT (INR)</b></span></th> -->
								<th align=center width=15% height=10 align="center" valign=top style="border-right: 0pt;"><span class=normal><b>AMOUNT </b></span></th>
										
									</tr>
								</thead>
								<tbody>
									
									<%-- <c:forEach var="ob" items="${debitNodeList.debittables}" varStatus="status" > 
										<tr class="description">
											<td class=" width_50" align="left" valign="top" height="10"  style="border-right: 0pt;">
												<span class=normal>
												<font face="arial" size="2"> Sub Group Code:- ${ob.subGroupCode}  </font><br>
												<font class="bold" face="arial" size="2">${ob.subGroupName}</font><br>									
												<font face="arial" size="2"> Account Code:- ${ob.drdtlAccountHead}</font><br>
												<font class="bold" face="arial" size="2">${ob.accountHeadName}</font><br>
												<font class="bold" face="arial" size="2"> Narration:- ${ob.dtlNarration}</font>
												<c:forEach var="obb" items="${vesselVoyageWithInvoiceNo.vesselvoyagelist[status.index]}">
												<font class="bold" face="arial" size="2"> Mode:- ${vesselVoyageWithInvoiceNo.vesselvoyagelist[status.index].vesselName} </font>
												<font class="bold" face="arial" size="2"> Job Order No.:- ${vesselVoyageWithInvoiceNo.vesselvoyagelist[status.index].voyage}</font>
												</c:forEach>
												</span>
											</td>
											
											<td class="subcolor width_20 text-wrap" align="left"  valign="top" nowrap="nowrap">
												<font class="bold" face="arial" size="2">${ob.subAcctName}</font>
											</td>
											
				
											<td class="subcolor width_25" align="right" height="10" nowrap="nowrap"  style="border-right: 0pt;">
											<span class="normal"> 
											${ob.tcAmount} 
											</span></td>
											<td class="subcolor width_25" align="right" height="10" nowrap="nowrap" style="border-right: 0pt;"><span class="normal"> 
											${ob.bcAmount} 
											</span></td>
										</tr>
										<tr class="description blank_row">
								            <td bgcolor="#FFFFFF" colspan="" height="10"  style="border-right: 0pt;">&nbsp;</td>
								            <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td>
								            <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td>
								    	</tr>
									</c:forEach> --%>
									
									<c:forEach var="ob"  items="${debitNodeList.debittables}" varStatus="i"> 
								<tr >					 					
					 					<td width="20%" align="left" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.drdtlAccountHead}"/></font></td> 
					 					<td width="15%" align="left" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.sacNO}"/></font></td>
					 					<td width="8%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.exchangeRate}"/></font></td>
					 					<td width="10%" align="left" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.currency}"/></font></td>
					 					<td width="10%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.cgstPrct}"/></font></td>
					 					<td width="12%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.cgstamt}" /></font>
					 					</td>
					 					<td width="10%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.sgstPrct}"/></font></td>
					 					<td width="12%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.sgstamt}" /></font>
					 					</td>
					 					<td width="10%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><c:out value="${ob.igstPrct}"/></font></td>
					 					<td width="12%" align="right" valign=top  style="border-right: 0pt;"><font face="arial" size="1" color="black"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.igstamt}" /></font>
					 					</td> 
					 					<%-- <td width="15%" align="right" valign=top  style="border-right: 0pt;"><c:out value="${ob.tcamount}"/></td>  --%>
					 					<td width="12%" align="right" valign=top  ><font face="arial" size="1" color="black"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.bcamount}" /></font></td> 					       				
				               		</tr>
				   					
				   					
				   					
				             
			               		</c:forEach>
			               		<tr>	
		        					<td style="border-right: 0pt;"><font face="arial" size="1" color="black"><B>Total</B></font></td>
									<td style="border-right: 0pt;"></td> 
									<td style="border-right: 0pt;"></td>        				
		        				<td style="border-right: 0pt;"></td>
		        				<td style="border-right: 0pt;"></td>
		        				<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;">
		        				<font face="arial" size="1" color="black"><B><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${debitNodeList.debittables[0].totalcgstAmt}" /></B></font>
		        				
		        				<td style="border-right: 0pt;"></td>
		        				<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;">
		        				<font face="arial" size="1" color="black"><B><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${debitNodeList.debittables[0].totalgstAmt}" /></B></font>
		        				
										 </td>
		        				<td style="border-right: 0pt;"></td>
		        				<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;">
		        				<font face="arial" size="1" color="black"><B><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${debitNodeList.debittables[0].totaligstAmt}" /></B></font>
		        				
										 </td>							
									
									<td width="15%" height="10" align="right" valign="top" >
										<font face="arial" size="1" color="black"><B><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.totalBCAmount+debitNodeList.debittables[0].totalcgstAmt+debitNodeList.debittables[0].totalgstAmt+debitNodeList.debittables[0].totaligstAmt}" /></B></font>
										</td>									
								</tr>
			               		<%-- <tr>	
		        					<td><b>Total</b></td>
									<td></td>        				
		        				<td></td>
		        				<td></td>
		        				<td></td>
		        				<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;"><span class=normal><b>
										 ${debitNodeList.debittables[0].totalcgstAmt}</b></span></td>
		        				<td></td>
		        				<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;"><span class=normal><b>
										 ${debitNodeList.debittables[0].totalgstAmt}</b></span></td>
		        				<td></td>
		        				<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;"><span class=normal><b>
										 ${debitNodeList.debittables[0].totaligstAmt}</b></span></td>							
									<td width="15%" height="10" align="right" valign="top" style="border-right: 0pt;"><span class=normal><b>
										 ${object1.totalTCAmount}</b></span></td>
									<td width="15%" height="10" align="right" valign="top">
										<span class=normal><b>${object1.totalBCAmount}</b></span></td>									
								</tr> --%>
									
															
										<%-- <tr>
											<td class="width_50" align="right" valign="top" style="border-right: 0pt;">
											</td>											
											<td class="width_25" align="right" style="border-right: 0pt;">
												<span class="normal"><b><!-- total TC Amount -->
												${object1.totalTCAmount}</b></span>
											</td>
											<td class="width_25" align="right">
												<span class="normal"> <b> <!-- total BC Amount (USD) -->  
												${object1.totalBCAmount}</b></span></td>
										</tr> --%>
								</tbody>		
							</table>					
						</td>
					</tr>
				</table>
				
				</td>
			</tr>
			<tr>
			<%-- <td align=left><span class=normal> 				
				<c:out value="Amount In Words:${object1.totalBCAmountInWords}"/><br>
				
				</span></td> --%>
		</tr>
		<br>
		<br>
		<tr>
			<td align="left" class="tablespace">
				<span class="normal"><br>
					<font style="font-style: arial;"><b>Amount In Words:${object1.totalBCAmountInWords}<br><br>
					</b></font>
					
				</span></td>
														
		</tr>
		<tr>
			<td align="left" class="tablespace">
				<span class="normal"><br>
					<font style="font-style: arial;"><b>MBK<br><br>
					</b></font>
					<font style="font-style: arial;"><b>${object1.createdUser}<br><br>
					</b></font>
				</span></td>
														
		</tr>
			<!-- <tr>
				<td align="left" class="tablespace">
					<span class="normal"><br>
						<font style="font-style: italic;"><b>Note:<br>
						IN CASE OF ANY DISCREPANCIES, PLEASE NOTIFY WITHIN 10 DAYS FROM THE DATE OF RECEIPT</b></font>
					</span></td>
			</tr> -->
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
								
								
								<c:when test="${payercountry == clocationName3}">
												<c:choose>
													<c:when test="${object1.sectorCode=='WEX'}">
														<TR>
															<td><span class=normal>&nbsp;&nbsp;XXXXXXXXXXXXX<br>
															        &nbsp;&nbsp;Bank Name: XXXXXXXXXXXXX<br>
																	&nbsp;&nbsp;Bank Details for MYR: XXXXXXXXXXXXX<BR>
																	&nbsp;&nbsp;Swift Code: XXXXXXXXXXXXX
															</span></td>
														</tr>
													</c:when>
													<c:otherwise>
														<TR>
															<td width="100%"><span class=normal>
																<!-- 	<span style="text-decoration: underline;"><b>XXXXXXXXXXXXX</b></span><BR>
																	Company Name :  PARAGON DYNAMICS INFO SYSTEMS (P) LTD (M) SDN BHD<BR> 
																	Bank Name : HSBC BANK MALAYSIA BERHAD<BR>
																	Bank Account : 355-268137-101<BR>
																	Swift Code : HBMBMYKL<BR><BR><BR> 
																	<span style="text-decoration: underline;"><b>USD Account</b></span><BR>
																	Company Name :  PARAGON DYNAMICS INFO SYSTEMS (P) LTD (M) SDN BHD<BR> 
																	Bank Name : HSBC BANK MALAYSIA BERHAD<BR>
																	Bank Account : 355-268137-725<BR> 
																	Swift Code : HBMBMYKL<BR>     
															</span>-->
															<span style="text-decoration: underline;"><b>Details:</b></span><BR>
																	Company Name :  ${object1.companyName}<BR> 
																	Bank Name    :${object1.companyName}<BR> 
																	Bank Account : ${object1.accountHeadCode}<BR>
																	   
															</span>
															</td>
														</tr>
													</c:otherwise>
												</c:choose>
												</c:when>
								
								
								
								
								
								
								
								
								
								
								
								
									<c:when test="${object1.companyLocation ==  'INDIA'}">
										<TR>
											<td width="100%"><span class=normal>XXXXXXXXXXXXXXX
													<BR> &nbsp;&nbsp;BRANCH : XXXXXXXXXXXXXXX<BR>
													&nbsp;&nbsp;BRANCH ADDRESS :XXXXXXXX<BR> &nbsp;&nbsp;A/C No : XXXXXXXXXXXX <BR>
													&nbsp;&nbsp;NEFT / RTGS / IFSC CODE : XXXXXXXXXXXXXXXXX<BR>
													&nbsp;&nbsp;MICR CODE : XXXXXXXXXXXXXXX<BR>
													&nbsp;&nbsp;BENEFICIARY : XXXXXXXXXXXXXXXXX<BR>
											</span></td>
										</tr>
									</c:when>
									<c:when test="${object1.companyLocation ==  'SRILANKA'}">
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
									<c:when test="${object1.companyLocation== 'DUBAI'}">
										<TR>
											<td width="100%"><span class=normal>
													Bene Name: PARAGON DYNAMICS INFO SYSTEMS (P) LTD<BR>
													Bene Bank: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX<BR>
													Swift Code: XXXXXXXXXXXXXXX<BR><BR><BR>
													<span style="text-decoration: underline;"><b>For USD Remittance:</b></span><BR>
													USD Acct.Num:  XXXXXXXXXXXXXXXXXX<BR> 
													IBAN (USD Acct): XXXXXXXXXXXXXXXXXXXXXXXX<BR>
													Intermediary Bank:  XXXXXXXXXXXXXXXXXX<BR>
													Swift Code: XXXXXXXXXXXX<BR><BR><BR> 
													<span style="text-decoration: underline;"><b>For AED Remittance:</b></span><BR>
													AED Acct. Num.: XXXXXXXXXXXXXXXXXXXXXX<BR> 
													IBAN (AED Acct): XXXXXXXXXXXXXXXXXXXXX.<BR>   
											</span></td>
										</tr>

									</c:when>
									
									<c:when
										test="${object1.companyLocation =='SINGAPORE'}">
										<TR>
											<td><span class=normal> &nbsp;&nbsp;XXXXXXXXXXXXX<br>
													&nbsp;&nbsp;SWIFT CODE XXXXXXXXXXXXX<BR>
													&nbsp;&nbsp;USD Current A/C :XXXXXXXXXXXXX<BR>
													&nbsp;&nbsp;SGD CURRENT A/C :XXXXXXXXXXXXXX
											</span></td>

										</tr>
									</c:when>
									
									<c:otherwise>
										<TR>
											<td width="100%"><span class=normal>
													Bene Name: PARAGON DYNAMICS INFO SYSTEMS (P) LTD<BR>
													Bene Bank: XXXXXXXXXXXXXXXXXXXXXXX<BR>
													Swift Code: XXXXXXXXXXXXXXXXX<BR><BR><BR>
													<span style="text-decoration: underline;"><b>For USD Remittance:</b></span><BR>
													USD Acct.Num:  XXXXXXXXXXXXXXX<BR> 
													IBAN (USD Acct): XXXXXXXXXXXXXXXXXXXXXX<BR>
													Intermediary Bank:  XXXXXXXXXXXXXXXXXXXXXXXXXX<BR>
													Swift Code: XXXXXXXXXXXXX<BR><BR><BR> 
													<span style="text-decoration: underline;"><b>For AED Remittance:</b></span><BR>
													AED Acct. Num.: XXXXXXXXXXXXXXXX<BR> 
													IBAN (AED Acct): XXXXXXXXXXXXXXXXXXXXX.<BR>   
											</span></td>
										</tr>

									</c:otherwise>
								</c:choose>
							</table>
						</td>
						<td>
							<table border=0 cellPadding=2 cellSpacing=0 class="width_100">
							<c:choose>
							<c:when	test="${object1.companyLocation =='SINGAPORE'}">
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
												<td class="bold text_right">MBK</td>
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
	<br><br><br><br><br><br><br><br>
<%-- 	<table border="1" width="90%" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="#cccccc" align=center>
		<tr>
			<td class="gridheadercell" colspan="13">CONTAINERS DETAILS</td>
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
			<td class="gridheadercell">Slot Loss</td>
		</tr>
		<c:set var="index" value="0"></c:set>
		<%
			int i = 1;
		%>
		<c:forEach var="slotmessageList" items="${containerList}">
			<tr>
				<td class="tablespace"><span class=normal><%=i++%></span></td>
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
				<td class="tablespace"><span class=normal>${slotmessageList.slotloss}</span></td>
			</tr>
		</c:forEach>
	</table> --%>
			
	</body>
</html>
