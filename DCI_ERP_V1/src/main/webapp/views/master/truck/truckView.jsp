<style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.nav-justified>li, .nav-tabs.nav-justified>li:active {
	background-color: #fff;
}

.nav-tabs>li.active {
	background-color: #fff;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}

.nav>li>a:hover, .nav>li>a:focus {
	background-color: rgba(5, 120, 144, 0.16);
	color: #fff;
}
</style>

<div class="wrapper-md">
	
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<tabset justified="true" class="tab-container"> <tab
			heading="{{tabs[0].title}}">
		<div class="panel-body">
			<div class="col-sm-12">
				<div class="col-sm-11 alert alert-success alert-dismissable"
					ng-if="thumbsAlert">
					<button ng-if="error" type="button" class="close"
						data-dismiss="alert" aria-hidden="true">×</button>
					{{successMsg}}
				</div>
				<div class="col-sm-11 alert alert-danger alert-dismissable"
					ng-if="error">
					<button ng-if="error" type="button" class="close"
						data-dismiss="alert" aria-hidden="true">×</button>
					{{errorMsg}}
				</div>
			</div>
			<form class="form-horizontal form-border"  method="POST"
				name="truckform" novalidate">
				<div class="col-md-12">
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-md-4 control-label">Model
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="model"  maxlength="40"
									ng-model="truckData.model"  validation="required"   form-name="truckform" friendly-name="model" disabled="true">
							</div>
						</div>
						
												<div class="form-group">
							<label class="col-md-4 control-label"> Plate No.
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="licensePlate"  maxlength="50"
									ng-model="truckData.licensePlate"  validation="required"   form-name="truckform" friendly-name="licensePlate" disabled="true">
							</div>
						</div>
						
						
						
						<div class="form-group">
							<label class="col-md-4 control-label">Registration No.(VIN) 
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									name="truckRegNo" ng-model="truckData.truckRegNo"  maxlength="50"
									validation="required"   form-name="truckform" friendly-name="truckRegNo" disabled="true">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Tag
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="tag"  maxlength="50" disabled="true"
									ng-model="truckData.tag" form-name="truckform">
							</div>
						</div>
					</div>
					<span style="float: right;"><label style="font-size: 20px">Status : <b ng-show = "truckData.isActive==true"> ACTIVE</b> <b ng-show = "truckData.isActive==false"> IN ACTIVE</b></label></span>
					<div class="col-md-6" style="text-align: right;">
						<img src="img/truck.jpg" style="width: 200px; height: auto;">
					</div> 
				</div>
				<div class="col-md-12">
					<div class="col-md-6">
					
						<div class="form-group">
							<label class="col-md-4 control-label"> Chassis Number 
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									name="chassisNo" ng-model="truckData.chassisNo"  maxlength="50" disabled="true"
							 form-name="truckform" friendly-name="chassisNo">
							</div>
						</div>
							<div class="form-group">
							<label class="col-md-4 control-label"> Current Driver
							</label>
							<div class="col-md-5">
								<selectivity list="truckDriverList" property="truckData.currentDriver" name="currentDriver"
								ng-model="truckData.currentDriver"  form-name="truckform"  validation="required" disabled="true"
									 friendly-name="currentDriver" id="currentDriver"	
									 
									></selectivity>
							</div>
						</div>
							<div class="form-group">
						<table>
						<tr>
						<label class="col-md-4 control-label">Average Speed</label></td>
						<td>
						
						<div class="col-md-12">
						<input type="text" class="text-right form-control input-sm"
								placeholder="0.00"	name="averageSpeed" ng-model="truckData.averageSpeed"  maxlength="50"
									 form-name="truckform" friendly-name="averageSpeed" disabled="true"/>
									
									
									<td class="bigtext"><b>Km/hr</b></td>
									</div>
								</tr>	
								
								
						</table>
						</div>
						
					
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="col-md-4 control-label">Model Year
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
								validation="required"	name="modelYear" ng-model="truckData.modelYear"  maxlength="10" disabled="true"
									form-name="truckform">
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-4 control-label">Last Odometer 
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00" name="lastOdometer" ng-model="truckData.lastOdometer"  maxlength="30" disabled="true"
									  form-name="truckform" friendly-name="lastOdometer">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Catalog Value (VAT
								Incl.) 
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									name="catalogValue" ng-model="truckData.catalogValue"  maxlength="30" disabled="true"
									form-name="truckform">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Residual Value
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00"
									name="residualValue" ng-model="truckData.residualValue"  maxlength="40" disabled="true"
									form-name="truckform">
							</div>
						</div>
						
					</div>
					<br> <br>

				</div>
				<br>
				<br>
				<div class="col-md-12">
					<div class="col-md-6">
<br>
<br>
						<div class="o_horizontal_separator"
							style="font-size: x-large; text-align: center; color: #0e4a3d;">Additional
							Properties</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Seats Number 							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm" name="seatsNo"  maxlength="40" disabled="true"
									ng-model="truckData.seatsNo" form-name="truckform" >
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Doors Number
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm" name="doors"  maxlength="40" disabled="true"
									ng-model="truckData.doors" form-name="truckform">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Color 
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="color"  maxlength="30" disabled="true"
									ng-model="truckData.color" form-name="truckform">
							</div>
						</div>


					</div>
					<br> 
					<br>
					<div class="col-md-5 o_horizontal_separator"
						style="font-size: x-large; text-align: center; color: #0e4a3d;">Engine
						Options</div>


					<div class="col-md-6">

						<div class="form-group">
							<label class="col-md-4 control-label">Transmission
							</label>


							<div class="col-md-5">
								<select class="form-control input-sm"
									ng-options="wk.id as wk.text for wk in controllist"
									ng-model="truckData.transmission"
									name="transmission" 
									form-name="truckform" disabled="true"
									friendly-name="{{ 'Row3' + (trIndex+1) + '(Contoll)'}}">
									<option value="">--Select--</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Fuel Type
							</label>
							<div class="col-md-5">
								<!-- <select class="form-control input-sm"
									ng-options="wk.id as wk.text for wk in controllist1"
									ng-model="truckData.fuelType" name="fuelType"
									 form-name="truckform"
									friendly-name="{{ 'Row3' + (trIndex+1) + '(Contoll)'}}">
									<option value="">--Select--</option>
								</select> -->
								
								<selectivity list="fuelTypeList" property="truckData.fuelType" name="fuelType"
								 ng-model="truckData.fuelType"  form-name="truckform" 
									 friendly-name="Fuel Type" id="fuelType"	disabled="true"
									 
									></selectivity>
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-4 control-label">Horsepower 
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00"
									name="horsepower" ng-model="truckData.horsepower"  maxlength="50" disabled="true"
									form-name="truckform">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Horsepower Taxation
								
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00"
									name="horsepowerTaxation"  maxlength="50"
									ng-model="truckData.horsepowerTaxation" form-name="truckform"  disabled="true">
							</div>
						</div>
						<div class="form-group">
						<table>
						<tr>
						<label class="col-md-4 control-label">Power</label></td>
						<td>
						
						<div class="col-md-12">
						<input type="text" class="text-right form-control input-sm"
									placeholder="0.00" name="power"  maxlength="50"
									ng-model="truckData.power" form-name="truckform" friendly-name="power" disabled="true"/>
									
									
									<td class="bigtext"><b>KW</b></td>
									</div>
								</tr>	
						</table>
						</div>
						<!-- <div class="form-group">
							<label class="col-md-6 control-label">Power 
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00" name="power"  maxlength="50"
									ng-model="truckData.power" form-name="truckform" friendly-name="power"/>

							</div>
							<label>KW</label>
						</div> -->
					
					</div>
					<br> <br>

				</div>
				<br>
				<div class="form-group" id="updateButtonId">
					<label class="col-sm-5 control-label"></label>
					<div class="col-sm-4">
						<button class="btn btn-danger" type="button" ng-click="cancel()">
						<i class="fa fa-close"> </i> Cancel</button>
					</div>
				</div>
			</form>
		</div>
		</tab> <tab heading="{{tabs[1].title}}" active="tabs[1].active">
		<div class="panel-body">
			<div class="col-sm-12">
				<div class="col-sm-11 alert alert-success alert-dismissable"
					ng-if="thumbsAlert">
					<button ng-if="error" type="button" class="close"
						data-dismiss="alert" aria-hidden="true">×</button>
					{{successMsg}}
				</div>
				<div class="col-sm-11 alert alert-danger alert-dismissable"
					ng-if="error">
					<button ng-if="error" type="button" class="close"
						data-dismiss="alert" aria-hidden="true">×</button>
					{{errorMsg}}
				</div>
			</div>
			<form class="form-horizontal form-border" method="POST"
				name="truckform1" novalidate">
				<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="o_horizontal_separator "
							style="text-align: center;  color: #0e4a3d; font-size: x-large;">Contract
							details</div>
					</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="o_horizontal_separator "
							style="text-align: center; color: #0e4a3d; font-size: x-large;">Odometer
							details</div>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
<fieldset>
<!-- 
						<div class="form-group">
							<label class="col-md-6 control-label"> Vehicle </label>
							<div class="col-md-6">

								<label class="col-md-6 control-label">
									{{truckData.model}} </label>

							</div>
						</div> -->


						<div class="form-group">
							<label class="col-md-4 control-label">Vehicle 
							</label>
							<div class="col-md-5">
								<input type="text"  class="form-control input-sm" name="model"  maxlength="50"
									ng-model="truckData.model" form-name="truckform1" disabled="true">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Type 
							</label>
							<div class="col-md-5">
								<input type="text"  class="form-control input-sm" name="type"  maxlength="50" disabled="true"
									ng-model="contract.type" form-name="truckform1">
							</div>
						</div>
					<!-- 	<div class="form-group">
							<label class="col-md-6 control-label">Activation Cost <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-6">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00"
									name="activationCost" ng-model="contract.activationCost"  maxlength="30"
									validation="required" form-name="truckform1">
							</div>
						</div> -->
						<!-- <div class="form-group">
							<label class="col-md-6 control-label">Recurring Cost
								Amount <span style="color: red;">*</span>
							</label>
							<div class="col-md-6">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00"
									name="recurringCostAmt" ng-model="contract.recurringCostAmt"  maxlength="30"
									validation="required" form-name="truckform1">
							</div>
						</div> -->
							<div class="form-group">
							<label class="col-md-4 control-label" ng-if="!isView">Invoice
								Date  </label> <label class="col-md-5 control-label font-bold"
								ng-if="isView">Invoice Date </label>
							<div class="col-md-5" ng-if="!isView">
								<!-- <bootstrapdatetimepicker  property="thirdPartyHeader.schStartDate" id="sch_start_date"></bootstrapdatetimepicker> -->
								<ng-bs3-datepicker data-ng-model="contract.invoiceDate" id="sch_start_date" name="invoiceDate"
									 form-name="truckform1"  date-format="DD/MM/YYYY "  friendly-name="invoiceDate" validation="required" disabled="true" />
							</div>
							<div class="col-md-6" ng-if="isView">
								<label class="control-label">{{contract.invoiceDate}}</label>

							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label" ng-if="!isView">Handover
							 Date  </label> <label class="col-md-5 control-label font-bold"
								ng-if="isView">Handover Date</label>
							<div class="col-md-5" ng-if="!isView">
								
								
								
								
								<!-- <bootstrapdatetimepicker  property="thirdPartyHeader.schStartDate" id="sch_start_date"></bootstrapdatetimepicker> -->
								<ng-bs3-datepicker data-ng-model="contract.handoverDate" id="handoverDate"  name="handoverDate" disabled="true"
							form-name="truckform1" date-format="DD/MM/YYYY " 	 friendly-name="handoverDate"
									  validation="required" />
							</div>
							<div class="col-md-6" ng-if="isView">
								<label class="control-label">{{contract.handoverDate}}</label>
							</div>
						</div>
						
				<!-- 	<div class="form-group">
							<label class="col-md-6 control-label" ng-if="!isView">Contract
								Expiration Date <span
								style="color: red;">*</span> </label> <label class="col-md-5 control-label font-bold"
								ng-if="isView">Contract Expiration Date</label>
							<div class="col-md-6" ng-if="!isView">
								<bootstrapdatetimepicker  property="thirdPartyHeader.schStartDate" id="sch_start_date"></bootstrapdatetimepicker>
								
								
								<ng-bs3-datepicker
									data-ng-model="contract.contractEpirationDate"  id="sch_start_date" name="contractEpirationDate"  form-name="truckform1"
									
									date-format="DD/MM/YYYY "  friendly-name="contractEpirationDate" validation="required" />
							</div>
							<div class="col-md-6" ng-if="isView">
								<label class="control-label">{{contract.contractExpDate}}</label>
							</div>
						</div>
 -->

					
						
						
						
						
						
						
						
						
					</fieldset>	


					</div>

						<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label class="col-md-4 control-label">Odometer at
								creation 
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00"
									name="odometerAtCreation"  maxlength="30"
									ng-model="contract.odometerAtCreation" validation="required" form-name="truckform1" disabled="true">
							</div>
						</div>
						<br>
						<br>
						<div class="o_horizontal_separator" 
							style="font-size: x-large; color: #0e4a3d; text-align: center;">Engine
							Options
						</div>
						
						
						<div class="form-group">
							<label class="col-md-4 control-label"> Vendor 
							</label>
							<div class="col-md-5">
								<selectivity list="vendorList" ng-model="contract.vendor"  maxlength="40"   disabled="true"
								 property="contract.vendor" id="vendor"
									object="vendor" name="vendor" friendly-name="vendor"
									form-name="truckform1" disabled="disabled"></selectivity>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-4 control-label">Contractor </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									name="contractor" ng-model="contract.contractor" form-name="truckform1"  disabled="true">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Contract Reference

							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"  maxlength="40"
									name="contractRef" ng-model="contract.contractRef" form-name="truckform1"  disabled="true">
							</div>
						</div>


					</div>
					
				</div>
				
				
				
				<div class="col-md-12">



					<div class="col-md-6">

						






						
					</div>
					<br> <br>

				</div>
				<br>
				<div class="form-group" id="updateButtonId">
					<label class="col-sm-5 control-label"></label>
					<div class="col-sm-4">
					
						<button class="btn btn-danger" type="button" ng-click="cancel1()">
						<i class="fa fa-close"> </i> Cancel</button>
					</div>
				</div>
			</form>
		</div>
		</tab> <tab heading="{{tabs[2].title}}" ng-if="isEdit">
	<div class="wrapper-md">
			<div class="panel panel-default panel-default-list"
				st-table="displayedCollection" st-safe-src="rowCollection">
		<table class="table table-striped table-hover dataTable no-footer">
			<thead class="dataTables-Main-Head">
			<thead>
				<tr>
					<th class="sorting width_2" st-sort="customerName">Vehicle</th>
					<th class="sorting width_3" st-sort="customerShortName">Total
						Price</th>
					<th class="sorting width_3" st-sort="country">Date</th>
					<th class="sorting width_3" st-sort="currency">Cost
						Description</th>
				</tr>
			</thead>



			<tbody class="dataTables-Main-Body">

				<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
					ng-repeat="objItem in displayedCollection">
					<td class="">{{objItem.vehicle}}</td>
					<td class="">{{objItem.todal}}</td>
					<td class="">{{objItem.date}}</td>
					<td class="">{{objItem.cost}}</td>
					<td class="td-actions text-center"><span
						class="edit-button  padding-right-5"
						data-ng-click="editRow(objItem)" tooltip="Edit Row"> <i
							class="fa  fa-pencil text-success text"></i>
					</span> <span class="delete-button" data-ng-click="deleteRow(objItem)"
						tooltip="Delete Row"> <i
							class="fa fa-trash-o text-danger-dker tex"></i>
					</span>
					<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button></td>
				</tr>
			</tbody>

		</table>

		<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>


				</div>
				</div>
		</div>

		</tab> 
		<tab heading="{{tabs[3].title}}" ng-if="isEdit">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-list"
				st-table="displayedCollection" st-safe-src="rowCollection">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
						<tr>
							<th class="sorting width_2" st-sort="entryNo">Voucher
								No.</th>
							<th class="sorting width_3" st-sort="date">Date
							</th>
							<th class="sorting width_3" st-sort="truckNo">Truck No.</th>
<!-- 							<th class="sorting width_3" st-sort="country">Driver's Name</th>
 -->							<th class="sorting width_3" st-sort="fuelType">Fuel Type</th>
							<th class="sorting width_3" st-sort="liters">Litres</th>


						</tr>
					</thead>



					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
							<td class="">{{objItem.entryNo}}</td>
							<td class="">{{objItem.date}}</td>
							<td class="">{{objItem.truckNo}}</td>
<!-- 							<td class="">{{objItem.driversName}}</td>
 -->							<td class="" value="{{objItem.fuelType}}==0">Petrol</td>

							<td class="">{{objItem.liters}}</td>

						</tr>
					</tbody>

				</table>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>


				</div>
			</div>
		</div>
		</tab> <tab heading="{{tabs[4].title}}" active="tabs[4].active"
			ng-if="isEdit">
		<div class="panel-body" ng-hide="isShow">
			<div class="panel panel-default panel-default-list"
				st-table="displayedCollection1" st-safe-src="rowCollection1">

				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
						<tr>
							<th class="sorting width_2" st-sort="tripNo">Trip No</th>
							<th class="sorting width_3" st-sort="truckNo">Truck No
							<th class="sorting width_3" st-sort="trailerNo">Trailer No
							<th class="sorting width_3" st-sort="fromLocation">From Location
							</th>
							<th class="sorting width_3" st-sort="toLocation">To Location</th>
							<th class="sorting width_3" st-sort="etd">ETD</th>
							<th class="sorting width_3" st-sort="eta">ETA</th>
							<th class="sorting width_3" st-sort="tripStartDate">Trip Start
								Date</th>
							<th class="sorting width_3" st-sort="driverName">Driver Name</th>
						</tr>
					</thead>

					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection in rowCollection1 track by $index">
							<td class="">{{collection.tripNo}}</td>
							<td class="">{{collection.truckNo}}</td>
							<td class="">{{collection.trailerNo}}</td>
							<td class="">{{collection.fromLocation}}</td>
							<td class="">{{collection.toLocation}}</td>
							<td class="">{{collection.etd}}</td>
							<td class="">{{collection.eta}}</td>
							<td class="">{{collection.tripStartDate}}</td>
							<td class="">{{collection.driverName}}</td>

						</tr>
					</tbody>

				</table>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>


				</div>
			</div>
		</div>
		</tab> <tab heading="{{tabs[5].title}}" active="tabs[5].active"
			ng-if="isEdit"> <br>
		<br>
		<span style="font-color: black; font-size: 17px">Truck
			Allocation History</span> <br>
		<br>

		<div class="panel-body" ng-hide="isShow">
			<div class="panel panel-default panel-default-list"
				st-table="displayedCollection2" st-safe-src="rowCollection2">

				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
						<tr>
							<th class="sorting width_3" st-sort="truckNo">Truck No
							<th class="sorting width_3" st-sort="trailerNo">Trailer No
							<th class="sorting width_3" st-sort="fromDate">From Date</th>
							<th class="sorting width_3" st-sort="toDate">To Date</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection in rowCollection2 track by $index">
							<td class="">{{collection.truckNo}}</td>
							<td class="">{{collection.trailerNo}}</td>
							<td class="">{{collection.fromDate}}</td>
							<td class="">{{collection.toDate}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<br>
		<br>
		<span style="font-color: black; font-size: 17px">Driver
			Allocation History</span> <br>
		<br>
		<div class="panel-body" ng-hide="isShow">
			<div class="panel panel-default panel-default-list"
				st-table="displayedCollection3" st-safe-src="rowCollection3">

				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
						<tr>
							<th class="sorting width_3" st-sort="truckNo">Truck No
							<th class="sorting width_3" st-sort="driverName">Driver Name
							<th class="sorting width_3" st-sort="fromDate">From Date</th>
							<th class="sorting width_3" st-sort="toDate">To Date</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection in rowCollection3 track by $index">
							<td class="">{{collection.truckNo}}</td>
							<td class="">{{collection.driverName}}</td>
							<td class="">{{collection.fromDate}}</td>
							<td class="">{{collection.toDate}}</td>
						</tr>
					</tbody>
				</table>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>


				</div>
			</div>
		</div>
		</tab>
	</div>
	</tab>
	</tabset>
</div>
<!-- </div> -->
<!-- </div>

					</div>
				</div>
			</div>
		</div>
	</div>
</section>
 -->