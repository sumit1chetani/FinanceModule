
<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div style="width: 30%;position: absolute;margin-top: -33px;margin-left: 78%;">
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
			<div class="panel-body">
				<div class="row pl2pc pr10pc">
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">MBL No 
							</label>

							<div class="col-md-7">
								<label style="padding-top: 9px;padding-left: 10px;">{{mabl.mblCode}}</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">MBL Date 
							</label>
							<div class="col-md-7">
								<!-- <ng-bs3-datepicker data-ng-model="mabl.mblDate" id="mablDate" disabled="true"
									name="MBl Date" form-name="mablForm" friendly-name="MBl Date"
									validation="required" /> -->
									
							<label style="padding-top: 9px;padding-left: 10px;">{{mabl.mblDate}}</label>
									

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Type </label>
							<div class="col-md-7">
								<!-- <selectivity list="typeList" property="mabl.type" disabled="true"
									data-ng-model="mabl.type" name="MBL Type" validation="required"
									form-name="mablForm" friendly-name="MBL Type"> </selectivity>
 -->
							
												<label style="padding-top: 9px;padding-left: 10px;">{{mabl.type1}}</label>
							
							
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Customer </label>
							<div class="col-md-7">
							<!-- 	<selectivity list="customerList" property="mabl.customer"
									data-ng-model="mabl.customer" name="Customer" disabled="true"
									form-name="mablForm" friendly-name="Customer"> </selectivity>
 -->
 
 												<label style="padding-top: 9px;padding-left: 10px;">{{mabl.customer1}}</label>
 
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">POL 
							</label>
							<div class="col-md-7">
								<!-- <selectivity list="polList" property="mabl.pol" disabled="true"
									data-ng-model="mabl.pol" name="POL" validation="required"
									form-name="mablForm" friendly-name="POL"> </selectivity> -->
							
											<label style="padding-top: 9px;padding-left: 10px;">{{mabl.policdName}}</label>
							
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">POD </label>
							<div class="col-md-7">
								<!-- <selectivity list="podList" property="mabl.pod" disabled="true"
									data-ng-model="mabl.pod" name="POD" validation="required"
									form-name="mablForm" friendly-name="POD"> </selectivity> -->
						<label style="padding-top: 9px;padding-left: 10px;">{{mabl. aod1}}</label>
									
									
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Branch </label>
							<div class="col-md-7">

								<!-- <selectivity list="branchList" property="mabl.branch" disabled="true"
									data-ng-model="mabl.branch" name="branch" validation="required"
									form-name="mablForm" friendly-name="branch"> </selectivity>
 -->
 
 						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.branchName}}</label>
 

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Vendor</label>
							<div class="col-md-7">
								<!-- <selectivity list="customerList" property="mabl.vendor" validation="required"
									data-ng-model="mabl.vendor" name="Vendor" form-name="mablForm" disabled="true"
									friendly-name="Vendor"> </selectivity> -->
							
						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.vendorName}}</label>		
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Origin </label>
							<div class="col-md-7">
								<!-- <selectivity list="originList" property="mabl.origin" disabled="true"
									data-ng-model="mabl.origin" name="Origin" validation="required"
									form-name="mablForm" friendly-name="Origin"> </selectivity> -->

						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.orginName}}</label>		

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Destination</label>
							<div class="col-md-7">
								<!-- <selectivity list="destinationList" property="mabl.destination"
									data-ng-model="mabl.destination" name="Destination"
									validation="required" form-name="mablForm" disabled="true"
									friendly-name="Destination"> </selectivity> -->
									
								<label style="padding-top: 9px;padding-left: 10px;">{{mabl.destination1}}</label>		
									

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Term </label>
							<div class="col-md-7">
								<!-- <selectivity list="termList" property="mabl.term" disabled="true"
									data-ng-model="mabl.term" name="Term" form-name="mablForm"
									friendly-name="Term"> </selectivity> -->
								<label style="padding-top: 9px;padding-left: 10px;">{{mabl.term1}}</label>		

							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">


					

					
					<div class="col-md-3"></div>
				</div>
				
				
				<fieldset class="b-a width_100" style="top: 10px; padding-bottom: 10px; border: 1px solid #DDD">
									<legend class="width_9  b-a control-label;" style="margin-left: 1%;font-size: 15px; font-weight:bold;
 ">Job Details </legend>
				
				<div class="row pl2pc pr10pc" >
					<div class="col-md-18">
					<div class="table-responsive" ng-show="lMabljobDetailBean.length<=0"   style="padding-left: 33px;padding-bottom: 13px;">
					<div class="col-md-15">
					No Records found.
					</div>
					</div>
					
					
						<div class="table-responsive" ng-show="lMabljobDetailBean.length>0"   style="padding-left: 109px;">
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
												id="section{{trIndex}}"style="background-color: #c4c4d0;" disabled="true"><i></i></label></td>
										<td  width="10%">
										<div class="form-group col-md-3 col-lg-3"ng-if="isEdit">
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


					<div class="col-md-3"></div>
				</div>
				</fieldset>
				<br>
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
						<div class="form-group">
							<label class="col-md-5 control-label">MBL Doc No</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.mblDocNo" data-ng-model="mabl.mblDocNo"
									name="MBL Doc No" friendly-name="MBL Doc No" disabled="true" /> -->
									
												<label style="padding-top: 9px;padding-left: 10px;">{{mabl.mblDocNo}}</label>	
									
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">MBL Doc Date</label>
							<div class="col-md-7">
								<!-- <ng-bs3-datepicker data-ng-model="mabl.mblDocDate"
									id="mablDocDate" name="MBl Doc Date" form-name="mablForm"
									friendly-name="MBl Doc Date" disabled="true"/> -->
												<label style="padding-top: 9px;padding-left: 10px;">{{mabl.mblDocDate}}</label>	

							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Vessel Voyage</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.vesselVoyeage"
									data-ng-model="mabl.vesselVoyeage" name="Vessel Voyage"
									friendly-name="Vessel Voyage" disabled="true"/> -->
														<label style="padding-top: 9px;padding-left: 10px;">{{mabl.vesselVoyeage}}</label>	
									
									
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Feeder Vessel
								Voyage</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.feederVesselVoyeage"
									data-ng-model="mabl.feederVesselVoyeage"
									name="Feeder Vessel Voyage"
									friendly-name="Feeder Vessel Voyeage" disabled="true"/> -->
							
																		<label style="padding-top: 9px;padding-left: 10px;">{{mabl.feederVesselVoyeage}}</label>	
							
							
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">


					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">HBL Doc No</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.hblDocNo" data-ng-model="mabl.hblDocNo"
									name="HBL Doc No" friendly-name="HBL Doc No" disabled="true"/> -->
								<label style="padding-top: 9px;padding-left: 10px;">{{mabl.hblDocNo}}</label>	

							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">HBL Doc Date </label>
							<div class="col-md-7">
								<!-- <ng-bs3-datepicker data-ng-model="mabl.hblDocDate"
									id="hblDocDate" name="HBl Doc Date" form-name="mablForm"
									friendly-name="HBl Doc Date" disabled="true" /> -->
		<label style="padding-top: 9px;padding-left: 10px;">{{mabl.hblDocDate}}</label>	
							
							
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">ETD</label>
							<div class="col-md-7">
								<!-- <ng-bs3-datepicker data-ng-model="mabl.etd" id="etd" name="ETD"
									form-name="mablForm" friendly-name="ETD" disabled="true" /> -->
									
							<label style="padding-top: 9px;padding-left: 10px;">{{mabl.etd}}</label>	
									
							</div>
						</div>
					</div>
					
					
					
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">E.T.A at POD</label>
							<div class="col-md-7">
								<!-- <ng-bs3-datepicker data-ng-model="mabl.etaAtPod" id="etaPod"
									name="E.T.A at POD" form-name="mablForm"
									friendly-name=">E.T.A at POD" disabled="true"/> -->
							<label style="padding-top: 9px;padding-left: 10px;">{{mabl.etaAtPod}}</label>	
									
									
							</div>
						</div>
					</div>

				</div>
				<div class="row pl2pc pr10pc">




					
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-md-5 control-label">Agent</label>
							<div class="col-md-7">
								<!-- <ng-bs3-datepicker data-ng-model="mabl.etd" id="etd" name="ETD"
									form-name="mablForm" friendly-name="ETD" disabled="true" /> -->
									
							<label style="padding-top: 9px;padding-left: 10px;">{{mabl.agentName}}</label>	
									
							</div>
						</div>
					</div>
					
					
					
			

				</div>
				</fieldset>
				<br>
			<div style="padding: 0px 0px;border-bottom: none;border-top: none ;border-left: none;border-right: none;
    " class="panel-body" >
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
<!-- 							<th class="sorting width_2">Select</th>
 -->							<th class="sorting width_2">Container No</th>

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
							<!-- <td><label class="i-checks m-b-none"> <input
									type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td> -->
							<td>
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.containerNo" name="ContactName{{trIndex}}"
											ng-pattern-restrict="^[0-9.]*$"
											friendly-name="{{ 'Row' + $index + '(ContactName)'}}" disabled="true"/> -->
									
				<label style="padding-top: 9px;padding-left: 10px;">{{row.containerNo}}</label>						
									
									</div>
								</div>
							</td>


							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.sealNo" name="Designation{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Narration)'}}" disabled="true"/> -->
									
							<label style="padding-top: 9px;padding-left: 10px;">{{row.sealNo}}</label>						
									
									
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<!-- <selectivity list="sizeList" property="row.size"
											id="{{ 'Row' + $index + '(LandLineNo)'}}" ng-model="row.size"
											friendly-name="{{ 'Row' + $index + '(LandLineNo)'}}" disabled="true"></selectivity> -->
											
											
							<label style="padding-top: 9px;padding-left: 10px;">{{row.containersizeType}}</label>						

									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.marksAndNos" name="MobileNo{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(MobileNo)'}}" disabled="true"/> -->
											
																<label style="padding-top: 9px;padding-left: 10px;">{{row.marksAndNos}}</label>						
											
											
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
<!-- 										<input type="text" class="form-control input-sm"
											data-ng-model="row.cargoDescription" name="Skype{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Skype)'}}" disabled="true"/> -->
											
												<label style="padding-top: 9px;padding-left: 10px;">{{row.cargoDescription}}</label>						
											
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.noofPackage" name="Skype{{trIndex}}"
											ng-keyup="packageCalculation(row.noofPackage,trIndex,row)"
											friendly-name="{{ 'Row' + $index + '(Skype)'}}" disabled="true"/> -->
									
														<label style="padding-top: 9px;padding-left: 10px;">{{row.noofPackage}}</label>						
									
									
									</div>
								</div>
							</td>

							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.uOm" name="remarks{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(remarks)'}}" disabled="true"/> -->
									
																			<label style="padding-top: 9px;padding-left: 10px;">{{row.uom1}}</label>						
									
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.netWeight" name="ContactName{{trIndex}}"
											ng-keyup="netWeightCalculation(row.netWeight,trIndex,row)"
											friendly-name="{{ 'Row' + $index + '(ContactName)'}}" disabled="true" /> -->
											
							<label style="padding-top: 9px;padding-left: 10px;">{{row.netWeight}}</label>						
											
											
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.grossWeight" name="ContactName{{trIndex}}"
											ng-keyup="grossWeightCalculation(row.grossWeight,trIndex,row)"
											friendly-name="{{ 'Row' + $index + '(ContactName)'}}" disabled="true" /> -->
								<label style="padding-top: 9px;padding-left: 10px;">{{row.grossWeight}}</label>				
											
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.measureMent" name="ContactName{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(ContactName)'}}" disabled="true"/> -->
											
						<label style="padding-top: 9px;padding-left: 10px;">{{row.measureMent}}</label>				
											
											
									</div>
								</div>
							</td>
							<td>
								<div class="row">
									<div class="col-xs-12">
										<!-- <input type="text" class="form-control input-sm"
											data-ng-model="row.remarks" name="ContactName{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(ContactName)'}}" disabled="true"/> -->
									
								<label style="padding-top: 9px;padding-left: 10px;">{{row.remarks}}</label>				
									
									</div>
								</div>
							</td>
						</tr>
					</tbody>

				</table>
				</div>
				
			

				<div class="padding-right-5" id="AddOrRmvebtn" style="padding-left: 15px;">
					<!-- <button ng-click="addCredRow()" class="btn btn-sm btn-info"
						tooltip="Add Row" ng-disabled="" type="button">
						<i class="fa fa-plus"></i>
					</button> -->
					<!-- <button ng-click="deleteCredRow()" class="btn btn-sm btn-danger"
						type="button" tooltip="Delete">
						<i class="fa  fa-trash-o"></i>
					</button> -->
				</div>
				
				</fieldset></div>
				<br>
			<div class="panel-body" Style="border-top:none;border-left:none;border-right:none;border-bottom:none">
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Shipper </label>
							<div class="col-md-7">
								<textarea class="form-control input-sm" disabled="true"
									property="mabl.shipperAddress" ng-model="mabl.shipperAddress"
									name="Shipper" friendly-name="Shipper" rows="2"></textarea>



							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Consignee </label>
							<div class="col-md-7">
								<textarea class="form-control input-sm" disabled="true"
									property="mabl.addressAddress" ng-model="mabl.consigneeAddress"
									name="Consignee" friendly-name="Consignee" rows="2"></textarea>

							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Notify </label>
							<div class="col-md-7">
								<textarea class="form-control input-sm" disabled="true"
									property="mabl.notifyAddress" ng-model="mabl.notifyAddress"
									name="Notify" friendly-name="Notify" rows="2"></textarea>

							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Place Of Receipt </label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.placeofReceipt" disabled="true"
									data-ng-model="mabl.placeofReceipt" name="Place Of Receipt"
									friendly-name="Place Of Receipt" /> -->
									
					<label style="padding-top: 9px;padding-left: 10px;">{{mabl.placeofReceipt}}</label>				
									
									
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Port of Load</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm" disabled="true"
									property="mabl.portofLoad" data-ng-model="mabl.portofLoad"
									name="Port of Load" friendly-name="Port of Load" /> -->
									
						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.portofLoad}}</label>				
									
									
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Movement</label>
							<div class="col-md-7">

								<!-- <selectivity list="movementList" property="mabl.movement"
									data-ng-model="mabl.movement" name="branch" disabled="true"
									form-name="mablForm" friendly-name="Movement"> </selectivity> -->
						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.movement1}}</label>				


							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Port of Discharge</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.portofDischarge" disabled="true"
									data-ng-model="mabl.portofDischarge" name="Port of Discharge"
									friendly-name="Port of Discharge" /> -->
						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.portofDischarge}}</label>				

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Port of Delivery</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.portofDelivery" disabled="true"
									data-ng-model="mabl.portofDelivery" name="Port of Delivery"
									friendly-name="Port of Delivery" /> -->
						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.portofDelivery}}</label>				

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Place of Delivery</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.placeofDelivery" disabled="true"
									data-ng-model="mabl.placeofDelivery" name="Place of Delivery"
									friendly-name="Place of Delivery" /> -->
						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.placeofDelivery}}</label>				

							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">


					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Signed at</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm" disabled="true"
									property="mabl.signedAt" data-ng-model="mabl.signedAt"
									name="Signed at" friendly-name="Signed at" /> -->
						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.signedAt}}</label>				

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Signed by</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm" disabled="true"
									property="mabl.signedBy" data-ng-model="mabl.signedBy"
									name="Signed by" friendly-name="Signed by" /> -->
									
								<label style="padding-top: 9px;padding-left: 10px;">{{mabl.signedBy}}</label>				
									
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Final Destination</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.finalDestination" disabled="true"
									data-ng-model="mabl.finalDestination" name="Final Destination"
									friendly-name="Final Destination" /> -->
									
											<label style="padding-top: 9px;padding-left: 10px;">{{mabl.finalDestination}}</label>				
									
									
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Forwarding Agent
								Reference</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.forwardingAgentReference"
									data-ng-model="mabl.forwardingAgentReference"
									name="Forwarding Agent
								Reference" disabled="true"
									friendly-name="Forwarding Agent
								Reference" /> -->
								
						<label style="padding-top: 9px;padding-left: 10px;">{{mabl.forwardingAgentReference}}</label>				
								
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Cargo Insurance</label>
							<div class="col-md-7">
								<!-- <selectivity list="cargoList"
									property="mabl.cargoInsurance" disabled="true"
									data-ng-model="mabl.cargoInsurance" name="Cargo Insurance"
									form-name="mablForm" friendly-name="Cargo Insurance">
								</selectivity> -->
									<label style="padding-top: 9px;padding-left: 10px;">{{mabl.cargoInsurance}}</label>				
								
								
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Container Number</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.containerNumber" disabled="true"
									data-ng-model="mabl.containerNumber" name="Container Number"
									friendly-name="Container Number" /> -->
		<label style="padding-top: 9px;padding-left: 10px;">{{mabl.containerNumber}}</label>				
									
									
									
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Freight Payable at</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.freightPayableAt" disabled="true"
									data-ng-model="mabl.freightPayableAt" name="Freight Payable at"
									friendly-name="Freight Payable at" /> -->
									
			<label style="padding-top: 9px;padding-left: 10px;">{{mabl.freightPayableAt}}</label>				
									
									
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">No of Original BL</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.noOfOriginalBl" disabled="true"
									data-ng-model="mabl.noOfOriginalBl" name="No of Original BL"
									friendly-name="No of Original BL" /> -->
				<label style="padding-top: 9px;padding-left: 10px;">{{mabl.noOfOriginalBl}}</label>				
									
									
									
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Pre-Carriage By</label>
							<div class="col-md-7">
								<!-- <selectivity list="preCarriageList"
									property="mabl.precarrg" disabled="true"
									data-ng-model="mabl.preCarriagedBy" vlaidation="required"
									name="Pre-Carriage By" form-name="mablForm"
									friendly-name="Pre-Carriage By"> </selectivity> -->
									
			<label style="padding-top: 9px;padding-left: 10px;">{{mabl.precarrg}}</label>				
									
									
							</div>
						</div>
					</div>
				</div>


				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Consolidation
								Number</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.consolidationNumber" disabled="true"
									data-ng-model="mabl.consolidationNumber"
									name="Consolidation Number"
									friendly-name="Consolidation Number" /> -->
									
				<label style="padding-top: 9px;padding-left: 10px;">{{mabl.consolidationNumber}}</label>				
									
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Export References</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.exportReferences" disabled="true"
									data-ng-model="mabl.exportReferences" name="Export References"
									friendly-name="Export References" /> -->
									
								<label style="padding-top: 9px;padding-left: 10px;">{{mabl.exportReferences}}</label>				
									
									

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Shipper References</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.shipperReferences" disabled="true"
									data-ng-model="mabl.shipperReferences"
									name="Shipper References" friendly-name="Shipper References" /> -->
								<label style="padding-top: 9px;padding-left: 10px;">{{mabl.shipperReferences}}</label>				

							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">


					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">FTZ Number</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm" disabled="true"
									property="mabl.ftzNumber" data-ng-model="mabl.ftzNumber"
									name="FTZ Number" friendly-name="FTZ Number" /> -->
								<label style="padding-top: 9px;padding-left: 10px;">{{mabl.ftzNumber}}</label>				


							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Loading
								Pier/Terminal</label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm"
									property="mabl.loadingPierTerminal"
									data-ng-model="mabl.loadingPierTerminal"
									name="Loading Pier/Terminal" disabled="true"
									friendly-name="Loading Pier/Terminal" /> -->
									
				<label style="padding-top: 9px;padding-left: 10px;">{{mabl.loadingPierTerminal}}</label>				
									
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Co-Loaded With </label>
							<div class="col-md-7">
								<!-- <input type="text" class="form-control input-sm" disabled="true"
									property="mabl.coLoadedWith " data-ng-model="mabl.coLoadedWith"
									name="Co-Loaded With " friendly-name="Co-Loaded With " /> -->
				<label style="padding-top: 9px;padding-left: 10px;">{{mabl.coLoadedWith}}</label>				
									
									
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">




					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Desination Agent
								Code</label>
							<div class="col-md-7">
								<!-- <selectivity list="destinationAgentList"
									property="mabl.destinationAgent" disabled="true"
									data-ng-model="mabl.destinationAgent"
									name="Desination Agent Code" form-name="mablForm"
									friendly-name="Desination Agent
								Code"> </selectivity> -->
			<label style="padding-top: 9px;padding-left: 10px;">{{mabl.destinationAgentName}}</label>				
								
								
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Currency</label>
							<div class="col-md-7">
								<!-- <selectivity list="currencyList" property="mabl.currency"
									data-ng-model="mabl.currency" name="Currency" disabled="true"
									form-name="mablForm" friendly-name="Currency"> </selectivity> -->
				<label style="padding-top: 9px;padding-left: 10px;">{{mabl.currencyName}}</label>				
							
							
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label" style="display:none">Containerized</label>
							<div class="col-md-7" style="padding-top: 2%; display:none">
								<label>{{mabl.containarized}}<i></i></label>
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-3">
						<div class="form-group">
							<label class="control-label"
								style="font-weight: bold; color: black;">Freight Details</label>

						</div>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<!-- <th class="sorting width_2">Select</th> -->
								<th class="sorting width_2">Charge Name</th>
								<th class="sorting width_2">Payment Mode</th>
								<th class="sorting width_3">Amount</th>
								<th class="sorting width_3">Show In Print</th>
								<th class="sorting width_3"></th>
								<th class="sorting width_3"></th>
								<th class="sorting width_3"></th>

								<th class="sorting width_3"></th>



							</tr>
						</thead>

						<tbody ng-repeat="($index,row) in lMablFreightBean">
							<tr>
								<!-- <td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td> -->
								<td>
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm" disabled="true"
												data-ng-model="row.chargeName" name="ContactName{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(ContactName)'}}" /> -->
										
							<label style="padding-top: 9px;padding-left: 10px;">{{row.chargeName}}</label>							
										
										</div>
									</div>
								</td>


								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"
												data-ng-model="row.paymentm" disabled="true"
												name="Designation{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Narration)'}}" /> -->
												
									<label style="padding-top: 9px;padding-left: 10px;">{{row.paymentm}}</label>							
												
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm" disabled="true"
												data-ng-model="row.amount" name="LandLineNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(LandLineNo)'}}" /> -->
												
								<label style="padding-top: 9px;padding-left: 10px;">{{row.amount}}</label>							
												
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<label>{{row.print}} <i></i></label>
										</div>
									</div>
								</td>
							</tr>
						</tbody>

					</table>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<!-- <button  class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button> -->
						<!-- <button 
							class="btn btn-sm btn-danger" type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button> -->
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
					
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

							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>

						</div>
					</div>
				</div>
			</div>

		</form>
	</div>
</div>
5