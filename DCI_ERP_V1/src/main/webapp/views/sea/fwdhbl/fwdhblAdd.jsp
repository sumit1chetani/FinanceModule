
<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
.selectivity-backdrop {
background: transparent;
position: relative;
z-index: 9998;
top: 0;
right: 0;
bottom: 0;
left: 0;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div style="width: 30%;position: absolute;margin-top: -33px;margin-left: 78%;" ng-if="isEdit">
		<label style="color:#e25d5d;float: left;">Quick Links &nbsp;&nbsp; </label>
		  <select ng-change="quickLinkMethd(qukLinkVal)" ng-init="qukLinkVal='Select'" ng-model="qukLinkVal">
		 <option value="Select">Select</option>
		  <option value="Job Order">Job Order</option>
		  <option value="MBL">MBL</option>
		  <option value="Delivery Order">Delivery Order</option>
		  <option value="Sales Invoice">Sales Invoice</option>
		  <option value="Purchase Invoice">Purchase Invoice</option>
		</select>
		</div>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<form name="hblForm" method="post" class="form-horizontal" novalidate>
			<div class="panel-body" style="border-bottom:none;">
				<div class="row pl2pc pr10pc">
					<div class="col-md-3" ng-if="isEdit">
						<div class="form-group" >
							<label class="col-md-5 control-label" style="text-align:left">HBL No <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<label style="padding-top: 9px;padding-left: 6px;">{{hbl.hblCode}}</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<!-- <div class="form-group">
							<label class="col-md-5 control-label">HBL Date <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="hbl.mblDate" id="hblDate"
									name="MBl Date" form-name="hblForm" friendly-name="MBl Date"
									validation="required" />

							</div>
						</div> -->
					</div>
					<!-- <div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Type <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="typeList" property="hbl.branch"
									data-ng-model="hbl.typeId" name="Type" validation="required"
									form-name="hblForm" friendly-name="Type"> </selectivity>

							</div>
						</div>
					</div> -->


				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label" style="text-align:left">Job No <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<selectivity list="jobList" property="hbl.jobNo"
									data-ng-model="hbl.jobNo" name="Job No" validation="required"
									form-name="hblForm" friendly-name="Job No"> </selectivity>

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">HBL Date <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="hbl.hblDate" id="hblDate"
									name="MBl Date" form-name="hblForm" friendly-name="HBl Date"
									validation="required" />

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">POL <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<selectivity list="polList" property="hbl.pol"
									data-ng-model="hbl.pol" name="POL" validation="required"
									form-name="hblForm" friendly-name="POL"> </selectivity>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">POD <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="podList" property="hbl.pod"
									data-ng-model="hbl.pod" name="POD" validation="required"
									form-name="hblForm" friendly-name="POD"> </selectivity>
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					<!-- <div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">MBL No
							</label>
							<div class="col-md-7">
								<selectivity list="hblList" property="hbl.mblNo"
									data-ng-model="hbl.mblNo" name="MBL No"
									form-name="hblForm" friendly-name="MBL No"> </selectivity>

							</div>
						</div>
					</div> -->
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Branch<span
								style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<selectivity list="branchList" property="hbl.branch"
									data-ng-model="hbl.branch" name="branch" validation="required"
									form-name="hblForm" friendly-name="branch"> </selectivity>

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Origin </label>
							<div class="col-md-7">
								<selectivity list="originList" property="hbl.origin"
									data-ng-model="hbl.origin" name="Origin" form-name="hblForm"
									friendly-name="Origin"> </selectivity>


							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Destination</label>
							<div class="col-md-7">
								<selectivity list="destinationList" property="hbl.destination"
									data-ng-model="hbl.destination" name="Destination"
									form-name="hblForm" friendly-name="Destination">
								</selectivity>

							</div>
						</div>
					</div>



				</div>
				<div class="row pl2pc pr10pc">

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Customer <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="customerList" property="hbl.customer"
									data-ng-model="hbl.customer" name="Customer"
									form-name="hblForm" validation="required"
									friendly-name="Customer"> </selectivity>

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Shipper</label>
							<div class="col-md-7">
								<selectivity list="customerList" property="hbl.shipper"
									data-ng-model="hbl.shipper" name="Shipper" form-name="hblForm"
									friendly-name="Shipper"> </selectivity>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Consignee</label>
							<div class="col-md-7">
								<selectivity list="customerList" property="hbl.consignee"
									data-ng-model="hbl.consignee" name="Consignee"
									form-name="hblForm" friendly-name="Consignee"> </selectivity>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Term <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="termList" property="hbl.term"
									validation="required" validation="required"
									data-ng-model="hbl.term" name="Term" form-name="hblForm"
									friendly-name="Term"> </selectivity>

							</div>
						</div>

					</div>

					


				</div>
				
				<fieldset class="b-a width_100" style="top: 10px; padding-bottom: 10px; border: 1px solid #DDD">
									<legend class="width_14  b-a control-label;" style="margin-left: 1%;font-size: 15px; font-weight:bold;"
">Document Details</legend>

				<div class="row pl2pc pr10pc">


					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">HBL Doc No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.hblDocNo" data-ng-model="hbl.hblDocNo"
									name="HBL Doc No" friendly-name="HBL Doc No" />

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">HBL Doc Date </label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="hbl.hblDocDate"
									id="hblDocDate" name="HBl Doc Date" form-name="hblForm"
									friendly-name="HBl Doc Date" />
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Vendor</label>
							<div class="col-md-7">
								<selectivity list="customerList" property="hbl.vendor"
									data-ng-model="hbl.vendor" name="Vendor" form-name="hblForm"
									friendly-name="Vendor"> </selectivity>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Vessel Voyage</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.vesselVoyeage" data-ng-model="hbl.vesselVoyeage"
									name="Vessel Voyage" friendly-name="Vessel Voyage" />
							</div>
						</div>
					</div>

				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">MBL Doc No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.mblDocNo" data-ng-model="hbl.mblDocNo"
									name="MBl Doc No" friendly-name="MBl Doc No" />
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">MBL Doc Date</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="hbl.mblDocDate"
									id="hblDocDate" name="MBl Doc Date" form-name="hblForm"
									friendly-name="MBl Doc Date" />

							</div>
						</div>
					</div>
						<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Agent</label>
							<div class="col-md-7">
								<selectivity list="agentList" property="hbl.agent"
									data-ng-model="hbl.agent" name="Agent" form-name="hblForm"
									friendly-name="Agent"> </selectivity>
							</div>
						</div>
					</div>
					<!-- <div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">ETD</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="hbl.etd" id="etd" name="ETD"
									form-name="hblForm" friendly-name="ETD" />
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">E.T.A at POD</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="hbl.etaAtPod" id="etaPod"
									name="E.T.A at POD" form-name="hblForm"
									friendly-name=">E.T.A at POD" />
							</div>
						</div>
					</div> -->


				</div>
				<!-- <div class="row pl2pc pr10pc">
				
						<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Feeder Vessel
								Voyage</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.feederVesselVoyeage"
									data-ng-model="hbl.feederVesselVoyeage"
									name="Feeder Vessel Voyage"
									friendly-name="Feeder Vessel Voyage" />
							</div>
						</div>
					</div>
					</div> -->
					</fieldset>
					
					
				
			</div>
			<div style="padding: 0px 18px;border-bottom: none;border-top: none" class="panel-body" >
			<fieldset class="b-a width_100" style="top: 10px; padding-bottom: 10px; border: 1px solid #DDD">
									<legend class="width_14  b-a control-label;" style="margin-left: 1%;font-size: 15px; font-weight:bold;"
">Container Details</legend>



			<div >
				<table class="table table-striped b-t b-light" style="width:100%">
					<thead>
						<tr>
							<th class="sorting width_2">Select</th>
							<th class="sorting width_12">Container No</th>

							<th class="sorting width_12">Seal No</th>
							<th class="sorting width_12">Size Type</th>
							<th class="sorting width_2">Marks and Nos</th>

							<th class="sorting width_1 text-center table-heading">Cargo
								Description</th>
							<th class="sorting width_2 text-center table-heading">No of
								package</th>
							<th class="sorting width_6 text-center table-heading">UOM</th>
							<th class="sorting width_10 text-center table-heading">Net
								Weight</th>
							<th class="sorting width_10 text-center table-heading">Gross
								Weight</th>
							<th class="sorting width_6 text-center table-heading">Measurement
							</th>

							


						</tr>

										</thead>

					<tbody ng-repeat="($index,row) in lHablContainerBean">
						<tr>
							<td><label class="i-checks m-b-none"> <input
									type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12" style="width:151px">
										<input type="text" class="form-control input-sm"
											data-ng-model="row.containerNo" maxlength="11" name="ContactName{{trIndex}}"
									data-toggle="tooltip" title="{{row.containerNo}}"		friendly-name="{{ 'Row' + $index + '(ContactName)'}}" />
									</div>
								</div>
							</td>


							<td class="width_10">
								<div class="row">
									<div class="col-xs-12"style="width:151px">
										<input type="text" class="form-control input-sm"
											data-ng-model="row.sealNo" maxlength="20" name="Designation{{trIndex}}"
										data-toggle="tooltip" title="{{row.sealNo}}"	friendly-name="{{ 'Row' + $index + '(Narration)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12" style="width:160px">
										<selectivity list="sizeList" property="row.size"
											id="{{ 'Row' + $index + '(LandLineNo)'}}" ng-model="row.size"
											 friendly-name="{{ 'Row' + $index + '(LandLineNo)'}}"></selectivity>

									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									<!-- <div class="row"ng-if="edit">
											
                                    <button type="button" class="btn btn-link" ng-click="remarks(row.jobNo) "style="color: green;font-size: 10px;text-align:justify">Click here to view remarks history </button>
												
											
										</div> --><button type="button" class="btn btn-link" ng-click="remarks($index)"   style="color: green;font-size: 12px;text-align:justify">View</button>
										<!-- <input type="text" class="form-control input-sm" ng-click="remarks(row.jobNo)
											data-ng-model="row.marksAndNos" name="MobileNo{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(MobileNo)'}}" /> -->
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									<button type="button" class="btn btn-link" ng-click="cargo($index)"   style="color: green;font-size: 12px;text-align:justify">View</button>
									
									<!-- <textarea  type="text" class="form-control input-sm"
															name="Skype{{trIndex}}" id="Skype{{trIndex}}" 
															class="custom-scroll width_250 resize-none" rows="3" maxlength="600"
															data-ng-model="row.cargoDescription">
															</textarea> -->
															
										
									</div>
								</div>
							</td>
							<td class="width_7">
								<div class="row">
									<div class="col-xs-12" style="width:85px">
										<input type="text" class="form-control input-sm"
											data-ng-model="row.noofPackage" name="Skype{{trIndex}}"
											ng-keyup="packageCalculation1(row.noofPackage,trIndex,row)"
											data-toggle="tooltip" title="{{row.noofPackage}}" friendly-name="{{ 'Row' + $index + '(Skype)'}}" />
									</div>
								</div>
							</td>

							<td >
								<div class="row">
									<div class="col-xs-12" style="width:90px" >
									<selectivity list="uomList" property="row.uOm"
											id="{{ 'Row' + $index + '(LandLineNo)'}}" ng-model="row.uOm"
										 	friendly-name="{{ 'Row' + $index + '(LandLineNo)'}}"></selectivity>
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.uOm" name="remarks{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(remarks)'}}" /> -->
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm"
											data-ng-model="row.netWeight" validation="required|numeric"  name="netWeight{{'Row' + $index + '(netWeight)'}}"
											ng-keyup="netWeightCalculation(row.netWeight,trIndex,row)"
										data-toggle="tooltip" title="{{row.netWeight}}"	friendly-name="{{ 'Row' + $index + '(netWeight)'}}" />
										
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm"
											data-ng-model="row.grossWeight" validation="required|numeric" name="grossWeight{{'Row' + $index + '(grossWeight)'}}"
											ng-keyup="grossWeightCalculation(row.grossWeight,trIndex,row)"
										data-toggle="tooltip" title="{{row.grossWeight}}"	friendly-name="{{ 'Row' + $index + '(grossWeight)'}}" />
										
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12" style="width:85px">
										<input type="text"  class="form-control input-sm"  
											data-ng-model="row.measureMent" validation="required|numeric"  name="measureMent{{'Row' + $index + '(measureMent)'}}"
											data-toggle="tooltip" title="{{row.measureMent}}" friendly-name="{{ 'Row' + $index + '(measureMent)'}}" required>
									</div>
								</div>
							</td>
							<!-- <td>
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm"
											data-ng-model="row.remarks" name="ContactName{{trIndex}}"
										data-toggle="tooltip" title="{{row.remarks}}"	friendly-name="{{ 'Row' + $index + '(ContactName)'}}" />
									</div>
								</div>
							</td> -->
						</tr>
					</tbody>

				</table>
				</div>
				
				<div class="padding-right-5" style="padding-left: 16px;" id="AddOrRmvebtn">
					<button ng-click="addCredRow()" class="btn btn-sm btn-info"
						tooltip="Add Row" ng-disabled="" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="deleteCredRow()" class="btn btn-sm btn-danger"
						type="button" tooltip="Delete">
						<i class="fa  fa-trash-o"></i>
					</button>
				</div>
				</fieldset>
				</div>
				
			
			
			<div class="panel-body" style="border-top:none;">
				<div class="row pl2pc pr10pc">
					
					<div class="col-md-4" ng-if="isEdit">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Total Packages : </label>
							<div class="col-md-3 control-label">{{totalPackage}}</div>
						</div>
					</div>
					<div class="col-md-3" ng-if="isEdit">
						<div class="form-group" >
							<label class="col-md-7 control-label"style="text-align:left">Net Weight : </label>
							<div class="col-md-3 control-label">{{totalnetWeight}}</div>
						</div>
					</div>
					<div class="col-md-4" ng-if="isEdit">
						<div class="form-group">
							<label class="col-md-9 control-label" style="padding-right: 103px;""style="text-align:left">Gross Weight : </label>
							<div class="col-md-3 control-label">{{totalgrossWeight}}</div>
						</div>
					</div>
					


				</div>
				
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Shipper </label>
							<div class="col-md-7">
								<textarea class="form-control input-sm" property="hbl.shipperAddress"
									ng-model="hbl.shipperAddress" name="Shipper"
									friendly-name="Shipper" rows="2"></textarea>



							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Consignee </label>
							<div class="col-md-7">
								<textarea class="form-control input-sm"
									property="hbl.consigneeAddress" ng-model="hbl.consigneeAddress"
									name="Consignee" friendly-name="Consignee" rows="2"></textarea>

							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Notify</label>
							<div class="col-md-7">
								<textarea class="form-control input-sm"
									property="hbl.notifyAddress" ng-model="hbl.notifyAddress"
									name="Notify" friendly-name="Notify" rows="2"></textarea>

							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Place Of Receipt </label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.placeofReceipt"
									data-ng-model="hbl.placeofReceipt" name="Place Of Receipt"
									friendly-name="Place Of Receipt" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Port of Load</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.portofLoad" data-ng-model="hbl.portofLoad"
									name="Port of Load" friendly-name="Port of Load" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Movement</label>
							<div class="col-md-7">

								<selectivity list="movementList" property="hbl.movement"
									data-ng-model="hbl.movement" name="branch" form-name="hblForm"
									friendly-name="Movement"> </selectivity>


							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Port of Discharge</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.portofDischarge"
									data-ng-model="hbl.portofDischarge" name="Port of Discharge"
									friendly-name="Port of Discharge" />

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Port of Delivery</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.portofDelivery"
									data-ng-model="hbl.portofDelivery" name="Port of Delivery"
									friendly-name="Port of Delivery" />

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Place of Delivery</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.placeofDelivery"
									data-ng-model="hbl.placeofDelivery" name="Place of Delivery"
									friendly-name="Place of Delivery" />

							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">


					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Signed at</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.signedAt" data-ng-model="hbl.signedAt"
									name="Signed at" friendly-name="Signed at" />

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Signed by</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.signedBy" data-ng-model="hbl.signedBy"
									name="Signed by" friendly-name="Signed by" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Final Destination</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.finalDestination"
									data-ng-model="hbl.finalDestination" name="Final Destination"
									friendly-name="Final Destination" />
							</div>
						</div>
					</div>
				</div>
				<!-- <div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Forwarding Agent
								Reference</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.forwardingAgentReferences"
									data-ng-model="hbl.forwardingAgentReferences"
									name="Forwarding Agent
								Reference"
									friendly-name="Forwarding Agent
								Reference" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Cargo Insurance</label>
							<div class="col-md-7">
								<selectivity list="cargoList" property="hbl.cargoInsurance"
									data-ng-model="hbl.cargoInsurance" name="Cargo Insurance"
									form-name="hblForm" friendly-name="Cargo Insurance">
								</selectivity>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Container Number</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.containerNumber"
									data-ng-model="hbl.containerNumber" name="Container Number"
									friendly-name="Container Number" />
							</div>
						</div>
					</div>
				</div> -->
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Freight Payable at</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.freightPayableAt"
									data-ng-model="hbl.freightPayableAt" name="Freight Payable at"
									friendly-name="Freight Payable at" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">No of Original BL</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.noOfOriginalBl"
									data-ng-model="hbl.noOfOriginalBl" name="No of Original BL"
									friendly-name="No of Original BL" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Pre-Carriage By</label>
							<div class="col-md-7">
								<selectivity list="preCarriageList"
									property="hbl.preCarriagedBy"
									data-ng-model="hbl.preCarriagedBy" vlaidation="required"
									name="Pre-Carriage By" form-name="hblForm"
									friendly-name="Pre-Carriage By"> </selectivity>
							</div>
						</div>
					</div>
				</div>


				<!-- <div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Consolidation
								Number</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.consolidationNumber"
									data-ng-model="hbl.consolidationNumber"
									name="Consolidation Number"
									friendly-name="Consolidation Number" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Export References</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.exportReferences"
									data-ng-model="hbl.exportReferences" name="Export References"
									friendly-name="Export References" />

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Shipper References</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.shipperReferences"
									data-ng-model="hbl.shipperReferences" name="Shipper References"
									friendly-name="Shipper References" />

							</div>
						</div>
					</div>
				</div> -->
				<!-- <div class="row pl2pc pr10pc">


					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">FTZ Number</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.ftzNumber" data-ng-model="hbl.ftzNumber"
									name="FTZ Number" friendly-name="FTZ Number" />


							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Loading
								Pier/Terminal</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.loadingPierTerminal"
									data-ng-model="hbl.loadingPierTerminal"
									name="Loading Pier/Terminal"
									friendly-name="Loading Pier/Terminal" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Co-Loaded With </label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="hbl.coLoadedWith " data-ng-model="hbl.coLoadedWith"
									name="Co-Loaded With " friendly-name="Co-Loaded With " />
							</div>
						</div>
					</div>
				</div> -->
				<div class="row pl2pc pr10pc">




					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Desination Agent
								Code</label>
							<div class="col-md-7">
								<selectivity list="destinationAgentList"
									property="hbl.destinationAgentCode"
									data-ng-model="hbl.destinationAgentCode"
									name="Desination Agent Code" form-name="hblForm"
									friendly-name="Desination Agent
								Code"> </selectivity>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Currency</label>
							<div class="col-md-7">
								<selectivity list="currencyList" property="hbl.currency"
									data-ng-model="hbl.currency" name="Currency"
									form-name="hblForm" friendly-name="Currency"> </selectivity>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label" style="text-align:left; display:none">Containerized</label>
							<div class="col-md-7">
								<label class="i-checks m-b-none"  style="display:none" > <input type="checkbox" style="display:none"
									ng-model="hbl.containarized" id="section{{trIndex}}"><i></i></label>
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"
								style="font-weight: bold; color: black;">Freight Details</label>

						</div>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th class="sorting width_2">Select</th>
								<th class="sorting width_4">Charge Name </th>
								<th class="sorting width_2">Payment Mode </th>
								<th class="sorting width_3">Amount </th>
								<th class="sorting width_3">Show In Print</th>
								<th class="sorting width_3"></th>
								<th class="sorting width_3"></th>
								<th class="sorting width_3"></th>

								<th class="sorting width_3"></th>



							</tr>
						</thead>

						<tbody ng-repeat="($index,row) in lHablFreightBean">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-20">
											<input type="text" class="form-control input-sm"
												data-ng-model="row.chargeName"
												name="Charger Name{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Charger Name)'}}" />
										</div>
									</div>
								</td>


								<td class="width_8">
									<div class="row">
										<div class="col-xs-8">
											<selectivity list="paymentList" property="row.paymentMode"
												data-ng-model="row.paymentMode"
												name="Payment Mode{{trIndex}}" 
												form-name="hblForm" friendly-name="Payment Mode"
												friendly-name="{{ 'Row' + $index + '(Payment Mode)'}}">
											</selectivity>

										</div>
									</div>
								</td>
								<td class="width_8">
									<div class="row">
										<div class="col-xs-8">
											<input type="text" class="form-control input-sm"
												 data-ng-model="row.amount"
												name="Amount{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Amount)'}}" />
										</div>
									</div>
								</td>
								<td class="width_5">
									<div class="row">
										<div class="col-xs-8">
											<label class="i-checks m-b-none"> <input
												type="checkbox" ng-model="row.print" id="section{{trIndex}}"><i></i></label>
										</div>
									</div>
								</td>
							</tr>
						</tbody>

					</table>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addFreightRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeFreightRow()"
							class="btn btn-sm btn-danger" type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" ng-if="!isEdit" type="button"
									ng-click="save(hblForm)">
									<i class="fa fa-save"></i> Save
								</button>

								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="update(hblForm)">
									<i class="fa fa-save"></i> Update
								</button>
								
								<button class="btn btn-info" type="reset" ng-click="reset()"
									ng-if="!isEdit">
									<i class="fa fa-undo"></i> Reset
								</button>

								<button class="btn btn-info" ng-click="reset()" ng-if="isEdit">
									<i class="fa fa-undo"></i> Reset
								</button>

								<button class="btn btn-danger" ng-click="cancel()" type="button">
									<i class="fa fa-close"></i> Cancel
								</button>

							</div>
							<%-- <div class="row">
								<div class="col-md-12" >
								<security:authorize access="hasRole('F5577_${print}')">
									<a ng-click="printRow()" ng-show="isEdit"
										style="color: #0f1ece; text-decoration: underline;">Print
										HBL</a>
										</security:authorize> 
									<security:authorize access="hasRole('F5577_${print}')">
										<a ng-click="printBookingConfirmation()" ng-show="isEdit"
										style="color: #0f1ece; text-decoration: underline;">Print
										Booking Confirmation</a> 
										</security:authorize>
										<security:authorize access="hasRole('F5577_${print}')">
										<a ng-click="printManifest()"
										ng-show="isEdit"
										style="color: #0f1ece; text-decoration: underline;">Print
										Manifest</a>
										</security:authorize>
										<security:authorize access="hasRole('F5577_${print}')">
										 <a ng-click="printLoad()" ng-show="isEdit"
										style="color: #0f1ece; text-decoration: underline;">Print
										Load List</a>
										</security:authorize>
								</div>
							</div> --%>
						</div>
						<div class="row">
						<div class="col-md-12">
						<security:authorize access="hasRole('F5577_${print}')">
								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="printRow()">
									<i class="fa fa-print"></i> Print
										HBL
								</button>
								</security:authorize>
								<security:authorize access="hasRole('F5577_${print}')">
								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="printBookingConfirmation()">
									<i class="fa fa-print"></i> Print
										Booking Confirmation
								</button>
								</security:authorize>
							
								<security:authorize access="hasRole('F5577_${print}')">
								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="printRowOverFlow()">
									<i class="fa fa-print"></i> 	Print HBL Overflow MBK
								</button>
								</security:authorize>
								
								<security:authorize access="hasRole('F5577_${print}')">
								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="printManifest()">
									<i class="fa fa-print"></i> Print
										Manifest
								</button>
								</security:authorize>
								<security:authorize access="hasRole('F5577_${print}')">
								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="printLoad()">
									<i class="fa fa-print"></i> Print
										Load List
								</button>
								</security:authorize>
						</div>
					</div>
				</div>
				</div>
				</div>
		</form>
	</div>
</div>
