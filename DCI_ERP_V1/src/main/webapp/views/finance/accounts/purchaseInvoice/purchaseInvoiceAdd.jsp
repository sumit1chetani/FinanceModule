<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="purchaseInvoiceForm">
				<div class="row">

								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="col-sm-4 col-md-4 col-lg-4">
										<fieldset>
												<div class="form-group" style = "display: none">
												<label class="col-md-5 control-label"> Company <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">
												
													<selectivity list="companyList" ng-if="!edit" id="company_id"
														name="Hospital" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.company"
														ng-model="purchaseInvoiceData.company"
														validation="required" friendly-name="Hospital"
														object="hospitalObj" disabled="isGRNNo"></selectivity>
														
															<selectivity list="companyList"  ng-if="edit" id="company_id"
														name="Hospital" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.company"
														ng-model="purchaseInvoiceData.company"
														validation="required" friendly-name="Hospital"
														object="hospitalObj" disabled="true"></selectivity>
												</div>
											</div>
										
										
											<!-- <div class="form-group">
												<label for="inputPassword" class="control-label col-md-5">Purchase
													Invoice Date <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													
														<div class="dropdown">
															<a class="dropdown-toggle" id="purchaseInvoiceDate"
																role="button" data-toggle="dropdown" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="purchase Invoice Date"
																		data-ng-model="purchaseInvoiceData.puchaseInvoiceDate"
																		 validation="date_euro_long|required"
																		friendly-name="Pur Invoice Date" /><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															
															<ul class="dropdown-menu" role="menu"
aria-labelledby="dLabel">
<datetimepicker
data-ng-model="purchaseInvoiceData.puchaseInvoiceDate"
data-on-set-time="purchaseInvoiceData.puchaseInvoiceDate = onDateSet(newDate)"
data-datetimepicker-config="{ dropdownSelector: '#dueDate',startView:'day', minView:'day'}" />
</ul>
														
														</div>
												
												</div>
											</div> -->
											
											
											<div class="form-group ">
								<label class="col-md-5 control-label">Purchase
													Invoice Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="true" data-ng-model="purchaseInvoiceData.puchaseInvoiceDate"
										id="purchaseInvoiceDate" name="purchase Invoice Date"
										data-ng-change="checkDatesCL(purchaseInvoiceData.puchaseInvoiceDate)" 
										friendly-name="purchase Invoice Date" validation="required" />
								</div>
								</div>
											
											<div class="form-group">
												<label class="col-md-5 control-label"> Supplier <span
													style="color: red;">*</span></label>
												<div class="col-md-7">
													
													<selectivity ng-if="!edit" list="supplierList" id="supplier_id"
														name="Suppliername" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.supplier"
														ng-model="purchaseInvoiceData.supplier"
														validation="required" friendly-name="Supplier"
														object="supplierobj" ></selectivity>
														
														<selectivity ng-if="edit" list="supplierList" id="supplier_id"
														name="Suppliername" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.supplier"
														ng-model="purchaseInvoiceData.supplier"
														validation="required" friendly-name="Supplier"
														object="supplierobj" disabled="true"></selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> GRN No</label>
												<div class="col-md-7" ng-if="!edit">
													<selectivity list="grnList" id="purchaseOrder_id"
														name="Purchase No" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.grnNo"
														ng-model="purchaseInvoiceData.grnNo" object="grnObj"></selectivity>
												
												</div>
												<div class="col-md-7" ng-if="edit">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseInvoiceData.grnCode" name="grn" readonly />
													
												</div>
											</div>
											<div class="form-group" >
														<label class="col-md-5 control-label"> PO Type</label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="potype"
																name="potype" data-ng-model="purchaseInvoiceData.potype"
																data-ng-options="ac.id as ac.text for ac in potypelist"
																validation="required" friendly-name="PO Type"
																ng-disabled="type">
																<option value="" selected="selected">--Select--</option>
															</select>
														</div>
													</div>

													<%-- <div class="form-group" ng-if="!po_req_Type">
														<label class="col-md-5 control-label"> WO Type <spring:message
																code="label.asterisk.symbol"></spring:message></label>
														<div class="col-md-7">
															<select class="form-control input-sm" id="woType"
																name="woType" data-ng-model="purchaseInvoiceData.potype"
																data-ng-options="ac.id as ac.text for ac in requestTypeOrderDropDown"
																validation="required" friendly-name="WO Type"
																ng-disabled="isEdit">
																<option value="" selected="selected">--Select--</option>
															</select>
														</div>
													</div> --%>
													<div class="form-group" >
														<label class="col-md-5 control-label"> Budget Type
														</label>
														<div class="col-md-7">
															<selectivity list="budgetTypeList"
																property="purchaseInvoiceData.budgetType" id="budgetType"
																ng-model="purchaseInvoiceData.budgetType" name="budgetType"
																form-name="purchaseInvoiceForm" validation="required"
																friendly-name="budgetType"></selectivity>
														</div>
													</div>
											<!-- <div class="form-group">
		<label class="col-md-5 control-label">Cost Center <span style="color: red;">*</span></label>
												<div class="col-md-7">
											<selectivity list="grnListCost" id="costCenter"
												name="costCenter" form-name="purchaseInvoiceForm"
												property="purchaseInvoiceData.costCenter"
												ng-model="purchaseInvoiceData.costCenter"
									friendly-name="Costcenter" validation="required" ></selectivity>
												</div>
											</div> -->
									

										</fieldset>
									</div>
									<div class="col-sm-4 col-md-4 col-lg-4">
										<fieldset>
											 <div class="form-group">
												<label class="col-md-5 control-label"> Party Invoice
													No <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														ng-model="purchaseInvoiceData.partyInvoiceNo"
														name="Party Invoice No" validation="required"
														friendly-name="Party Invoice No" maxlength="30" />
												</div>
											</div> 
											
											
											<!-- <div class="form-group">
												<label for="inputPassword" class="control-label col-md-5">Party
													Invoice Date</label>
												<div class="col-md-7">
														<div class="dropdown">
															<a class="dropdown-toggle" id="partyInvoiceDate"
																role="button" data-toggle="dropdown" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="party Invoice Date"
																		data-validator="required" data-valid-method="submit"
																		data-message-id="party Invoice Date"
																		data-ng-model="purchaseInvoiceData.partyInvoiceDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="purchaseInvoiceData.partyInvoiceDate"
																	data-on-set-time="purchaseInvoiceData.partyInvoiceDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#partyInvoiceDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
												</div>
											</div> -->
											
											<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Party
													Invoice Date </label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="purchaseInvoiceData.partyInvoiceDate"
										id="partyInvoiceDate" name="party Invoice Date"
										data-ng-change="checkDatesCL(purchaseInvoiceData.partyInvoiceDate)"
										friendly-name="party Invoice Date"  />
								</div>
								</div> -->
										
								<div class="form-group ">
								<label class="col-md-5 control-label">Due
													 Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="purchaseInvoiceData.dueDate"
										id="dueDate" name="due Date"
										data-ng-change="checkDatesCL(purchaseInvoiceData.dueDate)"
										friendly-name="due Date" validation="required" />
								</div>
								</div>
											<!-- <div class="form-group">
												<label class="col-md-5 control-label">Currency</label>
												<div class="col-md-7">
													<selectivity list="currencyList" id="currency"
														name="currency" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.currency"
														ng-model="purchaseInvoiceData.currency"
														friendly-name="Currency"></selectivity>
												</div>
											</div> -->

											<!-- <div class="form-group">
												<label class="col-md-5 control-label"> Exchange Rate</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="Exchange Rate"
														ng-model="purchaseInvoiceData.exchangeRate"  />
												</div>
											</div> -->
