<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%-- <security:authentication var="user" property="principal" /> --%>

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="vessselArrivalForm" class="form-horizontal">
				<div class="row">


					<div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
							<div class="form-group">
									<label class="col-md-5 control-label">Mode<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="modeList" ng-model="discharge.mode"
											validation="required" friendly-name="Mode"
											property="discharge.mode" id="mode" name="mode"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4" ng-if="discharge.mode==4">
							<div class="form-group">
									<label class="col-md-5 control-label">Carrier<span style="color:red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="carrierList" ng-model="discharge.carrier" friendly-name="carrier"
											property="discharge.carrier" id="mode" name="carrier" validation="required"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4" ng-if="discharge.mode!=4">
							<div class="form-group">
									<label class="col-md-5 control-label">Carrier</label>
									<div class="col-md-7">
										<selectivity list="carrierList" ng-model="discharge.carrier" friendly-name="carrier"
											property="discharge.carrier" id="mode" name="carrier"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							
	<div class="col-md-4">
								<!-- Arrival date -->
								<div class="form-group">
									<label class="col-md-5 control-label">Arrival Date</label>
									<div class="col-md-7">
										<div class="input-group  input-append date">
										<input type="text" class="form-control input-sm"
												id="arrivalDate" name="arrivalDate"
												ng-model="discharge.arrivalDate" validation="required"  disabled="disabled"
												friendly-name="arrivalDate" /> <span
												class="input-group-addon add-on"><span
												form-name="vessselArrivalForm" class="glyphicon glyphicon-calendar"></span></span>
										</div>
									</div>
								</div>
							</div>

						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
								<!-- vessel -->
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="discharge.vessel" disabled="isEdit"
											validation="required" friendly-name="vessel"
											property="discharge.vessel" id="vessel" name="vessel"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
								
							</div>
<div class="col-md-4">
								<!-- voyage -->
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="discharge.voyage"
											validation="required" friendly-name="Voyage"
											property="discharge.voyage" id="Voyage" name="Voyage"  disabled="isEdit"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<!-- port -->
								<div class="form-group">
									<label class="col-md-5 control-label">Port<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="portList" ng-model="discharge.port"
											validation="required" friendly-name="port"
											property="discharge.port" id="port" name="port"  disabled="isEdit"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>



							

							
							
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
								<!-- Discharge Date -->
								<div class="form-group">
									<label class="col-md-5 control-label">Discharge Date<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<div class="input-group  input-append date">
											<input type="text" class="form-control input-sm"
												id="dischargeDate" name="dischargeDate" 
											ng-model="discharge.dischargeDate" validation="required"  
												friendly-name="dischargeDate" ng-disabled="isEdit"/> <span
												class="input-group-addon add-on"><span
												form-name="vessselArrivalForm" class="glyphicon glyphicon-calendar"></span></span>
										</div>
									</div>
								</div>
							</div>
						</fieldset>
						</div>


				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<button class="btn btn-success" ng-click="viewDetail()">
								<i class="fa fa-eye	"> </i>Show
							</button>
							<button class="btn btn-info" type="reset" ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>

						<!-- 	<button class="btn btn-primary" type="button"
								class="btn btn-primary" data-ng-click="fileUpload()">
								<i class="fa fa-file"></i>Upload Discharge time
							</button> -->
							<a id="sampleDownload" style="display: none"
								href="/assets/docs/CSL_shipping_Sample.xlsx"
								download="CSL_shipping_Sample.xlsx"></a>

							<!-- <button class="btn btn-primary" ng-click="print(rowCollection)">
								<i class=""> </i> Arrival Notice
							</button>
							<button class="btn btn-primary" ng-click="manifest()">
								<i class=""> </i> Manifest
							</button> -->
						</div>
					</div>
				</div>
				<br>
				<div class="breadcrumb-wrapper ng-scope">

					<div class="table-responsive" style="border: 1px solid #CCC;">
						<div class="panel panel-default panel-default-list"
							st-table="displayedCollection" st-safe-src="discharge.detailList">
							<div class="panel-body float-left padding-0" style="width: 100%;">
								<div class="table-responsive">
								<br>
									<div class="col-md-4">
									<h3 style="margin-left: 5px;">Discharge Container Detail</h3>
									</div>
									<div class="col-md-4">
									<div class="form-group">
									<label class="col-md-5 control-label">Discharge Status Date<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
									<div class="input-group  input-append date">
									<input type="text" class="form-control input-sm"
												id="detailDate" name="detailDate" 
											ng-model="discharge.detailDate" validation="required"  
												friendly-name="detailDate" /> <span
												class="input-group-addon add-on"><span
												form-name="vessselArrivalForm" class="glyphicon glyphicon-calendar"></span></span>
									<!-- 	<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="discharge.detailDate" id="detailDate"
										name="detailDate"  ng-model="discharge.detailDate"  friendly-name="Discharge Status Date"
										form-name="vessselArrivalForm" validation ="required" />
										</div> -->
										</div>
										</div>
									</div>
								</div>
								<button class="btn btn-info ng-scope"  type="button" 
								ng-click="apply(discharge.detailDate)">
								<i class="fa fa-exchange"></i> Apply
							</button>
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr role="row">
												<!-- <th class="width_1"><input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"></th> -->
									<th class="width_1 text-center"><label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"><i style="margin-left: -43px;"></i>
							</label> </th>
							
							<th class="sorting width_6">SL No</th>
												<th class="sorting width_6">Booking No</th>
												<th class="sorting width_6">B/L No</th>
												<th class="sorting width_8">Customer</th>
												<th class="sorting width_8">Container Number</th>
												<th class="sorting width_8">Discharge Date</th>
												<th class="sorting width_7">Container Type</th>
												<th class="sorting width_4">SOC</th>
												 
										<!-- 		<th class="width_5 text-center">Is Transit<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selectionTransit"
									data-ng-click="selectallTransit(selectionTransit)"><i style="margin-left: -43px;"></i>
							</label> </th> -->
												
												<!-- 			<th class="sorting width_5">Is Transit</th>
												<th class="width_5" ng-if="isEdit">Action</th>
 -->

											</tr>
										</thead>

										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="(trIndex, listitems) in displayedCollection"  ng-controller="dischargetableCtrl">
												<td class="width_1 text-center"><label
													class="i-checks m-b-none"> <input type="checkbox"
														ng-disabled="listitems.disabled" name="selectedTypes[]"
														ng-model="listitems.select1"> <i></i>
												</label></td>
                                    	 <td style="background-color: lightsalmon" class="sorting" data-toggle="tooltip">{{$index+1}}</td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.bookingNum}}" class="tool-tip-span"
													ng-bind="listitems.bookingNum"></span></td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.blNumber}}" class="tool-tip-span"
													ng-bind="listitems.blNumber"></span></td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.customerName}}" class="tool-tip-span"
													ng-bind="listitems.customerName"></span></td>

												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.containerNumber}}"
													class="tool-tip-span" ng-bind="listitems.containerNumber"></span>
												</td>
												<td style="background-color: lightsalmon">
										 		<input type="text" class="form-control input-sm"
										name="dischargeStatusDate" 
										property="listitems.dischargeStatusDate" ng-model="listitems.dischargeStatusDate" ng-show ="listitems.flag === 'DC'"  ng-disabled="listitems.flag === 'DC'" />
												<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="listitems.dischargeStatusDate" id="dischargeStatusDate"
										name="dischargeStatusDate"  ng-model="listitems.dischargeStatusDate"  friendly-name="dischargeStatusDate"
										form-name="vessselArrivalForm" ng-hide ="listitems.flag === 'DC'" />
										</div> 
									
										</td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.containerType}}" class="tool-tip-span"
													ng-bind="listitems.containerType"></span></td>
													<td style="background-color: lightsalmon"><input
													type="checkbox" class="checkbox style-0" name="soc"
													ng-model="listitems.soc"  disabled="true">
												</td>
												<!-- <td style="background-color: lightsalmon"><input
													type="checkbox" class="checkbox style-0" name="isTransit"
													ng-model="listitems.isTransit"  >
												</td> -->
												
												
