<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
	
<style>
div#jqgrid {
	    overflow:auto !important;
}
</style>		
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
			<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
	       <form class="form-horizontal" name="payableAgeWiseSearchForm">
		        <div class="row">
		    	   <div class="col-sm-12 col-md-12 col-lg-12">
		    	   		<div class="col-sm-3 col-md-3 col-lg-3">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> Company
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										 <selectivity list="companyList" property="apAgewise.companyCode" ng-model="apAgewise.companyCode" id="companyCode" name="companyCode"   object="companyCode"></selectivity> 
										
									
									</div>
									
								</div>
							</fieldset>
						</div>

						<div class="col-sm-3 col-md-3 col-lg-3">
							<fieldset>
								<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">To Date
										<span style="color: red;">*</span></label>
										<div class="col-md-7">
												<div class="input-group input-append date" id="ap_toDate">
			   									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
			   									ng-model="apAgewise.toDate" name="toDate" id="toDate">
												 <span class="input-group-addon add-on">
			           								<span class="glyphicon glyphicon-calendar"></span>
			       								 </span>
							     				</div>
										</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
										<label for="inputPassword" class="control-label col-md-4">Type
										</label>
										<div class="col-md-7">
												<selectivity list="typeList"
												property="apAgewise.type"
												ng-model="apAgewise.type" name="type"
												 friendly-name="Type">
										</selectivity>
										</div>
								</div>
						</div>

						<div class="col-sm-3 col-md-3 col-lg-3">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> Supplier
										<!-- <span style="color: red;">*</span> -->
									</label>
									<div class="col-md-7">
									<selectivity list="customerList" 
									property="apAgewise.srvcPrtnrBin" ng-model="apAgewise.srvcPrtnrBin"  id="Customer"  name="Customer"
									object="Customer"></selectivity>
									</div>
								</div>
							</fieldset>
						</div>
					</div>	
	        	</div>

	        	
		       <div class="form-actions">
		         <div class="row">
			          <div class="col-md-12 ">
			          	<security:authorize access="hasRole('${form_code}_${view}')">
							<button  type="button" class="btn btn-success" ng-click="viewAPPayableAgewisewithcurrency();">
				            	<i class="fa fa-search" type="button"></i>View Report with Currency
				            </button>
				            </security:authorize>
			          	<security:authorize access="hasRole('${form_code}_${view}')">
							<button  type="button" class="btn btn-success" ng-click="viewAPPayableAgewise();">
				            	<i class="fa fa-search" type="button"></i>View Report
				            </button>
				            </security:authorize>
				           <security:authorize access="hasRole('${form_code}_${export}')"> 
				            <button   type="button"class="btn btn-primary" ng-click="exportAPPayableAgewise();">
		            			<i class="fa fa-search" type="button"></i>Export Excel
		       				</button>
		       			</security:authorize> 
				            <button type="button" class="btn btn-info" ng-click="reset();">
				           		 <i class="fa fa-undo"></i>Reset
				            </button>
			          </div>
			     </div>
				</div>

		     <a id="APPayableExport" type="display:none"
						href="filePath/AccountPayable.xls"
						download="AccountPayable.xls"></a>
				<div class="row" ng-show="isPrimary!=dummy">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10"
						id="jqgrid">
						<table id="apAgewiseReportGrid"></table>
						<div id="apAgewiseReportGridPage"></div>
					</div>
				</div>
				<div class="row" ng-show="isPrimary==dummy">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10"
						id="jqgrid">
						<table id="apAgewiseReportGridTCAmount"></table>
						<div id="apAgewiseReportGridPageTCAmount"></div>
					</div>
				</div>
		       
	    	</form>
	    </div><br/><br/><br/><br/><br/>
	</div> 
   </div> 
   


