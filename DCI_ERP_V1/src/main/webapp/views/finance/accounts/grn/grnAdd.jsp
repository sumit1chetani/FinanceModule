<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
       <!-- add: non-hidden - to disable auto hide -->
       <div>
        <span> <span class="button-icon" data-reset-widgets
         rel="tooltip"
         title="<spring:message code="title.widget.reset"></spring:message>"
         data-placement="bottom"> <i
          class="fa fa-refresh"></i>
        </span>
        </span>
       </div>
      </div>
     </header>
     <div class="row book-widget-row" style="padding-bottom: 12px;"
      ng-init="init()">
      <form class="form-horizontal" name="referenceDoctorForm"
       ng-submit="">
       <!-- Form field start -->
       <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-6 ">
         <fieldset style="padding-left: 100px;">
          <input type="hidden" class="form-control input-sm"
           name="ref_doctor_id"
           ng-model="RefDoctorMasterData.ref_doctor_id"
           valid-method="submit" message-id="ref_doctor_id"
           id="ref_doctor_id">
          <div class="form-group">
           <label class="col-md-4 control-label">File Reference<spring:message
             code="label.asterisk.symbol"></spring:message></label>
           <div class="col-md-6">
            <input type="text" class="form-control input-sm">
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label">Invoice No</label>
           <div class="col-md-6">
            <select class="form-control input-sm">
             <option value="select">Select</option>
            </select>
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label">Supplier<spring:message
             code="label.asterisk.symbol"></spring:message></label>
           <div class="col-md-6">
            <select class="form-control input-sm">
             <option value="select">Select</option>
            </select>
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label">PO Reference No</label>
           <div class="col-md-6">
            <input type="text" class="form-control input-sm">
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label">GRN Date<spring:message
             code="label.asterisk.symbol"></spring:message></label>
           <div class="col-md-6">
            <div class="input-group date datetimepick col-md-12">
             <div class="dropdown">
              <a class="dropdown-toggle" id="permissiondate"
               role="button" data-toggle="dropdown" data-target="#"
               href="#">
               <div class="input-group">
                <input type="text" class="form-control"
                 placeholder="dd/mm/yyyy" name="Permission Date"
                 data-validator="required" data-valid-method="submit"
                 data-message-id="Permission Date"
                 data-ng-model="PermissionRequestData.permissiondate"><span
                 class="input-group-addon"><i
                 class="glyphicon glyphicon-calendar"></i></span>
               </div>
              </a>
              <ul class="dropdown-menu" role="menu"
               aria-labelledby="dLabel">
               <datetimepicker
                data-ng-model="PermissionRequestData.permissiondate"
                data-on-set-time="PermissionRequestData.permissiondate = onDateSet(newDate)"
                data-datetimepicker-config="{ dropdownSelector: '#permissiondate',startView:'day', minView:'day'}" />
              </ul>
             </div>
            </div>
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label">GRN Quantity</label>
           <div class="col-md-6">
            <input type="text" class="form-control input-sm">
           </div>
          </div>
         </fieldset>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-5">
         <fieldset>
          <div class="form-group">
           <label class="col-md-4 control-label">Challan No</label>
           <div class="col-md-6">
            <select class="form-control input-sm">
             <option value="select">Select</option>
            </select>
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label">Vehicle No</label>
           <div class="col-md-6">
            <input type="text" class="form-control input-sm">
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label">Driver Name</label>
           <div class="col-md-6">
            <input type="text" class="form-control input-sm">
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label">Driver No</label>
           <div class="col-md-6">
            <input type="text" class="form-control input-sm">
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label"> Despatched
            Date </label>
           <div class="col-md-6">
            <div class="input-group date datetimepick col-md-12">
             <div class="dropdown">
              <a class="dropdown-toggle" id="permissiondate"
               role="button" data-toggle="dropdown" data-target="#"
               href="#">
               <div class="input-group">
                <input type="text" class="form-control"
                 placeholder="dd/mm/yyyy" name="Permission Date"
                 data-validator="required" data-valid-method="submit"
                 data-message-id="Permission Date"
                 data-ng-model="PermissionRequestData.permissiondate"><span
                 class="input-group-addon"><i
                 class="glyphicon glyphicon-calendar"></i></span>
               </div>
              </a>
              <ul class="dropdown-menu" role="menu"
               aria-labelledby="dLabel">
               <datetimepicker
                data-ng-model="PermissionRequestData.permissiondate"
                data-on-set-time="PermissionRequestData.permissiondate = onDateSet(newDate)"
                data-datetimepicker-config="{ dropdownSelector: '#permissiondate',startView:'day', minView:'day'}" />
              </ul>
             </div>
            </div>
           </div>
          </div>
          <div class="form-group">
           <label class="col-md-4 control-label"> Remarks </label>
           <div class="col-md-6"
            style="border: 0px solid red;">
            <textarea class="form-control input-sm" name="Address"
             id="Address" maxlength="150"
             data-ng-model="RefHospitalMasterData.address"
             style="resize: none;" message-id="Address"
             validator="required"></textarea>
           </div>
          </div>
         </fieldset>
        </div>
        <div class="table-responsive col-sm-12"
         ng-repeat="(tIndex, grnTable) in grnData.grnTables">
         <table class="table table-striped b-t b-light">
          <thead>
           <tr>
            <th colspan=1 class="width_1"></th>
            <th colspan=1 class="width_10 text-center">Lot No</th>
            <th colspan=1 class="width_12 text-center">Product</th>
            <th colspan=1 class="width_12 text-center">Storage</th>
            <th colspan=1 class="width_12 text-center">Qty Ordered</th>
            <th colspan=1 class="width_12 text-center">Qty Recvd</th>
            <th colspan=1 class="width_12 text-center">Qty Invcd</th>
            <th colspan=1 class="width_12 text-center">Strg Ref</th>
            <th colspan=1 class="width_10 text-center">Narration</th>
            <th class="width_6 text-center"><spring:message
              code="label.action"></spring:message></th>
           </tr>
          </thead>
          <tbody ng-repeat="(trIndex, row) in grnTable.grnTableRow">
           <tr>
            <td><label class="i-checks m-b-none"> <input
              type="checkbox" ng-model="row.select"
              id="section{{trIndex}}"><i></i></label></td>
            <td>
             <div class="row">
              <div class="col-xs-12">
               <input type="text" class="form-control input-sm" required />
              </div>
             </div>
            </td>
            <td class="width_10">
             <div class="row">
              <div class="col-xs-12">
               <select class="form-control input-sm">
                <option value="select">Select</option>
               </select>
              </div>
             </div>
            </td>
            <td class="width_10">
             <div class="row">
              <div class="col-xs-12">
               <select class="form-control input-sm">
                <option value="select">Select</option>
               </select>
              </div>
             </div>
            </td>
            <td class="width_10">
             <div class="row">
              <div class="col-xs-12">
               <input type="text" class="form-control input-sm" required />
              </div>
             </div>
            </td>
            <td class="width_10">
             <div class="row">
              <div class="col-xs-12">
               <input type="text" class="form-control input-sm" required />
              </div>
             </div>
            </td>
            <td class="width_10">
             <div class="row">
              <div class="col-xs-12">
               <input type="text" class="form-control input-sm" required />
              </div>
             </div>
            </td>
            <td class="width_10">
             <div class="row">
              <div class="col-xs-12">
               <input type="text" class="form-control input-sm" required />
              </div>
             </div>
            </td>
            <td class="width_10">
             <div class="row">
              <div class="col-xs-12">
               <input type="text" class="form-control input-sm" required />
              </div>
             </div>
            </td>
            <td class=" td-actions text-center"><span> <i
              class="fa  fa-pencil text-success text"
              data-ng-click="editRow(departmentCollections)"></i>
            </span> <span> <i
              class="fa fa-trash-o text-danger-dker text"
              data-ng-click="deleteRow(departmentCollections)"></i>
            </span></td>
           </tr>
          </tbody>
         </table>
         <div class="padding-right-5" id="AddOrRmveMeritbtn">
          <button ng-click="addgrnRow(grnTable)"
           class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
           type="button">
           <i class="fa fa-plus"></i>
          </button>
          <button ng-click="removegrnRow(grnTable)"
           class="btn btn-sm btn-danger" type="button" tooltip="Delete">
           <i class="fa  fa-trash-o"></i>
          </button>
         </div>
         <!-- /padding-right-5 - /AddOrRmvebtn -->
        </div>
       </div>
       <!-- Form field end -->
       <!-- Button Action Div Start-->
       <div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-success" type="button"
           data-ng-click="submit(referenceDoctorForm)"
           data-ng-if="!RefDoctorMasterData.edit">
           <i class="fa fa-save"></i>
           <spring:message code="label.save"></spring:message>
          </button>
          <button class="btn btn-success" type="button"
           data-ng-click="submit(referenceDoctorForm)"
           data-ng-if="RefDoctorMasterData.edit">
           <i class="fa fa-save"></i>
           <spring:message code="label.update"></spring:message>
          </button>
          <button class="btn btn-info ng-scope" type="button"
           class="btn btn-success" ng-click="reset()">
           <i class="fa fa-undo"></i>
           <spring:message code="label.reset"></spring:message>
          </button>
          <button class="btn btn-danger" type="button"
           class="btn btn-success" ng-click="cancel()">
           <i class="fa fa-close"></i>
           <spring:message code="label.cancel"></spring:message>
          </button>
         </div>
        </div>
       </div>
       <!-- Button Action Div End-->
      </form>
      <!-- Form end -->
     </div>
    </div>
    <!-- end widget div -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
