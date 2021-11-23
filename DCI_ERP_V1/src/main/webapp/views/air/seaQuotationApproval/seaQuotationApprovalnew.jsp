<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>

							<div class="form-group " ng-if="edit">
								<label class="col-md-5 control-label" style="padding-top: 10px;">Quotation No <span
									style="color: red">*</span></label>
								<div class="col-md-7" style="padding-top: 15px;">
									<label style="padding-left: 14px;">{{quotation.quotationNo}}</label>
								</div>
								</div>
								<div class="form-group ">
								<label for="inputPassword" class="col-md-5 control-label">Mode <span style="color: red">*</span>
								</label>
								<div class="col-md-7">

									<selectivity list="modelistHeader"
										property="quotation.mode" id="mode"
										name="mode" ng-model="quotation.mode"
										object="mode" friendly-name="Mode"
										validation="required" form-name="quotationForm"
										></selectivity>



								</div>
								</div>
								<div class="form-group" ng-if="quotation.mode==4">
								<label class="col-md-5 control-label">POT</label>
								<div class="col-md-7">
										<selectivity list="portList"
										property="quotation.pot" id="pot"
										name="pot" ng-model="quotation.pot"
										object="pot" friendly-name="pot"
										form-name="quotationForm"
										></selectivity>
							</div>
							</div><div class="form-group " ng-if="quotation.mode==4">
								<label class="col-md-5 control-label">FPOD </label>
								<div class="col-md-7">
										<selectivity list="portList"
										property="quotation.fpod" id="fpod"
										name="fpod" ng-model="quotation.fpod"
										object="fpod" friendly-name="fpol"
										 form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							<div class="form-group ">
							
								<label class="col-md-5 control-label">Origin <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="portList"
										property="quotation.origin" id="origin"
										name="origin" ng-model="quotation.origin"
										object="origin" friendly-name="Quotation Type"
										 form-name="quotationForm"
										></selectivity>
							</div>
							
							</div>
								<div class="form-group ">
								<label class="col-md-5 control-label">POL <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="portList"
										property="quotation.aol" id="aol"
										name="aol" ng-model="quotation.aol"
										object="aol" friendly-name="POL"
										validation="required" form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							
							
							<div class="form-group ">
								<label class="col-md-5 control-label">POD <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="portList"
										property="quotation.aod" id="aod"
										name="aod" ng-model="quotation.aod"
										object="aod" friendly-name="POD"
										validation="required" form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							<div class="form-group ">
							
								<label class="col-md-5 control-label">Destination <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="portList"
										property="quotation.destination" id="destination"
										name="destination" ng-model="quotation.destination"
										object="destination" friendly-name="Destination"
										 form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Customer <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="customerDropList"
										property="quotation.customer" id="customer"
										name="customer" ng-model="quotation.customer"
										object="customer" friendly-name="Customer"
										validation="required" form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Shipper <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="shipperDropList"
										property="quotation.shipper" id="shipper"
										name="shipper" ng-model="quotation.shipper"
										object="shipper" friendly-name="shipper"
										form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							
							
							
							<!--Request Of Mayuri we command this <div class="form-group ">
								<label class="col-md-5 control-label">Vendor <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="customerList"
										property="quotation.vendor" id="quotationType_id"
										name="quotationType_id" ng-model="quotation.quotationType"
										object="quotationType" friendly-name="Quotation Type"
										form-name="quotationForm"
										></selectivity>
							</div>
							</div>
						
							<div class="form-group " >
								<label class="col-md-5 control-label">Vessel/Voyage<span
									style="color: red"></span></label>
							<div class="col-md-7 ">
										<input type="text" class="form-control input-sm"
										name="Vessel" 
										property="quotation.vessel" id="vessel" ng-model="quotation.vessel"
										friendly-name="Vessel/Voyage" />
							</div>
							</div> -->
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Kind Attention <span
									style="color: red"></span></label>
								<div class="col-md-7">
								<textarea  type="text" class="form-control input-sm"
															name="attention"   form-name="trailerForm"
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="quotation.attention">
															</textarea>
							</div>
							</div>
								

                        <div class="form-group"  align="center">							
							<label class="col-md-5 control-label">File Upload </label>
								<div class="col-md-7"style="padding-right:257px">
								<div class="input-group">
								 <span class="btn btn-success fileinput-button"> 
        <i class="glyphicon glyphicon-plus"></i>
        <span>Select files...</span>
       
        <input id="fileupload" type="file" onchange="angular.element(this).scope().uploadFile(this)" multiple>
                         </span>
								<!-- <input type="file" class="form-control btn-primary" multiple class="form-control input-sm" name="excelfile"
								  onchange="angular.element(this).scope().uploadFile(this)" />
								  
								  	<span class="input-group-btn ">
										<button class="btn btn-info input-sm" type="button"
											ng-click="adduploadfiles()" data-toggle="tooltip" title="Add File">
											Upload
										</button>
									</span> -->
									</div>
								</div>
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12"><div class="col-sm-6 col-md-6 col-lg-6"></div>
									<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="" ng-repeat="(tIndex, filelist)  in quotation.files"><!-- (tIndex, filelist) --> 
								<a id="tbnewExport{{tIndex}}" style="display: none"
											 href="{{filelist.filepath}}"
											download="{{filelist.filename}}"></a> <!-- href="{{filelist.filepath}}/{{filelist.filename}}"  -->
											
											<div ng-if="edit">{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex,filelist.filepath,filelist.filename)" style="color:green">{{filelist.filename}}</a> 
											<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)" data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>											
											</button>
											
											</div>
											
											<div ng-if="!edit">{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex,filelist.filepath,filelist.filename)" style="color:green">{{filelist.filename}}</a> 
											<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)" data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>											
											</button>
											
											</div>
											
											
											
											
							
							</div>
					</div>
					</div>

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Quotation Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="quotation.quotationDate"
										id="quotationDate" name="QuotationDate"
										data-ng-change="checkDatesCL(quotation.quotationDate)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
								
								<div class="form-group " >
								<label class="col-md-5 control-label">Validity Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="quotation.validityDate"
										id="validityDate" name="ValidityDate"
										friendly-name="Validity Date" validation="required" />
								</div>
								</div>
								<div class="form-group ">
								<label class="col-md-5 control-label">Branch <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="branchList"
										property="quotation.branch" id="branch"
										name="branch" ng-model="quotation.branch"
										object="branch" friendly-name="Branch"
										validation="required" form-name="quotationForm"></selectivity>
										
								</div>
								</div>
								
							
								<div class="form-group ">
								<label class="col-md-5 control-label">Sales Person <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="employeeList"
										property="quotation.salesPerson" id="salesPerson"
										name="salesPerson" ng-model="quotation.salesPerson"
										object="salesPerson" friendly-name="salesPerson"
										 form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Sales Type <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="salesTypeList"
										property="quotation.salesType" id="salesType"
										name="salesType" ng-model="quotation.salesTypee"
										object="quotationType" friendly-name="Sales Type"
										validation="required" form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							
							<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Freight Term <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="freightTerm"
										property="quotation.freightTerm" id="freightTerm"
										name="freightTerm" ng-model="quotation.freightTerm"
										object="freightTerm" friendly-name="freightTerm"
										validation="required" form-name="quotationForm"
										></selectivity>
							</div>
							</div> -->
							
								<div class="form-group ">
								<label class="col-md-5 control-label">Carrier <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="carrierList" ng-model="quotation.carrier"
										 property="quotation.carrier"
										id="carrier"  name="Carrier"
										friendly-name="Carrier" validation="required"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Origin/Transporter </label>
								<div class="col-md-7">
									<selectivity list="transList" ng-model="quotation.transOrg"
										 property="quotation.transOrg"
										id="transOrg" 
										friendly-name="transOrg"
										form-name="quotationForm"></selectivity>
								</div>
							</div><div class="form-group ">
								<label class="col-md-5 control-label">Destination/Transporter </label>
								<div class="col-md-7">
									<selectivity list="transList" ng-model="quotation.transDeg"
										 property="quotation.transDeg"
										id="transDeg" 
										friendly-name="transDeg"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
							
							
							<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Carrier <span
									style="color: red"></span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="Carrier" 
										property="quotation.carrier" id="carrier" ng-model="quotation.carrier"
										friendly-name="Carrier" />
							</div>
							</div>
							 -->
							 <div class="form-group ">
								<label class="col-md-5 control-label">Remarks <span
									style="color: red"></span></label>
								<div class="col-md-7">
								<textarea  type="text" class="form-control input-sm"
															name="remarks"   form-name="trailerForm"
															class="custom-scroll width_250 resize-none" rows="3"
														validation="required"	ng-model="quotation.remarks">
															</textarea>
							</div>
							</div>
							
							
						
							
							
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
<div class="form-group ">
								<label class="col-md-5 control-label">Service <span
									style="color: red">*</span></label>
								<div class="col-md-7" ng-if="!edit">
										<selectivity list="servicePartnerTypelist"
										property="quotation.service" id="service"
										name="service" ng-model="quotation.service"
										object="quotationType" friendly-name="service"
										validation="required" form-name="quotationForm" disabled="true"
										></selectivity>
										
								</div>
								<div class="col-md-7" ng-if="edit">
										<selectivity list="servicePartnerTypelist"
										property="quotation.service" id="service"
										name="service" ng-model="quotation.service"
										object="quotationType" friendly-name="service"
										validation="required" form-name="quotationForm" disabled="true"
										></selectivity>
										
								</div>
								</div>
							
								
								<div class="form-group ">
								<label class="col-md-5 control-label">Currency <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="currencylist"
										property="quotation.currency" id="currency"
										name="currency" ng-model="quotation.currency"
										object="currency" friendly-name="Currency"
										validation="required" form-name="quotationForm"
										></selectivity>
										
								</div>
								</div>
								<div class="form-group ">
							
								<label class="col-md-5 control-label">Pickup Point <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="pickupList"
										property="quotation.picPoint" id="picPoint"
										name="picPoint" ng-model="quotation.picPoint"
										object="picPoint" friendly-name="picPoint"
										 form-name="quotationForm"
										></selectivity>
							</div>
							
							</div>
								<div class="form-group ">
								<label class="col-md-5 control-label">Freight Term <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="TermList"
										property="quotation.term" id="term"
										name="term" ng-model="quotation.term"
										object="term" friendly-name="Term"
										validation="required" form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Commodity <span ng-if=quotation.mode!="5"
									style="color: red">*</span></label>
								<div class="col-md-7">	
												
										<!-- <input type="text" class="form-control input-sm"
										name="commodity" 
										property="quotation.commodity" id="commodity" ng-model="quotation.commodity"
										friendly-name="commodity" /> -->
										
										<!-- <selectivity list="commodityList"
										property="quotation.commodity" id="commodity"
										name="commodity" ng-model="quotation.commodity"
										object="commodity" friendly-name="Commodity"
										form-name="quotationForm" validation="required"
										></selectivity> -->
										<div class="col-md-15 "
										class="selectivity-input example-input selectivity-slot voyage_sel">
									<select id="commodityL" multiple="multiple" name="commodityL"
									friendly-name="commodityL"  form-name="quotationForm"
										ng-model="quotation.commodityL" validation="required"
										ng-options="option.text for option in commodityList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in commodityList" 
											value="{{getOptionId(option)}}"
											data-ng-bind-template="{{option.commodityL}}"></option>
									</select>										
										 
									</div>
							</div>
							
							</div>
								<!-- Request Of Mayuri we command this<div class="form-group ">
								<label class="col-md-5 control-label">Consignee <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="customerList"
										property="quotation.consignee" id="consignee"
										name="consignee" ng-model="quotation.consignee"
										object="consignee" 
										
										></selectivity>
							</div>
							</div> -->
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Nominated By <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="nominatedDropList"
										property="quotation.nominatedBy" id="nominatedBy"
										name="nominatedBy" ng-model="quotation.nominatedBy"
										object="nominatedBy" 
										 form-name="quotationForm"
										></selectivity></div></div>
							
							
							
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Contract Type<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="contractTypeList"
										property="quotation.contractType" id="contractType"
										name="contractType" ng-model="quotation.customer"
										object="contractType" friendly-name="contractType"
										form-name="quotationForm"
										></selectivity>
							</div>
							</div>
								
							<div class="form-group ">
								<label class="col-md-5 control-label">Cargo Type <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="cargoTypeList" ng-model="quotation.cargoType"
										 property="quotation.cargoType"
										id="cargoType" 
										friendly-name="Cargo Type"
										form-name="quotationForm"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Terms & Condition <span
									style="color: red"></span></label>
								<div class="col-md-7">
								<textarea  type="text" class="form-control input-sm"
															name="remarks" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="quotation.termConditions">
															</textarea>
							</div>
							</div>
							<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Dimension <span
									style="color: red"></span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="dimensionName" 
										property="quotation.dimensionName" id="dimensionName" ng-model="quotation.dimensionName"
										friendly-name="Dimension" />
							</div>
							</div> -->
							

						</fieldset>
					</div>


				</div>


				<tabset justified="true" class="tab-container"> <!-- <tab
						heading="Freight Charges"
						style=" background: #a8ccce;">
				<div class="table-responsive clear" style="height:265px;">
					<table class="table table-striped b-t b-light">
						<tr>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_19 text-center">Charge Heads <span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_10 text-center">Unit <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_7 text-center">Container Type</th>
							<th colspan=1 class=" width_4 text-center">Qty <span
								style="color: red">*</span></th>
								<th colspan=1 class="width_5 text-center">Qty<span
								style="color: red">*</span></th>
							<th colspan=1 class="width_7 text-center">Rate<span
								style="color: red">*</span></th>
							<th colspan=1 class="width_12 text-center">Currency <span
									style="color: red">*</span></th>
								<th colspan=1 class=" width_10 text-center">Payment Method <span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_2 text-center">Transaction Type <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_14 text-center">Buy/Sell Party <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_8 text-center">Notes <span
								style="color: red"></span></th>
						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"
										ng-disabled="row.disabled"> <i></i>
								</label></td>
								<td class=" width_10"><selectivity list="chargeHeadList"
										property="row.chargeHeads" id="chargeHeads{{trIndex}}" ng-model="row.chargeHeads"
										 validation="required"
										name="chargeHeads{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(ChargeHeads)'}}"
										form-name="quotationForm" ></selectivity></td>
								<td class=" width_10">
										<selectivity list="UnitList"
										property="row.unit" id="unit"
										name="unit" ng-model="row.unit"
										object="unit" friendly-name="{{ 'Row' + ($index+1) + '(Unit)'}}"
										validation="required" form-name="quotationForm"
										></selectivity>
										</td>
										<td ng-if="row.unit==1" crlass=" width_9"><selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"  validation="required"
											name="conType{{trIndex1}}" ></selectivity></td>
											<td ng-if="row.unit!=1" crlass=" width_9"><selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"  
											name="conType{{trIndex1}}" ></selectivity></td>
						<td class=" width_7" ><input type="text" class="form-control input-sm text-right"
										name="qty" 
										property="row.qty" id="qty{{trIndex}}" ng-model="row.qty"
										friendly-name="{{ 'Row' + ($index+1) + '(Qty)'}}" />
										</td>
								
								<td class=" width_5" ><input type="text" class="form-control input-sm text-right"
										name="Qty" 
										property="row.rate" id="rate{{trIndex}}" ng-model="row.rate"
										friendly-name="{{ 'Row' + ($index+1) + '(rate)'}}" />
								</td>
								<td class=" width_12" ><selectivity list="currencylist"
										property="row.currency" id="currency{{trIndex}}" ng-model="row.currency"
										 validation="required"
										name="currency{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Currency)'}}"
										form-name="quotationForm" ></selectivity></td>
											
											<td class=" width_10" style="padding-left: 32px;"><selectivity list="PaymentMethodList"
										property="row.paymentMethod" id="paymentMethod{{trIndex}}" ng-model="row.paymentMethod"
										 validation="required"
										name="paymentMethod{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(PaymentMethod)'}}"
										form-name="quotationForm" ></selectivity></td>
										
														<td class=" width_7"><selectivity list="transactionTypeList"
										property="row.transactionType" id="transactionType{{trIndex}}" ng-model="row.transactionType"
										 validation="required"
										name="transactionType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Transaction Type)'}}"
										form-name="quotationForm" ></selectivity></td>
										
													<td class=" width_12"><selectivity list="serviceParnrDropList"
										property="row.buySell" id="buySell{{trIndex}}" ng-model="row.buySell"
										 validation="required"
										name="buySell{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Buy Sell)'}}"
										form-name="quotationForm" ></selectivity></td>
										
										<td class=" width_8"  style="padding-left: -56px;">
										<textarea  type="text" class="form-control input-sm"
															name="note"   
															class="custom-scroll width_250 resize-none" rows="3"
															property="row.note" id="note{{trIndex}}" ng-model="row.note"
										                   friendly-name="{{ 'Row' + ($index+1) + '(note)'}}">
															</textarea>
							</tr>
						</tbody>
					</table>
						
					<button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button>
					 
					<br>
