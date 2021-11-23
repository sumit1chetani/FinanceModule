
<style>
.ngdialog-overlay {
	
}

.ngdialog {
	z-index: 1000;
}

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 48%;
	position: absolute;
	top: 20%;
	left: 29%;
	margin: 0 auto;
}

#content{
 
    border: 2px solid #ffffff;
    padding: 25px; 
      
}

</style>

<div id="content" border="1" style="margin-bottom: 10px;width: 94%;
    margin-left: 25px;">
	
		 <table border="0" class="padding-top-2" width="100%" cellpadding="0"
			cellspacing="0" bgcolor="FFFFFF" align="center"
			style="border-left: none; border-right: none">
			<tr>
				<td width="50%" style="text-align: center;">

					<table border="0" width="100%" cellpadding="0" cellspacing="0"
						bgcolor="FFFFFF" align="center"
						style="border-left: none; border-right: none; margin-left: 0px;">
						<tr>
							<td width="25%"><img
								src="/img/MBKHelpVideos/mbk_image.png"
								style="padding: 10 0 0 10; height: 50px;"></td>

							<td width="75%" style="font-size: 14px;"><span
								style="text-align: center;"><b>MBK GLOBAL
										LOGISTICS PVT LTD</b></span> <br> <span style="text-align: right;"
								style="font-size: 12px;">{{header.branchAddress1}}&nbsp;{{header.branchAddress2}}</span>
								<br> <span style="text-align: right;"
								style="font-size: 12px;">{{header.branchAddress3}}</span> <br>
								<span style="text-align: right;" style="font-size: 12px;"><c:if
										test="{{header.branchGstno != ''}}">GSTNO:{{header.branchGstno}}</c:if></span></td>
							</td>

						</tr>
					</table>
				</td>

			</tr>
			<tr>
			</tr>
		</table>
		<br>
		<table width=100% align="center" border="1" cellPadding="0"
			style="border-left: none; border-right: none;" cellSpacing="0"
			style="border-left:none;border-right:none;margin-left: 0px;">
			<tr>
				<td><center>
						<font size="2" face="arial"><b>PROFORMA INVOICE</b></font>
					</center></td>
			</tr>
		</table>
		<table width="50%"
			style="float: left; padding-top: 10px; padding-bottom: 15px;">
			<tr>
				<td class="width_30" align="left" style="font-size: 10px;"><b>To</b></td>
			</tr>
			<tr>
				<td style="font-size: 10px;"><b>{{header.cutName}}</b></td>
			</tr>
			<tr>
				<td style="font-size: 10px;">{{header.custAddress1}}{{header.custAddress2}}{{header.custAddress3}}
				</td>
			</tr>
			<tr>
				<td align="left" style="font-size: 10px;">GST IN
					:{{header.gstNo}}</td>
			</tr>
			<c:if test="{{object2.shipperName !=null }}">
				<tr>
					<td class="width_30" align="left" style="font-size: 10px;"><b>Shipper
							Address</b></td>
				</tr>
				<tr>
					<td style="font-size: 10px;"><b>{{object2.shipperName}}<b></td>
				</tr>
				<tr>
					<td style="font-size: 10px;">{{object2.shipperAddress1}}{{object2.shipperAddress2}}{{object2.shipperAddress3}}
					</td>
				</tr>
			</c:if>
			<tr>
				<c:if test="{{object2.consigneeName !=null }}">
					<td class="width_30" align="left" style="font-size: 10px;"><b>Consignee
							Address</b></td>
				</c:if>
			</tr>
			<tr>
				<td style="font-size: 10px;"><b>{{object2.consigneeName}}<b></td>
			</tr>
			<tr>
				<td style="font-size: 10px;">{{object2.consigneeAddress1}}{{object2.consigneeAddress2}}{{object2.consigneeAddress3}}
				</td>
			</tr>
		</table>
		<table width="50%"
			style="float: left; padding-top: 10px; padding-bottom: 15px;">
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>DATE</b></td>
				<td style="font-size: 10px;">: {{header.purchaseInvoiceDate}}</td>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>SALES
						INVOICE NO</b></td>
				<td style="font-size: 10px;">: {{header.purchaseInvoiceNo}}</td>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>JOB NO</b></td>
				<td style="font-size: 10px;">: {{header.jobNo}}</td>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>HBL NO</b></td>
				<c:if test="{{header.hbl != null}}">
					<td style="font-size: 10px;">: {{header.hbl}}</td>
				</c:if>
				<c:if test="{{header.hbl == null}">
					<td style="font-size: 10px;">: &nbsp;&nbsp; -</td>
				</c:if>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>MBL NO</b></td>
				<c:if test="{{header.mbl != null}}">
					<td style="font-size: 10px;">: {{header.mbl}}</td>
				</c:if>
				<c:if test="{{header.mbl == null}">
					<td style="font-size: 10px;">: &nbsp;&nbsp; -</td>
				</c:if>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>POL</b></td>
				<td style="font-size: 10px;">: {{header.polName}}</td>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>POD</b></td>
				<td style="font-size: 10px;">: {{header.podName}}</td>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>FPOD</b></td>
				<td style="font-size: 10px;">: {{header.podName}}</td>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>SAILED
						DATE</b></td>
				<c:if test="{{header.sailedDate != null}}">
					<td style="font-size: 10px;">: {{header.sailedDate}}</td>
				</c:if>
				<c:if test="{{header.sailedDate == null}}">
					<td style="font-size: 10px;">: &nbsp;&nbsp; -</td>
				</c:if>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>ARRIVAL
						DATE</b></td>
				<c:if test="{{header.arrivalDate != null}}">
					<td style="font-size: 10px;">: {{header.arrivalDate}}</td>
				</c:if>
				<c:if test="{{header.arrivalDate == null}}">
					<td style="font-size: 10px;">: &nbsp;&nbsp; -</td>
				</c:if>
			</tr>
			<tr>
				<td class="width_40" style="font-size: 10px;"><b>VESSEL/VOYAGE</b></td>
				<c:if test="{{header.vessel != ''}}">
					<td style="font-size: 10px;">: {{header.vessel}}</td>
				</c:if>
				<c:if test="{{header.vessel == ''}}">
					<td style="font-size: 10px;">: &nbsp;&nbsp; -</td>
				</c:if>
			</tr>
			<!-- <tr><td class="width_40"  style="font-size: 10px;"><b>VOLUME</b></td><td style="font-size: 10px;">: </td></tr> -->
		</table>
		<table width=100% align="center" border="1" cellPadding="0"
			style="border-left: none; border-right: none;" cellSpacing="0"
			style="border-left:none;border-right:none;margin-left: 0px;">
			<tr>
				<td><center>
						<font size="2" face="arial">YOUR ACCOUNT HAS BEEN CREDITED
							TOWARDS THE FOLLOWING CHARGES.</font>
					</center></td>
			</tr>
		</table>
		<br>
		<table  width=100% align="center" border="1" cellPadding="0"
			style="float: left; padding-top: 10px; padding-bottom: 15px;" 
			 cellSpacing="0">
			<thead>
				<tr>
					<th class="width_10" align="center" style="font-size: 10px;">Charge
						Heads</th>
					<th class="width_6" align="center" style="font-size: 10px;">SAC
						NO</th>
					<th class="width_8" align="center" style="font-size: 10px;">QTY</th>
					<th class="width_5" align="center" style="font-size: 10px;">RATE</th>
					<th class="width_5" align="center" style="font-size: 10px;">CURRENCY</th>
					<th class="width_8" align="center" style="font-size: 10px;">EX-RATE</th>									
					<th class="width_12" align="center" style="font-size: 10px;">TOTAL(USD)</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="x in listdata">
					<td align="left" style="font-size: 10px;">{{ x.accountHeadCode }}</td>
					<td ng-if="x.sacNo == 0" align="left" style="font-size: 10px;"></td>
					<td ng-if="x.sacNo != 0" align="left" style="font-size: 10px;">{{ x.sacNo }}</td>
					<td align="right" style="font-size: 10px;">{{ x.qty }}</td>
					<td align="right" style="font-size: 10px;">{{ x.rate }}</td>
					<td align="right" style="font-size: 10px;">USD</td>
					<td align="right" style="font-size: 10px;">{{ x.exchangeRate }}</td>					
					<td align="right" valign="right" style="font-size: 10px; "type="number" >{{ x.subTotal | number : 2 }}</td>
					
				</tr>				
				<tr>
					<td colspan="6"></td>				
									
					<td align="right" valign="right" style="font-size: 10px;" colspan="2">{{header.totalAmount}}</td>
				</tr>
			</tbody>
			<table style="font-size: 12px;">

				<tbody>
					<c:if test="{{containerDetails.conlist !=null}}">
						<td>Containers:</td>
					</c:if>
					<c:forEach var="ob" items="{{containerDetails.conlist}}"
						varStatus="theCount">

						<td>{{ob.containerNo}}&nbsp;</td>
					</c:forEach>
				</tbody>
			</table>

			<table style="font-size: 12px;">

				<tr>
					<td><b>Amount in Words: {{header.totalAmountInWords}}</b></td>
					<br>
				</tr>
				<tr>
					<td>Please issue all payment in favour of &nbsp;"MBK GLOBAL
						LOGISTICS PVT LTD"</td>
				</tr>
			</table>
		</table>
		<div>
			<table style="font-size: 10px;">
				<tr>
					<td>BANK
						DETAILS&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp{{header.bankName}}</td>
				</tr>
				<tr>
					<td>ADDRESS&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp{{header.bankAddress}}</td>
				</tr>
				<tr>
					<td>ACCOUNT NO
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp{{header.bankAcct}}</td>
				</tr>
				<tr>
					<td>SWIFT
						CODE&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp{{header.bankSwift}}
					</td>
				</tr>
				<tr>
					<td>IFSC
						CODE&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp{{header.bankifsc}}</td>
				</tr>
				<tr>
					<td>PAN
						NO&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp{{header.branchPan}}</td>
				</tr>
				<tr>
					<td>SERVICE TAX NO&nbsp:&nbsp&nbsp{{header.branchSrvctax}}</td>
				</tr>
				<tr>
					<td>GSTN
						IN&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp{{header.branchGstno}}</td>
				</tr>
			</table>
			<br> <font size="1" face="arial"><b>FOR MBK GLOBAL
					LOGISTICS PVT LTD (ADMIN)</b></font><br>
			<font size="1" face="arial"> Remarks :{{header.remarks}}</font> <br>
			<br>
			<br>
			<table border=0 bordercolor="" cellspacing="0" cellpadding="2"
				align="center">
				<tr>
					<td align="center"><span class=footer-text><center>
								This is a Computer Generated Invoice and does not require
								physical signature.</center> </span></td>
				</tr>
			</table>
			<div class="row">
				<div class="col-md-12" align="center">

					<button class="btn btn-danger" ng-click="cancelng()" type="button">Cancel</button>
					<button class="btn btn-success" type="button" ng-click="emailUsdForm(purchaseInvoiceForm,purchaseInvoiceData)">
					<i class="fa fa-print"></i> Send </button>
				</div>
			</div>
		</div> 

</div>


