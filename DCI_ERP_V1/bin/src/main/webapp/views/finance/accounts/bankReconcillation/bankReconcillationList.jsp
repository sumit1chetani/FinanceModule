



 <div class="panel panel-default panel-default-list" st-persist="loanEntryTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>

					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="chequereconsolation"
								novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-4">
										<fieldset>

<br>
											<!-- <div class="form-group">
												<label class="col-md-5 control-label">From Date
												</label>
												<div class="col-md-7 inputGroupContainer">
													<div class='input-group date datetimepick col-md-12'>

														<div class="dropdown">
															<a class="dropdown-toggle" id="curDate1" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="fromdate"
																		validation="date_euro_long|required"
																		friendly-name="From Date"
																		data-ng-model="bankReconcile.fromDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="bankReconcile.fromDate"
																	data-on-set-time="bankReconcile.fromDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#curDate1',startView:'day', minView:'day'}" />
															</ul>
														</div>

													</div>
												</div>
											</div> -->
											
											<div class="form-group ">
								<label class="col-md-4 control-label">From Date </label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="bankReconcile.fromDate"
										id="curDate1" name="From Date"
										data-ng-change="checkDatesCL(bankReconcile.fromDate)"
										friendly-name="From Date"  />
								</div>
								</div>
										</fieldset>
									</div>
									<div class="col-sm-12 col-md-4">

										<br>
											<!-- <div class="form-group">
												<label class="col-md-5 control-label">To Date 
												</label>
												<div class="col-md-7 inputGroupContainer">
													<div class="dropdown">
														<a class="dropdown-toggle" id="curDate" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="fromdate"
																	validation="date_euro_long|required"
																	friendly-name="To Date"
																	data-ng-model="bankReconcile.toDate"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker data-ng-model="bankReconcile.toDate"
																data-on-set-time="bankReconcile.toDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div> -->
											
											
											
												<div class="form-group ">
								<label class="col-md-4 control-label">To Date  </label>
								<div class="col-md-7 ">
								<!-- 	<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="bankReconcile.toDate"
										id="curDate" name="fromdate"
										data-ng-change="checkDatesCL(bankReconcile.toDate)"
										friendly-name="To Date"  /> -->
										<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="bankReconcile.toDate"
										id="purchaseInvoiceDate" name="purchase Invoice Date"
										data-ng-change="checkDatesCL(bankReconcile.toDate)" 
										friendly-name="From Date" >
								</div>
								</div>
								
								
								
								
											
									</div>
									<br>
									<div class="col-sm-4 col-md-4">
                      <div class="form-group">
                        <label class="col-md-3 control-label"> Bank Account
                        </label>
                        <div class="col-md-9">
                            	<selectivity list="bankList" 
														id="bankCode" name="bankCode"
														form-name="checkreconsider"
														property="bankReconcile.bankCode"
														ng-model="bankReconcile.bankCode"
														validation="required" friendly-name="bankCode"
														object="bankCode" ></selectivity>
                        </div>
                      </div>
                     </div>
									
									
									
									<div></div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<!-- <input type="file" class="form-control btn-primary" name="excelfile" ng-model="excelfile" accept=".xls,.xlsx,.xlsm" />
						           			<button class="btn btn-primary" type="button" onclick="angular.element(excelfile).scope().uploadFile(excelfile)" >Upload Statement</button> -->
										<%-- 	<security:authorize
												access="hasRole('${form_code}_${upload}')"> --%>
												<button class="btn btn-primary" type="button"
													ng-click="openFileModal()">Upload Statement</button>
<%-- 											</security:authorize>
 --%>											
<%--  <security:authorize access="hasRole('${form_code}_${view}')">
 --%>												<button class="btn btn-info" type="button"
													ng-click="getDiffernceList()">Show Differences</button>
<%-- 											</security:authorize>
 --%>											
<%--  <security:authorize access="hasRole('${form_code}_${view}')">
 --%>												<button class="btn btn-danger" ng-click="getReconcileList()"
													type="button">Show Reconciled Records</button>
