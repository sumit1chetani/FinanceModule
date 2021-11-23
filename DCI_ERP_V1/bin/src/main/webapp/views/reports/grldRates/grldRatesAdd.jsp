<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-0">
				<li><a>Reports</a></li>
				<li><a x-ui-sref="app.master.general">GR and LD Rates</a></li>
				<li><a ng-if="!grldRateData.edit">Add</a></li>
								<li><a ng-if="grldRateData.edit">Edit</a></li>
				
			</ol>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="grldRateForm" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

<div class="form-group">
								<label class="col-md-4 control-label"> Mode </label>
								<div class="col-md-5">
									<selectivity list="modeList"
										property="grldRateData.mode" id="mode"
										name="mode" ng-model="grldRateData.mode"
										object="mode" friendly-name="Mode"
										 form-name="quotationForm"
										></selectivity>
								</div>
							</div>


<div class="form-group">
								<label class="col-md-4 control-label"> Line </label>
								<div class="col-md-5">
									<selectivity list="line" property="grldRateData.line" id="line"
										ng-model="grldRateData.line" name="line"
										form-name="grldRateForm"></selectivity>
								</div>
							</div>



							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Agent<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
								
								<selectivity list="agentList" property="grldRateData.agent"
												id="currency{{trIndex}}" ng-model="grldRateData.agent"
												validation="required" name="agent"
												friendly-name="Agent"
												form-name="grldRateForm"></selectivity>
								
									<selectivity list="agentList" property="grldRateData.agent"
										id="agent" ng-model="grldRateData.agent" name="agent"
										form-name="grldRateForm" friendly-name="agent"></selectivity>
								</div>
							</div>
							 -->
							 
							 <div class="form-group">
								<label class="col-md-4 control-label"> Agent
								</label>
								<div class="col-md-5">
								
								<selectivity list="agentList" property="grldRateData.agent"
												id="currency{{trIndex}}" ng-model="grldRateData.agent"
											 name="agent"
												friendly-name="Agent"
												form-name="grldRateForm"></selectivity>
								
									<!-- <selectivity list="agentList" property="grldRateData.agent"
										id="agent" ng-model="grldRateData.agent" name="agent"
										form-name="grldRateForm" friendly-name="agent"></selectivity> -->
								</div>
							</div>
							
							 
							 
							 
							 
							 <div class="form-group">
								<label class="col-md-4 control-label"> Origin </label>
								<div class="col-md-5">
									<selectivity list="orginList" property="grldRateData.orgin"
										id="orgin" ng-model="grldRateData.orgin" name="orgin"
										form-name="grldRateForm" ></selectivity>
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Port <span style="color: red;">*</span>
								</label>
								<div class="col-md-5 "
										class="selectivity-input example-input selectivity-slot voyage_sel">
									<select id="portid" multiple="multiple" name="portid"
									friendly-name="Port"  form-name="grldRateForm"
										ng-model="grldRateData.portid" validation="required"
										ng-options="option.text for option in portList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in portList" 
											value="{{getOptionId(option)}}"
											data-ng-bind-template="{{option.portid}}"></option>
									</select>										
										 
									</div>
							</div>
							<!-- <div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Freight Element <span style="color: red;">*</span>
								</label>
								<div class="col-md-5 "
									class="selectivity-input example-input selectivity-slot voyage_sel">
									<selectivity list="freightElmnt" validation="required"
										property="grldRateData.freightElement" id="freightElement"
										ng-model="grldRateData.freightElement" name="freightElement"
										form-name="grldRateForm" friendly-name="Freight Element"></selectivity>
								</div>
							</div>
							 --><div class="form-group">
								<label for="inputPassword" class="col-md-4 control-label">Service
									Type</label>
								<div class="col-md-5">
									<div class="controls">
										<label class="radio inline"> <input id="lc_imp"
											name="lc_imp_exp" value="Import" type="radio" ng-model="grldRateData.serviceType"  property="grldRateData.serviceType"
											onclick="serviceTypeOnclick();" class="form-field-checkbox"
											checked="checked"> <span class=""> Import</span>
										</label> &nbsp &nbsp &nbsp &nbsp <label class="radio inline">
											<input id="lc_exp" name="lc_imp_exp" value="Export" ng-model="grldRateData.serviceType"  property="grldRateData.serviceType"
											type="radio" onclick="serviceTypeOnclick();"
											class="form-field-checkbox"> <span class="">
												Export</span>
										</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> From Date </label>
								<div class="col-md-5">
									<div class="input-group input-append date" id="fromDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'
											data-ng-model="grldRateData.fromDate" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> To Date</label>
								<div class="col-md-5">
									<div class="input-group input-append date" id="toDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'
											data-ng-model="grldRateData.toDate" />
									</div>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Line </label>
								<div class="col-md-5">
									<selectivity list="line" property="grldRateData.line" id="line"
										ng-model="grldRateData.line" name="line"
										form-name="grldRateForm"></selectivity>
								</div>
							</div>
 -->
 
 
 <div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Freight Element <span style="color: red;">*</span>
								</label>
																<div class="col-md-5">
								
								<div class="col-md-10"
									class="selectivity-input example-input selectivity-slot voyage_sel">
									<selectivity list="freightElmnt" validation="required"
										property="grldRateData.freightElement" id="freightElement"
										ng-model="grldRateData.freightElement" name="freightElement"
										form-name="grldRateForm" friendly-name="Freight Element"></selectivity>
								</div>
							</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Customer <span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<div class="col-md-10 "
										class="selectivity-input example-input selectivity-slot voyage_sel">
									<select id="customerid" multiple="multiple" name="customerid" friendly-name="Customer" validation="required"
										ng-model="grldRateData.customerid"  property="grldRateData.customerid"
										ng-options="option.text for option in customerList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in customerList"
											value="{{getOptionId(option)}}"
											data-ng-bind-template="{{option.id}}"></option>
									</select>										
										 
									</div>
								</div>
							</div>


						</fieldset>


					</div>
				</div>
				<br>


				<div class="table-responsive clear" ng-class="{view : isView}">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th ng-hide="hide" colspan=1 class="width_15 text-center">Container Type</th>
								<th colspan=1 class="width_15 text-center">Stuffing Status</th>
								<th colspan=1 class="width_15 text-center">Currency</th>
								<th colspan=1 class="width_15 text-center">Slab</th>

								<th colspan=1 class="width_1"></th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in grldRateData.grldRateTableDetail"
							>

							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select"><i></i></label></td>
								<td ng-hide="hide" class="">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="containertypeList" property="row.containerType"
												id="containerType{{trIndex}}" ng-model="row.containerType"
												validation="required" name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Container Type)'}}"
												form-name="grldRateForm"></selectivity>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="stuffingStatusList" property="row.stuffingStatus"
												id="stuffingStatus{{trIndex}}" ng-model="row.stuffingStatus"
												validation="required" name="{{ 'stuffingStatus' + $index }}"
												friendly-name="{{ 'Row' + $index + '(Stuffing Status)'}}"
												form-name="grldRateForm"></selectivity>
										</div>
									</div>
								</td>
								
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="currencyList" property="row.currency"
												id="currency{{trIndex}}" ng-model="row.currency"
												validation="required" name="{{ 'currency' + $index }}"
												friendly-name="{{ 'Row' + $index + '(currency)'}}"
												form-name="grldRateForm"></selectivity>
										</div>
									</div>
								</td>
								
								<td class="text-center">
													<button ng-click="addinnergrldDtl(row)"
														class="btn btn-info" tooltip="Add Row" type="button">
														<i class="fa fa-plus"></i>
													</button>
												</td>

							</tr>
							
							<tr>
												<td></td>
												<td colspan="12">
													<table class="table table-striped b-t b-light">	
						                       <thead>
														<tr>
															<th class="width_2 text-center subTable-brs">From</th>
															<th class="width_2 text-center subTable-brs">To</th>
															<th class="width_2 text-center subTable-brs">Rate/Day</th>
															

															<th class="width_2 text-center subTable-brs">Action</th> 
														</tr>
														</thead> 
														
															<tbody ng-repeat="(bTrIndex, rowDtl) in row.chargeList">
															
															<td class="subTable-brs text-center"><input class="form-control"
																type="text" name="from" id="from"
																ng-model="rowDtl.from"  property="rowDtl.from"placeholder="0"></td>
															
															<td class="subTable-brs text-center"><input class="form-control"
																type="text" name="to" id="to"
																ng-model="rowDtl.to"property="rowDtl.to"placeholder="0"></td>
															<td class="subTable-brs"><input class="form-control"
																type="text" name="rateperday" id="rateperday"
																ng-model="rowDtl.rateperday"property="rowDtl.rateperday"placeholder="0"></td>
														
															
														
															<td class="subTable-brs"><button
																	ng-click="deleteinnergrldDtl(row,bTrIndex)"
																	class="btn btn-sm btn-danger" type="button"
																	tooltip="Delete">
																	<i class="fa  fa-trash-o"></i>
																</button></td> 
														</tr>
													</table>
												</td>

											</tr>
					</table>
					 <div class="padding-right-5" id="AddOrRmvebtn">
           <button ng-click="addgrldRow(grldRateData.grldRateTableDetail)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
            <i class="fa fa-plus"></i>	
           </button>
           <button ng-click="removegrldRow(grldRateData.grldRateTableDetail)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
            <i class="fa  fa-trash-o"></i>
           </button>
      </div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-click="save(grldRateForm,grldRateData)"
								ng-if="!grldRateData.edit">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" type="button"
								ng-if="grldRateData.edit"
								ng-click="update(grldRateForm,grldRateData)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								ng-if="!grldRateData.edit" ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-info" type="button"
								ng-if="grldRateData.edit" ng-click="reset1()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="reset" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
