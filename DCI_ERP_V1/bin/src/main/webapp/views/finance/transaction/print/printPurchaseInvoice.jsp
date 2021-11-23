<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">


<title>Purchase Invoice</title>
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

.width_05 { width: 0.50%; }

.width_1 { width: 1%; }
.width_2 { width: 2%;}
.width_3 { width: 3%; }
.width_4 { width: 4%; }
.width_5 { width: 5%; }
.width_6 { width: 6%; }
.width_7 {width: 7%; }
.width_8 { width: 8%; }
.width_9 { width: 9%; }
.width_10 { width: 10%;}
.width_11 {width: 11%; }
.width_12 {width: 12%;}
.width_13 {	width: 13%;}
.width_14 { width: 14%;}
.width_15 {width: 15%;}
.width_16 {width: 16%;}
.width_17 {width: 17%;}
.width_18 {width: 18%;}
.width_19 {width: 19%;}
.width_20 {width: 20%;}
.width_21 {width: 21%;}
.width_22 {width: 22%;}
.width_23 {width: 23%;}
.width_24 {width: 24%;}
.width_25 {width: 25%;}

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
    position:absolute;
    bottom:0px;
    left:0px;
    width:100%;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-size: 12px;
    text-decoration: none;
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
	/* white-space: -moz-pre-wrap; */ /* Firefox */
	white-space: -o-pre-wrap; /* Opera */
	/* white-space: pre-wrap; */ /* Chrome */
	word-wrap: break-word; /* IE */
}
.border-right-none{
	border-right: none; 
}
.border-top-none{
	border-top: none; 
}
.border-bottom-none{
	border-bottom: none; 
}
.border-left-none{
	border-left: none; 
}
.border-bottom-1p{
	border-bottom: 1px solid #000;
} 
.border-bottom-2p{
	border-bottom: 2px solid #000;
} 
 .b-none{
 	border:none;
 }
.bold{
font-weight:bold;}

.company-for-seal{
    font-size: 14px;
    font-weight: bold;
    padding-top: 25px;
    text-align: center;
}
.table-striped tbody td{
	height: 30px;
	padding: 3px;
}
/* .normal{
	font-size:14px;
} */
.normal {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 8pt;
    font-style: normal;
    font-weight: normal;
    color: #000000;
    text-decoration: none;
}
.padding-top-20{
	padding-top: 20px;
}
.detail-table-cell {
    font-family: Arial;
    FONT-SIZE: 8pt;
    color: black;
    background-color: #FFFFFF;
    padding: 1px;
    bordercolor: #000000;
    text-transform: uppercase;
}
.thead-bold {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 8pt;
    font-style: normal;
    font-weight: bold;
    color: #000000;
    text-decoration: none;
    padding-left: 6px;
}
.detail-table-font{
font-size: 12px;
font-family:arial;
}
  @page:last {
    @bottom-center {
        content: "…";
    }
     #footer {  display: table-footer-group;
    width:100%;        
    position:absolute;

    bottom:0; } 
	}
</style>
<style type="text/css" media="print">
      html, body { margin: 0; padding: 0; }
      /* body { height: 11in;  width: 8.5in; } */
       a[href]:after {
	    content: " (" attr(href) ")";
	 }
	  #footer {  
	  display: table-footer-group;
    width:100%;        
    position:absolute;

    /* bottom:3px; */ } 
    #content{
    	margin-bottom:4px;
    }
   
