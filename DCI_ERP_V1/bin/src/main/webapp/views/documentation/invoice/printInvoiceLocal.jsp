<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

.width_8 {
	width: 8%;
}

.width_12 {
	width: 12%;
}

.width_48 {
	width: 48%;
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

@media print {
	.page-break {
		display: block;
		page-break-after: always;
	}
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

.padding-bottom-15p {
	padding-bottom: 15px;
}

.padding-bottom-20p {
	padding-bottom: 20px;
}

.padding-left-5p {
	padding-left: 5px;
}

.padding-5p {
	padding: 5px
}

.custom-color-1 .table-striped>thead>tr>th {
	color: #fff;
	border-bottom: 1px solid rgba(255, 255, 225, .15);
	border-left: 1px solid rgba(255, 255, 225, .15);
	border-top: 1px solid rgba(255, 255, 225, .15);
	background: #42a5f5 !important;
}

.padding-left-0 {
	padding-left: 0px !important;
}

.padding-top-5 {
	padding-top: 5px !important;
}

span.f1 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	text-decoration: none;
	width: 25%;
}

footer {
	font-size: 9px;
	color: #f00;
	text-align: center;
	display: table-footer-group;
}
</style>
</head>
<!-- <div>
	<img src="/img/MBKHelpVideos/mbk_image.png"
		style="float: left !important; padding: 0px 0px 0px 15px !important; float: left !important; height: 40px; width: 200px;">
	<img src="http://213.42.28.72:8082/img/csl.png"
		style="float: right !important; padding: 0px 15px 0px 0px !important; height: 40px;">
</div> -->

<br>
<c:set var="hdr" value="${masterList}" />
<c:set var="bank" value="${bankDetailList}" />
<!-- <br>
<br> -->
<div style="text-align: center; font-family: Tahoma !important;">
	<%-- <div>
		<b><span style='margin-left: -293px;'>${hdr.agentName}</span></b>
	</div> --%>
	
	<%-- <c:if test="${hdr.agentAddress1 != ''}">

	<p style="padding: 8px;">
	<span><b>${hdr.agentName}</b></span><br>
	<span style="font-size: 12px;">${hdr.agentAddress}</span><br>
 	<span style="font-size: 12px;">${hdr.agentAddress1}</span><br> 
	<span style="font-size: 11px;">(As Agents For CORDELIA CONTAINER SHIPPING LINE, CYPRUS)</span>
	</p>		
		</c:if>
		
	<c:if test="${hdr.agentAddress1 == ''}">

	<p style="padding: 8px;">
	<span><b>${hdr.agentName}</b></span><br>
	<span style="font-size: 12px;">${hdr.agentAddress}</span><br>
	<span style="font-size: 11px;">(As Agents For CORDELIA CONTAINER SHIPPING LINE, CYPRUS)</span>
	</p>		
		</c:if>	 --%>	

	<%-- <span style="font-size: 12px;">${hdr.customerAddress}${hdr.customerAddress1}</span> <br> 
	<span style="font-size: 11px;">(As Agents For CORDELIA CONTAINER SHIPPING LINE, CYPRUS)</span> <br> --%>
<tr>
							<td width="100%" style="text-align: center;">
								<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="" align="center">
									<tr>
										<td width="40%"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 0px 0 0 40px; height: 65px;"></td>                                   
										<td width="60%" style="word-wrap: break-word;padding-left: 2%;padding-right: 2%;">
											<span style="text-align: left;font-size: 17px;"><b>${hdr.branchName}</b></span> <br> <br> 
										<p style="text-align: right">	<span style="text-align: left;font-size: 15px;">${hdr.branchAddress1}</span> <br> 
											<span style="text-align: left;font-size: 14px;">
												<c:if test="${hdr.branchGstno != null && hdr.branchGstno != ''}">GSTNO : ${hdr.branchGstno} <br></c:if> 
												<c:if test="${hdr.stateNameNew != null && hdr.stateNameNew != ''}">State Name : ${hdr.stateNameNew} 
													<c:if test="${hdr.stateCode != null && hdr.stateCode != ''}">, Code : ${hdr.stateCode}</c:if><br> 
												</c:if> 
												<c:if test="${hdr.cin != null && hdr.cin != ''}">CIN : ${hdr.cin} <br></c:if> 
												<c:if test="${hdr.mailId != null && hdr.mailId != ''}">E-mail : ${hdr.mailId}</c:if>
											</span></p>
										</td>
										<!-- <td width="10%">
										</td> -->									
									</tr>
								</table>
							</td>

						</tr>
</div>
<%-- <table width="100%"
	style="font-family: verdana !important; font-size: 12px;">
	    <tr>
	    			<td style="width: 26%;"><c:if test="${hdr.cin != '' and hdr.currency == 'INR'}"><b>PAN NO:</b> ${hdr.cin}</c:if></td>

		</tr>
		<tr>
		<c:if test="${hdr.currency != 'INR'}">
			<td style="width: 26%;"><b>VAT #</b> ${bank[0].gstVat}</td>
		</c:if>
		<c:if test="${hdr.currency == 'INR'}">
			<td style="width: 26%;"><b>GST #</b> ${bank[0].gstVat}</td>
		</c:if>
		<td><p
				style="font-size: 17px; font-weight: bold; margin: 2px 0px 0px 330px; text-align: center; margin: 0px; margin-left: -200px;">Tax
				Invoice</p></td>


	</tr>
</table> --%>

<table width="100%"
	style="border: 1px solid; font-family: verdana !important; font-size: 12px;">
	<tbody style="line-height: 5px;">
		<tr>
			<td class="fntSiz10px" colspan="13" rowspan="6"
				style="width: 57%; vertical-align: baseline; padding-top: 15px;"><b>Customer:</b>
				${hdr.customerName}<br> <br> <br><b>Address:</b>
				<span style="line-height: 13px;">${hdr.customerAddress} </span><br> <br>
				<span style="line-height: 13px;">${hdr.city}</span><br> <br> <br> <br>
				${hdr.countryName}<br> <br> <br> <br> <span
				style="font-weight: bold">Tel # :</span>${hdr.phoneNo}</td>
			<td class="fntSiz10px"
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center; font-weight: bold;">
				Invoice #</td>
			<td class="fntSiz10px"
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center; font-weight: bold;">Inv
				Date</td>
		</tr>
		<tr>
			<td class="fntSiz10px"
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center;">${hdr.invoiceNo}
			</td>
			<td class="fntSiz10px"
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center;">${hdr.billDate}
			</td>
		</tr>
		<tr>
			<td class="fntSiz10px"
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center; font-weight: bold;">Cust
				ID</td>
			<td class="fntSiz10px"
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center; font-weight: bold;">Due
				Date</td>
		</tr>
		<tr>
			<td class="fntSiz10px"
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center;">${hdr.customer}
			</td>
			<td class="fntSiz10px"
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted;">
			</td>
		</tr>
		<tr>
			<td class="fntSiz10px" colspan='2'
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center; font-weight: bold; text-align: center;">B/L
				Number</td>

		</tr>
		<tr>
			<td class="fntSiz10px" colspan='2'
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center;">${hdr.blNo}
			</td>

		</tr>
		
		<tr>
			<td class="fntSiz10px" colspan="13"
				style="width: 34%; border-top: 1px solid; font-weight: bold; text-align: center;">
				Vessel & Voyage</td>
<!-- 			<td class="fntSiz10px" colspan="6" -->
<!-- 				style="width: 33%; border-top: 1px solid; border-left: 1px dotted; text-align: center; font-weight: bold;">Voyage -->
<!-- 			</td> -->
			<!-- <td class="fntSiz10px" colspan="2"
				style=" border-top: 1px solid; border-left: 1px dotted;text-align: center; border-bottom: 1px dotted;font-weight: bold;">Sailing Date
			</td> -->

			<td class="fntSiz10px" colspan='2'
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center; font-weight: bold; text-align: center;">Sailing
				Date</td>


		</tr>

		<tr>
			<td class="fntSiz10px" colspan="13"
				style="width: 34%; border-top: 1px solid; text-align: center;">
				${hdr.voyage}</td>
<!-- 			<td class="fntSiz10px" colspan="6" -->
<%-- 				style="width: 33%; border-top: 1px solid; border-left: 1px dotted; text-align: center;">${hdr.voyageName} --%>
<!-- 			</td> -->
			<%-- <td class="fntSiz10px" colspan="2"
				style=" border-top: 1px solid; border-left: 1px dotted;text-align: center; border-bottom: 1px dotted;font-weight: bold;">${hdr.vsSailingDate}
			</td> --%>
			<td class="fntSiz10px" colspan='2'
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center;">${hdr.vsSailingDate}
			</td>


		</tr>
		<tr>
			<td class="fntSiz10px" colspan="3" rowspan="2"
				style="width: 20%; border-top: 1px solid; font-weight: bold;">
				<c:if test="${hdr.currency != 'INR'}"> 
				Customer VAT # 
				</c:if> <c:if test="${hdr.currency == 'INR'}"> 
				Customer GST #
				</c:if>
			</td>
			<c:if test="${hdr.currency == 'INR'}"> 
			<td class="fntSiz10px" colspan="4" rowspan="2"
				style="width: 20%; border-top: 1px solid; border-left: 1px dotted; text-align: center;">${hdr.gst}
			</td>
			</c:if>
			<c:if test="${hdr.currency != 'INR'}"> 
			<td class="fntSiz10px" colspan="4" rowspan="2"
				style="width: 20%; border-top: 1px solid; border-left: 1px dotted; text-align: center;">${hdr.vatno}
			</td>
			</c:if>
			<td class="fntSiz10px" colspan="6"
				style="width: 27%; border-top: 1px solid; border-left: 1px dotted; text-align: center; border-bottom: 1px dotted; font-weight: bold;">POL
			</td>

			<td class="fntSiz10px" colspan='2'
				style="height: 18px; border-bottom: 1px dotted; border-left: 1px dotted; text-align: center; font-weight: bold;">POD
			</td>
		</tr>

		<tr>

			<td class="fntSiz10px" colspan="6"
				style="height: 18px; border-left: 1px dotted; text-align: center;">${hdr.pol}
			</td>
			<td class="fntSiz10px" colspan='2'
				style="height: 18px; border-left: 1px dotted; text-align: center;">${hdr.pod}
			</td>
		</tr>
	</tbody>

</table>



<table width="100%"
	style="border: 1px solid; border-top: 0px; font-family: verdana !important; font-size: 12px;">
	<tbody style="line-height: 5px;">
		 <tr style="
    word-wrap: break-word;
    line-height: 15px;
">
			<th class="fntSiz10px" colspan="10"
				style=" text-align: center; font-weight: bold;width:40%;">DESCRIPTION
				OF CHARGES</th>
			<th class="fntSiz10px"
				style="height: 18px; border-left: 1px dotted; text-align: center; font-weight: bold;width: 5%;">Qty
			</th>
			<th class="fntSiz10px"
				style="height: 18px; border-left: 1px dotted; text-align: center; font-weight: bold;width: 5%;">Curr
			</th>
			<th class="fntSiz10px"
				style="height: 18px; border-left: 1px dotted; text-align: center; font-weight: bold;width: 5%;">Rate/Unit
			</th>
			<c:if test="${hdr.currency != 'AED'}">
			<th class="fntSiz10px"
				style="height: 18px; border-left: 1px dotted; text-align: center; font-weight: bold;width: 5%;">Amount
			</th>
			</c:if>
			<th class="fntSiz10px"
				style="height: 18px; border-left: 1px dotted; text-align: center; font-weight: bold;width: 5%;">Ex.Rt
			</th>
			<c:if test="${hdr.currency == 'AED'}"> 
			<th class="fntSiz10px"
				style="height: 18px; border-left: 1px dotted;text-align: center; font-weight: bold;width: 15%;">Amount (USD)
			</th>
			</c:if>
			<th class="fntSiz10px"
				style="height: 18px; border-left: 1px dotted; text-align: center; font-weight: bold;width: 15%;">Amount (${hdr.currency})</th>
		</tr>










		<tr style="height: 240px !important;">

			<td class="" colspan="10"
				style="word-wrap: break-word;
     border-top: 1px solid; font-size: 9px; vertical-align: baseline; padding-top: 5px;">
				<c:forEach var="ob" items="${middleList}">
				
				<span style="font-weight: bold;line-height:13px">${ob.chargeTypeName}</span>
							
							
				<c:if test="${ob.sealNo != '-'}"> 
 				  <span style="font-weight: bold;line-height:13px"> (SAC:<c:out 
 							value="${ob.sealNo}" />)</span> 
 							</c:if> 
							
					<br>
					
					<span style="font-size: 8px;"> ${ob.cntrType} / <fmt:formatNumber
							type="number" groupingUsed="true" 
							value="${ob.rate}" /> ${ob.uom}
					</span>
					<br><br>
					
					
					
				</c:forEach>
			</td>

			<td class=""
				style="height: 25px; border-left: 1px dotted; border-top: 1px solid; vertical-align: baseline; padding-top: 5px; font-size: 11px; text-align: center;">
				<c:forEach var="ob" items="${middleList}">
					<c:if test="${ob.uom != 'PER BL'}"> 
					${ob.quantity}
					</c:if>
					<c:if test="${ob.uom == 'PER BL'}"> 
					1
					</c:if>
					<br>
					<br>
					<br>
					<br>
					<br>
					
					
					
					
					
				</c:forEach>
			</td>



			<td class=""
				style="height: 25px; border-left: 1px dotted; border-top: 1px solid; vertical-align: baseline; padding-top: 5px; font-size: 11px; text-align: center;">
				<c:forEach var="ob" items="${middleList}">
					 ${ob.currency }
					<br>
					<br>
					<br>
					<br>
					<br>
					
					
					
				
				</c:forEach>
			</td>
			<td class=""
				style="height: 25px; border-left: 1px dotted; border-top: 1px solid; vertical-align: baseline; padding-top: 5px; font-size: 11px; text-align: right;">
				<c:forEach var="ob" items="${middleList}">
					<fmt:formatNumber type="number" groupingUsed="true"
						 value="${ob.rate}" />
<%-- 						value="${fn:substringBefore(ob.rate, '.')}" --%>
				<br>
					<br>
					<br>
					<br>
				<br>
					
				
					
				</c:forEach>
			</td>

			<c:if test="${hdr.currency != 'AED'}"> 
			<td class=""
				style="height: 25px; border-left: 1px dotted; border-top: 1px solid; vertical-align: baseline; padding-top: 5px; font-size: 11px; text-align: right;">
				<c:forEach var="ob" items="${middleList}">
				<c:if test="${ob.uom != 'PER BL'}"> 
						<fmt:formatNumber type="number" groupingUsed="true"
						value="${ob.quanrate}" />
						</c:if>
							<c:if test="${ob.uom == 'PER BL'}"> 
							<fmt:formatNumber type="number" groupingUsed="true"
						value="${ob.rate}" />
							</c:if>

					<br>
					<br>
					<br>
					<br>
				<br>
					
					
					
					
						<c:if test="${ob.uom != 'PER BL'}"> 
					<c:set var="subTotal" value="${subTotal + ob.quanrate}" />
					</c:if>
					<c:if test="${ob.uom == 'PER BL'}"> 
					<c:set var="subTotal" value="${subTotal + ob.rate}" />
					</c:if>
				</c:forEach>
			</td>
</c:if>
			<td class=""
				style="height: 25px; border-left: 1px dotted; border-top: 1px solid; vertical-align: baseline; padding-top: 5px; font-size: 11px; text-align: right;">
				<c:forEach var="ob" items="${middleList}">
					${ob.exchangeRate}
					<br>
					<br>
					<br>
					<br>
					<br>
					
					
					
					
				</c:forEach>
			</td>
			
			<c:if test="${hdr.currency == 'AED'}"> 
			<td class=""
				style="height: 25px; border-left: 1px dotted; border-top: 1px solid; vertical-align: baseline; padding-top: 5px; font-size: 11px; text-align: right;">
				<c:forEach var="ob" items="${middleList}">
				<c:if test="${ob.uom != 'PER BL'}"> 
						<fmt:formatNumber type="number" groupingUsed="true"
						value="${ob.amount}" />
						</c:if>
						
							<c:set var="subTotalexchangeBC"
							value="${subTotalexchangeBC + (ob.amount)}" />
						
						
						
						
							<c:if test="${ob.uom == 'PER BL'}"> 
							<fmt:formatNumber type="number" groupingUsed="true"
						value="${ob.amount}" />
						

				
						
							</c:if>

					<br>
					<br>
					<br>
					<br>
					<br>
					
					
					
						<c:if test="${ob.uom != 'PER BL'}"> 
					<c:set var="subTotal" value="${subTotal + ob.amount}" />
					</c:if>
					<c:if test="${ob.uom == 'PER BL'}"> 
					<c:set var="subTotal" value="${subTotal + ob.rate}" />
					</c:if>
				</c:forEach>
			</td>
</c:if>
			<td class=""
				style="height: 25px; border-left: 1px dotted; border-top: 1px solid; vertical-align: baseline; padding-top: 5px; font-size: 11px; text-align: right;">
				<c:forEach var="ob" items="${middleList}">
					<c:if test="${ob.exchangeRate> 0}">
						<c:if test="${ob.uom != 'PER BL'}"> 
						<c:set var="amountcal" value="${ob.tcAmount}" />
						<fmt:formatNumber type="number" groupingUsed="true"
							
							value="${amountcal}" />
<%-- 							//value="${fn:substringBefore(amountcal, '.')}" --%>



						<c:set var="subTotalexchange"
							value="${subTotalexchange + (ob.tcAmount)}" />
						<c:if test="${ob.tax > 0}">
							<c:set var="taxableamount"
								value="${taxableamount + (ob.tcAmount)}" />
							<c:set var="taxpercent" value="${ob.tax}" />
						</c:if>
						</c:if>
						
						<c:if test="${ob.uom == 'PER BL'}"> 
						<c:set var="amountcal" value="${ob.tcAmount}" />
						<fmt:formatNumber type="number" groupingUsed="true"
							
							value="${amountcal}" />
<%-- 							value="${fn:substringBefore(amountcal, '.')}" /> --%>



						<c:set var="subTotalexchange"
							value="${subTotalexchange + (ob.tcAmount)}" />
						<c:if test="${ob.tax > 0}">
							<c:set var="taxableamount"
								value="${taxableamount + (ob.tcAmount)}" />
							<c:set var="taxpercent" value="${ob.tax}" />
						</c:if>
						</c:if>
						
					</c:if>

					<c:if test="${ob.exchangeRate<0 || ob.exchangeRate == null}"> 
						<c:if test="${ob.uom != 'PER BL'}"> 
					${ob.amount} <c:set var="subTotalexchange"
							value="${subTotalexchange + (ob.amount)}" />
						<c:if test="${ob.tax > 0}">
							<c:set var="taxableamount" value="${taxableamount + (ob.amount)}" />
							<c:set var="taxpercent" value="${ob.tax}" />
						</c:if>
						</c:if>
							<c:if test="${ob.uom == 'PER BL'}"> 
							${ob.rate} <c:set var="subTotalexchange"
							value="${subTotalexchange + (ob.rate)}" />
						<c:if test="${ob.tax > 0}">
							<c:set var="taxableamount" value="${taxableamount + (ob.rate)}" />
							<c:set var="taxpercent" value="${ob.tax}" />
						</c:if>
							</c:if>

					</c:if>
					<br>
					<br>
					<br>
					<br>
					<br>
					
					

				</c:forEach>
			</td>
		</tr>

<c:if test="${hdr.currency != 'AED'}"> 
		<tr>

			<td class="fntSiz10px" colspan="13"
				style="width: 68%; border-top: 1px dotted; font-weight: bold;">Subtotal</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; font-weight: bold; text-align: right;">
	

			</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold;">
			</td>
			
			
			<td class="fntSiz10px"  
				style="height: 25px;  word-wrap: break-word;
    line-height: 15px;border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">${hdr.currency}
				<fmt:formatNumber type="number" groupingUsed="true"
					value="${subTotalexchange}" />

			</td>
		</tr>
		
		</c:if>
		
		
<c:if test="${hdr.currency == 'AED'}"> 
		<tr>

			<td class="fntSiz10px" colspan="13"
				style="width: 68%; border-top: 1px dotted; font-weight: bold;">Subtotal</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; font-weight: bold; text-align: right;">
			

			</td>
			
				<td class="fntSiz10px"  
				style="height: 25px;  word-wrap: break-word;
    line-height: 15px;border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">USD
				<fmt:formatNumber type="number" groupingUsed="true"
					value="${subTotalexchangeBC}" />

			</td>
			<td class="fntSiz10px"  
				style="height: 25px;  word-wrap: break-word;
    line-height: 15px;border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">${hdr.currency}
				<fmt:formatNumber type="number" groupingUsed="true"
					value="${subTotalexchange}" />

			</td>
		</tr>
		
		</c:if>
		
	<%-- <tr>	

			<td class="fntSiz10px" colspan="13"
				style="width: 68%; border-top: 1px dotted; font-weight: bold;">Taxable
				Amount</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; text-align: right;">
			</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; text-align: right;">
			</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">
				<fmt:formatNumber type="number" groupingUsed="true"
					value="${taxableamount}" />


			</td>
		</tr> --%>
		<%-- <tr>

			<c:if test="${hdr.currency == 'INR'}">
				<c:if test="${hdr.showIgst == 'Yes'}">

					<td class="fntSiz10px" colspan="13"
						style="width: 68%; border-top: 1px dotted; font-weight: bold;">IGST
						(%)</td>
				</c:if>
				<c:if test="${hdr.showIgst == 'No'}">

					<td class="fntSiz10px" colspan="13"
						style="width: 68%; border-top: 1px dotted; font-weight: bold;">SGST
						(%)</td>
				</c:if>
			</c:if>
			<c:if test="${hdr.currency != 'INR'}">
				<td class="fntSiz10px" colspan="13"
					style="width: 68%; border-top: 1px dotted; font-weight: bold;">VAT Standard Rate
					(%)</td>
			</c:if>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; text-align: right;">
			</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">
				<c:if test="${hdr.currency == 'INR'}">
				<c:if test="${hdr.showIgst == 'Yes'}">
				<fmt:formatNumber type="number" maxIntegerDigits="3"
					value="${taxpercent}" />%
					</c:if>
					<c:if test="${hdr.showIgst == 'No'}">
					<fmt:formatNumber type="number" maxIntegerDigits="3"
					 value="${taxpercent/2}" />%
					</c:if>
					</c:if>
					<c:if test="${hdr.currency != 'INR'}">
					<fmt:formatNumber type="number" maxIntegerDigits="3"
					value="${taxpercent}" />%
					</c:if>
			</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; text-align: right;">
			</td>
		</tr> --%>

		<%-- <c:if test="${hdr.currency == 'INR'}">
			<c:if test="${hdr.showIgst == 'No'}">
				<tr>
					<td class="fntSiz10px" colspan="13"
						style="width: 68%; border-top: 1px dotted; font-weight: bold;">CGST
						(%)</td>


					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; text-align: right;">
					</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">
						<fmt:formatNumber type="number" maxIntegerDigits="3"
							value="${taxpercent/2}" />%
					</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; text-align: right;">
					</td>
				</tr>
			</c:if>
		</c:if>
		 --%>
		
		<%-- <c:if test="${hdr.currency != 'INR'}">
			
				<tr>
					<td class="fntSiz10px" colspan="13"
						style="width: 68%; border-top: 1px dotted; font-weight: bold;">VAT Zero Rate (%)</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; text-align: right;">
					</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; text-align: right;">
					</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">
						0%
						
					</td>
				</tr>
				
				<tr>
					<td class="fntSiz10px" colspan="13"
						style="width: 68%; border-top: 1px dotted; font-weight: bold;">VAT Out of Scope (%)</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; text-align: right;">
					</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; text-align: right;">
					</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">
						0%
						
					</td>
				</tr>
			
		</c:if> --%>


		<%-- <tr>
			<c:if test="${hdr.currency == 'INR'}">
				<c:if test="${hdr.showIgst == 'Yes'}">
					<td class="fntSiz10px" colspan="13"
						style="width: 68%; border-top: 1px dotted; font-weight: bold;">IGST
						Amount</td>
				</c:if>
				<c:if test="${hdr.showIgst == 'No'}">
					<td class="fntSiz10px" colspan="13"
						style="width: 68%; border-top: 1px dotted; font-weight: bold;">SGST
						Amount</td>
				</c:if>
			</c:if>
			<c:if test="${hdr.currency != 'INR'}">
				<td class="fntSiz10px" colspan="13"
					style="width: 68%; border-top: 1px dotted; font-weight: bold;">VAT
					Amount</td>
			</c:if>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; text-align: right;">
			</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; text-align: right;">
			</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">
				${hdr.currency} 
				<c:if test="${hdr.currency == 'INR'}">
				<c:if test="${hdr.showIgst == 'Yes'}">
				<fmt:formatNumber
					
					value="	${hdr.igstamount}" />
				</c:if>
				<c:if test="${hdr.showIgst == 'No'}">
				<fmt:formatNumber
					
					value="	${hdr.sgstamount}" />
				</c:if>
				</c:if>
				<c:if test="${hdr.currency != 'INR'}">
<fmt:formatNumber
					
					value="	${hdr.vatamount}" />
				</c:if>
				
			</td>
		</tr>
 --%>
		<%-- <c:if test="${hdr.currency == 'INR'}">
			<c:if test="${hdr.showIgst == 'No'}">
				<tr>
					<td class="fntSiz10px" colspan="13"
						style="width: 68%; border-top: 1px dotted; font-weight: bold;">CGST
						Amount</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; text-align: right;">
					</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; text-align: right;">
					</td>
					<td class="fntSiz10px"
						style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">
						${hdr.currency} 
						<fmt:formatNumber
					
					value="	${hdr.cgstamount}" />
					</td>
				</tr>
			</c:if>
		</c:if>
		 --%>
		

		<tr>

			<td class="fntSiz10px" colspan="13"
				style="width: 68%; border-top: 1px dotted; font-weight: bold;">Total
				Amount</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; width: 14%; border-top: 1px dotted; font-weight: bold; text-align: right;">
				<%-- <fmt:formatNumber type = "number" 
         groupingUsed = "false" value = "${subTotal}" /> --%>
			</td>
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; text-align: right;">
			</td>
			<%-- <c:if test="${hdr.currency != 'INR'}">
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">${hdr.currency}
				<c:set var="totaltaxAmount" value="${((taxpercent)/100)*taxableamount}" /> 
				<c:set var="finalAmt" value="${subTotalexchange + totaltaxAmount}" /> <fmt:formatNumber
					type="number" groupingUsed="true" 
					value="${finalAmt}" />

			</td>
			</c:if> --%>
			
			<td class="fntSiz10px"
				style="height: 25px; border-left: 1px dotted; border-top: 1px dotted; font-weight: bold; text-align: right;">
				${hdr.currency}
				 <fmt:formatNumber
					
					value="	${hdr.grandTotal}" />
			
			

			</td>
			
		</tr>
		<tr>

			<td class="fntSiz10px" colspan="16"
				style="width: 68%; height: 25px; border-top: 1px dotted; font-weight: bold; font-size: 11px;">
				In Words: <c:if test="${hdr.currency == 'INR'}">Rupees </c:if>
				
				${hdr.amountWords}

			</td>
	  </tr>

		<tr>
			<td class="fntSiz10px" colspan="16"
				style="width: 100%; height: 25px; border-top: 1px dotted; font-weight: bold; font-size: 11px;">
				Note: In case of any discrepancies, please notify within 7 days of receipt of this Invoice.</td>

		</tr>
	</tbody>

</table>

<c:if test="${hdr.currency != 'AED'}">


<c:choose>

 <c:when test="${bankDetailList.size() > 1}">
 
 
 
 <%-- <table width="100%" style="border: 1px solid; border-top: 0px; font-family: verdana !important; font-size: 12px;">
	<tbody style="line-height: 5px;">
		<tr>
			<td class="fntSiz10px" colspan="14"
				style="width: 100%; height: 15px; text-align: center;font-size:11px; font-weight: bold;">BANK
				ACCOUNT DETAILS</td>

		</tr>
		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;">Beneficiary
				Name</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: center;font-size:10px;">ICICI Bank${bank[0].benficiaryName}</td>
			<td class="fntSiz10px" colspan='5' rowspan='10'
				style="height: 15px;font-size:10px; border-top: 1px solid; width: 30%; vertical-align: top; padding-top: 11px;">
				<b>Invoice Issued by:</b> <br> <br> <br>
				<div style="line-height: 15px;font-size:10px;">${hdr.agentName}</div> <br> <br> <br> As Agents <br>
				<br> <br>
				<div style="line-height: 15px;font-size:10px;">For MBK Logistix Private Limited </div>
			</td>

		</tr>
		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid;">Bank
				Name</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid; text-align: center;">${bank[0].bankName}</td>


		</tr>

		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid;">Swift
				Code</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid; text-align: center;">${bank[0].swiftCode}</td>


		</tr>
		
			<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid;"></td>
			<td class="fntSiz10px" colspan='6'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid; text-align: center;"><b>Account Details	
				</b></td>
			</tr>
			
			<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;"></td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px;font-size:11px; border-top: 1px solid; border-right: 1px solid; text-align: center;"><b>For ${hdr.currency}  Remittance	
				</b></td>
		   <td class="fntSiz10px" colspan='3'
				style="height: 15px; font-size:11px;border-top: 1px solid; border-right: 1px solid; text-align: center;"><b>For USD Remittance	
				</b></td>		
			</tr>


		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;">Account
				#</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: center;font-size:10px;">${bank[0].accNo}</td>

            <td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: center;font-size:10px;">${bank[1].accNo}</td>
		</tr>

		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;">

				<c:if test="${hdr.currency == 'INR'}">  IFSC Code:</c:if>  <c:if
					test="${hdr.currency != 'INR'}"> Bank Code:</c:if> 

			</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: center;font-size:10px;">
				<c:if test="${hdr.currency == 'INR'}">	
				${bank[0].ifsc}
				</c:if>
				<c:if test="${hdr.currency != 'INR'}">	
				${bank[0].iban}
				</c:if>
				</td>
				
				
		<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: center;font-size:10px;">
					<c:if test="${hdr.currency == 'INR'}">	
				${bank[1].ifsc}
				</c:if>
				<c:if test="${hdr.currency != 'INR'}">	
				${bank[1].iban}
				</c:if>
				</td>		


		</tr>
		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;">Intermediary
				Bank</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left;font-size:10px;">${bank[0].usdIBANNo}</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;text-align: left;font-size:10px;">${bank[1].usdIBANNo}</td> 

		</tr>


		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;padding-top:3px;">Intermediary
				Bank Swift Code
			</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left;font-size:10px;">${bank[1].usdIBANNo}</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;text-align: left;font-size:10px;">${bank[1].usdIBANNo}</td>

		</tr>


	</tbody>

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

    
    

</c:when>
<c:otherwise>

<%-- <table width="100%"
	style="border: 1px solid; border-top: 0px; font-family: verdana !important; font-size: 12px;">
	<tbody style="line-height: 5px;">
		<tr>
			<td class="fntSiz10px" colspan="14"
				style="width: 100%; height: 25px; text-align: center; font-weight: bold;">BANK
				ACCOUNT DETAILS</td>

		</tr>
		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid;">Beneficiary
				Name</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid; text-align: left;">${bank[0].benficiaryName}</td>
			<td class="fntSiz10px" colspan='5' rowspan='10'
				style="height: 25px; border-top: 1px solid; width: 30%; vertical-align: top; padding-top: 11px;">
				<b>Invoice Issued by:</b> <br> <br> <br>
				<div style="line-height: 15px;">${hdr.agentName}</div> <br> <br> <br> As Agents <br>
				<br> <br>
				<div style="line-height: 15px;">For MBK Logistix Private Limited </div>
			</td>

		</tr>
		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid;">Bank
				Name</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid; text-align: left;">${bank[0].bankName}</td>


		</tr>

		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid;">Swift
				Code</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid; text-align: left;">${bank[0].swiftCode}</td>


		</tr>


		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid;">Account
				#</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid; text-align: left;">${bank[0].accNo}</td>


		</tr>

		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid;">

				<c:if test="${hdr.currency == 'INR'}">  IFSC Code:</c:if> <c:if
					test="${hdr.currency != 'INR'}"> Bank Code:</c:if>

			</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 25px; border-top: 1px solid; border-right: 1px solid; text-align: left;">
			<c:if test="${hdr.currency == 'INR'}">	
				${bank[0].ifsc}
				</c:if>
				<c:if test="${hdr.currency != 'INR'}">	
				${bank[0].iban}
				</c:if>
				</td>


		</tr>

	</tbody>

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

      
  </c:otherwise>


</c:choose>


</c:if>


<c:if test="${hdr.currency == 'AED'}">
<%-- <table width="100%"
	style="border: 1px solid; border-top: 0px; font-family: verdana !important; font-size: 12px;">
	<tbody style="line-height: 5px;">
		<tr>
			<td class="fntSiz10px" colspan="14"
				style="width: 100%; height: 15px; text-align: center;font-size:11px; font-weight: bold;">BANK
				ACCOUNT DETAILS</td>

		</tr>
		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;">Beneficiary
				Name</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left;font-size:10px;">${bank[0].benficiaryName}</td>
			<td class="fntSiz10px" colspan='5' rowspan='10'
				style="height: 15px;font-size:10px; border-top: 1px solid; width: 30%; vertical-align: top; padding-top: 11px;">
				<b>Invoice Issued by:</b> <br> <br> <br>
				<div style="line-height: 15px;font-size:10px;">${hdr.agentName}</div> <br> <br> <br> As Agents <br>
				<br> <br>
				<div style="line-height: 15px;font-size:10px;">For MBK Logistix Private Limited </div>
			</td>

		</tr>
		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid;">Bank
				Name</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid; text-align: left;">${bank[0].bankName}</td>


		</tr>

		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid;">Swift
				Code</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid; text-align: left;">${bank[0].swiftCode}</td>


		</tr>
		
			<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid;"></td>
			<td class="fntSiz10px" colspan='6'
				style="height: 15px;font-size:10px; border-top: 1px solid; border-right: 1px solid; text-align: center;"><b>Account Details	
				</b></td>
			</tr>
			
			<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;"></td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px;font-size:11px; border-top: 1px solid; border-right: 1px solid; text-align: center;"><b>For AED Remittance	
				</b></td>
		   <td class="fntSiz10px" colspan='3'
				style="height: 15px; font-size:11px;border-top: 1px solid; border-right: 1px solid; text-align: center;"><b>For USD Remittance	
				</b></td>		
			</tr>


		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;">Account
				#</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left;font-size:10px;">${bank[0].accNo}</td>

            <td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left;font-size:10px;">${bank[1].accNo}</td>
		</tr>

		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;">

				<c:if test="${hdr.currency == 'INR'}">  IFSC Code:</c:if> <c:if
					test="${hdr.currency != 'INR'}"> Bank Code:</c:if>

			</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left;font-size:10px;">
			<c:if test="${hdr.currency == 'INR'}">	
				${bank[0].ifsc}
				</c:if>
				<c:if test="${hdr.currency != 'INR'}">	
				${bank[0].iban}
				</c:if>
				</td>
				
				
		<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left;font-size:10px;">
		<c:if test="${hdr.currency == 'INR'}">	
				${bank[1].ifsc}
				</c:if>
				<c:if test="${hdr.currency != 'INR'}">	
				${bank[1].iban}
				</c:if>
				</td>		


		</tr>


		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;">Intermediary
				Bank</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left;font-size:10px;">Not
				Applicable</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;text-align: left;font-size:10px;">${bank[1].usdIBANNo}</td> 

		</tr>


		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;font-size:10px;padding-top:3px;">Intermediary
				Bank Swift Code
			</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left;font-size:10px;">Not
				Applicable</td>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid;text-align: left;font-size:10px;">${bank[1].swiftCode}</td>

		</tr>

		<tr>
			<td class="fntSiz10px" colspan='3'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; font-weight: bold;font-size:10px;">Note:</td>
			<td class="fntSiz10px" colspan='6'
				style="height: 15px; border-top: 1px solid; border-right: 1px solid; text-align: left; font-weight: bold;font-size:10px;">IBAN
				Mandatory for the remittance into UAE</td>


		</tr>


	</tbody>

</table> --%>
</c:if>

<table class="width_95">
	<tr>
		<td class="normal">This is a Computer Generated Invoice and does not require
							physical signature.</td>

	</tr>
</table>

<div class="page-break" style="page-break-after: always;"></div>
<br>
<br>
<br>
<br>
<br>
<table border="1" width="90%" cellpadding="0" cellspacing="0"
	bgcolor="FFFFFF" bordercolor="#cccccc" align=center>
	<tr>
		<td class="gridheadercell" colspan="13">CONTAINERS DETAILS</td>
	</tr>
	<tr>
		<td class="gridheadercell">S.No</td>
		<td class="gridheadercell">TYPE</td>
		<td class="gridheadercell">CONTAINER No.</td>
	</tr>
	<c:set var="index" value="0"></c:set>
	<%
		int i = 1;
	%>
	<c:forEach var="slotmessageList" items="${containerList}">
		<tr>
			<td class="tablespace" align=center><span class=normal><%=i++%></span></td>
			<td class="tablespace" align=center><span class=normal>${slotmessageList.cntrType}</span></td>
			<td class="tablespace" align=center><span class=normal>${slotmessageList.containerNo}</span></td>
		</tr>
	</c:forEach>
</table>
<footer>
	<!--       This is the text that goes at the bottom of every page. -->
</footer>
</html>