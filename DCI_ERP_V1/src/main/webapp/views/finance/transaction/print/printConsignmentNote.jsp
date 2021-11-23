<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">


<title>Consignment Note</title>
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
	<c:set var="hdr" value="${header1}" />
	<c:set var="detailObj" value="${consDetail}" />

	<div id="content">
		<table class="width_100" height="95%" align="center" border="0"
			cellPadding="0" cellSpacing="0">
			<tr>
				<td>
					<table border="0" class="padding-top-5" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td width="20%" style="font-size: 10px; padding-bottom: 75px;">
							</td>
							<td width="60%" style="text-align: center;"><img
								src="${context}/img/interafrica_trans.png" style=" height: 190px;"></td>
							<td width="20%" style="font-size: 10px; padding-bottom: 75px;">P.O
								Box 80116 - 80100 Mombasa<br> 1st Floor, Biashara Building,<br>
								Nyerere Avenue<br> www.interafrica-haulage.com<br>
								+254 (0)417 333 044
							</td>
						</tr>
						<tr></tr>
						<tr>
							<td width="20%"></td>
							<td
								style="text-align: center; font-weight: bold; padding-top: 5px;">
								<u>CONSIGNMENT NOTE - OWNER'S RISK</u>
							</td>
							<td width="20%"></td>
						</tr>
						<tr>
							<td width="20%"></td>
							<td style="text-align: center; font-size: 10px;">GOODS
								STORED, HANDLED OR CARRIED ARE UNINSURED AND AT OWNER'S RISK</td>
							<td width="20%"></td>
						</tr>
					</table> <!-- 					<font size="4" class="padding-top-10" face="arial"><b>INVOICE</b></font> -->
					<p>
					<table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						<tr>
							<td width=24% height=100%>
								<table width=100% align="left" border="0" height=100%
									bordercolor="" cellPadding="0" cellSpacing="0">
									<tr>
										<td valign="top" class="padding-left-5"><span
											class="normal"> <b>Sender Name : ${hdr.senderName}<br>
													<br> Consignee Name : ${hdr.consigneeName}<br>
											</b></span></td>
									</tr>
								</table>
							</td>
							<td width=2% height=100%></td>
							<td width=24% height=100%>
								<table width=100% align="left" border="0" height=100%
									bordercolor="" cellPadding="0" cellSpacing="0">
									<tr>
										<td valign="top" class="padding-left-5"><span
											class="normal"> <b>Date : ${hdr.consignedDate}<br>
													<br> Address : ${hdr.address}<br>

											</b></span></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="4" class="padding-top-10">
								<table class="" align="left" border="1" bordercolor=""
									cellPadding="0" cellSpacing="0" width=100%>
									<thead>
										<tr class="">
											<th class="width_10" height="10" align="center"
												style="border-right: 0pt;"><span class="normal bold">Marks</span></th>
											<th class="width_15" height="10" align="center"
												style="border-right: 0pt;"><span class="normal bold">No.
													Of Articles</span></th>
											<th class="width_25" height="10" align="center"
												style="border-right: 0pt;"><span class="normal bold">Description</span></th>
											<th class="width_10" height="10" align="center"
												style="border-right: 0pt;"><span class="normal bold">Total
													Weight</span></th>
											<th class="width_10" height="10" align="center"
												style="border-right: 0pt;"><span class="normal bold">Shed
													Yard</span></th>
											<th class="width_10" height="10" align="center"
												style="border-right: 0pt;"><span class="normal bold">Ref.
													No.</span></th>
											<th class="width_15" height="10" align="center"
												style="border-right: 0pt;"><span class="normal bold">Ship's
													Name</span></th>
										</tr>
									</thead>
									<tbody>
										<!-- 										 <tr  border="0"> -->
										<!-- 											<td colspan="4" class="width_60" align="left" valign="top" class="tablespace"> -->
										<%-- 													<span class="normal"> ${object1.subject}</span> --%>
										<!-- 											</td>												 -->
										<!-- 										</tr>	 -->
										<%-- 										<c:forEach var="ob" items="${generalInvoiceList.giDtl}"  varStatus="theCount">  --%>
										<!-- 											<tr class="description"> -->
										<!-- 												<td class="subcolor width_70" height="10" align="left" valign="top" style="border-right: 0pt;"> -->
										<%-- 													<font face="arial" size="2"> Sub Group Code:- ${ob.subGroupCode}  </font><br>
<%-- 													<font class="bold" face="arial" size="2">${ob.subGroupName}</font><br>									 --%>
										<%-- 													<font face="arial" size="2"> Account Code:- ${ob.accountHead}</font><br> --%>
										<!-- 													<span class="normal">  -->
										<%-- 													<font class="" face="arial" size="2">${ob.accountHeadName}</font> --%>
										<%-- 															<c:if test="${theCount.count == 1}"> --%>
										<!-- 																<b></b> -->
										<%-- 															</c:if> --%>
										<%-- 													<br><font class="" face="arial" size="2">${ob.narration}</font> --%>

										<!-- 													</span><br> -->

										<%-- 													<c:if test="${object1.vesselName ==''}"> --%>
										<%-- 													<c:choose> --%>
										<%-- 													    <c:when test="${empty ob.vesselCode}"> --%>
										<!-- 															<font class="" face="arial" size="2"></font>												         -->
										<%-- 													    </c:when> --%>
										<%-- 													    <c:otherwise> --%>
										<%-- 													        <font class="" face="arial" size="2"> <b>Vessel:</b> ${ob.vesselName} </font> --%>
										<%-- 													    </c:otherwise> --%>
										<%-- 													</c:choose>	 --%>
										<%-- 													</c:if> --%>

										<%-- 													<c:if test="${object1.voyage ==''}">														 --%>
										<%-- 													<c:choose> --%>
										<%-- 													    <c:when test="${empty ob.voyageCode}"> --%>
										<!-- 															<font class="" face="arial" size="2"></font>												         -->
										<%-- 													    </c:when> --%>
										<%-- 													    <c:otherwise> --%>
										<%-- 													        <font class="" face="arial" size="2"> <b>Voyage:</b> ${ob.voyageCode} </font><br> --%>
										<%-- 													    </c:otherwise> --%>
										<%-- 													</c:choose>	 --%>
										<%-- 													</c:if> --%>
										<%-- 													<c:choose>
