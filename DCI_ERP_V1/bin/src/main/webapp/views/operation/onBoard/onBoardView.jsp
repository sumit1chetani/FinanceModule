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
							<div class="form-group">
								<label class="col-md-4 control-label"> Vessel </label>
								<div class="col-md-5">{{onBoard.vessel}}</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Port  </label>
								<div class="col-md-5">{{onBoard.port}}</div>
							</div>

<div class="form-group">
								<label class="col-md-4 control-label"> Created By </label>
								<div class="col-md-5">{{onBoard.created_by}}</div>
							</div>

<div class="form-group">
								<label class="col-md-4 control-label"> Created Date </label>
								<div class="col-md-5">{{onBoard.created_date}}</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>


							<div class="form-group">
								<label class="col-md-4 control-label">Voyage </label>
								<div class="col-md-5">{{onBoard.voyage}}</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Date </label>
								<div class="col-md-5">{{onBoard.onBoardDate}}</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Modified By </label>
								<div class="col-md-5">{{onBoard.modified_by}}</div>
							</div>

<div class="form-group">
								<label class="col-md-4 control-label"> Modified Date </label>
								<div class="col-md-5">{{onBoard.modified_date}}</div>
							</div>
							
						</fieldset>
					</div>
				</div>

				<div class="panel-body">
						<div class="table-responsive"  id="Containerdetail">
							<div class="col-md-12" style="width: 130%;">

								<div class="row" id="items">
								<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												<th colspan=1 class="width_1">Select</th>
								<th colspan=1 class="width_1 text-center">SL No</th>
								<th colspan=1 class="width_5 text-center">BL No</th>
								<th colspan=1 class="width_5 text-center">Booking No</th>
								<th colspan=1 class="width_5 text-center">Customer Name</th>
						<!-- 		<th colspan=1 class="width_10 text-center">Customer Type</th> -->
								<th colspan=1 class="width_5 text-center">Container Type</th>
								<th colspan=1 class="width_5 text-center">Container No</th>
								<th colspan=1 class="width_5 text-center">SOC</th>
								<th colspan=1 class="width_12 text-center">OnBoard Date</th>
								<th colspan=1 class="width_5 text-center">Slot Operator</th>
								<th colspan=1 class="width_5 text-center">Seal No</th>
								<th colspan=1 class="width_5 text-center">Package Type</th>
								<th colspan=1 class="width_5 text-center">No Of Pkgs</th>
								<th colspan=1 class="width_5 text-center">Pod</th>
									<th colspan=1 class="width_1 text-center">T/s Leg</th>
											</tr>
										</thead>
										<tbody ng-repeat="(trIndex,row) in onBoard.containerDtl">
											<tr>
												<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td style="text-align:center">{{row.slno}}</td>
								<td style="text-align:center">{{row.blNo}}</td>
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
								
								<input type="text" class="form-control input-sm"
										name="onboardStatusDate" 
										property="row.onboardStatusDate" ng-model="row.onboardStatusDate"  disabled="disabled" />
								</td>
								<td style="text-align:center"><selectivity list="slotList" disabled="true" 
										property="row.slotOperator" id="slotOperator{{trIndex}}" ng-model="row.slotOperator"
										name="slotOperator{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(slotOperator)'}}" ></selectivity></td>
								<td style="text-align:center">{{row.sealNo}}</td>
								<td style="text-align:center">{{row.packgeType}}</td>
								<td style="text-align:center">{{row.noOfPkgs}}</td>
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
							<div class="col-md-12" style="padding-left: 47%;">
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
							</div>
			

			</form>
		</div>
	</div>
</div>
