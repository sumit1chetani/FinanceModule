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

<body style="border: 1px solid">
	<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="hdr" value="${headerDetails}" />

	<!-- <table width="100%" cellpadding="0" cellspacing="0" class="no_border" bgcolor="FFFFFF" bordercolor=""  align="center">
						

						<tr>
							<td width="50%" class="no_border" style="text-align: center; font-size:15px; font-family: arial;   padding-right: 200px;"> -->

	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="" align="center">
		<tr>
			<td width="25%"><img
											src="/img/MBKHelpVideos/mbk_image.png"
											style="padding: 10 0 0 10; height: 60px;"></td>
			<td width="100%" class="no_border"
				style="padding-top: 15; padding-right: 15; text-align: right;"><span
				style="text-align: right; font-family: arial; font-size: 15px; text-transform: uppercase;"><b>${user.tenantId} </b>
						<!-- GLOBAL LOGISTICS PVT LTD --> </span>
				<hr><%--  <br> <span
				style="font-family: arial; font-size: 15px;">${hdr.address1}</span>
				< --%> 
				</td>
		</tr>
	</table>
	<!-- </td>

						</tr>
						<tr>
						</tr>
					</table> -->
	<hr>
	<%-- <div style="padding-left: 80%;">
		<span>Date :</span> <span>${hdr.presentDate}</span>
	</div> --%>

	<center>
<!-- 		<b>CONTAINER RELEASE ORDER </b>
 -->				<b>Booking Confirmation</b>
		
	</center>
	<br>


	<table>
									
									
			<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: arial;">Issue 
				Date</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: arial;">:&nbsp;&nbsp;${hdr.bookingDate}
			</td>
			
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: arial;">Confmn #</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: arial;">:&nbsp;&nbsp;<b>${hdr.bookingNo}</b>
			</td>
		</tr>
		
		
		<tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: Ubuntu;"> 
				To</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: Ubuntu;">:&nbsp;&nbsp;${hdr.customerName}
			</td> 
			
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: arial;">CRO Valid Till </td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: arial;">:&nbsp;&nbsp;${hdr.croDate}
			</td>
		</tr>
		
		
		
		
									
			<%-- <tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: Ubuntu;"> 
				To</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: Ubuntu;">:&nbsp;&nbsp;${hdr.customerName}
			</td>
			 --%><tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: Ubuntu;">Name Of the Yard </td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: Ubuntu;">:&nbsp;&nbsp;${hdr.depot}
			</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: Ubuntu;">Yard Address </td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: Ubuntu;">:&nbsp;&nbsp;
			</td>
		</tr>
		
		
								
			<%-- <tr>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: Ubuntu;"> 
				CAP Code</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: Ubuntu;">:&nbsp;&nbsp;${hdr.custCode}
			</td>
			
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: Ubuntu;">Yard Address </td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: Ubuntu;">:&nbsp;&nbsp;${hdr.yardAddress}
			</td>
		</tr> --%>
		
		
		<tr>
			
			
			<%-- <td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 13px; font-family: Ubuntu;">Contact No</td>
			<td width=20% class="no_border"
				style="padding-top: .5em; padding-bottom: .5em; font-size: 12px; font-family: Ubuntu;">:&nbsp;&nbsp;${hdr.sportName}
			</td> --%>
		</tr>
													
  	</table>	


		</div>

    <div style="padding-left: 7%; style="font-size: 20px;">

	</div>

<%-- 	<c:set var="bean" value="${headerDetails}" />
 --%>	<br>

	<table width=100% border=0 bordercolor="" style="font-size: 10px;">
		
	
		<tr>

			<td colspan="2" width=10% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu;">Dear Sir,</td>
		</tr>
		<tr>

			<td  colspan="3" width=50% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu; ">Thank you for choosing MBK LOGISTIX PVT LTD as your shipping partner. We are issuing the container release order as requested by your good office.</td>

		</tr>
		
		
			
		</table>
		
		
		<div class ="main-table">
		
   <table border=0 cellPadding=0 cellSpacing=0 class="width_100" style="width:100%;"cellspacing="10px">
 			
	<tr>
    												<td class="normal" width="10%">&nbsp;&nbsp;<b>Sr. No </b>&nbsp;</td>
    													<td class="normal" style="text-align:center;" colspan="2"> <b>Booking Details</b></td>
  													</tr>
  													<tr>
    													<td class="normal"  style ="text-align: center;">1</td>
    													<td class="normal" height="10">&nbsp;&nbsp;Port Of Loading </td>
    													  <td class="normal" height="10">&nbsp;&nbsp;${hdr.polName}</td>
    													
  													</tr>
  													<tr>
    													<td class="normal" style ="text-align: center;">2</td>
    													<td class="normal" height="10">&nbsp;&nbsp;Port Of Discharge</td>
  													    	<td class="normal" height="10">&nbsp;&nbsp;${hdr.podName}</td>
  													
  													</tr>
  													<tr>
    													<td class="normal" style ="text-align: center;">3</td>
    													<td class="normal" height="10">&nbsp;&nbsp;Final Destination</td>
  													     <td class="normal" height="10">&nbsp;&nbsp;${hdr.destination}</td>
  													
  													</tr>
  												
  													<tr>
    													<td class="normal" style ="text-align: center;">4</td>
    													<td class="normal" height="10">&nbsp;&nbsp;Commodity </td>
    													  <td class="normal" height="10">&nbsp;&nbsp;${hdr.commodity}</td>
    													
  													</tr>

  													
  												 <tr>
    												<!-- <td class="normal" >&nbsp;&nbsp;</td>
    												<td class="normal" height="10">&nbsp;&nbsp;</td>
    												<td class="normal" height="10" colspan="5">&nbsp;&nbsp;</td> -->
    												<td class="normal" height="20" colspan="4">&nbsp;&nbsp;</td>
    												
   													</tr>
   													<tr>
    													<td class="normal" style ="text-align: center;">5</td>
														<td class="normal" height="10">&nbsp;&nbsp;Container Type</td>
														<td class="normal" height="10">&nbsp;&nbsp;Number Of Containers</td>
													</tr>
   											<c:set var="index" value="0"></c:set>  
						  						<c:forEach var="slotmessageList" items="${ConList}" varStatus="theCount">
							  					<tr>
													<td class="normal" style ="text-align: center;"></span></td>
													<td class="normal" height="10">&nbsp;&nbsp;${slotmessageList.conType}</span></td>
													<td class="normal" height="10">&nbsp;&nbsp;${slotmessageList.quantity}</span></td>
												</tr>
											  </c:forEach>
  												<tr>
    												<td class="normal" style ="text-align: center;">6</td>
    												<td class="normal" height="10">&nbsp;&nbsp;Vessel / Voyage </td>
    												<td class="normal" height="10">&nbsp;&nbsp;${hdr.vessel}/${hdr.voyage}</td>
    											</tr>
    											<tr>
	    											<td class="normal" height="25" colspan="4">&nbsp;&nbsp;</td>												
   												</tr>
   												<tr>
    												<td class="normal" style ="text-align: center;">7</td>
    												<td class="normal" height="10">&nbsp;&nbsp;Port Gate-In After </td>
    												<td class="normal" height="10">&nbsp;&nbsp;Date :${hdr.etasailDate} </td>
