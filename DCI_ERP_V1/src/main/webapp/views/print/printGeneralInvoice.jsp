<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sales Invoice</title>
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
.width_05 {	width: 0.50%;}
.width_1 {	width: 1%;}
.width_2 {	width: 2%;}
.width_3 {	width: 3%;}
.width_4 {	width: 4%;}
.width_5 {	width: 5%;}
.width_6 {	width: 6%;}
.width_7 {	width: 7%;}
.width_8 {	width: 8%;}
.width_9 {	width: 9%;}
.width_10 {	width: 10%;}
.width_11 {	width: 11%;}
.width_12 {	width: 12%;}
.width_13 {	width: 13%;}
.width_14 {	width: 14%;}
.width_15 {	width: 15%;}
.width_16 {	width: 16%;}
.width_17 {	width: 17%;}
.width_18 {	width: 18%;}
.width_19 {	width: 19%;}
.width_20 {	width: 20%;}
.width_21 {	width: 21%;}
.width_22 {	width: 22%;}
.width_23 {	width: 23%;}
.width_24 {	width: 24%;}
.width_25 {	width: 25%;}
.width_26 {	width: 26%;}
.width_27 {	width: 27%;}
.width_28 {	width: 28%;}
.width_29 {	width: 29%;}
.width_30 {	width: 30%;}
.width_31 {	width: 31%;}
.width_32 {	width: 32%;}
.width_33 {	width: 33%;}
.width_34 {	width: 34%;}
.width_35 {	width: 35%;}
.width_36 {	width: 36%;}
.width_37 {	width: 37%;}
.width_38 {	width: 38%;}
.width_39 {	width: 39%;}
.width_40 {	width: 40%;}
.width_41 {	width: 41%;}
.width_42 {	width: 42%;}
.width_43 {	width: 43%;}
.width_44 {	width: 44%;}
.width_45 {	width: 45%;}
.width_46 {	width: 46%;}
.width_47 {	width: 47%;}
.width_48 {	width: 48%;}
.width_49 {	width: 49%;}
.width_50 {	width: 50%;}
.width_51 {	width: 51%;}
.width_52 {	width: 52%;}
.width_53 {	width: 53%;}
.width_54 {	width: 54%;}
.width_55 {	width: 55%;}
.width_56 {	width: 56%;}
.width_57 {	width: 57%;}
.width_58 {	width: 58%;}
.width_59 {	width: 59%;}
.width_60 {	width: 60%;}
.width_61 {	width: 61%;}
.width_62 {	width: 62%;}
.width_63 {	width: 63%;}
.width_64 {	width: 64%;}
.width_65 {	width: 65%;}
.width_66 {	width: 66%;}
.width_67 {	width: 67%;}
.width_68 {	width: 68%;}
.width_69 {	width: 69%;}
.width_70 {	width: 70%;}
.width_71 {	width: 71%;}
.width_72 {	width: 72%;}
.width_73 {	width: 73%;}
.width_74 {	width: 74%;}
.width_75 {	width: 75%;}
.width_76 {	width: 76%;}
.width_77 {	width: 77%;}
.width_78 {	width: 78%;}
.width_79 {	width: 79%;}
.width_80 {	width: 80%;}
.width_81 {	width: 81%;}
.width_82 {	width: 82%;}
.width_83 {	width: 83%;}
.width_84 {	width: 84%;}
.width_85 {	width: 85%;}
 .footer{
    background: #fff;
    width: 100%;
    position: absolute;
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

.brk{
width:120px;
     display:block;
    word-break:break-all;
}

.new {
	margin-top: 5%;
	margin-left: 5%;
	margin-right: 5%;
}
</style>

<style type="text/css" media="print">
    html, body { margin: 2; padding: 0; }
      /* body { height: 11in;  width: 8.5in; } */
       a[href]:after {
	    content: " (" attr(href) ")";
	 }
	  #footer { position: absolute; bottom: 0; width:100%; margin:0 auto;} 
</style> 



</head>
	<body>
	 <c:set var="object1" value="${paymentVoucherList}" />
	 <c:set var="usrnameObject" value="${userName}" />	 
<div class="new">
		<form class="form-horizontal" action="printCashbankpayment">
			<table align="center" class="padding-20p" border="0" cellpadding="0" width="100%" cellspacing="0">
				<tr>
					<td>	
						<table width="100%" border="0" cellspacing="0" cellpadding="2">	
						<tr>
						<td colspan="3" align="center"><img src="/img/MBKHelpVideos/Dental_Council_of_India_logo1.png"></td></tr>
						<tr>
						
					<td colspan="3" align="center"><font face="arial" size="2"><b>${object1.companyName}</b></font></td> 
				</tr>
				<tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>Aiwan-E-Galib Marg, Kotla Road, New Delhi</b></font></td> 
					</tr>
					<%-- <tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>Kotla Road, New Delhi</b></font></td> </tr>
					<!-- <tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>Opp. Mata Sundari College for Women,</b></font></td> </tr>
					<tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>New Delhi - 110002</b></font></td> </tr> -->
						<tr>
					<td colspan="3" align="center"><font face="arial" size="2"><b>GST# ${object1.compGst}</b></font></td> </tr>
						 --%>
					</table>
							<br><br>
						<table width="100%" border="0" cellspacing="0" cellpadding="2">	
						<%-- 	<tr>		
						<c:choose>
								    <c:when test="${object1.pmtType=='B'}">
								        <td colspan="3" align="center"><font face="arial" size="4"><b>Bank Payment Voucher<br><br></b></font></td> 
								    </c:when>    
								    <c:otherwise>
								    	<td colspan="3" align="center"><font face="arial" size="4"><b>Cash Payment Voucher</b></font></td> 
								    </c:otherwise>
								</c:choose>			
							</tr> --%>	
								<tr>	
									<td class="width_20" align="left"><font face="arial" size="2"><b>Invoice No</b> : ${object1.invoiceNo}<br><br></font></td>
									<td class="width_20" align="left"><font face="arial" size="2"><b>Invoice Date</b> : ${object1.invoiceDate}<br><br></font></td>
<%-- 									<td class="width_20" align="left"><font face="arial" size="2"><b>Customer</b> :${object1.customerName}<br><br></font></td>
 --%>								</tr>	 	
								<tr>	
									
									
								</tr>	
								<tr>
								
								<td class="width_20" align="left"><font face="arial" size="2">	
									<b>Customer</b> : ${object1.customerName}<br>${object1.custAddress}</font></td>	
								
								
								<td class="width_20" align="left"><font face="arial" size="2">	
									<b>Customer GST#</b> : ${object1.custgst}<br></font></td>	
								
								
							<%-- 	<td class="width_20" align="left" >
										<font face="arial" size="2">	
										<b>AMOUNT TOTAL : ${object1.amount} </b></font>
									</td> --%>
												<td class="width_20" align="left" ><font face="arial" size="2"><b>AMOUNT TOTAL : </b><fmt:formatNumber
									type="number" minFractionDigits="2" maxFractionDigits="2"
									value="${object1.amount}" /></td>
									
																			</tr>
								<tr>	
									<%-- <td class="width_20" align="left" valign=bottom>
										<font face="arial" size="2">	
										<b>Cur </b> : 
												${object1.acctCurrency}
										<b>  &nbsp; &nbsp; Ex-Rate</b> :
												${object1.exchangeRate}<br><br>
										</font>
									</td> --%>
									
												
									<%-- <td class="width_20" align="left" valign=bottom>
										<font face="arial" size="2">	
										<b>TC Total  : 
												${object1.tcAmountHdr} </b> <br><br>
										</font>
									</td>  --%>
									 
									
								</tr>	
							
							</table>
							
							<!-- Detail Table ---- Starts -->
						<h3>Charge List</h3>
							<table class="table table-striped b-t b-light dotted-border" width="100%" border="1" bordercolor="" cellspacing="0" cellpadding="2" align="center">
								<thead>					
									<tr>
										<th class="width_30 dotted-border" align="center"><font face="arial" size="2"><span class="bold">Account Name</span></th>
										<th class="width_25 dotted-border" align="center"><font face="arial" size="2"><span class="bold">Narration</span></th>
										<th class="width_10 dotted-border" align="center"><font face="arial" size="2"><span class="bold">Amount</span></th>
								
								
									</tr>
								</thead>
								<tbody>
								 <c:forEach var="ob" items="${paymentVoucherList.salesOrderList}"> 
									<tr>
										
										<td class="subcolor width_30 dotted-border" align="left" valign="top">
											<font face="arial" size="2"> ${ob.accountHeadCode} -</font><br>
											<font face="arial" size="2">${ob.accountName}</font><br>
											<%-- <font face="arial" size="2">Sub Group:- ${ob.subGroupName}</font><br> --%>
											
										</td>
										
										<td class="subcolor width_25 dotted-border" align="left"  valign="top" >
											<font face="arial" size="2"><span class="normal"> ${ob.accountName} </span></td>
											
											
										<td class="subcolor width_10 dotted-border" align="right" valign="top" nowrap="nowrap"><span class="normal"> 
										<font face="arial" size="2">${ob.amount}  
										</span></td> 
										
																														
									</tr>
												
										<%-- <tr>		
									<td class="dotted-border" align="center"><font face="arial" size="2"><b>Total</b></font></td>		
									<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
								
									<td class="dotted-border" align="right"><font face="arial" size="2">
										<!-- Total Amount --> ${object1.amount}
									</font></td>
									
								</tr> --%>
								</c:forEach>
								<tr>		
									<td class="dotted-border" align="center"><font face="arial" size="2"><b>Total</b></font></td>		
									<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
								
									<td class="dotted-border" align="right"><font face="arial" size="2"><fmt:formatNumber
									type="number" minFractionDigits="2" maxFractionDigits="2"
									value="${object1.amount}" />
										<!-- Total Amount --> 
									</font></td>
									
								</tr>
								</tbody>	
								
								
								
							</table>
							<!-- <br>
							<h3>Item List</h3> -->
							
							<%-- <table  width="100%" border="1" bordercolor="" cellspacing="0" cellpadding="2" align="center">
								<thead>					
									<tr>
										<th class="width_30 dotted-border" align="center" ><font face="arial" size="2"><span class="bold">Item Name</span></th>
										<th class="width_25 dotted-border" align="center" ><font face="arial" size="2"><span class="bold">quantity</span></th>
										<th class="width_10 dotted-border" align="center" ><font face="arial" size="2"><span class="bold">Amount</span></th>
								
								
									</tr>
								</thead>
								<tbody>
								 <c:forEach var="ob" items="${paymentVoucherList.invoiceProdDetail}"> 
									<tr>
							
										
										<td class="subcolor width_25 dotted-border" align="left"  valign="top" >
											<font face="arial" size="2"><span class="normal"> ${ob.productItem} </span></td>
										
										<td class="subcolor width_25 dotted-border" align="left"  valign="top" >
										<font face="arial" size="2">	<span class="normal"> ${ob.quantity} </span></td> 
										
										<td class="subcolor width_10 dotted-border" align="right" valign="top" nowrap="nowrap"><span class="normal"> 
									<font face="arial" size="2">	${ob.amount}  
										</span></td> 
									</tr>
								</c:forEach>
								<!-- write -->					
								<tr>		
									<td class="dotted-border" align="center"><font face="arial" size="2"><b>Total</b></font></td>		
									<td class="dotted-border" align="center"><font face="arial" size="2"><br></font></td>
								
									<td class="dotted-border" align="right"><font face="arial" size="2">
										<!-- Total Amount --> ${object1.amount}
									</font></td>
									
								</tr>
								</tbody>	
								
								
								
							</table> --%>
							<br>

							<table border=0 bordercolor="" cellspacing="0" cellpadding="2" align="center" valign="bottom">
								<tr>
									<td><br><br></td>
								</tr>
								<tr>
									<td align="center"><font face="arial" size=3>${usrnameObject} <!-- User Name --></font></td>
									<td align="center"><br></td>
									<td align="center"><br></td>
								</tr>
								<tr>							
									<td align="center">________________________<br><font face="arial" size="2">Created By</font></td>		
									<td align="center">________________________<br><font face="arial" size="2">Reviewed By</font></td>
									<td align="center">________________________<br><font face="arial" size="2">Approved By</font></td>
								</tr>	
							</table>
						</td>	
						
					</tr>
				</table>
				<table id="footer" class="footer" border=0 bordercolor="" cellspacing="0" cellpadding="2" align="center" valign="bottom">								
															
				</table>
		</form>
		</div>
	</body>
</html>