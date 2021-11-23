<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
							<form class="form-horizontal" name="PurchaseOrderForm" novalidate
								method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="col-md-6">
												<fieldset>
													<%-- 	<div class="form-group">
        				<label class="col-md-5 control-label"> Purchase Order No
        				<spring:message
              			code="label.asterisk.symbol"></spring:message></label>
        				<div class="col-md-4">
							<input type="text" class="form-control input-sm">
						</div>
						</div> --%>

													<div class="form-group">
														<label class="col-md-3 control-label">
															Organization Name <span style="color:red";>* </span>
														</label>
														<div class="col-md-7">
															<selectivity list="hospitalList"
																property="purchaseOrder.companyId" id="hospital"
																ng-model="purchaseOrder.companyId" name="Organization"
																form-name="PurchaseOrderForm" validation="required"
																friendly-name="Organization"></selectivity>
															<!-- <select class="form-control input-sm" id="hospital" name="hospital" data-ng-model="purchaseOrder.companyId"
							        	data-ng-options="ac.id as ac.text for ac in hospitalList">
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 control-label">Request Type<span style="color:red";>* </span></label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="reqType"
																name="reqType" data-ng-model="purchaseOrder.reqType"
																data-ng-options="ac.id as ac.text for ac in requestTypeDropDown"
																ng-disabled="type">
															</select>
														</div>
													</div>
													<div class="form-group" ng-if="po_req_Type">
														<label class="col-md-3 control-label"> PO Type<span style="color:red";>* </span></label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="POType"
																name="POType" data-ng-model="purchaseOrder.potype"
																data-ng-options="ac.id as ac.text for ac in potypelist"
																validation="required" friendly-name="PO Type"
																ng-disabled="type">
																<option value="" selected="selected">--Select--</option>
															</select>
														</div>
													</div>

													<div class="form-group" ng-if="!po_req_Type">
														<label class="col-md-3 control-label"> WO Type <span style="color:red";>* </span></label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="woType"
																name="woType" data-ng-model="purchaseOrder.potype"
																data-ng-options="ac.id as ac.text for ac in requestTypeOrderDropDown"
																validation="required" friendly-name="WO Type"
																ng-disabled="isEdit">
																<option value="" selected="selected">--Select--</option>
															</select>
														</div>
													</div>
													<div class="form-group" ng-if="budgetType">
														<label class="col-md-3 control-label"> Budget Type
														<span style = "color:red";>*</span>
														</label>
														<div class="col-md-7">
															<selectivity list="budgetTypeList"
																property="purchaseOrder.budgetType" id="budgetType"
																ng-model="purchaseOrder.budgetType" name="budgetType"
																form-name="PurchaseOrderForm" validation="required"
																friendly-name="budgetType"></selectivity>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 control-label"> Purchase
															For <span style="color:red";>* </span>
														</label>
														<div class="col-md-7">
														
														
															<select class="form-control input-sm" id="purchaseFor"
																name="purchaseFor" data-ng-model="purchaseOrder.purchaseFor"
																data-ng-options="ac.id as ac.text for ac in requestTypeDropDownnew"
																ng-disabled="purchaseFor">
															</select>
														
															
