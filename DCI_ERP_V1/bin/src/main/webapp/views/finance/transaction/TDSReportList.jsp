<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<style>
.dropdown-menu>li>a {
	padding: 5px 36px;
}

.form-control {
	border: 1px solid #DDD;
	border-radius: 7px;
	box-shadow: none;
	height: 42px;
	padding: 8px 12px 9px 12px;
}
</style>
<security:authentication var="user" property="principal" />

		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="trialBalanceForm" class="form-horizontal">
						<div class="row">
         <div class="col-sm-12">
		     <div class="col-sm-4">
		     	<div class="form-group" ng-if="edit">
			        <label class="col-md-5 control-label">Voucher No</label>
			        <div class="col-md-7">				       
				        <input type="text" class="form-control  bg-color-none b-none" id="voucherNo" name="Voucher No" ng-model="cashbankpaymentModelData.cbVoucherNo" ng-disabled="true" />				        
			        </div>
		       	</div>
		     
		       	
		       	
		       	 <div class="form-group">
			        <label class="col-md-5 control-label">Company Name<span style="color:red;"> *</span></label>
			        <div class="col-md-7">				       
				        <selectivity list="companyList" property="budgetReportData.companyName"  ng-model="budgetReportData.companyName" 
								        id="companyCode" name="<spring:message
			              			code="label.company.name"></spring:message>" object="company" validation="required" 
								        friendly-name="	<spring:message
			              			code="label.company.name"></spring:message>" form-name = "cashBankcomPaymentForm"></selectivity>					        
			        </div>
		       	</div> 
		     	
		      
			       
		     	
		      	
		     <!--  <div class="form-group">
				        <label class="col-md-5 control-label">TDS DESC</label>
				        <div class="col-md-7">
					         <input type="text" class="form-control input-sm" name="tdsDesc" ng-model="tdscompanyData.tdsDesc"
				          	 id="tdsDesc"  friendly-name="tdsDesc" form-name = "tdsform"/>
				        </div>
		    </div> -->
		      
		     	
		     	 
		    </div>
		    
		    
		    
		    <div class="col-sm-4">
		    
		    
		    <div class="form-group">
				        <label class="col-md-5 control-label">TDS Type</label>
				        <div class="col-md-7">
				        <selectivity list="tdsList" name="financeyear" 
				        property="budgetReportData.financeyear" ng-model="budgetReportData.financeyear" 
				         friendly-name="financeyear" form-name = "cashBankcomPaymentForm" object="financeyear"></selectivity>
					       
				        </div>
		    </div>
		    
		  
		   
		      
	
		    </div>
		    
		    
		    
		      
		    <div class="col-sm-4">
		    
		    
		    <div class="form-group">
				        <label class="col-md-5 control-label">Vendor Name</label>
				        <div class="col-md-7">
				        <selectivity list="vendorList" name="vendor" 
				        property="budgetReportData.vendor" ng-model="budgetReportData.vendor" 
				         friendly-name="vendor" form-name = "cashBankcomPaymentForm" object="vendor"></selectivity>
					       
				        </div>
		    </div>
		    
		  
		   
		      
	
		    </div>
		
	    </div>
	    
		</div>
						<!-- <a id="GLExport" stype="display:none"
							href="filePath/TdsReport.xlsx" download="TdsReport.xlsx"></a> -->
						<!-- Form Action -->
						<div class="form-actions">
							<div class="form-actions">
         <div class="row">
       	 <div class="col-md-12">
         <button class="btn btn-success" type="submit" tooltip="Search"
         ng-click="onSearchpia(ARregister)">
         <i class="fa fa-search"></i> Submit
        </button>
         <button class="btn btn-primary" type="button" data-ng-click="exportExcel()">
        <span class="fa fa-file-excel-o"> Export Excel</span>
         <a id="budgetExport" stype="display:none"
		href="tempdoc/TdsReport.xls" download="TdsReport.xls"></a>
       </button>
		       <!--  <button class="btn btn-danger"  type="button" class="btn btn-success" ng-click="cancel()">
		        <i class="fa fa-close"></i>
		        Cancel
		       </button> -->
          </div>
          </div>
          </div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-12">
								<div id="jqgrid">
									<table id="tdsReportGrid"></table>
									<div id="tdsReportPage"></div>
								</div>
							</div>
						</div>


					</form>
				</div>
				<!-- /panel-body -->
			</div>
			<div class="panel-body " st-table="displayedCollection"
   st-safe-src="rowCollection">
   <div class="widget-body no-padding ">
    <div class="table-responsive ">
<table class="table table-striped table-hover dataTable no-footer">
								
              <thead>
             <tr>
                <th class="sorting width_5" st-sort="companyCode">Company</th>
                <th class="sorting width_5" st-sort="particulars">Voucher No</th>
                <th class="sorting width_5" st-sort="entity">Vendor Name</th>
                <th class="sorting width_5" st-sort="ledgerdate">Voucher Date</th>
                <th class="sorting width_5" st-sort="accountCode">Account Code</th>
                <th class="sorting width_5" st-sort="acctName">Account Name</th>
                <th class="sorting width_5" st-sort="bccredit">Amount</th>
       
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="userLogItem in displayedCollection">
       <td> {{userLogItem.companyCode}}</td>
       <td>{{userLogItem.particulars}}</td>
        <td>{{userLogItem.entity}}</td>
       <td>{{userLogItem.ledgerdate}}</td>
       
        <td>{{userLogItem.accountCode}}</td>
         <td>{{userLogItem.acctName}}</td>
       <td>{{userLogItem.bccredit}}</td>
    
       
    
      </tr>
     </tbody>
    </table>
    </div>
</div>
</div>
			<!-- /panel-default -->
			<br> <br> <br> <br> <br> <br> <br>
			<br>
			<br> <br> <br> <br> <br> <br> <br>
			<br>
		</div>

	