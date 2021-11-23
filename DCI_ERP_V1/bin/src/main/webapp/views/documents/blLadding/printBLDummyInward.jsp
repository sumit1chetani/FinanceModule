<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />


<head>
<meta http-equiv="Content-Type"
	content="text/htmlby
; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Ubuntu" />
<style>
.t-table {
	display: table;
	height: 330px;
	table-layout: fixed;
	width: 400px;
}
.vertical-line {
        width: 0;
        border: 1px solid green;
        height: 400px
    }
.td {
	height: 8px !important;
	font-family: Ubuntu !important;
}
div{

font-family: Ubuntu !important;
}


.watermark {
	opacity: 0.05;
	top: auto;
	left: 20%;
	text-shadow: -1px -1px 0 #025013, 1px -1px 0 #025013, -1px 1px 0 #025013,
		1px 1px 0 #025013;
	-webkit-transform: rotate(-20deg);
	position: absolute;
	bottom: 30%;
}

.bold {
	font-weight: bold;
}

table, td, th {
  border: 0;
}
#collapseTable {
  border-collapse: collapse;
}

table, th, td {
	border: 1px solid #333;
	border-collapse: collapse !important;
	
}
table, th, td {
       border: 1px solid black;
      }
      tr.hide_right > td, td.hide_right{
        border-right-style:hidden;
      }
      tr.hide_all > td, td.hide_all{
        border-style:hidden;
      }
  }
  
  
  
  
  
  .bor {
       border: px solid black;
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

.wid15pr {
	width: 15%;
}
.wid18pr {
    width: 18%;
}

.wid05pr {
	width: 5%;
}

.wid100pr {
	width: 100%;
}

.wid95pr {
	width: 95%;
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

.fntSiz12px {
	font-size: 10px;
}

.fntSiz10px {
font-size: 9px;
}

.fntSiz11px {
	font-size: 8px;
}

.wid77pr {
	width: 11% !important;
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
    margin: -2px;
    border-top: 0px solid #fff;
    height: 0px !important;
    border-left: 0px solid #fff;
    border-right: 0px solid #fff;
}

.hrLine1{
border-bottom: 1px solid #000;
    margin: -1px;
    border-top: 0px solid #fff;
    height: 0px !important;
    border-left: 0px solid #fff;
    border-right: 0px solid #fff;


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
.borde{
  border-left: none;
    border-right: none;
  
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

.rowitr {
	height: 15px !important;
}

@media print {
	html, body {
		height: 100%;
		width: 99%;
	}
	@page {
		size: A4;
		max-height: 100%;
		max-width: 100%
	}
	.footer, #non-printable {
		display: none !important;
	}
	#printable {
		display: block;
	}
}
.fontsizeForNum{
font-size:8px !important;
font-weight: 100 !important;
}

.table-body-cell{
display: table-cell;
width: 50%;
}

.resp-table-row{
display: table-row;
}
.hrLine2{

        height: 37px;
    margin: -1px;
    border-bottom: 0px solid #fff;
    border-top: 0px solid #fff;
    border-left: 0px solid #fff;
    border-right: 1px solid #333;
}
.hrLine3 {
	margin: -1px;
    border-bottom: 0px solid #fff;
    border-top: 0px solid #fff;
    border-left: 0px solid #fff;
    border-right: 0px solid #333;
}   
    
.column1 {
  float: left;
  /* width: 33.33%; */
  width:30%;
  padding: 10px;
  /* Should be removed. Only for demonstration */
}
p.none {border-style: none;}

/* Clear floats after the columns */
.row1:after {
  content: "";
  display: table;
  clear: both;
}
.non {
  border: none;
}
.bottom {
    position: absolute;
    bottom: 0;
    width: 100%;
    text-align: center;
      }
      
    .noborderTable td{
border:none;
}  
        .main {
           float: left;
    height: 100%;
    width: 100%;
    position: relative;
      }
</style>
</head>
<div>
	
</div>
<br>
<body >

<c:set var="hdr" value="${masterList}" />
<!-- <div>
	<p
		style="font-size: 14px;font-weight:bold; margin:2px 0px 0px 330px; font-family: Ubuntu !important;">
		
		
		</p>
	<br> 
</div> -->


<!-- <div
	style="padding: 1%; font-family: Ubuntu !important; margin-top: -28px;">

	<div style="margin-top:-52px">
	<div class="col-sm-12 wid100pr"> -->
		<table 
				style="border: none;margin-top: 5px; vertical-align: text-bottom; width: 100%;  height: 400px !important;border:none !important">
			<!-- <thead>
			</thead><body style="border: 1px solid">
			
		<table width="100%"> -->
			<thead>
			</thead>
			<tbody style="line-height: 5px;">
				<tr class="wid50pr" style="vertical-align: text-bottom;">
					<td class="wid50pr" style="vertical-align: text-bottom;"><br>
					<div class="bold fntSiz10px"
						style="padding-left: 5px; padding-left: 5px">
					<span class="bold fntSiz10px" style="padding-left: 5px">
							Shipper</span> <br><br><!-- <span class="fontsizeForNum"
						style="float: right; margin-top: -5px;">3</span> -->
						<div class="" style="padding-left: 5px">
							<p class="fntSiz12px"
								style="line-height: 10px; height: 72px; font-weight: normal; margin-top: 2px;">${hdr.shipper}</p>
						</div>
						<hr class="hrLine">
						<br>
					<br>
					<span class="bold fntSiz10px" style="padding-left: 5px">
							Consignee</span><br><br> <!-- <span class="fontsizeForNum"
						style="float: right; margin-top: -5px;">3</span> -->
						<div class="" style="padding-left: 5px">
							<p class="fntSiz12px"
								style="line-height: 10px; height: 72px; font-weight: normal; margin-top: 2px;">${hdr.cnee}</p>
						</div>
						<hr class="hrLine">
						<br>
					<br>
						<span
						class="bold fntSiz10px"
						style="padding-left: 5px; padding-left: 5px"> Notify</span><br><br></div>
					 <!-- <span class="fontsizeForNum"
						style="float: right; margin-top: -6px;">5</span> -->
						<p class="fntSiz12px"
							style="padding-left: 5px; height: 70px; line-height: 11px; margin-top: 2px;">${hdr.notify1}</p>

						
							</td>


										
				
<td class="wid50pr" style="vertical-align: text-bottom;">
					<div class="bold fntSiz10px"
						style="padding-left: 5px; padding-left: 5px">
					<p style ="padding-left:20px; font-size:15px; "><br><b>Bill Of Laddan </b><br>
									<br><br><span style ="padding-right:10px; font-size:12px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;REG. No : </span>
								</p>
						<hr class="hrLine">
						
					
					<p style ="padding-left:20px; font-size:13px; "><span style ="padding-right:10px; font-size:12px"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BL Number : ${hdr.blNo}</b></span></p>
											</div>

						<hr class="hrLine">
						
						<br>
					<br>
					<c:choose>
<c:when test="${hdr.carrier =='ALLIGATOR  SHIPPING CO LLC'}">
					 <%-- <c:if test="${hdr.carrier ==ALLIGATOR SHIPPING CO LLC}"> --%>
						<div style="text-align: center;">
			<span style=" line-height: 10px; text-align: center; height: 72px; font-weight: normal; margin-top: 2px; font-size:11px; align=center"><br><img 
											src="/img/MBKHelpVideos/asco1.png"
											style="padding: 0px 0 0 40px;   height: 35px; "> 
											<br><br> ${hdr.carrier}</span><br><br><span style="font-size:10px">(Regd.Office)
											 <br>${hdr.carrierAddress}<br></span></div> 
<p style="line-height: 10px; height: 72px; font-size:9px; margin-top: 2px; padding-left:5px;">RECEIVED by the carrier the Goods as specified below  in apparent good order and condition unless otherwise stated to be transported to such place as agreed, authorized or permitted herein and subject to all terms and conditions appearing on the front and reverse of this Bill of Lading to which the merchant agrees by accepting this Bill of lading, any local privileges and customs notwithstanding.
<br><br>The particulars given below as stated by the shipper and the weight, measure, quantity, condition, contents and the value of Goods are unknown to the Carrier.
<br><br>In WITNESS whereof one (1) original Bill of Lading has been signed if not otherwise stated hereafter, the same being accomplished the other(s), If any,to be void. If required by the Carrier one (1) original Bill of Lading must be surrenered duly endorsed exchange or the Goods or Delivery Order.
 </br></p></c:when>
 
 <c:when test="${hdr.carrier =='Freeseas Container Shipping LLC'}">
					 <%-- <c:if test="${hdr.carrier ==ALLIGATOR SHIPPING CO LLC}"> --%>
						<div style="text-align: center;">
			<span style=" line-height: 10px; text-align: center; height: 72px; font-weight: normal; margin-top: 2px; font-size:11px; align=center"><br><img 
											src="/img/MBKHelpVideos/freseasLogo.png"
											style="padding: 0px 0 0 40px;   height: 35px; "> 
											<br><br> ${hdr.carrier}</span><br><br><span style="font-size:10px">(Regd.Office)
											 <br>${hdr.carrierAddress}<br></span></div> 
<p style="line-height: 10px; height: 72px; font-size:9px; margin-top: 2px; padding-left:5px;">RECEIVED by the carrier the Goods as specified below  in apparent good order and condition unless otherwise stated to be transported to such place as agreed, authorized or permitted herein and subject to all terms and conditions appearing on the front and reverse of this Bill of Lading to which the merchant agrees by accepting this Bill of lading, any local privileges and customs notwithstanding.
<br><br>The particulars given below as stated by the shipper and the weight, measure, quantity, condition, contents and the value of Goods are unknown to the Carrier.
<br><br>In WITNESS whereof one (1) original Bill of Lading has been signed if not otherwise stated hereafter, the same being accomplished the other(s), If any,to be void. If required by the Carrier one (1) original Bill of Lading must be surrenered duly endorsed exchange or the Goods or Delivery Order.
 </br></p></c:when>
 <c:when test="${hdr.carrier !='KIN-SHIP Services (INDIA) PVT. LTD.'}">
					 <%-- <c:if test="${hdr.carrier ==ALLIGATOR SHIPPING CO LLC}"> --%>
						<div style="text-align: center;">
			<span style=" line-height: 10px; text-align: center; height: 72px; font-weight: normal; margin-top: 2px; font-size:11px; align=center"><br><img 
											src="/img/MBKHelpVideos/KIN.png"
											style="padding: 0px 0 0 40px;   height: 35px; "> 
											<br><br> ${hdr.carrier}</span><br><br><span style="font-size:10px">(Regd.Office)
											 <br>${hdr.carrierAddress}<br></span></div> 
<p style="line-height: 10px; height: 72px; font-size:9px; margin-top: 2px; padding-left:5px;">Taken in charge in apparently good condition herein at the place of receipt for transport and delivery  as mentioned above, unless otherwise stated. The MTO in accordance with the provisions contained in the MTD undertakes to perform or to procure the performance of the multimodal transport from the place at which he goods are taken in charge,to the place designated for deivery and assumes responsblity for such transport.
							 <br><br>One of the MTD(s) must be surrendered,duly endorsed in exchange for the goods. In witness where of the original MTD all of this tenor and date have been signed in the number indicated below one of which being accomplished the other(s) to be void.
							 </br></p></c:when>
 </c:choose>
 <!-- Taken in charge in apparently good condition herein at the place of receipt for transport and delivery  as mentioned above, unless otherwise stated. The MTO in accordance with the provisions contained in the MTD undertakes to perform or to procure the performance of the multimodal transport from the place at which he goods are taken in charge,to the place designated for deivery and assumes responsblity for such transport.
							 <br><br>One of the MTD(s) must be surrendered,duly endorsed in exchange for the goods. In witness where of the original MTD all of this tenor and date have been signed in the number indicated below one of which being accomplished the other(s) to be void. -->
						
						
							</td>					
				
						 <%-- <table style="border: 0px;">
						 <tr  style="height:10px;border: 0; ">
								<td colspan="2">
								<p style ="padding-left:20px; font-size:13px; "><b>Multimodal Transport Document </b>
									<br><span style ="padding-right:10px; font-size:12px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;REG. No :${hdr.blNo}</span>
								</p>
								 </td>
								 <td colspan="1" style="width:25%;"></td>
								 
							</tr>
							<tr style="height:20px;border: 0px; " >
							<td colspan="2" style="border: 0px;width:45%; font-size:11px" align="right"> MTD Number</td>
							
							<td colspan="1"></td>
							</tr>
							 <tr style="height:0px;border: 0px; height:100px;">
			<td colspan="3" style="border: 0px; " >
			<div style="text-align: center;">
			<span style=" line-height: 10px; text-align: center; height: 72px; font-weight: normal; margin-top: 2px; font-size:11px; align=center"><br><img 
											src="/img/MBKHelpVideos/asco1.png"
											style="padding: 0px 0 0 40px;   height: 35px; "> 
											<br><br> ${hdr.carrier}<br></span><span style="font-size:10px">(Regd.Office)
											 <br>${hdr.carrierAddress}<br></span></div> 
<p style="line-height: 10px; height: 72px; font-size:9px; margin-top: 2px; padding-left:5px;">RECEIVED by the carrier the Goods as specified below  in apparent good order and condition unless otherwise stated to be transported to such place as agreed, authorized or permitted herein and subject to all terms and conditions appearing on the front and reverse of this Bill of Lading to which the merchant agrees by accepting this Bill of lading, any local privileges and customs notwithstanding.
<br><br>The particulars given below as stated by the shipper and the weight, measure, quantity, condition, contents and the value of Goods are unknown to the Carrier.
<br><br>In WITNESS whereof one (1) original Bill of Lading has been signed if not otherwise stated hereafter, the same being accomplished the other(s), If any,to be void. If required by the Carrier one (1) original Bill of Lading must be surrenered duly endorsed exchange or the Goods or Delivery Order.<!-- Taken in charge in apparently good condition herein at the place of receipt for transport and delivery  as mentioned above, unless otherwise stated. The MTO in accordance with the provisions contained in the MTD undertakes to perform or to procure the performance of the multimodal transport from the place at which he goods are taken in charge,to the place designated for deivery and assumes responsblity for such transport.
							 <br><br>One of the MTD(s) must be surrendered,duly endorsed in exchange for the goods. In witness where of the original MTD all of this tenor and date have been signed in the number indicated below one of which being accomplished the other(s) to be void. -->
							</p> </td>
								
							</tr>
						</table> --%>						
					

				</td></tr>
				<tr>
					
					<td style="padding:0px">
					
				
						 <table style="width:100%;border: 0px;">
						
							<tr>
								<td style="    border-top: 0px; border-right: 0px;   border-left: 0px;" colspan="2" >
									<div class="bold fntSiz10px"
						style="padding-left: 5px; padding-left: 5px">
										<!-- <span class="fontsizeForNum"
											style="float: right; margin-top: -3.5px;">7</span> -->
										<p style ="padding-left:5px;">Date of Acceptance <!-- <span class="fontsizeForNum" style="float:right;margin-top:-3.5px;">9</span> --></p>
								<!-- <p class="fntSiz12px"
									style=" font-weight: normal;padding-left:5px;">—</p> -->
									<p class="fntSiz12px"
									style="font-weight: normal;padding-left:5px;">
								</p>
									</div>
								</td>
								<td style="    border-top: 0px; border-right: 0px;" colspan="2">
									<div class="bold fntSiz10px table-body-cell"
										style="vertical-align: top; padding-top: 5px;    width: 1%;">
										<!-- <span class="fontsizeForNum"
											style="float: right; margin-top: -3.5px;">8</span> -->
										<p style="padding-left: 5px;">Place of Acceptance</p>
										<p class="fntSiz12px"
											style="font-weight: normal; padding-left: 5px;">${hdr.disPol}
										</p>
									</div>

</td>
<td style="    border-top: 0px; border-right: 0px;  colspan="2"  border-left: 0px;">
									<div class="bold fntSiz10px table-body-cell"
										style="vertical-align: top; padding-top: 5px;    width: 1%;">
										<!-- <span class="fontsizeForNum"
											style="float: right; margin-top: -3.5px;">7</span> -->
										<p style ="padding-left:5px;">Port of Delivery <!-- <span class="fontsizeForNum" style="float:right;margin-top:-3.5px;">9</span> --></p>
								<!-- <p class="fntSiz12px"
									style=" font-weight: normal;padding-left:5px;">—</p> -->
									<p class="fntSiz12px"
									style="font-weight: normal;padding-left:5px;">${hdr.disPod}
								</p>
									</div>
								</td>
							</tr>
								<tr>
								<td style="    border-top: 0px; border-right: 0px;   border-left: 0px;" colspan="3" >
									 <div class="bold fntSiz10px table-body-cell" style ="vertical-align: top;padding-top: 5px;width: 1%;">
								<p style ="padding-left:5px;">Port of Discharge <!-- <span class="fontsizeForNum" style="float:right;margin-top:-3.5px;">9</span> --></p>
								<!-- <p class="fntSiz12px"
									style=" font-weight: normal;padding-left:5px;">—</p> -->
									<p class="fntSiz12px"
									style="font-weight: normal;padding-left:5px;">${hdr.disPod}
								</p>
								</div>
								</td>
								<td style="    border-top: 0px; border-right: 0px;" colspan="3">
									 <div class="bold fntSiz10px table-body-cell" style ="vertical-align: top;padding-top: 5px;width: 1%;">
								<p style ="padding-left:5px;">Place of Delivery <!-- <span class="fontsizeForNum" style="float:right;margin-top:-3.5px;">10</span> --></p>
								<p class="fntSiz12px"
									style="font-weight: normal;padding-left:5px;">${hdr.disFpod}
								</p>
								</div>
								</td>
							</tr>
							<tr >
								<td style="    border-top: 0px; border-right: 0px;   border-bottom: 0px;  border-left: 0px;" colspan="3">
									 <div class="bold fntSiz10px table-body-cell" style ="vertical-align: top;padding-top: 5px;width: 1%;">
								<p style ="padding-left:5px;">Vessel Voy No. <!-- <span class="fontsizeForNum" style="float:right;margin-top:-3.5px;">9</span> --></p>
								<!-- <p class="fntSiz12px"
									style=" font-weight: normal;padding-left:5px;">—</p> -->
									<p class="fntSiz12px"
									style="font-weight: normal;padding-left:5px;">${hdr.vessel} / ${hdr.vslVoyage}
								</p>
								</div>
								</td>
								<td style="    border-top: 0px; border-right: 0px; border-bottom: 0px;" colspan="3">
									 <div class="bold fntSiz10px table-body-cell" style ="vertical-align: top;padding-top: 5px;width: 1%;">
								<p style ="padding-left:5px;">Date or Period of Delivery <!-- <span class="fontsizeForNum" style="float:right;margin-top:-3.5px;">10</span> --></p>
								<p class="fntSiz12px"
									style="font-weight: normal;padding-left:5px;">
								</p>
								</div>
								</td>
							</tr> 
							<%-- <tr>
								<td style="    border-top: 0px; border-right: 0px;   border-bottom: 0px;  border-left: 0px;" colspan="3">
									 <div class="bold fntSiz10px table-body-cell" style ="vertical-align: top;width: 1%;">
								<p style ="padding-left:5px;margin-top: -14px;">Vessel Voy No.<!-- <span class="fontsizeForNum" style="float:right;margin-top:-3.5px;">11</span> --></p>
								<span class="fntSiz12px"
									style=" font-weight: normal;padding-left:5px;">—</span>
								</div>
								</td>
								<td style="    border-top: 0px; border-right: 0px; border-bottom: 0px;" colspan="3">
									<div class="bold fntSiz10px table-body-cell" style ="vertical-align: top;padding-top: 5px;width: 1%;">
								<p style ="padding-left:5px;">Date or Period of Delivery <!-- <span class="fontsizeForNum" style="float:right;margin-top:-3.5px;">12</span> --></p>
								<p class="fntSiz12px"
									style="font-weight: normal;padding-left:5px;">${hdr.vslVoyage}
								</p>
								</div>
								</td>
							</tr> --%> 
						</table> 


					</td><td style="padding:0px">
					
				
						 <table style="width:100%;border: 0px;">
						 <tr class="wid50pr" style="vertical-align: text-bottom;">
								<td colspan='2'
									style="border-top: 0px; border-right: 0px; border-left: 0px;">
									<!-- <span class="bold fntSiz10px" style="padding-left: 5px">
										Shipper/ Export /Forwarder References </span>  -->
										<span class="bold fntSiz10px" style="padding-left: 2px">
										 To Obtain Delivery Contact</span> <!-- <span
									class="fontsizeForNum" style="float: right; margin-top: -2px;">4</span> -->

									<div style="height: 5px;">
										<p style="padding-left: 5x; font-weight: normal;"
											class="fntSiz12px"></p>


									</div><br><br><br>
								</td>
								

							</tr>
							
							<tr class="wid50pr" style="vertical-align: text-bottom;">
								<td style="    border-top: 0px; border-right: 0px; border-bottom: 0px;   border-left: 0px;">
									<div class="bold fntSiz10px table-body-cell"
										style="vertical-align: top; padding-top: 5px;    width: 1%;">
										<!-- <span class="fontsizeForNum"
											style="float: right; margin-top: -3.5px;">7</span> -->
										<p style="padding-left: 5px;">Modes / Means of Transport</p>
										<p class="fntSiz12px"
											style="font-weight: normal; padding-left: 5px;"></p>
									</div>
								</td>
								<td style="  border-bottom: 0px;   border-top: 0px; border-right: 0px;">
									<div class="bold fntSiz10px table-body-cell"
										style="vertical-align: top; border-bottom: 0px;   padding-top: 5px;    width: 1%;">
										<!-- <span class="fontsizeForNum"
											style="float: right; margin-top: -3.5px;">8</span> -->
										<p style="padding-left: 5px;">Route/Place of Transhipment (if any)</p>
										<p class="fntSiz12px"
											style="font-weight: normal; padding-left: 5px;">${hdr.disPol}
										</p>
									</div>



							</tr>
								
							
						</table> 


					</td>
				</tr>
				</tbody></table>
				
				
				<table 
				style=" border-top:0px; margin-top: 0px; vertical-align: text-bottom; width: 100%;  height: 400px !important;">
				<thead>
					<tr>
						<!-- <th class="bold fntSiz12px"
							style=" border-top: 0px;   padding: 3px; width: 10%;">
							
								<span>Container No.</span>
													</th> -->
													<th class="bold fntSiz12px"
							style="border-top: 0px;  padding: 3px; width: 6%;">
							
							<div>
								<span>Container No</span>
							</div>
						</th>
						<th class="bold fntSiz12px"
							style="border-top: 0px;  padding: 3px; width: 6%;">
							
							<div>
								<span>Marks and Numbers</span>
							</div>
						</th>
						<th class="bold fntSiz12px"
							style="border-top: 0px;  padding: 3px; width: 30%;">
							
							<div>
								<span>Number of packages,kinds of Packages,general description of goods (said to contain) </span>
							</div>
						</th>
						<th class="bold fntSiz12px"
							style="border-top: 0px;  padding: 3px; width: 6%;">
							
							<div>
								<span>Gross Weight</span>
							</div>
						</th>

						<th class="bold fntSiz12px "
							style="border-top: 0px;  padding: 3px; width: 6%;">
							
							<div>
								<span>Measurement</span>
							</div>
						</th>

					</tr>
				</thead>
				<tbody style="font-size: 10px;">
					<c:forEach var="detailObj1" items="${ConListOverFlow}">
						<tr style="height: 8px !important;">

							<td class=" "
								style="border-bottom: 1px solid white; font-size: 10px; padding-left: 5px;"
								valign="top"><span style="padding: 0px; margin: 0px;">${detailObj1.marks}</span>
								
								</td>
							<td class=" "
								style="border-bottom: 1px solid white; font-size: 10px; padding-left: 5px;"
								valign="top"><span style="padding: 0px; margin: 0px;">${detailObj1.pkgs}</span>
								<br>
								<c:forEach var="contCount" items="${ConCountList}">
							<span style="padding: 0px; margin: 0px;">${contCount.contCount} X ${contCount.conType}</span> <br>
							</c:forEach>
								<span style="padding: 0px; margin: 0px;font-size: 10px;">${hdr.marks}</span>
								</td>
							<td class=" "
								style="border-bottom: 1px solid white; padding: 0px; margin: 0px; font-size: 10px; padding-left: 5px;"
								valign="top"><div class="main"><span> ${hdr.goods}</span>
								
							
								
								
								<c:if test="${hdr.billType == 'Sea WayBill'}"><div style="    text-align: center;">
								<span style="color:red;font-size: 15px;">Sea WayBill</span></div></c:if>
								
								<div class="bottom">
								<c:if test="${hdr.showFreeDaysGrid == true}">
								<br>
							
								<span style="font-size: 9px;">Free days allowed at Discharge Port</span>
								<table style="width: 100%; border: none;margin-top: 2px;margin-left: -3px;">
								<thead>
								<tr>
								<th class="bold fntSiz10px wid10pr"
								style="vertical-align: middle !important; border-left: 1px solid #333 !important; padding: 3px;"><span>Demurrage (days)</span>
								<span class="fontsizeForNum" style="float: right;"></span><br></th>
								<th class="bold fntSiz10px wid10pr"
								style="vertical-align: middle !important; border-right: none !important; padding: 3px;"><span>Detention (days)</span>
								<span class="fontsizeForNum" style="float: right;"></span><br></th>
								<th class="bold fntSiz10px wid10pr"
								style="vertical-align: middle !important; border-right: 1px solid #333 !important; padding: 3px;"><span>Combined (Demurrage + Detention) days</span>
								<span class="fontsizeForNum" style="float: right;"></span><br></th>
									
								</tr>
								</thead>
								<tbody style="font-size: 10px;">
								<c:if test="${hdr.demdet == 'Separate' || !hdr.demdet && hdr.demdet != 'Combined'}">
								<tr style="height: 20px !important; border-bottom: 1px solid #333 !important;">
									<td class=" "
									style="border-bottom: 1px solid black; font-size: 10px; padding-left: 5px; border-left: 1px solid #333;text-align: center;"><span
									style="padding: 0px; margin: 0px;">${hdr.podFreedaysDemaurrage}</span></td>
									<td class=" "
									style="border-bottom: 1px solid black; font-size: 10px; padding-left: 5px; text-align: center;border-right: none;"><span
									style="padding: 0px; margin: 0px;">${hdr.podFreedaysDetention}</span></td>
									<td class=" "
									style="border-bottom: 1px solid black; font-size: 10px; padding-left: 5px; text-align: center;border-right: 1px solid #333;"><span
									style="padding: 0px; margin: 0px;">0</span></td>
									
								</tr>
								</c:if>
								<c:if test="${hdr.demdet == 'Combined'}">
								<tr style="height: 20px !important; border-bottom: 1px solid #333 !important;">
									<td class=" "
									style="border-bottom: 1px solid black; font-size: 10px; padding-left: 5px; border-left: 1px solid #333;text-align: center;"><span
									style="padding: 0px; margin: 0px;">0</span></td>
									<td class=" "
									style="border-bottom: 1px solid black; font-size: 10px; padding-left: 5px; text-align: center;border-right: none;"><span
									style="padding: 0px; margin: 0px;">0</span></td>
									<td class=" "
									style="border-bottom: 1px solid black; font-size: 10px; padding-left: 5px; text-align: center;border-right: 1px solid #333;"><span
									style="padding: 0px; margin: 0px;">${hdr.podFreedaysDetention + hdr.podFreedaysDemaurrage}</span></td>
									
								</tr>
								</c:if>
								</tbody>
								</table>
								<br>
								</c:if>
								<b>Particulars above furnished by Shipper/Consignee</b>
								</div>
								</div>
								</td>


							<td class=" "
								style="border-bottom: 1px solid white; padding: 0px; margin: 0px; font-size: 10px; padding-right: 5px;"
								valign="top" align="right"><div class="main"><span>${detailObj1.g_wgt}</span></div> <c:set
									var="string3" value="Net Weight : ${detailObj1.nwgt}" /> <c:out
									value="${empty detailObj1.nwgt ? '' :  string3}" /></td>
							<td class=" "
								style="border-bottom: 1px solid white; padding: 0px; margin: 0px; font-size: 10px; padding-left: 5px;"
								valign="top" align="right"><div class="main"><span>${detailObj1.cbm}</span></div></td>


						</tr>
					</c:forEach>

				</tbody>
				<table style="width: 100%; height: 0px; border-top: 0px;">
			<tbody>
				<tr>
					<td rowpan="3"
						style="vertical-align: text-top; border-bottom: 1px solid #333; font-size: 10px;width: 27% !important;
    word-break: break-all;"
						class="wid18pr"><span style="font-size: 13px;">Freight Amount
								 </span><!-- <span class="fontsizeForNum" style="float: right;">31</span> -->
						<br>
					<span style="font-size: 8px;"></span></td>
					


					<td colspan="3"><span style="font-size: 13px;">Freight Payable at </span><!-- <span class="fontsizeForNum"
						style="float: right;">33</span> --><br>
					<!-- <span style="font-size: 13px;"><b>Cordelia Container
								Shipping Line</b></span> -->
						<p style="" class="signbehalf">
							<span style="font-size: 13px;"></span><br>
							<span style="font-size: 11px;">As Agent </span>
						</p></td>
						<td rowpan="3"
						style="vertical-align: text-top; border-bottom: 1px solid #333; font-size: 10px;width: 27% !important;
    word-break: break-all;"
						class="wid18pr"><span style="font-size: 13px;">Number of Original MTD (s)
								 </span><!-- <span class="fontsizeForNum" style="float: right;">31</span> -->
						<br>
					<span style="font-size: 14px;"><br><br>3</span></td>
					<td rowpan="3"
						style="vertical-align: text-top; border-bottom: 1px solid #333; font-size: 10px;width: 27% !important;
    word-break: break-all;"
						class="wid18pr"><span style="font-size: 13px;">Place and date of issue
								 </span><!-- <span class="fontsizeForNum" style="float: right;">31</span> -->
						<br>
					<span style="font-size: 8px;"></span></td>
</tr>
<tr>
					<td colspan="4"
						style="vertical-align: text-top; border-bottom: 1px solid #333; font-size: 10px;width: 27% !important;
    word-break: break-all;"
						class="wid18pr"><span style="font-size: 13px;">Other Particulars (if any)
								Agent </span><!-- <span class="fontsizeForNum" style="float: right;">31</span> -->
						<br>
					<span style="font-size: 8px;"></span></td>



					

					<td colspan="2"><span style="font-size: 13px;">For ${hdr.carrier}</span><!-- <span class="fontsizeForNum"
						style="float: right;">33</span> --><br>
					
						<p style="" class="signbehalf">
							<span style="font-size: 13px;"></span><br>
							<span style="font-size: 9px;">As Agent </span>
						</p></td>
</tr>
					
			</tbody>
		</table>
				
			</table>
	<!-- 	
	</table> -->
</body>
</html>




