<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<style>
.header_label {
	font-family: sans-serif;
	color: #000000;
	font-size: 20px;
	line-height: 1.1499023;
	font-weight: bold;
}

.table_header_label {
	font-family: sans-serif;
	color: #000000;
	font-size: 14px;
	line-height: 1.1499023;
	font-weight: normal;
}

.conatainer_detail {
	font-family: sans-serif;
	color: #000000;
	font-size: 12px;
	line-height: 1.1640625;
}

.table_detail {
	font-family: sans-serif;
	color: #000000;
	font-size: 12px;
	line-height: 1.1640625;
	padding-left: 5px;
}

tr.border_bot td {
	border-bottom: 1px solid black;
}

@page {
	size: auto; /* auto is the initial value */
	margin: 0mm; /* this affects the margin in the printer settings */
}
</style>
</head>
<body text="#000000" link="#000000" alink="#000000" vlink="#000000">
	<c:set var="vehicleReport" value="${headerDetails}" />
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tbody>
			<tr>
				<td align="center">
					<table cellpadding="0" cellspacing="0" border="0"
						style="empty-cells: show; width: 595px; border-collapse: collapse; background-color: white;">
						<tbody>							
							<tr class="border_bot">
								<td
									style="text-align: center; border-top: 0px; border-left: 0px; border-right: 0px; height: 25px;">
									<span class="header_label" style="font-size: 18px;">Tax Type</span>
								</td>
							</tr>
							<tr valign="top" style="height: 25px">
							</tr>
							<tr valign="top" style="height: 10px">
								<td>
									<table border="1" cellpadding="0" cellspacing="0" width=100%>
										<thead>
											<tr>
												<th height="25" style="width: 75px;"><span
													class="table_header_label">Type Code</span></th>
												<th height="25" style="width: 75px;"><span
													class="table_header_label">Type Name</span></th>
												<th height="25" style="width: 90px;"><span
													class="table_header_label">Type Ledger Name</span></th>
												<th height="25" style="width: 90px;"><span
													class="table_header_label">Branch</span></th>
												<th height="25" style="width: 90px;"><span
													class="table_header_label">Tax in %</span></th>
												<th height="25" style="width: 90px;"><span
													class="table_header_label">Charge Head</span></th>
										</thead>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table border="0" cellpadding="0" cellspacing="0" width=100%>
										<tbody>
											<c:forEach var="vehicleReport" items="${billDetails}">
												<tr style="height: 5px">
													<td height="35" style="width: 75px;"><span
														class="table_detail"><c:out
																value="${vehicleReport.code}" /></span></td>
													<td height="35" style="width: 75px;"><span
														class="table_detail"> <c:out
																value="${vehicleReport.name}" /></span></td>
													<td height="35" style="width: 90px;"><span
														class="table_detail"> <c:out
																value="${vehicleReport.lname}" /></span></td>
													<td height="35" style="width: 90px;"><span
														class="table_detail"> <c:out
																value="${vehicleReport.branchname}" />
													</span></td>
													<td height="35" style="width: 90px;"><span
														class="table_detail"> <c:out
																value="${vehicleReport.taxp}" />
													</span></td>
													<td height="35" style="width: 90px;"><span
														class="table_detail"> <c:out
																value="${vehicleReport.chargeHeads}" />
													</span></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</td>
							</tr>
							<tr class="border_bot">
								<td></td>
							</tr>
							
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html> --%>


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
@page { size: auto;  margin: 5mm; }
#table2, td, th {
	border: 1px solid #ddd;
	text-align: left;
}

#table2 {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 15px;
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
</head>

<body>
<input type="hidden" value="${user.tenantId}" id="tenantId">
	<c:set var="hdr" value="${billDetails}" />

<table > 

						 <table border="1" class="padding-top-2" width="100%"
						cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor=""
						align="center">
						<tr>
							<td >
							
							<table border="0" width="100%" cellpadding="0" cellspacing="0" bgcolor="FFFFFF" bordercolor="" align="center">
							<tr>
								<td width="25%"><img src="/img/logo.jpg" style=" padding:10 0 0 10; height: 60px;">
								</td>
									
								<td width="75%"> <span style="text-align: right;text-transform: uppercase;"><b>${user.tenantId} GLOBAL LOGISTICS PVT LTD</b></span>
							 </tr>
							 </table>
							</td>
							
						</tr>
						<tr>
						</tr>
					</table>  

						<tr>
						</tr>
					</table> 
					
 <c:set var="bean" value="${billDetails}" />
	<br><br><center><font size="3" face="arial"><b>Tax Type</b></font></center>

	
	
	<br><br><table class="table table-striped b-t b-light padding-top-10"
						align="left" border="1" bordercolor="black" cellPadding="0"
						cellSpacing="0" width=100%>
						<thead>
							<tr>
								<th class="width_20" align="center"><span
									class="thead-bold">Type Code</span></th>
								<th class="width_20" align="center"><span
									class="thead-bold">Type Name</span></th>
								<th class="width_20" align="center"><span
									class="thead-bold">Type Ledger Name</span></th>
								<th class="width_20" align="center"><span
									class="thead-bold">Branch</span></th>
								<th class="width_20" align="center"><span
									class="thead-bold">Tax in %</span></th>
									<th class="width_20" align="center"><span
									class="thead-bold">Charge Head</span></th>									
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ob"
								items="${billDetails}"
								varStatus="theCount">
								<tr>
									<td class="subcolor width_20 detail-table-cell" align="center"
										valign="top"><font face="arial" size="2">${ob.code}</font></td>
									
									
									<td class="subcolor width_20 text-wrap detail-table-cell"
										align="center" valign="middle"><span
										class="detail-table-font w-s-no">${ob.name} </span></td>
									<td class="subcolor width_20 detail-table-cell" align="center">
										<span class="detail-table-font">${ob.lname} </span>
									</td>
									<td class="subcolor width_20 detail-table-cell" align="center">
										<span class="detail-table-font">${ob.branchname} </span>
									</td>
									<td class="subcolor width_20 detail-table-cell" align="center">
										<span class="detail-table-font">${ob.taxp} </span>
									</td>
									<td class="subcolor width_20 detail-table-cell" align="center">
										<span class="detail-table-font">${ob.chargeHeads} </span>
									</td>
								</tr>
							</c:forEach> 
					</tbody>
					</table>
					<table><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr></table>
						
					<table><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr></table>


</body>
</html>




