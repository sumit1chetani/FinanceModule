<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />


<head>
<meta http-equiv="Content-Type" content="text/htmlby
; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">
<style>
.bold {
	font-weight: bold;
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

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

@media print {
	#Header,#Footer{display:none !important}
}

@page {
	size: A4;
	margin: 0mm;
	font-size:small;
}


.wid50pr {
	width: 50%;
}

.wid60pr {
	width: 60%;
}

.wid70pr {
	width: 70%;
}
.wid25pr {
	width: 25%;
}

.wid10pr {
	width: 10%;
}

.wid30pr {
	width: 30%;
}

.wid80pr {
	width: 80%;
}

.wid40pr {
	width: 40%;
}

.wid35pr {
	width: 35%;
}

.wid30pr {
	width: 30%;
}

.wid20pr {
	width: 20%;
}


.wid100pr {
	width: 100%;
}

.flRt {
	float: right;
}

.flLt {
	float: left;
}

.fntSiz14px {
	font-size: 14px;
}
.fntSiz8px {
	font-size: 8px;
}

.fntSiz13px {
	font-size: 13px;
}

.fntSiz10px {
	font-size: 9px;
}

.fntSiz11px {
	font-size: 8px;
}

.ttbody{
height : 120px;
    
}


.fntSiz16px {
	font-size: 16px;
}

.fntSiz15px {
	font-size: 15px;
}

.paddLftRit15 {
	padding-right: 15px;
	padding-left: 15px;
	padding-top: 5px;
	padding-bottom: 5px;
}

.reduceheight
{
height:48px;
}
.paddLtTp5 {
	padding-left: 5px;
	padding-top: 5px;
	padding-bottom: 5px;
}

.txtAlgCent {
	text-align: center;
}

.hrLine {
	border-bottom: 1px solid #000;
	margin: 0px;
	border-top: 1px solid #fdf7f7;
}

.dataTbl>thead>tr>th {
	border-top: 1px solid #fff !important;
}

.dataTbl>tbody>tr>td {
	border-bottom: 1px solid #fff !important;
}

.bdrTpBl {
	border-top: 1px solid #000;
}

.bdrLtBl {
	border-left: 1px solid #000;
}

.bdrRtBl {
	border-right: 1px solid #000;
}

.bdrBpBl {
	border-bottom: 1px solid #000;
}

.bdrTpWh {
	border-top: 1px solid #fff;
}

.bdrLtWh {
	border-left: 1px solid #fff;
}

.bdrRtWh {
	border-right: 1px solid #fff;
}

.bdrBpWh {
	border-bottom: 1px solid #fff;
}
</style>
</head>
<body>
<div style="margin:0.50in 0.40in 0.50in 0.40in">
<c:set var="hdr" value="${masterList}" />
<br>
<br>
<br>
<div style="padding: 0%;">
	<form>
		<div style="margin-top:0px">
			<div class="col-sm-12 wid100pr">
				<div>
					<div>	
					<span></span>			
						<span class="bold fntSiz15px" style="padding-left: 60%;">BILL
							OF LADING </span> <span class="bold fntSiz15px"
							style="padding-left: 35%;">FOR COMBINED TRANSPORT OR PORT TO
							PORT SHIPMENT </span>
					</div>
				</div>
				<table width="100%">
					<thead>
					</thead>
					<tbody>
						<tr>
							<td class="wid50pr"><span class="bold fntSiz11px" style="padding-left:5px;padding-left:5px">
									SHIPPER (Name & Address). </span>
							<!-- 	<div class="" style="padding-left:5px;height: 97px;"> -->
								<p class="fntSiz10px" style="padding-left:5px;height: 94px;">${hdr.shipperAddress}</p>
									<%-- <span class="fntSiz10px">${hdr.shipperName}</span> <br />
									<div class="fntSiz10px wid80pr">${hdr.shipperAddress1}
										<span>
										${hdr.shipperAddress2}
										</span> <br>
										<span> ${hdr.shipperAddress3}
										</span>
										
										<br></div> --%>
								<!-- </div> -->

								<hr class="hrLine"> <span class="bold fntSiz11px" style="padding-left:5px">
									CONSIGNEE (Not negotiable unless Consigned TO ORDER ) </span> 
								<div class="" style="padding-left:5px">
									
									<!-- <div class="fntSiz10px wid80pr"> -->
										<p class="fntSiz10px" style="padding-left:5px;height: 86px;">${hdr.consigneeAddress}</p> 
										<%-- <span> ${hdr.consAddress1} </span> <br>
										<span>${hdr.consAddress2} </span> <br>
										<span> ${hdr.consAddress3} </span> --%>
									</div>
								<!-- </div> <br /> --></td>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tbody style="">
										<tr>
											<td class="bold fntSiz11px" width="50%"
												style="border-top: 1px solid #fff; border-left: 1px solid #fff; font-size: 12px;"><p style="font-size: 8px;">BOOKING
													NO.</p><p class="fntSiz10px">
													${hdr.jobName} </p></td>
											<td class="bold fntSiz11px" width="50%"
												style=" border-right: 1px solid #fff; border-top: 1px solid #fff;"><p>B/L NUMBER</p>
												<p class="fntSiz10px" >${hdr.hblCode}</p></td>
										
												
										</tr>
									</tbody>
								</table> 
								<div align="center" style="font-size:11px">
									<p style=" text-transform: uppercase;"><b>MBK GLOBAL LOGISTICS PTE. LTD.
									</b></p>
									<p style=" text-transform: uppercase;"><b>NO 2. ANG MO KIO,
									</b></p>
									<p >  STREET 64 #05-01L, ECON BUILDING 
									</p>
									<p > SINGAPORE 569084,</p>
									<p>SINGAPORE</p>
									<p> TEL: +65 65555837 FAX: +65 65555839</p>
									<p >E-Mail: info@mbk-logistics.com </p>
									<p> Web: www.mbk-logistics.com </p>
									
									<%-- /span> <br> <span style="text-align: right;">
										${hdr.address1}</span> <br> <span style="text-align: right;">${hdr.address2}
									</span> <br> <span style="text-align: right;">${hdr.address3}</span>
									<br><span ><center><c:if test="${hdr.gstnNo != ''}">GSTNO:${hdr.gstnNo}</c:if></span> --%></center>
								</div>
							</td>

						</tr>
						<tr>
							<td >
								<div style="padding-bottom: 10px;">
									<span class="bold fntSiz11px" style="padding-left:5px">NOTIFY PARTY (No claim
										shall attach for failure to notify)</span> <br />
									<div class="">
										
										<div class="fntSiz10px wid80pr">
											<p style="padding-left:5px">${hdr.notifyAddress}</p> 
										
										</div>
									</div>
									<br />
									<table style="width: 100%;">
										<tbody>
											<tr class="">
												<td class="bold fntSiz11px reduceheight" width="50%" 
													style="border-bottom: 1px solid #fff; border-left: 1px solid #fff;vertical-align:top"><span style="padding-left:5px"
													>PRE-CARRIAGE BY</span>
													<p class="fntSiz10px " style="padding-left:5px">${hdr.precarrg}</p>
													</td>
												<td class="bold fntSiz11px reduceheight" width="50%" 
													style="border-bottom: 1px solid #fff; border-right: 1px solid #fff;vertical-align:top"><span style="padding-left:5px"
													>PLACE OF RECEIPT BY
														PRE-CARRIER</span> <p class="fntSiz10px"
													style="padding-left:5px">${hdr.placeofReceipt}</p></td>
											</tr>
										</tbody>
									</table>
								</div>
							</td>
							<td class="wid50pr" style="line-height:16px">
								
									<span class="fntSiz8px" style="height: 200%;font-size:9px;font-family: Times New Roman;padding-left:5px">. For
										freight prepaid Bill of Lading, delivery of Cargo is subject
										to realisation of freight, Demmurage / Detention charges of
										Port of destination Payable by consignee as per lines tariff.
									</span>
									<br>
									 <span class="fntSiz8px" style="height: 200%;padding-left:5px">
										. By accepting this Bill of Lading, the shipper accepts his
										reponsibility towards the carrier for payment of freight (in
										case of freight collect shipments). Accrued Ground rent,
										reshipment or disposal costs (as the case may be) if the
										consignee fails to take delivery of the cargo. </span> <br>
										
										 <span
										class="fntSiz8px" style="height: 200%;padding-left:5px"> . In case of
										any discpreancy found in declared weight & volume the carrier
										reserves the right ot hold the shipment & recover all charges
										as per the revised weight & volume whichever is high from
										shipper or consingee.</span>
										<br>
										<span
										class="fntSiz8px" style="padding-left:5px"> . Freight prepaid B/Ls are issued
										subject to realisation of freight payments.</span>
								 
								<!-- <div>
									<span class="fntSiz8px""> </span>
								</div> -->
							</td>
						</tr>

						<tr>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz11px" width="50%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz10px" style="padding-left:5px"">VESSEL & VOYAGE NO.</span><br>
											<br> <span style="padding-left:5px">${hdr.vesselVoyeage}
										</span></td>
										<td class="bold fntSiz11px" width="50%"
											style="border-bottom: 1px solid #fff;padding-left:5px; border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											">PORT OF LOADING</span><br> <br>
											<span class="fntSiz10px" style="padding-left:5px">${hdr.portofLoad}</span></td>
									</tr>
								</table>
							</td>
							<td class="wid50pr">
								<div>
									<span class="bold fntSiz11px" style="padding-left:5px">FREIGHT PAYABLE AT</span>
								</div> <br>
								<div>
									<span class="fntSiz10px" style="padding-left:5px">${hdr.freightPayableAt} </span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz11px" width="50%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">PORT OF DISCHARGE.</span> <br>
											<br> <span class="fntSiz10px" style="padding-left:5px">
												${hdr.portofDischarge} </span></td>
										<td class="bold fntSiz11px" width="50%"
											style="border-bottom: 1px solid #fff;  border-right: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">PLACE OF DELIVERY</span> <br> <br>
											<span class="fntSiz10px" style="padding-left:5px">${hdr.placeofDelivery}</span></td>
									</tr>
								</table>
							</td>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz11px" width="60%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px">TYPE OF MOVE.</span><br> <br>
											<span class="fntSiz10px" style="padding-left:5px"> ${hdr.movementname} </span></td>
										<td class="bold fntSiz11px" width="50%"
											style="border-bottom: 1px solid #fff;  border-right: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px">NUMBER OF ORIGINALS</span><br>
											<br> <span class="fntSiz10px"style="padding-left:5px">${hdr.noOfOriginalBl}</span></td>
									</tr>
								</table>
							</td>
						</tr>
				</table>
				<div>
				<table style="width: 100%;">
				<thead>
					<tr>
						<th class="bold fntSiz11px wid20pr" 
							style="border-top: 1px solid #fff"><span>MARKS & NUMBERS.</span><br> <br>
							</th>
						<th class="bold fntSiz11px wid10pr" 
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							">NO. OF PKGS OR SHIPPING UNITS</span><br>
							<br> </th>
						<th class="bold fntSiz11px wid40pr" 
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							">DESCRIPTION OF GOODS & PKGS</span><br>
							<br> </th>
						<th class="bold fntSiz11px wid10pr" 
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							">CARGO WEIGHT</span><br> <br> </th>
						<th class="bold fntSiz11px wid20pr" 
							style="border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							>MEASUREMENT</span><br> <br> </th>
							
					</tr>
					</thead>
					<tbody >
					<c:forEach var="detailObj1" items="${ConList}">
						


							<tr class="description" style="font-size:10px;height:100">
								<td  class="fntSiz8px" align="left" 
								style=" border-bottom: 1px solid white"
									valign="top"><span >${detailObj1.marksAndNos}</span></td>
								<td class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${detailObj1.noofPackage}</span></td>
								<td  class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span >${detailObj1.cargoDescription}</span><br>
									</td>
									
									
								<td  class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${detailObj1.grossWeight} KGS</span></td>
								<td class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${detailObj1.measureMent}</span></td>
								

							</tr>
					</c:forEach>
					</tbody>
				</table>
				<table style="width: 100%;height: 42px;">
					<tr>
						<td class="bold fntSiz11px" width="20%" 
							style="border-top: 1px solid white;"></td>
						<td class="bold fntSiz11px" width="10.09%" 
						style="border-top: 1px solid white;"
							></td>
						<td class="bold fntSiz11px" width="39.9%"
							style="border-top: 1px solid white;border-bottom: white;">
							<table style="width: 100%;">
								
									<c:forEach var="detailObj2" items="${ConatinerList}">
						<tbody >
						</tbody>
						</c:forEach>
									</table></td>
						<td class="bold fntSiz11px" width="10%"
						style="border-top: 1px solid white;border-bottom: white;"
							></td>
						<td class="bold fntSiz11px" width="20%"
						style="border-top: 1px solid white;border-bottom: white;"
							style="border: none;"></td>
					</tr>
					<tr>
					<td class="fntSiz11px"colspan="2">ABOVE PARTICULARS AS DECLARED BY SHIPPING</td>
					<td style="border-left:white;border-top: white;"></td> 
					<td style="border-left:white;border-top: white;"></td> 
					<td style="border-right:white;border-left:white;border-top: white;"></td>
					</tr>
				</table>
				</div>
				<table style="width: 100%;">
					<tr>
						<td  width="100%"
							style="border-top: 1px solid #fff; border-bottom: 1px solid #fff;font-size:10px"><span class="fntSiz8px"style="padding-left:5px">Note : The Merchant's attetnion
								is called to the fact that according to Clauses 10, 11 and 12 of
								this Bill of Loading, the liability of the carrier is, in most
								cases, limited in respect of loss of damage to the goods and
								delay.</span> <span class="fntSiz11px">
								<%-- ${bunkerRequestData.hawbiataCode} --%>
						</span></td>

					</tr>
					<tr>
						<td  width="100%" style="border-top: 1px solid #fff; font-size:10px">
						<span class="fntSiz8px" style="width: 40%;padding-left:5px">DECLARED VALUE :</span>
						<span  class="fntSiz8px" style="width: 60%;padding-left:5px" >Refer to Clause 11(4) & (5) on reverse side</span> <%-- ${bunkerRequestData.hawbiataCode} --%>
						</td>

					</tr>

				</table>
				<table>
					<tr>
						<td width="50%" valign="top">
						<div>
						<span class="fntSiz11px" style="padding-left:5px">FRIEGHT RATES, WEIGHTS AND / OR
										MEASUREMENTS SUBJECT TO CORRECTION</span>
										</div>

						<!-- <table style="width: 100%">
								<tr>

									<span class="fntSiz11px">FRIEGHT RATES, WEIGHTS AND / OR
										MEASUREMENTS SUBJECT TO CORRECTION</span>
</tr>


								</table>
								 -->
								<table style="width: 100%;">
								
								<tr >
									<td width="30%;"style="border-left:hidden">
										<div>
											<span class="bold fntSiz11px" style="padding-left:5px">DETAILS</span>

										</div>
									</td>
									<td width="30%">
										<div>
											<span class="bold fntSiz11px" style="padding-left:5px">PREPAID</span>


										</div>
									</td>
									<td width="30%" style="border-right:hidden">
										<div>
											<span class="bold fntSiz11px" style="padding-left:5px">COLLECT</span>


										</div>
									</td>
			<!-- 						<td width="10%" style="border-right:hidden">
										<div>
											<span class="bold fntSiz11px"></span>


										</div>
									</td> -->
								
								</tr>
								<c:if test="${FooterList.size() == 0}">
						
								<tr style="font-size: 9px;"> 
								
									<td width="30%"  style="height: 55px;border-left: 1px solid white;border-bottom: 1px solid white;"><div><span class="bold fntSiz11px"></span></div></td>
									<td width="30%"   style="border-left:white;"><div>  <c:if test="${footerobj.paymentMode==1}"><span class="bold fntSiz11px" style="padding-left:30px"></span></c:if></div></td>
									<td width="30%" style="border-right: 1px solid white;"><div> <c:if test="${footerobj.paymentMode==2}"><span class="bold fntSiz11px" style="padding-left:30px"></span></c:if></div></td>
									
									</tr>
									
									
									
								<tr style="height: 1px;">
									<td width="30%" style="border-top: 1px solid #fff;border-left: 1px solid #fff;">
										<div >
											<label class="bold fntSiz11px" style="border-left:hidden;float: right;border-top: 1px solid #fff;border-top: 1px solid #fff;" >TOTAL</label>

										</div>
									</td>
									<td width="30%">
										<div>
											<span class="bold fntSiz11px" style="padding-left:30px">0</span>


										</div>
									</td>
									<td width="30%" style="border-right: 1px solid #fff">
										<div>
											<span class="bold fntSiz11px" style="padding-left:30px"> 0</span>


										</div>
									</td>
				<!-- 					<td width="10%" style="border-right: 1px solid #fff;">
										<div>
											<span class="bold fntSiz11px" style="border-left:hidden"></span>


										</div>
									</td> -->

								</tr>
							
								
								
								
								
								</c:if>
									
								<c:forEach var="footerobj" items="${FooterList}">
								<tr style="font-size: 9px;"> 
								
									<td width="30%" height=20 style="border-left: 1px solid white;border-bottom: 1px solid white;"><div><span class="bold fntSiz11px">${footerobj.chargeName}</span></div></td>
									<td width="30%"  height=20 style="border-left:white;"><div>  <c:if test="${footerobj.paymentMode==1}"><span class="bold fntSiz11px" style="padding-left:30px">${footerobj.amt}</span></c:if></div></td>
									<td width="30%" height=20 style="border-right: 1px solid white;"><div> <c:if test="${footerobj.paymentMode==2}"><span class="bold fntSiz11px" style="padding-left:30px">${footerobj.amt}</span></c:if></div></td>
									
									</tr>
									</c:forEach>
									<c:if test="${FooterList.size() >  0}">
									<c:forEach var="obj" items="${List}">
									
								<tr >
									<td width="30%" style="border-top: 1px solid #fff;border-left: 1px solid #fff;">
										<div >
											<label class="bold fntSiz11px" style="border-left:hidden;float: right;" >TOTAL</label>

										</div>
									</td>
									<td width="30%">
										<div>
											<span class="bold fntSiz11px" style="padding-left:30px">${obj.paymentAmount}</span>


										</div>
									</td>
									<td width="30%" style="border-right: 1px solid #fff">
										<div>
											<span class="bold fntSiz11px" style="padding-left:30px"> ${obj.collectAmount}</span>


										</div>
									</td>
				<!-- 					<td width="10%" style="border-right: 1px solid #fff;">
										<div>
											<span class="bold fntSiz11px" style="border-left:hidden"></span>


										</div>
									</td> -->

								</tr>
								</c:forEach>
								</c:if>
							</table>
							<table>
								<tr>
									
										<span class="bold fntSiz11px" style="padding-left:5px">DELIVERY AGENT</span> 
										
											<p class="fntSiz11px"> ${hdr.agentName}</p> 
											<p class="fntSiz11px"> ${hdr.agentAddress}</p>
											<div class="fntSiz11px wid80pr">
												<span class="fntSiz11px"></span> 

											</div>
										
								</tr>



							</table>

						</td>
						<td width="50%">
							<div>
								<p class="fntSiz8px" style="padding-left:5px">Received by the carrier the foods as specified above in apparent good order and condition unless otherwise stated, to be transported to such place as agreed, authorised or permitted herein and subject to all theterms and conditions appearing on the front and reverse of this Bill of Lading to which the Merchant agrees by accepting the Bill of Lading, any local privileges and customs notwithstanding.</p> 
									
									 <p class="fntSiz8px" style="padding-left:5px">The particulars given above as stated by the shipper and the weight, measure, quantity, condition, contens and value of the goods are unknown to the Carrier.</p> 
									 <p
									class="fntSiz8px" style="padding-left:5px">In WITNESS whereof one (1) original Bill of Lading has been signed if not otherwise stated above, the same being accomplished of the other(s), if any, to be void, if required by the Carrier one (1) original Bill of Lading must be surrendered duly endorsed in exchange for the goods or delivery order</p>
							</div>  <span class="fntSiz11px" style="padding-left:5px">Place and date of issue <u>  ${hdr.signedAt}  &nbsp&nbsp&nbsp&nbsp&nbsp ${hdr.hblDate}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  </u>
						</span> 
							<div style="position: relative;top: 5px;">
								<span class="fntSiz8px" style="padding-left:5px">By &nbsp&nbsp&nbsp&nbsp&nbsp</span>
								<c:if test="${!empty hdr.signedBy}">
								<span
									class="fntSiz11px"
									style="border-bottom: 1px; border-bottom-style: solid; width: 70%">
									${hdr.signedBy}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>  <br> <br>
									</c:if>

<c:if test="${empty hdr.signedBy}">
								<span
									class="fntSiz11px"
									style="border-bottom: 1px; border-bottom-style: solid; width: 70%">
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
									</c:if>

							</div>

						</td>
					</tr>
				</table>
<div style="margin-top: 21px;">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>




					<!-- <tr>
						<th class="bold fntSiz11px" width="20%"
							style="border-top: 1px solid #fff"><span
							">MARKS & NUMBERS.</span><br> <br>
							</th>
						<th class="bold fntSiz11px" width="10%"
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							">NO. OF PKGS OR SHIPPING UNITS</span><br>
							<br> </th>
						<th class="bold fntSiz11px" width="40%"
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							">DESCRIPTION OF GOODS & PKGS</span><br>
							<br> </th>
						<th class="bold fntSiz11px" width="10%"
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							">CARGO WEIGHT</span><br> <br> </th>
						<th class="bold fntSiz11px" width="50%"
							style="border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							>MEASUREMENT</span><br> <br> </th>
							
					</tr> -->
					<%-- <c:forEach var="detailObj1" items="${ConList}">
						<tbody >


							<tr class="description" style="font-size:10px;height:100">
								<td class="width_10 " class="fntSiz8px" align="left" 
								style=" border-bottom: 1px solid white"
									valign="top"><span>${detailObj1.marksAndNos}</span></td>
								<td class="width_10 " class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span>${detailObj1.noofPackage}</span></td>
								<td class="width_10 " class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span>${detailObj1.cargoDescription}</span><br>
									</td>
									
									
								<td class="width_10 " class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span>${detailObj1.netWeight} KGS</span></td>
								<td class="width_10 " class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span>${detailObj1.measureMent}</span></td>
								

							</tr>



						</tbody>
					</c:forEach> --%>
					<div align="center" >
					<span>ATTACH SHEET FOR BL NO : ${hdr.hblCode}</span>
					</div>
				<div>
				<table style="width: 100%;">
				<thead>
					<tr>
						<th class="bold fntSiz11px wid20pr" 
							><span>MARKS & NUMBERS.</span><br> <br>
							</th>
						<th class="bold fntSiz11px wid10pr" 
							style=" border-left: 1px solid #fff;"><span
							">NO. OF PKGS OR SHIPPING UNITS</span><br>
							<br> </th>
						<th class="bold fntSiz11px wid40pr" 
							style=""><span
							">DESCRIPTION OF GOODS & PKGS</span><br>
							<br> </th>
						<th class="bold fntSiz11px wid10pr" 
							style=" border-left: 1px solid #fff;"><span
							">CARGO WEIGHT</span><br> <br> </th>
						<th class="bold fntSiz11px wid20pr" 
							style="border-left: 1px solid #fff;"><span
							>MEASUREMENT</span><br> <br> </th>
							
					</tr>
					</thead>
					<tbody >
					<c:forEach var="detailObj1" items="${ConList}">
						


							<tr class="description" style="font-size:10px;height:100">
								<td  class="fntSiz8px" align="left" 
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${detailObj1.marksNoPrint}</span></td>
								<td class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px"></span></td>
								<td  class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${detailObj1.cargoDescPrint}</span><br>
									</td>
									
									
								<td  class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px"></span></td>
								<td class="fntSiz8px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px"></span></td>
								

							</tr>
					</c:forEach>
					</tbody>
				</table>
				<table style="width: 100%;height: 160px;">
					<tr>
						<td class="bold fntSiz11px wid20pr"  
							style="border-top: 1px solid white;"></td>
						<td class="bold fntSiz11px wid10pr" 
						style="border-top: 1px solid white;"
							></td>
						<td class="bold fntSiz11px wid40pr" 
							style="border-top: 1px solid white;border-bottom: white;">
							<table style="width: 100%;">
							<thead>
									<tr>
									<th class="bold fntSiz8px" style="border:hidden;width:20%
									;border-bottom:1px solid black">Container No
									</th>
									<th class="bold fntSiz8px" style="border:hidden;width:20%;border-bottom:1px solid black">CType
									</th>
									<th class="bold fntSiz8px" style="border:hidden;width:20%;border-bottom:1px solid black">Seal No
									</th>
									<th class="bold fntSiz8px" style="border:hidden;width:20%;border-bottom:1px solid black">PKG No
									</th>
									<th class="bold fntSiz8px" style="border:hidden;width:10%;border-bottom:1px solid black">Gross WT
									</th>
									<th class="bold fntSiz8px" style="border:hidden;width:10%;border-bottom:1px solid black">Net WT
									</th>
								
									</tr>
									</thead>
									<tbody >
									<c:forEach var="detailObj2" items="${ConatinerList}">
						
						<tr style="font-size:10px">
						
						<td  class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black"
									valign="top"><span style="padding-left:15px">${detailObj2.containerNo}</span></td>
									<td class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black"
									valign="top"><span style="padding-left:5px">${detailObj2.containersize}</span></td>
									<td  class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black"
									valign="top"><span style="padding-left:5px">${detailObj2.sealNo}</span></td>
									<td class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black"
									valign="top"><span style="padding-left:20px">${detailObj2.noofPackage}</span></td>
									<td  class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black"
									valign="top"><span style="padding-left:17px">${detailObj2.grossWeight}</span></td>
									<td  class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black"
									valign="top"><span style="padding-left:14px">${detailObj2.netWeight}</span></td>
									
						</tr>
						
						</c:forEach>
						</tbody>
									</table></td>
						<td class="bold fntSiz11px wid10pr" 
						style="border-top: 1px solid white;border-bottom: white;"
							></td>
						<td class="bold fntSiz11px wid20pr" 
						style="border-top: 1px solid white;border-bottom: white;"
							style="border: none;"></td>
					</tr>
				</table>
				</div>				</div>

			</div>
		</div>
	</form>
</div>
</div>
</body>