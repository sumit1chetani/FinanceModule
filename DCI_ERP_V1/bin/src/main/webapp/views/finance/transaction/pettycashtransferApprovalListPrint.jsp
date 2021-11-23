<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="bunkerRequestData" value="${headerDetails}" />
<html>
<head>

<style media="print">
.header_label {
	font-family: Old English;
	color: #000000;
	font-size: 18px;
	line-height: 2.1499023;
	font-weight: bold;
}

.certificate_content_label {
	font-family: Old English;
	color: #000000;
	font-size: 18px;
	line-height: 2.1499023;
	font-weight: normal;
}

.college_header {
	font-family: Old English;
	color: #000000;
	font-size: 32px;
	line-height: 1.1499023;
	font-weight: bold;
	font-style: normal;
}

.header {
	font-family: Old English;
	color: #000000;
	font-size: 30px;
	line-height: 1.1499023;
	font-weight: bold;
	font-style: italic;
}

.conatainer_detail {
	font-family: Helvetica;
	color: #000000;
	font-size: 20px;
	line-height: 1.1640625;
	font-style: italic;
}

.table_detail {
	font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif;
	color: #000000;
	font-size: 10px;
	line-height: 1.1640625;
	padding-left: 5px;
}

tr.border_bot td {
	border-bottom: 1px solid black;
}

@page {
	size: A4 landscape;
	margin: 0mm;
}

@media print {
	table.page-break {
		page-break-after: always;
	}
}
</style>
</head>

<center>
<h1>Petty Cash Transfer for your Approval</h1>
</center>
<br><br><br><br><br><br>
	<table border="0" align="center">
	<thead style="border: 1px solid #000;background:#19a9d5; color: #fff;font-size: 12px;"><tr>
					<th style="padding: 10px; background-color: #42A5F5;">Transfer From</th>
					<th style="padding: 10px; background-color: #42A5F5;">Transfer Date</th>
					<th style="padding: 10px; background-color: #42A5F5;">Amount</th>
					<th style="padding: 10px; background-color: #42A5F5;">Status</th>
					
														
                    </thead>

<tbody style="background: #efeded">			
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${bunkerRequestData.transferFromName}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${bunkerRequestData.transferDate}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${bunkerRequestData.amount}</td>
			<td style="padding: 6px;font-size: 14px;text-align: center;color: #000;">${bunkerRequestData.status}</td>



			</tbody>
		
	</table>

</html>


<%-- <tbody>
			<tr>
				<td align="center">
					<table cellpadding="0" cellspacing="0" border="0"
						style="empty-cells: show; width: 800px; border-collapse: collapse; background-color: white; margin-top: 5px;">
						<tbody>
							<tr valign="top" style="height: 10px">
								<td>
									<table border="0" cellpadding="0" cellspacing="0" width=100%>
										<tbody>
											<tr>												
												<td
													style="height: 25px; border-bottom: 0px; margin-right: 30px; text-align: center;">
													<span class="college_header">
														${bunkerRequestData.entryNo}<br>
												</span>
												</td>
											</tr>
											<tr class="border_bot"></tr>
										</tbody>
									</table>
									<table border="0" cellpadding="0" cellspacing="0" width=100%>
										<tbody>
											<tr>
												<td style="text-align: center; height: 25px; font-size: 30px;"><span
													style="margin-left: 120px"> <b>Fuel Voucher Details for your Approval</b></span></td>

											</tr>
											<tr class="border_bot">
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							 <tr valign="top" style="height: 10px">
								<td></td>
							</tr> 													
							 <tr valign="top" style="height: 25px">
							<td><span style="float: left; font-size: 20px;">
										NO. : ${bunkerRequestData.toname} </span></td>
								<td><span style="float: right; font-size: 20px;">
										Date : ${bunkerRequestData.date} </span></td>
							</tr> -

							 <tr valign="top" style="height: 10px">
								<td>
									<table border="0" cellpadding="0" cellspacing="0" width=100%
										style="margin-top: 5%">
										<thead>
											<tr>
												<td style="height: 25px; border-bottom: 0px;"><span
													style="font-size: 25px; float: left">Liters:</span> <span
													style="font-size: 25px; float: left">${bunkerRequestData.liters}
												</span> <br> <br> <span
													style="font-size: 25px; float: left">Please Fuel Truck No.:
														&nbsp;&nbsp;&nbsp;</span> <span
													style="font-size: 25px; float: left">${bunkerRequestData.truckno}
												</span> <br> <br> <span
													style="font-size: 25px; float: left">Destination:
														&nbsp;&nbsp;&nbsp;</span> <span
													style="font-size: 25px; float: left">${bunkerRequestData.destination}
												</span> <br> <br> <span
													style="font-size: 25px; float: left">Authorised By.
														:&nbsp;&nbsp;&nbsp;</span> <span
													style="font-size: 25px; float: left">${bunkerRequestData.description}
												</span><br><br>
												<span
													style="font-size: 25px; float: left">Signature
														:&nbsp;&nbsp;&nbsp;</span> <span
													style="font-size: 25px; float: left">${fuelvoucher.description}
												</span><br><br>
												<span
													style="font-size: 25px; float: left">Driver's Name
														:&nbsp;&nbsp;&nbsp;</span> <span
													style="font-size: 25px; float: left">${fuelvoucher.driversname}
												</span>	<br><br>
												<span
													style="font-size: 25px; float: left">Driver's Signature
														:&nbsp;&nbsp;&nbsp;</span> <span
													style="font-size: 25px; float: left">${fuelvoucher.description}
												</span>													
											<br></td>
											</tr>											
										</thead>
									</table>
								</td>
							</tr> 						
						</tbody>
					</table>
				</td>
			</tr>
		</tbody> --%>
