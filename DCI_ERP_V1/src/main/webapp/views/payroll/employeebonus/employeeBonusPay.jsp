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
        <form class="form-horizontal" name="employeeBonusPay">
        <div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
           <!--  <div class="form-group">
        <label class="col-md-6 control-label">Bonus Id </label>
        <div class="col-md-4">
       <input type="text" class="form-control" name="Bonus Id" value="" data-ng-model="employeebonus.bonusId"  readonly>
              
        </div>
       </div> -->
           <div class="form-group">
        <label class="col-md-6 control-label">Employee Id </label>
        <div class="col-md-4">
       <input type="text" class="form-control" name="Employee Id" value="" data-ng-model="employeebonus.employeeId"  readonly>
              
        </div>
       </div>
        <div class="form-group">
        <label class="col-md-6 control-label">Employee Name  </label>
        <div class="col-md-4">
       <input type="text" class="form-control" name="Employee Name" value="" data-ng-model="employeebonus.employeeName"  readonly> 
              
        </div>
       </div>
        <div class="form-group">
        <label class="col-md-6 control-label">Declared Amount  </label>
        <div class="col-md-4">
    	   <input type="number" class="form-control" name="Declared Amount" value="" data-ng-model="employeebonus.declaredAmount" readonly>  
        </div>
       </div>
        <div class="form-group">
        <label class="col-md-6 control-label">Paid amount<span style="color:red;">*</span></label>
        <div class="col-md-2">
       <!--  <input type="number" min="1" max="999" /> -->
          <input type="text"  max="employeebonus.balanceAmount" ng-pattern-restrict="^[0-9.]*$" class="form-control" name="paidAmount" data-ng-model="employeebonus.paidAmount" validation="required" friendly-name="Paid Amount"> 
        </div>
         <div class="col-md-2">
           <input type="number" class="form-control" name="Paid amount" value="" data-ng-model="employeebonus.balanceAmount" readonly> 
        </div>
       </div>
         <div class="form-group">
        <label class="col-md-6 control-label">Paid On<span style="color:red;">*</span></label>
        <div class="col-md-4">
        
        	 <div class='input-group date datetimepick'>
               <div class="dropdown">
                <a class="dropdown-toggle" id="periodFrom" role="button" data-toggle="dropdown"
                 data-target="#" href="#">
                 <div class="input-group">
                  <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="paidOn"
                   validation="required" friendly-name="Paid On" id="paidOn"
                   data-ng-model="employeebonus.paidOn"><span
                   class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                 </div>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                 <datetimepicker data-ng-model="employeebonus.paidOn"
                  data-on-set-time="employeebonus.paidOn = onDateSet(newDate);"
                  data-datetimepicker-config="{ dropdownSelector: '#periodFrom',startView:'day', minView:'day'}" />
                </ul>
               </div>
              </div>
        
        	
		</div>  
        </div>
        </fieldset>
       </div>
         
           </div>
            </form>
           
           </div>
             <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" class="btn btn-success" type="button" ng-click="submit(employeeBonusPay)">
            <i class="fa fa-save"></i>
            Save
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
          </div>
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