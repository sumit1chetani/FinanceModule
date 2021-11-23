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
<body style="border:1px solid black;width: 94%;margin-left: 25px;">
	<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="object1" value="${purchaseInvoiceList}" />
	<c:set var="object2" value="${shipperDetails}" />
	<div id="content" style="margin-bottom: 10px;">
		<table class="width_100" align="center" border="0" cellPadding="0"
			cellSpacing="0">
			<tr>
				<td><br> <!-- <table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">		
					<tr>
						<td><img class="width_22" src='/img/logo.jpg'/>
						</td>
						<td><font size="3" face="arial">Athena Global Logistics Pvt. Ltd.</font></td>
					</tr>
				</table><br> -->
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
											style="padding: 10 0 0 10; height: 50px;"></td>
                                  
										<td width="75%" style="font-size: 14px;">
										<c:if test="${object1.branchId != 3}"><span style="text-align: center;"><b>MBK</b></span> <br> </c:if>
										<c:if test="${object1.branchId == 3}"><span style="text-align: center;"><b>MBK</b></span> <br> </c:if> 
													<span
											style="text-align: right;" style="font-size: 12px;">${object1.branchAddress1}${object1.branchAddress2}${object1.branchZip} </span> <br> <span
											style="text-align: right;" style="font-size: 12px;">${object1.branchAddress3}</span> <br> 
											<span
											style="text-align: right;" style="font-size: 12px;"><c:if test="${object1.branchGstno != ''}">GSTNO:${object1.branchGstno}</c:if></span></td>
									
									</tr>
								</table>
							</td>

						</tr>
						<tr>
						</tr>
					</table> <br>
					<table width=100% align="center" border="1" cellPadding="0"
						cellSpacing="0" style="border-left:none;border-right:none;margin-left:-1px">
						<tr>
							<td><center>
									<font size="2" face="arial"><b>TAX INVOICE</b></font>
								</center></td>
						</tr>
					</table>  
					<table width="50%" style="float:left; padding-top:10px; padding-bottom:15px;"><tr><td class="width_30" align="left" style="font-size: 10px;"><b>To</b></td></tr><tr><td style="font-size: 10px;"><b>${object1.cutName}</b></td></tr><tr><td style="font-size: 10px;">${object1.custAddress1}${object1.custAddress2}${object1.custAddress3}
							</td></tr><tr><td align="left" style="font-size: 10px;">GST IN :${object1.gstNo}</td></tr>
							<c:if test="${object2.shipperName !=null }"><tr><td class="width_30" align="left" style="font-size: 10px;"><b>Shipper Address</b></td></tr><tr><td style="font-size: 10px;"><b>${object2.shipperName}<b></td></tr><tr><td style="font-size: 10px;">${object2.shipperAddress1}${object2.shipperAddress2}${object2.shipperAddress3}
							</td></tr></c:if>
							<tr><c:if test="${object2.consigneeName !=null }"><td class="width_30" align="left" style="font-size: 10px;"><b>Consignee Address</b></td></c:if></tr><tr><td style="font-size: 10px;"><b>${object2.consigneeName}<b></td></tr><tr><td style="font-size: 10px;">${object2.consigneeAddress1}${object2.consigneeAddress2}${object2.consigneeAddress3}
							</td></tr>
								</table>
					<table width="50%" style="float:left; padding-top:10px; padding-bottom:15px;"><tr>
							<td class="width_40"  style="font-size: 10px;"><b>DATE</b></td><td style="font-size: 10px;">: ${object1.purchaseInvoiceDate}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>SALES INVOICE NO</b></td><td style="font-size: 10px;">: ${object1.purchaseInvoiceNo}</td></tr>
							 <tr><td class="width_40"  style="font-size: 10px;"><b>JOB NO</b></td><td style="font-size: 10px;">: ${object1.jobNo}</td></tr>
							<tr><td class="width_40" style="font-size: 10px;"><b>HAWB NO</b></td><c:if test="${object1.hawbNo != null}"><td style="font-size: 10px;">: ${object1.hawbNo}</td></c:if><c:if test="${object1.hawbNo == null}"><td style="font-size: 10px;">: &nbsp;&nbsp;-</td></c:if></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>MAWB NO</b></td><c:if test="${object1.mawbNo != null}"><td style="font-size: 10px;">: ${object1.mawbNo}</td></c:if><c:if test="${object1.mawbNo == null}"><td style="font-size: 10px;">: &nbsp;&nbsp;-</td></c:if></tr>
							<tr><td class="width_40" style="font-size: 10px;"><b>AOL</b></td><td style="font-size: 10px;">: ${object1.aolName}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>AOD</b></td><td style="font-size: 10px;">: ${object1.aodName}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>FPOD</b></td><td style="font-size: 10px;">: ${object1.aodName}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>GROSS WEIGHT</b></td><c:if test="${object1.grossWeight != 0}"><td style="font-size: 10px;">: ${object1.grossWeight}&nbsp;KGS</td></c:if><c:if test="${object1.grossWeight == 0}"><td style="font-size: 10px;">: &nbsp;&nbsp;-</td></c:if></tr>
							<tr><td class="width_40" style="font-size: 10px;"><b>FLIGHT NO</b></td><td style="font-size: 10px;">: ${object1.flightNo}</td></tr>
							<tr><td class="width_40"  style="font-size: 10px;"><b>ARRIVAL DATE</b></td><c:if test="${object1.arrivalDate != null}"><td style="font-size: 10px;">: ${object1.arrivalDate}</td></c:if><c:if test="${object1.arrivalDate == null}"><td style="font-size: 10px;">: &nbsp;&nbsp;-</td></c:if></tr>	
							<tr><td class="width_40"  style="font-size: 10px;"><b>DEPARTURE DATE</b></td><c:if test="${object1.depatureDate != null}"><td style="font-size: 10px;">: ${object1.depatureDate}</td></c:if><c:if test="${object1.depatureDate == null}"><td style="font-size: 10px;">: &nbsp;&nbsp;-</td></c:if></tr>
							</table>
					<table width=100% align="center" border="1" cellPadding="0"
						cellSpacing="0" style="border-left:none;border-right:none;margin-left:0px">
						<tr>
							<td><center>
									<font size="1" face="arial">YOUR ACCOUNT HAS BEEN
										DEBITED TOWARDS THE FOLLOWING CHARGES.</font>
								</center></td>
						</tr>
					</table> <br>
					<table class="table table-striped b-t b-light"
						align="left" border="1" bordercolor="" cellPadding="0"
						cellSpacing="0" width=100% style="border-left:none;border-right:none;margin-left:0px">
						<thead>
							<tr>
								<th class="width_10" align="center" style="font-size: 10px;">CHARGE HEADS</th>
								<th class="width_6" align="center" style="font-size: 10px;">SAC NO</th>
								<th class="width_8" align="center" style="font-size: 10px;">QTY</th>
								<th class="width_5" align="center" style="font-size: 10px;">RATE</th>
								<th class="width_5" align="center" style="font-size: 10px;">CURRENCY</th>
							<!-- 	<th class="width_8" align="center" style="font-size: 10px;">EX-RATE</th> -->
																								
