
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

input[type=number]::-webkit-inner-spin-button, 
input[type=number]::-webkit-outer-spin-button { 
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    margin: 0; 
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
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<security:authentication var="user" property="principal" />
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div style="width: 30%;position: absolute;margin-top: -33px;margin-left: 78%;" ng-if="edit">
		<!-- <label style="color:#e25d5d;float: left;">Quick Links &nbsp;&nbsp; </label>
		  <select ng-change="quickLinkMethd(joborder.jobId,qukLinkVal)" ng-init="qukLinkVal='Select'" ng-model="qukLinkVal">
		 <option value="Select">Select</option>
		  <option value="HBL">HBL</option>
		  <option value="MBL">MBL</option>
		  <option value="Delivery Order">Delivery Order</option>
		  <option value="Sales Invoice">Sales Invoice</option>
		  <option value="Purchase Invoice">Purchase Invoice</option>
		</select> -->
		<!-- <selectivity style="float: left;" list="categoryList" ng-init="category='Select'" ng-model="select.monItem"
		 property="category" 
		name="Category" friendly-name="Category"></selectivity> -->
		</div>
		<div>
			<input type="hidden" value="${form_code}" id="form_code_id">
			<input type="hidden" value="${user.userId}" id="tempidww">	
			<div class="panel-body">
				<form name="jobOrderForm" class="form-horizontal" novalidate>
					<div class="row book-widget-row">
						<div class="form-group col-md-12 col-lg-12" ng-if="edit"
							align="center">
							<label class="col-md-5 control-label" style="padding-top: 0px;">Job
								No <span style="color: red">*</span>
							</label>
							<div class="col-md-7" align="left">
								<label>{{joborder.jobNo}}</label>
							</div>
						</div>
					</div>
					<br> <br>
					<div ng-if="!disable">
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
							<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="col-md-5 control-label">Mode 
										<span style="color: red">*</span>
									</label>
									<div class="col-md-7" ng-if="!edit">

										<selectivity list="modeList" property="joborder.mode"
											id="mode" name="mode" ng-model="joborder.mode" object="mode"
											friendly-name="mode" validation="required"
											form-name="jobOrderForm" ></selectivity>

									</div>
									<div class="col-md-7" ng-if="edit">

										<selectivity list="modeList" property="joborder.mode"
											id="mode" name="mode" ng-model="joborder.mode" object="mode"
											friendly-name="mode" validation="required"
											form-name="jobOrderForm"  disabled=true></selectivity>

									</div>
								</div>
                               <div class="form-group col-md-3 col-lg-3"ng-if="!edit">
									<label class="col-md-5 control-label"> Booking No <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="quotationList"
											ng-model="joborder.quotationNo"
											property="joborder.quotationNo" class="quoLiCls"
											name="quotationNo" friendly-name="quotationNo"
											validation="required" form-name="jobOrderForm"></selectivity>

									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3"ng-if="edit">
								<label class="col-md-5 control-label view-label">Booking No</label> 
								<div class="col-md-7"> 
								<label class="col-md-7 control-label view-content"> <span class="tool-tip-span font-blue"> {{joborder.quotationnum}}</span></a></label> 
								</div>
								</div>
								
							   <div class="form-group col-md-3 col-lg-3">
								<label class="col-md-5 control-label view-label">Quotation No</label> 
								<div class="col-md-7"> 
							
										<selectivity list="quotationnoList" ng-model="joborder.quoteNo" 
											 friendly-name="quoteNo"   disabled="true"
											property="joborder.quoteNo" id="quoteNo" name="quoteNo" 
											form-name="jobOrderForm"></selectivity> 
						     	</div>
								</div>
							
								
								

								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Job
										Date <span style="color: red;">*</span>
									</label>
									
									
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.jobDate"
											name="jobDate" form-name="jobOrderForm"
											data-ng-change="checkDatesCL(joborder.jobDate)"
											friendly-name="Job Date" validation="required" />
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
										<selectivity list="customerDropList" ng-model="joborder.customer"
											property="joborder.customer" name="customer" id="customer"
											validation="required" friendly-name="Customer"
											form-name="jobOrderForm" ></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3" ng-if="joborder.mode==1">
									<label class="col-md-5 control-label"> Multi BCG 
									</label>
									<div class="col-md-7">
										<input
									type="checkbox" 
									data-ng-model="joborder.multi" />
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3" ng-if="joborder.mode==5">
									<label class="col-md-5 control-label"> MBL No
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm "
											ng-model="joborder.mblNo" name="mblNo"
											form-name='jobOrderForm' friendly-name="mblNo"
											>
									</div>
								</div>
                  <!-- <div class="form-group col-md-3 col-lg-3">
									Multi BCG<label class="i-checks m-b-none checkbox">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="checkbox" 
									data-ng-model="joborder.multi" /><i></i>
								</label>
								</div> -->
								<div class="form-group col-md-3 col-lg-3" >
									<label class="col-md-5 control-label"> Shipper <span ng-if="joborder.multi==false"
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="shipperDropList" ng-model="joborder.shipper"
											property="joborder.shipper" name="shipper"
											friendly-name="Shipper"
											form-name="jobOrderForm" ></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Add Shipper 
									</label>
									<div class="col-md-7">
										<input
									type="checkbox" 
									data-ng-model="joborder.addShipper" />
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Add Consignee 
									</label>
									<div class="col-md-7">
										<input
									type="checkbox" 
									data-ng-model="joborder.addConsignee" />
									</div>
								</div>
								<!-- <div class="form-group col-md-3 col-lg-3" ng-if="joborder.multi==true">
									<label class="col-md-5 control-label"> Shipper 
									</label>
									<div class="col-md-7">
										<selectivity list="shipperDropList" ng-model="joborder.shipper"
											property="joborder.shipper" name="shipper"
											friendly-name="Shipper"
											form-name="jobOrderForm" validation="required"></selectivity>
									</div>
								</div> -->

								<div class="form-group col-md-3 col-lg-3" >
									<label class="col-md-5 control-label"> Consignee <span ng-if="joborder.multi==false" style="color:red;" >*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="consigneeDropList" property="joborder.consignee"
											ng-model="joborder.consignee" name="consignee"
											 friendly-name="Consignee"
											form-name="jobOrderForm"  validation="required"></selectivity>
									</div>
								</div>
								<!-- <div class="form-group col-md-3 col-lg-3" ng-if="joborder.multi==true">
									<label class="col-md-5 control-label"> Consignee 
									</label>
									<div class="col-md-7">
										<selectivity list="consigneeDropList" property="joborder.consignee"
											ng-model="joborder.consignee" name="consignee"
											 friendly-name="Consignee"
											form-name="jobOrderForm"  validation="required"></selectivity>
									</div>
								</div> -->
								

								



							</fieldset>
						</div>
					</div>

					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Origin <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.origin"
											ng-model="joborder.origin" name="origin"
											validation="required" friendly-name="Origin"
											form-name="jobOrderForm" ></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> POL<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aol"
											ng-model="joborder.aol" name="aol" validation="required"
											friendly-name="Aol" form-name="jobOrderForm" ></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> POD <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aod"
											ng-model="joborder.aod" name="aod" validation="required"
											friendly-name="AOD" form-name="jobOrderForm" ></selectivity>
									</div>
								</div>

								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Destination<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.destination"
											ng-model="joborder.destination" name="destination"
											validation="required" friendly-name="Destination"
											form-name="jobOrderForm" ></selectivity>
									</div>
								</div>
								
								
								
								

							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Service <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7" ng-if="!edit">
										<selectivity list="servicePartnerTypelist"
											ng-model="joborder.service" property="joborder.service"
											name="service" validation="required" friendly-name=SERVICE
											form-name="jobOrderForm" ></selectivity>
									</div>
									<div class="col-md-7" ng-if="edit">
										<selectivity list="servicePartnerTypelist"
											ng-model="joborder.service" property="joborder.service"
											name="service" validation="required" friendly-name=SERVICE
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Commodity<span
										style="color: red;"></span>
									</label>
									 <div class="col-md-7">
										<!--<input type="text" class="form-control input-sm"
											ng-model="joborder.commodity" name="commodity"
											form-name='jobOrderForm' friendly-name="commodity" -->
											
									<div class="col-md-15 "
										class="selectivity-input example-input selectivity-slot voyage_sel">
									<select id="commodityL" multiple="multiple" name="commodityL"
									friendly-name="commodityL"  form-name="jobOrderForm"
										ng-model="joborder.commodityL" validation="required"
										ng-options="option.text for option in commodityList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in commodityList" 
											value="{{getOptionId(option)}}"
											data-ng-bind-template="{{option.commodityL}}"></option>
									</select>										
										 
									</div>	
								<!-- <selectivity list="commodityList"
										property="joborder.commodity" id="commodity"
										name="commodity" ng-model="joborder.commodity"
										object="commodity" friendly-name="Commodity"
										form-name="jobOrderForm"
										></selectivity> -->
									</div>
								</div>
								
								
								<!-- <div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Job Status 
									</label>
									<div class="col-md-7">
										<selectivity list="jobStatusList"
											property="joborder.jobStatus" ng-model="joborder.jobStatus"
											name="jobStatus" 
											friendly-name="job Status" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
									
								</div>
								 -->
								
								<!-- <div ng-if="user.userId=='A0001'" || ng-if="user.userId=='E0001'"> -->
								
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Job Status 
									</label>
									<div class="col-md-7">
										<selectivity list="jobStatusList"
											property="joborder.jobStatus" ng-model="joborder.jobStatus"
											name="jobStatus" 
											friendly-name="job Status" form-name="jobOrderForm" ></selectivity>
									</div>
									
								</div>
								
								<!-- </div> -->

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Currency <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="currencylist" property="joborder.currency"
											ng-model="joborder.currency" name="currency"
											validation="required" friendly-name="Currency"
											form-name="jobOrderForm" ></selectivity>
									</div>
								</div>
								



							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Customs Broker<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerDropList"
											property="joborder.customsBroker"
											ng-model="joborder.customsBroker" name="customsBroker"
											validation="required" friendly-name="Customs Broker"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Type <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="salesTypeList"
											property="joborder.salesType" ng-model="joborder.salesType"
											name="salesType" validation="required"
											friendly-name="Sales Type" form-name="jobOrderForm"
											></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Person <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="employeeList"
											property="joborder.salesPerson"
											ng-model="joborder.salesPerson" name="salesPerson"
											validation="required" friendly-name="Sales Person"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Nominated By<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="nominatedDropList"
											property="joborder.nominatedBy"
											ng-model="joborder.nominatedBy" name="nominatedBy"
											validation="required" friendly-name="Nominated By"
											form-name="jobOrderForm" ></selectivity>
									</div>
								</div>
								

							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Carrier<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
									<selectivity list="carrierList" ng-model="joborder.carrier"
										 property="joborder.carrier"
										id="carrier" 
										friendly-name="Carrier"
										form-name="jobOrderForm"></selectivity>
									
									
<!-- 										<input type="text" class="form-control input-sm "
											ng-model="joborder.carrier" name="carrier"
											form-name='jobOrderForm' friendly-name="Carrier"
											>
 -->									</div>
								</div>
<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Term <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="TermList" property="joborder.term"
											ng-model="joborder.term" name="term" validation="required"
											friendly-name="Term" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Vessel/Voyage<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="joborder.vessel"
											 friendly-name="vessel"
											property="joborder.vessel" id="vessel" name="vessel" 
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Ex-Rate 
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.exRate" name="exRate" ng-blur="checkExRate()"
											 form-name='jobOrderForm'
											friendly-name="Ex Rate">
									</div>
								</div>
								


							</fieldset>
						</div>
					</div>
                  <div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
<div class="form-group col-md-3 col-lg-3" >
									<label class="col-md-5 control-label"> Vendor</label>
									<div class="col-md-7">
										<selectivity list="vendorDropList" property="joborder.vendor"
											ng-model="joborder.vendor" name="vendor"
											validation="required" friendly-name="Vendor"
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
											ng-model="joborder.trackship1" name="trackship1"
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
											ng-model="joborder.trackship2" name="trackship2"
											form-name='jobOrderForm' friendly-name="trackship2"
											>
									</div>
								</div>
								
									<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Branch<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7" ng-if="!edit">
										<selectivity list="branchList" ng-model="joborder.branch"
											property="joborder.branch" name="branch"
											validation="required" friendly-name=BRANCH
											form-name="jobOrderForm" ></selectivity>
											
											
									</div>
									
									<div class="col-md-7"  ng-if="edit">
										<selectivity list="branchList" ng-model="joborder.branch"
											property="joborder.branch" name="branch"
											validation="required" friendly-name=BRANCH
											form-name="jobOrderForm" disabled="true" ></selectivity>
											
											
								</div>
									</div>
									<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Payer<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
									<selectivity list="mloList" ng-model="joborder.payerName"
										 property="joborder.payerName"
										id="payerName" 
										friendly-name="PayerName"
										form-name="jobOrderForm"></selectivity>
									
									
<!-- 										<input type="text" class="form-control input-sm "
											ng-model="joborder.carrier" name="carrier"
											form-name='jobOrderForm' friendly-name="Carrier"
											>
 -->									</div>
								</div>
							</fieldset>
						</div>
					</div>
					</div>
			
					<div ng-if="disable">
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
                               <div class="form-group col-md-3 col-lg-3"ng-if="!edit">
									<label class="col-md-5 control-label"> Quotation <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="quotationList"
											ng-model="joborder.quotationNo"
											property="joborder.quotationNo" class="quoLiCls"
											name="quotationNo" friendly-name="quotationNo"
											validation="required" form-name="jobOrderForm" disabled="true"></selectivity>

									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3"ng-if="edit">
								<label class="col-md-5 control-label view-label">Quotation: </label> 
								<div class="col-md-7"> 
								<label class="col-md-7 control-label view-content"><a data-ng-click="viewQuotation(joborder.quotationNo)">  <span class="tool-tip-span font-blue"> {{joborder.quotationnum}}</span></a></label> 
								</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="col-md-5 control-label">Mode 
										<span style="color: red">*</span>
									</label>
									<div class="col-md-7">

										<selectivity list="modeList" property="joborder.mode"
											id="mode" name="mode" ng-model="joborder.mode" object="mode"
											friendly-name="mode" validation="required"
											form-name="jobOrderForm"  disabled="true"></selectivity>

									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Job
										Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.jobDate"
											name="jobDate" form-name="jobOrderForm"
											data-ng-change="checkDatesCL(joborder.jobDate)"
											friendly-name="Job Date" validation="required" disabled="true" />
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Branch2 <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="branchList" ng-model="joborder.branch"
											property="joborder.branch" name="branch"
											validation="required" friendly-name=BRANCH
											form-name="jobOrderForm"  disabled="true"></selectivity>
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
										<selectivity list="customerDropList" ng-model="joborder.customer"
											property="joborder.customer" name="customer" id="customer"
											validation="required" friendly-name="Customer"
											form-name="jobOrderForm" disabled="true" ></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Shipper <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="shipperDropList" ng-model="joborder.shipper"
											property="joborder.shipper" name="shipper"
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
											ng-model="joborder.term" name="term" validation="required"
											friendly-name="Term" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Destination<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.destination"
											ng-model="joborder.destination" name="destination"
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
									<label class="col-md-5 control-label"> POL<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aol"
											ng-model="joborder.aol" name="aol" validation="required"
											friendly-name="Aol" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> POD <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aod"
											ng-model="joborder.aod" name="aod" validation="required"
											friendly-name="AOD" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Origin <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.origin"
											ng-model="joborder.origin" name="origin"
											validation="required" friendly-name="Origin"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Service <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="servicePartnerTypelist"
											ng-model="joborder.service" property="joborder.service"
											name="service" validation="required" friendly-name=SERVICE
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
									<label class="col-md-5 control-label"> Commodity<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											ng-model="joborder.commodity" name="commodity"
											form-name='jobOrderForm' friendly-name="commodity" disabled="true"
											>
										
										<!-- <selectivity list="commodityList"
										property="joborder.commodity" id="commodity"
										name="commodity" ng-model="joborder.commodity"
										object="commodity" friendly-name="Commodity"
										validation="required" form-name="jobOrderForm"
										></selectivity> -->
									</div>
								</div>

								<!-- <div ng-if="user.userId!='A0001'" || ng-if="user.userId!='E0001'">
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Job Status 
									</label>
									<div class="col-md-7">
										<selectivity list="jobStatusList"
											property="joborder.jobStatus" ng-model="joborder.jobStatus"
											name="jobStatus" 
											friendly-name="job Status" form-name="jobOrderForm" ></selectivity>
									</div>
									
								</div>
								</div> -->
								
								<div ng-if="unique">
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Job Status 
									</label>
									<div class="col-md-7">
										<selectivity list="jobStatusList"
											property="joborder.jobStatus" ng-model="joborder.jobStatus"
											name="jobStatus" 
											friendly-name="job Status" form-name="jobOrderForm"></selectivity>
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
											name="jobStatus" 
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
											ng-model="joborder.currency" name="currency"
											validation="required" friendly-name="Currency"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Customs Broker<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerDropList"
											property="joborder.customsBroker"
											ng-model="joborder.customsBroker" name="customsBroker"
											validation="required" friendly-name="Customs Broker"
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
									<label class="col-md-5 control-label"> Sales Type <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="salesTypeList"
											property="joborder.salesType" ng-model="joborder.salesType"
											name="salesType" validation="required"
											friendly-name="Sales Type" form-name="jobOrderForm" disabled="true"
											></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Person <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="employeeList"
											property="joborder.salesPerson"
											ng-model="joborder.salesPerson" name="salesPerson"
											validation="required" friendly-name="Sales Person"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Nominated By<span
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
											ng-model="joborder.consignee" name="consignee"
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
										<input type="text" class="form-control input-sm "
											ng-model="joborder.carrier" name="carrier"
											form-name='jobOrderForm' friendly-name="Carrier " disabled="true"
											>
									</div>
								</div>

								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Vessel/Voyage<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="joborder.vessel"
											 friendly-name="vessel"  disabled="true"
											property="joborder.vessel" id="vessel" name="vessel" 
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>



								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Ex-Rate <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.exRate" name="exRate" ng-blur="checkExRate()"
											validation="required|integer" form-name='jobOrderForm'
											friendly-name="Ex Rate" disabled="true">
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3" >
									<label class="col-md-5 control-label"> Vendor</label>
									<div class="col-md-7">
										<selectivity list="vendorDropList" property="joborder.vendor"
											ng-model="joborder.vendor" name="vendor"
											validation="required" friendly-name="Vendor"
											form-name="jobOrderForm"  disabled="true"></selectivity>
									</div>
								</div>


							</fieldset>
						</div>
					</div>
                  <div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>

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
											ng-model="joborder.trackship1" name="trackship1"
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
											ng-model="joborder.trackship2" name="trackship2"
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

					<div class="table-responsive clear" >
						<table class="table table-striped b-t b-light" >
							<thead >
								<tr ng-if = "specialEmployeeFlag">
									<th colspan=1 class="width_1"></th>
									<!-- <th colspan=1 class="width_3 text-center">S.No</th> -->
									<th colspan=1 class="width_20 text-center">Charge Heads<span
										style="color: red;">*</span></th>
										<br>
									<th colspan=1 class="width_12 text-center">Units<span
										style="color: red;">*</span></th>
										<th colspan=1 class="width_4 text-center">Container Type<span
										style="color: red;"></span></th>
									<th colspan=1 class="width_3 text-center">Transaction
										type<span style="color: red;">*</span>
									</th>
									<th colspan=1 class="width_5 text-center">Quantity<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_7 text-center">Rate<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_9 text-center">Currency<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_7 text-center">Ex-Rate<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Amount<span
										style="color: red;">*</span></th>
								<!-- 	<th colspan=1 class="width_9 text-center">Payment Mode<span
										style="color: red;">*</span></th> -->
									<th colspan=1 class="width_14 text-center">Buy/Sell Party<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_12 text-center">Status<span
										style="color: red;">*</span></th>
								</tr>
							</thead>
							<tbody ng-repeat="(trIndex, jobOrderDtl) in joborder.joborderDtl"
								ng-controller="jobtableCtrl" class="bookingDtlCls">
								<tr ng-if = "specialEmployeeFlag">
									<td ng-if="jobOrderDtl.status==1"><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select"><i></i></label></td>
											
											<td ng-if="jobOrderDtl.status!=1"><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select" disabled=ture><i></i></label></td>
											
									<!-- <td class="text-center">{{trIndex+1}}</td> -->
									<td class="" ng-if="jobOrderDtl.status==1"><selectivity list="chargeHeadList"
											property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}"
											ng-model="jobOrderDtl.chargeHead"
											name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}"
											form-name="jobOrderDtlForm" disabled=false></selectivity></td>
											
											<td class="" ng-if="jobOrderDtl.status!=1"><selectivity list="chargeHeadList"
											property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}"
											ng-model="jobOrderDtl.chargeHead"
											name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}"
											form-name="jobOrderDtlForm" disabled=true></selectivity></td>

									<td class="" ng-if="jobOrderDtl.status==1"><selectivity list="UnitList"
											property="jobOrderDtl.unit" id="unit"
											ng-model="jobOrderDtl.unit" name="unit{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td>
											
											<td class="" ng-if="jobOrderDtl.status!=1"><selectivity list="UnitList"
											property="jobOrderDtl.unit" id="unit"
											ng-model="jobOrderDtl.unit" name="unit{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
											
											<td class="" ng-if="jobOrderDtl.status==1">
											<selectivity list="conTypeList"
											property="jobOrderDtl.conType"   id="conType" validation="required"
											ng-model="jobOrderDtl.conType"    name="conType{{trIndex}}"
											name="conType{{trIndex1}}" disabled=false></selectivity>
											</td>
											
											<td class="" ng-if="jobOrderDtl.status!=1">
											<selectivity list="conTypeList"
											property="jobOrderDtl.conType"   id="conType" validation="required"
											ng-model="jobOrderDtl.conType"    name="conType{{trIndex}}"
											name="conType{{trIndex1}}" disabled=true></selectivity>
											</td>

									<td class="text-center" ng-if="jobOrderDtl.status==1"><selectivity
											list="transactionTypeList"
											property="jobOrderDtl.transactionType"
											id="transactionType{{trIndex}}"
											ng-model="jobOrderDtl.transactionType"
											name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td>
											
											<td class="text-center" ng-if="jobOrderDtl.status!=1"><selectivity
											list="transactionTypeList"
											property="jobOrderDtl.transactionType"
											id="transactionType{{trIndex}}"
											ng-model="jobOrderDtl.transactionType"
											name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>


									<td class="text-center" ng-if="jobOrderDtl.status==1"><input type="text"
										id="qty{{trIndex}}" class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}" placeholder="0"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="9" ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}"
										ng-change="ratevalues()" ></td>
										
										<td class="text-center" ng-if="jobOrderDtl.status!=1"><input type="text"
										id="qty{{trIndex}}" class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}" placeholder="0"
										validation="required" form-name='jobOrderForm'
										maxlength="9" ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}"
										ng-change="ratevalues()" disabled=true></td>

									<td class="text-center" ng-if="jobOrderDtl.status==1"><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="10"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}"
										ng-change="ratevalues()"></td>
										<td class="text-center" ng-if="jobOrderDtl.status!=1"><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="10"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}"
										ng-change="ratevalues()" disabled=true></td>
									
									<td class="" ng-if="jobOrderDtl.status==1"><selectivity list="currencylist"
											property="jobOrderDtl.currency" id="currency{{trIndex}}"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td>
									<td class="" ng-if="jobOrderDtl.status!=1"><selectivity list="currencylist"
											property="jobOrderDtl.currency" id="currency{{trIndex}}"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>

									<td class="text-center" ng-if="jobOrderDtl.status==1"><input type="text"
										class="form-control input-sm text-right"
										id="exRate{{trIndex}}" ng-model="jobOrderDtl.exRate" 
										name="exRate{{trIndex}}" validation="required|integer"
										form-name='jobOrderForm' ng-blur="CheckExRateDtl(jobOrderDtl.currency,trIndex)"
										maxlength="9"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}" >
									</td>
									<td class="text-center" ng-if="jobOrderDtl.status!=1"><input type="text"
										class="form-control input-sm text-right"
										id="exRate{{trIndex}}" ng-model="jobOrderDtl.exRate" 
										name="exRate{{trIndex}}" validation="required|integer"
										form-name='jobOrderForm' ng-blur="CheckExRateDtl(jobOrderDtl.currency,trIndex)"
										maxlength="9"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}" disabled=true>
									</td>

									<td class="text-center" ng-if="jobOrderDtl.status==1"><input type="text"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="20" id="amount{{trIndex}}"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}"
										ng-change="ratevalues1()" readonly disabled=false></td>
										
										<td class="text-center" ng-if="jobOrderDtl.status!=1"><input type="text"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="20" id="amount{{trIndex}}"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}"
										ng-change="ratevalues1()" readonly disabled=true></td>

									<!-- <td class="text-center" ng-if="jobOrderDtl.status==1"><selectivity
											list="PaymentMethodList" property="jobOrderDtl.paymentMode"
											id="paymentMethod{{trIndex}}"
											ng-model="jobOrderDtl.paymentMode"
											name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td>
											<td class="text-center" ng-if="jobOrderDtl.status!=1"><selectivity
											list="PaymentMethodList" property="jobOrderDtl.paymentMode"
											id="paymentMethod{{trIndex}}"
											ng-model="jobOrderDtl.paymentMode"
											name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td> -->

											<td class="" ng-if="jobOrderDtl.transactionType==1 && jobOrderDtl.status==1"><selectivity list="customerBuyList"
											property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td>
											
											
											<td class="" ng-if="jobOrderDtl.transactionType==1 && jobOrderDtl.status!=1"><selectivity list="customerBuyList"
											property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
											
											<td class="" ng-if="jobOrderDtl.transactionType==2 && jobOrderDtl.status==1"><selectivity list="customerSellList"
											property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled=false></selectivity></td>
											<td class="" ng-if="jobOrderDtl.transactionType==2 && jobOrderDtl.status!=1"><selectivity list="customerSellList"
											property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
											
									<td class="text-center" ng-if="jobOrderDtl.status==1"><selectivity list="jobStatusListDtl"
											property="jobOrderDtl.status" id="status{{trIndex}}"
											ng-model="jobOrderDtl.status" name="status{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(status)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
											<td class="text-center" ng-if="jobOrderDtl.status!=1"><selectivity list="jobStatusListDtl"
											property="jobOrderDtl.status" id="status{{trIndex}}"
											ng-model="jobOrderDtl.status" name="status{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(status)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
								</tr>

							</tbody>
						</table>
						<div ng-if="Add && specialEmployeeFlag">
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
					<div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_1"></th>
									<!-- <th colspan=1 class="width_3 text-center">S.No</th> -->
									<th colspan=1 class="width_20 text-center">Charge Heads<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_12 text-center">Units<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center">Transaction
										type<span style="color: red;">*</span>
									</th>
									<th colspan=1 class="width_3 text-center">Quantity<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_5 text-center">Rate<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_9 text-center">Currency<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_7 text-center">Ex-Rate<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Amount<span
										style="color: red;">*</span></th>
								<!-- 	<th colspan=1 class="width_9 text-center">Payment Mode<span
										style="color: red;">*</span></th> -->
									<th colspan=1 class="width_14 text-center">Buy/Sell Party<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_12 text-center">Status<span
										style="color: red;">*</span></th>
								
										
								</tr>
							</thead>
							<tbody ng-repeat="(trIndex, jobOrderDtl) in joborder.joborderDtl"
								ng-controller="jobtableCtrl" class="bookingDtlCls">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select" disabled="true"><i></i></label></td>
									<!-- <td class="text-center">{{trIndex+1}}</td> -->
									<td class=""><selectivity list="chargeHeadList"
											property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}"
											ng-model="jobOrderDtl.chargeHead"
											name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}"
											form-name="jobOrderDtlForm" disabled="true"></selectivity></td>

									<td class=""><selectivity list="UnitList"
											property="jobOrderDtl.unit" id="unit"
											ng-model="jobOrderDtl.unit" name="unit{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>

									<td class="text-center"><selectivity
											list="transactionTypeList"
											property="jobOrderDtl.transactionType"
											id="transactionType{{trIndex}}"
											ng-model="jobOrderDtl.transactionType"
											name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>


									<td class="text-center"><input type="text"
										id="qty{{trIndex}}" class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="9" ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}"
										ng-change="ratevalues()" disabled="true"></td>

									<td class="text-center"><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="10"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}"
										ng-change="ratevalues()" disabled="true"></td>

									<td class=""><selectivity list="currencylist"
											property="jobOrderDtl.currency" id="currency{{trIndex}}"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>

									<td class="text-center"><input type="text"
										class="form-control input-sm text-right"
										id="exRate{{trIndex}}" ng-model="jobOrderDtl.exRate" 
										name="exRate{{trIndex}}" validation="required|integer"
										form-name='jobOrderForm' ng-blur="CheckExRateDtl(jobOrderDtl.currency,trIndex)"
										maxlength="9"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}" disabled="true">
									</td>

									<td class="text-center"><input type="text"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="20" id="amount{{trIndex}}"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}"
										ng-change="ratevalues1()" readonly></td>

							<!-- 		<td class="text-center"><selectivity
											list="PaymentMethodList" property="jobOrderDtl.paymentMode"
											id="paymentMethod{{trIndex}}"
											ng-model="jobOrderDtl.paymentMode"
											name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td> -->

									<td ng-if="jobOrderDtl.transactionType==1"><selectivity list="customerBuyList"
											property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>
											
									<td ng-if="jobOrderDtl.transactionType==2"><selectivity list="customerSellList"
											property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled="true"></selectivity></td>
													
									<td class="text-center"><selectivity list="jobStatusListDtl"
											property="jobOrderDtl.status" id="status{{trIndex}}"
											ng-model="jobOrderDtl.status" name="status{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(status)'}}"
											form-name="jobOrderForm" disabled=true></selectivity></td>
								</tr>

							</tbody>
						</table>
						<div ng-if="Add && specialEmployeeFlag">
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

					
					
				

				<!-- <div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">


										<label class="col-md-6 control-label">Selling Amount</label> <input
											type="text" class="form-control input-sm text-right"
											style="width: 110px; float: left;"
											data-ng-model="joborder.sell1" id="sell1" name="sell1"
											readonly>

									</div>
									<div class="col-md-12">


										<label class="col-md-6 control-label">Buying Amount</label> <input
											type="text" class="form-control input-sm text-right"
											style="width: 110px; float: left;"
											data-ng-model="joborder.buy1" id="buy1" name="buy1" readonly>

									</div>

									<div class="col-md-12">


										<label class="col-md-6 control-label"> Total Profit</label> <input
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
				
				
														<div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<!-- <th colspan=1 class="width_1"></th> -->
									<!-- <th colspan=1 class="width_3 text-center">S.No</th> -->
									<th colspan=1 class="width_13 text-center"><span
										style="color: red;"></span></th>
									<!-- <th colspan=1 class="width_9 text-center">Units<span
										style="color: red;"></span></th> -->
									<th colspan=1 class="width_6 text-center">
										<span style="color: red;"></span>
									</th>
									<th colspan=1 class="width_5 text-center"><span
										style="color: red;"></span></th>
									<th colspan=1 class="width_8 text-center"><span
										style="color: red;"></span></th>
									<th colspan=1 class="width_9 text-center"><span
										style="color: red;"></span></th>
									<th colspan=1 class="width_8 text-center"><span
										style="color: red;"></span></th>
									<th colspan=1 class="width_10 text-center"><span
										style="color: red;"></span></th>
									<th colspan=1 class="width_9 text-center"><span
										style="color: red;"></span></th>
									<th colspan=1 class="width_9 text-center"><span
										style="color: red;"></span></th>
									<th colspan=1 class="width_12 text-center"><span
										style="color: red;"></span></th>
										<th colspan=1 class="width_6 text-center"><span
										style="color: red;"></span></th>
								</tr>
							</thead>
							<tbody ng-repeat="(trIndex, jobOrderDtl1) in joborder.joborderDtl1"
								ng-controller="jobtableCtrl" class="bookingDtlCls">
								<tr style="background-color: {{jobOrderDtl.color}};">
									<!-- <td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select"><i></i></label></td> -->
									<!-- <td class="text-center">{{trIndex+1}}</td> -->
									<td class="text-center"><!-- <selectivity list="chargeHeadList"
											property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}"
											ng-model="jobOrderDtl.chargeHead"
											name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}"
											form-name="jobOrderDtlForm" disabled = true></selectivity> -->
											<!-- <input type="text" class="form-control input-sm text-right"
											ng-model="jobOrderDtl.chargeHeadName" name="chargeHeadName"
											form-name='jobOrderForm' friendly-name="chargeHeadName" disabled = true
											> --><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.chargeHeadName}}</label>
											</td>
											
											<td class="text-center"><!-- <selectivity list="chargeHeadList"
											property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}"
											ng-model="jobOrderDtl.chargeHead"
											name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}"
											form-name="jobOrderDtlForm" disabled = true></selectivity> -->
											<!-- <input type="text" class="form-control input-sm text-right"
											ng-model="jobOrderDtl.chargeHeadName" name="chargeHeadName"
											form-name='jobOrderForm' friendly-name="chargeHeadName" disabled = true
											> --><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.unitName}}</label>
											</td>

									<!-- <td class="text-center"><selectivity list="UnitList"
											property="jobOrderDtl.unit" id="unit"
											ng-model="jobOrderDtl.unit" name="unit{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}"
											form-name="jobOrderForm" disabled = true></selectivity>
											<input type="text" class="form-control input-sm text-right"
											ng-model="jobOrderDtl.unitName" name="unitName"
											form-name='jobOrderForm' friendly-name="unitName" disabled = true
											></td>
 -->
									<td class="text-center"><!-- <selectivity
											list="transactionTypeList"
											property="jobOrderDtl.transactionType"
											id="transactionType{{trIndex}}"
											ng-model="jobOrderDtl.transactionType"
											name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}"
											form-name="jobOrderForm" disabled = true></selectivity> -->
											<!-- <input type="text" class="form-control input-sm text-right"
											ng-model="jobOrderDtl.transactionTypeName" name="transactionTypeName"
											form-name='jobOrderForm' friendly-name="transactionTypeName" disabled = true
											> --><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.transactionTypeName}}</label></td>


									<td class="text-center">
									<label class="col-md-7 control-label view-content"> {{jobOrderDtl1.quantity}}</label><!-- <input type="text"
										id="qty{{trIndex}}" class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="9" ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}"
										ng-change="ratevalues()" readonly> --></td>

									<td class="text-center">
									<label class="col-md-7 control-label view-content"> {{jobOrderDtl1.rate}}</label>
									<!-- <input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="10"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}"
										ng-change="ratevalues()" readonly> --></td>

									<td class="text-center"><!-- <selectivity list="currencylist"
											property="jobOrderDtl.currency" id="currency{{trIndex}}"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}"
											form-name="jobOrderForm" disabled = true></selectivity> -->
									<label class="col-md-7 control-label view-content"> {{jobOrderDtl1.currencyName}}</label>		<!-- <input type="text" class="form-control input-sm text-right"
											ng-model="jobOrderDtl.currencyName" name="currencyNameName"
											form-name='jobOrderForm' friendly-name="currencyNameName" disabled = true
											> --></td>

									<td class="text-center">
						<label class="col-md-7 control-label view-content"> {{jobOrderDtl1.exRate}}</label>			
									<!-- <input type="text"
										class="form-control input-sm text-right"
										id="exRate{{trIndex}}" ng-model="jobOrderDtl.exRate"
										name="exRate{{trIndex}}" validation="required|integer"
										form-name='jobOrderForm' ng-change="ratevalues()"
										maxlength="9"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}" readonly> -->
									</td>

									<td class="text-center"><!-- <input type="text"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="20" id="amount{{trIndex}}"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}"
										ng-change="ratevalues1()" readonly> -->
										<label class="col-md-7 control-label view-content"> {{jobOrderDtl1.amount}}</label>	</td>

									<td class="text-center"><!-- <selectivity
											list="PaymentMethodList" property="jobOrderDtl.paymentMode"
											id="paymentMethod{{trIndex}}"
											ng-model="jobOrderDtl.paymentMode"
											name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}"
											form-name="jobOrderForm" disabled = true></selectivity> -->
										<label class="col-md-7 control-label view-content"> {{jobOrderDtl1.paymentModeName}}</label>	<!-- <input type="text" class="form-control input-sm text-right"
											ng-model="jobOrderDtl.paymentModeName" name=""
											form-name='jobOrderForm' friendly-name="paymentModeName" disabled = true
											> --></td>

									<td class="text-center"><!-- <selectivity list="serviceParnrDropList"
											property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty"
											name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}"
											form-name="jobOrderForm" disabled = true></selectivity> -->
											<!-- <input type="text" class="form-control input-sm text-right"
											ng-model="jobOrderDtl.buySellPartyName" name=""
											form-name='jobOrderForm' friendly-name="buySellPartyName" disabled = true
											> --><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.buySellPartyName}}</label></td>
									<td class="text-center"><!-- <selectivity list="jobStatusListDtl"
											property="jobOrderDtl.status" id="status{{trIndex}}"
											ng-model="jobOrderDtl.status" name="status{{trIndex}}"
											validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(status)'}}"
											form-name="jobOrderForm" disabled = true></selectivity> -->
										
										<label class="col-md-7 control-label view-content"> {{jobOrderDtl1.statusName}}</label>	<!-- <input type="text" class="form-control input-sm text-right"
											ng-model="jobOrderDtl.statusName" name="statusName"
											form-name='jobOrderForm' friendly-name="statusName" disabled = true
											> --></td>
											<!-- <td class="text-center">
									<label class="col-md-7 control-label view-content"> {{jobOrderDtl1.invoiceNo}}</label>
									<input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="10"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}"
										ng-change="ratevalues()" readonly></td> -->
								</tr>

							</tbody>
						</table>
						<!-- <div class="padding-right-5">
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
						</div> -->
					</div>
                   <div class="col-sm-12 " ng-if="!edit && specialEmployeeFlag">
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
						 <div class="col-sm-12 " ng-if="edit && specialEmployeeFlag">
							<fieldset>
                             <div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Selling Amount</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.sell2" id="sell2" name="sell2"
												readonly>
									</div>

								</div>
								<div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Buying Amount</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.buy2" id="buy2" name="buy2" readonly>
									</div>
								</div>

								<div class="form-group col-md-4 col-lg-4">
									<label class="col-md-4 control-label">Total Profit</label>
									<div class="col-md-7">
										<input
												type="text" class="form-control input-sm text-right"
												style="width: 110px; float: left;"
												data-ng-model="joborder.total2" id="total2" name="amount2"
												readonly>
									</div>
								</div>
								
								
							</fieldset>
						</div>
						
				

				<br> <br>
				<br>
				<!-- <div class="table-responsive clear" ng-if="edit">
				<header id="btntoggle" data-role="heading"
						style="margin-bottom: 0px !important; color: black"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a style="color: black;">Invoice Details</a>
						</div>
					</header>
		<table class="table table-striped b-t b-light" >
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
									ng-model="joborder.salesInvoice"
									name="salesInvoice" readonly>											
									</div>
								</div>
							</td> 
							
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.salesDate" name="salesInvoiceDate"
											form-name="jobOrderForm" readonly
											 />
									</div>
								</div>
							</td>
					<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									<input type="text" id="purchaseInvoice"
									class="form-control input-sm text-Left"
									ng-model="joborder.purchaseInvoice"
									name="purchaseInvoice" readonly>
										
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.purchaseDate" name="purchaseInvoiceDate"
											form-name="jobOrderForm" readonly
											 />
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
		<table class="table table-striped b-t b-light" >
					<thead>
						<tr>
							
							<th class="width_10 text-center">Pickup Date</th>
							<th class="width_10 text-center">Customs Completion Date</th>
							<th class="width_10 text-center">Stuffing Date</th>
							<th class="width_10 text-center">Sailing Date</th>
							<th class="width_10 text-center">T/S Date</th>
							<th class="width_10 text-center">ETA Destination Date</th>
							<th colspan="1" class="width_21 text-center">Remarks<span
									style="color: red;"></span></th>
							
                       </tr>
					</thead>

					<tbody>
						<tr>
                      
							 <td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										
											<ng-bs3-datepicker
											ng-model="joborder.pickupDate" name="PickUpDate"
											form-name="jobOrderForm"/>
											
									</div>
								</div>
							</td> 
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.customsCompletionsDate" name="CustomsCompletionsDate"
											form-name="jobOrderForm"
											 />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.stuffingDate" name="StuffingDate"
											form-name="jobOrderForm"
											 />
									</div>
								</div>
							</td>
							
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.sailingDate" name="SailingDate"
											form-name="jobOrderForm"
											 />
									</div>
								</div>
							</td>
					<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.createdDt" name="createdDt"
											form-name="jobOrderForm"
											 />
									</div>
								</div>
							</td>					
							
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.etaDestinationDate" name="ETADestinationDate"
											form-name="jobOrderForm"
											 />
									</div>
								</div>
							</td>
							<td><div><textarea  type="text" class="form-control input-sm"
															name="remarks1{{trIndex1}}" id="remark1s{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3" maxlength="200"
															ng-model="joborder.remarks1">
															</textarea>
															<div class="row"ng-if="edit">
											
                                    <button type="button" class="btn btn-link" ng-click="remarks(row.jobNo) "style="color: green;font-size: 10px;text-align:justify">Click here to view remarks history </button>
												
											
										</div>
															</div>
															</td>		
							
						</tr>
					</tbody>
	          
				</table>
				<!-- <td class="width_10">
										<div class="row"ng-if="edit">
											<div class="col-xs-12" style="margin-left:1427px">
                                    <button type="button" class="btn btn-link" ng-click="remarks(row.accountHeadCode,row.jobNo) "style="color: green;font-size: 15px;">Click here to view remarks history </button>
												
											</div>
										</div>
									</td> -->	
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
		<table class="table table-striped b-t b-light" >
					<thead>
						<tr>
							
							<th class="width_10 text-center">Pickup Date</th>
							<th class="width_10 text-center">Customs Completion Date</th>
							<th class="width_10 text-center">Stuffing Date</th>
							<th class="width_10 text-center">Sailing Date</th>
							<th class="width_10 text-center">T/S Date</th>
							<th class="width_10 text-center">ETA Destination Date</th>
							<th colspan="1" class="width_21 text-center">Remarks<span
									style="color: red;"></span></th>
							
                       </tr>
					</thead>

					<tbody>
						<tr>
                      
							 <td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										
											<ng-bs3-datepicker
											ng-model="joborder.pickupDate" name="PickUpDate"
											form-name="jobOrderForm" disabled="true"/>
											
									</div>
								</div>
							</td> 
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.customsCompletionsDate" name="CustomsCompletionsDate"
											form-name="jobOrderForm" disabled="true"
											 />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.stuffingDate" name="StuffingDate"
											form-name="jobOrderForm" disabled="true"
											 />
									</div>
								</div>
							</td>
							
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.sailingDate" name="SailingDate"
											form-name="jobOrderForm" disabled="true"
											 />
									</div>
								</div>
							</td>
					<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.createdDt" name="createdDt"
											form-name="jobOrderForm" disabled="true"
											 />
									</div>
								</div>
							</td>					
							
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="joborder.etaDestinationDate" name="ETADestinationDate"
											form-name="jobOrderForm" disabled="true"
											 />
									</div>
								</div>
							</td>
							<td><div><textarea  type="text" class="form-control input-sm"
															name="remarks1{{trIndex1}}" id="remark1s{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3" maxlength="200"
															ng-model="joborder.remarks1" disabled="true">
															</textarea>
															<div class="row"ng-if="edit">
											
                                    <button type="button" class="btn btn-link" ng-click="remarks(row.jobNo) "style="color: green;font-size: 10px;text-align:justify">Click here to view remarks history </button>
												
											
										</div>
															</div>
															</td>		
							
						</tr>
					</tbody>
	          
				</table>
				<!-- <td class="width_10">
										<div class="row"ng-if="edit">
											<div class="col-xs-12" style="margin-left:1427px">
                                    <button type="button" class="btn btn-link" ng-click="remarks(row.accountHeadCode,row.jobNo) "style="color: green;font-size: 15px;">Click here to view remarks history </button>
												
											</div>
										</div>
									</td> -->	
				</div>
				</div>
				<!-- <div ng-if="trackDtl">
				<div class="table-responsive clear">
				<header id="btntoggle" data-role="heading"
						style="margin-bottom: 0px !important; color: black"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a style="color: black;">Container Details</a>
						</div>
					</header>
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan="1" class="width_1"></th>
								<th colspan="1" class="width_7 text-center">S.No</th>
								<th colspan="1" class="width_7 text-center">Container No<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_7 text-center">Size Type<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_12 text-center">Cargo Description <span style="color: red;"></span>
								</th>
								<th colspan="1" class="width_7 text-center">No of Package<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_7 text-center">UOM<span
									style="color: red;"></span>
								</th>
								<th colspan="1" class="width_7 text-center">Net Weight<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_7 text-center">Gross Weight<span
									style="color: red;"></span></th>
								
								<th colspan="1" class="width_7 text-center">Measurement<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_12 text-center">Remarks<span
									style="color: red;"></span></th>

							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex1, jobOrderTrackingDtl) in joborder.joborderTrackingDtl"
							class="bookingDtlCls">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="jobOrderTrackingDtl.select" disabled="true"> <i></i></label></td>
								<td class="text-center">{{trIndex1+1}}</td>
								
								<td>
								
								<input type="text" id="containerNo{{trIndex1}}"
									class="form-control input-sm " maxlength="11"
									ng-model="jobOrderTrackingDtl.containerNo"
									name="containerNo{{trIndex1}}" form-name='jobOrderForm'
									friendly-name="{{ 'Row-' + (trIndex1+1) + 'containerNo'}}" disabled="true">
									
									
								</td> 
                                <td class=""><selectivity list="sizeTypeList"
										property="jobOrderTrackingDtl.sizeType" id="sizeType"
										ng-model="jobOrderTrackingDtl.sizeType" name="sizeType{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(sizeType)'}}"
										form-name="jobOrderForm" disabled="true"></selectivity></td>
								<td><textarea  type="text" class="form-control input-sm"
															name="cargoDescription{{trIndex1}}" id="cargoDescription{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.cargoDescription" disabled="true">
															</textarea></td>
									
                               <td><input type="text"
									class="form-control input-sm text-right"
									id="noOfPcs{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.noOfPackage"
									name="noOfPackage{{trIndex1}}" ng-change="noOfPcs()" disabled="true"></td>
								<td class=""><selectivity list="uomList"
										property="jobOrderTrackingDtl.uom" id="uom"
										ng-model="jobOrderTrackingDtl.uom" name="uom{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(uom)'}}"
										form-name="jobOrderForm" disabled="true"></selectivity></td>


								<td><input type="number"
									class="form-control input-sm text-right"
									id="netWeight{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.netWeight" 
									name="netWeight{{trIndex1}}" friendly-name="netWeight{{trIndex1}} "
									 ng-change="noOfNet()" form-name="jobOrderForm" disabled="true"></td>

								<td><input type="number"
									class="form-control input-sm text-right"
									id="grossWeight{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.grossWeight"
									name="length{{trIndex1}}" ng-change="noOfGross()" disabled="true"></td>


								
									<td><input type="number"
									class="form-control input-sm text-right"
									id="measurement{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.measurement"
									name="measurement{{trIndex1}}" disabled="true"></td>
								
								<td><textarea  type="text" class="form-control input-sm"
															name="remarks{{trIndex1}}" id="remarks{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.remarks">
															</textarea></td>
									
							</tr>

						</tbody>
					</table>
					
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
				</div> ng-if="!trackDtl" -->
				 <div>
				<div class="table-responsive clear" ng-if=joborder.mode!="5">
				<header id="btntoggle" data-role="heading"
						style="margin-bottom: 0px !important; color: black"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a style="color: black;">Container Details</a>
						</div>
					</header>
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan="1" class="width_1"></th>
								<!--<th colspan="1" class="width_7 text-center">S.No</th>-->
								<th colspan="1" class="width_7 text-center">Container No<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_7 text-center">Size Type<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_12 text-center">Cargo Description <span style="color: red;"></span>
								</th>
								<th colspan="1" class="width_7 text-center">UOM<span
									style="color: red;"></span>
								</th>
								<th colspan="1" class="width_7 text-center">No of Package<span
									style="color: red;">*</span></th>
							
								<th colspan="1" class="width_7 text-center">Net Weight<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_7 text-center">Gross Weight<span
									style="color: red;"></span></th>
									
										
								
								<th colspan="1" class="width_7 text-center">Measurement<span
									style="color: red;"></span></th>
							<!--	<th colspan="1" class="width_12 text-center">Remarks<span
									style="color: red;"></span></th> -->

							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex1, jobOrderTrackingDtl) in joborder.joborderTrackingDtl"
							class="bookingDtlCls"  ng-controller="jobtableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="jobOrderTrackingDtl.select" > <i></i></label></td>
								<!--<td class="text-center">{{trIndex1+1}}</td>-->
								
								<td>
								
								<!-- <input type="text" id="containerNo{{trIndex1}}"
									class="form-control input-sm " maxlength="11"
									ng-model="jobOrderTrackingDtl.containerNo"
									name="containerNo{{trIndex1}}" form-name='jobOrderForm'
									friendly-name="{{ 'Row-' + (trIndex1+1) + 'containerNo'}}" > -->
									
										<selectivity list="containerNoList"
												property="jobOrderTrackingDtl.containerNo" id="containerNo{{trIndex}}"
												data-ng-model="jobOrderTrackingDtl.containerNo"
												name="containerNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerNo)'}}"
												form-name="jobOrderForm"></selectivity>
								</td>
                                <td class=""><selectivity list="sizeTypeList"
										property="jobOrderTrackingDtl.sizeType" id="sizeType"
										ng-model="jobOrderTrackingDtl.sizeType" name="sizeType{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(sizeType)'}}"
										form-name="jobOrderForm" readonly></selectivity></td>
								<td><textarea  type="text" class="form-control input-sm"
															name="cargoDescription{{trIndex1}}" id="cargoDescription{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.cargoDescription" >
															</textarea></td>
									
