<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="bunkerRequestData" value="${headerDetails}" />

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
</style>
</head>

<body>
	<img src="${context}/img/interafrica_new.png" style="width: 236px; height: 126px;">

	<table id="table1" border="0" cellPadding="0" cellSpacing="0"
		bgcolor="FFFFFF" align="right">
		<tr>

			<td><span style="text-align: left;"><b>Interafrica
						Haulage Services Ltd</b></span> <br> <span style="text-align: left;">81250-80100
					Mombasa </span> <br> <span style="text-align: left;">Mombasa -
					Nairobi Highway </span> <br> <span style="text-align: left;">Mombasa
			</span> <br> <span style="text-align: left;">E-Mail :
					accts@interafrica-haulage.com </span></td>
		</tr>
	</table>
		
	<h2 style="text-align: center;">Fuel Voucher</h2>
	<br>
	<br>
	<p style="text-align: left;"> Entry No. : <b>${bunkerRequestData.entryNo}</b>  <span style="padding-left: 450px;">Date : ${bunkerRequestData.date}</span></p>
	
	<%-- <span style="text-align: left; font-size: 25px; font-style:normal; padding-left: 15px">
		Entry No. : <b>${bunkerRequestData.entryNo}</b>
	</span> --%>
	<%-- <span style="text-align: right; font-size: 25px; font-style:normal;"> Date :
		${bunkerRequestData.date}</span> --%>	
	<br>

	<table id="table2">
		<tr>
			<td>To</td>
			<td>${bunkerRequestData.vendorName}</td>

		</tr>
		<tr>
			<td>Units(Liters)</td>
			<td>${bunkerRequestData.liters}&nbsp;&nbsp;
				${bunkerRequestData.fuel}</td>

		</tr>
		<tr>
			<td>Truck No.</td>
			<td>${bunkerRequestData.truckNo}</td>

		</tr>
		<tr>
			<td>Destination</td>
			<td>${bunkerRequestData.toLocation}</td>

		</tr>
		<tr>
			<td>Authorised By</td>
			<td>${bunkerRequestData.authorisedBy}</td>

		</tr>
		<tr>
			<td>Signature</td>
			<td></td>

		</tr>
		<tr>
			<td>Driver's Name</td>
			<td>${bunkerRequestData.driversName}</td>

		</tr>
		<tr>
			<td>Driver's Signature</td>
			<td></td>

		</tr>
	</table>


	<%-- <table style="width: 100%" border="1">
		<!-- <tr>
			<th>Name</th>
			<th colspan="2">Mobile No.</th>
		</tr>
		<tr>
			<td>Ajeet Maurya</td>
			<td>7503520801</td>
			<td>9555879135</td>
		</tr> -->
		<tr>
			<th>To
			<td style="text-align: center;">${bunkerRequestData.vendorName}
		</tr>
		<tr>
			<th>Units
			<td style="text-align: center;">${bunkerRequestData.liters}&nbsp;&nbsp;${bunkerRequestData.fuel}
		</tr>
		<tr>
			<th>Truck No.
			<td style="text-align: center;">${bunkerRequestData.truckNo}
		</tr>
		<tr>
			<th>Authorised By.
			<td style="text-align: center;">${bunkerRequestData.authorisedBy}
		</tr>
		<tr>
			<th>Signature
			<td style="text-align: center;">
		</tr>
		<tr>
			<th>Driver's Name
			<td style="text-align: center;">${bunkerRequestData.driversName}
		</tr>
		<tr>
			<th>Driver's Signature
			<td style="text-align: center;">
		</tr>
	</table> --%>


	<%-- <span style="float: left; font-size: 25px; padding-left: 15px"> To: ${bunkerRequestData.vendorName} </span>
	<br><br>
	<span style="float: left; font-size: 25px; padding-left: 15px"> Units : ${bunkerRequestData.liters} </span><span style="float: left; font-size: 25px; padding-left: 20px"">${bunkerRequestData.fuel}</span>
	<br><br>
	<span style="float: left; font-size: 25px; padding-left: 15px"> Truck No. : ${bunkerRequestData.truckNo} </span>
	<br><br>
	<span style="float: left; font-size: 25px; padding-left: 15px"> Authorised  By.: ${bunkerRequestData.authorisedBy} </span>
	<br><br>
	<span style="float: left; font-size: 25px; padding-left: 15px"> Signature    :</span>
	<br><br>
	<span style="float: left; font-size: 25px; padding-left: 15px"> Driver's Name: ${bunkerRequestData.driversName} </span>
	<br><br>
	<span style="float: left; font-size: 25px; padding-left: 15px"> Driver's Signature :</span>
	<br><br> --%>

	<%-- <table border="0" align="center">
		<table cellpadding="0" cellspacing="0" border="0" style="empty-cells: show; width: 800px; border-collapse: collapse; background-color: white; margin-top: 5px;" align="center">
			<tbody>							
				<tr valign="top" style="height: 25px">
					<td><span style="float: left; font-size: 20px;"> Entry
							No. :<h4> ${bunkerRequestData.entryNo} </h4></span></td>
					<td><span style="font-size: 25px;" align="right"> Date
							: ${bunkerRequestData.date} </span></td>
				</tr>
				<tr valign="top" style="height: 10px">
					<td>
						<table border="0" cellpadding="0" cellspacing="0" width=100%
							style="margin-top: 5%">
							<thead>

								<tr>
									<td style="height: 25px; border-bottom: 0px;"><span
										style="float: left; font-size: 25px;">
											To:&nbsp;&nbsp;${bunkerRequestData.vendorName}
											&nbsp;&nbsp;&nbsp;</span><br> <br>
									<br>
									<span style="float: left; font-size: 25px;">
											Units:&nbsp;&nbsp;${bunkerRequestData.entryNo}
											&nbsp;&nbsp;&nbsp;</span> <span
										style="float: left; font-size: 25px;">${bunkerRequestData.fuel}
									</span> <br> <br>
									<br> <span style="font-size: 25px; float: left">
											Truck No.: &nbsp;&nbsp;&nbsp;</span> <span
										style="font-size: 25px; float: left">${bunkerRequestData.truckNo}
									</span> <br>
									<br> <br> <span style="font-size: 25px; float: left">Destination:
											&nbsp;&nbsp;&nbsp;</span> <span style="font-size: 25px; float: left">${bunkerRequestData.toLocation}
									</span> <br>
									<br> <br> <span style="font-size: 25px; float: left">Authorised
											By. :&nbsp;&nbsp;&nbsp;</span> <span
										style="font-size: 25px; float: left">${bunkerRequestData.authorisedBy}
									</span><br>
									<br> <br> <span style="font-size: 25px; float: left">Signature
											:&nbsp;&nbsp;&nbsp;</span> <span
										style="font-size: 25px; float: left"> </span><br>
									<br> <br> <span style="font-size: 25px; float: left">Driver's
											Name :&nbsp;&nbsp;&nbsp;</span> <span
										style="font-size: 25px; float: left">${bunkerRequestData.driversName}
									</span> <br>
									<br> <br> <span style="font-size: 25px; float: left">Driver's
											Signature :&nbsp;&nbsp;&nbsp;</span> <span
										style="font-size: 25px; float: left"> </span> <br>
									<br></td>
								</tr>
							</thead>
						</table>
					</td>
				</tr>
			</tbody>
		</table>



	</table>  --%>

</body>
</html>




