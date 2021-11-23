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
												<label class="col-md-4 control-label">Requested Date</label>
												<div class="col-md-7">
	<div class="input-group date datetimepick col-md-12">
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="date" role="button" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control" disabled="disabled"
																		placeholder="dd/mm/yyyy" form-name="staffCircularForm" 
																		name="Date" validation="required" friendly-name="Date" 
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
														<!-- <div class="form-group">
												<label class="col-md-4 control-label"> Source Location <span style="color: red;">*</span>
												</label>
											 	<div class="col-md-7">
													<selectivity list="parentLocationList" ng-model="local.sourceLocation" property="local.sourceLocation" id="sourceLocation" object="sourceLocation"  name="sourceLocation" validation="required" friendly-name="Source Store"  disabled="true" form-name = "consignmentRequestForm"></selectivity>
												</div>
												</div> -->

												<div class="form-group">
											<label class="col-md-4 control-label"> Destination Location <span style="color: red;">*</span></label>
											<div class="col-md-7">

												 <selectivity list="parentLocationList" ng-model="local.destinationLocation" property="local.destinationLocation" id="destinationLocation" object="destinationLocation"  name="destinationLocation" validation="required" friendly-name="Destination Store"  disabled="true" form-name = "consignmentRequestForm"></selectivity>

											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Cost Center <span style="color: red;">*</span></label>
											<div class="col-md-7">

												 <selectivity list="costList" ng-model="local.costcenter" property="local.costcenter" id="costcenter" object="costcenter"  name="costcenter" validation="required" friendly-name="Cost Center"  disabled="true" form-name = "consignmentRequestForm"></selectivity>

											</div>
										</div>




						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
											<label class="col-md-4 control-label"> Requested By </label>
											<div class="col-md-7">
												 <selectivity list="employeeList" property="local.employeeId" disabled="true"  id="employeeId" ></selectivity>
											</div>
										</div>
									
										<div class="form-group">
					        				<label class="col-md-4 control-label"> <%-- <spring:message
			              			code="label.company.name"></spring:message> --%>Organization Name <spring:message
					              			code="label.asterisk.symbol"></spring:message></label>
					        				<div class="col-md-7">
						        				<selectivity  list="companyList" property="local.companyId" id="companyId"
						        				ng-model="local.companyId" name="companyId" form-name = "consignmentRequestForm"
						        				disabled="true" validation="required" friendly-name="<spring:message
			              			code="label.company.name"></spring:message>"></selectivity>
											</div>
										</div>
											 <div class="form-group">
											<label class="col-md-4 control-label">Remarks</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="remarks" disabled="true" 
													ng-model="local.remarks"
													>
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
								<!-- <th colspan=1 class="width_15 text-center">Dock<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Berth<span
									style="color: red;"> </span></th> -->
								<th colspan=1 class="width_15 text-center">ItemName<span
									style="color: red;"> </span></th>

								<th colspan=1 class="width_10 text-center"
									>Item Category<span
									style="color: red;"> </span></th>
								<!-- <th colspan=1 class="width_15 text-center" ng-if="local.basis=='Size'">Container Size<span
									style="color: red;"> </span></th> -->
								<th colspan=1 class="width_10 text-center">UOM
									Mode<span style="color: red;"> </span>
								</th>
						
								<!-- <th colspan=1 class="width_15 text-center">Stuffing Status<span
									style="color: red;"> </span></th> -->
								<th colspan=1 class="width_10 text-center">Item Description<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_5 text-center">Quantity<span
									style="color: red;"> </span></th>
										<th colspan=1 class="width_5 text-center">EDD Date<span
									style="color: red;"> </span></th>
								<!-- <th colspan=1 class="width_15 text-center">Amount Line<span
									style="color: red;"> </span></th> -->
								<!-- <th colspan=1 class="width_15 text-center">slab Rate<span
									style="color: red;"> </span></th> -->


							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in local.localDtl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>

								<!-- <td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="dockList" property="row.dock"
												id="dock{{trIndex}}" data-ng-model="row.dock"
												name="dock{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(dock)'}}"
												form-name="localForm"></selectivity>

										</div>
									</div>
								</td>
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="berthList" property="row.berth"
												id="berth{{trIndex}}" data-ng-model="row.berth"
												name="berth{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(berth)'}}"
												form-name="localForm"></selectivity>

										</div>
									</div>
								</td> -->

								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="itemList" property="row.itemName"
												id="itemName{{trIndex}}" data-ng-model="row.itemName"
												name="itemName{{trIndex}}" disabled="true" 
												friendly-name="{{ 'Row' + $index + '(itemName)'}}"
												form-name="itemName"></selectivity>
										</div>
									</div>
								</td>
								<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.itemCategory"
												name="itemCategory{{trIndex}}" disabled="true" 
												friendly-name="{{ 'Row' + $index + '(itemCategory)'}}" />
										</div>
									</div>
								</td>
								<!-- 	<td class="width_15" ng-if="local.basis=='Size'">
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="containerSizeList"
												property="row.containerSize" id="containerSize{{trIndex}}"
												data-ng-model="row.containerSize"
												name="containerSize{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerSize)'}}"
												form-name="localForm"></selectivity>

										</div>
									</div>
								</td>-->

							<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.uom"
												name="uom{{trIndex}}" disabled="true" 
												friendly-name="{{ 'Row' + $index + '(uom)'}}" />
										</div>
									</div>
								</td>


								<!-- <td class="width_5" align="center">
									<div class="row">

										<input type="checkbox" data-ng-model="row.hazardous"
											id="hazardous" name="hazardous{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(hazardous)'}}">


									</div>
								</td> -->
								<!-- <td class="width_15" align="center">
									<div class="row">

										<input type="checkbox" data-ng-model="row.empty"
											id="empty" name="empty{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(empty)'}}">


									</div>
								</td> -->
							<!-- 	<td class="width_5" align="center">
									<div class="row">

										<input type="checkbox" data-ng-model="row.oog" id="oog"
											name="oog{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(oog)'}}">


									</div>
								</td> -->