<%--     											<td class="normal" >&nbsp;&nbsp;Time : ${hdr.portIn}</td>
 --%>  											</tr>
  												<tr>
  													<td class="normal" style ="text-align: center;">8</td>
    												<td class="normal" height="10">&nbsp;&nbsp;Port Gate Cut-Off </td>
    												<td class="normal" height="10">&nbsp;&nbsp;Date :${hdr.gateInDate}</td>
<%--     											<td class="normal" >&nbsp;&nbsp;Time : ${hdr.portout}</td>
 --%>  											</tr>
 												<tr>
    												<td class="normal" height="25" colspan="4"></td>
    											</tr>
   												<tr>
    												<td class="normal" style ="text-align: center;">9</td>
    												<td class="normal" height="10">&nbsp;&nbsp;ETD<c:if test="${hdr.polName !=null }"> - ${hdr.polName}</c:if></td>
													<td class="normal" height="10">&nbsp;&nbsp;Date :${hdr.etasailDate}</td>
												</tr>	
  												<tr>
    												<td class="normal" style ="text-align: center;">10</td>
    												<td class="normal" height="10">&nbsp;&nbsp;ETA<c:if test="${hdr.podName !=null }"> - ${hdr.podName}</c:if></td>
  													<td class="normal" height="10">&nbsp;&nbsp;Date :${hdr.voyagePortETA}</td>
  												</tr>											
	                                            <tr>
  													<td class="normal" style ="text-align: center;">11</td>
    												<td class="normal" height="10">&nbsp;&nbsp;Vehicle No </td>
													<td class="normal" height="10">&nbsp;&nbsp;</td>
 												</tr>	
   										</table>
  												
  													</div>
	

						<br>
						
						
							 
						
						
	
	
	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="" align="center">
	

<tr>
<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; ">
<b>Other terms & conditions</b>
</td>
</tr>
	<tr>
     <td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu;">a) Empty containers in shipper's custody is allowed 5 (five) days free of detention.</td>
		
		</tr>	
		
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu;">b) Ensure that empty container(s) received from the yard is in clean & cargo worthy condition. Costs for any subsequent rejection will be to your account.</td>
			
		</tr>
		
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu;">c) Loaded container(s) must be returned in safe and sound condition at the nominated Depot within the stipulated free time.</td>
			
		</tr>
		
			<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu;">d) Any loss or damage to the container(s) while in your custody shall be fully indemnified from repair/replacement/reimbursement as notified by owner/hirer.</td>
			
		</tr>
	
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu;">e) HAZ stickers must be affixed in case the cargo is Hazardous in nature.</td>
			
		</tr>
		
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu;">f) HAZ cargo should be moved inside the port only after receiving an approval in writing from our office.</td>
			
		</tr>
		
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu;" >g) Ensure that the Cargo Weight in the Container does not exceed the maximum permissible loadability as stipulated on the CSC Plate. In the event of, if container is overloaded and the Gross Container Weight exceeds the permissible limit, 
all consequential fines and charges incurred for shifting and cross stuffing etc will be to the account of the Shipper/Customer.</td>
			
		</tr>
		
		<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; font-family: Ubuntu;" >h) This release order is only valid for the above-referred shipment.</td>
			
		</tr>
		
	
	</table>

	<br>
	
	
	
	
	
	
	
	
	
	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		bgcolor="FFFFFF" bordercolor="" align="center">
	


<tr>
				<td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; ">Your's Faithfully
			
		</tr>
	
		
		
		<tr>
		<td width=20% class="no_border"
		style="padding-top: .5em; padding-left: 40px; padding-bottom: .4em; font-size: 13px; "><b>MBK Logistix Pvt Ltd</b></td>

		</tr>
		
	
	</table>
	
	
	
	

	<br>
	
	
		<br>
		 
					<table>
									
									
	   <tr>
			<%-- <td width=20% class="no_border"
				style="padding-top: .5em; padding-left: 40px; padding-bottom: .5em; font-size: 14px; font-family: arial;">cc :&nbsp;&nbsp;${hdr.ccmail}
				</td> --%>

		
		</tr>
		
							
  											 	</table>	 





</body>
</html>