<td class=""><selectivity list="uomList"
										property="jobOrderTrackingDtl.uom" id="uom"
										ng-model="jobOrderTrackingDtl.uom" name="uom{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(uom)'}}"
										form-name="jobOrderForm" ></selectivity></td>
                              <td><input type="text"
									class="form-control input-sm text-right"
									id="noOfPcs{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.noOfPackage"
									name="noOfPackage{{trIndex1}}" validation="required"></td>


								<td><input type="number"
									class="form-control input-sm text-right"
									id="netWeight{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.netWeight" 
									name="netWeight{{trIndex1}}" friendly-name="netWeight{{trIndex1}} "
									 form-name="jobOrderForm" ></td>

								<td><input type="number"
									class="form-control input-sm text-right"
									id="grossWeight{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.grossWeight"
									name="length{{trIndex1}}"  ></td>
									
								

								
									<td><input type="number"
									class="form-control input-sm text-right"
									id="measurement{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.measurement"
									name="measurement{{trIndex1}}" ></td>
								
								<!--<td><textarea  type="text" class="form-control input-sm"
															name="remarks{{trIndex1}}" id="remarks{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.remarks">
															</textarea></td>-->
									
							</tr>

						</tbody>
					</table>
					
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
				<div class="table-responsive clear" ng-if=joborder.mode=="5">
				<header id="btntoggle" data-role="heading"
						style="margin-bottom: 0px !important; color: black"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a style="color: black;">Container Details</a>
						</div>
					</header>
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan="1" class="width_1"></th>
								<!-- <th colspan="1" class="width_7 text-center">S.No</th> -->
								<th colspan="1" class="width_7 text-center">Container No<span
									style="color: red;">*</span></th>
								<th colspan="1" class="width_7 text-center">Size Type<span
									style="color: red;">*</span></th>
								<th colspan="1" class="width_12 text-center">Cargo Description <span style="color: red;">*</span>
								</th>
								<th colspan="1" class="width_7 text-center">UOM<span
									style="color: red;"></span>
								</th>
								<th colspan="1" class="width_7 text-center">No of Package<span
									style="color: red;"></span></th>
								
								<th colspan="1" class="width_7 text-center">Net Weight<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_7 text-center">Gross Weight<span
									style="color: red;"></span></th>
								
								<th colspan="1" class="width_7 text-center">Measurement<span
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
										type="checkbox" ng-model="jobOrderTrackingDtl.select" > <i></i></label></td>
								<!-- <td class="text-center">{{trIndex1+1}}</td> -->
								
								<td>
									
								<input type="text" id="containerNo{{trIndex1}}" class="form-control input-sm" maxlength="11" 
									class="form-control input-sm " maxlength="11"  data-ng-blur="validateContainer(jobOrderTrackingDtl.containerNo,trIndex1)"
									ng-model="jobOrderTrackingDtl.containerNo" validation="required"
									name="containerNo{{trIndex1}}" form-name='jobOrderForm'
									friendly-name="{{ 'Row-' + (trIndex1+1) + 'containerNo'}}" >
									
									
									
									
								</td>
                                <td class=""><selectivity list="sizeTypeList"
										property="jobOrderTrackingDtl.sizeType" id="sizeType"
										ng-model="jobOrderTrackingDtl.sizeType" name="sizeType{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(sizeType)'}}"
										form-name="jobOrderForm" readonly></selectivity></td>
								<td><textarea  type="text" class="form-control input-sm"
															name="cargoDescription{{trIndex1}}" id="cargoDescription{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3" validation="required"
															ng-model="jobOrderTrackingDtl.cargoDescription" >
															</textarea></td>
									<td class=""><selectivity list="uomList"
										property="jobOrderTrackingDtl.uom" id="uom"
										ng-model="jobOrderTrackingDtl.uom" name="uom{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(uom)'}}"
										form-name="jobOrderForm" ></selectivity></td>
                               <td><input type="text"
									class="form-control input-sm text-right"
									id="noOfPcs{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.noOfPackage"
									name="noOfPackage{{trIndex1}}"  ></td>
								


								<td><input type="number"
									class="form-control input-sm text-right"
									id="netWeight{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.netWeight" 
									name="netWeight{{trIndex1}}" friendly-name="netWeight{{trIndex1}} "
									  form-name="jobOrderForm" ></td>

								<td><input type="number"
									class="form-control input-sm text-right"
									id="grossWeight{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.grossWeight"
									name="length{{trIndex1}}"  ></td>


								
									<td><input type="number"
									class="form-control input-sm text-right"
									id="measurement{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.measurement"
									name="measurement{{trIndex1}}" ></td>
								
								<!-- <td><textarea  type="text" class="form-control input-sm"
															name="remarks{{trIndex1}}" id="remarks{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.remarks">
															</textarea></td> -->
									
							</tr>

						</tbody>
					</table>
					
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
				<div class="col-sm-12 ">
							<fieldset>
                             <div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Total No of Package <span
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
								
								
							</fieldset>
						</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
									
										<button class="btn btn-success" ng-if="!edit" type="button"
											ng-click="saveBooking(jobOrderForm)">
											<i class="fa fa-save"></i> Save
										</button>
											<security:authorize access="hasRole('F5576_${print}')">
                                        <button class="btn btn-success" ng-if="edit" type="button"
											ng-click="print1(joborder.jobId)">
											<i class="fa fa-print"></i> Print - CPA
										</button>
										</security:authorize>
										<security:authorize access="hasRole('F5576_${print}')">
										<button class="btn btn-success" ng-if="edit" type="button"
											ng-click="printRoutingOrder1()">
											<i class="fa fa-print"></i> Print - Routing Order
										</button>
										</security:authorize>
										<security:authorize access="hasRole('F5576_${print}')">
										<button class="btn btn-success" ng-if="edit" type="button"
											ng-click="JobSheet(joborder.jbId)">
											<i class="fa fa-print"></i> Print -Job Sheet
										</button>
										</security:authorize>
										<security:authorize access="hasRole('F5576_${print}')">
										<button class="btn btn-success" ng-if="edit" type="button"
											ng-click="printPrealertSea(joborder.jobId)">
											<i class="fa fa-print"></i> Print - Pre-Alert
										</button>
										</security:authorize>
										<!-- <div ng-if="!disable"> -->
										<button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submitApprove(jobOrderForm,joborder)">
											<i class="fa fa-save"></i> Approve
										</button>
										<!-- </div> -->

									<!-- 	<button class="btn btn-info" type="reset" ng-click="reset()">
											<i class="fa fa-undo"></i> Reset
										</button> -->


										<button class="btn btn-danger" type="reset"
											class="btn btn-success" ng-click="cancel()">
											<i class="fa fa-close"></i> Cancel
										</button>

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
		
								<!-- for show debit credit -->
					
			<!--  		<div ng-if="disable">
					<div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_1"></th>
									<th colspan=1 class="width_3 text-center">S.No</th>
									<th colspan=1 class="width_13 text-center"></th>
									<th colspan=1 class="width_9 text-center"></th>
									<th colspan=1 class="width_6 text-center"></th>
									<th colspan=1 class="width_7 text-center"></th>
									<th colspan=1 class="width_8 text-center"></th>
									<th colspan=1 class="width_9 text-center"></th>
									<th colspan=1 class="width_8 text-center"></th>
									<th colspan=1 class="width_10 text-center"></th>
									<th colspan=1 class="width_9 text-center"></th>
									<th colspan=1 class="width_9 text-center"></th>
									<th colspan=1 class="width_12 text-center"></th>
								</tr>
							</thead>
							<tbody ng-repeat="(trIndex, row) in joborder.joborderDtl1"
								ng-controller="jobtableCtrl" class="bookingDtlCls">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select" disabled="true"><i></i></label></td>
									<td class="text-center">{{trIndex+1}}</td>
									

								<td class=""><label class="col-md-7 control-label view-content"> {{row.chargeHeadName}}</label></td> 

									<td class=""><label class="col-md-7 control-label view-content">{{jobOrderDtl1.unitName}}</label></selectivity></td>

									<td class="text-center"><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.transactionTypeName}}</label></td>


									<td class="text-center"><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.quantity}}</label></td>

									<td class="text-center"><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.rate}}</label></td>

									<td class=""><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.currencyName}}</label></td>

									<td class="text-center"><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.exRate}}</label>
									</td>

									<td class="text-center"><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.amount}}</label></td>

									<td class="text-center"><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.paymentModeName}}</label></td>

									<td><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.buySellPartyName}}</label></td>
											
									<td><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.statusName}}</label></td>
													
									<td class="text-center"><label class="col-md-7 control-label view-content"> {{jobOrderDtl1.invoiceNo}}</label></td>
								</tr>

							</tbody>
						</table>
					</div>
					</div>
					
					show debit credit end -->
					

	
	<div id="printableContent"
						style="margin-bottom: 10px; display: none;">

						<div style="width:100%;float: left;">
							<div style="width:30%;float: left;">
								<img src="/img/${user.tenantId}HelpVideos/logo.jpg"
									style="padding: 10 0 0 10; height: 60px;">
							</div>
							<div style="width:70%;float: left;margin-top: 2%;">
								<span style="text-align: right; text-transform: uppercase;"><b>${user.tenantId}
										GLOBAL LOGISTICS PVT LTD</b></span>
							</div>
						</div>

						<div style="width: 100%; float: left; text-align: center;margin: 1% 0% 1% 0%;">
							<span><b>Routing Order</b></span>
						</div>
						<div style="width: 100%;padding: 0% 1% 0% 1%;">
						<table width="100%" border="1"
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
					
	
	
	
	</div>