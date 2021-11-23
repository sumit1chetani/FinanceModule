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
@page {
	size: auto;
	margin: 5mm;
}

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
	border: 1px solid;
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

@page {
	size: A4;
	margin: 2mm;
}
</style>
<style type="text/css">
.chngTdCls>tbody>tr>td {
	padding: 5px 0px !important;
}
</style>
</head>

<body >
	<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="hdr" value="${headerDetails}" />

	<!-- <table width="100%" cellpadding="0" cellspacing="0" class="no_border" bgcolor="FFFFFF" bordercolor=""  align="center">
						

						<tr>
							<td width="50%" class="no_border" style="text-align: center; font-size:15px; font-family: arial;   padding-right: 200px;"> -->

	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="" align="center">
	<tr>
			<td width="25%" class="no_border"><img
				src="/img/Cordelia_resize_logo.jpg"
				style="padding: 10 0 0 10; height: 40px;"></td>
			<td width="100%" class="no_border"
				style="padding-top: 10; padding-right: 15; text-align: right;">
				<span
				style="text-align: right; font-family: arial; font-size: 10px; text-transform: uppercase;"><b>${user.tenantId}
						<!-- GLOBAL LOGISTICS PVT LTD --></span> </b>
				
				
		</tr>
	</table> 
	<!-- </td>

						</tr>
						<tr>
						</tr>
					</table> -->

	
	<div style="padding-left: 7%;">
<center>
<!-- 		<b>SEA TRADE AGENCIES (PVT) LTD</b>
 -->	
 <tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px;"></td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">&nbsp;${hdr.vendor_name_head}
			</td>
		</tr>
 </center>
	<div class="letter-style"
		style="font-size: 10px; margin-left: 150px; ;">
			<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px;"></td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">&nbsp;${hdr.vendor_address}
			</td>
		</tr>
		<br>
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px;"></td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">&nbsp;${hdr.vendor_off_tel_num}
			</td>
		</tr>
		<br>
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px;"></td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">&nbsp;${hdr.vendor_telex_num}
			</td>
		</tr>
		<!-- <p>LEVEL 1, VALIANT TOWERS, 46/7 NAWAM MAWATHA</p>
		<p>COLOMBO 2 SRI LANKA</p>
		<p>TEL : +94 11 4724516 </p>
		<p>FAX : +94 11 4724517</p> -->
	
	</div>
	
	<div class="letter-style"
		style="font-size: 10px; margin-right:50px; ">
		
		<!-- presentDate
		<p>11 MAR 2019</p> -->
		
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px;"></td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">&nbsp;${hdr.presentDate}
			</td>
		</tr>
		<p>THE DEPOT MANAGER,</p>
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px;"></td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">&nbsp;${hdr.depot_agent_name}
			</td>
		</tr>
		<br>
				
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; "></td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">&nbsp;${hdr.depot_address}
			</td>
		</tr>
		<br>
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; "></td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">&nbsp;${hdr.depot_phone_number}
			</td>
		</tr>
		<br>
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; "></td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">&nbsp;${hdr.depot_fax_number}
			</td>
		</tr>
		<!-- <p>REPCON CONTAINER DEPOT (PVT) LTD </p> -->
		<!-- <p>TEL NO : </p>
		<p>FAX NO : </p> -->
		
	</div>
	<div class="letter-style"
		style="font-size: 10px; margin-left: 350px; ">
		<p>YARD ACCOUNT  : cordelia CONTAINER LLC.</p>
	
	</div>
		</div>

