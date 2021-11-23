<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
			<!-- <ol class="breadcrumb inline-block padding-left-0">
				<li><a>Finance</a></li>
				<li><a x-ui-sref="app.master.controlscreen">Control Screen</a>
				</li>
				<li><a x-ui-sref="app.finance.controlscreen.subgroupaccount">Account
						Head</a></li>
				<li><a
					x-ui-sref="app.finance.controlscreen.subgroupaccountform">Add</a></li>
			</ol> -->
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="TripForm" novalidate
				method="POST">
				   <marquee style="color: #FF4500;font-weight: 400;" onmouseover="this.stop();" onmouseout="this.start();"  scrolldelay="100" 
  ><span style="color :red">Note : Trip Start Date should match with the time frame set in Truck Trailer Mapping.</span></marquee>
				<div class="form-group" align="center">
					<label for="inputPassword" class="control-label col-md-5">
						Trip Start Date<span style="color: red;">*</span>
					</label>
					<div class="col-md-3">
						<div class="input-group input-append date">
							<input type="text" class="form-control input-sm" disabled="disabled"
								id="tripStartDate" name="tripStartDate" form-name="TruckForm"
								ng-model="trip.tripStartDate" validation="required"
								friendly-name="Trip Start Date" /> <span
								class="input-group-addon add-on"><span
								class="glyphicon glyphicon-calendar"></span></span>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">Truck<span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">
										<selectivity list="truckList" id="truckId" name="truckId"
											property="trip.truckId" ng-model="trip.truckId"
											object="getSubGroup" validation="required" disabled="true"
											friendly-name="Truck" form-name="TripForm"></selectivity>
									</div>
								</div>



								<div class="form-group">
									<label class="col-md-4 control-label">Trailer No<span
										style="color: red;">*</span><span style="color: red;"></span></label>
									<div class="col-md-5">
										<selectivity list="trailerList" id="trailerId"
											name="trailerId" property="trip.trailerId" disabled="true"
											ng-model="trip.trailerId" object="truckId"
											validation="required" friendly-name="Trailer"
											form-name="TripForm"></selectivity>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> From Location<span
										style="color: red;">*</span><span style="color: red;"></span>
									</label>
									<div class="col-md-5">
										<selectivity list="portList" property="trip.fromLocation" disabled="true"
											id="fromLocation" name="fromLocation" form-name="TripForm"
											ng-model="trip.fromLocation" validation="required"
											friendly-name="From Location"></selectivity>

									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">ETD (From
											Location)<span style="color: red;">*</span>
									</label>
									<div class="col-md-5">

										<div class="input-group input-append date">
											<input type="text" class="form-control input-sm" disabled="disabled"
												id="fromDate" name="fromDate" form-name="TripForm"
												ng-model="trip.etd" validation="required"
												friendly-name="ETD" /> <span
												class="input-group-addon add-on"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>

									</div>
								</div>
									<div class="form-group">
										<label class="col-md-4 control-label "> Work Order No <span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.workOrderNo" name="Work Order No" disabled="disabled"
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
										ng-model="trip.cleaningfee" name="Cleaning Fee" disabled="disabled"
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
										ng-model="trip.portcharges" name="Portcharges No" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Portcharges No">
									</div>
										
									</div>
											<div class="form-group">
										<label class="col-md-4 control-label ">Road User(USD)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.roadchargesusd" name="Road User" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Road User(USD)">
									</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label ">Road User(KSH)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.roadchargesksh" name="Road User" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Road User(KSH)">
									</div>
										
									</div>
											<div class="form-group">
										<label class="col-md-4 control-label ">Mileage<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.mileage" name="Mileage" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Mileage">
									</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label ">RCN No<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.renNo" name="REN No" disabled="disabled"
										 form-name='TripForm'
										friendly-name="REN No">
									</div>
										
									</div>
										<div class="form-group">
										<label class="col-md-4 control-label ">Client's DN<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.dn" name="Cleint No" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Cleint No">
									</div>
										
									</div>
									
											<div class="form-group">
										<label class="col-md-4 control-label ">Income(USD)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.incomeusd" name="incomeusd" disabled="disabled"
										 form-name='TripForm'
										friendly-name="IncomeUSD">
									</div>
										
										<div class="form-group">
										<label class="col-md-4 control-label ">Others<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.others" name="others" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Others">
									</div>
										
								</div>
									
							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>

								<div class="form-group">
									<label class="col-md-4 control-label">Trip No<span
										style="color: red;">*</span><span style="color: red;"></span></label>
									<!-- <label
										class="col-md3 control-label" ng-if="accountHeadData.edit">{{accountHeadData.accountHeadName}}</label> -->
									<div class="col-md-5">
										<input type="text" class="form-control input-sm" id="tripNo" disabled="disabled"
											name="Trip No" ng-model="trip.tripNo" 
											validation="required" friendly-name="Trip No"
											form-name="TripForm" />
									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">Driver<span
										style="color: red;"></span></label>
									<div class="col-md-5">