</style> 
</head>
	<body>
		<c:set var="object1" value="${purchaseInvoiceList}" />
		<div id="content" style="margin-bottom: 10px;">
		
		<table width="100%" border="0" cellspacing="0" cellpadding="2">	
			
						
					<tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>Dental Council of India</b></font></td> 
					</tr>	
				<tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>Aiwan-E-Galib Marg, Kotla Road, New Delhi</b></font></td> 
					</tr>
					<!-- <tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>Kotla Road, Temple Lane,</b></font></td> </tr>
					<tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>Opp. Mata Sundari College for Women,</b></font></td> </tr>
					<tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>New Delhi - 110002</b></font></td> </tr> -->
						
					</table>
		
		<table class="width_100" align="center" border="0" cellPadding="0" cellSpacing="0">
			<tr>
				<td> <br>
				<table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">		
					
				</table><br>
				<font size="5" face="arial"><b>PURCHASE INVOICE</b></font>
					<table width=100% align="center" border="1" cellPadding="0" cellSpacing="0">
						<tr>						
							<td valign="top" class="line-height-23p padding-left-5 border-bottom-1p"><span class="normal">
								<b>Invoice. No :</b></span>
							</td>
							<td valign="top" class="line-height-23p padding-left-5 border-bottom-1p"><span class="normal">
								${object1.puchaseInvoiceNo}</span>
							</td>
							<td valign="top" class="line-height-23p padding-left-5 border-bottom-1p"><span class="normal">
								<b>Date :</b></span>
							</td>	
							<td valign="top" colspan="3" class="line-height-23p padding-left-5 border-bottom-1p"><span class="normal">
								${object1.puchaseInvoiceDate}</span>
							</td>	
							
							
						<!-- 	<td valign="top" class="width_5 line-height-23p padding-left-5 border-bottom-1p border-right-none"><span class="normal">
								<b>Ref No :</b></span>
							</td>	 -->
							<%-- <td valign="top" colspan="3" class="line-height-23p padding-left-5 border-bottom-1p border-right-none"><span class="normal">
								${object1.refNo}</span>
							</td> --%>
															
						</tr>
						<tr>
							<td valign="top" border="0"  class="line-height-23p padding-left-5">
							<span class="normal"> <b>Supplier :</b> </span>
							</td> 
							<td valign="top" border="0" colspan="4" class="line-height-23p padding-left-5 border-right-none">
								<span class="normal">   ${object1.supplier}</span>
							</td>   
							
							<%-- 	<td valign="top" border="0"  class="line-height-23p padding-left-5">
							<span class="normal"> <b>Reversed For:</b> </span>
							</td> 
							<td valign="top" border="0" colspan="3" class="line-height-23p padding-left-5 border-right-none">
								<span class="normal">   ${object1.reversedFor}</span>
							</td>   --%> 
							             
							   
						</tr>
						<tr>						
							<td valign="top" class="line-height-23p padding-left-5"><span class="normal">
						    <b>Party Inv. No :</b></span>
							</td>
							<td valign="top" class="line-height-23p padding-left-5"><span class="normal">
								${object1.partyInvoiceNo}</span>
							</td>
							<td valign="top" class="width_10 line-height-23p padding-left-5 border-right-none"><span class="normal">
								<b>Party Inv. Dt :</b> </span>
							</td>	
							<td valign="top" colspan="5" class="line-height-23p padding-left-5 border-right-none"><span class="normal">
								${object1.partyInvoiceDate}</span>
							</td>	
						</tr>
						<%-- <tr>						
							<td valign="top" class="line-height-23p padding-left-5"><span class="normal">
								<b>Purchase No :</b> </span>
							</td>
							<td valign="top" class="line-height-23p padding-left-5"><span class="normal">
								${object1.purchaseOrderNo}</span>
							</td>
							<td valign="top" class="width_10 line-height-23p padding-left-5 border-right-none"><span class="normal">
								<b>Due Date :</b> </span>
							</td>
							<td valign="top" colspan="5" class="line-height-23p padding-left-5 border-right-none"><span class="normal">
								${object1.dueDate}</span>
							</td>	
						</tr> --%>
						<tr>						
							<%-- <td valign="top" class="width_15 line-height-23p padding-left-5 ""><span class="normal">
								<b>Currency :</b></span>
							</td>
							<td valign="top" class="width_15 line-height-23p padding-left-5 ""><span class="normal">
								${object1.currency}</span>
							</td>
							<td valign="top" class="width_15 line-height-23p padding-left-5 ""><span class="normal">
								<b>Exchange Rate :</b></span>
							</td>
							<td valign="top" class="width_10 line-height-23p padding-left-5 ""><span class="normal">
								${object1.exchangeRate}</span>
							</td>	 --%>
							<%-- <td valign="top" class="width_15 line-height-23p padding-left-5 "">
								<span class="normal"><b>TC Amount :</b></span>
							</td>
							<td valign="top" class="width_10 line-height-23p padding-left-5 "">
								<span class="normal">${object1.amount}</span>
							</td> --%>
							<td valign="top" class="width_20 line-height-23p padding-left-5 " >
							<span class="normal"><b>Amount  (${object1.currency}) :</b></span>
							</td>
							<%-- <td valign="top" class="width_25 line-height-23p padding-left-5 " >
							<span class="normal">${object1.amount}</span>
							</td> --%>
							<td valign="top" class="width_25 line-height-23p padding-left-5 " style="font-size: 12px;" align="right"><fmt:formatNumber
									type="number" minFractionDigits="2" maxFractionDigits="2"
									value="${object1.amount}" /></td>
						</tr>
						<tr>						
							<td valign="top" colspan="" class="line-height-23p padding-left-5 ">
							<span class="normal"> <b>Company :</b> </span>
							</td>	
							<td valign="top" colspan="7" class="line-height-23p padding-left-5 ">
							<span class="normal"> ${object1.companyName}</span>
							</td>						
						</tr>
						<tr>						
							<td valign="top" class="line-height-23p padding-left-5">
								<span class="normal"> <b>Description :</b></span>
							</td>
							<td valign="top" colspan="7" class="line-height-23p padding-left-5">
								<span class="normal"> ${object1.description}</span>
							</td>						
						</tr>
						<!-- <tr>
							<td colspan="9" border="0" class="b-none">
									
							</td>
						</tr> -->
					</table>
					<h4>CHARGE LIST :</h4>
					<table class="table table-striped b-t b-light padding-top-10" align="left" border="1"  bordercolor="" cellPadding="0" cellSpacing="0" width=100%>
						<thead>					
							<tr>
