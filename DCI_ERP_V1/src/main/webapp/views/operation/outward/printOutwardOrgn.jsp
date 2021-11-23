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
<br>
<br>
<br>
<div style="padding: 0%;">
	<form>
		<div style="margin-top:-52px">
			<div class="col-sm-12 wid100pr">
				<table width="100%">
					<thead>
					</thead>
					<tbody style="line-height: 6px;">
						<tr>
							<td class="wid50pr"><span class="bold fntSiz13px" style="padding-left:5px;padding-left:5px">
									Shipper</span>
							<!-- 	<div class="" style="padding-left:5px;height: 97px;"> -->
								<p class="fntSiz12px" style="padding-left:5px;height: 94px;font-weight: normal;">${hdr.shipper}</p>
									<%-- <span class="fntSiz10px">${hdr.shipperName}</span> <br />
									<div class="fntSiz10px wid80pr">${hdr.shipperAddress1}
										<span>
										${hdr.shipperAddress2}
										</span> <br>
										<span> ${hdr.shipperAddress3}
										</span>
										
										<br></div> --%>
								<!-- </div> -->

								<hr class="hrLine"><br> <span class="bold fntSiz13px" style="padding-left:5px">
									Consignee</span> 
								<div class="" style="padding-left:5px">
									
									<!-- <div class="fntSiz10px wid80pr"> -->
										<p class="fntSiz12px" style="padding-left:5px;height: 86px;font-weight: normal;">${hdr.cnee}</p> 
										<%-- <span> ${hdr.consAddress1} </span> <br>
										<span>${hdr.consAddress2} </span> <br>
										<span> ${hdr.consAddress3} </span> --%>
									</div>
									
								<!-- </div> <br /> --></td>
							<td class="wid50pr">
