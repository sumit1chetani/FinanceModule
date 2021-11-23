<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" name="vendorNatureForm" novalidate>
    <div class="row">
    
     <div class="col-sm-12 col-md-12 col-lg-12">
       <fieldset>
       
        <div class="form-group" ng-if="isEdit">
         <label class="col-md-4 control-label">Vendor Nature Code <span style="color: red;">*</span></label>
         <div class="col-md-3 inputGroupContainer">
          <input type="text" class="form-control input-sm" name="vendorNatureCode" ng-model="vendorNature.vendorNatureCode" readonly>
         </div>
        </div>
      <!--   <input type="text" validator="required" valid-method="submit" message-id="craneCapacity" id="craneCapacity" class="text-right form-control input-sm"
          name="noRefPoints" ng-model="vesselMasterData.noRefPoints" placeholder="0" ng-pattern-restrict="{{numExp}}"> -->
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Vendor <span style="color: red;">*</span></label>
         <div class="col-md-3" ng-if="!isEdit">
          <selectivity  list="vendorList" property="vendorNature.vendorCode" id="vendorCode"  ></selectivity>
         </div>
         <div class="col-md-3" ng-if="isEdit">
          <selectivity  list="vendorList" property="vendorNature.vendorName" id="vendorName"  ></selectivity>
         </div>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Nature <span style="color: red;">*</span></label>
         <div class="col-md-3">
          <selectivity  list="tdrNatureList" property="vendorNature.tdsNatureCode" id="tdsNatureCode" ></selectivity>
         </div>
        </div>
        
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Type <span style="color: red;">*</span></label>
         <div class="col-md-3">
          <select class="form-control input-sm" name="tdsNatureType" ng-model="vendorNature.tdsNatureType" >
			 <option value="" selected="selected">Select</option>
             <option value="C" >Company</option>
             <option value="I" >Individual</option>
		   </select>
         </div>
        </div>

        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Description </label>
         <div class="col-md-3">
           <textarea ng-model="vendorNature.description" name="description" class="custom-scroll width_100" rows="2">
           </textarea>
         </div>
        </div>
       </fieldset>
      
     </div>
    </div>
    <!-- /row -->
    <br>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" ng-if="!isEdit" type="button" ng-click="submit(vendorNatureForm)">
        <i class="fa fa-save"></i> Save
       </button>
       <button class="btn btn-success" ng-if="isEdit" type="button" ng-click="update()">
        <i class="fa fa-save"></i> Update
       </button>
       <button class="btn btn-info" ng-if="!isEdit" type="reset" ng-click="reset()">
        <i class="fa fa-undo"></i> Reset
       </button>
       <button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
        <i class="fa fa-close"></i> Cancel
       </button>
      </div>
     </div>
    </div>
   </form>
  </div>
 </div>
</div>