<div class="form-group">
		<label class="col-md-5 control-label"> Fund Type <span style="color: red;">*</span></label>
												<div class="col-md-7">
											<selectivity list="grnListCost" id="costCenter"
												name="costCenter" form-name="purchaseInvoiceForm"
												property="purchaseInvoiceData.costCenter"
												ng-model="purchaseInvoiceData.costCenter"
									friendly-name="Costcenter" validation="required" ></selectivity>
												</div>
											</div>


										</fieldset>
									</div>
<div class="col-sm-4 col-md-4 col-lg-4">
<!-- <div class="form-group">
<label for="inputPassword" class="control-label col-md-5">Due
Date<span style="color: red;">*</span>
</label>
<div class="col-md-7">
<div class="dropdown">
<a class="dropdown-toggle" id="dueDate" role="button"
data-toggle="dropdown" data-target="#" href="#">
<div class="input-group">
<input type="text" class="form-control"
placeholder="dd/mm/yyyy" name="due Date"
data-ng-model="purchaseInvoiceData.dueDate"
validation="date_euro_long|required"
friendly-name="Due Date"><span
class="input-group-addon"><i
class="glyphicon glyphicon-calendar"></i></span>
</div>
</a>
<ul class="dropdown-menu" role="menu"
aria-labelledby="dLabel">
<datetimepicker
data-ng-model="purchaseInvoiceData.dueDate"
data-on-set-time="purchaseInvoiceData.dueDate = onDateSet(newDate)"
data-datetimepicker-config="{ dropdownSelector: '#dueDate',startView:'day', minView:'day'}" />
</ul>
</div>
</div>
</div> -->


								
								
								<div class="form-group ">
								<label class="col-md-5 control-label">Party
													Invoice Date </label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="purchaseInvoiceData.partyInvoiceDate"
										id="partyInvoiceDate" name="party Invoice Date"
										data-ng-change="checkDatesCL(purchaseInvoiceData.partyInvoiceDate)"
										friendly-name="party Invoice Date"  />
								</div>
								</div>
										<div class="form-group">
											<label for="inputPassword" class="control-label col-md-5">Description</label>
											<div class="col-md-7">
												<textarea rows="2" class="form-control" name="Description"
													ng-model="purchaseInvoiceData.description">
	        					</textarea>
											</div>
										</div>
									
