<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%-- <%@ page contentType="text/html; charset=UTF-8" %> --%>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans" /> -->
<link href='/css/opensans.css' type="text/css" rel='stylesheet'/>
<title>MBK - Delivery Order</title>
<style type="text/css">
body {
	background-color: #FFFFFF;
	color: #333366;
	font-family: Open Sans !important;
}

.form-horizontal {
	margin-right: -15px;
	margin-left: -15px;
}

.padding-20p {
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

.footer {
	width: 100%;
	position: fixed;
	bottom: 0px;
}

.footer-text {
	font-family: Open Sans !important;
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
	font-family: Open Sans !important;
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

.dotted-border {
	border: 1px dotted;
}
table{
	border-collapse:collapse;
}
td,th{
border-collapse:collapse;
}
</style>
<style type="text/css">
@page {
	size: auto;
	margin: 5mm;
}
</style>
<style type="text/css" media="print">
html, body {
	margin: 0;
	padding: 0;
}
/*  body { height: 11in;  width: 8.5in; } */
#footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	margin: 0 auto;
}
.tableStyle{
font-size: 13px;
}


</style>
</head>
<body>
	<c:set var="object1" value="${bean}" />
	<c:set var="dry20" value="${dry20}" />
	<%-- <c:set var="dry40" value="${dry40}" />
	<c:set var="special20" value="${special20}" />
	<c:set var="special40" value="${special40}" />
	<c:set var="reefer40" value="${reefer40}" /> --%>
	
	<c:set var="containerList1" value="${containerList1}" />
	<c:set var="containerList2" value="${containerList2}" />
	
	
	
	<c:set var="count" value="${loop.index+1}" scope="page"/>
	<%-- 	 <c:set var="usrnameObject" value="${userName}" />	  --%>
	
		<div id="content"  style="padding: 0%; border: none;" class="subpage">
			<table align="center" class="padding-20p" border="0" cellpadding="0"
				width="95%" cellspacing="0 ">
				<tr>
					<td>
						<!-- //HEADING -->
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="25%" class="no_border">
								<c:if test="${object1.carrier =='ALLIGATOR  SHIPPING CO LLC'}">
								<img
									src="/img/MBKHelpVideos/asco1.png"
									style="padding: 10 0 0 10; height: 60px;"></c:if>
																	<c:if test="${object1.carrier !='ALLIGATOR  SHIPPING CO LLC'}">
										<img src="/img/MBKHelpVideos/KIN.png"
									style="padding: 10 0 0 10; height: 60px;">
									</c:if>
									<!-- <img src="/img/MBKHelpVideos/mbk_image.png"
		style="float: right !important; padding: 14 0 0 10; height: 60px;"> -->
		</td>
								
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table align="center" class="padding-20p" border="0" cellpadding="0"
				width="95%" cellspacing="0 ">
				<tr>
					<td>
						<hr style="height: 1px;background-color: #335fa0;">
							<table width="100%" border="0" cellspacing="0" cellpadding="2">
								<tr>
								
									<td  align="center" style="padding-top: 7px;"><font face="Open Sans" size="5"><b>Import Delivery Order</b></font>
									</td>
								</tr>
							</table>
					</td>
				</tr>
				
				<tr>
						<td>
						<hr style="height: 2px;background-color: #335fa0;width: 98%;">
						<div class="subpage">
							
							<div>
								<table  width="100%" border="0" cellspacing="0" cellpadding="0" >
								
								<%-- <tr width="100%">
										<td style="font-size: 13px;">Rotation No <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-left: 5px;">  ${object1.rotationNo} </td>
										<td style="font-size: 13px;">DO.Date  </td>
										<td style="font-size: 13px;"> <span>:</span>${object1.currenctDate}  </td>
										
										
									</tr> --%>
									
									<tr width="100%">
										<td style="font-size: 13px;">DO.No <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-left: 5px;">  ${object1.doNumber} </td>
										<td style="font-size: 13px;">DO.Date  <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-left: 5px;"> ${object1.currenctDate}  </td>
										
										
									</tr>
									 <tr>
										<td style="font-size: 13px;padding-top: 3px;" > DO.Issue Time <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;" > ${object1.doTime}  </td>
										<td style="font-size: 13px;">DO Valid Up to  <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-left: 5px;"> ${object1.doVaildDate} </td>
										
									</tr>
									 <tr>
										<td style="font-size: 13px;padding-top: 3px;" >Consignee <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;" > <p>${object1.consignee}</p></td>
										
									</tr>
								<tr>
										
										
										<td style="font-size: 13px;padding-top: 3px;">Vessel Name <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;"> ${object1.vesselName}</td>
										<td style="font-size: 13px;padding-top: 3px;">Voyage No <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;"> ${object1.voyage}  </td>
										
									</tr>
									<tr>
										
										
										<td style="font-size: 13px;padding-top: 3px;">Load Port <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;"> ${object1.loadPortName}   </td>
										<td style="font-size: 13px;padding-top: 3px;">Discharge Port <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;"> ${object1.dischargePortName}    </td>
										
									</tr>
									<tr>
										
										
										<td style="font-size: 13px;padding-top: 3px;">Vessel Arrival Date <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;">${object1.arrivalDate} </td>
										<td style="font-size: 13px;padding-top: 3px;">Cargo Discharge Date <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;">${object1.dischargeDate}</td>
										
									</tr>
									
									<tr>
										
										
										<td style="font-size: 13px;padding-top: 3px;">Total No.of Containers <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;"> ${object1.containerCount}</td>
										<%-- <td style="font-size: 13px;padding-top: 3px;">Total Weight(gross)</td>
										<td style="font-size: 13px;padding-top: 3px;"> <span>:</span>${object1.weigth}  ${object1.gwunit}</td> --%>
										
										
									</tr>
									
									<tr>
										
										
										<%-- <td style="font-size: 13px;padding-top: 3px;" >Container(s) Available at</td>
										<td style="font-size: 13px;padding-top: 3px;" ><span>:</span> ${object1.dischargePort}</td> --%>
										<td style="font-size: 13px;padding-top: 3px;">Place of Return of Container(s) <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;"> ${object1.dischargePortName}</td>
										
									</tr>
									
									<tr>
										
										
										<%-- <td style="font-size: 13px;padding-top: 3px;" >Container(s) Available at</td>
										<td style="font-size: 13px;padding-top: 3px;" ><span>:</span> ${object1.dischargePort}</td> --%>
										<td style="font-size: 13px;padding-top: 3px;">Clearance Port <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;"> ${object1.dischargePortName}</td>
										
									</tr>
									
									<tr>
										
										
										<td style="font-size: 13px;padding-top: 3px;" >Hazardous Cargo Info <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;" > </td>
										<td colspan="2"></td>
										
									</tr>
									<tr>
										
										
										<td style="font-size: 13px;padding-top: 3px;" >Reefer Info (Cargo Temperature) <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;" ></td>
										<td colspan="2"></td>
										
									</tr>
									<tr>
										
										
										<td style="font-size: 13px;padding-top: 3px;" >OOG Info <span style="float:right;">:</span></td>
										<td style="font-size: 13px;padding-top: 3px;padding-left: 5px;" ></td>
										<td colspan="2"></td>
										
									</tr>
									
									
									
								</table>
								<hr style="height: 2px;background-color: #335fa0;width: 99%;">
							</div>
							
							</div>
							<div class="table-responsive" style="border: 1px solid #CCC;">
			<table border=1  width="100%">
				<thead class="dataTables-Main-Head" >
					<tr>
						<th style="width: 25%; text-align: center;font-size: 13px">B/L No.</th>
						<th style="width: 25%; text-align: center;font-size: 13px">Description</th>
						<th style="width: 25%; text-align: center;font-size: 13px">Package Type</th>
						<th style="width: 25%; text-align: center;font-size: 13px">Gross Weight</th>
					
					</tr>
					</thead>
					
					<tbody>
					<tr style="height:120px">
					<td style="text-align: center"><span style="font-size: 13px;">${object1.blNoNew}</span></td>
					<td style="text-align: center"><span style="font-size: 10px;">${object1.goods}</span></td>
					<td style="text-align: center"><span style="font-size: 13px;">${object1.pkgcount} - ${object1.packageType}</span></td>
					<td style="text-align: center"><span style="font-size: 13px;">${object1.totWt}  ${object1.gwunit}</span></td>
					</tr>
					</tbody>
					
					<tr>
					<td colspan ="2">
					<table width="100%">

										<thead class="dataTables-Main-Head">
											<tr>
												<th
													style="width: 50%; text-align: center; font-size: 13px; border-right: 1px solid;">Container
													No.s</th>
												<th style="width: 50%; text-align: center; font-size: 13px">Type</th>
											</tr>
										</thead>
										<c:forEach var="containerObj1" items="${containerList1}">
											<tbody>
												<tr class="description">
													<td class="width_10 " align="center" valign="top"
														style="border-top: 1px solid; border-right: 1px solid;"><span
														style="font-size: 13px;">${containerObj1.containerName}</span></td>
													<td class="width_10 " align="center" valign="top"
														style="border-top: 1px solid;"><span
														style="font-size: 13px;">${containerObj1.type}</span></td>
												</tr>

											</tbody>
										</c:forEach>
									</table>
								</td>

								<td colspan="2">
									<table width="100%">

										<thead class="dataTables-Main-Head">
											<tr>
												<th
													style="width: 50%; text-align: center; font-size: 13px; border-right: 1px solid;">Container
													No.s</th>
												<th style="width: 50%; text-align: center; font-size: 13px">Type</th>
											</tr>
										</thead>
										<c:forEach var="containerObj1" items="${containerList1}">
											<tbody>
												<tr class="description">
													<td class="width_10 " align="center" valign="top"
														style="border-top: 1px solid; border-right: 1px solid;"><span
														style="font-size: 13px;">${containerObj1.containerName}</span></td>
													<td class="width_10 " align="center" valign="top"
														style="border-top: 1px solid;"><span
														style="font-size: 13px;">${containerObj1.type}</span></td>
												</tr>

											</tbody>
										</c:forEach>
									</table>
								</td>

							</tr>
				
										
				
				
			</table>
					
				
				</div>
				
			</table>
		</div>
		<div >
		<p style="font-size: 13px;font-family: Open Sans !important;padding-left: 21px;">Remarks : <span>${object1.paymentRemarks} </span> </p>
		</div>
							
							
							<div  style="padding-top: 0px">
							<p style="padding-left: 4px;font-size: 13px;font-family: Open Sans !important;padding-left: 21px;">
							Agent's Stamp & Signature _______________________________ Date ____________________
							</p>
							
 							  
							</div>
							
							<div class="containers" style="padding-top: 45%">
							
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<!-- <tr>
								<td width="25%" class="no_border"><img
									src="/img/MBKHelpVideos/mbk_image.png"
									style="padding: 10 0 0 10; height: 60px;">
									<img src="/img/MBKHelpVideos/mbk_image.png"
		style="float: right !important; padding: 14 0 0 10; height: 60px;">
		</td>
								
							</tr> -->
						</table>
						</div>
						<div class="containers" style="padding-top: 30px">
						<hr style="height: 1px;background-color: #335fa0;">
						
							<p style="font-size: 10px;">
							The issuer of this Delivery Order acts, unless expressly indicated otherwise, always on behalf and in the name of MBK LOGISTIX PVT LTD (MBK, hereafter), (the "carrier"). The Contract of Carriage and all services of the Carrier are subject to the Carrier's Terms and Conditions (either when a bill of lading is issued subject to the "BL Standard Terms & Conditions", or in all other cases subject to the "Sea Waybill Terms & Conditions"), the booking terms and the local Agency Terms & Conditions at the ports of Loading, transhipment and discharge. CSL or Carrier means ${object1.placeofReturn}, and the issuer or ______________ means __________including all its branch offices in and acting as agent of MBK LOGISTIX PVT LTD only. 
Merchant includes the Booking Party, Shipper, Consignee, holder of a Bill of Lading, the receiver of the Goods and any Person owning, entitled to or claiming the possession of the Goods or the corresponding Bill of Lading or anyone acting on behalf of this Person and when the context so requires means those persons jointly and severally. 
							
							</p>
							<p style="font-size: 10px;"><br><span>1.</span> Your goods, shipped under the Bill of Lading or Sea Waybill referred to in the Import Delivery Order, are or shortly will be available for <br>collection at the Container Place of Availability noted in same. If your goods are not collected within three (3) days of the date of availability, CSL reserves the right to place them in bond storage at your risk and expense. You must then pay all storage and associated charges before taking delivery of your goods. If after 30 calendar days from the date of discharge the goods have not been collected, CSL may exercise its rights under the Bill of Lading to dispose of the goods to recover any outstanding charges.
							</p>
							<p style="font-size: 10px;"><span>2.</span>	For your convenience, as an additional service beyond the physical carriage of the goods, and strictly on the terms set out in this document, the Arrival Notice, and the Bill of Lading and/or Sea Waybill, as applicable, except insofar as inconsistent with this agreement, you may make use of CSL's container, free of charge, for the maximum period set out below commencing on and including the day after the date of discharge as the first free day. This is defined as the "Hire Free Period". Your collection of the container will signify your acceptance of the terms of the offer contained in this document for the use of the container.
							</p>
							<p style="font-size: 10px;"><span>3.</span>Ultimately, the empty container must be returned to the container depot specified below, clean, undamaged, and completely free of cargo residues, chemicals, Dangerous Goods labels (in accordance with applicable regulations), fumigation labels, stowage aids and lashings. Failure to comply with this requirement may result in the container being rejected by the depot, or in action being taken against you to recover the costs of repairs, cleaning, disposal of residue/contamination and any other costs arising as a result, including fines imposed by authorities, recovery costs and interest.
							</p>
							<p style="font-size: 10px;">4.	You are liable for and shall indemnify CSL for all costs, loss and damages arising from any accidents or incidents involving the container provided to you under this agreement which cause injury or death of persons or loss of or damage to property. CSL makes no warranties, express or implied with respect to the condition of the container (including any accessory equipment) or its fitness for any particular purpose. 
							</p>
							<p style="font-size: 10px;">
							5.	After the Hire Free Period, you have the option of retaining the container, and the container hire charges as set out below will apply. If after 30 calendar days from the date of discharge the container has not been returned to the location specified below CSL may: (a) demand the immediate return of the container; and / or (b) elect to proceed with legal action to recover the container, or the replacement value as recorded in the books of CSL, in addition to all accrued container hire, detention, demurrage, and administration charges. Failure to pay invoiced container hire charges and replacement costs may result in legal proceedings. This responsibility, including in respect of legal and court fees and collection expenses, remains, at all times jointly and severally, with the parties comprising the Merchant under the Bill of Lading and/or Sea Waybill, and with the person by whom or on whose behalf the container is collected, notwithstanding delegation of container collection or transportation to a third party contractor.
							</p>
							<p style="font-size: 10px;">
							6.	Please note containers are the property of CSL and that time is of the essence in relation to the return of empty containers. 
							</p>
							<%-- <p style="font-size: 10px;">
							7.	A total of ${object1.bookingFreedays} free calendar days including the day after the date of discharge (day one) are allowed for all containers. The empty container must be returned clean and undamaged to the return location nominated on this notice.
							</p> --%>
							<p style="font-size: 10px;">
							7.	After the elapse of free time, container hire charges as set out below will apply (exclusive of VAT/GST/all applicable local taxes). The container hire charges are effective
							</p>
							<p style="font-size: 10px;">
							8.	A "calendar day" is a day, calculated from midnight to midnight (or any part of that day) including, without limitation, weekends and holidays. The above rates and/or policy may be varied at CSL's discretion and will incur GST. For any enquiries  please contact
							<span style="font-size: 10px;"><b>${object1.vendorName}</b>.</span></p>
							</div>
							<div class="table-responsive" style="border: 1px solid #CCC;">
			<table border=1 style="font-size: 10px;">
					
				<thead class="dataTables-Main-Head" >
					<tr>
						<th style="width: 10%; text-align: center;">Container Type</th>
						<!-- <th style="width: 10%; text-align: center;"></th> -->
						<th style="width: 10%; text-align: center;">Free Days</th>
						<th style="width: 25%; text-align: center;">1st Period </th>
						<th style="width: 15%; text-align: center;">Rate for each day thereafter </th>
					
					</tr>
				</thead>
				
				
				<c:forEach var="Obj1" items="${dry20}">
					<tbody>
					<tr>
					<td>${Obj1.containerName}</td>
					<td>${Obj1.freedays} Calendar Days</td>
					<td>${Obj1.days1} Calendar Days ${Obj1.currency1} ${Obj1.rate1} per Calendar Day</td>
					<td>${Obj1.currency2} ${Obj1.rate2} per Calendar Day</td>
					
					</tr>
													
					</tbody>
					</c:forEach>
				
				
				
				<%-- <tbody>
					
						<tr>
							<td>20ft Dry</td>
							 
							<td>${dry20[0].days} Calendar Days</td>
							<td>${dry20[1].days} Calendar Days ${dry20[1].currency} ${dry20[1].rates} per Calendar Day</td>
							<td>${dry20[2].currency} ${dry20[2].rates} per Calendar Day</td>
							
						</tr>
						<tr>
							<td>40ft Dry</td>
							 
							<td>${dry40[0].dry40f} Calendar Days</td>
							<td>${dry40[1].dry40f} Calendar Days US$  per Calendar Day</td>
							<td>US$ ${dry40[2].dry40f} per Calendar Day</td>
							
						</tr>
						<tr>
							<td>40ft High Cube Dry</td>
							 
							<td>${dry40[0].days} Calendar Days</td>
							<td>${dry40[1].days} Calendar Days ${dry40[1].currency} ${dry40[1].rates} per Calendar Day</td>
							<td>${dry40[2].currency} ${dry40[2].rates} per Calendar Day</td>
							
						</tr>
						
						<tr>
							<td>20ft Special</td>
							 
							<td>${special20[0].days} Calendar Days</td>
							<td>${special20[1].days} Calendar Days ${special20[1].currency} ${special20[1].rates} per Calendar Day</td>
							<td>${special20[2].currency} ${special20[2].rates} per Calendar Day</td>
							
						</tr>
						
						<tr>
							<td>40ft Special</td>
							 
							<td>${special40[0].days} Calendar Days</td>
							<td>${special40[1].days} Calendar Days ${special40[1].currency} ${special40[1].rates} per Calendar Day</td>
							<td>${special40[2].currency} ${special40[2].rates} per Calendar Day</td>
							
						</tr>
						
						<!-- <tr>
							<td>20ft Reefer</td>
							 
							<td>___Calendar Days</td>
							<td>___Calendar Days US$  per Calendar Day</td>
							<td>US$ __per Calendar Day</td>
							
						</tr> -->
						<tr>
							<td>40ft Reefer</td>
							 
							<td>${reefer40[0].days} Calendar Days</td>
							<td>${reefer40[1].days} Calendar Days ${reefer40[1].currency} ${reefer40[1].rates} per Calendar Day</td>
							<td>${reefer40[2].currency} ${reefer40[2].rates} per Calendar Day</td>
							
						</tr>
					
				</tbody> --%>
			</table>
		</div>
		<p style="font-size: 10px;"><b>Please Return the Container to the following Depot : <span>${object1.dischargePortName}</span></b>
		</p>




						</div>

					</td>
				</tr>
			</table>
		</div>
		
	
</body>
</html>