<!-- 												<td style="background-color: lightsalmon" ng-if="isEdit">
 -->												<!-- 	<button ng-click="removeRow(listitems)"
														class="btn btn-sm btn-danger" type="button" tooltip="Undo">
														<i class="fa fa-undo"></i>
													</button> -->
													
												<!-- 	<button ng-click="deleteRow(listitems.dischargeDtlId)"
														class="btn btn-sm btn-danger" type="button" tooltip="Delete">
														<i class="fa fa-trash-o "></i>
													</button> -->
													
						
									
				<!-- 
												</td> -->

										</tbody>
									</table>

								</div>

							</div>
						</div>

					</div>
				</div>



<div class="table-responsive" style="width: 29%;">
								<table class="table table-striped b-t b-light">
										<thead>
											<tr>
								<th colspan=1 class="width_1 text-center">Container Type</th>
								<th colspan=1 class="width_5 text-center">Count</th>
				
											</tr>
										</thead>
										<tbody ng-repeat="(trIndex,row) in discharge.count">
											<tr>
								<td style="text-align:center">{{row.containerTypes}}</td>
								<td style="text-align:center">{{row.containerTypeCount}}</td>

										</tbody>
									</table>
								<br>


							</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit" ng-disabled="check1"
								ng-click="saveData()">
								<i class="fa fa-save"></i> Discharge
							</button>
							<button class="btn btn-success"  type="button" ng-if="isEdit" ng-disabled="check1"
								ng-click="update()">
								<i class="fa fa-save"></i> Discharge
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>


			</form>

		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
	<br> <br> <br> <br> <br> <br> <br> <br>
	<br> <br> <br> <br> <br> <br> <br> <br>
</div>

<script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile1(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
 <!-- <button class="btn btn-info" type="button" ng-click="exportSampleExcel()">Download Sample</button> -->
   <button class="btn btn-info" type="button" ng-click="uploadFile()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
	<div id="btnRowDivIdsamp"> </div>
	</div>
  </div>
 </script>
 
 
