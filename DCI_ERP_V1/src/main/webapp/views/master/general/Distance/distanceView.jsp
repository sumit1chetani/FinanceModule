<style>
table.dataTable thead .sorting:after {
	content: "";
}

select {
	-webkit-appearance: none;
	padding: 0;
	text-indent: 8px;
	padding: 0 !important;
}

.input-group-addon {
	display: none !important;
}

.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
	{
	background-color: white !important;
	border: 0px !important;
}

.b-grey {
	border: 0px !important;
}
</style>

<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" name="distanceAddForm" role="form" novalidate method="post">
    <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
      <fieldset ng-disabled="viewDisable">
       <div class="form-group">
        <label class="col-md-4 control-label"> From Port
        </label> <label class="col-md-1 control-label"> </label>
        <div class="col-md-5">
         <select class="form-control input-sm" ng-model="distanceData.fromPort" ng-options="por.id as por.text for por in portList">
          	<option value=""></option>
          </select>
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label"> To Port
        </label> <label class="col-md-1 control-label"> </label>
        <div class="col-md-5">
          <select class="form-control input-sm" ng-model="distanceData.toPort" ng-options="por.id as por.text for por in portList">
          	<option value=""></option>
          </select>
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label"> Distance (Kms)
        </label> <label class="col-md-1 control-label"> </label>
        <div class="col-md-5">
         <input type="text" class="text-left form-control input-sm" ng-model="distanceData.disMiles" placeholder="0.0"
           validation="required|numeric" friendly-name="Distance (Nautical Miles)" id="disMiles" name="disMiles">
        </div>
       </div>
      </fieldset>
     </div>
    </div>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
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