<br>
<br>
 
				</div>
				</tab> -->
				<tab
heading="Freight Charges"  >
<div class="table-responsive clear">
<div class="wrapper-md">

<div class="row padding-top-10">
<div class="col-sm-12">
<div>
<!-- <tabset justified="true" class="tab-container"> <tab
heading="Freight/Origin/Destination Charges"
style="background:#5F9EA0; "> -->
<div>
<table class="table table-striped b-t b-light">
<thead>
<tr>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_19 text-center">Charge Heads <span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_10 text-center">Unit <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_7 text-center">Container Type</th>
							<!-- <th colspan=1 class=" width_4 text-center">Qty <span
								style="color: red">*</span></th> -->
								<th colspan=1 class="width_5 text-center">Qty<span
								style="color: red">*</span></th>
							<th colspan=1 class="width_7 text-center">Rate<span
								style="color: red">*</span></th>
							<th colspan=1 class="width_12 text-center">Currency <span
									style="color: red">*</span></th>
							<!-- 	<th colspan=1 class=" width_10 text-center">Payment Method <span
								style="color: red">*</span></th> -->
							<th colspan=1 class=" width_2 text-center">Transaction Type <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_14 text-center">Buy/Sell Party <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_8 text-center">Notes <span
								style="color: red"></span></th>
						</tr></thead>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"
										ng-disabled="row.disabled"> <i></i>
								</label></td>
								<td class=" width_10"><selectivity list="chargeHeadList"
										property="row.chargeHeads" id="chargeHeads{{trIndex}}" ng-model="row.chargeHeads"
										 validation="required"
										name="chargeHeads{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(ChargeHeads)'}}"
										form-name="quotationForm" ></selectivity></td>
								<td class=" width_10">
										<selectivity list="UnitList"
										property="row.unit" id="unit"
										name="unit" ng-model="row.unit"
										object="unit" friendly-name="{{ 'Row' + ($index+1) + '(Unit)'}}"
										validation="required" form-name="quotationForm"
										></selectivity>
										</td>
										<td ng-if="row.unit==1" crlass=" width_9"><selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"  validation="required"
											name="conType{{trIndex1}}" ></selectivity></td>
											<td ng-if="row.unit!=1" crlass=" width_9"><selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"  
											name="conType{{trIndex1}}" ></selectivity></td>
						<td class=" width_7" ><input type="text" class="form-control input-sm text-right"
										name="qty" 
										property="row.qty" id="qty{{trIndex}}" ng-model="row.qty"
										friendly-name="{{ 'Row' + ($index+1) + '(Qty)'}}" />
										</td>
								
								<td class=" width_5" ><input type="text" class="form-control input-sm text-right"
										name="Qty" 
										property="row.rate" id="rate{{trIndex}}" ng-model="row.rate"
										friendly-name="{{ 'Row' + ($index+1) + '(rate)'}}" />
								</td>
								<td class=" width_12" ><selectivity list="currencylist"
										property="row.currency" id="currency{{trIndex}}" ng-model="row.currency"
										 validation="required"
										name="currency{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Currency)'}}"
										form-name="quotationForm" ></selectivity></td>
											
										<!-- 	<td class=" width_10" style="padding-left: 32px;"><selectivity list="PaymentMethodList"
										property="row.paymentMethod" id="paymentMethod{{trIndex}}" ng-model="row.paymentMethod"
										 validation="required"
										name="paymentMethod{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(PaymentMethod)'}}"
										form-name="quotationForm" ></selectivity></td>
										 -->
														<td class=" width_7"><selectivity list="transactionTypeList"
										property="row.transactionType" id="transactionType{{trIndex}}" ng-model="row.transactionType"
										 validation="required"
										name="transactionType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Transaction Type)'}}"
										form-name="quotationForm" ></selectivity></td>
										
													<td class=" width_12"><selectivity list="serviceParnrDropList"
										property="row.buySell" id="buySell{{trIndex}}" ng-model="row.buySell"
										 validation="required"
										name="buySell{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Buy Sell)'}}"
										form-name="quotationForm" ></selectivity></td>
										
										<td class=" width_8"  style="padding-left: -56px;">
										<textarea  type="text" class="form-control input-sm"
															name="note"   
															class="custom-scroll width_250 resize-none" rows="3"
															property="row.note" id="note{{trIndex}}" ng-model="row.note"
										                   friendly-name="{{ 'Row' + ($index+1) + '(note)'}}">
															</textarea>
							</tr>


