
<script>


</script>
<style>
.con-ele input {
	height: 30px;
}

.bookingDtlCls {
	border-bottom: 2px solid #23b7e5 !important;
/* 	border-top: 2px solid #23b7e5 !important; */
	/*  border-left: 1px solid #23b7e5 !important;
    border-right: 1px solid #23b7e5 !important; */
}

tbody::before {
	content: '';
	display: block;
	height: 15px;
	/*  border-left: 0px solid  !imNSA-NHAVA SHEVA, INDIA	portant;
   border-right: 1px solid #23b7e5 !important;
       width: 100%; */
}

<
style>a:hover {
	color: black;
}

srrs
.panel .actions {
	right: 8%;
}

.subTable-brs {
	padding: 8px !important;
}
.form-horizontal .control-label{
padding-top :0px !important;
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

							<div class="form-group ">
								<label class="col-md-5 control-label">Quosation No <span
									style="color: red"></span></label>
								<div class="col-md-7" >
									<label >{{quotation.quotationNo}}</label>
								</div>
								</div>
								<div class="form-group ">
								<label class="col-md-5 control-label">Service <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="servicePartnerTypelist" disabled="true"
										property="quotation.service" id="service"
										name="service" ng-model="quotation.service"
										object="quotationType" friendly-name="service"
										validation="required" form-name="quotationForm"
										></selectivity> -->
									
							<label >{{quotation.service}}</label>
									
										
								</div>
								</div>
								<div class="form-group " ng-if=quotation.mode=="LINER">
								<label class="col-md-5 control-label">POT <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="portList" disabled="true"
										property="quotation.aol" id="aol"
										name="aol" ng-model="quotation.aol"
										object="aol" friendly-name="AOL"
										validation="required" form-name="quotationForm"
										></selectivity> -->
										
							<label >{{quotation.potName}}</label>
										
										
							</div>
							</div><div class="form-group " ng-if=quotation.mode=="LINER">
								<label class="col-md-5 control-label">FPOD <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="portList" disabled="true"
										property="quotation.aol" id="aol"
										name="aol" ng-model="quotation.aol"
										object="aol" friendly-name="AOL"
										validation="required" form-name="quotationForm"
										></selectivity> -->
										
							<label >{{quotation.fpodName}}</label>
										
										
							</div>
							</div>
								<div class="form-group ">
								<label class="col-md-5 control-label">POL <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="portList" disabled="true"
										property="quotation.aol" id="aol"
										name="aol" ng-model="quotation.aol"
										object="aol" friendly-name="AOL"
										validation="required" form-name="quotationForm"
										></selectivity> -->
										
							<label >{{quotation.policdName}}</label>
										
										
							</div>
							</div>
							<div class="form-group ">
							
								<label class="col-md-5 control-label">Origin <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="portList" disabled="true"
										property="quotation.origin" id="origin"
										name="origin" ng-model="quotation.origin"
										object="origin" friendly-name="Quotation Type"
										 form-name="quotationForm"
										></selectivity> -->
						<label >{{quotation.orginName}}</label>
										
										
							</div>
							
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Customer <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="customerDropList" disabled="true"
										property="quotation.customer" id="customer"
										name="customer" ng-model="quotation.customer"
										object="customer" friendly-name="Customer"
										validation="required" form-name="quotationForm"
										></selectivity> -->
										
						<label >{{quotation.customer1}}</label>
										
							</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Sales Person <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="employeeList" disabled="true"
										property="quotation.salesPerson" id="salesPerson"
										name="salesPerson" ng-model="quotation.salesPerson"
										object="salesPerson" friendly-name="salesPerson"
										 form-name="quotationForm"
										></selectivity> -->
					<label ">{{quotation.salesPerson1}}</label>
										
										
										
							</div>
							</div>
							
							
							<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Vendor <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="customerList" disabled="true"
										property="quotation.vendor" id="quotationType_id"
										name="quotationType_id" ng-model="quotation.quotationType"
										object="quotationType" friendly-name="Quotation Type"
										form-name="quotationForm"
										></selectivity>
							</div>
							</div> -->
						
							<!-- <div class="form-group " >
								<label class="col-md-5 control-label">Vessel/Voyage<span
									style="color: red">*</span></label>
							<div class="col-md-7 ">
										<input type="text" class="form-control input-sm" disabled="true"
										name="Vessel" 
										property="quotation.vessel" id="vessel" ng-model="quotation.vessel"
										friendly-name="Vessel/Voyage" />
							</div>
							</div> -->
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Kind Attention <span
									style="color: red"></span></label>
								<div class="col-md-7">
								<!-- <textarea  type="text" class="form-control input-sm" disabled="true"
															name="attention"   form-name="trailerForm"
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="quotation.attention">
															</textarea> -->
															
						<label >{{quotation.attention}}</label>
															
															
															
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Terms & Condition <span
									style="color: red"></span></label>
								<div class="col-md-7">
								<!-- <textarea  type="text" class="form-control input-sm" disabled="true"
															name="remarks" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="quotation.termConditions">
															</textarea> -->
															
							<label >{{quotation.termConditions}}</label>
															
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Contract Type</label>
								<div class="col-md-7">
										<!-- <selectivity list="contractTypeList"
										property="quotation.contractType" id="contractType"
										name="contractType" ng-model="quotation.customer"
										object="contractType" friendly-name="contractType"
										form-name="quotationForm"
										></selectivity> -->
																		<label style="padding-left: 14px;">{{quotation.contractType}}</label>
										
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Cargo Type </label>
								<div class="col-md-7">
									<!-- <selectivity list="cargoTypeList" ng-model="quotation.cargoType"
										 property="quotation.cargoType"
										id="cargoType" 
										friendly-name="Cargo Type"
										form-name="quotationForm"></selectivity> -->
										<label style="padding-left: 14px;">{{quotation.cargoType}}</label>
										
								</div>
							</div>


						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Quotation Date <span
									style="color: red"></span></label>
								<div class="col-md-7 ">
									<!-- <ng-bs3-datepicker
										 data-ng-model="quotation.quotationDate"
										id="QuotationDate" name="QuotationDate" ng-disabled="true"
										
										friendly-name="Valid From" validation="required" /> -->
										
								<label style="padding-left: 14px;">{{quotation.quotationDate}}</label>
										
								</div>
								</div>
								<div class="form-group ">
								<label class="col-md-5 control-label">Branch <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="branchList"
										property="quotation.branch" id="branch"
										name="branch" ng-model="quotation.branch" disabled="true"
										object="branch" friendly-name="Branch"
										validation="required" form-name="quotationForm"></selectivity>
										 -->
										 
					<label style="padding-left: 14px;">{{quotation.branchName}}</label>
										 
										 
								</div>
								</div>
								<div class="form-group ">
								<label class="col-md-5 control-label">POD <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="portList"
										property="quotation.aod" id="aod"
										name="aod" ng-model="quotation.aod" disabled="true"
										object="aod" friendly-name="AOD"
										validation="required" form-name="quotationForm"
										></selectivity> -->
										
											<label style="padding-left: 14px;">{{quotation.aod1}}</label>
										
										
							</div>
							</div>
							<div class="form-group ">
							
								<label class="col-md-5 control-label">Destination <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="portList" disabled="true"
										property="quotation.destination" id="destination"
										name="destination" ng-model="quotation.destination"
										object="v" friendly-name="Destination"
										 form-name="quotationForm"
										></selectivity> -->
										
					<label style="padding-left: 14px;">{{quotation.destination1}}</label>
										
							</div>
							</div>
							
								<div class="form-group ">
								<label class="col-md-5 control-label">Shipper <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="shipperDropList" disabled="true"
										property="quotation.shipper" id="shipper"
										name="shipper" ng-model="quotation.shipper"
										object="shipper" friendly-name="shipper"
										form-name="quotationForm"
										></selectivity> -->
				<label style="padding-left: 14px;">{{quotation.shipper1}}</label>
										
										
										
							</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Sales Type <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="salesTypeList" disabled="true"
										property="quotation.salesType" id="salesType"
										name="salesType" ng-model="quotation.salesTypee"
										object="quotationType" friendly-name="Sales Type"
										validation="required" form-name="quotationForm"
										></selectivity> -->
										
						<label style="padding-left: 14px;">{{quotation.salesType1}}</label>
										
										
							</div>
							</div>
							
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Carrier <span
									style="color: red"></span></label>
								<div class="col-md-7">
									<!-- <input type="text" class="form-control input-sm" disabled="true"
										name="Carrier" 
										property="quotation.carrier" id="carrier" ng-model="quotation.carrier"
										friendly-name="Carrier" /> -->
										
								<label style="padding-left: 14px;">{{quotation.carrier}}</label>
										
							</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Origin/Transporter </label>
								<div class="col-md-7">
									<!-- <selectivity list="transList" ng-model="quotation.transOrg"
										 property="quotation.transOrg"
										id="transOrg" 
										friendly-name="transOrg"
										form-name="quotationForm"></selectivity> -->
																		<label style="padding-left: 14px;">{{quotation.transOrgName}}</label>
										
								</div>
							</div><div class="form-group ">
								<label class="col-md-5 control-label">Destination/Transporter </label>
								<div class="col-md-7">
									<!-- <selectivity list="transList" ng-model="quotation.transDeg"
										 property="quotation.transDeg"
										id="transDeg" 
										friendly-name="transDeg"
										form-name="quotationForm"></selectivity> -->
									<label style="padding-left: 14px;">{{quotation.transDegName}}</label>
										
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Remarks <span
									style="color: red"></span></label>
								<div class="col-md-7">
								<!-- <textarea  type="text" class="form-control input-sm" disabled="true"
															name="remarks"   form-name="trailerForm"
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="quotation.remarks">
															</textarea> -->
							<label style="padding-left: 14px;">{{quotation.remarks}}</label>
															
															
							</div>
							</div>		
							
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>

							<div class="form-group ">
								<label for="inputPassword" class="col-md-5 control-label">Mode <span style="color: red"></span>
								</label>
								<div class="col-md-7">

									<!-- <selectivity list="modeList"
										property="quotation.mode" id="mode"
										name="mode" ng-model="quotation.mode"
										object="mode" friendly-name="Mode" disabled="true"
										validation="required" form-name="quotationForm"
										></selectivity> -->
							<label style="padding-left: 14px;">{{quotation.mode}}</label>



								</div>
								</div>
								
								<div class="form-group ">
								<label class="col-md-5 control-label">Currency <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="currencylist"
										property="quotation.currency" id="currency" disabled="true"
										name="currency" ng-model="quotation.currency"
										object="currency" friendly-name="Currency"
										validation="required" form-name="quotationForm"
										></selectivity> -->
										
							<label style="padding-left: 14px;">{{quotation.currencyName}}</label>
										
										
								</div>
								</div>
								<div class="form-group ">
								<label class="col-md-5 control-label">Pickup Point <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="currencylist"
										property="quotation.currency" id="currency" disabled="true"
										name="currency" ng-model="quotation.currency"
										object="currency" friendly-name="Currency"
										validation="required" form-name="quotationForm"
										></selectivity> -->
										
							<label style="padding-left: 14px;">{{quotation.picPoint}}</label>
										
										
								</div>
								</div>
								
								<div class="form-group ">
								<label class="col-md-5 control-label">Term <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="TermList"
										property="quotation.term" id="term"
										name="term" ng-model="quotation.term" disabled="true"
										object="term" friendly-name="Term"
										validation="required" form-name="quotationForm"
										></selectivity> -->
										
				<label style="padding-left: 14px;">{{quotation.term1}}</label>
										
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Commodity <span
									style="color: red"></span></label>
								<div class="col-md-7">
									<!-- <input type="text" class="form-control input-sm"
										name="commodity" 
										property="quotation.commodity" id="commodity" ng-model="quotation.commodity"
										friendly-name="commodity" readonly/> -->
										
								<label style="padding-left: 14px;">{{quotation.commodity}}</label>
										
										
							</div>
							
							</div>
								<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Consignee <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="customerList" disabled="true"
										property="quotation.consignee" id="consignee"
										name="consignee" ng-model="quotation.consignee"
										object="consignee" 
										
										></selectivity>
							</div>
							</div> -->

							<div class="form-group ">
								<label class="col-md-5 control-label">Cargo Type <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
								<label style="padding-left: 14px;">{{quotation.cargoType}}</label>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Nominated By <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<!-- <selectivity list="nominatedDropList" disabled="true"
										property="quotation.nominatedBy" id="nominatedBy"
										name="nominatedBy" ng-model="quotation.nominatedBy"
										object="nominatedBy" 
										 form-name="quotationForm"
										></selectivity> -->
									<label style="padding-left: 14px;">{{quotation.nominatedBy1}}</label>
										
										
										
							</div>
							</div>
							
							
							
							<div class="form-group " >
								<label class="col-md-5 control-label">Validity Date </label>
							<div class="col-md-7 ">
									<!-- <ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="quotation.validityDate"
										id="validityDate" name="validityDate" ng-disabled="true"
										friendly-name="Valid From" validation="required" readonly /> -->
										
							<label style="padding-left: 14px;">{{quotation.validityDate}}</label>
										
							</div>
							</div>
							<div class="form-group"  align="center">							
							<label class="col-md-5 control-label">File Download </label>
							<div class="col-sm-12 col-md-12 col-lg-12"><div class="col-sm-6 col-md-6 col-lg-6"></div>
									<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="" ng-repeat="(tIndex, filelist)  in quotation.files"><!-- (tIndex, filelist) --> 
								<a id="tbnewExport{{tIndex}}" style="display: none"
											 href="{{filelist}}"
											download="{{filelist.filename}}"></a> <!-- href="{{filelist.filepath}}/{{filelist.filename}}"  -->
											
											<div>{{tIndex+1}} ) <a ng-click="downloadNewFile('tbnewExport'+$index)" style="color:green">{{filelist.filename}}</a> 
										<!-- 	<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)" data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>											
											</button> -->
											
											</div>
											
											
							
							</div>
											
											
											
											
							
							</div>
					</div>
					</div>
							<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Dimension <span
									style="color: red"></span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="dimensionName" 
										property="quotation.dimensionName" id="dimensionName" ng-model="quotation.dimensionName"
										friendly-name="Dimension" ng-disabled="true"  />
							</div>
							</div> -->
						</fieldset>
					</div>


				</div>


				<div>Freight Charges
					<table class="table table-striped b-t b-light">
						<tr>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_13 text-center">Charge Heads </th>
							<th colspan=1 class=" width_9 text-center">Unit </th>
														<th colspan=1 class=" width_9 text-center">Container Type </th>
							
							<th colspan=1 class=" width_8 text-center">Qty </th>
							<th colspan=1 class="width_10 text-center">Rate</th>
							<th colspan=1 class="width_10 text-center">Currency </th>