<%-- 													    <c:when test="${empty ob.sectorCode}"> --%>
										<%-- 															<font face="arial" size="2"></font>												         --%>
										<%-- 													    </c:when> --%>
										<%-- 													    <c:otherwise> --%>
										<%-- 													        <font face="arial" size="2"> <b>Service:</b> ${ob.sectorCode} - ${ob.sectorName}</font> --%>
										<%-- 													    </c:otherwise> --%>
										<%-- 													</c:choose>  --%>
										<!-- 												</td> -->

										<%-- 												<td class="subcolor width_20 text-wrap" align="left"  valign="top" nowrap="nowrap">
<%-- 													<font class="bold" face="arial" size="2">${ob.subAccountName}</font> --%>
										<%-- 												</td> --%>


										<!-- 												<td class="subcolor width_15" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;"> -->
										<!-- 												<span class="normal">  -->
										<%-- 												${ob.tcAmount}  --%>
										<!-- 												</span></td> -->
										<!-- 												<td class="subcolor width_15" height="10" align="right" nowrap="nowrap" style="border-right: 0pt;"><span class="normal">  -->
										<%-- 												${ob.bcAmount}  --%>
										<!-- 												</span></td> -->
										<!-- 											</tr>	 -->
										<!-- 											<tr class="description blank_row"> -->
										<!-- 									            <td bgcolor="#FFFFFF" colspan="" height="10"  style="border-right: 0pt;">&nbsp;</td> -->
										<!-- 									            <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td> -->
										<!-- 									            <td bgcolor="#FFFFFF" height="10"  style="border-right: 0pt;">&nbsp;</td> -->
										<!-- 									    	</tr>									 -->
										<%-- 										</c:forEach>									 --%>
										<c:forEach var="det" items="${detailObj}" varStatus="theCount">
											<tr class="description">
												<td class="width_10 normal"  align="left"
													valign="top" style="border-right: 0pt;"><span
													class="normal">&nbsp;${det.marks}</span></td>
												<td class="width_15 normal"   align="left"
													valign="top" style="border-right: 0pt;"><span
													class="normal">&nbsp;${det.articles}</span></td>
												<td class="width_25 normal"   align="left"
													valign="top" style="border-right: 0pt;"><span
													class="normal">&nbsp;${det.description}</span></td>
												<td class="width_10 normal"   align="left"
													valign="top" style="border-right: 0pt;"><span
													class="normal">&nbsp;${det.weight}</span></td>
												<td class="width_10 normal"   align="left"
													valign="top" style="border-right: 0pt;"><span
													class="normal">&nbsp;${det.yard}</span></td>
												<td class="width_10 normal"  align="left"
													valign="top" style="border-right: 0pt;"><span
													class="normal">&nbsp;${det.refNo}</span></td>
												<td class="width_15 normal"   align="left"
													valign="top" style="border-right: 0pt;"><span
													class="normal">&nbsp;${det.shipName}</span></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<!-- Fetch TC Amount and BC Amount (USD) in words -->
				<td align="left" class="tablespace"><span class="normal"><b>Please
							receive the above mentioned goods for carriage at owner's risk
							Subject to contents not checked and not responsible for
							Damage/Breakage Cargo Received Ex-Port/Warehouse.</b><br> <br>
				</span></td>
			</tr>
			<tr>
				<td>

					<table border="0" class="padding-top-10" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td width="20%" style="font-size: 10px; ">
								Signature of Sender</td>
							<td width="60%" style="text-align: center;"></td>
							<td width="20%" style="font-size: 10px;">
								Vehicle No.</td>
						</tr>
						<tr>
							<td width="20%" style="font-size: 10px; ">
								Driver's Name & Sign</td>
							<td width="60%" style="text-align: center;"></td>
							<td width="20%" style="font-size: 10px; padding-bottom: 75px;">
								</td>
						</tr>
					</table> 

				</td>
			</tr>
			<tr>
				<td class="padding-top-10"  style="font-size: 14px;"><b><u>ACKNOWLEDGEMENT OF
							GOODS RECEIVED</u></b></td>
			</tr>
			<tr>
				<td class="padding-top-10"><span class="normal"><b>We hereby acknowledge the receipt in
					full of the goods as per above details and certify that the goods
					have arrived in good condition & order.</b></span></td>
			</tr>
			<tr>
				<td>

					<table border="0" class="padding-top-10" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td width="20%" style="font-size: 10px; ">
								Date</td>
							<td width="60%" style="text-align: center;"></td>
							<td width="20%" style="font-size: 10px; ">
								Signature</td>
						</tr>
						<tr></tr>
					</table> 

				</td>
			</tr>
		</table>

		 <br>
		<table id="footer" border=0 bordercolor="" cellspacing="0"
			cellpadding="2" align="center">
			<tr>

				<td class="" colspan="10" align="center"><span
					class=footer-text> </span></td>
			</tr>
			<tr>
				<td colspan="10" align="center"><span class=footer-text><b></b>
				</span> <span class=footer-text><b></b> </span> <span
					class=footer-text><b></b> </span></td>
			</tr>
		</table>
	</div>

</body>
</html>