<div align="center" style="font-size:11px">
							<!-- 	<img src="/img/Cordelia_resize_logo.jpg" style="float: left !important;
     float: left !important;
    padding: 0 20px 20px 0 !important;
    height: 12%!important;
    width: 16%!imporant;
    margin-left: 452px!important;
    position: absolute!important;
    bottom: 83%!important;
    left: 3.5%!important;"> --><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
									
									
									<%-- /span> <br> <span style="text-align: right;">
										${hdr.address1}</span> <br> <span style="text-align: right;">${hdr.address2}
									</span> <br> <span style="text-align: right;">${hdr.address3}</span>
									<br><span ><center><c:if test="${hdr.gstnNo != ''}">GSTNO:${hdr.gstnNo}</c:if></span> --%></center>
								</div>
								<table style="width: 100%;">
									<tbody style="">
										<tr>
											<td class="bold" width="50%"
												style="border-bottom: 1px solid #fff; border-right: 1px solid #fff;border-left: 1px solid #fff; font-size: 12px;"><p style="font-size: 10px!important" align="center">
												BILL OF LADING FOR OCEAN TRANSPORT OF MULTIMODAL TRANSPORT
												</p>
											</td>
										</tr>
									</tbody>
								</table> 
								
								<table style="width: 100%;">
									<tbody style="">
										<tr>
											<td class="bold fntSiz13px" width="50%"
												style="border-left: 1px solid #fff; border-bottom: 1px solid #fff;border-right: 1px solid #fff;"><p style="padding-left:5px">
													B/L No. 
													<span style=" margin-left: 19px; ">   ${hdr.blNo} </span></p></td>
											
										</tr>
									</tbody>
								</table> 
							</td>

						</tr>
						<tr>
						<td class="wid50pr" style="line-height:7px">
								<span class="bold fntSiz13px" style="padding-left:5px;padding-left:5px">
									Notify</span>
							<!-- 	<div class="" style="padding-left:5px;height: 97px;"> -->
								<p class="fntSiz12px" style="padding-left:5px;height: 94px;">${hdr.notify1}</p>
									<%-- <span class="fntSiz10px">${hdr.shipperName}</span> <br />
									<div class="fntSiz10px wid80pr">${hdr.shipperAddress1}
										<span>
										${hdr.shipperAddress2}
										</span> <br>
										<span> ${hdr.shipperAddress3}
										</span>
										
										<br></div> --%>
								<!-- </div> -->
							</td>
							<td >
								<div  style="margin-top: 7px;border-bottom: 1px solid #000!important;">
									<span class="bold fntSiz13px" style="padding-left:5px">
										Freight terms</span> <br />
									<div class="">
										
										<div class="fntSiz12px wid80pr">
											<p style="padding-left:5px">${hdr.terms}</p> 
										
										</div>
									</div>
									<br />
								</div>
								<div  style="margin-top: 7px;border-bottom: 1px solid #000!important;">
									<span class="bold fntSiz13px" style="padding-left:5px">
										Bill to</span> <br />
									<div class="">
										
										<div class="fntSiz12px wid80pr">
											<p style="padding-left:5px">${hdr.customerName}</p> 
										
										</div>
									</div>
									<br />
								</div>
								 
								<div style="margin-top: 7px;">
									<span class="bold fntSiz13px" style="padding-left:5px">
										Shipper Reference</span> <br />
									<div class="">
										
										<div class="fntSiz12px wid80pr">
											<p style="padding-left:5px">${hdr.ref}</p> 
										
										</div>
									</div>
									<br />
								</div>
							</td>
						</tr>

						<tr>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz13px" style="padding-left:5px"">Vessel</span><br>
											<br> <span class="fntSiz12px" style="padding-left:5px;font-weight: normal;">${hdr.vessel}
										</span></td>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff;padding-left:5px; border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											">Voyage</span><br> <br>
											<span class="fntSiz12px" style="padding-left:5px;font-weight: normal;">${hdr.vslVoyage}</span></td>
									</tr>
								</table>
							</td>
							<td class="wid50pr">
								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz13px" style="padding-left:5px"">Pre carriage by</span><br>
											<br> <span class="fntSiz12px" style="padding-left:5px;font-weight: normal;"> 
										</span></td>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff;padding-left:5px; border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											">Place of receipt</span><br> <br>
											<span class="fntSiz12px" style="padding-left:5px;font-weight: normal;">${hdr.receiptAt}</span></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">Port of Loading</span> <br>
											<br> <span class="fntSiz12px" style="padding-left:5px;font-weight: normal;">
												${hdr.pol} </span></td>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff;  border-right: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">Port of Discharge</span> <br> <br>
											<span class="fntSiz12px" style="padding-left:5px;font-weight: normal;">${hdr.pod}</span></td>
									</tr>
								</table>
							</td>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px">Final Designation</span><br> <br>
											<span class="fntSiz12px" style="padding-left:5px;font-weight: normal;"> ${hdr.fpod} </span></td>
										<td class="bold fntSiz13px" width="50%"
											style="border-bottom: 1px solid #fff;  border-right: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px">No. of Original Bills of Lading</span><br>
											<br> <span class="fntSiz12px"style="padding-left:5px;font-weight: normal;">${hdr.noBls}</span></td>
									</tr>
								</table>
							</td>
						</tr>
				</table>
				<div>
				<table style="width:100%;">
				<thead>
					<tr>
						<th class="bold fntSiz13px wid20pr" 
							style="border-top: 1px solid #fff"><span>Marks & Numbers</span><br> <br>
							</th>
						<th class="bold fntSiz13px wid10pr" 
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							">Number & Kind of Packages</span><br>
							<br> </th>
						<th class="bold fntSiz13px wid40pr" 
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							">Description of Goods</span><br>
							<br> </th>
						<th class="bold fntSiz13px wid10pr" 
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							">Gross Weight</span><br> <br> </th>
						<th class="bold fntSiz13px wid20pr" 
							style="border-left: 1px solid #fff; border-top: 1px solid #fff"><span
							>Measurement</span><br> <br> </th>
							
					</tr>
					</thead>
					<tbody >
						<c:forEach var="detailObj1" items="${ConList}">
					<tr class="description" style="font-size:10px;height:265px">
								<td  class="fntSiz12px" align="left" 
								style=" border-bottom: 1px solid white"
									valign="top"><span >${detailObj1.marks}</span></td>
								<td class="fntSiz12px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${detailObj1.pkgs}</span></td>
								<td  class="fntSiz12px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span >${detailObj1.goods}</span><br>
									</td>
									
									
								<td  class="fntSiz12px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${detailObj1.g_wgt}</span></td>
								<td class="fntSiz12px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${detailObj1.cbm}</span></td>
								

							</tr>
							</c:forEach>
					</tbody>
				</table>
				<table style="width: 100%;height: 0px;">
					<tr>
						<td class="bold fntSiz10px wid20pr"  
							style="border-top: 1px solid white;"></td>
						<td class="bold fntSiz10px wid10pr" 
						style="border-top: 1px solid white;"
							></td>
						<td class="bold fntSiz10px wid40pr" 
							style="border-top: 1px solid white;border-bottom: white;">
							<div class="watermark" style="color:white;" align="center">
									<p style="font-size: 24px;">ORIGINAL</p>
								 	<p style="font-size: 25px;">NON-NEGOTIABLE</p>
									</div>
							</td>
						<td class="bold fntSiz10px wid10pr" 
						style="border-top: 1px solid white;border-bottom: white;"
							></td>
						<td class="bold fntSiz10px wid20pr" 
						style="border-top: 1px solid white;border-bottom: white;"
							style="border: none;"></td>
					</tr>
					<tr>
					<td class="fntSiz13px wid30pr"colspan="5" style="padding-left:5px;height:10%;    border-bottom: 1px solid black !important;">Above Particulars as declared by shipper, but without responsibility of or representation by carrier.<font style="color:red;">(See clause)</font></td>
					</tr>
				</table>
				</div>
				<table style="width: 100%;">
					<tr>
						<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz13px" width="35%"
											style="border-bottom: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">Frieght & Charges</span> <br>
											<br> <span class="fntSiz12px" style="padding-left:5px;font-weight: normal;">
												${hdr.freight_charges} </span></td>
										<td class="bold fntSiz13px" width="17.5%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">Rate</span> <br>
											<br> <span class="fntSiz12px" style="padding-left:5px;font-weight: normal;">
												${hdr.rate} </span></td>
										<td class="bold fntSiz13px" width="17.5%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">Unit</span> <br>
											<br> <span class="fntSiz12px" style="padding-left:5px;font-weight: normal;"">
												${hdr.unit} </span></td>
										<td class="bold fntSiz13px" width="10%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">Currency</span> <br>
											<br> <span class="fntSiz12px" style="padding-left:5px;font-weight: normal;"">
												${hdr.currency} </span></td>
										<td class="bold fntSiz13px" width="10%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">Prepaid</span> <br>
											<br> <span class="fntSiz12px" style="padding-left:5px;font-weight: normal;"">
												${hdr.prepaid} </span></td>								
										<td class="bold fntSiz13px" width="10%"
											style="border-bottom: 1px solid #fff; border-top: 1px solid #fff"><span style="padding-left:5px"
											">Collect</span> <br> <br>
											<span class="fntSiz12px" style="padding-left:5px;font-weight: normal;"'">${hdr.collect}</span></td>
									</tr>
								</table>

					</tr>

				</table>
				<table>
					<tr>
						<td width="70%" valign="top">

						<!-- <table style="width: 100%">
								<tr>

									<span class="fntSiz11px">FRIEGHT RATES, WEIGHTS AND / OR
										MEASUREMENTS SUBJECT TO CORRECTION</span>