<!-- 								<th colspan=1 class=" width_10 text-center">Payment Method </th>
 -->							<th colspan=1 class=" width_6 text-center">Transaction Type </th>
								<th colspan=1 class=" width_14 text-center">Buy/Sell Party </th>
								<th colspan=1 class=" width_16 text-center">Notes </th>
						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr>
								<td>
						
								</td>
								<td class=" width_9">
										
									<label class="col-md-6 control-label  text-right">{{row.chargeHeads1}}</label>	
										
										</td>
								<td class=" width_9">
									
								<label class="col-md-6 control-label  text-right">{{row.unitName}}</label>	
										
										
										</td>
										<td class=" width_9">
									<label class="col-md-6 control-label  text-right">{{row.conType}}</label>	
									</td>
						<td class=" width_6" padding-left: 61px>
					
										
							<label class="col-md-6 control-label  text-right">{{row.qty}}</label>	
										
										</td>
								
								<td class=" width_7">
				
							<label class="col-md-7 control-label  text-right">{{row.rate}}</label>	
										
										
								</td>
								<td class=" width_10">
							
									<label class="col-md-7 control-label  text-right">{{row.currencyName}}</label>	
										
										
										
										</td>
										
									
														<td class=" width_10">
											
										<label class="col-md-7 control-label  text-right">{{row.transactionType1}}</label>	
										 
										 
										</td>
										
													<td class=" width_10">
									
																	<label class="col-md-7 control-label  text-right">{{row.tranType}}</label>	
										
										
										
										</td>
										
														
														<td class=" width_10"  >
									
															
															<label class="col-md-7 control-label  text-right">{{row.note}}</label>	
															
															
														</td>
														
														
									
							</tr>
						</tbody>
					</table>
	
				</div>
				<div>Local Charges
					<table class="table table-striped b-t b-light">
						<tr>

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
						<tbody ng-repeat="(trIndex, row) in quotation.addchargeData "
							ng-controller="quotationtableCtrl">
							<tr>
								
								<td class=" width_9">
										
									<label class="col-md-6 control-label  text-right">{{row.surcharge}}</label>	
										
										</td>
								<td class=" width_9">
									
								<label class="col-md-6 control-label  text-right">{{row.uom}}</label>	
										
										
										</td>
										<td class=" width_9">
									<label class="col-md-6 control-label  text-right">{{row.conType}}</label>	
									</td>
						<td class=" width_6" padding-left: 61px>
	
										
							<label class="col-md-6 control-label  text-right">{{row.hazardous}}</label>	
										
										</td>
								
								<td class=" width_7">
				
							<label class="col-md-7 control-label  text-right">{{row.oog}}</label>	
										
										
								</td>
								<td class=" width_10">
							
									<label class="col-md-7 control-label  text-right">{{row.currencyName}}</label>	
										
										
										
										</td>
									
														<td class=" width_10">
														
											<label class="col-md-7 control-label  text-right">{{row.addchrgtax}}</label>	
										 
										 
										</td>
										
													<td class=" width_10">
													<label class="col-md-7 control-label  text-right">{{row.bookingRate}}</label>	
										
										
										
										</td>
										
														
														<td class=" width_10"  >
										
															<label class="col-md-7 control-label  text-right">{{row.bookingqty}}</label>	
															
															
														</td>
														<td class=" width_10"  >
										
															<label class="col-md-7 control-label  text-right">{{row.bookremarks}}</label>	
															
															
														</td>
														
														
									
							</tr>
						</tbody>
					</table>
	
				</div>
				<div><br><br>
				<div class="col-sm-12 "  ng-if="checking==true">
							<fieldset>
                             <div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Selling Amount</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="quotation.sellAmt" id="sellAmt" name="sellAmt"
												readonly>
									</div>

								</div>
								<div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Buying Amount</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="quotation.buyAmt" id="buyAmt" name="buyAmt" readonly>
									</div>
								</div>
								

								<div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Total Profit</label>
									<div class="col-md-7"  ng-if="quotation.opr">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left; background-color: #99e599;"
												data-ng-model="quotation.buysellAmt" id="buysellAmt" name="buysellAmt"
												readonly>
									</div>
									<div class="col-md-7" ng-if="!quotation.opr">
										<input 
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left; background-color: #ff726f;"
												data-ng-model="quotation.buysellAmt" id="buysellAmt" name="buysellAmt"
												readonly>
									</div>
								</div>
								<div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Other Selling Amount</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="quotation.otherSelling" id="otherSelling" name="otherSelling" readonly>
									</div>
								</div>
								
								
							</fieldset>
						</div>
					<table class="table table-striped b-t b-light" ng-if=mode!="5">
						<tr>
							<th colspan=1 class="width_8 text-center">Container Type</span></th>
								 
									<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POL Free Days</th>
									<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POL Free Days</th>	
									<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POD Free Days</th>	
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POD Free Days</th>
							
						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationFreeDaysDtl"
							ng-controller="quotationtableCtrl">
							<tr>
								<td class=" width_9">
									<label class="col-md-6 control-label  text-right">{{row.conType}}</label>	
									</td>
									<td class=" width_9">
									<label class="col-md-6 control-label  text-right">{{row.polFreeDays}}</label>	
									</td><td class=" width_9">
									<label class="col-md-6 control-label  text-right">{{row.polFreeDays1}}</label>	
									</td><td class=" width_9">
									<label class="col-md-6 control-label  text-right">{{row.podFreeDays}}</label>	
									</td><td class=" width_9">
									<label class="col-md-6 control-label  text-right">{{row.podFreeDays1}}</label>	
									</td>
							</tr>
						</tbody>
					</table>
	
					<table class="table table-striped b-t b-light"  ng-if="checking==true">
						<tr>
							<th colspan=1 class="width_8 text-center">Sell Party Name</span></th>
								 
									<th colspan=1 class="width_8 text-center">Credit Limit</th>
																	<th colspan=1 class="width_8 text-center">Credit Days</th>
								
							
						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.consolidated"
							ng-controller="quotationtableCtrl">
							<tr>
								<td class=" width_9">
									<label class="col-md-6 control-label  text-center">{{row.tranType}}</label>	
									</td>
									<td class=" width_9">
									<label class="col-md-6 control-label  text-right">{{row.credit}}</label>	
									</td>
									<td class=" width_9">
									<label class="col-md-6 control-label  text-right">{{row.creditDays}}</label>	
									</td>
							</tr>
						</tbody>
					</table>

				<!-- 	<button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button> -->
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
									
										<button class="btn btn-danger" ng-click="cancel()"
											type="button">
											<i class="fa fa-close"></i> Cancel
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
										
										
										
									<%-- <security:authorize access="hasRole('${form_code}_${print}')">
								
					<button>
								 <i class="fa  fa-print text-success text"
										data-ng-click="printQuot(row.quotationId)"></i>

								</button>
									</security:authorize>
									<security:authorize access="hasRole('${form_code}_${print}')">
										<span> <i class="fa  fa-envelope text-success text"
										data-ng-click="sendmail(row.quotationId)"></i>
									</span>
								
									</security:authorize> --%>
										
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
