<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<style>
.description, .description td {
	border-bottom: 1pt solid #fff;
	border-top: 1pt solid #fff;
}

.description1, .description1 td {
	border-bottom: 0px solid #fff;
}
/*  tr,td {
}
 */
.blterms {
	font-family: Bookman OLD style;
	font-size: 5px;
	font-weight: bold;
	font: normal;
	font-style: normal;
	text-align: justify;
	width: 30%;
}

.note_hdr {
	font-style: italic;
	font-weight: bold;
	font-size: 12px;
	font-family: arial;
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

.blprint {
	vertical-align: top;
	font-family: verdana;
	font-size: 11px;
	font-weight: bold;
}

.blprint1 {
	font-family: verdana;
	font-size: 10px;
	line-height: 1.5;
	text-align: justify;
}

.text_center {
	text-align: center
}

.text_right {
	text-align: right
}

.text_left {
	text-align: left
}

.width_100 {
	width: 100%;
}

.width_90 {
	width: 90%;
}

.width_95 {
	width: 95%;
}

.width_70 {
	width: 70%;
}

.width_50 {
	width: 50%;
}

.width_40 {
	width: 40%;
}

.width_30 {
	width: 30%;
}

.width_25 {
	width: 25%;
}

.width_15 {
	width: 15%;
}

.text_decoration {
	text-decoration: underline
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

@page {
	size: A4 portrait; /* auto is the initial value */
	margin: 2mm; /* this affects the margin in the printer settings */
}

.normal {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	text-decoration: none
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

.footer {
	width: 100%;
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
.padding-bottom-15p{
padding-bottom: 15px;
}
.padding-bottom-20p{
padding-bottom: 20px;
}
.padding-left-5p{
padding-left: 5px;
}
.padding-5p{
	padding: 5px
}
.custom-color-1 .table-striped>thead>tr>th {
	color: #fff;
	border-bottom: 1px solid rgba(255, 255, 225, .15);
	border-left: 1px solid rgba(255, 255, 225, .15);
	border-top: 1px solid rgba(255, 255, 225, .15);
	background: #42a5f5 !important;
}
.padding-left-0{
 padding-left: 0px !important;
}
.padding-top-5{
 	padding-top: 5px !important;
}
@media print
{
.break_page {page-break-after:always}
}
 
</style>
<style type="text/css" media="print">
      html, body { margin: 0; padding: 0; }
      /* body { height: 11in;  width: 8.5in; } */
       a[href]:after {
	    content: " (" attr(href) ")";
	 }
	 /*  #footer {
	  display: table-footer-group;
    width:100%;        
    position:absolute;

    bottom:0; }  */
    #content{
    	position:absolute;
    	top:0;
    }
    .break_page {page-break-before:always}
</style>
</head>
<body marginheight="0" marginwidth="0" topmargin="0" leftmargin="0" style="background-color: white">
 <c:forEach var="mainObject" items="${printBulkInvoiceList.lBulkInvBean}" varStatus="theCount">
 <div class="break_page">
	<c:set var="object1" value="${mainObject.invoice}" /> <!-- masterList -->
	<c:set var="billofladingobject" value="${mainObject.printBLList}" /><!-- billoflading -->
	<c:set var="payerForIndia" value="${mainObject.payerForIndiaBankDetails}" /> <!-- payerIndia -->

	<c:set var="locationName" scope="session" value="DUBAI" />
	<c:set var="locationName1" scope="session" value="SINGAPORE" />
	<c:set var="locationName2" scope="session" value="AMERICA" />
	<c:set var="locationName3" scope="session" value="MUMBAI" />

	<c:set var="clocationName" scope="session" value="C0001" />
	<c:set var="clocationName1" scope="session" value="C0002" />
	<c:set var="clocationName2" scope="session" value="C0003" />
	<c:set var="clocationName3" scope="session" value="C0004" />
	<c:set var="clocationName5" scope="session" value="C0005" />
	<c:set var="clocationName6" scope="session" value="C0007" />	
	
	<table align=center border=0 cellPadding=0 cellSpacing=0 width="95%" height="95%">
		<tr>
			<td>
				<table border="0" width="100%" cellpadding="0" cellspacing="0"
					bgcolor="FFFFFF" bordercolor="#cccccc" align=center>
					<tr>
						<td>
						<%--<c:choose>
						 <c:when test="${locationName1 == object1.locationName}">
							<img src="/img/sfpl_logo_232x55.jpg">															
							</c:when>	
						 <c:when test="${payerForIndia ==  clocationName6}">
							<img src="/img/sfpl_logo_226x57.jpg">
							</c:when>
							<c:when test="${payerForIndia ==  clocationName2}">
							<img src="/img/sfpl_logo_232x55.jpg">
							</c:when>
							<c:when test="${payerForIndia ==  clocationName}">
							<img src="/img/sfpl_logo_315x54.jpg">
							</c:when>
							<c:otherwise> --%>
												
						<c:if test="${locationName == object1.locationName}">
								<img src="/img/sfpl_logo_315x54.jpg">
							</c:if> <c:if test="${locationName1 == object1.locationName}">
								<img src="/img/sfpl_logo_232x55.jpg">
							</c:if> <c:if test="${locationName2 == object1.locationName}">
								<img src="/img/America_logo.jpg">
							</c:if> <c:if test="${locationName3 == object1.locationName}">
								<img src="/img/sfpl_logo_226x50.jpg">
							</c:if>
												<%-- </c:otherwise> 
												</c:choose>--%>
						
						</td>
					</tr>
				</table> 
				<font face="arial" size="4"><b>INVOICE</b></font>
				<table class="width_100" align="center" border="0" cellPadding="0" cellSpacing="0">
					<tr>
						<td></td>
					</tr>
					<TR>
						<TD width=24%>

							<TABLE align=left border=1 cellPadding=2 cellSpacing=0 width=100%
								style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
								<TR>

									<TD align=left><span class="normal"><b>${object1.agent}<br>
												${object1.address1} <br> ${object1.address2} <br>
												<%-- Fax No :${object1.faxno}<br> --%> Tel
												No:${object1.officeTelephone} <br><br>
										</b></span>
										<span class="normal"><b>Shipment Terms : </b></span>
										<c:if test="${billofladingobject.shipment != null && billofladingobject.shipment != 'null' && billofladingobject.shipment != ''}">
												<span class=normal><b>${billofladingobject.shipment}</b></span>
												</c:if>
												<c:if test="${billofladingobject.shipment == null || billofladingobject.shipment == 'null' || billofladingobject.shipment == ''}">
												<span class=normal ><b>FI/FO</b></span>
												</c:if>
												<c:if test="${billofladingobject.creditDays != null && billofladingobject.creditDays != ''}"><br>
												<span class=normal ><b>Business Terms : </b></span>
													<c:if test="${object1.locationName != 'SINGAPORE'}">
														<span class=normal ><b>${billofladingobject.creditDays} days</b></span>
													</c:if>
												</c:if>
										</td>

								</tr>
							</table>
						</td>

						<TD width=2%>&nbsp;</td>

						<TD width=24% height=100%>
							<TABLE align=left border=1 cellPadding=2 cellSpacing=0 width=100%
								height=100%
								style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
								<TR>


									<TD align=left height=100%>
										<table width=100% border=0 cellspacing=0 cellpadding=0
											height=100%
											style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
											
											<tr>
												<td width=25% align=left><span class=bold>Customer</span></td>
												<td><span class=bold>: ${object1.customer}</span></td>
											</tr>
											<tr>
												<td width=25% align=left><span class=bold>Inv.
														No</span></td>
												<td><span class=bold>: ${object1.invoiceno}</span></td>
											</tr>
											<tr>
												<td width=25% align=left><span class=bold>Inv.
														Date</span></td>
												<td><span class=bold>: ${object1.invoiceDate} </span></td>
											</tr>
											<tr>
												<td width=25% align=left><span class=bold>Vessel</span></td>
												<td><span class=bold>: ${object1.vessel}</span>
											</tr>
											<tr>
												<td width=25% align=left><span class=bold>Voyage</span></td>
												<td><span class=bold>: ${object1.voyage} </span>
											</tr>

											<tr>
												<td width=25% align=left><span class=bold>Sailing
														Date</span></td>
												<td><span class=bold>: ${object1.sailingdate}</span></td>
											</tr>
											<tr>
												<td width=25% align=left><span class=bold>B/L No</span></td>
												<td><span class=bold>: ${object1.blno}</span></td>
											</tr>
											<tr>
												<td width=25% align=left><span class=bold>WO No</span></td>
												<td><span class=bold>: ${object1.woNo}</span></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="3"></td>
					</tr>			
					<tr>
						<td  class="padding-top-5" colspan="3" valign="top">	
							<table align="left" border="1" cellPadding=2 cellSpacing=0 width="100%" style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
								<thead>
									<tr>
										<th class="width_70"  height="10" valign=top><span class=normal><b>Description
													of Charges</b></span></th>
										<th class="width_15" align=center class="" height="10" valign=top style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
											class=normal><b>Amount - US$</b></span></th>
										<th class="width_15" align=center class="" height="10" valign=top><span
											class=normal><b>Amount ${object1.currency} </b></span></th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="ob" items="${mainObject.searchList}"> <!-- /middleList -->
									<c:if test="${ ob.amountusd > 0 }">
										<tr class="description">
											<td class="width_60" height="10" align=left valign="top" style="border-right: 0pt;"><span
												class=normal> <b><c:out value="${ob.accountHead}" />
														<c:if test="${ob.pol != null}">
															<c:out value="${ob.pol}-${ob.pod}" />
														</c:if></b><br> <c:out value="${ob.voyageIdwithhdr}" />
											</span></td>
											<td  class="width_15 normal" height="10"  style="border-right: 0pt;" align=right valign="top">
												<c:out value="${ob.amountusd}" /></td>
											<td  class="width_15 normal" height="10" align=right valign="top"><c:out
													value="${ob.amountaed}" /></td>
										</tr>
									</c:if>
								</c:forEach>
									<tr class="description">
										<td class="width_70 normal" height="200" align="left" valign="top" style="border-right: 0pt;"><span class="normal">&nbsp;</span> </td>
										<td class="width_15 normal" height="200" align="left" valign="top" style="border-right: 0pt;"><span class="normal">&nbsp;</span> </td>
										<td class="width_15 normal" height="200" align="left" valign="top"><span class="normal">&nbsp;</span> </td>	
									</tr>	
								</tbody>
								<tfoot>
								<tr height=10>
									<td class="width_70" align=left class="width_70" valign=top><span
										class=normal><b> Exchange Rate:
												${object1.exchangeRate}
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total </b></span></td>

									<td class="width_15" class="width_15" align=right valign=top
										style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
										class=normal><b> ${object1.strTotalUSD}</b></span></td>
									<td class="width_70" align=right valign=top><span
										class=normal><b> ${object1.strTotalAED} </b></span></td>
								</tr>
								
								
								
								<c:if test="${'Y' == object1.sector}">
								<tr height=10>
									<td class="width_70" align=left class="width_70" valign=top><span
										class=normal><b>*GST Payable@ 6%</b></span></td>

									<td class="width_15" class="width_15" align=right valign=top
										style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
										class=normal><b>  <%-- ${(object1.strTotalUSD * 6)/100} --%>
										<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${(object1.strTotalUSD * 6)/100}" />
										<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
										 ${totalBC} --%>
										</b></span></td>
									<td class="width_70" align=right valign=top><span
										class=normal><b> <%-- ${(object1.strTotalAED * 6)/100} --%>
										<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${(object1.strTotalAED * 6)/100}" />
										<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
										 ${totalTC} --%>
										</b></span></td>
								</tr>
								</c:if>
								
								
								<!-- Tax -->
								
                               <c:if test="${'Y' == object1.sTax}">
								<tr height=10>
									<td class="width_70" align=left class="width_70" valign=top><span
										class=normal><b>*Service Tax Payable@ 4.20%</b></span></td>

									<td class="width_15" class="width_15" align=right valign=top
										style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
										class=normal><b>  ${object1.sTaxAmountUsd}
										<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
										 ${totalBC} --%>
										</b></span></td>
									<td class="width_70" align=right valign=top><span
										class=normal><b> ${object1.sTaxAmount}
										<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
										 ${totalTC} --%>
										</b></span></td>
								</tr>
								
								<tr height=10>
									<td class="width_70" align=left class="width_70" valign=top><span
										class=normal><b>*SBC Tax Payable@ 0.15%</b></span></td>

									<td class="width_15" class="width_15" align=right valign=top
										style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
										class=normal><b>  ${object1.sbcTaxAmountUsd}
										<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
										 ${totalBC} --%>
										</b></span></td>
									<td class="width_70" align=right valign=top><span
										class=normal><b> ${object1.sbcTaxAmount}
										<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
										 ${totalTC} --%>
										</b></span></td>
								</tr>
								
								<tr height=10>
									<td class="width_70" align=left class="width_70" valign=top><span
										class=normal><b>*KKC Tax Payable@ 0.15%</b></span></td>

									<td class="width_15" class="width_15" align=right valign=top
										style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
										class=normal><b>  ${object1.kkcTaxAmountUsd}
										<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
										 ${totalBC} --%>
										</b></span></td>
									<td class="width_70" align=right valign=top><span
										class=normal><b> ${object1.kkcTaxAmount}
										<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
										 ${totalTC} --%>
										</b></span></td>
								</tr>
								</c:if>
																
								
								<!-- Tax End -->
								
																
								
								
								<c:if test="${'C0023' == object1.payerCountryId}">
									<c:if test="${'Y' != object1.sector}">
										<tr height=10>
											<td class="width_70" align=left class="width_70" valign=top><span
												class=normal><b>Zero Rated  GST@ 6%</b></span></td>
		
											<td class="width_15" class="width_15" align=right valign=top
												style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
												class=normal><b> 0
												<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
												 ${totalBC} --%>
												</b></span></td>
											<td class="width_70" align=right valign=top><span
												class=normal><b> 0 
												<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
												 ${totalTC} --%>
												</b></span></td>
										</tr>
										<tr height=10>
										<td class="width_70" align=left class="width_70" valign=top><span
											class=normal><b>Total After GST</b></span></td>
										<td class="width_15" class="width_15" align=right valign=top
											style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
											class=normal><b> <%-- ${object1.strTotalUSD + object1.sTaxAmountUsd + object1.sbcTaxAmountUsd + object1.kkcTaxAmountUsd} --%>
											<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.strTotalUSD}" />
											<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
											 ${totalBC} --%>
											</b></span></td>
										<td class="width_70" align=right valign=top><span
											class=normal><b><%--  ${object1.strTotalAED + object1.sTaxAmount + object1.sbcTaxAmount + object1.kkcTaxAmount}  --%>
											<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.strTotalAED}" />
											<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
											 ${totalTC} --%>
											</b></span></td>
									
										</tr>
									</c:if>			
									<c:if test="${'Y' == object1.sector}">
										<tr height=10>
											<td class="width_70" align=left class="width_70" valign=top><span
												class=normal><b>Total After GST</b></span></td>
											<td class="width_15" class="width_15" align=right valign=top
												style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
												class=normal><b> <%-- ${object1.strTotalUSD + object1.sTaxAmountUsd + object1.sbcTaxAmountUsd + object1.kkcTaxAmountUsd} --%>
												<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.strTotalUSD + object1.sTaxAmountUsd + object1.sbcTaxAmountUsd + object1.kkcTaxAmountUsd + ((object1.strTotalUSD * 6)/100)}" />
												<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
												 ${totalBC} --%>
												</b></span></td>
											<td class="width_70" align=right valign=top><span
												class=normal><b><%--  ${object1.strTotalAED + object1.sTaxAmount + object1.sbcTaxAmount + object1.kkcTaxAmount}  --%>
												<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.strTotalAED + object1.sTaxAmount + object1.sbcTaxAmount + object1.kkcTaxAmount + ((object1.strTotalAED * 6)/100)}" />
												<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
												 ${totalTC} --%>
												</b></span></td>
											
										</tr>
									</c:if>					
								</c:if>
								
								
								<c:if test="${'C0023' != object1.payerCountryId}">
									<c:if test="${'Y' == object1.sector}">
										<tr height=10>
											<td class="width_70" align=left class="width_70" valign=top><span
												class=normal><b>Total After GST</b></span></td>
											<td class="width_15" class="width_15" align=right valign=top
												style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
												class=normal><b> <%-- ${object1.strTotalUSD + object1.sTaxAmountUsd + object1.sbcTaxAmountUsd + object1.kkcTaxAmountUsd} --%>
												<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.strTotalUSD + object1.sTaxAmountUsd + object1.sbcTaxAmountUsd + object1.kkcTaxAmountUsd + ((object1.strTotalUSD * 6)/100)}" />
												<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
												 ${totalBC} --%>
												</b></span></td>
											<td class="width_70" align=right valign=top><span
												class=normal><b><%--  ${object1.strTotalAED + object1.sTaxAmount + object1.sbcTaxAmount + object1.kkcTaxAmount}  --%>
												<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.strTotalAED + object1.sTaxAmount + object1.sbcTaxAmount + object1.kkcTaxAmount + ((object1.strTotalAED * 6)/100)}" />
												<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
												 ${totalTC} --%>
												</b></span></td>
											
										</tr>
									</c:if>
								</c:if>
								
								
								
								<c:if test="${'Y' == object1.sector}">
									<tr height=10>
										<td class="width_70" align=left class="width_70" valign=top><span
											class=normal><b>Total Amount Payable</b></span></td>
	
										<td class="width_15" class="width_15" align=right valign=top
											style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
											class=normal><b> <%-- ${object1.strTotalUSD + ((object1.strTotalUSD * 6)/100)} --%>
											<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.strTotalUSD + ((object1.strTotalUSD * 6)/100)}" /> 
											<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
											 ${totalBC} --%>
											</b></span></td>
										<td class="width_70" align=right valign=top><span
											class=normal><b> <%-- ${object1.strTotalAED + ((object1.strTotalAED * 6)/100)} --%>
											<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${object1.strTotalAED + ((object1.strTotalAED * 6)/100)}" /> 
											<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
											 ${totalTC} --%>
											</b></span></td>
									</tr>								
								</c:if>				
								
								<c:if test="${'Y' == object1.sTax}">
									<tr height=10>
										<td class="width_70" align=left class="width_70" valign=top><span
											class=normal><b>Total Amount Payable</b></span></td>
	
										<td class="width_15" class="width_15" align=right valign=top
											style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
											class=normal><b> ${object1.payTotalAmountUsd}
											<%-- <fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
											 ${totalBC} --%>
											</b></span></td>
										<td class="width_70" align=right valign=top><span
											class=normal><b> ${object1.payTotalAmount} 
											<%-- <fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
											 ${totalTC} --%>
											</b></span></td>
									</tr>
								</c:if>	
								
								
								
								
								
								</tfoot>
							</table>
						</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td>
				<table align=center border=0 cellPadding=0 cellSpacing=0 class="width_95">
					<tr>
						<td><span class=normal><b>E &amp;O.E.</b> <br> <c:out
									value="${object1.usdwords}" /><br> <c:out
									value="${object1.aedwords}" /> </span></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table align=center border=0 cellPadding=0 cellSpacing=0
					class="width_95">
					<tr>
						<td align=left><br> <span class="note_hdr">Note:- <c:if test="${object1.checkGSTDate != 'Y'}">1.</c:if>
								In case of any discrepancies, please notify within 10 days from
					   date of receipt</span></td>
					</tr>
				</table>
			</td>
		</tr>
		
		<c:if test="${object1.checkGSTDate != 'Y'}">
			<!-- INMRM|INKAT|INIXE|INKRI|INCCU|INHZA|INPAV|INMAA|INTUT|INVTZ|INCOK|INAMD|INBLR|JNPT|ADANI|MICT|GTI|KPCT|INGOA -->
			<c:if test="${(object1.podChk == 'INMRM' || object1.podChk == 'INKAT' || object1.podChk == 'INIXE' || object1.podChk == 'INKRI' || object1.podChk == 'INCCU' || object1.podChk == 'INHZA' || object1.podChk == 'INPAV' || object1.podChk == 'INMAA' || object1.podChk == 'INTUT' || object1.podChk == 'INVTZ' || object1.podChk == 'INCOK' || object1.podChk == 'INAMD' || object1.podChk == 'INBLR' || object1.podChk == 'JNPT' || object1.podChk == 'ADANI' || object1.podChk == 'MICT' || object1.podChk == 'GTI' || object1.podChk == 'KPCT' || object1.podChk == 'INGOA') && (object1.sTaxAmount == null || object1.sTaxAmount == '' || object1.sTaxAmountUsd == null || object1.sTaxAmountUsd == '')}">
			<tr>
				<td>
					<table align=center border=0 cellPadding=0 cellSpacing=0
						class="width_95">
						<tr>
							<td align=left><br> <span class="note_hdr">Note:- 2.
									"With reference to Service tax notification  1/2/3-2017-Service tax,  dated 12  January  2017. Non Payment of Service tax liability @4.5% applicable on Import  freights including interest, penalty, if any will be solely borne by the customer  or by their authorized Agents in India under their registered Indian service tax".</span></td>
						</tr>
					</table>
				</td>
			</tr>
			</c:if>
		</c:if>
		
		<tr>
			<td><br> <br>
				<table align=center border=0 cellPadding=0 cellSpacing=0 class="width_95"
					style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
					<tr>
						<td><span class=normal class="text_decoration"><b>
									&nbsp;Bank Details :<br>
							</b></span></td>
					</tr>
					<tr>
						<td valign=top>
							<table border=0 cellPadding=0 cellSpacing=0 class="width_100"
								style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">
								<tr>
									<td>
										<table align=left border=1 cellPadding=0 cellSpacing=0
											class="width_100" height=100%
											style="border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;">

											<c:choose>
												<c:when test="${(object1.vessel == 'BMS LIBRA' || object1.vessel == 'BMS VIRGO') && object1.sectorCode=='WEX'}">
													<TR>
														<td><span class=normal>&nbsp;&nbsp;XXXXXXXXXXXXX<br>
														        &nbsp;&nbsp;Bank Name: XXXXXXXXXXXXX<br>
																&nbsp;&nbsp;Bank Details for MYR: XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;Swift Code: XXXXXXXXXXXXX
														</span></td>

													</tr>
												</c:when>
												
												
												
												
												
												
												
												
												
												
												
												
												
												
												
												<%-- <c:when test="${(object1.vessel == 'BMS LIBRA' || object1.vessel == 'BMS VIRGO') && object1.sectorCode!='WEX'}">
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
												</c:when> --%>
												
												<c:when test="${payerForIndia ==  clocationName1}">
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
												<c:when test="${payerForIndia ==  clocationName6}">
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
												<c:when test="${payerForIndia ==  clocationName2}">
												 
													<TR>
														<td><span class=normal> &nbsp;&nbsp;XXXXXXXXXXXXX<br>
																&nbsp;&nbsp;SWIFT CODE XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;USD Current A/C :XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;SGD CURRENT A/C :XXXXXXXXXXXXX
														</span></td>

													</tr>
												</c:when>
												<c:when test="${payerForIndia== clocationName}">
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

												</c:when>
												
												
												
												
												
												<c:when test="${clocationName3 == payerForIndia}">
											<c:choose>
												<c:when test="${(object1.vessel == 'BMS LIBRA' || object1.vessel == 'BMS VIRGO') && object1.sectorCode=='WEX'}">
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
														</span>  -->
													<span style="text-decoration: underline;"><b>XXXXXXXXXXXXX</b></span><BR>
														Company Name :  PARAGON DYNAMICS INFO SYSTEMS (P) LTD (M) SDN BHD<BR> 
														Bank Name    : XXXXXXXXXXXXX<BR>
														Bank Account : XXXXXXXXXXXXX<BR>
														Swift Code   : XXXXXXXXXXXXX<BR><BR><BR> 
													</span></td>
													</tr>
												</c:otherwise>
											</c:choose>
												</c:when>
												
												
												
												
												
												
												
												
												
												
												
												<c:when test="${object1.slInvLocation == clocationName}">
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

												</c:when>
												<c:when
													test="${object1.slInvLocation == clocationName2 || object1.slInvLocation == clocationName3  || object1.slInvLocation == clocationName4 }">
													<TR>
														<td><span class=normal> &nbsp;&nbsp;XXXXXXXXXXXXX<br>
																&nbsp;&nbsp;SWIFT CODE XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;USD Current A/C :XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;SGD CURRENT A/C :XXXXXXXXXXXXX
														</span></td>

													</tr>
												</c:when>
												<c:when test="${object1.slInvLocation == clocationName1}">
													<TR>
														<td><span class=normal> &nbsp;&nbsp;STANDARD
																CHARTERED BANK<br> &nbsp;&nbsp;XXXXXXXXXXXXX
																XXXXXXXXXXXXX<BR> &nbsp;&nbsp;IFSC/NEFT CODE :
																XXXXXXXXXXXXX MIRC CODE : XXXXXXXXXXXXX<BR>
																&nbsp;&nbsp;IRS Current A/c XXXXXXXXXXXXX<br>
																&nbsp;&nbsp;PAN :XXXXXXXXXXXXX , SERVICE TAX NO :
																AAJCS7502DST001
														</span></td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<c:if test="${locationName == object1.locationName}">
															<td><span class=normal>
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
														</c:if>
														<c:if test="${locationName1 == object1.locationName}">
															<br>
															<td><span class=normal> &nbsp;&nbsp;XXXXXXXXXXXXX<br>
																	&nbsp;&nbsp;SWIFT CODE XXXXXXXXXXXXX<BR>
																	&nbsp;&nbsp;USD Current A/C :XXXXXXXXXXXXXXXXXX<BR>
																	&nbsp;&nbsp;SGD CURRENT A/C :XXXXXXXXXXXXX <br></span></td>
															<br>

														</c:if>
														<c:if test="${locationName2 == object1.locationName}">
															<td><span class=normal> &nbsp;&nbsp;
																	XXXXXXXX.<br> &nbsp;&nbsp;XXXXXXXXXXXXX,
																	N.A<BR> &nbsp;&nbsp;Po BOX XXXXXXXX<BR>
																	&nbsp;&nbsp;XXXXXXXXXXXXX<br>
																	&nbsp;&nbsp;Account number- XXXXXXXXXXXXX<br>
																	&nbsp;&nbsp;Chase SWIFT Code: XXXXXXXXXXXXX<br>
																	&nbsp;&nbsp;Routing No: XXXXXXXXXXXXX
															</span></td>

														</c:if>
														<c:if test="${locationName3 == object1.locationName}">
															<td><span class=normal> &nbsp;&nbsp;STANDARD
																	CHARTERED BANK<br> &nbsp;&nbsp;XXXXXXXXXXXXX
																	XXXXXXXXXXXXX<BR> &nbsp;&nbsp;IFSC/NEFT CODE :
																	XXXXXXXXXXXXX MIRC CODE : XXXXXXXXXXXXX<BR>
																	&nbsp;&nbsp;IRS Current A/c XXXXXXXXXXXXX<br>
																	&nbsp;&nbsp;PAN :XXXXXXXXXXXXX , SERVICE TAX NO :
																	AAJCS7502DST001
															</span></td>

														</c:if>
													</tr>
												</c:otherwise>
											</c:choose>



										</table>
									</td>
									<td>
										<table border=0 cellPadding=2 cellSpacing=0 class="width_100">
																				
						<c:choose>
						 <c:when test="${locationName == object1.locationName}">
						<tr>
												<td>
													<table class="width_100" border=0 cellspacing=0
														cellpadding=0>
														<tr>
															<td class="bold text_right">PARAGON DYNAMICS INFO SYSTEMS (P) LTD</td>
														</tr>
														<tr>
															<td class="bold text_right"><br><br> ${object1.invCreatedUser}</td>
														</tr>
														
														
													</table>
												</td>
											</tr>
						</c:when>
						 <c:when test="${locationName2 == object1.locationName}">
						<tr>
												<td>
													<table class="width_100" border=0 cellspacing=0
														cellpadding=0>
														<tr>
															<td class="bold text_right"></td>
														</tr>
														<tr>
															<td class="bold text_right"><br><br> ${object1.invCreatedUser}</td>
														</tr>
														
														
													</table>
												</td>
											</tr>
						</c:when>						
						<c:otherwise>
						<c:if test="${locationName1 == object1.locationName}">
								<tr>
												<td>
													<table class="width_100" border=0 cellspacing=0
														cellpadding=0>
														<tr>
															<td class="bold text_right">PARAGON DYNAMICS INFO SYSTEMS (P) LTD <br><br> ${object1.invCreatedUser}</td>
														</tr>
														
														
													</table>
												</td>
											</tr>
							</c:if> 
							</c:otherwise>
							</c:choose>
																			
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table></td>
		</tr>		
		
		<tr>
			<td colspan="2" align="center"><br> <br> <span
				style='font-family: "bookman old style"; border: 0; overflow: auto; font-weight: normal; font-size: x-small; line-height: 1.5em;'>${object1.footeraddr}<br>
					Tel.:${object1.footerphno}&nbsp;FAX:${object1.footerfaxno}&nbsp;
					e-mail : <span
					style="text-transform: lowercase; text-decoration: underline;">${object1.footermail}</span><br>
					&nbsp;Website:www.paragondynamics.in&nbsp;
			</span></td>
		</tr>
	</table>
	<!-- <br><br> <br> <br> <br> -->
	<!-- <table align=center border=0 cellPadding=0 cellSpacing=0 class="footer width_95">
		
	</table> -->
	<!-- <br><br><br><br><br><br><br> <br><br> <br><br> <br> -->
	<br><br><br><br><br><br>
	<%-- <table border="1" class="width_95" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="#cccccc" align="center" height="90%">
		<tr>
			<td rowspan=3 colspan=4><span class="blprint">Shipper</span><br>
				<br> <span class="normal">${billofladingobject.ashipper}</span></td>
			<td colspan=4 class="tablespace"><span
				style="font-size: 12px; font-weight: bold">SERVICE BILL OF
					LADING</span></td>
		</tr>
		<tr>
			<td colspan="2" class="tablespace" width="13%"><span
				class="blprint">Country of Origin</span><br> &nbsp;</td>
			<td colspan="2" class="tablespace"><span class="blprint">Bill
					of lading No</span><br> <span class="normal">${billofladingobject.billNo}</span></td>
		</tr>
		<tr>
			<td colspan=3 rowspan=2 class="tablespace"><span class="blprint">F/Agent
					Name &amp; Ref</span><br> &nbsp;</td>
			<td colspan=1 rowspan=2 class="tablespace"><span class="blprint">Shipper's
					Ref.</span><br> &nbsp;<span class="normal">${billofladingobject.shipperReference}</span></td>
		</tr>
		<tr>
			<td rowspan=2 colspan=4 class="tablespace"><span class="blprint">Consignee(if
					"To Order" so indicate)</span><br> &nbsp;<span class="normal">${billofladingobject.consignee}</span></td>
		</tr>
		<tr>
			<td rowspan=2 colspan=4 align="center">
			<c:choose>
				<c:when test="${payerForIndia ==  clocationName6}">
				<img src="/img/sfpl_logo_226x57.jpg">
				</c:when><c:otherwise>
			<c:if
					test="${locationName == object1.locationName}">
					<img src="/img/sfpl_logo_315x54.jpg">
				</c:if> <c:if test="${locationName1 == object1.locationName}">
					<img src="/img/sfpl_logo_232x55.jpg">
				</c:if> <c:if test="${locationName2 == object1.locationName}">
					<img src="/img/America_logo.jpg">
				</c:if> <c:if test="${locationName3 == object1.locationName}">
					<img src="/img/sfpl_logo_226x50.jpg">
				</c:if> </c:otherwise> </c:choose><br> &nbsp;<span class="normal">${object1.footeraddr}<br>
					Tel.:${object1.footerphno}&nbsp;FAX:${object1.footerfaxno} &nbsp;
			</span></td>

		</tr>
		<tr>
			<td rowspan=2 colspan=4 class="tablespace"><span class="blprint">NotifyParty</span><br>
				<br> &nbsp;<span class="normal">${billofladingobject.notifyParty}</span></td>

		</tr>
		<tr>
			<td colspan=4>&nbsp;</td>

		</tr>
		<tr>
			<td colspan=3 class="tablespace"><span class="blprint">Place
					of Receipt</span><br> &nbsp;<span
				class="normal">${billofladingobject.pol}</span></td>
			<td colspan=1 class="tablespace" width="211"><span
				class="blprint">Port of Loading </span><br> &nbsp;<span
				class="normal">${billofladingobject.pol}</span></td>
			<td colspan=2 class="tablespace" width="157"><span
				class="blprint">Pre Carriage by:</span><br> &nbsp;<span
				class="normal">${billofladingobject.carraige}</span></td>
			<td colspan=2 class="tablespace"><span class="blprint">Freight
					to be paid at:</span><br> &nbsp;<span class="normal">${billofladingobject.paidAt}</span></td>
		</tr>
		<tr>
			<td colspan=3 class="tablespace"><span class="blprint">Vessel</span><br>
				<span class="normal">
					${billofladingobject.vessel},&nbsp;&nbsp;&nbsp;
					${billofladingobject.voyage}</span></td>
			<td colspan=1 class="tablespace" width="211"><span
				class="blprint">Port of Discharge</span><br> &nbsp;<span
				class="normal">${billofladingobject.pod}</span></td>
			<td colspan=2 class="tablespace" width="157"><span
				class="blprint">Place of Delivery</span><br> &nbsp;<span
				class="normal">${billofladingobject.pod}</span></td>

			<td colspan=1 class="tablespace" width="157"><span
				class="blprint">Sailing Date </span><br> &nbsp;<span
				class="normal">${billofladingobject.sailingDate}</span></td>
			<td colspan=1 class="tablespace"><span class="blprint">No.
					of Bills of lading</span><br> &nbsp;<span class="normal">${billofladingobject.noOfBill}</span></td>
		</tr>
		<tr style="height: 3%">
			<td colspan=2 class="tablespace" align="center"><span
				class="blprint">Marks&amp;Numbers</span>&nbsp;</td>
			<td colspan=1 class="tablespace" align="center"><span
				class="blprint">No.of Pkgs. or Shipping</span>&nbsp;</td>
			<td colspan=3 class="tablespace" align="center"><span
				class="blprint">Description of Goods &amp; Pkgs.</span> &nbsp;</td>
			<td colspan=1 class="tablespace" align="center"><span
				class="blprint">Gross Weight</span> &nbsp;</td>
			<td colspan=1 class="tablespace" align="center"><span
				class="blprint">Measurement</span> &nbsp;</td>
		</tr>
		<tr height="18%">
			<td colspan=2 rowspan=2 align="center"><span class="normal">${billofladingobject.marks}</span></td>
			<td colspan=1 align="center"><span class="normal">${billofladingobject.packages}</span></td>
			<td colspan=3 align="center"><span class="normal">${billofladingobject.goods}</span><br>
				&nbsp;</td>
			<td colspan=1 rowspan=2 align="center"><span class="normal">${billofladingobject.grossWeight}</span><br>
				&nbsp;</td>
			<td colspan=1 rowspan=2 align="center"><span class="normal">${billofladingobject.measurement}</span><br>
				&nbsp;</td>
		</tr>
		<tr>

			<td colspan=1 class="tablespace"><span class="normal">Total:
					&nbsp;<br> &nbsp;&nbsp;&nbsp;${billofladingobject.total}
			</span></td>
			<td colspan=3 class="tablespace"><span class="normal">Temperature
					control Instructions:${billofladingobject.tempControl}</span></td>

		</tr>
		<tr>
			<td colspan=4 width="60%">
				<table border=0 cellspacing="5">
					<tr>
						<td><span class="blprint1"> The term 'carriage by sea'
								by definition being transport goods, merchandise or their
								packing inclusive of containers and any type between one port
								and another port, the carrier is not and shall not be
								responsible for <br> <br> a) Any damage occasioned to
								the goods arising out of or in relation to the loading of
								containers on or of the vessel and/or<br> <br> b) Any
								damage containers before the loading and after the unloading of
								the said containers from the vessel;<br> <br> c) Any
								damage caused to containers on board the vessel by other
								containers in the course of loading or unloading of those other
								containers on board the vessel by stevedores;and/or<br> <br>
								d) Any damage caused to containers prior to the loading and
								subsequent to the unloading of other containers arising out of
								the vessels ancillary equipment(or any part there of)coming into
								contact with the said containers lying on the quayside should <br>
								<br> e) Any mis-information on the Import General Manifest
								and re-export of import containers and where appropriate to
								fumish guarantees to the carrier's agent if these are breached.
						</span></td>
					</tr>
				</table>
			</td>
			<td colspan=4 style="text-align: justify">
				<table border=0 cellspacing="10">
					<tr>
						<td><span class="blprint1" style="text-align: justify">
								RECEIVED on board vessel at port of receipt named herein the
								container as enumerated below apparent good order and condition
								unless otherwise stated (weight,measure,brand contents,quality
								and value unknown).to be transported as provided herein for
								delivery alongside at mentioned port of discharge (for as near
								to as the vessel may safety get)subject always to the
								exceptions,limitations condition and liberties mentioned on this
								and the reverse side here of ,which are mutually agreed upon by
								acceptance of this Bill of Lading in witness where of the stated
								number of original Bill of Lading all of this tenor and date
								have been signed,one of which being accomplished the other(s) to
								stand void. <br> <br> Place and date of issue<u>&nbsp;&nbsp;&nbsp;&nbsp;DUBAI&nbsp;&nbsp;&nbsp;&nbsp;</U>
								<br> Signed on behalf of the Carrier: <br> <br>
								by<br> &nbsp;&nbsp;As Agents
						</span></td>
					</tr>
				</table>
			</td>


		</tr>
	</table> --%>
	
	<table border="1" class="width_95" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="#cccccc" align=center height="90%">
		<tr>
			<td rowspan=3 colspan=4><span class="blprint">Shipper</span><br>
				<br> <span class="normal">${billofladingobject.shipper}</span></td>
			<td colspan=4 class="tablespace"><span
				style="font-size: 12px; font-weight: bold">SERVICE BILL OF
					LADING</span></td>
		</tr>
		<tr>

			<td colspan="2" class="tablespace" width="13%"><span
				class="blprint">Country of Origin</span><br><span class="normal">${billofladingobject.place}</span></td>
			<td colspan="2" class="tablespace"><span class="blprint">Bill
					of lading No</span><br> <span class="normal">${billofladingobject.billNo}</span></td>
		</tr>
		<tr>
			<td colspan=3 rowspan=2 class="tablespace"><span class="blprint">F/Agent
					Name &amp; Ref</span><br> &nbsp;<span class="normal">${billofladingobject.agent}</span></td>
			<td colspan=1 rowspan=2 class="tablespace"><span class="blprint">Shipper's
					Ref.</span><br> &nbsp;<span class="normal">${billofladingobject.shipper}</span></td>
		</tr>
		<tr>
			<td rowspan=2 colspan=4 class="tablespace"><span class="blprint">Consignee(if
					"To Order" so indicate)</span><br>
					<span class="normal">${billofladingobject.mloName}</span><br>
					<span class="normal">${billofladingobject.consigneeMloAddrsDtl}</span></td>

		</tr>
		<tr>
			<td rowspan=2 colspan=4 align="center">
			<c:choose>
				<c:when test="${payerForIndia ==  clocationName6}">
				<img src="/img/sfpl_logo_226x57.jpg">
				</c:when><c:otherwise>
			<c:if
					test="${locationName == object1.locationName}">
					<img src="/img/sfpl_logo_315x54.jpg">
				</c:if> <c:if test="${locationName1 == object1.locationName}">
					<img src="/img/sfpl_logo_232x55.jpg">
				</c:if> <c:if test="${locationName2 == object1.locationName}">
					<img src="/img/America_logo.jpg">
				</c:if> <c:if test="${locationName3 == object1.locationName}">
					<img src="/img/sfpl_logo_226x50.jpg">
				</c:if> </c:otherwise> </c:choose><br> &nbsp;<span class="normal">${object1.footeraddr}<br>
					Tel.:${object1.footerphno}&nbsp;FAX:${object1.footerfaxno} &nbsp;
			</span></td>

		</tr>
		<tr>
			<td rowspan=2 colspan=4 class="tablespace"><span class="blprint">NotifyParty</span><br>
				<br> &nbsp;<span class="normal">${billofladingobject.notify}</span></td>

		</tr>
		<tr>
			<td colspan=4>&nbsp;</td>

		</tr>
		<tr>
			<td colspan=3 class="tablespace"><span class="blprint">Place
					of Receipt</span><br> &nbsp;<span
				class="normal">${billofladingobject.pol}</span></td>
			<td colspan=1 class="tablespace" width="211"><span
				class="blprint">Port of Loading </span><br> &nbsp;<span
				class="normal">${billofladingobject.pol}</span></td>
			<td colspan=2 class="tablespace" width="157"><span
				class="blprint">Pre Carriage by:</span><br> &nbsp;<span
				class="normal">${billofladingobject.carriage}</span></td>
			<td colspan=2 class="tablespace"><span class="blprint">Freight
					to be paid at:</span><br> &nbsp;<span class="normal">${billofladingobject.recept}</span></td>
		</tr>
		<tr>
			<td colspan=3 class="tablespace"><span class="blprint">Vessel & Voyage</span><br>
				<span class="normal">
					${billofladingobject.vessel}</span><br>
				<span class="blprint">,</span>
				<span class="normal">
					${billofladingobject.voyage}</span><br>
								</td>
			
			<td colspan=1 class="tablespace" width="211"><span
				class="blprint">Port of Discharge</span><br> &nbsp;<span
				class="normal">${billofladingobject.pod}</span></td>
			<td colspan=2 class="tablespace" width="157"><span
				class="blprint">Place of Delivery</span><br> &nbsp;<span
				class="normal">${billofladingobject.pod}</span></td>

			<td colspan=1 class="tablespace" width="157"><span
				class="blprint">Sailing Date </span><br> &nbsp;<span
				class="normal">${billofladingobject.sailDate}</span></td>
			<td colspan=1 class="tablespace"><span class="blprint">No.
					of Bills of lading</span><br> &nbsp;<span class="normal">${billofladingobject.nobillofladding}</span></td>
		</tr>
		<tr style="height: 3%">
			<td colspan=2 class="tablespace" align="center"><span
				class="blprint">Marks&amp;Numbers</span>&nbsp;</td>
			<td colspan=1 class="tablespace" align="center"><span
				class="blprint">No.of Pkgs. or Shipping</span>&nbsp;</td>
			<td colspan=3 class="tablespace" align="center"><span
				class="blprint">Description of Goods &amp; Pkgs.</span> &nbsp;</td>
			<td colspan=1 class="tablespace" align="center"><span
				class="blprint">Gross Weight</span> &nbsp;</td>
			<td colspan=1 class="tablespace" align="center"><span
				class="blprint">Measurement</span> &nbsp;</td>
		</tr>
		<tr height="18%">
			<td colspan=2 rowspan=2 align="center"><span class="normal">${billofladingobject.marksandnumbers}</span></td>
			<td colspan=1 align="center"><span class="normal">${billofladingobject.noofpackers}</span></td>
			<td colspan=3 align="center">
			<span class="blprint1">SHIPPER OWN CONTAINERS STC, SHIPPER LOAD COUNT AND SEALED</span><br>
				<span class="normal">${billofladingobject.descofgoods}</span>
				<span class="blprint1">(CONTAINER LIST AS PER ATTACHED)</span>
				<br>
					&nbsp;
			</td>
			<td colspan=1 rowspan=2 align="center"><span class="normal">${billofladingobject.grossweight}</span><br>
				&nbsp;</td>
			<td colspan=1 rowspan=2 align="center"><span class="normal">${billofladingobject.mesurement}</span><br>
				&nbsp;</td>
		</tr>
		<tr>

			<td colspan=1 class="tablespace"><span class="normal">Total:
					&nbsp;<br> &nbsp;&nbsp;&nbsp;${billofladingobject.tempControl}
			</span></td>
			<%-- <td colspan=3 class="tablespace"><span class="normal">Temperature
					control Instructions:${billofladingobject.tempControl}</span></td> --%>

		</tr>
		<tr>
			<td colspan=4 width="60%">
				<table border=0 cellspacing="5">
					<tr>
						<td><span class="blprint1"> The term 'carriage by sea'
								by definition being transport goods, merchandise or their
								packing inclusive of containers and any type between one port
								and another port, the carrier is not and shall not be
								responsible for <br> <br> a) Any damage occasioned to
								the goods arising out of or in relation to the loading of
								containers on or of the vessel and/or<br> <br> b) Any
								damage containers before the loading and after the unloading of
								the said containers from the vessel;<br> <br> c) Any
								damage caused to containers on board the vessel by other
								containers in the course of loading or unloading of those other
								containers on board the vessel by stevedores;and/or<br> <br>
								d) Any damage caused to containers prior to the loading and
								subsequent to the unloading of other containers arising out of
								the vessels ancillary equipment(or any part there of)coming into
								contact with the said containers lying on the quayside should <br>
								<br> e) Any mis-information on the Import General Manifest
								and re-export of import containers and where appropriate to
								fumish guarantees to the carrier's agent if these are breached.
						</span></td>
					</tr>
				</table>
			</td>
			<td colspan=4 style="text-align: justify">
				<table border=0 cellspacing="10">
					<tr>
						<td><span class="blprint1" style="text-align: justify">
								RECEIVED on board vessel at port of receipt named herein the
								container as enumerated below apparent good order and condition
								unless otherwise stated (weight,measure,brand contents,quality
								and value unknown).to be transported as provided herein for
								delivery alongside at mentioned port of discharge (for as near
								to as the vessel may safety get)subject always to the
								exceptions,limitations condition and liberties mentioned on this
								and the reverse side here of ,which are mutually agreed upon by
								acceptance of this Bill of Lading in witness where of the stated
								number of original Bill of Lading all of this tenor and date
								have been signed,one of which being accomplished the other(s) to
								stand void. <br> <br> Place and date of issue<u>&nbsp;&nbsp;&nbsp;&nbsp;DUBAI&nbsp;&nbsp;&nbsp;&nbsp;</U>
								<br> Signed on behalf of the Carrier: <br> <br>
								by<br> &nbsp;&nbsp;As Agents
						</span></td>
					</tr>
				</table>
			</td>


		</tr>
	</table>
	
	
	<table width="100%" height="10%">
		<tr>
			<td class="normal">***This is a Computer Generated BL and does
				not requires signature and seal*****</td>
			<TD class="normal" style="text-align: right">Page 1 of 2</TD>
		</tr>
	</table>
	<table width="100%" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="#cccccc" align="center" height="90%">
		<tr>
			<td>
				<table cellpadding="7" cellspacing="0">
					<tr>
						<td class="blterms"><b>CONDITIONS OF CARRIAGE</b> <br> <br>

							1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; DEFINITIONS: Carrier means the
							party on whose behalf the Bill of Lading has been signed.<br>

							Goods means the cargo accepted form the Shipper and includes
							any Container not supplied by or on behalf of the Carrier.<br>
							<br> Merchant includes the Shipper, Holder, Consignee,
							the receiver of the Goods, any person owning or entitled to the
							possession of the Goods or this Bill of Lading and anyone acting
							on behalf on any such persons.<br> <br> Holder means
							any person for the time being in possession of this Bill of
							Lading to whom the property in the Goods has passed on by reason
							of the consignment of the Goods or the endorsement of this Bill
							or otherwise.<br> <br> References to the internal law
							of a State shall be deemed to exclude all principles of private
							international law applied by such state.<br> <br>

							2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CARRIERS TARIFF The terms of
							the Carriers applicable Tariff are incorporated herein. Copies
							of the relevant provisions of the applicable Tariff are
							obtainable from the Carrier upon request in the case of
							inconsistency between the Bill of Lading and the applicable
							Tariff the Bill of Lading shall prevail.<br> <br>

							3.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; WARRANTY, the Merchant warrants
							that in agreeing to the terms hereof he is or has the authority
							of the person owing or entitled to the possession of the goods
							and the Bill of Lading.<br> <br>

							4.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SUB-CONTRACTING (i) The Carrier
							shall be entitled to sub-contract on any terms and the whole or
							part of the person owning or entitled to the possession of the
							Goods and the Bill of Lading<br> <br> (ii) The Merchant
							undertakes that no claim or allegation shall be made against any
							servant, agent or sub-contractor, including, without limiting he
							generality of the foregoing terminal and depot operators, of the
							Carrier which imposes or attempts to impose upon any of them or
							any vessel owned by any of hem any liability whatsoever in
							connection with the Goods, and, if any such claim or allegation
							should nevertheless be made, to indemnity the Carrier against all
							consequences thereof. Without prejudice to the foregoing, every
							such servant, agent and sub-contractor, including without
							limiting the generality of the foregoing terminal and depot
							operators, shall have the benefit of all provisions herein
							benefiting the Carrier as if such provisions were expressly for
							their benefit; and in entering into this contract the Carrier as
							if such provisions were expressly for their benefit; and in
							entering into this contract the Carrier, to the extent of those
							provisions, does so not only on its own behalf, but also as agent
							and trustee for such servants, agents and Sub-contractors,
							including, without limiting the generality of the foregoing
							terminal and depot operators.<br> <br> (iii) The
							expression sub-contractor in this clause shall include direct
							and indirect sub-contractors and their respective servants and
							agents.<br> 5. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CARRIERS
							RESPONSIBILITY, (i) The Carrier shall be liable for loss of or
							damage to the Goods occurring between the time when he receives
							the Goods for transportation and the time of delivery.<br>

							(ii) The Carrier shall, however, be relieved of liability for any
							loss or damages if such loss or damage arose or resulted from:<br>
							<br> (a)&nbsp; &nbsp;&nbsp;The wrongful act or neglect of
							the Merchant.<br> <br> (b)&nbsp;&nbsp;&nbsp; Compliance
							with the instructions of the person entitled to give them:<br>
							<br> (c)&nbsp;&nbsp;&nbsp; The lack of or insufficient of or
							defective conditions of packing in the case of Goods which, by
							their nature, are liable to wastage or to be damaged when not
							packed or when not properly packed.<br> <br>

							(d)&nbsp;&nbsp;&nbsp; Handling loading, stowage or unloading of
							the Goods by or on behalf of the Merchant.<br> <br>

							(e)&nbsp;&nbsp;&nbsp; Inherent vice of the goods:<br> <br>

							(f)&nbsp;&nbsp;&nbsp; Insufficiency or inadequacy of marks or
							numbers on the Goods, covering or containers;<br> <br>

							(g)&nbsp;&nbsp;&nbsp; Strikes or lock-outs or stoppage or
							restraints of labour from whatever cause whether partial or
							general<br> <br> (h)&nbsp;&nbsp;&nbsp; Any cause or
							event which the Carrier could not avoid and the consequence
							whereof he could not prevent by the exercise of reasonable
							diligence.<br> <br> (iii) Where under sub-clause (ii)
							the Carrier is not under any liability in respect of some of the
							factors causing the loss or damage he shall only be liable to the
							extent that those factors for which he is liable under this
							Clause have <br> contributed to the loss or damage.<br>
							<br> (iv) The burden of proving that the loss or damage was
							due to one or more of the causes, or events specified in (n) (b)
							and (h) of sub-clause (ii) shall rest upon the Carrier.<br>
							<br> When the Carrier establishes that in the circumstances
							of the case, the loss or damage could be attributed to one or
							more of the causes, or events, specified in (c) to (g) of
							sub-clause (ii), it shall be presumed that it was so caused. The
							Merchant shall, however be entitled to prove that the loss or
							damage was not in fact, caused either wholly or partly by one or
							more of the causes or events.<br> <br> 6.
							&nbsp;&nbsp;&nbsp;THE AMOUNT OF COMPENSATION, (i) When the
							carrier is liable for compensation in respect of loss or damage
							of the Goods such compensation shall be calculated by reference
							to the invoice value of the goods plus freight charges and
							insurance if paid.<br> <br> (ii) If there is no invoice
							value of the Goods, such compensation shall be calculated by
							reference to the value of such Goods at the place and time they
							are delivered to the Merchant in accordance with the contract or
							should have been delivered. The value of the Goods shall be fixed
							according to the commodity exchange price of, if there be no such
							price according to the current market price or if there be no
							commodity exchange price or current market place, by reference to
							the normal value of goods of the same kind and quality.<br>
							<br> (iii) Compensation shall not, however, exceed US$2 per
							kilo or gross weight of the goods lost or damaged.<br> <br>

							(iv) Higher compensation may be claimed only when with the
							consent of the Carrier the value of the Goods declared by the
							shipper which exceeds the limits laid down in this clause has
							been stated in this Bill of Lading. In that case the amount of
							the declared value shall be substituted for that limit. Any
							partial loss or damage shall be adjusted pro rata on the basis of
							such declared value.<br> <br> 7.
							&nbsp;&nbsp;&nbsp;SPECIAL PROVISIONS (1) Notwithstanding anything
							provided for in Clauses 5 and 6 of this Bill of Lading and
							subject to Clauses 18 and 19, if it can be proved where the loss
							of damage occurred, the Carrier and the Merchant shall, as to the
							liability of the Carrier, be entitled to require such liability
							to be determined<br> <br> (a) by the provisions
							contained in any international convention or national law, which
							provisions:<br> <br> (i) cannot be departed from by
							private contract to the detriment of the Merchant (claimant??),
							and <br> <br> (ii) would have applied if the Merchant
							had made a separate and direct contract with the Carrier in
							respect of the particular stage of transport where the loss or
							damage occurred and received as evidence thereof any particular
							document which must be issued if such international convention or
							national law shall apply.<br> <br> Provided that an
							international convention or national law may be invoked as
							aforesaid only if it would have been applicable, if the contract
							referred to in (ii) above were governed.<br> <br> (1)
							Where the loss or damage occurred between the time that the Goods
							were received by the Carrier for transportation and the time that
							the Goods were loaded at the port of loading, by the national law
							of the State of the place or receipt, or [not clear]<br> <br>

							(2) where the loss or damage occurred during damage by sea, by
							the national law of the final port of discharge, or [not clear]<br>
							<br> (3) Where the loss or damage occurred between the time
							that the Goods were discharged at the final port of discharge and
							the time that the Goods were delivered to the Merchant by the
							national law of the State of the place of delivery or<br> <br>


							(b) subject to (a) [the latter, plus 1, 2 and 3 need proper links
							between the sentences and may be redrafting]<br> (i)by the
							Hague Rules contained in the international Convention at Brussels
							for the Unification of Certain Rules Relating to Bill of Lading
							dated 25th August, 1924 as amended by the Brussels Protocol of
							23rd February 1968, if the loss or damage is proved to have
							occurred at sea or on inland waterways, for the purposes of this
							sub-clause the limitation of liability under the Hague Rules
							shall be deemed to be £100 sterling, lawful money of the United
							Kingdom per package or until and references in the Hague Rules to
							carriage by sea shall be deemed to include references to carriage
							by inland waterways and the Hague Rules shall be construed
							accordingly, or<br> <br> (ii) by standard Japanese
							Railway Transportation Clauses if the loss or damage is proved to
							have occurred during carriage by road in Japan, or<br> <br>

							(iii) by Japanese Railway Transportation Business law and
							Ministerial Ordinance for Railway Transportation if the loss or
							damage is proved to have occurred during carriage by rail in
							Japan.<br> <br> (2) If the whole of the carriage
							undertaken by the Carrier is limited to carriage from a Container
							Yard CY or Container Freight Station (CFS) in or immediately
							adjacent to sea terminal at the port of loading to a Container
							Yard or CFS in or immediately adjacent to the sea terminal at the
							port of discharge, the liability of the Carrier shall be
							determined by the national law which shall be applicable to the
							carriage by sea under paragraph (a) above or ailing which by the
							Hague Rules referred to in (1) (b) (i) above irrespective of
							whether the loss or damage is proved to have occurred during the
							period of carriage at sea or port or subsequent thereto.<br>
							(8)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GENERAL (I) The Carrier
							does not undertake that the Goods shall arrive at the port of
							discharge or place of delivery at any particular time or to meet
							any particular market or so and save as provided in Clause ???
							the Carrier shall in no circumstances be liable for any direct,
							indirect or consequential loss or damage caused by delay and
							shall in no cases exceed the freight for the transport covered by
							the Bill of Lading.<br> <br> <br></td>

						<td class="blterms">(ii) Save as otherwise provided herein,
							the Carrier shall in no circumstances be liable for direct or
							indirect or consequential loss or damage arising from any other
							cause whatsoever.<br> <br> (iii) The terms of this Bill
							of Lading shall govern the responsibility of the Carrier in
							connection with or arising out of the supply of a Container to
							the Merchant whether before or after the Goods are received by
							the Carrier for transportation or delivered to the Merchant.<br>

							(9) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NOTICE OF LOSS, TIME BAR
							(i) Unless notice of loss or damage to the Goods and the general
							nature of it be given in writing to the Carrier at the place of
							delivery before or at the time of removal of the Goods into the
							custody of the person entitled to delivery thereof under this
							Bill of Lading, or if the loss or damage be not apparent within
							seven consecutive days thereafter, such removal shall be prima
							facie evidence of the delivery by the Carrier of the Goods as
							described in this Bills of Lading.<br> (ii) Subject to
							paragraph (iii) below the Carrier shall be discharged of all
							liability under this Bill of Lading unless suit is brought and
							written Notice thereof given to the Carrier within nine months
							after the delivery if the goods have been received for
							transportation or the date when the goods should have been
							delivered<br> <br> 10.
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DEFENCES AND LIMITS FOR THE
							CARRIER, (i) The defences and limits of liability provided for in
							this Bill of Lading shall apply in any action against the Carrier
							for loss of damage to the Goods whether the action can be founded
							in contract or in tort.<br> <br> (ii) The Carrier shall
							be entitled to the benefit of the limitation of liability
							provided for in Clause 6, sub-clause (iii) if it is proved that
							the loss or damage resulted from an act or omission of the
							Carrier done with intent to cause damage or recklessly and with
							knowledge that damage would probably result.<br> <br>

							11. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SHIPPER-PACKED
							CONTAINERS, If a container has not been filled, packed, stuffed,
							stowed or loaded by the Carrier, the Carrier shall not be liable
							for loss or damage to the content and the Merchant shall
							indemnify the Carrier against any loss, damage, liability or
							expense incurred by the carrier, if such loss, damage, liability
							or expense has been cause by.:<br> <br> a) the manner
							in which the container has been filled, packed, stuffed, stowed
							or loaded; or<br> <br> b) The unsuitability of the
							contents for carriage in Containers: or<br> 12.
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;INSPECTION OF GOODS The
							carrier shall be entitled but under no obligation, to open any
							Container at any time and to inspect the contents. If it
							thereupon appears that the contents or any part thereof cannot
							safely or properly be carried or carried further at all or
							without incurring any additional expense or taking any measure in
							relation to the Container or its contents or any part thereof,
							the Container may abandon the transportation thereof and/or take
							any measures and/or incur any reasonable additional expense to
							carry or to continue the carriage or to store the same ashore or
							afloat under cover or in the open at any place, which storage
							shall be deemed to constitute due delivery under this Bill of
							Lading. The Merchant shall indemnify the Carrier against any
							reasonable additional expense so incurred.<br> <br> 13.
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DESCRIPTION OF GOODS, This
							Bill of lading shall be prima facie evidence of the receipt by
							the Carrier in apparent good order and condition except as
							otherwise noted of the total number of Containers or other
							packages or units enumerated overleaf. Proof to the contrary
							shall not be admissible when this Bill of Lading has been
							transferred to a third party acting in good faith.<br> <br>


							14.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SHIPPERS RESPONSIBILITY
							(i) The Shipper warrants to the Carrier that the particulars
							relating to the Goods as set overleaf have been checked by the
							Shippers on receipt of this Bill of Lading and that such
							particulars and any other particulars furnished by or on behalf
							of the Shippers are correct.<br> <br> (ii) The Shippers
							shall indemnify the Carrier against all loss, damage expenses
							arising or resulting from inaccuracies in or inadequacy of such
							particulars. The right of the Carrier to such indemnity shall in
							no way limit his responsibility and liability under this Bill of
							Lading to any person other than the Shipper.<br> <br>

							15. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FREIGHT AND CHARGES, (i)
							Freight and charges shall be deemed fully earned receipt of the
							Goods by the Carrier and shall be paid and non-refundable in any
							event.<br> <br> (ii) The Merchants attention is drawn
							to the stipulations concerning currency in which the freight and
							charges are to be paid rate of exchange, devaluation and other
							contingencies relative to freight and charges in the applicable
							Tariff.<br> <br> (iii) The freight has been calculated
							on the basis of particulars furnished by or on behalf of the
							Shippers. The Carrier may at any time open any container or other
							package or unit in order to reweigh, re-measure or revalue the
							contents, and if the particulars furnished by or behalf of the
							Shippers are incorrect, it is agreed that a sum equal to either
							by or on behalf of the Shipper are incorrect, it is agreed that a
							sum equal to either five times the difference between the correct
							freight and the freight charged or to double the correct freight
							less the freight charged, whichever sum is the smaller, shall be
							payable as liquidated damages to the Carrier.<br> <br>

							(iv) Full freight hereunder shall be due and payable at the place
							where this Bill of Lading is issued, by the Shipper in cash
							without deduction on receipt of the Goods or part thereof by the
							Carrier for Shipment even if stated in this Bill of Lading to be
							payable elsewhere and shall be deemed to have been fully earned
							upon such receipt of such goods. All charges due there under
							together with freight (if not paid at the port of loading as
							aforesaid) shall be due from and payable on demand by the
							Shipper, and severally liable to the Carrier therefore) at such
							port or place as the Carrier may require, vessel or cargo lost or
							not lost from any cause whatsoever.<br> <br>

							16.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIEN, The Carrier shall
							have a lien on the Goods and any documents relating thereto for
							[for any amount ???] payable to the Carrier under this Contract
							and for general average contributions to whomsoever due and for
							the costs of recovering the same and also for all previously
							unsatisfied debts whatsoever due to the carrier by the Merchant,
							and for that purpose shall have the right to enforce such lien in
							any manner, including selling the Goods by public auction or
							private treaty without notice to the Merchant.<br> <br>

							17.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; OPTIONAL STOWAGE (i) The
							goods may be stowed by Carrier in Containers or similar article
							or transport used to consolidate goods.<br> <br> (ii)
							Goods stowed in Containers other than flats or pallets whether by
							the Carrier or the Merchant may be carried on or under deck
							without notice to the merchant Such Goods (other than livestock)
							whether carried on deck or under deck shall participate in
							general average and shall be deemed to be within the definition
							of goods for the purpose of Hague Rules.<br> <br>

							18.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DECK CARGO(not being Goods
							stowed in Containers other than flats or pallets) which are
							stated herein to be carried on deck are carried without
							responsibility on the part of the Carrier for loss or damage of
							whatsoever nature arising during carriage by sea whether caused
							by unseaworthiness or negligence or any other cause whatsoever.<br>
							<br> 19. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LIVESTOCK,
							Livestock are carried at the sole risk of the Merchant. The
							Carrier shall be under no liability whatsoever for any injury
							illness, delay or destruction howsoever arising even though
							caused or unfitness of any vessel, craft, conveyance, container
							or other place existing at any tine in the event of the Master,
							in his sole discretion, considering that any livestock is likely
							to be injurious to the health of any other livestock or of any
							person on board or to cause the vessel to be delayed or impeded
							in the prosecution of the voyage, such livestock may be destroyed
							and thrown overboard without any liability attaching to the
							Carrier. The Merchant shall indemnify the Carrier against the
							cost of vetenary services on the voyage and of providing forage
							for any period during which the carriage delayed for any reason
							whatsoever, and of complying with the regulations of any
							authority if any country whatsoever with regard to such
							livestock.<br> <br> 20.
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;METHODS AND ROUTES OF
							TRANSPORTATION (i) The Carrier may at any time and without notice
							to the Merchant.<br> <br> (a) use any means of
							transport or storage whatsoever. <br> <br> (b) transfer
							the Goods from one conveyance to another including transshipping
							or carrying the same as another vessel than the vessel named
							overleaf or on any other means of transport whatsoever.<br>
							<br>
						</td>
						<td class="blterms">(c) proceed by any route to his
							discretion/whether or not the nearest or most direct or customary
							or advertised route) and proceed to or stay at any place or port
							whatsoever once or more often and in any order.<br> <br>
							(d) load and unload the Goods at any place or port (whether or
							not any such port is named overleaf as the Port of Discharge and
							store the Goods at any such place or port.<br> <br> (e)
							comply with any orders or recommendations given by any government
							or any person or body acting or purporting to act as or on behalf
							or such government or authority or having the terms of the
							insurance on the conveyance employed by the Carrier the right to
							give orders or directions.<br> <br> (i) The liberties
							set out in sub clause (i) may be invoked by the Carrier for any
							purpose whatsoever including undergoing repairs, towing or being
							towed, adjusting instruments, dry-docking, and assisting vessels
							in all situations and anything done in accordance with sub clause
							(i) ?? or any delay arising there from shall be deemed to be
							within the contractual carriage and shall not be a deviation.<br>
							<br> 21.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MATTERS
							AFFECTING PERFORMACE if at any time the performance if the
							contract evidenced by this Bill of Lading is likely to be
							affected by any hindrance, risk, delay difficulty or disadvantage
							or whatsoever kind which cannot be avoided by the exercise of
							reasonable endeavors the Carrier (whether or not the transport is
							commenced) may without notice to the Merchant treat the
							performance of this contract as terminated and place the goods or
							any part to them at the Merchants disposal at any place or port
							which the Carrier may deem safe and convenient, whereupon the
							responsibility of the Carrier in respect to such Goods shall
							cease. The carrier shall nevertheless be entitled to full freight
							and charges on Goods received for transportation and the
							/merchant shall pay any additional costs of the carriage to and
							delivery and the storage at such place or port. Notwithstanding
							the above, the Carrier reserves the right to reship the Goods
							without the Merchants consent and without this act constituting
							an act of conversion and the merchant shall indemnify and hold
							the Carrier harmless for all liabilities and expenses incurred.<br>
							<br> 22.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; DANGEROUS GOODS
							(i) The Merchant shall comply with all internationally recognised
							requirements and all rules which apply according to national law
							or by reason of international Convention, relating to the
							carriage of goods of a dangerous nature. The Merchant undertakes
							not to tender for transportation any Goods which are of a
							dangerous, inflammable, radio-active, or damaging nature without
							giving prior written notice of exact nature of the danger to the
							Carrier, indicating to the Carrier, if need be, the precautions
							to be taken and marking the Goods and the Container or other
							covering on the outside as required by any laws or regulations
							which may be applicable during the carriage.<br> <br>

							(ii) If the requirements of sub-clause (i) are not complied with
							the Merchant shall indemnify the Carrier against all loss, damage
							or expense arising out of the Goods being tendered for
							transportation or handled or carried by the carrier.<br> <br>

							(iii) goods which are or at any time become dangerous,
							inflammable, radio-active or damaging may, at any time or place,
							be unloaded, destroyed or rendered harmless without compensation
							and [if the Merchant has not given no liability to make any
							general average contribution in respect of such Goods phrase not
							clear].<br> <br>

							23.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;REFRIGERATED CARGO, (i)
							The Merchant undertakes not to tender for transportation any
							goods which require refrigeration without giving prior written
							notice of their nature and particular temperature range to be
							maintained and in the case of a refrigerated Container packed by
							or on behalf of the Merchant further undertakes that the Goods
							have been properly stowed in the container and that the
							thermostatic controls have been adequately set by him before
							receipt of the Goods by the Carrier, if the above requirements
							are not compiled with the Carrier shall not be liable for any
							loss or damage to the goods howsoever arising.<br> <br>

							(2)The Carrier shall not be liable of any loss of or damage to
							the Goods arising from talent defects derangement, breakdown,
							stoppage of the refrigerating machinery plant, insulation and/or
							any apparatus of the Container, vessel, conveyance and any other
							facilities, provided that the Carrier shall before or at the
							beginning of the transport exercise due diligence to maintain the
							refrigerated Container in an efficient state.<br> <br>

							24.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;REGULATIONS RELATING TO
							GOODS The Merchant shall comply with all regulations or
							requirements of Customs, port and authorities and shall bear and
							pay all duties, taxes, fines, imports expenses or losses incurred
							suffered by reason thereof or reason of any illegal, incorrect or
							insufficient marking, numbering or addressing of the Goods and
							indemnity the Carrier respect thereof.<br> <br>

							25.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NOTIFICATION AND DELIVERY
							(i) Any mention in this Bill of Lading of parties to be notified
							of the arrival of the Goods to safety for formation of the
							Carrier, and failure to give such notification shall not involve
							the Carrier in any liability nor receive the Merchant of any
							obligation hereunder.<br> <br> (ii)The Merchant shall
							take delivery of the Goods within the time provided for in the
							Carriers applicable Tariff.<br> <br> (iii) If the
							Merchant fails to take delivery of the Goods or part of them in
							accordance with this Bill of Lading, the Carrier may without
							notice unstow the Goods or that part thereof and/or store the
							Goods or that part thereof shore afloat, in the open or under
							cover. Such storage shall constitute due delivery hereunder, and
							thereupon all liability whatsoever of the carrier in respect of
							the Goods or that part thereof shall cease.<br> <br>

							(iv) The Merchants attention is drawn to the stipulations
							concerning free storage time and demurrage contained in the
							Carriers applicable Tariff which is incorporated into this Bill
							of Lading.<br> <br>

							26.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BOTH-TO-BLAME, COLLISION,
							If the (carrying) ship comes into collision with another ship as
							a result of the negligence of the other ship and act, neglect or
							default in the navigation or the management of the carrying ship,
							the Merchant undertakes to pay the Carrier or where the carrier
							is not owners and in possession of the carrying ship, to pay to
							the Carrier as trustee for the owner and/or demise charterer of
							the carrying ship a sum sufficient to indemnify the Carrier
							and/or the owners and/or demise charterer of the carrying ship
							against all loss or liability represents loss of or damage to, or
							any claim whatsoever of the merchant, paid of payable by the
							other or non-carrying ship or her owners to the Merchant and set
							off recouped or recovered by the other or non-carrying ship or
							her owners, operators, or those in charge of any ship or ships or
							objects, other than or in addition to the colliding ships or
							objects are at fault in respect of a collision, contact stranding
							or other accident.<br> <br> 27.
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GENERAL AVERAGE, (i) General
							average shall be adjusted at any port or place at the option of
							the Carrier and subject to Clause 17(ii) in accordance with the
							York Antwerp Rules 1974 as mended 1990, provided that where an
							adjustment is made in accordance with the law and practice of the
							United States of America or of any other country having the same
							or similar law or practice the following clause shall apply.<br>
							<br> New Jason Clause<br> <br> (a) In the event of
							accident, danger, damage or disaster before of after the
							commencement of the voyage resulting from any cause whatsoever,
							whether due to negligence or not, for which or for the
							consequence of which, the Carrier is not responsible, by statute,
							contract or otherwise the Goods and the Merchant shall contribute
							with the Carrier in general average to the payment of any
							sacrifices, losses or expenses of a general average nature that
							may be made or incurred and shall pay salvage and special charges
							in respect of the Goods.<br> <br> (b) If a saving
							vessel is owned or operated by the Carrier salvage shall be paid
							for as fully as if the said-salving vessel belonged to stranger.<br>
							<br> (ii) If the Carrier delivers the Goods without
							obtaining security for general average contribution , the
							merchant by taking delivery of the Goods, undertakes personal
							responsibility to pay such contribution and provide such cash
							deposit or other security for the estimated amount of such
							contribution as the Carrier may deem sufficient ??.<br> <br>

							(iii) The Carrier shall be under no obligation to exercise any
							lien for general average contribution due to the Merchant.<br>
							<br> 28.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; VARIATION OF
							THE CONTRACT ETC, No servant or agent of the Carrier shall have
							power to waive of vary any form of this Bill of Lading unless
							such waiver or variations is in writing and is specifically
							authorized or ratified in writing by the Carrier.<br> <br>

							29. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VESSELS ON CHARTER, In
							case of goods being carried by a vessel not belonging to the
							Carrier but chartered by him then the Carrier shall be entitled
							to any or all right, demurrers prescriptions exemptions from and
							limitations of liability available to the Owners of the Vessel,
							as if the Bill of lading has been issued by the Owner of the
							Vessel on his behalf.<br> <br> 30.
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LAW AND JURISDICTIONS, The
							Contract evidence hereby or contained herein shall be governed by
							English Law. Any Claim or other dispute there under shall be
							solely determined by the English Courts unless the Carrier
							otherwise agrees in writing.<br> <br>

							31.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; WAS RISK CLAUSE, The ship
							shall have liberty to comply with any orders or directions as to
							departure, arrival routes, ports to call, stoppages, destination
							delivery or otherwise howsoever given by the government of the
							nation under whose flag the vessel sails or any other department
							thereof, or by any other Government or any department thereof, of
							any person acting or purporting to act with the authority of such
							Government or any department thereof, or by any committee or
							person having under the terms of the War Risks insurance on the
							ship, the right to give such orders or directions and if by
							reason or and in compliance with any such orders or directions
							anything is done or is not done the same shall be a fulfillment
							of the contract voyage and freight shall be payable accordingly.<br>
							<br> 32. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DEMISE CLAUSE,
							If the ship is not owned or chartered by demise to the Company or
							line by whom this Bill of Lading is issued as may be the case
							notwithstanding anything that appears to the contrary as the case
							may be as Principal made through the agency of the said Company
							or line who act as agents only and shall be under no personal
							liability whatsoever in respect thereof.<br> <br>
						</td>
					<tr>
				</table>
			</TD>
		</tr>
		<tr>
			<td class="normal" style="text-align: right">Page 2 of 2</td>
		</tr>
	</table>
		<br><br><br><br><br><br><br><br>
		<div >
			<table border="1" width="90%" cellpadding="0" cellspacing="0"
				bgcolor="FFFFFF" bordercolor="#cccccc" align="center">
				<tr>
					<td class="gridheadercell" colspan="13" height="10px">CONTAINERS DETAILS</td>
				</tr>
				<tr>
					<td  class="gridheadercell" height="10px">S.No</td>
					<td  class="gridheadercell" height="10px">Voyage</td>
					<td  class="gridheadercell" height="10px">CUST.</td>
					<td  class="gridheadercell" height="10px">POL</td>
					<td  class="gridheadercell" height="10px">POD</td>
					<td  class="gridheadercell" height="10px">TYPE</td>
					<td  class="gridheadercell" height="10px">CONTAINER_NO</td>
					<td  class="gridheadercell" height="10px">SLOT_SIZE</td>
		
					<td  class="gridheadercell" height="10px">WEIGHT</td>
					<td  class="gridheadercell" height="10px">IMCO</td>
		
					<td  class="gridheadercell" height="10px">REFER</td>
					<td  class="gridheadercell" height="10px">Remarks</td>
					<td  class="gridheadercell" height="10px">Slot Loss</td>
				</tr>
				<c:set var="index" value="0"></c:set>
				<%
					int i = 1;
				%>
				<c:forEach var="slotmessageList" items="${mainObject.slotmessageList}"> <!-- /containerList -->
					<tr>
						<td class="tablespace" height="10px"><span class=normal><%=i++%></span></td>
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.voyage}</span></td>
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.mloname}</span></td>
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.pol}</span></td>
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.pod}</span></td>
		
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.containerType}</span></td>
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.containerNO}</span></td>
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.slotsize}</span></td>
		
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.weight}</span></td>
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.imco}</span></td>
		
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.refer}</span></td>
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.remarks}</span></td>
						<td class="tablespace" height="10px"><span class=normal>${slotmessageList.slotloss}</span></td>						
					</tr>
				</c:forEach>
			</table>
		</div>
		<!-- <table border="0" width="90%" cellpadding="0" cellspacing="0" height="90%">
			<tr>
				<td class="" colspan="12" height="10px"></td>
			</tr>
		</table> -->
		</div>
	</c:forEach>
	</body>
</html>
<!-- <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> -->
