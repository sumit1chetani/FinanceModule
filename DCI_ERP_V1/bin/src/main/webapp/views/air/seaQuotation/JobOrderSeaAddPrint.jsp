<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />

<html>
<head>
<style>
@page { size: auto;  margin: 5mm; }
#table2, td, th {
	border: 1px solid #ddd;
	text-align: left;
}

#table2 {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	/* padding: 15px; */
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
.no_border {
border: 0px;
}


</style>

<style type="text/css" media="print">
html, body {
	margin: 0;
	padding: 0;
	border:1px solid;
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
margin: 2mm;

}


</style>
<style type="text/css">

.chngTdCls > tbody > tr > td{
padding: 5px 0px !important;
}
</style>
</head>

<body style="border:1px solid" >
<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="hdr" value="${headerDetails}" />

<table width="100%" cellpadding="0" cellspacing="0" class="no_border" bgcolor="FFFFFF" bordercolor=""  align="center">
						

						<table border="0"  class="no_border" class="padding-top-2" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td width="50%" class="no_border" style="text-align: center; font-size:15px; font-family: arial;   padding-right: 200px;">

								<table border="0" width="100%" cellpadding="0" cellspacing="0"
									bgcolor="FFFFFF" bordercolor="" align="center">
									<tr>
										<td width="25%" class="no_border"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 10 0 0 10; height: 60px;"></td>
										<td width="75%" class="no_border"><span
											style="text-align: center; font-family: arial;  font-size:15px;   text-transform: uppercase;"><center>${user.tenantId}
													</center></span> 
											<br>
										<span  ><center style="font-family: arial;  font-size:15px;">
												${hdr.address1} ${hdr.address2}</center></span> <br>
										
										<span  ><center style="font-family: arial;  font-size:15px;">${hdr.address3}</center></span>
										<span ><center style="font-family: arial;  font-size:15px;" ><c:if test="${hdr.gstnNo != ''}">GSTNO:${hdr.gstnNo}</c:if></span></center>
									</tr>
								</table>
							</td>

						</tr>
						<tr>
						</tr>
					</table>

						<tr>
						</tr>
					</table> 
 <c:set var="bean" value="${headerDetails}" />
  <center style="padding-top: 1%;font-size:16px;padding-left:20px; font-family: arial;">COST & PROFIT ANALYSIS (CPA)</center>
	<br>

	<table width=750px border=0 bordercolor="" style = "font-size:10px;">
	<tr>
	<td width=10% class="no_border" style="padding-top: .5em;    padding-left: 20px;padding-bottom: .5em; font-size: 12px;  font-family: arial;">Customer </td>
	<td width=40% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial; ">:&nbsp;&nbsp;${bean.customerName} </td>
	<td width=10% class="no_border" style="padding-top: .5em;padding-bottom: .5em;	"><b></b> </td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;	"><b></b> </td>
	</tr>
	<tr>
	<td width=10% class="no_border" style="padding-top: .5em;    padding-left: 20px;padding-bottom: .5em;font-size: 12px;  font-family: arial; ">Job &nbsp;&nbsp;</td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.jobNo}</td>
	<td width=10% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">Job Date </td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.jobDt} </td>
	</tr>
	<tr>
	<td width=10% class="no_border" style="padding-top: .5em;    padding-left: 20px;padding-bottom: .5em;font-size: 12px;  font-family: arial;    	">POL</td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.aolName} </td>
	<td width=10% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">POD</td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.aodName} </td>
	</tr>	
	<tr>
	<td width=10% class="no_border" style="padding-top: .5em;    padding-left: 20px;padding-bottom: .5em;font-size: 12px;  font-family: arial;    	">Origin</td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.originName}</td>
	<td width=10% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">Destination </td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.destinationName} </td>
	</tr>
	<tr>
	<td width=10% class="no_border" style="padding-top: .5em;    padding-left: 20px;padding-bottom: .5em;font-size: 12px;  font-family: arial;    	">Agents Name</td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.agentName} </td>
	<td width=10% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">Sales Person </td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.salesPerson}</td>
	</tr>
	<tr>
	<td width=20% class="no_border" style="padding-top: .5em;    padding-left: 20px;padding-bottom: .5em;font-size: 12px;  font-family: arial;	    ">Currency</td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.currencyName} </td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">Ex-Rate(USD) </td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.exRate} </td>
	</tr>
	<tr>
	
	<td width=20% class="no_border" style="padding-top: .5em;    padding-left: 20px;padding-bottom: .5em; font-size: 12px;  font-family: arial;		">Job Status </td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	">:&nbsp;&nbsp;${bean.jobStatus} </td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	"><b></b> </td>
	<td width=20% class="no_border" style="padding-top: .5em;padding-bottom: .5em;font-size: 12px;  font-family: arial;	"><b></b> </td>
	</tr>
	</table> 
		
	<br><br>
	<table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						
						<!-- <tr>
							<td class="padding-top-10"> -->
	
						<tr>
							<td style="border-top:none;border-bottom:none;border-left:none;border-right:none">
								<table class="" align="center" border="1px solid"
									cellPadding="0" cellSpacing="0" width=96%>
									<thead>
										<tr class="">
											<th class="width_8" height="10" text-align="center"
												style="font-size: 12px;;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;""><span
												class="bold">Charge Heads </span></th>
											<th class="width_22" height="10" align="center"
												style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;""><span
												class="bold"> Buy (INR) </span></th>
											<th class="width_10" height="10" align="center"
												style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;""><span
												class="bold">Sell (INR) </span></th>
											<th class="width_10" height="10" align="center"
												style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;""><span
												class="bold">Profit (INR) </span></th>
											<th class="width_10" height="10" align="center"
												style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;""><span
												class="bold">Profit (USD) </span></th>
											
										</tr>
									</thead>
									<c:forEach var="ob" items="${listDetails}">
										<tbody>


											<tr class="description">
												<td class="width_10 " align="left" 
													style="font-size: 12px;  font-family: arial;padding: 5px;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial; text-align: left;" valign="top"><span >${ob.chargeName}</span></td>
												<td class="width_10 " align="left"
													style="font-size: 12px;  font-family: arial;    padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial; text-align: right;" valign="top"><span style="padding: 6px;">${ob.buy}</span></td>
												<td class="width_10 " align="right"
													style="font-size: 12px;  font-family: arial;    padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial; text-align: right;" valign="top"><span style="padding: 6px;">${ob.sell}</span></td>
												<td class="width_10 " align="right"
													style="font-size: 12px;  font-family: arial;    padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial; text-align: right;" valign="top"><span style="padding: 6px;">${ob.profit}</span></td>
												<td class="width_10 " align="left"
													style="font-size: 12px;  font-family: arial;    padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial; text-align: right;" valign="top"><span style="padding: 6px;">${ob.profitusd} </span></td>
												
											</tr>



										</c:forEach> 
                            <tr><td></td><td></td><td style="text-align: right;padding: 6px;font-size: 12px;   font-family: arial; "> Total Profit</td><td style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial; text-align: right;     padding: 6px;"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bean.totprofit}" />	</td><td style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial; text-align: right; font-size: 12px;     padding: 6px;"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${bean.totprofitusd}" /></td></tr>
						</tbody>
								</table>
							</td>
						</tr>
						</table>
					
					<br>
					<table width=96% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						
						<tr>
							<td >
					
						<table class="table table-striped b-t b-light padding-top-10 chngTdCls"
						align="left" border="1px solid; "cellPadding="0"
						cellSpacing="0" width=100% style = "font-size:10px;">
						<thead>
							<tr>
								<th class="width_8" height="10" text-align="center" style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;">Invoice No</span></th>
								<th class="width_8" height="10" text-align="center" style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;">Invoice Date</span></th>
								<th class="width_8" height="10" text-align="center" style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;">Party</span></th>
								<th class="width_8" height="10" text-align="center" style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;">Invoice Amount</span></th>
								<th class="width_8" height="10" text-align="center" style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;">Invoice Currency</span></th>
								<th class="width_8" height="10" text-align="center" style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;">TDS</span></th>
								<th class="width_8" height="10" text-align="center" style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;">Receive Amount</span></th>
								<th class="width_8" height="10" text-align="center" style="font-size: 12px;  font-family: arial;padding-top: 0.5em;
    padding-bottom: 0.5em; font-family: arial;text-align: center;">Due Amount</span></th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ap"
								items="${jobInvoiceDetails}"
								varStatus="theCount">
								<tr>
									<td class="subcolor width_15 detail-table-cell" align="center" style="padding-top: 0.5em;
    padding-bottom: 0.5em;"
										valign="top"><font face="arial" size="2">${ap.invoiceNo}</font></td>
									
									
									<td class="subcolor width_10 text-wrap detail-table-cell" style="padding-top: 0.5em;font-size: 12px;  font-family: arial;";
    padding-bottom: 0.5em;"
										align="center" valign="middle"><span
										class="detail-table-font w-s-no">${ap.invoiceDate} </span></td>
									<td class="subcolor width_20 detail-table-cell" style="padding-top: 0.5em;font-size: 12px;  font-family: arial;
    padding-bottom: 0.5em;" align="center">
										<span class="detail-table-font">${ap.invoiceParty} </span>
									</td>
									<td class="subcolor width_15 detail-table-cell" style="padding-top: 0.5em; font-size: 12px;  font-family: arial;
    padding-bottom: 0.5em; text-align: right;" align="center">
										<span class="detail-table-font">${ap.invoiceAmt} </span>
									</td>
									<td class="subcolor width_10 detail-table-cell" style="padding-top: 0.5em;font-size: 12px;  font-family: arial;
    padding-bottom: 0.5em;text-align: right;" align="center">
										<span class="detail-table-font">${ap.invoiceCurrency} </span>
									</td>
									<td class="subcolor width_10 detail-table-cell" style="padding-top: 0.5em;font-size: 12px;  font-family: arial;
    padding-bottom: 0.5em;" align="center">
										<span class="detail-table-font">${ap.tds} </span>
									</td>
									<td class="subcolor width_10 detail-table-cell" style="padding-top: 0.5em;font-size: 12px;  font-family: arial;
    padding-bottom: 0.5em; text-align: right;" align="center">
										<span class="detail-table-font">${ap.recAmt} </span>
									</td>
									<td class="subcolor width_10 detail-table-cell" style="padding-top: 0.5em;font-size: 12px;  font-family: arial;
    padding-bottom: 0.5em; text-align: right;" align="center">
										<span class="detail-table-font">${ap.dueAmt} </span>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
					</td>
						</tr>
					</table>
					<br>
					<br>
					<br>
					<br>
					<br>
						
<b style = "font-size:12px;  font-family: arial; padding-left: 20px;">Prepared By</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style = "font-size:14px;">Approved By</b>
<br>
<b style = "font-size:12px;  font-family: arial; padding-left: 20px;">MBK</b><br>
<b style = "font-size:12px;  font-family: arial; padding-left: 20px;">(${name})</b>

</body>
</html>