</tbody>
</table>

<button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button>
</div>
<br><br>

</tab></tabset>
</div>
</div>


</div>
</div>
<br>
<br>
<br>

</div>
</tab>
<tab
heading="Local Charges"  ng-if="quotation.mode=='4'">
<div class="table-responsive clear">
<div class="wrapper-md">

<div class="row padding-top-10">
<div class="col-sm-12">
<div>
<tabset justified="true" class="tab-container"> <tab
heading="Freight/Origin/Destination Charges"
style="background:#5F9EA0; ">
<div>
<table class="table table-striped b-t b-light">
<thead>
<tr>
<th colspan=1 class="width_1">Select</th>

<th colspan=1 class="width_15 text-center">Charge<span
style="color: red;"> </span></th>

<!-- <th colspan=1 class="width_10 text-center">Charge Type<span
style="color: red;"> </span></th> -->
<th colspan=1 class="width_3 text-center">UOM</th>
<th colspan=1 class="width_5 text-center"
>Container Type<span
style="color: red;"> </span></th>

<th colspan=1 class="width_5 text-center">Hazardous<span
style="color: red;"> </span></th>
<th colspan=1 class="width_5 text-center">OOG Cargo<span
style="color: red;"> </span></th>
<th colspan=1 class="width_5 text-center">Currency<span
style="color: red;"> *</span></th>
<th colspan=1 class="width_5 text-center">Tax(%)<span
style="color: red;"> </span></th>
<th colspan=1 class="width_5 text-center">Quoted Rate<span
style="color: red;">*</span></th>
<th colspan=1 class="width_5 text-center">Quantity<span
style="color: red;">*</span></th>