<!-- 								<th class="width_10" align="center"><span class="thead-bold">Company</span></th>
 -->								<th class="width_30" align="center"><span class="thead-bold">Account Code/ Name</span></th>
								<th class="width_10" align="center"><span class="thead-bold">Short Details</span></th>
						<!-- 		<th class="width_5" align="center"><span class="thead-bold">Cur</span></th>
								<th class="width_5" align="center"><span class="thead-bold">Ex. Rate</span></th> -->
								<%-- <c:if test="${object1.companyCode=='C0001' || object1.companyCode=='C0002'}">
								<th class="width_6" align="center"><span class="thead-bold">VAT (%)</span></th>
								<th class="width_7" align="center"><span class="thead-bold">VAT AED Amount</span></th>
								<th class="width_7" align="center"><span class="thead-bold">VAT BC Amount</span></th>
								</c:if>	 --%>						
								<th class="width_10" align="center"><span class="thead-bold">Amount</span></th>
<!-- 								<th class="width_10" align="center"><span class="thead-bold">BC Amount</span></th>
 -->							</tr>
						</thead>
						<tbody>									
								<c:forEach var="ob" items="${purchaseInvoiceList.purchaseInvoiceDetail}" varStatus="theCount"> 
						<%-- 		<c:if test="${ob.accountHeadCode!='10090022' && ob.accountHeadCode!='10090023' && ob.accountHeadCode!='10090026' && 
									ob.accountHeadCode!='10090025' && ob.accountHeadCode!='10090027' && ob.accountHeadCode!='10090028'}"> --%>
									<tr>
									<%-- 	<td class="subcolor width_10 detail-table-cell" align="left" valign="top">
											<font face="arial" size="2"> ${ob.companyShortName} </font>														
										</td> --%>
										<%-- <td class="subcolor width_20" align="left" valign="top">
											<font face="arial" size="2"> Sub Group Code:- ${ob.subGrpCode}  / </font><br>
											<font class="bold" face="arial" size="2">${ob.subGroupName}</font><br>		
										</td> --%>
										<td class="subcolor width_30 detail-table-cell" align="left" valign="top">																			
											<span class="detail-table-font">
												<span class="bold">Account Code:-</span> ${ob.chargecode} / ${ob.accountHeadName}<br>
												<span class="bold">Sub Account:-</span> ${ob.subGrpCode}<br>
											</span>
											<%-- <font face="arial" size="2"> Account Code:- ${ob.accountHeadCode} / </font><br>
											<font class="bold" face="arial" size="2">${ob.accountHeadName}</font><br>
											<font class="bold" face="arial" size="2">Sub Account:- ${ob.subAccountName}</font><br> --%>
										<%-- 	<c:choose>
											    <c:when test="${empty ob.vesselCode}">
											    	<span class="detail-table-font"></span>																						        
											    </c:when>
											    <c:otherwise>
											    	<span class="detail-table-font">
											    		<b>Vessel:</b> ${ob.vesselCode} -  ${ob.vesselName}
											    	</span><br>
											        <font face="arial" size="2"> <b>Vessel:</b> ${ob.vesselCode} -  ${ob.vesselName} </font>
											    </c:otherwise>
											</c:choose>														
											<c:choose>
											    <c:when test="${empty ob.voyageCode}">
											    	<span class="detail-table-font"></span>
													<!-- <font face="arial" size="2"></font> -->												        
											    </c:when>
											    <c:otherwise>
											    	<span class="detail-table-font">
											        	 <b>Voyage:</b> ${ob.voyageCode}<br>
											        </span>
											    </c:otherwise>
											</c:choose>	
											<c:choose>
											    <c:when test="${empty ob.sectorCode}">
											    	<span class="detail-table-font"></span>
													<!-- <font face="arial" size="2"></font>		 -->										        
											    </c:when>
											    <c:otherwise>
											    	<span class="detail-table-font">
											        	 <b>Service:</b> ${ob.sectorCode} - ${ob.sectorName}
											        </span>
											    </c:otherwise>
											</c:choose>	 --%>	
										</td>										
										<td class="subcolor width_10 text-wrap detail-table-cell" align="left"  valign="middle" >
											<span class="detail-table-font w-s-no">${ob.shortDetail}</span>
										</td>
										<%-- <td class="subcolor width_5 detail-table-cell" align="left">
											<span class="detail-table-font"> 
											${ob.currency} 
											</span>
										</td>  --%>
										<%-- <td class="subcolor width_5 detail-table-cell" align="right">
										<span class="detail-table-font"> 
										${ob.exchangeRate} 
										</span></td> --%>
									<%-- 	<c:if test="${object1.companyCode=='C0001' || object1.companyCode=='C0002'}">
										<td class="subcolor width_6 detail-table-cell" align="right">
										<span class="detail-table-font"> 
										${ob.vatTaxPercent} %
										</span></td>
										<td class="subcolor width_7 detail-table-cell" align="right">
										<span class="detail-table-font"> 
										${ob.vatTaxAmount} 
										</span></td>
										<td class="subcolor width_7 detail-table-cell" align="right">
										<span class="detail-table-font"> 
										${ob.vatTaxBcAmount} 
										</span></td>
										</c:if> --%>
										<td class="subcolor width_10 detail-table-cell" align="right">
										<span class="detail-table-font"> <fmt:formatNumber
									type="number" minFractionDigits="2" maxFractionDigits="2"
									value="${ob.amount}" />
									
									
										</span></td>
													
										<%-- <td class="subcolor width_10 detail-table-cell" align="right">
										<span class="detail-table-font"> 
										${ob.bcAmount} 
										</span></td> --%>
										<%-- <c:set var="totalTCAmt" value="${totalTCAmt + ob.amount}" />
										<c:set var="totalBCAmt" value="${totalBCAmt + ob.bcAmount}" /> --%>
									</tr>
																			
								</c:forEach>							
							<!-- 	<tr>
									<td class="width_10" border="0" align="right" valign="top">
									</td>									
									<td class="width_30" align="right" valign="top">
									</td>									
									<td class="width_10" align="right" valign="top">
									</td>
									<td class="width_5" align="right" valign="top">
									</td> -->
								<%-- 	<c:if test="${object1.companyCode=='C0001' || object1.companyCode=='C0002'}">
									<td class="width_5" align="right" valign="top">
									</td>
									<td class="width_6" align="right" valign="top">
									</td>
									<td class="width_7" align="right" valign="top">
									</td>
									<td class="width_7" align="right" valign="top">
									<b>Total</b> :
									</td>
									</c:if>
									<c:if test="${object1.companyCode!='C0001' && object1.companyCode!='C0002'}">
									<td class="width_5" align="right" valign="top">
									<b>Total</b> :
									</td>
									</c:if> --%>
								<%-- 	<td class="width_10" align="right">
										<span class="detail-table-font"><b><!-- total TC Amount -->
										 ${object1.tcAmount}
										<fmt:formatNumber var="totalTC" type="number" value="${totalTCAmt}" />
										 ${totalTC}
										 </b></span>
									</td>
									<td class="width_10" align="right">
										<span class="detail-table-font"> <b> <!-- total BC Amount (USD) -->  
										 ${object1.bcAmount}
										<fmt:formatNumber var="totalBC" type="number" value="${totalBCAmt}" />
										 ${totalBC}
										</b></span></td> --%>
