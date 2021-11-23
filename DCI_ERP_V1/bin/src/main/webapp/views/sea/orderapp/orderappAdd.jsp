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
													<label class="col-md-3 control-label"> Purchase
														Order No </label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															data-ng-model="purchaseOrder.purchaseOrderNum">
													</div>
												</div>
												<!-- <div class="form-group">
													<label class="col-md-3 control-label"> PO Type </label>
													<div class="col-md-7">
														<select class="form-control input-sm deselect"
															id="purchaseFor" name="potype"
															data-ng-model="purchaseOrder.potype"
															data-ng-options="ac.id as ac.text for ac in potypelist">
															<option value="" selected="selected">--Select--</option>
														</select>
													</div>
												</div> -->
												 <div class="form-group">
				            <label class="col-md-3 control-label">Request Type<span style ="color:red";>*</span></label>
				            <div class="col-md-7">
				            <select class="form-control input-sm" id="reqType" name="reqType" data-ng-model="purchaseOrder.reqType"
							        	data-ng-options="ac.id as ac.text for ac in requestTypeDropDownnew" ng-disabled = "type">
						     </select>
				            </div>
			             </div>
						<div class="form-group" ng-if = "po_req_Type">
				            <label class="col-md-3 control-label"> PO Type <span style ="color:red";>*</span></label>
				            <div class="col-md-7">
				            <select class="form-control input-sm" id="POType" name="POType" 
				            data-ng-model="purchaseOrder.potype"
							        	data-ng-options="ac.id as ac.text for ac in potypelist"
							        	validation="required" friendly-name="PO Type" ng-disabled = "type">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
				            </div>
				            
				            <div class="form-group" ng-if = "!po_req_Type">
				            <label class="col-md-3 control-label"> WO Type <span style ="color:red";>*</span></label>
				            <div class="col-md-7">
				            <select class="form-control input-sm" id="woType" name="woType" 
				            data-ng-model="purchaseOrder.potype"
							        	data-ng-options="ac.id as ac.text for ac in requestTypeOrderDropDown"
							        	validation="required" friendly-name="WO Type" ng-disabled = "isEdit">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div>
												<div class="form-group" ng-if="budgetType">
													<label class="col-md-3 control-label"> Budget Type
														<span style ="color:red";>*</span>
													</label>
													<div class="col-md-7">
														<selectivity list="budgetTypeList"
															property="purchaseOrder.budgetType" id="budgetType"
															ng-model="purchaseOrder.budgetType" name="budgetType"
															form-name="PurchaseOrderForm" validation="required"
															friendly-name="budgetType" disabled = "true"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Purchase For
													</label>
													<div class="col-md-7">
														<select class="form-control input-sm" id="purchaseFor"
																name="purchaseFor" data-ng-model="purchaseOrder.purchaseFor"
																data-ng-options="ac.id as ac.text for ac in requestTypeDropDownnew"
																ng-disabled="purchaseFor">
															</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label"> Organization Name <span style ="color:red";>*</span></label>
													<div class="col-md-7">
														<select class="form-control input-sm deselect"
															id="hospital" name="hospital"
															data-ng-model="purchaseOrder.companyId"
															data-ng-options="ac.id as ac.text for ac in hospitalList">
															<option value="" selected="selected">--Select--</option>
														</select>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label"> Destination
														Location </label>
													<div class="col-md-7">
														<select class="form-control input-sm deselect"
															id="location" name="location"
															data-ng-model="purchaseOrder.locationId"
															data-ng-options="ac.id as ac.text for ac in addressList"
															ng-change="loadDestAddress()">
															<option value="" selected="selected">--Select--</option>
														</select>
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
																placeholder="country" ng-model="purchaseData.desCountry"
																readonly>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Terms &
														Conditions </label>
													<div class="col-md-7">
														<textarea  class="text-left form-control input-sm"
															data-ng-model="purchaseOrder.termsCondition" rows="4"
															cols="20" style="resize: none" disabled> </textarea>
													</div>
												</div>
												<div class="form-group">
							            <label class="col-md-3 control-label"> Payment Terms
							            </label>
							            <div class="col-md-7">
							             <input class="text-right form-control input-sm" ng-model="purchaseOrder.paymentTerms" />
							            </div>
							             <span class="pull-left line-height-30">Days</span>
							        </div>	
												<div class="form-group" ng-if="isRecmnd">
													<label class="col-md-3 control-label"> Recommend By
													</label>
													<div class="col-md-7">
														<input type="text" disbaled
															class="text-left form-control input-sm"
															data-ng-model="purchaseOrder.userName" />
													</div>
												</div>

											</fieldset>
										</div>

										<div class="col-md-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-4 control-label"> PO Date </label>
													<div class="col-md-8">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a data-toggle="dropdown" class="dropdown-toggle"
																	id="curDate" role="button" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="currentDate"
																			data-validator="required" data-valid-method="submit"
																			data-message-id="currentDate"
																			data-ng-model="purchaseOrder.purchaseOrderDate"
																			disabled><span class="input-group-addon"><i
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
													<label class="col-md-4 control-label"> Status </label>
													<div class="col-md-7" ng-if="poStatus.length>0">
														<select class="form-control input-sm" id="Status"
															ng-disabled="isConsignment==true" name="Status"
															data-ng-model="purchaseOrder.statusId"
															data-ng-options="ac.id  as ac.text for ac in poStatus"
															data-ng-change="checkStatus();">
															<option value="" selected="selected" disabled>--Select--</option>
														</select>

													</div>
													<span ng-if="isRecmndEdit"><i
														class="fa  fa-list-alt text-dark text"
														data-ng-click="openDialog()"></i></span>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Vendor <span style ="color:red";>*</span></label>
													<div class="col-md-7">
														<select class="form-control input-sm deselect" id="Vendor"
															name="Vendor" data-ng-model="vendor"
															data-ng-options="ac as ac.text for ac in vendorList"
															ng-change="loadVendorAddress()" disabled>
															<option value="" selected="selected">--Select--</option>
														</select>
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
															form-name="PurchaseOrderForm" disabled = "true"></selectivity>

													</div>
												</div>
												<div class="form-group" ng-if="!isRecmnd">
													<label class="col-md-4 control-label "> Remarks </label>
													<div class="col-md-7">
														<textarea disbaled class="text-left form-control input-sm"
															data-ng-model="purchaseOrder.remarks" rows="4" cols="20"
															style="resize: none" disabled> </textarea>
													</div>
												</div>
												<div class="form-group" ng-if="!isRecmnd">
													<label class="col-md-4 control-label "> Advance </label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															data-ng-model="purchaseOrder.advanceamt" readonly>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Currency </label>
													<div class="col-md-7">

														<selectivity list="currencyList"
															ng-model="purchaseOrder.currency"
															property="purchaseOrder.currency" id="costcenter"
															object="currency" name="currency"
															friendly-name="Currency" 
															disabled = "true"
															form-name="PurchaseOrderForm" > </selectivity>

													</div>
													<!--  <span class="pull-left line-height-30">Days</span> -->
												</div>
												<div class="form-group" ng-if="isRecmnd">
													<label class="col-md-4 control-label"> Recommended
														Date </label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a data-toggle="dropdown" class="dropdown-toggle"
																	id="recDate" role="button" data-target="#" href="#">
																	<div class="input-group col-md-11">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="recmnDate"
																			data-ng-model="purchaseOrder.recmndDate"><span
																			class="input-group-addon"
																			style="display: inline-table !important; position: absolute;"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="purchaseOrder.recmndDate"
																		data-on-set-time="purchaseOrder.recmndDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#recDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group" ng-if="isRecmnd">
													<label class="col-md-4 control-label "> Recommend
														Remarks </label>
													<div class="col-md-7">
														<textarea class="text-left form-control input-sm"
															data-ng-model="purchaseOrder.recmndremarks" rows="4"
															cols="20" style="resize: none"> </textarea>
													</div>
												</div>
											</fieldset>
										</div>

										<div class="col-sm-12 col-md-12 col-lg-12"
											ng-if="purchaseOrder.purchaseTypeName != 'Rate Contract'">
											<br>
											<div role="content">
												<!-- <div class="widget-body no-padding"> -->
												<div class="table-responsive">
													<div class="col-md-12" style="width: 150%;">

														<div
															class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
															data-st-table="displayedCollectionItem"
															data-st-safe-src="rowCollectionItem">

															<table id="dt_basic"
																class="table table-striped table-bordered table-hover dataTable no-footer"
																role="grid" aria-describedby="dt_basic_info">
																<thead class="dataTables-Main-Head">
																	<tr>
																		<!-- <th class="width_1 table-heading text-center">
			            <label class="i-checks m-b-none">
			             <input type="checkbox">
			             <i></i>
			            </label>
			           </th> -->
																		<th class="sorting width_10">Purchase
																			Requisition Number</th>
																		<th class="sorting width_10"
																			data-st-sort="purchaseItemName">Item Code-Item
																			Name</th>
																		<th class="sorting width_8">Item Description</th>
																		<th class="sorting width_4" data-st-sort="edd">EDD</th>
																		
																	<th class="sorting width_2">Purchase UOM</th>
																	<th class="sorting width_1">Purchase Qty</th>
																		<th class="sorting width_1" data-st-sort="uom">Vendor
																			UOM</th>
																		<th class="sorting width_2" data-st-sort="quantity">Vendor
																			Qty</th>
																		<th class="sorting width_4 detail-qty"
																			ng-if="isRecmnd || isRecmndEdit"
																			style="padding-left: 0px !important; padding-right: 0px !important;">
																			Requested Qty</th>
																		<th class="sorting width_4" data-st-sort="unitPrice">Unit
																			Price</th>
																		<th class="sorting width_4"
																			data-st-sort="oldUnitPrice">Old Unit Price</th>
																		<th class="sorting width_4" data-st-sort="price">Price</th>
																		<th class="sorting width_4" data-st-sort="discount">Discount</th>
																	<th class="sorting width_8" data-st-sort="costcenter">Cost Center</th>
																		
																		<!-- <th class="sorting width_8"  style="padding: 0 !important;line-height: 34px;">Discount(%)</th> -->
																		<th class="sorting width_4">Net Price</th>
																		<!-- <th class="sorting width_7" data-st-sort="tax">Tax</th> -->
																		<th class="sorting width_4" data-st-sort="tax">CGST</th>
																		<th class="sorting width_4" data-st-sort="tax">SGST</th>
																		<th class="sorting width_4" data-st-sort="tax">IGST</th>
																		<th class="sorting width_2">CGST(%)</th>
																		<th class="sorting width_2">SGST(%)</th>
																		<th class="sorting width_2">IGST(%)</th>
																		<th class="sorting width_4" data-st-sort="total">Sub
																			Total</th>
																		<!-- <th class="sorting width_7" data-st-sort="purchaseStatus">Status</th> -->
																		<!-- <th class="sorting width_10" data-st-sort="">Item Description</th> -->
																		<!-- <th class="sorting width_7" data-st-sort="">Vendor Item Name</th> -->
																		<!--  <th class="sorting width_7" data-st-sort="">Delivery Lead Time</th> -->
																		<%-- <th class="width_8 table-heading text-center"><spring:message code="label.action"></spring:message></th> --%>
																	</tr>
																</thead>
																<tbody class="dataTables-Main-Body">
																	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																		ng-controller="parentCtrl"
																		ng-repeat="departmentCollections in displayedCollectionItem"
																		ng-hide="departmentCollections.edit == '2'">
																		<!--   <td >
			           <label class="i-checks m-b-none">
			             <input type="checkbox" ng-model="departmentCollections.isSelected">
			             <i></i>
			            </label></td> -->
																		<td>{{departmentCollections.requisitionNo}}</td>

																		<td>{{departmentCollections.purchaseItemName}}</td>
																		<!-- <td>{{departmentCollections.purchaseQuoteId}}</td> -->
																		<td title={{departmentCollections.purchaseItemDesc}}>{{departmentCollections.purchaseItemDesc}}</td>
																		<td>{{departmentCollections.edd}}</td>
																																	
																	<td>{{departmentCollections.purchaseUOMName}}</td>
																	<td>{{departmentCollections.purchaseQty}}</td>
																		<td>{{departmentCollections.uomName}}</td>
																		<td><input type="text" name=quantity
																		class="form-control input-sm"
																			ng-model="departmentCollections.quantity"
																			ng-pattern-restrict="{{numExp}}"
																			ng-keyup="validateQty(departmentCollections.quantity,$index);"
																			ng-disabled="!isRecmnd" maxlength="5"
																			style="text-align: right; width: 50px !important;"
																			ng-blur="checkPartiallyVerified(departmentCollections)"
																			name="{{ 'quantity' + $index }}"
																			validation="required"
																			friendly-name="{{ 'Row' + $index + '(Quantity)'}}" />
																		</td>
																		<td style="text-align: right;"
																			ng-if="isRecmnd || isRecmndEdit">{{departmentCollections.recmnQty}}</td>
																		<td style="text-align: right;">{{departmentCollections.unitPrice}}</td>
																		<td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
																		<td
																			ng-init="calculateTaxDiscount(departmentCollections)"
																			style="text-align: right;">{{departmentCollections.price}}</td>

																		<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountAmount}}</td>
																		<!-- <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.dicountPercentage}}</td>
																		 --><!-- <td style="text-align: right;">{{departmentCollections.tax}}</td> -->
