<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" >
					<header class="ngdialog-header">
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<h2  ng-if=!isEdit>Rate Add </h2>
      				<h2  ng-if=isEdit>Rate Edit</h2>
					<%-- <h2><spring:message code="label.add.loanType"></spring:message> </h2> --%>
					</header>
					<div role="content">
						<div class="widget-body">
       <form class="form-horizontal" name="rateTypeAdd">
        <div class="row">
        <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
           <div class="form-group">
            <label class="col-md-6 control-label">
       		Range From
       		 <span style="color: red;">*</span>
            </label>
            <div class="col-md-6">
             <input type="number" class="form-control input-sm"  name="rangeFrom"
              ng-model="rateAdd.rangeFrom"   validation="required" friendly-name="Range From">
             </div>
           </div>
         
            <div class="form-group">
            <label class="col-md-6 control-label">
           	Range To
           	 <span style="color: red;">*</span>
            </label>
            <div class="col-md-6">
             <input type="number" class="form-control input-sm"  name="rangeTo"
              ng-model="rateAdd.rangeTo"   validation="required" friendly-name="Range To">
             </div>
            </div>
          
           
           <div class="form-group">
            <label class="col-md-6 control-label">
          	Unit Charges
          	 <span style="color: red;">*</span>
            </label>
            <div class="col-md-6">
           <input type="number" class="form-control input-sm"  name="rangeTo"
              ng-model="rateAdd.unitCharge" validation="required" friendly-name="Unit Charges">
            </div>
            </div>
          
           
           </fieldset></div></div>
             <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
          
          <button class="btn btn-success" type="button"
            ng-if="!rateAdd.isEdit"
            ng-click="save(rateTypeAdd)" class="btn btn-success">
            <i class="fa fa-save"></i> Save
           </button>
           <button class="btn btn-success" type="button"
            ng-if="rateAdd.isEdit" class="btn btn-success"
            ng-click="update(rateTypeAdd)">
            <i class="fa fa-save"></i> Update
           </button>
           <button type="reset" class="btn btn-info"
            ng-click="reset(rateTypeAdd)" ng-if="!rateAdd.isEdit">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="reset"
            class="btn btn-success" ng-click="cancel()">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
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