<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
      <h2>Add Store Approval Request</h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="storeApprovalReqForm">
        <div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
           <div class="form-group">
            <label class="col-md-6 control-label"> Item Code </label>
            <div class="col-md-6">
             <select class="form-control input-sm" ng-model="storeApprovalRequestData.itemCode">
              <option value="">Select</option>
              <option value="D3234">D3234</option>
              <option value="C4658">C4658</option>
             </select>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Item Name </label>
            <div class="col-md-6">
             <!-- select class="form-control input-sm" ng-model="storeApprovalRequestData.itemName">
              <option value="">Select</option>
              <option value="name1">name1</option>
              <option value="name2">name2</option>
             </select-->
             <label class="col-md-6 control-label text-left">Name</label>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Item Description </label>
            <div class="col-md-6">
            <input type="text" class="form-control input-sm" ng-model="gatePassAddItem.serialno" name="serialno" data-message-id="gatePassName" data-valid-method="save">
             <!-- select class="form-control input-sm" ng-model="storeApprovalRequestData.itemType">
              <option value="">Select</option>
              <option value="Type1">Type1</option>
              <option value="Type2">Type2</option>              
             </select-->
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Item Category </label>
            <div class="col-md-6">
             <select class="form-control input-sm" ng-model="storeApprovalRequestData.itemCategory">
              <option value="">Select</option>
              <option value="Category1">Category1</option>
              <option value="Category2">Category2</option>
             </select>
            </div>
           </div>
           
           <div class="form-group">
            <label class="col-md-6 control-label"> UOM </label>
            <div class="col-md-6">
             <!-- select class="form-control input-sm" ng-model="storeApprovalRequestData.uom">
              <option value="">Select</option>
              <option value="gm">gm</option>
              <option value="mg">mg</option>
              <option value="mg">kg</option>
              <option value="ml">ml</option>
             </select-->
             <label class="col-md-6 control-label text-left">Name</label>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Quantity </label>
            <div class="col-lg-6">
             <input type="number" ng-model="storeApprovalRequestData.quantity"
             class="form-control input-sm" size="4" min="1" max="1000" validate/>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> EDD </label>
            <div class="col-lg-6">
             <div class='input-group date datetimepick'>
              <div class="dropdown">
               <a class="dropdown-toggle" id="Edd" role="button" data-toggle="dropdown" data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="requestDate"
                  data-validator="required" data-valid-method="submit" data-message-id="requestDate"
                  data-ng-model="storeApprovalRequestData.edd">
                 <span class="input-group-addon">
                  <i class="glyphicon glyphicon-calendar"></i>
                 </span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                <datetimepicker data-ng-model="storeApprovalRequestData.edd"
                 data-on-set-time="storeApprovalRequestData.edd = onDateSet(newDate)"
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
         <button class="btn btn-success" type="button" data-ng-if="!isEdit" ng-click="save(storeApprovalReqForm)"
          class="btn btn-success">
          <i class="fa fa-save"></i>
Save         </button>
         <button class="btn btn-success" type="button" data-ng-if="isEdit == true" class="btn btn-success"
          ng-click="update(storeApprovalReqForm)">
          <i class="fa fa-save"></i>Update
         </button>
         <button type="reset" class="btn btn-info" ng-click="reset(storeApprovalReqForm)">
          <i class="fa fa-undo"></i>
Reset         </button>
         <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancelReq()">
          <i class="fa fa-close"></i>
Cancel         </button>
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