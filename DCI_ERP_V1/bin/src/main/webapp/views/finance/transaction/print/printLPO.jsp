<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">


<title>LPO</title>
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
	padding: 5px;
}
.normal{
	font-size:14px;
}
</style>
</head>
	<body>
		<c:set var="object1" value="${LPOList}" />
		
		<table class="width_100" align="center" border="0" cellPadding="0" cellSpacing="0">
			<tr>
				<td>
				<br>
			<br>
			<table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">		
				<tr>
					<td><img src='/img/sfpl_logo_202x48.jpg'/>'</td>
				</tr>
			</table>
			<br>
			<br>
				<font size="5" face="arial"><b>LPO</b></font>
				<p>
				<table width=100% align="center" border="1" cellPadding="0" cellSpacing="0">
					<tr>
						<td valign="top" border="0" class="line-height-23p padding-left-5 border-right-none"><span class="normal">
							<b>Company :  ${object1.companyName}</b></span>
						</td>                 
							<td valign="top" border="0" class="line-height-23p padding-left-5 border-left-none border-right-none">
						</td>   
							<td valign="top" border="0" class="line-height-23p padding-left-5 border-left-none border-right-none">
						</td>   
							<td valign="top" border="0" class="line-height-23p border-left-none padding-left-5">
						</td>   
					</tr>
					<tr>						
						<td valign="top" class="line-height-23p padding-left-5 border-bottom-1p"><span class="normal">
							<b>LPO No :  ${object1.lpoNo}</b></span>
						</td>
						<td valign="top" class="line-height-23p padding-left-5 border-bottom-1p border-right-none"><span class="normal">
							<b>Date : ${object1.lpoDate}</b></span>
						</td>	
						<td valign="top" class="line-height-23p padding-left-5 border-bottom-1p border-left-none border-right-none">
							
						</td>	
						<td valign="top" class="line-height-23p padding-left-5 border-bottom-1p  border-left-none">
							
						</td>	
					</tr>
					<tr>
						<td valign="top" border="0" class="line-height-23p padding-left-5 border-right-none"><span class="normal">
							<b>Supplier :  ${object1.supplierName}</b></span>
						</td>                 
							<td valign="top" border="0" class="line-height-23p padding-left-5 border-left-none border-right-none">
						</td>   
							<td valign="top" border="0" class="line-height-23p padding-left-5 border-left-none border-right-none">
						</td>   
							<td valign="top" border="0" class="line-height-23p border-left-none padding-left-5">
						</td>   
					</tr>
					
					<tr>
						<td valign="top" border="0" class="line-height-23p padding-left-5 border-right-none"><span class="normal">
							<b>Description :  ${object1.description}</b></span>
						</td>                 
							<td valign="top" border="0" class="line-height-23p padding-left-5 border-left-none border-right-none">
						</td>   
							<td valign="top" border="0" class="line-height-23p padding-left-5 border-left-none border-right-none">
						</td>   
							<td valign="top" border="0" class="line-height-23p border-left-none padding-left-5">
						</td>  
					</tr>
					<tr>						
						<td valign="top" class="width_10 line-height-23p padding-left-5 border-bottom-2p""><span class="normal">
							<b>Currency :  ${object1.currency}</b></span>
						</td>
						<td valign="top" class="width_10 line-height-23p padding-left-5 border-bottom-2p""><span class="normal">
							<b>Exchange Rate : ${object1.exchangeRate}</b></span>
						</td>	
						<td valign="top" class="width_10 line-height-23p padding-left-5 border-bottom-2p""><span class="normal">
							<b>TC Amt : ${object1.totalTCamount}</b></span>
						</td>
						<td valign="top" class="width_10 line-height-23p padding-left-5 border-bottom-2p""><span class="normal">
							<b>BC Amt : ${object1.totalBCamount} (${object1.companyCurrency})</b></span>
						</td>
					</tr>
					<tr>
						<td colspan="9" border="0" class="b-none"><br><br>
							<table class="table table-striped b-t b-light" align="left" border="1"  bordercolor="" cellPadding="0" cellSpacing="0" width=100%>
								<thead>					
									<tr>
										<th class="width_1" align="center"><span class="bold">Sl. No.</span></th>
										<th class="width_10" align="center"><span class="bold">Company</span></th>
										<th class="width_30" align="center"><span class="bold">Account Code/ Name</span></th>
										<th class="width_10" align="center"><span class="bold">Short Detail</span></th>
										<th class="width_10" align="center"><span class="bold">Cur</span></th>
										<th class="width_10" align="center"><span class="bold">Ex. Rate</span></th>							
										<th class="width_15" align="center"><span class="bold">TC Amount</span></th>
										<th class="width_15" align="center"><span class="bold">BC Amount (${object1.companyCurrency})</span></th>
										
									</tr>
								</thead>
								<tbody>									
									<c:forEach var="ob" items="${LPOList.lpoDetail}" varStatus="theCount"> 
										<tr>
											<td class="subcolor width_1" align="left" valign="top">
												<font face="arial" size="2"> ${theCount.count} </font>														
											</td>
											<td class="subcolor width_10" align="left" valign="top">
												<font face="arial" size="2"> ${ob.companyName} </font>														
											</td>
											<%-- <td class="subcolor width_20" align="left" valign="top">
												<font face="arial" size="2"> Sub Group Code:- ${ob.subGrpCode}  / </font><br>
												<font class="bold" face="arial" size="2">${ob.subGroupName}</font><br>		
											</td> --%>
											<td class="subcolor width_30" align="left" valign="top">																			
												<font face="arial" size="2"> Account Code:- ${ob.accountHeadCode} / </font><br>
												<font class="bold" face="arial" size="2">${ob.accountHeadName}</font><br><br>
												<font class="bold" face="arial" size="2">Sub Account:- ${ob.subAccountName}</font><br>
																								
												
													<c:choose>
												    <c:when test="${empty ob.vesselCode}">
														<font face="arial" size="2"></font><br>												        
												    </c:when>
												    <c:otherwise>
												        <font face="arial" size="2"> <b>Truck:</b> ${ob.vesselCode} -  ${ob.vesselName} </font><br>
												    </c:otherwise>
												</c:choose>	
												<c:choose>
												    <c:when test="${empty ob.voyageCode}">
														<font face="arial" size="2"></font>		<br>										        
												    </c:when>
												    <c:otherwise>
												        <font face="arial" size="2"> <b>Trip:</b> ${ob.voyageCode} </font><br>
												    </c:otherwise>
												</c:choose>	
												<c:choose>
												    <c:when test="${empty ob.sectorCode}">
														<font face="arial" size="2"></font>		<br>										        
												    </c:when>
												    <c:otherwise>
												        <font face="arial" size="2"> <b>Service:</b> ${ob.sectorCode} - ${ob.sectorName}</font><br>
												    </c:otherwise>
												</c:choose>		
											</td>										
											<td class="subcolor width_10 text-wrap" align="left"  valign="middle" >
												<font class="bold" face="arial" size="2">${ob.shortDetail}</font>
											</td>
											<td class="subcolor width_10" align="left" nowrap="nowrap">
											<span class="normal"> 
											${ob.currency} 
											</span></td>
											<td class="subcolor width_10" align="right" nowrap="nowrap">
											<span class="normal"> 
											${ob.exchangeRate} 
											</span></td>
											<td class="subcolor width_15" align="right" nowrap="nowrap">
											<span class="normal"> 
											${ob.tcAmount} 
											</span></td>
											<td class="subcolor width_15" align="right" nowrap="nowrap"><span class="normal"> 
											${ob.bcAmount} 
											</span></td>
										</tr>										
									</c:forEach>									
										
										<tr>
											<td class="width_1" border="0" align="right" valign="top">
											</td>
											
											<td class="width_30" align="right" valign="top">
											</td>
											
											<td class="width_10" align="right" valign="top">
											</td>
											<td class="width_10" align="right" valign="top">
											</td>
											<td class="width_10" align="right" valign="top">
											</td>
											<td class="width_10" align="right" valign="top">
											Total:
											</td>
											<td class="width_10" align="right">
												<span class="normal"><b><!-- total TC Amount -->
												${object1.totalTCamount}</b></span>
											</td>
											<td class="width_10" align="right">
												<span class="normal"> <b> <!-- total BC Amount (USD) -->  
												${object1.totalBCamount}</b></span></td>
										</tr>
								</tbody>		
							</table>	
						</td>
					</tr>
				</table>
				</td>
			</tr>
			
			
			
			<tr>
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
								<span class=footer-text><b>e-mail:</b> ${object1.companyEmail}</span>
							</td>
						</tr>	
					</table>	
				</td>
			</tr>
		</table>
	</body>
</html>
