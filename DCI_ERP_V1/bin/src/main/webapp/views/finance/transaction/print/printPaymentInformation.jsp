<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>PaymentInformation</title>
<style type="text/css">
.custom-color-1 .table-striped>thead>tr>th {
	color: #fff;
	border-bottom: 1px solid rgba(255, 255, 225, .15);
	border-left: 1px solid rgba(255, 255, 225, .15);
	border-top: 1px solid rgba(255, 255, 225, .15);
	background: #42a5f5 !important;
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
</style>



</head>
<body>
 <c:set var="object1" value="${paymentInfoList}" />

 
<form>	
	<table align=center border=0 cellPadding=0 cellSpacing=0 width="95%">
		<tr>
			<td><br><br>
				<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="#cccccc" align=center>		
					<tr>
						<td>
							<img src="/img/sfpl_logo_202x48.jpg" />
						</td>
					</tr>
				</table><br>
				<table width=100% border=0 cellspacing=0 cellpadding=0 align=center>
					<tr>
						<td>
							<table width=100% border=1 bordercolor="" cellspacing=0 cellpadding=2 align=center>
								<tr>
									<td class="header-bg" align="center" colspan='2'>
									<span  class="bold"><font size="3"> Payment Information</font></span></td>
								</tr>
								<tr>
		
									<td class="subcolor"1 width="26%">Payment Order No</td>
		
									<td class="subcolor" height="26" width="74%">
									<span class=normal> ${object1.paymentInformationNo}</span></td>
								</tr>
		
								<tr>
									<td class="subcolor"1 width="26%">Date</td>
		
									<td class="subcolor" height="26" width="74%"><span
										class=normal> ${object1.paymentInformationDate}</span></td>
		
								</tr>
		
								<tr>
		
									<td class="subcolor"1 width="26%">Supplier</td>
		
									<td class="subcolor" height="26" width="74%"><span
										class=normal> ${object1.supplierName}</span></td>
		
								</tr>
		
										
							</table><br>
							<table class="table table-striped b-t b-light" width=100% border=1 bordercolor="" cellspacing="0" cellpadding="2" align="center">
								<thead>
									<tr>
										<th class="" align="center"><span class=bold>Sl.No</span></th>
										<th class="" align="center"><span class=bold>Due Date</span></th>
										<th class="" align="center"><span class=bold>Party Inv. No.</span></th>
										<th class="" align="center"><span class=bold>Party Inv. Dt.</span></th>
										<th class="" align="center"><span class=bold>Invoice No</span></th>
										<th class="" align="center"><span class=bold>Invoice Date</span></th>
										<th class="" align="center"><span class=bold>Curr</span></th>
										<th class="" align="center"><span class=bold>Ex-Rate</span></th>
										<th class="" align="center"><span class=bold>Inv.TC Amount </span></th>
										<th class="" align="center"><span class=bold>Inv.BC Amount </span></th>
										<!-- <th class="" align="center"><span class=bold> Payable Amount</span></th> -->
										<th class="" align="center"><span class=bold>Pay TC Amount </span></th>
										<th class="" align="center"><span class=bold>Pay BC Amount </span></th>
									</tr>
								</thead>
								<tbody>
								 <c:forEach var="ob"  items="${paymentInfoList.lDetaillist}"> 
									<tr>
										<td class="subcolor" align="center" nowrap="nowrap"><span class=normal> ${ob.slNo} </span></td>
										<td class="subcolor" align="center" nowrap="nowrap"><span class=normal> ${ob.dueDate} </span></td>
	
										<td class="subcolor" align="center" nowrap="nowrap"><span class=normal> 
										${ob.partyInvoiceNo} 
										</span></td>
										<td class="subcolor" align="center" nowrap="nowrap"><span class=normal> 
										${ob.partyInvoiceDate} 
										</span></td>
	
										<td class="subcolor" align="center" nowrap="nowrap"><span class=normal> 
										${ob.invoiceNo} 
										</span></td>
	
										<td class="subcolor" align="center" nowrap="nowrap"><span class=normal> 
										${ob.invoiceDate} 
										</span></td>
	
	
										<td class="subcolor" align="center"><span class=normal> 
										${ob.currency} 
										 </span></td>
										<td class="subcolor" align="center"><span class=normal> 
										${ob.exchangeRate} 
										 </span></td>
										<td class="subcolor" align=right><span class=normal> 
											${ob.tcAmount} 
										</span></td>
										<td class="subcolor" align=right><span class=normal> 
											${ob.bcAmount} 
										</span></td>
	
										<%-- <td class="subcolor" align=right>
										${ob.pendingAmount} 
										</td> --%>
	
										<td class="subcolor" align=right><span class=normal> 
										${ob.payTCAmount} 
										</span></td>
										<td class="subcolor" align=right><span class=normal> 
										${ob.payAmount} 
										</span></td>
									</tr>
									
								</c:forEach>
								<!-- write -->
								
								<tr>
									<td class="subcolor" align=right colspan="9" >
									<b>
									Total Amount&nbsp;
									</b>
									</td>
									<td align=right>
										<span class="normal">
										</span>
									</td>
									<td align=right>
										<span class="normal">
											${object1.sPayTCAmount}
										</span>
									</td>
									<td align=right>
										<span class="normal">
											${object1.sPayAmount}
										</span>
									</td>
								</tr>
								</tbody>								
							</table>
							
						</td>
					</tr>
					<tr>
						<td>
							<table width="100%" border=0 bordercolor="" cellspacing=0 cellpadding=2 align="center" valign="bottom">								
					<tr>
						<td align="center"><font face="arial" size=3> ${object1.createdByName} </font></td>
						<td align="center"><font face="arial" size=3> ${object1.approvedByName} </font></td>
					</tr>
					<tr>							
						<td align="center">________________________<br><font face="arial" size="2">Prepared By</font></td>		
						 <td align="center">________________________<br><font face="arial" size="2">Approved By</font></td>
						<td align="center">________________________<br><font face="arial" size="2">Receiver Signature</font></td> 
					</tr>											
				</table>	
						</td>
					</tr>	
					<br><br>	
					<tr>
						<td>
							<table class="footer" border=0 bordercolor="" cellspacing=0 cellpadding=2 align="center" valign="bottom">	
								<tr>		
									<td align="center"  class="subcolor">														
									<span class=footer-text> ${object1.address}</span></td>
								</tr>
		
								<tr>
									<td align="center" class="subcolor">
										<span class=footer-text><b>Tel.:</b> ${object1.phoneNo}</span>
										<span class=footer-text><b>Telex:</b> ${object1.faxNo}</span>
										<span class=footer-text><b>e-mail:</b> ${object1.email}</span>
									</td>		
								</tr>		
								<tr>		
									<td align="center" class="subcolor">
									</td>		
								</tr>
								<tr>		
									<td align="center" class="subcolor">
									</td>		
								</tr>										
							</table><br>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			
		</tr>
	</table>
</form>
</body>
</html>