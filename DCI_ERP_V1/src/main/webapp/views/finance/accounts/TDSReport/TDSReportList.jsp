<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style type="text/css">
.main_container{
	overflow:auto;
}
</style>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="padding-top-10">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header>
     		<%@include file="/views/templates/panel-header-form.jsp"%>		
     
     <!--  <span class="widget-icon"> <i class="fa fa-table"></i>
      </span> <span><state-breadcrumbs></state-breadcrumbs></span> -->
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="tdsform" novalidate method="post">
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
			        <label class="col-md-5 control-label">Organization Name<span style="color:red;"> *</span></label>
			        <div class="col-md-7">				       
				        <selectivity list="companyList" property="budgetReportData.companyName"  ng-model="budgetReportData.companyName" 
								        id="companyCode" name="organizationName" object="company" validation="required" 
								        friendly-name="	companyName" form-name = "cashBankcomPaymentForm"></selectivity>					        
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
	    
		</div> <!-- /row -->
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
		href="filePath/TdsReport.xls" download="TdsReport.xls"></a>
       </button>
          <button class="btn btn-primary" ng-click="exportPDF()" type = "button">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="exportPDF" stype="display:none"
											href="filePath/TdsReport.pdf"
											download="TdsReport.pdf"></a>
									</button>	
                        
		       <!--  <button class="btn btn-danger"  type="button" class="btn btn-success" ng-click="cancel()">
		        <i class="fa fa-close"></i>
		        Cancel
		       </button> -->
          </div>
          </div>
          </div>
       </form>
      </div>
      <!-- end widget content -->
     </div>
     
     
     
     
         <div class="panel-body " st-table="displayedCollection"
   st-safe-src="rowCollection">
   <div class="widget-body no-padding ">
    <div class="table-responsive ">
<table class="table table-striped table-hover dataTable no-footer">
								
              <thead>
             <tr>
                <th class="sorting width_5" st-sort="companyCode">Organization</th>
                  <th class="sorting width_5" st-sort="particulars">Voucher No</th>
                  <th class="sorting width_5" st-sort="entity">Vendor Name</th>
                <th class="sorting width_5" st-sort="ledgerdate">Voucher Date</th>
                <th class="sorting width_5" st-sort="accountCode">Pan No</th>
                <th class="sorting width_5" st-sort="accountCode">Account Code</th>
                <th class="sorting width_5" st-sort="acctName">Account Name</th>
                <th class="sorting width_5" st-sort="bccredit" align ="right">Amount</th>
       
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="userLogItem in displayedCollection">
       <td> {{userLogItem.companyCode}}</td>
       <td>{{userLogItem.particulars}}</td>
        <td>{{userLogItem.entity}}</td>
       <td>{{userLogItem.ledgerdate}}</td>
          <td>{{userLogItem.panno}}</td>
        <td>{{userLogItem.accountCode}}</td>
         <td>{{userLogItem.acctName}}</td>
       <td align ="right">{{userLogItem.bccredit |number:2}}</td>
  </tr>
     </tbody>
    </table>
    </div>
    
    
    
    
    
    



<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
</div>
</div>
    
     <!-- end widget div -->
    </div>  <!-- /standard-datatable-widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
