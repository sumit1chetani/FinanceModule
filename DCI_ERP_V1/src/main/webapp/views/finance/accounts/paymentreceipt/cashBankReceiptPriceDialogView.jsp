 <style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 75%;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>
      Invoice Details
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="cashBankReceiptPricePopupForm"  novalidate  method="post">
        <div class="row">
        	<div class="col-lg-12 col-sm-12 col-md-12 padding-top-10">
				<div role="content">
			      <div class="widget-body no-padding">
			       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
			        data-st-table="displayedCollection" data-st-safe-src="rowCollection">
			        <table id="dt_basic"
			         class="table table-striped table-bordered table-hover dataTable no-footer"
			         role="grid" aria-describedby="dt_basic_info">
			         <thead class="dataTables-Main-Head">
			          <tr>
			           
			           <th class="width_1 table-heading">
			            <label class="i-checks m-b-none">
			             <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(displayedCollection,selectedAll)">
			             <i></i>
			            </label>
			           </th>
			           
			           <th class="sorting width_10" data-st-sort="receiptCollections.gInvoiceNo">Invoice. No</th>
			           <th class="sorting width_10" data-st-sort="receiptCollections.bcInvAmt">BC Inv Amt</th>
			          
			           <th class="sorting width_10" data-st-sort="receiptCollections.tcInvAmt">TC Inv Amt</th>
			          
			           <th class="sorting width_8" data-st-sort="receiptCollections.currency">Currency</th>
			           <th class="sorting width_8" data-st-sort="receiptCollections.exchangeRate">Exg Rate</th>
			           <th class="sorting width_10" data-st-sort="receiptCollections.bcPaidAmt">BC Paid Amt </th>
			           <th class="sorting width_10" data-st-sort="receiptCollections.tcPaidAmt">TC Paid Amt</th>			           
			           
			          </tr>
			         </thead>
			         <tbody class="dataTables-Main-Body">
			          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="receiptCollections in displayedCollection">
			            <td>
							<label class="i-checks m-b-none"> 
							<input type="checkbox" data-ng-model="receiptCollections.select" ng-change="checkPaidAmount(displayedCollection)"><i></i></label>
						</td>
			           <td class="width_10" ng-bind="receiptCollections.gInvoiceNo"></td>
			           <td class="width_10" ng-bind="receiptCollections.bcInvAmt"></td>
			         
			           <td class="width_10" ng-bind="receiptCollections.tcInvAmt"></td>
			          
			           <td class="width_8" ng-bind="receiptCollections.currency"></td>
			           <td class="width_8" ng-bind="receiptCollections.exchangeRate"></td>
			            <td class="width_8" ng-bind="receiptCollections.bcPaidAmt"></td>
			             <td class="width_8" ng-bind="receiptCollections.tcPaidAmt"></td>
			         
			          </tr>
			         </tbody>
			        </table>
			       </div>
			      </div>		     
				</div>
	    	</div> 
        </div>
        </form>
		 	   
         
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">           
         
                      
          <%--  <button type="reset" class="btn btn-info"
            ng-click="reset(purchaseOrderRequestForm)">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button> --%>
           <button class="btn btn-danger" type="button"
            class="btn btn-success" ng-click="cancelInvoicePriceDialog()">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
    
         </div>
        </div>
      
      </div> <!-- end widget content -->
     </div> <!--/standard-datatable-widget -->
   </article> <!-- WIDGET END -->
  </div>
 </section>
</div>
