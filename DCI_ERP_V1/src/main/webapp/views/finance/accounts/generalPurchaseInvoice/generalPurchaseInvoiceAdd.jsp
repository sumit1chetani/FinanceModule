<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="purchaseInvoiceForm">
				<div class="row">

								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="col-sm-4 col-md-4 col-lg-4">
										<fieldset>

											<div class="form-group" style= "display:none">
												<label class="col-md-5 control-label"> Company <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">

													<selectivity list="companyList" id="company_id"
														name="Hospital" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.company"
														ng-model="purchaseInvoiceData.company"
														validation="required" friendly-name="Hospital"
														object="hospitalObj"></selectivity>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-5 control-label"> Fund Type <span
													style="color: red;">*</span></label>
												<div class="col-md-7">
													<selectivity list="costList" id="costCenter"
														name="costCenter" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.costCenter"
														ng-model="purchaseInvoiceData.costCenter"
														friendly-name="Costcenter" validation="required"></selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> <label>
														Non PO</label> <%-- 															<spring:message code="label.asterisk.symbol"> </spring:message> --%>
												</label>
												<div class="col-md-7">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="purchaseInvoiceData.nonPo"
															ng-change="nonPO(purchaseInvoiceData.nonPo)"
															ng-disabled="edit"> <span></span>
														</label>
													</div>
												</div>
											</div>
											<div class="form-group" >
												<label class="col-md-5 control-label"> WO Type </label>
												<div class="col-md-7">
													<select class="form-control input-sm" id="woType"
														name="WOType" data-ng-model="purchaseInvoiceData.wotype"
														data-ng-options="ac.id as ac.text for ac in wotypelist"
														validation="required" friendly-name="POType">
														<option value="" selected="selected">--Select--</option>
													</select>
												</div>
											</div>


											<div class="form-group" >
												<label class="col-md-5 control-label"> Budget Type </label>
												<div class="col-md-7">
													<selectivity list="budgetTypeList"
														property="purchaseInvoiceData.budgetType" id="budgetType"
														ng-model="purchaseInvoiceData.budgetType"
														name="budgetType" form-name="PurchaseOrderForm"
														validation="required" friendly-name="budgetType"></selectivity>
												</div>
											</div>

											<div class="form-group" ng_if="nonPOflag">
												<label class="col-md-5 control-label"> WO Number </label>
												<div class="col-md-7">
													<selectivity list="wonumberist" id="wonumber"
														name="costCenter" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.wonumber"
														ng-model="purchaseInvoiceData.wonumber"
														friendly-name="wonumber" validation="required"></selectivity>
												</div>
											</div>




											<!-- <div class="col-sm-4 col-md-4 col-lg-4"> -->

											<!-- <div class="form-group">
												<label class="col-md-5 control-label"> Supplier <span
													style="color: red;">*</span></label>
												<div class="col-md-7">



													<selectivity list="supplierList" id="supplier_id"
														name="Suppliername" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.supplier"
														ng-model="purchaseInvoiceData.supplier"
														validation="required" friendly-name="Supplier"
														object="supplierobj"></selectivity>
												</div>
											</div> -->
											<!-- <div class="form-group">
												<label class="col-md-5 control-label"> Company <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">

															<selectivity list="companyList"  id="company_id"
														name="Hospital" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.company"
														ng-model="purchaseInvoiceData.company"
														validation="required" friendly-name="Hospital"
														object="hospitalObj" ></selectivity>
												</div>
											</div> -->

										</fieldset>
									</div>
									<div class="col-sm-4 col-md-4 col-lg-4">
										<fieldset>
											<!-- <div class="form-group">
												<label for="inputPassword" class="control-label col-md-5">
													Invoice Date </label>
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
								<label class="col-md-5 control-label">Due Date <span style="color: red;">*</span>  </label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="true" data-ng-model="purchaseInvoiceData.puchaseInvoiceDate"
										id="purchaseInvoiceDate" name="purchase Invoice Date" disabled="true"
										data-ng-change="checkDatesCL(purchaseInvoiceData.puchaseInvoiceDate)"
										friendly-name="purchase Invoice Date" validation="required" />
								</div>
								</div>
	       				
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
														ng-model="purchaseInvoiceData.exchangeRate" />
												</div>
											</div> -->
											
											<div class="form-group">
												<label class="col-md-5 control-label"> Supplier <span
													style="color: red;">*</span></label>
												<div class="col-md-7">



													<selectivity list="supplierList" id="supplier_id"
														name="Suppliername" form-name="purchaseInvoiceForm"
														property="purchaseInvoiceData.supplier"
														ng-model="purchaseInvoiceData.supplier"
														validation="required" friendly-name="Supplier"
														object="supplierobj"></selectivity>
												</div>
											</div>

										</fieldset>
									</div>
									<div class="col-sm-4 col-md-4 col-lg-4">
										<fieldset>
											<!-- <div class="form-group">
												<label for="inputPassword" class="control-label col-md-5">Invoice
													Due Date <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<div class="dropdown">
														<a class="dropdown-toggle" id="invoiceDueDate"
															role="button" data-toggle="dropdown" data-target="#"
															href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="Invoice due Date"
																	data-ng-model="purchaseInvoiceData.invoiceDueDate"
																	friendly-name="Invoice due Date"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="purchaseInvoiceData.invoiceDueDate"
																data-on-set-time="purchaseInvoiceData.invoiceDueDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#dueDate',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div> -->
											
											
											<div class="form-group ">
								<label class="col-md-5 control-label">Due Date <span style="color: red;">*</span>  </label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="purchaseInvoiceData.invoiceDueDate"
										id="invoiceDueDate" name="Invoice due Date"
										data-ng-change="checkDatesCL(purchaseInvoiceData.invoiceDueDate)"
										friendly-name="Invoice due Date" validation="required" />
								</div>
								</div>
	       				
											<!-- <div class="col-sm-4 col-md-4 col-lg-4">
 -->
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
												<label class="col-md-5 control-label"> Amount </label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="bcamount" id="bcamount"
														property="purchaseInvoiceData.bcamount"
														ng-model="purchaseInvoiceData.bcamount"
														friendly-name="BC Amount" readonly />
												</div>
											</div>
									</div>
								</div>
								</fieldset>
								<!-- /col-sm-12 -->
							</div>
							<!-- /row -->
							<br> <br>
							<div class="table-responsive clear">
								<!-- Product table -->

								<table class="table table-striped b-t b-light">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="width_1 text-center"><label
												class="i-checks m-b-none"> <input type="checkbox"
													ng-model="selectedAll"
													ng-change="checkAll(purchaseInvoiceProdDetail,selectedAll)">
													<i></i>
											</label></th>
											<th colspan="1" class="sorting width_1 text-center">SI.No</th>
											<th colspan="1" class="sorting width_10 text-center">Account
												Head<span style="color: red;">*</span>
											</th>
											<!-- <th colspan="1" class="sorting width_10 text-center">Sub Account Head
												</th> -->
											<th colspan="1" class="sorting width_10 text-center">Service
												Detail</th>
											<th colspan="1" class="sorting width_10 text-center">
												Amount</th>
											<th colspan="1" class="sorting width_10 text-center">Tax
												Amount</th>


											<th colspan="1" class="sorting width_10 text-center">Total
												Amount</th>
										</tr>
									</thead>
									<tbody
										ng-repeat="(trIndex, row) in purchaseInvoiceData.purchaseInvoiceProdDetail"
										ng-controller="tableCtrl">
										<tr>
											<td class="text-center">
												<div class="checkbox">
													<label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="row.select"><i
														style="left: 6px;"></i>
													</label>
												</div>
											</td>

											<td><label class="m-b-none" ng-model="row.siNo">{{row.siNo}}</label></td>


											<td><selectivity list="itemList" id="accountHeadCode"
													name="{{ 'accountHeadCode' + $index }}"
													property="row.accountHeadCode"
													ng-model="row.accountHeadCode"
													form-name="purchaseInvoiceForm" validation="required"
													friendly-name="{{ 'Row ' + $index + ' (Account Head)'}}"
													object="itemObj"></selectivity></td>
											<!-- <td >
											<selectivity list="subAccountCodedetailList" id="subaccountHeadCode"
													name="{{ 'subaccountHeadCode' + $index }}" property="row.subaccountHeadCode"
													ng-model="row.subaccountHeadCode" form-name="purchaseInvoiceForm"
													
													friendly-name="{{ 'Row ' + $index + ' (Account Head)'}}"
													object="itemObj"></selectivity>
											</td> -->
											<td><input type="text" class="form-control input-sm"
												id="servicedetail{{trIndex}}" ng-model="row.servicedetail"
												name="servicedetail"></td>


											<td><input type="text" class="form-control input-sm"
												id="amount{{trIndex}}" ng-model="row.amount"
												ng-keyup="calculateProductAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
												name="amount"></td>

											<td><input type="text" class="form-control input-sm"
												ng-keyup="calculateProductAmount(purchaseInvoiceData.purchaseInvoiceProdDetail)"
												id="taxAmount{{trIndex}}" ng-model="row.taxAmount"
												name="taxAmount" /></td>
											<td><input type="text" class="form-control input-sm"
												id="totalAmount{{trIndex}}" ng-model="row.totalAmount"
												name="totalAmount" readonly></td>

										</tr>





										<tr>
											<td colspan="12">
												<div class="col-sm-12">


													<div class="col-md-4" ng-if="row.isCostCenter"
														style="padding-top: 10px;">
														<label class="col-md-3 control-label"> CostCtr</label>
														<div class="col-md-9">
															<selectivity list="costCenterList"
																ng-model="row.costCenter" property="row.costCenter"
																id="costCenterId{{trIndex}}">{{row.costCenter}}</selectivity>


														</div>
													</div>


													<div class="col-md-4" ng-if="row.isEmployee"
														style="padding-top: 10px;">
														<label class="col-md-3 control-label"> Employee</label>
														<div class="col-md-9">
															<selectivity list="employeeList"
																ng-model="row.employeeCode" property="row.employeeCode"
																id="employeeCode{{trIndex}}">{{row.employeeCode}}</selectivity>


														</div>
													</div>
													
													<div class="col-md-4" ng-if="row.isDepartment"
														style="padding-top: 10px;">
														<label class="col-md-3 control-label"> Students</label>
														<div class="col-md-9">
															<selectivity list="studentList"
																ng-model="row.departmentCode" property="row.departmentCode"
																id="departmentCode{{trIndex}}">{{row.departmentCode}}</selectivity>


														</div>
													</div>

												</div>
											</td>
									</tbody>
								</table>
								<div class="padding-right-5">
									<div class="col-md-4">
										<button
											ng-click="addProdRow(purchaseInvoiceData.purchaseInvoiceProdDetail)"
											class="btn btn-sm btn-info" tooltip="Add Row" type="button">
											<i class="fa fa-plus"></i>
										</button>
										<button
											ng-click="removeProdRow(purchaseInvoiceData.purchaseInvoiceProdDetail)"
											class="btn btn-sm btn-danger" type="button" tooltip="Delete">
											<i class="fa  fa-trash-o"></i>
										</button>
									</div>
									<div class="col-md-4" ng-if="edit"></div>

									<div class="col-md-8">
										<div class="form-group" style="margin-top: 2%;">
											<label class="col-md-8 control-label">Total </label>
											<div class="col-md-4">
												<input type="text" class="form-control input-sm"
													ng-model="purchaseInvoiceData.productwithTaxTotal" readonly
													name="BC Total" placeholder="0.0" /> <input type="hidden"
													class="form-control input-sm" ng-model="purOrderTotal"
													name="BC Total" placeholder="0.0" readonly />
											</div>
										</div>
									</div>

								</div>
							</div>
							<br> <br>
							<!-- /table-responsive -  End of product table -->

							<div id="content">

								<div id="content">

									<div class="padding-right-5">
										<div class="col-md-4"></div>

									</div>
									<div class="row">
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="content">
												<div class="form-actions">
													<div class="row">
														<div class="col-md-12">
															<button ng-model="add" class="btn btn-success"
																ng-if="!edit" class="btn btn-success" type="button"
																ng-click="validate()">
																<i class="fa fa-save"></i> Save
															</button>
															<button class="btn btn-success" ng-if="edit"
																type="button" ng-click="validate()">
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