<!-- 								<th class="width_12" align="center" style="font-size: 10px;">TOTAL1111(USD)</th> -->
						
						<c:forEach var="ob" items="${purchaseInvoiceList.purchaseInvoiceDetail}" varStatus="theCount">
<c:if test="${theCount.count == 1}">
<th class="width_12" align="center" style="font-size: 10px;">TOTAL(${ob.currency})</th>
	</c:if>		
</c:forEach>
						
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ob"
								items="${purchaseInvoiceList.purchaseInvoiceDetail}"
								varStatus="theCount">
								<tr>
									<td  align="left" style="font-size: 10px;">${ob.accountHeadCode}</td>

                                        <c:if test="${ob.sacNo == 0}">
									<td align="left" valign="middle" style="font-size: 10px;"><center></center></td></c:if>
									<c:if test="${ob.sacNo != 0}">
									<td align="left" valign="middle" style="font-size: 10px;"><center>${ob.sacNo}</center></td></c:if>
									<td align="right" style="font-size: 10px;">
										${ob.qty}
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.rate} 
									</td>
									<td align="right" style="font-size: 10px;">
										${ob.currency}
									</td>
									<%-- <td align="right" style="font-size: 10px;">
										${ob.exchangeRate} 
									</td> --%>
									
									
										
									<td align="right"
										valign="right" style="font-size: 10px;"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${ob.subTotal}" />
									</td>

								</tr>
							</c:forEach>
                            <tr >
                              <td colspan="5" class="width_10" align="right" style="font-size: 12px;" >TOTAL</td>                        
                            
                             
                             
												
                              <td align="right" valign="right" style="font-size: 10px;"><fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
												value="${object1.totalAmount}" /></td>
                              </tr> 
						</tbody>
						<table style="font-size: 12px;">
							
					<c:forEach var="ob" items="${purchaseInvoiceList.purchaseInvoiceDetail}" varStatus="theCount">
<c:if test="${theCount.count == 1}">

<td><b>Amount in Words: ${ob.currency} ${object1.totalAmountInWords}</b></td><br>

</c:if>
</c:forEach>
						    <tr>
						    <c:if test="${object1.branchId != 3}"><td>Please issue all payment in favour of &nbsp;"MBK"</td></c:if>
						    <c:if test="${object1.branchId == 3}"><td>Please issue all payment in favour of &nbsp;"MBK"</td></c:if>
						    </tr>
						</table>
					</table></td>
			</tr>
		</table>
	</div>
	<div>
		
					<table style="font-size: 10px;" >
						    <tr><td>BANK DETAILS&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankName}</td> </tr>
							<tr><td>ADDRESS&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankAddress}</td></tr>
							<tr><td>ACCOUNT NO &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankAcct}</td></tr>
							<tr><td>SWIFT CODE&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankSwift}</td></tr>
							<tr> <td>IFSC CODE&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.bankifsc}</td></tr>
                            <tr><td>PAN NO&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.branchPan}</td></tr>
                            <!-- <tr><td>SERVICE TAX NO&nbsp:&nbsp&nbsp${object1.branchSrvctax}</td></tr> -->
                            <tr><td> GSTN IN&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp${object1.branchGstno}</td></tr>	
					</table>
				
		</table>
		<br> <c:if test="${object1.branchId != 3}"> <font size="1" face="arial"><b>FOR MBK (ADMIN)</b></font></c:if>
		<c:if test="${object1.branchId == 3}"> <font size="1" face="arial"><b>FOR MBK (ADMIN)</b></font></c:if>
		<br><font size="1" face="arial"> Remarks :${object1.remarks}</font>
		<br><br><br>
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
