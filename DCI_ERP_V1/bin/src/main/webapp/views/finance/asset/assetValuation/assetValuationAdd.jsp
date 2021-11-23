<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- #MAIN CONTENT -->
<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i></span> <span><state-breadcrumbs></state-breadcrumbs>
						</span>
						<div class="widget-toolbar">
							<div>
								<span> <span class="button-icon" data-placement="bottom"
									data-reset-widgets rel="tooltip"
									title="<spring:message code='title.widget.reset'></spring:message>">
										<i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="assetValuationForm"
								method="post" novalidate>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="col-md-6">

												<div class="form-group">
													<label class="col-md-4 control-label">Item Category
														<span style="color: red;">*</span>
													</label>
													<div class="col-md-7">
														<selectivity list="MyItemList" disabled="edit"
															property="assetValue.itemCategoryId" id="itemCategoryId"
															ng-model="assetValue.itemCategoryId"
															object="itemCategoryId"
															name="itemCategoryId" validation="required"
															friendly-name="Item Category"
															form-name="assetValuationForm"></selectivity>
													</div>
												</div>


												<div class="form-group" ng-if="!edit">
													<label class="col-md-4 control-label">Item<span style="color: red;">*</span> </label>
													<div class="col-md-7">
														<selectivity list="ItemList"
															property="assetValue.itemId" id="itemId"
															ng-model="assetValue.itemId" name="itemId" 
															validation="required" object="itemId"
															friendly-name="Item Name"
															form-name="assetValuationForm"
															></selectivity>
													</div>
												</div>

												<div class="form-group" >
													<label class="col-md-4 control-label">Valuation
														Type <span style="color: red;">*</span>
													</label>
													<div class="radio radio-inline">
														<label class="i-checks"> <input type="radio"
															class="" name="depAppre" value="A" id="valuationTypeId" ng-click ="valType()"
															 ng-model="assetValue.depAppre" ng-change="percentageAgg()">
															<i></i> Appreciation
														</label>
													</div>
													<div class="radio radio-inline">
														<label class="i-checks" style="margin-left: -11px;">
															<input type="radio" class="" name="depAppre" value="D"
															id="valuationTypeDepId" ng-click ="valType()"
															ng-model="assetValue.depAppre" ng-change="percentageDeg()"> <i></i>
															Depreciation
														</label>
													</div>
												</div>
												<!-- <div class="form-group" ng-if="edit">
													<label class="col-md-4 control-label">Valuation
														Type</label>
													<div class="radio radio-inline">
														<label class="i-checks"> <input type="radio"
															class="" name="depAppre" value="A" id="valuationTypeId"
															disabled ng-model="assetValue.depAppre"> <i></i>
															Appreciation
														</label>
													</div>
													<div class="radio radio-inline">
														<label class="i-checks" style="margin-left: -11px;">
															<input type="radio" class="" name="depAppre" value="D"
															id="valuationTypeDepId" disabled
															ng-model="assetValue.depAppre"> <i></i>
															Depreciation
														</label>
													</div>
												</div> -->

												<div class="form-group" style="display: none;">
												<label class="col-md-4 control-label">Number Of Valuation
													</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="Name" data-ng-model="assetValue.noa" 
														object="Name" id="Name"
														readonly>
												</div>
											</div>
											
											
											<div class="form-group">
												<label class="col-md-4 control-label">Number Of Valuation
													</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="Name" data-ng-model="hidden.noa" readonly>
												</div>
											</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Valuation
														Date</label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="startDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="From Date"
																			data-message-id="From Date"
																			data-ng-model="assetValue.startDate"> <span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="assetValue.startDate"
																		data-on-set-time="assetValue.startDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#startDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Next Period
														of Deprecation <span style="color: red;">*</span> </label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="nextdate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="Next Date"
																			data-message-id="Next Date" validation="date_euro_long|required" friendly-name="Next Period Date"
																			data-ng-model="assetValue.nextDate"> <span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="assetValue.nextDate"
																		data-on-set-time="assetValue.nextDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#nextdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
												
												<div class="form-group" ng-show = "endDate">
													<label class="col-md-4 control-label"> End Date 
														 </label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="enddate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="End Date"
																			data-message-id="End Date"  
																			data-ng-model="assetValue.endDate"> <span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="assetValue.endDate"
																		data-on-set-time="assetValue.endDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#enddate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
												
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-4 control-label">Current
														Purchase Value <span style="color: red;">*</span>
													</label>
													<div class="col-md-7">
														<input type="text"
															class="form-control input-sm text-right"
															id="currPurValue" object="currPurValue"
															name="currPurValue" validation="required"
															friendly-name="Purchase Value"
															form-name="assetValuationForm"
															data-ng-model="assetValue.currPurValue"
															ng-change="currValue()" ng-disabled = "edit">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Amount Already
														Appreciated</label>
													<div class="col-md-7">
														<input type="text"
															class="form-control input-sm text-right" name="Name"
															data-ng-model="assetValue1.amtaggr" placeholder="0"
															readonly>
													</div>
												</div>


												<div class="form-group">
													<label class="col-md-4 control-label">Amount Already
														Depreciated </label>
													<div class="col-md-7">
														<input type="text"
															class="form-control input-sm text-right" name="Name"
															data-ng-model="assetValue1.amtdep" placeholder="0"
															"
														 readonly>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Current
														Value </label>
													<div class="col-md-7">
														<input type="text"
															class="form-control input-sm text-right"
															name="<spring:message code="label.degressive.factor"></spring:message>"
															data-ng-model="assetValue1.currValue" readonly>
													</div>
												</div>
												
												
												
												<div class="form-group" id="depFactor" style="display: none"
													ng-if="!detailEdit>
												<!-- id="
													depFactor" style="display: none"-->
													<label class="col-md-4 control-label"> <spring:message
															code="label.degressive.factor"></spring:message>
													</label>
													<div class="col-md-6">
														<input type="text"
															class="form-control input-sm text-right"
															name="<spring:message code="label.degressive.factor"></spring:message>"
															data-ng-model="assetValue1.deggressiveFactor" readonly
															ng-change="percentageDeg()">
													</div>
													<div class="col-md-1">
														<label class="control-label">%</label>
													</div>
												</div>

												<%-- <div class="form-group" id="depFactor" style="display: none"
													ng-if="detailEdit>
												<!-- id="
													depFactor" style="display: none"-->
													<label class="col-md-4 control-label"> <spring:message
															code="label.degressive.factor"></spring:message>
													</label>
													<div class="col-md-6">
														<input type="text"
															class="form-control input-sm text-right"
															name="<spring:message code="label.degressive.factor"></spring:message>"
															data-ng-model="assetValue1.deggressiveFactor"
															ng-change="percentageDeg()">
													</div>
													<div class="col-md-1">
														<label class="control-label">%</label>
													</div>
												</div> --%>

												<div class="form-group" id="aggFactor">
													<!-- style = "display: none" -->
													<label class="col-md-4 control-label"
														ng-if="assetValue.depAppre == 'A'"> Aggressive
														Factor <span style="color: red;">*</span></label> <label class="col-md-4 control-label"
														ng-if="assetValue.depAppre == 'D'"> <spring:message
															code="label.degressive.factor"> </spring:message><span style="color: red;">*</span>
													</label>
													<div class="col-md-6">
														<input type="number"
															class="form-control input-sm text-right"
															ng-if="assetValue.depAppre == 'A'"  ng-disabled="disfac"
															name="<spring:message code="label.aggressive.factor"></spring:message>"
															data-ng-model="assetValue1.aggressiveFactor"
															 ng-change="percentageAgg()" min=0 max=100  validation="max:100|numeric|required" friendly-name="Factor">
														<input type="number"
															class="form-control input-sm text-right"
															ng-if="assetValue.depAppre == 'D'"  ng-disabled="disfac"
															name="<spring:message code="label.degressive.factor" ></spring:message>"
															data-ng-model="assetValue1.aggressiveFactor"
															 ng-change="percentageDeg()" min=0 max=100  validation="max:100|numeric|required" friendly-name="Factor">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">After
														Valuation</label>
													<div class="col-md-7">
														<input type="text"
															class="form-control input-sm text-right" name="Name"
															data-ng-model="assetValue1.afterValuation" readonly>
													</div>
												</div>
											</div>
										</fieldset>
										

										<div class="form-actions">
											<div class="row">
												<div class="col-md-12">
													<button class="btn btn-success" type="button"
														ng-if="!detailEdit" ng-disabled="addVal"
														data-ng-click="save(assetValuationForm,assetValue,assetValue1)">
														<i class="fa fa-save"></i> Add
													</button>

													<button class="btn btn-success" type="button"
														ng-if="detailEdit"
														data-ng-click="update(assetValuationForm,assetValue,assetValue1)">
														<i class="fa fa-save"></i> Update
													</button>
												</div>
											</div>
										</div>
										<br>
										</div>
										</div>
										<tabset>
										<br>
										<tab heading="Asset Valuation">
										<br>
										<div
											class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all padding-top-10"
											data-st-table="displayedCollection1"
											data-st-safe-src="rowCollection1">
											<table id="dt_basic"
												class="table table-striped table-bordered table-hover dataTable no-footer"
												role="grid" aria-describedby="dt_basic_info">
												<thead class="dataTables-Main-Head">
													<tr>
														<th class="width_1 table-heading text-center"><label
															class="i-checks m-b-none"> <input type="checkbox">
																<i></i>
														</label></th>
														<th class="sorting width_7">Amount Appreciated</th>
														<th class="sorting width_7">Amount Depreciated</th>
														<th class="sorting width_7">Current Value</th>
														<th class="sorting width_7">Factor %</th>
														<th class="sorting width_7">After Valuation</th>
														<th class="sorting width_7">Check Valuation</th>
													</tr>
												</thead>
												<tbody>
													<tr ng-repeat="valuationDtl in assetValue.assetValuation">
														<td><label class="i-checks m-b-none"> <input
																type="checkbox" ng-model="tableSelection[$index]"
																id="section$index"><i></i></label></td>
														<td>{{valuationDtl.amtaggr}}</td>
														<td>{{valuationDtl.amtdep}}</td>
														<td>{{valuationDtl.currValue}}</td>
														<td>{{valuationDtl.aggressiveFactor}}</td>
														<td>{{valuationDtl.afterValuation}}</td>
														<td class="width_5">
															<button class="btn btn-sm ng-scope" type="button"
																class="btn btn-success"
																ng-click="EditVal(valuationDtl, $index)"
																ng-disabled="!$last">
																<i class="fa  fa-pencil text-success text"></i>
															</button> <span ng-if="$last"
															ng-init="addDepricate(valuationDtl.amtdep);"></span>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
										</tab> <tab heading="Track Information">
										<br>
										<div id="AssetTrackDetails">
											<div
												class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all padding-top-10"
												data-st-table="displayedCollection"
												data-st-safe-src="rowCollection">
												<table id="dt_basic"
													class="table table-striped table-bordered table-hover dataTable no-footer"
													role="grid" aria-describedby="dt_basic_info">
													<thead class="dataTables-Main-Head">
														<tr>
															<th class="width_1 table-heading text-center"><label
																class="i-checks m-b-none"> <input
																	type="checkbox"> <i></i>
															</label></th>
															<th class="sorting width_7">Asset Track No</th>
															<th class="sorting width_7">Asset Name</th>
															<th class="sorting width_7">Serial No</th>
															<th class="sorting width_7">Asset Location</th>
															<th class="sorting width_7">Responsible</th>
															<th class="sorting width_7">Asset User</th>
														</tr>
														<tr data-ng-class="trIndex % 2 == 0? 'even' : 'odd'"
															data-ng-repeat="(trIndex, row) in displayedCollection">
															<td><label class="i-checks m-b-none"><input ng-disabled = "edit" ng-change="stateChanged(row.assetTrackConfirm)"
																	type="checkbox"  data-ng-model="row.assetTrackConfirm">
																	<i></i></label></td>
															<td>{{row.assettrackNo}}</td>
															<td>{{row.assettrackName}}</td>
															<td>{{row.serialNo}}</td>
															<td>{{row.asstlocation}}</td>
															<td>{{row.resAsset}}</td>
															<td>{{row.user}}</td>
														</tr>
													</thead>
												</table>
											</div>
										</div>

										</tab> </tabset>
										<div class="form-actions">
											<div class="row">
												<div class="col-md-12">
													<button class="btn btn-success" type="button" ng-if="!edit"
														data-ng-click="saveAll(assetValuationForm,assetValue,assetValue1,rowCollection)">
														<i class="fa fa-save"></i>
														<spring:message code="label.save"></spring:message>
													</button>
													<button class="btn btn-success" type="button" ng-if="edit"
														data-ng-click="saveAll(assetValuationForm,assetValue,assetValue1,rowCollection)">
														<i class="fa fa-save"></i>
														<spring:message code="label.update"></spring:message>
													</button>
													<button class="btn btn-danger" type="button"
														class="btn btn-success" data-ng-click="cancel();">
														<i class="fa fa-close"></i>
														<spring:message code="label.cancel"></spring:message>
													</button>
												</div>
											</div>
										</div>
							</form>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>