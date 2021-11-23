<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">
<style>
.bold {
	font-weight: bold;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

@page {
	size: A4;
	margin: 2mm;
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

.wid80pr {
	width: 80%;
}

.wid40pr {
	width: 40%;
}

.wid30pr {
	width: 30%;
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
	font-size: 9px;
}

.fntSiz10px {
	font-size: 9px;
}

.fntSiz11px {
	font-size:  8px;
}
.fntSiz12px {
	font-size:  9px;
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
<c:set var="hdr" value="${masterList}" />

<div style="padding: 0%;padding-top:14%">
	<form>
		<div>
		<div align="right">
		<div class="col-sm-12 wid100pr bold fntSiz15px" style="float:left;">
		BILL OF LADING  
		</div>
		</div>
		<div align="right">
		<div class="col-sm-12 wid100pr bold fntSiz15px" style="float:left;">
	FOR COMBINED TRANSPORT OR PORT TO
							PORT SHIPMENT 
		</div>
		</div>
			<div class="col-sm-12 wid100pr " >
				<!-- <div>
					<div>	
				
						<div class="bold fntSiz15px" style="float:right;">BILL
							OF LADING </div> 
							<div class="bold fntSiz15px"
							style="float:right">FOR COMBINED TRANSPORT OR PORT TO
							PORT SHIPMENT </div>
					</div>
				</div> -->
				<table width="100%">
					<thead>
					</thead>
					<tbody>
						<tr>
							<td class="wid50pr"><span class="bold fntSiz12px"style="font-size:10px;padding-left:5px">
									SHIPPER (Name & Address). </span> <br />
								<div class="">
									<span class="fntSiz11px" style="padding-left:5px">${hdr.shipperAddress}</span>
										</div>
								</div> <br />

								<hr class="hrLine"> <span class="bold fntSiz12px"style="font-size:10px;padding-left:5px">
									CONSIGNEE (Not negotiable unless Consigned TO ORDER ) </span> <br />
								<div class="">
									<span class="fntSiz11px"></span> <br />
									<div class="fntSiz11px wid80pr">
										<span class="fntSiz11px" style="padding-left:5px">${hdr.consigneeAddress}</span>
										<%-- ${hdr.} --%> <%-- ${hdr.consAddress2} ${hdr.consAddress3} --%>
										<br>
									</div>
								</div> <br /></td>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tbody style="">
										<tr>
											<td class="bold fntSiz13px" width="50%"
												style="border-top: 1px solid #fff; border-left: 1px solid #fff; font-size: 9px;"><span style="padding-left:5px">BOOKING
													NO.</span><br> <br> <span style="font-size: 11px;padding-left:5px">
													${hdr.mblCode} </span></td>
											<td class="bold fntSiz13px" width="50%"
												style="font-size: 9x; border-right: 1px solid #fff; border-top: 1px solid #fff;"><span
												style="font-size: 9px;padding-left:5px">B/L NUMBER</span><br> <br>
												<span style="font-size: 9px;padding-left:5px">${hdr.noOfOriginalBl}</span></td>
										</tr>
									</tbody>
								</table> <span class="bold fntSiz12px"></span> <br />
								<div align="center">
									<span  class="fntSiz11px"style="text-align: right; text-transform: uppercase;font-size:9px"><b>${hdr.branchCode}
									</b></span> <br> <span style="text-align: right;font-size:9px">
										${hdr.address1}</span> <br> <span style="text-align: right;font-size:9px">${hdr.address2}
									</span> <br> <span style="text-align: right;font-size:9px">${hdr.address3}</span>
								</div> <br />
							</td>

						</tr>
						<tr>
							<td class="wid50pr">
								<div>
									<span class="bold fntSiz12px" style="padding-left:5px">NOTIFY PARTY (No claim
										shall attach for failure to notify)</span> <br />
									<div class="">
										<span class="fntSiz11px"> </span> <br />
										<div class="fntSiz11px wid80pr">
											<span class="fntSiz11px" style="padding-left:5px">${hdr.notifyAddress}</span> 

										</div>
									</div>
									<br />
									<table style="width: 100%;">
										<tbody style="">
											<tr>
												<td class="bold fntSiz12px" width="50%"
													style="border-bottom: 1px solid #fff;font-size: 9px; border-left: 1px solid #fff"><span
													class="fntSiz12px">PRE-CARRIAGE BY</span><br> <br>
													<span style="font-size: 11px;">${hdr.preCarriagedBy}
												</span></td>
												<td class="bold fntSiz12px" width="50%"
													style="border-bottom: 1px solid #fff; font-size: 9px; border-right: 1px solid #fff;"><span
													class="fntSiz12px"style="padding-left:5px">PLACE OF RECEIPT BY
														PRE-CARRIER</span><br> <br> <span
													class="fntSiz11px" style="padding-left:5px">${hdr.placeofReceipt}</span></td>
											</tr>
										</tbody>
									</table>
								</div>
							</td>
							<td class="wid50pr">
								<div>
									<span class="bold fntSiz12px" style="padding-left:5px">DELIVERY AGENT</span>
								</div> <br>
								<div>
									<span class="fntSiz11px"> </span>
								</div>
							</td>
						</tr>

						<tr>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz12px" style="padding-left:5px">VESSEL & VOYAGE NO.</span><br>
											<br> <span class="fntSiz11px" style="padding-left:5px">${hdr.vesselVoyeage}
										</span></td>
										<td class="bold fntSiz12px" width="50%"
											style="border-bottom: 1px solid #fff; font-size: 9px; border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz12px" style="padding-left:5px">PORT OF LOADING</span><br> <br>
											<span class="fntSiz11px" style="padding-left:5px">${hdr.polCode}</span></td>
									</tr>
								</table>
							</td>
							<td class="wid50pr">
								<div>
									<span class="bold fntSiz12px" style="padding-left:5px">FREIGHT PAYABLE AT</span>
								</div> <br>
								<div>
									<span class="fntSiz11px"style="padding-left:5px">${hdr.freightPayableAt} </span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz12px" width="50%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz12px"style="padding-left:5px">PORT OF DISCHARGE.</span> <br>
										<br> <span class="fntSiz11px"style="padding-left:5px">
												${hdr.portofDischarge} </span></td>
										<td class="bold fntSiz12px" width="50%"
											style="border-bottom: 1px solid #fff; font-size: 9x; border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz12px"style="padding-left:5px">PLACE OF DELIVERY</span> <br>
										<br> <span class="fntSiz11px" style="padding-left:5px">${hdr.placeofDelivery}</span></td>
									</tr>
								</table>
							</td>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz12px" style="padding-left:5px">TYPE OF MOVE.</span><br> <br>
											<span class="fntSiz11px" style="padding-left:5px"> ${hdr.movementm} </span></td>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff; font-size: 9px; border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz12px" style="padding-left:5px">NUMBER OF ORIGINALS</span><br>
											<br> <span class="fntSiz11px" style="padding-left:5px">${hdr.noOfOriginalBl}</span></td>
									</tr>
								</table>
							</td>
						</tr>
				</table>
				<table style="width: 100%;">
					<tr>
						<td class=" fntSiz13px" width="20"
							style="border-top: 1px solid #fff"><span
							class="bold fntSiz12px"style="font-size:9px;padding-left:5px">MARKS & NUMBERS.</span><br> <br>
							<span class="fntSiz12px""> <%-- ${bunkerRequestData.hawbiataCode} --%>
						</span></td>
						<td class=" fntSiz12px" width="20%"
							style="font-size: 11px; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							class="bold fntSiz12px"style="font-size:9px;padding-left:5px">NO. OF PKGS OR SHIPPING UNITS</span><br>
							<br> <span class="fntSiz11px"></span></td>
						<td class=" fntSiz12px" width="20%"
							style="font-size: 11px; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							class="bold fntSiz12px"style="font-size:9px;padding-left:5px">DESCRIPTION OF GOODS & PKGS</span><br>
							<br> <span class="fntSiz11px"></span></td>
						<td class=" fntSiz12px" width="20%"
							style="font-size: 11px; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							class="bold fntSiz12px"style="font-size:9px;padding-left:5px">CARGO WEIGHT</span><br> <br> <span
							class="fntSiz11px"></span></td>
						<td class=" fntSiz12px" width="20%"
							style="font-size: 11px; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							class="bold fntSiz12px"style="font-size:9px;padding-left:5px">MEASUREMENT</span><br> <br> <span
							class="fntSiz11px"></span></td>
					</tr>
					<c:forEach var="detailObj1" items="${ConList}">
						<tbody>


							<tr class="description">
								<td class="width_10 " style="font-size: 11px;" align="left"
									valign="top"><span style="padding-left:5px">${detailObj1.marksAndNos}</span></td>
								<td class="width_10 " style="font-size: 11px;" align="left"
									valign="top"><span style="padding-left:5px">${detailObj1.noofPackage}</span></td>
								<td class="width_10 " style="font-size: 11px;" align="left"
									valign="top"><span style="padding-left:5px">${detailObj1.cargoDescription}</span></td>
								<td class="width_10 " style="font-size: 11px;" align="left"
									valign="top"><span style="padding-left:5px">${detailObj1.grossWeight}</span></td>
								<td class="width_10 " style="font-size: 11px;" align="left"
									valign="top"><span style="padding-left:5px">${detailObj1.measureMent}</span></td>


							</tr>



						</tbody>
					</c:forEach>
				</table>
				<table style="width: 100%;height: 160px;">
					<tr>
						<td class="bold fntSiz11px" width="20.2%" 
							style="border-top: 1px solid white;"></td>
						<td class="bold fntSiz11px" width="10%" 
						style="border-top: 1px solid white;"
							></td>
						<td class="bold fntSiz11px" width="39.8%"
							style="border-top: 1px solid white;border-bottom: white;">
							<table style="width: 100%;">
									<tr>
									<th class="bold fntSiz10px" style="border:hidden;border-bottom:1px solid black">Container No
									</th>
									<th class="bold fntSiz10px" style="border:hidden;border-bottom:1px solid black"">CType
									</th>
									<th class="bold fntSiz10px" style="border:hidden;border-bottom:1px solid black"">Seal No
									</th>
									<th class="bold fntSiz10px" style="border:hidden;border-bottom:1px solid black"">PKG No
									</th>
									<th class="bold fntSiz10px" style="border:hidden;border-bottom:1px solid black"">Gross WT
									</th>
									<th class="bold fntSiz10px" style="border:hidden;border-bottom:1px solid black"">Net WT
									</th>
								
									</tr>
									<c:forEach var="detailObj2" items="${ConatinerList}">
						<tbody >
						<tr style="font-size:10px">
						
						<td class="width_10 " class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black"
									valign="top"><span style="padding-left:20px">${detailObj2.containerNo}</span></td>
									<td class="width_12 " class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black;font-size:8px"
									valign="top"><span style="padding-left:9px">${detailObj2.containersize}</span></td>
									<td class="width_10 " class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black;font-size:8px"
									valign="top"><span style="padding-left:17px">${detailObj2.sealNo}</span></td>
									<td class="width_8" class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black;font-size:8px"
									valign="top"><span style="padding-left:22px">${detailObj2.noofPackage}</span></td>
									<td class="width_10 " class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black;font-size:8px"
									valign="top"><span style="padding-left:24px">${detailObj2.grossWeight}</span></td>
									<td class="width_10 " class="fntSiz8px" align="left" style="border:hidden;border-top:1px solid black;font-size:8px"
									valign="top"><span style="padding-left:15px">${detailObj2.netWeight}</span></td>
									
						</tr>
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
					<td class="fntSiz11px"colspan="2"style="padding-left:5px">ABOVE PARTICULARS AS DECLARED BY SHIPPING</td>
					<td style="border-left:white;border-top: white;"></td> 
					<td style="border-left:white;border-top: white;"></td> 
					<td style="border-right:white;border-left:white;border-top: white;"></td>
					</tr>
				</table>
				<table style="width: 100%;">
					<tr>
						<td class="fntSiz12px" width="100%"
							style="border-top: 1px solid #fff; border-bottom: 1px solid #fff"><span
							class="fntSiz12px"style="padding-left:5px">Note : The Merchant's attetnion
								is called to the fact that according to Clauses 10, 11 and 12 of
								this Bill of Loading, the liability of the carrier is, in most
								cases, limited in respect of loss of damage to the goods and
								delay.</span><br> <br> <span class="fntSiz12px">
								<%-- ${bunkerRequestData.hawbiataCode} --%>
						</span></td>

					</tr>
					<tr>
						<td class="fntSiz12px" width="100%"
							style="border-top: 1px solid #fff"><span style="width: 40%;padding-left:5px"
							class="fntSiz12px" >DECLARED VALUE :</span><span
							style="width: 60%;" class="fntSiz12px"style="padding-left:5px">Refer to
								Clause 11(4) & (5) on reverse side</span> <%-- ${bunkerRequestData.hawbiataCode} --%>
						</td>

					</tr>

				</table>
				<table>
					<tr>
						<td width="50%">

							<table style="width: 100%;">
								<tr>

									<span class="fntSiz11px" style="padding-left:5px">FRIEGHT RATES, WEIGHTS AND / OR
										MEASUREMENTS SUBJECT TO CORRECTION</span>



								</tr>
								<tr>
									<td width="30%">
										<div>
											<span class="bold fntSiz13px"style="padding-left:5px">DETAILS</span>

										</div>
									</td>
									<td width="30%">
										<div>
											<span class="bold fntSiz13px"style="padding-left:5px">PREPAID</span>


										</div>
									</td>
									<td width="30%" >
										<div>
											<span class="bold fntSiz13px"style="padding-left:5px">COLLECT</span>


										</div>
									</td>
									<!-- <td width="10%">
										<div>
											<span class="bold fntSiz13px"></span>


										</div>
									</td> -->
								</tr>
								<c:forEach var="footerobj" items="${FooterList}">
								<tr> 
								
									<td width="30%" height=20 style="border-left:white;"><div><span class="bold fntSiz13px">${footerobj.chargeName}</span></div></td>
									<td width="30%"  height=20 style="border-left:white;"><div> <c:if test="${footerobj.paymentMode==1}"><span class="bold fntSiz13px" style="padding-left:30px">${footerobj.amt}</span></c:if></div></td>
									<td width="30%" height=20 style="border-left:white;border-right:white"><div><c:if test="${footerobj.paymentMode==2}"><span class="bold fntSiz13px" style="padding-left:30px">${footerobj.amt}</span></c:if></div></td>
									<!-- <td width="10%" height=20 style="border-left:white;border-right:white"><div><span ></span></div></td> -->
									
									</tr>
									</c:forEach>
									<c:forEach var="obj" items="${List}">
								<tr>
									<td width="30%" style="border-top: 1px solid #fff;">
										<div>
											<span class="bold fntSiz13px"style="padding-left:5px">TOTAL</span>

										</div>
									</td>
									<td width="30%">
										<div>
											<span class="bold fntSiz13px" style="padding-left:30px">${obj.paymentAmount}</span>


										</div>
									</td>
									<td width="30%" >
										<div>
											<span class="bold fntSiz13px" style="padding-left:30px">${obj.collectAmount}</span>


										</div>
									</td>
									<!-- <td width="10%">
										<div>
											<span class="bold fntSiz13px"></span>


										</div>
									</td> -->

								</tr>
								</c:forEach>
							</table>
							<table>
								<tr>

									<td class="fntSiz11px" style="padding-left:5px">. For freight prepaid Bill of
										Lading, delivery of Cargo is subject to realisation of
										freight, Demmurage / Detention charges of Port of destination
										Payable by consignee as per lines tariff.</td>
								</tr>
								<tr>
									<td class="fntSiz11px" style="padding-left:5px">. By accepting this Bill of Lading,
										the shipper accepts his reponsibility towards the carrier for
										payment of freight (in case of freight collect shipments)</td>
								</tr>
								<tr>
									<td class="fntSiz11px" style="padding-left:5px">. Accrued Ground rent, reshipment
										or disposal costs (as the case may be) if the consignee fails
										to take delivery of the cargo.</td>
								</tr>
								<tr>
									<td class="fntSiz11px" style="padding-left:5px">. In case of any discpreancy found
										in declared weight & volume the carrier reserves the right ot
										hold the shipment & recover all charges as per the revised
										weight & volume whichever is high from shipper or consingee.</td>
								</tr>



							</table>

						</td>
						<td width="50%">
							<div>
								<span class="fntSiz11px"style="padding-left:5px">Received by the carrier the
									foods as specified above in apparent good order and condition
									unless otherwise stated, to be transported to such place as
									agreed, authorised or permitted herein and subject to all the
									terms and conditions appearing on the front and reverse of this
									Bill of Lading to which the Merchant agrees by accepting the
									Bill of Lading, any local privileges and customs
									notwithstanding.</span> <br> <span class="fntSiz11px"style="padding-left:5px">The
									particulars given above as stated by the shipper and the
									weight, measure, quantity, condition, contens and value of the
									goods are unknown to the Carrier.</span> <br> <span
									class="fntSiz11px"style="padding-left:5px">In WITNESS whereof one (1) original
									Bill of Lading has been signed if not otherwise stated above,
									the same being accomplished of the other(s), if any, to be
									void, if required by the Carrier one (1) original Bill of
									Lading must be surrendered duly endorsed in exchange for the
									goods or delivery order</span>
							</div> <br> <span class="fntSiz11px"style="padding-left:5px">Place and date of
								issue <u style="font-size: 7px;"> ${hdr.signedAt}  &nbsp&nbsp&nbsp&nbsp&nbsp ${hdr.mblDate}  </u>
						</span> <br> <br> <br>
							<div>
								<span class="fntSiz8px"style="padding-left:5px">By &nbsp&nbsp&nbsp&nbsp&nbsp</span><span
									class="fntSiz11px"
									style="border-bottom: 1px; border-bottom-style: solid; width: 70%;font-size: 7px;padding-left:5px">
									${hdr.signedBy}</span> <br> <br> <br> <br>


							</div>


						</td>
					</tr>
				</table>
    

			</div>
		</div>
	</form>
</div>