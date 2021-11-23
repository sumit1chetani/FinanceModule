<style>
.main_container {
	overflow: auto;
}

.span-class {
	float: left;
	padding-top: 8px;
}

.datetimepicker {
	width: auto;
}

select {
	-webkit-appearance: none;
	padding: 0;
	text-indent: 8px;
	padding: 0 !important;
}

.input-group-addon {
	display: none !important;
}

.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
	{
	background-color: white !important;
	border: 0px !important;
}

.b-grey {
	border: 0px !important;
}

.sorting:after {
	display: none !important;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
							<form class="form-horizontal" name="PurchaseOrderForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-md-6">
											<fieldset ng-disabled="true">
												<div class="form-group">
													<label class="col-md-5 control-label"> Purchase
														Order No </label>
													<div class="col-md-4">
														<input type="text" class="form-control input-sm"
															data-ng-model="purchaseOrder.purchaseOrderNum">
													</div>
												</div>
								<!-- <div class="form-group">
				            <label class="col-md-5 control-label"> PO Type </label>
				            <div class="col-md-4">
				            <select class="form-control input-sm" id="POType" name="POType" 
				            data-ng-model="purchaseOrder.potype"
							        	data-ng-options="ac.id as ac.text for ac in potypelist"
							        	validation="required" friendly-name="POType">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div> -->
			             <div class="form-group">
				            <label class="col-md-5 control-label">Request Type<span style= "color:red">*</span></label>
				            <div class="col-md-4">
				            <select class="form-control input-sm" id="reqType" name="reqType" data-ng-model="purchaseOrder.reqType"
							        	data-ng-options="ac.id as ac.text for ac in requestTypeDropDown" ng-disabled = "type">
						     </select>
				            </div>
			             </div>
						<div class="form-group" ng-if = "po_req_Type">
				            <label class="col-md-5 control-label"> PO Type <span style= "color:red">*</span></label>
				            <div class="col-md-4">
				            <select class="form-control input-sm" id="POType" name="POType" 
				            data-ng-model="purchaseOrder.potype"
							        	data-ng-options="ac.id as ac.text for ac in potypelist"
							        	validation="required" friendly-name="PO Type" ng-disabled = "type">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
				            </div>
				            
				            <div class="form-group" ng-if = "!po_req_Type">
				            <label class="col-md-3 control-label"> WO Type <span style= "color:red">*</span></label>
				            <div class="col-md-7">
				            <select class="form-control input-sm" id="woType" name="woType" 
				            data-ng-model="purchaseOrder.potype"
							        	data-ng-options="ac.id as ac.text for ac in requestTypeOrderDropDown"
							        	validation="required" friendly-name="WO Type" ng-disabled = "isEdit">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div>
						<div class="form-group" ng-if = "budgetType">
				            <label class="col-md-5 control-label"> Budget Type</label>
				            <div class="col-md-4">				          
						     <selectivity list="budgetTypeList" property="purchaseOrder.budgetType" id="budgetType"
	        				ng-model="purchaseOrder.budgetType" name="budgetType" form-name = "PurchaseOrderForm"
	        				validation="required" friendly-name="budgetType" disabled = "true"></selectivity>
				            </div>
			             </div>
												<div class="form-group">
													<label class="col-md-5 control-label"> Purchase For
													</label>
													<div class="col-md-4">
														<select class="form-control input-sm" id="purchaseFor"
																name="purchaseFor" data-ng-model="purchaseOrder.purchaseFor"
																data-ng-options="ac.id as ac.text for ac in requestTypeDropDownnew"
																ng-disabled="true">
															</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-5 control-label"> Organization
													</label>
													<div class="col-md-4">
														<select class="form-control input-sm" id="hospital"
															name="hospital" data-ng-model="purchaseOrder.companyId"
															data-ng-options="ac.id as ac.text for ac in hospitalList">
															<option value="" selected="selected">--Select--</option>
														</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-5 control-label"> Destination
														Location </label>
													<div class="col-md-7">
														<select class="form-control input-sm" id="location"
															name="location" data-ng-model="purchaseOrder.locationId"
															data-ng-options="ac.id as ac.text for ac in addressList"
															ng-change="loadDestAddress()">
															<option value="" selected="selected">--Select--</option>
														</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-5 control-label"> Destination
														Address </label>
													<div class="col-md-6">
														<div class="col-md-12 b b-grey no-padding">
															<label class="col-md-12 control-label"
																style="text-align: left !important">
																{{purchaseData.desAddress}}, {{purchaseData.desCity}} ,
																{{purchaseData.desState}},{{purchaseData.desZipcode}} ,
																{{purchaseData.desCountry}}.</label>
														</div>
													</div>
												</div>

											</fieldset>
										</div>

										<div class="col-md-6">
											<fieldset ng-disabled="true">
											<div class="form-group">
							            <label class="col-md-3 control-label">PO Number
							            </label>
							            <div class="col-md-7">
							             <input class="text-left form-control input-sm" ng-model="purchaseOrder.purchaseOrderNum" readonly/>
							            </div>
							            
							            <!--  <span class="pull-left line-height-30">Days</span> -->
							        </div>	
												<div class="form-group">
													<label class="col-md-3 control-label"> PO Date </label>
													<div class="col-md-4">
														<div class='input-group date width_100 datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="curDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="currentDate"
																			data-validator="required" data-valid-method="submit"
																			data-message-id="currentDate"
																			data-ng-model="purchaseOrder.purchaseOrderDate"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="purchaseOrder.purchaseOrderDate"
																		data-on-set-time="purchaseOrder.purchaseOrderDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label"> Purchase
														Type </label>
													<div class="col-md-4">
														<select class="form-control input-sm" id="purchaseType"
																name="purchaseType" data-ng-model="purchaseOrder.purchaseType"
																data-ng-options="ac.id as ac.text for ac in purchaseTypeListNew"
																disabled="true">
															</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label"> Vendor </label>
													<div class="col-md-4">
														<select class="form-control input-sm" id="Vendor"
															name="Vendor" data-ng-model="vendor"
															data-ng-options="ac as ac.text for ac in vendorList"
															ng-change="loadVendorAddress()">
															<option value="" selected="selected">--Select--</option>
														</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label"> Status </label>
													<div class="col-md-4">
														<select class="form-control input-sm" id="Status"
															name="Status" data-ng-model="purchaseOrder.statusId"
															data-ng-options="ac.id as ac.text for ac in statusList"
															disabled>
															<option value="" selected="selected">Approved</option>
														</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label"> Vendor
														Address </label>
													<div class="col-md-6">
														<div class="col-md-12 b b-grey no-padding">
															<label class="col-md-12 control-label"
																style="text-align: left !important">
																{{purchaseData.desAddress1}}, {{purchaseData.desCity1}}
																,
																{{purchaseData.desState1}},{{purchaseData.desZipcode1}}
																, {{purchaseData.desCountry1}}.</label>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Cost Center
														<span style="color: red;">*</span>
													</label>
													<div class="col-md-6">

														<selectivity list="costList"
															ng-model="purchaseOrder.costcenter"
															property="purchaseOrder.costcenter" id="costcenter"
															object="costcenter" name="costcenter"
															validation="required" friendly-name="Cost Center"
															form-name="PurchaseOrderForm" disabled = "true"></selectivity>

													</div>
												</div>
												<div class="form-group" ng-if="!isRecmnd">
													<label class="col-md-3 control-label "> Advance </label>
													<div class="col-md-6">
														<input type="text" class="form-control input-sm"
															data-ng-model="purchaseOrder.advanceamt" readonly>
													</div>
												</div>
												<div class="form-group" ng-if="!isRecmnd">
													<label class="col-md-3 control-label "> Remarks </label>
													<div class="col-md-6">
														<textarea disbaled class="text-left form-control input-sm"
															data-ng-model="purchaseOrder.remarks" rows="4" cols="20"
															style="resize: none" disabled> </textarea>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Currency </label>
													<div class="col-md-6">

														<selectivity list="currencyList"
															ng-model="purchaseOrder.currency"
															property="purchaseOrder.currency" id="currency"
															object="currency" name="currency"
															friendly-name="Currency" 
															disabled = "true"
															form-name="PurchaseOrderForm" > </selectivity>

													</div>
													<!--  <span class="pull-left line-height-30">Days</span> -->
												</div>
											</fieldset>
										</div>

										<div class="col-md-12">
											<fieldset>
												<div class="form-group">
													<label class="col-md-2 control-label margin-left-4-2">
														Terms & Conditions </label> <label class="col-md-9 control-label"
														style="text-align: left;">{{purchaseOrder.termsCondition}}</label>
												</div>

												<div class="form-group">
													<label class="col-md-2 control-label margin-left-4-2">
														Remarks </label> <label class="col-md-9 control-label"
														style="text-align: left;">{{purchaseOrder.remarks}}</label>
												</div>
												<div class="form-group">
													<label class="col-md-2 control-label margin-left-4-2">
														Payment Terms </label> <label class="col-md-9 control-label"
														style="text-align: left;">{{purchaseOrder.paymentTerms}}</label>
												</div>

						</div>
											</fieldset>
										</div>

										<div class="col-sm-12 col-md-12 col-lg-12"
											ng-if="purchaseOrder.purchaseTypeName != 'Rate Contract'">
											<br>
											<div role="content">
												<div class="widget-body no-padding">
													<div class="table-responsive">
														<div class="col-md-12" style="width: 150%;">

															<div
																class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
																data-st-table="displayedCollectionItem"
																data-st-safe-src="rowCollectionItem">
																<table id="dt_basic"
																	class="table table-striped table-bordered table-hover dataTable no-footer"
																	role="grid" aria-describedby="dt_basic_info">
																	<thead class="dataTables-Main-Head">
																		<tr>
																			<th class="sorting width_10">Purchase
																				Requisition Number</th>

																			<th class="sorting width_10">Item Code-Item
																				Name</th>
																			<th class="sorting width_8">Item Description</th>

																			<th class="sorting width_4">EDD</th>
																			<th class="sorting width_2">Purchase UOM</th>
																			<th class="sorting width_1">Purchase Qty</th>
																			<th class="sorting width_2">Vendor UOM</th>
																			<th class="sorting width_1">Vendor Qty</th>
																			<th class="sorting width_4">Unit Price</th>
																			<th class="sorting width_4">Old Unit Price</th>
																			<th class="sorting width_4">Price</th>
																			<th class="sorting width_2">Discount</th>
																			<th class="sorting width_8">Cost Center</th>
																			
																			<!-- <th class="sorting width_7" >Tax</th> -->
																			<th class="sorting width_2" data-st-sort="tax">CGST</th>
																			<th class="sorting width_2" data-st-sort="tax">SGST</th>
																			<th class="sorting width_2" data-st-sort="tax">IGST</th>
																			<th class="sorting width_2">CGST(%)</th>
																			<th class="sorting width_2">SGST(%)</th>
																			<th class="sorting width_2">IGST(%)</th>
																			<th class="sorting width_4">Total</th>
																			<!-- <th class="sorting width_8" >Sub Total</th> -->
																			<!-- <th class="sorting width_10" data-st-sort="">Item Description</th> -->
																			<!-- <th class="sorting width_7" data-st-sort="">Vendor Item Name</th> -->
																			<!--  <th class="sorting width_7" data-st-sort="">Delivery Lead Time</th> -->
																			<%-- <th class="width_8 table-heading text-center"><spring:message code="label.action"></spring:message></th> --%>
																		</tr>
																	</thead>
																	<tbody class="dataTables-Main-Body">
																		<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																			ng-repeat="departmentCollections in displayedCollectionItem"
																			ng-hide="departmentCollections.edit == '2'">
																			<td>{{departmentCollections.requisitionNo}}</td>

																			<td>{{departmentCollections.purchaseItemName}}</td>
																			<td title={{departmentCollections.purchaseItemDesc}}>{{departmentCollections.purchaseItemDesc}}</td>

																			<td>{{departmentCollections.edd}}</td>
																			<td>{{departmentCollections.purchaseUOMName}}</td>
																			<td>{{departmentCollections.purchaseQty}}</td>
																				
																			<td>{{departmentCollections.uomName}}</td>
																			<td
																				ng-init="calculateTaxDiscount(departmentCollections)"
																				style="text-align: right;">{{departmentCollections.quantity}}</td>
																			<td style="text-align: right;">{{departmentCollections.unitPrice}}</td>
																			<td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
																			<td style="text-align: right;">{{departmentCollections.price}}</td>
																			<!-- <td style="text-align: right;">{{departmentCollections.discount}}</td>
			           <td style="text-align: right;">{{departmentCollections.tax}}</td>
			            -->
																			<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountAmount}}</td>