<th colspan=1 class="width_10 text-center">Remarks<span
style="color: red;"></span></th>
</tr>
</thead>
<tbody ng-repeat="(trIndex, row) in quotation.addchargeData track by trIndex" >
<tr>
<td><label class="i-checks m-b-none"> <input
type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>



<td class="width_10">


<selectivity list="chargeHeadList" property="row.surcharge"
id="surcharge{{trIndex}}" data-ng-model="row.surcharge"
name="surcharge{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(surcharge)'}}"
form-name="surcharge"></selectivity>

</td>
<!-- <td class="width_10">


<selectivity list="contTypeList" property="row.chargeType"
id="chargeType{{trIndex}}" data-ng-model="row.chargeType"
name="chargeType{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(chargeType)'}}"
></selectivity>
</td> -->
<td class="width_10">


<selectivity list="UnitList" property="row.uom"
id="uom{{trIndex}}" data-ng-model="row.uom"
name="uom{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(uom)'}}"
></selectivity>
</td>

<td class="width_5">
<div class="row">
<div class="col-xs-12">

<selectivity list="conTypeList"
property="row.conType" id="conType{{trIndex}}"
data-ng-model="row.conType"
name="conType{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(conType)'}}"
form-name="localForm"></selectivity>

</div>
</div>
</td>


