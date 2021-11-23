
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-persist="empFinalSettelmentTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
<div class="panel-body float-left padding-0" style="width: 100%;">
  <br>
			  <form class="form-horizontal" name="employeeFinalSettlementForm" role="form" > 
     	<div class="row">
     	<div class="col-sm-12 col-md-12 col-lg-12 ">
				<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label class="col-md-5 control-label" > Organization
							 <span style="color: red;">*</span>
						</label>
						<div class="col-md-5">
						
								 <!-- <selectivity  list=companyList property="employeeFinalSettlement.companyId" ng-model="employeeFinalSettlement.companyId"
								 								id="companyId"  name="companyId" form-name = "employeeFinalSettlementForm" 
	        												validation="required" friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
				        		
				        		<input type="text" class="form-control input-sm" ng-model="employeeFinalSettlement.companyName" message-id="companyId" 
        						data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="companyList.length == 1" readonly> 
						 -->
						 <selectivity list="companyList"
										property="employeeFinalSettlement.companyId" id="companyId"
										object="companyId"></selectivity></div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Branch
							 <span style="color: red;">*</span>
						</label>
						<div class="col-md-5">
					
							<selectivity  list=branchList property="employeeFinalSettlement.branchId" ng-model="employeeFinalSettlement.branchId" id="branchId"  name="branchId" form-name = "employeeFinalSettlementForm" validation="required" friendly-name="Branch Name" ng-if="branchList.length > 1"></selectivity>
						           						
						           						 <input type="text" class="form-control input-sm" ng-model="employeeFinalSettlement.branchName" message-id="branchId" 
        										data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0" readonly>     	 	 
			        	</div>
					</div>
										
					</div>
			
			
			<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
					<label class="col-md-5 control-label" > Department
						 <span style="color: red;">*</span>
					</label>
					<div class="col-md-5">
					
						 <selectivity  list=departmentList property="employeeFinalSettlement.departmentId" ng-model="employeeFinalSettlement.departmentId" id="departmentId"  name="departmentId" validation="required" friendly-name="Department Name" form-name = "employeeFinalSettlementForm"></selectivity>
					</div>
					</div>
										<div class="form-group">
												<label class="col-md-5 control-label">Employee 
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
														 <selectivity  list=employeeList property="employeeFinalSettlement.employeeId" ng-model="employeeFinalSettlement.employeeId" id="employeeId" validation="required" friendly-name="Employee Name"  name="employeeId" form-name = "employeeFinalSettlementForm" ></selectivity>
												</div>
										</div>
		
				</div>
			
					<div class="form-group">
						<div class="row">
						<div class=" col-sm-12">
									<label class="col-md-5 control-label" >
									</label>
									
										<button class="btn btn-success" type="button" data-ng-click="submit(employeeFinalSettlementForm)">
												Submit
										</button>
									</div>
									</div>		
						</div>
				</div>
			
			</div>
					
			</form>
			<br>
			<br>
								<div class="row">
										<div class=" col-sm-12" data-ng-repeat="(trIndex, table) in employeeFinalSettlement.tables">
											<div class="row padding-top-15">
												<div class="col-md-12">
													<table class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
														<thead>
															<tr>
																<th class="width_1 text-center table-heading">
														            <label ng-if="employeeFinalSettlement.status!='Approved'" class="i-checks m-b-none" >
														             <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(storeToPurchaseData.tables,selectedAll)">
														             <i></i>
														            </label>
													           </th>
																<th class="sorting text-center padding-both-side-2">S.No <span style="color: red;">*</span></th>
																<th class="sorting text-center padding-both-side-2">Description<span style="color: red;">*</span></th>
																<th class="sorting text-center padding-both-side-2">Credit <span style="color: red;">*</span></th>
																<th class="sorting text-center padding-both-side-2">Debit <span style="color: red;">*</span></th>
															</tr>
														</thead>
													  <tbody ng-repeat="(trIndex, storeTableRow) in table.storeTableRow"
															>
															<tr>
																<td><label ng-if="employeeFinalSettlement.status!='Approved'" class="i-checks m-b-none"> <input
																		type="checkbox" data-ng-model="storeTableRow.select" id="section{{trIndex}}"><i></i></label></td>
																		<td class="width_5">{{trIndex+1}}
																		</td>
																<td class="width_15">
																	<div class="row">
																		<div class="col-xs-12">
																			<input ng-if="employeeFinalSettlement.status!='Approved'" type="text" class="form-control input-sm"
																				data-ng-model="storeTableRow.description"  
																				 />
																				<input ng-if="employeeFinalSettlement.status=='Approved'" type="text" class="form-control input-sm"
																				data-ng-model="storeTableRow.description" readonly
																				 />
																		</div>
																	</div>
																</td>
																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input ng-if="employeeFinalSettlement.status!='Approved'"  type="text" class="form-control input-sm"
																				data-ng-model="storeTableRow.credit" ng-change="calculateTotal()" ng-pattern-restrict="^\d{1,20}\.?\d{0,3}$"
																				 />
																				<input ng-if="employeeFinalSettlement.status=='Approved'"  type="text" class="form-control input-sm"
																				data-ng-model="storeTableRow.credit" ng-change="calculateTotal()" ng-pattern-restrict="^\d{1,20}\.?\d{0,3}$"
																				 readonly />
																		</div>
																	</div>
																</td>
																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input ng-if="employeeFinalSettlement.status!='Approved'"  type="text" class="form-control input-sm"
																				data-ng-model="storeTableRow.debit"  ng-change="calculateTotal()" ng-pattern-restrict="^\d{1,20}\.?\d{0,3}$"
																				 />
																				<input ng-if="employeeFinalSettlement.status=='Approved'"  type="text" class="form-control input-sm"
																				data-ng-model="storeTableRow.debit"  ng-change="calculateTotal()" readonly ng-pattern-restrict="^\d{1,20}\.?\d{0,3}$"
																				 />
																		</div>
																	</div>
																</td>

															</tr>
														</tbody>  
													</table>
													<div class="padding-right-5" id="AddOrRmveMeritbtn" >
														<button ng-click="addRow(table)" ng-if="employeeFinalSettlement.status!='Approved'"
															class="btn btn-sm btn-info" tooltip="Add Row" 
															type="button">
															<i class="fa fa-plus"></i>
														</button>
														<button ng-click="removeRow(table)"  ng-if="employeeFinalSettlement.status!='Approved'"
															class="btn btn-sm btn-danger" type="button"
															tooltip="Delete">
															<i class="fa  fa-trash-o"></i>
														</button>
													</div>
													</div>
										</div>
												<div class="col-sm-12">
														<div class="form-group pull-right">
															<label class="col-md-3 control-label">Total Credit Amount</label>
													        <div class="col-md-3">
													         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="totalCredit"
												         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
													        </div>
													        <label class="col-md-3 control-label">Total Debit Amount</label>
													        <div class="col-md-3">
													         	<input type="text" class="form-control input-sm" name="totalBCAmount" data-ng-model="totalDebit"
												         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
													        </div>	        
												       </div>
													</div>
													<br>
												<div class="col-sm-12">
														<div class="form-group pull-right">
														<label class="col-md-5 control-label">Total  Amount</label>
													        <div class="col-md-7">
													         	<input  style="margin-left: 5%;width: 96%;" type="text" class="form-control input-sm" name="grandTotal" data-ng-model="grandTotal"
												         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/"  disabled />
													        </div>
														</div>
													</div> 
													</div>
													</div>
													
		       		<div class="form-actions">
					<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" class="btn btn-success" type="button"   ng-show="isList"  ng-click="save(employeeFinalSettlementForm)">
									  <i class="fa fa-save"></i>
									       Save
						        </button>
								
										<div id="btnRowDivId"> </div>
								</div>
					</div>
			 </div> 
	       
	      </div>
	      </div>
	      
     </div>
   </article>
  </div>
 </section>
</div>