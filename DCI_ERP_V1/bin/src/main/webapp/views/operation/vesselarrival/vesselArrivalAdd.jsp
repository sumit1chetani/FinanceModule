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
										<selectivity list="modeList" ng-model="vesselArrival.mode"
											validation="required" friendly-name="Mode"
											property="vesselArrival.mode" id="mode" name="mode"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
							
							<div class="col-md-4" ng-if=vesselArrival.mode=="4">
								<div class="form-group">
									<label class="col-md-5 control-label">Carrier<span style="color:red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="carrierList" ng-model="vesselArrival.carrier"
											friendly-name="carrier"
											property="vesselArrival.carrier" id="carrier" name="carrier" validation="required"
											form-name="vessselArrivalForm"></selectivity>
											
									</div>
								</div>
							</div>
							<div class="col-md-4" ng-if=vesselArrival.mode!="4">
								<div class="form-group">
									<label class="col-md-5 control-label">Carrier</label>
									<div class="col-md-7">
										<selectivity list="carrierList" ng-model="vesselArrival.carrier"
											friendly-name="carrier"
											property="vesselArrival.carrier" id="carrier" name="carrier"
											form-name="vessselArrivalForm"></selectivity>
											
									</div>
								</div>
							</div>
							
<div class="col-md-4">
								<!-- Arrival date -->
								<div class="form-group">
								<label class="col-md-5 control-label">Arrival Date<span
										style="color: red;">*</span></label>
							<div class="col-md-7">
								<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="vesselArrival.arrivalDate" id="arrivalDate"
										name="arrivalDate" ng-model="vesselArrival.arrivalDate"  friendly-name="arrivalDate"/>
										</div>
							
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<!-- <div class="col-md-4">
								terminal
								<div class="form-group">
									<label class="col-md-5 control-label">Terminal Name<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<selectivity list="terminalList"
											ng-model="vesselArrival.terminal"
											friendly-name="Terminal" property="vesselArrival.terminal"
											id="terminal" name="terminal" form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div> -->



							
							<div class="col-md-4">
								<!-- vessel -->
								
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="vesselArrival.vessel"
											validation="required" friendly-name="vessel"
											property="vesselArrival.vessel" id="vessel" name="vessel"
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
										<selectivity list="voyageList" ng-model="vesselArrival.voyage"
											validation="required" friendly-name="Voyage"
											property="vesselArrival.voyage" id="Voyage" name="Voyage"
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
										<selectivity list="portList" ng-model="vesselArrival.port"
											validation="required" friendly-name="port"
											property="vesselArrival.port" id="port" name="port"
											form-name="vessselArrivalForm"></selectivity>
									</div>
								</div>
							</div>
						</fieldset>
					</div>


				</div>
				<div class="form-actions" ng-if=vesselArrival.mode!="4">
					<div class="row">
						<div class="col-md-12 ">
							<button class="btn btn-success"  ng-click="viewDetail()">
								<i class="fa fa-eye	"> </i>Show
							</button>
						</div>
					</div>
				</div>
				<br>
				<!-- ng-disabled="vesselArrival"  -->
				<div class="breadcrumb-wrapper ng-scope" ng-if=vesselArrival.mode!="4">

					<div class="table-responsive" style="border: 1px solid #CCC;">
						<div class="panel panel-default panel-default-list"
							st-table="displayedCollection" st-safe-src="rowCollection">
							<div class="panel-body float-left padding-0" style="width: 100%;">
								<div class="table-responsive"><br>
								<h3 style="margin-left:5px;">Loaded Container on Board Detail</h3><br>
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr role="row">
												<!-- <th class="width_1">Select</th> -->
												<th class="sorting width_5">Sl. No.</th>
												<th class="sorting width_10">Bl No</th>
												<th class="sorting width_10">Container Type</th>
												<th class="sorting width_10">Total No.of Containers</th>
												<th class="sorting width_10">No.of Full</th>												
												<th class="sorting width_10">No.of Empty</th>
												<th class="sorting width_10">Transit No.of Full</th>
												<th class="sorting width_5">Transit No.of Empty</th>

											</tr>
										</thead>

										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="(trIndex, listitems) in displayedCollection">
												<!--       <td class="width_1 text-center"><label
								class="i-checks m-b-none"> <input type="checkbox"
									name="selectedTypes[]" ng-model="objTranslationItem.check">
									<i></i>
							</label></td> -->
													 <td style="background-color: lightsalmon" class="sorting" data-toggle="tooltip">{{$index+1}}</td>
																					
													<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.blno}}" class="tool-tip-span"
													ng-bind="listitems.blno"></span></td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.containerType}}" class="tool-tip-span"
													ng-bind="listitems.containerType"></span></td>
												
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.totalCon}}" class="tool-tip-span"
													ng-bind="listitems.totalCon"></span></td>
												
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.fullDirect}}" class="tool-tip-span"
													ng-bind="listitems.fullDirect"></span></td>
												
												<td style="background-color: lightsalmon">
													<span tooltip="{{listitems.empDirect}}" class="tool-tip-span" 
													ng-bind="listitems.empDirect"></span></td> 
												
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.fullTransit}}"
													class="tool-tip-span" ng-bind="listitems.fullTransit"></span>
												</td>
												
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.empTransit}}" class="tool-tip-span"
													ng-bind="listitems.empTransit"></span></td>
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
										<tbody ng-repeat="(trIndex,row) in vesselArrival.count">
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
							<button class="btn btn-success" type="button" ng-disabled="showArrival" 
							ng-if="!isEdit"
								ng-click="saveData(vessselArrivalForm,vesselArrival)">
								<i class="fa fa-save"></i> Save
							</button>
							
							<button class="btn btn-success" type="button" ng-if="isEdit"
								ng-click="updateData(vessselArrivalForm,vesselArrival)">
								<i class="fa fa-save"></i>Update
							</button>
							
							<button class="btn btn-info" ng-if="!edit" type="reset"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
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
