<div class="wrapper-md">
 <!-- <div class="panel panel-default panel-default-form"> -->
<div class="panel-heading panel-heading-form font-bold">
<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
   <!-- <ol class="breadcrumb inline-block padding-left-0">
    <li>
     <a>Finance</a>
    </li>
    <li>
     <a x-ui-sref="app.master.controlscreen">Control Screen</a>
    </li>
    <li>
     <a x-ui-sref="app.master.controlscreen.customer">Customer Master</a>
    </li>
    <li>
     <a x-ui-sref="app.master.controlscreen.customer-add">Add</a>
    </li>
   </ol> -->
  </div>
  <div class="panel-body">
      <form class="form-horizontal" name="CustomerMasterForm" ng-submit="save(CustomerMasterForm,CustomerMasterData,isEdit)" novalidate>
    <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>
	       <div class="form-group">
	        <label class="col-md-4 control-label">
	         Customer Name
	         <span style="color: red;">*</span>
	        </label>
	        <label class="col-md-1 control-label" ng-if="CustomerMasterData.edit">{{CustomerMasterData.customerName}}</label>
	        <div class="col-md-5">
	         <input type="text" class="form-control input-sm" name="customerName" ng-model="CustomerMasterData.customerName" ng-blur="Duplicate(CustomerMasterForm.customerName)"
	          ng-if="!CustomerMasterData.edit" required>
	        </div>
	       </div>

         <div class="form-group">
        <label class="col-md-4 control-label">
         Address
           <span style="color: red;">*</span>
        </label>
        <label class="col-md-1 control-label" ng-if="CustomerMasterData.edit">{{CustomerMasterData.address}}</label>
        <div class="col-md-5">
        <textarea ng-model="CustomerMasterData.address" name="address" class="custom-scroll width_100" rows="2" required>
        </div>
       </div>


           <div class="form-group">
        <label class="col-md-4 control-label">     Country Name <span style="color: red;">*</span></label>
       <!--  <label class="col-md-1 control-label" ng-if ="CustomerMasterData.isEdit" >{{CustomerMasterData.location}}</label> -->
        <div class="col-md-5">
         <select class="form-control input-sm" ng-class="{'show-error':CustomerMasterForm.location.$error.required && validated}" name="locationname"
          ng-model="CustomerMasterData.location" data-ng-options="r.location as r.locationname for r in locationList" required>
          <option value="">--Select--</option>
         </select>
        </div>
       </div>


      <!--    <div class="form-group">
            <label class="col-md-4 control-label">Sector<span style="color: red;">*</span></label>
            <label class="col-md-1 control-label" ng-if ="vesselSectorData.isEdit" >{{vesselSectorData.sector}}</label>
            <div class="col-md-5">
             <select class="form-control input-sm" name="sector" ng-model="vesselSectorData.sector" ng-options="d.sector  as d.sector for d in sectorList" ng-class="{'show-error':vesselSectorForm.sector.$error.required&& checked}" ng-if ="!vesselSectorData.isEdit" required>
              <option value="">--Select--</option>
             </select>

            </div>
           </div>  -->



        <div class="form-group">
        <label class="col-md-4 control-label">Purchase Date
         <span style="color: red;">*</span>
         </label>
        <div class="col-md-5">
         <input type="date" class="form-control"   ng-model="CustomerMasterData.purchasedate" required />
        </div>
       </div>




        <div class="form-group">
        <label class="col-md-4 control-label">Purchase Value
         <span style="color: red;">*</span>
         </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="purchasevalue"  ng-model="CustomerMasterData.purchasevalue"  required>
        </div>
       </div>

      </fieldset>
     </div>


     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>

       <div class="form-group">
        <label class="col-md-4 control-label">
         Supplier Name
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <select class="form-control input-sm" ng-class="{'show-error':CustomerMasterForm.suppliername.$error.required && validated}" name="suppliercode"
          ng-model="CustomerMasterData.suppliercode" data-ng-options="r.vendorcode as r.vendorname for r in supplierList" required>
          <option value="" selected="selected">--Select--</option>
         </select>
        </div>
       </div>

     <div class="form-group">
        <label class="col-md-4 control-label">Depreciation Type
        </label>
        <div class="col-md-5">
         <div class="radio">
          <label>
           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.depreciationtype" value="PERCENTAGE" id="percentage" name="depreciationtype" ng-click="viewDepreciationType()"
            checked="checked"  >
           <span>Percentage</span>
          </label>
          <label>
           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.depreciationtype" value="VALUE" id="value" name="depreciationtype" ng-click="viewDepreciationType1()"
            checked="checked" >
           <span>Value</span>
          </label>
         </div>
        </div>

          </div>

       	  <div class="form-group" id="Percentage" style="display: none;">
        <label class="col-md-4 control-label">Percentage
         <span style="color: red;">*</span>
         </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="Percentage"  ng-model="CustomerMasterData.value" ng-click="viewDepreciationType()" required>
        </div>
       </div>

        <div class="form-group" id="Value" style="display: none;">
        <label class="col-md-4 control-label">Value
         <span style="color: red;">*</span>
         </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="Value"   ng-model="CustomerMasterData.value" ng-click="viewDepreciationType1()" required>
        </div>
       </div>


       <div class="form-group" id="Percentage1"  ng-if="CustomerMasterData.edit " ng-show="CustomerMasterData.depreciationtype=='PERCENTAGE'">
        <label class="col-md-4 control-label">Percentage
         <span style="color: red;">*</span>
         </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="Percentage"  ng-model="CustomerMasterData.depreciation" ng-click="viewDepreciationType()"  required>
        </div>
       </div>

        <div class="form-group" id="Value1"  ng-if="CustomerMasterData.edit " ng-show="CustomerMasterData.depreciationtype=='VALUE'">
        <label class="col-md-4 control-label">Value
         <span style="color: red;">*</span>
         </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="Value"   ng-model="CustomerMasterData.depreciation" ng-click="viewDepreciationType1()"  required>
        </div>
       </div>


            <div class="form-group">
        <label class="col-md-4 control-label">
         Account Head Allocation
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <select class="form-control input-sm" ng-class="{'show-error':CustomerMasterForm.accounthead.$error.required && validated}" name="acctheadcode"
          ng-model="CustomerMasterData.acctheadcode" data-ng-options="r.acctheadcode as r.acctheadname for r in accountheadList" required>
          <option value="" selected="selected">--Select--</option>
         </select>
        </div>
       </div>

        <div class="form-group">
           <label for="inputPassword" class="control-label col-md-4">Description
            </label>
           <div class="col-md-5">
            <textarea ng-model="CustomerMasterData.description" name="description" class="custom-scroll width_100" rows="2" required>
            </textarea>
           </div>
          </div>

      </fieldset>
     </div>
    </div>
    <br>

    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
        <button ng-model="add" class="btn btn-success" type="submit" ng-if="!CustomerMasterData.edit" class="btn btn-success">
        <i class="fa fa-plus"></i>
        Save
       </button>

   		<button class="btn btn-primary"  ng-if="!CustomerMasterData.edit" type="button"  ng-click="reset()">
        	<i class="fa fa-reply"></i>
        Reset
       	</button>

       <button class="btn btn-success" ng-if="CustomerMasterData.edit"  type="submit">
        <i class="fa fa-save"></i>
        Update
       </button>

        <button class="btn btn-primary"  ng-if="CustomerMasterData.edit" type="button"  ng-click="reset()">
        	<i class="fa fa-reply"></i>
        Reset
       	</button>


        <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
        <i class="fa fa-close"></i>
        Cancel
       </button>


      		</div>
     	</div>
    	</div>
  	</form>
<!--  </div>
</div>
</div> -->
</div>
</div>