<!-- 																			<td style="text-align: right;">{{departmentCollections.costcenter}}</td>
 -->																		<td style="text-align: right;"><selectivity list="costList"
																					ng-model="departmentCollections.costcenter"
																					property="departmentCollections.costcenter"
																					id="costcenter" name="costcenter"
																					friendly-name="{{ 'Row' + ($index+1) + '(costcenter)'}}"
																					form-name="purchaseQuoteRequestForm" disabled="true"></selectivity>
																			</td>	
																			<!-- <td style="text-align: right;">{{departmentCollections.tax}}</td> -->
																			<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGST}}</td>
																			<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGST}}</td>
																			<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGST}}</td>
																			<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGSTinPercent}}</td>
																			<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGSTinPercent}}</td>
																			<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGSTinPercent}}</td>
																			<td style="text-align: right;">{{departmentCollections.finalTotal}}</td>
																			<!--  <td style="text-align: right;">{{departmentCollections.finalTotal}}</td>
			           <td style="text-align: right;">{{departmentCollections.purchaseStatus}}</td> -->
																			<!-- <td>{{departmentCollections.purchaseItemDesc}}</td> -->
																			<!-- <td>{{departmentCollections.vendorName}}</td> -->
																			<!--  <td>{{departmentCollections.deliveryLeadTime}}</td> -->
																			<!-- <td class=" td-actions text-center">
					        <span>
					         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(departmentCollections)"></i>
					        </span>
					        <span>
					         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(departmentCollections)"></i>
					        </span>
			       </td> -->
																		</tr>
																	</tbody>
																</table>
																<!-- 			        <div class="dt-toolbar-footer" -->
																<!-- 			         data-smart-include="views/layout/toolbar-footer.tpl"></div> -->
															</div>
														</div>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<br>
										</div>

										<div class="col-md-12"
											ng-if="purchaseOrder.purchaseTypeName != 'Rate Contract'">
											<div class="form-group">
												<label class="col-md-1 control-label"> SubTotal :</label> <span
													class="span-class">{{purchaseOrder.subTotal}}</span> <label
													class="col-md-2 control-label"> Discount :</label> <span
													class="span-class">{{purchaseOrder.totalDiscount}}</span>
												<!-- <label class="col-md-2 control-label"> Tax :</label>
        				<span class="span-class">{{purchaseOrder.totalTax}}</span> -->
												<label class="col-md-2 control-label"> Tax CGST :</label> <span
													class="span-class">{{purchaseOrder.totalTaxCGST}}</span> <label
													class="col-md-2 control-label"> Tax SGST :</label> <span
													class="span-class">{{purchaseOrder.totalTaxSGST}}</span> <label
													class="col-md-2 control-label"> Tax IGST :</label> <span
													class="span-class">{{purchaseOrder.totalTaxIGST}}</span> <label
													class="col-md-2 control-label"> Freight :</label> <span
													class="span-class">{{purchaseOrder.freight}}</span> <br>
