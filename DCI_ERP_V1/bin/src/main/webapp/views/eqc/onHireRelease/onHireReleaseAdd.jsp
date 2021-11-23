
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="onhireReleaseForm" class="form-horizontal" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Agreement Ref. No. <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="agreementRefno"
										property="onhireReleaseAdd.agreementRefno" id="agreementRefno_id"
										ng-model="onhireReleaseAdd.agreementRefno" name="agreementRefno_id"
										validation="required" friendly-name="agreementRefno" validation="required"
										form-name="onhireReleaseForm" required></selectivity>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Agent
								</label>
								<div class="col-md-5">
									<selectivity list="agent"
										property="onhireReleaseAdd.agent" id="agent_id"
										ng-model="onhireReleaseAdd.agent" name="agent_id"
										 friendly-name="agent"
										form-name="onhireReleaseForm"></selectivity>
								</div>
							</div> -->
						<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">Port
								</label>
								<div class="col-md-5">
									<selectivity list="port"
										property="onhireReleaseAdd.port" id="port_id"
										ng-model="onhireReleaseAdd.port" name="port_id"
										 friendly-name="port"
										form-name="onhireReleaseForm"></selectivity>
								</div>
							</div> -->
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Free Days(if any)</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="freeDays" id="freeDays"
										ng-model="onhireReleaseAdd.freeDays"
										friendly-name="FREEDAYS" />
								</div>
							</div>
						
	<div class="form-group">
								<label class="col-md-4 control-label">Reference No
								 <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="referenceNo" id="referenceNo"
										ng-model="onhireReleaseAdd.referenceNo"
										friendly-name="Ref No"	validation="required" />
								</div>
							</div>																																																																																													
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Release Ref. No. <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="releaseRefno" id="releaseRefno"
										ng-model="onhireReleaseAdd.releaseRefno" validation="required"
										friendly-name="releaseRefno" required disabled="disabled"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Agreement Party</label>
								<div class="col-md-5">
										<selectivity list="agreementPartyList" disabled="true"
										property="onhireReleaseAdd.agreementParty" id="agreementParty"
										ng-model="onhireReleaseAdd.agreementParty" name="agreementParty"
									 
										form-name="onhireReleaseForm" ></selectivity>
									<!-- 
									<input type="text" class="form-control input-sm"
										name="agreementParty" id="agreementParty"
										ng-model="onhireReleaseAdd.agreementParty" disabled= "disabled"
										friendly-name="agreementParty" /> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Lease Type </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="leaseType" id="leaseType"
										ng-model="onhireReleaseAdd.leaseType" disabled= "disabled"
										friendly-name="leaseType" />
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_15 text-center">Port<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Container Type<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_20 text-center">Release Qty<span
									style="color: red;"> </span></th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in onhireReleaseAdd.onHireReleaseDtl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								

								<td class="width_20">
									<div class="row">
										<div class="col-xs-12">
												<selectivity list="port"
												property="row.port"
												id="port{{trIndex}}"
												data-ng-model="row.port"
												name="port{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(port)'}}"
												form-name="onhireReleaseForm"></selectivity>
										</div>
									</div>
								</td>
								<td class="width_20">
									<div class="row">
										<div class="col-xs-12">
												<selectivity list="containerType"
												property="row.containerType"
												id="containerType{{trIndex}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="onhireReleaseForm"></selectivity>
										</div>
									</div>
								</td>
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.releaseQty" name="releaseQty{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(releaseQty)'}}" />
										</div>
									</div>
								</td>
								
							</tr>
						</tbody>
						<!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->

					</table>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addCredRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCredRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br> <br> <br>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!isEdit" class="btn btn-success"
								ng-click="save(onhireReleaseForm,onhireReleaseAdd)">
								<i class="fa fa-save"></i> Save

							</button>
							<button class="btn btn-success" type="button"
								ng-if="isEdit" class="btn btn-success"
								ng-click="update(onhireReleaseForm,onhireReleaseAdd)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset(onhireReleaseForm)">
								<i class="fa fa-undo"></i> Reset
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
