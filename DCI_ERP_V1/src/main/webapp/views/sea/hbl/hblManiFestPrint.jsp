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
	border-bottom: 1px dotted rgba(255, 255, 225, .15) !important;
	border-left: 1px dotted rgba(255, 255, 225, .15) !important;
	border-top: 1px dotted rgba(255, 255, 225, .15) !important;
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
@page{
size: A4;
margin: 2mm;

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
<body style="border:1px solid black">
	<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="hdr" value="${masterList}" />


	<div id="content">


		<table  class="padding-top-2" width="100%" cellpadding="0"
			cellspacing="0" bgcolor="FFFFFF"  align="center" style="border-top: 0px;border-left: 1px; border-right: 1px;">
			<tr>
				<td width="50%" style="text-align: center;">
				<table  width="100%"  cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF"align="center">
									<tr>
										<td width="20%"><img
											src="/img/${user.tenantId}HelpVideos/logo.jpg"
											style="padding: 10 0 0 10; height: 60px;"></td>
										<td width="80%" style="padding-right: 142;"><span
											style="text-align: center; text-transform: uppercase;"><center><b>${user.tenantId}
													GLOBAL LOGISTICS PVT LTD</b></center></span> <%-- 								<span style="text-align: right;" ng-if="${user.tenantId} == unicon"><b>UNICON GLOBAL LOGISTICS PVT LTD</b></span> --%>
											<br>
										<span class="" style="font-size: 13px;" ><center>
												${hdr.address1} ${hdr.address2}</center></span> <br>
										<!-- <span  style="    margin-left: 116px;font-size: 13px;"> </span> <br> -->
										<span  ><center>${hdr.address3}</center></span>
										<br><span ><center><c:if test="${hdr.gstnNo != ''}">GSTNO:${hdr.gstnNo}</c:if></span></center>
									</tr>
								</table>

					<%-- <table border="0" width="100%" cellpadding="0" cellspacing="0"
						bgcolor="FFFFFF" bordercolor="" align="center">
						<tr>
							<td width="25%"><img
								src="/img/${user.tenantId}HelpVideos/logo.jpg"
								style="padding: 10 0 0 10; height: 60px;"></td>

							<td width="75%"><span
								style="text-align: right; text-transform: uppercase;"><b>${user.tenantId}
										GLOBAL LOGISTICS PVT LTD</b></span> <br> <span
								style="text-align: right;"> ${hdr.address1}</span> <br> <span
								style="text-align: right;">${hdr.address2} </span> <br> <span
								style="text-align: right;">${hdr.address3}</span>
						</tr>
					</table> --%>
				</td>

			</tr>
			<tr>
			</tr>
		</table>
		
		<h4 align="center">IMPORT GENERAL MANIFEST</h4>
		<h4 align="center">CARGO DECLARATION</h4>
		<h4 align="center">FORM III</h4>

		<h4 align="center">(See Regulation 3 and 4)</h4>




		<table class="table" width=100% 
			cellspacing="0" cellpadding="2" align="center">

			<tr>
			<td colspan=1 style="border-top: none !important;width:40% line-height: 200%;padding-left: 15px;"><b>Name Of The Shipping Line : </b>${hdr.shipperName}</td>
				<td colspan=1 style="border-top: none !important; padding-right: 96px;width:35% line-height: 200%;"><b>Name Of The Agent : </b>${hdr.agent}</td>
				<td colspan=1 style="border-top: none !important;width:25% line-height: 200%;"></td>
			<%-- 
				<td colspan=1 style="border-top: none !important;width:25% line-height: 200%;"><b>Name Of The Shipping Line </b></td>
				<td colspan=1 style="border-top: none !important;width:25%">${hdr.shipperName}</td>
				<td colspan=1 style="border-top: none !important;width:25% line-height: 200%;"><b>Name Of The Agent </b></td>
				<td colspan=1 style="border-top: none !important" ;width:25%>${hdr.consigneeName}</td> --%>
			</tr>
			</table>
			<table class="table" width=100% 
			cellspacing="0" cellpadding="2" align="center">
			<tr>
				<td colspan=1 style="border-top: none !important;width:40% line-height: 200%;padding-left: 15px;"><b>1. Name of the Ship : </b>${hdr.shipperName}</td>
				<td colspan=1 style="border-top: none !important;width:35% line-height: 200%;"><b>2. Port where report is made : </b>${hdr.originCode}</td>
				<td colspan=1 style="border-top: none !important;width:25% line-height: 200%;"></td>
				
			<tr>
				<td colspan=1 style="border-top: none !important;width:40% line-height: 200%;padding-left: 15px;"><b>3. Nationality of Ship : </b></td>
				<td colspan=1 style="border-top: none !important;width:35% line-height: 200%;"><b>4. Name of the Master : </b></td>
				<td colspan=1 style="border-top: none !important;width:25% line-height: 200%;"><b>5. Port of Loading : </b>${hdr.polCode}</td>
				
			</tr>

			<%-- <tr>
				<td colspan=1 style="border-top: none !important;width:% line-height: 200%;"><b>1. Name of the Ship </b></td>
				<td colspan=1 style="border-top: none !important;width:25%">${hdr.shipperName}</td>
				<td colspan=1 style="border-top: none !important;width:25% line-height: 200%;"><b>2. Port where report is made : </b></td>
				<td colspan=1 style="border-top: none !important;width:25%">${hdr.originCode}</td>
			<tr>
				<td colspan=1 style="border-top: none !important;width:25% line-height: 200%;"><b>3. Nationality of Ship : </b></td>
				<td colspan=1 style="border-top: none !important;width:25%"></td>
					${hdr.serviceType}
				
				<td colspan=2 style="border-top: none !important; line-height: 200%;"><b>4. Name of the Master : </b></td>
				<td colspan=2 style="border-top: none !important"></td>

				<td colspan=2 style="border-top: none !important; line-height: 200%;"><b>5. Port of Loading : </b></td>
				<td colspan=2 style="border-top: none !important">${hdr.podCode}</td>
			</tr> --%>

		</table>




		<table class="table" align="center"  cellPadding="0"
			cellSpacing="0" width=98%>
			<thead class="bold">
				<tr class="">
					<th class="width_8" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">6.Line
							No</span></th>
					<th class="width_22" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">
							7. B/L No and Date </span></th>
					<th class="width_10" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">8.
							No. and Nature of Packages </span></th>
					<th class="width_10" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">9.
							Marks and Numbers </span></th>
					<th class="width_10" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">10.
							Net Wt. </span></th>
					<th class="width_20" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">11.
							Gross Wt.</span></th>
					<th class="width_8" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">12.
							Description of goods</span></th>
					<th class="width_22" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">
							13. Name of consignee/ Importer/shipper, If different </span></th>
					<th class="width_10" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">
							14. Date of * presentation of bill of entry</span></th>
					<th class="width_10" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">15.
							Name of Custom * Custom House Agent </span></th>
					<th class="width_10" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">16.Rotation
							No.: Cash/Deposit W.R.N. </span></th>
					<th class="width_20" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">No.Of
							Packages on which duty colld.or ware- housed</span></th>
					<th class="width_10" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">Year:
							(To be filled by Port Trust) No. of packgs discharged </span></th>
					<th class="width_20" height="10" align="center"
						style="border: 1px dashed !important"><span class="bold">Remark</span></th>

				</tr>
			</thead>
			<c:forEach var="detailObj1" items="${detailList}">
				<tbody>


					<tr class="description">
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.containerNo}</span></td>
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.noOfOriginalBl}</span></td>
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.noofPackage}</span></td>
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.marksAndNos}</span></td>
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.netWeight}</span></td>
						<td class="width_15 " align="right" valign="top"
							style="border: 1px dashed !important" style="padding-right: 2px;">${detailObj1.grossWeight}</td>
							<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.cargoDescription}</span></td>
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${hdr.shipperName}${hdr.consigneeName}${hdr.customerName}</span></td>
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${hdr.etd}</span></td>
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.notifyAddress}</span></td>
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.pol}</span></td>
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.pol}</span></td>
						<td class="width_15 " align="right" valign="top"
							style="border: 1px dashed !important" style="padding-right: 2px;">${detailObj1.pol}</td>
						
						<td class="width_10 " align="left" valign="top"
							style="border: 1px dashed !important"><span style="padding: 6px;">${detailObj1.remarks}</span></td>

					</tr>



				</tbody>
			</c:forEach>
		</table>


		<table class="table" width=98%
			cellspacing="0" cellpadding="2" align="center">
			<tr>
				<td colspan=1 align="center"
					style="border-top: none !important; line-height: 150%; text-decoration: underline;"><b>TRANSHIPMENT
						CARGO FROM ICD AHMEDABAD TO AUCKLAND </b></td>

			</tr>


			<tr>
				<td colspan=1 align="center"
					style="border-top: none !important; line-height:150%; text-decoration: underline;"><b>Ex
						Vessel: </b></td>
			</tr>



		</table>
		<hr style="border: 1px dashed !important">
		<table class="table" width=100%  style="padding-top: 0px;"
			cellspacing="0" cellpadding="2" align="center">
			<tr>
				<td colspan=1
					style="border-top: none !important; line-height: 200%;padding-left: 15px;">We
					hereby certify that Item Nos.Item List are on account of our
					principals. We, as agents are responsible for the full outturn of</td>
				<td colspan=1 style="border-top: none !important"></td>
			</tr>


			<tr>
				<td colspan=1
					style="border-top: none !important; line-height: 200%;padding-left: 15px;">
					manifested under the above items and will be liable for any penalty
					or other dues in case of any short Landings/Survey.</td>

			</tr>

			<tr>
				<td colspan=1
					style="border-top: none !important; line-height: 200%;padding-left: 15px;">We
					certify that all items indicated on this hard copy of IGM have been
					fully represented in the magnetic medium.</td>
		</table>
		<table class="table" width=100% 
			cellspacing="0" cellpadding="2" align="center">
			<tr>
				<td colspan=1
					style="border-top: none !important; line-height: 200%; text-transform: uppercase;padding-left: 15px;"><b>FOR
						${user.tenantId} GLOBAL LOGISTICS PVT LTD </b></td>
				<td colspan=1 style="border-top: none !important"></td>
			</tr>


			<tr>
				<td colspan=1
					style="border-top: none !important; line-height: 200%;padding-left: 15px;"><b>(ADMIN)</b></td>
				<td colspan=1 style="border-top: none !important"></td>
			</tr>

			<tr>
		</table>

	</div>

</body>
</html>
