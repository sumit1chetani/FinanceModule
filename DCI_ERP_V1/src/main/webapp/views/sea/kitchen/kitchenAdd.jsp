<style>
input.check-box-style {
	margin-left: 90px;
	width: 40px;
	height: 22px;
}
</style>



<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<div class="panel-body">
			<form name="localForm" class="form-horizontal" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

										<div class="form-group">
					        				<label class="col-md-4 control-label"> <%-- <spring:message
			              			code="label.company.name"></spring:message> --%>Organization Name <span style="color: red;">*</span></label>
					        				<div class="col-md-7">
						        				<selectivity list="companyList" property="local.companyId" id="companyId" validation="required" 
						        				ng-model="local.companyId" name="companyId" form-name = "localForm"
						        				validation="required" friendly-name="Organization Name"></selectivity>
											</div>
										</div>
																	
														<div class="form-group">
												<label class="col-md-4 control-label"> Source Location <span style="color: red;">*</span>
												</label>
											 	<div class="col-md-7">
													<selectivity list="parentLocationList" ng-model="local.sourceLocation" property="local.sourceLocation" id="sourceLocation" object="sourceLocation"  name="sourceLocation" validation="required" friendly-name="Source Location" form-name = "localForm"></selectivity>
												</div>
												</div>

												<div class="form-group">
											<label class="col-md-4 control-label"> Destination Location <span style="color: red;">*</span></label>
											<div class="col-md-7">

												 <selectivity list="parentLocationList" ng-model="local.destinationLocation" property="local.destinationLocation" id="destinationLocation" object="destinationLocation"  name="destinationLocation" validation="required" friendly-name="Destination Location" form-name = "localForm"></selectivity>

											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Cost Center <span style="color: red;">*</span></label>
											<div class="col-md-7">

												 <selectivity list="costList" ng-model="local.costcenter" property="local.costcenter" id="costcenter" object="costcenter"  name="costcenter" validation="required" friendly-name="Cost Center" form-name = "localForm"></selectivity>

											</div>
										</div>




						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
											<label class="col-md-4 control-label"> Requested By </label>
											<div class="col-md-7">
												 <selectivity list="employeeList" property="local.employeeId" id="employeeId" form-name = "localForm"></selectivity>
											</div>
										</div>
									<div class="form-group">
												<label class="col-md-4 control-label">Requested Date<span style="color: red;">*</span></label>
												<div class="col-md-7">
	<div class="input-group date datetimepick col-md-12">
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="date" role="button" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy"  form-name = "localForm"
																		name="Date" validation="required" friendly-name="Requested Date" 
																		data-ng-model="local.requisitionDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="local.requisitionDate"
																	data-on-set-time="local.requisitionDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#date',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
											 <div class="form-group">
											<label class="col-md-4 control-label">Remarks</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="remarks"  form-name = "localForm"
													ng-model="local.remarks">
											</div>
										</div> 
									<div class="form-group">
												<label class="col-md-4 control-label">Return Date</label>
												<div class="col-md-7">
											<div class="input-group date datetimepick col-md-12">
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="date" role="button" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy"  form-name = "localForm"
																		name="Date" friendly-name="Date" 
																		data-ng-model="local.returnDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="local.returnDate"
																	data-on-set-time="local.returnDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#date',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
							</div>
							<div></div>
						</fieldset>
					</div>
				</div>
				<label class="control-label">Out</label>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>
								<th colspan=1 class="width_15 text-center">ItemName<span
									style="color: red;"></span>
								</th>
								<th colspan=1 class="width_10 text-center"
									>Item Category<span
									style="color: red;"> </span>
								</th>
								<th colspan=1 class="width_10 text-center">UOM
									Mode<span style="color: red;"> </span>
								</th>
								<th colspan=1 class="width_10 text-center">Item Description<span
									style="color: red;"> </span>
								</th>
								<th colspan=1 class="width_5 text-center">Quantity<span style="color: red;">*</span><span
									style="color: red;"> </span>
								</th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in local.localDtl" ng-controller="outItemDetailCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="itemList" property="row.itemName"
												id="itemName{{trIndex}}" data-ng-model="row.itemName"
												name="itemName{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(itemName)'}}"
												 form-name = "localForm"></selectivity>
										</div>
									</div>
								</td>
								<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.itemCategory"
												name="itemCategory{{trIndex}}" disabled  form-name = "localForm"
												friendly-name="{{ 'Row' + $index + '(itemCategory)'}}" />
										</div>
									</div>
								</td>

							<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.uom"
												name="uom{{trIndex}}" disabled  form-name = "localForm"
												friendly-name="{{ 'Row' + $index + '(uom)'}}" />
										</div>
									</div>
								</td>
							<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.description"
												name="description{{trIndex}}"   form-name = "localForm"
												friendly-name="{{ 'Row' + $index + '(description)'}}" />
										</div>
									</div>
								</td>
								<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.quantity"  form-name = "localForm"
												name="quantity{{trIndex}}"  onkeypress="return event.charCode >= 48 && event.charCode <= 57"
												friendly-name="{{ 'Row' + $index + '(quantity)'}}" />
										</div>
									</div>
								</td>
							</tr>						
							</tbody>
					</table>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addCredRow(trIndex)" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button class="btn btn-sm btn-info" ng-click="addCredRow1()"
							style="display: none;" tooltip="ssssss Row" id="buttontemp"
							type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCredRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br> <br> <br>
				</div>
				<br>
				<br> <label class="control-label">In</label>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light" style="width: 100%;">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>
								<th colspan=1 class="width_15 text-center">Item Name<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_10 text-center"
									>Item Category<span
									style="color: red;"> </span>
								</th>
								<th colspan=1 class="width_10 text-center">UOM
									Mode<span style="color: red;"> </span>
								</th>
								<th colspan=1 class="width_10 text-center">Item Description<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_5 text-center">Quantity<span style="color: red;">*</span><span
									style="color: red;"> </span></th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex1,row5) in local.localDtl1" ng-controller="outItemDetailCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row5.select" id="section{{trIndex1}}"><i></i></label></td>
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="itemList" property="row5.itemName"
												id="itemName{{trIndex1}}" data-ng-model="row5.itemName"
												name="itemName{{trIndex1}}"
												friendly-name="{{ 'Row' + $index + '(itemName)'}}"
												 form-name = "localForm"></selectivity>
										</div>
									</div>
								</td>
								<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row5.itemCategory"
												name="itemCategory{{trIndex}}" disabled  form-name = "localForm"
												friendly-name="{{ 'Row' + $index + '(itemCategory)'}}" />
										</div>
									</div>
								</td>
							<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row5.uom"
												name="uom{{trIndex}}" disabled  form-name = "localForm"
												friendly-name="{{ 'Row' + $index + '(uom)'}}" />
										</div>
									</div>
								</td>								
						 	<td class="width_15">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row5.description"
												name="description{{trIndex1}}"   form-name = "localForm"
												friendly-name="{{ 'Row' + $index + '(description)'}}" />
										</div>
									</div>
								</td> 
								 	<td class="width_15">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row5.quantity"  form-name = "localForm"
												name="quantity{{trIndex1}}" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
												friendly-name="{{ 'Row' + $index + '(quantity)'}}" />
										</div>
									</div>
								</td> 

							</tr>
						</tbody>
					</table>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addCredRow1(trIndex1)"
							class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
							type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button class="btn btn-sm btn-info" ng-click="addCredRow1()"
							style="display: none;" tooltip="ssssss Row" id="buttontemp"
							type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCredRow1()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br> <br> <br>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit"
								class="btn btn-success" ng-click="save(localForm,local)">
								<i class="fa fa-save"></i> Save

							</button>
							<button class="btn btn-success" type="button" ng-if="isEdit"
								class="btn btn-success" ng-click="update(localForm,local)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset(localForm)">
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