<!-- 									<select  id="driverListSelect" multiple="multiple" name="multiselect[]" ng-model="trip.driverId"  property="trip.driverId" -->
<!-- 											 ng-options="option.id as option.text for option in driverList" data-dropdownmultiselect>     -->
<!-- 											   <option data-ng-repeat="option in driverList" value="{{getOptionId(option)}}"  -->
<!-- 											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option> -->
<!-- 											</select> -->
											
											
											<select  id="driverListSelect" multiple="multiple" name="multiselect[]" ng-model="trip.driverId" 
											 ng-options="option.id as option.text for option in driverList" data-dropdownmultiselect>    
											   <option data-ng-repeat="option in driverList" value="{{getOptionId(option)}}" 
											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
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
										<selectivity list="portList" property="trip.toLocation" disabled="true"
											id="toLocation" name="toLocation" form-name="TripForm"
											ng-model="trip.toLocation" validation="required"
											friendly-name="To Location"></selectivity>
									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">ETA (To
											Location)<span style="color: red;">*</span></label>
									<div class="col-md-5">
										<div class="input-group input-append date">
											<input type="text" class="form-control input-sm" id="toDate" disabled="true"
												name="toDate" ng-model="trip.eta" validation="required"
												friendly-name="ETA" /> <span
												class="input-group-addon add-on"><span
												form-name="TripForm" class="glyphicon glyphicon-calendar"></span></span>
										</div>
									</div>
								</div>
									<div class="form-group" ng-if="isEdit">
										<label class="col-md-4 control-label "> Trip Completed Date
										  <span
											style="color: red;"> </span>
										</label>
										<div class="col-md-5">
										<ng-bs3-datepicker property="trip.tripCompletedDate" disabled="true"  ng-model="trip.tripCompletedDate"   name="tripCompletedDate"
											id="tripCompletedDate"  />
									</div>
										
									</div>
												
									<div class="form-group">
										<label class="col-md-4 control-label ">Weight/Tonnes <span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.weight" name="Weight" disabled="disabled"
										friendly-name="Weight">
									</div>
										
									</div>
											<div class="form-group">
										<label class="col-md-4 control-label ">Rate(USD)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.rate" name="Rate" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Rate">
									</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label ">Rate(KHS)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.rateusd" name="Rate" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Rate">
									</div>
										
									</div>
											<div class="form-group">
										<label class="col-md-4 control-label ">EIR No<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.eirNo" name="EIR No" disabled="disabled"
										 form-name='TripForm'
										friendly-name="EIR No">
									</div>
										
									</div>
										<div class="form-group">
										<label class="col-md-4 control-label ">Seal No<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.sealNo" name="Seal No"  disabled="disabled"
										 form-name='TripForm'
										friendly-name="Seal No">
									</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label ">Bundles<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.bundles" name="Bundles" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Bundles">
									</div>
										
										
								</div>
		<div class="form-group">
										<label class="col-md-4 control-label ">Fuel(ltrs)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.fuel" name="Fuel" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Fuel">
									</div>
										
										
								</div>
								<div class="form-group">
										<label class="col-md-4 control-label ">Income(KHS)<span
											style="color: red;"></span>
										</label>
										<div class="col-md-5">
										<input type="text"
										class="form-control input-sm text-right"
										ng-model="trip.incomeksh" name="incomeksh" disabled="disabled"
										 form-name='TripForm'
										friendly-name="Incomeksh">
									</div>
										
										
								</div>

							</fieldset>
						</div>
					</div>
				</div>
				<!-- /row -->
				<br>



				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
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
	
	
				
				
				<div class="panel panel-default panel-default-form" ng-if="isEdit">
		<div class="panel-heading panel-heading-form font-bold">
<label style="color: white;font-size: 17px;margin-left: 47%;">Allotted Booking</label>
</div>
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="col-md-6"></div>
								<div class="wrapper-md">
									<div class="panel panel-default panel-default-list"
										st-table="displayedCollection" st-safe-src="rowCollection">
										<div class="panel-body float-left padding-0"
											style="width: 100%;">
											<div class="table-responsive ">
												<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="sorting" st-sort="bookingNo">Booking No</th>
							<th class="sorting" st-sort="bookingDate">Booking Date</th>
							<th class="sorting" st-sort="mloName">Customer</th>
							<th class="sorting" st-sort="lolName">LOL</th>
							<th class="sorting" st-sort="lodName">LOD</th>
							<th class="sorting" st-sort="conType">Con.Quantity</th>
							<th class="sorting" st-sort="conType">Container No</th>
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
										<td>{{booking.containerNo}}</td>
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
</div>