<%-- 											</security:authorize>
 --%>											<%-- <security:authorize
												access="hasRole('${form_code}_${upload}')">
												 <button class="btn btn-primary" ng-click="exportExcel()">
										<i class="fa fa-file-excel-o"> </i> Export to Excel <a
											id="bankId" stype="display:none"
											href="tempDoc/BankReconciliation.xlsx"
											download="BankReconciliation.xlsx"></a>
									</button>
											</security:authorize> --%>
											<a id="bankId" stype="display:none"
						href="filePath/BankReconciliation.xls"
						download="BankReconciliation.xls"></a>
						<button class="btn btn-primary" ng-click="exportExcel()">
							<i class="fa fa-download"> Export Excel</i>
						</button>
										</div>
									</div>
								</div>
							</form>
						</div>

						<div class="panel-body float-left padding-0"
							st-table="displayedCollection" st-safe-src="rowCollection">
							<!-- <div class="table-responsive"> -->
								<!-- <table
									class="table table-striped table-bordered table-hover dataTable no-footer">
									<thead class="dataTables-Main-Head">
										<tr role="row">
											<th class="width_52">Book Statement</th>
											<th class="	width_47">Bank Statement</th>
										</tr>
									</thead>
								</table> -->
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									width="100%" role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr role="row">
											<th colspan=1 class="width_1 "><label
									class="i-checks m-b-none"> <input type="checkbox"
										ng-click="checkAll()" ng-model="bankReconcile.checkAll"> <i></i>
								</label></th>
											<th class="sorting width_15" st-sort="transno">Customer/Supplier</th>
											<th class="sorting width_14" st-sort="book_cheque_no">Voucher No</th>
											<th class="sorting width_12" st-sort="chequedt">Cheque
												Date</th>
											<th class="sorting width_8" st-sort="bookdr">Narration</th>
											<th class="sorting width_10" st-sort="bookcr">Voucher Type</th>
											<th class="sorting width_10" st-sort="bookcr">Doc Type</th>
											<th class="sorting width_8" st-sort="bank_cheque_no">Credit</th>
											<th class="sorting width_8" st-sort="bankdate">Debit</th>
											<th class="sorting width_18" st-sort="bankdr">Bank Date</th>
											<th class="sorting width_15" st-sort="bankcr">Remarks</th>
										
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body"  ng-controller="bankReconcillationCtrlcal" 
										 data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="(trIndex, objTranslationItem) in bankReconcile.dtl" >
											<td><label class="i-checks m-b-none"> <input
													type="checkbox" ng-if="!isReconcileList"
													ng-model="objTranslationItem.select" id="select{{trIndex}}"><i></i></label></td>
										<td><span
												tooltip="{{objTranslationItem.customer}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.customer"></span></td>
											<td><span
												tooltip="{{objTranslationItem.transaction_no}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.transaction_no"></span></td>
											<td style="background-color: lightsalmon"><span
												tooltip="{{objTranslationItem.book_date}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.book_date"></span></td>
											<td style="background-color: lightsalmon"><span
												tooltip="{{objTranslationItem.book_narration}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.book_narration"></span></td>
												<td style="background-color: lightsalmon"><span
												tooltip="{{objTranslationItem.book_cheque_no}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.book_cheque_no"></span></td>
											<td style="background-color: lightsalmon"><span
												tooltip="{{objTranslationItem.type}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.type"></span></td>
											<td align="right" style="background-color: lightsalmon"><span
												tooltip="{{objTranslationItem.book_credit_amt}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.book_credit_amt| number : 2"></span></td>
											<td align="right" style="background-color: lightsalmon"><span
												tooltip="{{objTranslationItem.book_debit_amt}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.book_debit_amt| number : 2"></span></td>
												
											<!-- <td style="background-color: orange"><span
												tooltip="{{objTranslationItem.bank_cheque_no}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.bank_cheque_no"></span></td> -->
										<!-- 	<td style="background-color: orange">
											<input style="background-color: white"
											 type="text" 
											 tooltip="{{objTranslationItem.bank_cheque_no}}"
												class="tool-tip-span"
												ng-model="objTranslationItem.bank_cheque_no"/></td> -->
												<td ng-if ="isReconcileList">{{objTranslationItem.bank_date}}</td>
											<td style="background-color: lightsalmon" ng-if ="!isReconcileList">
										<div class="col-md-15 inputGroupContainer">
													<div class='input-group date datetimepick col-md-12'>

														<div class="col-md-22 ">
															 <!-- <a  class="dropdown-toggle" id="bank_date{{trIndex}}" role="button"
															data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="bank_date"
																	tooltip="{{objTranslationItem.bank_date}}"
																	validation="date_euro_long|required"
																	
																		friendly-name="Bank Date" class="tool-tip-span" 
																		data-ng-model="objTranslationItem.bank_date" ><span
																		 class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="objTranslationItem.bank_date"
																	data-on-set-time="objTranslationItem.bank_date = onDateSet(newDate)" 
																	data-datetimepicker-config="{ dropdownSelector: '#bank_date{{trIndex}}',startView:'day', minView:'day'}" />
															</ul> -->
															
																						<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="objTranslationItem.bank_date"
										id="bank_date{{trIndex}}"	name="bank_date "	
										friendly-name="bank_date{{trIndex}}"
										data-ng-change="checkDatesCL()"
										 validation="required" />
														</div>

													</div>
												</div>
												<!-- <div class="col-md-15 inputGroupContainer">
													<div class="dropdown">
														<a class="dropdown-toggle" id="bank_date" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="bank_date"
																	validation="date_euro_long|required"
																	friendly-name="bank_date" ng-change="calculateTotal(rowCollection)"
																	data-ng-model="objTranslationItem.bank_date"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker data-ng-model="objTranslationItem.bank_date"
																data-on-set-time="objTranslationItem.bank_date = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#bank_date',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div> -->
											</td>
										<!-- 	<td style="background-color: orange"><span
												tooltip="{{objTranslationItem.bank_debit_amt}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.bank_debit_amt"></span></td>
											<td style="background-color: orange"><span
												tooltip="{{objTranslationItem.bank_credit_amt}}"
												class="tool-tip-span"
												ng-bind="objTranslationItem.bank_credit_amt"></span></td> -->
											<td ng-if="!isReconcileList" class="remarks-td"><input
												type="text" class="form-control input-sm input-remarks" 
												name="remarks{{trIndex}}" id="remarks{{trIndex}}"
												ng-model="objTranslationItem.remarks" ng-blur="objTranslationItem.remarks"/></td>
											<td ng-if="isReconcileList"><span
												tooltip="{{objTranslationItem.remarks}}"
												class="tool-tip-span" ng-if="isReconcileList"
												ng-bind="objTranslationItem.remarks"></span></td>
										
										 <!-- <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="collection in (trIndex, objTranslationItem)"></tr> -->
									</tbody>
								</table>
							</div>