<!-- 							<div class="form-group" disabled="disabled" > -->
<!-- 												<label class="col-md-5 control-label"> TC Amount </label> -->
<!-- 												<div class="col-md-7"> -->
<!-- 													<input type="text" class="form-control input-sm" -->
<!-- 														name="Exchange Rate" -->
<!-- 														ng-model="purchaseInvoiceData.tcamount" property="purchaseInvoiceData.tcamount" -->
<!-- 														 friendly-name="TC Amount"/> -->
<!-- 												</div> -->
<!-- 											</div> -->
											<div class="form-group">
												<label class="col-md-5 control-label">  Amount </label>
												<div class="col-md-7">
													<input type="text" class="text-right form-control input-sm"
														name="bcamount" id="bcamount" property="purchaseInvoiceData.bcamount"
														ng-model="purchaseInvoiceData.bcamount|number:2" friendly-name=" Amount" />
												</div>
											</div>
						
						
									</div>
								</div>
								<!-- /col-sm-12 -->
							</div>
							<!-- /row -->
							<div class="table-responsive clear">
								<!-- Product table -->
								<div class="legendStyle">Item List</div>
								<table class="table table-striped b-t b-light">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="width_1 text-center" ng-if="!isGRNNo"><label class="i-checks m-b-none">
								             <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(purchaseInvoiceProdDetail,selectedAll)">
											 <i></i>
								           	</label>
								           </th>
											<!-- <th colspan="1" class="width_1" ng-if="!isGRNNo"></th> -->
											<th colspan="1" class="sorting width_1 text-center">SI.No</th>
											<th colspan="1" class="sorting width_13 text-center">Item<span
												style="color: red;">*</span></th>
											<th colspan="1" class="sorting width_10 text-center">Quantity</th>
											<th colspan="1" class="sorting width_10 text-center">Unit
												price</th>
												<th colspan="1" class="sorting width_10 text-center"> Fund Type</th>
												
											<th colspan="1" class="sorting width_10 text-center">Tax
												Amount</th>
											<th colspan="1" class="sorting width_10 text-center">Discount
												Amount</th>
											<th colspan="1" class="sorting width_10 text-center">Prod
												Amount</th>
											<th colspan="1" class="sorting width_10 text-center">Total
												Amount</th>
												
										</tr>
									</thead>
									<tbody
										ng-repeat="(trIndex, row) in purchaseInvoiceData.purchaseInvoiceProdDetail">
										<tr>
											<td class="text-center" ng-if="!isGRNNo">
									           <div class="checkbox">
									           	<label class="i-checks m-b-none">
												  <input type="checkbox" ng-model="row.select"><i style="left: 6px;"></i>
												</label>
												</div>
								           	</td>
											<!-- <td ng-if="!isGRNNo"><label class="i-checks m-b-none"> <input
													type="checkbox" ng-model="row.select" ><i></i></label></td> -->
											<td><label class="m-b-none" ng-model="row.siNo">{{row.siNo}}</label></td>
											
											<td ng-if="!edit">
											
											<selectivity list="itemList" id="itemCode"
													name="{{ 'Item' + $index }}" property="row.itemId"
													ng-model="row.itemId" form-name="purchaseInvoiceForm"
													
													friendly-name="{{ 'Row ' + $index + ' (Item on Detail table)'}}"
													object="itemObj" disabled="isGRNNo"></selectivity>
													
											</td>
										
											
											<td ng-if="edit">
											<selectivity list="itemList" id="itemCode"
													name="{{ 'Item' + $index }}" property="row.itemId"
													ng-model="row.itemId" form-name="purchaseInvoiceForm"
												
													friendly-name="{{ 'Row ' + $index + ' (Item on Detail table)'}}"
													object="itemObj" disabled="true"></selectivity>
											</td>
											 <td ng-if="!edit">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="form-control input-sm"  
															id="quantityTxt{{trIndex}}"
															ng-pattern-restrict="^[0-9]*$" ng-model="row.quantity"
															name="quantity"
															data-ng-keyup="calculateProductAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
															ng-disabled="isGRNNo" />
															
													</div>
												</div>
											</td>
											 <td ng-if="edit">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="form-control input-sm"  
															id="quantityTxt{{trIndex}}"
															ng-pattern-restrict="^[0-9]*$" ng-model="row.quantity"
															name="quantity"
															data-ng-keyup="calculateProductAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
															readonly />
															
													</div>
												</div>
											</td>
											
											
											<td ng-if="!edit">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="form-control input-sm" 
															id="unitpriceTxt{{trIndex}}" ng-model="row.unitprice"
															name="unitprice"
															ng-keyup="calculateProductAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
															ng-pattern-restrict="{{numExp}}"
															data-ng-blur="onChangeDecimal('unitpriceTxt'+trIndex,row.unitprice)"
															ng-disabled="isGRNNo" />
														
													</div>
												</div>
											</td>
											
											<td ng-if="edit">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="form-control input-sm" 
															id="unitpriceTxt{{trIndex}}" ng-model="row.unitprice"
															name="unitprice"
															ng-keyup="calculateProductAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
															ng-pattern-restrict="{{numExp}}"
															data-ng-blur="onChangeDecimal('unitpriceTxt'+trIndex,row.unitprice)"
															readonly />
														
													</div>
												</div>
											</td>
											
											
											<td ng-if="!edit">
											
										<!-- <selectivity list="costList"
												 		ng-model="row.costdtl"
																					property="row.costdtl"
																					id="costdtl" name="costdtl"
