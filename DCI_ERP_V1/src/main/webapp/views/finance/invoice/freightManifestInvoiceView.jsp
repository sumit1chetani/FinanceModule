 <style>
 .ngdialog-overlay{
 
 }
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	    max-width: 100%;
    width: 100%;
    position: absolute;
    top: 2%;
    left: 0%;
    margin: 0 auto;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		 
		<div class="panel panel-default">

			<div class="panel-body">
				<form class="form-horizontal" name="billAddForm" role="form">
					<div class="row book-widget-row">
						<div class="col-sm-12 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">

									<label class="col-md-6 control-label">Location </label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.locationName"> </label>



								</div>


								<div class="form-group">
									<label class="col-md-6 control-label">Invoice No </label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.invoiceno"> </label>

								</div>

								<div class="form-group">
									<label class="col-md-6 control-label">Vessel</label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.vessel"> </label>
								</div>
								<div class="form-group">
									<label class="col-md-6 control-label">Voyage </label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.voyage"> </label>
								</div>
								
						         <div class="form-group">
									<label class="col-md-6 control-label">Pol </label>  <label
										class="col-md-6 text-left control-label" 
										ng-bind="viewInvoiceHeader.pol"></label>

								</div>

								<div class="form-group">
									<label class="col-md-6 control-label">Quot. Valid from </label>  <label
										class="col-md-6 text-left control-label" 
										ng-bind="viewInvoiceHeader.quotValidFrom"></label> 

								</div>
							</fieldset>
						</div>
						<div class="col-sm-12 col-md-4 col-lg-4">
							<fieldset>
							
								<div class="form-group">
									<label class="col-md-6 control-label">BL No </label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.blno"> </label>

								</div>							

								<div class="form-group">
									<label class="col-md-6 control-label">Date </label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.invoiceDate"> </label>

								</div>

								<div class="form-group">
									<label class="col-md-6 control-label">Quot. No </label><a href="#/quotation/view/{{viewInvoiceHeader.quotNo}}"><label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.quotNo"> </label></a>

								</div>
								<div class="form-group">
									<label class="col-md-6 control-label">Currency</label><label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.currency"> </label> </label>
								</div>
								<div class="form-group">
									<label class="col-md-6 control-label">Pod </label>  <label
										class="col-md-6 text-left control-label" 
										ng-bind="viewInvoiceHeader.pod"></label>
								</div>							
								<div class="form-group">
									<label class="col-md-6 control-label">Quot. Valid To  </label>  <label
										class="col-md-6 text-left control-label" 
										ng-bind="viewInvoiceHeader.quotValidTo"></label>
								</div>								
							</fieldset>
						</div>
						<div class="col-sm-12 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label class="col-md-6 control-label">Cust.</label><label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.customer"> </label> </label>
								</div>
								<div class="form-group">
									<label class="col-md-6 control-label">Payer </label>  <label
										class="col-md-6 text-left control-label" 
										ng-bind="viewInvoiceHeader.agent"></label>
								</div>							
								<div class="form-group">
									<label class="col-md-6 control-label">Ex. Rate </label>  <label
										class="col-md-6 text-left control-label" 
										ng-bind="viewInvoiceHeader.exchangeRate"></label>
								</div>
							</fieldset>
						</div>	
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12">
								<fieldset>	
									<div class="form-group">
										<label class="col-md-2 control-label">Quot. Remarks </label>  <label
											class="col-md-10 text-left control-label" 
											ng-bind="viewInvoiceHeader.remarks"></label>
									</div>
								</fieldset>
						</div>	
					</div>
					<div class="table-responsive">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>

									<th colspan="2" rowspan="2" class="text-center" valign="top">Charges</th>
									<!--  <th colspan="2" ng-repeat="objCont in containersList" class="text-center">{{objCont.containerType}} </th>  -->
									<th colspan="2" class="text-center" valign="top">M20</th>
									<th colspan="2" class="text-center" valign="top">M40</th>
									<th colspan="2" class="text-center" valign="top">M45</th>

									<th colspan="2" class="text-center" valign="top">D20</th>
									<th colspan="2" class="text-center" valign="top">D40</th>
									<th colspan="2" class="text-center" valign="top">D45</th>

									<th colspan="2" class="text-center" valign="top">R20</th>
									<th colspan="2" class="text-center" valign="top">R40</th>

									<th colspan="2" class="text-center" valign="top">OOG20</th>
									<th colspan="2" class="text-center" valign="top">OOG40</th>

									<th colspan="2" class="text-center" valign="top">RI20</th>
									<th colspan="2" class="text-center" valign="top">RI40</th>
									
									<th colspan="2" class="text-center" valign="top">FLEXI 20</th>
									<th colspan="2" class="text-center" valign="top">FLEXI 40</th>
									
									
									<th colspan="2" class="text-center" valign="top">IM51 20</th>
									<th colspan="2" class="text-center" valign="top">IM51 40</th>
									
									<!-- <th colspan="2" class="text-center" valign="top">OOG SL</th> -->

									<th rowspan="2" colspan="2" class="text-center" valign="top">MT
										Qty.</th>
									<th rowspan="2" colspan="2" class="text-center" valign="top">MT
										Amt.</th>

									<th rowspan="2" colspan="2" class="text-center" valign="top">LDN
										Qty.</th>
									<th rowspan="2" colspan="2" class="text-center" valign="top">LDN
										Amt.</th>

									<th rowspan="2" colspan="2" class="text-center" valign="top">Total
										Qty.</th>

									<th rowspan="2" colspan="2" class="text-center" valign="top">Total Local
										</th>
									<th rowspan="2" colspan="2" class="text-center" valign="top">Total
										USD</th>	

								</tr>
								<tr class="width_20">

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>
									
									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>									

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>


									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>


									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>
									
									
									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>
									
									
									<th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>

									<!-- <th colspan="2">
										<table style="width: 130%">
											<tr>
												<th class="width_8 text-center">Qty</th>&nbsp;
												<th class="width_8 text-center">Rate</th>
											</tr>
										</table>
									</th>	 -->																	



								</tr>
								
							</thead>
							<tbody>
								<tr ng-repeat="objItem in viewInvoiceHeaderDtl">



									<td class="sorting width_10" ng-bind="objItem.slNo"></td>
									<td class="sorting width_250" ng-bind="objItem.surName"></td>

									<td class="sorting width_15" ng-bind="objItem.m20"></td>
									<td class="sorting width_15" ng-bind="objItem.m20rate"></td>

									<td class="sorting width_15" ng-bind="objItem.m40"></td>
									<td class="sorting width_15" ng-bind="objItem.m40rate"></td>


									<td class="sorting width_15" ng-bind="objItem.m45"></td>
									<td class="sorting width_15" ng-bind="objItem.m45rate"></td>


									<td class="sorting width_15" ng-bind="objItem.d20"></td>
									<td class="sorting width_15" ng-bind="objItem.d20rate"></td>

									<td class="sorting width_15" ng-bind="objItem.d40"></td>
									<td class="sorting width_15" ng-bind="objItem.d40rate"></td>


									<td class="sorting width_15" ng-bind="objItem.d45"></td>
									<td class="sorting width_15" ng-bind="objItem.d45rate"></td>

									<td class="sorting width_15" ng-bind="objItem.r20"></td>
									<td class="sorting width_15" ng-bind="objItem.r20rate"></td>

									<td class="sorting width_15" ng-bind="objItem.r40"></td>
									<td class="sorting width_15" ng-bind="objItem.r40rate"></td>

									<td class="sorting width_15" ng-bind="objItem.oog20"></td>
									<td class="sorting width_15" ng-bind="objItem.oog20rate"></td>


									<td class="sorting width_15" ng-bind="objItem.oog40"></td>
									<td class="sorting width_15" ng-bind="objItem.oog40rate"></td>

									<td class="sorting width_15" ng-bind="objItem.rI20"></td>
									<td class="sorting width_15" ng-bind="objItem.rI20rate"></td>

									<td class="sorting width_15" ng-bind="objItem.rI40"></td>
									<td class="sorting width_15" ng-bind="objItem.rI40rate"></td>
									
									<td class="sorting width_15" ng-bind="objItem.flexi20"></td>
									<td class="sorting width_15" ng-bind="objItem.flexi20rate"></td>
									
									<td class="sorting width_15" ng-bind="objItem.flexi40"></td>
									<td class="sorting width_15" ng-bind="objItem.flexi40rate"></td>									
									
									<td class="sorting width_15" ng-bind="objItem.im5120"></td>
									<td class="sorting width_15" ng-bind="objItem.im5120rate"></td>	
									
									<td class="sorting width_15" ng-bind="objItem.im5140"></td>
									<td class="sorting width_15" ng-bind="objItem.im5140rate"></td>	
									
									<!-- <td class="sorting width_15" ng-bind="objItem.oogSl"></td>
									<td class="sorting width_15" ng-bind="objItem.oogSlrate"></td> -->																										


									<td  colspan="2" class="width_1" ng-bind="objItem.mtQty"></td>
									<td  colspan="2" class="width_1" ng-bind="objItem.mtAmt"></td>
                                    
                                    <td  colspan="2" class="width_1" ng-bind="objItem.ldnQty"></td>
									<td  colspan="2" class="width_1" ng-bind="objItem.ldnAmt"></td>
									
									<td  colspan="2" class="width_1" ng-bind="objItem.totQty"></td>
									<td  colspan="2" class="width_1" ng-bind="objItem.totalLocalAmt"></td>
									<td  colspan="2" class="width_1" ng-bind="objItem.totalAmt"></td>
								</tr>
							</tbody>					
</table>
					</div>


					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-danger" ng-click="close()" type="button">
									<i class="fa fa-close"></i> Close
								</button>
								<!-- <button class="btn btn-success" type="button" ng-click="clickInvoiceFunction(viewInvoiceHeader.invoiceno,'both')">
									<i class="fa fa-print"></i> Print Both
								</button>
								<button class="btn btn-success" type="button" ng-click="clickInvoiceFunction(viewInvoiceHeader.invoiceno,'usd')">
									<i class="fa fa-print"></i> Print USD
								</button>
								<button class="btn btn-success" type="button" ng-click="clickInvoiceFunction(viewInvoiceHeader.invoiceno,'local')">
									<i class="fa fa-print"></i> Print Local
								</button>	 -->															
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
