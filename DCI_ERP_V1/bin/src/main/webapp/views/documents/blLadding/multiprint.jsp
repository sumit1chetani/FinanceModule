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
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Ubuntu" />
<style>
@page { size: auto; margin: 5mm; }


td.a {
	height: auto;
}

table.noborder {
	border: none;
}

td.noborder { @media print
{
.break_page {page-break-after:always}
}

	border: none;
}

.subpage {
	border: 1px black solid;
	height: 270mm;
}
.hr{
height: 8px 
}
p.t-content {
    font-size: 11px;
}
p.h-content {
    font-size: 11px;
}
hr {
    border-bottom: 2px solid;
}
 @media print
{
.break_page {page-break-after:always}
}

body{

	font-family: Ubuntu !important;

}
  
</style>
</head>
<body>
	<c:forEach var="hdr" items="${resultBean.getMultiprint()}" varStatus="loop">
		
		<%-- //test : ${hdr.index+1} --%>
	<%-- 	test : ${loop.index+1} --%>
		
		<c:set var="count" value="${loop.index+1}" scope="page"/>
  

               <!-- =========page 1 Header values======= -->
		<div style="padding: 0%; border: none;" class="subpage">

			 <table style="width: 100%;" ng-repeat="(trIndex,row) " >
				<tr >
					<td style="width: 30%"><img 
						src="/img/MBKHelpVideos/mbk_image.png" style = "height: 50px; width: 200px; float: left !important; " /></td>
						<td style="text-align:right"><font face="arial" size="4" style="float: right !important; padding: 0px 15px 0px 0px !important;"><b>MBK LOGISTIX PVT LTD</b>
								
		   </font>
						</td>
				</tr>
			</table>
			<hr>
			<br>
			<table style="width: 100%;">
			<tr>
			<td style="width: 60%"><b><center><h1 style="font-size:20px">CARGO MANIFEST </h1 ></center></b></td>
			<td style="width: 10%"><p class="t-content"> <b>&nbsp;&nbsp;</b><br><b></b></p></td>
			<td style="width: 15%"><p class="t-content"> <b>Run Date:&nbsp;&nbsp;${hdr.currentDate}  </b><br><b>User :&nbsp;&nbsp;${hdr.username}</b></p></td>
			</tr>
			</table>
			<hr>
			<table style="width: 100%;">
			<tr>
			<td style="width: 35%"> <p class="t-content"><b>Agent:&nbsp;&nbsp;${hdr.agent}</b></td>
			<td style="width: 25%"> <p class="t-content"><b>Vessel:&nbsp;&nbsp;${hdr.vessel}</b></td>
			<td style="width: 20%"> <p class="t-content"><b>Voyage:&nbsp;&nbsp;${hdr.vslVoyage}</b></td>
			<%-- <td style="width: 20%"> <p class="t-content"><b>Rotation No:&nbsp;&nbsp;${hdr.rotationNo}</b></td> --%>
			</tr>
			</table>
			<hr>
			<table style="width: 100%;">
			<tr>
			<!-- <td style="width: 10%"> <p class="t-content"><b>Arrival:</b></p></td> -->
			<td style="width: 25%;padding-left: 39px"> <p class="t-content"><b>Port of Loading: </b><br>&nbsp;&nbsp;${hdr.pol}</p></td>
			<td style="width: 25%"> <p class="t-content"><b>Port of Discharge:</b><br>&nbsp;&nbsp;${hdr.pod}</p></td>
			<td style="width: 25%"> <p class="t-content"><b>Port of Delivery:</b><br>&nbsp;&nbsp;${hdr.fpod}</p></td>
			<td style="width: 20%"> <p class="t-content"><b>Sailing on:</b><br>&nbsp;&nbsp;${hdr.onBoard}</p></td>
			</tr>
			<tr></tr> <tr></tr> <tr></tr> <tr></tr>
 			<tr>
			
			<td style="width: 25%;padding-left: 39px"> <p class="t-content"></p></td>
			<td style="width: 25%"> <p class="t-content"><b>Free time at Origin:</b>&nbsp;&nbsp;${hdr.polfreedays} Days</p></td>
			<td style="width: 25%"> <p class="t-content"><b>Free time at Destination:</b>&nbsp;&nbsp;${hdr.podfreedays} Days</p></td>
			
			</tr>
			</table>
			<br><br>
			
            <table style="width: 100%;">
			<tr>
			<td style="width: 23%;text-align:center;font-size: 11px;"> <b>Name & Address Details <br> S-Shipper, C-Consignee, N-Notify</b></p></td>
			<td style="width: 12%;text-align:center;font-size: 11px;"> <b>BL Number <br>Marks & Nos</b></td>
			<td style="width: 22%;text-align:center;font-size: 11px;"> <b>Cargo Description</b></td>
			<td style="width: 10%;text-align:center;font-size: 11px;"> <b>BL Issued Date</b></td>
			<td style="width:15%;text-align:center;font-size: 11px;"> <b>Terms</b></td>
			</tr>
			</table>
			<hr>
			<table style="width: 100%;">
