<style>
#trkTrailAddId{
/* box-shadow: 0px 10px 70px 0px #1a34f1; */
}
#trkSelList > .blockOverlay{
    width: 90% !important;
    margin-left: 5% !important;
    background-color: rgb(210, 205, 205) !important
}
</style>
<div class="wrapper-md trCal">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div ng-controller="trucktrailerAddCtrl">
			<div ng-show="showTrailMap">
				<div ng-include="'/views/master/trucktrailer/trucktrailerAdd.jsp'"></div>
			</div>
		</div>
		<div class="panel panel-default panel-default-form ptCalHdRem ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div id="blkCnt">
		<div class="panel-body" id="TripAddId">
			<form class="form-horizontal" name="TripForm" novalidate
				method="POST">
				<marquee style="color: #FF4500; font-weight: 400;"
					onmouseover="this.stop();" onmouseout="this.start();"
					scrolldelay="100">
					<span style="color: red">Note : Trip Start Date should match
						with the time frame set in Truck Trailer Mapping.</span>
				</marquee>
				<div class="form-group" align="center">
					<label for="inputPassword" class="control-label col-md-5 trCalStartlbl">
						Booking Date<span style="color: red;">*</span>
					</label>
					<div class="col-md-3 trCalStDt">
						<ng-bs3-datepicker data-ng-model="trip.tripStartDate"
							name="tripStartDate" form-name="TripForm"  date-format="DD/MM/YYYY HH:mm" 	
							friendly-name="Booking Date" validation="required" />
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6 trWidth">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">Truck<span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">
										<selectivity list="truckList" id="truckId" name="truckId"
											property="trip.truckId" ng-model="trip.truckId"
											object="getSubGroup" validation="required"
											friendly-name="Truck" form-name="TripForm"></selectivity>
									</div>
								</div>



								<div class="form-group">
									<label class="col-md-4 control-label">Trailer No<span
										style="color: red;">*</span><span style="color: red;"></span></label>
									<div class="col-md-5">
										<selectivity list="trailerList" id="trailerId"
											name="trailerId" property="trip.trailerId"
											ng-model="trip.trailerId" object="truckId"
											validation="required" friendly-name="Trailer"
											form-name="TripForm"></selectivity>
									</div>
								<!-- <div class="col-md-3" style="margin-top: 7px;" ng-if="transportType == 'L'">	<a style="color:#006400;" ng-click="changeTrailerMapping(trip.truckTrailerMappingId)">Change Trailer Mapping</a> -->
								 <div class="col-md-3" style="margin-top: 7px;" ng-if="createTrailerMapLink">	<a style="color:#006400;" ng-click="createTrailerMapping()">Create Trailer Mapping</a>	
									</div> 
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> From Location<span
										style="color: red;">*</span><span style="color: red;"></span>
									</label>
									<div class="col-md-5">
										<selectivity list="portList" property="trip.fromLocation" disabled="tripReallocate"
											id="fromLocation" name="fromLocation" form-name="TripForm"
											ng-model="trip.fromLocation" validation="required"
											friendly-name="From Location"></selectivity>

									</div>
								</div>
								
					<div class="form-group">
										<label class="col-md-4 control-label "> ETD
										(From Location) <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-5">
										<ng-bs3-datepicker property="trip.etd" readonly name="etd" friendly-name="ETD"
											id="etd"  date-format="DD/MM/YYYY HH:mm"  ng-model="trip.etd" validation="required"/></div>
										
									</div> 
									
									<div class="form-group">
										<label class="col-md-4 control-label "> Work Order No <span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.workOrderNo" name="Work Order No"
										 form-name='TripForm'
										friendly-name="Work Order No">
									</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label ">Clearing Fee<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.cleaningfee" name="Cleaning Fee"
										 form-name='TripForm'
										friendly-name="Cleaning Fee">
									</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label ">Port Charges<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.portcharges" name="Portcharges No"
										 form-name='TripForm'
										friendly-name="Portcharges No">
									</div>
										
									</div>
										<div class="form-group">
										<label class="col-md-4 control-label ">Road User(USD)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text" ng-blur="changetoKsh()"
										class="form-control input-sm text-right"
										ng-model="trip.roadchargesusd" name="Road User(USD)"
										 form-name='TripForm'
										friendly-name="Road User">
									</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label ">Road User(KSH)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text" ng-blur="changetoUsd()"
										class="form-control input-sm text-right"
										ng-model="trip.roadchargesksh" name="Road User(KSH)"
										 form-name='TripForm'
										friendly-name="Road User">
									</div>
										
									</div>
									
									<div class="form-group">
										<label class="col-md-4 control-label ">Mileage<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.mileage" name="Mileage"
										 form-name='TripForm'
										friendly-name="Mileage">
									</div>
										
									</div>
									
								<div class="form-group">
									<label class="col-md-4 control-label">Voucher Date</label>

									<div class="col-md-5">
										<ng-bs3-datepicker readonly data-ng-model="fuelmodel.date" id="date" validation="required"
											name="date"  form-name="toForm" friendly-name="date"
											/>
									</div>
								</div>
								
							
								
																<div class="form-group">
									<label class="col-md-4 control-label">Fuel Order No.</label>	
									<div class="col-md-5">
										<input type="text" class="form-control input-sm" id="orderNo"
											name="orderNo" ng-model="fuelmodel.orderNo" 
											friendly-name="orderNo"
											form-name="fuelvoucherentryForm" maxlength="25"/>
									</div>
								</div>										
								
								<div class="form-group">
									<label class="col-md-4 control-label">Rate Per Unit</label>
									<div class="col-md-2">
										<input type="text" class="form-control input-sm" id="rateUnit"
											name="rateUnit" ng-model="fuelmodel.rateUnit" 
											friendly-name="rateUnit" ng-change="getFuelAmount()"
											form-name="fuelvoucherentryForm" maxlength="15"/>
									</div>
									<label class="col-md-1 control-label">Tot.Value</label>
									<div class="col-md-2">
										<input type="text" class="form-control input-sm" id="totalValue"
											name="totalValue" ng-model="fuelmodel.totalValue" 
											 friendly-name="Total Value"
											form-name="fuelvoucherentryForm" maxlength="15"/>
									</div><p style="margin-top: 10px;">ksh</p>

								</div>
						
								<div class="form-group">
									<label class="col-md-4 control-label">Filling Location </label>
									<div class="col-md-5">											
											<textarea ng-model="fuelmodel.fillingLocation"
											name="fillingLocation"
											class="custom-scroll width_100 resize-none" rows="3">
		          						</textarea>
									</div>
								</div>
									
							</fieldset>
						</div>
					
					
						<div class="col-sm-6 col-md-6 col-lg-6 trWidth">
							<fieldset>

								<div class="form-group">
									<label class="col-md-4 control-label">Trip No<span
										style="color: red;">*</span><span style="color: red;"></span></label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm" id="tripNo"
											name="Trip No" ng-model="trip.tripNo" disabled="disabled"
											validation="required" friendly-name="Trip No"
											form-name="TripForm" />
									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">Driver<span
										style="color: red;">*</span></label>
									<div class="col-md-5">
