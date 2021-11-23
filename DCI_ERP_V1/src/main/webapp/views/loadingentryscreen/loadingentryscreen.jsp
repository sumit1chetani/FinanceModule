<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
<%-- 		<%@include file="/views/templates/panel-header.jsp"%>
 --%>

 <input type="hidden" value="${user.userId}" id="userId">	
	<div class="panel-body">
		<form name="bookingForm" class="form-horizontal" novalidate>
			<div class="row book-widget-row">
				<div class="col-sm-12 ">
					<fieldset>

						<div class="form-group col-md-3 col-lg-3">
							<div class="form-group">
								<label class="col-md-5 control-label"> Action </label>
								<div class="col-md-7">
									<selectivity list="actionList" id="actionId" name="actionId"
										property="loadingEntry.actionId"
										ng-model="loadingEntry.actionId" object="getSubGroup"
										validation="required" friendly-name="Trip"
										form-name="TripForm"></selectivity>
								</div>
							</div>
						</div>	
						
						<!-- <div class="form-group col-md-3 col-lg-3" ng-if="closeTripflag">
							<div class="form-group">
										<label class="col-md-5 control-label "> Trip Completed Date
										  <span
											style="color: red;"> </span>
										</label>
									 
										<div
												class="col-md-7 control-label text-left inputGroupContainer">
													<ng-bs3-datepicker property="tripCompleted.tripCompletedDate"  ng-model="tripCompleted.tripCompletedDate"   name="tripCompletedDate"
											date-format="DD/MM/YYYY HH:mm"  id="tripCompletedDate"  />

											</div>
									 
										
									</div>			</div>	 -->

