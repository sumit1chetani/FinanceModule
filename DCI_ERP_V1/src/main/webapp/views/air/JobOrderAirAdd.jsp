<script>


</script>
<style>
.con-ele input {
	height: 30px;
}
input[type=number]::-webkit-inner-spin-button, 
input[type=number]::-webkit-outer-spin-button { 
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    margin: 0; 
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

.text-space {
	padding-bottom: 10px;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<security:authentication var="user" property="principal" />
	<input type="hidden" value="${form_code}" id="form_code_id">
	<input type="hidden" value="${user.userId}" id="tempw">
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div style="width: 20%;position: absolute;margin-top: -33px;margin-left: 78%;" ng-if="isEdit">
		<label style="color:#e25d5d">Quick Links &nbsp;&nbsp; </label>
		 <select ng-change="quickLinkMethd(joborder.jobId,qukLinkVal)" ng-init="qukLinkVal='Select'" ng-model="qukLinkVal">
		 <option value="Select">Select</option>
		  <option value="HAWB">HAWB</option>
		  <option value="MAWB">MAWB</option>
		  <option value="Delivery Order">Delivery Order</option>
		  <option value="Sales Invoice">Sales Invoice</option>
		  <option value="Purchase Invoice">Purchase Invoice</option>
		</select>
		</div>
		<div>
			
			<div class=" form-controller panel-body ">
				<form name="jobOrderForm" class="form-horizontal" novalidate>
				<div ng-if="!disable">
					<div class="row book-widget-row">


						<div class="col-sm-12 " align="center">


							<div class="form-group col-md-12 col-lg-12" ng-if="isEdit">
								<label for="inputPassword" class="control-label col-md-5">Job
									No </label>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm text-left"
										ng-model="joborder.jobNo" name="jobNo" maxlength=50 disabled
										form-name='jobOrderForm' friendly-name="jobNo">
								</div>
							</div>

						</div>

						<div class="col-sm-12 ">
							<fieldset>
                             <div class="form-group col-md-3 col-lg-3"ng-if="!isEdit">
									<label class="col-md-5 control-label"> Quotation <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="quotationList"
											ng-model="joborder.quotationNo"
											property="joborder.quotationNo" class="quoLiCls"
											name="quotationNo" id="quotationNo" friendly-name="QuotationNo"
											validation="required" form-name="jobOrderForm"></selectivity>
									</div>

								</div>
								<div class="form-group col-md-3 col-lg-3"ng-if="isEdit">
								<label class="col-md-5 control-label view-label">Quotation: </label> 
								<div class="col-md-7"> 
								<label class="col-md-7 control-label view-content"><a data-ng-click="viewQuotation(joborder.quotationNo)">  <span class="tool-tip-span font-blue"> {{joborder.quotationnum}}</span></a></label> 
								</div>
								</div>
								
								
								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Mode 
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="modeList" ng-model="joborder.mode"
											property="joborder.mode" name="mode" validation="required"
											friendly-name=Mode form-name="jobOrderForm"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Job
										Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.jobDate"
											name="jobDate" id="jobDate" form-name="jobOrderForm"
											data-ng-change="checkDatesCL(joborder.jobDate)"
											friendly-name="Job Date" validation="required" />
									</div>
									
									
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Branch <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7" ng-if="!edit">
										<selectivity list="branchList" ng-model="joborder.branch"
											property="joborder.branch" name="branch" id="branch"
											validation="required" friendly-name=BRANCH
											form-name="jobOrderForm"></selectivity>
									</div>
									
									<div class="col-md-7"  ng-if="edit">
										<selectivity list="branchList" ng-model="joborder.branch"
											property="joborder.branch" name="branch" id="branch"
											validation="required" friendly-name=BRANCH
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Customer <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" ng-model="joborder.customer"
											property="joborder.customer" name="customer" id="customer"
											validation="required" friendly-name="Customer"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Shipper <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="shipperDropList" ng-model="joborder.shipper"
											property="joborder.shipper" name="shipper" id="shipper"
											validation="required" friendly-name="Shipper"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Term <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="TermList" property="joborder.term" 
											ng-model="joborder.term" name="term" id="term" validation="required"
											friendly-name="Term" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Destination <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.destination"
											ng-model="joborder.destination" id="destination" name="destination"
											validation="required" friendly-name="Destination"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>



							</fieldset>
						</div>
					</div>

					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> AOL <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aol"
											ng-model="joborder.aol" name="aol" id="aol" validation="required"
											friendly-name="Aol" form-name="jobOrderForm"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> AOD <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aod"
											ng-model="joborder.aod" name="aod" id="aod" validation="required"
											friendly-name="AOD" form-name="jobOrderForm"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Origin <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.origin"
											ng-model="joborder.origin" name="origin" id="origin"
											validation="required" friendly-name="Origin"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Service <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7" ng-if="!edit">
										<selectivity list="servicePartnerTypelist" id="service"
											ng-model="joborder.service" property="joborder.service"
											name="service" id="service" validation="required" friendly-name=SERVICE
											form-name="jobOrderForm"></selectivity>
									</div>
									
									<div class="col-md-7" ng-if="edit" >
										<selectivity list="servicePartnerTypelist" id="service"
											ng-model="joborder.service" property="joborder.service"
											name="service" id="service" validation="required" friendly-name=SERVICE
											form-name="jobOrderForm"  disabled="true"></selectivity>
									</div>
								</div>
								


							</fieldset>
						</div>
					</div>
					<div class="  row book-widget-row ">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Commodity <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">			
									
									
										<input type="text" class="form-control input-sm"
										name="Commodity"  
										property="joborder.commodity" id="commodity" ng-model="joborder.commodity"
										friendly-name="commodity" />						
											<!-- 
											<selectivity list="commodityList"
										property="joborder.commodity" id="commodity"
										name="commodity" ng-model="joborder.commodity"
										object="commodity" friendly-name="Commodity"
										validation="required" form-name="jobOrderForm"
										></selectivity> -->
									</div>
								</div>
								
								<div>
								<!-- <div ng-if="user.userId!='A0001'" || ng-if="user.userId!='E0001'" > -->
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Job Status 
									</label>
									<div class="col-md-7">
										<selectivity list="jobStatusList"
											property="joborder.jobStatus" ng-model="joborder.jobStatus"
											name="jobStatus"  id="jobStatus"
											friendly-name="job Status" form-name="jobOrderForm" ></selectivity>
									</div>
									
								
								
							</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Currency <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="currencylist" property="joborder.currency"
											ng-model="joborder.currency" name="currency" id="currency"
											validation="required" friendly-name="Currency"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Ex-Rate <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
										ng-blur="checkExRate()"	ng-model="joborder.exRate" name="exRate" id="exRate"
											validation="required" form-name='jobOrderForm'
											friendly-name="Ex Rate">
									</div>
								</div>

							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Type <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="salesTypeList"
											property="joborder.salesType" ng-model="joborder.salesType"
											name="salesType" validation="required" id="salesType"
											friendly-name="Sales Type" form-name="jobOrderForm"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Person <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="employeeList"
											property="joborder.salesPerson" id="salesPerson"
											ng-model="joborder.salesPerson" name="salesPerson"
											validation="required" friendly-name="Sales Person"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Nominated By <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="nominatedDropList"
											property="joborder.nominatedBy"
											ng-model="joborder.nominatedBy" name="nominatedBy"
											validation="required" friendly-name="Nominated By"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3" >
									<label class="col-md-5 control-label"> Consignee 
									</label>
									<div class="col-md-7">
										<selectivity list="consigneeDropList" property="joborder.consignee"
											ng-model="joborder.consignee" name="consignee" id="consignee"
											 friendly-name="Consignee"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>

							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Carrier <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											ng-model="joborder.carrier" name="carrier"
											form-name='jobOrderForm' friendly-name="Carrier">
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Flight No <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
									
										<input type="text" class="form-control input-sm" 
											ng-model="joborder.flightNo" name="flightNo" id="flightNo"
											form-name='jobOrderForm' friendly-name="Flight No">
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Flight Date <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.flightDate" 
											name="flightDate" id="flightDate" form-name="jobOrderForm" 
											friendly-name="Flight Date" validation="required" />
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3" >
									<label class="col-md-5 control-label"> Vendor <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="vendorDropList" property="joborder.vendor"
											ng-model="joborder.vendor" name="vendor" id="vendor"
											validation="required" friendly-name="Vendor"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>
					</div>

					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Customs Broker <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList"
											property="joborder.customsBroker"
											ng-model="joborder.customsBroker" name="customsBroker"
											validation="required" friendly-name="Customs Broker"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
                              <div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Work Order No <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.workOrder" name="workOrder"
											form-name='jobOrderForm' friendly-name="workOrder"
											>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> T/S Trackingshipment1 <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.truckship1" name="trackship1"
											form-name='jobOrderForm' friendly-name="trackship1"
											>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">T/S Trackingshipment2<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.truckship2" name="trackship2"
											form-name='jobOrderForm' friendly-name="trackship2"
											>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
					</div>
					
					
					
					<div ng-if="disable">
					<div class="row book-widget-row">


						<div class="col-sm-12 " align="center">


							<div class="form-group col-md-12 col-lg-12" ng-if="isEdit">
								<label for="inputPassword" class="control-label col-md-5">Job
									No </label>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm text-left"
										ng-model="joborder.jobNo" name="jobNo" maxlength=50 disabled
										form-name='jobOrderForm' friendly-name="jobNo" disabled="true">
								</div>
							</div>

						</div>

						<div class="col-sm-12 ">
							<fieldset>
                             <div class="form-group col-md-3 col-lg-3"ng-if="!isEdit">
									<label class="col-md-5 control-label"> Quotation <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="quotationList"
											ng-model="joborder.quotationNo"
											property="joborder.quotationNo" class="quoLiCls"
											name="quotationNo" id="quotationNo" friendly-name="QuotationNo"
											validation="required" form-name="jobOrderForm"></selectivity>
									</div>

								</div>
								<div class="form-group col-md-3 col-lg-3"ng-if="isEdit">
								<label class="col-md-5 control-label view-label">Quotation: </label> 
								<div class="col-md-7"> 
								<label class="col-md-7 control-label view-content"><a data-ng-click="viewQuotation(joborder.quotationNo)">  <span class="tool-tip-span font-blue"> {{joborder.quotationnum}}</span></a></label> 
								</div>
								</div>
								
								
								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Mode
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="modeList" ng-model="joborder.mode"
											property="joborder.mode" name="mode" validation="required"
											friendly-name=Mode form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Job
										Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.jobDate"
											name="jobDate" id="jobDate" form-name="jobOrderForm"
											data-ng-change="checkDatesCL(joborder.jobDate)"
											friendly-name="Job Date" validation="required" disabled="true"/>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Branch <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="branchList" ng-model="joborder.branch"
											property="joborder.branch" name="branch" id="branch"
											validation="required" friendly-name=BRANCH
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Customer <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" ng-model="joborder.customer"
											property="joborder.customer" name="customer" id="customer"
											validation="required" friendly-name="Customer"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Shipper <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="shipperDropList" ng-model="joborder.shipper"
											property="joborder.shipper" name="shipper" id="shipper"
											validation="required" friendly-name="Shipper"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Term <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="TermList" property="joborder.term" 
											ng-model="joborder.term" name="term" id="term" validation="required"
											friendly-name="Term" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Destination <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.destination"
											ng-model="joborder.destination" id="destination" name="destination"
											validation="required" friendly-name="Destination"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>



							</fieldset>
						</div>
					</div>

					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> AOL <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aol"
											ng-model="joborder.aol" name="aol" id="aol" validation="required"
											friendly-name="Aol" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> AOD <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aod"
											ng-model="joborder.aod" name="aod" id="aod" validation="required"
											friendly-name="AOD" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Origin <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.origin"
											ng-model="joborder.origin" name="origin" id="origin"
											validation="required" friendly-name="Origin"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Service <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="servicePartnerTypelist" id="service"
											ng-model="joborder.service" property="joborder.service"
											name="service" id="service" validation="required" friendly-name=SERVICE
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								


							</fieldset>
						</div>
					</div>
					<div class="  row book-widget-row ">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Commodity <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">			
									
									
										<input type="text" class="form-control input-sm"
										name="Commodity"  
										property="joborder.commodity" id="commodity" ng-model="joborder.commodity"
										friendly-name="commodity" disabled="true"/>						
											<!-- 
											<selectivity list="commodityList"
										property="joborder.commodity" id="commodity"
										name="commodity" ng-model="joborder.commodity"
										object="commodity" friendly-name="Commodity"
										validation="required" form-name="jobOrderForm"
										></selectivity> -->
									</div>
								</div>
									
								<div ng-if="unique">
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Job Status 
									</label>
									<div class="col-md-7">
										<selectivity list="jobStatusList"
											property="joborder.jobStatus" ng-model="joborder.jobStatus"
											name="jobStatus"  id="jobStatus"
											friendly-name="job Status" form-name="jobOrderForm" ></selectivity>
									</div>
								</div>
								</div>
								<div ng-if="!unique">
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Job Status 
									</label>
									<div class="col-md-7">
										<selectivity list="jobStatusList"
											property="joborder.jobStatus" ng-model="joborder.jobStatus"
											name="jobStatus"  id="jobStatus"
											friendly-name="job Status" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Currency <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="currencylist" property="joborder.currency"
											ng-model="joborder.currency" name="currency" id="currency"
											validation="required" friendly-name="Currency"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Ex-Rate <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
										ng-blur="checkExRate()"	ng-model="joborder.exRate" name="exRate" id="exRate"
											validation="required" form-name='jobOrderForm'
											friendly-name="Ex Rate" disabled="true">
									</div>
								</div>

							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Type <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="salesTypeList"
											property="joborder.salesType" ng-model="joborder.salesType"
											name="salesType" validation="required" id="salesType"
											friendly-name="Sales Type" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Person <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="employeeList"
											property="joborder.salesPerson" id="salesPerson"
											ng-model="joborder.salesPerson" name="salesPerson"
											validation="required" friendly-name="Sales Person"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Nominated By <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="nominatedDropList"
											property="joborder.nominatedBy"
											ng-model="joborder.nominatedBy" name="nominatedBy"
											validation="required" friendly-name="Nominated By"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3" >
									<label class="col-md-5 control-label"> Consignee 
									</label>
									<div class="col-md-7">
										<selectivity list="consigneeDropList" property="joborder.consignee"
											ng-model="joborder.consignee" name="consignee" id="consignee"
											 friendly-name="Consignee"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Carrier <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											ng-model="joborder.carrier" name="carrier"
											form-name='jobOrderForm' friendly-name="Carrier" disabled="true">
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Flight No <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
									
										<input type="text" class="form-control input-sm" 
											ng-model="joborder.flightNo" name="flightNo" id="flightNo"
											form-name='jobOrderForm' friendly-name="Flight No" disabled="true">
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Flight Date <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.flightDate" 
											name="flightDate" id="flightDate" form-name="jobOrderForm" 
											friendly-name="Flight Date" validation="required" disabled="true"/>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3" >
									<label class="col-md-5 control-label"> Vendor <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.vendor"
											ng-model="joborder.vendor" name="vendor" id="vendor"
											validation="required" friendly-name="Vendor"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>
					</div>

					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Customs Broker <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList"
											property="joborder.customsBroker"
											ng-model="joborder.customsBroker" name="customsBroker"
											validation="required" friendly-name="Customs Broker"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
                              <div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Work Order No <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.workOrder" name="workOrder"
											form-name='jobOrderForm' friendly-name="workOrder" disabled="true"
											>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> T/S Trackingshipment1 <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.truckship1" name="trackship1"
											form-name='jobOrderForm' friendly-name="trackship1" disabled="true"
											>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">T/S Trackingshipment2<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.truckship2" name="trackship2"
											form-name='jobOrderForm' friendly-name="trackship2" disabled="true"
											>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
					</div>
					

					<br> <br> <br>
					<div ng-if="!disable">

					<div class=" form-controller table-responsive clear ">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan="1" class="width_1"></th>
									<!-- <th colspan="1" class="width_3 text-center">S.No</th> -->
									<th colspan="1" class="width_13 text-center">Charge Heads<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_9 text-center">Units<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_6 text-center">Transaction
										type<span style="color: red;">*</span>
									</th>
									<th colspan="1" class="width_7 text-center">Quantity<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_8 text-center">Rate<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_9 text-center">Currency<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_8 text-center">Ex-Rate<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_10 text-center">Amount<span
										style="color: red;">*</span></th>
							<!-- 		<th colspan="1" class="width_9 text-center">Payment Mode<span
										style="color: red;">*</span></th> -->
									<th colspan="1" class="width_9 text-center">Buy/Sell
										Party<span style="color: red;">*</span>
									</th>
									<th colspan="1" class="width_12 text-center">Status<span
										style="color: red;">*</span></th>
								</tr>
							</thead>
							<tbody ng-repeat="(trIndex, jobOrderDtl) in joborder.joborderDtl"
								class="bookingDtlCls" ng-controller="jobtableCtrl">
								<tr>
									<td ng-if="jobOrderDtl.status==1"><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select"><i></i></label></td>
											
											<td ng-if="jobOrderDtl.status!=1"><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select" disabled=ture><i></i></label></td>
								
								
									<!-- <td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select"><i></i></label></td> -->
									<!-- <td class="text-center">{{trIndex+1}}</td> -->
									<td ng-if="jobOrderDtl.status==1"><selectivity list="chargeHeadList"
											property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}"
											ng-model="jobOrderDtl.chargeHead"
											name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}"
											form-name="jobOrderDtlForm" disabled=false></selectivity></td>
											<td ng-if="jobOrderDtl.status!=1"><selectivity list="chargeHeadList"
											property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}"
											ng-model="jobOrderDtl.chargeHead"
											name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}"
											form-name="jobOrderDtlForm" disabled=true></selectivity></td>

									<td ng-if="jobOrderDtl.status==1"><selectivity list="UnitList"
										property="jobOrderDtl.unit" id="unit{{trIndex}}"
											ng-model="jobOrderDtl.unit" name="unit{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td>
											<td ng-if="jobOrderDtl.status!=1"><selectivity list="UnitList"
										property="jobOrderDtl.unit" id="unit{{trIndex}}"
											ng-model="jobOrderDtl.unit" name="unit{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
											

									 <td ng-if="jobOrderDtl.status==1"><selectivity list="transactionTypeList"
											property="jobOrderDtl.transactionType" id="transactionTypes{{trIndex}}"
											ng-model="jobOrderDtl.transactionType"
											name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td> 
											<td ng-if="jobOrderDtl.status!=1"><selectivity list="transactionTypeList"
											property="jobOrderDtl.transactionType" id="transactionTypes{{trIndex}}"
											ng-model="jobOrderDtl.transactionType"
											name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td> 

									<td ng-if="jobOrderDtl.status==1"><input type="text" id="quantity{{trIndex}}"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}" 
										validation="required|integer" form-name='jobOrderForm'
										maxlength="9" ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}">
									</td>
									<td ng-if="jobOrderDtl.status!=1"><input type="text" id="quantity{{trIndex}}"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}" 
										validation="required|integer" form-name='jobOrderForm'
										maxlength="9" ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}" disabled=true>
									</td>

									<td ng-if="jobOrderDtl.status==1"><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}">
									</td>
									<td ng-if="jobOrderDtl.status!=1"><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}" disabled=true>
									</td>

									<td ng-if="jobOrderDtl.status==1"><selectivity list="currencylist"
											property="jobOrderDtl.currency" id="currency{{trIndex}}"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td>
											<td ng-if="jobOrderDtl.status!=1"><selectivity list="currencylist"
											property="jobOrderDtl.currency" id="currency{{trIndex}}"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>

									<td ng-if="jobOrderDtl.status==1"><input type="text"
										class="form-control input-sm text-right"
										id="exRate{{trIndex}}" ng-model="jobOrderDtl.exRate" 
										name="exRate{{trIndex}}" validation="required|integer"
										form-name='jobOrderForm' 
										ng-blur="CheckExRateDtl(jobOrderDtl.currency,trIndex)"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}">
									</td>
									<td ng-if="jobOrderDtl.status!=1"><input type="text"
										class="form-control input-sm text-right"
										id="exRate{{trIndex}}" ng-model="jobOrderDtl.exRate" 
										name="exRate{{trIndex}}" validation="required|integer"
										form-name='jobOrderForm' 
										ng-blur="CheckExRateDtl(jobOrderDtl.currency,trIndex)"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}" disabled=true>
									</td>
									

									<td ng-if="jobOrderDtl.status==1"><input type="text"
										class="form-control input-sm text-right" id="amount{{trIndex}}"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										ng-change="ratevalues1()" validation="required|integer" 
										form-name='jobOrderForm'
										
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}" disabled=false>
									</td>
									<td ng-if="jobOrderDtl.status!=1"><input type="text"
										class="form-control input-sm text-right" id="amount{{trIndex}}"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										ng-change="ratevalues1()" validation="required|integer" 
										form-name='jobOrderForm'
										
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}" disabled=true>
									</td>
