<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
	<security:authentication var="user" property="principal" />
<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}

.selectivity-backdrop {
	background: transparent;
	position: relative;
	z-index: 9998;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
}
    /* //#container     { outline:1px solid black; padding:0 .2em; background:white;} */

</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div style="width: 30%;position: absolute;margin-top: -33px;margin-left: 78%;" ng-if="isEdit">
		<label style="color:#e25d5d;float: left;">Quick Links &nbsp;&nbsp; </label>
		  <select ng-change="quickLinkMethd(qukLinkVal)" ng-init="qukLinkVal='Select'" ng-model="qukLinkVal">
		 <option value="Select">Select</option>
		  <option value="Job Order">Job Order</option>
		  <option value="HBL">HBL</option>
		  <option value="Delivery Order">Delivery Order</option>
		  <option value="Sales Invoice">Sales Invoice</option>
		  <option value="Purchase Invoice">Purchase Invoice</option>
		</select>
		</div>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<form name="mablForm" method="post" class="form-horizontal" novalidate>
			<div class="panel-body" style="border-bottom: none;">
				<div class="row pl2pc pr10pc">
					<div class="col-md-3" ng-if="isEdit">
						<div class="form-group" >
							<label class="col-md-5 control-label" style="text-align:left">MBL No <span
								style="color: red;">*</span>
							</label>

							<div class="col-md-7">
								<label style="padding-top: 9px;">{{mabl.mblCode}}</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Search By Booking <span
								style="color: red;"></span></label>
							<div class="col-md-7">
								<selectivity ng-if="isEdit" list="bookingList" property="mabl.booking"
									data-ng-model="mabl.booking" name="Booking" 
									form-name="mablForm" friendly-name="Booking" disabled="true"> </selectivity>
									<selectivity ng-if="!isEdit" list="bookingList" property="mabl.booking"
									data-ng-model="mabl.booking" name="Booking" 
									form-name="mablForm" friendly-name="Booking"> </selectivity>

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">MBL Date <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="mabl.mblDate" id="mablDate"
									name="MBl Date" form-name="mablForm" friendly-name="MBl Date"
									validation="required" />

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Type <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="typeList" property="mabl.type"
									data-ng-model="mabl.type" name="MBL Type" validation="required"
									form-name="mablForm" friendly-name="MBL Type"> </selectivity>

							</div>
						</div>
					</div>
					


				</div>
				<div class="row pl2pc pr10pc">

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">POL <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<selectivity list="polList" property="mabl.pol"
									data-ng-model="mabl.pol" name="POL" validation="required"
									form-name="mablForm" friendly-name="POL"> </selectivity>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">POD <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="podList" property="mabl.pod"
									data-ng-model="mabl.pod" name="POD" validation="required"
									form-name="mablForm" friendly-name="POD"> </selectivity>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Branch <span
								style="color: red;">*</span></label>
							<div class="col-md-7">

								<selectivity list="branchList" property="mabl.branch"
									data-ng-model="mabl.branch" name="branch" validation="required"
									form-name="mablForm" friendly-name="branch"> </selectivity>


							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Customer <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="customerList" property="mabl.customer"
									data-ng-model="mabl.customer" name="Customer"
									validation="required" form-name="mablForm"
									friendly-name="Customer"> </selectivity>

							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Origin <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="originList" property="mabl.origin"
									data-ng-model="mabl.origin" name="Origin" validation="required"
									form-name="mablForm" friendly-name="Origin"> </selectivity>


							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Destination<span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="destinationList" property="mabl.destination"
									data-ng-model="mabl.destination" name="Destination"
									validation="required" form-name="mablForm"
									friendly-name="Destination"> </selectivity>

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Term <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="termList" property="mabl.term"
									validation="required" data-ng-model="mabl.term" name="Term"
									form-name="mablForm" friendly-name="Term"> </selectivity>

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"style="text-align:left">Vendor<span
								style="color: red;"></span></label>
							<div class="col-md-7">
								<selectivity list="customerList" property="mabl.vendor"
									  data-ng-model="mabl.vendor" name="Vendor"
									form-name="mablForm" friendly-name="Vendor"> </selectivity>
							</div>
						</div>
					</div>
				</div>
				<!-- <div class="row pl2pc pr10pc">


					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Customer <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="customerList" property="mabl.customer"
									data-ng-model="mabl.customer" name="Customer"
									validation="required" form-name="mablForm"
									friendly-name="Customer"> </selectivity>

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Vendor<span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="customerList" property="mabl.vendor"
									validation="required" data-ng-model="mabl.vendor" name="Vendor"
									form-name="mablForm" friendly-name="Vendor"> </selectivity>
							</div>
						</div>
					</div>
					<div class="col-md-3"></div>
				</div> -->
				<!-- <div class="row pl2pc pr10pc">
					<div class="col-md-5">
						<div class="form-group">
							<label class="col-md-3 control-label" style="font-weight: bold; color: black;">Job Details<span
								style="color: red;">*</span></label>
						</div>
					</div>
				</div> -->
				
				<!-- div class="row pl2pc pr10pc">
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label" style="font-size: 18px;">Job Details<span
								style="color: red;">*</span></label>

						</div>
					</div>




				</div> -->
				<fieldset class="b-a width_100" style="top: 10px; padding-bottom: 10px; border: 1px solid #DDD">
									<legend class="width_9  b-a control-label;" style="margin-left: 1%;font-size: 15px; font-weight:bold;
 ">Job Details <span
								style="color: red;">*</span></legend>
				
				<div class="row pl2pc pr10pc" >
					<div class="col-md-18">
					<div class="table-responsive" ng-if="jobDetail==false"   style="padding-left: 33px;padding-bottom: 13px;">
					<div class="col-md-15">
					You Searched for -<label style="color:red;"> ( POL : {{t1}}, POD : {{t2}}, Branch : {{t3}} )</label>- did not match any Job Order
					</div>
					</div>
					
					</div>
					<div class="table-responsive" ng-show="lMabljobDetailBean.length<=0"   style="padding-left: 33px;padding-bottom: 13px;">
					<div class="col-md-15">
					No Records 
					</div>
					</div>
					
					
					<div class="table-responsive" ng-if="s1"  style="padding-left: 33px;padding-bottom: 13px;">
					
					<label class="col-md-30 control-label" style= text-align:"left">Please select POL, POD and Branch and Fetch Job Order Details.</label>
					
					</div>
						<div class="table-responsive" ng-if="jobDetail==true"   style="padding-left: 109px;">
							<table class="table table-striped b-t b-light"  style="width:44%">
								<thead>
									<tr style="background-color: #FB6C23;">
										<th class="sorting width_2" style="padding-left: 42px;">Select</th>
										<th class="sorting width_2" style="padding-left: 71px; text-align:left"    
										>JobNo</th>
									</tr>
								</thead>

								<tbody ng-repeat="($index,row) in lMabljobDetailBean" >
									<tr  style="background-color: #c4c4d0;" >
										<td width="10%" ><label class="i-checks m-b-none"  style="padding-left: 54px;">
										 <input type="checkbox" ng-model="row.select" ng-click="container(row.select,$index)"
												id="section{{trIndex}}"style="background-color: #c4c4d0;"><i></i></label></td>
										<td  width="10%">
										<div class="form-group col-md-3 col-lg-3">
								               <!--  <label class="col-md-5 control-label view-label">Quotation: </label>  -->
								             <div class="col-md-7"> 
								       <label class="col-md-7 control-label view-content"><a data-ng-click="viewQuotation(row.jobNo)">  <span class="tool-tip-span font-blue"> {{row.jobCode}}</span></a></label> 
								             </div>
								            </div>
								            
											<!-- <div class="row" >
												<div class="col-xs-10"   >
												
													<input type="text"  class="form-control input-sm" disabled style="background-color: #c4c4d0;border: none;color: #080808;"
														ng-hidden="row.jobNo" data-ng-model="row.jobCode"
														name="Charger Name{{trIndex}}" 
														friendly-name="{{ 'Row' + $index + '(Charger Name)'}}" />
												</div>
											</div> -->
										</td>

									</tr>
								</tbody>

							</table>

						</div>

					</div>


					
				</fieldset>
				
				
				<div class="col-md-12" style="    PADDING-TOP: 10px;">
					<div class="col-md-1"></div>
					<div class="col-md-4"></div>
				</div>
			
				
				<fieldset class="b-a width_100" style="top: 10px; padding-bottom: 10px; border: 1px solid #DDD">
									<legend class="width_14  b-a control-label;" style="margin-left: 1%;font-size: 15px; font-weight:bold;"
