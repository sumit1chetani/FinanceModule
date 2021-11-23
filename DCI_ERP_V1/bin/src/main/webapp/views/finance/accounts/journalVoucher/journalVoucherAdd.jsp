<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="journalVoucherForm"
								novalidate method="post">
								<div class="row">
								<br>
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-md-3">
											<fieldset>

												<div class="form-group">
												<label class="col-md-5 control-label"> Organization <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">

													<selectivity list="companyList" ng-if="!edit"
														id="company_id" name="Hospital"
														form-name="purchaseInvoiceForm"
														property="journalVoucher.company"
														ng-model="journalVoucher.company"
														validation="required" friendly-name="Hospital"
														object="hospitalObj" disabled="isGRNNo"></selectivity>

													<selectivity list="companyList" ng-if="edit"
														id="company_id" name="Hospital"
														form-name="purchaseInvoiceForm"
														property="journalVoucher.company"
														ng-model="journalVoucher.company"
														validation="required" friendly-name="Hospital"
														object="hospitalObj" disabled="true"></selectivity>
												</div>
											</div>
												
<!-- 												<div class="form-group"> -->
<!-- 													<label class="col-md-4 control-label"> JV Date <span -->
<!-- 													style="color: red;">*</span> -->
<!-- 													</label> -->
<!-- 													<div class="col-md-8"> -->
<!-- 														<div class='input-group date datetimepick col-md-12'> -->
<!-- 															<div class="dropdown"> -->
<!-- 																<a class="dropdown-toggle" id="dataOfIssue" -->
<!-- 																	role="button" data-toggle="dropdown" data-target="#" -->
<!-- 																	href="#"> -->
<!-- 																	<div class="input-group"> -->
<!-- 																		<input type="text" class="form-control" -->
<!-- 																			placeholder="dd/mm/yyyy" name="JV Date" -->
<!-- 																			data-ng-model="journalVoucher.dataOfIssue" -->
<!-- 																			validation="date_euro_long|required" -->
<!-- 																			friendly-name="JV Date" /> <span -->
<!-- 																			class="input-group-addon"><i -->
<!-- 																			class="glyphicon glyphicon-calendar"></i></span> -->
<!-- 																	</div> -->
<!-- 																</a> -->
<!-- 																<ul class="dropdown-menu" role="menu" -->
<!-- 																	aria-labelledby="dLabel"> -->
<!-- 																	<datetimepicker -->
<!-- 																		data-ng-model="journalVoucher.dataOfIssue" -->
<!-- 																		data-on-set-time="journalVoucher.dataOfIssue = onDateSet(newDate)" -->
<!-- 																		data-datetimepicker-config="{ dropdownSelector: '#dataOfIssue',startView:'day', minView:'day'}" /> -->
<!-- 																</ul> -->
<!-- 															</div> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 												</div> -->

                                <div class="form-group ">
								<label class="col-md-5 control-label">JV Date </label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="todate"
										id="todate" name="todate"
										data-ng-change="checkDatesCL(todate)"
										friendly-name="todate" validation="required" />
								</div>
								</div>
											</fieldset>
										</div>

										<div class="col-md-3">