<label
													class="col-md-2 control-label"> Freight Tax (%) :</label> <span
													class="span-class">{{purchaseOrder.freightTax}}</span>
													<label 
													class="col-md-2 control-label">  Freight Total: </label> <span
													class="span-class">{{purchaseOrder.freightAmount}}</span><br>
												<label class="col-md-2 control-label"> Other Charges
													:</label> <span class="span-class">{{purchaseOrder.otherCharges}}</span>

												<label class="col-md-2 control-label" > Total :</label> <span
													class="span-class">{{purchaseOrder.totalAmount}}</span>
											</div>
												<br>
						<br>
						<br>
						<div class="form-group" ng-repeat="group in gstGroup" style="padding-left: 80%;color: black;">
	        				<label class="col-md-8 control-label"> {{group.gstgroupbyPercent}}  </label>
	        		
	  <span class="span-class">:  {{group.gstAmtgroupbyPercent}}</span>
	  
						</div>
						<div class="form-group" style="padding-left: 80%;color: black;">
						<label class="col-md-8 control-label"> Total </label>
						<span class="span-class">: {{purchaseOrder.totalAmount}}</span>
        				
						</div>
										</div>






										<div class="col-sm-12 col-md-12 col-lg-12"
											ng-if="purchaseOrder.purchaseTypeName == 'Rate Contract'">
											<tabset justified="true" class="tab-container"> <tab
												heading="Order Status">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollectionItem"
														data-st-safe-src="rowCollectionItem">
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="sorting width_10">Item Code-Item Name</th>
																	<th class="sorting width_6">EDD</th>
																	<th class="sorting width_6">UOM</th>
																	<th class="sorting width_5">Qty</th>
																	<th class="sorting width_7"
																		style="padding: 0 !important; line-height: 34px;">Unit
																		Price</th>
																	<th class="sorting width_7">Old Unit Price</th>
																	<th class="sorting width_8">Price</th>
																	<th class="sorting width_10">Discount Type</th>
																	<th class="sorting width_8"
																		style="padding: 0 !important; line-height: 34px;">Discount</th>
																	<!--  <th class="sorting width_7" >Tax Type</th>
					           <th class="sorting width_7" >Tax</th> -->
																	<th class="sorting width_7" data-st-sort="tax">CGST</th>
																	<th class="sorting width_7" data-st-sort="tax">SGST</th>
																	<th class="sorting width_7" data-st-sort="tax">IGST</th>

																	<th class="sorting width_8">Total</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	ng-repeat="departmentCollections in displayedCollectionItem">
																	<td>{{departmentCollections.purchaseItemName}}</td>
																	<td>{{departmentCollections.edd}}</td>
																	<td>{{departmentCollections.uomName}}</td>
																	<td
																		ng-init="calculateTaxDiscount(departmentCollections)">{{departmentCollections.quantity}}</td>
																	<td style="text-align: right;">{{departmentCollections.unitPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.price}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td>
																	<!-- <td  style="text-align: right;">{{departmentCollections.discount}}</td>
					           <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCode}}</td>
					           <td  style="text-align: right;">{{departmentCollections.tax}}</td> -->
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountAmount}}</td>
																	<!-- <td style="text-align: right;">{{departmentCollections.tax}}</td> -->
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGST}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGST}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGST}}</td>

																	<td style="text-align: right;">{{departmentCollections.finalTotal}}</td>
																	<!--  <td>{{departmentCollections.purchaseStatus}}</td> -->
																</tr>
															</tbody>
														</table>
													</div>
													<div class="form-group padding-top-20">

														<label class="col-md-1 control-label"> SubTotal :</label>
														<span class="span-class">{{purchaseOrder.subTotal}}</span>
														<label class="col-md-2 control-label"> Discount :</label>
														<span class="span-class">{{purchaseOrder.totalDiscount}}</span>
														<!-- <label class="col-md-2 control-label"> Tax :</label>
        				<span class="span-class">{{purchaseOrder.totalTax}}</span> -->
														<label class="col-md-1 control-label"> Tax CGST:</label>
														<div class="col-md-1">
															<input type="text" class="form-control input-sm"
																ng-model="purchaseOrder.totalTaxCGST" readonly
																style="text-align: right; padding-right: 0; padding-left: 0;">
														</div>
														<label class="col-md-1 control-label"> Tax SGST:</label>
														<div class="col-md-1">
															<input type="text" class="form-control input-sm"
																ng-model="purchaseOrder.totalTaxSGST" readonly
																style="text-align: right; padding-right: 0; padding-left: 0;">
														</div>
														<label class="col-md-1 control-label"> Tax IGST:</label>
														<div class="col-md-1">
															<input type="text" class="form-control input-sm"
																ng-model="purchaseOrder.totalTaxIGST" readonly
																style="text-align: right; padding-right: 0; padding-left: 0;">
														</div>

														<label class="col-md-2 control-label"> Freight :</label> <span
															class="span-class">{{purchaseOrder.freight}}</span> <label
															class="col-md-2 control-label"> Total :</label> <span
															class="span-class">{{purchaseOrder.totalAmount}}</span>



														<!-- <label class="col-md-1 control-label"> SubTotal </label>
		        				<div class="col-md-1">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.subTotal" readonly  style="text-align:">
								</div>
		        				<label class="col-md-1 control-label"> Discount </label>
		        				<div class="col-md-1">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalDiscount" readonly  style="text-align: right;padding-right: 40px; padding-left: 0;">
								</div>
		        				<label class="col-md-1 control-label"> Tax </label>
		        				<div class="col-md-1">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalTax" readonly  style="text-align: right;padding-right: 40px;padding-left: 0;">
								</div>
								<label class="col-md-1 control-label"> Freight </label>
		        				<div class="col-md-1">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.freight"  readonly style="text-align: right;padding-right: 31px;padding-left: 0;">
								</div>
								<label class="col-md-1 control-label"> Total </label>
		        				<div class="col-md-1">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalAmount" readonly  style="text-align: right;padding-right: 31px;padding-left: 0;">
								</div> -->
													</div>
												</div>
												<!-- /WIDGET-BODY -->
											</div>
											</tab> <tab heading="Delivery Schedule">
											<div data-st-safe-src="rowCollectionDeliveryItem">
												<table
													class="table table-striped table-bordered table-hover dataTable no-footer">
													<thead class="dataTables-Main-Head">
														<tr>
															<th class="width_1 table-heading text-center"><label
																class="i-checks m-b-none"> <input
																	type="checkbox" ng-model="chkAll"
																	ng-change="qtchkAllfun(rowCollectionDeliveryItem,chkAll)">
																	<i></i>
															</label></th>
															<th class="sorting width_7">Item Name</th>
															<th class="sorting width_10">Delivery Schedule</th>
															<th class="sorting width_8">Quantity</th>
														</tr>
													</thead>
													<tbody>
														<tr ng-controller="parentCtrl"
															data-ng-repeat="(trIndex,departmentCollectionsDelivery) in rowCollectionDeliveryItem"
															ng-hide="departmentCollectionsDelivery.edit == '2'">
															<td><label class="i-checks m-b-none"> <input
																	type="checkbox"
																	data-ng-model="departmentCollectionsDelivery.select">
																	<i></i>
															</label></td>
															<td class="width_15"><select
																class="form-control input-sm" id="item" name="item"
																data-ng-model="departmentCollectionsDelivery.itemId"
																data-ng-options="ac.id as ac.text for ac in itemList"
																disabled>
																	<option value="" selected="selected">--Select--</option>
															</select></td>
															<td class="width_10"><input type="text"
																ng-model="departmentCollectionsDelivery.purchaseOrderDeliveryDate"
																class="control-label" placeholder="0" readonly>
															</td>
															<td class="width_15"><input type="text"
																ng-model="departmentCollectionsDelivery.quantity"
																class="control-label" placeholder="0" readonly>
															</td>
														</tr>
													</tbody>
												</table>

											</div>
											</tab> </tabset>
										</div>


									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i>Cancel
											</button>
										</div>
									</div>
								</div>
</form>						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>