<!-- 									<select  id="driverListSelect" multiple="multiple" name="multiselect[]" ng-model="trip.driverId"  property="trip.driverId" -->
<!-- 											 ng-options="option.id as option.text for option in driverList" data-dropdownmultiselect>     -->
<!-- 											   <option data-ng-repeat="option in driverList" value="{{getOptionId(option)}}"  -->
<!-- 											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option> -->
<!-- 											</select> -->
											
											
											<select class="drvSelStyl" id="driverListSelect" multiple="multiple" name="multiselect[]" ng-model="trip.driverId" 
											 ng-options="option.id as option.text for option in driverList" friendly-name="Driver" >    
											</select>
											
											
									<!-- 	<selectivity list="driverList" property="trip.driverId"
											id="driverId" name="driverId" form-name="TripForm"
											ng-model="trip.driverId" friendly-name="Driver"></selectivity> -->
									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">To
										Location<span style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="portList" property="trip.toLocation" disabled="tripReallocate"
											id="toLocation" name="toLocation" form-name="TripForm"
											ng-model="trip.toLocation" validation="required"
											friendly-name="To Location"></selectivity>
									</div>
								</div>

									<div class="form-group">
										<label class="col-md-4 control-label "> ETA
										(To Location) <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-5">
										<ng-bs3-datepicker property="trip.eta" readonly date-format="DD/MM/YYYY HH:mm"  ng-model="trip.eta" validation="required" name="eta" friendly-name="ETA"
											id="eta"  />
									</div>
										
									</div>
									
									