<!-- 								</tr>
 -->						</tbody>		
					</table>
					<br>
					<br>
					
					
					
										<h4>ACCOUNT HEAD :</h4>
					
					<table class="table table-striped b-t b-light padding-top-10" align="left" border="1"  bordercolor="" cellPadding="0" cellSpacing="0" width=100%>
						<thead>					
							<tr>
<!-- 								<th class="width_10" align="center"><span class="thead-bold">Company</span></th>
 -->								<th class="width_30" align="center"><span class="thead-bold">Account Code/ Name</span></th>
								<th class="width_10" align="center"><span class="thead-bold">Short Details</span></th>
						<!-- 		<th class="width_5" align="center"><span class="thead-bold">Cur</span></th>
								<th class="width_5" align="center"><span class="thead-bold">Ex. Rate</span></th> -->
								<%-- <c:if test="${object1.companyCode=='C0001' || object1.companyCode=='C0002'}">
								<th class="width_6" align="center"><span class="thead-bold">VAT (%)</span></th>
								<th class="width_7" align="center"><span class="thead-bold">VAT AED Amount</span></th>
								<th class="width_7" align="center"><span class="thead-bold">VAT BC Amount</span></th>
								</c:if>	 --%>						
								<th class="width_10" align="center"><span class="thead-bold">Amount</span></th>