<!-- 
									<td ng-if="jobOrderDtl.status==1"><selectivity list="PaymentMethodList"
											property="jobOrderDtl.paymentMode"
											id="paymentModes{{trIndex}}"
											ng-model="jobOrderDtl.paymentMode"
											name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td>
											<td ng-if="jobOrderDtl.status!=1"><selectivity list="PaymentMethodList"
											property="jobOrderDtl.paymentMode"
											id="paymentModes{{trIndex}}"
											ng-model="jobOrderDtl.paymentMode"
											name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td> -->

                                    <td ng-if="jobOrderDtl.transactionType==1 && jobOrderDtl.status==1"><selectivity list="customerBuyList"
											property="jobOrderDtl.buySellParty" id="buySellPartys{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" ></selectivity></td>
									
									<td ng-if="jobOrderDtl.transactionType==2  && jobOrderDtl.status==1"><selectivity list="customerSellList"
											property="jobOrderDtl.buySellParty" id="buySellPartys{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" ></selectivity></td>	
									
									<td ng-if="jobOrderDtl.transactionType==1  && jobOrderDtl.status!=1"><selectivity list="customerBuyList"
											property="jobOrderDtl.buySellParty" id="buySellPartys{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>
									
									<td ng-if="jobOrderDtl.transactionType==2  && jobOrderDtl.status!=1"><selectivity list="customerSellList"
											property="jobOrderDtl.buySellParty" id="buySellPartys{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>
									
									<td ng-if="jobOrderDtl.status==1"><selectivity list="jobDetailStatusList"
											property="jobOrderDtl.status" id="status{{trIndex}}"
											ng-model="jobOrderDtl.status" name="status{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(status)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
											<td ng-if="jobOrderDtl.status!=1"><selectivity list="jobDetailStatusList"
											property="jobOrderDtl.status" id="status{{trIndex}}"
											ng-model="jobOrderDtl.status" name="status{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(status)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
								</tr>

							</tbody>
						</table>
						<div ng-if="Add">
						
						<div class="padding-right-5">
							<div class="col-md-4">
								<button ng-click="addRow()" class="btn btn-sm btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button>
								<button ng-click="removeRow()" class="btn btn-sm btn-danger"
									type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div>
						</div>
						</div>
					</div>
					</div>
					
					
					<div ng-if="disable">
					<div class=" form-controller table-responsive clear ">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan="1" class="width_1"></th>
									<!-- <th colspan="1" class="width_3 text-center">S.No</th> -->
									<th colspan="1" class="width_13 text-center">Charge Heads<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_9 text-center">Units<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_6 text-center">Transaction
										type<span style="color: red;">*</span>
									</th>
									<th colspan="1" class="width_7 text-center">Quantity<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_8 text-center">Rate<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_9 text-center">Currency<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_8 text-center">Ex-Rate<span
										style="color: red;">*</span></th>
									<th colspan="1" class="width_10 text-center">Amount<span
										style="color: red;">*</span></th>
								<!-- 	<th colspan="1" class="width_9 text-center">Payment Mode<span
										style="color: red;">*</span></th> -->
									<th colspan="1" class="width_9 text-center">Buy/Sell
										Party<span style="color: red;">*</span>
									</th>
									<th colspan="1" class="width_12 text-center">Status<span
										style="color: red;">*</span></th>
								</tr>
							</thead>
							<tbody ng-repeat="(trIndex, jobOrderDtl) in joborder.joborderDtl"
								class="bookingDtlCls" ng-controller="jobtableCtrl">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select" disabled="true"><i></i></label></td>
									<!-- <td class="text-center">{{trIndex+1}}</td> -->
									<td><selectivity list="chargeHeadList"
											property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}"
											ng-model="jobOrderDtl.chargeHead"
											name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}"
											form-name="jobOrderDtlForm" disabled="true"></selectivity></td>

									<td><selectivity list="UnitList"
										property="jobOrderDtl.unit" id="unit{{trIndex}}"
											ng-model="jobOrderDtl.unit" name="unit{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>
											

									 <td><selectivity list="transactionTypeList"
											property="jobOrderDtl.transactionType" id="transactionTypes{{trIndex}}"
											ng-model="jobOrderDtl.transactionType"
											name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td> 

									<td><input type="text" id="quantity{{trIndex}}"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}" 
										validation="required|integer" form-name='jobOrderForm'
										maxlength="9" ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}" disabled="true">
									</td>

									<td><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}" disabled="true">
									</td>

									<td><selectivity list="currencylist"
											property="jobOrderDtl.currency" id="currency{{trIndex}}"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>

									<td><input type="text"
										class="form-control input-sm text-right"
										id="exRate{{trIndex}}" ng-model="jobOrderDtl.exRate" 
										name="exRate{{trIndex}}" validation="required|integer"
										form-name='jobOrderForm' 
										ng-blur="CheckExRateDtl(jobOrderDtl.currency,trIndex)"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}" disabled="true">
									</td>
									

									<td><input type="text"
										class="form-control input-sm text-right" id="amount{{trIndex}}"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										ng-change="ratevalues1()" validation="required|integer" 
										form-name='jobOrderForm'
										
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}" disabled="true">
									</td>

						<!-- 			<td><selectivity list="PaymentMethodList"
											property="jobOrderDtl.paymentMode"
											id="paymentModes{{trIndex}}"
											ng-model="jobOrderDtl.paymentMode"
											name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td> -->

									<td ng-if="jobOrderDtl.transactionType==1"><selectivity list="customerBuyList"
											property="jobOrderDtl.buySellParty" id="buySellPartys{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>
									
									<td ng-if="jobOrderDtl.transactionType==2"><selectivity list="customerSellList"
											property="jobOrderDtl.buySellParty" id="buySellPartys{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>		

									<td><selectivity list="jobDetailStatusList"
											property="jobOrderDtl.status" id="status{{trIndex}}"
											ng-model="jobOrderDtl.status" name="status{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(status)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
								</tr>

							</tbody>
						</table>
						<div ng-if="Add">
						
						<div class="padding-right-5">
							<div class="col-md-4">
								<button ng-click="addRow()" class="btn btn-sm btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button>
								<button ng-click="removeRow()" class="btn btn-sm btn-danger"
									type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div>
						</div>
						</div>
					</div>
					</div>



                          <div class="col-sm-12 ">
							<fieldset>
                             <div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Selling Amount</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.sell1" id="sell1" name="sell1"
												readonly>
									</div>

								</div>
								<div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Buying Amount</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.buy1" id="buy1" name="buy1" readonly>
									</div>
								</div>

								<div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Total Profit</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.total" id="total" name="amount"
												readonly>
									</div>
								</div>
								
								
							</fieldset>
						</div>



					<!-- <div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="content">
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12 text-space">


											<label class="col-md-6 control-label">Selling Amount</label>


											<input type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.sell1" id="sell1" name="sell1"
												readonly>




										</div>
										<br>
										<div class="col-md-12 text-space">


											<label class="col-md-6 control-label">Buying Amount</label> <input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.buy1" id="buy1" name="buy1" readonly>

										</div>
										<br>


										<div class="col-md-12">


											<label class="col-md-6 control-label">Total Profit</label> <input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.total" id="total" name="amount"
												readonly>




										</div>
									</div>
								</div>
							</div>
						</div>
					</div> -->
					<br>
					<br>
					<br>
					<!-- <div class="table-responsive clear" ng-if="edit">
						<header id="btntoggle" data-role="heading"
							style="margin-bottom: 0px !important; color: black"
							class="btn btn-default col-sm-12 col-md-12 col-lg-12"
							data-ng-click="isCollapsed = !isCollapsed">
							<div class="row">
								<a style="color: black;">Invoice Details </a>
							</div>
						</header>
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>

									<th class="width_10 text-center">Sales Invoice</th>
									<th class="width_10 text-center">Sales Date</th>
									<th class="width_10 text-center">Purchase Invoice</th>
									<th class="width_10 text-center">Purchase Date</th>
								</tr>
							</thead>

							<tbody>
								<tr>

									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<input type="text" id="salesInvoice"
													class="form-control input-sm text-Left"
													ng-model="joborder.salesInvoice" name="salesInvoice"
													readonly>
											</div>
										</div>
									</td>

									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker data-ng-model="joborder.salesDate"
													name="salesInvoiceDate" form-name="jobOrderForm" readonly />
											</div>
										</div>
									</td>
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">
												<input type="text" id="purchaseInvoice"
													class="form-control input-sm text-Left"
													ng-model="joborder.purchaseInvoice" name="purchaseInvoice"
													readonly>

											</div>
										</div>
									</td>
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker data-ng-model="joborder.purchaseDate"
													name="purchaseInvoiceDate" form-name="jobOrderForm"
													readonly />
											</div>
										</div>
									</td>

								</tr>
							</tbody>

						</table>
					</div> -->
					<div ng-if="!trackDtl">
					<div class="table-responsive clear">
						<header id="btntoggle" data-role="heading"
							style="margin-bottom: 0px !important; color: black"
							class="btn btn-default col-sm-12 col-md-12 col-lg-12"
							data-ng-click="isCollapsed = !isCollapsed">
							<div class="row">
								<a style="color: black;">Job Tracking</a>
							</div>
						</header>
						
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>

									<th class="width_10 text-center">Pickup Date</th>
									<th class="width_10 text-center">Customs Completion Date</th>
									<th class="width_10 text-center">Carting Date</th>
									<th class="width_10 text-center">Created Date</th>
									<th class="width_10 text-center">ETA Destination Date</th>
									<th class="width_21 text-center">Remarks</th>
									
								</tr>
								
							</thead>

							<tbody>
								<tr>

									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker ng-model="joborder.pickupDate"
													name="PickUpDate" form-name="jobOrderForm" />

											</div>
										</div>
									</td>
                                   <td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker
													data-ng-model="joborder.customsCompletionsDate"
													name="CustomsCompletionsDate" form-name="jobOrderForm" />
											</div>
										</div>
									</td>
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker data-ng-model="joborder.stuffingDate"
													name="StuffingDate" form-name="jobOrderForm" />
											</div>
										</div>
									</td>
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker data-ng-model="joborder.createdDt"
													name="createdDt" form-name="jobOrderForm" />
											</div>
										</div>
									</td>

									
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker
													data-ng-model="joborder.etaDestinationDate"
													name="ETADestinationDate" form-name="jobOrderForm" />
											</div>
										</div>
									</td>
									<td><div><textarea  type="text" class="form-control input-sm"
															name="remarks1{{trIndex1}}" id="remark1s{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3" maxlength="200"
															ng-model="joborder.remarks1">
															</textarea>
															<div class="row"ng-if="isEdit">
											
                                    <button type="button" class="btn btn-link" ng-click="remarks(row.jobNo) "style="color: green;font-size: 10px;text-align:justify;">Click here to view Previous remark history </button>
												
											
										</div>
															</div>
															</td>
									
									
								</tr>
								
							</tbody>
										
						</table>
						
												
											
						<!-- <td class="width_10">
										<div class="row"ng-if="isEdit">
											<div class="col-xs-12" style="margin-left:1427px">
                                    <button type="button" class="btn btn-link" ng-click="remarks(row.jobNo) "style="color: green;font-size: 15px;">Click here to view remarks history </button>
												
											</div>
										</div>
									</td>	 -->				
						
		
					</div>
					</div>
					
					
					<div ng-if="trackDtl">
					<div class="table-responsive clear">
						<header id="btntoggle" data-role="heading"
							style="margin-bottom: 0px !important; color: black"
							class="btn btn-default col-sm-12 col-md-12 col-lg-12"
							data-ng-click="isCollapsed = !isCollapsed">
							<div class="row">
								<a style="color: black;">Job Tracking</a>
							</div>
						</header>
						
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>

									<th class="width_10 text-center">Pickup Date</th>
									<th class="width_10 text-center">Customs Completion Date</th>
									<th class="width_10 text-center">Carting Date</th>
									<th class="width_10 text-center">Created Date</th>
									<th class="width_10 text-center">ETA Destination Date</th>
									<th class="width_21 text-center">Remarks</th>
									
								</tr>
								
							</thead>

							<tbody>
								<tr>

									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker ng-model="joborder.pickupDate"
													name="PickUpDate" form-name="jobOrderForm" disabled="true" />

											</div>
										</div>
									</td>
                                   <td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker
													data-ng-model="joborder.customsCompletionsDate"
													name="CustomsCompletionsDate" form-name="jobOrderForm" disabled="true" />
											</div>
										</div>
									</td>
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker data-ng-model="joborder.stuffingDate"
													name="StuffingDate" form-name="jobOrderForm" disabled="true" />
											</div>
										</div>
									</td>
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker data-ng-model="joborder.createdDt"
													name="createdDt" form-name="jobOrderForm" disabled="true" />
											</div>
										</div>
									</td>

									
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">

												<ng-bs3-datepicker
													data-ng-model="joborder.etaDestinationDate"
													name="ETADestinationDate" form-name="jobOrderForm" disabled="true" />
											</div>
										</div>
									</td>
									<td><div><textarea  type="text" class="form-control input-sm"
															name="remarks1{{trIndex1}}" id="remark1s{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3" maxlength="200"
															ng-model="joborder.remarks1" disabled="true">
															</textarea>
															<div class="row"ng-if="isEdit">
											
                                    <button type="button" class="btn btn-link" ng-click="remarks(row.jobNo) "style="color: green;font-size: 10px;text-align:justify;">Click here to view Previous remark history </button>
												
											
										</div>
															</div>
															</td>
									
									
								</tr>
								
							</tbody>
										
						</table>
						
												
											
						<!-- <td class="width_10">
										<div class="row"ng-if="isEdit">
											<div class="col-xs-12" style="margin-left:1427px">
                                    <button type="button" class="btn btn-link" ng-click="remarks(row.jobNo) "style="color: green;font-size: 15px;">Click here to view remarks history </button>
												
											</div>
										</div>
									</td>	 -->				
						
		
					</div>
					</div>
					<div ng-if="!trackDtl">
					<div class="table-responsive clear">
					<header id="btntoggle" data-role="heading"
						style="margin-bottom: 0px !important; color: black"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a style="color: black;">Cargo Details</a>
						</div>
					</header>
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan="1" class="width_1"></th>
									<!-- <th colspan="1" class="width_2 text-center">S.No</th> -->
									<th colspan="1" class="width_7 text-center">KG/QT<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_15 text-center">Commodity<span style="color: red;"></span>
									</th>
									<th colspan="1" class="width_7 text-center">LWH UOM<span
										style="color: red;"></span>
									</th>
									<th colspan="1" class="width_7 text-center">Length<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_7 text-center">Width<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_7 text-center">Height<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_7 text-center">No of Pieces<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_6 text-center">Net Weight<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_6 text-center">Gross Weight<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_8 text-center">Chargebale
										Weight<span style="color: red;"></span>
									</th>
									<th colspan="1" class="width_8 text-center">Rate/Charge<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_10 text-center">Amount<span
										style="color: red;"></span></th>
									<!-- <th colspan="1" class="width_12 text-center">Remarks<span
										style="color: red;"></span></th> -->

								</tr>
							</thead>
							<tbody
								ng-repeat="(trIndex1, jobOrderTrackingDtl) in joborder.joborderTrackingDtl"
								class="bookingDtlCls">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderTrackingDtl.select"><i></i></label></td>
									<!-- <td class="text-center">{{trIndex1+1}}</td> -->
									<td>		
									
										<input type="text" class="form-control input-sm"
										 name="commodity{{trIndex1}}"
										property="jobOrderTrackingDtl.commodity" id="commodity{{trIndex1}}" ng-model="jobOrderTrackingDtl.commodity"
										friendly-name="commodity" />								
										<!-- <selectivity list="commodityList"
										property="jobOrderTrackingDtl.commodity" id="commodity{{trIndex1}}"
										name="commodity{{trIndex1}}" ng-model="jobOrderTrackingDtl.commodity"
										object="commodity" friendly-name="{{ 'Row-' + (trIndex1+1) + '(Commodity)'}}"
										form-name='jobOrderForm'
										></selectivity> -->
										
									</td>

									<td><textarea  type="text" class="form-control input-sm"
															name="descriptionGoods{{trIndex1}}" id="descriptionGoods{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.descriptionGoods">
															</textarea></td>



									<td><selectivity list="uomList"
											property="jobOrderTrackingDtl.uom"
											ng-model="jobOrderTrackingDtl.uom" name="uom"></selectivity>
									</td>




									<td><input type="text"
										class="form-control input-sm text-right"
										id="length{{trIndex1}}" ng-model="jobOrderTrackingDtl.length"
										name="length{{trIndex1}}"></td>



									<td><input type="text"
										class="form-control input-sm text-right"
										id="width{{trIndex1}}" ng-model="jobOrderTrackingDtl.width"
										name="width{{trIndex1}}"></td>

									<td><input type="text"
										class="form-control input-sm text-right"
										id="height{{trIndex1}}" ng-model="jobOrderTrackingDtl.height"
										name="height{{trIndex1}}"></td>

									<td><input type="text"
										class="form-control input-sm text-right"
										id="noOfPcs{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.noOfPieces"
										name="noOfPcs{{trIndex1}}" ng-change="noOfPcs()"></td>

									<td><input type="number"
										class="form-control input-sm text-right"
										id="netWeight{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.netWeight"
										name="netWeight{{trIndex1}}" ng-change="noOfNet()"></td>

									<td><input type="number"
										class="form-control input-sm text-right"
										id="grossWeight{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.grossWeight"
										name="length{{trIndex1}}" ng-change="noOfGross()"></td>
									<td><input type="text"
										class="form-control input-sm text-right"
										id="chargeableWeight{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.chargeableWeight"
										name="chargeableWeight{{trIndex1}}" ng-change="cargoCal()"></td>
									<td><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.rate" name="rate{{trIndex1}}" ng-change="cargoCal()">
									</td>

									<td><input type="text"
										class="form-control input-sm text-right"
										id="amount{{trIndex1}}" ng-model="jobOrderTrackingDtl.amount"
										name="amount{{trIndex1}}" ></td>
									<!-- <td><textarea  type="text" class="form-control input-sm"
															name="remarks{{trIndex1}}" id="remarks{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.remarks">
															</textarea></td> -->
										
										
								</tr>

							</tbody>
						</table>
						<div ng-if="trackDtlAdd">
						<div class="padding-right-5">
							<div class="col-md-4">
								<button ng-click="addRowTracking()" class="btn btn-sm btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button>
								<button ng-click="removeRowTracking()"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div>
						</div>
						</div>
					</div>
					</div>
					
					<div ng-if="trackDtl">
					<div class="table-responsive clear">
					<header id="btntoggle" data-role="heading"
						style="margin-bottom: 0px !important; color: black"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a style="color: black;">Cargo Details</a>
						</div>
					</header>
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan="1" class="width_1"></th>
									<!-- <th colspan="1" class="width_2 text-center">S.No</th> -->
									<th colspan="1" class="width_7 text-center">KG/QT<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_15 text-center">Commodity<span style="color: red;"></span>
									</th>
									<th colspan="1" class="width_7 text-center">LWH UOM<span
										style="color: red;"></span>
									</th>
									<th colspan="1" class="width_7 text-center">Length<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_7 text-center">Width<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_7 text-center">Height<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_7 text-center">No of Pieces<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_6 text-center">Net Weight<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_6 text-center">Gross Weight<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_8 text-center">Chargebale
										Weight<span style="color: red;"></span>
									</th>
									<th colspan="1" class="width_8 text-center">Rate/Charge<span
										style="color: red;"></span></th>
									<th colspan="1" class="width_10 text-center">Amount<span
										style="color: red;"></span></th>
									<!-- <th colspan="1" class="width_12 text-center">Remarks<span
										style="color: red;"></span></th> -->

								</tr>
							</thead>
							<tbody
								ng-repeat="(trIndex1, jobOrderTrackingDtl) in joborder.joborderTrackingDtl"
								class="bookingDtlCls">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderTrackingDtl.select" disabled="true"><i></i></label></td>
									<!-- <td class="text-center">{{trIndex1+1}}</td> -->
									<td>		
									
										<input type="text" class="form-control input-sm"
										 name="commodity{{trIndex1}}"
										property="jobOrderTrackingDtl.commodity" id="commodity{{trIndex1}}" ng-model="jobOrderTrackingDtl.commodity"
										friendly-name="commodity" disabled="true" />								
										<!-- <selectivity list="commodityList"
										property="jobOrderTrackingDtl.commodity" id="commodity{{trIndex1}}"
										name="commodity{{trIndex1}}" ng-model="jobOrderTrackingDtl.commodity"
										object="commodity" friendly-name="{{ 'Row-' + (trIndex1+1) + '(Commodity)'}}"
										form-name='jobOrderForm'
										></selectivity> -->
										
									</td>

									<td><textarea  type="text" class="form-control input-sm"
															name="descriptionGoods{{trIndex1}}" id="descriptionGoods{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.descriptionGoods" disabled="true">
															</textarea></td>



									<td><selectivity list="uomList"
											property="jobOrderTrackingDtl.uom"
											ng-model="jobOrderTrackingDtl.uom" name="uom" disabled="true"></selectivity>
									</td>




									<td><input type="text"
										class="form-control input-sm text-right"
										id="length{{trIndex1}}" ng-model="jobOrderTrackingDtl.length"
										name="length{{trIndex1}}" disabled="true"></td>



									<td><input type="text"
										class="form-control input-sm text-right"
										id="width{{trIndex1}}" ng-model="jobOrderTrackingDtl.width"
										name="width{{trIndex1}}" disabled="true"></td>

									<td><input type="text"
										class="form-control input-sm text-right"
										id="height{{trIndex1}}" ng-model="jobOrderTrackingDtl.height"
										name="height{{trIndex1}}" disabled="true"></td>

									<td><input type="text"
										class="form-control input-sm text-right"
										id="noOfPcs{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.noOfPieces"
										name="noOfPcs{{trIndex1}}" ng-change="noOfPcs()" disabled="true"></td>

									<td><input type="number"
										class="form-control input-sm text-right"
										id="netWeight{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.netWeight"
										name="netWeight{{trIndex1}}" ng-change="noOfNet()" disabled="true"></td>

									<td><input type="number"
										class="form-control input-sm text-right"
										id="grossWeight{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.grossWeight"
										name="length{{trIndex1}}" ng-change="noOfGross()" disabled="true"></td>
									<td><input type="text"
										class="form-control input-sm text-right"
										id="chargeableWeight{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.chargeableWeight"
										name="chargeableWeight{{trIndex1}}" ng-change="cargoCal()" disabled="true"></td>
									<td><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex1}}"
										ng-model="jobOrderTrackingDtl.rate" name="rate{{trIndex1}}" ng-change="cargoCal()" disabled="true">
									</td>

									<td><input type="text"
										class="form-control input-sm text-right"
										id="amount{{trIndex1}}" ng-model="jobOrderTrackingDtl.amount"
										name="amount{{trIndex1}}" disabled="true"></td>
									<!-- <td><textarea  type="text" class="form-control input-sm"
															name="remarks{{trIndex1}}" id="remarks{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.remarks">
															</textarea></td> -->
										
										
								</tr>

							</tbody>
						</table>
						<div ng-if="trackDtlAdd">
						<div class="padding-right-5">
							<div class="col-md-4">
								<button ng-click="addRowTracking()" class="btn btn-sm btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button>
								<button ng-click="removeRowTracking()"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div>
						</div>
						</div>
					</div>
					</div>
                                  
                                  <div class="col-sm-12 ">
							<fieldset>
                             <div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Total No of Pieces <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.joborderTracking.totalPcs" id="total" name="amount"
												readonly>
									</div>

								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Total Net Weight
										<span style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.joborderTracking.totalNetWeight" id="total" name="amount"
												readonly>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Total Gross Weight
										 <span style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.joborderTracking.totalGrosssWeight" id="total" name="amount"
												readonly>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Total Amount <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.joborderTracking.totalAmount" id="total" name="amount"
												readonly>
									</div>
								</div>
							</fieldset>
						</div>
                                  
                                  
                                  
                                  
                                  
                                  
                                   <!-- <div class="col-md-12">
											<label class="col-md-6 control-label">Total No of Pieces</label> <input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.totPieces" id="total" name="amount"
												readonly>
										</div>
										 <div class="col-md-12">
											<label class="col-md-6 control-label">Total Net Weight</label> <input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.totNetWeight" id="total" name="amount"
												readonly>
										</div>
										<div class="col-md-12">
											<label class="col-md-6 control-label">Total Gross Weight</label> <input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.totGrossWeight" id="total" name="amount"
												readonly>
										</div>
										<div class="col-md-12">
											<label class="col-md-6 control-label">Total Amount</label> <input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.totAmount" id="total" name="amount"
												readonly>
										</div> -->


					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="content">
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" ng-if="!isEdit" type="button"
												ng-click="saveJob(jobOrderForm)">
												<i class="fa fa-save"></i> Save
											</button>
											<security:authorize access="hasRole('F5568_${print}')">
                                            <button type="button" class="btn btn-success" ng-if="isEdit"
												ng-click="print(joborder.jobId)">
												<i class="fa fa-print"></i> Print - CPA
											</button>
											</security:authorize>
											<security:authorize access="hasRole('F5568_${print}')">
											<button type="button" class="btn btn-success" ng-if="isEdit"
												ng-click="printRoutingOrder1()">
												<i class="fa fa-print"></i> Print - Routing Order
											</button>
											</security:authorize>
											<security:authorize access="hasRole('F5568_${print}')">
											<button class="btn btn-success" ng-if="isEdit"
												ng-click="jobSheet(joborder.jobId)">
												<i class="fa fa-print"></i> Print - Job Sheet
											</button>
											</security:authorize>
											<security:authorize access="hasRole('F5568_${print}')">
											<button type="button" class="btn btn-success" ng-if="isEdit"
												ng-click="printPrealertAir(joborder.jobId)">
												<i class="fa fa-print"></i> Print - Pre-Alert
											</button>
											</security:authorize>
											<!-- <div ng-if="!disable"> -->
											<button type="button" class="btn btn-success"
												ng-click="updateJob(jobOrderForm)" ng-if="isEdit" type="button">
												<i class="fa fa-save"></i> Update
											</button>
											<!-- </div> -->

											<button type="button" class="btn btn-info" type="reset" ng-click="reset()">
												<i class="fa fa-undo"></i> Reset
											</button>


											<button  type="button"class="btn btn-danger" type="reset"
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i> Cancel
											</button>



										</div>
									</div>
								</div>
							</div>
						</div>
					</div>



					<div id="printableContent"
						style="margin-bottom: 10px; display: none;">

						<div style="width:100%;float: left;">
							<div style="width:30%;float: left;">
								<img src="/img/MBKHelpVideos/logo.jpg"
									style="padding: 10 0 0 10; height: 60px;">
							</div>
							<div style="width:70%;float: left;margin-top: 2%;">
								<span style="text-align: right; text-transform: uppercase;"><b>MBK
										GLOBAL LOGISTICS PVT LTD</b></span>
							</div>
						</div>

						<div style="width: 100%; float: left; text-align: center;margin: 1% 0% 1% 0%;">
							<span><b>Routing Order</b></span>
						</div>
						<div style="width: 100%;padding: 0% 1% 0% 1%;">
						<table width="100%" border="0"
							style="float: left; padding-top: 12px; padding-bottom: 15px;">
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>SHIPPER
										NAME</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtShpprName}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>SHIPPER
										ADDRESS</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;"><br>{{prtShpprAddress}} <br></td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>CONSIGNEE
										NAME</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtConsignName}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>PORT
										OF LOADING</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtPrtOfLoading}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>PORT
										OF DISCHARGE</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtPrtOfDischrg}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>FINAL
										PORT OF DISCHARG</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtPrtOfDischrg}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>NO. OF
										PIECES</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtTotlPices}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>NET
										WEIGHT</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtTotlNetWt}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>GROSS
										WEIGHT</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtTotlGrsWt}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>COMMODITY</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtcommdty}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 10px;padding: 0px 0px 0px 5px;"><b>TERMS</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtTems}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>CARGO
										STATUS</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;"></td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>BOOKING
										DETAILS</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;"></td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>REMARKS</b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;">{{prtremarks}}</td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12px;padding: 0px 0px 0px 5px;"><b>MBL
										INSTRUCTIONS</b></td>
								<td style="font-size: 12px;"></td>
							</tr>
							<tr>
								<td class="width_40" style="font-size: 12pxpadding: 0px 0px 0px 5px;;"><b>HBL
										INSTRUCTIONS </b></td>
								<td style="font-size: 12px;padding: 0px 0px 0px 5px;"></td>
							</tr>

						</table>
						</div>
					</div>



				</form>
			</div>
		</div>
	</div>
</div>