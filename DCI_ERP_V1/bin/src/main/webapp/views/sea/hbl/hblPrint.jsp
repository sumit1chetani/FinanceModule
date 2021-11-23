<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />


<head>
<meta http-equiv="Content-Type"
	content="text/htmlby
; charset=ISO-8859-1">
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

.ttbody {
	height: 120px;
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

.reduceheight {
	height: 48px;
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
<br>
<br>
<br>
<div style="padding: 0%;">
	<form>
		<div style="margin-top: 0px">
			<div class="col-sm-12 wid100pr">
				<div>
					<div style="text-align: center;">

						<span class="bold fntSiz15px" align="center">BILL OF
							COASTAL GOODS</span>
					</div>
				</div>
				<table width="100%">
					<thead>
					</thead>
					<tbody>
						<tr>
						<tr>
							<td width="20%;">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">ORIGINAL
										PORT</span>

								</div>
							</td>
							<td width="30%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">${hdr.portofLoad}</span>


								</div>
							</td>

							<td width="50%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">AGENT
										: ${hdr.agent}</span>


								</div>
							</td>


						</tr>

						</tr>
						<tr>
						<tr style="height: 50px;">
							<td width="20%;">
								<div>
									<span class="fntSiz11px wid20pr" style="padding-left: 5px">SHIPPER'S
										NAME AND ADDRESS</span>

								</div>
							</td>
							<td colspan="2" width="80%">
								<div>
									<span class="fntSiz11px wid20pr" style="padding-left: 2px">${hdr.shipperName} <br> ${hdr.shipperAddress}</span>


								</div>
							</td>




						</tr>

						</tr>

						<tr>
						<tr style="height: 50px;">
							<td width="20%;">
								<div>
									<span class="fntSiz11px wid20pr" style="padding-left: 5px">CONSIGNEE'S
										NAME AND ADDRESS</span>

								</div>
							</td>
							<td colspan="2" width="80%">
								<div>
									<span class="fntSiz11px wid20pr" style="padding-left: 2px">${hdr.consigneeName} <br> ${hdr.consigneeAddress}</span>


								</div>
							</td>




						</tr>

						</tr>


					</tbody>

				</table>
				<table width="100%">
					<thead>
					</thead>
					<tbody>
						<tr>
						<tr>
							<td width="20%;" style="border-top: hidden">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">NAME
										OF THE VESSEL</span>

								</div>
							</td>
							<td width="20%" style="border-top: hidden">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">PORT
										OF LOADING</span>


								</div>
							</td>

							<!-- <td width="15%" style="border-top: hidden">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">MASTER
										OR AGENT</span>


								</div>
							</td> -->

							<td width="15%" style="border-top: hidden">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">COLOR</span>


								</div>
							</td>

							<td width="20%" style="border-top: hidden">
								<div>
									<span class="fntSiz11px" style="padding-left: 1px">PORT
										AT WHICH GOODS ARE DISCHARGED</span>


								</div>
							</td>

							<td width="5%" style="border-top: hidden">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">LINE
										:</span>


								</div>
							</td>

							<td width="5%" style="border-top: hidden">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px"></span>


								</div>
							</td>


						</tr>

						</tr>
						<tr>
						<tr>
							<td width="20%;">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">${hdr.vesselVoyeage}</span>

								</div>
							</td>
							<td width="20%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">${hdr.polCode}</span>


								</div>
							</td>

							<%-- <td width="15%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">${hdr.agent}</span>


								</div>
							</td> --%>

							<td width="15%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px"></span>


								</div>
							</td>

							<td colspan=3 width="20%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px">${hdr.podCode}</span>


								</div>
							</td>




						</tr>


						<tr>
							<td width="20%;">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px"></span>

								</div>
							</td>
							<td width="15%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px"></span>


								</div>
							</td>

							<td width="15%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px"></span>


								</div>
							</td>

							<td width="20%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px"></span>


								</div>
							</td>

							<td colspan=3 width="20%">
								<div>
									<span class="fntSiz11px" style="padding-left: 5px"></span>


								</div>
							</td>




						</tr>

						</tr>

					</tbody>

				</table>



				<table width="100%">
					<thead>
						<tr>
							<th class="bold fntSiz11px wid20pr"
								style="border-top: 1px solid #fff"><span>CONTAINER
									NO & SEAL</span><br>
							<br></th>
							<th class="bold fntSiz11px wid10pr"
								style="border-left: 1px solid #fff; border-top: 1px solid #fff"><span">QUANTITY
									& WEIGHT</span><br>
							<br></th>
							<th colspan=2 class="bold fntSiz11px wid40pr"
								style="border-left: 1px solid #fff; border-top: 1px solid #fff"><span">FOB
									VALUE</span><br>
							<br></th>
							<th class="bold fntSiz11px wid10pr"
								style="border-left: 1px solid #fff; border-top: 1px solid #fff"><span">DESCRIPTION
									OF GOODS</span><br>
							<br></th>
							<th class="bold fntSiz11px wid20pr"
								style="border-left: 1px solid #fff; border-top: 1px solid #fff"><span>REMARKS</span><br>
							<br></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="detailObj1" items="${detailList}">



							<tr class="description" style="font-size: 10px; height: 100">
								<td class="fntSiz10px" align="left"
									style="border-bottom: 1px solid white" valign="top"><span>${detailObj1.containerNo}/${detailObj1.sealNo}</span></td>
								<td class="fntSiz10px" align="left"
									style="border-bottom: 1px solid white" valign="top"><span
									style="padding-left: 5px">${detailObj1.grossWeight}</span></td>
								<td class="fntSiz10px" align="left"
									style="border-bottom: 1px solid white" valign="top"><span>AS
										PER INVOICE</span><br></td>
								<td class="fntSiz10px" align="left"
									style="border-bottom: 1px solid white" valign="top"><span>TOTAL
										AMOUNT</span><br></td>

								<td class="fntSiz10px" align="left"
									style="border-bottom: 1px solid white" valign="top"><span
									style="padding-left: 5px">${detailObj1.cargoDescription}</span></td>
								<td class="fntSiz10px" align="left"
									style="border-bottom: 1px solid white" valign="top"><span
									style="padding-left: 5px">${detailObj1.remarks}</span></td>


							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table style="width: 100%; height: 160px;">
					<tr>
						<td class="bold fntSiz11px wid20pr"
							style="border-top: 1px solid white;"></td>
						<td class="bold fntSiz11px wid10pr" style=""></td>
						<td class="bold fntSiz11px wid20pr" style="border-bottom: white;">
						</td>
						<td class="bold fntSiz11px wid20pr" style="border-bottom: white;">
						</td>
						<td class="bold fntSiz11px wid10pr"
							style="border-top: 1px solid white; border-bottom: white;"></td>
						<td class="bold fntSiz11px wid20pr"
							style="border-top: 1px solid white; border-bottom: white;"
							style="border: none;"></td>
					</tr>
					<tr>
						<td class="fntSiz11px wid20pr"
							style="padding-left: 5px; height: 10%;">TOTAL</td>
						<td class="wid10pr" style="padding-left: 5px; height: 10%;"></td>
						<td class="wid10pr" style="border-left: white; border-top: white;"></td>
						<td class="wid10pr" style="border-left: white; border-top: white;"></td>
						<td class="wid10pr" style="border-left: white; border-top: white;"></td>
						<td class="wid10pr" style="border-left: white; border-top: white;"></td>

					</tr>
				</table>

				<table style="width: 100%;">
					<tr>
						<td width="100%"
							style="border-top: 1px solid #fff; border-bottom: 1px solid #fff; font-size: 10px"><span
							class="fntSiz8px" style="padding-left: 5px"> TOTAL NO OF
								PACKAGES(IN WORDS) </span> <span class="fntSiz11px"> <%-- ${bunkerRequestData.hawbiataCode} --%>
						</span></td>

					</tr>


				</table>
				<table style="width: 100%; height: 170px;">
					<tr>
						<td width="50%" valign="top">
							<div>
								<span class="fntSiz11px text-center" style="padding-left: 125px">FOR
									CUSTOMS USE ONLY</span>
							</div> <br>
						<br>
						<span class="fntSiz11px text-center" style="padding-left: 5px">CUSTOMS
								HOUSE SEAL</span> <br>
						<br>
						<span class="fntSiz11px text-center" style="padding-left: 5px">BCG
								NO & DATE:</span>&nbsp&nbsp&nbsp&nbsp<span class="fntSiz11px text-center" style="padding-left: 5px">${hdr.hblDocNo}  -  ${hdr.hblDocDate}</span><br>
						<br>
						<BR>
						
						<div>
						<span class="fntSiz14px text-center" style="padding-left: 5px"><b>${hdr.hblCode}</b></span>
						
						
						
						<span class="fntSiz11px text-center" style="padding-left: 95px">PO
								(DP)
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								SUPT (DP)</span>
							</div>




						</td>
						<td width="50%">
							<div>
								<p class="fntSiz8px" style="padding-left: 5px">1. We declare
									that : -1.the value.sort,specification,quality,composition and
									description the goods mentioned in this bill of started to the
									best of my/ our knowledge and belief.I / We certify that they
									are in accordance and with the terms of the contr</p>

								<p class="fntSiz8px" style="padding-left: 5px">2. The
									particulars given above are true.</p>
								<p class="fntSiz8px" style="padding-left: 5px">
									3. Quality, quantity and value as decleared by<BR> the
										shipper in the supporting invoice
								</p>

							</div>

							<DIV>
								<span class="fntSiz11px" style="padding-left: 230px">FOR
									MBK LOGISTIX PVT LTD </span>
							</DIV> <br>
						<br>
						<span class="fntSiz11px" style="padding-left: 5px">PLACE :
								${hdr.polCode} </span> <br>
						<span class="fntSiz11px" style="padding-left: 5px">DATE &nbsp&nbsp:
								${hdr.hblDate} </span> <span class="fntSiz11px"
							style="padding-left: 165px">AUTHORISED SIGNATORY </span>

						</td>
					</tr>
				</table>


			</div>
		</div>
	</form>
</div>