<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
  									<input type="hidden" value="${form_code}" id="form_code_id">
  				<div class="panel-body">
    			<form name="trialBalanceForm" class="form-horizontal" >
    			<div class="row">
    				<input type="hidden" id="companyCode" value="${user.companyCode}">
					     	<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Company
											<span style="color: red;">*</span>
											<label>${user.companyCode}</label>
										</label>
										<div class="col-md-7">
											<selectivity list="companyList" ng-model="staffLedger.companyCode" property="staffLedger.companyCode" id="companyCode" object="companyCode" name = "companyCode"> </selectivity>
										</div>
									</div>
								</fieldset>
							</div>
					     	
					
					     	<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
             							<label for="inputPassword" class="control-label col-md-5">From Date
             							<span style="color: red;">*</span></label>
            								<div class="col-md-7">
             									<div class="input-group input-append date" id="gl_fromDate">
                									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                									ng-model="staffLedger.fromDate" name="fromDate" id="fromDate">
		           									 <span class="input-group-addon add-on">
                        								<span class="glyphicon glyphicon-calendar"></span>
                    								 </span>
        									     </div>
            								</div>
           							</div>
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
             							<label for="inputPassword" class="control-label col-md-5">To Date
             							<span style="color: red;">*</span></label>
            								<div class="col-md-7">
             									<div class="input-group input-append date" id="gl_toDate">
                									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                									ng-model="staffLedger.toDate" name="toDate" id="toDate">
		           									 <span class="input-group-addon add-on">
                        								<span class="glyphicon glyphicon-calendar"></span>
                    								 </span>
        									     </div>
            								</div>
           							</div>
           					</fieldset>
						</div>
						
						<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Employee
										</label>
										<div class="col-md-7">
											<selectivity list="subAccountCodeList" ng-model="staffLedger.employeeCode" property="staffLedger.employeeCode"  ></selectivity>
										</div>
									</div>
								</fieldset>
						</div>
						
						<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> From Code
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm" ng-model="staffLedger.fromCode" >
										</div>
									</div>
								</fieldset>
						</div>
						
						<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> To Code
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm" ng-model="staffLedger.toCode" >
										</div>
									</div>
								</fieldset>
						</div>
						
						<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Status</label>
										<div class="col-md-7">											
											<!-- <label class="i-checks">
												<input type="checkbox" class="checkbox style-0" checked="checked" ng-false-value = "'N'" ng-true-value = "'Y'" name="isActive" id="isActive" ng-model="staffLedger.isActive">
											<i></i></label> -->
											
											<select class="form-control" property="staffLedger.isActive" ng-model="staffLedger.isActive">
												<option value="Y">Active</option>
												<option value="N">Inactive</option>
												<option value="A">All</option>
											</select>
											
										</div>
									</div>
								</fieldset>
						</div>
						
				</div>
						<a id="SLExport" stype="display:none"
						href="filePath/StaffLedger.xls"
						download="staffLedger.xls"></a>
						<!-- Form Action -->
						<div class="form-actions">
					         <div class="row">
						          <div class="col-md-12 ">
						          		 <security:authorize access="hasRole('${form_code}_${view}')">
           							<button class="btn btn-success" ng-click="viewSubLedgerReport()">
            								<i class="fa fa-search"></i>View Report
           							</button>
           							</security:authorize>
           							 <security:authorize access="hasRole('${form_code}_${export}')"> 
           							<button class="btn btn-primary" ng-click="exportSubLedgerExcel()">
            								Export Excel
           							</button>
           							</security:authorize> 
           							<button class="btn btn-success" class="btn btn-success" ng-click="printStaffLedger()">
						            Print
						           </button>
						           
						        <!--     -->
        							<button class="btn btn-success" class="btn btn-success" ng-click="employeeStatus()">
						            Employee Status
						           </button>
        
						           <button class="btn btn-info" type="reset" class="btn btn-success" ng-click="formreset()">
						            <i class="fa fa-undo"></i>Reset
						           </button>
         						 </div>
        						 </div>
       					</div>
         				<br>
         				<div class="row">
         					<div class="col-xs-12">
         				 		<div id="jqgrid">
									<table id="staffLedgerGrid"></table>
									<div id="staffLedgerPage"></div>
								</div>
							</div>
         				</div>	
					     	

					</form>
				</div> <!-- /panel-body -->
			</div> <!-- /panel-default -->
		</div>
	</div>
</div>