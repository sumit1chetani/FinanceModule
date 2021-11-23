<style>
#Containerdetail {
	height: auto;
	width: auto;
	max-height: 350px;
	overflow-y: scroll;
	overflow-x: scroll;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="onBoardForm" class="form-horizontal" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
						<div class="form-group ">
								<label for="inputPassword" class="col-md-4 control-label">Mode <span style="color: red">*</span>
								</label>
								<div class="col-md-5">

									<selectivity list="modeList"
										property="onBoard.mode" id="mode"
										name="mode" ng-model="onBoard.mode"
										object="mode" friendly-name="Mode"
										validation="required" form-name="onBoardForm"
										></selectivity>



								</div>
								</div>
								
								
							<div class="form-group">
								<label class="col-md-4 control-label"> Vessel <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="vesselList" property="onBoard.vessel"
										id="vessel" ng-model="onBoard.vessel" name="vessel"
										validation="required" friendly-name="Vessel"
										form-name="onBoardForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Port <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<selectivity list="portList" property="onBoard.port" id="port"
										ng-model="onBoard.port" name="port" validation="required"
										friendly-name="port" form-name="onBoardForm"></selectivity>
								</div>
							</div>


						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
<div class="form-group ">
								<label class="col-md-4 control-label">Carrier <span ng-if="onBoard.mode==4"
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<selectivity list="carrierList" ng-model="onBoard.carrier"
										 property="onBoard.carrier"
										id="carrier" 
										friendly-name="Carrier"
										form-name="onBoardForm"></selectivity>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Voyage  <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<selectivity list="voyageList" property="onBoard.voyage"
										id="voyage" ng-model="onBoard.voyage" name="voyage"
										validation="required" friendly-name="VOYAGE"
										form-name="onBoardForm"></selectivity>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Date <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
										<div class="input-group  input-append date">
										<input type="text" class="form-control input-sm"
												id="onBoardDate" name="onBoardDate"
												ng-model="onBoard.onBoardDate" 
												friendly-name="onBoardDate" validation="required" /> <span
												class="input-group-addon add-on"><span
												form-name="onBoardForm" class="glyphicon glyphicon-calendar"></span></span>
										</div>
								</div>
							</div>
						</fieldset>
					</div>
					
				</div>
				<div class="form-actions">
				
				
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit"
								class="btn btn-success" ng-click="getData(onBoardForm,onBoard)">
								<i class="fa fa-search"></i> Show

							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
						</div>
						<br>
												<div class="col-md-3">
						</div>
						<div class="col-md-6">
									<div class="form-group">
									<label class="col-md-5 control-label">Onboard Status Date<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="onBoard.detailDate" id="detailDate"
										name="detailDate"  ng-model="onBoard.detailDate"  friendly-name="Onboard Status Date" 
										form-name="onBoardForm"  />
										</div>
										</div>
									</div>
								</div>
																				<div class="col-md-3">
								<button class="btn btn-info ng-scope"  type="button" 
								ng-click="apply(onBoard.detailDate)" style="
    margin-left: -106%;">
								<i class="fa fa-exchange"></i> Apply
							</button>
					</div></div>
				</div>
				
				<div class="panel-body">
						<div class="table-responsive"  id="Containerdetail">
							<div class="col-md-12" style="width: 130%;">

								<div class="row" id="items">
								<table class="table table-striped b-t b-light">
										<thead>
											<tr>
											<th colspan=1 class="width_1 text-center" ng-if="!isEdit">Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>
												<!-- <th colspan=1 class="width_1">Select</th> -->
								<th colspan=1 class="width_1 text-center">SL No</th>
								<th colspan=1 class="width_5 text-center">BL No</th>
								<th colspan=1 class="width_5 text-center">Job No</th>
								<th colspan=1 class="width_5 text-center">Booking No</th>
								<th colspan=1 class="width_5 text-center">Customer Name</th>
						<!-- 		<th colspan=1 class="width_10 text-center">Customer Type</th> -->
								<th colspan=1 class="width_5 text-center">Container Type</th>
								<th colspan=1 class="width_5 text-center">Container No</th>
								<th colspan=1 class="width_5 text-center">SOC</th>
								<th colspan=1 class="width_12 text-center">Onboard Status Date</th>
								<th colspan=1 class="width_5 text-center">Slot Operator</th>
								<th colspan=1 class="width_5 text-center">Seal No</th>
<!-- 								<th colspan=1 class="width_5 text-center">Package Type</th>
 -->								<th colspan=1 class="width_5 text-center">No Of Pkgs</th>
								<th colspan=1 class="width_5 text-center">Pod</th>
									<th colspan=1 class="width_1 text-center">T/s Leg</th>
											</tr>
										</thead>
										<tbody ng-repeat="(trIndex,row) in onBoard.containerDtl"  ng-controller="onBoardtableCtrl">
											<tr>
												<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td style="text-align:center">{{row.slno}}</td>
								<td style="text-align:center">{{row.blNo}}</td>
								<td style="text-align:center">{{row.jobNo}}</td>
								<td style="text-align:center">{{row.bookingNo}}</td>
								<td style="text-align:center">{{row.customerName}}</td>
								<!-- <td style="text-align:center">{{row.customerType}}</td> -->
								<td style="text-align:center">{{row.containerType}}</td>
								<td style="text-align:center">{{row.containerNo}}</td>
								<td class="text-center">
														<label class="i-checks"><input type="checkbox"
													name="soc" id="soc" ng-model="row.soc" disabled="true"><i></i></label>
												</td>
								<td style="text-align:center">
								<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="row.onboardStatusDate" id="onboardStatusDate" validation="required"
										name="onboardStatusDate"  ng-model="row.onboardStatusDate"  friendly-name="{{ 'Row' + ($index+1) + '(onboardStatusDate)'}}"
										/>
										</div></td>
								<td style="text-align:center"><selectivity list="slotList"
										property="row.slotOperator" id="slotOperator{{trIndex}}" ng-model="row.slotOperator"
										name="slotOperator{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(slotOperator)'}}"></selectivity></td>
								<td style="text-align:center">{{row.sealNo}}</td>
<!-- 								<td style="text-align:center">{{row.packgeType}}</td>
 -->								<td style="text-align:center">{{row.noOfPkgs}}</td>
								<td style="text-align:center">{{row.pod}}</td>
								<td style="text-align:center">{{row.leg}}</td>
										</tbody>
									</table>
								</div>
								<br>

<div class="padding-right-5" id="AddOrRmvebtn">
						<!-- <button ng-click="addRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button> -->
						<button ng-click="removeRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
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
										<tbody ng-repeat="(trIndex,row) in onBoard.count">
											<tr>
								<td style="text-align:center">{{row.containerCount}}</td>
								<td style="text-align:center">{{row.containerTypeCount}}</td>

										</tbody>
									</table>
								<br>


							</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" 
								ng-if="onBoard.containerDtl.length > 0" ng-if="!isEdit"
								class="btn btn-success" ng-click="save(onBoardForm,onBoard)">
								<i class="fa fa-save"></i> Save

							</button>

							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>




			</form>
		</div>
	</div>
</div>
