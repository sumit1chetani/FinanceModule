<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" name="budgetAllocationFileUploadForm" novalidate>
    <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-4">
      <fieldset>
       <!--  <div class="form-group">
                    <label class="col-md-4 control-label">Vessel
                        <span style="color: red;">*</span>
                       </label>
                      <div class="col-md-5">                     
                        <selectivity  list="vesselList" property="budgetActuals.vesselCode" id="vesselCode" ></selectivity>
                      </div>                   
            </div> -->
            
       <div class="form-group form-group-label-left">
        <label class="col-md-4 col-md-offset-1 control-label">Company</label>
        <div class="col-md-7 inputGroupContainer">
         <select ng-model="budgetActuals.vesselCodeList" multiple="multiple" id="vesselCode" name="vesselCode" ng-options="option.text as option.text for option in vesselCodeList">
         </select>
        </div>
       </div>
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-12 col-lg-4">
      <fieldset>
        <div class="form-group form-group-label-left">
          <label for="inputPassword" class="control-label col-md-5">From Date </label>
          <div class="col-md-7">
           <div class="input-group input-append date" id="budget_from_date">
            <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="budgetActuals.fromDate" name="fromDate" id="fromDate">
            <span class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
            </span>
           </div>
          </div>
         </div>
      </fieldset>
     </div>
       <div class="col-sm-12 col-md-12 col-lg-4">
      <fieldset>
         <div class="form-group form-group-label-left">
          <label for="inputPassword" class="control-label col-md-5">To Date </label>
          <div class="col-md-7">
           <div class="input-group input-append date" id="budget_to_date">
            <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" ng-model="budgetActuals.toDate" name="toDate" id="toDate">
            <span class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
            </span>
           </div>
          </div>
         </div>
      </fieldset>
     </div>
    </div>
    <br>
    <div class="form-actions">
     <div class="row" id="budgetActualsExportId">
      <div class="col-md-12">
       <button class="btn btn-primary" type="button" ng-click="exportToExcel()">
        <i class="fa fa-download"></i> Export to Excel
       </button>
       <button class="btn btn-info " type="reset">
        <i class="fa fa-undo"></i> Reset
       </button>
       <button class="btn btn-danger" type="reset" ng-click="cancel()">
        <i class="fa fa-close"></i> Cancel
       </button>
      </div>
     </div>
    </div>
   </form>
  </div>
 </div>
</div>
<script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
   <button class="btn btn-info" type="button" ng-click="uploadBudgetAllocation()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>
