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
tr.noBorder td {
  border: 0;
  padding-bottom: 1em;
  borer:1px solid
}
.description, .description th {
	border-bottom: 1pt solid #fff;
	border-top: -1pt solid #fff;
}

.description1, .description1 th {
	border-bottom: 0px solid #fff;
}

.description, .description td {
	border-bottom: 1pt solid #fff;
	border-top: -1pt solid #fff;
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
@page {
	size: A4;
	margin: 2mm;
}

}
@page { @bottom-right { content:counter(page)" of "counter(pages);
	
}
}
</style>

</head>
<body style="border:1px solid black">
  <input type="hidden" value="${user.tenantId}" id="tenantId">	
	<c:set var="object1" value="${headerDetails2}" />
	

	<div id="content">
		
		<table class="width_100" align="center" border="0"
			cellPadding="0" cellSpacing="0">
			<tr>
				<td>
					<table border="0" class="padding-top-2" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td width="50%" style="text-align: center;">
							
							<table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">
							<c:if test="${object1[0].serviceId ==1 }"><tr border="1" >
								<td  width="25%">EXPORT</td>
									
								<td  width="75%"> <span style="text-align: center;text-transform: uppercase;padding-left: 300px;"><b>JOB SHEET</b></span>
								 
							 </tr></c:if>
							 <c:if test="${object1[0].serviceId ==2 }"><tr border="1" >
								<td  width="25%">IMPORT</td>
									
								<td width="75%"> <span style="text-align: center;text-transform: uppercase;padding-left: 300px;"><b>JOB SHEET</b></span>
								 
							 </tr></c:if>
							<tr>
								<td width="25%"><img src="/img/${user.tenantId}HelpVideos/logo.jpg" style=" padding:10 0 0 10; height: 60px;">
								</td>
									
								<td width="75%"> <span style="text-align: center;text-transform: uppercase;padding-left: 195px;"><b>${user.tenantId} GLOBAL LOGISTICS PVT LTD</b></span>
								 <br><span style="text-align: right;padding-left: 85px;"> ${object1[0].address1}</span>
								 <br><span style="text-align: right;padding-left: 183px;">${object1[0].address2} </span>
								 <br><span style="text-align: right;padding-left: 212px;">${object1[0].address3}</span>
							 </tr>
							 </table>
							</td>
							
						</tr>
						<tr>
						</tr>
					</table> 
					<p>
					
							<%-- <table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						<tr>
					<td align="left"  style="padding-left: 3px;"><span>Quotation No :  ${hdr.quotationNo}<br>
				</span></td>
				<td align="right"  style="padding-left: 3px;"><span>Quotation Date  :  ${hdr.quotationDate}<br>
				</span></td>
				</tr>
				</table> --%>
				<br>
			
				<%-- <table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						<tr>
					<td align="left"  style="padding-left: 3px;"><span><b>To</b>
				</span></td>
					<br>
				</tr>
			
				
				<tr>
				<td align="left"  style="padding-left: 3px;"><span>Kind Attention&nbsp;: ${hdr.attention}<br>
				</span></td>
				</tr>
				<tr>
				<td align="left"  style="padding-left: 3px;"><span>Customer Name&nbsp;&nbsp;: ${hdr.customer}<br>
				</span></td>
				</tr>
					<tr>
				<td align="left"  style="padding-left: 3px;"><span>Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <br>
				</span></td>
				</tr>
			
			
				</table> --%>
				
							    <%--    <table class="table" width=100% border=0  bordercolor="" cellspacing="0" cellpadding="2" align="center">
										 <tr>
																	           <td colspan=1 style="border-top: none !important;line-height: 200%;text-decoration: underline;"><b>To</b></td><td colspan=1 style="border-top: none !important"></td>
           </tr>
     				 
																	 
																	 <tr>
           <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>Kind Attention</b></td><td colspan=1 style="border-top: none !important">${hdr.attention}</td>
           </tr>
           
            <tr>
           <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>Customer Name</b></td><td colspan=1 style="border-top: none !important">${hdr.custName}</td>
           <tr>
           <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>Address</b></td><td colspan=1 style="border-top: none !important">${hdr.custAddress1} ${hdr.custAddress2} ${hdr.custAddress3} ${hdr.custAddress4}</td>
          
           </tr>
                 <tr>
          
           </tr>
           	</table> --%>
           	
           	
           	<%-- <tr class="noBorder">
		  <td  colspan=1 style="border-top:1;line-height: 200%; border-bottom: 1px solid black;width: 25% "><b>JOB NO. :-${object1[0].jbName}</b></td><td colspan=1 style="border-top: none !important; border-bottom: 1px solid black; "></td>
		               <td colspan=1 style="border-top: none !important;line-height: 200%; border-bottom: 1px solid black;"><b></b></td><td colspan=1 style="border-top: none !important;border-bottom: 1px solid black;"></td>
		  
           </tr> --%>
           
           <div style="width: 100%;float: left; float: left;border-top: 1px solid black;border-bottom: 1px solid black;padding-top: 10px;padding-bottom: 10px;">
           <div style="width: 100%;float: left;"><b>JOB NO. :-${object1[0].jbName}</b></div>
           </div>
           
				
				
	<table class="table" width=100% border=  bordercolor="black" cellspacing="0" cellpadding="2" align="center">
		 	 <tr class="noBorder">
           <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>CONSIGNEE</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].consignee} </td>
          
           </tr>
        
 		<tr class="noBorder">
           <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>SHIPPER</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;"> ${object1[0].shipper} </td>
          
           </tr>
           
		 <tr class="noBorder">
           <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>CUSTMERNAME</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].customer} </td>
          
           </tr>
           
            <tr class="noBorder">
           <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>AIRLINE</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].line}</td>
