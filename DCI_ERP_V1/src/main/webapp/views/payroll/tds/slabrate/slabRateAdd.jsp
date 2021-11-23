<!-- #MAIN CONTENT -->
<div>
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" >
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs>  </span>
					</header>
					<div role="content">
						<div class="widget-body">
       <form class="form-horizontal" name="slabRateForm" novalidate method="post">
        <div class="row">
        
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
          <div class="form-group" ng-if="slabRate.isEdit">
            <label class="col-md-6 control-label">
            Slab Rate Id
             <span style="color: red;">*</span>
            </label>
            <div class="col-md-3">
      
           
           	<input type="text" class="form-control input-sm" 
              data-ng-model="slabRate.taxRateId" data-ng-if="slabRate.isEdit" name="Slab Rate Id" data-validator="required" data-message-id="taxRateId" data-valid-method="submit" readonly>
           
            </div>
           </div>
          <div class="form-group">
			<label class="col-md-6 control-label">Financial Year
			<span style="color: red;">*</span>
			</label>
			<div class="col-md-3">
			 <selectivity  list=financialYearList  property="slabRate.financialYear" ng-model="slabRate.financialYear" id="financialYear"  name="financialYear" form-name = "slabRateForm" 
	        		validation="required" data-ng-if="!employeehra.isEdit" friendly-name="Month Year"></selectivity> 
			</div>
			</div>
           <div class="form-group">
            <label class="col-md-6 control-label">
             Slab Type
             <span style="color: red;">*</span>
            </label>
            <div class="col-md-3">
            	<selectivity list="payerTypeList" property="slabRate.taxPayerTypeId" ng-model="slabRate.taxPayerTypeId" name="taxPayerTypeId"
            	validation="required" friendly-name="Slab Type" form-name="slabRateForm">
            	</selectivity>
           	</div>
           </div>
         
            <div class="form-group">
            <label class="col-md-6 control-label">
            Range From
           	 <span style="color: red;">*</span>
            </label>
            <div class="col-md-3">
             <input type="text" class="form-control input-sm" name="Range From"
             validation="required" friendly-name="Range From"
              ng-model="slabRate.rangeFrom" phonenumbers-only/>
            </div>
           </div>
            <div class="form-group">
	            <label class="col-md-6 control-label">
	            Range To
	             <span style="color: red;">*</span>	
	            </label>
	            <div class="col-md-3">
	            	<input type="text" class="form-control input-sm" name="Range To"
	            	validation="required" friendly-name="Range To"
             	    ng-model="slabRate.rangeTo" phonenumbers-only/>
	            </div>
            </div>
                    <div class="form-group">
            <label class="col-md-6 control-label">
           		Percentage
             <span style="color: red;">*</span>
            </label>
            <div class="col-md-3">
             <input type="text" class="form-control input-sm" name="Percentage"
             validation="required" friendly-name="Percentage"
              ng-model="slabRate.rateInPercentage" phonenumbers-only/>
            </div></div>
           </fieldset></div></div>
             <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-click="submit(slabRateForm)" data-ng-if="!slabRate.isEdit" >
            <i class="fa fa-save"></i>
            Save
           </button>
          <button class="btn btn-success"  type="button" data-ng-click="update(slabRateForm)"
												data-ng-if="slabRate.isEdit" >
        <i class="fa fa-save"></i>
       Update
       </button>
         <button class="btn btn-info" type="reset" class="btn btn-success" ng-click="reset()">
        <i class="fa fa-undo"></i>
        Reset
       </button> 
       <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
        <i class="fa fa-close"></i>
       Cancel
       </button>
          </div>
         </div>
        </div>
           </form></div>
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