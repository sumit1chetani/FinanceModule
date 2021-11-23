<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<style>
.description, .description td {
	border-bottom: 1pt solid #fff;
	border-top: 1pt solid #fff;
}

.description1, .description1 td {
	border-bottom: 0px solid #fff;
}
/*  tr,td {
}
 */
 @media print {
    footer {page-break-after: always;}
}
 .blank_row
{
    height: 10px !important; /* Overwrite any previous rules */
    background-color: #FFFFFF;
}

.blterms {
	font-family: Bookman OLD style;
	font-size: 5px;
	font-weight: bold;
	font: normal;
	font-style: normal;
	text-align: justify;
	width: 30%;
}

.note_hdr {
	font-style: italic;
	font-weight: bold;
	font-size: 12px;
	font-family: arial;
}

.gridheadercell {
	color: #000000;
	background: #ffe6a2;
	text-align: center;
	FONT-FAMILY: Arial;
	FONT-SIZE: 8pt;
	padding: 2px;
	font-weight: bold;
}

.blprint {
	vertical-align: top;
	font-family: verdana;
	font-size: 11px;
	font-weight: bold;
}

.blprint1 {
	font-family: verdana;
	font-size: 10px;
	line-height: 1.5;
	text-align: justify;
}

.text_center {
	text-align: center
}

.text_right {
	text-align: right
}

.text_left {
	text-align: left
}

.width_100 {
	width: 100%;
}

.width_90 {
	width: 90%;
}

.width_95 {
	width: 95%;
}

.width_70 {
	width: 70%;
}

.width_50 {
	width: 50%;
}

.width_40 {
	width: 40%;
}

.width_30 {
	width: 30%;
}

.width_25 {
	width: 25%;
}

.width_15 {
	width: 15%;
}
.width_8{
	width: 8%
}
.width_20{
	width: 20%
}
.width_12{
width: 12%
}
.width_3 {
	width: 3%;
}

.text_decoration {
	text-decoration: underline
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

/* @page {
	size: A4 portrait; /* auto is the initial value */
	margin: 2mm; /* this affects the margin in the printer settings */
} */

.normal {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	text-decoration: none
}

.bold {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
	font-weight: bold;
	color: #000000;
	text-decoration: none;
	padding-left: 6px;
}