<td class="width_5" align="center">
<div class="row">

<input type="checkbox" data-ng-model="row.hazardous"
id="hazardous" name="hazardous{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(hazardous)'}}">


</div>
</td>


<td class="width_5" align="center">
<div class="row">

<input type="checkbox" data-ng-model="row.oog" id="oog"
name="oog{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(oog)'}}">


</div>
</td>


<td class="width_10">
<div class="row">
<div class="col-xs-12">
<selectivity list="currencylist" property="row.addchrgcurrency"
id="addchrgcurrency{{trIndex}}" data-ng-model="row.addchrgcurrency"
name="addchrgcurrency{{trIndex}}" validation="required"
friendly-name="{{ 'Row' + $index + '(addchrgcurrency)'}}"
></selectivity>
</div>
</div>
</td>
<td class="width_5">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
maxlength=255 data-ng-model="row.addchrgtax"
name="addchrgtax{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(addchrgtax)'}}" />
</div>
</div>
</td>
<td class="width_5">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
maxlength=255 data-ng-model="row.bookingRate"
name="bookingRate{{trIndex}}"

friendly-name="{{ 'Row' + $index + '(bookingRate)'}}" />
</div>
</div>
</td>

<td class="width_5">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
maxlength=255 data-ng-model="row.bookingqty"
name="bookingqty{{trIndex}}" validation="required"

