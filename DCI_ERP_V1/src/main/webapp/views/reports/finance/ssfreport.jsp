<div class="panel panel-default">
<div class="panel-heading font-bold">Pie Chart</div>     
<div class="panel-body text-center">  
    <form name="mloreport" class="form-horizontal container ng-pristine ng-valid" ng-submit="viewReport()">
        <div class="row book-widget-row">
         <div class="col-sm-12 col-md-4 col-lg-4">
          <fieldset>
           <div class="form-group">
            <label class="col-md-5 control-label">MLO</label>
            <div class="col-md-7">
            <select class="form-control input-sm" name="company"
			data-ng-model="ssf.mloShortName"
			data-ng-options="objCompany.text as objCompany.text  for objCompany in mloList "
			required data-ng-change="isRecordExsist = false;isShow = false">
			<option value="" selected="selected">Select</option>
			</select>
            </div>
           </div>
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-4 col-lg-4">
          <fieldset>
           <div class="form-group">
            <label class="col-md-5 control-label">Slot Account</label>
            <div class="col-md-7">
             <select class="form-control input-sm" name="pod" ng-model="ssf.slotId" 
             data-ng-options="objSlot.mloShortName as objSlot.mloShortName  for objSlot in slotList" data-ng-change="isRecordExsist = false;isShow = false" required>
             <option value="" selected="selected" class="">Select</option>
             </select>
            </div>
           </div>
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-4 col-lg-4">
          <fieldset>
           <div class="form-group">
            <label class="col-md-5 control-label">Year</label>
            <div class="col-md-6">
            <select class="form-control input-sm" name="year"
			data-ng-model="ssf.year"
			data-ng-options="val as val  for (key,val) in yearList 
			track by val" data-ng-change="isRecordExsist = false;isShow = false"
			required>
			</select>
            </div>
           </div>
          </fieldset>
         </div>
         <div class="col-md-12 text-center" style="padding-bottom:10px;">
           <button class="btn btn-primary" type="submit"  tooltip="View">
            View Report
           </button>
          </div>
        </div>
       </form>
    <div class="col-lg-6" data-ng-hide="!isShow">
      <div class="panel panel-default">
         <div class="panel-heading font-bold">{{ssf.mloShortName}} With {{ssf.slotId}}</div>
          <div class="panel-body">
          <div ui-jq="sparkline"  ui-options="data_mlo = {{mlo}}, {type:'pie', height:254, sliceColors:['{{app.color.info}}','#eaeeea']}" 
          ui-refresh="data_mlo" class="sparkline inline"></div>
          <div class="line pull-in"></div>
          <div class="text-xs">
            <i class="fa fa-circle text-info"></i> {{mlo[0]}}
            <i class="fa fa-circle text-muted m-l"></i> {{mlo[1]}}
          </div>
          </div>
      </div>
    </div>
    
     <div class="col-lg-6" data-ng-hide="!isShow">
      <div class="panel panel-default">
        <div class="panel-heading font-bold">{{ssf.mloShortName}} With SSF</div>
          <div class="panel-body">
          <div ui-jq="sparkline" ui-refresh="data_ssf" ui-options="data_ssf = {{slotssf}}, {type:'pie', height:254, sliceColors:['{{app.color.info}}','#eaeeea']}" 
          class="sparkline inline"></div>
          <div class="line pull-in"></div>
          <div class="text-xs">
            <i class="fa fa-circle text-info"></i> {{slotssf[0]}}
            <i class="fa fa-circle text-muted m-l"></i> {{slotssf[1]}}
          </div>
          </div>
      </div>
    </div>
    <div ng-show="isRecordExsist" class="col-md-12 text-center " style="padding-bottom:10px;"><span class="error">No Record Found</span></div>
 </div>   
</div>