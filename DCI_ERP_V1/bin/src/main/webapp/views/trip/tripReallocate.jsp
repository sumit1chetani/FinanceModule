<script>
	
</script>
<style>
.con-ele input {
	height: 30px;
}

.bookingDtlCls {
	border-bottom: 2px solid #23b7e5 !important;
	border-top: 2px solid #23b7e5 !important;
	/*  border-left: 1px solid #23b7e5 !important;
    border-right: 1px solid #23b7e5 !important; */
}

tbody::before {
	content: '';
	display: block;
	height: 15px;
	/*  border-left: 0px solid  !important;
   border-right: 1px solid #23b7e5 !important;
       width: 100%; */
}

<
style>a:hover {
	color: black;
}

.panel .actions {
	right: 8%;
}

.subTable-brs {
	padding: 8px !important;
}
</style>


<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="bookingForm" novalidate
				method="POST">
				<div class="row quotationClass">
					<div class="col-md-12" style="padding: 0% 7% 0% 7%;">
						<div class="panel panel-default">
							<div class="panel-heading" style="height: 37px;">
								<h3 class="panel-title" style="margin-top: 8px;">Current
									Trip Details</h3>

							</div>

							<div class="panel panel-default panel-default-list quoHideDiv">
								<div class="panel-body padding-0">
									<div class="table-responsive "
										style="background-color: #e1d3d3">
										<div class="panel-body">
											<table
												class="table table-striped b-light">
													<tbody >
													<tr class="customHead" style="background-color: lightblue">
														<th class="subTable-brs">Trip No</th>
														<th class="subTable-brs">From Location</th>
														<th class="subTable-brs">To Location</th>
														<th class="subTable-brs">Truck Reg No</th>
														<th class="subTable-brs">Truck Plate No</th>
														<th class="subTable-brs">Trailer No</th>
														<th class="subTable-brs">Trip Start Date</th>
														<th class="subTable-brs">Driver Mobile No</th>
													</tr>
												
													<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
														ng-repeat="trip in displayedCollection track by $index"
														style="background-color: lightblue">
														<td class="subTable-brs">{{trip.tripNo}}</td>
														<td class="subTable-brs">{{trip.fromLocation}}</td>
														<td class="subTable-brs">{{trip.toLocation}}</td>
														<td class="subTable-brs">{{trip.truckRegNo}}</td>
														<td class="subTable-brs">{{trip.plateNo}}</td>
														<td class="subTable-brs">{{trip.trailerNo}}</td>
														<td class="subTable-brs">{{trip.tripStartDate}}</td>
														<td class="subTable-brs">{{trip.mobileNo}}</td>



													</tr>
												</tbody>

											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br> <br> <br>

					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="col-sm-6 col-md-6 col-lg-6">
								<fieldset>



									<div class="form-group">
										<label class="col-md-4 control-label">Assign to Trip
											No<span style="color: red;">*</span>
										</label>
										<div class="col-md-3">
											<selectivity list="availableTrip"
												property="reallocate.assignTripNo" id="assignTripNo"
												name="assignTripNo" form-name="bookingForm"
												ng-model="reallocate.assignTripNo" validation="required"
												friendly-name="Assign Trip No"></selectivity>
										</div>
										<div class="col-md-2" style="margin-top: 7px;">
											<a ng-if="availableTrip.length == 0" style="color: green;"
												ng-click="createNewTrip(reallocate.fromLocation,reallocate.toLocation)">Add
												New Trip</a>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label"> From Location </label>
										<div class="col-md-5">
											<selectivity list="portList"
												property="reallocate.fromLocation" disabled="true"
												id="fromLocation" name="fromLocation" form-name="bookingForm"
												ng-model="reallocate.fromLocation" validation="required"
												friendly-name="From Location"></selectivity>

										</div>
									</div>

									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-4">
											ReAllocate Date<span style="color: red;">*</span>
										</label>
										<div class="col-md-5">
											<ng-bs3-datepicker data-ng-model="reallocate.reallocateDate"
												name="reallocateDate" form-name="bookingForm"
												friendly-name="ReAllocate Date" validation="required" />
										</div>
									</div>
									-



								</fieldset>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
								<fieldset>

									<div class="form-group">
										<label class="col-md-4 control-label"> Reason<span
											style="color: red;">*</span><span style="color: red;"></span>
										</label>
										<div class="col-md-5">
											<selectivity list="reasonList" property="reallocate.reason"
												id="fromLocation" name="fromLocation" form-name="bookingForm"
												ng-model="reallocate.reason" validation="required"
												friendly-name="Reason"></selectivity>

										</div>
									</div>


									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-4">To
											Location </label>
										<div class="col-md-5">
											<selectivity list="portList" property="reallocate.toLocation"
												id="toLocation" name="toLocation" form-name="bookingForm"
												disabled="isDestChange" ng-model="reallocate.toLocation"
												validation="required" friendly-name="To Location"></selectivity>
										</div>
									</div>


									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-4">Remarks<span
											style="color: red;">*</span>
										</label>
										<div class="col-md-5">
											<textarea rows="2" cols="43" name="remarks"
												friendly-name="Remarks" validation="required"
												ng-model="reallocate.remarks"></textarea>
										</div>
									</div>
									<!-- <div class="form-group">
										<label class="col-md-4 control-label "> ETA
										(To Location) <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-5">
										<bootstrapdatetimepicker property="reallocte.eta"
											id="eta"  ></bootstrapdatetimepicker>
									</div>
										
									</div>  -->
							</div>
							</fieldset>
						</div>

						<div class="col-md-12" style="padding: 0% 7% 0% 7%;">
							<div class="panel panel-default">
								<div class="panel-heading" style="height: 37px;">
									<h3 class="panel-title" style="margin-top: 8px;">Assign
										Trip Details</h3>

								</div>

								<div class="panel panel-default panel-default-list quoHideDiv">
									<div class="panel-body padding-0">
										<div class="table-responsive "
											style="background-color: #e1d3d3">
											<div class="panel-body">
												<table
													class="table table-striped b-light">
														<tbody >
														<tr class="customHead" style="background-color: lightblue">
															<th class="subTable-brs">Trip No</th>
															<th class="subTable-brs">From Location</th>
															<th class="subTable-brs">To Location</th>
															<th class="subTable-brs">Truck Reg No</th>
															<th class="subTable-brs">Truck Plate No</th>
															<th class="subTable-brs">Trailer No</th>
															<th class="subTable-brs">Trip Start Date</th>
															<th class="subTable-brs">Driver Mobile No</th>
														</tr>
												
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-repeat="trip in tripDetails track by $index"
															style="background-color: lightblue">
															<td class="subTable-brs">{{trip.tripNo}}</td>
															<td class="subTable-brs">{{trip.fromLocation}}</td>
															<td class="subTable-brs">{{trip.toLocation}}</td>
															<td class="subTable-brs">{{trip.truckRegNo}}</td>
															<td class="subTable-brs">{{trip.plateNo}}</td>
															<td class="subTable-brs">{{trip.trailerNo}}</td>
															<td class="subTable-brs">{{trip.tripStartDate}}</td>
															<td class="subTable-brs">{{trip.mobileNo}}</td>



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
				<br>

				<div class="wrapper-md" ng-if="reallocate.reason == 4 && isBooking">
				<button ng-click="addBooking()" class="btn btn-sm btn-info" style="background: midnightblue;"
										tooltip="Add Row" type="button">
										<i class="fa fa-plus"></i>
									</button>
										<button ng-click="deleteBooking(trIndex1)" style="background:#e9110b;"
										class="btn btn-sm btn-danger" type="button" tooltip="Delete">
										<i class="fa  fa-trash-o"></i>
									</button>
									
					<div class="panel panel-default panel-default-form" style=" border: 1px solid midnightblue;" ng-repeat="(trIndex1, booking) in bookingTableList" >
						<div class="row book-widget-row">
							<div class="col-sm-12 "  style="margin-top: 12px;">
								<fieldset>
	
									<div class="form-group col-md-4 col-lg-4">
										<label class="i-checks m-b-none col-md-2" style="padding-left: 47px;"> <input
												type="checkbox" ng-model="booking.select " ><i></i></label>
										<label for="inputPassword" class="control-label col-md-3">Booking
											Pick Up Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<ng-bs3-datepicker data-ng-model="booking.bookingDate"
												name="bookingDate{{trIndex1}}" form-name="bookingForm"
								friendly-name="{{ 'Row-' + (trIndex1+1) + '(Booking Date)'}}" validation="required" />
										</div>
									</div>
									<div class="form-group col-md-4 col-lg-4">
										<label class="col-md-5 control-label"> Customer <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="mloList" ng-model="booking.mloCode"
												property="booking.mloCode" name="mloCode{{trIndex1}}"
												validation="required" friendly-name="{{ 'Row-' + (trIndex1+1) + '(Customer)'}}" 
												form-name="bookingForm"></selectivity>
										</div>
									</div>



									<div class="form-group col-md-4 col-lg-4">
										<label class="col-md-5 control-label"> LOL <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="lolList" property="booking.lolId" 
												ng-model="booking.lolId" name="lolId{{trIndex1}}" validation="required"
												friendly-name="{{ 'Row-' + (trIndex1+1) + '(LOL)'}}"  form-name="bookingForm"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>
						</div>


						<div class="row book-widget-row">
							<div class="col-sm-12 ">
								<fieldset>

									<div class="form-group col-md-4 col-lg-4">
										<label class="col-md-5 control-label"> LOD <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="lodList" property="booking.lodId" 
												ng-model="booking.lodId" name="lodId{{trIndex1}}" validation="required"
												friendly-name="{{ 'Row-' + (trIndex1+1) + '(LOD)'}}"  form-name="bookingForm"></selectivity>
										</div>
									</div>

									<div class="form-group col-md-4 col-lg-4">
										<label class="col-md-5 control-label"> Quotation </label>
										<div class="col-md-6" style="padding-right: 4px; width: 48%">
											<selectivity list="quotationList"
												ng-model="booking.quotationNo"
												property="booking.quotationNo" class="quoLiCls"
												name="quotationNo{{trIndex1}}" friendly-name="quotationNo"
												form-name="bookingForm"></selectivity>
										</div>
										<div class="col-md-1" style="padding-left: 1px;">
											<button id="quoIconId" class="btn btn-success"
												style="padding: 2px 7px; margin-top: 7px; color: #ffffff; background-color: #27b6af;"
												ng-click="showHideQuotation()">
												<span class="fa fa-bolt"></span>
											</button>
										</div>
									</div>

									<div class="form-group col-md-4 col-lg-4"
										ng-if="local == true || transit == true">
										<label class="col-md-5 control-label"> Transport Type
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7 control-label text-left">
											<div class="radio radio-inline" style="padding-left: 0px;"
												ng-if="local == true">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0" ng-model="booking.transportType"
													name="transportType{{trIndex1}}" value="L" /> <i></i> Local
												</label>
											</div>

											<div class="radio radio-inline" ng-if="transit == true">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0" ng-model="booking.transportType"
													name="transportType{{trIndex1}}" value="T" /> <i></i> Transit
												</label>
											</div>

											<div class="radio radio-inline" style="margin-left: 0%"
												ng-if="transit == true">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0" ng-model="booking.transportType"
													name="transportType{{trIndex1}}" value="TEC" /> <i></i> Transit
													(Empty)
												</label>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
						<div class="form-group col-md-4 col-lg-4" ng-if="isEdit">
							<label for="inputPassword" class="control-label col-md-5">Booking
								No</label> <label for="inputPassword"
								class="control-label col-md-5 text-left">{{booking.bookingNo}}</label>
						</div>
						<br> <br> <br>






						<div class="row quotationClass" ng-show="showQuotation{{trIndex1}}">
							<div class="col-md-12" style="padding: 0% 7% 0% 7%;">
								<div class="panel panel-default">
									<div class="panel-heading" style="height: 37px;">
										<h3 class="panel-title" style="margin-top: 8px;">Quotation
											Details</h3>
										<div class="actions pull-right quoView">
											<i class="fa fa-minus"></i> <i data-fullscreen-widget
												class="fa fa-expand"></i>
										</div>
									</div>

									<div class="panel panel-default panel-default-list quoHideDiv">
										<div class="panel-body padding-0">
											<div class="table-responsive "
												style="background-color: #e1d3d3">
												<div class="panel-body">
													<table class="table table-striped  b-light">
														<tbody>
															<tr class="customHead"
																style="background-color: lightblue">
																<th class="width_6 subTable-brs">Quotation No</th>
																<th class="width_6 subTable-brs">Quotation DT</th>
																<th class="width_6 subTable-brs">Customer</th>
																<th class="width_6 subTable-brs">Quotation Type</th>
																<th class="width_6 subTable-brs">LOL</th>
																<th class="width_6 subTable-brs">LOD</th>
																<th class="width_6 subTable-brs">Valid From</th>
																<th class="width_6 subTable-brs">Valid Till</th>
																<th class="width_6 subTable-brs">Currency</th>
															</tr>
															<tr style="background-color: lightblue">
																<td class="width_6 subTable-brs">{{quotationView.quoNo}}</td>
																<td class="width_6 subTable-brs">{{quotationView.quoDate}}</td>
																<td class="width_6 subTable-brs">{{quotationView.customer}}</td>
																<td class="width_6 subTable-brs">{{quotationView.quoType}}</td>
																<td class="width_6 subTable-brs">{{quotationView.lol}}</td>
																<td class="width_6 subTable-brs">{{quotationView.lod}}</td>
																<td class="width_6 subTable-brs">{{quotationView.valFrom}}</td>
																<td class="width_6 subTable-brs">{{quotationView.valTo}}</td>
																<td class="width_6 subTable-brs">{{quotationView.currency}}</td>

															</tr>
														</tbody>
													</table>
													<br />

												</div>
											</div>

										</div>
									</div>

								</div>
							</div>
						</div>











						<div class="table-responsive clear">
							<table class="table table-striped b-t b-light">
								<thead>
									<tr>
										<th colspan=1 class="width_1"></th>
										<th colspan=1 class="width_5 text-center">S.No</th>
										<th colspan=1 class="width_13 text-center">Container Type<span
											style="color: red;">*</span></th>
										<th colspan=1 class="width_13 text-center">Container Size<span
											style="color: red;">*</span></th>
										<th colspan=1 class="width_13 text-center">Quantity</th>
										<th colspan=1 class="width_10 text-center">Cont.Dtl</th>

									</tr>
								</thead>
								<tbody ng-repeat="(trIndex, bookingDtl) in booking.bookingDtlList"
									class="bookingDtlCls">
									<tr>
										<td><label class="i-checks m-b-none"> <input
												type="checkbox" ng-model="bookingDtl.select"><i></i></label></td>
										<td class="text-center">{{trIndex+1}}</td>
										<td class="text-center">
											<div class="radio radio-inline">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0"
													ng-change="contType(bookingDtl,trIndex)"
													ng-model="bookingDtl.containerTypeId"
													name="conTypeId{{trIndex1}}{{trIndex}}" value="1" /> <i></i> Full
												</label>
											</div>
											<div class="radio radio-inline">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0"
													ng-change="contType(bookingDtl,trIndex)"
													ng-model="bookingDtl.containerTypeId"
													name="conTypeId{{trIndex1}}{{trIndex}}" value="2" /> <i></i> Empty
												</label>
											</div>
										</td>

										<td class="text-center">
											<div class="radio radio-inline">
												<label class="i-checks"> <input type="radio"
													ng-change="contType(bookingDtl,trIndex)"
													class="radiobox style-0" ng-model="bookingDtl.conSizeId"
													name="conSizeId{{trIndex1}}{{trIndex}}" value="1" /> <i></i> 20
												</label>
											</div>
											<div class="radio radio-inline">
												<label class="i-checks"> <input type="radio"
													ng-change="contType(bookingDtl,trIndex)"
													class="radiobox style-0" ng-model="bookingDtl.conSizeId"
													name="conSizeId{{trIndex1}}{{trIndex}}" value="2" /> <i></i> 40
												</label>
											</div>
										</td>
										<td class="text-center"><input type="text"
											class="form-control input-sm text-right"
											ng-model="bookingDtl.quantity" name="quantity{{trIndex1}}{{trIndex}}"
											ng-blur="addContCargoDtl(bookingDtl)"
											validation="required|integer" form-name='bookingForm'
											maxlength="3"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}">
										</td>

										<td>
											<div class="row">
												<div class="col-xs-12 text-center">
													<button ng-click="hideShow(bookingDtl)"
														class="btn btn-sm btn-info" tooltip="Add Row"
														type="button">
														<span ng-if="!bookingDtl.show">Show</span><span
															ng-if="bookingDtl.show">Hide</span>
													</button>
													<button
														ng-click="allocatetruck(bookingDtl,booking,trIndex)"
														ng-if="isEdit && booking.quotationNo != '' && booking.quotationNo != null && booking.bookingStatus != 'D'"
														class="btn btn-sm btn-info" tooltip="Allocate Truck"
														type="button">
														<span>Allocate Truck</span>
													</button>
												</div>
											</div>
										</td>

									</tr>
									<tr ng-show="bookingDtl.show" class="con-ele">
										<td></td>
										<td colspan="5">
											<table class="table table-striped b-t b-light">
												<tr>
													<th class="width_2 text-center subTable-brs">Con.S.No</th>
													<th class="width_8 text-center subTable-brs">Container
														No<span style="color: red;">*</span>
													</th>
													<th class="width_6 text-center subTable-brs">Seal No</th>
													<th class="width_6 text-center subTable-brs">Gross Wt<span
														style="color: red;">*</span></th>
													<th class="width_6 text-center subTable-brs">Net Wt<span
														style="color: red;">*</span></th>
													<th class="width_8 text-center subTable-brs"
														ng-show="!bookingDtl.emptyCont">Commodity</th>
													<th class="width_8 text-center subTable-brs"
														ng-if="!bookingDtl.emptyCont">Package Type</th>
													<th class="width_6 text-center subTable-brs"
														ng-if="!bookingDtl.emptyCont">No.of packages</th>
													<th class="width_6 text-center subTable-brs"
														ng-if="!bookingDtl.emptyCont">Is Haz</th>
													<th class="width_6 text-center subTable-brs"
														ng-if="!bookingDtl.emptyCont">UN Name</th>
													<th class="width_6 text-center subTable-brs"
														ng-if="!bookingDtl.emptyCont">UN Class</th>
													<th class="width_3 text-center subTable-brs">Action</th>
												</tr>
												<tr
													ng-repeat="(bTrIndex, bookingConDtl) in bookingDtl.bookingConCargoDtlList track by bTrIndex">
													<td class="subTable-brs text-center">{{bTrIndex+1}}</td>
													<td class="subTable-brs"><input type="text"
														class="form-control input-sm" validation="required"
														friendly-name="{{ 'Row-'  + (trIndex1+1) +' ContainerList-'  + (trIndex+1) +' Container-' + (bTrIndex+1)}}"
														ng-model="bookingConDtl.containerNo" name="containerNo"></td>
													<td class="subTable-brs"><input type="text"
														class="form-control input-sm"
														ng-model="bookingConDtl.sealNo" name="sealNo"></td>
													<td class="subTable-brs"><input type="text"
														class="form-control input-sm text-right"
														ng-model="bookingConDtl.grossWt"
														name="grossWt{{trIndex}}-{{bTrIndex}}"
														validation="numeric|required" form-name='bookingForm'
														ng-blur="validateGorssWeight(trIndex,bTrIndex,bookingConDtl.grossWt,bookingConDtl.netWt,bookingConDtl)"
														friendly-name="{{ 'Row-' + (trIndex1+1) +' ContainerList-' + (trIndex+1) +' Container-' + (bTrIndex+1)+' (Gross Wt)'}}"></td>
													<td class="subTable-brs"><input type="text"
														class="form-control input-sm text-right"
														ng-model="bookingConDtl.netWt"
														name="netWt{{trIndex}}-{{bTrIndex}}"
														ng-blur="validateNetWeight(trIndex,bTrIndex,bookingConDtl.netWt,bookingConDtl.grossWt,bookingConDtl)"
														validation="numeric|required" form-name='bookingForm'
														friendly-name="{{ 'Row-' + (trIndex1+1) +' ContainerList-'  + (trIndex+1) +' Container-' + (bTrIndex+1)+' (Net Wt)'}}"></td>
													<td class="subTable-brs" ng-if="!bookingDtl.emptyCont"
														ng-init="bookingConDtl.commodityId = bookingConDtl.commodityId + ''"><selectivity
															id="commodityId{{bTrIndex}}" list="commodityList"
															property="bookingConDtl.commodityId"
															ng-model="bookingConDtl.commodityId" name="commodityId"></selectivity></td>
													<td class="subTable-brs" ng-if="!bookingDtl.emptyCont"
														ng-init="bookingConDtl.packageType = bookingConDtl.packageType + ''"><selectivity
															id="packageType{{bTrIndex}}" list="packageTypeList"
															property="bookingConDtl.packageType"
															ng-model="bookingConDtl.packageType" name="packageType"></selectivity></td>
													<td class="subTable-brs" ng-if="!bookingDtl.emptyCont"><input
														type="text" class="form-control input-sm text-right"
														ng-model="bookingConDtl.noOfPackages"
														name="noOfPackages{{trIndex}}-{{bTrIndex}}"
														validation="integer" form-name='bookingForm'
														friendly-name="{{ 'Row-' + (trIndex1+1) +' ContainerList-'  + (trIndex+1) +' Container-' + (bTrIndex+1)+' (No.of packages)'}}"></td>
													<td class="subTable-brs text-center"
														ng-if="!bookingDtl.emptyCont"><label class="i-checks">
															<input type="checkbox" id="isActive"
															class="checkbox style-0" name="isHaz{{bTrIndex}}"
															ng-model="bookingConDtl.isHaz" /> <i></i>
													</label>
														</div></td>
													<td class="subTable-brs" ng-if="!bookingDtl.emptyCont"><input
														type="text" class="form-control input-sm"
														ng-disabled="!bookingConDtl.isHaz"
														ng-model="bookingConDtl.unName" name="unName"></td>
													<td class="subTable-brs" ng-if="!bookingDtl.emptyCont"><input
														type="text" class="form-control input-sm"
														ng-disabled="!bookingConDtl.isHaz"
														ng-model="bookingConDtl.unClass" name="unClass"></td>
													<td class="subTable-brs">
														<button ng-disabled="bookingConDtl.unAllocateStatus"
															ng-click="unAllocatetruck(bookingConDtl)" ng-if="isEdit"
															class="btn btn-sm btn-primary" tooltip="Allocate Truck"
															type="button">
															<span>UnAllocate</span>
														</button>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
							<div class="padding-right-5">
								<div class="col-md-4">
									<button ng-click="addBookingDtl(trIndex1)" class="btn btn-sm btn-info"
										tooltip="Add Row" type="button">
										<i class="fa fa-plus"></i>
									</button>
									<button ng-click="deleteBookingDtl(trIndex1)"
										class="btn btn-sm btn-danger" type="button" tooltip="Delete">
										<i class="fa  fa-trash-o"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			
		</div>
	</div>
</div>



<div class="form-actions">
	<div class="row">
		<div class="col-md-12">
			<button class="btn btn-success" ng-if="!isBooking" ng-click="save(reallocate,TripForm)">
				<i class="fa fa-save"></i> Save
			</button>
			
<button class="btn btn-success" ng-if="isBooking"
												ng-click="saveBooking(bookingForm)">
												<i class="fa fa-save"></i> Save
											</button>

			<button class="btn btn-info" ng-click="reset()">
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