friendly-name="{{ 'Row' + $index + '(bookingqty)'}}" />
</div>
</div>
</td>

<td class="width_10">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
data-ng-model="row.bookremarks"
name="bookremarks{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(bookremarks)'}}" />
</div>
</div>
</td>



</tr>


</tbody>
</table>

<button ng-click="addAdditionalRow()" class="btn btn-sm btn-info"
 type="button">
<i class="fa fa-plus"></i>
</button>
<button ng-click="removequoRow()" class="btn btn-sm btn-danger"
 type="button">
<i class="fa fa-trash-o"></i>
</button>
</div>
<br><br>

</tab></tabset>
</div>
</div>


</div>
</div>
<br>
<br>
<br>

</div>
</tab>




</tabset><br><br>
							<div ng-if=quotation.mode!="5">
						<table class="table table-striped b-t b-light" >
							<tr>

								<th colspan=1 class="width_1 "><label
									class="i-checks m-b-none"> <input type="checkbox"
										ng-click="checkAllFreeDays()" ng-model="quotation.checkAllFreeDays"> <i></i>
								</label></th>
 
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span></th>
								 
									<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POL Free Days<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POL Free Days<span
									style="color: red;"> </span></th>	
									<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POD Free Days<span
									style="color: red;"> </span></th>	
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POD Free Days<span
									style="color: red;"> </span></th>		
										

							</tr>
							<tbody ng-repeat="(trIndex1, row) in quotation.quotationFreeDaysDtl"
								ng-controller="quotationtableCtrl">
								<tr>
								
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex1}}">
											<i></i>
									</label></td>
 
									<td class=" width_9"><selectivity list="conTypeList"
											property="row.conType"   data-toggle="tooltip"
											ng-model="row.conType"  
											name="conType{{trIndex1}}" ></selectivity></td>
									  
									 <td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="freeDays"
										property="row.polFreeDays" id="polFreeDays{{trIndex}}"
										ng-model="row.polFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pol FreeDays)'}}"
										 /></td>
										 <td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="freeDays"
										property="row.polFreeDays1" id="polFreeDays1{{trIndex1}}"
										ng-model="row.polFreeDays1"
										friendly-name="{{ 'Row' + ($index+1) + '(Pol FreeDays1)'}}"
										 /></td>
										 <td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="freeDays"
										property="row.podFreeDays" id="podFreeDays{{trIndex2}}"
										ng-model="row.podFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pod FreeDays)'}}"
										 /></td>
										 <td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="freeDays"
										property="row.podFreeDays1" id="podFreeDays1{{trIndex3}}"
										ng-model="row.podFreeDays1"
										friendly-name="{{ 'Row' + ($index+1) + '(Pod FreeDays)'}}"
										 /></td>
								</tr>
							</tbody>
						</table>

						<button ng-click="addRowFreeDays()" class="btn btn-sm btn-info"
							ng-disabled="subForm.$invalid" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRowFreeDays()" class="btn btn-sm btn-danger"
							ng-disabled="userForm{{$index}}.$invalid" type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br><br>
							<!-- <div>
						<table class="table table-striped b-t b-light">
							<tr>

								<th colspan=1 class="width_1 "><label
									class="i-checks m-b-none"> <input type="checkbox"
										ng-click="checkAllFreeDays1()" ng-model="quotation.checkAllFreeDays1"> <i></i>
								</label></th>
 
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span></th>
								 
									<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POL Free Days<span
									style="color: red;"> </span></th>	
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POD Free Days<span
									style="color: red;"> </span></th>			

							</tr>
							<tbody ng-repeat="(trIndex1, row) in quotation.quotationGroundFreeDaysDtl"
								ng-controller="quotationtableCtrl">
								<tr>
								
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex1}}">
											<i></i>
									</label></td>
 
									<td class=" width_9"><selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"  
											name="conType{{trIndex1}}" ></selectivity></td>
									  
									 <td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="freeDays"
										property="row.polFreeDays" id="polFreeDays{{trIndex}}"
										ng-model="row.polFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pol FreeDays)'}}"
										 /></td>
										 <td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="freeDays"
										property="row.podFreeDays" id="podFreeDays{{trIndex1}}"
										ng-model="row.podFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pod FreeDays)'}}"
										 /></td>
								</tr>
							</tbody>
						</table>

						<button ng-click="addRowGroundFreeDays()" class="btn btn-sm btn-info"
							ng-disabled="subForm.$invalid" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRowGroundFreeDays()" class="btn btn-sm btn-danger"
							ng-disabled="userForm{{$index}}.$invalid" type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div> -->
					<table class="table table-striped b-t b-light"  ng-if="checking==true">
						<tr>
							<th colspan=1 class="width_8 text-center">Sell Party Name</span></th>
								 
									<th colspan=1 class="width_8 text-center">Credit Limit</th>
																	<th colspan=1 class="width_8 text-center">Credit Days</th>
								
							
						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.consolidated"
							ng-controller="quotationtableCtrl">
							<tr>
								<td class=" width_9"><selectivity list="customerDropList"
										property="row.tranType" id="tranType{{trIndex}}" ng-model="row.tranType"
										 validation="required"
										name="tranType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(tranType)'}}"
										form-name="quotationForm" ></selectivity></td>
									<td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="credit"
										property="row.credit" id="credit{{trIndex1}}"
										ng-model="row.credit"
										friendly-name="{{ 'Row' + ($index+1) + '(credit)'}}"
										 /></td>
									<td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="creditDays"
										property="row.creditDays" id="creditDays{{trIndex1}}"
										ng-model="row.creditDays"
										friendly-name="{{ 'Row' + ($index+1) + '(CreditDays)'}}"
										 /></td>
							</tr>
						</tbody>
					</table>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
											<button class="btn btn-success" type="button"
											ng-if="quotation.status=='Pending'"
											ng-click="submitupdateapprove(quotation.quotationNo,quotation.consolidated)">
											<i class=""></i> Approve
										</button>
				
										<button class="btn btn-success" type="button"
											ng-if="quotation.status=='Pending'"
											ng-click="reject(quotation.quotationNo)">
											<i class=""></i> Reject
										</button>
										<button class="btn btn-danger" ng-click="cancel()"
											type="button">
											<i class="fa fa-close"></i> Back
										</button>
										<%-- <security:authorize access="hasRole('${form_code}_${print}')">
								<span>
								 <i class="fa  fa-print text-success text" data-toggle="tooltip" title="Print"
										data-ng-click="printQuot(row.quotationId)"></i>
									</span>
									</security:authorize>
									<security:authorize access="hasRole('${form_code}_${print}')">
										<span> <i class="fa  fa-envelope text-success text" data-toggle="tooltip" title="Email"
										data-ng-click="sendmail(row.quotationId)"></i>
									</span>
									</security:authorize> --%>
										<security:authorize access="hasRole('F5576_${print}')">
										<button class="btn btn-success" ng-if="edit"
											data-ng-click="printQuot(quotation.quotationId)">
											<i class="fa fa-print"></i> Print Quotation
										</button>
										</security:authorize>
										
										<security:authorize access="hasRole('F5576_${print}')">
										<button class="btn btn-success" ng-if="edit"
											data-ng-click="sendmail(quotation.quotationId)">
											<i class="fa  fa-envelope"></i> Send-Email
										</button>
										</security:authorize>
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/ng-template" id="algorithmModal">
<div class="modal-header"> Quotation Algorithm </div>
<div class="row">
<div class="width_90 m-n-auto">
	<iframe title='Quotation Algorithm' class='' 
        width='625' height='500' src='assets/algorithm_Docs/Quotation_Algorithm.pdf'
         allowfullscreen='true' frameborder='0' align="center"></iframe>
</div>
</div>
<div class="modal-footer">
	<button class="btn btn-danger" ng-click="closeHelpDialog()">Close</button>
</div>
</script>
