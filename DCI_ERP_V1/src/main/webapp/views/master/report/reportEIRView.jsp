<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="reportEIRForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<div class="col-sm-12">
								<div class="col-sm-6">
									<div class="form-group">
										<label class="col-md-4 control-label p-l-0"> EIR No. 
										</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												validation="required" friendly-name="eirNo" maxlength="10"
												ng-model="reportEir.eirNo" name="eirNo" id="eirNo" disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label  vessel-text">Trip
											
										</label>
										<div class="col-md-8">
											<selectivity list="lTripList" property="reportEir.tripId" 
												id="tripId" disabled = "true"></selectivity>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label  vessel-text">Truck
											
										</label>
										<div class="col-md-8">
											<selectivity list="lTruckList" property="reportEir.truck" disabled = "true"
												id="truck" disabled></selectivity>
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label p-l-0"> Driver
											Name 
										</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												validation="required" friendly-name="driverName"
												maxlength="25" ng-model="reportEir.driverName"
												name="driverName" id="driverName" disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label p-l-0"> Driver ID
											
										</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												maxlength="25" friendly-name="driverID"
												ng-model="reportEir.driverID" name="driverID" id="driverID"
												disabled>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Shipping Line</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												friendly-name="Shipping Line" maxlength="25"
												ng-model="reportEir.shippingLine" name="shippingLine"
												id="shippingLine" disabled>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">OffLoad SNO. </label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												friendly-name="OffLoad SNO" ng-model="reportEir.offloadSno"
												maxlength="25" name="offloadSno" id="offloadSno" disabled>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Container No. </label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												friendly-name="Container No" maxlength="50"
												ng-model="reportEir.containerNo" name="containerNo"
												id="containerNo" disabled>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">ISO </label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												friendly-name="ISO" ng-model="reportEir.iso" name="iso"
												maxlength="25" id="iso" disabled>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Size </label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												friendly-name="Size" ng-model="reportEir.size" name="size"
												maxlength="25" id="size" disabled>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Type </label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												friendly-name="Type" ng-model="reportEir.type" name="type"
												maxlength="25" id="type" disabled>
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label">EIR Document
											Upload</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">


												<div id="image-holder"></div>
												<!-- <input type="file" class="form-control"
													name="uploadDocument" friendly-name="Document"
													ng-model="reportEir.eirDocUrl" id="fileUpload"
													onchange="angular.element(this).scope().uploadDoc(this)"
													accept=".jpg,.pdf,.png" />  -->

											</div>
											<!-- <button class="col-sm-4" style="margin-top: 2%"
												ng-click="fileUpload()">Upload</button> -->
											<a id="fileExport" class="link"
												href="{{reportEir.eirDocUrl}}" download>
												<button class="col-sm-4" style="margin-top: 2%"
													ng-click="fileDownload()" download>Download</button>
											</a> <br>
										</div>
									</div>
								</div>
								<div class="col-sm-6">


									<div class="form-group">
										<label class="col-md-4 control-label">EIR Date</label>
										<div class="col-md-8 inputGroupContainer">


											<div class="input-group input-append date">
												<input type="text" class="form-control input-sm" disabled
													id="eirDate" name="eirDate" ng-model="reportEir.eirDate"
													friendly-name="EIR Date" /> <span
													class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span>
											</div>

										</div>
									</div>

									<div class="form-group ">
										<label class="col-md-4 control-label">DMF</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm" id="dmf"
												maxlength="25" disabled name="dmf" ng-model="reportEir.dmf"
												friendly-name="DMF" />
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">MGWT</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm" id="mgwt"
												maxlength="25" disabled name="MGWT"
												ng-model="reportEir.mgwt" friendly-name="mgwt" />
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">MTWT</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm" id="mtwt"
												maxlength="25" disabled name="mtwt"
												ng-model="reportEir.mtwt" friendly-name="mtwt" />
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">NETWT</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm" id="netwt"
												maxlength="25" disabled name="netwt"
												ng-model="reportEir.netwt" friendly-name="netwt" />
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Vessel Name</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												id="vesselName" name="vesselName" maxlength="25" disabled
												ng-model="reportEir.vesselName" friendly-name="vesselName" />
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Voyage No.</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												maxlength="25" disabled id="voyageNo" name="Voyage No"
												ng-model="reportEir.voyageNo" friendly-name="voyageNo" />
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Guarantee No.</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												id="guaranteeNo" name="guaranteeNo" maxlength="25" disabled
												ng-model="reportEir.guaranteeNo" friendly-name="guaranteeNo" />
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Surveyed By</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												id="surveyedBy" name="Surveyed By" maxlength="25" disabled
												ng-model="reportEir.surveyedBy" friendly-name="surveyedBy" />
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">EIR
											Compiled/Estimated By</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												id="eirComplied" name="EIR Complied" maxlength="25" disabled
												ng-model="reportEir.eirComplied" friendly-name="eirComplied" />
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Remarks</label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm" id="remarks"
												name="Remarks" ng-model="reportEir.remarks" maxlength="25"
												disabled friendly-name="remarks" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="table-responsive clear">
							<table class="table table-striped b-t b-light">
								<thead>
									<tr>
										<th colspan=1 class="width_1"></th>
										<th colspan=1 class="width_13 text-center">Code</th>
										<th colspan=1 class="width_10 text-center">Description of
											Damage</th>
										<th colspan=1 class="width_10 text-center">QTY</th>
										<th colspan=1 class="width_10 text-center">HRS</th>
										<th colspan=1 class="width_10 text-center">L. Cost</th>
										<th colspan=1 class="width_10 text-center">M. Cost</th>
										<th colspan=1 class=" width_10 text-center">Total</th>
									</tr>
								</thead>
								<tbody
									ng-repeat="(trIndex, row) in reportEirDetailList track by $index">
									<tr>
										<td><label class="i-checks m-b-none"> <input
												type="checkbox" ng-model="row.select"
												name="section{{trIndex}}" id="section{{trIndex}}"><i></i></label></td>
										<td class="width_10">
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														ng-model="row.code" name="actualRate{{$index}}"
														id="actualRate{{$index}}" maxlength="25"
														ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" disabled
														friendly-name="{{ 'Row' + $index + '(actualRate)'}}" />
												</div>
											</div>
										</td>
										<td class="width_10">
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														ng-model="row.description" name="currency{{$index}}"
														id="currency{{$index}}" maxlength="250" disabled
														friendly-name="{{ 'Row' + $index + '(currency)'}}" />
												</div>
											</div>
										</td>
										<td class="width_10">
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														ng-model="row.qty" maxlength="25" disabled
														ng-keyup="rateCalculation(row.noOfCon,trIndex,row)"
														name="exRate{{$index}}" id="currency{{$index}}"
														friendly-name="{{ 'Row' + $index + '(exRate)'}}" />
												</div>
											</div>
										</td>
										<td class="width_10">
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														ng-model="row.hrs" name="rate{{$index}}"
														id="rate{{$index}}" maxlength="25" disabled
														friendly-name="{{ 'Row' + $index + '(rate)'}}" />
												</div>
											</div>
										</td>
										<td class="width_10">
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														ng-model="row.lcost" name="qty{{$index}}"
														id="qty{{$index}}" maxlength="25" disabled
														friendly-name="{{ 'Row' + $index + '(qty)'}}" />
												</div>
											</div>
										</td>
										<td class="width_10">
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														ng-model="row.mcost" name="total{{$index}}"
														id="currency{{$index}}" maxlength="25" disabled
														friendly-name="{{ 'Row' + $index + '(total)'}}" />
												</div>
											</div>
										</td>
										<td class="width_10">
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														ng-model="row.total" name="taxFree{{$index}}"
														id="taxFree{{$index}}" maxlength="25" disabled
														friendly-name="{{ 'Row' + $index + '(taxFree)'}}" />
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>

							<!-- /padding-right-5 - /AddOrRmvebtn -->
						</div>
						<!-- /table-responsive -->






						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="content">
									<div class="form-actions">
										<div class="row">
											<div class="col-md-12">


												<button class="btn btn-danger" ng-click="cancel()"
													type="button">
													<i class="fa fa-close"></i> Cancel
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>