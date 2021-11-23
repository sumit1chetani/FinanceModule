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

		
					<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="" align="center">
									<tr>
										<td width="25%"><img
											src="/img/${user.tenantId}HelpVideos/logo.jpg"
											style="padding: 10 0 0 10; height: 60px;"></td>
										<td width="75%"><span
											style="text-align: center;     text-transform: uppercase;"><center><b>${user.tenantId}
													GLOBAL LOGISTICS PVT LTD</b></center></span> <%-- 								<span style="text-align: right;" ng-if="${user.tenantId} == unicon"><b>UNICON GLOBAL LOGISTICS PVT LTD</b></span> --%>
											<br>
										<span><center><b>
												${hdr.address1} ${hdr.address2}</b></center></span> <br>
										<!-- <span  style="    margin-left: 116px;font-size: 13px;"> </span> <br> -->
										<span  ><center><b>${hdr.address3}</b></center></span>
								<br><span ><center><c:if test="${hdr.gstnNo != ''}">GSTNO:${hdr.gstnNo}</c:if></span></center>
										
									</tr>
								</table>
					
					<p>
					<h2 align="center">Export Advance List</h2>
					<table class="table" width=100% border=0 bordercolor=""
			cellspacing="0" cellpadding="2" align="center">
			<tr>
				<td colspan=1 style="border-top: none !important;     font-size: 20px;width:50% line-height: 200%;padding-left: 15px;"><b>Vessel & Voyage</b></td>
				<td colspan=1 style="border-top: none !important;     font-size: 20px;width:50% line-height: 200%;">:&nbsp;${hdr.vesselVoyeage}</td>
				
				
			<tr>
			<tr>
				<td colspan=1 style="border-top: none !important;     font-size: 20px;width:50% line-height: 200%;padding-left: 15px;"><b>POL </b></td>
				<td colspan=1 style="border-top: none !important;     font-size: 20px;width:50% line-height: 200%;">:&nbsp;${hdr.polCode}</td>
				
				
			<tr>
			<tr>
				<td colspan=1 style="border-top: none !important;     font-size: 20px;width:50% line-height: 200%;padding-left: 15px;"><b>Branch </b></td>
				<td colspan=1 style="border-top: none !important;     font-size: 20px;width:50% line-height: 200%;">:&nbsp;${hdr.branchCode}</td>
				
				
			<tr>
			</tr>
					<%-- <table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						  <tr>
							<td align="left" style="padding-left: 3px;"><span><b><table border="0" width="100%" cellpadding="0" cellspacing="0"
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
					</table>
									&Voyage&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:</b> ${hdr.vesselVoyeage}</span><br>
						</td>
							</tr>
							<tr>
							<td align="left" style="padding-left: 3px;"><span><b>POL
									 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp: </b>
									 ${hdr.polCode}<br>
							</span></td>
							</tr>
							<tr>
							<td align="left" style="padding-left: 3px;"><span><b>Branch
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:</b> ${hdr.branchCode}<br>
							</span></td>
						</tr>
					</table> --%> <br>










					<table width=97% align="center" border="0" cellPadding="0"
						cellSpacing="0">

						<tr>
							<td class="padding-top-10">
								<table class="" align="left" border="1" bordercolor=""
									cellPadding="0" cellSpacing="0" width=100%>
									<thead>
										<tr class="">
											
											<th class="width_22" height="10" align="center"><span
												class="bold" style="font-size: 20px;"> CONTAINER NO </span></th>
											<th class="width_10" height="10" align="center"><span
												class="bold" style="font-size: 20px;">SEAL NO </span></th>
											<th class="width_10" height="10" align="center"><span
												class="bold" style="font-size: 20px;">SIZE </span></th>
											<th class="width_10" height="10" align="center"><span
												class="bold" style="font-size: 20px;">NT WT </span></th>
											<th class="width_20" height="10" align="center"><span
												class="bold" style="font-size: 20px;">GR WT</span></th>
											<th class="width_20" height="10" align="center"><span
												class="bold" style="font-size: 20px;">POD</span></th>
											<th class="width_20" height="10" align="center"><span
												class="bold" style="font-size: 20px;">FPD</span></th>
										</tr>
									</thead>
									<c:forEach var="detailObj1" items="${detailList}">
										<tbody>


											<tr class="description">
												<td class="width_10 " align="left" valign="top"><span style="font-size: 20px;    padding: 7px;">${detailObj1.containerNo}</span></td>
												<td class="width_10 " align="left" valign="top"><span style="font-size: 20px;    padding: 7px;">${detailObj1.sealNo}</span></td>
												<td class="width_10 " align="left" valign="top"><span style="font-size: 20px;    padding: 7px;">${detailObj1.size}</span></td>
												<td class="width_10 " align="right" valign="top"><span style="font-size: 20px;padding-right: 7px;">${detailObj1.netWeight}</span></td>
												<td class="width_10 " align=right  valign="top"><span style="font-size: 20px;padding-right: 7px;">${detailObj1.grossWeight}</span></td>
												<td class="width_10 " align="left" valign="top"><span style="font-size: 20px;    padding: 7px;">${detailObj1.placeofDelivery}</span></td>
												<td class="width_10 " align="left" valign="top"><span style="font-size: 20px;    padding: 7px;"> ${detailObj1.freightPayableAt}</span></td>

	
											</tr>



										</tbody>
									</c:forEach>
								</table>
							</td>
						</tr>
					</table>

		
	</div>

</body>
</html>