<%-- 			<c:forEach var="cndtl" items="${hdr.blcntrDtlList}">
 --%>			<tr>
			<td style="width: 23%"> <p class="h-content">Org Name: <br><br> S:&nbsp;${hdr.shipper}<br><br>C:&nbsp;${hdr.cnee}<br><br>N:&nbsp;${hdr.notify1}<br><br>N:&nbsp;${hdr.notify2}</br></p></td>
			<td style="width: 12%;font-size: 12px;a: left;padding-left: 1px;padding-bottom: 143px;"><b>${hdr.blNo}</b><br></td>
			<td style="width: 22%"><p class="h-content"><br>TOTAL CONTAINERS:&nbsp; ${hdr.totalcontainers}<br>TOTAL PACKAGES: &nbsp; ${hdr.totalpkgs}<br>TOTAL NET WEIGHT:&nbsp;${hdr.totalnet}<br>TOTAL GROSS WEIGHT:&nbsp;${hdr.totalgross}<br>TOTAL CBM:&nbsp;${hdr.totalcbm}</br></p></td>
			<td style="width: 10%;padding-bottom: 134px;font-size: 13px;">${hdr.issueDate}</td>
			<td style="width: 15%;padding-bottom: 134px;font-size: 13px;text-align: center;">${hdr.terms}</td>
			</tr>
<%-- 			</c:forEach>
 --%>			</table> 
			<br><br><br><br><br><br><br><br><br><br>
			<hr>
			<p class="c-content" style="font-style: italic;"><b>Remarks:</b></p>
			<hr>
			
			
</div>
<div>
 <br><br><br><br> <br> <br>                                        <!-- ======page 2 Container details List===== -->
<table style="width: 100%;" >
				<tr >
						<td style="width: 30%"><img 
						src="/img/MBKHelpVideos/mbk_image.png" style = "height: 50px; width: 200px; float: left !important; " /></td>
						<td style="text-align:right"><font face="arial" size="4" style="float: right !important; padding: 0px 15px 0px 0px !important;"><b>MBK LOGISTIX PVT LTD</b>
								
		   </font>
						</td>
				</tr>
			</table>
			<hr>
			<table style="width: 100%;">
			<tr>
			<td style="width: 60%"><b><center><h1 style="font-size:20px">CARGO MANIFEST</h1 ></center></b></td>
			<td style="width: 10%"><p class="t-content"> <b>&nbsp;&nbsp;</b><br><b></b></p></td>
			<td style="width: 15%"><p class="t-content"> <b>Run Date:&nbsp;&nbsp;${hdr.currentDate}</b><br><b>User:&nbsp;&nbsp;${hdr.username}</b></p></td>
			</tr>
			</table>
			<hr>
			<c:choose>
    <c:when test="${loop.index < '1'}">
       <c:set value="break_page" var="cssClass"></c:set>
       
    </c:when>    
   
</c:choose>

