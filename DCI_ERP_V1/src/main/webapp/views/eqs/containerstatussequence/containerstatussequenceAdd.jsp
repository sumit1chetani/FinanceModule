
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="containerstatussequenceForm" class="form-horizontal"
				novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">CMS Code <span
									style="color: red;">*</span></label>
								<div class="col-md-5" ng-if="!isEdit">
									<selectivity list="sequenceList"
										property="containerstatussequence.sequenceS" id="sequenceS"
										name="sequenceS" ng-model="containerstatussequence.sequenceS"
										validation="required" friendly-name="Sequence"
										form-name="containerstatussequenceForm"></selectivity>
								</div>
								<div class="col-md-5" ng-if="isEdit">
									<input type="text" style="width: 95%" ng-model="containerstatussequence.sequence"
										disabled/>
								</div>
							</div>

							<div class="form-group" ng-if="!isEdit">
								<label class="col-md-4 control-label"> Next Move </label>
								<div class="col-md-5">
									<select id="port" multiple="multiple" name="port"
										ng-model="containerstatussequence.sequenceM"
										ng-options="option.text for option in portList"
										friendly-name="Port" data-dropdownmultiselect>
										<option data-ng-repeat="option in portList"
											value="{{getOptionId(option)}}"
											ng-selected="isOptionSelected(option)"
											data-ng-bind-template="{{option.text}}"></option>
									</select>
								</div>
							</div> <br/><br/><br/>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset></fieldset>
					</div>
				</div>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<!-- <th colspan=1 class="width_1">Select</th> -->
								<th colspan=1 class="width_15 text-center">Possible CMS Code<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_20 text-center">Description<span
									style="color: red;"> </span></th>

							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex,row) in containerstatussequence.sequenceM">
							<tr>
								<!-- <td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td> -->

								<td class="width_20">
									<div class="row">
										<div class="col-xs-12">


											<input type="text" class="form-control input-sm" name="id"
												id="id{{trIndex}}" data-ng-model="row.id"
												form-name="containerstatussequenceForm" />

										</div>
									</div>
								</td>

								<td class="width_20">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" name="text"
												id="text{{trIndex}}" data-ng-model="row.text"
												form-name="containerstatussequenceForm" />



										</div>
									</div>
								</td>

							</tr>
						</tbody>


					</table>
					<!-- <div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addCredRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCredRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div> -->
					<br> <br> <br>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit"
								class="btn btn-success"
								ng-click="save(containerstatussequenceForm,containerstatussequence)">
								<i class="fa fa-save"></i> Save

							</button>
							<!-- <button class="btn btn-success" type="button" ng-if="isEdit"
								class="btn btn-success"
								ng-click="update(containerstatussequenceForm,containerstatussequence)">
								<i class="fa fa-save"></i> Update
							</button> -->
							<button class="btn btn-info" type="button" ng-if="!isEdit"
								data-ng-click="reset(containerstatussequenceForm)">
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
