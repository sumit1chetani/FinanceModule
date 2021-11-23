<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 
	 
<head>
<c:set var="object1" value="${receiptVoucherList}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${object1.voucherNo}</title>
<style type="text/css">
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
    border-style:dotted;
}
.padding-top-10{
	padding-top: 10px;
}
/* .custom-color-1 .table-striped>thead>tr>th {
	color: #fff;
	border-bottom: 1px solid rgba(255, 255, 225, .15);
	border-left: 1px solid rgba(255, 255, 225, .15);
	border-top: 1px solid rgba(255, 255, 225, .15);
	background: #42a5f5 !important;
	
} */

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
    position: relative;
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
	font-weight: bold;
}
.dotted-border{
	border:1px dotted;
}
@page {
	margin: 2mm; /* this affects the margin in the printer settings */
}
</style>
<style type="text/css" media="print">
      html, body { margin: 2; padding: 0; }
     /*  body { height: 11in;  width: 8.5in; } */
      #footer { position: absolute; bottom: 0; width:100%; margin:0 auto;}
</style> 
</head>
	<body>
	
	 
	 <c:set var="usrnameObject" value="${userName}" />	 
		<form class="form-horizontal" action="printCashbankpayment">
			<table  align="center" class="padding-20p" border="0" cellpadding="0" width="100%" cellspacing="0">
				<tr>
					<td>	
						<table width="100%" border="0" cellspacing="0" cellpadding="2">	
							<tr>		
								<td>
									<img src="/img/sfpl_logo_202x48.jpg"  />
								</td>	
							</tr>	
							<tr>		
							
							        <td colspan=3 align="center"><font face="arial" size="4"><b>Agent Receipt Voucher -${object1.companyName}</b></font></td> 
							  	
							</tr>	
							<tr>	
								<td class="width_20" align="left"><font face="arial" size="2"><b>Voucher No</b> : ${object1.voucherNo}<br><br></font></td>
								<td class="width_20" align="left"><font face="arial" size="2"><b>Voucher Date</b> : ${object1.cbReceiptDate}<br><br></font></td>
								<td class="width_20" align="left"><font face="arial" size="2"><b>Received From</b> :${object1.receivedFrom}<br><br></font></td>
							</tr>	 	
							<tr>	
								
								<td class="width_30" align="left" valign=bottom>
									<font face="arial" size="2">	 
									<b>
									Account:
									 	${object1.accountName}<br><br>
									</b></font>
								</td>	
								
								<td class="width_20" align="left">
									<font face="arial" size="2">	
									<b>Agent</b> : ${object1.subAccountName}<br><br></font>
								</td>
								
								<td class="width_20" align="left">
									<font face="arial" size="2">	
									<b>Desc</b> : ${object1.narration}<br><br></font>
								</td>	
								
								
								
							</tr>	
								
							<tr>	
								
								
								<td class="width_20" align="left" valign=bottom>
									<font face="arial" size="2">	
									<b>Cur </b> : 
											${object1.acctCurrency}
									<b>  &nbsp; &nbsp; Ex-Rate</b> :
											${object1.exchangeRate}<br><br>
									</font>
								</td>
								
											
								<td class="width_20" align="left" valign=bottom>
									<font face="arial" size="2">	
									<b>TC Total  : 
											${object1.tcAmountHdr} </b><br><br>
									</font>
								</td>
								
								<td class="width_20" align="left" valign=bottom>
									<font face="arial" size="2">	
									<b>BC Total : ${object1.bcAmountHdr} </b><br><br></font>
								</td>
							</tr>	
						</table>
						<!-- Detail table ---- Starts -->
						<table  class="table table-striped b-t b-light dotted-border" width=100% border="1" bordercolor="" cellspacing="0" cellpadding="2" align="center">
							<thead>					
								<tr>
									<th class="width_15 dotted-border" align="center"><span class="bold">Company</span></th>
									<th class="width_30 dotted-border" align="center"><span class="bold">Account Name</span></th>
									<th class="width_25 dotted-border" align="center"><span class="bold">Narration</span></th>
									<!-- <th class="width_20 text-wrap" align="center"><span class="bold">Sub Account Name</span></th> -->
									<th class="width_5 dotted-border" align="center"><span class="bold">Cur</span></th>
									<th class="width_5 dotted-border" align="center"><span class="bold">Ex-rate</span></th>
									<th class="width_10 dotted-border" align="center"><span class="bold">TC Amt</span></th>
									<th class="width_10 dotted-border" align="center"><span class="bold">BC Amt (${object1.companyCurrency})</span></th>
									
									
								</tr>
							</thead>
							<tbody>
							 <c:forEach var="ob"  items="${receiptVoucherList.cshBankDetail}"> 
								<tr>
									<td class="subcolor width_15 dotted-border" align="left" valign="top" ><span class="normal"> 
									${ob.companyCode} - ${ob.companyName}
									</span></td>
									
									<td class="subcolor width_30 dotted-border" align="left" valign="top">
										<font face="arial" size="2"> ${ob.acctHeadCode} -</font><br>
										<font class="bold" face="arial" size="2">${ob.acctName}</font><br>
										<font class="bold" face="arial" size="2">Sub Account:- ${ob.subAccountName}</font><br>
										
										<c:choose>
										    <c:when test="${empty ob.vesselCode}">
												<font face="arial" size="2"></font>												        
										    </c:when>
										    <c:otherwise>
										        <font face="arial" size="2"> <b>Truck:</b> ${ob.vesselCode} -  ${ob.vesselName} </font><br>
										    </c:otherwise>
										</c:choose>														
										<c:choose>
										    <c:when test="${empty ob.voyageCode}">
												<font face="arial" size="2"></font>												        
										    </c:when>
										    <c:otherwise>
										        <font face="arial" size="2"> <b>Trip:</b> ${ob.voyageCode} </font><br>
										    </c:otherwise>
										</c:choose>	
										<c:choose>
										    <c:when test="${empty ob.sectorCode}">
												<font face="arial" size="2"></font>												        
										    </c:when>
										    <c:otherwise>
										        <font face="arial" size="2"> <b>Service:</b> ${ob.sectorCode} - ${ob.sectorName}</font>
										    </c:otherwise>
										</c:choose>	
									</td>
									<td class="subcolor width_25 dotted-border" align="left"  valign="top" >
										<font class="bold" face="arial" size="2">${ob.shortDetail}</font>
									</td>
									<td class="subcolor width_5 dotted-border" align="left"  valign="top" nowrap="nowrap">
										<span class="normal"> ${ob.currency} </span></td>
									
									<td class="subcolor width_5 dotted-border" align="right" valign="top" nowrap="nowrap"><span class="normal"> 
									${ob.exgRate} 
									</span></td>
									
									<td class="subcolor width_10 dotted-border" align="right" valign="top" nowrap="nowrap"><span class="normal"> 
									${ob.tcamount} 
									</span></td>
									<td class="subcolor width_10 dotted-border" align="right" valign="top" nowrap="nowrap"><span class="normal"> 
									${ob.bcamount} 
									</span></td>
									
								</tr>
								
							</c:forEach>
							<!-- write -->					
							<tr>		
								<td class="dotted-border" align="center"><font face="arial" size="2"><b>Total</b></font></td>		
								<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>		
								<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
								<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
								<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
								<td class="dotted-border" align="right"><font face="arial" size="2">
									<!-- Total Amount --> ${object1.totalTcAmount}
								</font></td>
								<td class="dotted-border" width=15% align="right"><font face="arial" size="2">
									<!-- Total Amount USD --> ${object1.totalBcAmount}
								</font></td>
								
							</tr>
							</tbody>								
						</table><br>
						<table class="table table-striped b-t b-light dotted-border" width=100% border="1" bordercolor="" cellspacing="0" cellpadding="2" align="center">
							<thead>					
								<tr>
									<th class="width_15 dotted-border" align="center"><span class="bold">Invoice No</span></th>
									<th class="width_30 dotted-border" align="center"><span class="bold">Received TC Amount</span></th>
									<th class="width_30 dotted-border" align="center"><span class="bold">Received BC Amount</span></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach  var="objDet" items="${receiptVoucherList.cbInvoiceDtl}">							    
								<tr>
									<td class="subcolor width_15 dotted-border" align="left" valign="top" ><span class="normal"> 
									${objDet.invoiceNo}
									</span></td>
									<td class="subcolor width_30 dotted-border" align="right" valign="top">
										<font face="arial" size="2">${objDet.receivedAmount}</font>
									</td>	
									<td class="subcolor width_30 dotted-border" align="right" valign="top">
										<font face="arial" size="2">${objDet.receivedAmountUSD}</font>
									</td>							
								</tr>							  
							</c:forEach>
							
							</tbody>
						</table><br>
						<table class="width_100">
							<tr class="no-border">
								<td class="no-border" align="center"><font face="arial" size=3> ${usrnameObject} <!-- User Name --></font></td>
								<td class="no-border" align="center"><br></td>
							</tr>	
							<tr class="no-border">							
								<td class="no-border" align="center">________________________<br><font face="arial" size="2">Prepared By</font></td>		
								<td class="no-border" align="center">________________________<br><font face="arial" size="2">Approved By</font></td>
								<td class="no-border" align="center">________________________<br><font face="arial" size="2">Receiver Signature</font></td>
							</tr>
							
							<tr class="no-border">
								<td class="padding-top-10 no-border"" colspan="10" align="center"><span class=footer-text> ${object1.companyAddress}</span></td>
							</tr>
							<tr class="no-border">
								<td class="no-border" colspan="10" align="center">
									<span class="footer-text no-border"><b>Tel.:</b> ${object1.companyPhoneNo}</span>
									<span class="footer-text no-border"><b>Telex:</b> ${object1.companyFaxNo}</span>
									<span class="footer-text no-border"><b>e-mail:</b> ${object1.companyEmail}</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>