<!-- 																		<td style="text-align: right;">{{departmentCollections.costcenter}}</td>
 -->																		 <td style="text-align: left;">
 															<!-- <selectivity list="costList" tittle ="departmentCollections.costcenter"
																					ng-model="departmentCollections.costcenter"
																					property="departmentCollections.costcenter"
																					id="costcenter" name="costcenter"
																					friendly-name="{{ 'Row' + ($index+1) + '(costcenter)'}}"
																					form-name="purchaseQuoteRequestForm" disabled="true"></selectivity> -->
																					{{departmentCollections.costCenterName}}
																			</td>
																		<td style="text-align: right;">{{departmentCollections.netPrice}}</td>
																		<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGST}}</td>
																		<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGST}}</td>
																		 <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGST}}</td>
																 
																		<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCGSTinPercent}}</td>
																		<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxSGSTinPercent}}</td>
																		<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxIGSTinPercent}}</td>
																		<td style="text-align: right;">{{departmentCollections.finalTotal}}</td>
																		<!--  <td>{{departmentCollections.purchaseStatus}}</td> -->
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
												<!-- end widget content -->
											</div>
											<br>
										</div>

										<div class="col-md-12"
											ng-if="purchaseOrder.purchaseTypeName != 'Rate Contract'">
											<div class="form-group">
												<label class="col-md-1 control-label"> SubTotal :</label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.subTotal" readonly
														style="text-align: right; padding-right: 0; padding-left: 0;">
												</div>
												<label class="col-md-1 control-label"> Discount :</label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.totalDiscount" readonly
														style="text-align: right; padding-right: 0; padding-left: 0;">
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
												<!-- <label class="col-md-1 control-label"> Freight </label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.freight" ng-if="!isRecmnd"
														style="text-align: right; padding-right: 0; padding-left: 0;"
														readonly> <input type="text"
														class="form-control input-sm"
														ng-model="purchaseOrder.freight" ng-if="isRecmnd"
														style="text-align: right; padding-right: 0; padding-left: 0;"
														ng-change="calculateTotal()">
												</div> -->
												
												<label class="col-md-1 control-label" style="padding-left:12px"> Freight: </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"   ng-pattern-restrict="^[0-9.]*$" ng-model="purchaseOrder.freight"  ng-blur = "TOtalCal1(purchaseOrder.freight)" placeholder="0" style="text-align: right;padding-right: 0;" readonly>
						</div>
						<br>
						<br>
						<br>
						<label class="col-md-1 control-label" style="padding-left:12px"> Freight Tax (%) : </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"   ng-pattern-restrict="^[0-9.]*$" ng-model="purchaseOrder.freightTax"  ng-blur = "TOtalCal1(purchaseOrder.freightTax)" placeholder="0" style="text-align: right;padding-right: 0;" readonly>
						</div>
						
						<label class="col-md-1 control-label" style="padding-left:12px"> Freight Total: </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"   ng-pattern-restrict="^[0-9.]*$" ng-model="purchaseOrder.freightAmount"  ng-blur = "TOtalCal1(purchaseOrder.freightAmount)" placeholder="0" style="text-align: right;padding-right: 0;" readonly>
						</div>
						<label class="col-md-1 control-label"
													style="padding-left: 12px"> Other Charges: </label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-pattern-restrict="^[0-9.]*$"
														ng-model="purchaseOrder.otherCharges"
														ng-blur="TOtalCal(purchaseOrder.otherCharges)" placeholder="
														0"
							 style="text-align: right; padding-right: 0;"
														readonly>
												</div>
												<label class="col-md-1 control-label"
													style="padding-left: 12px"> Remarks : </label>
												<div class="col-md-3">
													<textarea class="text-left form-control input-sm"
														name="remarks for OtherCharges"
														data-ng-model="purchaseOrder.remarksforother" rows="1"
														cols="20" style="resize: none" readonly> </textarea>
												</div>


												<label class="col-md-1 control-label"> Total :</label>
												<div class="col-md-1">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseOrder.totalAmount" readonly
														style="text-align: right; padding-right: 0; padding-left: 0;">
												</div>
												<br>

												<div class="form-group" ng-repeat="group in gstGroup" style="padding-left: 80%;color: black;">
	        				<label class="col-md-8 control-label"> {{group.gstgroupbyPercent}}  </label>
	        		
	 							 <label class="span-class" style="    padding-top: 8px;">:  {{group.gstAmtgroupbyPercent}}</label>
	  
						</div>
						<div class="form-group" style="padding-left: 80%;color: black;">
						<label class="col-md-8 control-label"> Total </label>
						<label class="span-class" style="    padding-top: 8px;">: {{purchaseOrder.totalAmount}}</label>
        				
						</div>
											</div>
										</div>

										<div class="col-sm-12 col-md-12 col-lg-12"
											ng-if="purchaseOrder.purchaseTypeName == 'Rate Contract'"
											style="overflow-x: hidden;">
											<tabset justified="true" class="tab-container"> <tab
												heading="Order Status">
											<div role="content">
												<div class="widget-body no-padding">
													<div style="min-width: 70%; overflow-x: scroll"
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
														data-st-table="displayedCollectionItem"
														data-st-safe-src="rowCollectionItem">
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_1 table-heading text-center"><label
																		class="i-checks m-b-none"> <input
																			type="checkbox" ng-model="selectedAll"
																			ng-change="checkAllRateContract(rowCollectionItem,selectedAll)">
																			<i></i>
																	</label></th>
																	<th class="sorting width_14">Item Code-Item Name</th>
																	<th class="sorting width_6">EDD</th>
																	<th class="sorting width_6">Vendor UOM</th>
																	<th class="sorting width_5">Vendor Qty</th>
																	<th class="sorting width_7"
																		style="padding: 0 !important; line-height: 34px;">Unit
																		Price</th>
																	<th class="sorting width_7">Old Unit Price</th>
																	<th class="sorting width_8">Price</th>
																	<th class="sorting width_10">Discount Type</th>
																	<th class="sorting width_8"
																		style="padding: 0 !important; line-height: 34px;">Discount</th>
																	<th class="sorting width_7">Tax Type</th>
																	<th class="sorting width_7">Tax</th>
																	<th class="sorting width_8">Total</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr ng-controller="parentCtrl"
																	data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	ng-repeat="departmentCollections in displayedCollectionItem"
																	ng-hide="departmentCollections.edit == '2'">
																	<td><label class="i-checks m-b-none"> <input
																			type="checkbox"
																			ng-model="departmentCollections.select"> <i></i>
																	</label></td>
																	<td>{{departmentCollections.purchaseItemName}}</td>
																	<td>{{departmentCollections.edd}}</td>		
																	<td>{{departmentCollections.uomName}}</td>
																	<td
																		ng-init="calculateTaxDiscount(departmentCollections)">{{departmentCollections.quantity}}</td>
																	<td style="text-align: right;">{{departmentCollections.unitPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
																	<td style="text-align: right;">{{departmentCollections.price}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td>
																	<td style="text-align: right;">{{departmentCollections.discount}}</td>
																	<td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCode}}</td>
																	<td style="text-align: right;">{{departmentCollections.tax}}</td>
																	<td style="text-align: right;">{{departmentCollections.finalTotal}}</td>
																	<!--  <td>{{departmentCollections.purchaseStatus}}</td> -->
																</tr>
															</tbody>
														</table>
													</div>
													<div class="form-group padding-top-20">
														<label class="col-md-1 control-label"> SubTotal </label>
														<div class="col-md-1">
															<input type="text" class="form-control input-sm"
																ng-model="purchaseOrder.subTotal" readonly
																style="text-align: right; padding-right: 0; padding-left: 0;">
														</div>
														<label class="col-md-1 control-label"> Discount </label>
														<div class="col-md-1">
															<input type="text" class="form-control input-sm"
																ng-model="purchaseOrder.totalDiscount" readonly
																style="text-align: right; padding-right: 0; padding-left: 0;">
														</div>
														<label class="col-md-1 control-label"> Tax </label>
														<div class="col-md-1">
															<input type="text" class="form-control input-sm"
																ng-model="purchaseOrder.totalTax" readonly
																style="text-align: right; padding-right: 0; padding-left: 0;">
														</div>
														<label class="col-md-1 control-label"> Freight </label>
														<div class="col-md-1">
															<input type="text" class="form-control input-sm"
																ng-pattern-restrict="^[0-9.]*$"
																ng-model="purchaseOrder.freight" readonly
																style="text-align: right; padding-right: 0; padding-left: 0;">
														</div>
														<label class="col-md-1 control-label"> Total </label>
														<div class="col-md-2">
															<input type="text" class="form-control input-sm"
																ng-model="purchaseOrder.totalAmount" readonly
																style="text-align: right; padding-left: 0; padding-right: 0;">
														</div>
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
																maxlength="5" class="control-label" placeholder="0"
																readonly></td>
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
											<button class="btn btn-success" type="button"
												class="btn btn-success" data-ng-click="BudgetAmount(purchaseOrder)">
												<i class="fa fa-check"></i>
												Approve
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i>
												Cancel
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

<script type="text/ng-template" id="errorDialog">
	<div class="modal-header" style="font-weight:bold;"> Recommended Details.
		<a class="pull-right" ng-click="closeErrorDialog()">&times; </a>
	</div>
		<table class="table table-striped table-bordered table-hover dataTable no-footer">
								 <thead class="dataTables-Main-Head">
							          <tr>
							           <th class="sorting width_7">Recommended By</th>
							           <th class="sorting width_10" >Recommended Date</th>
							            <th class="sorting width_8">Recommended Remarks</th>
							          </tr>
							     </thead>
								<tbody >
									<tr>
										<td class="width_15">
											 {{purchaseOrder.recmmendedBy}}
										</td>
									
										<td class="width_10">
									             {{purchaseOrder.recmndDate}}
										</td>
										<td class="width_15">
									          {{purchaseOrder.recmndremarks}}
										</td>
									</tr>
								</tbody>
							</table>

     <div class="modal-footer">
			<button class="btn btn-danger" ng-click="closeErrorDialog()">Cancel</button>
	</div>
		
 </script>