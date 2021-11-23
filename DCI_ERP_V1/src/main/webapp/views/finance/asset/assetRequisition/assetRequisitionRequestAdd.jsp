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
       Add Asset Request
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="assetForm">
        <div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
          	<div class="form-group">
            <label class="col-md-6 control-label"> Asset Code 
            <spring:message code="label.asterisk.symbol"></spring:message>
            </label>
            <div class="col-md-6">
             <select class="form-control input-sm">
              <option value="">Select</option>
             </select>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Asset Name </label>
            <div class="col-md-6">
             <select class="form-control input-sm">
              <option value="">Select</option>
              <option value="name1">name1</option>
              <option value="name2">name2</option>
             </select>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Asset Type </label>
            <div class="col-md-6">
             <select class="form-control input-sm">
              <option value="">Select</option>
              <option value="Type1">Type1</option>
             </select>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Asset Category </label>
            <div class="col-md-6">
             <select class="form-control input-sm">
              <option value="">Select</option>
              <option value="Category1">Category1</option>
             </select>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Quantity </label>
            <div class="col-lg-6">
             <input type="text" class="form-control input-sm">
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> UOM </label>
            <div class="col-md-6">
             <select class="form-control input-sm">
              <option value="">Select</option>
              <option value="gm">gm</option>
              <option value="mg">mg</option>
              <option value="mg">kg</option>
              <option value="ml">ml</option>
             </select>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> EDD </label>
            <div class="col-lg-6">
             <div class='input-group date datetimepick'>
              <div class="dropdown">
               <a class="dropdown-toggle" id="Edd" role="button" data-toggle="dropdown" data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="edd"
                  data-validator="required" data-valid-method="submit" data-message-id="edd"
                  data-ng-model="assetRequisitionRequestData.edd">
                 <span class="input-group-addon">
                  <i class="glyphicon glyphicon-calendar"></i>
                 </span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                <datetimepicker data-ng-model="assetRequisitionRequestData.edd"
                 data-on-set-time="assetRequisitionRequestData.edd = onDateSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#Edd',startView:'day', minView:'day'}" />
               </ul>
              </div>
             </div>
            </div>
           </div>
          </fieldset>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="save(assetForm)" data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="update(assetForm);"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
           </button>
           <button class="btn btn-info" type="button"
            data-ng-click="reset(assetForm)">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="button"
            data-ng-click="cancelReq();">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
         </div>
        </div>
       </form>
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