<%--            <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>DESTINATION</b></td><td colspan=1 style="border-top: none !important">${hdr.destinationName}</td>
 --%>           <tr class="noBorder">
           <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>IATA AGENT</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].agent} </td>
<%--            <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>TERM</b></td><td colspan=1 style="border-top: none !important">${hdr.termName}</td>         
 --%>          
           </tr>
                
             <tr class="noBorder">
           <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>AOL</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].pol} </td>
          
           </tr>
           <tr class="noBorder">           <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>AOD</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].pod}</td>         
           
           </tr>
            <tr class="noBorder">           <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>COMMODITY</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].commodity}</td>         
           
           </tr>
            <tr class="noBorder">           <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>PACKAGE</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].pkg}</td>         
           
           </tr>
            <tr class="noBorder">          
            		<td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>GROSS WEIGHT</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].gross}KGS</td>
                    <td colspan=1 style="border-top: none !important;line-height: 200%;width: 20%"><b>CHARGEABLE WEIGHT</b></td><td colspan=1 style="border-top: none !important;width:20%">${object1[0].charge}</td>         
           </tr>
           <tr class="noBorder">          
            		 <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>HAWB NO.</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].hwb}</td>         
           
           </tr>
            <tr class="noBorder">          
             		 <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>MAWB NO.</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].mwb}</td>         
           
           </tr>
           <tr class="noBorder">         
                  <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>FLIGHT NO</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].flight}</td>
                  <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>ETA OF DESTINATION </b></td><td colspan=1 style="border-top: none !important;width: 20%">${object1[0].eta}</td>         
           </tr>
           
            
            <tr class="noBorder">          
            	 <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>IGM NO & DATE</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].igm}</td>         
            	 <td colspan=1 style="border-top: none !important;line-height: 200%;width: 20%"><b>ROTATION NO</b></td><td colspan=1 style="border-top: none !important;width: 20%">${object1[0].rotation}</td>
           
           </tr>
           <tr class="noBorder">          
            	 <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>CUSTOMS BROKER</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].broker}</td>         
            	 <td colspan=1 style="border-top: none !important;line-height: 200%;width: 20%"><b>DO RELEASE DATE</b></td><td colspan=1 style="border-top: none !important;width: 20%"></td>
           
           </tr>
           <tr class="noBorder">           
            		<td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>NOMINATION</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].nomination}</td>         
           
           </tr>
            <tr class="noBorder">           
            		<td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>EX-RATE</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].exrate}</td>         
           
           </tr>
           <tr class="noBorder">          
            	 <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>PICKUP DATE</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].pickUp}</td>         
            	 <td colspan=1 style="border-top: none !important;line-height: 200%;width: 20%"><b>STUFFING DATE</b></td><td colspan=1 style="border-top: none !important;width: 20%">${object1[0].stuffing}</td>
           
           </tr>
            <tr class="noBorder">         
            		  <td colspan=1 style="border-top: none !important;line-height: 200%;border-right: 1px solid black;width: 25%"><b>REMARKS</b></td><td colspan=1 style="border-top: none !important;width: 40%;padding-left: 10px;">${object1[0].remarks}</td>         
           </tr>
           	</table>
           	
				<%-- 	
					<table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
						<tr>
					<td align="left"  style="padding-left: 3px;"><span><b>Consignment Details</b><br>
				</span></td>
				</tr>
				<tr>
				<td align="left"  style="padding-left: 3px;"><span>AOL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${hdr.aolName}<br>
				</span></td>
				<td align="right"  style="padding-left: 3px;"><span>AOD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:  ${hdr.aodName}<br>
				</span></td>
				</tr>
				<tr>
				<td align="left"  style="padding-left: 3px;"><span>ORIGIN&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${hdr.originName}<br>
				</span></td>
				<td align="right"  style="padding-left: 3px;"><span>DESTINATION  :  ${hdr.destinationName}<br>
				</span></td>
				</tr>
				<tr>
				<td align="left"  style="padding-left: 3px;"><span>SERVICE TYPE : ${hdr.serviceType}<br>
				</span></td>
				<td align="right"  style="padding-left: 3px;"><span>TERM         :  ${hdr.termName}<br>
				</span></td>
				</tr>
				<tr>
				<td align="left"  style="padding-left: 3px;"><span>VALIDITY DATE : ${hdr.validityDate}<br>
				</span></td>
				<td align="right"  style="padding-left: 3px;"><span>COMMODITY    :  ${hdr.commodity}<br>
				</span></td>
				</tr>
				<tr>
				<td align="left"  style="padding-left: 3px;"><span>REMARKS      : ${hdr.remarks}<br>
				</span></td>
				</tr>
				</table>
				
			
				
	<%-- 				<table width=100% align="center" border="0" cellPadding="0"
						cellSpacing="0">
								 <tr>
		<td colspan=1 style="border-top: none !important;line-height: 200%;text-decoration: underline;"><b>Charge Details</b></td><td colspan=1 style="border-top: none !important"></td>
           </tr>
						<tr>
							<td class="padding-top-10">
								<table class="" align="left" border="1" bordercolor=""
									cellPadding="0" cellSpacing="0" width=100%>
									<thead>
										<tr class="">
											<th class="width_8" height="10" align="center"
												><span class="bold">Charge Heads </span></th>
											<th class="width_22" height="10" align="center"
												><span class="bold"> Unit </span></th>
											<th class="width_10" height="10" align="center"
												><span class="bold">Qty </span></th>
											<th class="width_10" height="10" align="center"
												><span class="bold">Rate </span></th>
											<th class="width_10" height="10" align="center"
												><span class="bold">Currency </span></th>
											<th class="width_20" height="10" align="center"
												><span class="bold">Notes</span></th>
										</tr>
									</thead>
									<c:forEach var="detailObj1" items="${detailList}" >	
									<tbody >
									
											
												<tr class="description" >
													<td class="width_10 "  align="left"
														valign="top" ><span
														>${detailObj1.chargeHead}</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>${detailObj1.unitName}</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>${detailObj1.quantityCount}</span></td>
													<td class="width_10 "   align="left"
														valign="top" ><span
														>${detailObj1.rate}</span></td>
														<td class="width_10 "   align="left"
														valign="top" ><span
														>${detailObj1.currencyName}</span></td>
													<td class="width_15 "  align="right"
														valign="top" style="padding-right: 2px; " >${detailObj1.note}</td>
												</tr>
												
											
									
									</tbody>
									</c:forEach>
								</table>
							</td>
						</tr>
					</table> --%>
					
						      <!--  <table class="table" width=100% border=0  bordercolor="" cellspacing="0" cellpadding="2" align="center">
										 <tr>
																	           <td colspan=1 style="border-top: none !important;line-height: 200%;text-decoration: underline;"><b>Terms & Conditions   : </b></td><td colspan=1 style="border-top: none !important"></td>
           </tr>
     				 
																	 
																	 <tr>
           <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>1. Freight will be charged on the basis of gross weight or volume weight whichever is higher. </b></td><td colspan=1 style="border-top: none !important"></td>
           </tr>
           
            <tr>
           <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>2. Volume ratio 1 : 6  </b></td><td colspan=1 style="border-top: none !important"></td>
           <tr>
           <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>3. The rate applicable on per kg basis.  </b></td><td colspan=1 style="border-top: none !important"></td>
          
           </tr>
                <tr>
           <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>4. The surcharges are change with or without prior notice.</b></td><td colspan=1 style="border-top: none !important"></td>
          
           </tr>
            <tr>
           <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>5. The above mentioned rate not valid for hazardous cargo/Over dimension cargo
</b></td><td colspan=1 style="border-top: none !important"></td>
          
           </tr>
           	</table> -->
           	 <%-- <table class="table" width=100% border=0  bordercolor="" cellspacing="0" cellpadding="2" align="center"> 
										 <tr>
																	           <td colspan=1 style="border-top: none !important;line-height: 200%;text-decoration: underline;text-transform: uppercase;"><b>FOR ${user.tenantId}  GLOBAL LOGISTICS PVT LTD  </b></td><td colspan=1 style="border-top: none !important"></td>
           </tr>
     				 
																	 
																	 <tr>
           <td colspan=1 style="border-top: none !important;line-height: 200%;"><b>(ADMIN)</b></td><td colspan=1 style="border-top: none !important"></td>
           </tr>
           
            <tr>
          
           	</table> --%>
           	
				</td>
			</tr>
			<!-- </table>
		<table id="footer" border=0 bordercolor="" cellspacing="0"
			cellpadding="2" align="center">
			<tr>
				<td colspan="10" align="center"><span class=footer-text> (This is a System Generated Quotation. No Signature Required)
				</span> </td>
			</tr>-->
		</table> 
	</div>

</body>
</html>
