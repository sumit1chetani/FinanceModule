<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
	<%@include file="/views/templates/panel-header-form.jsp"%>	
		<div class="panel-heading font-bold"></div>
		<div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-6 col-lg-6 ">
				<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label  bold">Customer Company</label>
							<div class="col-md-8">
								<label class="col-md-7 control-label  vessel-text" ng-bind="cuscompany"></label>
							</div>
						</div>
					</fieldset>
				
				
					<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label  bold">Customer</label>
							<div class="col-md-8">
								<label class="col-md-7 control-label  vessel-text" ng-bind="customerName"></label>
							</div>
						</div>
					</fieldset>
				</div>
				
				<div class="col-sm-12 col-md-6 col-lg-6 ">
				<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label  bold">Supplier Company</label>
							<div class="col-md-8">
								<label class="col-md-7 control-label  vessel-text" ng-bind="supcompany"></label>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label  bold">Supplier</label>
							<div class="col-md-8">
								<label class="col-md-7 control-label  vessel-text" ng-bind="supplierName"></label>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
			<div class="row m-t-sm">
			
			
			
				<!-- <div class="col-sm-12 col-md-6 col-lg-6 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label  bold">Set Off Date</label>
							<div class="col-md-8">
								<label class="col-md-7 control-label  vessel-text" ng-bind="setOffDate"></label>
							</div>
						</div>
					</fieldset>
				</div>
				 -->
			
			</div>
		</div>
	</div>

<div class="row">
	<div class="panel-body float-left padding-0">
	  <div class="col-md-6">
	   <div class="table-responsive" >
	   <table class="table table-striped table-bordered table-hover dataTable no-footer">
	   	<thead class="dataTables-Main-Head">
	   		<tr role="row">
	     	  <th >Customer Invoices</th>
	     	</tr>
	   	</thead>
	   </table>
	    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
	     <thead class="dataTables-Main-Head">     	
	      <tr role="row">
	      
	       <th class="sorting width_8 padding-both-side-2" >Inv No</th>
	       <th class="sorting width_8 padding-both-side-2" >Inv Amt</th>
	       <th class="sorting width_12 padding-both-side-2" >TC Amt</th>
	       <th class="sorting width_12 padding-both-side-2" >BC Amt</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objpendingCustomerInvoice) in pendingCustomerInvoices">
	       <td>
	         <span tooltip="{{objpendingCustomerInvoice.invoiceNo}}" class="tool-tip-span" ng-bind="objpendingCustomerInvoice.invoiceNo"></span>
	       </td>
	       <td>
	        <span tooltip="{{objpendingCustomerInvoice.invoiceAmount}}" class="tool-tip-span" ng-bind="objpendingCustomerInvoice.invoiceAmount"></span>
	       </td>
	         <td>
	        <span tooltip="{{objpendingCustomerInvoice.tcAmount}}" class="tool-tip-span" ng-bind="objpendingCustomerInvoice.tcAmount"></span>
	       </td>
	       <td>
	        <span tooltip="{{objpendingCustomerInvoice.bcAmount}}" class="tool-tip-span" ng-bind="objpendingCustomerInvoice.bcAmount"></span>
	       </td>
	     
	      </tr>
	     </tbody>
	    </table>
	   </div>
	  
	  
	  <br>
	  <!-- <div class="form-group hidden-group">
		<label class="col-md-5 control-label">Disputed revenue(Customer)</label>
		<div class="col-md-6">
			<input type="text" data-ng-model="payerDisputedRevenue"
			class="form-control input-sm ng-pristine ng-valid ng-touched" readonly></input>
		</div>
		</div> -->
	  	
	  </div>
	  <div class="col-md-6">
	   <div class="table-responsive" >
	   <table class="table table-striped table-bordered table-hover dataTable no-footer">
	   	<thead class="dataTables-Main-Head">
	   		<tr role="row">
	     	  <th >Supplier Invoices</th>
	     	</tr>
	   	</thead>
	   </table>
	    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
	     <thead class="dataTables-Main-Head">     	
	      <tr role="row">
	      
	       <th class="sorting width_8 padding-both-side-2" >Inv No</th>
	       <th class="sorting width_12 padding-both-side-2" >TC Amt</th>
	       <th class="sorting width_12 padding-both-side-2" >BC Amt</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objpendingCustomerInvoice) in pendingSupplierInvoices">
	       <td>
	         <span tooltip="{{objpendingCustomerInvoice.invoiceNo}}" class="tool-tip-span" ng-bind="objpendingCustomerInvoice.invoiceNo"></span>
	       </td>
	       <td>
	        <span tooltip="{{objpendingCustomerInvoice.tcAmount}}" class="tool-tip-span" ng-bind="objpendingCustomerInvoice.tcAmount"></span>
	       </td>
	       <td>
	        <span tooltip="{{objpendingCustomerInvoice.bcAmount}}" class="tool-tip-span" ng-bind="objpendingCustomerInvoice.bcAmount"></span>
	       </td>
	      </tr>
	     </tbody>
	    </table>
	   </div>
	  
	  	 <br>
	  <div class="form-group hidden-group">
		<label class="col-md-5 control-label">{{accountCode}}</label>
		<div class="col-md-6" ng-if="supplierDisputedRevenue !=0">
			<input type="text" data-ng-model="supplierDisputedRevenue"
			class="form-control input-sm ng-pristine ng-valid ng-touched" readonly></input>
		</div>
	</div>
	  </div>
	  </div>
  </div>
 
	 <br>
    <div class="row">
		<div class="col-sm-12 col-md-12 col-lg-12">
			<div class="form-group">
				
				<label class="col-md-3 control-label"> Customer's Total</label>
				<div class="col-md-3">
					<input type="text" class="form-control input-sm"
						ng-model="totalCustomerBCAmount" readonly
						name="BC Total">
				</div>
				
				<label class="col-md-3 control-label"> Supplier's Total</label>
				<div class="col-md-3">
					<input type="text" class="form-control input-sm"
						ng-model="totalSupplierBCAmount" readonly
						name="BC Total">
				</div>
				
			</div>
		</div>
	</div>
	
   <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   					<button class="btn btn-danger" ng-click="cancel()" type="button">Back to List</button>
   				</div>
   			</div>
   	   	</div>
  </div>