.footer {
	width: 100%;
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
.padding-bottom-15p{
padding-bottom: 15px;
}
.padding-bottom-20p{
padding-bottom: 20px;
}
.padding-left-5p{
padding-left: 5px;
}
.padding-5p{
	padding: 5px
}
.padding-top-50{
	padding-top: 50px;
}
.padding-top-40{
	padding-top: 40px;
}
.custom-color-1 .table-striped>thead>tr>th {
	color: #fff;
	border-bottom: 1px solid rgba(255, 255, 225, .15);
	border-left: 1px solid rgba(255, 255, 225, .15);
	border-top: 1px solid rgba(255, 255, 225, .15);
	background: #42a5f5 !important;
}
.padding-left-0{
 padding-left: 0px !important;
}
.padding-top-5{
 	padding-top: 5px !important;
}
.padding-top-20{
    padding-top: 20px;
}
.padding-top-10{
    padding-top: 10px;
}
.bank-details{
border-left-width: 0px; border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border: black;
}
.footer-details{
font-family: "bookman old style"; border: 0; overflow: auto; font-weight: normal; font-size: x-small; line-height: 1.5em;
}
.employeeTbl th{
	background: #f7d2ca;
}
.pull-left{
    float: left;
}
.font-size-15{
	font-size:15px !important;
}
.normal {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	text-decoration: none
}
 @media print
{
.break_page {page-break-after:always}
}

</style>
<style type="text/css" media="print">
     html, body { margin: 0; padding: 0; }
     a[href]:after {
	    content: " (" attr(href) ")";
	 }
	 #footer { position: absolute; bottom: 0; width:100%; margin:0 auto;} 
</style> 
</head>

<body marginheight=0 marginwidth=0 topmargin=0 leftmargin=0
	style="background-color: white">
	
			
	<%
	int  Count= 1;int title =0;int innerRowCnt = 0;
	%>
	<c:set var="test" value="false" />
	<c:set var="object1" value="${staffLedgerList}" />
	<c:forEach var="objEmpDtl" items="${staffLedgerList.lStaffHdrList}" varStatus="theCount">
	
	<% 
	if(Count==1){
	%>
		<table border="0" class="width_100" cellpadding="0" cellspacing="0"
					bgcolor="FFFFFF" bordercolor="#cccccc" align="center">
					<tr>
						<td>
							<img class="pull-left" src="/img/simatech-logo.jpg" />
							<span class="pull-left padding-top-20 bold font-size-15">INTER AFRICA<br>
							Account Listing With Analysis</span>
						</td>
						
					</tr>
					<tr>
						<td class="width_35"></td>
						<td align="center">
						<span class="pull-left padding-top-20 bold font-size-15">From Date : ${object1.fromDate} &nbsp; &nbsp; &nbsp;
						To Date : ${object1.toDate}</span>
						</td>
					</tr>
				</table> <br>
		<%	 
	}else{
		
	}
		%>
	
	<%
	if(title==1){
		title =0;innerRowCnt=0;
		%>
				<table border="0" class="width_100" cellpadding="0" cellspacing="0"
					bgcolor="FFFFFF" bordercolor="#cccccc" align="center">
					<tr>
						<td>
							<img class="pull-left" src="/img/simatech-logo.jpg" />
							<span class="pull-left padding-top-20 bold font-size-15">SIMATECH INTERNATIONAL<br>
							Account Listing With Analysis</span>
						</td>
						
					</tr>
					<tr>
						<td class="width_35"></td>
						<td align="center">
						<span class="pull-left padding-top-20 bold font-size-15">From Date : ${object1.fromDate} &nbsp; &nbsp; &nbsp;
						To Date : ${object1.toDate}</span>
						</td>
					</tr>
				</table> <br>
				<% 
	}  %>
	
	<%
	
	if(Count%3==0){
		title = title + 1;
		%>
				
		<c:set value="break_page" var="cssClass"></c:set>
	<%	 
	
	}else{
		%>
		 <c:set value="breakdgdg_page" var="cssClass"></c:set>
		<% 
	} Count= Count+1;  %>
	
	<c:forEach var="objSLDtl" items="${objEmpDtl.lStaffDtlList}" varStatus="theCount">
		<% innerRowCnt = innerRowCnt+1; %>
	</c:forEach>
	<% 
		if(innerRowCnt>6){
			title = 0;Count= 1;innerRowCnt=0;
	%>
			<c:set value="break_page" var="cssClass"></c:set>
		
	<%}%>

	<div class="${cssClass}">	
	<table align="center" border="0" cellPadding="0" cellSpacing="0" width="100%">

		<tr>
			<td><br>
				
				<table class="width_100" align="center" border="0" cellPadding="0" cellSpacing="0">
					<tr>
						<td class="padding-top-5" colspan="3">	
							<table align="left" border="1" cellPadding="2" cellSpacing="0" class="width_100">
							 
									<tr>
										<td class="width_12"  height="10" valign="top"><span class=normal><b>Transaction Date</b></span></td>
										<td class="width_40" align="center" class="" height="10" valign="top" style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
											class=normal><b>Transaction Ref</b></span></td>
										<td class="width_12" align="center" class="" height="10" valign=top><span
											class=normal><b>Journal No </b></span></td>
										<td class="width_8" align="center" class="" height="10" valign=top><span
											class=normal><b>BC Amt </b></span></td>
										<td class="width_8" align="center" class="" height="10" valign=top><span
											class=normal><b>TC Amt </b></span></td>
										<td class="width_5" align="center" class="" height="10" valign=top><span
											class=normal><b>Currency</b></span></td>
									</tr>
								 
								<%-- <c:forEach var="objEmpDtl" items="${staffLedgerList.lStaffHdrList}" varStatus="theCount"> --%>
									<tbody>									
										<tr>
											<td class="padding-top-5" colspan="6">
												<table class="employeeTbl" align="left" border="0" cellPadding="2" cellSpacing="0" class="width_100" style="background: #f7cad2;">
												<tr>
														<td colspan="3" width="15%" class="normal" height="10" align="left" valign="top">
															<b>Account Code :</b> <c:out value="${objEmpDtl.employeeCode}" /> <br>
															<b>Description :</b>  <c:out value="${objEmpDtl.employeeName}" />
														</td>	 											
														<td colspan="1" width="5%" class="normal" height="10" align="left" valign="top">
															<b>Opening Balance</b></td>
														<td colspan="1" width="5%" class="normal" height="10" align="left" valign="top">
															<b>USD</b> <br>
															<b>AED</b>
														</td>
														<td colspan="1" width="5%" class="normal" height="10" align="right" valign="top">
															<c:out value="${objEmpDtl.openingBalanceBC}" /> <br>
															<c:out value="${objEmpDtl.openingBalanceTC}" />
														</td> 
													</tr>
												</table>
											</td>										
										</tr>
										<c:forEach var="objSLDtl" items="${objEmpDtl.lStaffDtlList}" varStatus="theCount">
										<%-- <% innerRowCnt = innerRowCnt+1; %> --%>
											<tr>				    					    
				    					    	<td class="width_12"  height="10" valign="top">
				    					    		<span class=normal><b>${objSLDtl.transactionDate}</b></span></td>
												<td class="width_40" align="left" class="" height="10" valign="top" style="border-bottom-width: 1px; border-left-width: 0px; border-top-width: 1px; border-right-width: 0px;"><span
													class=normal><b>${objSLDtl.narration}</b></span></td>
												<td class="width_12" align="center" class="" height="10" valign=top><span
													class=normal><b>${objSLDtl.transactionNo}</b></span></td>
												<td class="width_8" align="right" class="" height="10" valign=top><span
													class=normal><b>${objSLDtl.bcAmount}</b></span></td>
												<td class="width_8" align="right" class="" height="10" valign=top><span
													class=normal><b>${objSLDtl.tcAmount}</b></span></td>
												<td class="width_5" align="left" class="" height="10" valign=top><span
													class=normal><b>${objSLDtl.currency}</b></span></td>
											</tr>
										</c:forEach>
										<tr>
											<td colspan="4" class="width_15"  height="10" valign="top" align="right">
				    					    		<span class="normal bold">Total for Account</span></td>
				    					    <td colspan="1" class="width_15"  height="10" valign="top" align="right">
				    					    		<span class="normal bold">USD<br>
															AED</span></td>
				    					    <td colspan="1" class="width_20"  height="10" valign="top" align="right">
				    					   		<span class="normal bold">
				    					   			<fmt:formatNumber var="totalBC" type="number" value="${objEmpDtl.closingBalanceBC}" />
				    					   			<fmt:formatNumber var="totalTC" type="number" value="${objEmpDtl.closingBalanceTC}" />			    					    			
			    					    			<c:out value="${totalBC}" /><br>
			    					    			<c:out value="${totalTC}" />
			    					    		</span>
				    					    </td>
										</tr>
										<tr class="blank_row">
								            <td bgcolor="#FFFFFF" colspan="6">&nbsp;</td>
								        </tr>
									</tbody>
								<%-- </c:forEach> --%>
							</table>
						</td>
					</tr>
				</table>
				
			
			</td>
		</tr>
	</table>
	</div>
		</c:forEach>
</body>
 
</html>