</tr>


								</table>
								 -->
								
							<table style="width:100%;">
								<tr>
									<td class="wid50pr" style="line-height:11px;border-bottom: 1px solid white;border-top: 1px solid white;border-left: 1px solid white;">
								<span class="bold fntSiz13px" style="padding-left:5px;padding-left:5px;font-weight: normal;">
									Carriers receipt <font style="color:red;">(See clause 1 and 14)</font>. Total number of containers and packages received by Carrier.</span>
							<!-- 	<div class="" style="padding-left:5px;height: 97px;"> -->
								<p class="fntSiz12px" style="padding-left:5px;height: 94px;"></p>
									<%-- <span class="fntSiz10px">${hdr.shipperName}</span> <br />
									<div class="fntSiz10px wid80pr">${hdr.shipperAddress1}
										<span>
										${hdr.shipperAddress2}
										</span> <br>
										<span> ${hdr.shipperAddress3}
										</span>
										
										<br></div> --%>
								<!-- </div> -->
							</td>
							<td style="line-height:5px;border-bottom: 1px solid white;border-top: 1px solid white;border-right: 1px solid white;">
								<div  style=" border-bottom: 1px solid #000!important;">
									<span class="bold fntSiz13px" style="padding-left:5px">
										Place of issue of B/L</span> <br />
									<div class="">
										
										<div class="fntSiz12px wid80pr">
											<p style="padding-left:5px">${hdr.issuePlace}</p> 
										
										</div>
									</div>
									<br />
								</div>
								<div style="margin-top: 7px; border-bottom: 1px solid #000!important;">
									<span class="bold fntSiz13px" style="padding-left:5px">
										Date of issue of B/L</span> <br />
									<div class="">
										
										<div class="fntSiz12px wid80pr">
											<p style="padding-left:5px">${hdr.issueDate}</p> 
										
										</div>
									</div>
									<br />
								</div>
								<div style="margin-top: 7px;">
									<span class="bold fntSiz13px" style="padding-left:5px">
										Shipped on Board Date</span> <br />
									<div class="">
										
										<div class="fntSiz12px wid80pr">
											<p style="padding-left:5px">${hdr.onBoard}</p> 
										
										</div>
									</div>
									<br />
								</div>
							</td>
										
								</tr>



							</table>

						</td>
						<td width="40%" style="border-bottom: 1px solid #fff;">
							<div>
								<p class="fntSiz8px" style="padding-left:5px">RECEIVED by the carrier the Goods as specified above in apparent good order and condition, unless otherwise stated, to be transported to such place as agreed, authorised or permitted herein and subject to all the terms and conditions appearing on the front and reverse of this Bill of Lading to which the Merchant agrees by accepting the Bill of Lading, any local privileges and customs notwithstanding.</p> 
									 <p class="fntSiz8px" style="padding-left:5px">The particulars given above as stated by the shipper and the weight, measure, quantity, condition, contents and value of the goods are unknown to the carrier.</p> 
									 <p
									class="fntSiz8px" style="padding-left:5px">In WITNESS whereof one (1) original Bill of Lading has been signed if not otherwise stated above, the same being accomplished, the other(s), if any, to be void, One (1) original Bill of Lading must be surrendered duly endorsed in exchange for the goods or delivery order</p>
							</div> 
							

						</td>
					</tr>
					<tr>

								<table style="width: 100%;height: 58px;">
									<tr>
										<td class="fntSiz8px" width="100%">
										<p class="fntSiz13px" style="margin-right: 1%;margin-bottom: 2%;font-size: 12.5px;" align="right">Signed for the Carrier MBK CONTAINER SHIPPING LLC</p>
										<p class="" style="font-size: 10px;margin-right: 0%;margin-bottom: 0%;" align="right">As Agents <span style="font-size: 5px;margin-right: 3%;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspB/L Seqt - ${hdr.blId}</span></p> 
										</td>
									</tr>
								</table>
							
						</tr>
				</table>
			</div>
		</div>
	</form>
</div>