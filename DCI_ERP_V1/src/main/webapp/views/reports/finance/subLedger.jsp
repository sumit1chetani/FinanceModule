	<style>
					ul.multiselect-container{
					    max-height: 200px;
				    overflow-y: auto;
				    overflow-x: hidden;
				    padding-left: 15px;
				    position: relative;
					}
					
					</style>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="breadcrumb-wrapper ng-scope">
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
											<selectivity list="companyList" ng-model="generalLedger.companyCode" property="generalLedger.companyCode" id="companyCode" object="companyCode"  name="companyCode"></selectivity>
										
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
                									ng-model="generalLedger.fromDate" name="fromDate" id="fromDate">
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
                									ng-model="generalLedger.toDate" name="toDate" id="toDate">
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
										<label class="col-md-5 control-label"> Main Account
										<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="accountHeadList" property="generalLedger.mainAccountCode" id="mainAccountCode" object="accountHeadCode"></selectivity>
										</div>
									</div>
								</fieldset>
						</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> SubAccount Code 
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											   <!--  <select id="payer" multiple="multiple"  name="payer"  ng-model="generalLedger.lpayer"
      ng-options="option.id as option.text for option in subAccountCodeList"  >     -->
        <!-- <option data-ng-repeat="option in subAccountCodeList" value="{{getpayer(option)}}" data-ng-bind-template="{{option.text}}"></option> -->
     </select> 
     
     	<select ng-model="lpayer" multiple="multiple"
										id="lpayer" name="lpayer"
										ng-options="option.text for option in subAccountCodeList">
									</select>
									
										</div>
									</div>
								</fieldset>
							</div>
				</div>
						
				<!-- 		<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Sub Account <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="subAccountCodeList" property="generalLedger.subAccountCode" id="subAccountCode" object="subAccountCode"></selectivity>
										</div>
									</div>
								</fieldset>
						</div> -->
				</div>
						<a id="SLExport" stype="display:none"
						href="filePath/subLedger.xlsx"
						download="subLedger.xlsx"></a>
						<div id="exportDiv" style="display:none"></div>
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
            								<i class="fa fa-search"></i>Export Excel
           							</button>
           							 </security:authorize> 
           							
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
									<table id="subLedgerGrid"></table>
									<div id="subLedgerPage"></div>
								</div>
							</div>
         				</div>	
					     	

					</form>
				
				</div> <!-- /panel-body -->
			</div> <!-- /panel-default -->
		</div>
	</div>
</div>