<!-- 
								<td class="width_15" align="center">
									<div class="row">

										<div class="" style="margin-left: -120px;">
											<div class="radio radio-inline" style="padding-left: 0px;">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0" ng_model="row.type" value="Import"
													name="type{{trIndex}}" checked="checked"> <i></i>
													Import
												</label>
											</div>
										</div>
										<div class="" style="margin-left: 15%; margin-top: -20px;">
											<div class="radio radio-inline" style="padding-left: 0px;">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0" 
													ng_model="row.type" value="Export" name="type{{trIndex}}"
													checked="checked"> <i></i> Export
												</label>
											</div>
										</div>
										<div class="" style="margin-left: 68%; margin-top: -20px;">
											<div class="radio radio-inline" style="padding-left: 0px;">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0" 
													ng_model="row.type" value="T_S" name="type{{trIndex}}"
													checked="checked"> <i></i> T/S
												</label>
											</div>
										</div>
									</div>
								</td> -->
								<!-- 	<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="stuffList" property="row.stuffing"
												id="stuffing{{trIndex}}" data-ng-model="row.stuffing"
												name="stuffing{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(stuffing)'}}"
												form-name="localForm"></selectivity>
										</div>
									</div>
								</td> -->
							<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.description"
												name="description{{trIndex}}" disabled="true" 
												friendly-name="{{ 'Row' + $index + '(description)'}}" />
										</div>
									</div>
								</td>
								<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.quantity"
												name="quantity{{trIndex}}" disabled="true" 
												friendly-name="{{ 'Row' + $index + '(quantity)'}}" />
										</div>
									</div>
								</td>
												<td class="width_10">
																<div class="row">
																	<div class='input-group date datetimepick col-md-12'>
																		<div class="dropdown">
																				<a class="dropdown-toggle" id="eddDate{{trIndex}}" role="button"
																					data-toggle="dropdown" data-target="#" href="#">
																					<div class="input-group">
																						<input type="text" class="form-control" disabled="true" 
																							placeholder="dd/mm/yyyy"
																							name="{{ 'eddDate' + trIndex }}"
																							id="{{ 'eddDate' + trIndex }}"
																							friendly-name="{{ 'Row' + (trIndex+1) + 'EDD Date'}}"
		       																				validation="required"
																							data-ng-model="row.eddDate"> <span
																							class="input-group-addon"> <i
																							class="glyphicon glyphicon-calendar"></i>
																						</span>
																					</div>
																				</a>
																				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel" style="top:-100px;">
																					<datetimepicker data-ng-model="row.eddDate"
																						data-on-set-time="row.eddDate = onDateSet(newDate)"
																						data-datetimepicker-config="{ dropdownSelector: '#eddDate{{trIndex}}',startView:'day', minView:'day'}" />
																				</ul>
																			</div>
																		</div>
																	</div>
																</td>
								<!-- <td class="width_15">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.amountline"
												name="amountline{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(amountline)'}}" />
										</div>
									</div>
								</td> -->
								<!-- <td class="width_15">
									<div class="col-xs-3 pull-left">
										<label class="line-height-30 cursor-pointer"
											data-ng-click="showSlabPopup()"> <i
											class="fa fa-expand"></i>
										</label>
									</div>
								</td> -->


							</tr>
					<!-- 		<tr ng-if="local.slab">
								<td></td>
								slabRate
								<td colspan="15">
									<h4>Slab Rate</h4>
									<table class="table table-striped b-t b-light"
										style="width: 56%;">

										<tr style="background-color: #dae8f6;">
												<th colspan=1 class="width_1 text-center"></th>
											<th colspan=1 class="width_1 text-center"></th>
											<th colspan=1 class="width_9 text-center">ItemName<span
												style="color: red"></span></th>
											<th colspan=1 class=" width_9 text-center">Description<span
												style="color: red"></span></th>
											<th colspan=1 class=" width_9 text-center">quantity<span
												style="color: red"></span></th>
											<th colspan=1 class=" width_9 text-center">Action<span
												style="color: red">*</span></th>
											 <th colspan=1 class="width_9 text-center"></th>

										</tr>
										<tbody ng-repeat="(trIndex1, row1) in row.slabRate">
											<tr>
												<td class=" width_1"></td>
												<td><label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="row1.select"
														id="section{{trIndex1}}"> <i></i>
												</label></td>
												<td class=" width_9"><input type="text"
													class="form-control input-sm" maxlength=255
													data-ng-model="row1.from" name="from{{trIndex1}}"
													friendly-name="{{ 'Row' + $index + '(from)'}}" /></td>

												<td class=" width_9"><input type="text"
													class="form-control input-sm" maxlength=255
													data-ng-model="row1.to" name="to{{trIndex1}}"
													friendly-name="{{ 'Row' + $index + '(to)'}}" /></td>


												<td class=" width_9"><input type="text"
													class="form-control input-sm" maxlength=255
													data-ng-model="row1.rateDay" name="rateDay{{trIndex1}}"
													friendly-name="{{ 'Row' + $index + '(rateDay)'}}" /></td>
												<td class=" width_9"></td>



											</tr>

											detail

										</tbody>



									</table>
									<button ng-click="addSlab(row,trIndex)"
										class="btn btn-sm btn-info" type="button">
										<i class="fa fa-plus"></i>
									</button>
									<button ng-click="removeSlab(row,trIndex)"
										class="btn btn-sm btn-danger" type="button">
										<i class="fa  fa-trash-o"></i>
									</button>



								</td>

							</tr> -->

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
					<table class="table table-striped b-t b-light" style="width: 60%;">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>

								<th colspan=1 class="width_15 text-center">Item Name<span
									style="color: red;"> </span></th>

								<!-- <th colspan=1 class="width_15 text-center" ng-if="local.basis=='Type'">Container Type<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center" ng-if="local.basis=='Size'">Container Size<span
									style="color: red;"> </span></th> -->
								<th colspan=1 class="width_15 text-center">Item Description<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Quantity<span
									style="color: red;"> </span></th>
							<!-- 	<th colspan=1 class="width_15 text-center">Amount<span
									style="color: red;"> </span></th> -->
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex1,row5) in local.localDtl1">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row5.select" id="section{{trIndex1}}"><i></i></label></td>
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="itemList" property="row5.itemName"
												id="itemName{{trIndex1}}" data-ng-model="row5.itemName"
												name="itemName{{trIndex1}}" disabled="true" 
												friendly-name="{{ 'Row' + $index + '(itemName)'}}"
												form-name="itemName"></selectivity>
										</div>
									</div>
								</td>
								<!-- <td class="width_15" ng-if="local.basis=='Type'">
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="containerType"
												property="row.containerType" id="containerType{{trIndex1}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="localForm"></selectivity>

										</div>
									</div>
								</td>
									<td class="width_15" ng-if="local.basis=='Size'">
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="containerSizeList"
												property="row.containerSize" id="containerSize{{trIndex}}"
												data-ng-model="row.containerSize"
												name="containerSize{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerSize)'}}"
												form-name="localForm"></selectivity>

										</div>
									</div>
								</td> -->

								<!-- 	<td class="width_15">
									<div class="row">

											<selectivity list="modeType"
												property="row.mode" id="mode{{trIndex}}"
												data-ng-model="row.mode"
												name="mode{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(mode)'}}"
												form-name="localForm"></selectivity>

									</div>
			<!-- 					</td> -->
				<!-- 	<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.description"
												name="description{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(description)'}}" />
										</div>
									</div>
								</td>
							<td class="width_5">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.quantity"
												name="quantity{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(quantity)'}}" />
										</div>
									</div>
								</td> --> -->
						 	<td class="width_15">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row5.description"
												name="description{{trIndex1}}" disabled="true" 
												friendly-name="{{ 'Row' + $index + '(description)'}}" />
										</div>
									</div>
								</td> 
								 	<td class="width_15">
									<div class="row">
										<div class="col-xs-16">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row5.quantity"
												name="quantity{{trIndex1}}" disabled="true" 
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
						
							<button class="btn btn-success" type="button" ng-if="isEdit"
								class="btn btn-success" ng-click="Publish(localForm,local)">
								<i class="fa fa-save"></i> Publish
							</button>
							
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel1()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>




			</form>
		</div>
	</div>
</div>