<div class="${cssClass}">
				<table style="width: 100%;">
			<tr>
			<td style="width: 11%"><p class="t-content"> <b>Container No</b></p></td>
			<td style="width: 4%"><p class="t-content"> <b>Size&type </b></p></td>
			<td style="width: 7%"><p class="t-content"> <b>Service</b></p></td>
			<td style="width: 12%"><p class="t-content"> <b>Packages</b></p></td>
			<td style="width: 8%"><p class="t-content"> <b>Seal #</b></p></td>
			<td style="width: 8%"> <p class="t-content"><b>Net Wt (KG)</b></p></td>
			<td style="width: 8%"> <p class="t-content"><b>Gross Wt (KG)</b></p></td>
			<td style="width: 8%"><p class="t-content"> <b>VGM (KG)</b></p></td>
			<td style="width: 8%"> <p class="t-content"><b>CBM</b></p></td>
			<td style="width: 10%"><p class="t-content"> <b>Commodity</b></p></td>
			<td style="width: 4%"> <p class="t-content"><b>Haz</b></p></td>
			<td style="width: 5%"> <p class="t-content"><b>Temp/Unit</b></p></td>
			</tr>
			<tr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			<td><hr></hr>
			</tr>
			</table>
			<table style="width: 100%;">
			<c:forEach var="cndtl" items="${hdr.blcntrDtlList}">
			<tr>
			<td style="width: 15%; font-size: 12px;">${cndtl.cntrName}</td>
			<td style="width: 5.5%;font-size: 12px;">${cndtl.conType}</td>
			<td style="width: 6.5%;font-size: 12px;"></td>
			<td style="width: 13%;font-size: 12px;">${cndtl.packageType}&nbsp;&nbsp;${cndtl.noOfPckgs}</td>
			<td style="width: 10%;font-size: 12px;">${cndtl.sealNo}</td>
			<td style="width: 8%;font-size: 12px;">${cndtl.net}</td>
			<td style="width: 8%;font-size: 12px;">${cndtl.gw}</td>
			<td style="width: 9%;font-size: 12px;"></td>
			<td style="width: 8%;font-size: 12px;">${cndtl.cb}</td>
			<td style="width: 9;font-size: 8px;"><b>${hdr.maincom}</b></td>
			<td style="width: 4%;font-size: 12px;"></td>
			<td style="width: 5%;font-size: 12px;"></td>
			</tr>
			</c:forEach>
			</table>
			<hr>
				<table style="width: 100%;">
			<tr>
			<td style="width: 36%; font-size: 11px;"><b>Total Containers:</b>${hdr.totalcon}</td>
			<td style="width: 1%;font-size: 12px;"></td>
			<td style="width: 13%;font-size: 12px;"><b>Total: ${hdr.totalpkgs}</b></td>
			<td style="width: 10%;font-size: 12px;">${cndtl.sealNo}</td>
			<td style="width: 8%;font-size: 12px;"> <b>${hdr.totalnet}</b></td>
			<td style="width: 8%;font-size: 12px;"><b>${hdr.totalgross}</b></td>
			<td style="width: 9%;font-size: 12px;"><b></b></td>
			<td style="width: 8%;font-size: 12px;"><b>${hdr.totalcbm}</b></td>
			<td style="width: 9;font-size: 12px;%"></td>
			<td style="width: 3%;font-size: 12px;"></td>
			<td style="width: 4%;font-size: 12px;"></td>
			</tr>
			</table>
			<hr>
<!-- 
			<hr>
			<p class="c-content" style="font-style: italic;"><b>Remarks:</b></p>
			<hr>
			 -->
	
	
          <table style ="width:100%;border: 1px solid #333;border-bottom:1px solid #fff;">
           <tr>
            <th style= "font-size:12px;">DISCHARGE PORT</th>
            <th style= "font-size:12px;">DELIVERY PLACE</th>
            <th style= "font-size:12px;">TOTAL BL</th>
           </tr>
           <tbody>
           <tr>
           <td style = "text-align:center;font-size:12px;">${hdr.podname}</td>
           <td style = "text-align:center;font-size:12px;">${hdr.fpodname}</td>
           <td style = "text-align:center;font-size:12px;">${hdr.noBls}</td>
           </tr>
           </tbody>
          </table>
          <div  style ="border: 1px solid #333;text-align: center;">
          <p>Total Containers: <br> </p>
           <p> 20" - ${hdr.t20con}<br>
               40" - ${hdr.t40con}</p>
           	</div>	
			
</div>


</div>
	


</c:forEach>
	
	
	
	
</body>