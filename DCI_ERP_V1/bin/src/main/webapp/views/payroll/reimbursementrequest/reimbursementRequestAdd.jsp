<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
	<!-- widget grid -->
	<section widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs>  </span>
					</header>
					<div role="content">
						<div class="widget-body">
							<div class="dataTables_wrapper for-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
							<form class="form-horizontal" name="reimbursememtReqAddForm" role="form" >
								<div class="row">
									<fieldset>
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5" ng-if="!reimbursementReq.isEdit">
					 								<selectivity list="companyList" property="reimbursementReq.companyId" 
										                id="companyId" ng-model="reimbursementReq.companyId"
										               name="companyId" form-name="reimbursememtReqAddForm" ng-if="companyList.length > 1"
										               validation="required" friendly-name="Hospital">
										               </selectivity>
										               <input type="text" class="form-control input-sm" ng-model="reimbursementReq.companyName" message-id="companyId" 
        							 						name="Hospital Name"  ng-if="companyList.length ==1"readonly>
										               </div>
										          <div class="col-md-5" ng-if="reimbursementReq.isEdit">     
										               <input type="text" class="form-control input-sm" ng-model="reimbursementReq.companyName" message-id="companyId" 
        							 						name="Hospital Name"  ng-if="reimbursementReq.isEdit"readonly>
			                       	 	
													</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5" ng-if="!reimbursementReq.isEdit">
												<selectivity list="departmentList" property="reimbursementReq.departmentId" 
										                id="departmentId" ng-model="reimbursementReq.departmentId"
										               name="departmentId" form-name="reimbursememtReqAddForm" 
										               validation="required" friendly-name="Department">
										         </selectivity>
						           				
											    </div>
											    <div class="col-md-5">
												 <input type="text" class="form-control input-sm" name="Department" ng-if="reimbursementReq.isEdit"
					             							 ng-model="reimbursementReq.departmentName" readonly> 
												
											    
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Reimbursement Type
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5" ng-if="!reimbursementReq.isEdit">
						           					
										   			<selectivity list="reimbursementTypeList" property="reimbursementReq.reimbursementTypeId" 
										                id="reimbursementTypeId" ng-model="reimbursementReq.reimbursementTypeId"
										               name="reimbursementTypeId" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="Reimbursement Type">
										   		
													</div>
													<div class="col-md-5" ng-if="reimbursementReq.isEdit">
													<selectivity list="reimbursementTypeList" property="reimbursementReq.reimbursementTypeId" 
										                id="reimbursementTypeId" ng-model="reimbursementReq.reimbursementTypeId"
										               name="reimbursementTypeId" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="Reimbursement Type" disabled>
										   			
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Currency
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5" ng-if="!reimbursementReq.isEdit">
												<selectivity list="currencyList" property="reimbursementReq.currencyCode" 
										                id="currencyCode" ng-model="reimbursementReq.currencyCode"
										               name="currencyCode" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="Currency">
						           					
													</div>
													<div class="col-md-5" ng-if="reimbursementReq.isEdit">
													<selectivity list="currencyList" property="reimbursementReq.currencyCode" 
										                id="currencyCode" ng-model="reimbursementReq.currencyCode"
										               name="currencyCode" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="Currency">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Remarks</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="Description"
					             							 ng-model="reimbursementReq.description">
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5" ng-if="!reimbursementReq.isEdit">
												 <selectivity list="branchList" property="reimbursementReq.branchId" 
										                id="branchId" ng-model="reimbursementReq.branchId"
										               name="branchId" form-name="reimbursememtReqAddForm" ng-if="branchList.length > 1"
										               validation="required" friendly-name="Branch">
										         </selectivity>
										         	<input type="text" class="form-control input-sm" ng-model="reimbursementReq.branchId" message-id="branchId" 
        							 					name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0" readonly> 
										         </div>
										         <div class="col-md-5" ng-if="reimbursementReq.isEdit">
						           					
													 	<input type="text" class="form-control input-sm" ng-model="reimbursementReq.branchName" message-id="branchId" 
        														 name="Hospital Name" readonly>    
														
												</div>
												
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Name
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5" ng-if="!reimbursementReq.isEdit">
												<selectivity list="employeeList" property="reimbursementReq.employeeId" 
										                id="employeeId" ng-model="reimbursementReq.employeeId"
										               name="employeeId" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="Employee Name">
										         </selectivity>
										         </div>
										         <div class="col-md-5">
								           				<input type="text" class="form-control input-sm" name="Amount"
					             							ng-if="reimbursementReq.isEdit" ng-model="reimbursementReq.employeeName" readonly>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">PaymentMode
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
												<selectivity list="paymentList" property="reimbursementReq.paymentMode"  data-ng-if="!reimbursementReq.isEdit"
										                id="paymentMode" ng-model="reimbursementReq.paymentMode"
										               name="paymentMode" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="PaymentMode">
										         </selectivity>
										         <selectivity list="paymentList" property="reimbursementReq.paymentMode"  data-ng-if="reimbursementReq.isEdit"
										                id="id" ng-model="reimbursementReq.paymentMode"
										               name="id" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="PaymentMode">
										         </selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label" >Amount
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<input type="text" class="form-control input-sm" name="Amount"
					             							 ng-model="reimbursementReq.amount" validation="required" friendly-name="Amount" phonenumbers-only>
												</div>
												<span class="pull-left line-height-30">Rupees</span>
											</div>
										</div>
										</div>
									<div class="col-sm-8 col-md-8 col-lg-8 padding-right-50">
											<!-- <div class="form-group">
												<label class="col-sm-4 col-md-4 col-lg-4 control-label">Remarks
												</label>
												<div class="col-md-3">
						           					<input type="text" class="form-control input-sm" name="Description"
					             							 ng-model="reimbursementReq.description">
												</div>
											</div> -->
										  <div class="form-group">
        <label class="col-md-4 control-label">
        Attachment
         
        </label>
        <div class="col-md-4">
         <input type="file" name="fileName" ng-model="reimbursementReq.fileName" class="form-control" onchange="angular.element(this).scope().uploadDocFile(this)"
           			  accept=".docx,.xls,.png,.jpg,.pdf" style=" width: 94.5%; "/> <br> 
        </div>
        <button class="btn btn" type="button" ng-click="uploadDocument()">Upload</button>
       </div>
								</div>
								</fieldset> 
								</div>
							<div class="form-actions">
							      <div class="row">
								       <div class="col-md-12">
								      		<button class="btn btn-success" type="button" data-ng-click="save(reimbursememtReqAddForm)"
												 data-ng-if="!reimbursementReq.isEdit">
												<i class="fa fa-save"></i> <spring:message code="label.save"></spring:message>
											</button>
				             				<button class="btn btn-success" type="submit" data-ng-click="update(reimbursememtReqAddForm)"
												 data-ng-if="reimbursementReq.isEdit">
												<i class="fa fa-save"></i> <spring:message code="label.update"></spring:message>
											</button>
								           	<button class="btn btn-info ng-scope" type="button"  data-ng-if="!reimbursementReq.isEdit"
								           		class="btn btn-success" ng-click="reset()">
												<i class="fa fa-undo"></i> <spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
								          		<i class="fa fa-close"></i> <spring:message code="label.cancel"></spring:message>
								            </button>
						             	</div>
							      </div>
							     </div>
							     
							</form>
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