<div class="form-group">
													<label class="col-md-5 control-label"> Fund Type </label>
													<div class="col-md-7">
														<selectivity list="costList" id="costCenter"
															name="costCenter" form-name="purchaseInvoiceForm"
															property="journalVoucher.costCenter"
															ng-model="journalVoucher.costCenter"
															friendly-name="Costcenter" ></selectivity>
													</div>
												</div>

											
											<!-- <div class="form-group">
												<label class="col-md-5 control-label"> JV Type </label>
												<div class="col-md-7">
													<selectivity class="selectivity-results-container1 "
														list="journalVoucherTypeList"
														ng-model="journalVoucher.journalvoucherTypeId"
														property="journalVoucher.journalvoucherTypeId"></selectivity>
												</div>
											</div> -->
										</div>
										<!-- <div class="col-md-3">

											<div class="form-group">
												<label class="col-md-6 control-label">Bank </label>
												<div class="col-md-6">
													<selectivity list="banklist" id="accountCode"
														name="bank" form-name="purchaseInvoiceForm"
														property="journalVoucher.bankCenter"
														ng-model="journalVoucher.bankCenter"
														friendly-name="Costcenter" validation="required"></selectivity>
												</div>

												</td>
											</div>
										</div> -->
										<div class="col-md-3">
											<div class="form-group">
												<label class="col-md-6 control-label"> Narration
													</label>
												<div class="col-md-6">
													<textarea type="text" class="form-control input-sm"
														id="txtNarration" name="Narration"
														data-ng-model="journalVoucher.narration"
														 friendly-name="Narration" />


												</div>
											</div>
										</div>


										<!--  <div class="col-md-3">
           <div class="form-group">
            <label class="col-md-4 control-label"> Company </label>
            <div class="col-md-8" >
            	<input type="hidden" class="form-control input-sm" data-ng-model="journalVoucher.companyCode" value="" />
				<label class="form-control input-sm" ng-bind="journalVoucher.company"></label>
             	<input type="hidden" class="form-control input-sm" data-ng-model="journalVoucher.companyCode" value="" />
             	<label class="form-control input-sm" ng-bind="journalVoucher.company"></label>
            </div>
           </div>
          </div> -->
										<!-- table responsive -->
									</div>
									<!-- /col-sm-12 -->
								</div>
								<!-- /row -->
								<div class="row">
									<div class="col-md-12">
										<div
											class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
											<table
												class="table table-striped table-bordered table-hover dataTable  b-t b-light">
												<thead class="dataTables-Main-Head">
													<tr>
														<th
															class="width_3 sorting text-center padding-both-side-2"></th>
														<!-- <th class="text-center padding-both-side-2">Sub Group</th> -->
														<th
															class="width_15 sorting text-center padding-both-side-2">Account
															Head <span style = "color:red";></span>
														</th>
														<th
															class="width_15 sorting text-center padding-both-side-2">Ledger Code</th>
														<!-- <th
															class="width_20 sorting text-center padding-both-side-2">Narration</th> -->
													<!-- 	<th
															class="width_10 sorting text-center padding-both-side-2">Currency
															<span style = "color:red";></span>
														</th> -->
														<!-- <th class="width_10 sorting text-center padding-both-side-2">Exg Rate</th> -->
														<!-- 				          <th class="width_10 sorting text-center padding-both-side-2">TC Debit</th>
 -->
														<th
															class="width_10 sorting text-center padding-both-side-2">
															Debit</th>
														<!-- 				          <th class="width_10 sorting text-center padding-both-side-2">TC Credit</th>
 -->
														<th
															class="width_10 sorting text-center padding-both-side-2">
															Credit</th>
													</tr>
												</thead>
												<!-- <tbody ng-repeat="(trIndex, row) in table.row" ng-controller="tableCtrl"> -->
												<tbody ng-repeat="(trIndex, row) in journalVoucher.tables"
													ng-controller="tableCtrl">
													<tr>
														<td class="padding-both-side-2"><label
															class="i-checks m-b-none"> <input type="checkbox"
																ng-model="row.select" id="section{{trIndex}}" /><i></i></label>
														</td>
														<td class="padding-both-side-2"><selectivity
																class=""
																list="accountHeadList" ng-model="row.accountCode"
																property="row.accountCode"
																id="txtAccountCode{{trIndex}}"
																name="{{ 'accountCode' + $index }}"
																validation="required"
																friendly-name="{{ 'Row ' + $index + ' (Account Head on Detail table)'}}"
																form-name="journalVoucherForm"></selectivity></td>
														<td>
														
														<input type="text"
															class="form-control input-sm journalVoucher-textBox"
															ng-model="row.subAccountCode"	id="txtAccountCode{{trIndex}}"
															name="{{ 'subAccountCode' + $index }}"															
															property="row.subAccountCode" form-name="journalVoucherForm"
														
															 />
														<!-- <selectivity
																class=""
																list="subAccountCodeList" ng-model="row.subAccountCode" readonly
																property="row.subAccountCode"
																id="txtSubAccountCode{{$index}}"
																name="{{ 'subAccountCode' + $index }}"
																form-name="journalVoucherForm"></selectivity> --></td>
														<!-- <td class="padding-both-side-2"><input type="text"
															class="form-control input-sm journalVoucher-textBox"
															ng-model="row.narration"></td> -->
														<!-- <td class="padding-both-side-2"><selectivity
																class=""
																list="currencyList" ng-model="row.currency"
																property="row.currency" id="currency{{trIndex}}"
																name="{{ 'currency' + $index }}" validation="required"
																friendly-name="{{ 'Row ' + $index + ' (Currency on Detail table)'}}"
																form-name="journalVoucherForm"></selectivity></td> -->
														<!-- <td class="padding-both-side-2">
			              <input type="text" class="form-control input-sm journalVoucher-textBox" ng-model="row.exchangeRate" />
			            </td> -->
														<!--<td class="padding-both-side-2">
			            	<input type="text" class="form-control input-sm journalVoucher-textBox" ng-model="row.tcDebitAmount" ng-keyup="numberCheck(row)" ng-change="onChangeTcDebit(row,journalVoucher.tables)" />
			            </td> -->
														<td class="padding-both-side-2"><input type="text"
															class="form-control input-sm journalVoucher-textBox"
															ng-model="row.bcDebitAmount" ng-keyup="numberCheck(row)"
															ng-change="onChangeBcDebit(row,journalVoucher.tables)" />
														</td>
														<!--  <td class="padding-both-side-2">
			            	<input type="text" class="form-control input-sm  journalVoucher-textBox" ng-model="row.tcCreditAmount" ng-keyup="numberCheck(row)" ng-change="onChangeTcCredit(row,journalVoucher.tables)" />
			            </td> -->
														<td class="padding-both-side-2"><input type="text"
															class="form-control input-sm journalVoucher-textBox"
															ng-model="row.bcCreditAmount" ng-keyup="numberCheck(row)"
															ng-change="onChangeBcCredit(row,journalVoucher.tables)" />
														</td>
													</tr>
													<tr>
														<td colspan="12">
															<div class="col-sm-12">
																<div class="col-sm-4" ng-if="row.isEmployee">
																	<label class="col-md-3 control-label"> Employee

																	</label>
																	<div class="col-md-9">
																		<selectivity list="employeeList"
																			property="row.employeeCode"
																			id="employeeCode{{trIndex}}"></selectivity>
																	</div>
																</div>
																<div class="col-sm-4" ng-if="row.isDepartment">
																	<label class="col-md-3 control-label">
																		Department </label>
																	<div class="col-md-9">
																		<selectivity list="departmentList"
																			property="row.departmentCode"
																			id="departmentCode{{trIndex}}"></selectivity>
																	</div>
																</div>
																<div class="col-sm-4" ng-if="row.isLocation">
																	<label class="col-md-3 control-label"> Students
																	</label>
																	<div class="col-md-9">
																		<selectivity list="studentList"
																			property="row.countryCode"
																			id="countryCode{{trIndex}}"></selectivity>
																	</div>
																</div>
																<div class="col-sm-4" class="col-sm-4"
																	style="padding-top: 10px;" ng-if="row.isCustomer">
																	<label class="col-md-3 control-label"> Customer

																	</label>
																	<div class="col-md-9">
																		<selectivity list="customerList"
																			property="row.customerCode"
																			id="customerCode{{trIndex}}"></selectivity>
																	</div>
																</div>
																<div class="col-sm-4" style="padding-top: 10px;"
																	ng-if="row.isSupplier">
																	<label class="col-md-3 control-label"> Supplier

																	</label>
																	<div class="col-md-9">
																		<selectivity list="supplierList"
																			property="row.supplierCode"
																			id="supplierCode{{trIndex}}"></selectivity>
																	</div>
																</div>
																<div class="col-sm-4" style="padding-top: 10px;"
																	ng-if="row.isDesignation">
																	<label class="col-md-3 control-label">
																		Designation </label>
																	<div class="col-md-9">
																		<selectivity list="designationList"
																			property="row.designationCode"
																			id="designationCode{{trIndex}}"></selectivity>
																	</div>
																</div>
																
																
															
																<div class="col-sm-4" style="padding-top: 10px;"
																	ng-if="row.isCostCenter">
																	<label class="col-md-3 control-label">  Fund Type

																	</label>
																	<div class="col-md-5">
																		<selectivity class="selectivity-results-container1"
																			list="costCenterList" property="row.costCenter"
																			ng-model="row.costCenter" id="costCenter{{trIndex}}"></selectivity>

																		<!-- <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/> -->
																	</div>
																</div>
																<div class="col-sm-4" style="padding-top: 15px;"
																	ng-if="row.isCompany">
																	<label class="col-md-3 control-label"> Organization Name
																	</label>
																	<div class="col-md-9">

																		<selectivity list="companyList"
																			property="row.companyCode"
																			id="companyCode{{trIndex}}"></selectivity>
																	</div>
																</div>
																<div class="col-sm-4" style="padding-top: 10px;"
																	ng-if="row.isPatient">
																	<label class="col-md-3 control-label">Patient</label>
																	<div class="col-md-9">
																		<selectivity list="patientList"
																			property="row.patientCode" id="patientId{{trIndex}}"></selectivity>
																	</div>
																</div>
															</div>
														</td>
													</tr>
												</tbody>
											</table>
											<div class="padding-right-5" id="AddOrRmvebtn">
												<button ng-click="addRow(journalVoucher.tables)"
													class="btn btn-sm btn-info" type="button">
													<i class="fa fa-plus"></i>
												</button>
												<button ng-click="removeRow(journalVoucher.tables)"
													class="btn btn-sm btn-danger" type="button">
													<i class="fa fa-trash-o"></i>
												</button>
											</div>
											<div class="row">
												<div class="col-sm-12">
													<div class="form-group pull-right">
														<label class="col-md-4 control-label">Total </label>
														<!-- <div class="col-md-2" id="totals">
				        	<input type="text" class="form-control input-sm" id="totaltcDebit" ng-model="totaltcDebit" readonly>
				        </div> -->
														<div class="col-md-4" id="totals">
															<input type="text" class="form-control input-sm"
																id="totalbcDebit" ng-model="totalbcDebit" readonly>
														</div>
														<!-- div class="col-md-2" id="totals">
				        	<input type="text" class="form-control input-sm" id="totaltcCredit" ng-model="totaltcCredit" readonly>
				        </div> -->
														<div class="col-md-4" id="totals">
															<input type="text" class="form-control input-sm"
																id="totalbcCredit" ng-model="totalbcCredit" readonly>
														</div>
													</div>
												</div>
												<!-- /col-sm-12 -->
											</div>
											<!-- /row -->

											<div class="row">
												<div class="col-md-12">
													<div class="form-actions">
														<button ng-model="add" class="btn btn-success ng-scope"
															type="button" class="btn btn-success" ng-if="!isEdit"
															ng-click="validate(journalVoucherForm,totalbcDebit,totalbcCredit,journalVoucher)">
															<i class="fa fa-save"></i> Save
														</button>
														<button ng-model="add" class="btn btn-success ng-scope"
															type="button" class="btn btn-success" ng-if="isEdit"
															ng-click="validate(journalVoucherForm,totalbcDebit,totalbcCredit,journalVoucher)">
															<i class="fa fa-save"></i> Update
														</button>
														<button class="btn btn-danger" ng-click="cancel()"
															type="button">
															<i class="fa fa-close"></i> Cancel
														</button>
													</div>
													<!-- /form-actions -->
												</div>
												<!-- /col-sm-12 -->
											</div>
											<!-- /row -->
										</div>
										<!-- /table-responsive -->
									</div>
								</div>
								<!-- /row -->
							</form>
							<!-- /form-horizontal -->
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