<div class="form-group">
									<label class="col-md-4 control-label">Original Voucher No.<span
									style="color: red;">*</span></label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="orginalvoucherNo" name="orginalvoucherNo"
											ng-model="fuelmodel.orginalvoucherNo"  validation="required"
											friendly-name="Orginal Voucher No." form-name="fuelvoucherentryForm">
									</div>
								</div>
								
								 	
								
								<div class="form-group">
									<label class="col-md-4 control-label"> Fuel Type 
									</label>
									<div class="col-md-2">
										<selectivity list="fuelList" id="fuelType" 
											property="fuelmodel.fuelType" name="fuelType"
											ng-model="fuelmodel.fuelType" friendly-name="Fuel Type" form-name="fuelvoucherentryForm"></selectivity>
									</div>
									<label class="col-md-1 control-label">Units<span
									style="color: red;">*</span></label>
									<div class="col-md-2">
										<input type="text" class="form-control input-sm" id="liters"
											name="liters" ng-model="fuelmodel.liters"  ng-change="getFuelAmount()"
											validation="required" friendly-name="Liters"
											form-name="fuelvoucherentryForm" maxlength="15"/>
									</div>

								</div>
										<div class="form-group">
									<label class="col-md-4 control-label">Supplier<span
									style="color: red;">*</span></label>
									<div class="col-md-5">				
											
									<selectivity list="localtionList" id="vendorCode"
										name="vendorCode"
										property="fuelmodel.vendorCode"
										ng-model="fuelmodel.vendorCode" validation="required"
										friendly-name="Supplier"
										form-name="fuelvoucherentryForm"></selectivity> 
									</div>
								</div>
								
									<div class="form-group">
										<label class="col-md-4 control-label ">RCN No<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.renNo" name="REN No"
										 form-name='TripForm'
										friendly-name="REN No">
									</div>
									
								<div class="form-group">
									<label class="col-md-4 control-label"> Others </label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="others" name="others1"
											ng-model="trip.others"  validation="required"
											friendly-name="others">
									</div>
								</div>
								<div class="form-group">
										<label class="col-md-4 control-label ">Income(USD)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.incomeusd" name="incomeusd"
										 form-name='TripForm'
										friendly-name="IncomeUSD">
									</div>
									
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label ">Income(KHS)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.incomeksh" name="incomeksh"
										 form-name='TripForm'
										friendly-name="Incomeksh">
									</div>
										
										
								</div>
								
								
										
								</div>

							</fieldset>
						</div>
					</div>
				</div>
				<!-- /row -->

		

		<br>
			
				<div class="form-actions" id="tripAddBtnId">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit"
								ng-click="save(trip,TripForm)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit"
								ng-click="update(trip,TripForm)" ng-if="accountHeadData.edit"
								type="submit">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" ng-if="!accountHeadData.edit"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>


							<button class="btn btn-danger" class="btn btn-success"
								ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>


						</div>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>

	<div class="panel panel-default panel-default-form pln-hisy" id="tripHisId" ng-if="!isEdit">
		<div class="panel-heading panel-heading-form font-bold">
			<label style="color: white; font-size: 17px; margin-left: 47%;">Trip
				History</label>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="col-md-6"></div>
				<div class="wrapper-md">
					<div class="panel panel-default panel-default-list"
						st-table="displayedCollection" st-safe-src="rowCollection">
						<div class="panel-body float-left padding-0" style="width: 100%;">
							<div class="table-responsive ">
								<table
									class="table table-striped table-hover dataTable no-footer">
									<thead class="dataTables-Main-Head">
									<thead>
										<tr>
											<th>Truck No</th>
											<th>Trip No</th>
											<th>Trailer No</th>
											<th>Driver</th>
											<th>From Location</th>
											<th>To Location</th>
											<th>ETD (From Location)</th>
											<th>ETA (To Location)</th>

										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="trip in trip1 track by $index">
											<td>{{trip.truckRegNo}}</td>
											<td>{{trip.tripNo}}</td>
											<td>{{trip.trailerNo}}</td>
											<td>{{trip.driversName}}</td>
											<td>{{trip.fromLocation}}</td>
											<td>{{trip.toLocation}}</td>
											<td>{{trip.etd}}</td>
											<td>{{trip.eta}}</td>

										</tr>
									</tbody>

								</table>
							</div>
						</div>

					</div>
				</div>


			</div>
		</div>
	</div>


	<div class="panel panel-default panel-default-form" id="allotBokBlock" ng-if="isEdit">
		<div class="panel-heading panel-heading-form font-bold">
			<label style="color: white; font-size: 17px; margin-left: 47%;">Allotted
				Booking</label>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="col-md-6"></div>
				<div class="wrapper-md">
					<div class="panel panel-default panel-default-list"
						st-table="displayedCollection" st-safe-src="rowCollection">
						<div class="panel-body float-left padding-0" style="width: 100%;">
							<div class="table-responsive ">
								<table
									class="table table-striped table-hover dataTable no-footer">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="sorting" st-sort="bookingNo">Booking No</th>
											<th class="sorting" st-sort="bookingDate">Booking Date</th>
											<th class="sorting" st-sort="mloName">Customer</th>
											<th class="sorting" st-sort="lolName">LOL</th>
											<th class="sorting" st-sort="lodName">LOD</th>
											<th class="sorting" st-sort="conType">Con.Quantity</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="booking in bookingList">
											<!-- <td class=""><label class="i-checks m-b-none"> <input
									type="checkbox" name="post[]" data-ng-model="objItem.isSelect">
									<i></i>
							</label></td> -->

											<td>{{booking.bookingNo}}</td>
											<td>{{booking.bookingDate}}</td>
											<td>{{booking.mloName}}</td>
											<td>{{booking.lolName}}</td>
											<td>{{booking.lodName}}</td>
											<td>{{booking.conType}}</td>
										</tr>
										<tr x-ng-show="showEmptyLabel">
											<td colspan="6" class="text-center">No Records Found</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
       
		<br/>
		<br/>
		<br/>
		<br/>