<!-- 								<th class="width_10" align="center"><span class="thead-bold">BC Amount</span></th>
 -->							</tr>
						</thead>
						<tbody>									
								<c:forEach var="ob" items="${purchaseInvoiceList.purchaseInvoiceDetailacct}" varStatus="theCount"> 
						<%-- 		<c:if test="${ob.accountHeadCode!='10090022' && ob.accountHeadCode!='10090023' && ob.accountHeadCode!='10090026' && 
									ob.accountHeadCode!='10090025' && ob.accountHeadCode!='10090027' && ob.accountHeadCode!='10090028'}"> --%>
									<tr>
									<%-- 	<td class="subcolor width_10 detail-table-cell" align="left" valign="top">
											<font face="arial" size="2"> ${ob.companyShortName} </font>														
										</td> --%>
										<%-- <td class="subcolor width_20" align="left" valign="top">
											<font face="arial" size="2"> Sub Group Code:- ${ob.subGrpCode}  / </font><br>
											<font class="bold" face="arial" size="2">${ob.subGroupName}</font><br>		
										</td> --%>
										<td class="subcolor width_30 detail-table-cell" align="left" valign="top">																			
											<span class="detail-table-font">
												<span class="bold">Account Code:-</span> ${ob.ahaccountHeadCode} / ${ob.ahaccountHeadName}<br>
												<span class="bold">Sub Account:-</span> ${ob.subGrpCode}<br>
											</span>
											
										</td>										
										<td class="subcolor width_10 text-wrap detail-table-cell" align="left"  valign="middle" >
											<span class="detail-table-font w-s-no">${ob.ahshortDetail}</span>
										</td>
										
										<td class="subcolor width_10 detail-table-cell" align="right">
										<span class="detail-table-font"><fmt:formatNumber
									type="number" minFractionDigits="2" maxFractionDigits="2"
									value="${ob.ahamount}" />										 
										</span></td>
										
									</tr>
																			
								</c:forEach>	
								
								<tr>		
											
									<td class="dotted-border" align="center"><font face="arial" size="2">Total<br></font></td>
									
									<td class="dotted-border" align="right"><font face="arial" size="2">
										<!-- Total TC Credit --> 
									</font></td>
									<td class="dotted-border" width=15% align="right"><font face="arial" size="2">
										<!-- Total BC Credit --> <fmt:formatNumber
									type="number" minFractionDigits="2" maxFractionDigits="2"
									value="${object1.amount}" />
										
										
									</font></td>
								</tr>						
												</tbody>	
												
											
					</table>
				</td>
			</tr>
			
			
			
			<%-- <tr>
				<td>				
					<!-- Detail table - ends -->
					<table class="width_100" border="0" bordercolor="" cellspacing="0" cellpadding="0" align="center" valign="top">								
						<tr>
							<td class="padding-top-10" colspan="10" align="center"><span class=footer-text> ${object1.companyAddress}</span></td>
						</tr>
						<tr>
							<td colspan="10" align="center">
								<span class=footer-text><b>Tel.:</b> ${object1.companyPhoneNo}</span>
								<span class=footer-text><b>Telex:</b> ${object1.companyFaxNo}</span>
								<span class=footer-text><b>SIMA e-mail:</b> ${object1.companyEmail}</span>
							</td>
						</tr>	
					</table>	
				</td>
			</tr> --%>
		</table>
		</div>
		<div id="footer">
	<%-- 	<table width="100%" border=0 bordercolor="" cellspacing=0 cellpadding=2 align="center" valign="bottom">								
					<tr>
						<td align="center"><font face="arial" size=3> ${object1.createdBy} </font></td>
						<td align="center"><font face="arial" size=3> ${object1.approvedBy} </font></td>
					</tr>
					
					
					<tr>							
						<td align="center">________________________<br><font face="arial" size="2">Prepared By</font></td>		
						 <td align="center">________________________<br><font face="arial" size="2">Approved By</font></td>
						<td align="center">________________________<br><font face="arial" size="2">Receiver Signature</font></td> 
					</tr>											
				</table> --%>
				
			<%-- <table border=0 bordercolor="" cellspacing="0" cellpadding="2" align="center" valign="bottom">								
				<tr>
					<td class="padding-top-10" colspan="10" align="center"><span class=footer-text> ${object1.companyAddress}</span></td>
				</tr>
				<tr>
					<td colspan="10" align="center">
						<span class=footer-text><b>Tel.:</b> ${object1.companyPhoneNo}</span>
						<span class=footer-text><b>FAX:</b> ${object1.companyFaxNo}</span>
						<span class=footer-text><b>e-mail:</b> ${object1.companyEmail}</span>
					</td>
				</tr>										
			</table> --%>
		</div>
		
	</body>
</html>