<!-- 															<select class="form-control input-sm" id="purchaseFor"
																name="purchaseFor" data-ng-model="purchaseOrder.purchaseFor"
																data-ng-options="ac.id as ac.text for ac in purchaseForList"
																ng-disabled="type">
															</select>
 -->														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 control-label"> Status </label>
														<div class="col-md-7">
															<label style="margin-top: 7px; margin-bottom: 0px;">Pending</label>

															<!-- <select class="form-control input-sm hide" id="Status" name="Status" data-ng-model="purchaseOrder.statusId"
							        	data-ng-options="ac.id as ac.text for ac in statusList" disabled>
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
														</div>
													</div>


													<div class="form-group">
														<label class="col-md-3 control-label"> Destination
															Location <spring:message code="label.asterisk.symbol"></spring:message>
														</label>
														<div class="col-md-7">
															<selectivity list="addressList"
																property="purchaseOrder.locationId" id="locationId"
																ng-model="purchaseOrder.locationId" name="locationId"
																form-name="PurchaseOrderForm" validation="required"
																friendly-name="Destination Location" object="location"></selectivity>
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
														<label class="col-md-3 control-label">Terms &
															Conditions<span style="color:red";>* </span>
														</label>
														<div class="col-md-7">
															<textarea class="text-left form-control input-sm "
																name="disabled" ng-model="purchaseOrder.termsCondition"
																rows="4" cols="20" style="resize: none"
																validation="max_len:800|required"
																friendly-name="Terms & Conditions"> </textarea>
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-3 control-label"> Payment
															Terms </label>
														<div class="col-md-5">
															<input class="text-right form-control input-sm"
																ng-model="purchaseOrder.paymentTerms" />
														</div>
														<span class="pull-left line-height-30">Days</span>
													</div>
													<!-- <div class="form-group">
							            <label class="col-md-3 control-label"> Delivery Schedule
							            </label>
							            <div class="col-md-5">
							             <input class="text-right form-control input-sm" ng-model="purchaseOrder.deleiverySchedule" />
							            </div>
							        </div>	 -->
											</div>

											<div class="col-md-6">

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
																			data-ng-model="purchaseOrder.purchaseOrderDate"
																			ng-disabled="isEdit"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel" ng-if="!isEdit">
																	<datetimepicker
																		data-ng-model="purchaseOrder.purchaseOrderDate"
																		data-on-set-time="purchaseOrder.purchaseOrderDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div> -->
														
														<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="purchaseOrder.purchaseOrderDate"
										id="curDate" name="Purchase Order Date"
										data-ng-change="checkDatesCL(purchaseOrder.purchaseOrderDate)" 
										friendly-name="Purchase Order Date" validation="required" />
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Purchase
														Type </label>
													<div class="col-md-7">
														
														<select class="form-control input-sm" id="purchaseType"
																name="purchaseType" data-ng-model="purchaseOrder.purchaseType"
																data-ng-options="ac.id as ac.text for ac in purchaseTypeListNew"
																disabled="true">
															</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Vendor <span style = "color:red";> * </span>
													</label>
													<div class="col-md-7">
														<selectivity list="vendorList"
															property="purchaseOrder.vendorId" name="vendorId"
															ng-model="purchaseOrder.vendorId" validation="required"
															friendly-name="Vendor" form-name="PurchaseOrderForm"
															id="vendorId" object="vendor" ng-show="isEdit == false"></selectivity>

														<selectivity list="vendorList"
															property="purchaseOrder.vendorId" name="vendorId"
															ng-model="purchaseOrder.vendorId" disabled="true"
															validation="required" friendly-name="Vendor"
															form-name="PurchaseOrderForm" id="vendorId"
															object="vendor" ng-show="isEdit == true"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Vendor
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
															rows="4" cols="20" style="resize: none"> </textarea>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Advance </label>
													<div class="col-md-7">
														<input class="text-right form-control input-sm"
															ng-model="purchaseOrder.advanceamt"
															ng-pattern-restrict="^[0-9.]*$" />
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

											</div>
										</fieldset>
										<!-- <fieldset>
        		<div class="col-sm-12 col-md-12 col-lg-12"><br>
        		<div role="content">
			      <div class="widget-body no-padding"> -->
										<div class="col-sm-12 col-md-12 col-lg-12 ">
											<div role="content" >
												<!-- <div class="panel-body"> -->
												<div >
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
																			<th class="width_1 table-heading text-center"><label
																				class="i-checks m-b-none"> <input
																					type="checkbox" ng-model="selectedAll"
																					ng-change="checkAll(displayedCollectionItem,selectedAll)">
																					<i></i>
																			</label></th>
																			<th class="sorting width_10">Purchase
																				Requisition Number</th>
																			<th class="sorting width_10">Item Code-Item
																				Name</th>
																			<!--    <th class="sorting width_10" >Purchase Quote Number</th> -->

																			<th class="sorting width_8">Item Description</th>
																			<th class="sorting width_2">EDD</th>
																			<th class="sorting width_2">Purchase UOM</th>
																			<th class="sorting width_1">Purchase Qty</th>
																			<th class="sorting width_5">Vendor UOM</th>
																			<th class="sorting width_1">Vendor Qty</th>
																			<th class="sorting width_1">Available Qty</th>
																			<th class="sorting width_4"
																				style="padding: 0 !important; line-height: 34px;">Unit
																				Price</th>
																			<th class="sorting width_4">Old Unit Price</th>
																			<th class="sorting width_5">Price</th>
																			<th class="sorting width_6">Discount Type</th>
																			<th class="sorting width_4"
																				style="padding: 0 !important; line-height: 34px;">Discount</th>
																			<th class="sorting width_2"
																				style="padding: 0 !important; line-height: 34px;">Discount(%)</th>

																			<!--   <th class="sorting width_7" >Tax Type</th>
			           <th class="sorting width_7" >Tax</th> -->		<th class="sorting width_8">Cost Center</th>
			           
																			<th class="sorting width_4">Net Price</th>
																			<th class="sorting width_4">CGST</th>
																			<th class="sorting width_4">SGST</th>
																			<th class="sorting width_4">IGST</th>
																			<th class="sorting width_2">CGST(%)</th>
																			<th class="sorting width_2">SGST(%)</th>
																			<th class="sorting width_2">IGST(%)</th>
																			<th class="sorting width_5">Total</th>
																		</tr>
																	</thead>
																	<tbody class="dataTables-Main-Body">
																		<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																			ng-controller="parentCtrl"
																			ng-repeat="departmentCollections in displayedCollectionItem track by $index"
																			ng-hide="departmentCollections.edit == '2'">
																			<td><label class="i-checks m-b-none"> <input
																					type="checkbox"
																					ng-model="departmentCollections.select"> <i></i>
																			</label></td>
																			<td>{{departmentCollections.requisitionNo}}</td>
																			<td>{{departmentCollections.purchaseItemName}}</td>
																			<!-- <td>{{departmentCollections.purchaseQuoteId}}</td> -->

																			<td title={{departmentCollections.purchaseItemDesc}}>{{departmentCollections.purchaseItemDesc}}</td>
																			<td>{{departmentCollections.edd}}</td>
																			<td>{{departmentCollections.purchaseUOMName}}</td>
																			<td>{{departmentCollections.purchaseQty}}</td>
																				<td><selectivity list="uomCategoryList"
																				property="departmentCollections.uom" id="purchaseUOM{{trIndex}}"
																				ng-model="departmentCollections.uom" name="purchaseUOM{{trIndex}}"
																				friendly-name="{{ 'Row' + $index + '(purchase UOM)'}}"
																				form-name="purchaseQuoteRequestForm"></selectivity>
																				<!-- {{departmentCollections.uomName}} --></td>


																			<!--  <td><input type="text" style="text-align: right;" ng-model="departmentCollections.quantity" ng-blur="checkPartiallyVerified(departmentCollections)" 
			           placeholder="0" style="width:40px;" 
			           ng-blur="calculateTaxDiscountEdit(departmentCollections)" 
			           ng-pattern-restrict="^[0-9.]*$"			           
			           ng-init="calculateTaxDiscount(departmentCollections)" 
			           maxlength="5" ng-pattern-restrict="{{numExp}}" ng-keyup="validateQty(departmentCollections.quantity,$index);"
			           name="{{ 'quatity' + $index }}"
			           validation="required" friendly-name="{{ 'Row' + $index + '(Quantity)'}}"  >
			           </td>
			           
			           <td  style="text-align: right;">{{departmentCollections.availableQty}}</td>			           
			           <td  style="text-align: right;">{{departmentCollections.unitPrice}}</td>
			           <td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
			           <td  style="text-align: right;">{{departmentCollections.price}}</td>
                       <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td>
			           <td  style="text-align: right;">{{departmentCollections.discount}}</td>
			           <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.dicountPercentage}}</td>
			           <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCode}}</td>
			           <td  style="text-align: right;">{{departmentCollections.tax}}</td>
			           <td  style="text-align: right;">{{departmentCollections.netPrice}}</td>
                       	<td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGST}}</td>
			            <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGST}}</td>
			            <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGST}}</td>
			            <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGSTinPercent}}</td>
			            <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGSTinPercent}}</td>
			            <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGSTinPercent}}</td>
			            <td  style="text-align: right;">{{departmentCollections.finalTotal}}</td>
			          -->


																			<td><input type="text"
																				style="text-align: right; width: 50px;"
																				class="form-control input-sm"
																				ng-model="departmentCollections.quantity"
																				ng-blur="k(departmentCollections,$index)"
																				placeholder="0" style="width:40px;"
																				ng-init="calculateTaxDiscount(departmentCollections,$index)"
																				name="{{ 'quantity' + $index }}" maxlength="5"
																				validation="required"
																				friendly-name="{{ 'Row' + $index + '(Quantity)'}}"
																				ng-disabled="departmentCollections.pendingQnty == '0'"
																				ng-pattern-restrict="^[0-9.]*$">
																				
																				
																				</td>
																			<td style="text-align: right;">{{departmentCollections.availableQty}}</td>

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
																			<td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>

																			<td style="text-align: right;">{{departmentCollections.price}}</td>

																			<!--  <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td> -->
																			<td><selectivity list="discountTypeList"
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
<td><selectivity list="costList"
																					ng-model="departmentCollections.costcenter"
																					property="departmentCollections.costcenter"
																					id="costcenter" name="costcenter"
																					friendly-name="{{ 'Row' + ($index+1) + '(costcenter)'}}"
																					form-name=""></selectivity>
																			</td>

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
																				ng-blur="calculateTaxDiscountEdit(departmentCollections,$index,'IGST')"
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



																			<!-- <td>{{departmentCollections.purchaseStatus}}</td> -->
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
												
														<!-- end widget content -->
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-12"
											style="margin-top: 7px; padding-left: 12px">
											<div class="form-group">
												<label class="col-md-1 control-label"
													style="padding-left: 12px"> SubTotal :</label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.subTotal"
														style="text-align: right; padding-right: 0;">
												</div>
												<label class="col-md-1 control-label"
													style="padding-left: 12px"> Discount :</label>
												<div class="col-md-1">
													 <input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.totalDiscount"
														ng-blur="TOtalCal(purchaseOrder.totalDiscount)"  style="
														text-align:right;padding-right: 0;"> 
														
														
												</div>
												<!-- 	<label class="col-md-1 control-label" style="padding-left:15px"> Tax :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalTax"  style="text-align: right;padding-right: 0;">
						</div> -->

												<!-- CGST -->
												<label class="col-md-1 control-label"
													style="padding-left: 15px"> CGST :</label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.totalTaxCGST"
														style="text-align: right; padding-right: 0;">
												</div>
												<!-- SGST -->
												<label class="col-md-1 control-label"
													style="padding-left: 15px"> SGST :</label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.totalTaxSGST"
														style="text-align: right; padding-right: 0;">
												</div>
												<!-- IGST -->
												<label class="col-md-1 control-label"
													style="padding-left: 15px"> IGST :</label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.totalTaxIGST"
														style="text-align: right; padding-right: 0;">
												</div>
												<label class="col-md-1 control-label"
													style="padding-left: 12px"> Freight: </label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-pattern-restrict="^[0-9.]*$"
														ng-model="purchaseOrder.freight"
														ng-blur="TOtalCal1(purchaseOrder.freight)" placeholder="0"
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
														ng-model="purchaseOrder.otherCharges"
														ng-blur="TOtalCal(purchaseOrder.otherCharges)"
														placeholder="0"
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
												<label class="col-md-1 control-label"
													style="padding-left: 12px"> Total :</label>

												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.totalAmount" readonly
														style="text-align: right; padding-right: 0;">
												</div>

											</div>
										</div>
										<div class="padding-left-10 padding-top-5"
											id="AddOrRmveMeritbtn">
											<button ng-click="addPurchaseRow(purchaseOrder)"
												class="btn btn-sm btn-primary" tooltip="Add" ng-disabled=""
												type="button">
												<i class="fa fa-plus"></i>
											</button>
											<button ng-click="removePurchaseRow()"
												class="btn btn-sm btn-danger" type="button" tooltip="Delete">
												<i class="fa  fa-trash-o"></i>
											</button>
										</div>

									</div>
								</div>

								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												class="btn btn-success"
												data-ng-click="validate(PurchaseOrderForm,purchaseOrder)"
												data-ng-if="!isEdit">
												<i class="fa fa-save"></i> Request For Approval
											</button>
											<button class="btn btn-success" type="button"
												class="btn btn-success" id="update"
												data-ng-click="validate(PurchaseOrderForm,purchaseOrder);"
												data-ng-if="isEdit == true">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success"
												data-ng-click="reset(PurchaseOrderForm);">
												<i class="fa fa-undo"></i>Reset
											</button>
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