<div style="padding-left: 7%; style="font-size: 20px;">
<center>
		<b>RELEASE ORDER</b>
	</center>
	</div>

	<c:set var="bean" value="${headerDetails}" />
	<%--  <center style="padding-top: 1%;font-size:16px;padding-left:20px; font-family: arial;">COST & PROFIT ANALYSIS (CPA)</center> --%>
	<br>

	<table width=100% border=0 bordercolor="" style="font-size: 10px;">
		
	
		<tr>

			<td colspan="2" width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">Dear Sir,</td>
		</tr>
		<tr>

			<td  colspan="3" width=50% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">PLEASE BE KIND ENOUGH TO MAKE ARRANGEMENTS TO RELEASE THE FOLLOWING CONTAINER/S.</td>

		</tr>
	
	
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">RELEASE ORDER REF.</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.container_release_hdr_code}
			</td>
		</tr>
		<tr>

			<td width=10% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; padding-left: 40px; ">CONTAINER AGENT</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.vendor_name}
			</td>
		</tr>
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">YARD / DEPOT</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.depot_agent_name}</td>
		</tr>
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">VESSEL / VOYAGE
			</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.vesselname} / ${bean.voyage}
			</td>
		</tr>
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">ETA (POL)</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.eta} / (${bean.pol})
			</td>
		</tr>
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; padding-left: 40px; font-size: 10px; ">SHIPPER / FORWARDER</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.customer}</td>
		</tr>
		<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">COMMODITY</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.commodity}
			</td>
		</tr>
		<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">DESCRIPTION OF GOODS
			</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.commodity}
			</td>
		</tr>
		<tr>

			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">PORT OF DISCHARGE</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.pod}
			</td>
		</tr>
		<tr>

		</tr>
		<tr>
		<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">DESTINATION
			</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.destination}
			</td>
		</tr>
		<tr>

		</tr>
		<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">CONTAINER SUMMARY</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.containersummary}
			</td>
			</tr>
			<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">CONTAINER DETAILS</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.terminal}
			</td>
		</tr>
		<tr>

		</tr>
		<tr>

			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">TERMINAL</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.depot}
			</td>
			</tr>
			<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">OPENING</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.eta1}
			</td>
		</tr>
		<tr>

		</tr>
		<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">CARGO CUT OFF DATE</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.cutoff_dt}
			</td>
		</tr>
		<tr>

		</tr>
		<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">VSL / CNTR OPERATOR CODE</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.vessel}
			</td>
		</tr>
		<tr>

		</tr>
		<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">REMARKS</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;
			</td>
			
			
		</tr>
		
	</table>

						<td width=24% >
							<table width=50% align="right"  cellPadding="0" cellSpacing="0" >
								<tr>
									
									<td valign="top" class="padding-left-5"><span class="normal" style="font-size: 10px;">
										<b>VEHICLE NUMBER :  ${object1.debitNoteNo}<br>
										ARRIVED AT : ${object1.debitNoteDate}<br>
										GATE IN : ${object1.invoiceNo}<br>	
										GATE OUT : ${object1.invoiceNo}<br>
										CONTAINER NUMBERS : ${object1.invoiceNo}<br>
									
						
										</b></span>
									</td>							
								</tr>
							</table>
						</td>
						
						
						
	
	
	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="" align="center">
	

				<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">*
THIS RELEASE ORDER IS VALID FOR 7 DAYS ONLY.</td>
</tr>
<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">* EMPTY CONTAINERS IN SHIPPERS CUSTODY IS ALLOWED 7 DAYS FREE OF DEMURRAGE. THEREAFTER, THE</td>
			
		</tr>
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">FOLLOWING DEMURRAGE CHARGES WOULD BE APPLICABLE.</td>
			
		</tr>
		
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">1 - 7 DAYS 20F USD 7.88 / DAY                               8 DAYS ONWARDS 20FT USD 10.50 / DAY</td>
			
		</tr>
		
			<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">40FT USD 7.88 / DAY                                       40FT USD 10.50 / DAY</td>
			
		</tr>
	
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">*   LOADING OF METAL SCRAP IS STICTLY PROHIBITED ON THESE CONTAINERS.</td>
			
		</tr>
		
			<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">*   BOAT NOTES FOR EXPORT CONTAINERS SHOULD BE PASSED WITHIN 6 HOURS AFTER FCL CUT OFF.</td>
			
		</tr>
		
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">*  THIS RELEASE ORDER IS ONLY VALID FOR THE ABOVE SHIPMENT.</td>
			
		</tr>
		
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px;  padding-bottom: .4em; font-size: 10px; ">* <b> PLEASE USE BOTTLE SEAL FOR FINAL SEAL.</b></td>
			
		</tr>
				
	
	</table>

<b style="font-size: 10px;  padding-left: 20px;">Yours
		Faithfully</b>
	<br>

	<b style="font-size: 10px;  padding-left: 20px;">MBK
		</b> 
	
	
	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="" align="center">
	
		<tr>
			<td width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 10px; ">PRINTED BY</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.userid}
			</td>
		</tr>
		<tr>

			<td width=10% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; padding-left: 40px; ">DATE</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .4em; font-size: 10px; font-family: arial;">:&nbsp;&nbsp;${bean.createddt} 
			</td>
		</tr>
	

				<hr> 
	
	</table>
	<hr>




</body>
</html>