<!-- <div class="form-group  col-md-3 col-lg-3"
							ng-if="closeTripflag">
							<div class="form-group">
								<label class="col-md-5 control-label"> Trip No </label>
								<div class="col-md-7">
									<select id="closeTrip" multiple="multiple"
										name="multiselect[]" ng-model="tripCompleted.tripId"
										ng-options="option.text for option in tripCloseDateList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in companyList"
											value="{{getOptionId(option)}}"
											ng-selected="isOptionSelected(option)"
											data-ng-bind-template="{{option.text}}"></option>
									</select>
								</div>
							</div>
						</div> -->
						
						<div class="form-group  col-md-3 col-lg-3" ng-if="createTripflag" align="center">
							<button class="btn btn-success" ng-click="createTrip()">
								<span style="color: white;"></span> Create New Trip
							</button>
						</div>
							<!-- <div class="form-group  col-md-3 col-lg-3" ng-if="closeTripflag" align="center">
							<button class="btn btn-success" ng-click="closeTrip()">
								<span style="color: white;"></span> Close Trip
							</button>
						</div> -->
						<div class="form-group  col-md-3 col-lg-3"
							ng-if="createBookingflag">
							<div class="form-group">
								<label class="col-md-5 control-label"> Customer </label>
								<div class="col-md-7">
									<selectivity list="customerList"
										property="loadingEntry.customer" id="customer"
										object="customer" name="customer"
										ng-model="loadingEntry.customer"
										friendly-name="Customer" form-name="customerinvoiceForm"
										validation="required"></selectivity>
								</div>
							</div>
						</div>
						
						<div class="form-group  col-md-3 col-lg-3"
							ng-if="createBookingflag">
							<div class="form-group">
								<label class="col-md-5 control-label"> Trip No </label>
								<div class="col-md-7">
									<select id="txtGroupCode" multiple="multiple"
										name="multiselect[]" ng-model="loadingEntry.tripId"
										ng-options="option.text for option in tripList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in companyList"
											value="{{getOptionId(option)}}"
											ng-selected="isOptionSelected(option)"
											data-ng-bind-template="{{option.text}}"></option>
									</select>
								</div>
							</div>
						</div>
						
						
						
						<div class="form-group  col-md-3 col-lg-3"
							ng-if="createInoviceflag">
							<div class="form-group">
								<label class="col-md-5 control-label"> Customer </label>
								<div class="col-md-7">
									<selectivity list="customerList"
										property="createInvoice.customerCode" id="customerCode"
										object="customerCode" name="customerCode"
										ng-model="createInvoice.customerCode"
										friendly-name="Customer" form-name="customerinvoiceForm"
										validation="required"></selectivity>
								</div>
							</div>
						</div>

					<!-- 	<div class="form-group  col-md-3 col-lg-3"
							ng-if="createInoviceflag">
							<div class="form-group">
								<label class="col-md-5 control-label"> TRIP No. </label>
								<div class="col-md-7">
									<select id="tripMultiSelect" multiple="multiple"
										name="multiselect[]"
										ng-model="customerinvoicepopup.tripIdList"
										validation="required" friendly-name="Trip No"
										form-name="customerinvoiceForm"
										ng-options="option.id as option.text for option in tripsList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in tripsList"
											value="{{getOptionId(option)}}"
											ng-selected="isOptionSelected(option)"
											data-ng-bind-template="{{option.text}}"></option>
									</select>
								</div>
							</div>
						</div> -->
						<!-- <div class="form-group  col-md-3 col-lg-3" ng-if="createInoviceflag" align="center">
							<button class="btn btn-success" ng-click="createInvoice(table)">Create
								Invoice</button>
						</div> -->


					</fieldset>
				</div>
			</div>

			<div class="row book-widget-row" style="margin-top: 130px;">
				<div class="col-sm-12 ">
					<fieldset></fieldset>
				</div>
			</div>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>


 <div class="panel-body float-left padding-0" style="width: 100%;">
    <table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info"
									ng-if="createBookingflag">
									<thead>
										<tr>
										 
											<th class="width_6">Trip No<span style="color: red;">*</span></th>
											<th class="width_6">LOL<span style="color: red;">*</span></th>
											<th class="width_6">LOD<span style="color: red;">*</span></th>
											<th class="width_6">Truck Reg No<span
												style="color: red;">*</span></th>
											<th class="width_6">Truck Plate No<span
												style="color: red;">*</span></th>
											<th class="width_6">Trailer No<span style="color: red;">*</span></th>
											<th class="width_6">Trip Start Date<span
												style="color: red;">*</span></th>
											<th class="width_6">Driver Mobile No<span
												style="color: red;">*</span></th>
											<th class="width_6">Booking Mode<span
												style="color: red;">*</span></th>
											<th class="width_6">Customer<span style="color: red;">*</span></th>
											<th class="width_6">Transport Type<span
												style="color: red;">*</span></th>
											<th class="width_6">20'/40'<span style="color: red;">*</span></th>
											<th class="width_6">Container Type<span
												style="color: red;">*</span>
											</th>
											<th class="width_6">Con.Quantity<span
												style="color: red;">*</span></th>
											<!-- <th class="width_6">Create New Container's<span
												style="color: red;">*</span></th> -->
											<!-- <th class="width_6" ng-if="!quotationExist">Create New
												Quotation<span style="color: red;"></span>
											</th> -->
											<th class="width_6" >Quotation No<span
												style="color: red;"></span></th>
											<!-- <th class="width_6">Invoice No<span style="color: red;">*</span></th>
											<th class="width_6">Fuel Vocuher No<span
												style="color: red;">*</span></th> -->
										</tr>
									</thead>
									<tbody data-ng-repeat="(trIndex, table) in loadingEntry.tables"
										ng-controller="loadingEntryListCtrl">
										<tr>
											<td class="width_6 "><selectivity list="tripList"
													id="planTripId" name="planTripId"
													property="table.planTripId" ng-model="table.planTripId"
													object="getSubGroup" validation="required" disabled="true"
													friendly-name="Trip" form-name="TripForm"></selectivity></td>
											<td class="width_6 "><selectivity list="portList"
													property="table.fromLocation" disabled="true"
													id="fromLocation" name="fromLocation" form-name="TripForm"
													ng-model="table.fromLocation" validation="required"
													friendly-name="From Location"></selectivity></td>
											<td class="width_6 "><selectivity list="portList"
													property="table.toLocation" id="toLocation"
													name="toLocation" form-name="TripForm" disabled="true"
													ng-model="table.toLocation" validation="required"
													friendly-name="To Location"></selectivity></td>
											<td class="width_6 ">{{table.truckRegNo}}<input
												type="hidden" ng-model="table.bookingId"> <input
												type="hidden" ng-model="table.fromLocationCode"> <input
												type="hidden" ng-model="table.toLocationCode">

											</td>
											<td class="width_6 ">{{table.plateNo}}</td>
											<td class="width_6 ">{{table.trailerNo}}</td>
											<td class="width_6 ">{{table.tripStartDate}}</td>
											<td class="width_6 ">{{table.mobileNo}}</td>
											<td class="width_6 "><selectivity list="modeList"
													property="table.mode" ng-model="table.mode" id="mode{{trIndex}}"
													validation="required" friendly-name="Mode" name="mode_id{{trIndex}}"
													object="mode" form-name="bookingForm"></selectivity></td>
											<td class="width_6 "><selectivity list="mloList" disabled="true"
													ng-model="table.mloCode" property="table.mloCode"
													name="mloCode" validation="required"
													friendly-name="Customer" form-name="bookingForm"></selectivity></td>
											<td class="width_10">
												<div class="col-md-7 control-label text-left">
													<div class="radio radio-inline" style="padding-left: 0px;"
														ng-if="local == true">
														<label class="i-checks"> <input type="radio"
															id="transportType{{trIndex}}" class="radiobox style-0"
															ng-model="table.transportType"
															name="transportType{{trIndex}}" value="L" /> <i></i>
															Local
														</label>
													</div>

													<div class="radio radio-inline" ng-if="transit == true ">
														<label class="i-checks"> <input type="radio"
															id="transportType{{trIndex}}" class="radiobox style-0"
															ng-model="table.transportType"
															name="transportType{{trIndex}}" value="T" /> <i></i>
															Transit
														</label>
													</div>

													<div class="radio radio-inline" style="margin-left: 0%"
														ng-if="transit == true">
														<label class="i-checks"> <input type="radio"
															id="transportType{{trIndex}}" class="radiobox style-0"
															ng-model="table.transportType"
															name="transportType{{trIndex}}" value="TEC" /> <i></i>
															Transit (Empty)
														</label>
													</div>
												</div>
											</td>
											<td class="width_8 ">
												<div class="radio radio-inline" ng-if="table.mode ==1">
													<label class="i-checks"> <input type="radio"
														ng-change="contType(table,trIndex)"
														id="conSizeId{{trIndex}}" class="radiobox style-0"
														ng-model="table.conSizeId" name="conSizeId{{trIndex}}"
														value="1" /> <i></i> 20
													</label>
												</div>
												<div class="radio radio-inline" ng-if="table.mode ==1">
													<label class="i-checks"> <input type="radio"
														ng-change="contType(table,trIndex)"
														id="conSizeId{{trIndex}}" class="radiobox style-0"
														ng-model="table.conSizeId" name="conSizeId{{trIndex}}"
														value="2" /> <i></i> 40
													</label>
												</div>
											</td>
											<td>
												<div class="radio radio-inline" ng-if="table.mode ==1">
													<label class="i-checks"> <input type="radio"
														class="radiobox style-0"
														ng-change="contType(table,trIndex)"
														id="conTypeId{{trIndex}}" ng-model="table.containerTypeId"
														name="conTypeId{{trIndex}}" value="1" /> <i></i> Full
													</label>
												</div>
												<div class="radio radio-inline" ng-if="table.mode ==1">
													<label class="i-checks"> <input type="radio"
														class="radiobox style-0"
														ng-change="contType(table,trIndex)"
														id="conTypeId{{trIndex}}" ng-model="table.containerTypeId"
														name="conTypeId{{trIndex}}" value="2" /> <i></i> Empty
													</label>
												</div>
											</td>
											<td class="width_6 "><input type="text"
												ng-change="createNewContainers(table,trIndex)"
												class="form-control input-sm" name="quantity" maxlength="50"
												ng-model="table.quantity" validation="required"
												form-name="truckform" friendly-name="quantity"></td>
											<!-- <td class="width_6 ">
												<button class="btn btn-success"
													ng-click="createNewContainers(table,trIndex)">Create
													New Containers</button>
											</td> -->

											<!-- <td class="width_6" ng-if="!quotationExist">
												<button class="btn btn-success"
													ng-click="createQuoatation(table)">Create
													Quoatation</button>
											</td> -->

											<td class="width_6" ><selectivity
													list="quotationList" ng-model="table.quotationNo"
													property="table.quotationNo" class="quoLiCls"
													name="quotationNo" friendly-name="quotationNo"
													form-name="bookingForm"></selectivity></td>
											<!-- 	<td class="width_8 "><button class="btn btn-success"
													ng-click="createInvoice(table)">Create Invoice</button></td>
											<td class="width_6 "></td> -->
										</tr>

										<tr class="con-ele" ng-if="table.mode==1">
											<td></td>
											<td colspan="8">
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

													</tr>
													<tr
														ng-repeat="(bTrIndex, bookingConDtl) in table.bookingConCargoDtlList">
														<td class="subTable-brs text-center">{{bTrIndex+1}}</td>
														<td class="subTable-brs"><input type="text"
															class="form-control input-sm" validation="required"
															friendly-name="{{ 'Row-' + (trIndex+1) +' Container-' + (bTrIndex+1)"
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
															friendly-name="{{ 'Row-' + (trIndex+1) +' Container-' + (bTrIndex+1)+' (Gross Wt)'}}"></td>
														<td class="subTable-brs"><input type="text"
															class="form-control input-sm text-right"
															ng-model="bookingConDtl.netWt"
															name="netWt{{trIndex}}-{{bTrIndex}}"
															ng-blur="validateNetWeight(trIndex,bTrIndex,bookingConDtl.netWt,bookingConDtl.grossWt,bookingConDtl)"
															validation="numeric|required" form-name='bookingForm'
															friendly-name="{{ 'Row-' + (trIndex+1) +' Container-' + (bTrIndex+1)+' (Net Wt)'}}"></td>
	                                       <td class="subTable-brs"
													ng-init="bookingConDtl.commodityId = bookingConDtl.commodityId + ''">
													<autocomplete
													 ng-model="bookingConDtl.commodityId" 	
													attr-inputclass="subTable-brs"  click-activation="true"  
													 data="commodityList" 
													 ></autocomplete>
												<!-- 	<selectivity
														id="commodityId{{bTrIndex}}" list="commodityList"
														property="bookingConDtl.commodityId"
														ng-model="bookingConDtl.commodityId" name="commodityId"></selectivity> -->
														</td> 
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
															friendly-name="{{ 'Row-' + (trIndex+1) +' Container-' + (bTrIndex+1)+' (No.of packages)'}}"></td>
														<td class="subTable-brs text-center"
															ng-if="!bookingDtl.emptyCont"><label
															class="i-checks"> <input type="checkbox"
																id="isActive" class="checkbox style-0"
																name="isHaz{{bTrIndex}}" ng-model="bookingConDtl.isHaz" />
																<i></i>
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

													</tr>
												</table>
											</td>
										</tr>
										<tr class="con-ele" ng-if="table.mode==2">
											<td></td>
											<td colspan="8">
												<table class="table table-striped b-t b-light">
													<tr>
														<th class="width_6 text-center subTable-brs">S.No<span
															style="color: red;">*</span></th>
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

													</tr>
													<tr
														ng-repeat="(bTrIndex, bookingConDtl) in table.bookingConCargoDtlList track by bTrIndex">
														<td class="subTable-brs text-center">{{bTrIndex+1}}</td>
														<td class="subTable-brs"><input type="text"
															class="form-control input-sm text-right"
															ng-model="bookingConDtl.grossWt"
															name="grossWt{{trIndex}}-{{bTrIndex}}"
															validation="numeric|required" form-name='bookingForm'
															ng-blur="validateGorssWeight(trIndex,bTrIndex,bookingConDtl.grossWt,bookingConDtl.netWt,bookingConDtl)"
															friendly-name="{{ 'Row-' + (trIndex+1) +' Container-' + (bTrIndex+1)+' (Gross Wt)'}}"></td>
														<td class="subTable-brs"><input type="text"
															class="form-control input-sm text-right"
															ng-model="bookingConDtl.netWt"
															name="netWt{{trIndex}}-{{bTrIndex}}"
															ng-blur="validateNetWeight(trIndex,bTrIndex,bookingConDtl.netWt,bookingConDtl.grossWt,bookingConDtl)"
															validation="numeric|required" form-name='bookingForm'
															friendly-name="{{ 'Row-' + (trIndex+1) +' Container-' + (bTrIndex+1)+' (Net Wt)'}}"></td>
														  <td class="subTable-brs"
													ng-init="bookingConDtl.commodityId = bookingConDtl.commodityId + ''">
													<autocomplete
													 ng-model="bookingConDtl.commodityId" 	
													attr-inputclass="subTable-brs"  click-activation="true"  
													 data="commodityList" 
													 ></autocomplete>
												<!-- 	<selectivity
														id="commodityId{{bTrIndex}}" list="commodityList"
														property="bookingConDtl.commodityId"
														ng-model="bookingConDtl.commodityId" name="commodityId"></selectivity> -->
														</td> 
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
															friendly-name="{{ 'Row-' + (trIndex+1) +' Container-' + (bTrIndex+1)+' (No.of packages)'}}"></td>
														<td class="subTable-brs text-center"
															ng-if="!bookingDtl.emptyCont"><label
															class="i-checks"> <input type="checkbox"
																id="isActive" class="checkbox style-0"
																name="isHaz{{bTrIndex}}" ng-model="bookingConDtl.isHaz" />
																<i></i>
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

													</tr>
												</table>
											</td>
										</tr>
									</tbody>
								</table>
    <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
    </footer>
  </div>
  <!-- end widget content -->
 </div>