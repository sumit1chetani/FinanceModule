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
.watermark {
    opacity: 0.6;
    top: auto;
    left: 45%;
   text-shadow: -1px -1px 0 #025013,  
    1px -1px 0 #025013,
    -1px 1px 0 #025013,
     1px 1px 0 #025013;
     -webkit-transform: rotate(-20deg);
     position: absolute;
    bottom: 35%;
}
.bold {
	font-weight: bold;
}

table, th, td {
    line-height: 21px;
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
<div style="padding: 1%;">
	<form>
		<div>
			<div class="col-sm-12 wid100pr">
				
				<table width="100%">
					<thead>
					</thead>
					<tbody>
						<tr>
							<td class="wid50pr"><span class="bold fntSiz11px" style="padding-left:5px;">
									Shipper (Name & Address). </span>
							<!-- 	<div class="" style="padding-left:5px;height: 97px;"> -->
								<p class="fntSiz10px" style="padding-left:5px;height: 40px;">${hdr.shipper}</p>
									<%-- <span class="fntSiz10px">${hdr.shipperName}</span> <br />
									<div class="fntSiz10px wid80pr">${hdr.shipperAddress1}
										<span>
										${hdr.shipperAddress2}
										</span> <br>
										<span> ${hdr.shipperAddress3}
										</span>
										
										<br></div> --%>
								<!-- </div> -->

								
								<!-- </div> <br /> --></td>
							<td class="wid50pr">
								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz11px" width="60%"
											style=" border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz10px" style="padding-left:5px"">Country of Origin</span><br>
											<br> <span style="padding-left:5px">${hdr.blNo}
										</span></td>
										<td class="bold fntSiz11px" width="40%"
											style="padding-left:5px; border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											">Bill of Lading No</span><br> <br>
											<span class="fntSiz10px" style="padding-left:5px">${hdr.blNo}</span></td>
									</tr>
									<tr>
										<td class="bold fntSiz11px" width="60%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz10px" style="padding-left:5px"">F/Agent Name & Ref.</span><br>
											<br> <span style="padding-left:5px">${hdr.agent},${hdr.agent}
										</span></td>
										<td class="bold fntSiz11px" width="40%"
											style="border-bottom: 1px solid #fff;padding-left:5px; border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											">Shipper's Ref</span><br> <br>
											<span class="fntSiz10px" style="padding-left:5px">${hdr.ref}</span></td>
									</tr>
								</table> 
							</td>

						</tr>
						
						<tr>
						<td class="wid50pr">
								<table style="width: 100%;height: 160px;">
									<tr>
										<td class="bold fntSiz11px"
											style=" border-left: 1px solid #fff;border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz10px" style="padding-left:5px"">Consignee (if 'To Order' so indicate)</span><br>
											<br> <span style="padding-left:5px">${hdr.cnee}
										</span></td>
									</tr>
									<tr>
										<td class="bold fntSiz11px"
											style="border-bottom: 1px solid #fff;border-right: 1px solid #fff;  border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz10px" style="padding-left:5px"">Notify Party ( No claim shall attach for failure to notify )</span><br>
											<br> <span style="padding-left:5px">${hdr.notify1}
										</span></td>
									</tr>
									<tr>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz11px reduceheight" width="60%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff;"><span
											class="fntSiz10px" style="padding-left:5px"">Place of Receipt</span><br>
											<br> <span style="padding-left:5px">${hdr.receiptAt}
										</span></td>
										<td class="bold fntSiz11px" width="40%"
											style="border-bottom: 1px solid #fff;padding-left:5px; border-right: 1px solid #fff;"><span
											">Port of Loading</span><br> <br>
											<span class="fntSiz10px" style="padding-left:5px">${hdr.pol}</span></td>
									</tr>
								</table>
							</td>
						</tr>
								</table> 
							</td>
							<td class="wid50pr">
								<table style="width: 100%;">
									<div class="watermark" style="color:white;" align="center">
									<p style="font-size: 20px;">COPY</p>
									<p style="font-size: 15px;">NON-NEGOTIABLE</p>
									</div>
								</table> 
							</td>
						</tr>

						<tr>
							<td class="wid50pr">

								<table style="width: 100%;">
									<tr>
										<td class="bold fntSiz11px reduceheight" width="60%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz10px" style="padding-left:5px"">Vessel</span><br>
											<br> <span style="padding-left:5px">${hdr.blNo}
										</span></td>
										<td class="bold fntSiz11px reduceheight" width="40%"
											style="border-bottom: 1px solid #fff;padding-left:5px; border-right: 1px solid #fff; border-top: 1px solid #fff"><span
											">Port of Discharge</span><br> <br>
											<span class="fntSiz10px" style="padding-left:5px">${hdr.pod}</span></td>
									</tr>
								</table>
							</td>
							<td class="wid50pr">
							<table style="width: 100%;">
									<tr>
									<td class="bold fntSiz11px reduceheight" width="60%"
											style="border-bottom: 1px solid #fff; border-left: 1px solid #fff; border-top: 1px solid #fff"><span
											class="fntSiz10px" style="padding-left:5px"">Place of Delivery</span><br>
											<br> <span style="padding-left:5px">${hdr.fpod}
										</span></td>
										<td class="bold fntSiz11px reduceheight" width="40%"
											style="border-bottom: 1px solid #fff;padding-left:5px; border-right: 1px solid #fff; border-top: 1px solid #fff"><span">No. of Original Bills of Lading</span><br>
											<br> <span style="padding-left:5px">${hdr.noBls}
										</span></td>
								</tr>
								</table>
							</td>
						</tr>
						
				</table>
				<div>
				<table style="width: 100%;">
				<thead>
					<tr>
						<th class="bold fntSiz11px" 
							style="border-top: 1px solid #fff; width: 20%; text-align: center;"><span>Marks & Numbers.</span><br> <br>
							</th>
						<th class="bold fntSiz11px wid10pr" 
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff; text-align: center;"><span
							">No. of Pkgs or Shipping Units.</span><br>
							<br> </th>
						<th class="bold fntSiz11px wid50pr" 
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff; text-align: center;"><span
							">Description of Goods & Pkgs.</span><br>
							<br> </th>
						<th class="bold fntSiz11px wid10pr" 
							style=" border-left: 1px solid #fff; border-top: 1px solid #fff; text-align: center;"><span
							">Gross Weight</span><br> <br> </th>
						<th class="bold fntSiz11px wid20pr" 
							style="border-left: 1px solid #fff; border-top: 1px solid #fff; text-align: center;"><span
							>Measurement</span><br> <br> </th>
							
					</tr>
					</thead>
					<tbody >
					<c:forEach var="detailObj1" items="${hdr.marks}">
						<tr class="description" style="font-size:10px;height:100%">
								<td  class="fntSiz10px" align="left" 
								style=" border-bottom: 1px solid white"
									valign="top"><span >${hdr.pkgs}</span></td>
								<td class="fntSiz10px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${hdr.goods}</span></td>
								<td  class="fntSiz10px wid50pr" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span >${hdr.g_wgt}</span>
									<br>
									</td>
								<td  class="fntSiz10px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${hdr.g_wgt}</span></td>
								<td class="fntSiz10px" align="left"
								style=" border-bottom: 1px solid white"
									valign="top"><span style="padding-left:5px">${hdr.blNo}</span></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<table style="width: 100%;height: 160px;">
					<tr>
						<td class="bold fntSiz11px "  style="border-top: 1px solid white;border-bottom: 1px solid white; width: 20%;"></td>
						<td class="bold fntSiz11px wid10pr" style="border-top: 1px solid white;border-bottom: 1px solid white;">
						<table style="width: 100%;height: 25px;margin-top: 124px;">
					<tr>
											<td class="bold fntSiz11px wid50pr" style="border-left: 1px solid white;border-right: 1px solid white;border-bottom: 1px solid white;">
											<span">Total</span>
											</td>
					
					</tr>
				</table>
						</td>
						<td class="bold fntSiz11px wid50pr" style="border-top: 1px solid white;border-bottom: 1px solid white;">
						<table style="width: 100%;height: 25px;margin-top: 124px;">
					<tr>
											<td class="bold fntSiz11px wid50pr" style="border-left: 1px solid white;border-right: 1px solid white;border-bottom: 1px solid white;">
											<span">Temperature Control Instructions:</span>
											</td>
					
					</tr>
				</table>
				</td>
						<td class="bold fntSiz11px wid10pr" style="border-top: 1px solid white;border-bottom: 1px solid white;"></td>
						<td class="bold fntSiz11px wid10pr" style="border-top: 1px solid white;border-bottom: 1px solid white;"></td>
					</tr>
				</table>
				</div>
				<table style="width: 100%;height: 160px;">
				<tr>
							<td class="wid50pr"><span class="bold fntSiz11px" style="padding-left:5px;padding-left:5px">
									Freight Details Charges etc.:</span>
							<!-- 	<div class="" style="padding-left:5px;height: 97px;"> -->
								<p class="fntSiz10px" style="padding-left:5px;height: 40px;">${hdr.blNo}</p>
									<%-- <span class="fntSiz10px">${hdr.shipperName}</span> <br />
									<div class="fntSiz10px wid80pr">${hdr.shipperAddress1}
										<span>
										${hdr.shipperAddress2}
										</span> <br>
										<span> ${hdr.shipperAddress3}
										</span>
										
										<br></div> --%>
								<!-- </div> -->

								
								<!-- </div> <br /> --></td>
							<td class="wid50pr"><span class="bold fntSiz11px" style="padding-left:5px;padding-left:5px">
									Excess Value Declaration: Refer to Clause 6 (3) (B) + (C) on Page 1</span>
							<!-- 	<div class="" style="padding-left:5px;height: 97px;"> -->
								<p class="fntSiz10px" style="padding-left:5px;height: 40px;">${hdr.blNo}</p>
									<%-- <span class="fntSiz10px">${hdr.shipperName}</span> <br />
									<div class="fntSiz10px wid80pr">${hdr.shipperAddress1}
										<span>
										${hdr.shipperAddress2}
										</span> <br>
										<span> ${hdr.shipperAddress3}
										</span>
										
										<br></div> --%>
								<!-- </div> -->

								
								<!-- </div> <br /> -->
							</td>

						</tr>
						<tr>
							<td class="wid50pr"><span class="bold fntSiz11px" style="padding-left:5px;padding-left:5px">
									Discharge Port Agents: </span>
							<!-- 	<div class="" style="padding-left:5px;height: 97px;"> -->
								<p class="fntSiz10px" style="padding-left:5px;height: 40px;">${hdr.blNo}</p>
									<%-- <span class="fntSiz10px">${hdr.shipperName}</span> <br />
									<div class="fntSiz10px wid80pr">${hdr.shipperAddress1}
										<span>
										${hdr.shipperAddress2}
										</span> <br>
										<span> ${hdr.shipperAddress3}
										</span>
										
										<br></div> --%>
								<!-- </div> -->

								
								<!-- </div> <br /> --></td>
							<td class="wid50pr" style="line-height:13px">
							<div>
								<p class="fntSiz8px" style="padding-left:8px">
RECEIVED by the Carrier the Gods as specified above in apparent good order and condition, unless otherwise stated, to be transported to such 
									place as agreed, authorised or permitted herein and subject to all the terms and conditions appearing on the front and reverse of this bill of Lading to which the Merchant agrees by accepting this Bill
									of Lading, any local privileges and customs notwithstanding. The particular given above are as stated by the shipper and the weight, measure, quantity, condition, contents and value of the goods are unknown 
									to the carrier. In WITNESS whereof one (1) original Bill of Lading has been signed if not otherwise stated above, the same being accomplished the other(s), if any, to be void. One (1) original Bill of Lading 
									must be surrendered duly endorsed in exchange for the Goods or delivery order.</p> 
									</div>
								
							</td>

						</tr>
					<tr>
						<td width="50%" valign="top">
					<div>
								<p class="fntSiz8px" style="padding-left:5px; color:#006600;">
								JURISDICTION AND LAW CLAUSE <br>
								Whenever US COGSA applies, whether by virtue of Carriage of the Goods to or from the United States of America or otherwise, or losses occur during in land carriage within 
								the United States of America, this bill of lading is to be governed by United States law and United States Federal Court of the Southern District of New York is to have exclusive Jurisdictions here are disputes 
								hereunder in all other cases, the bill of lading shall be govern by at constructed in accordance English law and all disputes arising hereunder shall be determined by the English High Court of Justice in London 
								to the exclusion of courts of any other country.</p> 
									</div>

						</td>
						<td width="50%">
							 <span class="fntSiz11px" style="padding-left:5px">Place and date of issue <u>  ${hdr.issueDate}  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</u>
						</span> <br>
<span class="fntSiz11px" style="padding-left:5px">EMIRATES SHIPPING COMPANY LIMITED</span>
</span> <br>
<span class="fntSiz11px" style="padding-left:5px">As Carrier</span>  
						</td>
					</tr>
				</table>


			</div>
		</div>
	</form>
</div>