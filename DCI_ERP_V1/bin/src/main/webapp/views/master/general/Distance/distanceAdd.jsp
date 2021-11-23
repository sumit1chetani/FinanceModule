<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" name="distanceAddForm" role="form" novalidate method="post">
    <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
      <fieldset>
       <div class="form-group">
        <label class="col-md-4 control-label"> From Location <span style="color: red;">*</span>
        </label> <label class="col-md-1 control-label"> </label>
        <div class="col-md-5">
         <selectivity list="portList" property="distanceData.fromPort" id="fromPort" name="fromPort" form-name="distanceAddForm" ng-model="distanceData.fromPort" validation="required" friendly-name="From Port"></selectivity>
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label"> To Location <span style="color: red;">*</span>
        </label> <label class="col-md-1 control-label"> </label>
        <div class="col-md-5">
          <selectivity list="portList" property="distanceData.toPort" id="toPort" name="toPort" form-name="distanceAddForm" ng-model="distanceData.toPort" validation="required" friendly-name="To Port"></selectivity>
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label"> Distance (Kms) <span style="color: red;">*</span>
        </label> <label class="col-md-1 control-label"> </label>
        <div class="col-md-5">
         <input type="text" class="text-right form-control input-sm" ng-model="distanceData.disMiles" placeholder="0.0"
           validation="numeric|required" friendly-name="Distance (Nautical Miles)" id="disMiles" name="disMiles" maxlength="10">
        </div>
       </div>
      </fieldset>
     </div>
    </div>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" ng-if="!distanceData.isEdit" ng-click="save(distanceAddForm,distanceData)" type="button">
        <i class="fa fa-save"></i> Save
       </button>
       <button class="btn btn-success" ng-if="distanceData.isEdit" ng-click="update(distanceAddForm,distanceData)" type="button">
        <i class="fa fa-save"></i> Update
       </button>
       <button class="btn btn-info" type="button" ng-if="!distanceData.isEdit" ng-click="reset()">
               <i class="fa fa-undo"></i>
               Reset
              </button>
              <button class="btn btn-info" type="button" ng-if="distanceData.isEdit" ng-click="reset1()">
               <i class="fa fa-undo"></i>
               Reset
              </button>
       <button class="btn btn-danger" ng-click="cancel()" type="button">
        <i class="fa fa-close"></i> Cancel
       </button>
      </div>
     </div>
    </div>
   </form>
  </div>
 </div>
</div>
</div>
</div>
