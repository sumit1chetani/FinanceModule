<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id" /> 
  <div class="panel-body">
   <form name="assetSaleForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
     <div class="col-sm-12">
	     <div class="col-sm-6">
	          
	       	<div class="form-group">
				<label class="col-md-6 control-label"> Company
					<span style="color: red;">*</span>
				</label>
				<div class="col-md-6">
					<selectivity  list="companyList" ng-model="assetSale.companyCode" name="Company"
					property="assetSale.companyCode" validation="required" friendly-name="Company" form-name = "assetSaleForm"
					></selectivity>
				</div>
			</div>
	     	
	     	<div class="form-group">
				<label class="col-md-6 control-label"> Asset
					<span style="color: red;">*</span>
				</label>
				<div class="col-md-6">
					<selectivity  list="assetList" ng-model="assetSale.assetCode" name="Asset"
					property="assetSale.assetCode"  validation="required" friendly-name="Asset" form-name = "assetSaleForm"
					></selectivity>
				</div>
			</div>
			
	      	<div class="form-group">
		        <label class="col-md-6 control-label">Customer<span style="color:red;"> *</span></label>
		        <div class="col-md-6 ">
		         <selectivity  list="customerList" ng-model="assetSale.customerCode" name="Asset"
					property="assetSale.customerCode"  validation="required" friendly-name="Customer" form-name = "assetSaleForm"
					></selectivity>
		        </div>
	       	</div>
	       	
	       	
	       	<div class="form-group">
		        <label class="col-md-6 control-label">Contact Person</label>
		        <div class="col-md-6 ">
		         	<input type = "text" class="form-control input-sm" ng-model="assetSale.contactPerson">
		        </div>
	       	</div>
	       	
	       	
	    </div>
	    <div class="col-sm-6">
    		<div class="form-group">
	        <label class="col-md-6 control-label">Date Of Sale</label>
	        <div class="col-md-6">
				<div class="input-group input-append date" id="cn_date" >
					<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" 
							ng-model="assetSale.saleDate" name="Date" id="saleDate"
							validation="required" friendly-name="Customer" >
									 <span class="input-group-addon add-on">
                 								<span class="glyphicon glyphicon-calendar"></span>
      								 </span>
			     </div>
			</div>
	     	</div>
	     	
	     	<div class="form-group">
		        <label class="col-md-6 control-label">Current value(USD)</label>
		        <div class="col-md-6 ">
		         	<input type = "text" class="form-control input-sm" ng-model="assetSale.currentValue"
		         	validation="required" friendly-name="Current Value" name="Current Value" readonly>
		        </div>
	       	</div>
	       	
	       	<div class="form-group">
		        <label class="col-md-6 control-label">Sale value(USD)</label>
		        <div class="col-md-6 ">
		         	<input type = "text" class="form-control input-sm" ng-model="assetSale.saleValue"
		         	validation="required" friendly-name="Sale Value" name="Sale Value">
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
          <button class="btn btn-success" type="button"  ng-click="submit()" >
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