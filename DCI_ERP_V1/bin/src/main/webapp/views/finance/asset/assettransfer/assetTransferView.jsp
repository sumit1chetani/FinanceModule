<style>
.main_container{
overflow:auto;
}
.datetimepicker{
width:auto;
}
select{
-webkit-appearance: none;
  padding: 0;
  text-indent: 8px;
  padding : 0 !important;
}
.input-group-addon{
display:none !important;
}
.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
{
 background-color:white !important;
 border:0px !important;
}
.b-grey{
border:0px !important;
}
.sorting:after{
  display : none !important;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- #MAIN CONTENT -->
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span> <span><state-breadcrumbs></state-breadcrumbs> </span>
      <div class="widget-toolbar">
       <div>
        <span> <span class="button-icon" data-placement="bottom" data-reset-widgets
         rel="tooltip" title="<spring:message code='title.widget.reset'></spring:message>"> <i
          class="fa fa-refresh"></i>
        </span>
        </span>
       </div>
      </div>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="assetTransferForm" novalidate method="post">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
         <div class="col-sm-6">
          <fieldset ng-disabled="true">
           <div class="form-group"  ng-show="edit">
            <label class="col-md-3 control-label">Asset Transfer No</label>
            <div class="col-md-7">
             <input type="text" class="form-control input-sm" name="AssetCode"
              ng-model="assetTransferObj.assetTransferNo" id="requestedby" readonly>
            </div>
            <div class="col-md-6">
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-3 control-label">Transfer Date</label>
            <div class="col-md-7">
             <div class='input-group date datetimepick col-md-12'>
              <div class="dropdown">
               <a class="dropdown-toggle" id="fromdate" role="button" data-toggle="dropdown"
                data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="From Date"
                  validation="date_euro_long|required" friendly-name="Transfer Date" 
                  data-ng-model="assetTransferObj.transferDate"><span class="input-group-addon"><i
                  class="glyphicon glyphicon-calendar"></i></span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                <datetimepicker data-ng-model="assetTransferObj.transferDate"
                 data-on-set-time="assetTransferObj.transferDate = onDateSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#fromdate',startView:'day', minView:'day'}" />
               </ul>
              </div>
             </div>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-3 control-label"> Transportation Type </label>
            <div class="col-md-7">
            <select class="form-control input-sm" id="requisition" name="requisition" data-ng-model="assetTransferObj.transportType"
			   	data-ng-options="ac.id as ac.text for ac in Transportation" >
			   	<option value="" selected="selected">--Select--</option>
			</select>
            </div>
           </div>
           <div class="form-group" id="personname" style="display: none;">
            <label class="col-md-3 control-label">Person Name</label>
            <div class="col-md-7">
             <input type="text" class="form-control input-sm" name="AssetCode"
              ng-model="assetTransferObj.personName">
            </div>
           </div>
           <div class="form-group" id="servicename" style="display: none;">
            <label class="col-md-3 control-label">Service Name</label>
            <div class="col-md-7">
             <input type="text" class="form-control input-sm" name="AssetCode"
              ng-model="assetTransferObj.serviceName">
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-3 control-label">Source Location</label>
            <div class="col-md-7">
             <input type="text" class="form-control input-sm" 
              ng-model="assetTransferObj.sourceLocName"  readonly>
             
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-3 control-label">Destination Location</label>
            <div class="col-md-7">
            <input type="text" class="form-control input-sm" 
              ng-model="assetTransferObj.destLocName" readonly>
             
            </div>
           </div>
          </fieldset>
         </div>
         <div class="col-sm-6">
          <fieldset ng-disabled="true">
           <div class="form-group">
            <label class="col-md-3 control-label"> Requisition No </label>
            <div class="col-md-7">
            <select class="form-control input-sm" id="requisition" name="requisition" data-ng-model="assetTransferObj.requisition"
							        	data-ng-options="ac.id as ac.text for ac in RequisitionList" >
							          	<option value="" selected="selected">--Select--</option>
						     </select>
            
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-3 control-label">Requisition Date</label>
            <div class="col-md-7">
             <input type="text" class="form-control input-sm" name="AssetCode"
              ng-model="assetTransferObj.requisitionDate" id="requisitiondate" readonly>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-3 control-label">Requested By</label>
            <div class="col-md-7">
             <input type="text" class="form-control input-sm" name="AssetCode"
              ng-model="assetTransferObj.requisitionBy" id="requestedby" readonly>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-3 control-label"> Delivery Method </label>
            <div class="col-md-7">
            <select class="form-control input-sm" id="requisition" name="requisition" data-ng-model="assetTransferObj.deliveryMet"
			   	data-ng-options="ac.id as ac.text for ac in Delivery" >
			   	<option value="" selected="selected">--Select--</option>
			</select>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-3 control-label"> Status </label>
            <div class="col-md-7">
             <select class="form-control input-sm" ng-model="assetTransferObj.status"
              name="Hospital Name" validation="required" friendly-name="Status"
              data-message-id="status">
              <option value="">Select</option>
              <option value="Pending">Pending</option>
              <option value="Approved">Approved</option>
             </select>
            </div>
           </div>
          </fieldset>
         </div>
         </div>
         </div>
          <br>
          <br>
          <br>
          <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
         <div class="col-sm-3">
          <div class="form-group">
            <label class="col-md-4 control-label">Item Name</label>
            <div class="col-md-8">
             <input type="text" class="form-control input-sm" name="ItemName"
              ng-model="assetTransferObj.itemName" id="requestedby" readonly>
            </div>
           </div>
         </div>
         <div class="col-sm-3">
          <div class="form-group">
            <label class="col-md-5 control-label">Item Category</label>
            <div class="col-md-7">
             <input type="text" class="form-control input-sm" name="AssetCode"
              ng-model="assetTransferObj.itemCategory" id="itemCategory" readonly>
            </div>
           </div>
         </div>
         <div class="col-sm-3">
          <div class="form-group">
            <label class="col-md-6 control-label">Requested Quantity</label>
            <div class="col-md-4">
             <input type="text" class="form-control text-right input-sm" name="AssetCode"
              ng-model="assetTransferObj.requisitionquantity" id="quantity" readonly>
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label">Transfer Quantity</label>
            <div class="col-md-4">
             <input type="text" class="form-control text-right input-sm" name="AssetCode"
              ng-model="assetTransferObj.transferquantity" id="quantity" readonly>
            </div>
           </div>
         </div>
         <div class="col-sm-3">
          <div class="form-group">
            <label class="col-md-4 control-label">EDD Date</label>
            <div class="col-md-7">
             <input type="text" class="form-control input-sm" name="eddDate"
              ng-model="assetTransferObj.eddDate" id="eddDate" readonly>
            </div>
           </div>
         </div>
         </div>
         </div>
          <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
          <br>
          <div role="content">
           <div class="widget-body no-padding">
            <div class="dt-bootstrap no-footer ui-jqgrid ui-corner-all"
             data-st-table="displayedCollection" data-st-safe-src="rowCollection">
             <table id="dt_basic"
              class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
              aria-describedby="dt_basic_info">
             <thead class="dataTables-Main-Head">
															<tr>
																
																<th class="table-heading width_7">Asset Track No</th>
																<th class="table-heading width_7">Asset Name</th>
																<th class="table-heading width_7">Serial No</th>
																<th class="table-heading width_7">Asset Location</th>
																<th class="table-heading width_7">Responsible</th>
																<th class="table-heading width_7">Asset User</th>
															</tr>
														</thead>
             <tbody>
              <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																ng-repeat="objAssetRequistion in displayedCollection" >

																
																<td>{{objAssetRequistion.assettrackNo}}</td>
																<td>{{objAssetRequistion.assettrackName}}</td>
																<td>{{objAssetRequistion.serialNo}}</td>
																<td>{{objAssetRequistion.asstlocation}}</td>
																<td>{{objAssetRequistion.resAsset}}</td>
																<td>{{objAssetRequistion.user}}</td>
															</tr>
               </tbody>
             </table>
            </div>
           </div>
          </div>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
<!--            <button class="btn btn-success" type="button" ng-if="!edit" -->
<!--             data-ng-click="save(assetTransferObj,rowCollection)"> -->
<!--             <i class="fa fa-save"></i> -->
<%--             <spring:message code="label.save"></spring:message> --%>
<!--            </button> -->
<!--            <button class="btn btn-success" type="button" data-ng-if="edit" -->
<!--             data-ng-click="update(assetTransferForm,assetTransferObj);" > -->
<!--             <i class="fa fa-save"></i> -->
<%--             <spring:message code="label.update"></spring:message> --%>
<!--            </button> -->
<!--            <button class="btn btn-info" type="button" ng-if="!edit" data-ng-click="reset();"> -->
<!--             <i class="fa fa-undo"></i> -->
<%--             <spring:message code="label.reset"></spring:message> --%>
<!--            </button> -->
<!--            <button class="btn btn-info" type="button" ng-if="edit" data-ng-click="reset1();"> -->
<!--             <i class="fa fa-undo"></i> -->
<%--             <spring:message code="label.reset"></spring:message> --%>
<!--            </button> -->
           <button class="btn btn-danger" type="button" class="btn btn-success"
            data-ng-click="cancel1();">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
         </div>
        </div>
       </form>
       </div>
        </div>
      </div>
   </article>
  </div>
 </section>
</div>
