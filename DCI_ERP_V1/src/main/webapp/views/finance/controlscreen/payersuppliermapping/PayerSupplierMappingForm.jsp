<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body">
   <form name="payerSuppMapForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
     <div class="col-sm-12">
	    <div class="col-sm-6">	     	
	        <div class="form-group">
		        <label class="col-md-5 control-label">Payer<span style="color:red;"> *</span></label>
		        <div class="col-md-7">
		         	 <selectivity list="payerList" property="payerSupplierMapModelData.payerAcctCode" id="txtPayerAcctCode"
			        form-name="payerSuppMapForm"  validation="required" friendly-name="Payer"
			        name="Payer" ng-model="payerSupplierMapModelData.payerAcctCode"></selectivity>			 
		        </div>
		    </div>
		</div>
	    <div class="col-sm-6">
	     	<div class="form-group" >
		        <label class="col-md-5 control-label">Supplier<span style="color:red;"> *</span></label>
		        <div class="col-md-7">
		        	 <selectivity list="supplierList" property="payerSupplierMapModelData.supplierAcctCode" id="txtVendorAcctCode"
			        form-name="payerSuppMapForm"  validation="required" friendly-name="Supplier"
			        name="Supplier" ng-model="payerSupplierMapModelData.supplierAcctCode"></selectivity>			 
		        </div>
	       	</div>
	    </div>
    </div>
   </div>
    <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="content">
      	<div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-success" type="button" ng-click="submit(payerSuppMapForm,payerSupplierMapModelData)" >
           <i class="fa fa-save"></i>
           Save
          </button>
        
          <button class="btn btn-danger" ng-click="cancel()" type="button">
           <i class="fa fa-close"></i>
           Cancel
          </button>
         </div>
        </div>
       </div>
      </div>
     </div>
    </div>
	 
   </form>
  </div>
 </div>
</div>