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


.th-class{
width:50% !important;


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
	<body>
	 <c:set var="object1" value="${vesselSaillingList}" />
	 	<c:set var="opclbalance" value="${objGeneralLedgerOPBean}" />
	 	<c:set var="object" value="${list}" />
	 <c:set var="usrnameObject" value="${userName}" />	 
		<form class="form-horizontal" action="printCashbankpayment">
			<div id="content">
				<table align="center" class="padding-20p" border="0" cellpadding="0" width="95%" cellspacing="0">
					<tr>
						<td>	
							<table width="100%" border="0" cellspacing="0" cellpadding="2">	
						<!-- 	
							<td width="25%"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 10 0 0 30; height: 50px;"></td> -->
								 <tr>	
								<td>
								<img class="width_30" src='/img/MBKHelpVideos/mbk_image.png'/>

								</tr> 
								<tr>		
									<td colspan=3 align="center"><font face="arial" size="5"><b>${object1.companyName}</b></font></td> 
								</tr>	
																<tr>		
									<td colspan=3 align="center"><font face="arial" size="3"><b>${opclbalance.subGroupName}</b></font></td> 
								</tr>
								<tr>		
									<td colspan=3 align="center"><font face="arial" size="2"><b>${opclbalance.subGroupAddress1}</b></font></td> 
								</tr>
								
									<tr>		
									<td colspan=3 align="center"><font face="arial" size="2"><b>${opclbalance.subGroupAddress2}</b></font></td> 
								</tr>
								
								<%-- 	<tr>		
									<td colspan=3 align="center"><font face="arial" size="3"><b>${opclbalance.subGroupAddres3}</b></font></td> 
								</tr>
									<tr>		
									<td colspan=3 align="center"><font face="arial" size="3"><b>${opclbalance.subGroupAddress4}</b></font></td> 
								</tr> --%>
								 <tr>		
									<td colspan=3 align="center"><font face="arial" size="2"><b>LEDGER ACCOUNT</b></font></td> 
								</tr>
									  <tr>		
									<td colspan=3 align="center"><font face="arial" size="2"><b>GST :  ${object.gstNo}</b></font></td> 
								</tr>
									<tr>		
									<td colspan=3 align="center"><font face="arial" size="4">PARTY NAME : ${object.partyname}</font></td> 
								</tr>
											<tr>		
									<td colspan=3 align="center"><font face="arial" size="4">${object.address}</font></td> 
								</tr>
								<br><br>	
								<tr>	
									<td  style="position:relative;left:30%;font-size: 12px;"><fmt:parseDate pattern="dd/mm/yyyy" value="${object1.fromDate}" var="fromDate" />
                                  <span class="bold">From Period:</span>
                                 <fmt:formatDate value="${fromDate}" pattern="dd-MMM-yyyy" />
                          			</td>
									 <td style="position:relative;font-size: 12px;" >
									  <span class="bold">To Period:</span>
							      	<fmt:parseDate pattern="dd/mm/yyyy" value="${object1.toDate}" var="toDate" />
                                 <fmt:formatDate value="${toDate}" pattern="dd-MMM-yyyy" />
									</td> 
								</tr> 	
								
								
							</table>
							
	                 <table class="table table-striped b-t b-light dotted-border" width=100%  border="1" bordercolor="" 
	                        cellspacing="0" cellpadding="2" align="center"  >
	                           	<thead>	
							          	<tr>
									<th class="width_10 " style="background-color: #F3F702; align="center"><span class="bold">Voucher DATE</span></th>
  									<th class="width_10 "  style="background-color: #F3F702; align="center"><span class="bold">Voucher NO</span></th>
								    <th class="width_10 "  style="background-color: #F3F702;  align="center"><span class="bold">TRANSACTION TYPE</span></th>
 								    <th class="th-class" style="background-color: #F3F702; align="center"><span class="bold">NARRATION</span></th>
									<th class="width_10 " style="background-color: #F3F702;  align="center"><span class="bold">BC DEBIT</span></th>
									<th class="width_10 " style="background-color: #F3F702; align="center"><span class="bold">BC CREDIT</span></th>
									
									</tr>
								</thead>
								<thead>					
									<tr>
										<th class="width_5 dotted-border"    align="center"><span class="bold"></span></th>
 									<th class="width_30 dotted-border" font face="arial"  style="color:green;  align="center"><span class="bold">OPENING BALANCE</span></th>
										<th class="width_25 dotted-border" align="center"><span class="bold"></span></th>
 									<th class="width_5 dotted-border"  align="center"><span class="bold"></span></th>
										<!-- <th class="width_10 dotted-border" align="center"><span class="bold"></span></th> -->
										<c:if test="${objGeneralLedgerOPBean.openingBalance < 0}">
										<th class="dotted-border" style="color:green; align="right">
									<fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
									 value="${objGeneralLedgerOPBean.openingBalance}"/>
									</th>
									</c:if>
									<c:if test="${objGeneralLedgerOPBean.openingBalance > 0}">
										<th class="dotted-border" style="color:green; align="right">
									<fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
									 value="${objGeneralLedgerOPBean.openingBalance}"/>
									</th>
									</c:if>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="ob"  items="${lGeneralLedgerList}"> 
									<tr>
										<td class="subcolor  dotted-border" align="left"  valign="top"  > 
										<font face="arial" size="2">
											${ob.transactionDate} </font></td>
											<td class="subcolor  dotted-border" align="left"  valign="top" >
											<font face="arial" size="2">
											 ${ob.transactionNo} </font></td>
								        <td class="subcolor  dotted-border" align="left" font size="50" valign="top" >
								        <font face="arial" size="2">
											 ${ob.transactionType}</font></td> 
										<td class="subcolor width_25 dotted-border th-class" align="left"  valign="top" >
										 <font face="arial" size="2">
											${ob.narration}
											</font>
										</td>
											<td class="subcolor width_5 dotted-border" align="right"  valign="top">
									<fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
									value="${ob.bcDebit}"/>
									
									</font></td>
											
											<td class="subcolor width_5 dotted-border" align="right"  valign="top">
									<fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
									value="${ob.bcCredit}"/>
									
								
									</tr>								
								</c:forEach>
								
								<tr>		
											
									<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
									<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
									<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
		                            <td class="dotted-border"  font face="arial" style="color:red;  align="center"><span class="bold">TOTAL</span></td>			
								
								
								<td class="dotted-border" style="color:red; align="right">
									<fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
									value="${objGeneralLedgerOPBean.debitamount}"/>
									
									</td>
								
									
										<td class="dotted-border" style="color:red; align="right">
									<fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2" 
									value="${objGeneralLedgerOPBean.creditamount}"/>
									
									</td>
			
									
								</tr>
								
									<tr>		
										<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
																			<td class="dotted-border" align="center"><span class="bold"  style="color:red;">CLOSING BALANCE</span></td>
									
									<!-- <td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td> -->
								<th class="width_30 dotted-border" font face="arial"  style="color:red;  align="center"></th>
									
								<td class="dotted-border" align="center"><font face="arial" size="1"><br></font></td> 
 <c:if test="${objGeneralLedgerOPBean.closingBalance > 0}">
									<td class="dotted-border" style="color:red; align="right">
									<fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="1"
									value="${objGeneralLedgerOPBean.closingBalance}"/>
									
									</td>
									</c:if>
									
									 <c:if test="${objGeneralLedgerOPBean.closingBalance < 0}">
									<td class="dotted-border" style="color:red; align="right">
									<fmt:formatNumber type="number"
												minFractionDigits="2" maxFractionDigits="2"
									value="${objGeneralLedgerOPBean.closingBalance}"/>
									
									</td>
									</c:if>
									
									

								</tr>
								
								</tbody>							
							</table>
							
							
							<br>
				
						</td>
						</tr>
						</table>
						</div>
						
					
		</form>
	</body>
</html>