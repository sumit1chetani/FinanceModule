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
</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
		
							<form class="form-horizontal" name="PurchaseOrderAmendment"
								novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="col-md-6">
												<fieldset ng-disabled="false">
													<%-- 	<div class="form-group">
        				<label class="col-md-5 control-label"> Purchase Order No
        				<spring:message
              			code="label.asterisk.symbol"></spring:message></label>
        				<div class="col-md-4">
							<input type="text" class="form-control input-sm">
						</div>
						</div> --%>
													<%-- <div class="form-group">
				            <label class="col-md-3 control-label"> PO Type <spring:message code="label.asterisk.symbol"></spring:message></label>
				            <div class="col-md-7">
				            <select class="form-control input-sm" id="POType" name="POType" 
				            data-ng-model="purchaseOrder.potype"
							        	data-ng-options="ac.id as ac.text for ac in potypelist"
							        	validation="required" friendly-name="POType">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div> --%>
													<div class="form-group">
														<label class="col-md-3 control-label">Request Type</label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="reqType"
																name="reqType" data-ng-model="purchaseOrder.reqType"
																data-ng-options="ac.id as ac.text for ac in requestTypeDropDown"
																ng-disabled = "type">
															</select>
														</div>
													</div>
													<div class="form-group" ng-if="po_req_Type">
														<label class="col-md-3 control-label"> PO Type </label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="POType"
																name="POType" data-ng-model="purchaseOrder.potype"
																data-ng-options="ac.id as ac.text for ac in potypelist"
																validation="required" friendly-name="PO Type"
																ng-disabled = "type">
																<option value="" selected="selected">--Select--</option>
															</select>
														</div>
													</div>

													<div class="form-group" ng-if="!po_req_Type">
														<label class="col-md-3 control-label"> WO Type </label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="woType"
																name="woType" data-ng-model="purchaseOrder.potype"
																data-ng-options="ac.id as ac.text for ac in requestTypeOrderDropDown"
																validation="required" friendly-name="WO Type"
																ng-disabled = "type">
																<option value="" selected="selected">--Select--</option>
															</select>
														</div>
													</div>
													<div class="form-group" ng-if="budgetType">
														<label class="col-md-3 control-label"> Budget Type
														</label>
														<div class="col-md-7">
															<selectivity list="budgetTypeList"
																property="purchaseOrder.budgetType" id="budgetType"
																ng-model="purchaseOrder.budgetType" name="budgetType"
																form-name="PurchaseOrderForm" validation="required"
																friendly-name="budgetType" ng-disabled = "type"></selectivity>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 control-label"> Purchase
															For </label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="purchaseFor"
																name="purchaseFor" data-ng-model="purchaseOrder.purchaseFor"
																data-ng-options="ac.id as ac.text for ac in requestTypeDropDownnew"
																ng-disabled = "type">
															</select>
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-3 control-label">
															Organization 
														</label>
														<div class="col-md-7">
															<!-- <selectivity list="hospitalList"
																property="purchaseOrder.companyId" id="hospital"
																ng-model="purchaseOrder.companyId" name="hospital"
																form-name="PurchaseOrderForm" disabled="true"
																validation="required" friendly-name="Hospital"></selectivity> -->
																
																
																<selectivity list="companyList"
																property="purchaseOrder.companyId" id="company"
																ng-model="purchaseOrder.companyId" name="Organization"
																form-name="PurchaseOrderForm" validation="required"
																friendly-name="Organization"></selectivity>
															<!-- <select class="form-control input-sm" id="hospital" name="hospital" data-ng-model="purchaseOrder.companyId"
							        	data-ng-options="ac.id as ac.text for ac in hospitalList">
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
														</div>
													</div>

													<div class="form-group" disabled="false">
														<label class="col-md-3 control-label"> Destination
															Location </label>
														<div class="col-md-7">
															<!-- <selectivity list="addressList"
																property="purchaseOrder.locationId"
																ng-model="purchaseOrder.locationId" name="destination"
																form-name="PurchaseOrderForm" validation="required"
																friendly-name="Destination" id="location"
																object="location"></selectivity> -->
																
																<selectivity list="destinationList"
																property="purchaseOrder.locationId" id="locationId"
																ng-model="purchaseOrder.locationId" name="locationId"
																form-name="PurchaseOrderForm" validation="required"
																friendly-name="Destination Location" object="location"></selectivity>
																
															<!-- <select class="form-control input-sm" id="location" name="location" data-ng-model="location"
							        	data-ng-options="ac as ac.text for ac in destinationList" ng-change="loadDestAddress()">
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-3 control-label"> Destination
															Address </label>
														<div class="col-md-7">
															<div class="col-md-12 no-padding">
																<textarea class="text-left form-control input-sm"
																	rows="2" cols="15" style="resize: none" readonly=""
																	ng-model="purchaseData.desAddress"> </textarea>
															</div>
															<div class="col-md-12 no-padding">
																<div class="col-md-5 no-padding padding-top-5">
																	<input type="text"
																		class="form-control input-sm ng-pristine"
																		placeholder="city" ng-model="purchaseData.desCity"
																		readonly="">
																</div>
																<div
																	class="col-md-4 no-padding padding-left-5 padding-top-5">
																	<input type="text" class="form-control input-sm "
																		placeholder="state" ng-model="purchaseData.desState"
																		readonly="">
																</div>
																<div
																	class="col-md-3 no-padding padding-left-5 padding-top-5">
																	<input type="text" class="form-control input-sm"
																		placeholder="zip" ng-model="purchaseData.desZipcode"
																		readonly="">
																</div>
															</div>
															<div class="col-md-12 no-padding padding-top-5">
																<input type="text" class="form-control input-sm"
																	placeholder="country"
																	ng-model="purchaseData.desCountry" readonly>
															</div>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 control-label "> Terms &
															Conditions </label>
														<div class="col-md-7">
															<textarea class="text-left form-control input-sm "
																name="disabled" ng-model="purchaseOrder.termsCondition"
																rows="4" cols="20" style="resize: none"
																validation="max_len:500|required"
																friendly-name="Terms & Conditions"> </textarea>
														</div>
													</div>
												</fieldset>

												<div class="form-group">
													<label class="col-md-4 control-label"
														style="margin-left: -53px;"> Reason For Amendment
													</label>
													<div class="col-md-7">
														<textarea class="text-left form-control input-sm"
															name="reason_for_amendment"
															data-ng-model="purchaseOrder.reason_for_amendment"
															rows="4" cols="20" style="resize: none"> </textarea>
													</div>
												</div>



											</div>

											<div class="col-md-6">
												<fieldset ng-disabled="false">
													<div class="form-group">
														<label class="col-md-4 control-label">PO Number </label>
														<div class="col-md-7">
															<input class="text-left form-control input-sm"
																ng-model="purchaseOrder.purchaseOrderNum" readonly />
														</div>

														<!--  <span class="pull-left line-height-30">Days</span> -->
													</div>
													<div class="form-group">
														<label class="col-md-4 control-label"> PO Date </label>
														<div class="col-md-7">
															<!-- <div class='input-group datetimepick col-md-12'>
																<div class="dropdown">
																	<a class="dropdown-toggle" id="curDate" role="button"
																		data-toggle="dropdown" data-target="#" href="#">
																		<div class="input-group">
																			<input type="text" class="form-control"
																				placeholder="dd/mm/yyyy" name="currentDate"
																				validation="date_euro_long|required"
																				friendly-name="Purchase Order Date"
																				data-ng-model="purchaseOrder.purchaseOrderDate"><span
																				class="input-group-addon"><i
																				class="glyphicon glyphicon-calendar"></i></span>
																		</div>
																	</a>
																	<ul class="dropdown-menu" role="menu"
					              aria-labelledby="dLabel">
					              <datetimepicker data-ng-model="purchaseOrder.purchaseOrderDate"
					               data-on-set-time="purchaseOrder.purchaseOrderDate = onDateSet(newDate)"
					               data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
					             </ul>
																</div>
															</div> -->
															
															<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="purchaseOrder.purchaseOrderDate"
										id="Purchase Order Date" name="Purchase Order Date"
										data-ng-change="checkDatesCL(purchaseOrder.purchaseOrderDate)"
										friendly-name="Purchase Order Date"  />
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label"> Purchase
															Type </label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="purchaseType"
																name="purchaseType" data-ng-model="purchaseOrder.purchaseType"
																data-ng-options="ac.id as ac.text for ac in purchaseTypeListNew"
																ng-disabled = "type">
															</select>
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label"> Status </label>
														<div class="col-md-7">
															<!-- <label>A</label> -->

															<!-- <select class="form-control input-sm " id="Status"
																name="Status" data-ng-model="purchaseOrder.statusId"
																data-ng-options="ac.id as ac.text for ac in statusList"
																ng-disabled = "type">
																<option value="" selected="selected">--Select--</option>
															</select> -->
															
															<select class="form-control input-sm ng-valid ng-dirty ng-valid-parse ng-touched" ng-model="addQuoteList.status">
	              	<option value="">Select</option>
	              	<option value="1">Pending</option>
					<option value="2">Approved</option>
					<option value="3">Rejected</option>
	              </select>
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label"> Vendor </label>
														<div class="col-md-7">
															<selectivity list="vendorList"
																ng-model="purchaseOrder.vendorId"
																property="purchaseOrder.vendorId" id="vendor"
																object="vendor" name="vendor" validation="required"
																friendly-name="vendor" form-name="PurchaseOrderForm"></selectivity>
															<!-- 	<select class="form-control input-sm" id="Vendor" name="Vendor" data-ng-model="vendor"
							        	data-ng-options="ac as ac.text for ac in vendorList" ng-change="loadVendorAddress()">
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
														</div>
													</div>


													<div class="form-group">
														<label class="col-md-4 control-label"> Vendor
															Address </label>
														<div class="col-md-7">
															<div class="col-md-12 no-padding">
																<textarea class="text-left form-control input-sm"
																	rows="2" cols="15" style="resize: none" readonly
																	ng-model="purchaseData.desAddress1"> </textarea>
															</div>
															<div class="col-md-12 no-padding">
																<div class="col-md-5 no-padding padding-top-5">
																	<input type="text" class="form-control input-sm"
																		placeholder="city" readonly
																		ng-model="purchaseData.desCity1">
																</div>
																<div
																	class="col-md-4 no-padding padding-left-5 padding-top-5">
																	<input type="text" class="form-control input-sm"
																		placeholder="state" ng-model="purchaseData.desState1"
																		readonly>
																</div>
																<div
																	class="col-md-3 no-padding padding-left-5 padding-top-5">
																	<input type="text" class="form-control input-sm"
																		placeholder="zip" ng-model="purchaseData.desZipcode1"
																		readonly>
																</div>
															</div>
															<div class="col-md-12 no-padding padding-top-5">
																<input type="text" class="form-control input-sm"
																	placeholder="country"
																	ng-model="purchaseData.desCountry1" readonly>
															</div>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-4 control-label"> Cost Center
															<span style="color: red;">*</span>
														</label>
														<div class="col-md-7">

															<selectivity list="costList"
																ng-model="purchaseOrder.costcenter"
																property="purchaseOrder.costcenter" id="costcenter"
																object="costcenter" name="costcenter"
																validation="required" friendly-name="Cost Center"
																form-name="PurchaseOrderForm"></selectivity>

														</div>
													</div>
													<div class="form-group">
														<label class="col-md-4 control-label"> Remarks </label>
														<div class="col-md-7">
															<textarea class="text-left form-control input-sm"
																name="remarks" data-ng-model="purchaseOrder.remarks"
																rows="1" cols="20" style="resize: none"> </textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-4 control-label">Advance </label>
														<div class="col-md-7">
															<input class="text-right form-control input-sm"
																ng-model="purchaseOrder.advanceamt" />
														</div>
														<!--  <span class="pull-left line-height-30">Days</span> -->
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">Currency </label>
														<div class="col-md-7">

															<selectivity list="currencyList"
																ng-model="purchaseOrder.currency"
																property="purchaseOrder.currency" id="costcenter"
																object="currency" name="currency"
																friendly-name="Currency" form-name="PurchaseOrderForm"></selectivity>

														</div>
														<!--  <span class="pull-left line-height-30">Days</span> -->
													</div>
										
											</div></fieldset></div></div>




											<!-- <div class="col-sm-12 col-md-12 col-lg-12 ">
											<div role="content" >
												<div class="panel-body">
												<div >
													<div class="table-responsive" >
															<div
																class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
																data-st-table="displayedCollectionItem"
																data-st-safe-src="rowCollectionItem">
																<table id="dt_basic"
																	class="table table-striped table-bordered table-hover dataTable no-footer"
																	role="grid" aria-describedby="dt_basic_info"  style="width: 220%;">
																	<thead class="dataTables-Main-Head"> -->
																	
																	<div class="row">
										
																	<div class="table-responsive" >
															<div
																class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
																data-st-table="displayedCollectionItem"
																data-st-safe-src="rowCollectionItem">
																<table id="dt_basic"
																	class="table table-striped table-bordered table-hover dataTable no-footer"
																	role="grid" aria-describedby="dt_basic_info"  style="width: 220%;">
																	<thead class="dataTables-Main-Head">
																	
																	
																			<tr>
																				<!--  <th class="width_1 table-heading text-center">
			            <label class="i-checks m-b-none">
			             <input type="checkbox">
			             <i></i>
			            </label>
			           </th> -->
																				<th class="width_1 table-heading text-center">
																					<label class="i-checks m-b-none"> <input
																						type="checkbox" ng-model="selectedAll"
																						ng-change="checkAll(displayedCollectionItem,selectedAll)">
																						<i></i>
																				</label>
																				</th>
																				<th class="sorting width_8">Purchase
																					Requisition Number</th>
																				<th class="sorting width_10">Item Code-Item
																					Name</th>
																				<th class="sorting width_8">Item Description</th>

																				<th class="sorting width_4">EDD</th>
																				<th class="sorting width_2">Purchase UOM</th>
																				<th class="sorting width_1">Purchase Qty</th>
																				
																				<th class="sorting width_4">Vendor UOM</th>
																				<th class="sorting width_1">Vendor Qty</th>
																				<th class="sorting width_4"
																					style="padding: 0 !important; line-height: 34px;">Unit
																					Price</th>
																				<th class="sorting width_4">Price</th>
																				<th class="sorting width_6">Discount Type</th>
																				<th class="sorting width_6"
																					style="padding: 0 !important; line-height: 34px;">Discount
																					(%) or (Amt)</th>
																				<!-- <th class="sorting width_8"  style="padding: 0 !important;line-height: 34px;">Discount(%)</th>
			            -->
																				<!--   <th class="sorting width_7" >Tax Type</th> -->
																				<!--  <th class="sorting width_7" >Tax</th> -->
																				<th class="sorting width_8"
																					style="padding: 0 !important; line-height: 34px;">Discount</th>
																					
																			<th class="sorting width_8"
																					style="padding: 0 !important; line-height: 34px;">Cost Center</th>
																				<th class="sorting width_4">Net Price</th>
																				<th class="sorting width_2">CGST(%)</th>
																				<th class="sorting width_2">SGST(%)</th>
																				<th class="sorting width_2">IGST(%)</th>
																				<th class="sorting width_2">TaxCGST</th>
																				<th class="sorting width_2">TaxSGST</th>
																				<th class="sorting width_2">TaxIGST</th>

																				<th class="sorting width_4">Total</th>
																				<!--  <th class="sorting width_8" >pending Qty</th> -->
																			</tr>
																		</thead>
																		<tbody class="dataTables-Main-Body">
																			<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																				ng-repeat="departmentCollections in displayedCollectionItem"
																				ng-hide="departmentCollections.edit == '2'">
																				<!-- <td ng-init="display = departmentCollections.quantity == departmentCollections.pendingQnty ? false : true ">
			           <label class="i-checks m-b-none" ng-hide='display' >
			             <input type="checkbox" ng-model="departmentCollections.isSelected">
			             <i></i>
			            </label></td> -->
																				<td><label class="i-checks m-b-none">
																						<input type="checkbox"
																						ng-model="departmentCollections.select"> <i></i>
																				</label></td>
																				<td>{{departmentCollections.requisitionNo}}</td>

																				<td>{{departmentCollections.purchaseItemName}}</td>
																				<td title={{departmentCollections.purchaseItemDesc}}>{{departmentCollections.purchaseItemDesc}}</td>
																				<td>{{departmentCollections.edd}}</td>
																				<td>{{departmentCollections.purchaseUOMName}}</td>
																				<td>{{departmentCollections.purchaseQty}}</td>
																		<!-- 		<td>{{departmentCollections.uomName}}</td> -->
																		<td><selectivity list="uomCategoryList"
																				property="departmentCollections.uom" id="purchaseUOM{{trIndex}}"
																				ng-model="departmentCollections.uom" name="purchaseUOM{{trIndex}}"
																				friendly-name="{{ 'Row' + $index + '(purchase UOM)'}}"
																				form-name="purchaseQuoteRequestForm"></selectivity>
																				<!-- {{departmentCollections.uomName}} --></td>
																				<td><input type="text"
																					style="text-align: right; width: 50px;"
																					class="form-control input-sm"
																					ng-model="departmentCollections.quantity"
																					ng-blur="calculateTaxDiscountEdit(departmentCollections,$index,'')"
																					placeholder="0" style="width:40px;"
																					ng-init="calculateTaxDiscount(departmentCollections,$index)"
																					name="{{ 'quantity' + $index }}" maxlength="5"
																					validation="required"
																					friendly-name="{{ 'Row' + $index + '(Quantity)'}}"
																					ng-disabled="departmentCollections.pendingQnty == '0'"
																					ng-pattern-restrict="^[0-9.]*$"></td>
																				<!-- <td  style="text-align: right;">{{departmentCollections.unitPrice}}</td> -->
																				<td><input type="text"
																					style="text-align: right;"
																					class="form-control input-sm"
																					ng-model="departmentCollections.unitPrice"
																					ng-blur="calculateTaxDiscountEdit(departmentCollections,$index,'')"
																					placeholder="0" style="width:40px;"
																					ng-init="calculateTaxDiscount(departmentCollections,$index)"
																					name="{{ 'unitPrice' + $index }}"
																					validation="required"
																					friendly-name="{{ 'Row' + $index + '(unitPrice)'}}"
																					ng-disabled="departmentCollections.pendingQnty == '0'"
																					phonenumbers-only></td>

																				<td style="text-align: right;">{{departmentCollections.price}}</td>
																				<!--  <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td> -->
																				<td><selectivity
																						"
					list="discountTypeList"
																						ng-model="departmentCollections.quoteTaxDetail.discountType"
																						property="departmentCollections.quoteTaxDetail.discountType"
																						id="discountType" name="discountType"
																						friendly-name="{{ 'Row' + ($index+1) + '(discountType)'}}"
																						form-name="purchaseQuoteRequestForm"></selectivity>
																				</td>


																				<td><input type="text"
																					style="text-align: right;"
																					class="form-control input-sm" id="discount"
																					name="{{ 'Discount' + ($index)}}"
																					ng-model="departmentCollections.discount"
																					ng-blur="calculateTaxDiscountEdit(departmentCollections,$index,'')"
																					friendly-name="{{ 'Row' + ($index+1) + '(Discount)'}}"
																					ng-pattern-restrict="^[0-9]*$"></td>
																				<td><input type="text"
																					style="text-align: right;"
																					class="form-control input-sm" id="discount1"
																					name="{{ 'Discount1' + ($index)}}"
																					ng-model="departmentCollections.discount1"
																					ng-blur="calculateTaxDiscountEdit(departmentCollections,$index,'')"
																					friendly-name="{{ 'Row' + ($index+1) + '(Discount1)'}}"
																					readonly></td>
																					
																					<td><selectivity
																						"
					list="costList"
																						ng-model="departmentCollections.costcenter"
																						property="departmentCollections.costcenter"
																						id="costcenter" name="costcenter"
																						friendly-name="{{ 'Row' + ($index+1) + '(costcenter)'}}"
																						form-name="purchaseQuoteRequestForm"></selectivity>
																				</td>
																					
																				<!--  <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountAmount}}</td>
			           	  -->

																				<!--        	 <td  style="text-align: right;"  ng-if = "departmentCollections.discountType == 58 || discountTaxDetail.discountType == 'Amount'"><input type="text"
					class="form-control input-sm" id="discount"
						name="{{ 'discountAmount' + ($index)}}"
						ng-model="departmentCollections.discountAmount" 
						friendly-name="{{ 'Row' + ($index+1) + '(discountAmount)'}}">
						</td>
						<td  style="text-align: right;"  ng-if = "departmentCollections.discountType == 59 || discountTaxDetail.discountType == 'Percentage'"><input type="text" 
					class="form-control input-sm" id="dicountPercentage"
						name="{{ 'dicountPercentage' + ($index)}}"
						ng-model="departmentCollections.dicountPercentage" 
						friendly-name="{{ 'Row' + (trIndex+1) + '(dicountPercentage)'}}">
						</td> -->
																				<!-- <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.dicountPercentage}}</td>
			            -->
																				<!-- <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCode}}</td> -->
																				<!-- <td  style="text-align: right;">{{departmentCollections.tax}}</td> -->

																				<td style="text-align: right;">{{departmentCollections.netPrice}}</td>
																				<td><input type="text"
																					style="text-align: right; width: 50px;"
																					class="form-control input-sm" id="taxCGSTinPercent"
																					ng-blur="calculateTaxDiscountEdit(departmentCollections,$index,'CGST')"
																					name="{{ 'taxCGSTinPercent' + ($index)}}"
																					ng-model="departmentCollections.quoteTaxDetail.taxCGSTinPercent"
																					friendly-name="{{ 'Row' + ($index+1) + '(taxCGSTinPercent)'}}"
																					ng-pattern-restrict="^[0-9.]*$"></td>
																				<td><input type="text"
																					style="text-align: right; width: 50px;"
																					class="form-control input-sm" id="taxSGSTinPercent"
																					ng-blur="calculateTaxDiscountEdit(departmentCollections,$index,'SGST')"
																					name="{{ 'taxSGSTinPercent' + ($index)}}"
																					ng-model="departmentCollections.quoteTaxDetail.taxSGSTinPercent"
																					friendly-name="{{ 'Row' + ($index+1) + '(taxSGSTinPercent)'}}"
																					ng-pattern-restrict="^[0-9.]*$"></td>
																				<td><input type="text"
																					style="text-align: right; width: 50px;"
																					class="form-control input-sm" id="taxIGSTinPercent"
																					ng-blur="calculateTaxDiscountEdit(departmentCollections,$index,'')"
																					name="{{ 'taxIGSTinPercent' + ($index)}}"
																					ng-model="departmentCollections.quoteTaxDetail.taxIGSTinPercent"
																					friendly-name="{{ 'Row' + ($index+1) + '(taxIGSTinPercent)'}}"
																					ng-pattern-restrict="^[0-9.]*$"></td>


																				<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGST}}</td>
																				<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGST}}</td>
																				<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGST}}</td>
																				<!--             <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGSTinPercent}}</td>
			            <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGSTinPercent}}</td>
			            <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGSTinPercent}}</td>	 -->


																				<td style="text-align: right;">{{departmentCollections.finalTotal}}</td>
																				<!--  <td  style="text-align: right;">{{departmentCollections.pendingQnty}}</td> -->
																				<!-- <td>{{departmentCollections.purchaseStatus}}</td> -->
																				<!-- <td>{{departmentCollections.purchaseItemDesc}}</td> -->
																				<!-- <td>{{departmentCollections.vendorName}}</td> -->
																				<!--  <td>{{departmentCollections.deliveryLeadTime}}</td> -->
																			</tr>
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
													</div>
													<!-- end widget content -->
												</div>
												<div class="padding-left-10 padding-top-35"
													id="AddOrRmveMeritbtn">
													<button ng-click="addPurchaseRow()"
														class="btn btn-sm btn-primary" tooltip="Add"
														ng-disabled="" type="button">
														<i class="fa fa-plus"></i>
													</button>
													<button ng-click="removePurchaseRow()"
														class="btn btn-sm btn-danger" type="button"
														tooltip="Delete">
														<i class="fa  fa-trash-o"></i>
													</button>
												</div>
											</div>

											<div class="col-md-12" style="margin-top: 10px;">
												<div class="form-group">
													<label class="col-md-1 control-label"> SubTotal :</label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-model="purchaseOrder.subTotal" readonly
															style="text-align: right; padding-right: 0;">
													</div>
													<label class="col-md-1 control-label"> Discount :</label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-model="purchaseOrder.totalDiscount"
															style="text-align: right; padding-right: 0;">
													</div>
													<!-- <label class="col-md-1 control-label"> Tax :</label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.totalTax" readonly
														style="text-align: right; padding-right: 0; padding-left: 0;">
												</div> -->
													<label class="col-md-1 control-label"> Tax CGST:</label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-model="purchaseOrder.totalTaxCGST"
															style="text-align: right; padding-right: 0; padding-left: 0;">
													</div>
													<label class="col-md-1 control-label"> Tax SGST:</label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-model="purchaseOrder.totalTaxSGST"
															style="text-align: right; padding-right: 0; padding-left: 0;">
													</div>
													<label class="col-md-1 control-label"> Tax IGST:</label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-model="purchaseOrder.totalTaxIGST"
															style="text-align: right; padding-right: 0; padding-left: 0;">
													</div>
													<!-- <label class="col-md-1 control-label"> Freight </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"    ng-pattern-restrict="^[0-9.]*$" ng-model="purchaseOrder.freight"  style="text-align: right;padding-right: 0;">
						</div> -->

													<label class="col-md-1 control-label"
														style="padding-left: 12px"> Freight: </label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-pattern-restrict="^[0-9.]*$"
															ng-model="purchaseOrder.freight"
															ng-blur="TOtalCal1(purchaseOrder.freight)"
															placeholder="0"
															style="text-align: right; padding-right: 0;">
													</div>
													<br> <br> <br> <label
														class="col-md-1 control-label" style="padding-left: 12px">
														Freight Tax (%) : </label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-pattern-restrict="^[0-9.]*$"
															ng-model="purchaseOrder.freightTax"
															ng-blur="TOtalCal1(purchaseOrder.freightTax)"
															placeholder="0"
															style="text-align: right; padding-right: 0;">
													</div>

													<label class="col-md-1 control-label"
														style="padding-left: 12px"> Freight Total: </label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-pattern-restrict="^[0-9.]*$"
															ng-model="purchaseOrder.freightAmount"
															ng-blur="TOtalCal1(purchaseOrder.freightAmount)"
															placeholder="0"
															style="text-align: right; padding-right: 0;" readonly>
													</div>

													<label class="col-md-1 control-label"
														style="padding-left: 12px"> Other Charges: </label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-pattern-restrict="^[0-9.]*$"
															ng-model="purchaseOrder.otherCharges" placeholder="0"
															style="text-align: right; padding-right: 0;">
													</div>
													<!-- <br> -->

													<label class="col-md-1 control-label"
														style="padding-left: 12px"> Remarks : </label>
													<div class="col-md-3">
														<textarea class="text-left form-control input-sm"
															name="remarks for OtherCharges"
															data-ng-model="purchaseOrder.remarksforother" rows="1"
															cols="20" style="resize: none"> </textarea>
													</div>
													<!-- <br> -->
													<label class="col-md-1 control-label"> Total :</label>
													<div class="col-md-1">
														<input type="text" class="form-control input-sm"
															ng-model="purchaseOrder.totalAmount" readonly
															style="text-align: right; padding-right: 0;">
													</div>

													<br> <br> <br>
													<div class="form-group" ng-repeat="group in gstGroup"
														style="padding-left: 80%; color: black;">
														<label class="col-md-8 control-label">
															{{group.gstgroupbyPercent}} </label> <label class="span-class"
															style="padding-top: 8px;">:
															{{group.gstAmtgroupbyPercent}}</label>

													</div>
													<div class="form-group"
														style="padding-left: 80%; color: black;">
														<label class="col-md-8 control-label"> Total </label> <label
															class="span-class" style="padding-top: 8px;">:
															{{purchaseOrder.totalAmount}}</label>

													</div>



												</div>

											</div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<!-- <button class="btn btn-success" type="button"
            class="btn btn-success"
            data-ng-click="validate(PurchaseOrderForm,purchaseOrder)"
            
            data-ng-if="!isEdit">
           <i class="fa fa-save"></i>
				Request For Approval
           </button> -->
											<!-- data-ng-click="save(PurchaseOrderForm,purchaseOrder)" -->
											<button class="btn btn-success" type="button"
												class="btn btn-success" id="update"
												data-ng-click="validate(PurchaseOrderForm,purchaseOrder);">
												<!-- data-ng-if="isEdit == true" -->

												<i class="fa fa-save"></i> Update
											</button>
											<%-- <button class="btn btn-info" type="button"
            class="btn btn-success" data-ng-hide="isEdit == true"
            data-ng-click="reset(PurchaseOrderForm);">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button> --%>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i>Cancel
											</button>
										</div>
									</div>
								</div>
							</form>
						</div>
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