">Document Details</legend>
				<!-- <div class="row pl2pc pr10pc" >
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"
								style="font-weight: bold; color: black;">Document
								Details</label>

						</div>
					</div>
				</div> -->
				
			
				<div class="row pl2pc pr10pc">
					<div class="col-md-3">
						<div class="form-group" ng-if="!isEdit">
							<label class="col-md-5 control-label">MBL Doc No</label>
							<div class="col-md-7">
								<input ng-if="mblNoCheck" type="text" class="form-control input-sm"
									property="mabl.mblDocNo" data-ng-model="mabl.mblDocNo"
									name="MBL Doc No" friendly-name="MBL Doc No" />
									<input ng-if="!mblNoCheck" type="text" class="form-control input-sm"
									property="mabl.mblDocNo" data-ng-model="mabl.mblDocNo"
									name="MBL Doc No" friendly-name="MBL Doc No" disabled="true"/>
							</div>
						</div>
						<div class="form-group" ng-if="isEdit">
							<label class="col-md-5 control-label">MBL Doc No</label>
							<div class="col-md-7">
								<input ng-if="mblNoCheck" type="text" class="form-control input-sm"
									property="mabl.mblDocNo" data-ng-model="mabl.mblDocNo"
									name="MBL Doc No" friendly-name="MBL Doc No" disabled="true"/>
									<input ng-if="!mblNoCheck" type="text" class="form-control input-sm"
									property="mabl.mblDocNo" data-ng-model="mabl.mblDocNo"
									name="MBL Doc No" friendly-name="MBL Doc No" disabled="true"/>
							</div>
						</div>
					</div>
					

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">MBL Doc Date</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="mabl.mblDocDate"
									id="mablDocDate" name="MBl Doc Date" form-name="mablForm"
									friendly-name="MBl Doc Date" />

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Vessel Voyage</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="mabl.vesselVoyeage"
									data-ng-model="mabl.vesselVoyeage" name="Vessel Voyage"
									friendly-name="Vessel Voyage" />
							</div>
						</div>
					</div>
					<!-- <div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Feeder Vessel
								Voyage</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="mabl.feederVesselVoyeage"
									data-ng-model="mabl.feederVesselVoyeage"
									name="Feeder Vessel Voyage"
									friendly-name="Feeder Vessel Voyeage" />
							</div>
						</div>
					</div> -->


				</div>
				<div class="row pl2pc pr10pc">


					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">HBL Doc No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="mabl.hblDocNo" data-ng-model="mabl.hblDocNo"
									name="HBL Doc No" friendly-name="HBL Doc No" />

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">HBL Doc Date </label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="mabl.hblDocDate"
									id="hblDocDate" name="HBl Doc Date" form-name="mablForm"
									friendly-name="HBl Doc Date" />
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label"">Agent
							</label>
							<div class="col-md-7">
								<selectivity list="agentList" property="mabl.agentName"
									data-ng-model="mabl.agentName" name="AgentName"
								 form-name="mablForm"
									friendly-name="AgentName"> </selectivity>

							</div>
						</div>
					</div>
					
					<!-- <div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">ETD</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="mabl.etd" id="etd" name="ETD"
									form-name="mablForm" friendly-name="ETD" />
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">E.T.A at POD</label>
							<div class="col-md-7">
								<ng-bs3-datepicker data-ng-model="mabl.etaAtPod" id="etaPod"
									name="E.T.A at POD" form-name="mablForm"
									friendly-name=">E.T.A at POD" />
							</div>
						</div>
					</div> -->

				</div>
				</fieldset>
				
				

				
			</div>
	
			
			<div style="padding: 0px 18px;border-bottom: none;border-top: none" class="panel-body" >
			<fieldset class="b-a width_100" style="top: 10px; padding-bottom: 10px; border: 1px solid #DDD">
									<legend class="width_14  b-a control-label;" style="margin-left: 1%;font-size: 15px; font-weight:bold;
									 ">Container Details</legend>
			<!-- <div class="row pl2pc pr10pc">
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label"
							style="font-weight: bold; color: black;">Container
							Details</label>

					</div>
				</div>
			</div> -->

			

			<div >
				<table class="table table-striped b-t">
					<thead>
						<tr>
							<th class="sorting width_2">Select</th>
							<th class="sorting width_2">Container No</th>

							<th class="sorting width_2">Seal No</th>
							<th class="sorting width_3">Size Type</th>
							<th class="sorting width_3">Marks and Nos</th>

							<th class="sorting width_2 text-center table-heading">Cargo
								Description</th>
							<th class="sorting width_2 text-center table-heading">No of
								package</th>
							<th class="sorting width_2 text-center table-heading">UOM</th>
							<th class="sorting width_2 text-center table-heading">Net
								Weight</th>
							<th class="sorting width_2 text-center table-heading">Gross
								Weight</th>
							<th class="sorting width_2 text-center table-heading">Measurement
							</th>

							<th class="sorting width_2 text-center table-heading">Remarks
							</th>


						</tr>
					</thead>

					<tbody ng-repeat="($index,row) in lMablContainerBean">
						<tr>
							<td><label class="i-checks m-b-none"> <input
									type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
							<td>
								<div class="row">
									<div class="col-xs-12"style="width:150px">
										<input type="text" class="form-control input-sm"
											data-ng-model="row.containerNo" maxlength="11" name="ContactName{{trIndex}}"
											ng-pattern-restrict="^[0-9.]*$"  data-toggle="tooltip" title="{{row.containerNo}}"
											friendly-name="{{ 'Row' + $index + '(ContactName)'}}" />
									</div>
								</div>
							</td>


							<td class="width_10">
								<div class="row">
									<div class="col-xs-12"style="width:151px">
										<input type="text" class="form-control input-sm" maxlength="20"  data-toggle="tooltip" title="{{row.sealNo}}"
											data-ng-model="row.sealNo" name="Designation{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Narration)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<selectivity list="sizeList" property="row.size"
											id="{{ 'Row' + $index + '(LandLineNo)'}}" ng-model="row.size"
											friendly-name="{{ 'Row' + $index + '(LandLineNo)'}}"></selectivity>

									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"data-toggle="tooltip" title="{{row.marksAndNos}}"
											data-ng-model="row.marksAndNos" name="MobileNo{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(MobileNo)'}}" /> -->
											<button type="button" class="btn btn-link" ng-click="remarks($index)"   style="color: green;font-size: 12px;text-align:justify">View</button>
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"data-toggle="tooltip" title="{{row.cargoDescription}}"
											data-ng-model="row.cargoDescription" name="Skype{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Skype)'}}" /> -->
											<button type="button" class="btn btn-link" ng-click="cargo($index)"   style="color: green;font-size: 12px;text-align:justify">View</button>
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm"data-toggle="tooltip" title="{{row.noofPackage}}"
											data-ng-model="row.noofPackage" name="Skype{{trIndex}}"
											ng-keyup="packageCalculation(row.noofPackage,trIndex,row)"
											friendly-name="{{ 'Row' + $index + '(Skype)'}}" />
									</div>
								</div>
							</td>

							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									<selectivity list="uomList" property="row.uOm"
											id="{{ 'Row' + $index + '(LandLineNo)'}}" ng-model="row.uOm"
											friendly-name="{{ 'Row' + $index + '(LandLineNo)'}}"></selectivity>
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.uOm" name="remarks{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(remarks)'}}" /> -->
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12" style="width:150px">
										<input type="text" class="form-control input-sm"data-toggle="tooltip" title="{{row.netWeight}}"
											data-ng-model="row.netWeight" validation="required|numeric" name="netWeight{{ 'Row' + $index + '(netWeight)'}}"
											ng-keyup="netWeightCalculation(row.netWeight,trIndex,row)"
											friendly-name="{{ 'Row' + $index + '(netWeight)'}}" />
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12"style="width:150px">
										<input type="text" class="form-control input-sm" data-toggle="tooltip" title="{{row.grossWeight}}"
											data-ng-model="row.grossWeight" validation="required|numeric" name="grossWeight{{ 'Row' + $index + '(grossWeight)'}}"
											ng-keyup="grossWeightCalculation(row.grossWeight,trIndex,row)"
											friendly-name="{{ 'Row' + $index + '(grossWeight)'}}" />
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm" data-toggle="tooltip" title="{{row.measureMent}}"
											data-ng-model="row.measureMent" validation="required|numeric" name="measureMent{{ 'Row' + $index + '(measureMent)'}}"
											friendly-name="{{ 'Row' + $index + '(measureMent)'}}" />
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm"data-toggle="tooltip" title="{{row.remarks}}"
											data-ng-model="row.remarks" name="ContactName{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(ContactName)'}}" />
									</div>
								</div>
							</td>
						</tr>
					</tbody>

				</table>
				</div>
				
			

				<div class="padding-right-5" id="AddOrRmvebtn" style="padding-left: 15px;">
					<button ng-click="addCredRow()" class="btn btn-sm btn-info"
						tooltip="Add Row" ng-disabled="" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="deleteCredRow()" class="btn btn-sm btn-danger"
						type="button" tooltip="Delete">
						<i class="fa  fa-trash-o"></i>
					</button>
				</div>
				
				</fieldset></div>
				

				<div class="table-responsive" >
				<div class="panel-body" style="border-top: none;">
					<div class="row pl2pc pr10pc">
						
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Total Packages </label>
								<div class="col-md-3 control-label">{{totalPackage}}</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Net Weight : </label>
								<div class="col-md-3 control-label">{{totalnetWeight}}</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Gross Weight : </label>
								<div class="col-md-3 control-label">{{totalgrossWeight}}</div>
							</div>
						</div>


					</div>
					<div class="row pl2pc pr10pc">
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Shipper </label>
								<div class="col-md-7">
									<textarea class="form-control input-sm"
										property="mabl.shipperAddress" ng-model="mabl.shipperAddress"
										name="Shipper" friendly-name="Shipper" rows="2"></textarea>



								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Consignee </label>
								<div class="col-md-7">
									<textarea class="form-control input-sm"
										property="mabl.addressAddress"
										ng-model="mabl.consigneeAddress" name="Consignee"
										friendly-name="Consignee" rows="2"></textarea>

								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Notify </label>
								<div class="col-md-7">
									<textarea class="form-control input-sm"
										property="mabl.notifyAddress" ng-model="mabl.notifyAddress"
										name="Notify" friendly-name="Notify" rows="2"></textarea>

								</div>
							</div>
						</div>


					</div>
					<div class="row pl2pc pr10pc">

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Place Of Receipt </label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.placeofReceipt"
										data-ng-model="mabl.placeofReceipt" name="Place Of Receipt"
										friendly-name="Place Of Receipt" />
								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Port of Load</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.portofLoad" data-ng-model="mabl.portofLoad"
										name="Port of Load" friendly-name="Port of Load" />
								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Movement</label>
								<div class="col-md-7">

									<selectivity list="movementList" property="mabl.movement"
										data-ng-model="mabl.movement" name="branch"
										form-name="mablForm" friendly-name="Movement"> </selectivity>


								</div>
							</div>
						</div>


					</div>
					<div class="row pl2pc pr10pc">
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Port of Discharge</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.portofDischarge"
										data-ng-model="mabl.portofDischarge" name="Port of Discharge"
										friendly-name="Port of Discharge" />

								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Port of Delivery</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.portofDelivery"
										data-ng-model="mabl.portofDelivery" name="Port of Delivery"
										friendly-name="Port of Delivery" />

								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Place of Delivery</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.placeofDelivery"
										data-ng-model="mabl.placeofDelivery" name="Place of Delivery"
										friendly-name="Place of Delivery" />

								</div>
							</div>
						</div>
					</div>
					<div class="row pl2pc pr10pc">


						<!-- <div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Signed at</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.signedAt" data-ng-model="mabl.signedAt"
										name="Signed at" friendly-name="Signed at" />

								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Signed by</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.signedBy" data-ng-model="mabl.signedBy"
										name="Signed by" friendly-name="Signed by" />
								</div>
							</div> -
						</div> -->
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label" style="text-align:left">Final Destination</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.finalDestination"
										data-ng-model="mabl.finalDestination" name="Final Destination"
										friendly-name="Final Destination" />
								</div>
							</div>
						</div>
					</div>
					<!-- <div class="row pl2pc pr10pc">
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Forwarding Agent
									Reference</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.forwardingAgentReferences"
										data-ng-model="mabl.forwardingAgentReferences"
										name="Forwarding Agent
								Reference"
										friendly-name="Forwarding Agent
								Reference" />
								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Cargo Insurance</label>
								<div class="col-md-7">
									<selectivity list="cargoList" property="mabl.cargoInsurance"
										data-ng-model="mabl.cargoInsurance" name="Cargo Insurance"
										form-name="mablForm" friendly-name="Cargo Insurance">
									</selectivity>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Container Number</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.containerNumber"
										data-ng-model="mabl.containerNumber" name="Container Number"
										friendly-name="Container Number" />
								</div>
							</div>
						</div>
					</div> -->
					<div class="row pl2pc pr10pc">
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Freight Payable at</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.freightPayableAt"
										data-ng-model="mabl.freightPayableAt"
										name="Freight Payable at" friendly-name="Freight Payable at" />
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">No of Original BL</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.noOfOriginalBl"
										data-ng-model="mabl.noOfOriginalBl" name="No of Original BL"
										friendly-name="No of Original BL" />
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Pre-Carriage By</label>
								<div class="col-md-7">
									<selectivity list="preCarriageList"
										property="mabl.preCarriagedBy"
										data-ng-model="mabl.preCarriagedBy" vlaidation="required"
										name="Pre-Carriage By" form-name="mablForm"
										friendly-name="Pre-Carriage By"> </selectivity>
								</div>
							</div>
						</div>
					</div>


					<!-- <div class="row pl2pc pr10pc">
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Consolidation
									Number</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.consolidationNumber"
										data-ng-model="mabl.consolidationNumber"
										name="Consolidation Number"
										friendly-name="Consolidation Number" />
								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Export References</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.exportReferences"
										data-ng-model="mabl.exportReferences" name="Export References"
										friendly-name="Export References" />

								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Shipper References</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.shipperReferences"
										data-ng-model="mabl.shipperReferences"
										name="Shipper References" friendly-name="Shipper References" />

								</div>
							</div>
						</div>
					</div> -->
					<!-- <div class="row pl2pc pr10pc">


						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">FTZ Number</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.ftzNumber" data-ng-model="mabl.ftzNumber"
										name="FTZ Number" friendly-name="FTZ Number" />


								</div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Loading
									Pier/Terminal</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.loadingPierTerminal"
										data-ng-model="mabl.loadingPierTerminal"
										name="Loading Pier/Terminal"
										friendly-name="Loading Pier/Terminal" />
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Co-Loaded With </label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										property="mabl.coLoadedWith "
										data-ng-model="mabl.coLoadedWith" name="Co-Loaded With "
										friendly-name="Co-Loaded With " />
								</div>
							</div>
						</div>
					</div> -->
					<div class="row pl2pc pr10pc">




						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Desination Agent
									Code</label>
								<div class="col-md-7">
									<selectivity list="destinationAgentList"
										property="mabl.destinationAgentCode"
										data-ng-model="mabl.destinationAgentCode"
										name="Desination Agent Code" form-name="mablForm"
										friendly-name="Desination Agent
								Code"> </selectivity>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left">Currency</label>
								<div class="col-md-7">
									<selectivity list="currencyList" property="mabl.currency"
										data-ng-model="mabl.currency" name="Currency"
										form-name="mablForm" friendly-name="Currency"> </selectivity>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"style="text-align:left; display:none">Containerized</label>
								<div class="col-md-7">
									<label class="i-checks m-b-none" style="display:none"> <input
										type="checkbox" ng-model="mabl.containarized"
										id="section{{trIndex}}"><i></i></label>
								</div>
							</div>
						</div>
					</div>
					<div class="row pl2pc pr10pc">
						<div class="col-md-3">
							<div class="form-group">
								<label class="control-label"
									style="font-weight: bold; color: black;">Freight
									Details</label>

							</div>
						</div>
					</div>
					<div class="table-responsive form-controller">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th class="sorting width_2">Select</th>
									<th class="sorting width_2">Charge Name </th>
									<th class="sorting width_2">Payment Mode </th>
									<th class="sorting width_3">Amount </th>
									<th class="sorting width_3">Show In Print</th>
									<th class="sorting width_3"></th>
									<th class="sorting width_3"></th>
									<th class="sorting width_3"></th>

									<th class="sorting width_3"></th>



								</tr>
							</thead>

							<tbody ng-repeat="($index,row) in lMablFreightBean">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
									<td>
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm"
													data-ng-model="row.chargeName"
													name="Charger Name{{trIndex}}" 
													friendly-name="{{ 'Row' + $index + '(Charger Name)'}}" />
											</div>
										</div>
									</td>


									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">
												<selectivity list="paymentList" property="row.paymentMode"
													data-ng-model="row.paymentMode"
													name="Payment Mode{{trIndex}}" 
													form-name="mablForm"
													friendly-name="{{ 'Row' + $index + '(Payment Mode)'}}">
												</selectivity>

											</div>
										</div>
									</td>
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">
												<input type="text" class="form-control input-sm"
													data-ng-model="row.amount"
													name="Amount{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Amount)'}}" />
											</div>
										</div>
									</td>
									<td class="width_10">
										<div class="row">
											<div class="col-xs-12">
												<label class="i-checks m-b-none"> <input
													type="checkbox" ng-model="row.print"
													id="section{{trIndex}}"><i></i></label>
											</div>
										</div>
									</td>
								</tr>
							</tbody>

						</table>
						<div class="padding-right-5" id="AddOrRmvebtn">
							<button ng-click="addFreightRow()" class="btn btn-sm btn-info"
								tooltip="Add Row" ng-disabled="" type="button">
								<i class="fa fa-plus"></i>
							</button>
							<button ng-click="removeFreightRow()"
								class="btn btn-sm btn-danger" type="button" tooltip="Delete">
								<i class="fa  fa-trash-o"></i>
							</button>
						</div>
					</div>

					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" ng-if="!isEdit" type="button"
									ng-click="save(mablForm)">
									<i class="fa fa-save"></i> Save
								</button>

								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="update(mablForm)">
									<i class="fa fa-save"></i> Update
								</button>
								
								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="printRow()">
									<i class="fa fa-print"></i> Print
										MBL
								</button>
								<%-- <security:authorize access="hasRole('F5578_${print}')">
								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="printBookingConfirmation()">
									<i class="fa fa-print"></i> Print
										Booking Confirmation
								</button>
								</security:authorize> --%>
								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="printManifest()">
									<i class="fa fa-print"></i> Print
										Manifest
								</button>
								<button class="btn btn-success" ng-if="isEdit" type="button"
									ng-click="printLoad()">
									<i class="fa fa-print"></i> Print
										Load List
								</button>
								<button class="btn btn-info" type="reset" ng-click="reset()"
									ng-if="!isEdit">
									<i class="fa fa-undo"></i> Reset
								</button>

								<button class="btn btn-info" ng-click="reset()" ng-if="isEdit">
									<i class="fa fa-undo"></i> Reset
								</button>

								<button class="btn btn-danger" ng-click="cancel()" type="button">
									<i class="fa fa-close"></i> Cancel
								</button>

							</div>

							<%-- <div class="row">
								<div class="col-md-12">
								<security:authorize access="hasRole('F5578_${print}')">	<a ng-click="printRow()" ng-show="isEdit"
										style="color: #0f1ece; text-decoration: underline;">Print
										MABL</a>
										</security:authorize>
										<security:authorize access="hasRole('F5578_${print}')"> <a ng-click="printManifest()" ng-show="isEdit"
										style="color: #0f1ece; text-decoration: underline;">Print
										Manifest</a>
										</security:authorize>
										<security:authorize access="hasRole('F5578_${print}')"> <a ng-click="printLoad()" ng-show="isEdit"
										style="color: #0f1ece; text-decoration: underline;">Print
										Load List</a>
										</security:authorize>
								</div>
							</div> --%>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
