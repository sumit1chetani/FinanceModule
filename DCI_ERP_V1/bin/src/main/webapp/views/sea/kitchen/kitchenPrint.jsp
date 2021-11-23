<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title></title>
</head>
<style>
body {
	background-color: #FFFFFF;
	color: #000000;
	font-family: 'Arial';
}

.form-horizontal {
	margin-right: -15px;
	margin-left: -15px;
}

.padding-20p {
	padding: 20px;
}

.padding-top-10 {
	padding-top: 10px;
}

.padding-left-5 {
	padding-left: 5px;
}

.padding-5p {
	padding: 5px;
}

.line-height-23p {
	line-height: 23px;
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

.width_100 {
	width: 100%;
}
/* .footer{
    width: 100%;
    position: relative;
    bottom: 0px;
} */
.footer {
	position: absolute;
	bottom: 0px;
	left: 0px;
	width: 100%;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	text-decoration: none;
}

.footer-text {
	font-family: Arial, Helvetica, sans-serif;
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
	font-family: sans-serif;
}

.text-wrap {
	/* white-space: -moz-pre-wrap; */ /* Firefox */
	white-space: -o-pre-wrap; /* Opera */
	/* white-space: pre-wrap; */ /* Chrome */
	word-wrap: break-word; /* IE */
}

.border-right-none {
	border-right: none;
}

.border-top-none {
	border-top: none;
}

.border-bottom-none {
	border-bottom: none;
}

.border-left-none {
	border-left: none;
}

.border-bottom-1p {
	border-bottom: 1px solid #000;
}

.border-bottom-2p {
	border-bottom: 2px solid #000;
}

.b-none {
	border: none;
}

.bold {
	font-weight: bold;
}

.company-for-seal {
	font-size: 14px;
	font-weight: bold;
	padding-top: 25px;
	text-align: center;
}

.table-striped tbody td {
	height: 30px;
	padding: 3px;
}
/* .normal{
	font-size:14px;
} */
.normal {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 4pt;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	text-decoration: none;
}

.padding-top-20 {
	padding-top: 20px;
}

.detail-table-cell {
	font-family: Arial;
	FONT-SIZE: 4pt;
	color: black;
	background-color: #FFFFFF;
	padding: 1px;
	bordercolor: #000000;
	text-transform: uppercase;
}

.thead-bold {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 4pt;
	font-style: normal;
	font-weight: bold;
	color: #000000;
	text-decoration: none;
	padding-left: 6px;
}

.detail-table-font {
	font-size: 5px;
	font-family: arial;
}

@page :last { @bottom-center { content:"…";
	
}

#footer {
	display: table-footer-group;
	width: 100%;
	position: absolute;
	bottom: 0;
}
.new {
	margin-top: 5%;
	margin-left: 5%;
	margin-right: 5%;
}
</style>
<body>
<body>
<div class="new" style="border: 1px solid black">
	<c:set var="result" value="${WorkOrderdetail}" />
	<table class="width_100" align="center" border="0" cellPadding="0"
		cellSpacing="0">
		<tr>
			<td><br>
				<table border="0" class="padding-top-2" width="100%" cellpadding="0"
					cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">
					<tr>
						<td width="50%" style="text-align: center;">

							<table border="0" width="100%" cellpadding="0" cellspacing="0"
								bgcolor="FFFFFF" bordercolor="" align="center">
								<tr>
									<%-- <td width="25%"><img
											src="/img//${user.tenantId}HelpVideos/logo.jpg"
											style="padding: 10 0 0 10; height: 50px;"></td> --%>
									<td width="25%"
										style="float: left; padding-left: 100px; padding-right: 51px; padding-bottom: 50px;">
										<img src="/sampark/images/logo1.png">
									</td>
									<td width="75%" style="font-size: 11px;"><span
										style="text-align: center;">
										<h4 style="font-size: 1.3em; margin-top: 0px; margin-left: 22px;">
												Lalaji Memorial Omega International School<br>No:79,Omega
												School Road,<br>Kolappakkam,Chennai-600122,<br>State - Tamil Nadu, Code - 33
											</h4>
											<!-- <h2
												style="font-size: 1.3em; margin-top: -27px; margin-left: 22px;">LALAJI
												MEMORIAL OMEGA INTERNATIONAL SCHOOL</h2> -->
									</span> <!-- <span
											style="text-align: right;" style="font-size: 12px;"></span>  -->
										<br> <span style="text-align: right;"
										style="font-size: 12px;"></span></td>
									<!-- 		<td class= "bank-class" style=" padding-left: 400px; " >
                                        <p>'OUR GOAL IS YOUR GROWTH'</p>
                                       
                                           </td> -->
									<td width="75%" style="font-size: 5px;"><span
										style="text-align: left;"> <!-- 	<h1 style="
    padding-bottom: -18px;
    margin-left: -170px;
    margin-bottom: 10px;
">'OUR GOAL IS YOUR GROWTH'</h1> --></span> <!-- <span
											style="text-align: right;" style="font-size: 12px;"></span>  -->
										<br> <span style="text-align: right;"
										style="font-size: 12px;"></span> <br></td>
									<!-- 	<td width="75%" style="font-size: 14px;"><span style="text-align: center;"><h2>Our Goal is your Growth</h2></span> <br> <span
											style="text-align: right;" style="font-size: 12px;"></span> <br> <span
											style="text-align: right;" style="font-size: 12px;"></span> <br> </td> -->

								</tr>
							</table>
						</td>

					</tr>
					<tr>
					</tr>
				</table>
				<table width=100% align="center" border="1" cellPadding="0"
					cellSpacing="0" style="border-left: none; border-right: none;">
					<tr>
						<td><center>
								<font size="2" face="arial"><b>GATE PASS</b></font>
							</center></td>
					</tr>
				</table>
				<table width="50%"
					style="float: left; padding-top: 10px; padding-bottom: 15px;">
					<td class="width_40" style="font-size: 13px;"><b>REQUESTED
							DATE</b></td>
					<td style="font-size: 13px;">: <b>
							${result.requisitionDate} </b></td>
					</tr>
					<tr>
						<td class="width_40" style="font-size: 13px;"><b>SOURCE
								LOCATION</b></td>
						<td style="font-size: 13px;">: <b>
								${result.sourceLocation} </b></td>
					</tr>
					<tr>
						<td class="width_40" style="font-size: 13px;"><b>DESTINATION
								LOCATION</b></td>
						<td style="font-size: 13px;">: <b>
								${result.destinationLocation} </b></td>
					</tr>
					<tr>
						<td class="width_40" style="font-size: 13px;"><b>COST
								CENTER</b></td>
						<td style="font-size: 13px;">:<b> ${result.costcenter} </b>
						</td>
					</tr>

				</table>
				<table width="50%"
					style="float: left; padding-top: 10px; padding-bottom: 15px;">
					<tr>
						<td class="width_40" style="font-size: 13px;"><b>REQUESTED
								BY</b></td>
						<td style="font-size: 13px;">:<b> ${result.employeeId} </b></td>
					</tr>
					<tr>
						<td class="width_40" style="font-size: 13px;"><b>ORGANIZATION
								NAME</b></td>
						<td style="font-size: 13px;">:<b> ${result.companyId} </b>
						</td>
					</tr>
					<tr>
						<td class="width_40" style="font-size: 13px;"><b>REMARKS</b></td>
						<td style="font-size: 13px;">:<b> ${result.remarks} </b>
						</td>
					</tr>


				</table> <br> <br>


				<table width=100% align="center" border="1" cellPadding="0"
					cellSpacing="0" style="border-left: none; border-right: none;">
					<tr>
						<td><center>
								<font size="2" face="arial"><b>OUT</b></font>
							</center></td>
					</tr>
				</table> <br>
				<table class="table table-striped b-t b-light " align="left"
					border="1" bordercolor="" cellPadding="0" cellSpacing="0"
					width=100%>
					<thead>
						<tr>
							<th class="width_10" align="center" style="font-size: 13px;">ITEMNAME</th>
							<th class="width_10" align="center" style="font-size: 13px;">ITEM
								CATEGORY</th>
							<th class="width_10" align="center" style="font-size: 13px;">UOM
								MODE</th>
							<th class="width_10" align="center" style="font-size: 13px;">ITEM
								DESCRIPTION</th>
							<th class="width_10" align="center" style="font-size: 13px;">QUANTITY</th>
							<th class="width_10" align="center" style="font-size: 13px;">EDD
								DATE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="obj" items="${WorkOrderdetail.localDtl}">
							<tr>
								<td align="left" style="font-size: 13px;"><b>
										<c:out value="${obj.itemName}" />

								</b></td>
								<td align="right" style="font-size: 13px;"><b>
										<c:out value="${obj.itemCategory}" />
										</b> </td>
								<td align="right" style="font-size: 13px;"><b>
										 <c:out value="${obj.uom}" />

								</b></td>
								<td align="right" style="font-size: 13px;"><b>
										 <c:out value="${obj.description}" />

								</b></td>
								<td align="right" style="font-size: 13px;"><b> <c:out
											value="${obj.quantity}" />
								</b></td>
								<td align="right" style="font-size: 13px;"><b> <c:out
											value="${obj.eddDate}" />
								</b></td>
							</tr>
							<!-- <tr class="no-border">
							</tr> -->
						<%-- 	<c:out value="${obj}" /> --%>
						</c:forEach>
						 <tr>
							<td colspan="6"></td>

						</tr> 



					</tbody>

				</table> <br>

				<table width=100% align="center" border="1" cellPadding="0"
					cellSpacing="0" style="border-left: none; border-right: none;">
					
					<tr>
						<td><center>
								<font size="2" face="arial"><b>IN</b></font>
							</center></td>
					</tr>
				</table> <br>

				<table class="table table-striped b-t b-light " align="left"
					border="1" bordercolor="" cellPadding="0" cellSpacing="0"
					width=100%>
					<thead>
						<tr>
							<th class="width_10" align="center" style="font-size: 13px;">ITEMNAME</th>
							<!-- 							<th class="width_10" align="center" style="font-size: 13px;">ITEM
								CATEGORY</th>
							<th class="width_10" align="center" style="font-size: 13px;">UOM
								MODE</th> -->
							<th class="width_10" align="center" style="font-size: 13px;">ITEM
								DESCRIPTION</th>
							<th class="width_10" align="center" style="font-size: 13px;">QUANTITY</th>
							<!-- <th class="width_10" align="center" style="font-size: 13px;">EDD
								DATE</th> -->
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ob" items="${WorkOrderdetail.localDtl1}"
							varStatus="theCount">
							<tr>
								<td align="left" style="font-size: 13px;"><b>
										${ob.itemName} </b></td>
								<td align="right" style="font-size: 13px;"><b>
										${ob.description} </td>
								<td align="right" style="font-size: 13px;"><b>
										${ob.quantity} </b></td>

							</tr>
							<tr class="no-border">
							</tr>
						</c:forEach>
						<tr>
							<td colspan="3"></td>

						</tr>
					</tbody>

				</table> <br> <br> <br> <br></td>
		</tr>
	</table>
	</div>
	</body>
</html>