readonly="readonly" disabled ="isGRNNo"
																					form-name="" 	 
																					></selectivity>
													 -->
													 
													 <selectivity list="costList" id="costdtl"
													name="{{ 'Item' + $index }}" property="row.costdtl"
													ng-model="row.costdtl" form-name="purchaseInvoiceForm"
													validation="required"
													friendly-name="{{ 'Row ' + $index + ' (Item on Detail table)'}}"
													object="itemObj" disabled="isGRNNo"></selectivity>
											</td>
										
											
											<td ng-if="edit">
											
											
											<selectivity list="costList" id="costdtl"
													name="{{ 'Item' + $index }}" property="row.costdtl"
													ng-model="row.costdtl" form-name="purchaseInvoiceForm"
													validation="required"
													friendly-name="{{ 'Row ' + $index + ' (Item on Detail table)'}}"
													object="itemObj" disabled="true"></selectivity>
											
											
																						
													
											
<!-- 											<selectivity list="costList"
																					ng-model="row.costdtl"
																					property="row.costdtl"
																					id="costdtl" name="costdtl"
readonly="readonly" disabled =""
																					form-name="" 	 
 -->																					></selectivity>
											</td>
										
											<td ng-if="!edit">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="text-right form-control input-sm"  
															id="taxAmount{{trIndex}}" ng-model="row.taxAmount|number:2"
															name="taxAmount"
															ng-keyup="calculateTaxPoAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
															
															ng-disabled="isGRNNo" />
														
													</div>
												</div>
											</td>
											
												<td ng-if="edit">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="text-right form-control input-sm"  
															id="taxAmount{{trIndex}}" ng-model="row.taxAmount|number:2"
															name="taxAmount"
															ng-keyup="calculateProductAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
															readonly/>
														
													</div>
												</div>
											</td>
											
											<td ng-if="!edit">
												<div class="row">
													<div class="col-xs-12"> 
														<input type="text" class="text-right form-control input-sm" 
															id="discountAmount{{trIndex}}"
															ng-model="row.discountAmount|number:2" name="discountAmount"
															ng-keyup="calculateProductAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
															ng-disabled="isGRNNo" />
															
													</div>
												</div>
											</td>
											
											
											<td ng-if="edit">
												<div class="row">
													<div class="col-xs-12"> 
														<input type="text" class="text-right form-control input-sm" 
															id="discountAmount{{trIndex}}"
															ng-model="row.discountAmount|number:2" name="discountAmount"
															ng-keyup="calculateProductAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
															readonly />
															
													</div>
												</div>
											</td>
											
											<td>
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="text-right form-control input-sm"
															id="amount{{trIndex}}" ng-model="row.amount"
															name="amount" placeholder="0.00" readonly>
													</div>
												</div>
											</td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="text-right form-control input-sm"
															id="totalAmount{{trIndex}}" ng-model="row.totalAmount"
															name="totalAmount" placeholder="0.00" readonly>
													</div>
												</div>
											</td>
											
											
											
											
										</tr>
									</tbody>
								</table>
								<div class="padding-right-5">
									<div class="col-md-4" ng-if="!edit">
										<button
											ng-click="addProdRow(purchaseInvoiceData.purchaseInvoiceProdDetail)"
											class="btn btn-sm btn-info" tooltip="Add Row" type="button"
											ng-if="!isGRNNo">
											<i class="fa fa-plus"></i>
										</button>
										<button
											ng-click="removeProdRow(purchaseInvoiceData.purchaseInvoiceProdDetail)"
											class="btn btn-sm btn-danger" type="button" tooltip="Delete"
											ng-if="!isGRNNo">
											<i class="fa  fa-trash-o"></i>
										</button>
									</div>
									<div class="col-md-4" ng-if="edit">
									</div>
							
										<div class="col-md-8">
										<div class="form-group"  style="margin-top: 2%;">
											<label class="col-md-8 control-label">Amount </label>
											<div class="col-md-4">
												<input type="text" class="text-right form-control input-sm"
													ng-model="purchaseInvoiceData.productwithTaxTotal readonly
													name="BC Total" placeholder="0.00" />
													 <!-- <input type="hidden"
													class="form-control input-sm" ng-model=""
													name="BC Total" placeholder="0.0" readonly /> -->
											</div>
										</div>
									</div>
									
									
									
										<div class="padding-right-6">
									<div class="col-md-4"></div>
										<div class="col-md-8">
										<div class="form-group" >
											<label class="col-md-8 control-label">Discount </label>
											<div class="col-md-4">
												<input type="text" class="text-right form-control input-sm"
													ng-model="purchaseInvoiceData.discountAmount" readonly
													name="BC Total" placeholder="0.00" /><!--  <input type="hidden"
													class="form-control input-sm" ng-model="purOrderTotal"
													name="BC Total" placeholder="0.0" readonly /> -->
											</div>
										</div>
									</div>
									</div>
								
									<div class="padding-right-6">
									<div class="col-md-4"></div>
							 <div class="col-md-8">
										<div class="form-group" >
											<label class="col-md-8 control-label">Tax </label>
											<div class="col-md-4">
												<input type="text" class="text-right form-control input-sm"
													ng-model="purchaseInvoiceData.totalTaxPo" readonly
													name="BC Total" placeholder="0.00" /><!--  <input type="hidden"
													class="form-control input-sm" ng-model="purOrderTotal"
													name="BC Total" placeholder="0.0" readonly /> -->
											</div> 
											
									
										</div>
									</div> 
									</div>
							
							
								<div class="padding-right-6">
									<div class="col-md-4"></div>
										<div class="col-md-8">
										<div class="form-group" >
											<label class="col-md-8 control-label">Total </label>
											<div class="col-md-4">
												<input type="text" class="text-right form-control input-sm"
													ng-model="purchaseInvoiceData.grantamountGst" readonly
													name="BC Total" placeholder="0.00" /><!--  <input type="hidden"
													class="form-control input-sm" ng-model="purOrderTotal"
													name="BC Total" placeholder="0.0" readonly /> -->
											</div>
										</div>
									</div>
									</div>
								<!-- </div> -->
									<!-- <div class="col-md-4">
										<div class="form-group">
											<label class="col-md-5 control-label">Total </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													ng-model="purchaseInvoiceData.productwithTaxTotal" readonly
													name="BC Total" placeholder="0.0" /> <input type="hidden"
													class="form-control input-sm" ng-model="purOrderTotal"
													name="BC Total" placeholder="0.0" readonly />
											</div>
										</div>
									</div> -->
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">							        	
									<fieldset>
										<div class="col-md-4" ng-if="purchaseInvoiceData.isEmployee" style="padding-top: 10px;">
										<label class="col-md-3 control-label"> Employee </label>
										<div class="col-md-9">
									    	<selectivity list="employeeList" property="purchaseInvoiceData.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
									    </div>
									</div>
									<div class="col-md-4" ng-if="purchaseInvoiceData.isDepartment" style="padding-top: 10px;">
										<label class="col-md-3 control-label"> Students</label>
										<div class="col-md-9">
									    	<selectivity list="studentList" property="purchaseInvoiceData.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
									    </div>
									</div>
									<div class="col-md-4" ng-if="purchaseInvoiceData.isLocation" style="padding-top: 10px;">
										<label class="col-md-3 control-label"> Kitchen</label>
										<div class="col-md-9">
									    	<selectivity list="countryList" property="purchaseInvoiceData.countryCode" id="countryCode{{trIndex}}"></selectivity>
									    </div>
									</div>
									<div class="col-md-4" ng-if="purchaseInvoiceData.isCustomer" style="padding-top: 10px;" >
										<label class="col-md-3 control-label"> Customer</label>
										<div class="col-md-9">
									    	<selectivity list="customerList" property="purchaseInvoiceData.customerCode" id="customerCode{{trIndex}}"></selectivity>
									    </div>
									</div>
									<div class="col-md-4" ng-if="purchaseInvoiceData.isSupplier"  style="padding-top: 10px;">
										<label class="col-md-3 control-label"> Supplier</label>
										<div class="col-md-9">
									    	<selectivity list="supplierList" property="purchaseInvoiceData.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
									    </div>
									</div>
									<div class="col-md-4" ng-if="purchaseInvoiceData.isDesignation"  style="padding-top: 10px;">
										<label class="col-md-3 control-label"> Designation</label>
										<div class="col-md-9">
									             <selectivity list="designationList" property="purchaseInvoiceData.designationCode" id="designationCode{{trIndex}}"></selectivity>
									     </div>
									</div>
									<!-- <div class="col-md-4" ng-if="purchaseInvoiceData.isCostCenter "  style="padding-top: 10px;">
										<label class="col-md-3 control-label"> Cost Center</label>
										<div class= "col-md-9">
											<selectivity list="costCenterListHr" ng-model="purchaseInvoiceData.costCenter" property="purchaseInvoiceData.costCenter" id="costCenterId{{trIndex}}"  ></selectivity>
									    	
									    </div>
									</div> -->
									<div class="col-md-4" ng-if="purchaseInvoiceData.isCompany"  style="padding-top: 10px;">
										<label class="col-md-3 control-label"> 		<spring:message
			              			code="label.company.name"></spring:message></label>
										<div class="col-md-9">
									    	<selectivity list="companyList" ng-model="purchaseInvoiceData.companyCode" property="purchaseInvoiceData.companyCode" id="companyCodeId{{trIndex}}"></selectivity>
									    </div>
									</div>
									<div class="col-md-4" ng-if="purchaseInvoiceData.isAsset"  style="padding-top: 10px;">
										<label class="col-md-3 control-label">Asset</label>
										<div class="col-md-9">
											<selectivity list="assetList"  ng-model="purchaseInvoiceData.assetCode"  property="purchaseInvoiceData.assetCode" id="assetCode{{trIndex}}"></selectivity>											        
									    </div>
									</div>
									</fieldset>	
								</div>
							</div>
							<br>
							<!-- /table-responsive -  End of product table -->
							<div class="table-responsive clear">
								<!-- Product table -->
							<!-- <div id="content"> -->
								<div class="legendStyle">Charges List</div>
								
									<table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th colspan=1 class="width_1"></th>
											<th colspan=1 class="width_1 text-center">SI.No</th>
											<th colspan=1 class="width_13 text-center">Charges<!-- <span
												style="color: red;">*</span> --></th>
											<th colspan=1 class="width_10 text-center">Short Details</th>
											<th colspan=1 class="width_10 text-center">Amount<!-- <span
												style="color: red;">*</span> --></th>
										</tr>
									</thead>
									<tbody
										ng-repeat="(trIndex, row) in purchaseInvoiceData.purchaseInvoiceDetail" ng-controller="tableCtrl">
										<tr>
											<td><label class="i-checks m-b-none"> <input
													type="checkbox" ng-model="row.select"><i></i></label></td>
											<td><label class="m-b-none" ng-model="row.siNo">{{row.siNo}}</label></td>


											  <td class="padding-both-side-2">
			            	<div class="row">
			            		<div class="col-xs-12"  ng-if="!edit">
				            		 <selectivity list="chargeList"
													id="accountheadcode{{trIndex}}"
													name="{{ 'Charges' + $index }}"
													property="row.accountHeadCode"
													ng-model="row.accountHeadCode"
													form-name="purchaseInvoiceForm" 
													friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}"
													object="chargeObj"></selectivity>
				              	
			        			</div>
			        			<div class="col-xs-12"  ng-if="edit">
				            		 <selectivity list="chargeList"
													id="accountheadcode{{trIndex}}"
													name="{{ 'Charges' + $index }}"
													property="row.accountHeadCode"
													ng-model="row.accountHeadCode"
													form-name="purchaseInvoiceForm" disabled="true"
													friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}"
													object="chargeObj"></selectivity>
				              	
			        			</div>
			        		</div>
			        	</td>
							<td class="padding-both-side-2">
								<div class="row">
			            		<div class="col-xs-12"  ng-if="!edit">
			            				<input type="text" class="form-control input-sm"
															id="shortDetails{{trIndex}}" ng-model="row.shortDetail"
															name="shortDetail">
			            		</div>
			            		<div class="col-xs-12" ng-if="edit">
			            				<input type="text" class="form-control input-sm"
															id="shortDetails{{trIndex}}" ng-model="row.shortDetail"
															name="shortDetail" readonly>
			            		</div>
			            	</div>
							</td>
						
							<td class="padding-both-side-2">
												<div class="row">
													<div class="col-xs-12" ng-if="!edit">
														<input type="text" class="form-control input-sm"
															id="amountTxt{{trIndex}}" ng-model="row.amount"
															name="amount{{trIndex}}" 
															friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}"
															ng-keyup="calculateChargeAmount(purchaseInvoiceData.purchaseInvoiceDetail)"
															data-ng-blur="onChangeDecimal('amountTxt'+trIndex,row.amount)"
															ng-pattern-restrict="{{numExpah}}" />
													</div>
													
													<div class="col-xs-12" ng-if="edit">
														<input type="text" class="form-control input-sm"
															id="amountTxt{{trIndex}}" ng-model="row.amount"
															name="amount{{trIndex}}" 
															friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}"
															ng-keyup="calculateChargeAmount(purchaseInvoiceData.purchaseInvoiceDetail)"
															data-ng-blur="onChangeDecimal('amountTxt'+trIndex,row.amount)"
															ng-pattern-restrict="{{numExp}}" readonly/>
													</div>
												</div>
											</td>
											</tr>
											<tr>
					
											<!-- <td>
												<select class="form-control input-sm" name="accountheadcode" ng-model="row.accountHeadCode" 
							data-ng-options="r.id as r.text for r in chargeList">
										<option value="" selected="selected">--Select--</option>
							</select>  <selectivity list="chargeList"
													id="accountheadcode{{trIndex}}"
													name="{{ 'Charges' + $index }}"
													property="row.accountHeadCode"
													ng-model="row.accountHeadCode"
													form-name="purchaseInvoiceForm" validation="required"
													friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}"
													object="chargeObj"></selectivity>
											</td>
											<td> -->
												
											<td colspan="12">
				        	<div class="col-sm-12">							        	
								<div class="col-md-4" ng-if="row.isEmployee" style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Employee </label>
									<div class="col-md-9">
								    	<selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isDepartment" style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Students</label>
									<div class="col-md-9">
								    	<selectivity list="studentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isLocation" style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Country</label>
									<div class="col-md-9">
								    	<selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isCustomer" style="padding-top: 10px;" >
									<label class="col-md-3 control-label"> Customer</label>
									<div class="col-md-9">
								    	<selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isSupplier"  style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Supplier</label>
									<div class="col-md-9">
								    	<selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isDesignation"  style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Designation</label>
									<div class="col-md-9">
								             <selectivity list="designationList" 
								             property="row.designationCode" 
								             id="designationCode{{trIndex}}"
								              ></selectivity>
								     </div>
								</div>
								<div class="col-md-4" ng-if="row.isCostCenter "  style="padding-top: 10px;">
									<label class="col-md-3 control-label">  Fund Type</label>
									<div class="col-md-9">
										<selectivity list="costCenterList" 
										ng-model="row.costCenter" 
										property="row.costCenter" 
										id="costCenterId{{trIndex}}" 
										disabled="edit" ></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isCompany"  style="padding-top: 10px;">
									<label class="col-md-3 control-label"> 		<spring:message
			              			code="label.company.name"></spring:message></label>
									<div class="col-md-9">
								    	<selectivity list="companyList" ng-model="row.companyCode" property="row.companyCode" id="companyCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isAsset"  style="padding-top: 10px;">
									<label class="col-md-3 control-label">Asset</label>
									<div class="col-md-9">
										<selectivity list="assetList"  ng-model="row.assetCode"  property="row.assetCode" id="assetCode{{trIndex}}"></selectivity>											        
								    </div>
								</div>	
																	
							</div>
					    </td> 		  
										</tr>
									</tbody>
								</table>
								<div class="padding-right-5">
									<div class="col-md-4" ng-if="!edit">
										<button
											ng-click="addRow(purchaseInvoiceData.purchaseInvoiceDetail)"
											class="btn btn-sm btn-info" tooltip="Add Row" type="button">
											<i class="fa fa-plus"></i>
										</button>
										<button
											ng-click="removeRow(purchaseInvoiceData.purchaseInvoiceDetail)"
											class="btn btn-sm btn-danger" type="button" tooltip="Delete">
											<i class="fa  fa-trash-o"></i>
										</button>
										
										
										
										
										
									</div>
									<div class="col-md-4" ng-if="edit">
									</div>
									<div class="col-md-8">
										<div class="form-group">
											<label class="col-md-8 control-label">Total </label>
											<div class="col-md-4">
												<input type="text" class="form-control input-sm"
													ng-model="purchaseInvoiceData.chargeTotal" readonly
													name="BC Total" placeholder="0.0">
											</div>
										</div>
									</div>
								</div>
								</div>

								<div class="padding-right-5">
									<div class="col-md-4"></div>
									<div class="col-md-8">
										<!-- <div class="form-group">
											<label class="col-md-8 control-label">Grand Total </label>
											<div class="col-md-4">
												<input type="text" class="form-control input-sm"
													ng-model="purchaseInvoiceData.grantamount" readonly
													name="grant Total" placeholder="0.0">
											</div>
										</div> -->
									</div>
								</div>
								<div id="content">
								<div class="legendStyle">AccountHead List</div>
									<table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th colspan=1 class="width_1"></th>
											<th colspan=1 class="width_1 text-center">SI.No</th>
											<th colspan=1 class="width_13 text-center">Account Head Description<!-- <span
												style="color: red;">*</span> --></th>
											<th colspan=1 class="width_10 text-center">Short Details</th>
											<th colspan=1 class="width_10 text-center">Amount<!-- <span
												style="color: red;">*</span> --></th>
										</tr>
									</thead>
									<tbody
										ng-repeat="(trIndex, row) in purchaseInvoiceData.purchaseInvoiceDetailacct" ng-controller="tableCtrl1">
										<tr>
											<td><label class="i-checks m-b-none"> <input
													type="checkbox" ng-model="row.select"><i></i></label></td>
											<td><label class="m-b-none" ng-model="row.siNo">{{row.siNo}}</label></td>


											  <td class="padding-both-side-2">
			            	<div class="row">
			            		<div class="col-xs-12"  ng-if="!edit">
				            		 <selectivity list="chargeList"
													id="accountheadcode{{trIndex}}"
													name="{{ 'Charges' + $index }}"
													property="row.ahaccountHeadCode"
													ng-model="row.ahaccountHeadCode"
													form-name="purchaseInvoiceForm" 
													friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}"
													object="chargeObj"></selectivity>
				              	
			        			</div>
			        			<div class="col-xs-12"  ng-if="edit">
				            		 <selectivity list="chargeList"
													id="accountheadcode{{trIndex}}"
													name="{{ 'Charges' + $index }}"
													property="row.ahaccountHeadCode"
													ng-model="row.ahaccountHeadCode"
													form-name="purchaseInvoiceForm"  disabled="true"
													friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}"
													object="chargeObj"></selectivity>
				              	
			        			</div>
			        		</div>
			        	</td>
							<td class="padding-both-side-2">
								<div class="row">
			            		<div class="col-xs-12"  ng-if="!edit">
			            				<input type="text" class="form-control input-sm"
															id="shortDetails{{trIndex}}" ng-model="row.ahshortDetail"
															name="shortDetail">
			            		</div>
			            		<div class="col-xs-12" ng-if="edit">
			            				<input type="text" class="form-control input-sm"
															id="shortDetails{{trIndex}}" ng-model="row.ahshortDetail"
															name="shortDetail" readonly>
			            		</div>
			            	</div>
							</td>
						
							<td class="padding-both-side-2">
												<div class="row">
													<div class="col-xs-12" ng-if="!edit">
														<input type="text" class="form-control input-sm"
															id="ahamountTxt{{trIndex}}" ng-model="row.ahamount"
															name="ahamount{{trIndex}}"
															friendly-name="{{ 'Row ' + $index + ' (AccoundHead  on Detail table)'}}"
															ng-keyup="calculateAHAmount(purchaseInvoiceData.purchaseInvoiceDetailacct)"
															data-ng-blur="onChangeDecimal('ahamountTxt'+trIndex,row.ahamount)"
															ng-pattern-restrict="{{numExpah}}" />
													</div>
													
													<div class="col-xs-12" ng-if="edit">
														<input type="text" class="form-control input-sm"
															id="ahamountTxt{{trIndex}}" ng-model="row.ahamount"
															name="ahamount{{trIndex}}"
															friendly-name="{{ 'Row ' + $index + ' (AccoundHead on Detail table)'}}"
															ng-keyup="calculateAHAmount(purchaseInvoiceData.purchaseInvoiceDetailacct)"
															data-ng-blur="onChangeDecimal('ahamountTxt'+trIndex,row.ahamount)"
															ng-pattern-restrict="{{numExpwah}}" readonly/>
													</div>
												</div>
												
											</td>
											</tr>
											<tr>
					
											<!-- <td>
												<select class="form-control input-sm" name="accountheadcode" ng-model="row.accountHeadCode" 
							data-ng-options="r.id as r.text for r in chargeList">
										<option value="" selected="selected">--Select--</option>
							</select>  <selectivity list="chargeList"
													id="accountheadcode{{trIndex}}"
													name="{{ 'Charges' + $index }}"
													property="row.accountHeadCode"
													ng-model="row.accountHeadCode"
													form-name="purchaseInvoiceForm" validation="required"
													friendly-name="{{ 'Row ' + $index + ' (Charges on Detail table)'}}"
													object="chargeObj"></selectivity>
											</td>
											<td> -->
												
											<td colspan="12">
				        	<div class="col-sm-12">							        	
								<div class="col-md-4" ng-if="row.isEmployee" style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Employee </label>
									<div class="col-md-9">
								    	<selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isDepartment" style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Students</label>
									<div class="col-md-9">
								    	<selectivity list="studentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isLocation" style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Country</label>
									<div class="col-md-9">
								    	<selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isCustomer" style="padding-top: 10px;" >
									<label class="col-md-3 control-label"> Customer</label>
									<div class="col-md-9">
								    	<selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isSupplier"  style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Supplier</label>
									<div class="col-md-9">
								    	<selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isDesignation"  style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Designation</label>
									<div class="col-md-9">
								             <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
								     </div>
								</div>
								<div class="col-md-4" ng-if="row.isCostCenter "  style="padding-top: 10px;">
									<label class="col-md-3 control-label">  Fund Type</label>
									<div class="col-md-9">
										<selectivity list="costCenterList" 
										ng-model="row.costCenter"
										 property="row.costCenter" 
										 id="costCenterId{{trIndex}}" disabled="edit"  ></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isCompany"  style="padding-top: 10px;">
									<label class="col-md-3 control-label"> 		
									<spring:message
			              			code="label.company.name"></spring:message></label>
									<div class="col-md-9">
								    	<selectivity list="companyList" ng-model="row.companyCode" property="row.companyCode" id="companyCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isAsset"  style="padding-top: 10px;">
									<label class="col-md-3 control-label">Asset</label>
									<div class="col-md-9">
										<selectivity list="assetList"  ng-model="row.assetCode"  property="row.assetCode" id="assetCode{{trIndex}}"></selectivity>											        
								    </div>
								</div>	
																	
							</div>
					    </td> 		  
										</tr>
									</tbody>
								</table>
								<div class="padding-right-5">
									<div class="col-md-4" ng-if="!edit">
										<button
											ng-click="addRowacct(purchaseInvoiceData.purchaseInvoiceDetailacct)"
											class="btn btn-sm btn-info" tooltip="Add Row" type="button">
											<i class="fa fa-plus"></i>
										</button>
										<button
											ng-click="removeRowacct(purchaseInvoiceData.purchaseInvoiceDetailacct)"
											class="btn btn-sm btn-danger" type="button" tooltip="Delete">
											<i class="fa  fa-trash-o"></i>
										</button>
									</div>
									<div class="col-md-4" ng-if="edit">
									</div>
									<div class="col-md-8">
										<div class="form-group">
											<label class="col-md-8 control-label">Total </label>
											<div class="col-md-4">
												<input type="text" class="form-control input-sm"
													ng-model="purchaseInvoiceData.ahTotal" readonly
													name="BC Total" placeholder="0.0">
											</div>
										</div>
									</div>
								</div>

								<div class="padding-right-5">
									<div class="col-md-4"></div>
									<div class="col-md-8">
										<div class="form-group">
											<label class="col-md-8 control-label">Grand Total </label>
											<div class="col-md-4">
												<input type="text" class="form-control input-sm"
													ng-model="purchaseInvoiceData.grantamount" readonly
													name="grant Total" placeholder="0.0">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="content">
											<div class="form-actions">
												<div class="row">
													<div class="col-md-12">
														<button ng-model="add" class="btn btn-success"
															ng-if="!edit" class="btn btn-success" type="button"
															ng-click="validate(purchaseInvoiceForm,purchaseInvoiceData)">
															<i class="fa fa-plus"></i> Save
														</button>
														<button class="btn btn-success" ng-if="edit" type="button"
															ng-click="validate(purchaseInvoiceForm,purchaseInvoiceData)">
															<i class="fa fa-save"></i> Update
														</button>
														<button class="btn btn-danger" type="reset" type="button"
															class="btn btn-success" ng-click="cancel()">
															<i class="fa fa-close"></i> Cancel
														</button>
													</div>
												</div>
											</div>
											<!-- /form-actions -->
										</div>
									</div>
								</div>
							</div>
							<!-- /table-responsive -->
						</form>
						<!-- Form end -->
					</div>
				</div>
				<!-- end widget div -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>