<div class="row">
		<div class="col-sm-12" >
			<div >
										<br><br>
			
		       <div class="col-sm-4">
	       			<div class="form-group">
				        <label class="col-md-5 control-label">Balance as per bank</label>
				        <div class="col-md-7">
				          <input type="text" class="form-control input-sm  text-right" 
				          name="bankBalanceAsPerBank{{trIndex}}" id="bankBalanceAsPerBank{{trIndex}}"
				             ng-model="bankReconcile.bankBalanceAsPerBank| number : 2" disabled /> 
				        </div>
			        </div>
		        
		        
		         </div>
		         
		         
		        
		         <div class="col-sm-4">
			         <div class="form-group">
				         <label class="col-md-5 control-label">Balance as per book</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="balanceAsPerBook" 
				         	data-ng-model="balanceAsPerBook| number : 2"
			         	  			  disabled/>
				        </div>
			        </div>
			        
		        </div>
		          <div class="col-sm-4">
			         <div class="form-group">
				         <label class="col-md-5 control-label">Difference</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right"
				         	 name="difference" data-ng-model="difference| number : 2"
			         	  			step="0.01" disabled />
				        </div>
			        </div>
			        
		        </div>
		         
		  </div>
	     </div>
	     </div>
	     
	     
	     <div class="row" ng-if="details">
		<div class="col-md-12" style=" margin-top: 32px;">
			<div class="form-group pull-right">
	
	<div class="col-md-6">
			         <div class="form-group">
				         <label class="col-md-6 control-label">Unreconciled Receipts</label>
				        <div class="col-md-6">
				         	<input type="text" class="form-control input-sm text-right"
				         	 name="bankReconcile.differenceReceipt" data-ng-model="bankReconcile.differenceReceipt"
			         	  			step="0.01" disabled />
				        </div>
			        </div>
			        
		        </div>
		         <div class="col-md-6">
			         <div class="form-group">
				         <label class="col-md-6 control-label">Unreconciled Payments</label>
				        <div class="col-md-6">
				         	<input type="text" class="form-control input-sm text-right" name="bankReconcile.differencePayment" data-ng-model="bankReconcile.differencePayment"
			         	  			step="0.01" disabled />
				        </div>
			        </div>
			        
		        </div>
	</div></div></div>
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<security:authorize access="hasRole('${form_code}_${add}')">
											<button class="btn btn-danger"
												ng-click="reconcileRecords(displayedCollection)"
												ng-if="!isReconcileList" type="button">Reconcile</button>
										</security:authorize>
									</div>
								</div>
							</div>
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

<script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-12">
			<!--<input type="file"  class="form-control btn-primary" id="file" name="file">-->
			<input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
		</div>
	</div> 
</div>
<div class="modal-footer">
<a class="btn btn-success" href="/tempdoc/BankRecoSample.xlsx" class="control-label">Download sample excel file</a>
	<button class="btn btn-info" type="button" ng-click="uploadBankStatement()">OK</button>
	<button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>